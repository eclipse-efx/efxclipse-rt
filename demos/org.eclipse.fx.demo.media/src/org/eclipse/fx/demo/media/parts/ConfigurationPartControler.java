/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.demo.media.parts;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.fx.demo.media.addon.PerspectiveAnimationAddon.TransitionImpl;
import org.eclipse.fx.ui.animation.pagetransition.CenterSwitchAnimation;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.fx.ui.services.theme.ThemeManager;
import org.osgi.service.prefs.BackingStoreException;

@SuppressWarnings("restriction")
public class ConfigurationPartControler implements Initializable {
	@Inject
	TransitionImpl transitionService;

	@Inject
	@Preference("perspectiveTransition")
	@Optional
	String transition;
	
	@Inject
	ThemeManager manager;
	
	@FXML
	ChoiceBox<String> themeId;
	@FXML
	ChoiceBox<String> switchType;
	@FXML
	BorderPane switchPreview;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		{
			ObservableList<String> items = FXCollections.observableArrayList();
			for( Theme t : manager.getAvailableThemes() ) {
				items.add(t.getName());
			}
			
			themeId.setItems(items);
			
			for( int i = 0; i < items.size(); i++ ) {
				if( items.get(i).equals(manager.getCurrentTheme().getName()) ) {
					themeId.getSelectionModel().select(i);
					break;
				}
			}
			
			themeId.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					manager.setCurrentThemeId(manager.getAvailableThemes().get(newValue.intValue()).getId());
				}				
			});
		}
		
		{
			ObservableList<String> items = FXCollections.observableArrayList();
			for (String e : transitionService.getAnimations().keySet()) {
				items.add(e);
			}
			Collections.sort(items);
			items.add(0, "<NONE>");
			switchType.setItems(items);
			
			final ImageView view1 = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("/icons/resources/pics/pic1.jpg")));
			view1.setFitWidth(200);
			view1.setFitHeight(150);
			
			final ImageView view2 = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("/icons/resources/pics/pic2.jpg")));
			view2.setFitWidth(200);
			view2.setFitHeight(150);
			
			switchPreview.setCenter(view1);
			switchPreview.setClip(new Rectangle(200, 150));
			if( transition == null ) {
				switchType.getSelectionModel().select(0);
			} else {
				for( int i = 0; i < items.size(); i++ ) {
					if( items.get(i).equals(transition) ) {
						switchType.getSelectionModel().select(i);
						break;
					}
				}
			}
			switchType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					if(! "<NONE>".equals(newValue) ) {
						CenterSwitchAnimation a = transitionService.getAnimations().get(newValue);
						if( a != null ) {
							a.animate(switchPreview, switchPreview.getCenter() == view1 ? view2 : view1, null);
							updateTransitionPreference(newValue);
						} else {
							updateTransitionPreference(null);
						}
					} else {
						updateTransitionPreference(null);
					}
				}
			});
		}
	}
	
	private void updateTransitionPreference(String newValue) {
		IEclipsePreferences preference = InstanceScope.INSTANCE.getNode("org.eclipse.fx.demo.media");
		preference.put("perspectiveTransition", newValue);
		try {
			preference.flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
