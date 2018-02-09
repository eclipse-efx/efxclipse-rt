/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.IInjector;
import org.eclipse.e4.core.di.suppliers.ExtendedObjectSupplier;
import org.eclipse.e4.core.di.suppliers.IObjectDescriptor;
import org.eclipse.e4.core.di.suppliers.IRequestor;
import org.eclipse.e4.core.internal.di.Requestor;
import org.eclipse.fx.core.ObjectSerializer;
import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.core.ValueSerializer;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.core.preferences.Preference;
import org.eclipse.fx.core.preferences.PreferenceDefaultValueFactory;
import org.eclipse.fx.core.preferences.Value;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Component;

/**
 * Supplier for {@link Preference}
 *
 * @since 2.1.0
 */
@Component(service = ExtendedObjectSupplier.class, property = "dependency.injection.annotation=org.eclipse.fx.core.preferences.Preference")
public class PreferenceValueSupplier extends ExtendedObjectSupplier {
	static private class PrefInjectionListener implements IPreferenceChangeListener {

		final private IRequestor requestor;
		final private IEclipsePreferences node;
		final private String key;

		public PrefInjectionListener(IEclipsePreferences node, String key, IRequestor requestor) {
			this.node = node;
			this.key = key;
			this.requestor = requestor;
		}

		@Override
		public void preferenceChange(final PreferenceChangeEvent event) {
			if (!this.requestor.isValid()) {
				this.node.removePreferenceChangeListener(this);
				return;
			}

			if (!event.getKey().equals(this.key)) {
				return;
			}

			this.requestor.resolveArguments(false);
			this.requestor.execute();
		}

		public IRequestor getRequestor() {
			return this.requestor;
		}

		// public void stopListening() {
		// this.node.removePreferenceChangeListener(this);
		// }
	}

	// Hash (nodePath -> Hash (key -> list))
	private Map<String, HashMap<String, List<PrefInjectionListener>>> listenerCache = new HashMap<String, HashMap<String, List<PrefInjectionListener>>>();

	private static Logger LOGGER;

	private static Logger getLogger() {
		if (LOGGER == null) {
			LOGGER = LoggerCreator.createLogger(PreferenceValueSupplier.class);
		}
		return LOGGER;
	}

	private static ValueSerializer serializer;

	private static ValueSerializer getValueSerializer() {
		if (serializer == null) {
			ServiceUtils.getService(ValueSerializer.class).ifPresent(s -> serializer = s);
		}
		return serializer;
	}

	private static ObjectSerializer objectSerializer;

	private static ObjectSerializer getObjectSerializer() {
		if (objectSerializer == null) {
			ServiceUtils.getService(ObjectSerializer.class).ifPresent(s -> objectSerializer = s);
		}
		return objectSerializer;
	}

	private static IPreferencesService preferenceService;

	private static IPreferencesService getPreferenceService() {
		if (preferenceService == null) {
			ServiceUtils.getService(IPreferencesService.class).ifPresent(s -> preferenceService = s);
		}
		return preferenceService;
	}

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public Object get(IObjectDescriptor descriptor, IRequestor requestor, boolean track, boolean group) {
		if (descriptor == null)
			return null;
		Class<?> descriptorsClass = getDesiredClass(descriptor.getDesiredType());
		if (descriptorsClass == null) {
			return null;
		}
		String nodePath = getNodePath(descriptor, requestor.getRequestingObjectClass());

		if (nodePath == null || nodePath.length() == 0)
			return IInjector.NOT_A_VALUE;

		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(nodePath);

		if (preferences == null) {
			return IInjector.NOT_A_VALUE;
		}

		String key = getKey(descriptor);
		if (key == null || key.length() == 0) {
			return IInjector.NOT_A_VALUE;
		}

		Preference p = descriptor.getQualifier(Preference.class);

		String defaultValue = p.defaultValue();
		if ("EFX__NO_VALUE__".equals(defaultValue)) { //$NON-NLS-1$
			defaultValue = null;
		}

		Class<?> factory = p.factory();
		if (factory == PreferenceDefaultValueFactory.class) {
			factory = null;
		}

		if (descriptorsClass.equals(boolean.class) || descriptorsClass.equals(Boolean.class)
				|| descriptorsClass.equals(int.class) || descriptorsClass.equals(Integer.class)
				|| descriptorsClass.equals(double.class) || descriptorsClass.equals(Double.class)
				|| descriptorsClass.equals(float.class) || descriptorsClass.equals(Float.class)
				|| descriptorsClass.equals(long.class) || descriptorsClass.equals(Long.class)
				|| descriptorsClass.equals(String.class)) {
			if (track)
				addListener(nodePath, key, requestor);

			Object v = getDefault(defaultValue, descriptorsClass, p, factory);
			return getValue(nodePath, key, (Class<Object>) descriptorsClass, null, v);
		}

		ValueSerializer valueSerializer = getValueSerializer();
		if (valueSerializer != null && valueSerializer.test(descriptorsClass)) {
			if (track)
				addListener(nodePath, key, requestor);

			Object v = getDefault(defaultValue, descriptorsClass, p, factory);
			return getValue(nodePath, key, (Class<Object>) descriptorsClass, null, v);
		}

		Requestor<?> r = (Requestor<?>) requestor;
		PreferenceValue<Object> v = r.getInjector().make(PreferenceValue.class, r.getPrimarySupplier());
		if (descriptorsClass != Value.class && !v.canAdaptTo(descriptorsClass)) {
			ObjectSerializer objectSerializer = getObjectSerializer();
			if (objectSerializer != null) {
				if (track) {
					addListener(nodePath, key, requestor);
				}
				Class<?> valueType = null;
				if ((descriptorsClass == List.class || descriptorsClass == Set.class)
						&& descriptor.getDesiredType() instanceof ParameterizedType) {
					Type t = ((ParameterizedType) descriptor.getDesiredType()).getActualTypeArguments()[0];
					valueType = t instanceof ParameterizedType ? (Class<?>) ((ParameterizedType) t).getRawType()
							: (Class<?>) t;

				}

				return getValue(nodePath, key, (Class<Object>) descriptorsClass, valueType,
						getDefault(defaultValue, descriptorsClass, p, factory));
			}
		}

		Class<?> type = p.type();
		Class<?> valueType = null;
		if (type == Object.class && descriptor.getDesiredType() instanceof ParameterizedType) {
			Type t = ((ParameterizedType) descriptor.getDesiredType()).getActualTypeArguments()[0];
			type = t instanceof ParameterizedType ? (Class<?>) ((ParameterizedType) t).getRawType() : (Class<?>) t;
			if (t instanceof ParameterizedType && (type == List.class || type == Set.class)) {
				Type tmp = ((ParameterizedType) t).getActualTypeArguments()[0];
				valueType = tmp instanceof ParameterizedType ? (Class<?>) ((ParameterizedType) tmp).getRawType()
						: (Class<?>) tmp;
			}
		}

		if (type == Object.class) {
			return IInjector.NOT_A_VALUE;
		}

		v.init(nodePath, key, type, valueType, getDefault(defaultValue, type, p, factory));

		if (descriptorsClass != Value.class) {
			return v.adaptTo(descriptorsClass);
		}

		return v;
	}

	@SuppressWarnings({ "unchecked" })
	private static <@Nullable T> @Nullable T getDefault(@Nullable String value, @NonNull Class<@NonNull T> type,
			Preference p, Class<?> factory) {
		if (factory != null) {
			try {
				PreferenceDefaultValueFactory<T> instance;
				instance = (PreferenceDefaultValueFactory<@Nullable T>) factory.newInstance();
				if (instance != null) {
					return instance.create(p);
				}

			} catch (InstantiationException | IllegalAccessException e) {
				getLogger().error("Failed to create instance of '" + factory + "'", e); //$NON-NLS-1$//$NON-NLS-2$
			}
		}

		if (type == Boolean.class || type == boolean.class) {
			return (T) Boolean.valueOf(value);
		} else if (type == int.class || type == Integer.class) {
			if (value == null || value.isEmpty()) {
				return (T) Integer.valueOf(0);
			} else {
				try {
					return (T) Integer.valueOf(value);
				} catch (Throwable t) {
					getLogger().error("Unable to parse provided default value '" + value + "'", t); //$NON-NLS-1$//$NON-NLS-2$
					return (T) Integer.valueOf(0);
				}
			}
		} else if (type == Double.class || type == double.class) {
			if (value == null || value.isEmpty()) {
				return (T) Double.valueOf(0);
			} else {
				try {
					return (T) Double.valueOf(value);
				} catch (Throwable t) {
					getLogger().error("Unable to parse provided default value '" + value + "'", t); //$NON-NLS-1$//$NON-NLS-2$
					return (T) Double.valueOf(0);
				}
			}
		} else if (type == Float.class || type == float.class) {
			if (value == null || value.isEmpty()) {
				return (T) Float.valueOf(0);
			} else {
				try {
					return (T) Float.valueOf(value);
				} catch (Throwable t) {
					getLogger().error("Unable to parse provided default value '" + value + "'", t); //$NON-NLS-1$//$NON-NLS-2$
					return (T) Float.valueOf(value);
				}
			}
		} else if (type == Long.class || type == long.class) {
			if (value == null || value.isEmpty()) {
				return (T) Long.valueOf(0);
			} else {
				try {
					return (T) Long.valueOf(value);
				} catch (Throwable t) {
					getLogger().error("Unable to parse provided default value '" + value + "'", t); //$NON-NLS-1$//$NON-NLS-2$
					return (T) Long.valueOf(0);
				}
			}
		} else if (type == String.class) {
			return (T) value;
		} else {
			if (value != null) {
				ValueSerializer valueSerializer = getValueSerializer();
				if (valueSerializer != null) {
					if (valueSerializer.test(type)) {
						return valueSerializer.fromString(type, value);
					}
				}

				ObjectSerializer objectSerializer = getObjectSerializer();
				if (objectSerializer != null) {
					return objectSerializer.deserialize(type, value);
				}
			}
		}

		return (@Nullable T) null;
	}

	/**
	 * Get the preference value for the desired type
	 *
	 * @param path
	 *            the path
	 * @param key
	 *            the key
	 * @param type
	 *            the descriptor
	 * @param valueType
	 *            the value type
	 * @param defaultValue
	 *            the default value
	 * @return the value
	 * @param <T>
	 *            the result type
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getValue(String path, String key, Class<T> type, Class<?> valueType, T defaultValue) {
		if (type.isPrimitive()) {
			if (type.equals(boolean.class)) {
				return (T) Boolean.valueOf(
						getPreferenceService().getBoolean(path, key, ((Boolean) defaultValue).booleanValue(), null));
			} else if (type.equals(int.class)) {
				return (T) Integer
						.valueOf(getPreferenceService().getInt(path, key, ((Integer) defaultValue).intValue(), null));
			} else if (type.equals(double.class)) {
				return (T) Double.valueOf(
						getPreferenceService().getDouble(path, key, ((Double) defaultValue).doubleValue(), null));
			} else if (type.equals(float.class)) {
				return (T) Float
						.valueOf(getPreferenceService().getFloat(path, key, ((Float) defaultValue).floatValue(), null));
			} else if (type.equals(long.class)) {
				return (T) Long
						.valueOf(getPreferenceService().getLong(path, key, ((Long) defaultValue).longValue(), null));
			}
		}

		if (String.class.equals(type) || CharSequence.class.equals(type)) {
			String v = null;
			if (defaultValue != null) {
				v = defaultValue.toString();
			}
			return (T) getPreferenceService().getString(path, key, v, null);
		} else if (Boolean.class.equals(type)) {
			return (T) Boolean.valueOf(
					getPreferenceService().getBoolean(path, key, ((Boolean) defaultValue).booleanValue(), null));
		} else if (Integer.class.equals(type)) {
			return (T) Integer
					.valueOf(getPreferenceService().getInt(path, key, ((Integer) defaultValue).intValue(), null));
		} else if (Double.class.equals(type)) {
			return (T) Double
					.valueOf(getPreferenceService().getDouble(path, key, ((Double) defaultValue).doubleValue(), null));
		} else if (Float.class.equals(type)) {
			return (T) Float
					.valueOf(getPreferenceService().getFloat(path, key, ((Float) defaultValue).floatValue(), null));
		} else if (Long.class.equals(type)) {
			return (T) Long.valueOf(getPreferenceService().getLong(path, key, ((Long) defaultValue).longValue(), null));
		} else {
			String value = getPreferenceService().getString(path, key, null, null);
			if (value != null) {
				ValueSerializer valueSerializer = getValueSerializer();
				if (valueSerializer != null) {
					if (valueSerializer.test(type)) {
						return valueSerializer.fromString(type, value);
					}
				}

				ObjectSerializer objectSerializer = getObjectSerializer();
				if (objectSerializer != null) {
					if (valueType != null && (type == List.class || type == Set.class)) {
						if (type == List.class) {
							return (T) objectSerializer.deserializeCollection((Class<List>) type, valueType, value);
						} else {
							return (T) objectSerializer.deserializeCollection((Class<Set>) type, valueType, value);
						}

					}
					return objectSerializer.deserialize(type, value);
				}
			}
		}

		return defaultValue;
	}

	private static @Nullable Class<?> getDesiredClass(Type desiredType) {
		if (desiredType instanceof Class<?>)
			return (Class<?>) desiredType;
		if (desiredType instanceof ParameterizedType) {
			Type rawType = ((ParameterizedType) desiredType).getRawType();
			if (rawType instanceof Class<?>)
				return (Class<?>) rawType;
		}
		return null;
	}

	private static String getKey(IObjectDescriptor descriptor) {
		if (descriptor == null)
			return null;
		Preference qualifier = descriptor.getQualifier(Preference.class);
		return qualifier.key();
	}

	private static String getNodePath(IObjectDescriptor descriptor, Class<?> requestingObject) {
		if (descriptor == null)
			return null;
		Preference qualifier = descriptor.getQualifier(Preference.class);
		String nodePath = qualifier.nodePath();

		if (nodePath == null || nodePath.trim().isEmpty()) {
			if (requestingObject == null)
				return null;
			nodePath = FrameworkUtil.getBundle(requestingObject).getSymbolicName();
		}
		return nodePath;
	}

	private void addListener(String nodePath, String key, final IRequestor requestor) {
		if (requestor == null)
			return;
		synchronized (this.listenerCache) {
			if (this.listenerCache.containsKey(nodePath)) {
				HashMap<String, List<PrefInjectionListener>> map = this.listenerCache.get(nodePath);
				if (map.containsKey(key)) {
					for (PrefInjectionListener listener : map.get(key)) {
						IRequestor previousRequestor = listener.getRequestor();
						if (previousRequestor.equals(requestor))
							return; // avoid adding duplicate listeners
					}
				}
			}
		}
		final IEclipsePreferences instanceNode = InstanceScope.INSTANCE.getNode(nodePath);
		PrefInjectionListener listener = new PrefInjectionListener(instanceNode, key, requestor);
		instanceNode.addPreferenceChangeListener(listener);

		final IEclipsePreferences configNode = ConfigurationScope.INSTANCE.getNode(nodePath);
		configNode.addPreferenceChangeListener(listener);

		final IEclipsePreferences defaultNode = DefaultScope.INSTANCE.getNode(nodePath);
		defaultNode.addPreferenceChangeListener(listener);

		synchronized (this.listenerCache) {
			HashMap<String, List<PrefInjectionListener>> map = this.listenerCache.get(nodePath);
			if (map == null) {
				map = new HashMap<String, List<PrefInjectionListener>>();
				this.listenerCache.put(nodePath, map);
			}
			List<PrefInjectionListener> listeningRequestors = map.get(key);
			if (listeningRequestors == null) {
				listeningRequestors = new ArrayList<PrefInjectionListener>();
				map.put(key, listeningRequestors);
			}
			listeningRequestors.add(listener);
		}
	}

	// public void removeAllListeners() {
	// synchronized (this.listenerCache) {
	// for (HashMap<String, List<PrefInjectionListener>> map :
	// this.listenerCache.values()) {
	// for (List<PrefInjectionListener> listeners : map.values()) {
	// if (listeners == null)
	// continue;
	// for (PrefInjectionListener listener : listeners) {
	// listener.stopListening();
	// }
	// }
	// }
	// this.listenerCache.clear();
	// }
	// }
}
