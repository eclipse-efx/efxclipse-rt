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
package org.eclipse.fx.ui.workbench.base.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.fx.core.GenericObject;
import org.eclipse.fx.core.GenericObject.GenericAttribute;
import org.eclipse.fx.core.adapter.AdapterProvider;
import org.eclipse.fx.core.adapter.AdapterService.ValueAccess;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.component.annotations.Component;

/**
 * Adapter for EObject
 */
@Component
public class EObjectAdapterProvider implements AdapterProvider<EObject, GenericObject> {

	@Override
	public @NonNull Class<EObject> getSourceType() {
		return EObject.class;
	}

	@Override
	public @NonNull Class<GenericObject> getTargetType() {
		return GenericObject.class;
	}

	@Override
	public boolean canAdapt(@NonNull EObject sourceObject, @NonNull Class<GenericObject> targetType) {
		return true;
	}

	@Override
	public GenericObject adapt(@NonNull EObject sourceObject, @NonNull Class<GenericObject> targetType,
			ValueAccess... valueAccess) {
		return new EObjectGenericObjectAdapter(sourceObject);
	}
	
	static class EObjectGenericObjectAdapter implements GenericObject {
		private final EObject eo;
		private Map<String, GenericAttribute<?>> attributes;
		
		public EObjectGenericObjectAdapter(EObject eo) {
			this.eo = eo;
		}
		
		@Override
		public Class<?> getType() {
			return this.eo.eClass().getInstanceClass();
		}
		
		private Map<String, GenericAttribute<?>> _getAttributeMap() {
			if( this.attributes == null ) {
				this.attributes = new HashMap<>();
				for (EStructuralFeature feature : this.eo.eClass().getEAllStructuralFeatures()) {
					this.attributes.put(feature.getName(), new GenericAttributeAdapter<>(this.eo, feature, this));
				}
			}
			return this.attributes;
		}

		@Override
		public <T> @Nullable GenericAttribute<T> getAttribute(String attributeName) {
			return (@Nullable GenericAttribute<T>) _getAttributeMap().get(attributeName);
		}

		@Override
		public Collection<GenericAttribute<?>> getAttributes() {
			// TODO Auto-generated method stub
			return Collections.unmodifiableCollection(_getAttributeMap().values());
		}

		@Override
		public boolean hasAttribute(String attributeName) {
			return _getAttributeMap().containsKey(attributeName);
		}

		@Override
		public <V> @Nullable V get(String attributeName) throws IllegalArgumentException {
			GenericAttribute<?> attribute = _getAttributeMap().get(attributeName);
			if( attribute == null ) {
				throw new IllegalArgumentException("Attribute '"+attributeName+"' is not known to class '"+this.eo+"'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return (@Nullable V) attribute.getValue();
		}

		@Override
		public GenericObject getAsGenericObject(String attributeName)
				throws IllegalArgumentException, IllegalStateException {
			GenericAttribute<?> genericAttribute = _getAttributeMap().get(attributeName);
			GenericAttributeAdapter<?> genericAttribute2 = (GenericAttributeAdapter<?>)genericAttribute;
			if( genericAttribute == null ) {
				throw new IllegalArgumentException("Attribute '"+attributeName+"' is not known to class '"+this.eo+"'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			} else if( genericAttribute2.f instanceof EReference ) {
				return new EObjectGenericObjectAdapter(genericAttribute.getValue());
			} 
			return null;
		}

		@Override
		public void set(String attributeName, Object value) throws IllegalArgumentException, ClassCastException {
			// TODO Auto-generated method stub
			
		}
	}
	
	static class GenericAttributeAdapter<T> implements GenericAttribute<T> {
		final EStructuralFeature f;
		private final GenericObject owner;
		private final EObject eo;
		
		public GenericAttributeAdapter(EObject eo, EStructuralFeature f, GenericObject owner) {
			this.eo = eo;
			this.f = f;
			this.owner = owner;
		}

		@Override
		public GenericObject getOwner() {
			return this.owner;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Class<T> getType() {
			return (Class<T>) this.f.getEType().getInstanceClass();
		}

		@SuppressWarnings("unchecked")
		@Override
		public <R extends T> R getValue() {
			return (R) this.eo.eGet(this.f);
		}

		@Override
		public void setValue(T v) throws ClassCastException {
			this.eo.eSet(this.f, v);
		}
	}
}
