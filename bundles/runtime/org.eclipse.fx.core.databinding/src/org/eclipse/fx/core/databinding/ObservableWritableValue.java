/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
