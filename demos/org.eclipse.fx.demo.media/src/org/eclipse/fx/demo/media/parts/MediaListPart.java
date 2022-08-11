/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.demo.media.parts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.demo.media.model.Media;
import org.eclipse.fx.demo.media.model.MediaType;

@SuppressWarnings("restriction")
public class MediaListPart {
	static class MediaCell extends ListCell<Media> {
		@Override
		protected void updateItem(Media item, boolean empty) {
			if(  ! empty && item != null ) {
				setText(item.getName());
				switch (item.getType()) {
				case MOVIE:
					setGraphic(new ImageView("platform:/plugin/org.eclipse.fx.demo.media/icons/kaffeine.png"));
					break;
				case PICTURE:
					setGraphic(new ImageView("platform:/plugin/org.eclipse.fx.demo.media/icons/games-config-background.png"));
					break;
				default:
					setGraphic(new ImageView("platform:/plugin/org.eclipse.fx.demo.media/icons/player-volume.png"));
					break;
				}				
			}
			super.updateItem(item, empty);
		}
	}
	
	
	@Inject
	EPartService partService;
	
	@Inject
	EModelService modelService;
	
	@Inject
	MPerspective perspective;
	
	private ListView<Media> list;
	
	@PostConstruct
	void init(BorderPane pane) {
		list = new ListView<Media>(createList("perspective.videos".equals(perspective.getElementId())));
		list.getStyleClass().add("mediaList");
		list.setCellFactory(new Callback<ListView<Media>, ListCell<Media>>() {
			
			@Override
			public ListCell<Media> call(ListView<Media> param) {
				return new MediaCell();
			}
		});
		list.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if( event.getClickCount() > 1 ) {
					handleOpen();
				}
			}
		});
		pane.setCenter(list);
	}
	
	void handleOpen() {
		MPartStack stack = (MPartStack) modelService.find("content.stack", perspective);
		Media m = list.getSelectionModel().getSelectedItem();
		
		if( m != null ) {
			String instance = Media.serialize(m);
			
			for( MStackElement e : stack.getChildren() ) {
				if( e instanceof MPart ) {
					if( instance.equals(e.getPersistedState().get(MediaPart.MEDIA_OBJECT_KEY)) ) {
						partService.activate((MPart) e);
						return;
					}
				}
			}
			
			MPart p = MBasicFactory.INSTANCE.createPart();
			p.setLabel(m.getName());
			if( m.getType() == MediaType.MOVIE ) {
				p.setIconURI("platform:/plugin/org.eclipse.fx.demo.media/icons/22/kaffeine.png");	
			} else if( m.getType() == MediaType.PICTURE ) {
				p.setIconURI("platform:/plugin/org.eclipse.fx.demo.media/icons/22/games-config-background.png");
			} else {
				p.setIconURI("platform:/plugin/org.eclipse.fx.demo.media/icons/22/player-volume.png");
			}
			
			p.setContributionURI("bundleclass://org.eclipse.fx.demo.media/org.eclipse.fx.demo.media.parts.MediaPart");
			p.getPersistedState().put(MediaPart.MEDIA_OBJECT_KEY, instance);
			stack.getChildren().add(p);
			partService.activate(p,true);			
		}
	}
	
	@Focus
	void focus() {
		list.requestFocus();
	}
	
	private static ObservableList<Media> createList(boolean videos) {
		ObservableList<Media> l = FXCollections.observableArrayList();
		if( ! videos ) {
			l.add(new Media(MediaType.PICTURE, "Mountains 1",     "platform:/plugin/org.eclipse.fx.demo.media/icons/resources/pics/pic1.jpg"));
			l.add(new Media(MediaType.PICTURE, "Mountains 2", "platform:/plugin/org.eclipse.fx.demo.media/icons/resources/pics/pic2.jpg"));
		} else {
			l.add(new Media(MediaType.MOVIE,   "Grog",       "platform:/plugin/org.eclipse.fx.demo.media/icons/resources/movs/mov1.flv"));
		}
		return l;
	}
}