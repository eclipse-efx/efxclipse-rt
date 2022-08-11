/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.ui;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;

public interface IFeature {

	/** installs the feature into the control.
	 * <p>
	 * by disposing the returned subscription, the feature gets uninstalled
	 * </p>
	 *
	 * @param control
	 * @return
	 */
	public Subscription install(StyledTextArea control);


}
