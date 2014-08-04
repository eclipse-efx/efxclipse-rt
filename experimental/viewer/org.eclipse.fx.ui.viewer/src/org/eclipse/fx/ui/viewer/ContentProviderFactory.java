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

import java.util.List;

public class ContentProviderFactory {
	public static <O> ContentProvider<O, List<O>> createListContentProvider() {
		return new ContentProvider<O, List<O>>() {
			private List<O> input;
			
			@Override
			public void setInput(List<O> input) {
				this.input = input;
			}
			
			@Override
			public int getSize() {
				return input.size();
			}
			
			@Override
			public O getRootElement(int index) {
				return input.get(index);
			}
		};
	}
	
	public static <O> ContentProvider<O, O[]> createArrayContentProvider() {
		return new ContentProvider<O, O[]>() {
			private O[] input;
			
			@Override
			public void setInput(O[] input) {
				this.input = input;
			}

			@Override
			public O getRootElement(int index) {
				return input[index];
			}

			@Override
			public int getSize() {
				return input.length;
			}

		};
	}
}
