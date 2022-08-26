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

import org.eclipse.fx.ui.mobile.animations.TransitionDelegate;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Transition type
 */
public enum TransitionType {
	/**
	 * No transition
	 */
	NONE(null),
	/**
	 * slide to the left
	 */
	SLIDE_LEFT(TransitionDelegate.slideLeft()),
	/**
	 * slide to the right
	 */
	SLIDE_RIGHT(TransitionDelegate.slideRight()),
	/**
	 * fade
	 */
	FADE(TransitionDelegate.fade()),
	/**
	 * zoom slide
	 */
	ZOOM_SLIDE(TransitionDelegate.zoomSlide());
	
	@Nullable
	private final TransitionDelegate delegate;
	
	private TransitionType(@Nullable TransitionDelegate delegate) {
		this.delegate = delegate;
	}
	
	/**
	 * @return the delegate
	 */
	public @Nullable TransitionDelegate getDelegate() {
		return this.delegate;
	}
}
