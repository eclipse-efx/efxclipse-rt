/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.core.databinding;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;

/**
 * Observable value which can be modified as well
 * 
 * @param <E> the type
 */
public interface ObservableWritableValue<E> extends ObservableValue<E>, WritableValue<E> {
	// no additional methods
}
