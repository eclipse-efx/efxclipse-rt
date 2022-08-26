/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.base.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.fx.core.AppMemento;
import org.eclipse.fx.core.ObjectSerializer;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * Context function creating an {@link AppMemento} instance backed by the
 * {@link MApplication}
 */ 
@Component(service = { IContextFunction.class }, property={"service.context.key=org.eclipse.fx.core.AppMemento"})
public class AppMementoCF extends ContextFunction {
	List<ObjectSerializer> serializers = new ArrayList<ObjectSerializer>();

	/**
	 * Register a new serializer
	 * 
	 * @param serializer
	 *            the new serializer
	 */
	@Reference(policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY, cardinality=ReferenceCardinality.MULTIPLE)
	public void registerObjectSerializer(ObjectSerializer serializer) {
		synchronized (this.serializers) {
			this.serializers.add(serializer);
		}
	}

	/**
	 * Unregister a new serializer
	 * 
	 * @param serializer
	 *            the serializer to remove
	 */
	public void unregisterObjectSerializer(ObjectSerializer serializer) {
		synchronized (this.serializers) {
			this.serializers.remove(serializer);
		}
	}

	@Override
	public Object compute(IEclipseContext context) {
		MApplication mApplication = context.get(MApplication.class);
		if (mApplication == null) {
			return null;
		} else {
			return new AppMementoImpl(mApplication.getPersistedState());
		}
	}

	class AppMementoImpl implements AppMemento {
		private final Map<String, String> map;
		private static final String TYPE_PREFIX = "__type_"; //$NON-NLS-1$

		public AppMementoImpl(Map<String, String> map) {
			this.map = map;
		}

		private void _put(String key, Object value, String type) {
			this.map.put(key, value == null ? null : value.toString());
			this.map.put(TYPE_PREFIX + key, type);
		}

		public String _get(String key, String defaultValue, String type) {
			String rv = defaultValue;
			rv = this.map.get(key);
			if (rv == null) {
				rv = defaultValue;
			}
			return rv;
		}

		@Override
		public void put(String key, String value) {
			_put(key, value, String.class.getName());
		}

		@Override
		public void put(String key, boolean value) {
			_put(key, Boolean.valueOf(value), boolean.class.getName());
		}

		@Override
		public void put(String key, int value) {
			_put(key, Integer.valueOf(value), int.class.getName());
		}

		@Override
		public void put(String key, double value) {
			_put(key, Double.valueOf(value), double.class.getName());
		}

		@Override
		public void remove(String key) {
			this.map.remove(key);
			this.map.remove(TYPE_PREFIX + key);
		}

		@Override
		public boolean exists(String key) {
			return this.map.containsKey(key);
		}

		@Override
		public String get(String key, String defaultValue) {
			return _get(key, defaultValue, String.class.getName());
		}

		@Override
		public boolean get(String key, boolean defaultValue) {
			String rv = _get(key, Boolean.valueOf(defaultValue).toString(), boolean.class.getName());
			return Boolean.parseBoolean(rv);
		}

		@Override
		public int get(String key, int defaultValue) {
			String rv = _get(key, Integer.valueOf(defaultValue).toString(), int.class.getName());
			return Integer.parseInt(rv);
		}

		@Override
		public double get(String key, double defaultValue) {
			String rv = _get(key, Double.valueOf(defaultValue).toString(), double.class.getName());
			return Double.parseDouble(rv);
		}

		@Override
		public <O> O get(String key, Class<O> clazz, O defaultValue) {
			synchronized (AppMementoCF.this.serializers) {
				String serializer = this.map.get(TYPE_PREFIX+key);
				if( serializer == null ) {
					return defaultValue;
				}
				
				String value = this.map.get(key);
				if( value == null ) {
					return defaultValue;
				}
				
				serializer = serializer.substring("serialized:".length()); //$NON-NLS-1$
				
				for( ObjectSerializer s : AppMementoCF.this.serializers ) {
					if( s.getId().equals(serializer) ) {
						return s.deserialize(clazz, value);
					}
				}
				throw new IllegalArgumentException("The serializer '"+serializer+"' is not known");  //$NON-NLS-1$//$NON-NLS-2$
			}
		}

		@Override
		public void put(@NonNull String key, Object value, String serializer) {
			if( value == null ) {
				_put(key, null, "serialized:"+serializer); //$NON-NLS-1$
			}
			synchronized (AppMementoCF.this.serializers) {
				for( ObjectSerializer s : AppMementoCF.this.serializers ) {
					if( s.getId().equals(serializer) ) {
						_put(key, s.serialize(value), "serialized:"+serializer); //$NON-NLS-1$
						return;
					}
				}
			}
			throw new IllegalArgumentException("The serializer '"+serializer+"' is not known");  //$NON-NLS-1$//$NON-NLS-2$
		}
	}
}
