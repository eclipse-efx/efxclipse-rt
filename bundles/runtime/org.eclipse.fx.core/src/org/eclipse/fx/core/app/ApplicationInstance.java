/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.app;

import java.util.concurrent.CompletableFuture;

/**
 * A running instance of the application
 *
 * @since 3.0
 */
public interface ApplicationInstance {
	/**
	 * Launches the application
	 *
	 * @param context
	 *            the application context
	 * @return future who is completed once the application is launched
	 */
	public CompletableFuture<ExitStatus> launch(ApplicationContext context);

	/**
	 * Stop the application
	 *
	 * @param status
	 *            the exit status
	 */
	public void stop(ExitStatus status);
}
