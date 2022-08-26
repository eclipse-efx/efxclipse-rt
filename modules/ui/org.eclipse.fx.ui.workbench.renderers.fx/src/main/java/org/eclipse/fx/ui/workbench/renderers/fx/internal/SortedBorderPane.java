/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Christoph Caks <christoph.caks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import org.eclipse.fx.core.bindings.FXBindings;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

@SuppressWarnings("javadoc")
public class SortedBorderPane extends BorderPane {

	private ObservableList<Node> children;
	private ObservableList<Node> positioned;
	private ObservableList<Node> unpositioned;

	public SortedBorderPane() {
		this.positioned = new SortedList<>(new FilteredList<>(super.getChildren(), this::isPositioned), this::compare);
		this.unpositioned = new FilteredList<>(super.getChildren(), n -> !isPositioned(n));
		this.children = FXBindings.concat(this.positioned, this.unpositioned);
	}

	private boolean isLeft(Node node) {
		return getLeft() == node;
	}

	private boolean isTop(Node node) {
		return getTop() == node;
	}

	private boolean isRight(Node node) {
		return getRight() == node;
	}

	private boolean isBottom(Node node) {
		return getBottom() == node;
	}

	private boolean isCenter(Node node) {
		return getCenter() == node;
	}

	private boolean isPositioned(Node node) {
		return isTop(node) || isLeft(node) || isCenter(node) || isRight(node) || isBottom(node);
	}

	private int getWeight(Node node) {
		return 0 + (isTop(node) ? 5 : 0) + (isLeft(node) ? 4 : 0) + (isCenter(node) ? 3 : 0) + (isRight(node) ? 2 : 0) + (isBottom(node) ? 1 : 0);
	}

	private int compare(Node a, Node b) {
		return getWeight(b) - getWeight(a);
	}

	@Override
	public ObservableList<Node> getChildrenUnmodifiable() {
		return this.children;
	}
}