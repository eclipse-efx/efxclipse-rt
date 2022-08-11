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
package org.eclipse.fx.ui.controls.styledtext_ng.internal;

import org.eclipse.fx.ui.controls.styledtext_ng.StyledLineRenderer;
import org.eclipse.fx.ui.controls.styledtext_ng.StyledLineRendererFactory;

public class SingleTextStyledLineRendererFactory implements StyledLineRendererFactory {

	@Override
	public StyledLineRenderer createRenderer() {
		return new SingleTextStyledLineRenderer();
	}

}
