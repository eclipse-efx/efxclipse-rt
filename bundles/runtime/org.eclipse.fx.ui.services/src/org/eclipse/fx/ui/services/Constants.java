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

import org.eclipse.jdt.annotation.NonNull;

/**
 * Various constants
 */
public final class Constants {
	/**
	 * Context key with the windows focus node
	 */
	@NonNull
	public static final String WINDOW_FOCUS_NODE = "efx_WINDOW_FOCUS_NODE"; //$NON-NLS-1$
	/**
	 * Context key with the applications focus node
	 */
	@NonNull
	public static final String APP_FOCUS_NODE 	 = "efx_APP_FOCUS_NODE"; //$NON-NLS-1$
	
	/**
	 * Context key with the timer value used for tool item check
	 */
	@NonNull
	public static final String TOOLITEM_TIMER = "efx_TOOLITEM_TIMER"; //$NON-NLS-1$
	
	/**
	 * Root topic for fx specific events
	 */
	@NonNull
	public static final String ROOT_TOPIC = "org/eclipse/fx"; //$NON-NLS-1$
	/**
	 * Event sent when a window is fully shown
	 */
	@NonNull
	public static final String WINDOW_SHOWN = ROOT_TOPIC + "/MWindow/Shown"; //$NON-NLS-1$
	/**
	 * Event sent when a window is fully hidden
	 */
	@NonNull
	public static final String WINDOW_HIDDEN = ROOT_TOPIC + "/MWindow/Hidden"; //$NON-NLS-1$
	/**
	 * Event sent when a window is activated 
	 */
	@NonNull
	public static final String WINDOW_ACTIVATED = ROOT_TOPIC + "/MWindow/Activated"; //$NON-NLS-1$
	/**
	 * Event sent when a perspective is fully shown
	 */
	@NonNull
	public static final String PERSPECTIVE_SHOWN = ROOT_TOPIC + "/MPerspective/Shown"; //$NON-NLS-1$
	/**
	 * Event sent when a perspective is fully hidden
	 */
	@NonNull
	public static final String PERSPECTIVE_HIDDEN = ROOT_TOPIC + "/MPerspective/Hidden"; //$NON-NLS-1$
	/**
	 * Event sent when the application has been launched
	 */
	@NonNull
	public static final String APPLICATION_LAUNCHED = ROOT_TOPIC + "/E4Application/Launched"; //$NON-NLS-1$
	
}
