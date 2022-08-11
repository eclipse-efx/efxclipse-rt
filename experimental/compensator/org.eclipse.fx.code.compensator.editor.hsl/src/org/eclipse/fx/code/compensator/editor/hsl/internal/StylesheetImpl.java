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
package org.eclipse.fx.code.compensator.editor.hsl.internal;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.code.compensator.hsl.hSL.Model;
import org.eclipse.fx.ui.services.theme.MultiURLStylesheet;
import org.eclipse.fx.ui.services.theme.Theme;

public class StylesheetImpl implements MultiURLStylesheet {
	private ObservableList<URL> defaultUrls = FXCollections.observableArrayList();
	private ObservableList<URL> darkUrls  = FXCollections.observableArrayList();
	
	public void setHSLComponent(HSLComponent component) {
		ObservableList<Model> models = component.getModels();
		for( Model m : models ) {
			defaultUrls.add(getDefaultStylesheet(m, "default"));
			darkUrls.add(getDefaultStylesheet(m, "dark"));
		}
		models.addListener(this::handleModelChange);
		
	}
	
	private void handleModelChange(Change<? extends Model> change) {
		while( change.next() ) {
			for( Model m : change.getRemoved() ) {
				defaultUrls.remove(getDefaultStylesheet(m, "default"));
				darkUrls.remove(getDefaultStylesheet(m, "dark"));
			}
			
			for( Model m : change.getAddedSubList() ) {
				defaultUrls.add(getDefaultStylesheet(m, "default"));
				darkUrls.add(getDefaultStylesheet(m, "dark"));
			}
		}
	}
	
	@Override
	public boolean appliesToTheme(Theme t) {
		return true;
	}

//	public ObservableList<URL> getURL(Theme t) {
//		if( "dark".equals(t.getId()) ) {
//			return FXCollections.observableArrayList(getClass().getClassLoader().getResource("css/dark-highlight.css"));
//		}
//		return FXCollections.observableArrayList(getClass().getClassLoader().getResource("css/highlight.css"));
//	}
	
	@Override
	public ObservableList<URL> getURL(Theme t) {
		if( "dark".equals(t.getId()) ) {
			return darkUrls;
		}
		return defaultUrls;
	}
	
	private static URL getDefaultStylesheet(Model model, String themeId) {
		if ("default".equals(themeId)) {
			themeId = null;
		}
		URI uri = model.eResource().getURI();
		uri = uri.trimSegments(1);
		uri = uri.appendSegment(model.getName() + (themeId != null ? "-" + themeId : "") + "-highlight.css");

		if (uri.isPlatform()) {
			System.err.println(StylesheetImpl.class.getClassLoader().getResource(getPluginPath(uri)));
			return StylesheetImpl.class.getClassLoader().getResource(getPluginPath(uri));
		} else {
			try {
				return new File(uri.toFileString()).toURI().toURL();
			} catch (MalformedURLException e) {
				return null;
			}
		}
	}

	private static String getPluginPath(URI uri) {
		String[] parts = uri.segments();
		StringBuffer b = new StringBuffer(parts[2]);

		for (int i = 3; i < parts.length; i++) {
			b.append("/" + parts[i]);
		}
		return b.toString();
	}
}