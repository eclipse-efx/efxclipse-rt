/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.theme;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;

import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.ui.services.theme.MultiURLStylesheet;
import org.eclipse.fx.ui.services.theme.Stylesheet;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * A basic implementation of a theme
 *
 * @since 1.2
 */
public abstract class AbstractTheme implements Theme {
	private final @NonNull String id;
	private final @NonNull String name;
	@SuppressWarnings("null")
	private final @NonNull ObservableList<@NonNull URL> stylesheetUrlList = FXCollections.observableArrayList();
	@SuppressWarnings("null")
	private final @NonNull ObservableList<@NonNull URL> unmodifiableStylesheetUrlList = FXCollections.unmodifiableObservableList(this.stylesheetUrlList);
	@Nullable
	private static Logger LOGGER;
	
	/**
	 * Create a theme
	 *
	 * @param id
	 *            the id of the theme
	 * @param name
	 *            the name of the theme as displayed to the user
	 * @param baseStylesheetUrl
	 *            URL of the base stylesheet
	 */
	public AbstractTheme(@NonNull String id, @NonNull String name, @NonNull URL baseStylesheetUrl) {
		this.id = id;
		this.name = name;
		this.stylesheetUrlList.add(baseStylesheetUrl);
	}

	@Override
	public @NonNull String getId() {
		return this.id;
	}

	@Override
	public @NonNull String getName() {
		return this.name;
	}

	@Override
	public @NonNull ObservableList<@NonNull URL> getStylesheetURL() {
		return this.unmodifiableStylesheetUrlList;
	}

	/**
	 * Try to register a stylesheet
	 *
	 * @param stylesheet
	 *            the stylesheet
	 */
	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC)
	public void registerStylesheet(Stylesheet stylesheet) {
		if (stylesheet.appliesToTheme(this)) {
			URL url = stylesheet.getURL(this);
			if( url != null ) {
				this.stylesheetUrlList.add(url);
			} else {
				getLogger().error("Stylesheet '"+stylesheet+"' tried to restrict null as a stylesheet URI");  //$NON-NLS-1$//$NON-NLS-2$
			}
		}
	}
	
	private static Logger getLogger() {
		if( LOGGER == null ) {
			LOGGER = LoggerCreator.createLogger(AbstractTheme.class);
		}
		return LOGGER;
	}

	/**
	 * Try to unregister a stylesheet
	 *
	 * @param stylesheet
	 *            the stylesheet
	 */
	public void unregisterStylesheet(Stylesheet stylesheet) {
		if (stylesheet.appliesToTheme(this)) {
			this.stylesheetUrlList.remove(stylesheet.getURL(this));
		}
	}
	
	private Map<@NonNull MultiURLStylesheet, @NonNull ObservableList<@NonNull URL>> urlMap = new HashMap<>();
	
	/**
	 * Try to register a stylesheet
	 *
	 * @param stylesheet
	 *            the stylesheet
	 */
	@Reference(cardinality=ReferenceCardinality.MULTIPLE,policy=ReferencePolicy.DYNAMIC)
	public void registerMultiURLStylesheet(MultiURLStylesheet stylesheet) {
		if (stylesheet.appliesToTheme(this)) {
			ObservableList<@NonNull URL> url = stylesheet.getURL(this);
			url.addListener(this::handleChange);
			this.urlMap.put(stylesheet, url);
			this.stylesheetUrlList.addAll(url);
		}
	}

	/**
	 * Try to unregister a stylesheet
	 *
	 * @param stylesheet
	 *            the stylesheet
	 */
	public void unregisterMultiURLStylesheet(MultiURLStylesheet stylesheet) {
		if (stylesheet.appliesToTheme(this)) {
			if( this.urlMap.containsKey(stylesheet) ) {
				ObservableList<@NonNull URL> remove = this.urlMap.remove(stylesheet);
				remove.removeListener(this::handleChange);
				this.stylesheetUrlList.remove(remove);
			}
		}
	}
	
	private void handleChange(Change<@NonNull ? extends URL> change) {
		while( change.next() ) {
			this.stylesheetUrlList.removeAll(change.getRemoved());
			this.stylesheetUrlList.addAll(change.getAddedSubList());
		}
	}
}
