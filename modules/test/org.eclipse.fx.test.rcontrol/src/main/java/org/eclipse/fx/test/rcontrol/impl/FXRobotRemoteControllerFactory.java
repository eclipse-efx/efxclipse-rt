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
package org.eclipse.fx.test.rcontrol.impl;

import org.eclipse.fx.test.rcontrol.RController;
import org.eclipse.fx.test.rcontrol.RControllerFactory;
import org.osgi.service.component.annotations.Component;

import javafx.scene.Scene;

@SuppressWarnings("javadoc")
@Component(xmlns = "http://www.osgi.org/xmlns/scr/v1.2.0")
public class FXRobotRemoteControllerFactory implements RControllerFactory {

	@Override
	public RController create(Scene s) {
		return new FXRobotRemoteController(s);
	}
}