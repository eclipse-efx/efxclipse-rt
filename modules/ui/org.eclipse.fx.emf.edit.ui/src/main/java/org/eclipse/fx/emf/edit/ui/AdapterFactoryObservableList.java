/******************************************************************************* 
 * Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0 
 * 
 * Contributors: 
 *     Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation 
 *******************************************************************************/
package org.eclipse.fx.emf.edit.ui;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.jdt.annotation.NonNull;

/**
 * This {@link ObservableList} wraps an {@link AdapterFactory} and retrieves its elements from the
 * adapter-implemented {@link IStructuredItemContentProvider} interface. The content of the list can only be
 * modified through changes to the underlying model.
 * 
 * @param <T>
 *            the type
 */
public class AdapterFactoryObservableList<T> implements ObservableList<T> {

	private static final String CHANGES_THROUGH_MODEL = "An AdapterFactoryObservableList cannot be manipulated directly. Changes must be made via the model."; //$NON-NLS-1$
	/**
	 * The adapter factory
	 */
	@NonNull
	protected final AdapterFactory adapterFactory;
	/**
	 * The to root
	 */
	@NonNull
	protected final Object root;
	/**
	 * The content provider
	 */
	@NonNull
	protected IStructuredItemContentProvider provider;
	/* package */final ObservableList<T> elements = FXCollections.observableArrayList();
	
	private INotifyChangedListener changeListener = null;
	private Adapter adapter = null;

	/**
	 * Create an adapter for a list
	 * 
	 * @param adapterFactory
	 *            the factory
	 * @param root
	 *            the root
	 */
	public AdapterFactoryObservableList(@NonNull AdapterFactory adapterFactory, @NonNull final Object root) {
		super();

		this.adapterFactory = adapterFactory;
		this.root = root;
		Object contentProvider = adapterFactory.adapt(root, IStructuredItemContentProvider.class);

		if (contentProvider instanceof IStructuredItemContentProvider)
			this.provider = (IStructuredItemContentProvider) contentProvider;
		else
			throw new IllegalArgumentException("Provided root object cannot be adapted."); //$NON-NLS-1$

		this.elements.addAll(getProviderElements());

		if (root instanceof Notifier) {
			((Notifier) root).eAdapters().add(createAdapter());
		} else if (root instanceof IChangeNotifier) {
			((IChangeNotifier) root).addListener(createChangedListener());
		}
	}

	private Adapter createAdapter() {
		if (this.adapter == null) {
			this.adapter = new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					updateInternalList(msg);
				}
			};
		}
		return this.adapter;
	}

	private INotifyChangedListener createChangedListener() {
		if (this.changeListener == null) {
			this.changeListener = new INotifyChangedListener() {
				@Override
				public void notifyChanged(Notification notification) {
					updateInternalList(notification);
				}
			};
		}
		return this.changeListener;
	}
	
	/**
	 * Remove the EMF change listeners
	 */
	public void dispose() {
		if (this.changeListener != null) {
			((IChangeNotifier) this.provider).removeListener(this.changeListener);
		}
		if (this.adapter != null) {
			((Notifier) this.root).eAdapters().remove(this.adapter);
		}
	}
	
	@SuppressWarnings("unchecked")
	private Collection<? extends T> getProviderElements() {
		return (Collection<? extends T>) this.provider.getElements(this.root);
	}
	
	void updateInternalList(Notification msg) {
		if (msg.isTouch())
			return;
		if (msg.getFeature() != null && !(msg.getFeature() instanceof EReference))
			return;
		
		switch (msg.getEventType()) {
		case Notification.ADD:
			addNewChild(msg.getNewValue(), msg.getPosition());
			break;
		case Notification.ADD_MANY:
			List<?> newValues = (List<?>) msg.getNewValue();
			int position = msg.getPosition();
			if (position != Notification.NO_INDEX && position <= this.elements.size()) {
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
		case Notification.RESOLVE:
			this.elements.setAll(getProviderElements());
			break;
		case Notification.MOVE:
			int index = ((Integer) msg.getOldValue()).intValue();
			if (index >= 0 && index < this.elements.size()) {
				T item = this.elements.get(index);
				this.elements.remove(item);
				this.elements.add(msg.getPosition(), item);
			}
			break;
		}
	}

	@SuppressWarnings("unchecked")
	private void addNewChild(Object value, int position) {
		if (!getProviderElements().contains(value))
			return;
		if (position == Notification.NO_INDEX || position > this.elements.size()) {
			this.elements.add((T)value);
		} else {
			this.elements.add(position, (T)value);
		}
	}
	
	private void removeChild(Object value) {
		this.elements.remove(value);
	}

	@Override
	public boolean add(Object e) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public void add(int index, Object element) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public boolean contains(Object o) {
		return this.elements.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return this.elements.containsAll(c);
	}

	@Override
	public T get(int index) {
		return this.elements.get(index);
	}

	@Override
	public int indexOf(Object o) {
		return this.elements.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return this.elements.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return this.elements.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return this.elements.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		return this.elements.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return this.elements.listIterator(index);
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public T remove(int index) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public T set(int index, Object element) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public int size() {
		return this.elements.size();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return this.elements.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return this.elements.toArray();
	}

	@Override
	public <A> A[] toArray(A[] a) {
		return this.elements.toArray(a);
	}

	@Override
	public void addListener(InvalidationListener listener) {
		this.elements.addListener(listener);
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		this.elements.removeListener(listener);
	}

	@Override
	public boolean addAll(Object... arg0) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public void addListener(ListChangeListener<? super T> listener) {
		this.elements.addListener(listener);
	}

	@Override
	public void remove(int arg0, int arg1) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public boolean removeAll(Object... arg0) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public void removeListener(ListChangeListener<? super T> listener) {
		this.elements.removeListener(listener);
	}

	@Override
	public boolean retainAll(Object... arg0) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public boolean setAll(Object... arg0) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public boolean setAll(Collection<? extends T> arg0) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}
}
