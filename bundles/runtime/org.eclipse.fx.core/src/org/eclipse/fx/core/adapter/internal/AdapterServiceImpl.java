/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.adapter.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.fx.core.ValueSerializer;
import org.eclipse.fx.core.adapter.AdapterProvider;
import org.eclipse.fx.core.adapter.AdapterService;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * Default implementation of the adapter service
 */
@Component
public class AdapterServiceImpl implements AdapterService {
	@NonNull
	private Map<Class<Object>, Map<Class<Object>, List<AdapterProvider<Object, Object>>>> adapterMap = new HashMap<>();

	private ValueSerializer valueSerializer;

	/**
	 * Register the value serializer
	 *
	 * @param valueSerializer
	 *            the value serializer
	 */
	@Reference(cardinality = ReferenceCardinality.OPTIONAL, policyOption = ReferencePolicyOption.GREEDY)
	public void setValueSerializer(ValueSerializer valueSerializer) {
		this.valueSerializer = valueSerializer;
	}

	/**
	 * Unregister the value serializer
	 *
	 * @param valueSerializer
	 *            the value serializer
	 */
	public void unsetValueSerializer(ValueSerializer valueSerializer) {
		if (this.valueSerializer == valueSerializer) {
			this.valueSerializer = null;
		}
	}

	/**
	 * Register provider services
	 *
	 * @param service
	 *            the service to register
	 */
	@SuppressWarnings("unchecked")
	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policyOption = ReferencePolicyOption.GREEDY)
	public void registerAdapterProviderService(AdapterProvider<?, ?> service) {
		synchronized (this.adapterMap) {
			Map<Class<Object>, List<AdapterProvider<Object, Object>>> map = this.adapterMap
					.get(service.getSourceType());
			if (map == null) {
				map = new HashMap<>();
				this.adapterMap.put((Class<Object>) service.getSourceType(), map);
			}

			List<AdapterProvider<Object, Object>> list = map.get(service.getTargetType());
			if (list == null) {
				list = new ArrayList<>();
				map.put((Class<Object>) service.getTargetType(), list);
			}
			list.add((AdapterProvider<Object, Object>) service);
		}
	}

	/**
	 * Unregister a provider service
	 *
	 * @param service
	 *            the service to unregister
	 */
	public void unregisterAdapterProviderService(AdapterProvider<?, ?> service) {
		synchronized (this.adapterMap) {
			Map<Class<Object>, List<AdapterProvider<Object, Object>>> map = this.adapterMap
					.get(service.getSourceType());
			if (map != null) {
				List<AdapterProvider<Object, Object>> list = map.get(service.getTargetType());
				if (list != null) {
					list.remove(service);
				}
			}
		}
	}

	@Override
	public boolean canAdapt(Object sourceObject, Class<?> targetType) {
		if (sourceObject == null) {
			return true;
		}

		boolean rv = canAdaptRec(sourceObject, sourceObject.getClass(), targetType);
		ValueSerializer valueSerializer = this.valueSerializer;
		if (!rv && valueSerializer != null) {
			if (targetType == String.class) {
				return valueSerializer.test(sourceObject.getClass());
			} else if (sourceObject instanceof String) {
				return valueSerializer.test(targetType);
			}
		}
		return rv;
	}

	@SuppressWarnings("unchecked")
	private boolean canAdaptRec(@NonNull Object sourceObject, Class<?> sourceType, @NonNull Class<?> targetType) {
		boolean adapt = canAdapt(this.adapterMap, sourceObject, (Class<Object>) sourceType, (Class<Object>) targetType);
		if (adapt) {
			return true;
		}

		for (Class<?> i : sourceType.getInterfaces()) {
			if (canAdapt(this.adapterMap, sourceObject, (Class<Object>) i, (Class<Object>) targetType)) {
				return true;
			}
		}

		if (sourceType.getSuperclass() != Object.class) {
			return canAdaptRec(sourceObject, sourceType.getSuperclass(), targetType);
		}

		return false;
	}

	private static boolean canAdapt(
			Map<Class<Object>, Map<Class<Object>, List<AdapterProvider<Object, Object>>>> adapterMap,
			@NonNull Object sourceObject, Class<Object> source, @NonNull Class<Object> target) {
		Map<Class<Object>, List<AdapterProvider<Object, Object>>> map = adapterMap.get(source);
		if (map != null) {
			List<AdapterProvider<Object, Object>> aList = map.get(target);
			if (aList != null) {
				for (AdapterProvider<Object, Object> a : aList) {
					if (a.canAdapt(sourceObject, target)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <A> A adapt(Object sourceObject, Class<A> targetType, ValueAccess... valueAccess) {
		if (sourceObject == null) {
			return null;
		}

		A rv = (A) adaptRec(sourceObject, sourceObject.getClass(), targetType, valueAccess);
		ValueSerializer valueSerializer = this.valueSerializer;
		if (rv == null && canAdapt(sourceObject, targetType)) {
			if (targetType == String.class) {
				return (@Nullable A) valueSerializer.toString(sourceObject);
			} else if (sourceObject instanceof String) {
				return valueSerializer.fromString(targetType, (String) sourceObject);
			}
		}
		return rv;
	}

	@SuppressWarnings("unchecked")
	private Object adaptRec(@NonNull Object sourceObject, Class<?> sourceType, @NonNull Class<?> targetType,
			ValueAccess[] valueAccess) {
		Object adapt = adapt(this.adapterMap, sourceObject, (Class<Object>) sourceType, (Class<Object>) targetType,
				valueAccess);
		if (adapt != null) {
			return adapt;
		}

		for (Class<?> i : sourceType.getInterfaces()) {
			adapt = adapt(this.adapterMap, sourceObject, (Class<Object>) i, (Class<Object>) targetType, valueAccess);
			if (adapt != null) {
				return adapt;
			}
		}

		if (sourceType.getSuperclass() != Object.class) {
			return adaptRec(sourceObject, sourceType.getSuperclass(), targetType, valueAccess);
		}

		return null;
	}

	private static Object adapt(
			Map<Class<Object>, Map<Class<Object>, List<AdapterProvider<Object, Object>>>> adapterMap,
			@NonNull Object sourceObject, Class<Object> source, @NonNull Class<Object> target,
			ValueAccess[] valueAccess) {
		Map<Class<Object>, List<AdapterProvider<Object, Object>>> map = adapterMap.get(source);
		if (map != null) {
			List<AdapterProvider<Object, Object>> aList = map.get(target);
			if (aList != null) {
				for (AdapterProvider<Object, Object> a : aList) {
					Object adapt = a.adapt(sourceObject, target, valueAccess);
					if (adapt != null) {
						return adapt;
					}
				}
			}
		}
		return null;
	}
}
