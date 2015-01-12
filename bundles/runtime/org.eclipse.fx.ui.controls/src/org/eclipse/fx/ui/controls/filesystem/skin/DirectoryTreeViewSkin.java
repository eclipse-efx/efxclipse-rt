/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.filesystem.skin;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import org.eclipse.fx.ui.controls.filesystem.DirItem;
import org.eclipse.fx.ui.controls.filesystem.DirectoryTreeView;
import org.eclipse.fx.ui.controls.filesystem.behavior.DirectoryTreeViewBehavior;
import org.eclipse.fx.ui.controls.tree.LazyTreeItem;
import org.eclipse.fx.ui.controls.tree.SimpleTreeCell;
import org.eclipse.jdt.annotation.NonNull;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;

/**
 * Skin for {@link DirectoryTreeView}
 *
 * @since 1.2
 */
@SuppressWarnings("restriction")
public class DirectoryTreeViewSkin extends
		BehaviorSkinBase<DirectoryTreeView, DirectoryTreeViewBehavior> {

	private final TreeView<@NonNull DirItem> tree;

	private final ObservableList<DirItem> selectedItems;

	/**
	 * Create a new skin
	 *
	 * @param control
	 *            the control
	 * @param selectedItems
	 *            the selected items
	 */
	public DirectoryTreeViewSkin(DirectoryTreeView control,
			ObservableList<DirItem> selectedItems) {
		super(control, new DirectoryTreeViewBehavior(control));
		this.selectedItems = selectedItems;
		this.tree = new TreeView<>();
		this.tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.tree.setCellFactory((v) -> new SimpleTreeCell<@NonNull DirItem>(
				DirectoryTreeViewSkin::handleDirLabel, this::handleStyleclass));
		this.tree.setShowRoot(false);
		this.tree.getSelectionModel().getSelectedItems()
				.addListener(this::handleSelectionChange);
		getChildren().add(this.tree);

		control.rootDirectoriesProperty().addListener(this::rebuildTable);
		control.iconSizeProperty().addListener(this::rebuildTable);
		rebuildTable(control.rootDirectoriesProperty());
	}

	private static String handleDirLabel(DirItem e) {
		return e.getName();
	}

	@SuppressWarnings("null")
	private void handleSelectionChange(Observable o) {
		this.selectedItems.setAll(this.tree.getSelectionModel()
				.getSelectedItems().stream().map(t -> t.getValue())
				.collect(Collectors.toList()));
	}

	@SuppressWarnings("null")
	private @NonNull List<@NonNull String> handleStyleclass(DirItem e) {
		switch (getSkinnable().getIconSize()) {
		case SMALL:
			return Collections.singletonList("folderSmall"); //$NON-NLS-1$
		case MEDIUM:
			return Collections.singletonList("folderMedium"); //$NON-NLS-1$
		default:
			return Collections.singletonList("folderBig"); //$NON-NLS-1$
		}
	}

	private void rebuildTable(Observable o) {
		if (getSkinnable().getRootDirectories() == null) {
			this.tree.setRoot(new TreeItem<>());
		} else {
			TreeItem<@NonNull DirItem> root = new TreeItem<>();
			root.getChildren().setAll(
					getSkinnable().getRootDirectories().stream()
							.map((d) -> new DirTreeItem(d))
							.collect(Collectors.toList()));
			this.tree.setRoot(root);
		}
	}

	static Function<TreeItem<DirItem>, List<TreeItem<DirItem>>> FACTORY = (p) -> {
		return FXCollections.observableArrayList(p.getValue().getChildren()
				.stream().filter(c -> c instanceof DirItem)
				.map((c) -> new DirTreeItem((DirItem) c))
				.collect(Collectors.toList()));
	};

	static class DirTreeItem extends LazyTreeItem<DirItem> {
		public DirTreeItem(DirItem item) {
			super(item, FACTORY);
		}
	}

}
