/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
