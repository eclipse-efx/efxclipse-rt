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
package org.eclipse.fx.ui.controls.test;


import org.eclipse.fx.ui.controls.JavaFXCompatUtil;
import org.junit.Assert;
import org.junit.Test;

import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

public class JavaFXCompatUtilTest {
	@Test
	public void getAllWindows() {
		Assert.assertNotNull(JavaFXCompatUtil.getAllWindows());
	}

	@Test
	public void getCode() {
		Assert.assertEquals(0x41,JavaFXCompatUtil.getCode(KeyCode.A));
	}

	@Test
	public void getChar() {
		Assert.assertEquals("A",JavaFXCompatUtil.getChar(KeyCode.A));
	}

	@Test
	public void reapplyCSS() {
		JavaFXCompatUtil.reapplyCSS(new Rectangle());
	}
}
