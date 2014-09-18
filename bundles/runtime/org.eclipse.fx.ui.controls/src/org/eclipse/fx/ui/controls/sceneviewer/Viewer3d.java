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

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.ParallelCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

/**
 * Viewer for 3d models
 */
public final class Viewer3d extends Pane {
	private SubScene scene;
	private final Rotate cameraXRotation = new Rotate(-20, 0, 0, 0, Rotate.X_AXIS);
	private final Rotate cameraYRotation = new Rotate(-20, 0, 0, 0, Rotate.Y_AXIS);
	private final Translate cameraPosition = new Translate(0, 0, -20);
	private Camera camera;
	private double dragStartX, dragStartY, dragStartRotateX, dragStartRotateY;
	private RotateTransition rotateTransition;
	private Scale zoom = new Scale(1, 1, 1);
	private Group root;
	
	private ObjectProperty<Node> contentProperty = new SimpleObjectProperty<>(this, "content"); //$NON-NLS-1$
	private BooleanProperty animated = new SimpleBooleanProperty(this, "rotate"); //$NON-NLS-1$
	
	/**
	 * Create a new 3d viewer
	 */
	public Viewer3d() {
		this.root = new Group();
		this.scene = new SubScene(this.root, -1, -1, true, SceneAntialiasing.BALANCED);
		this.scene.setManaged(false);
		this.camera = setupCamera();
		this.scene.setCamera(this.camera);
		this.root.getChildren().add(this.camera);
		this.scene.widthProperty().addListener((o) -> updateSize());
		this.scene.heightProperty().addListener((o) -> updateSize());
		getChildren().add(this.scene);

		addEventHandler(MouseEvent.MOUSE_PRESSED,this::cameraRotationHandler);
		addEventHandler(MouseEvent.MOUSE_DRAGGED,this::cameraRotationHandler);
		addEventHandler(ScrollEvent.SCROLL, this::zoomHandler);
		
		contentProperty().addListener(this::contentHandler);
		contentRotateProperty().addListener(this::animationHandler);
	}
	
	@Override
	protected void layoutChildren() {
		this.scene.setWidth(getWidth());
		this.scene.setHeight(getHeight());
		super.layoutChildren();
	}
	
	private void animationHandler(Observable o) {
		if( this.rotateTransition != null ) {
			if( isContentRotate() ) {
				this.rotateTransition.play();
			} else {
				this.rotateTransition.stop();
			}
		}
	}
	
	private void contentHandler(Observable o) {
		if (this.root.getChildren().size() > 1) {
			this.root.getChildren().set(1, getContent());
		} else {
			this.root.getChildren().add(getContent());
		}
		getContent().getTransforms().setAll(this.zoom);

		updateSize();

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
		this.zoom.setX(this.zoom.getX() + event.getDeltaY() * 0.01);
		this.zoom.setY(this.zoom.getY() + event.getDeltaY() * 0.01);
		this.zoom.setZ(this.zoom.getZ() + event.getDeltaY() * 0.01);
	}
	
	private void updateSize() {
		if( this.contentProperty.get() != null) {
			Node content = this.contentProperty.get();
			double width = content.getLayoutBounds().getWidth();
			double height = content.getLayoutBounds().getHeight();
			double depth = content.getLayoutBounds().getDepth();
			content.setTranslateX(getWidth() / 2 - width / 2);
			content.setTranslateY(getHeight() / 2 + height / 2);
			content.setTranslateZ(-content.getLayoutBounds().getMinZ() - depth / 2);
		}	
	}
	
	private Camera setupCamera() {
		ParallelCamera camera = new ParallelCamera();
		camera.getTransforms().addAll(this.cameraXRotation, this.cameraYRotation,
				this.cameraPosition);
		return camera;
	}
	
	public void setContent(Node node) {
		this.contentProperty.set(node);
	}
	
	public Node getContent() {
		return contentProperty().get();
	}
	
	public ObjectProperty<Node> contentProperty() {
		return this.contentProperty;
	}
	
	public boolean isContentRotate() {
		return contentRotateProperty().get();
	}
	
	public void setContentRotate(boolean animated) {
		contentRotateProperty().set(animated);
	}
	
	public BooleanProperty contentRotateProperty() {
		return this.animated;
	}	
}
