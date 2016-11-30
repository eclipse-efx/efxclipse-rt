package org.eclipse.fx.text.ui.hover.internal;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ListBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableDoubleProperty;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.css.StyleableDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Window;

public class ResizeablePane extends Region {

	private DoubleProperty resizeHandleSize = new SimpleStyleableDoubleProperty(RESIZE_HANDLE_SIZE, this, "resizeHandleSize", Double.valueOf(5)); //$NON-NLS-1$
	private static final CssMetaData<ResizeablePane, Number> RESIZE_HANDLE_SIZE = new CssMetaData<ResizeablePane, Number>("-efx-resize-handle-size", StyleConverter.getSizeConverter(), Double.valueOf(5)) { //$NON-NLS-1$
		@Override
		public boolean isSettable(ResizeablePane n) {
			return (n.resizeHandleSize == null) || !n.resizeHandleSize.isBound();
		}
		@Override
		public StyleableDoubleProperty getStyleableProperty(ResizeablePane n) {
			return (StyleableDoubleProperty) n.resizeHandleSize;
		}
	};
	
	private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;
	static {

		final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<CssMetaData<? extends Styleable, ?>>(
				Region.getClassCssMetaData());
		styleables.add(RESIZE_HANDLE_SIZE);
		STYLEABLES = Collections.unmodifiableList(styleables);
	}

	/**
	* @return The CssMetaData associated with this class, which may include the
	* CssMetaData of its super classes.
	* @since JavaFX 8.0
	*/
	public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
	   return STYLEABLES;
	}

	
	
	@Override
	public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
	   return getClassCssMetaData();
	}
	
	
	private ObjectProperty<Node> contentProperty = new SimpleObjectProperty<>(this, "content");
	public ObjectProperty<Node> contentProperty() {
		return this.contentProperty;
	}
	public void setContent(Node node) {
		this.contentProperty().set(node);
	}
	public Node getContent() {
		return this.contentProperty().get();
	}
	
	private Node resizeWest;
	private Node resizeEast;
	private Node resizeSouth;
	private Node resizeNorth;

	private Node resizeNorthWest;
	private Node resizeNorthEast;
	private Node resizeSouthWest;
	private Node resizeSouthEast;
	
	public ResizeablePane() {
		initialize();
	}
	
	@Override
	protected double computeMinWidth(double height) {
		return 2 * this.resizeHandleSize.get() + getContent().minWidth(height);
	}
	
	@Override
	protected double computeMinHeight(double width) {
		return 2 * this.resizeHandleSize.get() + getContent().minHeight(width);
	}
	
	@Override
	protected double computePrefHeight(double width) {
		return 2 * this.resizeHandleSize.get() + getContent().prefHeight(width);
	}
	
	@Override
	protected double computePrefWidth(double height) {
		return 2 * this.resizeHandleSize.get() + getContent().prefWidth(height);
	}
	
	private Node createHandle(Cursor cursor) {
		Region handle = new Region();
		handle.setCursor(cursor);
		//handle.setStyle("-fx-border-color: green; -fx-border-width: 1px;");
		
		handle.setOnMousePressed(this.handler);
		handle.setOnMouseDragged(this.handler);
		handle.setOnMouseReleased(this.handler);
		
		return handle;
	}
	
	private class ContentListBinding extends ListBinding<Node> {

		public ContentListBinding() {
			bind(contentProperty());
		}
		
		@Override
		protected ObservableList<Node> computeValue() {
			Node center = contentProperty().get();
			if (center == null) {
				return FXCollections.observableArrayList(ResizeablePane.this.resizeWest, ResizeablePane.this.resizeEast, ResizeablePane.this.resizeSouth, ResizeablePane.this.resizeNorth, 
						ResizeablePane.this.resizeNorthWest, ResizeablePane.this.resizeNorthEast, ResizeablePane.this.resizeSouthWest, ResizeablePane.this.resizeSouthEast);
			}
			else {
				return FXCollections.observableArrayList(ResizeablePane.this.resizeWest, ResizeablePane.this.resizeEast, ResizeablePane.this.resizeSouth, ResizeablePane.this.resizeNorth, 
						ResizeablePane.this.resizeNorthWest, ResizeablePane.this.resizeNorthEast, ResizeablePane.this.resizeSouthWest, ResizeablePane.this.resizeSouthEast,
						center);
			}
		}
		
		@Override
		public void dispose() {
			super.dispose();
			unbind(contentProperty());
		}
	}
	
	private void initialize() {
		this.getStyleClass().add("resize-popup-pane"); //$NON-NLS-1$
		
		this.setBackground(new Background(new BackgroundFill(Color.rgb(20, 20, 20, 0.7), new CornerRadii(this. resizeHandleSize.get()), Insets.EMPTY)));
		
		this.resizeWest = createHandle(Cursor.W_RESIZE);
		this.resizeEast = createHandle(Cursor.E_RESIZE);
		this.resizeSouth = createHandle(Cursor.S_RESIZE);
		this.resizeNorth = createHandle(Cursor.N_RESIZE);
		this.resizeNorthWest = createHandle(Cursor.NW_RESIZE);
		this.resizeNorthEast = createHandle(Cursor.NE_RESIZE);
		this.resizeSouthWest = createHandle(Cursor.SW_RESIZE);
		this.resizeSouthEast = createHandle(Cursor.SE_RESIZE);
		
		ContentListBinding binding = new ContentListBinding();
		Bindings.bindContent(getChildren(), binding);
		
	}
	
	private ObjectProperty<Window> windowProperty = new SimpleObjectProperty<>(this, "window");
	public ObjectProperty<Window> windowProperty() {
		return this.windowProperty;
	}
	public void setWindow(Window window) {
		this.windowProperty().set(window);
	}
	public Window getWindow() {
		return this.windowProperty().get();
	}
	
	
	private Handler handler = new Handler();
	private class Handler implements EventHandler<MouseEvent> {

		double dragBeginX, dragBeginY;
		
		boolean rN, rS, rE, rW;
		
		
		double x, y, width, height;
		
		@Override
		public void handle(MouseEvent e) {
			if (MouseEvent.MOUSE_PRESSED == e.getEventType()) {
				System.err.println("BEGIN");
				this.dragBeginX = e.getScreenX();
				this.dragBeginY = e.getScreenY();
				
				this.x = getWindow().getX();
				this.y = getWindow().getY();
				this.width = getWidth();
				this.height = getHeight();
						
				if (e.getSource() == ResizeablePane.this.resizeNorth) {
					this.rN = true;
				}
				else if (e.getSource() == ResizeablePane.this.resizeNorthEast) {
					this.rN = true;
					this.rE = true;
				}
				else if (e.getSource() == ResizeablePane.this.resizeEast) {
					this.rE = true;
				}
				else if (e.getSource() == ResizeablePane.this.resizeSouthEast) {
					this.rS = true;
					this.rE = true;
				}
				else if (e.getSource() == ResizeablePane.this.resizeSouth) {
					this.rS = true;
				}
				else if (e.getSource() == ResizeablePane.this.resizeSouthWest) {
					this.rS = true;
					this.rW = true;
				}
				else if (e.getSource() == ResizeablePane.this.resizeWest) {
					this.rW = true;
				}
				else if (e.getSource() == ResizeablePane.this.resizeNorthWest) {
					this.rW = true;
					this.rN = true;
				}
 			}
			else if (MouseEvent.MOUSE_DRAGGED == e.getEventType()) {
//				System.err.println("MOVE");
				double x = this.x, y = this.y, width = this.width, height = this.height;
				double deltaX = e.getScreenX() - this.dragBeginX;
				double deltaY = e.getScreenY() - this.dragBeginY;
				double minWidth = getContent().minWidth(-1) + ResizeablePane.this.resizeHandleSize.get() * 2;
				double minHeight = getContent().minHeight(-1) + ResizeablePane.this.resizeHandleSize.get() * 2;
//				System.err.println( "=> " + minWidth + " / " + minHeight);
				if (this.rS) {
					height += deltaY;
					if (height < minHeight) {
						height = minHeight;
					}
				}
				if (this.rE) {
					width += deltaX;
					if (width < minWidth) {
						width = minWidth;
					}
				}
				if (this.rN) {
					y += deltaY;
					height -= deltaY;
					if (height < minHeight) {
						height = minHeight;
						y = this.y + this.height - minHeight;
					}
				}
				if (this.rW) {
					x += deltaX;
					width -= deltaX;
					if (width < minWidth) {
						width = minWidth;
						x = this.x + this.width - minWidth;
					}
				}
				
//				System.err.println(" R: " + width + " / " + height);
				// update
				
				resizeWindow(x, y, width, height);
			}
			else if (MouseEvent.MOUSE_RELEASED == e.getEventType()) {
				this.rN = false; this.rS = false; this.rE = false; this.rW = false;
			}
		}
		
	}
	
	private void resizeWindow(double x, double y, double width, double height) {
		getWindow().setX(x);
		getWindow().setY(y);
		setMinWidth(Math.max(computeMinWidth(height), width));
		setMinHeight(Math.max(computeMinHeight(width), height));
		setPrefWidth(width);
		setPrefHeight(height);
		setMaxWidth(width);
		setMaxHeight(height);
		getWindow().setWidth(width + 20);
		getWindow().setHeight(height + 20);
	}
	
	
	@Override
	protected void layoutChildren() {
		final double handleSize = this.resizeHandleSize.get();
		final double width = getWidth();
		final double height = getHeight();
		this.resizeWest.resizeRelocate(0, handleSize, handleSize, height - handleSize);
		this.resizeNorthWest.resizeRelocate(0, 0, handleSize, handleSize);
		this.resizeNorth.resizeRelocate(handleSize, 0, width - handleSize, handleSize);
		this.resizeNorthEast.resizeRelocate(width - handleSize, 0, handleSize, handleSize);
		this.resizeEast.resizeRelocate(width - handleSize, handleSize, handleSize, height - handleSize);
		this.resizeSouthEast.resizeRelocate(width - handleSize, height - handleSize, handleSize, handleSize);
		this.resizeSouth.resizeRelocate(handleSize, height - handleSize, width - handleSize, handleSize);
		this.resizeSouthWest.resizeRelocate(0, height - handleSize, handleSize, handleSize);
		Node center = contentProperty().get();
		if (center != null) {
			center.resizeRelocate(handleSize, handleSize, width - 2 * handleSize, height - 2 * handleSize);
		}
	}
	
}
