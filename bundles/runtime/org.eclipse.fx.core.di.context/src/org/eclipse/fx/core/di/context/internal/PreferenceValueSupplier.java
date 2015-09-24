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

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.IInjector;
import org.eclipse.e4.core.di.suppliers.ExtendedObjectSupplier;
import org.eclipse.e4.core.di.suppliers.IObjectDescriptor;
import org.eclipse.e4.core.di.suppliers.IRequestor;
import org.eclipse.e4.core.internal.di.Requestor;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.core.preferences.Preference;
import org.eclipse.fx.core.preferences.Value;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Component;

import com.google.common.base.Strings;

/**
 * Supplier for {@link Preference}
 *
 * @since 2.1.0
 */
@SuppressWarnings("restriction")
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

	@Override
	public Object get(IObjectDescriptor descriptor, IRequestor requestor, boolean track, boolean group) {
		if (descriptor == null)
			return null;
		Class<?> descriptorsClass = getDesiredClass(descriptor.getDesiredType());
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
		if( "EFX__NO_VALUE__".equals(defaultValue) ) { //$NON-NLS-1$
			defaultValue = null;
		}

		if (descriptorsClass.equals(boolean.class) || descriptorsClass.equals(Boolean.class) || descriptorsClass.equals(int.class) || descriptorsClass.equals(Integer.class) || descriptorsClass.equals(double.class) || descriptorsClass.equals(Double.class) || descriptorsClass.equals(float.class)
				|| descriptorsClass.equals(Float.class) || descriptorsClass.equals(long.class) || descriptorsClass.equals(Long.class) || descriptorsClass.equals(String.class)) {
			if (track)
				addListener(nodePath, key, requestor);

			Object v = getDefault(defaultValue, descriptorsClass);
			return getValue(preferences, key, (Class<Object>) descriptorsClass, v);
		}

		Class<?> type = p.type();
		if (type == Object.class && descriptor.getDesiredType() instanceof ParameterizedType) {
			Type t = ((ParameterizedType) descriptor.getDesiredType()).getActualTypeArguments()[0];
			type = t instanceof ParameterizedType ? (Class<?>) ((ParameterizedType) t).getRawType() : (Class<?>) t;
		}

		if (type == Object.class) {
			return IInjector.NOT_A_VALUE;
		}

		Requestor<?> r = (Requestor<?>) requestor;
		PreferenceValue<Object> v = r.getInjector().make(PreferenceValue.class, r.getPrimarySupplier());
		v.init(key, preferences, type, getDefault(defaultValue, type));

		if (descriptorsClass != Value.class) {
			return v.adaptTo(descriptorsClass);
		}

		return v;
	}

	private static <T> T getDefault(String value, Class<T> type) {
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
		}
		throw new IllegalArgumentException("Unsupported value type '" + type + "'");
	}

	/**
	 * Get the preference value for the desired type
	 *
	 * @param preference
	 *            the preference
	 * @param key
	 *            the key
	 * @param descriptorsClass
	 *            the descriptor
	 * @param defaultValue
	 *            the default value
	 * @return the value
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getValue(IEclipsePreferences preference, String key, Class<T> descriptorsClass, T defaultValue) {
		if (descriptorsClass.isPrimitive()) {
			if (descriptorsClass.equals(boolean.class))
				return (T) Boolean.valueOf(preference.getBoolean(key, ((Boolean) defaultValue).booleanValue()));
			else if (descriptorsClass.equals(int.class))
				return (T) Integer.valueOf(preference.getInt(key, ((Integer) defaultValue).intValue()));
			else if (descriptorsClass.equals(double.class))
				return (T) Double.valueOf(preference.getDouble(key, ((Double) defaultValue).doubleValue()));
			else if (descriptorsClass.equals(float.class))
				return (T) Float.valueOf(preference.getFloat(key, ((Float) defaultValue).floatValue()));
			else if (descriptorsClass.equals(long.class))
				return (T) Long.valueOf(preference.getLong(key, ((Long) defaultValue).longValue()));
		}

		if (String.class.equals(descriptorsClass))
			return (T) preference.get(key, (String) defaultValue);
		else if (Boolean.class.equals(descriptorsClass))
			return (T) Boolean.valueOf(preference.getBoolean(key, ((Boolean) defaultValue).booleanValue()));
		else if (Integer.class.equals(descriptorsClass))
			return (T) Integer.valueOf(preference.getInt(key, ((Integer) defaultValue).intValue()));
		else if (Double.class.equals(descriptorsClass))
			return (T) Double.valueOf(preference.getDouble(key, ((Double) defaultValue).doubleValue()));
		else if (Float.class.equals(descriptorsClass))
			return (T) Float.valueOf(preference.getFloat(key, ((Float) defaultValue).floatValue()));
		else if (Long.class.equals(descriptorsClass))
			return (T) Long.valueOf(preference.getLong(key, ((Long) defaultValue).longValue()));

		return (T) preference.get(key, null);
	}

	private static Class<?> getDesiredClass(Type desiredType) {
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

		if (Strings.isNullOrEmpty(nodePath)) {
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
		final IEclipsePreferences node = InstanceScope.INSTANCE.getNode(nodePath);
		PrefInjectionListener listener = new PrefInjectionListener(node, key, requestor);
		node.addPreferenceChangeListener(listener);

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
