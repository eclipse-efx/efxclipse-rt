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
package org.eclipse.fx.tool.context.spy.internal.model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.internal.contexts.EclipseContext;

import org.eclipse.fx.tool.context.spy.internal.element.ContextOutlineElement;
import org.eclipse.fx.tool.context.spy.internal.element.ContextOverviewElement;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Model of the context spy tool.
 */
public class ContextSpyModel {

    private Optional<IEclipseContext> currentRootContext = Optional.empty();
    private final ObjectProperty<ContextOverviewElement> rootContextTreeElement = new SimpleObjectProperty<>();
    private Optional<ContextOverviewElement> selectedContextTreeElement = Optional.empty();
    private final ObservableList<ContextOutlineElement> contextOutlineElements = FXCollections.observableArrayList();
    private String lastSearch = "";
    private final BooleanProperty showOnlyFilteredProperty = new SimpleBooleanProperty(false);

    // ----- Reset the root context -----

    public void setContext(IEclipseContext iEclipseContext) {
        this.currentRootContext = Optional.ofNullable(iEclipseContext);
    }

    // ----- Refresh everything ----

    public void refresh() {
        this.currentRootContext.ifPresent(rootContext -> rootContextTreeElement.setValue(createContextTreeElement(rootContext)));
    }

    private ContextOverviewElement createContextTreeElement(IEclipseContext context) {
        return new ContextOverviewElement(context, computeChildren(context));
    }

    private List<ContextOverviewElement> computeChildren(IEclipseContext context) {
        return ((EclipseContext) context).getChildren().stream().map(this::createContextTreeElement).collect(Collectors.toList());
    }

    // ----- Select a context -----

    public void setSelectedContextTreeElement(ContextOverviewElement contextTreeElement) {
        selectedContextTreeElement = Optional.ofNullable(contextTreeElement);
        setContextOutlineElements(Collections.emptyList());
        refreshOutline();
    }

    // ----- Enter a search string -----

    public void search(String searchString) {
        lastSearch = searchString;
        refreshOutline();
    }

    // ----- Change show only filtered option -----

    public void setShowOnlyFiltered(Boolean checked) {
        showOnlyFilteredProperty.setValue(checked);
        refreshOutline();
    }

    private void refreshOutline() {
        setContextOutlineElements(
        selectedContextTreeElement.map(element->element.getOutline()).orElse(Collections.emptyList()));        
    }

    private void setContextOutlineElements(List<ContextOutlineElement> contextOutlineElements) {

        this.contextOutlineElements.clear();
        this.contextOutlineElements.addAll(contextOutlineElements);

        searchOverview(lastSearch, rootContextTreeElement.getValue());
        searchOutline(lastSearch, this.contextOutlineElements);

        if (showOnlyFilteredProperty.getValue() == Boolean.TRUE) {
            this.contextOutlineElements.forEach(ContextOutlineElement::filterOut);
            this.contextOutlineElements.clear();
            this.contextOutlineElements.addAll(contextOutlineElements);
        }

    }

    private void searchOverview(String searchText, ContextOverviewElement context) {
        context.showAll(searchText == null || searchText.trim().length() == 0);
        context.setMaredAsSearchResult(!context.isShowAll() && context.containsText(searchText));
        context.getChildren().forEach(ctx -> searchOverview(searchText, ctx));
    }

    private void searchOutline(String searchString, List<ContextOutlineElement> contextOutlineElements) {
        contextOutlineElements.forEach(element -> element.setMaredAsSearchResult(false));
        if (searchString != null && searchString.trim().length() > 0) {
            markSearchResults(searchString, contextOutlineElements);
        }
        contextOutlineElements.forEach(element -> searchOutline(searchString, element.getChildren()));
    }

    private void markSearchResults(String searchString, List<ContextOutlineElement> contextOutlineElements) {
        contextOutlineElements.stream().filter(element -> element.getKey().toString().toLowerCase().contains(searchString))
                .forEach(element -> element.setMaredAsSearchResult(true));
        contextOutlineElements.stream().filter(element -> element.getValue().toString().toLowerCase().contains(searchString))
                .forEach(element -> element.setMaredAsSearchResult(true));
    }

    // ---- expand / collapse ----

    public void expandAll() {
        expand(rootContextTreeElement.getValue());
    }

    public void collapseAll() {
        collapse(rootContextTreeElement.getValue());
    }

    private void expand(ContextOverviewElement element) {
        element.setExpanded(true);
        element.getChildren().forEach(this::expand);
    }

    private void collapse(ContextOverviewElement element) {
        element.setExpanded(false);
        element.getChildren().forEach(this::collapse);
    }

    // ----- getter ----

    public ObservableList<ContextOutlineElement> getContextOutlineElements() {
        return contextOutlineElements;
    }

    public ObjectProperty<ContextOverviewElement> contextObjectProperty() {
        if (rootContextTreeElement.getValue() == null) {
            refresh();
        }
        return rootContextTreeElement;
    }

    public ReadOnlyBooleanProperty showOnlyFiltered() {
        return showOnlyFilteredProperty;
    }

}
