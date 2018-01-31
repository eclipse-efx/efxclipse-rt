/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	 * 
	 * @param name
	 *            the name of the logger
	 * @return the logger instance
	 */
	@NonNull
	public Logger createLogger(@NonNull String name);
}
