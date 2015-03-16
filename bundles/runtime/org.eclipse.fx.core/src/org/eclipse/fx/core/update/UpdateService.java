/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.update;

import org.eclipse.fx.core.Callback;
import org.eclipse.fx.core.ReturnValue;

/**
 * A service to update your application
 */
public interface UpdateService {
	/**
	 * Update the application
	 * 
	 * @param data
	 *            the update data from the update check
	 * @param callback
	 *            call back to invoke when the update is done
	 */
	public void update(UpdateCheckData data, Callback<UpdateData> callback);

	/**
	 * Check your application for updates
	 * 
	 * @param callback
	 *            the callback when the check is finished
	 */
	public void checkUpdate(Callback<UpdateCheckData> callback);

	
	/**
	 * Basic definition for update callback informations
	 */
	interface UpdateCheckData extends ReturnValue<Boolean> {
		public boolean nothingToUpdate();
	}
	
	/**
	 * Basic definition for an update data informations
	 */
	interface UpdateData extends ReturnValue<Boolean> {
		// no methods needed
	}
}