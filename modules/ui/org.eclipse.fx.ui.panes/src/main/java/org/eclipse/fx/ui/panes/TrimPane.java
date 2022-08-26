/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
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

import javafx.beans.property.ObjectProperty;
import javafx.scene.Node;
import javafx.scene.layout.Region;

/**
 * A pane with trims
 * 
 * @since 3.5.0
 */
public interface TrimPane {
	/**
	 * @return property with the node rendered at the top
	 */
	public ObjectProperty<Node> topProperty();

	/**
	 * @return the top node
	 */
	public Node getTop();

	/**
	 * Set a new top node
	 * 
	 * @param top the top node
	 */
	public void setTop(final Node top);

	/**
	 * @return property with the node rendered at the bottom
	 */
	public ObjectProperty<Node> bottomProperty();

	/**
	 * @return the bottom node
	 */
	public Node getBottom();

	/**
	 * Set a new bottom node
	 * 
	 * @param bottom the bottom node
	 */
	public void setBottom(final Node bottom);

	/**
	 * @return property with the node rendered to the left
	 */
	public ObjectProperty<Node> leftProperty();

	/**
	 * @return the left node
	 */
	public Node getLeft();

	/**
	 * Set a new left node
	 * 
	 * @param left the left node
	 */
	public void setLeft(final Node left);

	/**
	 * @return property with the node rendered to the right
	 */
	public ObjectProperty<Node> rightProperty();

	/**
	 * @return the right node
	 */
	public Node getRight();

	/**
	 * Set a new right node
	 * 
	 * @param right the new right node
	 */
	public void setRight(final Node right);

	/**
	 * @return property with the node rendered in the center
	 */
	public ObjectProperty<Node> centerProperty();

	/**
	 * @return the center node
	 */
	public Node getCenter();

	/**
	 * Set a new center node
	 * 
	 * @param center the center code
	 */
	public void setCenter(final Node center);

	/**
	 * @return the pane rendering
	 */
	public Region getPane();
}
