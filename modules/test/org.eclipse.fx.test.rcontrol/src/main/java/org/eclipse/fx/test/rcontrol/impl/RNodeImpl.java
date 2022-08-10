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
package org.eclipse.fx.test.rcontrol.impl;

import java.time.Duration;

import org.eclipse.fx.test.rcontrol.Click;
import org.eclipse.fx.test.rcontrol.Drag;
import org.eclipse.fx.test.rcontrol.Move;
import org.eclipse.fx.test.rcontrol.RController;
import org.eclipse.fx.test.rcontrol.RNode;
import org.eclipse.fx.test.rcontrol.Type;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;

@SuppressWarnings("javadoc")
public class RNodeImpl<T extends Node> implements RNode<T> {
	private final T node;
	private final RController controller;
	
	public RNodeImpl(T node, RController controller) {
		this.node = node;
		this.controller = controller;
	}
	
	public T node() {
		return node;
	}
	
	@Override
	public RNode<T> focus() {
		node.requestFocus();
		return this;
	}

	private RNode<T> _click(MouseButton button) {
		moveToCenter();
		controller.run(Click.click(button));
		return this;
	}
	
	private RNode<T> _click(MouseButton button, double x, double y) {
		controller.run(Click.click(button, x, y));
		return this;
	}
	
	@Override
	public RNode<T> click() {
		return _click(MouseButton.PRIMARY);
	}
	
	@Override
	public RNode<T> click(MouseButton button) {
		return _click(button);
	}
	
	@Override
	public RNode<T> click(double x, double y) {
		return _click(MouseButton.PRIMARY, x, y);
	}
		
	@Override
	public RNode<T> click(MouseButton button, double x, double y) {
		return _click(button, x, y);
	}
	
	@Override
	public RNode<T> doubleClick() {
		return doubleClick(MouseButton.PRIMARY);
	}
	
	@Override
	public RNode<T> doubleClick(MouseButton button) {
		_click(button);
		_click(button);
		return this;
	}
	
	@Override
	public RNode<T> doubleClick(double x, double y) {
		return doubleClick(MouseButton.PRIMARY, x, y);
	}
		
	@Override
	public RNode<T> doubleClick(MouseButton button, double x, double y) {
		_click(button,x,y);
		_click(button,x,y);
		return this;
	}
	
	@Override
	public RNode<T> moveToCenter() {
		Bounds bounds = node.getBoundsInLocal();
		moveTo(bounds.getWidth() / 2, bounds.getHeight() / 2);
		return this;
	}
	
	@Override
	public RNode<T> moveTo(double x, double y) {
		Bounds bounds = node.localToScreen(node.getBoundsInLocal());
		controller.run(Move.to(bounds.getMinX() + x, bounds.getMinY() + y));
		return this;
	}
	
	@Override
	public RNode<T> moveToCenter(Duration d) {
		Bounds bounds = node.getBoundsInLocal();
		return moveTo(d, bounds.getWidth() / 2, bounds.getHeight() / 2);
	}
	
	@Override
	public RNode<T> moveTo(Duration d, double x, double y) {
		Bounds bounds = node.localToScreen(node.getBoundsInLocal());
		controller.run(Move.to(d,bounds.getMinX() + x, bounds.getMinY() + y));
		return null;
	}
	
	@Override
	public RNode<T> moveTo(Duration d, Pos referencePoint, double _x, double _y) {
		double x;
		double y;
		
		Bounds bounds = node.localToScreen(node.getBoundsInLocal());
		switch (referencePoint.getHpos()) {
		case CENTER:
			x = bounds.getMinX() + bounds.getWidth()/2;
			break;
		case RIGHT:
			x = bounds.getMaxX();
			break;
		default:
			x = bounds.getMinX();
			break;
		}
		
		switch (referencePoint.getVpos()) {
		case BOTTOM:
		case BASELINE:
			y = bounds.getMaxY();
			break;
		case CENTER:
			y = bounds.getMinY() + bounds.getHeight()/2;
			break;
		default:
			y = bounds.getMinY();
			break;
		}
		
		controller.run(Move.to(d, x+_x, y+_y));
		return this;
	}
	
	@Override
	public RNode<T> moveTo(Pos referencePoint, double _x, double _y) {
		double x;
		double y;
		
		Bounds bounds = node.localToScreen(node.getBoundsInLocal());
		switch (referencePoint.getHpos()) {
		case CENTER:
			x = bounds.getMinX() + bounds.getWidth()/2;
			break;
		case RIGHT:
			x = bounds.getMaxX();
			break;
		default:
			x = bounds.getMinX();
			break;
		}
		
		switch (referencePoint.getVpos()) {
		case BOTTOM:
		case BASELINE:
			y = bounds.getMaxY();
			break;
		case CENTER:
			y = bounds.getMinY() + bounds.getHeight()/2;
			break;
		default:
			y = bounds.getMinY();
			break;
		}
		
		controller.run(Move.to(x+_x, y+_y));
		return this;
	}
	
	@Override
	public RNode<T> dragTo(double x, double y) {
		Bounds bounds = node.localToScreen(node.getBoundsInLocal());
		controller.run(Drag.to(bounds.getWidth() / 2, bounds.getHeight() / 2, x, y));
		return this;
	}
	
	@Override
	public RNode<T> dragTo(Duration d, double x, double y) {
		Bounds bounds = node.localToScreen(node.getBoundsInLocal());
		controller.run(Drag.to(d, bounds.getWidth() / 2, bounds.getHeight() / 2, x, y));
		return this;
	}

	@Override
	public RNode<T> dragBy(double dx, double dy) {
		Bounds bounds = node.localToScreen(node.getBoundsInLocal());
		controller.run(Drag.by( bounds.getMinX() + bounds.getWidth() / 2, bounds.getMinY() + bounds.getHeight() / 2, dx, dy));
		return this;
	}
	
	@Override
	public RNode<T> dragBy(Duration d, double dx, double dy) {
		Bounds bounds = node.localToScreen(node.getBoundsInLocal());
		controller.run(Drag.by(d, bounds.getMinX() + bounds.getWidth() / 2, bounds.getMinY() + bounds.getHeight() / 2, dx, dy));
		return this;
	}

	@Override
	public RNode<T> typeText(String text) {
		focus();
		controller.run(Type.text(text));
		return this;
	}
	
	@Override
	public Point2D center() {
		Bounds bounds = node.localToScreen(node.getBoundsInLocal());
		return new Point2D(bounds.getMinX() + bounds.getWidth()/2, bounds.getMinY() + bounds.getHeight()/2);
	}
	
	@Override
	public Point2D location(Pos position) {
		double x;
		double y;
		
		Bounds bounds = node.localToScreen(node.getBoundsInLocal());
		switch (position.getHpos()) {
		case CENTER:
			x = bounds.getMinX() + bounds.getWidth()/2;
			break;
		case RIGHT:
			x = bounds.getMaxX();
			break;
		default:
			x = bounds.getMinX();
			break;
		}
		
		switch (position.getVpos()) {
		case BOTTOM:
		case BASELINE:
			y = bounds.getMaxY();
			break;
		case CENTER:
			y = bounds.getMinY() + bounds.getHeight()/2;
			break;
		default:
			y = bounds.getMinY();
			break;
		}
		return new Point2D(x, y);
	}
}
