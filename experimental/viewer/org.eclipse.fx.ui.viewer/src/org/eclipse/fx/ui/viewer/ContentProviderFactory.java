/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.viewer;

import java.util.List;

public class ContentProviderFactory {
	public static <O> ContentProvider<List<O>, O> createListContentProvider() {
		return new ContentProvider<List<O>,O>() {
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
	
	public static <O> ContentProvider<O[], O> createArrayContentProvider() {
		return new ContentProvider<O[], O>() {
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
