/*******************************************************************************
 * Copyright (c) 2019 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.test.rcontrol;

import javafx.scene.Scene;

/**
 * Factory to create a {@link RController}
 */
public interface RControllerFactory {
	/**
	 * Create a controller for the scene
	 * 
	 * @param s
	 *            the scene
	 * @return self
	 */
	public RController create(Scene s);
}
