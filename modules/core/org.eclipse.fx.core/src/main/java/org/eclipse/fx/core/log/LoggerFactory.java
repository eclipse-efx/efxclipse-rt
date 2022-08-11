/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
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
package org.eclipse.fx.core.log;

import org.eclipse.fx.core.RankedService;
import org.eclipse.jdt.annotation.NonNull;

/**
 * A factory service to create a logger instance
 */
public interface LoggerFactory extends RankedService {
	/**
	 * Create an instance of a logger
	 * @param name the name of the logger
	 * @return the logger instance
	 */
	@NonNull
	public Logger createLogger(@NonNull String name);
}
