/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.tree;

import java.util.List;
import java.util.function.Function;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 * A tree item which is populated lazy
 *
 * @param <T>
 *            the domain value type
 * @since 1.2
 */
public class LazyTreeItem<T> extends TreeItem<T> {
	private boolean hasLoaded;

	/**
	 * Create a lazy tree item
	 *
	 * @param value
	 *            the domain value
	 * @param listCreator
	 *            the creator
	 */
	public LazyTreeItem(T value,
			Function<TreeItem<T>, List<TreeItem<T>>> listCreator) {
		super(value);
		getChildren().add(new TreeItem<>());

		expandedProperty().addListener((o) -> {
			if (isExpanded()) {
				if (!this.hasLoaded) {
					List<TreeItem<T>> list = listCreator.apply(this);
					if( list instanceof ObservableList<?> ) {
						getChildren().clear();
						Bindings.bindContent(getChildren(), (ObservableList<TreeItem<T>>)list);
					} else {
						getChildren().setAll(list);
					}
					this.hasLoaded = true;
				}
			}
		});
	}
}
