/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.fx.ui.controls.filesystem.FileItem;
import org.eclipse.fx.ui.controls.filesystem.ResourceEvent;
import org.eclipse.fx.ui.controls.filesystem.ResourceItem;
import org.eclipse.fx.ui.controls.filesystem.ResourceTreeView;
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
public class ResourceTreeViewSkin extends
		SkinBase<ResourceTreeView> {

	private final TreeView<@NonNull ResourceItem> tree;

	private final ObservableList<ResourceItem> selectedItems;

	/**
	 * Create a new skin
	 *
	 * @param control
	 *            the control
	 * @param selectedItems
	 *            the selected items
	 */
	public ResourceTreeViewSkin(ResourceTreeView control,
			ObservableList<ResourceItem> selectedItems) {
		super(control);
		this.selectedItems = selectedItems;
		this.tree = new TreeView<>();
		this.tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.tree.setCellFactory((v) -> new SimpleTreeCell<@NonNull ResourceItem>(
				ResourceTreeViewSkin::handleDirLabel, this::handleStyleclass));
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

	private static String handleDirLabel(ResourceItem e) {
		return e.getName();
	}

	private void handleSelectionChange(Observable o) {
		this.selectedItems.setAll(this.tree.getSelectionModel()
				.getSelectedItems().stream().map(t -> t.getValue())
				.collect(Collectors.toList()));
	}

	@SuppressWarnings("null")
	private @NonNull List<@NonNull String> handleStyleclass(ResourceItem e) {
		if( e instanceof DirItem ) {
			switch (getSkinnable().getIconSize()) {
			case SMALL:
				return Collections.singletonList("folderSmall"); //$NON-NLS-1$
			case MEDIUM:
				return Collections.singletonList("folderMedium"); //$NON-NLS-1$
			default:
				return Collections.singletonList("folderBig"); //$NON-NLS-1$
			}
		} else {
			switch (getSkinnable().getIconSize()) {
			case SMALL:
				return Collections.singletonList("fileSmall"); //$NON-NLS-1$
			case MEDIUM:
				return Collections.singletonList("fileMedium"); //$NON-NLS-1$
			default:
				return Collections.singletonList("fileBig"); //$NON-NLS-1$
			}
		}
	}

	private void rebuildTable(Observable o) {
		if (getSkinnable().getRootDirectories() == null) {
			this.tree.setRoot(new TreeItem<>());
		} else {
			TreeItem<@NonNull ResourceItem> root = new TreeItem<>();
			root.getChildren().setAll(
					getSkinnable().getRootDirectories().stream()
							.map((d) -> new DirTreeItem(d))
							.collect(Collectors.toList()));
			this.tree.setRoot(root);
		}
	}

	static Function<TreeItem<ResourceItem>, List<TreeItem<ResourceItem>>> FACTORY = (p) -> {
		return FXCollections.observableArrayList(((DirItem)p.getValue()).getChildren()
				.stream()
				.map((c) -> {
					if( c instanceof DirItem ) {
						return new DirTreeItem((DirItem) c);
					} else {
						return new FileTreeItem(c);
					}

				})
				.collect(Collectors.toList()));
	};

	static class FileTreeItem extends TreeItem<ResourceItem> {

		public FileTreeItem(ResourceItem value) {
			super(value);
		}

	}

	static class DirTreeItem extends LazyTreeItem<ResourceItem> {
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
					Map<ResourceItem, TreeItem<ResourceItem>> map = getChildren().stream().collect(Collectors.toMap( c -> c.getValue(), c -> c));
					List<TreeItem<ResourceItem>> itemsToRemove = change.getRemoved().stream().filter( c -> map.containsKey(c)).map(c -> map.get(c)).collect(Collectors.toList());
					getChildren().removeAll(itemsToRemove);
				}

				if (change.wasAdded()) {
					getChildren().addAll(
							change.getAddedSubList().stream()
									.filter(c -> c instanceof DirItem)
									.map((c) -> new DirTreeItem((DirItem) c))
									.collect(Collectors.toList()));
					getChildren().addAll(change.getAddedSubList().stream()
							.filter(c -> c instanceof FileItem)
							.map((c) -> new FileTreeItem((FileItem) c))
							.collect(Collectors.toList()));
				}

			}
		}
	}

}
