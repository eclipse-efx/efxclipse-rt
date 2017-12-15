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
package org.eclipse.fx.core;

import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Represents eg. of an operation
 *
 * @since 2.0
 */
public interface Status {
	/**
	 * default code when unknown
	 */
	public static final int UNKNOWN_RETURN_CODE = -1;

	/**
	 * @return the state
	 */
	@NonNull
	public State getState();

	/**
	 * @return the message in case of none OK or CANCEL
	 */
	@Nullable
	public String getMessage();

	/**
	 * @return the exception causing the failure if one
	 */
	@Nullable
	public Throwable getThrowable();

	/**
	 * @return return value specific (error/success) code or
	 *         {@link #UNKNOWN_RETURN_CODE}
	 */
	public int getCode();

	/**
	 * @return the state
	 */
	public Optional<State> state();

	/**
	 * @return <code>true</code> if {@link #getState()} equals {@link State#OK}
	 * @since 3.0.0
	 */
	public default boolean isOk() {
		return getState() == State.OK;
	}

	/**
	 * Filter of the status is one of those states
	 *
	 * @param states
	 *            the states
	 * @return a none-empty {@link Optional} if one of the states matches
	 *         {@link #getState()}
	 */
	public default Optional<Status> filter(State... states) {
		return is(states) ? Optional.of(this) : Optional.empty();
	}

	/**
	 * Check if status is one of these states
	 *
	 * @param states
	 *            the states
	 * @return <code>true</code> if one of the states matches {@link #getState()}
	 */
	public default boolean is(State... states) {
		return Stream.of(states).anyMatch(s -> s == getState());
	}

	/**
	 * @return a status representing {@link State#OK}
	 */
	@NonNull
	public static Status ok() {
		return StatusImpl.OK;
	}

	/**
	 * Create a new value status with {@link State#OK}
	 * 
	 * @param <O>
	 *            the value type
	 * @param value
	 *            the value
	 * @return a status
	 * @since 3.0
	 */
	@NonNull
	public static <@Nullable O> ValueStatus<O> ok(O value) {
		return status(value, State.OK, 0, "", null); //$NON-NLS-1$
	}

	/**
	 * Create a new status object
	 *
	 * @param state
	 *            the state
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 * @param t
	 *            the throwable
	 * @return the new status instance
	 */
	@NonNull
	public static Status status(@NonNull State state, int code, @NonNull String message, @Nullable Throwable t) {
		return new StatusImpl(state, code, message, t);
	}

	/**
	 * Create a new status object
	 * 
	 * @param <O>
	 *            the value type
	 * @param value
	 *            the value
	 *
	 * @param state
	 *            the state
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 * @param t
	 *            the throwable
	 * @return the new status instance
	 */
	@NonNull
	public static <@Nullable O> ValueStatus<O> status(@Nullable O value, @NonNull State state, int code,
			@NonNull String message, @Nullable Throwable t) {
		return new ValueStatusImpl<O>(value, state, code, message, t);
	}

	/**
	 * A status with an attached value
	 *
	 * @param <O>
	 *            the value to be passed with the status
	 * @since 2.3.0
	 */
	public interface ValueStatus<O> extends Status {
		/**
		 * @return the value, might be <code>null</code> in case of an error
		 */
		public O getValue();
	}

	/**
	 * State of the method a callback
	 */
	public enum State {
		/**
		 * Action ended in error
		 */
		ERROR,
		/**
		 * Action ended with a warning
		 */
		WARNING,
		/**
		 * Action was canceled
		 */
		CANCEL,
		/**
		 * Action succeeded
		 */
		OK
	}
}
