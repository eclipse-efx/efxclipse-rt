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

import org.eclipse.fx.core.app.ApplicationContext;
import org.eclipse.fx.core.app.ApplicationInstance;

/**
 * Service to track startup progress eg to update the splash screen
 */
public interface StartupProgressTrackerService {
	/**
	 * Return value of
	 * {@link StartupProgressTrackerService#applicationLaunched(ApplicationContext)}
	 */
	public enum OSGiRV {
		/**
		 * Continue with the start process
		 */
		CONTINUE,
		/**
		 * End the statt process and restart
		 */
		RESTART,
		/**
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
		 * The JavaFX subsystem has been initialized so custom stages can be
		 * shown.
		 * <p>
		 * This state is guaranteed to be reached on JavaFX event thread
		 * </p>
		 */
		JAVAFX_INITIALIZED,
		/**
		 * The JavaFX subsystem has been initialized so custom stages can be
		 * shown.
		 * <p>
		 * This state is guaranteed to be reached on launcher thread
		 * </p>
		 * <p>
		 * <strong>This state is only reach if you are launching on the if you are launching the E4MainThreadApplication</strong>
		 * </p>
		 */
		JAVAFX_INITIALIZED_LAUNCHER_THREAD,
		/**
		 * The DI-System is started (in case the implementation has @Inject
		 * annotated fields and methods the have been filled now with values)
		 * <p>
		 * This state is guaranteed to be reached on JavaFX event thread
		 * </p>
		 */
		DI_SYSTEM_INITIALIZED,
		/**
		 * The lifecycle @PostContextCreate has been finished
		 * <p>
		 * This state is guaranteed to be reached on JavaFX event thread
		 * </p>
		 */
		POST_CONTEXT_LF_FINISHED,
		/**
		 * The workbench UI is showing
		 * <p>
		 * This method is guaranteed to be called on JavaFX event thread
		 * </p>
		 */
		WORKBENCH_GUI_SHOWING,
		/**
		 * The workbench UI is shown
		 * <p>
		 * This method is guaranteed to be called on JavaFX event thread
		 * </p>
		 */
		WORKBENCH_GUI_SHOWN,
		/**
		 * State reached when check for workspace could not be locked
		 * <p>
		 * This state is guaranteed to be reached on JavaFX event thread
		 * </p>
		 */
		LOCATION_CHECK_FAILED
	}

	/**
	 * Invoked when the OSGi-Framework has been launched. This method is
	 * guaranteed to be called on the thread
	 * {@link ApplicationInstance#launch(ApplicationContext)} has been invoked
	 *
	 * @param applicationContext
	 *            the application context
	 * @return information how to proceed
	 */
	public OSGiRV applicationLaunched(ApplicationContext applicationContext);

	/**
	 * Method called when a certain state has been reached
	 *
	 * @param state
	 *            the state reached
	 */
	public void stateReached(ProgressState state);
}
