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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javafx.scene.control.Cell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory.ICellCreationListener;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory.ICellUpdateListener;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTreeCellFactory;
import org.junit.Before;
import org.junit.Test;


public class AdapterFactoryTreeCellFactoryTest extends AbstractAdapterFactoryCellFactoryTest {

	AdapterFactoryTreeCellFactory cellFactory;
	
	@Before
	public void setUp() {
		createTestBench();
		cellFactory = spy(new AdapterFactoryTreeCellFactory(adapterFactory));
		stubHelperMethods(cellFactory);
	}

	@Test
	public void call() {
		cellFactory.call(null);
	}

	@Test
	public void cellCreationNotification() {
		ICellCreationListener listener = mock(ICellCreationListener.class);
		cellFactory.addCellCreationListener(listener);
		cellFactory.call(null);
		verify(listener).cellCreated((Cell<?>) any());
	}

	@Test
	public void updateItem() throws Exception {
		ICellUpdateListener listener = mock(ICellUpdateListener.class);
		cellFactory.addCellUpdateListener(listener);
		TreeView<Object> treeView = new TreeView<>();
		TreeCell<Object> treeCell = cellFactory.call(treeView);

		// update the cell
		invokeUpdateItem(treeCell, item1, false);

		assertNotNull("No adapter was added", adapter1);

		verify(cellFactory, times(1)).applyItemProviderStyle(itemCaptor.capture(), cellCaptor.capture(), adapterFactoryCaptor.capture());
		assertEquals(item1, itemCaptor.getValue());
		assertEquals(treeCell, cellCaptor.getValue());
		assertEquals(adapterFactory, adapterFactoryCaptor.getValue());

		// update the cell again
		invokeUpdateItem(treeCell, item2, false);

		verify(adapterList1).remove(adapter1);

		assertNotNull("No adapter was added", adapter2);

		verify(cellFactory, times(2)).applyItemProviderStyle(itemCaptor.capture(), cellCaptor.capture(), adapterFactoryCaptor.capture());
		assertEquals(item2, itemCaptor.getValue());
		assertEquals(treeCell, cellCaptor.getValue());
		assertEquals(adapterFactory, adapterFactoryCaptor.getValue());

		// notify the adapter
		Notification notification = mock(Notification.class);
		when(notification.getNotifier()).thenReturn(item2);
		adapter2.notifyChanged(notification);

		verify(cellFactory, times(3)).applyItemProviderStyle(itemCaptor.capture(), cellCaptor.capture(), adapterFactoryCaptor.capture());
		assertEquals(item2, itemCaptor.getValue());
		assertEquals(treeCell, cellCaptor.getValue());
		assertEquals(adapterFactory, adapterFactoryCaptor.getValue());
	}

}
