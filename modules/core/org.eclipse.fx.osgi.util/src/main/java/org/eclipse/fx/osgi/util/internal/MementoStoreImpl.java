/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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
package org.eclipse.fx.osgi.util.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.fx.core.Memento;
import org.eclipse.fx.core.MementoStore;
import org.eclipse.fx.core.ObjectSerializer;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Memento store based on Equinox Preferences
 */
@Component
public class MementoStoreImpl implements MementoStore {

	List<ObjectSerializer> serializers = new ArrayList<ObjectSerializer>();
	IPreferencesService preferencesService;

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
	 * Sets the {@link IPreferencesService} used by this MementoStore
	 * 
	 * @param preferenceService
	 * 		The preference service
	 */
	@Reference
	public void setPreferenceService(IPreferencesService preferenceService) {
		this.preferencesService = preferenceService;
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
	public @NonNull Memento getMemento(String path) {
		return new MementoImpl(this.preferencesService, path);
	}

	@Override
	public void remove(String path) {
		try {
			InstanceScope.INSTANCE.getNode(path).removeNode();
		} catch (BackingStoreException e) {
			throw new RuntimeException(e);
		}
	}

	class MementoImpl implements Memento {
		private final IPreferencesService preferencesService;
		private final String path;
		private final IEclipsePreferences node;
		private final IEclipsePreferences defaultNode;
		private static final String TYPE_PREFIX = "__type_"; //$NON-NLS-1$
		
		private void flush() {
			try {
				this.node.flush();
			} catch (BackingStoreException e) {
				throw new RuntimeException(e);
			}
		}
		
		public MementoImpl(IPreferencesService preferencesService, String path) {
			this.preferencesService = preferencesService;
			this.path = path;
			this.node = InstanceScope.INSTANCE.getNode(path);
			this.defaultNode = DefaultScope.INSTANCE.getNode(path);
		}

		@Override
		public void put(@NonNull String key, String value) {
			this.node.put(key, value);
			flush();
		}

		@Override
		public void put(@NonNull String key, boolean value) {
			this.node.putBoolean(key, value);
			flush();
		}

		@Override
		public void put(@NonNull String key, int value) {
			this.node.putInt(key, value);
			flush();
		}

		@Override
		public void put(@NonNull String key, double value) {
			this.node.putDouble(key, value);
			flush();
		}

		@Override
		public void put(@NonNull String key, Object value, String serializer) {
			if( value == null ) {
				this.node.put(key, null);
				this.node.put(TYPE_PREFIX+key, "serialized:"+serializer); //$NON-NLS-1$
			}
			synchronized (MementoStoreImpl.this.serializers) {
				for( ObjectSerializer s : MementoStoreImpl.this.serializers ) {
					if( s.getId().equals(serializer) ) {
						this.node.put(key, s.serialize(value));
						this.node.put(TYPE_PREFIX+key, "serialized:"+serializer); //$NON-NLS-1$
						flush();
						return;
					}
				}
			}
			throw new IllegalArgumentException("The serializer '"+serializer+"' is not known");  //$NON-NLS-1$//$NON-NLS-2$
		}

		@Override
		public void remove(@NonNull String key) {
			this.node.remove(key);
			flush();
		}

		@Override
		public boolean exists(@NonNull String key) {
			try {
				return Arrays.asList(this.node.keys()).contains(key);
			} catch (BackingStoreException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public @Nullable String get(@NonNull String key, @Nullable String defaultValue) {
			return this.preferencesService.getString(this.path, key, defaultValue, null);
		}

		@Override
		public boolean get(@NonNull String key, boolean defaultValue) {
			return this.preferencesService.getBoolean(this.path, key, defaultValue, null);
		}

		@Override
		public int get(@NonNull String key, int defaultValue) {
			return this.preferencesService.getInt(this.path, key, defaultValue, null);
		}

		@Override
		public double get(@NonNull String key, double defaultValue) {
			return this.preferencesService.getDouble(this.path, key, defaultValue, null);
		}
		
		@Override
		public <@Nullable O> O getDefault(String key, Class<O> clazz) {
			synchronized (MementoStoreImpl.this.serializers) {
				String serializer = this.defaultNode.get(TYPE_PREFIX+key, null);
				if( serializer == null ) {
					return null;
				}
				
				String value = this.defaultNode.get(key, null);
				if( value == null ) {
					return null;
				}
				
				serializer = serializer.substring("serialized:".length()); //$NON-NLS-1$
				
				for( ObjectSerializer s : MementoStoreImpl.this.serializers ) {
					if( s.getId().equals(serializer) ) {
						return s.deserialize(clazz, value);
					}
				}
				throw new IllegalArgumentException("The serializer '"+serializer+"' is not known");  //$NON-NLS-1$//$NON-NLS-2$
			}
		}
		
		@Override
		public boolean getDefaultBoolean(String key) {
			return this.defaultNode.getBoolean(key, false);
		}
		
		@Override
		public int getDefaultInteger(String key) {
			return this.defaultNode.getInt(key, 0);
		}
		
		@Override
		public double getDefaultDouble(String key) {
			return this.defaultNode.getDouble(key, 0.);
		}
		
		@Override
		public String getDefaultString(String key) {
			return this.defaultNode.get(key, ""); //$NON-NLS-1$
		}
		
		@Override
		public <O> @Nullable O get(String key, Class<O> clazz, @Nullable O defaultValue) {
			synchronized (MementoStoreImpl.this.serializers) {
				String serializer = this.preferencesService.getString(this.path, TYPE_PREFIX+key, null, null);
				if( serializer == null ) {
					return defaultValue;
				}
				
				String value = this.preferencesService.getString(this.path, key, null, null);
				if( value == null ) {
					return defaultValue;
				}
				
				serializer = serializer.substring("serialized:".length()); //$NON-NLS-1$
				
				for( ObjectSerializer s : MementoStoreImpl.this.serializers ) {
					if( s.getId().equals(serializer) ) {
						return s.deserialize(clazz, value);
					}
				}
				throw new IllegalArgumentException("The serializer '"+serializer+"' is not known");  //$NON-NLS-1$//$NON-NLS-2$
			}
		}
		
	}
}
