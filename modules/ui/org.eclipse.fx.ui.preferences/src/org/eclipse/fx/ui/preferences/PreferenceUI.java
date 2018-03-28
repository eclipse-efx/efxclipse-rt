/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at, EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *     Camille Letavernier<cletavernier@eclipsesource.com>
 *******************************************************************************/
package org.eclipse.fx.ui.preferences;

import java.text.Collator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.fx.core.command.Command;
import org.eclipse.fx.core.di.Service;
import org.eclipse.fx.core.observable.FXObservableUtil;
import org.eclipse.fx.ui.controls.list.SimpleListCell;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PreferenceUI {
	private final ListView<PreferencePageProvider> providerView;
	
	private final ScrollPane contentArea;
	
	private Map<PreferencePageProvider, PageCache> pages = new HashMap<>();
	
	private final PreferencePageFactory factory;

	private String currentFilter = "";
	
	private final ObservableList<PreferencePageProvider> providers = FXCollections.observableArrayList();
	private final SortedList<PreferencePageProvider> sortedProviders = providers.sorted((p1, p2) -> Collator.getInstance().compare(p1.titleProperty().getValue().toString(), p2.titleProperty().getValue().toString()));
	private final FilteredList<PreferencePageProvider> filteredProviders = sortedProviders.filtered(getFilter());

	private HBox actions;
	
	static class PageCache {
		final PreferencePage page;
		final BorderPane parent;
		
		public PageCache(PreferencePage page, BorderPane parent) {
			this.page = page;
			this.parent = parent;
		}
	}
	
	@Inject
	public PreferenceUI(PreferencePageFactory factory) {
		this.factory = factory;
		this.providerView = new ListView<>();
		this.contentArea = new ScrollPane();
		this.contentArea.setFitToWidth(true);
		this.contentArea.setFitToHeight(true);
		
		this.providerView.setCellFactory( v -> new SimpleListCell<>( pp -> pp.titleProperty().getValue()));
		FXObservableUtil.onChange(this.providerView.getSelectionModel().selectedItemProperty(), this::handleSelectedPageChange);
		providerView.setItems(filteredProviders);
	}
	
	private void handleSelectedPageChange(PreferencePageProvider provider) {
		if( provider != null ) {
			PageCache pc = pages.computeIfAbsent(provider, p -> {
				BorderPane parent = new BorderPane();
				return new PageCache(factory.make(parent, provider), parent);
			});
			
			contentArea.setContent(pc.parent);			
		} else {
			contentArea.setContent(null);
		}
	}
	
	@PostConstruct
	void init(BorderPane root) {
		SplitPane split = new SplitPane();
		root.getStylesheets().add(getClass().getResource("preferenceUI.css").toExternalForm());
		
		{
			VBox box = new VBox();
			TextField searchField = new TextField();
			searchField.textProperty().addListener((obs, old, newFilter) -> { 
				this.currentFilter = newFilter == null ? "" : newFilter;
				refreshFilter();
			});
			
			box.getChildren().add(searchField);
			box.getChildren().add(providerView);
			VBox.setVgrow(providerView, Priority.ALWAYS);
			
			split.getItems().add(box);
		}
		
		{
			BorderPane p = new BorderPane();
			p.setCenter(contentArea);
			split.getItems().add(p);	
		}
		
		split.setDividerPositions(0.3);
		
		root.setCenter(split);
		actions = new HBox();
		actions.getStyleClass().add("preferences-actions-bar");
		actions.setAlignment(Pos.BASELINE_RIGHT);
		createActionButtons();
		root.setBottom(actions);
		
		selectFirstPage();
	}
	
	protected void createActionButtons() {
		addButton("Cancel", this.cancel());
		addButton("Apply and Close", this.applyAndClose());
	}
	
	private Optional<Command<Void>> applyAndClose() {
		return Optional.of(Command.createCommand(() -> {
			for (PageCache pageCache : pages.values()) {
				pageCache.page.persist().execute();
			}
		}));
	}

	private Optional<Command<Void>> cancel() {
		return Optional.of(Command.createCommand(() -> {
			for (PageCache pageCache : pages.values()) {
				pageCache.page.reset().execute();
			}
			this.requestClose();
		}));
	}

	private void requestClose() {
		//Unsupported TODO
	}

	protected void addButton(String label, Optional<Command<Void>> restoreDefault) {
		Button action = new Button(label);
		actions.getChildren().add(action);
		if (restoreDefault.isPresent()) {
			Command<Void> command = restoreDefault.get();
			action.disableProperty().bind(command.enabledProperty().not());
			action.setOnAction(event -> {
				command.evaluate();
				if (command.isEnabled()) {
					command.execute();
				}
			});
		} else {
			action.setDisable(true);
		}
	}
	
	private void refreshFilter() {
		SelectionModel<PreferencePageProvider> selectionModel = providerView.getSelectionModel();
		//Make sure one page is always selected
		//If we already had a selection, preserve it; otherwise, select the first visible item
		PreferencePageProvider selectedItem = selectionModel.getSelectedItem();
		this.filteredProviders.predicateProperty().set(getFilter());
		if (selectionModel.isEmpty()) {
			if (selectedItem == null || ! filteredProviders.contains(selectedItem)) {
				selectionModel.selectFirst();
			} else {
				selectionModel.select(selectedItem);
			}
		}
	}

	private void selectFirstPage() {
		providerView.getSelectionModel().clearSelection();
		providerView.getSelectionModel().selectFirst();
	}

	@Inject
	public void setPreferencePageProviders(@Service List<PreferencePageProvider> providers) {
		this.providers.setAll(providers);
	}
	
	private Predicate<PreferencePageProvider> getFilter(){
		String filter = currentFilter == null ? "*" : "*" + currentFilter+"*"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return provider -> provider.select(filter);
	}
}
