/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image;

import org.eclipse.jdt.annotation.NonNull;

import javafx.scene.Node;

/**
 * Provider who translates a url into a node
 *
 * @since 3.0
 */
public interface GraphicNodeProvider {
	/**
	 * @return the name
	 */
	@NonNull
	public String getName();

	/**
	 * Check if the URL is handled
	 *
	 * @param url
	 *            the url
	 * @return <code>true</code> if the URL is handled
	 */
	public boolean handles(String url);

	/**
	 * Load the graphic node
	 *
	 * @param uri
	 *            the uri
	 * @return the node
	 */
	@NonNull
	public Node getGraphicNode(String uri);
}
