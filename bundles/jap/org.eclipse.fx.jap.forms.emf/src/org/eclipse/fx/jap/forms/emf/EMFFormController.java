/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
package org.eclipse.fx.jap.forms.emf;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.fx.jap.datasource.emf.EMFDataSource;
import org.eclipse.fx.jap.forms.FormController;

public interface EMFFormController<D extends EMFDataSource,T> extends FormController<D, T> {
	public void bind(IObservableValue uiObservable, EStructuralFeature... featurePath);
}
