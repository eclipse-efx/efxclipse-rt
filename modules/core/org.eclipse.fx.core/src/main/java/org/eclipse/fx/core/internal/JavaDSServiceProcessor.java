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
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
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
import javax.xml.bind.Unmarshaller;

import org.eclipse.fx.core.IOUtils;
import org.eclipse.fx.core.KeyValueStore;
import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.core.ServiceUtils.ServiceReference;
import org.eclipse.fx.core.internal.sm.Component;
import org.eclipse.fx.core.internal.sm.Component11;
import org.eclipse.fx.core.internal.sm.Component12;
import org.eclipse.fx.core.internal.sm.Component13;
import org.eclipse.fx.core.internal.sm.Properties;
import org.eclipse.fx.core.internal.sm.Property;
import org.eclipse.fx.core.internal.sm.Reference;
import org.eclipse.fx.core.internal.sm.Reference.ReferenceCardinality;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Implements parts of the OSGi-DS-Specification resolving services with it's
 * references
 */
public class JavaDSServiceProcessor {
	private Map<String, Component> componentCache;
	private Map<String, List<Component>> serviceList;
	private Map<Class<?>, List<?>> serviceCache = new HashMap<>();
	private Map<Class<?>, List<ServiceReference<?>>> serviceReferenceCache = new HashMap<>();
	private static JavaDSServiceProcessor INSTANCE;

	class JavaServiceReference<S> implements ServiceReference<S> {
		private final Component c;
		private S service;
		private KeyValueStore<String, Object> properties;

		public JavaServiceReference(Component c) {
			this.c = c;
		}

		@Override
		public S get() {
			if( this.service == null ) {
				try {
					Class<?> serviceClass = Class.forName(this.c.getImplementation().getClazz());
					S service = (S) serviceClass.newInstance();
					process(service);
					this.service = service;
				} catch (Throwable e) {
					throw new RuntimeException(e);
				}
			}
			return this.service;
		}

		@Override
		public KeyValueStore<String, Object> getProperties() {
			// TODO create the KeyValueStore lazy
			if( this.properties == null ) {
				this.properties = KeyValueStore.fromMap(this.c.getProperty().stream().collect(Collectors.toMap(Property::getName, Property::getValue)));
				//TODO Implement Properties
			}
			// TODO Auto-generated method stub
			return this.properties;
		}

		@Override
		public int getRanking() {
			Object object = getProperties().contains("service.ranking") ? getProperties().get("service.ranking") : null; //$NON-NLS-1$ //$NON-NLS-2$
			return object == null ? 0 : object instanceof Integer ? ((Integer)object).intValue() : Integer.parseInt(object.toString());
		}
	}

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

	public synchronized static <S> @NonNull List<@NonNull ServiceReference<@NonNull S>> lookupServiceReferenceList(Class<?> requestor, Class<S> clazz) {
		if (INSTANCE == null) {
			INSTANCE = new JavaDSServiceProcessor();
		}
		return INSTANCE._lookupServiceReferenceList(requestor, clazz);
	}

	public static <S> @NonNull List<@NonNull S> lookupServiceList(@Nullable Class<?> requestor,
			@NonNull String serviceClass) {
		if (INSTANCE == null) {
			INSTANCE = new JavaDSServiceProcessor();
		}
		Class<S> cl;
		try {
			cl = (Class<S>)(Class)Class.forName(serviceClass);
			return INSTANCE.lookupServiceList(null, cl);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	private synchronized <S> @NonNull List<@NonNull ServiceReference<@NonNull S>> _lookupServiceReferenceList(Class<?> requestor, Class<S> clazz) {
		List<ServiceReference<?>> list = this.serviceReferenceCache.get(clazz);
		if( list != null ) {
			return (List<ServiceReference<S>>)(List)list;
		}
		initializeComponentCache();

		List<Component> componentList = this.serviceList.get(clazz.getName());
		if (componentList != null) {
			List<ServiceReference<?>> referenceList = componentList
				.stream()
				.map(JavaServiceReference::new)
				.sorted()
				.collect(Collectors.toList());
			Collections.reverse(referenceList); // reverse the order so that highest is first
			this.serviceReferenceCache.put(clazz, referenceList);
			return (List<ServiceReference<S>>)(List)referenceList;
		}
		return Collections.emptyList();
	}

	@SuppressWarnings({ "unchecked", "null" })
	private synchronized <S> @NonNull List<@NonNull S> _lookupServiceList(Class<?> requestor, Class<S> clazz) {
		List<?> list = this.serviceCache.get(clazz);
		if (list != null) {
			return (List<S>) list;
		}
		initializeComponentCache();

		List<@NonNull S> collect = _lookupServiceReferenceList(requestor, clazz).stream().map(ServiceReference::get).collect(Collectors.toList());
		this.serviceCache.put(clazz, collect);
		return collect;
	}

	void process(Object o) {
		Component component = this.componentCache.get(o.getClass().getName());

		if (component != null) {
			component.getReference().stream().forEach(r -> handleReference(o, r));
		}
	}

	private static void logError(String message, Throwable t) {
		System.err.println(JavaDSServiceProcessor.class.getSimpleName() + " - " + message); //$NON-NLS-1$
		if( t != null ) {
			try(StringWriter s = new StringWriter();
					PrintWriter w = new PrintWriter(s);) {
				t.printStackTrace(w);
				System.err.println(JavaDSServiceProcessor.class.getSimpleName() + " - " + s); //$NON-NLS-1$
			} catch (IOException e) {
				// nothing
			}
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
						logError("Unable to read manifest of " + url, e); //$NON-NLS-1$
					}

					if (m != null) {
						String value = m.getMainAttributes().getValue("Service-Component"); //$NON-NLS-1$
						if (value != null) {
							Map<String, Component> collect = Stream.of(value.split(",")) //$NON-NLS-1$
									.map(String::trim)
									.map(e -> cl.getResource(e))
									.map(this::handle).filter(c -> c != null)
									.collect(Collectors.toMap(c -> c.getImplementation().getClazz(), c -> c));
							synchronized (collect) {
								this.componentCache.putAll(collect);
							}
						}
					}
				}
				this.serviceList = new HashMap<>();
				this.componentCache.values().forEach(c -> {
					this.serviceList.computeIfAbsent(c.getImplementation().getClazz(), i -> new ArrayList<>()).add(c);
					if( c.getService() != null ) {
						c.getService().getProvide().forEach(s -> {
							this.serviceList.computeIfAbsent(s.getIface(), i -> new ArrayList<>()).add(c);
						});
					}
				});

			} catch (IOException e) {
				logError("Failed loading data into component cache", e); //$NON-NLS-1$
			}
		}
	}

	private static Method getMethod(Class<?> cl, String name, Class<?> serviceType) {
		if (name == null) {
			return null;
		}
		Method register = null;
		try {
			register = cl.getDeclaredMethod(name, serviceType, Map.class);
		} catch (NoSuchMethodException | SecurityException e) {
			// Skip it
		}

		try {
			register = cl.getDeclaredMethod(name, serviceType);
		} catch (NoSuchMethodException | SecurityException e) {
			// Skip it
		}

		if( register == null &&  cl.getSuperclass() != Object.class ) {
			register = getMethod(cl.getSuperclass(), name, serviceType);
		}

		return register;
	}

	@SuppressWarnings("null")
	private void handleReference(Object o, Reference r) {
		try {
			Class<?> serviceInterface = Class.forName(r.getIface());
			Method bind = getMethod(o.getClass(), r.getBind(), serviceInterface);

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
						List<?> list = ServiceUtils.getServiceList(serviceInterface);
						if (cardinality == ReferenceCardinality.AT_LEAST_ONE && list.isEmpty()) {
							logError("Unsatisfied dependency '"+r.getIface()+"'. There must be at least one component providing this service", null);  //$NON-NLS-1$//$NON-NLS-2$
						} else {
							list.stream().forEach(s -> invoke(bind, o, s, getProperties(s)));
						}
						break;
					}
					case MANDATORY:
					case OPTIONAL: {
						Optional<?> service = ServiceUtils.getService(serviceInterface);
						if (ReferenceCardinality.MANDATORY == cardinality && !service.isPresent()) {
							logError("Unsatisfied dependency '"+r.getIface()+"'. There must be at least one component providing this service", null);  //$NON-NLS-1$//$NON-NLS-2$
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
			logError("Failed to resolve references", t); //$NON-NLS-1$
		}
	}

	private Map<String, Object> getProperties(Object serviceObject) {
		Component component = this.componentCache.get(serviceObject.getClass().getName());
		Map<String, Object> data = new HashMap<>();
		if( component != null ) {
			data.putAll(component.getProperty()
				.stream()
				.collect(Collectors.toMap( p -> p.getName(), p -> p.getValue())));
			data.putAll(component.getProperties()
				.stream()
				.map( Properties::getEntry )
				.map( e -> serviceObject.getClass().getClassLoader().getResource(e))
				.map( eu -> {
					try ( InputStream in =  eu.openStream() ) {
						java.util.Properties p = new java.util.Properties();
						p.load(in);
						return p.entrySet();
					} catch( Throwable t ) {
						logError("Unable to load properties file", t); //$NON-NLS-1$
					}
					return null;
				})
				.filter( m -> m != null)
				.flatMap( m -> m.stream())
				.collect(Collectors.toMap( e -> e.getKey().toString(), e -> e.getValue())));
		}
		return data;
	}

	private static void invoke(Method m, Object o, Object s, Map<String, Object> properties) {
		try {
			if (m.getParameterCount() == 2) {
				m.invoke(o, s, properties);
			} else {
				m.invoke(o, s);
			}
		} catch (Throwable t) {
			logError("Failed to invoke bind method", t); //$NON-NLS-1$
		}
	}

	private Component handle(URL resource) {
		try (InputStream in = resource.openStream()) {
			String data = IOUtils.readToString(in, Charset.forName("UTF-8")); //$NON-NLS-1$
			JAXBContext jaxbContext;
			if (data.contains("http://www.osgi.org/xmlns/scr/v1.1.0")) { //$NON-NLS-1$
				jaxbContext = JAXBContext.newInstance(Component11.class);
			} else if( data.contains("http://www.osgi.org/xmlns/scr/v1.2.0") ) { //$NON-NLS-1$
				jaxbContext = JAXBContext.newInstance(Component12.class);
			} else {
				jaxbContext = JAXBContext.newInstance(Component13.class);
			}

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (Component) jaxbUnmarshaller.unmarshal(new StringReader(data));
		} catch (Throwable e) {
			logError("Unable to load component '"+resource+"'", e);  //$NON-NLS-1$//$NON-NLS-2$

		}
		return null;
	}




}
