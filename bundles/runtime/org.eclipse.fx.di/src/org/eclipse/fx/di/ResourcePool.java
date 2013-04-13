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
package org.eclipse.fx.di;

import javafx.scene.image.Image;

import org.eclipse.core.runtime.CoreException;

public interface ResourcePool {
	public Image getImage(String imageKey) throws CoreException;
	public Image getImageUnchecked(String imageKey);
}