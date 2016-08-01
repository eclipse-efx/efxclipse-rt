/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.emf.databinding.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.emf.databinding.EFXObject;
import org.eclipse.fx.emf.databinding.EProperty;
import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;


@SuppressWarnings("javadoc")
public class AdaptedEObject<@NonNull O extends EObject> implements EFXObject<O> {
	final Map<EStructuralFeature, Property<?>> map = new HashMap<>();
	final Map<EStructuralFeature, Property<?>> editMap = new HashMap<>();
	private final O eo;
	private final EditingDomain ed;

	public AdaptedEObject(EditingDomain ed, O eo) {
		this.eo = eo;
		this.ed = ed;
		this.eo.eAdapters().add( new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				Property<Object> property = (Property<Object>) AdaptedEObject.this.map.get(msg.getFeature());
				if( property != null && ! property.isBound() ) {
					property.setValue(msg.getNewValue());
				}

				property = (Property<Object>) AdaptedEObject.this.editMap.get(msg.getFeature());
				if( property != null && ! property.isBound() ) {
					property.setValue(msg.getNewValue());
				}
			}
		});
	}

	public <@NonNull P extends EProperty<@NonNull O,?>> P getProperty(EStructuralFeature feature) {
		 Map<EStructuralFeature, Property<?>> map = ed == null ? this.map : this.editMap;
		Property<?> property = map.get(feature);

		if( property == null ) {
			if( feature instanceof EReference ) {
				if( feature.isMany() ) {
					throw new UnsupportedOperationException();
				} else {
					property = new ObjectPropertyImpl<>(this.eo, feature, ed);
					map.put(feature, property);
				}
			} else {
				EAttribute ea = (EAttribute) feature;
				if( ! ea.isMany() ) {
					if(ea.getEType().getInstanceClass() == String.class) {
						property = new StringPropertyImpl<>(this.eo, feature, ed);
						map.put(ea, property);
					} else if( ea.getEType().getInstanceClass() == int.class ) {
						property = new IntegerPropertyImpl<>(this.eo, feature, ed);
						map.put(ea, property);
					} else if( ea.getEType().getInstanceClass() == double.class ) {
						property = new DoublePropertyImpl<>(this.eo, feature, ed);
						map.put(ea, property);
					} else if( ea.getEType().getInstanceClass() == long.class ) {
						property = new LongPropertyImpl<>(this.eo, feature, ed);
						map.put(ea, property);
					} else if( ea.getEType().getInstanceClass() == float.class ) {
						property = new FloatPropertyImpl<>(this.eo, feature, ed);
						map.put(ea, property);
					} else if( ea.getEType().getInstanceClass() == boolean.class ) {
						property = new BooleanPropertyImpl<>(this.eo, feature, ed);
						map.put(ea, property);
					} else {
						property = new ObjectPropertyImpl<>(this.eo, feature, ed);
						map.put(ea, property);
					}
				} else {
					throw new UnsupportedOperationException();
				}
			}
		}

		return (P) property;
	}

	static class ObjectPropertyImpl<@NonNull O extends EObject, V> extends SimpleObjectProperty<V> implements EProperty<O, V> {
		private final O eo;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public ObjectPropertyImpl(O eo, EStructuralFeature f, EditingDomain ed) {
			this.eo = eo;
			this.f = f;
			this.ed = ed;
			set(((V) this.eo.eGet(this.f)));
		}

		@Override
		public O getBean() {
			return this.eo;
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
			set(((V) this.eo.eGet(this.f)));
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			V value = get();
			if( this.eo.eGet(this.f) != value ) {
				if( this.ed == null ) {
					this.eo.eSet(this.f, value);
				} else {
					Command command = SetCommand.create(this.ed, this.eo, this.f, value);
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	static class BooleanPropertyImpl<@NonNull O extends EObject> extends SimpleBooleanProperty implements EProperty<O, Boolean> {
		private final O eo;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public BooleanPropertyImpl(O eo, EStructuralFeature f, EditingDomain ed) {
			this.eo = eo;
			this.f = f;
			this.ed = ed;
			set(((Boolean) this.eo.eGet(this.f)).booleanValue());
		}

		@Override
		public O getBean() {
			return this.eo;
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
			set(((Boolean) this.eo.eGet(this.f)).booleanValue());
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			boolean value = get();
			if( ((Boolean) this.eo.eGet(this.f)).booleanValue() != value ) {
				if( this.ed == null ) {
					this.eo.eSet(this.f, Boolean.valueOf(value));
				} else {
					Command command = SetCommand.create(this.ed, this.eo, this.f, Boolean.valueOf(value));
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	static class FloatPropertyImpl<@NonNull O extends EObject> extends SimpleFloatProperty implements EProperty<O, Number> {
		private final O eo;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public FloatPropertyImpl(O eo, EStructuralFeature f, EditingDomain ed) {
			this.eo = eo;
			this.f = f;
			this.ed = ed;
			set(((Float) this.eo.eGet(this.f)).floatValue());
		}

		@Override
		public O getBean() {
			return this.eo;
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
			set(((Float) this.eo.eGet(this.f)).floatValue());
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			float value = get();
			if( ((Float) this.eo.eGet(this.f)).floatValue() != value ) {
				if( this.ed == null ) {
					this.eo.eSet(this.f, Float.valueOf(value));
				} else {
					Command command = SetCommand.create(this.ed, this.eo, this.f, Float.valueOf(value));
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	static class LongPropertyImpl<@NonNull O extends EObject> extends SimpleLongProperty implements EProperty<O, Number> {
		private final O eo;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public LongPropertyImpl(O eo, EStructuralFeature f, EditingDomain ed) {
			this.eo = eo;
			this.f = f;
			this.ed = ed;
			set(((Long) this.eo.eGet(this.f)).longValue());
		}

		@Override
		public O getBean() {
			return this.eo;
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
			set(((Long) this.eo.eGet(this.f)).longValue());
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			long value = get();
			if( ((Long) this.eo.eGet(this.f)).longValue() != value ) {
				if( this.ed == null ) {
					this.eo.eSet(this.f, Long.valueOf(value));
				} else {
					Command command = SetCommand.create(this.ed, this.eo, this.f, Long.valueOf(value));
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	static class IntegerPropertyImpl<@NonNull O extends EObject> extends SimpleIntegerProperty implements EProperty<O, Number> {
		private final O eo;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public IntegerPropertyImpl(O eo, EStructuralFeature f, EditingDomain ed) {
			this.eo = eo;
			this.f = f;
			this.ed = ed;
			set(((Integer) this.eo.eGet(this.f)).intValue());
		}

		@Override
		public O getBean() {
			return this.eo;
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
			set(((Integer) this.eo.eGet(this.f)).intValue());
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			int value = get();
			if( ((Integer) this.eo.eGet(this.f)).intValue() != value ) {
				if( this.ed == null ) {
					this.eo.eSet(this.f, Integer.valueOf(value));
				} else {
					Command command = SetCommand.create(this.ed, this.eo, this.f, Integer.valueOf(value));
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	static class DoublePropertyImpl<@NonNull O extends EObject> extends SimpleDoubleProperty implements EProperty<O, Number> {
		private final O eo;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public DoublePropertyImpl(O eo, EStructuralFeature f, EditingDomain ed) {
			this.eo = eo;
			this.f = f;
			this.ed = ed;
			set(((Double) this.eo.eGet(this.f)).doubleValue());
		}

		@Override
		public O getBean() {
			return this.eo;
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
			set(((Double) this.eo.eGet(this.f)).doubleValue());
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			double value = get();
			if( ((Double) this.eo.eGet(this.f)).doubleValue() != value ) {
				if( this.ed == null ) {
					this.eo.eSet(this.f, Double.valueOf(value));
				} else {
					Command command = SetCommand.create(this.ed, this.eo, this.f,  Double.valueOf(value));
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}

	static class StringPropertyImpl<@NonNull O extends EObject> extends SimpleStringProperty implements EProperty<O, String> {
		private final O eo;
		private final EStructuralFeature f;
		private final EditingDomain ed;

		public StringPropertyImpl(O eo, EStructuralFeature f, EditingDomain ed) {
			this.eo = eo;
			this.f = f;
			this.ed = ed;
			set((String) eo.eGet(f));
		}

		@Override
		public O getBean() {
			return this.eo;
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
			set((String) this.eo.eGet(this.f));
		}

		@Override
		protected void invalidated() {
			super.invalidated();

			String value = get();
			if( this.eo.eGet(this.f) != value ) {
				if( this.ed == null ) {
					this.eo.eSet(this.f, value);
				} else {
					Command command = SetCommand.create(this.ed, this.eo, this.f, value);
					if( command.canExecute() ) {
						this.ed.getCommandStack().execute(command);
					}
				}
			}
		}
	}
}
