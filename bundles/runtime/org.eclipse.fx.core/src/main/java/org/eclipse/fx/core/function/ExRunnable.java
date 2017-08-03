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
package org.eclipse.fx.core.function;

/**
 * Simple operation to execute
 *
 * @since 1.2
 */
@FunctionalInterface
public interface ExRunnable {
	/**
	 * Called to execute the operation
	 *
	 * @throws Throwable
	 *             exception if something goes wrong
	 */
	public void wrappedRun() throws Throwable;
}
