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
 * Abstract operation who can be canceled
 * 
 * @param <T>
 *            the type produced when completed successfully
 * @since 2.0
 */
public interface CancelableOperation<T> extends Operation<T> {
	/**
	 * Called when the operation completes successfully
	 * 
	 * @param consumer
	 *            consumer invoked
	 * @return the operation
	 */
	@Override
	public CancelableOperation<T> onComplete(@NonNull Consumer<@Nullable T> consumer);

	/**
	 * Called when the operation completes with an exception
	 * 
	 * @param consumer
	 *            the consumer invoked
	 * @return the operation
	 */
	@Override
	public CancelableOperation<T> onException(@NonNull Consumer<@NonNull StatusException> consumer);
	
	/**
	 * Called when the operation is canceled
	 * 
	 * @param consumer
	 *            the consumer
	 * @return the operation
	 */
	public CancelableOperation<T> onCancel(@NonNull Runnable consumer);
	
	/**
	 * Cancel the running operation
	 */
	public void cancel();
}
