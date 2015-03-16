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

import org.eclipse.jdt.annotation.NonNull;

/**
 * Abstract operation who can be canceled
 * 
 * @param <T>
 *            the type produced when completed successfully
 * @since 2.0
 */
public interface CancelableOperation<T> extends Operation<T> {
	/**
	 * Called when the operation is canceled
	 * 
	 * @param consumer
	 *            the consumer
	 */
	public void onCancel(@NonNull Runnable consumer);
	
	/**
	 * Cancel the running operation
	 */
	public void cancel();
}
