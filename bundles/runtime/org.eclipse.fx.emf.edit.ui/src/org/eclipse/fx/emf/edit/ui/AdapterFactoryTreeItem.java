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
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.IViewerNotification;

/**
 * A {@link TreeItem} that wraps an {@link AdapterFactory} and retrieves its
 * children from the adapter-implemented {@link ITreeItemContentProvider}
 * interface.
 * 
 * It is necessary to call {@link #dispose} on an instance to release the EMF
 * change listeners.
 */
public class AdapterFactoryTreeItem extends TreeItem<Object> {

	final private AdapterFactory adapterFactory;
	final private ObservableList<TreeItem<Object>> children;
	final private ITreeItemContentProvider provider;

	private AdapterImpl adapter = null;
	private INotifyChangedListener changeListener = null;

	/**
	 * Create a new instance. It is necessary to call {@link #dispose} on an
	 * instance to release the EMF change listeners.
	 * 
	 * @param value
	 *            the value of the tree item
	 * @param adapterFactory
	 *            the factory
	 */
	public AdapterFactoryTreeItem(Object value, AdapterFactory adapterFactory) {
		super(value);
		this.adapterFactory = adapterFactory;
		this.children = FXCollections.unmodifiableObservableList(super.getChildren());

		Object contentProvider = adapterFactory.adapt(value, ITreeItemContentProvider.class);
		if (contentProvider instanceof ITreeItemContentProvider) {
			this.provider = (ITreeItemContentProvider) contentProvider;
		} else {
			throw new IllegalArgumentException("Provided root object cannot be adapted."); //$NON-NLS-1$
		}

		if (this.provider instanceof IChangeNotifier) {
			((IChangeNotifier) this.provider).addListener(createNotifyChangedListener());
		} else if (value instanceof Notifier) {
			((Notifier) value).eAdapters().add(createAdapter());
		}

		initializeChildren();
	}

	private INotifyChangedListener createNotifyChangedListener() {
		if (this.changeListener == null) {
			this.changeListener = new INotifyChangedListener() {
				@Override
				public void notifyChanged(Notification msg) {
					if (!msg.isTouch() && msg.getFeature() instanceof EReference) {
						if (msg instanceof IViewerNotification) {
							processViewerNotification((IViewerNotification) msg);
						} else {
							updateChildren(msg);
						}
					}
				}

				private void processViewerNotification(IViewerNotification notification) {
					if (notification.getElement() == null)
						return;
					if (getValue().equals(notification.getElement())) {
						updateChildren(notification);
					}
				}
			};
		}
		return this.changeListener;
	}

	private AdapterImpl createAdapter() {
		if (this.adapter == null) {
			this.adapter = new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if (!msg.isTouch() && msg.getFeature() instanceof EReference)
						updateChildren(msg);
				}
			};
		}
		return this.adapter;
	}

	/**
	 * Remove the EMF change listeners
	 */
	public void dispose() {
		super.getChildren().forEach(childItem -> {
			((AdapterFactoryTreeItem) childItem).dispose();
		});
		if (this.changeListener != null) {
			((IChangeNotifier) this.provider).removeListener(this.changeListener);
		}
		if (this.adapter != null) {
			((Notifier) getValue()).eAdapters().remove(this.adapter);
		}
	}

	/**
	 * This method overrides {@link TreeItem#getChildren()} and returns an
	 * unmodifiable {@link ObservableList} as the children may only be changed
	 * via the underlying model.
	 */
	@Override
	public ObservableList<TreeItem<Object>> getChildren() {
		return this.children;
	}

	void initializeChildren() {
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
				// reverse List, so items are added at correct position in
				// backward order
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
			int index = ((Integer) msg.getOldValue()).intValue();
			if (index >= 0 && index < childTreeItems.size()) {
				TreeItem<Object> treeItem = childTreeItems.get(index);
				childTreeItems.remove(treeItem);
				childTreeItems.add(msg.getPosition(), treeItem);
			}
			break;
		}
	}

	private void addNewChild(Object value, int position) {
		if (!this.provider.getChildren(getValue()).contains(value))
			return;
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
			((AdapterFactoryTreeItem) treeItem).dispose();
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
