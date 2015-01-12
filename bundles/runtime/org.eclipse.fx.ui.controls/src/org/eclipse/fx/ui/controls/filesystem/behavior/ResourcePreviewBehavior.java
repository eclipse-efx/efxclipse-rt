/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.filesystem.behavior;

import java.util.Collections;

import org.eclipse.fx.ui.controls.filesystem.ResourcePreview;

import com.sun.javafx.scene.control.behavior.BehaviorBase;

/**
 * Behavior for {@link ResourcePreview}
 *
 * @since 1.2
 */
@SuppressWarnings("restriction")
public class ResourcePreviewBehavior extends BehaviorBase<ResourcePreview> {
	/**
	 * Create new behavior
	 *
	 * @param control
	 *            the control
	 */
	public ResourcePreviewBehavior(ResourcePreview control) {
		super(control, Collections.emptyList());
	}
}
