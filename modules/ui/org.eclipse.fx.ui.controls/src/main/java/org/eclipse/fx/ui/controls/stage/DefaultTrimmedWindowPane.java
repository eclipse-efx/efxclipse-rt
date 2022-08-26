/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.stage;

import org.eclipse.jdt.annotation.NonNull;
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
public class DefaultTrimmedWindowPane extends ResizeableWindowPane implements TrimmedWindow {
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

	@NonNull
	private final ObjectProperty<@Nullable Node> leftTrim = new SimpleObjectProperty<>(this, "leftTrim"); //$NON-NLS-1$
	@NonNull
	private final ObjectProperty<@Nullable Node> rightTrim = new SimpleObjectProperty<>(this, "rightTrim"); //$NON-NLS-1$
	@NonNull
	private final ObjectProperty<@Nullable Node> topTrim = new SimpleObjectProperty<>(this, "topTrim"); //$NON-NLS-1$
	@NonNull
	private final ObjectProperty<@Nullable Node> bottomTrim = new SimpleObjectProperty<>(this, "bottomTrim"); //$NON-NLS-1$

	private TitleAreaNode dialogAreaNode;

	/**
	 * Create a default window pane
	 */
	public DefaultTrimmedWindowPane() {
		this(null);
	}

	/**
	 * Create a default window pane
	 *
	 * @param lightweight
	 *            <code>true</code> to mark the window lightweight
	 * @since 2.4.0
	 */
	public DefaultTrimmedWindowPane(boolean lightweight) {
		this(lightweight, null);
	}

	/**
	 * Create a default window pane with a default client area as
	 * {@link #setContent(Node)}
	 *
	 * @param clientArea
	 *            a client area
	 */
	public DefaultTrimmedWindowPane(@Nullable Pane clientArea) {
		this(false, clientArea);
	}

	/**
	 * Create a default window pane
	 *
	 * @param lightweight
	 *            <code>true</code> to mark the window lightweight
	 * @param clientArea
	 *            a client area
	 * @since 2.4.0
	 */
	public DefaultTrimmedWindowPane(boolean lightweight, @Nullable Pane clientArea) {
		super(lightweight);
		menuBarProperty().addListener(this::updateMenuBar);
		clientAreaProperty().addListener(this::updateClientArea);
		topTrimProperty().addListener(this::updateTopTrim);
		bottomTrimProperty().addListener(this::updateBottomTrim);
		rightTrimProperty().addListener(this::updateRightTrim);
		leftTrimProperty().addListener(this::updateLeftTrim);
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
		handleFocus(getStage().focusedProperty());
		if (getStage().getModality() == Modality.WINDOW_MODAL) {
			this.dialogAreaNode.getMinButton().setVisible(false);
		}
	}

	@Override
	public void setBottomTrim(@Nullable Node node) {
		this.bottomTrimProperty().set(node);
	}

	/**
	 * @return the bottom trim property
	 */
	public @NonNull ObjectProperty<@Nullable Node> bottomTrimProperty() {
		return this.bottomTrim;
	}

	/**
	 * @return the bottom trim
	 */
	public @Nullable Node getBottomTrim() {
		return this.bottomTrimProperty().get();
	}

	@Override
	public void setLeftTrim(@Nullable Node node) {
		this.leftTrimProperty().set(node);
	}

	/**
	 * @return the left trim property
	 */
	public @NonNull ObjectProperty<@Nullable Node> leftTrimProperty() {
		return this.leftTrim;
	}

	/**
	 * @return the left trim
	 */
	public @Nullable Node getLeftTrim() {
		return this.leftTrimProperty().get();
	}

	@Override
	public void setRightTrim(@Nullable Node node) {
		this.rightTrimProperty().set(node);
	}

	/**
	 * @return the right trim property
	 */
	public @NonNull ObjectProperty<@Nullable Node> rightTrimProperty() {
		return this.rightTrim;
	}

	/**
	 * @return the right trim
	 */
	public @Nullable Node getRightTrim() {
		return this.rightTrimProperty().get();
	}

	@Override
	public void setTopTrim(@Nullable Node node) {
		this.topTrimProperty().set(node);
	}

	/**
	 * @return the top trim property
	 */
	public @NonNull ObjectProperty<@Nullable Node> topTrimProperty() {
		return this.topTrim;
	}

	/**
	 * @return the top trim
	 */
	public @Nullable Node getTopTrim() {
		return this.topTrimProperty().get();
	}

	private void updateTopTrim(ObservableValue<? extends Node> o, Node oldValue, Node newValue) {
		if (oldValue != null) {
			Pane pane = (Pane) lookup("#top-trim-area"); //$NON-NLS-1$
			if (pane == null) {
				this.trimPane.setTop(null);
			} else {
				pane.getChildren().remove(oldValue);
			}
		}

		if (newValue != null) {
			Pane pane = (Pane) lookup("#top-trim-area"); //$NON-NLS-1$
			if (pane == null) {
				this.trimPane.setTop(newValue);
			} else {
				pane.getChildren().add(newValue);
			}
		}
	}

	private void updateBottomTrim(ObservableValue<? extends Node> o, Node oldValue, Node newValue) {
		if (oldValue != null) {
			Pane pane = (Pane) lookup("#bottom-trim-area"); //$NON-NLS-1$
			if (pane == null) {
				this.trimPane.setBottom(null);
			} else {
				pane.getChildren().remove(newValue);
			}
		}

		if (newValue != null) {
			Pane pane = (Pane) lookup("#bottom-trim-area"); //$NON-NLS-1$
			if (pane == null) {
				this.trimPane.setBottom(newValue);
			} else {
				pane.getChildren().add(newValue);
			}
		}
	}

	private void updateLeftTrim(ObservableValue<? extends Node> o, Node oldValue, Node newValue) {
		if (oldValue != null) {
			Pane pane = (Pane) lookup("#left-trim-area"); //$NON-NLS-1$
			if (pane == null) {
				this.trimPane.setLeft(null);
			} else {
				pane.getChildren().remove(oldValue);
			}
		}

		if (newValue != null) {
			Pane pane = (Pane) lookup("#left-trim-area"); //$NON-NLS-1$
			if (pane == null) {
				this.trimPane.setLeft(newValue);
			} else {
				pane.getChildren().add(newValue);
			}
		}
	}

	private void updateRightTrim(ObservableValue<? extends Node> o, Node oldValue, Node newValue) {
		if (oldValue != null) {
			Pane pane = (Pane) lookup("#right-trim-area"); //$NON-NLS-1$
			if (pane == null) {
				this.trimPane.setRight(null);
			} else {
				pane.getChildren().remove(oldValue);
			}
		}

		if (newValue != null) {
			Pane pane = (Pane) lookup("#right-trim-area"); //$NON-NLS-1$
			if (pane == null) {
				this.trimPane.setRight(newValue);
			} else {
				pane.getChildren().add(newValue);
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

	/**
	 * Request the closing through the cancel icon in trim
	 */
	protected void requestCancelClose() {
		close(true);
	}

	class TitleAreaNodeImpl extends HBox implements TitleAreaNode {
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
			closeButton.setOnAction(e -> requestCancelClose());

			this.minButton = new WindowButton("minimize"); //$NON-NLS-1$
			this.minButton.setFocusTraversable(false);
			this.minButton.setOnAction(e -> minimize());

			WindowButton maxButton = new WindowButton("maximize"); //$NON-NLS-1$
			maxButton.setFocusTraversable(false);
			maxButton.setOnAction(e -> maximize());

			HBox windowBtns = new HBox();
			windowBtns.getStyleClass().add("window-buttons"); //$NON-NLS-1$
			windowBtns.getChildren().addAll(this.minButton, maxButton, closeButton);

			getChildren().addAll(this.titleLabel, spacer, windowBtns);
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

	private ObjectProperty<Node> menuBar = new SimpleObjectProperty<Node>(this, "menuBar", null); //$NON-NLS-1$

	@Override
	protected ObjectProperty<Node> impl_menuBarProperty() {
		return this.menuBar;
	}

	private void updateMenuBar(ObservableValue<? extends Node> o, Node oldMenuBar, Node newMenuBar) {
		if (oldMenuBar != null) {
			((Pane) lookup("#menu-bar-area")).getChildren().remove(oldMenuBar); //$NON-NLS-1$
			oldMenuBar.getStyleClass().remove("window-menubar"); //$NON-NLS-1$
		}

		if (newMenuBar != null) {
			((Pane) lookup("#menu-bar-area")).getChildren().add(0, newMenuBar); //$NON-NLS-1$
			newMenuBar.getStyleClass().add("window-menubar"); //$NON-NLS-1$
			HBox.setHgrow(newMenuBar, Priority.ALWAYS);
		}
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

	@Override
	public String getUserAgentStylesheet() {
		return DefaultTrimmedWindowPane.class.getResource("window.css").toExternalForm(); //$NON-NLS-1$
	}

}
