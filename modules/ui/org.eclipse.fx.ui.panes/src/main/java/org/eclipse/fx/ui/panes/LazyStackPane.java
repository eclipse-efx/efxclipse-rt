/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
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
package org.eclipse.fx.ui.panes;

import java.util.function.Predicate;

import javafx.beans.value.WritableValue;
import javafx.scene.layout.StackPane;

/**
 * A {@link StackPane} who is able break the recursive CSS & Layout-Pass call
 * chain
 */
public class LazyStackPane extends StackPane {
	/**
	 * The check type
	 */
	public enum CheckType {
		/**
		 * Should a layout pass be forwarded
		 */
		LAYOUT,
		/**
		 * Should a css pass be forwarded
		 */
		CSS
	}

	private Predicate<CheckType> checkSupplier;

	/**
	 * Create a pane who can optimize CSS & Layout-Passes
	 *
	 * @param checkSupplier
	 *            the supplier
	 */
	public LazyStackPane(Predicate<CheckType> checkSupplier) {
		this.checkSupplier = checkSupplier;
	}

//FIXME see how to port to JavaFX 11+
//	@SuppressWarnings("deprecation")
//	protected void impl_processCSS(WritableValue<Boolean> unused) {
//		if (this.checkSupplier.test(CheckType.CSS)) {
//			super.impl_processCSS(unused);
//		}
//
//	}

	@Override
	protected void layoutChildren() {
		if (this.checkSupplier.test(CheckType.LAYOUT)) {
			super.layoutChildren();
		}
	}
}
