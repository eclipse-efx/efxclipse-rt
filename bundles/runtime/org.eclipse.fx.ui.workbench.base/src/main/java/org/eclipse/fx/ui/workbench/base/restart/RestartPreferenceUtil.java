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

import java.util.function.Consumer;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.preferences.Preference;

/**
 * Extended service for internal purposes
 */
@Creatable
public class RestartPreferenceUtil {

	static final String CLEAR_STATE_AFTER_RESTART = "CLEAR_STATE_AFTER_RESTART"; //$NON-NLS-1$

	@Inject
	@Preference(key=CLEAR_STATE_AFTER_RESTART)
	private Consumer<Boolean> preferenceValue;

	@Inject
	@Optional
	@Preference(key = CLEAR_STATE_AFTER_RESTART)
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
		this.preferenceValue.accept(Boolean.valueOf(value));
	}

	/**
	 * @return Should the Persisted State be cleared?
	 */
	public boolean isClearPersistedStateOnRestart() {
		return this.clearPersistedStateAfterRestart;
	}
}
