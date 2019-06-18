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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.fx.core.Subscription;
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
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class PreferenceUI {

	/**
	 * The CSS class for the top-level container of the Preference UI
	 */
	public static final String TOP_LEVEL_STYLE = "preferences-container";

	/**
	 * The CSS class for the content area of the preferences (Where the current
	 * preference page is displayed)
	 */
	public static final String CONTENT_AREA_STYLE = "preferences-contents";
	
	/**
	 * The CSS class for a preference page
	 */
	public static final String PAGE_STYLE = "preferences-page";
	
	/**
	 * The CSS class for the list of preference pages
	 */
	public static final String PAGE_LIST_STYLE = "preferences-page-list";
	
	/**
	 * The CSS class for the page-search field
	 */
	public static final String SEARCH_STYLE = "preferences-search-field";
	
	/**
	 * The CSS class for the Actions bar
	 */
	public static final String ACTIONS_BAR_STYLE = "preferences-actions-bar";

	private final ListView<PreferencePageProvider> providerView;

	private final TitledPane contentAreaWrapper;
	private final ScrollPane contentArea;

	private final List<Consumer<PreferencePage>> onCancelHandlers = new ArrayList<>();
	private final List<Consumer<PreferencePage>> onOkHandlers = new ArrayList<>();

	private Map<PreferencePageProvider, PageCache> pages = new HashMap<>();

	private final PreferencePageFactory factory;

	protected String currentFilter = "";

	private final ObservableList<PreferencePageProvider> providers = FXCollections.observableArrayList();
	private final SortedList<PreferencePageProvider> sortedProviders = providers.sorted(getComparator());
	private final FilteredList<PreferencePageProvider> filteredProviders = sortedProviders.filtered(getFilter());
	private PageCache currentPage;

	private HBox actions;

	private TextField searchField;

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
		this.providerView.getStyleClass().add(PAGE_LIST_STYLE);
		this.contentAreaWrapper = new TitledPane();
		this.contentArea = new ScrollPane();
		this.contentArea.setFitToWidth(true);
		this.contentArea.setFitToHeight(true);
		this.contentAreaWrapper.setContent(this.contentArea);
		this.contentAreaWrapper.setMaxHeight(Double.MAX_VALUE);
		this.contentAreaWrapper.setMaxWidth(Double.MAX_VALUE);
		this.contentAreaWrapper.setCollapsible(false);

		this.providerView.setCellFactory(v -> new SimpleListCell<>(pp -> pp.titleProperty().getValue()));
		FXObservableUtil.onChange(this.providerView.getSelectionModel().selectedItemProperty(),
				this::handleSelectedPageChange);
		providerView.setItems(filteredProviders);
	}

	private void handleSelectedPageChange(PreferencePageProvider provider) {
		if (provider != null) {
			this.currentPage = pages.computeIfAbsent(provider, p -> {
				BorderPane parent = new BorderPane();
				parent.getStyleClass().add(PAGE_STYLE);
				return new PageCache(factory.make(parent, provider), parent);
			});

			contentAreaWrapper.setText(provider.titleProperty().getValue().toString());
			contentArea.setContent(this.currentPage.parent);

		} else {
			contentArea.setContent(null);
			contentAreaWrapper.setText(null);
			this.currentPage = null;
		}
	}

	@PostConstruct
	void init(BorderPane container) {
		BorderPane root = new BorderPane() {
			@Override
			public String getUserAgentStylesheet() {
				return "platform:/plugin/org.eclipse.fx.ui.preferences/preferenceUI.css";
			}
		};
		root.getStyleClass().add(TOP_LEVEL_STYLE);
		container.setCenter(root);
		SplitPane split = new SplitPane();

		{
			VBox box = new VBox();
			searchField = new TextField();
			searchField.getStyleClass().add(SEARCH_STYLE);
			FXObservableUtil.onChange(searchField.textProperty(), newFilter -> {
				this.currentFilter = newFilter == null ? "" : newFilter;
				refreshFilter();
			});

			box.getChildren().add(searchField);
			box.getChildren().add(providerView);
			VBox.setVgrow(providerView, Priority.ALWAYS);

			split.getItems().add(box);

			SplitPane.setResizableWithParent(box, false);
		}

		{
			BorderPane p = new BorderPane();
			p.getStyleClass().add(CONTENT_AREA_STYLE);
			p.setCenter(contentAreaWrapper);
			split.getItems().add(p);
		}

		split.setDividerPositions(0.3);

		root.setCenter(split);
		actions = new HBox();
		actions.getStyleClass().add(ACTIONS_BAR_STYLE);
		actions.setMinWidth(Region.USE_PREF_SIZE);
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
				Command<Void> persist = pageCache.page.persist();
				persist.evaluate();
				if (persist.isEnabled()) {
					persist.execute();
				}
			}
			PreferencePage activePreferencePage = currentPage == null ? null : currentPage.page;
			this.onOkHandlers.forEach(handler -> {
				handler.accept(activePreferencePage);
			});
		}));
	}

	private Optional<Command<Void>> cancel() {
		return Optional.of(Command.createCommand(() -> {
			for (PageCache pageCache : pages.values()) {
				pageCache.page.reset().execute();
			}
			PreferencePage activePreferencePage = currentPage == null ? null : currentPage.page;
			this.onCancelHandlers.forEach(handler -> handler.accept(activePreferencePage));
		}));
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
		// Make sure one page is always selected
		// If we already had a selection, preserve it; otherwise, select the first
		// visible item
		PreferencePageProvider selectedItem = selectionModel.getSelectedItem();
		this.filteredProviders.predicateProperty().set(getFilter());
		if (selectionModel.isEmpty()) {
			if (selectedItem == null || !filteredProviders.contains(selectedItem)) {
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

	protected Predicate<PreferencePageProvider> getFilter() {
		String filter = currentFilter == null ? "*" : "*" + currentFilter + "*"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return provider -> provider.select(filter);
	}

	protected Comparator<PreferencePageProvider> getComparator() {
		return (p1, p2) -> Collator
		.getInstance().compare(p1.titleProperty().getValue().toString(), p2.titleProperty().getValue().toString());
	}

	public Subscription registerOnCancelHandler(Consumer<PreferencePage> handler) {
		onCancelHandlers.add(handler);
		return () -> onCancelHandlers.remove(handler);
	}

	public Subscription registerOnOkHandler(Consumer<PreferencePage> handler) {
		onOkHandlers.add(handler);
		return () -> onOkHandlers.remove(handler);
	}

	/**
	 * <p>
	 * Set the text filter to the given value. The filter is used to restrict the
	 * pages displayed in the pages list.
	 * </p>
	 * <p>
	 * The filter is case-insensitive, and accepts wildcards (* and ?)
	 * </p>
	 * 
	 * @param filter The new filter
	 */
	public void setFilter(String filter) {
		searchField.setText(filter);
	}

	/**
	 * Select the preference page with the given ID
	 * 
	 * @param pageId The ID of the page to select
	 * 
	 * @see PreferencePageProvider#id()
	 */
	public void selectPage(String pageId) {
		if (pageId == null) {
			return;
		}
		providers.stream().filter(p -> pageId.equals(p.id())).findAny()
				.ifPresent(providerView.getSelectionModel()::select);
	}
}
