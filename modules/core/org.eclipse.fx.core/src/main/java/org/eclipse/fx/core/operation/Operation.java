/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.operation;

import java.util.function.Consumer;

import org.eclipse.fx.core.StatusException;
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
	 * @return the operation
	 */
	public Operation<T> onComplete(@NonNull Consumer<@Nullable T> consumer);

	/**
	 * Called when the operation completes with an exception
	 * 
	 * @param consumer
	 *            the consumer invoked
	 * @return the operation
	 */
	public Operation<T> onException(@NonNull Consumer<@NonNull StatusException> consumer);
}
