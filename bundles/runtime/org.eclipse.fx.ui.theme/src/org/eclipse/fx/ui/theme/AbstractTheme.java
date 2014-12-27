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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.fx.ui.services.theme.Stylesheet;
import org.eclipse.fx.ui.services.theme.Theme;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A basic implementation of a theme
 *
 * @since 1.2
 */
public class AbstractTheme implements Theme {
	private final @NonNull String id;
	private final @NonNull String name;
	private final @NonNull List<@NonNull URL> stylesheetUrlList = new ArrayList<>();

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

	@SuppressWarnings("null")
	@Override
	public @NonNull List<@NonNull URL> getStylesheetURL() {
		return Collections.unmodifiableList(this.stylesheetUrlList);
	}

	/**
	 * Try to register a stylesheet
	 *
	 * @param stylesheet
	 *            the stylesheet
	 */
	public void registerStylesheet(Stylesheet stylesheet) {
		if (stylesheet.appliesToTheme(this)) {
			this.stylesheetUrlList.add(stylesheet.getURL(this));
		}
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
}
