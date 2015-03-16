/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.operation;

import java.util.function.Consumer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Abstract operation who is running async and informs about its state
 * 
 * @param <T>
 *            the value produced by the operation
 * @since 2.0
 */
public interface Operation<T> {
	/**
	 * Called when the operation completes successfully
	 * 
	 * @param consumer
	 *            consumer invoked
	 */
	public void onComplete(@NonNull Consumer<@Nullable T> consumer);

	/**
	 * Called when the operation completes with an exception
	 * 
	 * @param consumer
	 *            the consumer invoked
	 */
	public void onException(@NonNull Consumer<@NonNull Throwable> consumer);
}
