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
	 * @return a status representing {@link State#OK}
	 */
	public static Status ok() {
		return StatusImpl.OK;
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
	public static Status status(@NonNull State state, int code, @NonNull String message, @Nullable Throwable t) {
		return new StatusImpl(state, code, message, t);
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
