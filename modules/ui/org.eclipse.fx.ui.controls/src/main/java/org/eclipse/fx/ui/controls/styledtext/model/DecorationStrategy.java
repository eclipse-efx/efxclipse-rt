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
package org.eclipse.fx.ui.controls.styledtext.model;

import org.eclipse.fx.ui.controls.styledtext.internal.TextNode;

import javafx.scene.layout.Pane;

/**
	 * A strategy to decorate the text
	 */
	public interface DecorationStrategy {
		/**
		 * Attach the decoration on the text
		 *
		 * @param node
		 *            the node the decoration is attached to
		 * @param textNode
		 *            the text node decorated
		 */
		public void attach(Pane node, TextNode textNode);

		/**
		 * Remove the decoration from the text
		 *
		 * @param node
		 *            the node the decoration is attached to
		 * @param textNode
		 *            the text node decorated
		 */
		public void unattach(Pane node, TextNode textNode);

		/**
		 * Layout the decoration
		 *
		 * @param node
		 *            the node the layout pass is done on
		 * @param textNode
		 *            the text node decorated
		 */
		public void layout(Pane node, TextNode textNode);
	}