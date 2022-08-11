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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryObservableList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class AdapterFactoryObservableListTest {

	final static int DUMMY_INDEX = 0;
	final static int DUMMY_SIZE = 10;
	final static List<Object> DUMMY_LIST = Collections.emptyList();
	final static Object DUMMY_OBJECT = new Object();
	final static Object[] DUMMY_ARRAY = new Object[0];
	final static Iterator<Object> DUMMY_ITERATOR = mock(Iterator.class);
	final static ListIterator<Object> DUMMY_LIST_ITERATOR = mock(ListIterator.class);
	final static ListIterator<Object> DUMMY_LIST_ITERATOR_WITH_INDEX = mock(ListIterator.class);
	final static ListChangeListener DUMMY_LIST_CHANGE_LISTENER = mock(ListChangeListener.class);
	final static InvalidationListener DUMMY_INVALIDATION_LISTENER = mock(InvalidationListener.class);

	AdapterFactoryObservableList list;
	ObservableList<Object> elements;
	AdapterFactoryImpl adapterFactory;

	@Before
	public void setUp() {
		elements = mock(ObservableList.class);
		when(elements.lastIndexOf(DUMMY_OBJECT)).thenReturn(DUMMY_INDEX);
		when(elements.iterator()).thenReturn(DUMMY_ITERATOR);
		when(elements.listIterator()).thenReturn(DUMMY_LIST_ITERATOR);
		when(elements.listIterator(DUMMY_INDEX)).thenReturn(
				DUMMY_LIST_ITERATOR_WITH_INDEX);
		when(elements.size()).thenReturn(DUMMY_SIZE);
		when(elements.subList(DUMMY_INDEX, DUMMY_INDEX)).thenReturn(DUMMY_LIST);
		when(elements.toArray()).thenReturn(DUMMY_ARRAY);
		when(elements.toArray(DUMMY_ARRAY)).thenReturn(DUMMY_ARRAY);
		adapterFactory = new AdapterFactoryImpl();
		ItemProvider root = new ItemProvider();
		list = new AdapterFactoryObservableList(adapterFactory, root);
		list.elements = elements;
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorWithNullAdapterFactory() {
		new AdapterFactoryObservableList(null, DUMMY_OBJECT);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorWithNonAdaptableRoot() {
		new AdapterFactoryObservableList(adapterFactory, DUMMY_OBJECT);
	}

	Adapter adapter;

	@Test
	public void constructorWithNotifierRoot() {
		Notifier notifier = mock(Notifier.class);
		EList adapterList = mock(EList.class);
		when(notifier.eAdapters()).thenReturn(adapterList);
		when(adapterList.add(any())).thenAnswer(new Answer() {

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				adapter = (Adapter) invocation.getArguments()[0];
				return null;
			}

		});
		AdapterFactory adapterFactory = mock(AdapterFactory.class);
		IStructuredItemContentProvider contentProvider = mock(IStructuredItemContentProvider.class);
		when(adapterFactory.adapt(any(), any())).thenReturn(contentProvider);
		AdapterFactoryObservableList observableList = new AdapterFactoryObservableList(
				adapterFactory, notifier);
		observableList.elements = elements;

		// make sure that notification are forwarded
		adapter.notifyChanged(mock(Notification.class));
		verify(elements).setAll(any(Collection.class));
	}

	INotifyChangedListener changeListener;

	@Test
	public void constructorWithIChangeNotifierRoot() {
		ItemProvider itemProvider = mock(ItemProvider.class);
		doAnswer(new Answer() {

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				changeListener = (INotifyChangedListener) invocation
						.getArguments()[0];
				return null;
			}
		}).when(itemProvider).addListener(
				(INotifyChangedListener) any(IChangeNotifier.class));

		AdapterFactoryObservableList observableList = new AdapterFactoryObservableList(
				adapterFactory, itemProvider);
		observableList.elements = elements;

		verify(itemProvider).addListener(any(INotifyChangedListener.class));

		// make sure that notification are forwarded
		changeListener.notifyChanged(mock(Notification.class));
		verify(elements).setAll(any(Collection.class));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void addWidthObject() {
		list.add(DUMMY_OBJECT);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void addWidthIndexAndObject() {
		list.add(DUMMY_INDEX, DUMMY_OBJECT);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void addAllWithCollection() {
		list.addAll(DUMMY_LIST);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void addAllWithIndexAndCollection() {
		list.addAll(DUMMY_INDEX, DUMMY_LIST);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void addAllWithArray() {
		list.addAll(DUMMY_OBJECT);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void clear() {
		list.clear();
	}

	@Test
	public void contains() {
		list.contains(DUMMY_OBJECT);
		verify(elements).contains(DUMMY_OBJECT);
	}

	@Test
	public void containsAll() {
		list.containsAll(DUMMY_LIST);
		verify(elements).containsAll(DUMMY_LIST);
	}

	@Test
	public void get() {
		list.get(DUMMY_INDEX);
		verify(elements).get(DUMMY_INDEX);
	}

	@Test
	public void indexOf() {
		list.indexOf(DUMMY_OBJECT);
		verify(elements).indexOf(DUMMY_OBJECT);
	}

	@Test
	public void isEmpty() {
		list.isEmpty();
		verify(elements).isEmpty();
	}

	@Test
	public void iterator() {
		Iterator<Object> iterator = list.iterator();
		verify(elements).iterator();
		assertEquals(DUMMY_ITERATOR, iterator);
	}

	@Test
	public void lastIndexOf() {
		int index = list.lastIndexOf(DUMMY_OBJECT);
		verify(elements).lastIndexOf(DUMMY_OBJECT);
		assertEquals(DUMMY_INDEX, index);
	}

	@Test
	public void listIterator() {
		ListIterator<Object> listIterator = list.listIterator();
		verify(elements).listIterator();
		assertEquals(DUMMY_LIST_ITERATOR, listIterator);
	}

	@Test
	public void listIteratorWithIndex() {
		ListIterator<Object> listIterator = list.listIterator(DUMMY_INDEX);
		verify(elements).listIterator(DUMMY_INDEX);
		assertEquals(DUMMY_LIST_ITERATOR_WITH_INDEX, listIterator);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeWidthObject() {
		list.remove(DUMMY_OBJECT);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeWithIndex() {
		list.remove(DUMMY_INDEX);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeWithFromAndToIndex() {
		list.remove(DUMMY_INDEX, DUMMY_INDEX);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeAllWithCollection() {
		list.removeAll(DUMMY_LIST);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeAllWithObject() {
		list.removeAll(DUMMY_OBJECT);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void retainAllWithCollection() {
		list.retainAll(DUMMY_LIST);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void retainAllWithObject() {
		list.retainAll(DUMMY_OBJECT);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void set() {
		list.set(DUMMY_INDEX, DUMMY_OBJECT);
	}

	@Test
	public void size() {
		int size = list.size();
		verify(elements).size();
		assertEquals(DUMMY_SIZE, size);
	}

	@Test
	public void subList() {
		List<Object> subList = list.subList(DUMMY_INDEX, DUMMY_INDEX);
		verify(elements).subList(DUMMY_INDEX, DUMMY_INDEX);
		assertEquals(DUMMY_LIST, subList);
	}

	@Test
	public void toArray() {
		Object[] array = list.toArray();
		verify(elements).toArray();
		assertArrayEquals(DUMMY_ARRAY, array);
	}

	@Test
	public void toArrayWithArray() {
		Object[] array = list.toArray(DUMMY_ARRAY);
		verify(elements).toArray(DUMMY_ARRAY);
		assertArrayEquals(DUMMY_ARRAY, array);
	}

	@Test
	public void addListenerWithInvalidationListener() {
		list.addListener(DUMMY_INVALIDATION_LISTENER);
		verify(elements).addListener(DUMMY_INVALIDATION_LISTENER);
	}

	@Test
	public void addListenerWithListChangeListener() {
		list.addListener(DUMMY_LIST_CHANGE_LISTENER);
		verify(elements).addListener(DUMMY_LIST_CHANGE_LISTENER);
	}

	@Test
	public void removeListenerWithInvalidationListener() {
		list.removeListener(DUMMY_INVALIDATION_LISTENER);
		verify(elements).removeListener(DUMMY_INVALIDATION_LISTENER);
	}

	@Test
	public void removeListenerWithListChangeListener() {
		list.removeListener(DUMMY_LIST_CHANGE_LISTENER);
		verify(elements).removeListener(DUMMY_LIST_CHANGE_LISTENER);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void setAllWithCollection() {
		list.setAll(DUMMY_LIST);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void setAllWithObject() {
		list.setAll(DUMMY_OBJECT);
	}

}
