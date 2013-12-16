/******************************************************************************* 
 * Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation 
 *******************************************************************************/
package org.eclipse.fx.emf.edit.ui;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TreeItem;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * A {@link TreeItem} that wraps an {@link AdapterFactory} and retrieves its children from the
 * adapter-implemented {@link ITreeItemContentProvider} interface.
 */
public class AdapterFactoryTreeItem extends TreeItem<Object> {

	final AdapterFactory adapterFactory;
	final Control view;
	final ObservableList<TreeItem<Object>> children;
	final ITreeItemContentProvider provider;

	/**
	 * Create a new instance
	 * 
	 * @param object
	 *            the object
	 * @param treeView
	 *            the tree
	 * @param adapterFactory
	 *            the factory
	 */
	public AdapterFactoryTreeItem(Object object, Control treeView, AdapterFactory adapterFactory) {
		super(object);
		this.view = treeView;
		this.adapterFactory = adapterFactory;
		this.children = FXCollections.unmodifiableObservableList(super.getChildren());

		Object adapter = adapterFactory.adapt(object, ITreeItemContentProvider.class);
		this.provider = (adapter instanceof ITreeItemContentProvider) ? (ITreeItemContentProvider) adapter : null;

		if (object instanceof Notifier) {
			((Notifier) object).eAdapters().add(new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if (msg.getFeature() instanceof EReference)
						updateChildren();
				}

			});
		}

		updateChildren();
	}

	/**
	 * This method overrides {@link TreeItem#getChildren()} and returns an unmodifiable {@link ObservableList}
	 * as the children may only be changed via the underlying model.
	 */
	@Override
	public ObservableList<TreeItem<Object>> getChildren() {
		return this.children;
	}

	/**
	 * Recreates the child tree items using the {@link ITreeItemContentProvider} and restores the selection
	 * and expanded state of the tree items.
	 */
	void updateChildren() {
		ObservableList<TreeItem<Object>> childTreeItems = super.getChildren();

		MultipleSelectionModel<?> selectionModel = CellUtil.getSelectionModel(this.view);
		List<?> selection = selectionModel.getSelectedItems();
		ArrayList<Object> selectedItems = new ArrayList<>();
		ArrayList<TreeItem<?>> selectedTreeItems = new ArrayList<>();
		ArrayList<Object> expandedItems = new ArrayList<>();

		// remember the expanded items
		for (TreeItem<Object> childTreeItem : childTreeItems) {
			if (childTreeItem.isExpanded())
				expandedItems.add(childTreeItem.getValue());
		}

		// remember the selected items
		for (Object selectedTreeItem : selection) {
			for (TreeItem<Object> childTreeItem : childTreeItems) {
				if (selectedTreeItem == childTreeItem) {
					selectedTreeItems.add(childTreeItem);
					selectedItems.add(childTreeItem.getValue());
				}
			}
		}

		// clear the selection
		for (TreeItem<?> selectedTreeItem : selectedTreeItems) {
			int treeItemIndex = selectionModel.getSelectedItems().indexOf(selectedTreeItem);
			int selectionIndex = selectionModel.getSelectedIndices().get(treeItemIndex).intValue();
			selectionModel.clearSelection(selectionIndex);
		}

		// remove the old tree items
		childTreeItems.clear();

		if (this.provider == null)
			return;

		// add the new tree items
		for (Object child : this.provider.getChildren(getValue())) {
			AdapterFactoryTreeItem treeItem = new AdapterFactoryTreeItem(child, this.view, this.adapterFactory);

			childTreeItems.add(treeItem);

			// expand the new tree items
			if (expandedItems.contains(child))
				treeItem.setExpanded(true);

			// restore the selection
			if (selectedItems.contains(child) && "javafx.scene.control.TreeView$TreeViewBitSetSelectionModel".equals(selectionModel.getClass().getName())) { //$NON-NLS-1$
				try {
					Method m = selectionModel.getClass().getDeclaredMethod("select", new Class[] { TreeItem.class }); //$NON-NLS-1$
					m.setAccessible(true);
					m.invoke(selectionModel, treeItem);
				} catch (Exception e) {
					// do nothing
				}
			}
		}

	}

}
