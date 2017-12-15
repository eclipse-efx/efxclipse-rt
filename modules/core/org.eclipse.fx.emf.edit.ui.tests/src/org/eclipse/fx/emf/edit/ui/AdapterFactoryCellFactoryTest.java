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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.scene.Node;
import javafx.scene.control.Cell;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory.ICellCreationListener;
import org.eclipse.fx.emf.edit.ui.AdapterFactoryCellFactory.ICellUpdateListener;
import org.junit.Before;
import org.junit.Test;

public class AdapterFactoryCellFactoryTest {

	AdapterFactory adapterFactory;
	AdapterFactoryCellFactory cellFactory;

	@Before
	public void setUp() {
		adapterFactory = mock(AdapterFactory.class);
		cellFactory = spy(new AdapterFactoryCellFactory(adapterFactory) {
		});
	}

	@Test
	public void getAdapterFactory() {
		assertEquals(adapterFactory, cellFactory.getAdapterFactory());
	}

	@Test
	public void addAndRemoveCellCreationListener() {
		ICellCreationListener listener = mock(ICellCreationListener.class);
		cellFactory.addCellCreationListener(listener);
		assertEquals(listener, cellFactory.cellCreationListeners.get(0));

		cellFactory.removeCellCreationListener(listener);
		assertTrue(cellFactory.cellCreationListeners.isEmpty());
	}

	@Test
	public void addAndRemoveCellUpdateListener() {
		ICellUpdateListener listener = mock(ICellUpdateListener.class);
		cellFactory.addCellUpdateListener(listener);
		assertEquals(listener, cellFactory.cellUpdateListeners.get(0));

		cellFactory.removeCellUpdateListener(listener);
		assertTrue(cellFactory.cellUpdateListeners.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorWithNullAdapterFactory() {
		new AdapterFactoryCellFactory(null) {
		};
	}

	@Test
	public void fontFromObjectWithNonURI() {
		cellFactory.fontFromObject(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void fontFromObjectWithIllegalScheme() {
		URI uri = URI.createURI("http://Arial/8/bold");
		cellFactory.fontFromObject(uri);
	}

	@Test(expected = IllegalArgumentException.class)
	public void fontFromObjectWithoutSegments() {
		URI uri = URI.createURI("font://");
		cellFactory.fontFromObject(uri);
	}

	@Test
	public void fontFromObjectWithoutFontName() {
		URI uri = URI.createURI("font:///8/");
		Font font = cellFactory.fontFromObject(uri);
		assertEquals(8, font.getSize(), 0);
	}

	@Test
	public void fontFromObjectWithPositiveHeightDelta() {
		URI uri = URI.createURI("font://Arial/+1/");
		Font font = cellFactory.fontFromObject(uri);
		assertEquals(Font.getDefault().getSize() + 1, font.getSize(), 0);
	}

	@Test
	public void fontFromObjectWithNegativeHeightDelta() {
		URI uri = URI.createURI("font://Arial/-2/");
		Font font = cellFactory.fontFromObject(uri);
		assertEquals(Font.getDefault().getSize() - 2, font.getSize(), 0);
	}

	@Test
	public void fontFromObjectWithoutHeight() {
		URI uri = URI.createURI("font://Arial//");
		cellFactory.fontFromObject(uri);
		Font font = cellFactory.fontFromObject(uri);
		assertEquals("Arial", font.getName());
	}

	@Test
	public void fontFromObjectBold() {
		URI uri = URI.createURI("font://Arial/8/bold");
		Font font = cellFactory.fontFromObject(uri);
		assertEquals("Arial Bold", font.getName());
		assertEquals(8, font.getSize(), 0);
	}

	@Test
	public void fontFromObjectItalic() {
		URI uri = URI.createURI("font://Arial/8/italic");
		Font font = cellFactory.fontFromObject(uri);
		assertEquals("Arial Italic", font.getName());
		assertEquals(8, font.getSize(), 0);
	}

	@Test
	public void fontFromObjectBoldAndItalic() {
		URI uri = URI.createURI("font://Arial/8/bold+italic");
		Font font = cellFactory.fontFromObject(uri);
		assertEquals("Arial Bold Italic", font.getName());
		assertEquals(8, font.getSize(), 0);
	}

	@Test
	public void fontFromObjectItalicAndBold() {
		URI uri = URI.createURI("font://Arial/8/italic+bold");
		Font font = cellFactory.fontFromObject(uri);
		assertEquals("Arial Bold Italic", font.getName());
		assertEquals(8, font.getSize(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void colorFromObjectWithIllegalScheme() {
		URI uri = URI.createURI("http://");
		cellFactory.colorFromObject(uri);
	}

	@Test(expected = IllegalArgumentException.class)
	public void colorFromObjectWithIllegalAuthority() {
		URI uri = URI.createURI("color://hsb");
		cellFactory.colorFromObject(uri);
	}

	@Test(expected = IllegalArgumentException.class)
	public void colorFromObjectWithIllegalSegmentCount() {
		URI uri = URI.createURI("color://rgb/120/100");
		cellFactory.colorFromObject(uri);
	}

	@Test(expected = IllegalArgumentException.class)
	public void colorFromObjectWithIllegalNumberFormat() {
		URI uri = URI.createURI("color://rgb/100/XXX/0");
		Color color = cellFactory.colorFromObject(uri);
		assertEquals(Color.rgb(100, 200, 0), color);
	}

	@Test
	public void colorFromObjectValidURI() {
		URI uri = URI.createURI("color://rgb/100/200/0");
		Color color = cellFactory.colorFromObject(uri);
		assertEquals(Color.rgb(100, 200, 0), color);
	}

	@Test
	public void cssColorFromObjectValidURI() {
		URI uri = URI.createURI("color://rgb/100/200/0");
		String color = cellFactory.cssColorFromObject(uri);
		assertEquals("rgb(100, 200, 0)", color);
	}

	@Test
	public void applyItemProviderFont() {
		IItemFontProvider fontProvider = mock(IItemFontProvider.class);
		Object item = new Object();
		URI fontURI = URI.createURI("font://Arial/8/");
		Font font = new Font(8);
		when(fontProvider.getFont(item)).thenReturn(fontURI);
		when(adapterFactory.adapt(item, IItemFontProvider.class)).thenReturn(fontProvider);
		when(cellFactory.fontFromObject(fontURI)).thenReturn(font);
		Cell<?> cell = new Cell<>();
		cellFactory.applyItemProviderFont(item, cell, adapterFactory);
	}	
	
	@Test
	public void applyItemProviderLabel() {
		IItemLabelProvider labelProvider = mock(IItemLabelProvider.class);
		Object item = new Object();
		String text = "";
		URI imageURI = URI.createURI("");
		when(labelProvider.getText(item)).thenReturn(text);
		when(labelProvider.getImage(item)).thenReturn(imageURI);
		ImageView graphic = new ImageView();
		when(cellFactory.graphicFromObject(imageURI)).thenReturn(graphic);
		when(adapterFactory.adapt(item, IItemLabelProvider.class)).thenReturn(labelProvider);

		Cell<?> cell = new Cell<>();
		cellFactory.applyItemProviderLabel(item, cell, adapterFactory);
		
		assertEquals(text, cell.getText());
		assertEquals(graphic, cell.getGraphic());
	}
	
	@Test
	public void applyItemProviderColor() {
		IItemColorProvider colorProvider = mock(IItemColorProvider.class);
		Object item = new Object();
		URI foregroundColorURI = URI.createURI("color://rgb/255/0/0");
		URI backgroundColorURI = URI.createURI("color://rgb/0/255/0");
		when(colorProvider.getForeground(item)).thenReturn(foregroundColorURI);
		when(colorProvider.getBackground(item)).thenReturn(backgroundColorURI);
		when(adapterFactory.adapt(item, IItemColorProvider.class)).thenReturn(colorProvider);

		Cell<?> cell = new Cell<>();
		cellFactory.applyItemProviderColor(item, cell, adapterFactory);
		
		assertEquals(Color.rgb(255,  0,  0), cell.getTextFill());
		assertEquals("-fx-background-color: rgb(0, 255, 0)", cell.getStyle());
	}

	@Test
	public void imageFromObject() throws MalformedURLException {
		URL imageURL = new URL("http://domain.com/image.jpg");
		Node image = cellFactory.graphicFromObject(imageURL);
		assertNotNull(image);
	}	
}
