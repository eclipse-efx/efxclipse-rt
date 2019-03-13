/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.test.rcontrol;

import org.eclipse.fx.test.rcontrol.Click.Clickable;
import org.eclipse.fx.test.rcontrol.Drag.Dragable;
import org.eclipse.fx.test.rcontrol.Move.Moveable;
import org.eclipse.fx.test.rcontrol.Type.Typable;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;

/**
 * Wrapper for a remote controlled node
 * 
 * @param <T>
 */
public interface RNode<T extends Node>
		extends Clickable<RNode<T>>, Moveable<RNode<T>>, Dragable<RNode<T>>, Typable<RNode<T>> {
	/**
	 * @return the {@link Node}
	 */
	public T node();

	/**
	 * @return try to focus the node
	 */
	public RNode<T> focus();

	/**
	 * @return center of the node in screen coordinates
	 */
	public Point2D center();

	/**
	 * Compute the location of the provided {@link Pos} in screen coordinates
	 * 
	 * @param position
	 *            the position in the node
	 * @return the location
	 */
	public Point2D location(Pos position);
}
