/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services;

public final class Constants {
	public static final String WINDOW_FOCUS_NODE = "efx_WINDOW_FOCUS_NODE";
	public static final String APP_FOCUS_NODE 	 = "efx_APP_FOCUS_NODE";
	
	public static final String ROOT_TOPIC = "org/eclipse/fx";
	public static final String WINDOW_SHOWN = ROOT_TOPIC + "/MWindow/Shown";
	public static final String WINDOW_HIDDEN = ROOT_TOPIC + "/MWindow/Hidden";
	public static final String WINDOW_ACTIVATED = ROOT_TOPIC + "/MWindow/Activated";
	
	public static final String PERSPECTIVE_SHOWN = ROOT_TOPIC + "/MPerspective/Shown";
	public static final String PERSPECTIVE_HIDDEN = ROOT_TOPIC + "/MPerspective/Hidden";
}
