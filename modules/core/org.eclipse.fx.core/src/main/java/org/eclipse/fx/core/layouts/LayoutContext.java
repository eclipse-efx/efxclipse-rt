/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.layouts;

import javafx.geometry.Bounds;

/**
 * The context for the layout calculation
 * 
 * @since 3.5.0
 */
public interface LayoutContext {
	/**
	 * @return the bounds in which the layout takes place
	 */
	public Bounds getBounds();
}
