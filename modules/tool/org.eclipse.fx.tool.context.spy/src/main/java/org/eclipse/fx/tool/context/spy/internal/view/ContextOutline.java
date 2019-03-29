/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.context.spy.internal.view;

import java.util.stream.Collectors;

import org.eclipse.fx.tool.context.spy.internal.element.ContextOutlineElement;
import org.eclipse.fx.tool.context.spy.internal.model.ContextSpyModel;

import javafx.beans.binding.Bindings;
import javafx.css.PseudoClass;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * View for presenting an outline of a selected context.
 * 
 * This outline is also hierarchical.
 *
 */
class ContextOutline {

	private static final String OUTLINE_SEARCHRESULT_PSEUDOCLASS = "outlinesearchresult";

	private TreeTableView<ContextOutlineElement> treeTableView;

	private final ContextSpyModel contextSpyModel;

	/**
	 * Main constructor.
	 * 
	 * @param contextSpyModel
	 */
	ContextOutline(ContextSpyModel contextSpyModel) {
		this.contextSpyModel = contextSpyModel;
	}

	/**
	 * Returns the gui element.
	 * 
	 * @return
	 */
	Node getGui() {
		if (treeTableView == null) {
			createGui();
		}
		return treeTableView;
	}

	private void createGui() {
		treeTableView = new TreeTableView<>();

		TreeTableColumn<ContextOutlineElement, ContextOutlineElement.Wrap> keyColumn = new TreeTableColumn<>("Key");
		keyColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("key"));
		treeTableView.getColumns().add(keyColumn);
		TreeTableColumn<ContextOutlineElement, ContextOutlineElement.Wrap> valueColumn = new TreeTableColumn<>("Value");
		valueColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("value"));
		treeTableView.getColumns().add(valueColumn);

		treeTableView.setShowRoot(false);

		treeTableView.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);
		treeTableView.rootProperty().bind(Bindings.createObjectBinding(() -> {

			TreeItem<ContextOutlineElement> root = new TreeItem<>();
			root.setExpanded(true);
			root.getChildren().clear();
			root.getChildren().addAll(contextSpyModel.getContextOutlineElements().stream().map(this::createTreeItem)
					.collect(Collectors.toList()));

			return root;

		}, contextSpyModel.getContextOutlineElements()));

		treeTableView.getColumns().stream().map(TreeTableColumn.class::cast).forEach(column -> column
				.setCellFactory(tv -> new TextFieldTreeTableCell<ContextOutlineElement, ContextOutlineElement.Wrap>() {

					@Override
					public void updateItem(ContextOutlineElement.Wrap item, boolean empty) {

						textProperty().unbind();
						pseudoClassStateChanged(PseudoClass.getPseudoClass(OUTLINE_SEARCHRESULT_PSEUDOCLASS), false);
						setTooltip(null);
						super.updateItem(item, empty);
						if (item != null) {
							String tooltipText = item.getWrapped().getTooltipText();
							if (tooltipText != null && tooltipText.trim().length() > 0) {
								setTooltip(new Tooltip(item.getWrapped().getTooltipText()));
							}
						}
						if (item != null) {
							textProperty().bind(Bindings.createStringBinding(() -> {
								pseudoClassStateChanged(PseudoClass.getPseudoClass(OUTLINE_SEARCHRESULT_PSEUDOCLASS),
										item.getWrapped().markedAsSearchResultProperty().getValue() == Boolean.TRUE);
								return item.toString();
							}, item.getWrapped().markedAsSearchResultProperty()));
						}
					}
				}));
	}

	private TreeItem<ContextOutlineElement> createTreeItem(ContextOutlineElement element) {
		TreeItem<ContextOutlineElement> treeItem = new TreeItem<ContextOutlineElement>(element,
				new ImageView(new Image(getClass().getResourceAsStream(element.getImageURL()))));
		treeItem.setExpanded(true);
		treeItem.getChildren()
				.addAll(element.getChildren().stream().map(this::createTreeItem).collect(Collectors.toList()));
		return treeItem;
	}

}
