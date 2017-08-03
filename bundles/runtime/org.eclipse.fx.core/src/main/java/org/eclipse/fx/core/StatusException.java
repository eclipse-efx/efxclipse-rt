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

import java.io.PrintStream;
import java.io.PrintWriter;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Exception transporting an {@link Status} with meta informations
 */
public class StatusException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NonNull
	private final Status status;

	/**
	 * Create a new exception
	 * 
	 * @param status
	 *            the status with meta information
	 */
	public StatusException(@NonNull Status status) {
		this.status = status;
	}
	
	/**
	 * @return the status object
	 */
	public @NonNull Status getStatus() {
		return this.status;
	}

	@Override
	public void printStackTrace(PrintStream s) {
		synchronized (s) {
			super.printStackTrace(s);
			Throwable throwable = this.status.getThrowable();
			if (throwable != null) {
				throwable.printStackTrace(s);
			}
		}
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		synchronized (s) {
			super.printStackTrace(s);
			Throwable throwable = this.status.getThrowable();
			if (throwable != null) {
				throwable.printStackTrace(s);
			}
		}
	}
}
