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
package org.eclipse.fx.testcases.dnd.app.jemmy;

import org.jemmy.fx.SceneDock;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleTestCase {
	protected static SceneDock scene;
	
	@BeforeClass
	public static void startApp() throws InterruptedException {
		try {
			scene = new SceneDock();
		} catch(Throwable t ) {
			t.printStackTrace();
		}
	}
	
	@Test
	public void sampleTestMethod() {
		Assert.fail("Not implemented");
	}
}
