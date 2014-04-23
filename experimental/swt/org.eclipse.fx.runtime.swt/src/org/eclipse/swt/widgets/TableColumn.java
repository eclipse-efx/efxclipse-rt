/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation, BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   IBM Corporation - initial API
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.widgets;

import java.util.WeakHashMap;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Drawable;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Drawable.DrawableGC;
import org.eclipse.swt.internal.CanvasGC;
import org.eclipse.swt.internal.Util;
import org.eclipse.swt.widgets.TableItem.AttributeType;
import org.eclipse.swt.widgets.TableItem.Registration;

public class TableColumn extends Item {
	private javafx.scene.control.TableColumn<TableItem, CellItem> column;
	private int index;
	private Table parent;
	private boolean moveable;
	
	private WeakHashMap<TableColumnCell, Boolean> cellMap = new WeakHashMap<>();
	
	public TableColumn(Table parent, int style) {
		super(parent, style);
		this.parent = parent;
		// before we call the add because we'll maybe get called immediately
		index = parent.getColumnCount();
		parent.internal_columnAdded(this);
	}
	
	public TableColumn(Table parent, int style, int index) {
		super(parent, style);
		this.parent = parent;
		// before we call the add because we'll maybe get called immediately
		this.index = index;
		parent.internal_columnAdded(this, index);
	}

	@Override
	public String getText() {
		checkWidget();
		return notNullString(column.getText());
	}

	@Override
	public void setText(String string) {
		checkWidget();
		column.setText(string);
	}
	
	public void setToolTipText (String string) {
		Util.logNotImplemented();
	}

	@Override
	protected javafx.scene.control.TableColumn<TableItem, CellItem> createWidget() {
		column = new javafx.scene.control.TableColumn<TableItem, CellItem>();
		column.setCellValueFactory(new Callback<CellDataFeatures<TableItem,CellItem>, ObservableValue<CellItem>>() {
			
			@Override
			public ObservableValue<CellItem> call(CellDataFeatures<TableItem, CellItem> param) {
				return new SimpleObjectProperty<TableColumn.CellItem>(new CellItem(index,param.getValue())); 
			}
		});
		column.setCellFactory(new Callback<javafx.scene.control.TableColumn<TableItem, CellItem>, TableCell<TableItem,CellItem>>() {
			
			@Override
			public TableCell<TableItem, CellItem> call(
					javafx.scene.control.TableColumn<TableItem, CellItem> param) {
				TableColumnCell i = new TableColumnCell();
				i.addEventFilter(MouseEvent.MOUSE_CLICKED, new FXSelectionListener(i));
				return i;
			}
		});
		return column;
	}
	
	public void addControlListener(ControlListener listener) {
		Util.logNotImplemented();
	}
	
	public void addSelectionListener (SelectionListener listener) {
		Util.logNotImplemented();
	}
	
	public int getAlignment() {
		if( (getStyle() & SWT.LEFT) != 0 ) {
			return SWT.LEFT;
		} else if( (getStyle() & SWT.CENTER) != 0 ) {
			return SWT.CENTER;
		} else if( (getStyle() & SWT.RIGHT) != 0 ) {
			return SWT.RIGHT;
		}
		return SWT.LEFT;
	}

	
	public Table getParent () {
		checkWidget();
		return parent;
	}
	
	public boolean getMoveable () {
		checkWidget();
		return moveable;
	}
	
	public boolean getResizable () {
		checkWidget();
		return column.isResizable();
	}
	
	public String getToolTipText () {
		Util.logNotImplemented();
		return null;
	}
	
	public int getWidth () {
		checkWidget();
		return (int) column.getWidth();
	}
	
	public void pack () {
		Util.logNotImplemented();
	}
	
	public void removeControlListener (ControlListener listener) {
		Util.logNotImplemented();
	}
	
	public void removeSelectionListener(SelectionListener listener) {
		Util.logNotImplemented();
	}
	
	public void setAlignment (int alignment) {
		style &= ~(SWT.LEFT|SWT.CENTER|SWT.RIGHT);
		style |= alignment;
	}
	
	@Override
	public void setImage(Image image) {
		super.setImage(image);
		if( image == null ) {
			column.setGraphic(null);
		} else {
			column.setGraphic(new ImageView(image.internal_getImage()));			
		}
	}
	
	public void setMoveable (boolean moveable) {
		this.moveable = moveable;
		Util.logNotImplemented();
	}
	
	public void setResizable (boolean resizable) {
		column.setResizable(resizable);
	}
	
	public void setWidth (int width) {
		column.setPrefWidth(width);
	}
	
	@Override
	public javafx.scene.control.TableColumn<TableItem, CellItem> internal_getNativeObject() {
		return column;
	}
	
	class CellItem {
		private int index;
		private TableItem item;
		
		public CellItem(int index, TableItem item) {
			this.index = index;
			this.item = item;
		}
		
		String getText() {
			return item.getText(index);
		}
		
		Image getImage() {
			return item.getImage(index);
		}

		Color getForeground() {
			return item.getForeground(index);
		}

		Color getBackground() {
			return item.getBackground(index);
		}

		Font getFont() {
			return item.getFont(index);
		}
		
		
	}
	
	TableColumnCell getCell(TableItem item) {
		for( TableColumnCell c : cellMap.keySet() ) {
			if( c.currentItem.item == item ) {
				return c;
			}
		}
		parent.showItem(item);
		parent.showColumn(this);
		
		for( TableColumnCell c : cellMap.keySet() ) {
			if( c.currentItem.item == item ) {
				return c;
			}
		}
		
		return null; 
	}

	class TableColumnCell extends TableCell<TableItem, CellItem> implements Callback<TableItem.AttributeType, Void>, Drawable {
		private ImageView imageView;
		private CellItem currentItem;
		private Registration registration;
		private Control editor;
		private InvalidationListener selectionListner;
		private Canvas ownerDrawCanvas;
		private StackPane ownerDrawContainer;
		private HBox graphicItemsContainer;
		
		public TableColumnCell() {
			selectionListner = new InvalidationListener() {
				
				@Override
				public void invalidated(Observable observable) {
					updateVisuals();
				}
			};
			parentProperty().addListener(new ChangeListener<Parent>() {

				@Override
				public void changed(
						ObservableValue<? extends Parent> observable,
						Parent oldValue, Parent newValue) {
					if( oldValue != null && oldValue instanceof TableRow<?> ) {
						((TableRow<?>)oldValue).selectedProperty().removeListener(selectionListner);
					}
					if( newValue != null && newValue instanceof TableRow<?> ) {
						((TableRow<?>)newValue).selectedProperty().addListener(selectionListner);
					}
					updateVisuals();
				}
			});
		}
		
		
		@Override
		protected void updateItem(CellItem item, boolean empty) {
			if( registration != null ) {
				registration.dispose();
				registration = null;
			}
			
			if( item != null ) {
				registration = item.item.internal_registerModificationListener(item.index, this);
			}
			
			currentItem = item;
			
			if( item != null && ! empty ) {
				updateText();
				updateImage();
				updateVisuals();
				cellMap.put(this, Boolean.TRUE);
			} else {
				setText(null);
				setGraphic(null);
				setStyle(null);
				cellMap.remove(this);
			}
			super.updateItem(item, empty);
		}
		
		private void updateVisuals() {
			if( currentItem == null || getParent() == null || !(getParent() instanceof TableRow<?>) ) {
				setStyle(null);
				return;
			}
			if(  ((TableRow<?>)getParent()).isSelected() ) {
				Font f = currentItem.getFont();
				if( f != null ) {
					setStyle("-fx-font: "+f.internal_getAsCSSString()+";");
				} else {
					setStyle(null);
				}
			} else {
				Color fg = currentItem.getForeground();
				Color bg = currentItem.getBackground();
				Font f = currentItem.getFont();
				
				StringBuilder b = new StringBuilder();
				if( fg != null ) {
					String rgb = "rgb("+fg.getRed()+","+fg.getGreen()+","+fg.getBlue()+")";
					b.append("-fx-text-inner-color:"+rgb+" ; -fx-text-background-color: "+rgb+";");
				}
				if( bg != null ) {
					b.append("-fx-background-color: rgb("+bg.getRed()+","+bg.getGreen()+","+bg.getBlue()+");");
				}			
				if( f != null ) {
					b.append("-fx-font: "+f.internal_getAsCSSString()+";");
				}
				
				setStyle(b.length() == 0 ? null : b.toString());				
			}
		}
		
		private void updateText() {
			if( editor != null || parent.internal_isPaintItem() ) {
				setText(null);
			} else {
				setText(currentItem.getText());	
			}
		}
		
		private void updateImage() {
			//TODO Keep or hide image???
			Image img = currentItem.getImage();
			if( img != null ) {
				if( imageView == null ) {
					imageView = new ImageView(img.internal_getImage());
				} else {
					imageView.setImage(img.internal_getImage());
				}
				
				if( editor != null ) {
					HBox h = new HBox();
					h.getChildren().setAll(imageView, editor.internal_getNativeObject());
					setGraphic(h);
				} else {
					if( parent.internal_isPaintItem() ) {
						if( graphicItemsContainer == null ) {
							graphicItemsContainer = new HBox();
						}
						
						if( ownerDrawCanvas == null ) {
							initCanvas();
						}
						sendMeasureEvent();
//						sendPaintEvent();
						graphicItemsContainer.getChildren().setAll(imageView,ownerDrawContainer);
						setGraphic(ownerDrawContainer);
					} else {
						setGraphic(imageView);	
					}
				}
			} else {
				if( editor != null ) {
					setGraphic(editor.internal_getNativeObject());
				} else {
					if( parent.internal_isPaintItem() ) {
						if( ownerDrawCanvas == null ) {
							initCanvas();
						}
						sendMeasureEvent();
//						sendPaintEvent();
						setGraphic(ownerDrawContainer);
					} else {
						setGraphic(null);	
					}
				}
			}
		}
		
		private void initCanvas() {
			ownerDrawCanvas = new Canvas();
			ownerDrawContainer = new StackPane();
			
			InvalidationListener l = o -> { ownerDrawCanvas.setHeight(ownerDrawContainer.getHeight()); sendPaintEvent(); };
			ownerDrawContainer.heightProperty().addListener(l);
			
			l = o -> { ownerDrawCanvas.setWidth(ownerDrawContainer.getWidth()); sendPaintEvent(); };
			ownerDrawContainer.widthProperty().addListener(l);
			ownerDrawContainer.getChildren().add(ownerDrawCanvas);
		}
		
		@Override
		public DrawableGC internal_new_GC() {
			Font f = currentItem.item.getFont(index);
			if( f == null ) {
				f = currentItem.item.getParent().getFont();
			}
			return new CanvasGC(ownerDrawCanvas, f, currentItem.item.getBackground(index), currentItem.item.getForeground(index));
		}
		
		@Override
		public void internal_dispose_GC(DrawableGC gc) {
			gc.dispose();
		}
		
		private void sendPaintEvent() {
			Event event = new Event();
			event.item = currentItem.item;
			event.gc = new GC(this);
			ownerDrawCanvas.getGraphicsContext2D().clearRect(0,0,ownerDrawCanvas.getWidth(),ownerDrawCanvas.getHeight());
			parent.internal_sendEvent(SWT.PaintItem, event, true);
			event.gc.dispose();
		}
		
		private void sendMeasureEvent() {
			Event event = new Event();
			event.item = currentItem.item;
			event.gc = new GC(this);
			parent.internal_sendEvent(SWT.MeasureItem, event, true);
			ownerDrawCanvas.setWidth(event.width);
			ownerDrawCanvas.setHeight(event.height);
			event.gc.dispose();
		}
		
		private void sendEraseEvent() {
			
		}
		
		public void hideEditor() {
			this.editor = null;
			updateImage();
			updateText();
		}
		
		public void showEditor(Control control) {
			this.editor = control;
			updateImage();
			updateText();
			if( editor != null ) {
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						editor.setFocus();
					}
				});
			}
		}
		
		@Override
		public Void call(AttributeType param) {
			switch (param) {
			case IMAGE:
				updateImage();
				break;
			case TEXT:
				updateText();
				break;
			default:
				break;
			}
			return null;
		}
		
		public Rectangle getBounds() {
			Bounds bounds = getBoundsInParent();
			Point2D coords = parent.internal_getNativeObject().sceneToLocal(localToScene(0, 0));
			Rectangle r = new Rectangle((int)coords.getX(), (int)coords.getY(), (int)bounds.getWidth(), (int)bounds.getHeight());
			return r;
		}
	}
	
	//FIXME We need to remove this and reuse the selection model so that
	// we track keybindings double click are still handled like this
	class FXSelectionListener implements EventHandler<MouseEvent> {
		private TableColumnCell cell;
		
		public FXSelectionListener(TableColumnCell cell) {
			this.cell = cell;
		}
		
		@Override
		public void handle(MouseEvent event) {
			if( event.getClickCount() == 2 && cell.currentItem != null ) {
				Event evt = new Event();
				evt.item = cell.currentItem.item;
				internal_sendEvent(SWT.DefaultSelection, evt, true);
			} else {
				Event evt = new Event();
				evt.item = cell.currentItem.item;
				internal_sendEvent(SWT.Selection, evt, true);
			}
		}
	}
}
