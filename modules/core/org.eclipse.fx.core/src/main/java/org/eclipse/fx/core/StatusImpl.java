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
package org.eclipse.fx.core;

import java.util.Optional;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Basic status implementation
 *
 */
class StatusImpl implements Status {
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
	 * The return code
	 */
	public final int code;

	/**
	 * Ok status
	 */
	@NonNull
	public static final Status OK = new StatusImpl(State.OK,-1,"<ok>",null); //$NON-NLS-1$

	/**
	 * Create a new return value
	 *
	 * @param state
	 *            the state
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 * @param throwable
	 *            the exception
	 */
	public StatusImpl(@NonNull State state, int code, @Nullable String message, @Nullable Throwable throwable) {
		this.state = state;
		this.message = message;
		this.throwable = throwable;
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
	public int getCode() {
		return this.code;
	}

	@Override
	public Optional<State> state() {
		return Optional.of(this.state);
	}

	@Override
	public String toString() {
		return "StatusImpl [state=" + this.state + ", message=" + this.message + ", throwable=" + this.throwable + ", code=" + this.code  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ "]"; //$NON-NLS-1$
	}


}