package org.eclipse.fx.tool.event.spy.internal.view;

import org.eclipse.fx.tool.event.spy.internal.model.EventSpyModel;

import javafx.beans.binding.BooleanExpression;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

/**
 * Main view of the event spy tool.
 */
public class EventSpyView {

    private static final String START_CAPTURING_EVENTS_LABEL = "Start capturing events";
    private static final String STOP_CAPTURING_EVENTS_LABEL = "Stop capturing events";
    private static final String SHOW_FILTERS_LABEL = "Show filters";
    private static final String HIDE_FILTERS_LABEL = "Hide filters";
    
    private final EventSpyModel eventSpyModel;
    private BorderPane borderPane;
    private HBox topPanel;

    /**
     * Main constructor.
     * 
     * @param model
     */
    public EventSpyView(EventSpyModel eventSpyModel) {
        this.eventSpyModel = eventSpyModel;
    }

    /**
     * Returns the gui element.
     * 
     * @return
     */
    public Parent getGui() {
        if (borderPane == null) {
            createGui();
        }
        return borderPane;
    }

    private void createGui() {

        borderPane = new BorderPane();

        createTopPanel();
        createCenterPanel();
    }

    private void createCenterPanel() {

        AnchorPane   anchorPane = new AnchorPane();
        
        Region filterEditor = new FilterEditor(eventSpyModel).getGui();
        filterEditor.visibleProperty().bind(eventSpyModel.filtersVisibleProperty());
        
        
        anchorPane.getChildren().add(filterEditor);
        
        BorderPane overviewWrapPane = new BorderPane();
        
        Region eventOverview = new EventOverview(eventSpyModel).getGui();
        
        ToolBar toolbar = new ToolBar();
        
        ToggleButton wrapOnOffButton = new ToggleButton();
        wrapOnOffButton.textProperty().bind(eventSpyModel.wrapOnOffActionLabel());
        wrapOnOffButton.setOnAction(event->eventSpyModel.toggleWrapOnOffAction());
        toolbar.getItems().add(wrapOnOffButton);
        
        overviewWrapPane.setTop(toolbar);
        
        overviewWrapPane.setCenter(eventOverview);
        
        anchorPane.getChildren().add(overviewWrapPane);
        
        AnchorPane.setTopAnchor(filterEditor, 0.0d);
        AnchorPane.setLeftAnchor(filterEditor, 0.0d);
        AnchorPane.setRightAnchor(filterEditor, 0.0d);
        
        AnchorPane.setTopAnchor(overviewWrapPane, 0.0d);
        AnchorPane.setBottomAnchor(overviewWrapPane, 0.0d);
        AnchorPane.setLeftAnchor(overviewWrapPane, 0.0d);
        AnchorPane.setRightAnchor(overviewWrapPane, 0.0d);
        eventSpyModel.filtersVisibleProperty().addListener((event,oldValue,newValue)->{
            if (newValue) {
                AnchorPane.setTopAnchor(overviewWrapPane, filterEditor.getPrefHeight());
            } else {
                AnchorPane.setTopAnchor(overviewWrapPane, 0.0d);
            }
        });
        
        borderPane.setCenter(anchorPane);
        
    }

    private void createTopPanel() {
        topPanel = new HBox(10.0);
        topPanel.setPadding(new Insets(10));
        topPanel.setStyle("-fx-background-color:#6A7079;");

        createButton(START_CAPTURING_EVENTS_LABEL, eventSpyModel.startedProperty(), ev -> eventSpyModel.start());
        createButton(STOP_CAPTURING_EVENTS_LABEL, eventSpyModel.startedProperty().not(), ev -> eventSpyModel.stop());
        createButton(SHOW_FILTERS_LABEL, eventSpyModel.filtersVisibleProperty(), ev -> eventSpyModel.showFilters());
        createButton(HIDE_FILTERS_LABEL, eventSpyModel.filtersVisibleProperty().not(), ev -> eventSpyModel.hideFilters());

        borderPane.setTop(topPanel);        
    }

    private void createButton(String label, BooleanExpression disabledProperty, EventHandler<ActionEvent> eventHandler) {
        Button button = new Button(label);
        button.disableProperty().bind(disabledProperty);
        button.setOnAction(eventHandler);
        topPanel.getChildren().add(button);
    }

}
