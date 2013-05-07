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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Cell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemFontProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

/**
 * Base class for the AdapterFactoryCellFactories
 */
public abstract class AdapterFactoryCellFactory {

	/**
	 * A listener interface for callbacks that process newly created {@link Cell}s
	 */
	public interface ICellCreationListener {

		/**
		 * @param cell the newly created {@link Cell}
		 */
		void cellCreated(Cell<?> cell);

	}

	/**
	 * A listener interface for callbacks that process {@link Cell}s being updated during
	 * {@link Cell#updateItem}.
	 */
	public interface ICellUpdateListener {

		/**
		 * @param cell the {@link Cell} being updated
		 * @param item as defined in {@link Cell#updateItem}
		 * @param empty as defined in {@link Cell#updateItem}
		 */
		void updateItem(Cell<?> cell, Object item, boolean empty);

	}

	/**
	 * An interface for providers that handle cell editing. The {@link Cell}s created by the factory will
	 * delegate calls to their editing methods to the first handler in
	 * {@link AdapterFactoryCellFactory#cellEditHandlers} that returns <code>true</code> for
	 * {@link ICellEditHandler#canEdit(Cell)} .
	 */
	public interface ICellEditHandler {

		/**
		 * Whether editing treeCell can be handled
		 */
		boolean canEdit(Cell<?> treeCell);

		/**
		 * Delegate for {@link Cell#startEdit()}
		 */
		void startEdit(Cell<?> treeCell);

		/**
		 * Delegate for {@link Cell#commitEdit(Object)}
		 */
		void commitEdit(Cell<?> treeCell, Object newValue);

		/**
		 * Delegate for {@link Cell#cancelEdit()}
		 */
		void cancelEdit(Cell<?> treeCell);

	}

	final protected AdapterFactory adapterFactory;
	final List<ICellCreationListener> cellCreationListeners = new ArrayList<>();
	final List<ICellUpdateListener> cellUpdateListeners = new ArrayList<>();
	final List<ICellEditHandler> cellEditHandlers = new ArrayList<>();

	public AdapterFactoryCellFactory(AdapterFactory adapterFactory) {
		super();

		if (adapterFactory == null)
			throw new IllegalArgumentException("AdapterFactory must not be null.");

		this.adapterFactory = adapterFactory;
	}

	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	public void addCellCreationListener(ICellCreationListener listener) {
		cellCreationListeners.add(listener);
	}

	public void removeCellCreationListener(ICellCreationListener listener) {
		cellCreationListeners.remove(listener);
	}

	public void addCellUpdateListener(ICellUpdateListener listener) {
		cellUpdateListeners.add(listener);
	}

	public void removeCellUpdateListener(ICellUpdateListener listener) {
		cellUpdateListeners.remove(listener);
	}

	public void addCellEditHandler(ICellEditHandler cellEditHandler) {
		cellEditHandlers.add(cellEditHandler);
	}

	public void remvoveCellEditHandler(ICellEditHandler cellEditHandler) {
		cellEditHandlers.remove(cellEditHandler);
	}

	ICellEditHandler getCellEditHandler(Cell<?> cell) {
		for (ICellEditHandler cellEditHandler : cellEditHandlers) {
			if (cellEditHandler.canEdit(cell))
				return cellEditHandler;
		}
		return null;
	}

	void applyItemProviderStyle(Object item, Cell<?> cell, AdapterFactory adapterFactory) {
		applyItemProviderLabel(item, cell, adapterFactory);
		applyItemProviderColor(item, cell, adapterFactory);
		applyItemProviderFont(item, cell, adapterFactory);
	}

	void applyItemProviderFont(Object item, Cell<?> cell, AdapterFactory adapterFactory) {
		IItemFontProvider fontProvider = (IItemFontProvider) adapterFactory.adapt(item, IItemFontProvider.class);
		if (fontProvider != null) {
			Font font = fontFromObject(fontProvider.getFont(item));
			if (font != null)
				cell.setFont(font);
		}
	}

	Font fontFromObject(Object object) {

		if (object instanceof URI) {
			URI fontURI = (URI) object;
			if (!"font".equals(fontURI.scheme()))
				throw new IllegalArgumentException("Only 'font' scheme is recognized" + fontURI);

			if (fontURI.segmentCount() != 2)
				throw new IllegalArgumentException("The URI must have an authority and two segments");

			// font name
			String fontNameSpecification = fontURI.authority();
			if ("".equals(fontNameSpecification))
				fontNameSpecification = null;

			// font height
			String heightSpecification = fontURI.segment(0);
			boolean delta;
			int height;
			if (heightSpecification.startsWith("+")) {
				delta = true;
				height = Integer.parseInt(heightSpecification.substring(1));
			} else if ("".equals(heightSpecification)) {
				delta = true;
				height = 0;
			} else {
				height = Integer.parseInt(heightSpecification);
				delta = height < 0;
			}

			// font style
			String styleSpecification = fontURI.segment(1);
			boolean italic = false;
			boolean bold = false;
			if ("bold".equals(styleSpecification))
				bold = true;
			else if ("italic".equals(styleSpecification))
				italic = true;
			else if ("italic+bold".equals(styleSpecification) || "bold+italic".equals(styleSpecification))
				bold = italic = true;

			double size = delta ? Font.getDefault().getSize() + height : height;

			return Font.font(fontNameSpecification, bold ? FontWeight.BOLD : FontWeight.NORMAL, italic ? FontPosture.ITALIC
					: FontPosture.REGULAR, size);
		}

		return null;
	}

	void applyItemProviderLabel(Object item, Cell<?> cell, AdapterFactory adapterFactory) {
		IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(item, IItemLabelProvider.class);

		if (labelProvider != null) {
			cell.setText(labelProvider.getText(item));

			if (item != null) {
				Node image = graphicFromObject(labelProvider.getImage(item));
				if (image != null)
					cell.setGraphic(image);
			}
		}
	}

	void applyTableItemProviderStyle(Object item, int columnIndex, Cell<?> cell, AdapterFactory adapterFactory) {
		applyTableItemProviderLabel(item, columnIndex, cell, adapterFactory);
		applyTableItemProviderColor(item, columnIndex, cell, adapterFactory);
		applyTableItemProviderFont(item, columnIndex, cell, adapterFactory);
	}

	void applyTableItemProviderLabel(Object item, int columnIndex, Cell<?> cell, AdapterFactory adapterFactory) {
		ITableItemLabelProvider labelProvider = (ITableItemLabelProvider) adapterFactory.adapt(item, ITableItemLabelProvider.class);
		if (labelProvider != null) {
			cell.setText(labelProvider.getColumnText(item, columnIndex));
			Object columnImage = labelProvider.getColumnImage(item, columnIndex);
			Node graphic = graphicFromObject(columnImage);
			cell.setGraphic(graphic);
		} else {
			// clear the cell if there is no item
			cell.setText(null);
			cell.setGraphic(null);
		}
	}

	void applyTableItemProviderColor(Object item, int columnIndex, Cell<?> cell, AdapterFactory adapterFactory) {
		ITableItemColorProvider colorProvider = (ITableItemColorProvider) adapterFactory.adapt(item, ITableItemColorProvider.class);
		if (colorProvider != null) {
			Color foreground = colorFromObject(colorProvider.getForeground(item, columnIndex));
			if (foreground != null)
				cell.setTextFill(foreground);

			String background = cssColorFromObject(colorProvider.getBackground(item, columnIndex));
			if (background != null)
				cell.setStyle("-fx-background-color: " + background);
		}
	}

	void applyTableItemProviderFont(Object item, int columnIndex, Cell<?> cell, AdapterFactory adapterFactory) {
		ITableItemFontProvider fontProvider = (ITableItemFontProvider) adapterFactory.adapt(item, ITableItemFontProvider.class);
		if (fontProvider != null) {
			Font font = fontFromObject(fontProvider.getFont(item, columnIndex));
			if (font != null)
				cell.setFont(font);
		}
	}

	Node graphicFromObject(Object object) {
		if (object instanceof Node) {
			return (Node) object;
		} else if (object instanceof URL) {
			return new ImageView(((URL) object).toExternalForm());
		} else if (object instanceof ComposedImage) {
			Pane pane = new Pane();

			for (Object image : ((ComposedImage) object).getImages()) {
				if (image instanceof URL) {
					ImageView imageView = new ImageView(((URL) image).toExternalForm());
					pane.getChildren().add(imageView);
				}
			}

			return pane;
		}

		return null;
	}

	void applyItemProviderColor(Object item, Cell<?> cell, AdapterFactory adapterFactory) {
		IItemColorProvider colorProvider = (IItemColorProvider) adapterFactory.adapt(item, IItemColorProvider.class);
		if (colorProvider != null) {
			Color foreground = colorFromObject(colorProvider.getForeground(item));
			if (foreground != null)
				cell.setTextFill(foreground);

			String background = cssColorFromObject(colorProvider.getBackground(item));
			if (background != null)
				cell.setStyle("-fx-background-color: " + background);
		}
	}

	Color colorFromObject(Object object) {
		URI colorURI = toColorURI(object);

		if (colorURI != null) {
			try {
				int red = Integer.parseInt(colorURI.segment(0));
				int green = Integer.parseInt(colorURI.segment(1));
				int blue = Integer.parseInt(colorURI.segment(2));
				return Color.rgb(red, green, blue);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Cannot parse color values " + colorURI + ". " + e.getMessage());
			}
		}

		return null;
	}

	String cssColorFromObject(Object object) {
		URI colorURI = toColorURI(object);

		if (colorURI != null)
			return "rgb(" + colorURI.segment(0) + ", " + colorURI.segment(1) + ", " + colorURI.segment(2) + ")";

		return null;
	}

	URI toColorURI(Object object) {
		if (object instanceof URI) {
			URI colorURI = (URI) object;

			if (!"color".equals(colorURI.scheme()))
				throw new IllegalArgumentException("Only 'color' scheme is recognized " + colorURI);

			if (!"rgb".equals(colorURI.authority()))
				throw new IllegalArgumentException("Only 'rgb' authority is recognized " + colorURI);

			if (colorURI.segmentCount() != 3)
				throw new IllegalArgumentException("Color must have 3 segments (r, g, b) " + colorURI);

			return colorURI;
		}

		return null;
	}

}
