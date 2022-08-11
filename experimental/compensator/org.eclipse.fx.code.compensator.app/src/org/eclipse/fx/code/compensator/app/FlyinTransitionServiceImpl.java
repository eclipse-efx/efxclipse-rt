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

import org.eclipse.fx.ui.workbench.renderers.fx.services.FlyInTransitionService;
import org.eclipse.fx.ui.workbench.renderers.fx.services.LightweightDialogTransitionService;
import org.osgi.service.component.annotations.Component;

@Component(property={"service.ranking:Integer=1"})
public class FlyinTransitionServiceImpl extends FlyInTransitionService implements LightweightDialogTransitionService {

}
