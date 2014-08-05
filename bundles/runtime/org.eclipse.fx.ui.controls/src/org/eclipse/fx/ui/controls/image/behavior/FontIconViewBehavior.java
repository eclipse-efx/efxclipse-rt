/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks <ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image.behavior;

import java.util.List;

import org.eclipse.fx.ui.controls.image.FontIconView;
import org.eclipse.jdt.annotation.NonNull;

import com.sun.javafx.scene.control.behavior.BehaviorBase;
import com.sun.javafx.scene.control.behavior.KeyBinding;

/**
 * Behavior for the {@link FontIconView}
 */
@SuppressWarnings("restriction")
public class FontIconViewBehavior extends BehaviorBase<FontIconView> {

	/**
	 * Create a behavior
	 * 
	 * @param control
	 *            the control
	 * @param keyBindings
	 *            the key bindings
	 */
	public FontIconViewBehavior(@NonNull FontIconView control, @NonNull List<@NonNull KeyBinding> keyBindings) {
		super(control, keyBindings);
	}

}
