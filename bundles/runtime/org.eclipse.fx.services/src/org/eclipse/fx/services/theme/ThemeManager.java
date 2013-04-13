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
package org.eclipse.fx.services.theme;

import java.util.List;

import javafx.scene.Scene;

public interface ThemeManager {
	public Theme getCurrentTheme();

	public List<Theme> getAvailableThemes();

	public void setCurrentThemeId(String id) throws IllegalArgumentException;

	public Registration registerScene(Scene scene);
	
	public interface Registration {
		public void dispose();
	}
}
