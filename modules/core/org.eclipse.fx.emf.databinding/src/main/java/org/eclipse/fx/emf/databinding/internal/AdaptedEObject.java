/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
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
package org.eclipse.fx.emf.databinding.internal;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.emf.databinding.EFXObject;
import org.eclipse.fx.emf.databinding.EProperty;
import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@SuppressWarnings("javadoc")
public class AdaptedEObject<@NonNull O extends EObject> implements EFXObject<O> {
	final Map<EStructuralFeature, Property<?>> map = new HashMap<>();
	final O eo;
	private final EditingDomain ed;
	private Adapter adapter;

	public AdaptedEObject(EditingDomain ed, O eo) {
		this.eo = eo;
		this.ed = ed;
		this.adapter = new MyInnerAdapter(this);
		this.eo.eAdapters().add(this.adapter);
	}

	static class MyInnerAdapter extends AdapterImpl {
		private WeakReference<AdaptedEObject<?>> eo;

		public MyInnerAdapter(AdaptedEObject<?> eo) {
			this.eo = new WeakReference<AdaptedEObject<?>>(eo);
		}

		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);
			AdaptedEObject<?> eo = this.eo.get();
			if( eo == null ) {
				if( msg.getEventType() != Notification.REMOVING_ADAPTER ) {
					((EObject)msg.getNotifier()).eAdapters().remove(this);
				}
			} else {
				Property<Object> property = (Property<Object>) eo.map.get(msg.getFeature());
				if( property != null && ! property.isBound() ) {
					//TODO could avoid boxing
					property.setValue(msg.getNewValue());
				}
			}
		}

		@Override
		public void setTarget(Notifier newTarget) {
			super.setTarget(newTarget);
		}
	}

	@Override
	public BooleanProperty getBooleanProperty(EStructuralFeature feature) {
		if( feature.isMany() ) {
			throw new IllegalArgumentException("Feature is multi valued"); //$NON-NLS-1$
		}
		if(feature.getEType().getInstanceClass() == boolean.class) {
			return (BooleanProperty) this.map.computeIfAbsent(feature, f -> new BooleanPropertyImpl<>(this, f, this.ed));
		} else {
			throw new IllegalAccessError("The feature type is not boolean.class"); //$NON-NLS-1$
		}
	}

	@Override
	public DoubleProperty getDoubleProperty(EStructuralFeature feature) {
		if( feature.isMany() ) {
			throw new IllegalArgumentException("Feature is multi valued"); //$NON-NLS-1$
		}
		if(feature.getEType().getInstanceClass() == double.class) {
			return (DoubleProperty) this.map.computeIfAbsent(feature, f -> new DoublePropertyImpl<>(this, f, this.ed));
		} else {
			throw new IllegalAccessError("The feature type is not double.class"); //$NON-NLS-1$
		}
	}

	@Override
	public FloatProperty getFloatProperty(EStructuralFeature feature) {
		if( feature.isMany() ) {
			throw new IllegalArgumentException("Feature is multi valued"); //$NON-NLS-1$
		}
		if(feature.getEType().getInstanceClass() == float.class) {
			return (FloatProperty) this.map.computeIfAbsent(feature, f -> new FloatPropertyImpl<>(this, f, this.ed));
		} else {
			throw new IllegalAccessError("The feature type is not float.class"); //$NON-NLS-1$
		}
	}

	@Override
	public IntegerProperty getIntegerProperty(EStructuralFeature feature) {
		if( feature.isMany() ) {
			throw new IllegalArgumentException("Feature is multi valued"); //$NON-NLS-1$
		}
		if(feature.getEType().getInstanceClass() == int.class) {
			return (IntegerProperty) this.map.computeIfAbsent(feature, f -> new IntegerPropertyImpl<>(this, f, this.ed));
		} else {
			throw new IllegalAccessError("The feature type is not float.class"); //$NON-NLS-1$
		}
	}

	@Override
	public LongProperty getLongProperty(EStructuralFeature feature) {
		if( feature.isMany() ) {
			throw new IllegalArgumentException("Feature is multi valued"); //$NON-NLS-1$
		}
		if(feature.getEType().getInstanceClass() == long.class) {
			return (LongProperty) this.map.computeIfAbsent(feature, f -> new LongPropertyImpl<>(this, f, this.ed));
		} else {
			throw new IllegalAccessError("The feature type is not float.class"); //$NON-NLS-1$
		}
	}

	@Override
	public <T> ObjectProperty<T> getObjectProperty(Class<T> type, EStructuralFeature feature) {
		if( feature.isMany() ) {
			throw new IllegalArgumentException("Feature is multi valued"); //$NON-NLS-1$
		}

		if( feature instanceof EReference ) {
			return (ObjectProperty<T>) map.computeIfAbsent(feature, f -> new ObjectPropertyImpl<>(this, f, ed));
		} else {
			Class<?> t = feature.getEType().getInstanceClass();
			if( t == String.class
					|| t == int.class
					|| t == long.class
					|| t == double.class
					|| t == float.class
					|| t == boolean.class) {
				throw new IllegalArgumentException("Feature holds a primitive value");
			} else {
				return new ObjectPropertyImpl<>(this, feature, this.ed);
			}
		}
	}

	@Override
	public StringProperty getStringProperty(EStructuralFeature feature) {
		if( feature.isMany() ) {
			throw new IllegalArgumentException("Feature is multi valued"); //$NON-NLS-1$
		}
		if(feature.getEType().getInstanceClass() == String.class) {
			return (StringProperty) this.map.computeIfAbsent(feature, f -> new StringPropertyImpl<>(this, f, this.ed));
		} else {
			throw new IllegalAccessError("The feature type is not String.class"); //$NON-NLS-1$
		}
	}

	static class ObjectPropertyImpl<@NonNull O extends EObject, V> extends SimpleObjectProperty<V> implements EProperty<O, V> {
		private final AdaptedEObject<O> adapter;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public ObjectPropertyImpl(AdaptedEObject<O> adapter, EStructuralFeature f, EditingDomain ed) {
			this.adapter = adapter;
			this.f = f;
			this.ed = ed;
			set(((V) this.adapter.eo.eGet(this.f)));
		}

		@Override
		public O getBean() {
			return this.adapter.eo;
		}

		@Override
		public EStructuralFeature getFeature() {
			return this.f;
		}

		@Override
		public String getName() {
			return this.f.getName();
		}

		@Override
		public void unbind() {
			super.unbind();
			set(((V) this.adapter.eo.eGet(this.f)));
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			V value = get();
			if( this.adapter.eo.eGet(this.f) != value ) {
				if( this.ed == null ) {
					this.adapter.eo.eSet(this.f, value);
				} else {
					Command command = SetCommand.create(this.ed, this.adapter.eo, this.f, value);
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	static class BooleanPropertyImpl<@NonNull O extends EObject> extends SimpleBooleanProperty implements EProperty<O, Boolean> {
		private final AdaptedEObject<O> adapter;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public BooleanPropertyImpl(AdaptedEObject<O> adapter, EStructuralFeature f, EditingDomain ed) {
			this.adapter = adapter;
			this.f = f;
			this.ed = ed;
			set(((Boolean) this.adapter.eo.eGet(this.f)).booleanValue());
		}

		@Override
		public O getBean() {
			return this.adapter.eo;
		}

		@Override
		public EStructuralFeature getFeature() {
			return this.f;
		}

		@Override
		public String getName() {
			return this.f.getName();
		}

		@Override
		public void unbind() {
			super.unbind();
			set(((Boolean) this.adapter.eo.eGet(this.f)).booleanValue());
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			boolean value = get();
			if( ((Boolean) this.adapter.eo.eGet(this.f)).booleanValue() != value ) {
				if( this.ed == null ) {
					this.adapter.eo.eSet(this.f, Boolean.valueOf(value));
				} else {
					Command command = SetCommand.create(this.ed, this.adapter.eo, this.f, Boolean.valueOf(value));
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	static class FloatPropertyImpl<@NonNull O extends EObject> extends SimpleFloatProperty implements EProperty<O, Number> {
		private final AdaptedEObject<O> adapter;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public FloatPropertyImpl(AdaptedEObject<O> adapter, EStructuralFeature f, EditingDomain ed) {
			this.adapter = adapter;
			this.f = f;
			this.ed = ed;
			set(((Float) this.adapter.eo.eGet(this.f)).floatValue());
		}

		@Override
		public O getBean() {
			return this.adapter.eo;
		}

		@Override
		public EStructuralFeature getFeature() {
			return this.f;
		}

		@Override
		public String getName() {
			return this.f.getName();
		}

		@Override
		public void unbind() {
			super.unbind();
			set(((Float) this.adapter.eo.eGet(this.f)).floatValue());
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			float value = get();
			if( ((Float) this.adapter.eo.eGet(this.f)).floatValue() != value ) {
				if( this.ed == null ) {
					this.adapter.eo.eSet(this.f, Float.valueOf(value));
				} else {
					Command command = SetCommand.create(this.ed, this.adapter.eo, this.f, Float.valueOf(value));
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	static class LongPropertyImpl<@NonNull O extends EObject> extends SimpleLongProperty implements EProperty<O, Number> {
		private final AdaptedEObject<O> adapter;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public LongPropertyImpl(AdaptedEObject<O> adapter, EStructuralFeature f, EditingDomain ed) {
			this.adapter = adapter;
			this.f = f;
			this.ed = ed;
			set(((Long) this.adapter.eo.eGet(this.f)).longValue());
		}

		@Override
		public O getBean() {
			return this.adapter.eo;
		}

		@Override
		public EStructuralFeature getFeature() {
			return this.f;
		}

		@Override
		public String getName() {
			return this.f.getName();
		}

		@Override
		public void unbind() {
			super.unbind();
			set(((Long) this.adapter.eo.eGet(this.f)).longValue());
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			long value = get();
			if( ((Long) this.adapter.eo.eGet(this.f)).longValue() != value ) {
				if( this.ed == null ) {
					this.adapter.eo.eSet(this.f, Long.valueOf(value));
				} else {
					Command command = SetCommand.create(this.ed, this.adapter.eo, this.f, Long.valueOf(value));
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	static class IntegerPropertyImpl<@NonNull O extends EObject> extends SimpleIntegerProperty implements EProperty<O, Number> {
		private final AdaptedEObject<O> adapter;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public IntegerPropertyImpl(AdaptedEObject<O> adapter, EStructuralFeature f, EditingDomain ed) {
			this.adapter = adapter;
			this.f = f;
			this.ed = ed;
			set(((Integer) this.adapter.eo.eGet(this.f)).intValue());
		}

		@Override
		public O getBean() {
			return this.adapter.eo;
		}

		@Override
		public EStructuralFeature getFeature() {
			return this.f;
		}

		@Override
		public String getName() {
			return this.f.getName();
		}

		@Override
		public void unbind() {
			super.unbind();
			set(((Integer) this.adapter.eo.eGet(this.f)).intValue());
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			int value = get();
			if( ((Integer) this.adapter.eo.eGet(this.f)).intValue() != value ) {
				if( this.ed == null ) {
					this.adapter.eo.eSet(this.f, Integer.valueOf(value));
				} else {
					Command command = SetCommand.create(this.ed, this.adapter.eo, this.f, Integer.valueOf(value));
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	static class DoublePropertyImpl<@NonNull O extends EObject> extends SimpleDoubleProperty implements EProperty<O, Number> {
		private final AdaptedEObject<O> adapter;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public DoublePropertyImpl(AdaptedEObject<O> adapter, EStructuralFeature f, EditingDomain ed) {
			this.adapter = adapter;
			this.f = f;
			this.ed = ed;
			set(((Double) this.adapter.eo.eGet(this.f)).doubleValue());
		}

		@Override
		public O getBean() {
			return this.adapter.eo;
		}

		@Override
		public EStructuralFeature getFeature() {
			return this.f;
		}

		@Override
		public String getName() {
			return this.f.getName();
		}

		@Override
		public void unbind() {
			super.unbind();
			set(((Double) this.adapter.eo.eGet(this.f)).doubleValue());
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			double value = get();
			if( ((Double) this.adapter.eo.eGet(this.f)).doubleValue() != value ) {
				if( this.ed == null ) {
					this.adapter.eo.eSet(this.f, Double.valueOf(value));
				} else {
					Command command = SetCommand.create(this.ed, this.adapter.eo, this.f,  Double.valueOf(value));
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	static class StringPropertyImpl<@NonNull O extends EObject> extends SimpleStringProperty implements EProperty<O, String> {
		private final AdaptedEObject<O> adapter;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public StringPropertyImpl(AdaptedEObject<O> adapter, EStructuralFeature f, EditingDomain ed) {
			this.adapter = adapter;
			this.f = f;
			this.ed = ed;
			set((String) adapter.eo.eGet(f));
		}

		@Override
		public O getBean() {
			return this.adapter.eo;
		}

		@Override
		public EStructuralFeature getFeature() {
			return this.f;
		}

		@Override
		public String getName() {
			return this.f.getName();
		}

		@Override
		public void unbind() {
			super.unbind();
			set((String) this.adapter.eo.eGet(this.f));
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			String value = get();
			if( this.adapter.eo.eGet(this.f) != value ) {
				if( this.ed == null ) {
					this.adapter.eo.eSet(this.f, value);
				} else {
					Command command = SetCommand.create(this.ed, this.adapter.eo, this.f, value);
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}
}
