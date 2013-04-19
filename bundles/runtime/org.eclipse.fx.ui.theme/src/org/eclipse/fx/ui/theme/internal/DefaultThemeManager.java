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
import java.util.List;

import javafx.scene.Scene;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.fx.ui.services.theme.ThemeManager;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;


public class DefaultThemeManager implements ThemeManager {
	static final String ATT_ID = "id";
	static final String ATT_NAME = "name";
	static final String ATT_THEME_ID = "themeId";
	static final String ATT_BASETYLESHEET = "basestylesheet";
	static final String ATT_RESOURCE = "resource";

	static class ThemeImpl implements Theme {
		private final IConfigurationElement element;
		private final List<IConfigurationElement> stylesheetElements = new ArrayList<IConfigurationElement>();
		private final List<URL> resolvedUrls = new ArrayList<URL>();

		public ThemeImpl(IConfigurationElement element) {
			this.element = element;
		}

		void addStylesheet(IConfigurationElement stylesheet) {
			this.resolvedUrls.clear();
			this.stylesheetElements.add(stylesheet);
		}

		@Override
		public String getId() {
			return this.element.getAttribute(ATT_ID);
		}

		@Override
		public String getName() {
			return this.element.getAttribute(ATT_NAME);
		}

		@Override
		public List<URL> getStylesheetURL() {
			if (resolvedUrls.isEmpty()) {
				URL url = getUrl(element, ATT_BASETYLESHEET);

				if (url != null) {
					resolvedUrls.add(url);
				} else {
					getLogger().error("Unable to load base stylesheet '"+element.getAttribute(ATT_BASETYLESHEET)+"'");
				}

				for (IConfigurationElement e : stylesheetElements) {
					url = getUrl(e, ATT_RESOURCE);
					if (url != null) {
						resolvedUrls.add(url);
					} else {
						getLogger().error("Unable to load stylesheet '"+e.getAttribute(ATT_RESOURCE)+"'");
					}
				}

			}
			return resolvedUrls;
		}

		private URL getUrl(IConfigurationElement e, String attributeName) {
			String resource = e.getAttribute(attributeName);
			String contributer = e.getDeclaringExtension().getContributor().getName();
			
			if( resource.startsWith("platform:") ) {
				try {
					return FileLocator.find(new URL(resource));
				} catch (MalformedURLException e1) {
					getLogger().error("Unable to find css stylesheet file "+resource+"", e1);
				}
				return null;
			} else {
				Bundle b = Platform.getBundle(contributer);
				return b.getResource(resource);
			}
		}
	}

	private final List<Theme> themes = new ArrayList<Theme>();
	private String currentThemeId;
	private List<Scene> managedScenes = new ArrayList<Scene>();

	public DefaultThemeManager() {
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		for (IConfigurationElement e : registry.getConfigurationElementsFor("org.eclipse.fx.ui.theme")) {
			if (e.getName().equals("theme")) {
				themes.add(new ThemeImpl(e));
			}
		}

		for (IConfigurationElement e : registry.getConfigurationElementsFor("org.eclipse.fx.ui.theme")) {
			if (e.getName().equals("stylesheet")) {
				String themeId = e.getAttribute(ATT_THEME_ID);
				for (Theme t : themes) {
					if (t.getId().equals(themeId)) {
						((ThemeImpl)t).addStylesheet(e);
					}
				}
			}
		}

	}

	@Override
	public Theme getCurrentTheme() {
		if (themes.size() == 1) {
			return themes.get(0);
		} else {
			String id = getCurrentThemeId();
			if (id != null) {
				for (Theme t : themes) {
					if (t.getId().equals(id)) {
						return t;
					}
				}
			}

			themes.get(0);
		}

		return null;
	}

	@Override
	public List<Theme> getAvailableThemes() {
		return themes;
	}

	@Override
	public void setCurrentThemeId(String id) {
		for (Theme t : themes) {
			if (t.getId().equals(id)) {
				currentThemeId = id;
				
				for( Scene scene : managedScenes ) {
					List<Theme> availableThemes = getAvailableThemes();
					for (Theme theme : availableThemes) {
						for (URL url : theme.getStylesheetURL()) {
							scene.getStylesheets().remove(url.toExternalForm());
						}
					}
					for (Theme theme : availableThemes) {
						for (URL url : theme.getStylesheetURL()) {
							if (theme.getId().equals(currentThemeId)) {
								scene.getStylesheets().add(url.toExternalForm());
							}
						}
					}
					
					if( Util.isFX2() ) {
						try {
							ReflectiveInvoke.onStyleManagerClass(scene);
						} catch (Exception e) {
							getLogger().error("Unable to reload styles", e);
						}
					}
				}
				
				return;
			}
		}
		throw new IllegalArgumentException("Theme with id '" + id + "' is not known.");
	}

	private String getCurrentThemeId() {
		return currentThemeId;
	}
	
	private static Logger LOGGER;
	
	static Logger getLogger() {
		if( LOGGER == null ) {
			ServiceReference<LoggerFactory> ref = Activator.getContext().getServiceReference(LoggerFactory.class);
			LOGGER = Activator.getContext().getService(ref).createLogger(DefaultThemeManager.class.getName());
		}
		return LOGGER;
	}
	
	@Override
	public Registration registerScene(final Scene scene) {
		managedScenes.add(scene);
		return new Registration() {
			
			@Override
			public void dispose() {
				managedScenes.remove(scene);
			}
		};
	}
}
