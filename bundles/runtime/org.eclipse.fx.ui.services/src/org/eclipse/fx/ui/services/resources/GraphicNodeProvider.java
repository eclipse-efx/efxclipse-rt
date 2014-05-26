/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.resources;

import java.io.IOException;
import java.util.List;

import javafx.scene.Node;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Provider who translates a url into a node
 */
public interface GraphicNodeProvider {
	/**
	 * @return the name
	 */
	@NonNull
	public String getName();

	/**
	 * @return the file suffixes supported
	 */
	@NonNull
	public List<@NonNull String> getFileSuffix();

	/**
	 * Load the graphic node
	 * 
	 * @param uri
	 *            the uri
	 * @return the node
	 * @throws IOException
	 *             if loading fails
	 */
	@NonNull
	public Node getGraphicNode(URI uri) throws IOException;
}
