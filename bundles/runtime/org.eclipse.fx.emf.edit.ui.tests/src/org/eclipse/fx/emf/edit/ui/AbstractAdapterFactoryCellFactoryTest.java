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

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;

import javafx.scene.control.Cell;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * This class provides a test bench and helper methods for
 * {@link AdapterFactoryCellFactory} tests
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class AbstractAdapterFactoryCellFactoryTest {

	AdapterFactory adapterFactory;
	Adapter adapter1;
	Adapter adapter2;
	ArgumentCaptor<Object> itemCaptor;
	ArgumentCaptor<Cell> cellCaptor;
	ArgumentCaptor<AdapterFactory> adapterFactoryCaptor;
	Notifier item1;
	Notifier item2;
	EList<Adapter> adapterList1;
	EList<Adapter> adapterList2;
	Object foregroundObject;
	Object backgroundObject;
	Color foregroundColor;
	Color backgroundColor;
	String backgroundCss;
	Object fontObject;
	Font font;

	void createTestBench() {
		adapterFactory = mock(AdapterFactory.class);
		itemCaptor = ArgumentCaptor.forClass(Object.class);
		cellCaptor = ArgumentCaptor.forClass(Cell.class);
		adapterFactoryCaptor = ArgumentCaptor.forClass(AdapterFactory.class);

		item1 = mock(Notifier.class);
		adapterList1 = mock(EList.class);
		when(item1.eAdapters()).thenReturn(adapterList1);
		when(adapterList1.add(any(Adapter.class))).thenAnswer(new Answer() {

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				adapter1 = (Adapter) invocation.getArguments()[0];
				return null;
			}

		});

		item2 = mock(Notifier.class);
		adapterList2 = mock(EList.class);
		when(item2.eAdapters()).thenReturn(adapterList2);
		when(adapterList2.add(any(Adapter.class))).thenAnswer(new Answer() {

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				adapter2 = (Adapter) invocation.getArguments()[0];
				return null;
			}

		});

		foregroundObject = mock(Object.class);
		foregroundColor = mock(Color.class);
		
		backgroundObject = mock(Object.class);
		backgroundColor = mock(Color.class);		
		
		backgroundCss = "rgb(0, 255, 0)";
		
		fontObject = mock(Object.class);
		font = Font.getDefault();
	}

	void stubHelperMethods(AdapterFactoryCellFactory cellFactory) {
		when(cellFactory.colorFromObject(foregroundObject)).thenReturn(foregroundColor);
		when(cellFactory.colorFromObject(backgroundObject)).thenReturn(backgroundColor);
		when(cellFactory.cssColorFromObject(backgroundObject)).thenReturn(backgroundCss);
		when(cellFactory.fontFromObject(fontObject)).thenReturn(font);
	}

	/**
	 * Helper method to call protected method {@link Cell#updateItem}
	 */
	static void invokeUpdateItem(Cell<?> cell, Object item, boolean empty) throws Exception {
		Method updateItem = Cell.class.getDeclaredMethod("updateItem", Object.class, boolean.class);
		updateItem.setAccessible(true);
		updateItem.invoke(cell, item, empty);
	}

}
