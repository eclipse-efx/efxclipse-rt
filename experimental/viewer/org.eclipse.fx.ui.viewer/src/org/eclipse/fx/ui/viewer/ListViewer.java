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
import java.util.function.Function;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Base interface of all list viewers
 * 
 * @param <O>
 *            the domain object representing a row
 * @param <I>
 *            the input to the viewer
 * @param <C>
 *            the content provider responsible to translate the input into the
 *            internal structure
 */
public interface ListViewer<O, I, C extends ContentProvider<O, I>> extends Viewer<O, I, C> {
	/**
	 * Translate the domain object into a string
	 * 
	 * @param converter
	 *            the converter
	 * @return the list viewer
	 */
	public ListViewer<O, I, C> textProvider(Function<@NonNull O, @Nullable String> converter);

	/**
	 * Translate the domain object into a style information to style the cell
	 * and its contents e.g. background color
	 * 
	 * @param converter
	 *            the converter
	 * @return the list viewer
	 */
	public ListViewer<O, I, C> styleProvider(Function<@NonNull O, @Nullable String> converter);

	/**
	 * Translate the domain object into a style ranges
	 * 
	 * @param converter
	 *            the converter
	 * @return the list viewer
	 */
	public ListViewer<O, I, C> textStyleRangeProvider(Function<@NonNull O, @NonNull List<@NonNull StyleRange>> converter);

	/**
	 * Translate the domain object into an image definition
	 * 
	 * @param converter
	 *            the converter
	 * @return the list viewer
	 */
	public ListViewer<O, I, C> graphicProvider(Function<@NonNull O, @Nullable String> converter);
}
