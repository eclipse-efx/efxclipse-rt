/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.context.spy.internal.view;

import java.util.stream.Collectors;

import org.eclipse.fx.tool.context.spy.internal.element.ContextOverviewElement;
import org.eclipse.fx.tool.context.spy.internal.model.ContextSpyModel;

import javafx.beans.binding.Bindings;
import javafx.css.PseudoClass;
import javafx.scene.Node;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * Hierarchical overview over all contexts of the current application.
 *
 */
class ContextOverview {

	private static final String OVERVIEW_SEARCH_RESULT_PSEUDOCLASS = "overviewsearchresult";

	private final ContextSpyModel contextSpyModel;

	private TreeView<ContextOverviewElement> contextHierarchyTreeView;

	/**
	 * Main constructor.
	 * 
	 * @param contextSpyModel
	 */
	ContextOverview(ContextSpyModel contextSpyModel) {
		this.contextSpyModel = contextSpyModel;
	}

	/**
	 * Returns the gui element.
	 * 
	 * @return
	 */
	Node getGui() {
		if (contextHierarchyTreeView == null) {
			createGui();
		}
		return contextHierarchyTreeView;
	}

	private void createGui() {
		contextHierarchyTreeView = new TreeView<>();

		contextHierarchyTreeView.rootProperty().bind(Bindings.createObjectBinding(() -> {
			return recreateTreeRoot();
		}, contextSpyModel.contextObjectProperty()));

		contextHierarchyTreeView.getSelectionModel().selectedItemProperty().addListener((event, oldv, newv) -> {
			contextSpyModel.setSelectedContextTreeElement((newv != null) ? newv.getValue() : null);
		});

		contextHierarchyTreeView.setCellFactory(tv -> new TreeCell<ContextOverviewElement>() {

			@Override
			public void updateItem(ContextOverviewElement item, boolean empty) {
				super.updateItem(item, empty);
				pseudoClassStateChanged(PseudoClass.getPseudoClass(OVERVIEW_SEARCH_RESULT_PSEUDOCLASS), false);
				if (empty) {
					textProperty().unbind();
					setText("");
				} else {
					textProperty().bind(Bindings.createStringBinding(() -> {
						pseudoClassStateChanged(PseudoClass.getPseudoClass(OVERVIEW_SEARCH_RESULT_PSEUDOCLASS),
								item.markedAsSearchResultProperty().getValue() == Boolean.TRUE);
						return item.toString();
					}, item.markedAsSearchResultProperty()));					
				}
			}
		});
	}

	private TreeItem<ContextOverviewElement> recreateTreeRoot() {
		return createTreeItem(contextSpyModel.contextObjectProperty().get());
	}

	private TreeItem<ContextOverviewElement> createTreeItem(ContextOverviewElement element) {
		TreeItem<ContextOverviewElement> item = new TreeItem<>(element);
		item.expandedProperty().bindBidirectional(element.expandedProperty());

		item.getChildren()
				.addAll(element.getChildren().stream().map(this::createTreeItem).collect(Collectors.toList()));
		return item;
	}

}
