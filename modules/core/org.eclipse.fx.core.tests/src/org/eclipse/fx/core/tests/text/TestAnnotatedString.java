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
package org.eclipse.fx.core.tests.text;

import org.eclipse.fx.core.text.AnnotatedString;
import org.eclipse.fx.core.text.AnnotatedString.Builder;
import org.junit.Assert;
import org.junit.Test;

public class TestAnnotatedString {
	@Test
	public void testAdd_Char() {
		Builder<String> builder = AnnotatedString.create(String.class,10);
		AnnotatedString<String> string = builder
			.add(new char [] { 'H','e','l','l','o' }, "a", "b")
			.add(new char[] { ' ' })
			.add(new char [] { 'W','o','r','l','d', '!' }, "c", "d")
			.build();
		Assert.assertNotNull(string);
		Assert.assertEquals(12, string.length());
		Assert.assertEquals("Hello World!", string.toString());
	}
}
