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
package org.eclipse.fx.testcases.e4.parts;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.PersistState;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;

public class Test_PersistState {
	int lastState = 0;
	@PostConstruct
	void init(MPart part, BorderPane p) {
		String s = part.getPersistedState().get("persistedStatedTest");
		if( s != null ) {
			lastState = Integer.parseInt(s);
		}
		p.setCenter(new Label(lastState + ""));
	}

	@PersistState
	void persistState(MPart part) {
		part.getPersistedState().put("persistedStatedTest",(lastState+1)+"");
	}
}
