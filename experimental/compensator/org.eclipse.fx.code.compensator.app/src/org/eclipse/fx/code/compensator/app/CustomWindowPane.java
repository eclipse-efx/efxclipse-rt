package org.eclipse.fx.code.compensator.app;


import org.eclipse.fx.ui.workbench.renderers.fx.DefWindowRenderer.CustomRootContainer;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CustomWindowPane extends StackPane implements CustomRootContainer {
	private BorderPane root;
	private Rectangle resizeCorner;
	private ToolBar dialogTitleBar;
	private Label titleLabel;
	private WindowButton closeButton;
	private WindowButton minButton;
	private WindowButton maxButton;
	private HBox windowBtns;
	private double mouseDragDeltaX;
	private double mouseDragDeltaY;
	private Rectangle2D backupWindowBounds;

	protected static final int HEADER_HEIGHT = 28;

	protected static final PseudoClass ACTIVE_PSEUDO_CLASS = PseudoClass.getPseudoClass("active"); //$NON-NLS-1$

	public CustomWindowPane() {
		root = new BorderPane();
        getChildren().add(root);
        getStyleClass().addAll("dialog", "decorated-root"  //$NON-NLS-1$ //$NON-NLS-2$
//                       ,Platform.getCurrent().getPlatformId()
                       );


        // --- resize corner
        resizeCorner = new Rectangle(10, 10);
        resizeCorner.getStyleClass().add("window-resize-corner"); //$NON-NLS-1$
        resizeCorner.setManaged(false);
        getChildren().add(resizeCorner);


        // --- titlebar (only used for cross-platform look)
        dialogTitleBar = new ToolBar();
        dialogTitleBar.getStyleClass().add("window-header"); //$NON-NLS-1$
        dialogTitleBar.setPrefHeight(HEADER_HEIGHT);
        dialogTitleBar.setMinHeight(HEADER_HEIGHT);
        dialogTitleBar.setMaxHeight(HEADER_HEIGHT);

        titleLabel = new Label();
        titleLabel.setMaxHeight(Double.MAX_VALUE);
        titleLabel.setId("window-label-title");
        titleLabel.getStyleClass().add("window-title"); //$NON-NLS-1$
//        titleLabel.setText("Hello World");
//        titleLabel.setText(titleProperty().get());

//        titleProperty().addListener(new InvalidationListener() {
//            @Override public void invalidated(Observable valueModel) {
//                titleLabel.setText(titleProperty().get());
//            }
//        });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // add close min max
        closeButton = new WindowButton("close"); //$NON-NLS-1$
        closeButton.setFocusTraversable(false);
        closeButton.setOnAction((a) -> {
        	//FIXME Need to ask for confirmation
        	((Stage)getScene().getWindow()).close();
        });

        minButton = new WindowButton("minimize"); //$NON-NLS-1$
        minButton.setFocusTraversable(false);
        minButton.setOnAction((a) -> ((Stage)getScene().getWindow()).setIconified(true));

        maxButton = new WindowButton("maximize"); //$NON-NLS-1$
        maxButton.setFocusTraversable(false);
        maxButton.setOnAction(this::maximize);

        windowBtns = new HBox(3);
        windowBtns.getStyleClass().add("window-buttons"); //$NON-NLS-1$
        windowBtns.getChildren().addAll(minButton, maxButton, closeButton);

        dialogTitleBar.getItems().addAll(titleLabel, spacer, windowBtns);
        dialogTitleBar.setOnMousePressed(event -> {
            mouseDragDeltaX = event.getSceneX();
            mouseDragDeltaY = event.getSceneY();
        });
        dialogTitleBar.setOnMouseDragged(event -> {
            getStage().setX(event.getScreenX() - mouseDragDeltaX);
            getStage().setY(event.getScreenY() - mouseDragDeltaY);
        });
        root.setTop(dialogTitleBar);
        dialogTitleBar.applyCss();

        EventHandler<MouseEvent> resizeHandler = new EventHandler<MouseEvent>() {
            private double width;
            private double height;
            private Point2D dragAnchor;

            @Override public void handle(MouseEvent event) {
                EventType<? extends MouseEvent> type = event.getEventType();

                if (type == MouseEvent.MOUSE_PRESSED) {
                    width = getStage().getWidth();
                    height = getStage().getHeight();
                    dragAnchor = new Point2D(event.getSceneX(), event.getSceneY());
                } else if (type == MouseEvent.MOUSE_DRAGGED) {
                	getStage().setWidth(width  + (event.getSceneX() - dragAnchor.getX()));
                	getStage().setHeight(height + (event.getSceneY() - dragAnchor.getY()));
                }
            }
        };
        resizeCorner.setOnMousePressed(resizeHandler);
        resizeCorner.setOnMouseDragged(resizeHandler);
        sceneProperty().addListener((o) -> {
        	Scene s = getScene();
        	if( s != null ) {
        		if( s.getWindow() != null ) {
        			handleFocus(s.getWindow().focusedProperty());
        		} else {
        			s.windowProperty().addListener((o2) -> {
        				if( s.getWindow() != null) {
        					handleFocus(s.getWindow().focusedProperty());
        				}
        			});
        		}
        	}
        });

	}

	private void handleFocus(ReadOnlyBooleanProperty readOnlyBooleanProperty) {
		readOnlyBooleanProperty.addListener((o) -> {
			pseudoClassStateChanged(ACTIVE_PSEUDO_CLASS, readOnlyBooleanProperty.getValue());
		});
	}

	@Override
	public void setTitle(String title) {
		titleLabel.setText(title);
	}

	@Override
	public void setMenuBar(Node menuBar) {
		((ToolBar)lookup("#main-header")).getItems().add(0,menuBar);
		menuBar.getStyleClass().add("window-menubar");
		HBox.setHgrow(menuBar, Priority.ALWAYS);
	}

	@Override
	public void setTrim(Node trim) {
		((Pane)lookup("#trim-pane-container")).getChildren().add(trim);
	}

	private Stage getStage() {
		return (Stage) getScene().getWindow();
	}

	private void maximize(ActionEvent e) {
		Stage stage = getStage();
		final double stageY = stage.getY();
        final Screen screen = Screen.getScreensForRectangle(stage.getX(), stageY, 1, 1).get(0);
        Rectangle2D bounds = screen.getVisualBounds();
        if (bounds.getMinX() == stage.getX() && bounds.getMinY() == stageY &&
                bounds.getWidth() == stage.getWidth() && bounds.getHeight() == stage.getHeight()) {
            if (backupWindowBounds != null) {
                stage.setX(backupWindowBounds.getMinX());
                stage.setY(backupWindowBounds.getMinY());
                stage.setWidth(backupWindowBounds.getWidth());
                stage.setHeight(backupWindowBounds.getHeight());
            }
        } else {
            backupWindowBounds = new Rectangle2D(stage.getX(), stage.getY(), stage.getWidth(), stage.getHeight());
            final double newStageY = screen.getVisualBounds().getMinY();
            stage.setX(screen.getVisualBounds().getMinX());
            stage.setY(newStageY);
            stage.setWidth(screen.getVisualBounds().getWidth());
            stage.setHeight(screen.getVisualBounds().getHeight());
        }
	}

	public void setContent(Node content) {
		root.setCenter(content);
	}

	public Node getContent() {
		return root.getCenter();
	}

	public ObjectProperty<Node> contentProperty() {
		return root.centerProperty();
	}

	protected void layoutChildren() {
        super.layoutChildren();
        if (resizeCorner != null) {
            resizeCorner.relocate(getWidth() - resizeCorner.getWidth(),
                                  getHeight() - resizeCorner.getHeight());
        }
    }

	private static class WindowButton extends Button {
        WindowButton(String name) {
            getStyleClass().setAll("window-button"); //$NON-NLS-1$
            getStyleClass().add("window-"+name+"-button"); //$NON-NLS-1$ //$NON-NLS-2$
            StackPane graphic = new StackPane();
            graphic.getStyleClass().setAll("graphic"); //$NON-NLS-1$
            setGraphic(graphic);
            setMinSize(17, 17);
            setPrefSize(17, 17);
        }
    }
}
