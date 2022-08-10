/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.context.spy.internal.view;

import org.eclipse.fx.tool.context.spy.internal.model.ContextSpyModel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * Main view of the context spy tool.
 */
public class ContextSpyView {

	private static final String REFRESH_BUTTON_TOOLTIP = "Refresh the contexts";
	private static final String EXPAND_BUTTON_TOOLTIP = "Expand context nodes";
	private static final String COLLAPSE_BUTTON_TOOLTIP = "Collapse context nodes";

	private static final String SEARCH_TEXT_FIELD_PROMPT_TEXT = "Search Data";
	private static final String SEARCH_TEXT_FIELD_TOOLTIP_TEXT = "Highlight the contexts where the contained objects contains this string pattern.\n"
			+ "Case is ignored.";

	private static final String SHOW_ONLY_FILTERED_TEXT = "Show Only Filtered";
	private static final String SHOW_ONLY_THE_FILTERED_TOOLTIP_TEXT = "Show only the filtered items in the table view";

	private static final String ICON_COLLAPSEALL = "/icons/collapseall.png";
	private static final String ICON_EXPANDALL = "/icons/expandall.png";
	private static final String ICON_REFRESH = "/icons/refresh.png";

	private static final String CSS_CONTEXT_SPY_CSS = "/css/context-spy.css";

	private BorderPane borderPane;

	private final ContextSpyModel model;
	private HBox topPanel;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 */
	public ContextSpyView(ContextSpyModel model) {
		this.model = model;
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
		applyCss();
		borderPane.setTop(createTopPanel());
		SplitPane splitPane = new SplitPane(new ContextOverview(model).getGui(),
		        new ContextOutline(model).getGui());
		splitPane.setOrientation(Orientation.VERTICAL);
		splitPane.setDividerPositions(0.66d);
		borderPane.setCenter(splitPane);		
	}

	private void applyCss() {
		borderPane.getStylesheets().add(this.getClass().getResource(CSS_CONTEXT_SPY_CSS).toExternalForm());
	}

	private HBox createTopPanel() {
		topPanel = new HBox(10.0);
		topPanel.setPadding(new Insets(10));

		createButton(ICON_REFRESH, event -> model.refresh(), REFRESH_BUTTON_TOOLTIP);
		createButton(ICON_EXPANDALL, event -> model.expandAll(), EXPAND_BUTTON_TOOLTIP);
		createButton(ICON_COLLAPSEALL, event -> model.collapseAll(), COLLAPSE_BUTTON_TOOLTIP);

		createSearchTextFieldAndFilterCheckbox();

		return topPanel;
	}

	private void createButton(String iconImageUrl, EventHandler<ActionEvent> eventHandler, String tooltipText) {
		Button button = new Button(null, new ImageView(new Image(getClass().getResourceAsStream(iconImageUrl))));
		button.setTooltip(new Tooltip(tooltipText));
		button.setOnAction(eventHandler);
		topPanel.getChildren().add(button);
	}

	private void createSearchTextFieldAndFilterCheckbox() {
		TextField searchField = new TextField();
		searchField.setPromptText(SEARCH_TEXT_FIELD_PROMPT_TEXT);
		searchField.setTooltip(new Tooltip(SEARCH_TEXT_FIELD_TOOLTIP_TEXT));

		CheckBox showOnlyFilteredBox = new CheckBox(SHOW_ONLY_FILTERED_TEXT);
		showOnlyFilteredBox.setTooltip(new Tooltip(SHOW_ONLY_THE_FILTERED_TOOLTIP_TEXT));
		showOnlyFilteredBox.selectedProperty().addListener((ev, oldv, newv) -> model.setShowOnlyFiltered(newv));
		showOnlyFilteredBox.disableProperty().bind(searchField.textProperty().isEmpty());

		searchField.textProperty().addListener((ev, oldv, newv) -> {
			if (newv == null || newv.trim().length() == 0) {
				showOnlyFilteredBox.setSelected(false);
			}
			model.search(newv.toLowerCase());
		});

		topPanel.getChildren().add(searchField);
		topPanel.getChildren().add(showOnlyFilteredBox);
	}

}
