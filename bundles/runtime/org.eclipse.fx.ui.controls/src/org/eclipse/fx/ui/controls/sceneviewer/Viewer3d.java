/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.sceneviewer;

import java.util.function.Consumer;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Viewer for 3d models
 *
 * @since 1.1
 */
public final class Viewer3d extends Pane {
	private SubScene scene;
	private final Rotate cameraXRotation = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
	private final Rotate cameraYRotation = new Rotate(-35, 0, 0, 0, Rotate.Y_AXIS);
	private final Translate cameraPosition = new Translate(0, 0, -100);
	private Camera camera;
	private double dragStartX, dragStartY, dragStartRotateX, dragStartRotateY;
	private RotateTransition rotateTransition;
	Scale contentScale = new Scale(1, 1, 1);
	private Group contentGroup;

	@SuppressWarnings("null")
	@NonNull
	private final ObservableList<@NonNull Node> selectedNodes = FXCollections.observableArrayList();
	@NonNull
	private final ObjectProperty<@Nullable Node> hoverNode = new SimpleObjectProperty<>(this, "hoverNode"); //$NON-NLS-1$
	@NonNull
	private final ObjectProperty<@Nullable Node> contentProperty = new SimpleObjectProperty<>(this, "content"); //$NON-NLS-1$
	@NonNull
	private final BooleanProperty animated = new SimpleBooleanProperty(this, "rotate"); //$NON-NLS-1$

	/**
	 * Create a new 3d viewer
	 */
	public Viewer3d() {
		this.contentGroup = new Group();
		this.contentGroup.getTransforms().add(this.contentScale);
		Group root = new Group(this.contentGroup);
		this.scene = new SubScene(root, -1, -1, true, SceneAntialiasing.BALANCED);
		this.scene.setManaged(false);
		this.camera = setupCamera();
		this.scene.setCamera(this.camera);
		root.getChildren().add(this.camera);
		this.scene.widthProperty().addListener((o) -> updateSize());
		this.scene.heightProperty().addListener((o) -> updateSize());
		getChildren().add(this.scene);

		addEventHandler(MouseEvent.MOUSE_PRESSED, this::cameraRotationHandler);
		addEventHandler(MouseEvent.MOUSE_DRAGGED, this::cameraRotationHandler);
		addEventHandler(ScrollEvent.SCROLL, this::zoomHandler);

		contentProperty().addListener(this::contentHandler);
		contentRotateProperty().addListener(this::animationHandler);
	}

	/**
	 * Property slot to hold an open item handler
	 *
	 * @return the property
	 */
	public final @NonNull ObjectProperty<@Nullable EventHandler<OpenItemEvent>> onOpenItemProperty() {
		return this.onOpenItem;
	}

	/**
	 * Set an open item handler
	 *
	 * @param value
	 *            the new handler
	 */
	public final void setOnOpenItem(@Nullable EventHandler<OpenItemEvent> value) {
		onOpenItemProperty().set(value);
	}

	/**
	 * @return the current open item handler
	 */
	public final @Nullable EventHandler<OpenItemEvent> getOpenItem() {
		return onOpenItemProperty().get();
	}

	@NonNull
	private final ObjectProperty<@Nullable EventHandler<OpenItemEvent>> onOpenItem = new ObjectPropertyBase<@Nullable EventHandler<OpenItemEvent>>() {
		@SuppressWarnings("synthetic-access")
		@Override
		protected void invalidated() {
			setEventHandler(OpenItemEvent.OPEN_ITEM, get());
		}

		@Override
		public Object getBean() {
			return Viewer3d.this;
		}

		@Override
		public String getName() {
			return "onOpenItem"; //$NON-NLS-1$
		}
	};

	@Override
	protected void layoutChildren() {
		this.scene.setWidth(getWidth());
		this.scene.setHeight(getHeight());
		super.layoutChildren();
	}

	/**
	 * Zoom out
	 *
	 * @param percentage
	 *            the percentage to zoom out
	 */
	public void zoomIn(double percentage) {
		this.contentScale.setX(this.contentScale.getX() + this.contentScale.getX() * percentage);
		this.contentScale.setY(this.contentScale.getY() + this.contentScale.getY() * percentage);
		this.contentScale.setZ(this.contentScale.getZ() + this.contentScale.getZ() * percentage);
	}

	/**
	 * Zoom in
	 *
	 * @param percentage
	 *            the percentage to zoom in
	 */
	public void zoomOut(double percentage) {
		this.contentScale.setX(this.contentScale.getX() - this.contentScale.getX() * percentage);
		this.contentScale.setY(this.contentScale.getY() - this.contentScale.getY() * percentage);
		this.contentScale.setZ(this.contentScale.getZ() - this.contentScale.getZ() * percentage);
	}

	/**
	 * Reset the zoom
	 */
	public void resetZoom() {
		this.contentScale.setX(1);
		this.contentScale.setY(1);
		this.contentScale.setZ(1);
	}

	/**
	 * Zoom to the target factor
	 *
	 * @param target
	 *            the target factor
	 * @param duration
	 *            the duration
	 * @param r
	 *            consumer called at the end of the zooming
	 */
	public void zoomTo(double target, Duration duration, Consumer<ActionEvent> r) {
		if (duration != null) {
			double startX = this.contentScale.getX();
			double delta = target - startX;

			Transition t = new Transition() {
				{
					this.setCycleDuration(duration);
				}

				@Override
				protected void interpolate(double frac) {
					Viewer3d.this.contentScale.setX(startX + delta * frac);
					Viewer3d.this.contentScale.setY(startX + delta * frac);
					Viewer3d.this.contentScale.setZ(startX + delta * frac);
				}
			};

			if (r != null) {
				t.setOnFinished((e) -> r.accept(e));
			}

			t.playFromStart();
		} else {
			Viewer3d.this.contentScale.setX(target);
			Viewer3d.this.contentScale.setY(target);
			Viewer3d.this.contentScale.setZ(target);
		}

	}

	private void animationHandler(Observable o) {
		if (this.rotateTransition != null) {
			if (isContentRotate()) {
				this.rotateTransition.play();
			} else {
				this.rotateTransition.stop();
			}
		}
	}

	private void attachListener() {
		Node n = getContent();
		if (n != null) {
			for (Node c : n.lookupAll(".component")) { //$NON-NLS-1$
				if (c.getId() != null) {
					for (Node s : c.lookupAll(".shape")) { //$NON-NLS-1$
						s.setOnMouseEntered((e) -> {
							this.hoverNode.set(c);
						});
						s.setOnMouseExited((e) -> {
							if (this.hoverNode.get() == c) {
								this.hoverNode.set(null);
							}
						});
						s.setOnMouseReleased((e) -> {
							if (e.getClickCount() == 2) {
								fireEvent(new OpenItemEvent(c));
							} else {
								this.selectedNodes.clear();
								this.selectedNodes.add(c);
							}
						});
					}
				}
			}
		}
	}

	private void contentHandler(Observable o) {
		if (getContent() == null) {
			this.contentGroup.getChildren().clear();
		} else {
			this.contentGroup.getChildren().setAll(getContent());
		}

		attachListener();
		updateSize();
		this.selectedNodes.clear();
		this.hoverNode.set(null);

		if (this.rotateTransition != null) {
			this.rotateTransition.stop();
		}

		this.rotateTransition = new RotateTransition();
		this.rotateTransition.setAxis(Rotate.Y_AXIS);
		this.rotateTransition.setDelay(Duration.millis(4));
		this.rotateTransition.setDuration(Duration.millis(5000));
		this.rotateTransition.setCycleCount(Animation.INDEFINITE);
		this.rotateTransition.setAutoReverse(false);
		this.rotateTransition.setInterpolator(Interpolator.LINEAR);
		this.rotateTransition.setByAngle(360);
		this.rotateTransition.setNode(getContent());

		if (this.animated.get()) {
			this.rotateTransition.play();
		}
	}

	private void cameraRotationHandler(MouseEvent event) {
		if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			this.dragStartX = event.getSceneX();
			this.dragStartY = event.getSceneY();
			this.dragStartRotateX = this.cameraXRotation.getAngle();
			this.dragStartRotateY = this.cameraYRotation.getAngle();
		} else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			double xDelta = event.getSceneX() - this.dragStartX;
			double yDelta = event.getSceneY() - this.dragStartY;
			this.cameraXRotation.setAngle(this.dragStartRotateX - (yDelta * 0.7));
			this.cameraYRotation.setAngle(this.dragStartRotateY + (xDelta * 0.7));
		}
	}

	private void zoomHandler(ScrollEvent event) {
		this.contentScale.setX(this.contentScale.getX() + event.getDeltaY() * 0.01);
		this.contentScale.setY(this.contentScale.getY() + event.getDeltaY() * 0.01);
		this.contentScale.setZ(this.contentScale.getZ() + event.getDeltaY() * 0.01);
	}

	private void updateSize() {
		@Nullable
		Node content = this.contentProperty.get();
		if (content != null) {
			double width = content.getLayoutBounds().getWidth();
			double height = content.getLayoutBounds().getHeight();
			double depth = content.getLayoutBounds().getDepth();
			content.setTranslateX(+7.8 - width / 2);
			content.setTranslateY(height / 2);
			content.setTranslateZ(+7.8 - depth / 2);
			this.cameraPosition.setX(getWidth() / -2);
			this.cameraPosition.setY(getHeight() / -2);
		}
	}

	private Camera setupCamera() {
		PerspectiveCamera camera = new PerspectiveCamera();
		camera.getTransforms().addAll(this.cameraXRotation, this.cameraYRotation, this.cameraPosition);
		return camera;
	}

	/**
	 * Set the content node
	 *
	 * @param node
	 *            the new content node
	 */
	public void setContent(@Nullable Node node) {
		this.contentProperty.set(node);
	}

	/**
	 * Get the current content node
	 *
	 * @return the new node
	 */
	public @Nullable Node getContent() {
		return contentProperty().get();
	}

	/**
	 * @return the content node
	 */
	public @NonNull ObjectProperty<@Nullable Node> contentProperty() {
		return this.contentProperty;
	}

	/**
	 * Check if the content is rotating
	 *
	 * @return <code>true</code> if rotating
	 */
	public boolean isContentRotate() {
		return contentRotateProperty().get();
	}

	/**
	 * Start/Stop the rotation of the content
	 *
	 * @param rotate
	 *            the new value
	 */
	public void setContentRotate(boolean rotate) {
		contentRotateProperty().set(rotate);
	}

	/**
	 * @return the rotation property
	 */
	public @NonNull BooleanProperty contentRotateProperty() {
		return this.animated;
	}

	/**
	 * @return list of currently selected nodes
	 */
	public @NonNull ObservableList<@NonNull Node> getSelectedNodes() {
		return this.selectedNodes;
	}

	/**
	 * @return currently hover node
	 */
	public @NonNull ReadOnlyObjectProperty<@Nullable Node> hoverNodeProperty() {
		return this.hoverNode;
	}

	/**
	 * @return the currently hovered node
	 */
	public @Nullable Node getHoverNode() {
		return this.hoverNode.get();
	}
}
