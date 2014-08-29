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
package org.eclipse.fx.jap.forms;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.fx.jap.datasource.DataSource;

public interface FormController<D extends DataSource, T> {
	public IObservableValue getMaster();
	public T getMasterValue();
//	public void bind(IObservableValue uiObservable, String featurePath);
}
