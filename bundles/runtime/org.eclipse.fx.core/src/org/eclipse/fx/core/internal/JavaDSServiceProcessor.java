/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.jar.Manifest;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.fx.core.RankedService;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.function.ExExecutor;
import org.eclipse.fx.core.internal.sm.Component;
import org.eclipse.fx.core.internal.sm.Component11;
import org.eclipse.fx.core.internal.sm.Component12;
import org.eclipse.fx.core.internal.sm.Reference;
import org.eclipse.fx.core.internal.sm.Reference.ReferenceCardinality;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Implements parts of the OSGi-DS-Specification resolving services with it's
 * references
 */
public class JavaDSServiceProcessor {
	private Map<String, Component> componentCache;
	private Map<String, List<Component>> serviceList;
	private Map<Class<?>, List<?>> serviceCache = new HashMap<>();
	private static JavaDSServiceProcessor INSTANCE;

	/**
	 * Retrieve all services for the given type ordered by their ranking
	 *
	 * @param requestor
	 *            the requestor
	 * @param clazz
	 *            the clazz
	 * @return the list of services
	 */
	public synchronized static <S> @NonNull List<@NonNull S> lookupServiceList(Class<?> requestor, Class<S> clazz) {
		if (INSTANCE == null) {
			INSTANCE = new JavaDSServiceProcessor();
		}
		return INSTANCE._lookupServiceList(requestor, clazz);
	}

	@SuppressWarnings({ "unchecked", "null" })
	private synchronized <S> @NonNull List<@NonNull S> _lookupServiceList(Class<?> requestor, Class<S> clazz) {
		List<?> list = this.serviceCache.get(clazz);
		if (list != null) {
			return (List<S>) list;
		}
		initializeComponentCache();

		List<Component> componentList = this.serviceList.get(clazz.getName());
		if (componentList != null) {
			List<?> collect = componentList.stream().map(c -> c.getImplementation().getClazz()).map(c -> ExExecutor.executeFunction(c, Class::forName, "Could not load class '" + c + "'").orElse(null)).filter(c -> c != null).map(c -> { //$NON-NLS-1$ //$NON-NLS-2$
				if (c != null) {
					return ExExecutor.executeSupplier(c::newInstance, "Could not create instance").get(); //$NON-NLS-1$
				} else {
					return null;
				}
			}).filter(c -> c != null).sorted((o1, o2) -> {
				if (o1 instanceof RankedService && o2 instanceof RankedService) {
					return -1 * Integer.compare(((RankedService) o1).getRanking(), ((RankedService) o2).getRanking());
				} else {
					return 0;
				}
			}).collect(Collectors.toList());
			this.serviceCache.put(clazz, collect);
			collect.stream().forEach(this::process);
			return (List<S>) collect;
		}
		return Collections.emptyList();
	}

	private void process(Object o) {
		Component component = this.componentCache.get(o.getClass().getName());

		if (component != null) {
			component.getReference().stream().forEach(r -> handleReference(o, r));
		}

	}

	private synchronized void initializeComponentCache() {
		if (this.componentCache == null) {
			this.componentCache = new HashMap<>();
			try {
				ClassLoader cl = Thread.currentThread().getContextClassLoader();
				Enumeration<URL> resources = cl.getResources("META-INF/MANIFEST.MF"); //$NON-NLS-1$
				while (resources.hasMoreElements()) {
					URL url = resources.nextElement();
					Manifest m = null;
					try (InputStream in = url.openStream();) {
						m = new Manifest(in);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (m != null) {
						String value = m.getMainAttributes().getValue("Service-Component"); //$NON-NLS-1$
						if (value != null) {
							Map<String, Component> collect = Stream.of(value.split(",")) //$NON-NLS-1$
									.map(String::trim).map(e -> cl.getResource(e)).map(this::handle).filter(c -> c != null).collect(Collectors.toMap(c -> c.getImplementation().getClazz(), c -> c));
							synchronized (collect) {
								this.componentCache.putAll(collect);
							}
						}
					}
				}
				this.serviceList = new HashMap<>();
				this.componentCache.values().forEach(c -> {
					c.getService().getProvide().forEach(s -> {
						List<Component> list = this.serviceList.get(s.getIface());
						if (list == null) {
							list = new ArrayList<>();
							this.serviceList.put(s.getIface(), list);
						}
						list.add(c);
					});
				});

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static Method getMethod(Object o, String name, Class<?> serviceType) {
		if (name == null) {
			return null;
		}
		Method register = null;
		try {
			register = o.getClass().getDeclaredMethod(name, serviceType, Map.class);
		} catch (NoSuchMethodException | SecurityException e) {
			// Skip it
		}

		try {
			register = o.getClass().getDeclaredMethod(name, serviceType);
		} catch (NoSuchMethodException | SecurityException e) {
			// Skip it
		}

		return register;
	}

	@SuppressWarnings("null")
	private void handleReference(Object o, Reference r) {
		try {
			Class<?> serviceInterface = Class.forName(r.getIface());
			Method bind = getMethod(o, r.getBind(), serviceInterface);

			if (bind != null) {
				boolean changeAccessible = false;
				if (!bind.isAccessible()) {
					bind.setAccessible(true);
					changeAccessible = true;
				}
				try {
					ReferenceCardinality cardinality = ReferenceCardinality.fromString(r.getCardinality());
					switch (cardinality) {
					case AT_LEAST_ONE:
					case MULTIPLE: {
						List<?> list = Util.lookupServiceList(serviceInterface);
						if (cardinality == ReferenceCardinality.AT_LEAST_ONE && list.isEmpty()) {
							// TODO Log error
						} else {
							list.stream().forEach(s -> invoke(bind, o, s, getProperties(s)));
						}
						break;
					}
					case MANDATORY:
					case OPTIONAL: {
						Optional<?> service = Util.getService(serviceInterface);
						if (ReferenceCardinality.MANDATORY == cardinality && !service.isPresent()) {
							// TODO Log error
						} else {
							Object s = service.get();
							invoke(bind, o, s, getProperties(s));
						}
						break;
					}
					default:
						break;
					}
				} finally {
					if (changeAccessible) {
						bind.setAccessible(false);
					}
				}
			} else {
				System.err.println("Could not find bind method '" + r.getBind() + "'"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} catch (Throwable t) {
			// TODO Auto-generated catch block
			t.printStackTrace();
		}
	}

	private Map<String, Object> getProperties(Object serviceObject) {
		// TODO implement
		return null;
	}

	private static void invoke(Method m, Object o, Object s, Map<String, Object> properties) {
		try {
			if (m.getParameterCount() == 2) {
				m.invoke(o, s, properties);
			} else {
				m.invoke(o, s);
			}
		} catch (Throwable t) {
			t.printStackTrace();
			// TODO Auto-generated catch block
		}
	}

	private Component handle(URL resource) {
		try (InputStream in = resource.openStream()) {
			String data = Util.readToString(in, Charset.forName("UTF-8")); //$NON-NLS-1$
			JAXBContext jaxbContext;
			if (data.contains("http://www.osgi.org/xmlns/scr/v1.1.0")) { //$NON-NLS-1$
				jaxbContext = JAXBContext.newInstance(Component11.class);
			} else {
				jaxbContext = JAXBContext.newInstance(Component12.class);
			}

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (Component) jaxbUnmarshaller.unmarshal(new StringReader(data));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
