/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.tests.utils;

import org.eclipse.fx.core.SystemUtils;
import org.junit.Assert;
import org.junit.Test;


public class TestSystemUtils {
	@Test
	public void testGetMajorFXVersion() {
		System.getProperties().put("javafx.version", "2");
		Assert.assertEquals(2,SystemUtils.getMajorFXVersion());
		
		System.getProperties().put("javafx.version", "11.0.0");
		Assert.assertEquals(11,SystemUtils.getMajorFXVersion());
		
		System.getProperties().put("javafx.version", "11-ea");
		Assert.assertEquals(11,SystemUtils.getMajorFXVersion());
	}
}
