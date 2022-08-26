/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.databinding.internal;

import org.eclipse.core.databinding.observable.value.IObservableValue;

import javafx.beans.Observable;
import javafx.scene.Node;

@SuppressWarnings("javadoc")
public class ControlDelayedObservableValueDecorator<T> extends ControlObservableValueDecorator<T> {
	private final Node control;

	public ControlDelayedObservableValueDecorator(IObservableValue<T> decorated, Node control) {
		super(decorated);
		this.control = control;
		control.focusedProperty().addListener( this::handleFocusChange );
	}

	private void handleFocusChange(Observable o) {
		if( ! this.control.focusedProperty().get()
				&& isStale() ) {
			getValue();
		}
	}


	@Override
	public synchronized void dispose() {
		this.control.focusedProperty().removeListener(this::handleFocusChange);
		super.dispose();
	}
}
