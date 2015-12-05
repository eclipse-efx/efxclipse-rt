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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.fx.core.URLStreamHandler;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.fx.ui.services.theme.ThemeManager;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicyOption;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.url.URLConstants;
import org.osgi.service.url.URLStreamHandlerService;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.Scene;

/**
 * Default implementation of a theme manager
 */
@Component
public class DefaultThemeManager implements ThemeManager {

	@SuppressWarnings("null")
	private final @NonNull ObservableMap<@NonNull String, @NonNull Theme> themes = FXCollections.observableMap(new HashMap<>());
	@SuppressWarnings("null")
	private final @NonNull ObservableMap<@NonNull String, @NonNull Theme> unmodifiableThemes = FXCollections.unmodifiableObservableMap(this.themes);
	private String currentThemeId;
	ObservableList<Scene> managedScenes = FXCollections.observableArrayList();

	/**
	 * Create a new theme manager instance
	 */
	public DefaultThemeManager() {
		for( URLStreamHandler handler : Util.lookupServiceList(URLStreamHandler.class) ) {
			Hashtable<String, Object> t = new Hashtable<>();
			t.put(URLConstants.URL_HANDLER_PROTOCOL, new String[] { handler.getProtocol() });
			Activator.getContext().registerService(URLStreamHandlerService.class, new DelegatingURLStreamHandlerService(handler), t);
		}

		this.managedScenes.addListener((ListChangeListener<Scene>) change -> {
			@Nullable
			Theme currentTheme = getCurrentTheme();
			if (currentTheme == null)
				return;
			while (change.next()) {
				for (Scene scene : change.getAddedSubList()) {
					applyThemeToScene(currentTheme, scene);
				}
			}
		});
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
				if (this.themes.containsKey(id)) {
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
		while (change.next()) {
			for (Scene scene : this.managedScenes) {
				for (URL url : change.getRemoved()) {
					scene.getStylesheets().remove(url.toExternalForm());
				}

				for (URL url : change.getAddedSubList()) {
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
			applyThemeToScene(theme, scene);
		}
	}

	private static void applyThemeToScene(Theme theme, Scene scene) {
		for (URL url : theme.getStylesheetURL()) {
			if (scene.getRoot() != null) {
				scene.getRoot().getStyleClass().remove(getCSSClassname(theme.getId()));
				scene.getRoot().getStyleClass().add(getCSSClassname(theme.getId()));
			}
			scene.getStylesheets().add(url.toExternalForm());
		}
	}

	@Override
	public void setCurrentThemeId(String id) {
		if (this.themes.containsKey(id)) {
			if (this.currentThemeId != null && this.themes.containsKey(this.currentThemeId)) {
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
	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policyOption = ReferencePolicyOption.GREEDY)
	public void registerTheme(@NonNull Theme theme) {
		synchronized (this.themes) {
			this.themes.put(theme.getId(), theme);
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