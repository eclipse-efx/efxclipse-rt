/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
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
package org.eclipse.fx.ui.databinding;

import org.eclipse.core.databinding.observable.value.IObservableValue;

/**
 * Base interface of all control observables
 *
 * @param <T>
 *            type of the value of the property
 */
public interface IJFXControlValueObservable<T> extends IObservableValue<T> {
	// nothing to spec
}
