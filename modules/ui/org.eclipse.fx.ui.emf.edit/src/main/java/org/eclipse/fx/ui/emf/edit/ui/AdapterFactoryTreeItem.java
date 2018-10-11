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
package org.eclipse.fx.ui.emf.edit.ui;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
import org.eclipse.fx.ui.controls.tree.SortableTreeItem;

/**
 * A {@link TreeItem} that wraps an {@link AdapterFactory} and retrieves its
 * children from the adapter-implemented {@link ITreeItemContentProvider}
 * interface.
 * 
 * It is necessary to call {@link #dispose} on an instance to release the EMF
 * change listeners.
 * 
 * @param <T> type of elements in the tree
 */
public class AdapterFactoryTreeItem<T> extends SortableTreeItem<T> {

	final private AdapterFactory adapterFactory;
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
	public AdapterFactoryTreeItem(T value, AdapterFactory adapterFactory) {
		super(value);
		this.adapterFactory = adapterFactory;
		
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
		super.getInternalChildren().forEach(childItem -> {
			((AdapterFactoryTreeItem<T>) childItem).dispose();
		});
		if (this.changeListener != null) {
			((IChangeNotifier) this.provider).removeListener(this.changeListener);
		}
		if (this.adapter != null) {
			((Notifier) getValue()).eAdapters().remove(this.adapter);
		}
	}

	void initializeChildren() {
		for (Object child : this.provider.getChildren(getValue())) {
			addNewChild(child, Notification.NO_INDEX);
		}
	}

	void updateChildren(Notification msg) {
		ObservableList<TreeItem<T>> childTreeItems = super.getInternalChildren();

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
				TreeItem<T> treeItem = childTreeItems.get(index);
				childTreeItems.remove(treeItem);
				childTreeItems.add(msg.getPosition(), treeItem);
			}
			break;
		}
	}

	@SuppressWarnings("unchecked")
	private void addNewChild(Object value, int position) {
		if (!this.provider.getChildren(getValue()).contains(value))
			return;
		ObservableList<TreeItem<T>> childTreeItems = super.getInternalChildren();
		AdapterFactoryTreeItem<T> newTreeItem = new AdapterFactoryTreeItem<T>((T)value, this.adapterFactory);
		if (position == Notification.NO_INDEX || position > childTreeItems.size()) {
			childTreeItems.add(newTreeItem);
		} else {
			childTreeItems.add(position, newTreeItem);
		}
	}

	private void removeChild(Object value) {
		TreeItem<T> treeItem = findTreeItemForValue(value);
		if (treeItem != null) {
			((AdapterFactoryTreeItem<T>) treeItem).dispose();
			super.getInternalChildren().remove(treeItem);
		}
	}

	private TreeItem<T> findTreeItemForValue(Object value) {
		Optional<TreeItem<T>> first = super.getInternalChildren().stream().filter(item -> {
			return item.getValue().equals(value);
		}).findFirst();
		return first.orElse(null);
	}

}
