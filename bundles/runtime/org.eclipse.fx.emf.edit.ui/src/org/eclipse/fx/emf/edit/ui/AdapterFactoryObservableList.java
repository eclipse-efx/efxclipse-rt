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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;

/**
 * This {@link ObservableList} wraps an {@link AdapterFactory} and retrieves its elements from the
 * adapter-implemented {@link IStructuredItemContentProvider} interface. The content of the list can only be
 * modified through changes to the underlying model.
 */
public class AdapterFactoryObservableList<T> implements ObservableList<T> {

	private static final String CHANGES_THROUGH_MODEL = "An AdapterFactoryObservableList cannot be manipulated directly. Changes must be made via the model.";
	protected AdapterFactory adapterFactory;
	protected Object root;
	protected IStructuredItemContentProvider provider;
	/* package */ObservableList<T> elements = FXCollections.observableArrayList();

	@SuppressWarnings("unchecked")
	public AdapterFactoryObservableList(AdapterFactory adapterFactory, final Object root) {
		super();

		if (adapterFactory == null)
			throw new IllegalArgumentException("AdapterFactory must not be null.");

		this.adapterFactory = adapterFactory;
		this.root = root;
		Object contentProvider = adapterFactory.adapt(root, IStructuredItemContentProvider.class);

		if(contentProvider instanceof IStructuredItemContentProvider)
			provider = (IStructuredItemContentProvider) contentProvider;
		else
			throw new IllegalArgumentException("Provided root object cannot be adapted.");
		
		elements.addAll((Collection<? extends T>) provider.getElements(root));

		if (root instanceof Notifier) {
			AdapterImpl adapter = new AdapterImpl() {

				@Override
				public void notifyChanged(Notification msg) {
					elements.setAll((Collection<? extends T>) provider.getElements(root));
				}

			};

			((Notifier) root).eAdapters().add(adapter);
		} else if (root instanceof IChangeNotifier) {
			((IChangeNotifier) root).addListener(new INotifyChangedListener() {

				@Override
				public void notifyChanged(Notification notification) {
					elements.setAll((Collection<? extends T>) provider.getElements(root));
				}
				
			});
		}

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
		return elements.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return elements.containsAll(c);
	}

	@Override
	public T get(int index) {
		return elements.get(index);
	}

	@Override
	public int indexOf(Object o) {
		return elements.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return elements.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return elements.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		return elements.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return elements.listIterator(index);
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
		return elements.size();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return elements.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return elements.toArray();
	}

	@Override
	public <A> A[] toArray(A[] a) {
		return elements.toArray(a);
	}

	@Override
	public void addListener(InvalidationListener listener) {
		elements.addListener(listener);
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		elements.removeListener(listener);
	}

	@Override
	public boolean addAll(Object... arg0) {
		throw new UnsupportedOperationException(CHANGES_THROUGH_MODEL);
	}

	@Override
	public void addListener(ListChangeListener<? super T> listener) {
		elements.addListener(listener);
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
		elements.removeListener(listener);
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
