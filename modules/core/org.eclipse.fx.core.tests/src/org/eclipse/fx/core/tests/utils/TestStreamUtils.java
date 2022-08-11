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
package org.eclipse.fx.core.tests.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.fx.core.StreamUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestStreamUtils {
	@Test
	public void test_replaceTabBySpace() {
		List<String> list = Arrays.asList("1", "2", "3"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		List<String> reversed = StreamUtils.reverse(list).collect(Collectors.toList());
		Assert.assertEquals(Arrays.asList("3", "2", "1"), reversed);
	}
}
