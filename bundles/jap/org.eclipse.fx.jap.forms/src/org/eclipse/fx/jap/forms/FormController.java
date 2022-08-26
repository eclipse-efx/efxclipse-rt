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
package org.eclipse.fx.jap.forms;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.fx.jap.datasource.DataSource;

public interface FormController<D extends DataSource, T> {
	public IObservableValue getMaster();
	public T getMasterValue();
//	public void bind(IObservableValue uiObservable, String featurePath);
}
