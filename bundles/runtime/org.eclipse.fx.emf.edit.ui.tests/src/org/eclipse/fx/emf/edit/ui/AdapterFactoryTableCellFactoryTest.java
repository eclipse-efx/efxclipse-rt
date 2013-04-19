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
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.scene.control.Cell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemFontProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory.ICellCreationListener;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory.ICellUpdateListener;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryTableCellFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

@SuppressWarnings("rawtypes")
public class AdapterFactoryTableCellFactoryTest extends AbstractAdapterFactoryCellFactoryTest {

	private static final Integer COLUMN_INDEX = new Integer(1);
	AdapterFactoryTableCellFactory cellFactory;
	ArgumentCaptor<Integer> columnIndexCaptor;

	@Before
	public void setUp() {
		createTestBench();
		cellFactory = spy(new AdapterFactoryTableCellFactory(adapterFactory, COLUMN_INDEX));
		stubHelperMethods(cellFactory);
		columnIndexCaptor = ArgumentCaptor.forClass(Integer.class);
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
		TableColumn<Object, Object> listView = new TableColumn<Object, Object>();
		TableCell<Object, Object> tableCell = cellFactory.call(listView);

		// update the cell
		invokeUpdateItem(tableCell, item1, false);

		assertNotNull("No adapter was added", adapter1);

		verify(cellFactory, times(1)).applyTableItemProviderStyle(itemCaptor.capture(), columnIndexCaptor.capture(), cellCaptor.capture(),
				adapterFactoryCaptor.capture());
		assertEquals(item1, itemCaptor.getValue());
		assertEquals(COLUMN_INDEX, columnIndexCaptor.getValue());
		assertEquals(tableCell, cellCaptor.getValue());
		assertEquals(adapterFactory, adapterFactoryCaptor.getValue());
		// update the cell again
		invokeUpdateItem(tableCell, item2, false);

		verify(adapterList1).remove(adapter1);

		assertNotNull("No adapter was added", adapter2);

		verify(cellFactory, times(2)).applyTableItemProviderStyle(itemCaptor.capture(), columnIndexCaptor.capture(), cellCaptor.capture(),
				adapterFactoryCaptor.capture());
		assertEquals(item2, itemCaptor.getValue());
		assertEquals(COLUMN_INDEX, columnIndexCaptor.getValue());
		assertEquals(tableCell, cellCaptor.getValue());
		assertEquals(adapterFactory, adapterFactoryCaptor.getValue());

		// notify the adapter
		Notification notification = mock(Notification.class);
		when(notification.getNotifier()).thenReturn(item2);
		adapter2.notifyChanged(notification);

		verify(cellFactory, times(3)).applyTableItemProviderStyle(itemCaptor.capture(), columnIndexCaptor.capture(), cellCaptor.capture(),
				adapterFactoryCaptor.capture());
		assertEquals(item2, itemCaptor.getValue());
		assertEquals(COLUMN_INDEX, columnIndexCaptor.getValue());
		assertEquals(tableCell, cellCaptor.getValue());
		assertEquals(adapterFactory, adapterFactoryCaptor.getValue());
	}

	@Test
	public void applyTableItemProviderColor() {
		Object item = mock(Object.class);
		ITableItemColorProvider itemProvider = mock(ITableItemColorProvider.class);
		when(itemProvider.getForeground(item, COLUMN_INDEX)).thenReturn(foregroundObject);
		when(itemProvider.getBackground(item, COLUMN_INDEX)).thenReturn(backgroundObject);
		when(adapterFactory.adapt(item, ITableItemColorProvider.class)).thenReturn(itemProvider);
		Cell cell = new Cell();
		cellFactory.applyTableItemProviderColor(item, COLUMN_INDEX, cell, adapterFactory);
		assertEquals(foregroundColor, cell.getTextFill());
		assertEquals("-fx-background-color: rgb(0, 255, 0)", cell.getStyle());
	}
	
	@Test
	public void applyTableItemProviderFont() {
		Object item = mock(Object.class);
		ITableItemFontProvider itemProvider = mock(ITableItemFontProvider.class);
		when(itemProvider.getFont(item, COLUMN_INDEX)).thenReturn(fontObject);
		when(adapterFactory.adapt(item, ITableItemFontProvider.class)).thenReturn(itemProvider);
		Cell cell = new Cell();
		cellFactory.applyTableItemProviderFont(item, COLUMN_INDEX, cell, adapterFactory);
		assertEquals(font, cell.getFont());
	}
	
	@Test
	public void applyTableItemProviderLabel() throws MalformedURLException {
		Object item = mock(Object.class);
		String columnText = "my column text";
		URL columnImage = new URL("http://domain.com/image.jpg");
		ITableItemLabelProvider itemProvider = mock(ITableItemLabelProvider.class);
		when(itemProvider.getColumnText(item, COLUMN_INDEX)).thenReturn(columnText);
		when(itemProvider.getColumnImage(item, COLUMN_INDEX)).thenReturn(columnImage);
		when(adapterFactory.adapt(item, ITableItemLabelProvider.class)).thenReturn(itemProvider);
		Cell cell = new Cell();
		cellFactory.applyTableItemProviderLabel(item, COLUMN_INDEX, cell, adapterFactory);
		assertEquals(columnText, cell.getText());
		assertTrue(cell.getGraphic() instanceof ImageView);
	}

}
