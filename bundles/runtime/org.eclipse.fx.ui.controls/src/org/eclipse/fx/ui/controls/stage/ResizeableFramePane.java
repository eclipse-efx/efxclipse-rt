/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.stage;

import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.css.CssMetaData;
import javafx.css.SimpleStyleableDoubleProperty;
import javafx.css.StyleConverter;
import javafx.css.StyleableDoubleProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

/**
 * A window pane who has handles at the borders to resize it
 * 
 * @since 2.0
 */
public abstract class ResizeableFramePane extends StackPane implements Frame {
	private static final CssMetaData<ResizeableFramePane, Number> RESIZE_HANDLE_SIZE = new CssMetaData<ResizeableFramePane, Number>(
			"-efx-resize-handle-size", StyleConverter.getSizeConverter(), Double.valueOf(5)) { //$NON-NLS-1$

		@Override
		public boolean isSettable(ResizeableFramePane n) {
			return (n.resizeHandleSize == null) || !n.resizeHandleSize.isBound();
		}

		@Override
		public StyleableDoubleProperty getStyleableProperty(ResizeableFramePane n) {
			return (StyleableDoubleProperty) n.resizeHandleSize;
		}
	};
	
	
	private Rectangle2D backupWindowBounds;
	private double mouseDragDeltaX;
	private double mouseDragDeltaY;

	private Node resizeLeft;
	private Node resizeRight;
	private Node resizeBottom;
	private Node resizeTop;

	private Node resizeCornerRightBottom;
	private Node resizeCornerRightTop;
	private Node resizeCornerLeftBottom;
	private Node resizeCornerLeftTop;

	private BooleanProperty minimizable = new SimpleBooleanProperty(this, "minimizable", true); //$NON-NLS-1$
	private BooleanProperty maximizable = new SimpleBooleanProperty(this, "maximizable", true); //$NON-NLS-1$
	private BooleanProperty resizeable = new SimpleBooleanProperty(this, "resizeable", true); //$NON-NLS-1$
	private ReadOnlyBooleanWrapper lightweight = new ReadOnlyBooleanWrapper(this, "lightweight", false); //$NON-NLS-1$

	private ReadOnlyBooleanWrapper maximized = new ReadOnlyBooleanWrapper(this, "maximized", false); //$NON-NLS-1$
	DoubleProperty resizeHandleSize = new SimpleStyleableDoubleProperty(RESIZE_HANDLE_SIZE, this, "resizeHandleSize", Double.valueOf(5)); //$NON-NLS-1$

	enum Location {
		TOP, LEFT, RIGHT, BOTTOM
	}

	class ResizeHandler implements EventHandler<MouseEvent> {
		private double width;
		private double height;

		private double x;
		private double y;

		private Point2D dragAnchor;

		private Location[] locations;

		public ResizeHandler(Location... locations) {
			this.locations = locations;
		}

		@Override
		public void handle(MouseEvent event) {
			EventType<? extends MouseEvent> type = event.getEventType();

			if( type == MouseEvent.MOUSE_RELEASED ) {
				this.dragAnchor = null;
			} else if (type == MouseEvent.MOUSE_PRESSED) {
				this.x = getStage().getX();
				this.y = getStage().getY();
				this.width = getStage().getWidth();
				this.height = getStage().getHeight();
				this.dragAnchor = new Point2D(event.getScreenX(), event.getScreenY());
			} else if (type == MouseEvent.MOUSE_DRAGGED && this.dragAnchor != null) {
				if (!isLightweight()) {
					double deltaX = event.getScreenX() - this.dragAnchor.getX();
					double deltaY = event.getScreenY() - this.dragAnchor.getY();
					// update(this.x, this.y, this.width, this.height, deltaX,
					// deltaY);

					for (Location l : this.locations) {
						switch (l) {
						case TOP:
							getStage().setY(this.y + (int) deltaY);
							getStage().setHeight(this.height + -1 * (int) deltaY);
							break;
						case BOTTOM:
							getStage().setHeight(this.height + deltaY);
							break;
						case LEFT:
							getStage().setX(this.x + (int) deltaX);
							getStage().setWidth(this.width + -1 * (int) deltaX);
							break;
						case RIGHT:
							getStage().setWidth(this.width + deltaX);
							break;
						default:
							break;
						}
					}
				}
			}
		}
	}

	private ObservableValue<Window> windowProperty;

	/**
	 * Create a new pane which is used in a heavy-weight dialog
	 */
	public ResizeableFramePane() {
		this(false);
	}

	/**
	 * A resizeable frame pane
	 * 
	 * @param lighweight
	 *            <code>true</code> if used in a light-weight scenario
	 */
	public ResizeableFramePane(boolean lighweight) {
		this.lightweight.set(lighweight);
		Node windowNode = createWindowArea();
		getChildren().add(windowNode);
		initResize();
		if (!lighweight) {
			this.windowProperty = org.eclipse.fx.ui.controls.Util.windowProperty(this);
			this.windowProperty.addListener((o, oldV, newV) -> {
				if (oldV != null) {
					oldV.widthProperty().removeListener(this::handleStageChange);
					oldV.heightProperty().removeListener(this::handleStageChange);
					oldV.xProperty().removeListener(this::handleStageChange);
					oldV.yProperty().removeListener(this::handleStageChange);
				}

				if (newV != null) {
					newV.widthProperty().addListener(this::handleStageChange);
					newV.heightProperty().addListener(this::handleStageChange);
					newV.xProperty().addListener(this::handleStageChange);
					newV.yProperty().addListener(this::handleStageChange);
				}
			});
		}
	}

	private void handleStageChange(Observable o, Number oldVal, Number newVal) {
		getStyleClass().remove("window-maximized"); //$NON-NLS-1$
		this.maximized.set(false);
	}

	private void initResize() {
		initResizeLeft();
		initResizeRight();
		initResizeTop();
		initResizeBottom();

		initResizeCornerRightBottom();
		initResizeCornerRightTop();
		initResizeCornerLeftBottom();
		initResizeCornerLeftTop();
	}

	private void initResizeBottom() {
		this.resizeBottom = createBottomResize();
		this.resizeBottom.setManaged(false);
		getChildren().add(this.resizeBottom);

		ResizeHandler resizeHandler = new ResizeHandler(Location.BOTTOM);
		this.resizeBottom.setOnMousePressed(resizeHandler);
		this.resizeBottom.setOnMouseDragged(resizeHandler);
		this.resizeBottom.setOnMouseReleased(resizeHandler);
	}

	private void initResizeTop() {
		this.resizeTop = createTopResize();
		this.resizeTop.setManaged(false);
		getChildren().add(this.resizeTop);

		ResizeHandler h = new ResizeHandler(Location.TOP);
		this.resizeTop.setOnMousePressed(h);
		this.resizeTop.setOnMouseDragged(h);
		this.resizeTop.setOnMouseReleased(h);
	}

	private void initResizeLeft() {
		this.resizeLeft = createLeftResize();
		this.resizeLeft.setManaged(false);
		getChildren().add(this.resizeLeft);

		ResizeHandler h = new ResizeHandler(Location.LEFT);
		this.resizeLeft.setOnMousePressed(h);
		this.resizeLeft.setOnMouseDragged(h);
		this.resizeLeft.setOnMouseReleased(h);
	}

	private void initResizeRight() {
		this.resizeRight = createRightResize();
		this.resizeRight.setManaged(false);
		getChildren().add(this.resizeRight);

		ResizeHandler h = new ResizeHandler(Location.RIGHT);
		this.resizeRight.setOnMousePressed(h);
		this.resizeRight.setOnMouseDragged(h);
		this.resizeRight.setOnMouseReleased(h);
	}

	private void initResizeCornerRightBottom() {
		this.resizeCornerRightBottom = createResizeCornerRightBottom();
		this.resizeCornerRightBottom.setManaged(false);
		getChildren().add(this.resizeCornerRightBottom);

		ResizeHandler h = new ResizeHandler(Location.BOTTOM, Location.RIGHT);
		this.resizeCornerRightBottom.setOnMousePressed(h);
		this.resizeCornerRightBottom.setOnMouseDragged(h);
		this.resizeCornerRightBottom.setOnMouseReleased(h);
	}

	private void initResizeCornerRightTop() {
		this.resizeCornerRightTop = createResizeCornerRightTop();
		this.resizeCornerRightTop.setManaged(false);
		getChildren().add(this.resizeCornerRightTop);

		ResizeHandler h = new ResizeHandler(Location.TOP, Location.RIGHT);
		this.resizeCornerRightTop.setOnMousePressed(h);
		this.resizeCornerRightTop.setOnMouseDragged(h);
		this.resizeCornerRightTop.setOnMouseReleased(h);
	}

	private void initResizeCornerLeftBottom() {
		this.resizeCornerLeftBottom = createResizeCornerLeftBottom();
		this.resizeCornerLeftBottom.setManaged(false);
		getChildren().add(this.resizeCornerLeftBottom);

		ResizeHandler h = new ResizeHandler(Location.BOTTOM, Location.LEFT);
		this.resizeCornerLeftBottom.setOnMousePressed(h);
		this.resizeCornerLeftBottom.setOnMouseDragged(h);
		this.resizeCornerLeftBottom.setOnMouseReleased(h);
	}

	private void initResizeCornerLeftTop() {
		this.resizeCornerLeftTop = createResizeCornerLeftTop();
		this.resizeCornerLeftTop.setManaged(false);
		getChildren().add(this.resizeCornerLeftTop);

		ResizeHandler h = new ResizeHandler(Location.TOP, Location.LEFT);
		this.resizeCornerLeftTop.setOnMousePressed(h);
		this.resizeCornerLeftTop.setOnMouseDragged(h);
		this.resizeCornerLeftTop.setOnMouseReleased(h);
	}

	/**
	 * Register the title bar which is the area used to drag the window around
	 * 
	 * @param node
	 *            the node
	 */
	protected void registerTitleBar(Node node) {
		node.setOnMousePressed(event -> {
			this.mouseDragDeltaX = event.getSceneX();
			this.mouseDragDeltaY = event.getSceneY();
		});
		node.setOnMouseDragged(event -> {
			getStage().setX(event.getScreenX() - this.mouseDragDeltaX);
			getStage().setY(event.getScreenY() - this.mouseDragDeltaY);
		});
		node.setOnMouseClicked(e -> {
			if (e.getClickCount() > 1) {
				if (this.maximized.get()) {
					restore();
				} else {
					maximize();
				}

			}
		});
	}

	/**
	 * @return the node acting as the root container in the window
	 */
	protected abstract Node createWindowArea();

	/**
	 * @return the stage
	 */
	protected Stage getStage() {
		return (Stage) getScene().getWindow();
	}

	private static Node createResizeCornerRightBottom() {
		Pane resizeCorner = new Pane();
		resizeCorner.getStyleClass().add("window-resize-corner-right-bottom"); //$NON-NLS-1$
		return resizeCorner;
	}

	private static Node createResizeCornerRightTop() {
		Pane resizeCorner = new Pane();
		resizeCorner.getStyleClass().add("window-resize-corner-right-top"); //$NON-NLS-1$
		return resizeCorner;
	}

	private static Node createResizeCornerLeftBottom() {
		Pane resizeCorner = new Pane();
		resizeCorner.getStyleClass().add("window-resize-corner-left-bottom"); //$NON-NLS-1$
		return resizeCorner;
	}

	private static Node createResizeCornerLeftTop() {
		Pane resizeCorner = new Pane();
		resizeCorner.getStyleClass().add("window-resize-corner-left-top"); //$NON-NLS-1$
		return resizeCorner;
	}

	private static Node createLeftResize() {
		Pane resizeCorner = new Pane();
		resizeCorner.getStyleClass().add("window-resize-left"); //$NON-NLS-1$
		return resizeCorner;
	}

	private static Node createRightResize() {
		Pane resizeCorner = new Pane();
		resizeCorner.getStyleClass().add("window-resize-right"); //$NON-NLS-1$
		return resizeCorner;
	}

	private static Node createTopResize() {
		Pane resizeCorner = new Pane();
		resizeCorner.getStyleClass().add("window-resize-top"); //$NON-NLS-1$
		return resizeCorner;
	}

	private static Node createBottomResize() {
		Pane resizeCorner = new Pane();
		resizeCorner.getStyleClass().add("window-resize-bottom"); //$NON-NLS-1$
		return resizeCorner;
	}

	/**
	 * Set the main content to be displayed by this window
	 * 
	 * @param content
	 *            the content node
	 */
	public final void setContent(Node content) {
		contentProperty().set(content);
	}

	/**
	 * The main content to be displayed by this window
	 * 
	 * @return the current content
	 */
	public final Node getContent() {
		return contentProperty().get();
	}

	/**
	 * The main content to be displayed by this window
	 * 
	 * @return the property to observe
	 */
	public final ObjectProperty<Node> contentProperty() {
		return impl_contentProperty();
	}

	/**
	 * @return the real content property
	 */
	protected abstract ObjectProperty<Node> impl_contentProperty();

	@Override
	public final void setTitle(String title) {
		titleProperty().set(title);
	}

	/**
	 * @return the current title
	 */
	public final String getTitle() {
		return titleProperty().get();
	}

	/**
	 * @return the title property
	 */
	public final StringProperty titleProperty() {
		return impl_titleProperty();
	}

	/**
	 * @return the real title property
	 */
	protected abstract StringProperty impl_titleProperty();

	@Override
	public final void setClientArea(Node node) {
		clientAreaProperty().set(node);
	}

	/**
	 * @return the current client area node
	 */
	public final Node getClientArea() {
		return clientAreaProperty().get();
	}

	/**
	 * @return the client area property
	 */
	public final ObjectProperty<Node> clientAreaProperty() {
		return impl_clientAreaProperty();
	}

	/**
	 * @return the real client area property
	 */
	protected abstract ObjectProperty<Node> impl_clientAreaProperty();

	/**
	 * Maximize the window
	 */
	protected void maximize() {
		// We are bound to the stage
		if (!isLightweight()) {
			Stage stage = getStage();
			final double stageY = stage.getY();
			final Screen screen = Screen.getScreensForRectangle(stage.getX(), stageY, 1, 1).get(0);

			this.backupWindowBounds = new Rectangle2D(stage.getX(), stage.getY(), stage.getWidth(), stage.getHeight());
			final double newStageY = screen.getVisualBounds().getMinY();
			stage.setX(screen.getVisualBounds().getMinX());
			stage.setY(newStageY);
			stage.setWidth(screen.getVisualBounds().getWidth());
			stage.setHeight(screen.getVisualBounds().getHeight());
			getStyleClass().add("window-maximized"); //$NON-NLS-1$
			// stage.setMaximized(true);
			this.maximized.set(true);
		} else {
			// We are embedded into a container do nothing
		}
	}

	/**
	 * Restore the window to original size
	 */
	protected void restore() {
		if (!isLightweight()) {
			if (this.backupWindowBounds != null) {
				Stage stage = getStage();
				stage.setX(this.backupWindowBounds.getMinX());
				stage.setY(this.backupWindowBounds.getMinY());
				stage.setWidth(this.backupWindowBounds.getWidth());
				stage.setHeight(this.backupWindowBounds.getHeight());
				stage.setMaximized(false);
				this.backupWindowBounds = null;
			}
		}
	}

	/**
	 * @return The current state of the maximized property
	 */
	protected ReadOnlyBooleanProperty maximizedProperty() {
		return this.maximized.getReadOnlyProperty();
	}

	/**
	 * Close the window
	 */
	protected void close() {
		if( isLightweight() ) {
			// We are bound to the stage
			FrameEvent evt = new FrameEvent(this, FrameEvent.CLOSING);
			Event.fireEvent(this, evt);
			if (!evt.isConsumed()) {
				Event.fireEvent(this, new FrameEvent(this, FrameEvent.CLOSED));
			}			
		} else {
			WindowEvent event = new WindowEvent(getStage(), WindowEvent.WINDOW_CLOSE_REQUEST);
			Event.fireEvent(getStage(), event);
			if( ! event.isConsumed() ) {
				getStage().close();
			}
		}
	}

	/**
	 * Minimize the window
	 */
	protected void minimize() {
		// We are bound to the stage
		if (!isLightweight()) {
			getStage().setIconified(true);
		} else {
			// We are embedded into a container do nothing
		}
	}

	@Override
	public final void setMaximizable(boolean maximizeable) {
		this.maximizable.set(maximizeable);
	}

	/**
	 * Observable property defining of the dialog is maximizable
	 * 
	 * @return the property
	 */
	public final BooleanProperty maximizableProperty() {
		return this.maximizable;
	}

	/**
	 * @return check if maximizable
	 */
	public final boolean isMaximizable() {
		return this.maximizable.get();
	}

	@Override
	public final void setMinimizable(boolean minimizable) {
		this.minimizable.set(minimizable);
	}

	/**
	 * Observable property defining of the dialog is minimizable
	 * 
	 * @return the property
	 */
	public final BooleanProperty minimizableProperty() {
		return this.minimizable;
	}

	/**
	 * @return check if the dialog is minizable
	 */
	public final boolean isMinimizable() {
		return this.minimizable.get();
	}

	@Override
	public final void setResizeable(boolean resizable) {
		this.resizeable.set(resizable);
	}

	/**
	 * @return the resize handle size
	 */
	public double getResizeHandleSize() {
		return this.resizeHandleSize.get();
	}

	/**
	 * Set a handle size
	 * 
	 * @param size
	 *            the size
	 */
	public void setResizeHandleSize(double size) {
		this.resizeHandleSize.set(size);
	}
	
	/**
	 * @return property to observe the size
	 */
	public DoubleProperty resizeHandleSize() {
		return this.resizeHandleSize;
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();
		if (this.resizeLeft != null) {
			this.resizeLeft.resizeRelocate(0, this.getResizeHandleSize(), this.getResizeHandleSize(), getHeight() - 2 * this.getResizeHandleSize());
			this.resizeLeft.visibleProperty().bind(this.resizeable);
		}

		if (this.resizeRight != null) {
			this.resizeRight.resizeRelocate(getWidth() - this.getResizeHandleSize(), this.getResizeHandleSize(), this.getResizeHandleSize(), getHeight() - 2 * this.getResizeHandleSize());
			this.resizeRight.visibleProperty().bind(this.resizeable);
		}

		if (this.resizeTop != null) {
			this.resizeTop.resizeRelocate(this.getResizeHandleSize(), 0, getWidth() - this.getResizeHandleSize(), this.getResizeHandleSize());
			this.resizeTop.visibleProperty().bind(this.resizeable);
		}

		if (this.resizeBottom != null) {
			this.resizeBottom.resizeRelocate(this.getResizeHandleSize(), getHeight() - this.getResizeHandleSize(), getWidth() - this.getResizeHandleSize(), this.getResizeHandleSize());
			this.resizeBottom.visibleProperty().bind(this.resizeable);
		}

		if (this.resizeCornerRightBottom != null) {
			this.resizeCornerRightBottom.resizeRelocate(getWidth() - this.getResizeHandleSize(), getHeight() - this.getResizeHandleSize(), this.getResizeHandleSize(), this.getResizeHandleSize());
			this.resizeCornerRightBottom.visibleProperty().bind(this.resizeable);
		}

		if (this.resizeCornerRightTop != null) {
			this.resizeCornerRightTop.resizeRelocate(getWidth() - this.getResizeHandleSize(), 0, this.getResizeHandleSize(), this.getResizeHandleSize());
			this.resizeCornerRightTop.visibleProperty().bind(this.resizeable);
		}

		if (this.resizeCornerLeftBottom != null) {
			this.resizeCornerLeftBottom.resizeRelocate(0, getHeight() - this.getResizeHandleSize(), this.getResizeHandleSize(), this.getResizeHandleSize());
			this.resizeCornerLeftBottom.visibleProperty().bind(this.resizeable);
		}

		if (this.resizeCornerLeftTop != null) {
			this.resizeCornerLeftTop.resizeRelocate(0, 0, this.getResizeHandleSize(), this.getResizeHandleSize());
			this.resizeCornerLeftTop.visibleProperty().bind(this.resizeable);
		}
	}

	/**
	 * @return is the frame lightweight
	 */
	public final ReadOnlyBooleanProperty lightweightProperty() {
		return this.lightweight.getReadOnlyProperty();
	}

	/**
	 * @return check if the frame is lightweight
	 */
	public final boolean isLightweight() {
		return this.lightweightProperty().get();
	}

}
