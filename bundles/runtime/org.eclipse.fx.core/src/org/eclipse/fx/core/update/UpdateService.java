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
package org.eclipse.fx.core.update;

import java.util.Optional;

import org.eclipse.fx.core.ProgressReporter;
import org.eclipse.fx.core.operation.CancelableOperation;

/**
 * A service to update your application
 */
public interface UpdateService {

	/**
	 * Check your application for updates
	 * 
	 * @param reporter
	 *            reporting progress
	 * 
	 * @return check update operation
	 * 
	 */
	public CancelableOperation<Optional<UpdatePlan>> checkUpdate(ProgressReporter reporter);

	/**
	 * Basic definition for update callback informations
	 */
	interface UpdatePlan {
		/**
		 * Create the update operation
		 * 
		 * @param progressReporter
		 *            the progress reporter
		 * @return the update operation if available
		 */
		public CancelableOperation<UpdateResult> runUpdate(ProgressReporter progressReporter);
	}

	/**
	 * Basic definition for an update data informations
	 */
	interface UpdateResult {
		// no methods needed
	}
}