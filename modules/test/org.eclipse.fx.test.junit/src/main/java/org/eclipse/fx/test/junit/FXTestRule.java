/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.test.junit;

import org.eclipse.fx.test.junit.internal.ApplicationLaunch;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Rule to make sure test statements are run on the JavaFX Thread
 */
public class FXTestRule implements TestRule {

	@Override
	public Statement apply(Statement base, Description description) {
		Statement result = base;
		FXTest annotation = description.getAnnotation(FXTest.class);
		if (annotation != null) {
			ApplicationLaunch.bootstrap();
			result = new FXTestStatement(base);
		}
		return result;
	}
}