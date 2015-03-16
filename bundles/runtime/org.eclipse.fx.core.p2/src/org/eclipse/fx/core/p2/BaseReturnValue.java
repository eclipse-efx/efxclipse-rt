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
package org.eclipse.fx.core.p2;

import org.eclipse.fx.core.ReturnValue;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A default implementation for a return value
 * 
 * @param <V>
 *            the type
 */
public class BaseReturnValue<V> implements ReturnValue<V> {
	/**
	 * The state
	 */
	@NonNull
	public final State state;
	/**
	 * A message in case of a state different than OK or CANCEL
	 */
	@Nullable
	public final String message;
	/**
	 * An exception in case one was the reason for the failure
	 */
	@Nullable
	public final Throwable throwable;
	/**
	 * The value in case of a OK state
	 */
	@Nullable
	public final V value;
	/**
	 * The return code
	 */
	public final int code;

	/**
	 * Create a new return value
	 *
	 * @param state
	 *            the state
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 * @param value
	 *            the value
	 * @param throwable
	 *            the exception
	 */
	public BaseReturnValue(@NonNull State state, int code, @Nullable String message, @Nullable V value, @Nullable Throwable throwable) {
		this.state = state;
		this.message = message;
		this.throwable = throwable;
		this.value = value;
		this.code = code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public Throwable getThrowable() {
		return this.throwable;
	}

	@Override
	public State getState() {
		return this.state;
	}

	@Override
	public V getValue() {
		return this.value;
	}

	@Override
	public int getCode() {
		return this.code;
	}
}
