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
package org.eclipse.fx.ui.workbench.renderers.base.services;

import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;

@SuppressWarnings("restriction")
public interface PerspectiveTransitionService<P,C> {
	public AnimationDelegate<P,C> getDelegate(MPerspective fromPerspective, MPerspective toPerspective);
	
	public interface AnimationDelegate<P,C> {
		public void animate(P container,C control);
	}
}
