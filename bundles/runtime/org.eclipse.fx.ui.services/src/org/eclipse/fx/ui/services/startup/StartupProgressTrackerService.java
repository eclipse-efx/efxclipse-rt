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
package org.eclipse.fx.ui.services.startup;

import org.eclipse.equinox.app.IApplicationContext;

/**
 * Service to track startup progress eg to update the splash screen
 */
public interface StartupProgressTrackerService {
	/**
	 * Return value of
	 * {@link StartupProgressTrackerService#osgiApplicationLaunched(IApplicationContext)}
	 */
	public enum OSGiRV {
		/**
		 * Continue with the start process
		 */
		CONTINUE, /**
					 * End the statt process and restart
					 */
		RESTART, /**
					 * End the start process and shutdown
					 */
		EXIT
	}

	/**
	 * Basic interface implemented by the progress state. For a default set of
	 * states see {@link DefaultProgressState}
	 */
	public interface ProgressState {
		// empty by design
	}

	/**
	 * A set of predefined states
	 */
	public enum DefaultProgressState implements ProgressState {
		/**
		 * The JavaFX subsystem has been initialized so
		 * custom stages can be shown
		 */
		JAVAFX_INITIALIZED,
		/**
		 * The DI-System is started (in case the implementation has @Inject
		 * annotated fields and methods the have been filled now with values)
		 */
		DI_SYSTEM_INITIALIZED,
		 /**
							 * The lifecycle @PostContextCreate has been
							 * finished
							 */
		POST_CONTEXT_LF_FINISHED, /**
									 * The workbench UI is shown
									 */
		WORKBENCH_GUI_SHOWING
	}

	/**
	 * Invoked when the OSGi-Framework has been launched
	 * 
	 * @param applicationContext
	 *            the application context
	 * @return information how to proceed
	 */
	public OSGiRV osgiApplicationLaunched(IApplicationContext applicationContext);

	/**
	 * Method called when a certain state has been reached
	 * 
	 * @param state
	 *            the state reached
	 */
	public void stateReached(ProgressState state);
}
