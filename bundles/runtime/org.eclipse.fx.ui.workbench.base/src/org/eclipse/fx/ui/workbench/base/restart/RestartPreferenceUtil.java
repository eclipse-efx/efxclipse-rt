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
package org.eclipse.fx.ui.workbench.base.restart;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Extended service for internal purposes
 */
@SuppressWarnings("restriction")
@Creatable
public class RestartPreferenceUtil {

	static final String CLEAR_STATE_AFTER_RESTART = "CLEAR_STATE_AFTER_RESTART"; //$NON-NLS-1$

	@Inject
	@Preference
	private IEclipsePreferences node;

	@Inject
	@Optional
	@Preference(value = CLEAR_STATE_AFTER_RESTART)
	private boolean clearPersistedStateAfterRestart;

	@Inject
	@Log
	Logger logger;

	/**
	 * Set the CLEAR_STATE_AFTER_RESTART Flag in the Preferences
	 * 
	 * @param value
	 *            Value to set as Preference
	 */
	public void setClearPersistedStateOnRestart(boolean value) {
		this.node.putBoolean(CLEAR_STATE_AFTER_RESTART, value);
		// Preferences speichern
		try {
			this.node.flush();
		} catch (BackingStoreException e) {
			this.logger.error("Error while writing preferences", e); //$NON-NLS-1$
		}
	}

	/**
	 * @return Should the Persisted State be cleared?
	 */
	public boolean isClearPersistedStateOnRestart() {
		return this.clearPersistedStateAfterRestart;
	}
}
