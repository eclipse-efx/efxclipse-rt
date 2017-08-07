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
package org.eclipse.fx.ui.workbench.renderers.fx.widget;

import javafx.scene.Node;

/**
 * Implementation of a perspective stack item
 */
public class PerspectiveStackItem {
	private Node content;
	private Runnable runnable;

	/**
	 * @return the content
	 */
	public Node getContent() {
		if (this.content == null) {
			if (this.runnable != null) {
				this.runnable.run();
			}
		}
		return this.content;
	}

	/**
	 * @param runnable
	 *            callback to run on init
	 */
	public void setInitRunnable(Runnable runnable) {
		this.runnable = runnable;
	}

	/**
	 * @param content
	 *            the cotent node
	 */
	public void setContent(Node content) {
		this.content = content;
	}
}
