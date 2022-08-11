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
package org.eclipse.fx.code.compensator.app;

import org.eclipse.fx.ui.workbench.renderers.fx.services.FadeDialogTranstionService;
import org.eclipse.fx.ui.workbench.renderers.fx.services.LightweightDialogTransitionService;
import org.osgi.service.component.annotations.Component;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;

@Component
public class FadeDialogTranstionServiceImpl extends FadeDialogTranstionService implements LightweightDialogTransitionService {
	@Override
	protected void configureFadeIn(FadeTransition transition) {
		super.configureFadeIn(transition);
		transition.setInterpolator(Interpolator.EASE_OUT);
	}
	
	@Override
	protected void configureFadeOut(FadeTransition transition) {
		super.configureFadeOut(transition);
		transition.setInterpolator(Interpolator.EASE_OUT);
	}
}
