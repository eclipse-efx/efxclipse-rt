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

import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;

/**
 * A default implementation for the window
 * 
 * @since 2.0
 */
public class DefaultFramePane extends ResizeableFramePane {
	/**
	 * A node representing the title area
	 */
	public interface TitleAreaNode {
		/**
		 * @return the title property
		 */
		public StringProperty titleProperty();

		/**
		 * @return the button used to minimize
		 */
		public Node getMinButton();
	}

	private static final PseudoClass ACTIVE_PSEUDO_CLASS = PseudoClass.getPseudoClass("active"); //$NON-NLS-1$

	private ObjectProperty<@Nullable Node> contentProperty;
	private StringProperty titleProperty;

	private TitleAreaNode dialogAreaNode;

	/**
	 * Create a default window pane
	 */
	public DefaultFramePane() {
		this(null);
	}
	
	public DefaultFramePane(boolean lightweight) {
		this(null,lightweight);
	}

	/**
	 * Create a default window pane with a default client area as
	 * {@link #setContent(Node)}
	 * 
	 * @param clientArea
	 *            a client area
	 */
	public DefaultFramePane(@Nullable Pane clientArea) {
		this(clientArea,false);
	}
	
	public DefaultFramePane(@Nullable Pane clientArea, boolean lighteight) {
		super(lighteight);
		if( lighteight ) {
			setMinimizable(false);
			setMaximizable(false);
		}
		clientAreaProperty().addListener(this::updateClientArea);
		if (clientArea != null) {
			clientArea.setId("client-area"); //$NON-NLS-1$
			setContent(clientArea);
		}
	}

	@SuppressWarnings("null")
	@Override
	protected Node createWindowArea() {
		BorderPane root = new BorderPane();

		getStyleClass().addAll("default-window", "decorated-root"); //$NON-NLS-1$ //$NON-NLS-2$

		Node dialogTitleBar = createTitleBar();
		this.dialogAreaNode = (TitleAreaNode) dialogTitleBar;
		registerTitleBar(dialogTitleBar);
		this.titleProperty = ((TitleAreaNode) dialogTitleBar).titleProperty();

		root.setTop(dialogTitleBar);
		dialogTitleBar.applyCss();

		sceneProperty().addListener((o) -> {
			Scene s = getScene();
			if (s != null) {
				if (s.getWindow() != null) {
					handleStageAttached();
				} else {
					s.windowProperty().addListener((o2) -> {
						if (s.getWindow() != null) {
							handleStageAttached();
						}
					});
				}
			}
		});

		this.trimPane = new BorderPane();
		root.setCenter(this.trimPane);

		this.contentProperty = this.trimPane.centerProperty();

		return root;
	}

	private void handleStageAttached() {
		if( ! isLightweight() ) {
			handleFocus(getStage().focusedProperty());
			if (getStage().getModality() == Modality.WINDOW_MODAL) {
				this.dialogAreaNode.getMinButton().setVisible(false);
			}			
		}
	}

	/**
	 * @return the title bar
	 */
	@SuppressWarnings("unchecked")
	protected <N extends Node & TitleAreaNode> N createTitleBar() {
		return (N) new TitleAreaNodeImpl();
	}

	class TitleAreaNodeImpl extends ToolBar implements TitleAreaNode {
		private static final int HEADER_HEIGHT = 28;
		private Label titleLabel;
		private WindowButton minButton;

		public TitleAreaNodeImpl() {
			getStyleClass().add("window-header"); //$NON-NLS-1$
			setPrefHeight(HEADER_HEIGHT);
			setMinHeight(HEADER_HEIGHT);
			setMaxHeight(HEADER_HEIGHT);

			this.titleLabel = new Label();
			this.titleLabel.setMaxHeight(Double.MAX_VALUE);
			this.titleLabel.setId("window-label-title"); //$NON-NLS-1$
			this.titleLabel.getStyleClass().add("window-title"); //$NON-NLS-1$

			Region spacer = new Region();
			HBox.setHgrow(spacer, Priority.ALWAYS);

			// add close min max
			WindowButton closeButton = new WindowButton("close"); //$NON-NLS-1$
			closeButton.setFocusTraversable(false);
			closeButton.setOnAction(e -> close());

			this.minButton = new WindowButton("minimize"); //$NON-NLS-1$
			this.minButton.setFocusTraversable(false);
			this.minButton.setOnAction(e -> minimize());
			this.minButton.visibleProperty().bind(minimizableProperty());
			
			WindowButton maxButton = new WindowButton("maximize"); //$NON-NLS-1$
			maxButton.setFocusTraversable(false);
			maxButton.setOnAction(e -> maximize());
			maxButton.visibleProperty().bind(maximizableProperty());

			HBox windowBtns = new HBox(3);
			windowBtns.getStyleClass().add("window-buttons"); //$NON-NLS-1$
			windowBtns.getChildren().addAll(this.minButton, maxButton, closeButton);

			getItems().addAll(this.titleLabel, spacer, windowBtns);
		}

		@Override
		public StringProperty titleProperty() {
			return this.titleLabel.textProperty();
		}

		@Override
		public Node getMinButton() {
			return this.minButton;
		}
	}

	private void handleFocus(ReadOnlyBooleanProperty readOnlyBooleanProperty) {
		readOnlyBooleanProperty.addListener((o) -> {
			pseudoClassStateChanged(ACTIVE_PSEUDO_CLASS, readOnlyBooleanProperty.get());
		});
	}

	@Override
	protected StringProperty impl_titleProperty() {
		return this.titleProperty;
	}

	private ObjectProperty<Node> clientArea = new SimpleObjectProperty<Node>(this, "clientArea", null); //$NON-NLS-1$

	private BorderPane trimPane;

	@Override
	protected ObjectProperty<Node> impl_clientAreaProperty() {
		return this.clientArea;
	}

	private void updateClientArea(ObservableValue<? extends Node> o, Node oldClientArea, Node newClientArea) {
		if (oldClientArea != null) {
			((Pane) lookup("#client-area")).getChildren().remove(oldClientArea); //$NON-NLS-1$
		}

		if (newClientArea != null) {
			((Pane) lookup("#client-area")).getChildren().add(newClientArea); //$NON-NLS-1$
		}
	}

	@Override
	public ObjectProperty<Node> impl_contentProperty() {
		return this.contentProperty;
	}

	private static class WindowButton extends Button {
		WindowButton(String name) {
			getStyleClass().setAll("window-button"); //$NON-NLS-1$
			getStyleClass().add("window-" + name + "-button"); //$NON-NLS-1$ //$NON-NLS-2$
			StackPane graphic = new StackPane();
			graphic.getStyleClass().setAll("graphic"); //$NON-NLS-1$
			setGraphic(graphic);
			setMinSize(17, 17);
			setPrefSize(17, 17);
		}
	}

	// FIXME Once the build server is on u40
	// @Override
	public String getUserAgentStylesheet() {
		return DefaultFramePane.class.getResource("window.css").toExternalForm(); //$NON-NLS-1$
	}

}
