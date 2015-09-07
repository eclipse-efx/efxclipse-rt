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

//		public void stopListening() {
//			this.node.removePreferenceChangeListener(this);
//		}
	}

	// Hash (nodePath -> Hash (key -> list))
	private Map<String, HashMap<String, List<PrefInjectionListener>>> listenerCache = new HashMap<String, HashMap<String, List<PrefInjectionListener>>>();

	@Override
	public Object get(IObjectDescriptor descriptor, IRequestor requestor, boolean track, boolean group) {
		if (descriptor == null)
			return null;
		Class<?> descriptorsClass = getDesiredClass(descriptor.getDesiredType());
		String nodePath = getNodePath(descriptor, requestor.getRequestingObjectClass());

		if (nodePath == null  || nodePath.length() == 0)
			return IInjector.NOT_A_VALUE;

		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(nodePath);

		if (preferences == null) {
			return IInjector.NOT_A_VALUE;
		}

		String key = getKey(descriptor);
		if (key == null || key.length() == 0) {
			return IInjector.NOT_A_VALUE;
		}

		if( descriptorsClass.equals(boolean.class)
				|| descriptorsClass.equals(Boolean.class)
				|| descriptorsClass.equals(int.class)
				|| descriptorsClass.equals(Integer.class)
				|| descriptorsClass.equals(double.class)
				|| descriptorsClass.equals(Double.class)
				|| descriptorsClass.equals(float.class)
				|| descriptorsClass.equals(Float.class)
				|| descriptorsClass.equals(long.class)
				|| descriptorsClass.equals(Long.class)
				|| descriptorsClass.equals(String.class)) {
			if (track)
				addListener(nodePath, key, requestor);

			return getValue(preferences, key, descriptorsClass);
		}

		Class<?> type = descriptor.getQualifier(Preference.class).type();
		if( type == Object.class && descriptor.getDesiredType() instanceof ParameterizedType ) {
			Type t = ((ParameterizedType) descriptor.getDesiredType()).getActualTypeArguments()[0];
			type = t instanceof ParameterizedType ? (Class<?>) ((ParameterizedType) t).getRawType() : (Class<?>) t;
		}

		if( type == Object.class ) {
			return IInjector.NOT_A_VALUE;
		}

		Requestor<?> r = (Requestor<?>) requestor;
		PreferenceValue<?> v = r.getInjector().make(PreferenceValue.class, r.getPrimarySupplier());
		v.init(key, preferences, type);

		if(descriptorsClass != Value.class ) {
			return v.adaptTo(descriptorsClass);
		}

		return v;

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
	 * @return the value
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getValue(IEclipsePreferences preference, String key, Class<T> descriptorsClass) {
		if (descriptorsClass.isPrimitive()) {
			if (descriptorsClass.equals(boolean.class))
				return (T) Boolean.valueOf(preference.getBoolean(key, false));
			else if (descriptorsClass.equals(int.class))
				return (T) Integer.valueOf(preference.getInt(key, 0));
			else if (descriptorsClass.equals(double.class))
				return (T) Double.valueOf(preference.getDouble(key, 0.0d));
			else if (descriptorsClass.equals(float.class))
				return (T) Float.valueOf(preference.getFloat(key, 0.0f));
			else if (descriptorsClass.equals(long.class))
				return (T) Long.valueOf(preference.getLong(key, 0L));
		}

		if (String.class.equals(descriptorsClass))
			return (T) preference.get(key, null);
		else if (Boolean.class.equals(descriptorsClass))
			return (T) Boolean.valueOf(preference.getBoolean(key, false));
		else if (Integer.class.equals(descriptorsClass))
			return (T) Integer.valueOf(preference.getInt(key, 0));
		else if (Double.class.equals(descriptorsClass))
			return (T) Double.valueOf(preference.getDouble(key, 0.0d));
		else if (Float.class.equals(descriptorsClass))
			return (T) Float.valueOf(preference.getFloat(key, 0.0f));
		else if (Long.class.equals(descriptorsClass))
			return (T) Long.valueOf(preference.getLong(key, 0L));

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

//	public void removeAllListeners() {
//		synchronized (this.listenerCache) {
//			for (HashMap<String, List<PrefInjectionListener>> map : this.listenerCache.values()) {
//				for (List<PrefInjectionListener> listeners : map.values()) {
//					if (listeners == null)
//						continue;
//					for (PrefInjectionListener listener : listeners) {
//						listener.stopListening();
//					}
//				}
//			}
//			this.listenerCache.clear();
//		}
//	}
}
