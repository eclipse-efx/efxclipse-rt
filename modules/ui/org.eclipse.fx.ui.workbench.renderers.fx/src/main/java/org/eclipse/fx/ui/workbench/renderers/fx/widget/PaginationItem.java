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
package org.eclipse.fx.ui.workbench.renderers.fx.widget;

import javafx.scene.Node;

/**
 * Pagination item
 */
public class PaginationItem {
	private Node content;

	/**
	 * @param content
	 *            the content
	 */
	public void setContent(Node content) {
		this.content = content;
	}

	/**
	 * @return the current content
	 */
	public Node getContent() {
		return this.content;
	}
}
