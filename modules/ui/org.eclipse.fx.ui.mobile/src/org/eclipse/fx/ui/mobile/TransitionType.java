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
