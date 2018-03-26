/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.preferences;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.fx.core.di.Service;
import org.eclipse.fx.core.observable.FXObservableUtil;
import org.eclipse.fx.ui.controls.list.SimpleListCell;

import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PreferenceUI {
	private final ListView<PreferencePageProvider> providerView;
	
	private final ScrollPane contentArea;
	
	private Map<PreferencePageProvider, PageCache> pages = new HashMap<>();
	
	private final PreferencePageFactory factory;
	
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
		
		this.providerView.setCellFactory( v -> new SimpleListCell<>( pp -> pp.titleProperty().getValue()));
		FXObservableUtil.onChange(this.providerView.getSelectionModel().selectedItemProperty(), this::handleSelectedPageChange);
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
		
		{
			VBox box = new VBox();
			TextField searchField = new TextField();
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
	}
	
	@Inject
	public void setPreferencePageProviders(@Service List<PreferencePageProvider> providers) {
		providerView.getItems().setAll(providers);
	}
}
