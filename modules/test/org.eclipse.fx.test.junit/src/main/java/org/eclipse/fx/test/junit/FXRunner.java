/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
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
package org.eclipse.fx.test.junit;

import org.eclipse.fx.test.junit.internal.ApplicationLaunch;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * Specialized runner who bootstrap JavaFX and runs the test methods on the
 * FX-Thread
 */
public class FXRunner extends BlockJUnit4ClassRunner {

	public FXRunner(Class<?> klass) throws InitializationError {
		super(klass);
		ApplicationLaunch.bootstrap();
	}

	@Override
	protected Statement methodBlock(FrameworkMethod method) {
		Statement statement = super.methodBlock(method);
		return new FXTestStatement(statement);
	}
}