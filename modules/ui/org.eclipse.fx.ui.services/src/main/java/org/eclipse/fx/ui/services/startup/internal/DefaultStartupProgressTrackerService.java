/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
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
package org.eclipse.fx.ui.services.startup.internal;

import org.eclipse.fx.core.app.ApplicationContext;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService;
import org.osgi.service.component.annotations.Component;

/**
 * Default implementation of the progress
 */
@Component
public class DefaultStartupProgressTrackerService implements StartupProgressTrackerService {

	@Override
	public OSGiRV applicationLaunched(ApplicationContext applicationContext) {
		applicationContext.applicationRunning();
		return StartupProgressTrackerService.OSGiRV.CONTINUE;
	}


	@Override
	public void stateReached(ProgressState state) {
		// do nothing
	}
}