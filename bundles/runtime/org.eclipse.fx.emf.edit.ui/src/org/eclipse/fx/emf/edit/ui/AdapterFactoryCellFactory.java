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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Base class for the AdapterFactoryCellFactories
 */
public abstract class AdapterFactoryCellFactory {

	/**
	 * A listener interface for callbacks that process newly created {@link Cell}s
	 */
	public interface ICellCreationListener {

		/**
		 * @param cell
		 *            the newly created {@link Cell}
		 */
		void cellCreated(Cell<?> cell);

	}

	/**
	 * A listener interface for callbacks that process {@link Cell}s being updated during
	 * {@link Cell#updateItem}.
	 */
	public interface ICellUpdateListener {

		/**
		 * @param cell
		 *            the {@link Cell} being updated
		 * @param item
		 *            as defined in {@link Cell#updateItem}
		 * @param empty
		 *            as defined in {@link Cell#updateItem}
		 */
		void updateItem(Cell<?> cell, Object item, boolean empty);

	}

	/**
	 * An interface for providers that handle cell editing. The {@link Cell}s created by the factory will
	 * delegate calls to their editing methods to the first handler in
	 * <code>AdapterFactoryCellFactory#cellEditHandlers<code> that returns <code>true</code> for
	 * {@link ICellEditHandler#canEdit(Cell)} .
	 */
	public interface ICellEditHandler {

		/**
		 * Whether editing treeCell can be handled
		 * 
		 * @param cell
		 *            the cell
		 * @return <code>true</code> if editable
		 */
		boolean canEdit(Cell<?> cell);

		/**
		 * Delegate for {@link Cell#startEdit()}
		 * 
		 * @param cell
		 *            the cell
		 */
		void startEdit(Cell<?> cell);

		/**
		 * Delegate for {@link Cell#commitEdit(Object)}
		 * 
		 * @param cell
		 *            the cell
		 * @param newValue
		 *            the new value
		 */
		void commitEdit(Cell<?> cell, Object newValue);

		/**
		 * Delegate for {@link Cell#cancelEdit()}
		 * 
		 * @param cell
		 *            the cell
		 */
		void cancelEdit(Cell<?> cell);

	}

	@NonNull
	final protected AdapterFactory adapterFactory;
	@NonNull
	final List<ICellCreationListener> cellCreationListeners = new ArrayList<>();
	@NonNull
	final List<ICellUpdateListener> cellUpdateListeners = new ArrayList<>();
	@NonNull
	final List<ICellEditHandler> cellEditHandlers = new ArrayList<>();

	/**
	 * Create a new factory
	 * 
	 * @param adapterFactory
	 *            the adapter factory
	 */
	public AdapterFactoryCellFactory(@NonNull AdapterFactory adapterFactory) {
		super();

		if (adapterFactory == null)
			throw new IllegalArgumentException("AdapterFactory must not be null."); //$NON-NLS-1$

		this.adapterFactory = adapterFactory;
	}

	/**
	 * @return the adapter factory
	 */
	@NonNull
	public AdapterFactory getAdapterFactory() {
		return this.adapterFactory;
	}

	/**
	 * Add a listener for cell creation
	 * 
	 * @param listener
	 *            the listener
	 */
	public void addCellCreationListener(@NonNull ICellCreationListener listener) {
		this.cellCreationListeners.add(listener);
	}

	/**
	 * Remove a listener for cell creation
	 * 
	 * @param listener
	 *            the listener
	 */
	public void removeCellCreationListener(@NonNull ICellCreationListener listener) {
		this.cellCreationListeners.remove(listener);
	}

	/**
	 * Add a cell update listener
	 * 
	 * @param listener
	 *            the listener
	 */
	public void addCellUpdateListener(@NonNull ICellUpdateListener listener) {
		this.cellUpdateListeners.add(listener);
	}

	/**
	 * Remove a cell update listener
	 * 
	 * @param listener
	 *            the listener
	 */
	public void removeCellUpdateListener(@NonNull ICellUpdateListener listener) {
		this.cellUpdateListeners.remove(listener);
	}

	/**
	 * Add a cell edit handler
	 * 
	 * @param cellEditHandler
	 *            the handler
	 */
	public void addCellEditHandler(@NonNull ICellEditHandler cellEditHandler) {
		this.cellEditHandlers.add(cellEditHandler);
	}

	/**
	 * Renove a cell edit handler
	 * 
	 * @param cellEditHandler
	 *            the handler
	 */
	public void remvoveCellEditHandler(@NonNull ICellEditHandler cellEditHandler) {
		this.cellEditHandlers.remove(cellEditHandler);
	}

	@Nullable
	ICellEditHandler getCellEditHandler(Cell<?> cell) {
		for (ICellEditHandler cellEditHandler : this.cellEditHandlers) {
			if (cellEditHandler.canEdit(cell))
				return cellEditHandler;
		}
		return null;
	}

	static void applyItemProviderStyle(@NonNull Object item, @NonNull Cell<?> cell, @NonNull AdapterFactory adapterFactory) {
		applyItemProviderLabel(item, cell, adapterFactory);
		applyItemProviderColor(item, cell, adapterFactory);
		applyItemProviderFont(item, cell, adapterFactory);
	}

	static void applyItemProviderFont(@NonNull Object item, @NonNull Cell<?> cell, @NonNull AdapterFactory adapterFactory) {
		IItemFontProvider fontProvider = (IItemFontProvider) adapterFactory.adapt(item, IItemFontProvider.class);
		if (fontProvider != null) {
			Font font = fontFromObject(fontProvider.getFont(item));
			if (font != null)
				cell.setFont(font);
		}
	}

	static Font fontFromObject(@NonNull Object object) {

		if (object instanceof URI) {
			URI fontURI = (URI) object;
			if (!"font".equals(fontURI.scheme())) //$NON-NLS-1$
				throw new IllegalArgumentException("Only 'font' scheme is recognized" + fontURI); //$NON-NLS-1$

			if (fontURI.segmentCount() != 2)
				throw new IllegalArgumentException("The URI must have an authority and two segments"); //$NON-NLS-1$

			// font name
			String fontNameSpecification = fontURI.authority();
			if ("".equals(fontNameSpecification)) //$NON-NLS-1$
				fontNameSpecification = null;

			// font height
			String heightSpecification = fontURI.segment(0);
			boolean delta;
			int height;
			if (heightSpecification.startsWith("+")) { //$NON-NLS-1$
				delta = true;
				height = Integer.parseInt(heightSpecification.substring(1));
			} else if ("".equals(heightSpecification)) { //$NON-NLS-1$
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
			if ("bold".equals(styleSpecification)) //$NON-NLS-1$
				bold = true;
			else if ("italic".equals(styleSpecification)) //$NON-NLS-1$
				italic = true;
			else if ("italic+bold".equals(styleSpecification) || "bold+italic".equals(styleSpecification)) //$NON-NLS-1$ //$NON-NLS-2$
				bold = italic = true;

			double size = delta ? Font.getDefault().getSize() + height : height;

			return Font.font(fontNameSpecification, bold ? FontWeight.BOLD : FontWeight.NORMAL, italic ? FontPosture.ITALIC : FontPosture.REGULAR, size);
		}

		return null;
	}

	static void applyItemProviderLabel(@NonNull Object item, @NonNull Cell<?> cell, @NonNull AdapterFactory adapterFactory) {
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

	static void applyTableItemProviderStyle(@NonNull Object item, int columnIndex, @NonNull Cell<?> cell, @NonNull AdapterFactory adapterFactory) {
		applyTableItemProviderLabel(item, columnIndex, cell, adapterFactory);
		applyTableItemProviderColor(item, columnIndex, cell, adapterFactory);
		applyTableItemProviderFont(item, columnIndex, cell, adapterFactory);
	}

	static void applyTableItemProviderLabel(@NonNull Object item, int columnIndex, @NonNull Cell<?> cell, @NonNull AdapterFactory adapterFactory) {
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

	static void applyTableItemProviderColor(@NonNull Object item, int columnIndex, @NonNull Cell<?> cell, @NonNull AdapterFactory adapterFactory) {
		ITableItemColorProvider colorProvider = (ITableItemColorProvider) adapterFactory.adapt(item, ITableItemColorProvider.class);
		if (colorProvider != null) {
			Color foreground = colorFromObject(colorProvider.getForeground(item, columnIndex));
			if (foreground != null)
				cell.setTextFill(foreground);

			String background = cssColorFromObject(colorProvider.getBackground(item, columnIndex));
			if (background != null)
				cell.setStyle("-fx-background-color: " + background); //$NON-NLS-1$
		}
	}

	static void applyTableItemProviderFont(@NonNull Object item, int columnIndex, @NonNull Cell<?> cell, @NonNull AdapterFactory adapterFactory) {
		ITableItemFontProvider fontProvider = (ITableItemFontProvider) adapterFactory.adapt(item, ITableItemFontProvider.class);
		if (fontProvider != null) {
			Font font = fontFromObject(fontProvider.getFont(item, columnIndex));
			if (font != null)
				cell.setFont(font);
		}
	}

	static Node graphicFromObject(@NonNull Object object) {
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

	static void applyItemProviderColor(@NonNull Object item, @NonNull Cell<?> cell, @NonNull AdapterFactory adapterFactory) {
		IItemColorProvider colorProvider = (IItemColorProvider) adapterFactory.adapt(item, IItemColorProvider.class);
		if (colorProvider != null) {
			Color foreground = colorFromObject(colorProvider.getForeground(item));
			if (foreground != null)
				cell.setTextFill(foreground);

			String background = cssColorFromObject(colorProvider.getBackground(item));
			if (background != null)
				cell.setStyle("-fx-background-color: " + background); //$NON-NLS-1$
		}
	}

	static Color colorFromObject(@NonNull Object object) {
		URI colorURI = toColorURI(object);

		if (colorURI != null) {
			try {
				int red = Integer.parseInt(colorURI.segment(0));
				int green = Integer.parseInt(colorURI.segment(1));
				int blue = Integer.parseInt(colorURI.segment(2));
				return Color.rgb(red, green, blue);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Cannot parse color values " + colorURI + ". " + e.getMessage()); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		return null;
	}

	static String cssColorFromObject(@NonNull Object object) {
		URI colorURI = toColorURI(object);

		if (colorURI != null)
			return "rgb(" + colorURI.segment(0) + ", " + colorURI.segment(1) + ", " + colorURI.segment(2) + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		return null;
	}

	static URI toColorURI(@NonNull Object object) {
		if (object instanceof URI) {
			URI colorURI = (URI) object;

			if (!"color".equals(colorURI.scheme())) //$NON-NLS-1$
				throw new IllegalArgumentException("Only 'color' scheme is recognized " + colorURI); //$NON-NLS-1$

			if (!"rgb".equals(colorURI.authority())) //$NON-NLS-1$
				throw new IllegalArgumentException("Only 'rgb' authority is recognized " + colorURI); //$NON-NLS-1$

			if (colorURI.segmentCount() != 3)
				throw new IllegalArgumentException("Color must have 3 segments (r, g, b) " + colorURI); //$NON-NLS-1$

			return colorURI;
		}

		return null;
	}

}
