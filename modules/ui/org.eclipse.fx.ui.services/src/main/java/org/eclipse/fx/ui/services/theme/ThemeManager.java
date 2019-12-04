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
package org.eclipse.fx.ui.services.theme;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.Scene;

/**
 * Manager of themes
 */
public interface ThemeManager {
	/**
	 * @return the current theme
	 */
	@Nullable
	public Theme getCurrentTheme();

	/**
	 * @return available themes
	 * @since 2.0
	 */
	@NonNull
	public ObservableMap<@NonNull String, @NonNull Theme> getAvailableThemes();

	/**
	 * Set the current theme id
	 * 
	 * @param id
	 *            the id of the theme
	 * @throws IllegalArgumentException
	 *             if the theme is not known
	 */
	public void setCurrentThemeId(@NonNull String id) throws IllegalArgumentException;

	/**
	 * Register a scene
	 * 
	 * @param scene
	 *            the scene
	 * @return the registration
	 */
	@NonNull
	public Registration registerScene(@NonNull Scene scene);

	/**
	 * Get a list of all managed Scenes
	 * 
	 * @return unmodifiable ObservableList of all managed Scenes
	 */
	@NonNull
	default ObservableList<@NonNull Scene> getManagedScenes() {
		throw new UnsupportedOperationException("getManagedScenes is not implemented"); //$NON-NLS-1$
	}
	
	/**
	 * Registration
	 */
	public interface Registration {
		/**
		 * A registration
		 */
		public void dispose();
	}
}
