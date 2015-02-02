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
package org.eclipse.fx.ui.theme.internal;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableMap;
import javafx.scene.Scene;

import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.fx.ui.services.theme.ThemeManager;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

/**
 * Default implementation of a theme manager
 */
public class DefaultThemeManager implements ThemeManager {
	static final String ATT_ID = "id"; //$NON-NLS-1$
	static final String ATT_NAME = "name"; //$NON-NLS-1$
	static final String ATT_THEME_ID = "themeId"; //$NON-NLS-1$
	static final String ATT_BASETYLESHEET = "basestylesheet"; //$NON-NLS-1$
	static final String ATT_RESOURCE = "resource"; //$NON-NLS-1$

	@SuppressWarnings("null")
	private final @NonNull ObservableMap<@NonNull String, @NonNull Theme> themes = FXCollections.observableMap(new HashMap<>());
	@SuppressWarnings("null")
	private final @NonNull ObservableMap<@NonNull String, @NonNull Theme> unmodifiableThemes = FXCollections.unmodifiableObservableMap(this.themes);
	private String currentThemeId;
	List<Scene> managedScenes = new ArrayList<Scene>();

	/**
	 * Create a new theme manager instance
	 */
	public DefaultThemeManager() {
	}

	@Override
	public Theme getCurrentTheme() {
		if (this.themes.isEmpty()) {
			return null;
		} else if (this.themes.size() == 1) {
			return this.themes.values().iterator().next();
		} else {
			String id = getCurrentThemeId();
			if (id != null) {
				if( this.themes.containsKey(id) ) {
					return this.themes.get(id);
				}
			}
		}

		return null;
	}

	@Override
	public @NonNull ObservableMap<@NonNull String, @NonNull Theme> getAvailableThemes() {
		return this.unmodifiableThemes;
	}

	@SuppressWarnings("null")
	private static @NonNull String getCSSClassname(@NonNull String id) {
		return id.replace('.', '-');
	}
	
	private void handleStylesheetUrlChange(Change<? extends URL> change) {
		while(change.next()) {
			for (Scene scene : this.managedScenes) {
				for( URL url : change.getRemoved() ) {
					scene.getStylesheets().remove(url.toExternalForm());
				}
				
				for( URL url : change.getAddedSubList() ) {
					scene.getStylesheets().add(url.toExternalForm());
				}
			}
		}
	}
	
	private void unsetTheme(Theme theme) {
		theme.getStylesheetURL().removeListener(this::handleStylesheetUrlChange);
		
		for (Scene scene : this.managedScenes) {
			Collection<Theme> availableThemes = getAvailableThemes().values();
			for (Theme t : availableThemes) {
				for (URL url : t.getStylesheetURL()) {
					if (scene.getRoot() != null) {
						scene.getRoot().getStyleClass().remove(getCSSClassname(t.getId()));
					}
					scene.getStylesheets().remove(url.toExternalForm());
				}
			}
		}
	}
	
	private void setTheme(Theme theme) {
		theme.getStylesheetURL().addListener(this::handleStylesheetUrlChange);
		for (Scene scene : this.managedScenes) {
			for (URL url : theme.getStylesheetURL()) {
				if (theme.getId().equals(this.currentThemeId)) {
					if (scene.getRoot() != null) {
						scene.getRoot().getStyleClass().remove(getCSSClassname(theme.getId()));
						scene.getRoot().getStyleClass().add(getCSSClassname(theme.getId()));
					}
					scene.getStylesheets().add(url.toExternalForm());
				}
			}			
		}
	}

	@Override
	public void setCurrentThemeId(String id) {
		if( this.themes.containsKey(id) ) {
			if( this.currentThemeId != null && this.themes.containsKey(this.currentThemeId) ) {
				unsetTheme(this.themes.get(this.currentThemeId));
			}
			
			this.currentThemeId = id;
			
			Theme theme = this.themes.get(id);
			
			setTheme(theme);
			
			EventAdmin eventAdmin = getEventAdmin();
			if (eventAdmin != null) {
				eventAdmin.sendEvent(new Event(Constants.THEME_CHANGED, Collections.singletonMap("org.eclipse.e4.data", id))); //$NON-NLS-1$
			}
			return;
		}
		throw new IllegalArgumentException("Theme with id '" + id + "' is not known."); //$NON-NLS-1$ //$NON-NLS-2$
	}

	private String getCurrentThemeId() {
		return this.currentThemeId;
	}

	private static Logger LOGGER;

	@SuppressWarnings("null")
	@NonNull
	static Logger getLogger() {
		Logger logger = LOGGER;
		if (logger == null) {
			ServiceReference<LoggerFactory> ref = Activator.getContext().getServiceReference(LoggerFactory.class);
			logger = Activator.getContext().getService(ref).createLogger(DefaultThemeManager.class.getName());
			LOGGER = logger;
		}
		return LOGGER;
	}

	private EventAdmin eventAdmin;

	@Nullable
	EventAdmin getEventAdmin() {
		EventAdmin eventAdmin = this.eventAdmin;
		if (eventAdmin != null) {
			return eventAdmin;
		}

		ServiceReference<EventAdmin> ref = Activator.getContext().getServiceReference(EventAdmin.class);
		if (ref != null) {
			eventAdmin = Activator.getContext().getService(ref);
		}

		return eventAdmin;
	}

	@Override
	public Registration registerScene(final Scene scene) {
		this.managedScenes.add(scene);
		InvalidationListener l = (o) -> {
			String themeId = this.currentThemeId;
			if (scene.getRoot() != null && themeId != null) {
				scene.getRoot().getStyleClass().remove(getCSSClassname(themeId));
				scene.getRoot().getStyleClass().add(getCSSClassname(themeId));
			}
		};
		String themeId = this.currentThemeId;
		if (themeId != null) {
			scene.getRoot().getStyleClass().remove(getCSSClassname(themeId));
			scene.getRoot().getStyleClass().add(getCSSClassname(themeId));
		}

		scene.rootProperty().addListener(l);
		return new Registration() {

			@Override
			public void dispose() {
				scene.rootProperty().removeListener(l);
				DefaultThemeManager.this.managedScenes.remove(scene);
			}
		};
	}

	/**
	 * Register a new theme
	 *
	 * @param theme
	 *            the theme
	 */
	public void registerTheme(@NonNull Theme theme) {
		synchronized (this.themes) {
			this.themes.put(theme.getId(),theme);
		}
	}

	/**
	 * Unregister a theme
	 *
	 * @param theme
	 *            the theme
	 */
	public void unregisterTheme(@NonNull Theme theme) {
		synchronized (this.themes) {
			this.themes.remove(theme);
		}
	}
}