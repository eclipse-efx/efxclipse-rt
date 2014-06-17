/*******************************************************************************
 * Copyright (c) 2014 EM-SOFTWARE and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.sync;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Extended UISynchronize Class
 */
public interface UISynchronize {

	/**
	 * Sync with the ui thread und provide a result when done
	 * 
	 * @param callable
	 *            the callable to execute
	 * @param defaultValue
	 *            a default value to return
	 * @return the result of callable.call()
	 */
	<V> V syncExec(final Callable<V> callable, V defaultValue);
	
	/**
	 * Executes the runnable on the UI-Thread and blocks until the runnable is finished
	 * 
	 * @param runnable
	 *            the runnable to execute
	 */
	void syncExec(Runnable runnable);
	
	/**
	 * Schedules the runnable on the UI-Thread for execution and returns immediately
	 * 
	 * @param callable
	 *            the callable to execute
	 * @return interface to the result of the callable
	 */
	<V> Future<V> asyncExec(final Callable<V> callable);

	/**
	 * Schedules the runnable on the UI-Thread for execution and returns immediately
	 * 
	 * @param runnable
	 *            the runnable to execute
	 */
	void asyncExec(Runnable runnable);

}
