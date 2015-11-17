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
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.fx.ui.controls.filesystem.DirItem;
import org.eclipse.fx.ui.controls.filesystem.DirectoryTreeView;
import org.eclipse.fx.ui.controls.filesystem.ResourceEvent;
import org.eclipse.fx.ui.controls.filesystem.ResourceItem;
import org.eclipse.fx.ui.controls.tree.LazyTreeItem;
import org.eclipse.fx.ui.controls.tree.SimpleTreeCell;
import org.eclipse.jdt.annotation.NonNull;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * Skin for {@link DirectoryTreeView}
 *
 * @since 1.2
 */
public class DirectoryTreeViewSkin extends
		SkinBase<DirectoryTreeView> {

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
		super(control);
		this.selectedItems = selectedItems;
		this.tree = new TreeView<>();
		this.tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.tree.setCellFactory((v) -> new SimpleTreeCell<@NonNull DirItem>(
				DirectoryTreeViewSkin::handleDirLabel, this::handleStyleclass));
		this.tree.setShowRoot(false);
		this.tree.getSelectionModel().getSelectedItems()
				.addListener(this::handleSelectionChange);
		this.tree.setOnMouseClicked( e -> {
			if( e.getClickCount() > 1 ) {
				openSelectedResources();
			}
		});
		getChildren().add(this.tree);

		control.rootDirectoriesProperty().addListener(this::rebuildTable);
		control.iconSizeProperty().addListener(this::rebuildTable);
		rebuildTable(control.rootDirectoriesProperty());
	}

	private void openSelectedResources() {
		Event.fireEvent(getSkinnable(), ResourceEvent.createOpenResource(
				getSkinnable(), getSkinnable().getSelectedItems()));
	}

	private static String handleDirLabel(DirItem e) {
		return e.getName();
	}

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
			item.getChildren().addListener(this::handleListModification);
		}

		private void handleListModification(
				Change<? extends ResourceItem> change) {
			if( ! Platform.isFxApplicationThread() ) {
				Platform.runLater(() -> _handleListModification(change));
			} else {
				_handleListModification(change);
			}
		}

		private void _handleListModification(Change<? extends ResourceItem> change) {
			while (change.next()) {
				if (change.wasRemoved()) {
					Map<DirItem, TreeItem<DirItem>> map = getChildren().stream().collect(Collectors.toMap( c -> c.getValue(), c -> c));
					List<TreeItem<DirItem>> itemsToRemove = change.getRemoved().stream().filter( c -> map.containsKey(c)).map(c -> map.get(c)).collect(Collectors.toList());
					getChildren().removeAll(itemsToRemove);
				}

				if (change.wasAdded()) {
					getChildren().addAll(
							change.getAddedSubList().stream()
									.filter(c -> c instanceof DirItem)
									.map((c) -> new DirTreeItem((DirItem) c))
									.collect(Collectors.toList()));
				}

			}
		}
	}

}
