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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javafx.beans.InvalidationListener;
import javafx.scene.Scene;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.fx.ui.services.theme.ThemeManager;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.Bundle;
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

	static class ThemeImpl implements Theme {
		private static int THEME_COUNT = 0;
		
		private final @NonNull IConfigurationElement element;
		private final @NonNull List<@NonNull IConfigurationElement> stylesheetElements = new ArrayList<>();
		private final @NonNull List<@NonNull URL> resolvedUrls = new ArrayList<>();

		public ThemeImpl(@NonNull IConfigurationElement element) {
			this.element = element;
		}

		void addStylesheet(@NonNull IConfigurationElement stylesheet) {
			this.resolvedUrls.clear();
			this.stylesheetElements.add(stylesheet);
		}

		@Override
		public String getId() {
			String attribute = this.element.getAttribute(ATT_ID);
			if(attribute == null) {
				getLogger().error("The theme has to have an ID"); //$NON-NLS-1$
				attribute = UUID.randomUUID().toString() + ""; //$NON-NLS-1$
			}
			return attribute;
		}

		@Override
		public String getName() {
			String attribute = this.element.getAttribute(ATT_NAME);
			if( attribute == null ) {
				getLogger().warning("The theme should have a name"); //$NON-NLS-1$
				attribute = "Automatic theme " + THEME_COUNT++; //$NON-NLS-1$
			}
			return attribute;
		}

		@Override
		public List<@NonNull URL> getStylesheetURL() {
			if (this.resolvedUrls.isEmpty()) {
				URL url = getUrl(this.element, ATT_BASETYLESHEET);

				if (url != null) {
					this.resolvedUrls.add(url);
				} else {
					getLogger().error("Unable to load base stylesheet '"+this.element.getAttribute(ATT_BASETYLESHEET)+"'"); //$NON-NLS-1$ //$NON-NLS-2$
				}

				for (IConfigurationElement e : this.stylesheetElements) {
					url = getUrl(e, ATT_RESOURCE);
					if (url != null) {
						this.resolvedUrls.add(url);
					} else {
						getLogger().error("Unable to load stylesheet '"+e.getAttribute(ATT_RESOURCE)+"'"); //$NON-NLS-1$ //$NON-NLS-2$
					}
				}

			}
			return this.resolvedUrls;
		}

		private static URL getUrl(IConfigurationElement e, String attributeName) {
			String resource = e.getAttribute(attributeName);
			String contributer = e.getDeclaringExtension().getContributor().getName();
			
			if( resource.startsWith("platform:") ) { //$NON-NLS-1$
				try {
					return FileLocator.find(new URL(resource));
				} catch (MalformedURLException e1) {
					getLogger().error("Unable to find css stylesheet file "+resource+"", e1); //$NON-NLS-1$ //$NON-NLS-2$
				}
				return null;
			} else {
				Bundle b = Platform.getBundle(contributer);
				return b.getResource(resource);
			}
		}
	}

	private final @NonNull List<@NonNull Theme> themes = new ArrayList<>();
	private String currentThemeId;
	List<Scene> managedScenes = new ArrayList<Scene>();

	/**
	 * Create a new theme manager instance
	 */
	public DefaultThemeManager() {
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		for (IConfigurationElement e : registry.getConfigurationElementsFor("org.eclipse.fx.ui.theme")) { //$NON-NLS-1$
			if (e.getName().equals("theme")) { //$NON-NLS-1$
				this.themes.add(new ThemeImpl(e));
			}
		}

		for (IConfigurationElement e : registry.getConfigurationElementsFor("org.eclipse.fx.ui.theme")) { //$NON-NLS-1$
			if (e.getName().equals("stylesheet")) { //$NON-NLS-1$
				String themeId = e.getAttribute(ATT_THEME_ID);
				for (Theme t : this.themes) {
					if (t.getId().equals(themeId) || themeId == null || themeId.isEmpty()) {
						((ThemeImpl)t).addStylesheet(e);
					}
				}
			}
		}

	}

	@Override
	public Theme getCurrentTheme() {
		if( this.themes.isEmpty() ) {
			return null;
		} else if (this.themes.size() == 1) {
			return this.themes.get(0);
		} else {
			String id = getCurrentThemeId();
			if (id != null) {
				for (Theme t : this.themes) {
					if (t.getId().equals(id)) {
						return t;
					}
				}
			}

			this.themes.get(0);
		}

		return null;
	}

	@Override
	public List<@NonNull Theme> getAvailableThemes() {
		return this.themes;
	}
	
	@SuppressWarnings("null")
	private static @NonNull String getCSSClassname(@NonNull String id) {
		return id.replace('.', '-');
	}

	@Override
	public void setCurrentThemeId(String id) {
		for (Theme t : this.themes) {
			if (t.getId().equals(id)) {
				this.currentThemeId = id;
				EventAdmin eventAdmin = getEventAdmin();
				if( eventAdmin !=  null ) {
					eventAdmin.sendEvent(new Event(Constants.THEME_CHANGED, Collections.singletonMap("org.eclipse.e4.data", id)));	 //$NON-NLS-1$
				}
				
				for( Scene scene : this.managedScenes ) {
					List<Theme> availableThemes = getAvailableThemes();
					for (Theme theme : availableThemes) {
						for (URL url : theme.getStylesheetURL()) {
							if( scene.getRoot() != null ) {
								scene.getRoot().getStyleClass().remove(getCSSClassname(theme.getId()));	
							}
							scene.getStylesheets().remove(url.toExternalForm());
						}
					}
					for (Theme theme : availableThemes) {
						for (URL url : theme.getStylesheetURL()) {
							if (theme.getId().equals(this.currentThemeId)) {
								if( scene.getRoot() != null ) {
									scene.getRoot().getStyleClass().remove(getCSSClassname(theme.getId()));
									scene.getRoot().getStyleClass().add(getCSSClassname(theme.getId()));
								}
								scene.getStylesheets().add(url.toExternalForm());
							}
						}
					}
				}
				
				return;
			}
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
		if( logger == null ) {
			ServiceReference<LoggerFactory> ref = Activator.getContext().getServiceReference(LoggerFactory.class);
			logger = Activator.getContext().getService(ref).createLogger(DefaultThemeManager.class.getName());
			LOGGER = logger;
		}
		return LOGGER;
	}
	
	private EventAdmin eventAdmin;
	
	@Nullable EventAdmin getEventAdmin() {
		EventAdmin eventAdmin = this.eventAdmin;
		if( eventAdmin != null ) {
			return eventAdmin;
		}
		
		ServiceReference<EventAdmin> ref = Activator.getContext().getServiceReference(EventAdmin.class);
		if( ref != null ) {
			eventAdmin = Activator.getContext().getService(ref);	
		}
		
		return eventAdmin;
	}
	
	@Override
	public Registration registerScene(final Scene scene) {
		this.managedScenes.add(scene);
		InvalidationListener l = (o) -> {
			String themeId = this.currentThemeId;
			if( scene.getRoot() != null && themeId != null ) {
				scene.getRoot().getStyleClass().remove(getCSSClassname(themeId));
				scene.getRoot().getStyleClass().add(getCSSClassname(themeId));
			}
		};
		String themeId = this.currentThemeId;
		if( themeId != null ) {
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
}
