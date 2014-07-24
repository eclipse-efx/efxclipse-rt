/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.viewer;

import java.util.Arrays;
import java.util.List;

public class ContentProviderFactory {
	public static <O> ContentProvider<O, List<O>> createListContentProvider() {
		return new ContentProvider<O, List<O>>() {
			@Override
			public List<O> getRootElements(List<O> input) {
				return input;
			}
		};
	}
	
	public static <O> ContentProvider<O, O[]> createArrayContentProvider() {
		return new ContentProvider<O, O[]>() {

			@Override
			public List<O> getRootElements(O[] input) {
				return Arrays.asList(input);
			}
		};
	}
}
