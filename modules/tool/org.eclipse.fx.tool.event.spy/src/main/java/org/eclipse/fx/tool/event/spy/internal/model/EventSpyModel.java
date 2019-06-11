/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.event.spy.internal.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.fx.tool.event.spy.internal.core.EventMonitor;
import org.eclipse.fx.tool.event.spy.internal.core.EventMonitor.NewEventListener;
import org.eclipse.fx.tool.event.spy.internal.core.model.CapturedEvent;
import org.eclipse.fx.tool.event.spy.internal.core.model.CapturedEventFilter;
import org.eclipse.fx.tool.event.spy.internal.core.model.IEventItem;
import org.eclipse.fx.tool.event.spy.internal.core.model.ItemToFilter;
import org.eclipse.fx.tool.event.spy.internal.core.model.Operator;

import org.eclipse.e4.core.services.events.IEventBroker;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Model of the event spy tool.
 */
public class EventSpyModel implements NewEventListener {

    private static final int LINE_LENGTH_BOUND_WRAP_ON = 0;
    private static final int LINE_LENGTH_BOUND_WRAP_OFF = 70;
    private static final String LINE_WRAP_ON_LABEL = "Line Wrap On";
    private static final String LINE_WRAP_OFF_LABEL = "Line Wrap Off";

    private static final String DEFAULT_TOPIC = "org/eclipse/e4/ui/*";

    private final IEventBroker eventBroker;
    private EventMonitor eventMonitor;

    private StringProperty lastSearchStringProperty = new SimpleStringProperty("");

    private final ObservableList<IEventItem> eventItems = FXCollections.observableArrayList();

    private final ObservableList<CapturedEventFilter> filters = FXCollections.observableArrayList();

    private final BooleanProperty startedProperty = new SimpleBooleanProperty(false);
    private final BooleanProperty filtersVisibleProperty = new SimpleBooleanProperty(false);

    private final StringProperty baseTopicProperty = new SimpleStringProperty(DEFAULT_TOPIC);

    private final ObjectProperty<ItemToFilter> selectedItemToFilterProperty = new SimpleObjectProperty<>(ItemToFilter.NotSelected);
    private final ObjectProperty<Operator> selectedOperatorProperty = new SimpleObjectProperty<>(Operator.NotSelected);
    private final StringProperty enteredExpectedValueProperty = new SimpleStringProperty("");

    private final BooleanProperty focusOnTextFieldProperty = new SimpleBooleanProperty(false);

    private final BooleanBinding parameterAndValueIllegalValueProperty = selectedItemToFilterProperty.isEqualTo(ItemToFilter.ParameterNameAndValue)
            .and(Bindings.createBooleanBinding(() -> {

                String e = enteredExpectedValueProperty.getValue();
                return e != null && e.split("=").length != 2;

            }, enteredExpectedValueProperty));

    private final BooleanBinding addFilterValidProperty = selectedItemToFilterProperty.isNotEqualTo(ItemToFilter.NotSelected)
            .and(selectedOperatorProperty.isNotEqualTo(Operator.NotSelected)).and(enteredExpectedValueProperty.isNotEmpty())
            .and(parameterAndValueIllegalValueProperty.not());

    private final ObjectProperty<CapturedEventFilter> selectedCapturedEventFilterProperty = new SimpleObjectProperty<>(null);

    private final BooleanBinding operationsOnSelectedFilterPossible = selectedCapturedEventFilterProperty.isNotNull();

    private final BooleanBinding updatePossible = operationsOnSelectedFilterPossible.and(addFilterValidProperty);

    private final BooleanProperty wrapOnProperty = new SimpleBooleanProperty(false);

    private IntegerProperty lineWrapBoundaryProperty = new SimpleIntegerProperty(70);

    public EventSpyModel(IEventBroker eventBroker) {
        this.eventBroker = eventBroker;

        initBindings();
    }

    private void initBindings() {
        startedProperty.addListener((ev, oldv, newValue) -> {
            if (newValue) {
                eventItems.clear();
                if (eventMonitor == null) {
                    eventMonitor = new EventMonitor(eventBroker);
                    eventMonitor.setNewEventListener(this);
                }
                eventMonitor.start(baseTopicProperty.getValue(), filters);
            } else {
                if (eventMonitor != null) {
                    eventMonitor.stop();
                }
            }
        });
        lineWrapBoundaryProperty.bind(Bindings.createIntegerBinding(() -> {
            if (wrapOnProperty.getValue()) {
                return LINE_LENGTH_BOUND_WRAP_ON;
            } else {
                return LINE_LENGTH_BOUND_WRAP_OFF;
            }

        }, wrapOnProperty));

    }

    public BooleanBinding operationsOnSelectedFilterPossible() {
        return operationsOnSelectedFilterPossible;
    }

    public BooleanBinding updatePossible() {
        return updatePossible;
    }

    public ObjectProperty<CapturedEventFilter> selectedCapturedEventFilterProperty() {
        return selectedCapturedEventFilterProperty;
    }

    public ObjectProperty<ItemToFilter> selectedItemToFilterProperty() {
        return selectedItemToFilterProperty;
    }

    public ObjectProperty<Operator> selectedOperatorProperty() {
        return selectedOperatorProperty;
    }

    public StringProperty enteredExpectedValueProperty() {
        return enteredExpectedValueProperty;
    }

    public BooleanBinding addFilterValidProperty() {
        return addFilterValidProperty;
    }

    public String getLastSearchString() {
        return lastSearchStringProperty.get();
    }

    public StringProperty lastSearchStringPropertyProperty() {
        return lastSearchStringProperty;
    }

    public StringProperty baseTopicProperty() {
        return baseTopicProperty;
    }

    public void start() {
        startedProperty.setValue(true);
    }

    public void stop() {
        startedProperty.setValue(false);
    }

    public void showFilters() {
        filtersVisibleProperty.setValue(true);
    }

    public void hideFilters() {
        filtersVisibleProperty.setValue(false);
    }

    public ReadOnlyBooleanProperty startedProperty() {
        return startedProperty;
    }

    public ReadOnlyBooleanProperty filtersVisibleProperty() {
        return filtersVisibleProperty;
    }

    @Override
    public void newEvent(CapturedEvent event) {
        eventItems.add(event);
    }

    public ObservableList<IEventItem> getCapturedEvents() {
        return eventItems;
    }

    public void resetToDefaultTopic() {
        baseTopicProperty.setValue(DEFAULT_TOPIC);
    }

    public void createNewFilter() {

        try {
            filters.add(new CapturedEventFilter(selectedItemToFilterProperty.getValue(), selectedOperatorProperty.getValue(),
                    enteredExpectedValueProperty.getValue()));
            resetFilters();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<CapturedEventFilter> getFilters() {
        return filters;
    }

    public void updateSelectedFilter() {
        CapturedEventFilter value = selectedCapturedEventFilterProperty.getValue();
        value.setItemToFilter(selectedItemToFilterProperty.getValue());
        value.setOperator(selectedOperatorProperty.getValue());
        value.setValue(enteredExpectedValueProperty.getValue());
        resetFilters();
    }

    public void removeSelectedFilter() {
        filters.remove(selectedCapturedEventFilterProperty.getValue());
    }

    public void removeAllFilters() {
        filters.clear();
    }

    public void resetFilters() {
        selectedItemToFilterProperty.setValue(ItemToFilter.NotSelected);
        selectedOperatorProperty.setValue(Operator.NotSelected);
        enteredExpectedValueProperty.setValue("");
    }

    public void setSelectedFilter(CapturedEventFilter filter) {
        selectedCapturedEventFilterProperty.setValue(filter);
        if (filter == null) {
            resetFilters();
        } else {
            selectedItemToFilterProperty.setValue(filter.getItemToFilter());
            selectedOperatorProperty.setValue(filter.getOperator());
            enteredExpectedValueProperty.setValue(filter.getValue());
        }
    }

    public BooleanProperty wrapOnProperty() {
        return wrapOnProperty;
    }

    public IntegerProperty lineWrapProperty() {
        return lineWrapBoundaryProperty;
    }

    public StringBinding wrapOnOffActionLabel() {
        return Bindings.createStringBinding(() -> {
            return wrapOnProperty.getValue() ? LINE_WRAP_OFF_LABEL : LINE_WRAP_ON_LABEL;
        }, wrapOnProperty);
    }

    public void toggleWrapOnOffAction() {
        wrapOnProperty.setValue(!wrapOnProperty.getValue());
    }

    public void autoCreateFilter(String parameterName, String expectedValue) {
        ItemToFilter itemToFilter = ItemToFilter.toItem(parameterName);
        selectedItemToFilterProperty.setValue(itemToFilter);
        selectedOperatorProperty.setValue(itemToFilter.getDefaultOperator());
        if (itemToFilter.getDefaultOperator().equals(Operator.Equals)) {
            enteredExpectedValueProperty.setValue(expectedValue);
        }
        focusOnTextFieldProperty.setValue(true);
        focusOnTextFieldProperty.setValue(false);
    }

    public BooleanProperty focusOnTextFieldProperty() {
        return focusOnTextFieldProperty;
    }

    public Optional<IEventItem> search(String searchTextRaw, IEventItem selectedItem) {

        lastSearchStringProperty.setValue(searchTextRaw);

        String searchText = searchTextRaw.toLowerCase();

        List<IEventItem> capturedItems = getCapturedEvents().stream().flatMap(c -> {
            List<IEventItem> result = new ArrayList<>();
            result.add(c);
            result.addAll(c.getChildren());
            return result.stream();

        }).collect(Collectors.toList());

        List<IEventItem> searchableItems = new ArrayList<>();

        if (selectedItem!=null) {

            int selectedIndex = capturedItems.indexOf(selectedItem);

            searchableItems.addAll(capturedItems.subList(selectedIndex + 1, capturedItems.size()));
            searchableItems.addAll(capturedItems.subList(0, selectedIndex));

        } else {
            searchableItems = capturedItems;
        }

        Optional<IEventItem> element = searchableItems.stream().filter(p -> {
            return p.getName().toString().trim().toLowerCase().contains(searchText) || p.getParam1().toString().trim().toLowerCase().contains(searchText)
                    || p.getParam2().toString().trim().toLowerCase().contains(searchText);

        }).findFirst();
        
       return element;

    }

}
