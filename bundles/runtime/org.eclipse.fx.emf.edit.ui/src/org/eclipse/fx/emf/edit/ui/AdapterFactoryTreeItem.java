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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	final ObservableList<TreeItem<Object>> children;
	final ITreeItemContentProvider provider;

	/**
	 * Create a new instance
	 * 
	 * @param object
	 *            the object
	 * @param adapterFactory
	 *            the factory
	 */
	public AdapterFactoryTreeItem(Object object, AdapterFactory adapterFactory) {
		super(object);
		this.adapterFactory = adapterFactory;
		this.children = FXCollections.unmodifiableObservableList(super.getChildren());

		Object adapter = adapterFactory.adapt(object, ITreeItemContentProvider.class);
		this.provider = (adapter instanceof ITreeItemContentProvider) ? (ITreeItemContentProvider) adapter : null;

		if (object instanceof Notifier) {
			((Notifier) object).eAdapters().add(new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if (!msg.isTouch() && msg.getFeature() instanceof EReference)
						updateChildren(msg);
				}
			});
		}

		initializeChildren();
	}

	/**
	 * This method overrides {@link TreeItem#getChildren()} and returns an unmodifiable {@link ObservableList}
	 * as the children may only be changed via the underlying model.
	 */
	@Override
	public ObservableList<TreeItem<Object>> getChildren() {
		return this.children;
	}
	
	void initializeChildren() {
		if (this.provider == null)
			return;

		// add the tree items
		for (Object child : this.provider.getChildren(getValue())) {
			addNewChild(child, Notification.NO_INDEX);
		}
	}

	void updateChildren(Notification msg) {
		ObservableList<TreeItem<Object>> childTreeItems = super.getChildren();
		
		switch (msg.getEventType()) {
		case Notification.ADD:
			addNewChild(msg.getNewValue(), msg.getPosition());
			break;
		case Notification.ADD_MANY:
			List<?> newValues = (List<?>) msg.getNewValue();
			int position = msg.getPosition();
			if (position != Notification.NO_INDEX && position <= childTreeItems.size()) {
				// reverse List, so items are added at correct position in backward order
				Collections.reverse(newValues); 
			}
			newValues.forEach(newValue -> {
				addNewChild(newValue, position);
			});
			break;
		case Notification.REMOVE:
			removeChild(msg.getOldValue());
			break;
		case Notification.REMOVE_MANY:
			List<?> oldValues = (List<?>) msg.getOldValue();
			oldValues.forEach(oldValue -> {
				removeChild(oldValue);
			});
			break;
		case Notification.SET:
			childTreeItems.clear();
			initializeChildren();
			break;
		case Notification.RESOLVE:
			initializeChildren();
			break;
		case Notification.MOVE:
			int index = ((Integer)msg.getOldValue()).intValue();
			if (index >= 0 && index < childTreeItems.size()) {
				TreeItem<Object> treeItem = childTreeItems.get(index);
				childTreeItems.remove(treeItem);
				childTreeItems.add(msg.getPosition(), treeItem);
			}
			break;
		}
	}

	private void addNewChild(Object value, int position) {
		ObservableList<TreeItem<Object>> childTreeItems = super.getChildren();
		AdapterFactoryTreeItem newTreeItem = new AdapterFactoryTreeItem(value, this.adapterFactory);
		if (position == Notification.NO_INDEX || position > childTreeItems.size()) {
			childTreeItems.add(newTreeItem);
		} else {
			childTreeItems.add(position, newTreeItem);
		}
	}
	
	private void removeChild(Object value) {
		TreeItem<Object> treeItem = findTreeItemForValue(value);
		if (treeItem != null) {
			super.getChildren().remove(treeItem);
		}
	}

	private TreeItem<Object> findTreeItemForValue(Object value) {
		Optional<TreeItem<Object>> first = super.getChildren().stream().filter(item -> {
			return item.getValue().equals(value);
		}).findFirst();
		return first.orElse(null);
	}

}
