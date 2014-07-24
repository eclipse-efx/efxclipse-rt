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

import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Base interface of all viewers
 * 
 * @param <O>
 *            the domain object representing a row
 * @param <I>
 *            the input to the viewer
 * @param <C>
 *            the content provider responsible to translate the input into the
 *            internal structure
 */
public interface Viewer<O, I, C extends ContentProvider<O, I>> {
	public void setContentProvider(@NonNull Supplier<@NonNull C> contentProvider);

	public void setInput(@NonNull Supplier<@NonNull I> input);
}
