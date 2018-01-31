/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Service to handle exception
 * 
 * @since 3.1.0
 */
public interface ExceptionHandler {
	/**
	 * Exception information
	 * 
	 * @noimplement
	 */
	public interface ExceptionData {
		// /**
		// * @return the thread the exception happened on
		// */
		// public Thread thread();

		/**
		 * @return the source class
		 */
		public @NonNull String sourceClass();

		/**
		 * @return the exception
		 */
		public @NonNull Throwable throwable();
	}

	/**
	 * Handle the exception
	 * 
	 * @param data
	 *            information about the exception
	 * 
	 */
	public void handleException(ExceptionData data);
}
