/**
 *  Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 *  All rights reserved. This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html 
 *  
 *  Contributors: 
 *      Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation
 */
package org.eclipse.fx.emf.databinding.edit;

import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.Property;
import javafx.collections.ObservableList;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public class EMFEditFXProperties {

	/**
	 * Returns a {@link Property} for the given {@link EStructuralFeature}
	 * 
	 * @param editingDomain the editing domain
	 * @param feature the feature instance the property is created for
	 * @return a value property for the given {@link EStructuralFeature}
	 */
	public static <T> Property<T> value(EditingDomain editingDomain, EObject eObject, EStructuralFeature feature) {
		return new EObjectProperty<>(editingDomain, eObject, feature);
	}

	public static <T> ObservableList<T> list(EditingDomain editingDomain, Notifier owner, EList<T> list) {
		throw new UnsupportedOperationException("Not implemented");
	}
	
	public static <T> ObservableList<T> list(EditingDomain editingDomain, EObject eObject, EStructuralFeature feature) {
		throw new UnsupportedOperationException("Not implemented");
	}
	
//	static class EObjectObservableList<T> extends ListPropertyBase<T> {
//
//		EObject eObject;
//		EStructuralFeature feature;
//		EditingDomain editingDomain;
//		
//		public Object getBean() {
//			return eObject;
//		}
//
//		public String getName() {
//			return feature.getName();
//		}
//		
//		//FIXME Java8	
//		// Default methods NOT YET supported by JDT-Core
////		@Override
//		public void forEach(Consumer<? super T> action) {
//			super.forEach(action);
//		}
//					
////		@Override
//		public Spliterator<T> spliterator() {
//			return super.spliterator();
//		}
//
//	}

	static class EObjectProperty<T> extends ObjectPropertyBase<T> {

		EObject eObject;
		EStructuralFeature feature;
		EditingDomain editingDomain;

		public EObjectProperty(EditingDomain editingDomain, EObject eObject, EStructuralFeature feature) {
			super();
			this.eObject = eObject;
			this.feature = feature;
			this.editingDomain = editingDomain;

			eObject.eAdapters().add(new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					fireValueChangedEvent();
				}
			});
		}

		public void setEObject(EObject eObject) {
			this.eObject = eObject;
		}

		@Override
		public void setValue(T newValue) {
			Command command = SetCommand.create(editingDomain, eObject, feature, newValue);
			if (command.canExecute())
				editingDomain.getCommandStack().execute(command);
		}

		@Override
		@SuppressWarnings("unchecked")
		public T getValue() {
			return (T) eObject.eGet(feature);
		}

		public Object getBean() {
			return eObject;
		}

		public String getName() {
			return feature.getName();
		}

	}

}
