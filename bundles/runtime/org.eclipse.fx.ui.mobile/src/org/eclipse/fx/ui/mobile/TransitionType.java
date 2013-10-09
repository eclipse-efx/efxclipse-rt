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

public enum TransitionType {
	NONE(null),
	SLIDE_LEFT(TransitionDelegate.slideLeft()),
	SLIDE_RIGHT(TransitionDelegate.slideRight());
	
	private final TransitionDelegate delegate;
	
	private TransitionType(TransitionDelegate delegate) {
		this.delegate = delegate;
	}
	
	public TransitionDelegate getDelegate() {
		return delegate;
	}
}
