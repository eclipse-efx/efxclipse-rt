/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.mobile;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import javafx.scene.layout.Region;

/**
 * Basic entry point for applications
 */
public abstract class MobileApp {
	/**
	 * @return the initial stylesheets
	 */
	@SuppressWarnings({ "null", "static-method" })
	public @NonNull List<@NonNull String> getInitialStylesheets() {
		return Collections.emptyList();
	}

	/**
	 * Create the main UI
	 * 
	 * @return the root region
	 */
	public abstract Region createUI();
}
