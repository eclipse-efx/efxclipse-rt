package org.eclipse.fx.tool.event.spy.internal.view;

import java.util.Arrays;

import org.eclipse.fx.tool.event.spy.internal.core.model.CapturedEventFilter;
import org.eclipse.fx.tool.event.spy.internal.core.model.ItemToFilter;
import org.eclipse.fx.tool.event.spy.internal.core.model.Operator;
import org.eclipse.fx.tool.event.spy.internal.model.EventSpyModel;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * This gui element is for creating and managing the event filters filtering the events in the overview tree table.
 *
 */
public class FilterEditor {

    private BorderPane borderPane;
    private EventSpyModel eventSpyModel;

    private Label topicLabel;
    private Label captureWhenLabel;

    private Button resetToDefault;
    private Button addFilter;
    private Button updateSelected;
    private Button removeSelected;
    private Button removeAll;

    private TextField topicTextField;
    private ChoiceBox<ItemToFilter> itemToFilterChoiceBox;
    private ChoiceBox<Operator> operatorChoiceBox;
    private TextField expectedValueTextField;

    private ListView<CapturedEventFilter> filterListBox;

    private TitledPane newFilterTitledPane;
    private TitledPane definedFiltersTitledPane;

    /**
     * Main constructor.
     * 
     * @param eventSpyModel
     */
    public FilterEditor(EventSpyModel eventSpyModel) {
        this.eventSpyModel = eventSpyModel;
    }

    /**
     * Returns the gui element.
     * 
     * @return
     */
    public Region getGui() {
        if (borderPane == null) {
            createGui();
        }
        return borderPane;
    }

    private void createGui() {

        borderPane = new BorderPane();

        newFilterTitledPane = new TitledPane("New Filter:", createNewFilterPane());
        newFilterTitledPane.setCollapsible(false);
        borderPane.setTop(newFilterTitledPane);

        definedFiltersTitledPane = new TitledPane("Defined filters (relation between filters is AND):", createDefinedFiltersPane());
        definedFiltersTitledPane.setCollapsible(false);
        borderPane.setCenter(definedFiltersTitledPane);

        borderPane.setPrefHeight(350);
        borderPane.setMaxHeight(350);
        borderPane.setMinHeight(350);

        borderPane.setStyle("-fx-background-color:orange");

    }

    /**
     * Pane for managing the existing filters.
     * 
     * @return
     */
    private Node createDefinedFiltersPane() {

        filterListBox = new ListView<>();
        filterListBox.setPrefWidth(500);
        filterListBox.setItems(eventSpyModel.getFilters());
        filterListBox.getSelectionModel().selectedItemProperty().addListener((event, oldValue, newValue) -> eventSpyModel.setSelectedFilter(newValue));
        filterListBox.focusedProperty()
                .addListener((event, oldValue, newValue) -> eventSpyModel.setSelectedFilter(filterListBox.getSelectionModel().getSelectedItem()));
        updateSelected = new Button("Update selected");
        updateSelected.disableProperty().bind(eventSpyModel.updatePossible().not());
        updateSelected.setOnAction(ev -> {
            eventSpyModel.updateSelectedFilter();
            filterListBox.refresh();
        });

        removeSelected = new Button("Remove selected");
        removeSelected.disableProperty().bind(eventSpyModel.operationsOnSelectedFilterPossible().not());
        removeSelected.setOnAction(ev -> eventSpyModel.removeSelectedFilter());

        removeAll = new Button("Remove all");
        removeAll.setOnAction(ev -> eventSpyModel.removeAllFilters());

        HBox hbox = new HBox(10);
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(updateSelected, removeSelected, removeAll);
        hbox.getChildren().addAll(filterListBox, vbox);
        hbox.setStyle("-fx-background-color:#6A7079;");
        return hbox;
    }

    /**
     * Pane for new filter creation.
     * 
     * @return
     */
    private Node createNewFilterPane() {

        topicLabel = new Label("Base topic of captured events:");
        topicTextField = new TextField();
        topicTextField.setPrefColumnCount(35);
        topicTextField.textProperty().bindBidirectional(eventSpyModel.baseTopicProperty());
        resetToDefault = new Button("Reset to default");
        resetToDefault.setOnAction(ev -> eventSpyModel.resetToDefaultTopic());

        captureWhenLabel = new Label("Capture event when:");
        itemToFilterChoiceBox = new ChoiceBox<>();
        itemToFilterChoiceBox.getItems().addAll(Arrays.asList(ItemToFilter.values()));
        itemToFilterChoiceBox.setValue(ItemToFilter.NotSelected);
        itemToFilterChoiceBox.valueProperty().bindBidirectional(eventSpyModel.selectedItemToFilterProperty());
        itemToFilterChoiceBox.tooltipProperty().bind(Bindings.createObjectBinding(() -> {
            return eventSpyModel.selectedItemToFilterProperty().getValue().equals(ItemToFilter.NotSelected)
                    ? new Tooltip("Item to filter must be chosen in order to create or update a filter.")
                    : null;
        }, eventSpyModel.selectedItemToFilterProperty()));

        operatorChoiceBox = new ChoiceBox<>();
        operatorChoiceBox.getItems().addAll(Arrays.asList(Operator.values()));
        operatorChoiceBox.setValue(Operator.NotSelected);
        operatorChoiceBox.valueProperty().bindBidirectional(eventSpyModel.selectedOperatorProperty());
        operatorChoiceBox.tooltipProperty().bind(Bindings.createObjectBinding(() -> {
            return eventSpyModel.selectedOperatorProperty().getValue().equals(Operator.NotSelected)
                    ? new Tooltip("Operator must be chosen in order to create or update a filter.")
                    : null;
        }, eventSpyModel.selectedOperatorProperty()));

        expectedValueTextField = new TextField();
        expectedValueTextField.setPromptText("-- expected value --");
        expectedValueTextField.textProperty().bindBidirectional(eventSpyModel.enteredExpectedValueProperty());
        expectedValueTextField.tooltipProperty().bind(Bindings.createObjectBinding(() -> {
            String text = eventSpyModel.enteredExpectedValueProperty().getValue();
            if (text == null || text.isEmpty()) {
                return new Tooltip("Please enter an expected value in order to create or udpate a filter.");
            } else if (eventSpyModel.selectedItemToFilterProperty().getValue().equals(ItemToFilter.ParameterNameAndValue) && text.split("=").length != 2) {
                return new Tooltip("When item to filter 'Parameter-Name-And-Value' is chosen, please use the expected value format 'parameter=value'. ");
            }
            return null;
        }, eventSpyModel.enteredExpectedValueProperty(), eventSpyModel.selectedItemToFilterProperty()));
        expectedValueTextField.setOnAction(event -> {
            if (eventSpyModel.addFilterValidProperty().getValue()) {
                eventSpyModel.createNewFilter();
            }
        });
        eventSpyModel.focusOnTextFieldProperty().addListener((event, oldValue, newValue) -> {
            if (newValue) {
                expectedValueTextField.requestFocus();
            }
        });

        addFilter = new Button("Add filter");
        addFilter.disableProperty().bind(eventSpyModel.addFilterValidProperty().not());
        addFilter.setOnAction(ev -> eventSpyModel.createNewFilter());

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        HBox hbox1 = new HBox(10);
        hbox1.setPadding(new Insets(10));
        hbox1.getChildren().addAll(topicLabel, topicTextField, resetToDefault);
        HBox hbox2 = new HBox(10);
        hbox2.setPadding(new Insets(10));
        hbox2.getChildren().addAll(captureWhenLabel, itemToFilterChoiceBox, operatorChoiceBox, expectedValueTextField, addFilter);

        vbox.getChildren().addAll(hbox1, hbox2);
        vbox.setStyle("-fx-background-color:#6A7079;");
        return vbox;
    }

}
