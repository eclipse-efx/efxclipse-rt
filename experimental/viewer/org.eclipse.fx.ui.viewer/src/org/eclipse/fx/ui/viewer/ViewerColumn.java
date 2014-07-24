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
import java.util.function.BiFunction;
import java.util.function.Function;

public interface ViewerColumn<O,T> {
	public ViewerColumn<O, T> setLabel(String label);
	public ViewerColumn<O,T> styleProvider(BiFunction<O, T, String> converter);
	public ViewerColumn<O,T> textProvider(BiFunction<O, T, String> converter);
	public ViewerColumn<O,T> textProvider(Function<T, String> converter);
	public ViewerColumn<O,T> textStyleRangeProvider(BiFunction<O, T, List<StyleRange>> converter);
	public ViewerColumn<O,T> graphicProvider(BiFunction<O, T, String> converter);
}
