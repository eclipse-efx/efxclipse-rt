/*******************************************************************************
 * Copyright (c) 2015 EM-SOFTWARE and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.tree;

import java.util.HashSet;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.CheckBoxTreeItem.TreeModificationEvent;
import javafx.scene.control.TreeItem;

/**
 * This class provides the possibility to collect all the values of "checked"
 * tree items of any root {@link CheckBoxTreeItem}. This collection is presented
 * as a flat {@link ObservableSet}.
 * 
 * The "checked" state of a tree item can be modified, by adding or removing its
 * value from {@link #getCheckedItems()}.
 *
 * @param <T>
 *            The type of the {@link TreeItem#getValue() value} property within
 *            {@link TreeItem}.
 */
public class CheckedTreeItemCollector<T> {

	private ObservableSet<T> checkedItems = FXCollections.observableSet(new HashSet<>());
	private CheckBoxTreeItem<T> root;

	/**
	 * @param root
	 *            The "checked" state of all the descendants, including the root
	 *            itself, will be monitored
	 */
	public CheckedTreeItemCollector(CheckBoxTreeItem<T> root) {
		this.root = root;
		root.addEventHandler(TreeModificationEvent.ANY, event -> {
			@SuppressWarnings("unchecked")
			TreeModificationEvent<T> mod = (TreeModificationEvent<T>) event;

			T value = mod.getTreeItem().getValue();
			boolean checked = mod.getTreeItem().isSelected();

			synchronized (this.checkedItems) {
				if (checked && !this.checkedItems.contains(value)) {
					this.checkedItems.add(value);
				} else if (!checked && this.checkedItems.contains(value)) {
					this.checkedItems.remove(value);
				}
			}
		});

		this.checkedItems.addListener((SetChangeListener<T>) change -> {
			if (change.getElementAdded() != null) {
				setCheckedStateForValue(root, change.getElementAdded(), true);
			}
			if (change.getElementRemoved() != null) {
				setCheckedStateForValue(root, change.getElementRemoved(), false);
			}
		});
	}

	private boolean setCheckedStateForValue(TreeItem<T> treeItem, T value, boolean state) {
		if (value.equals(treeItem.getValue())) {
			if (treeItem instanceof CheckBoxTreeItem) {
				setCheckedState((CheckBoxTreeItem<T>) treeItem, state);
			}
			return true;
		} else {
			for (TreeItem<T> child : treeItem.getChildren()) {
				if (setCheckedStateForValue(child, value, state)) {
					return true;
				}
			}
		}
		return false;
	}

	private void setCheckedStateRekursiv(TreeItem<T> treeItem, boolean state) {
		if (treeItem instanceof CheckBoxTreeItem) {
			setCheckedState((CheckBoxTreeItem<T>) treeItem, state);
		}
		treeItem.getChildren().forEach(child -> setCheckedStateRekursiv(child, state));
	}
	
	private void setCheckedState(CheckBoxTreeItem<T> root, boolean state) {
		if (Platform.isFxApplicationThread()) {
			root.setSelected(state);
		} else {
			Platform.runLater(() -> root.setSelected(state));
		}
	}
	
	/**
	 * Check all the items in the tree
	 */
	public void checkAll() {
		setCheckedStateRekursiv(this.root, true);
	}

	/**
	 * Uncheck all the items in the tree
	 */
	public void uncheckAll() {
		setCheckedStateRekursiv(this.root, false);
	}

	/**
	 * @return An {@link ObservableSet} of all the values who's tree items have
	 *         been "checked"
	 */
	public ObservableSet<T> getCheckedItems() {
		return this.checkedItems;
	}

}
