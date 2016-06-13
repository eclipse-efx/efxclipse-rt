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
package org.eclipse.fx.ui.workbench.fx;

import java.util.concurrent.CountDownLatch;

import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.databinding.JFXRealm;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService.DefaultProgressState;

import com.sun.javafx.application.PlatformImpl;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * An E4Application who assumes to be launched at the same thread as the
 * OSGi-Launcher
 */
@SuppressWarnings("restriction")
public class E4MainThreadApplication extends E4Application {
	static CountDownLatch STARTUP_LATCH = new CountDownLatch(1);
	static CountDownLatch SHUTDOWN_LATCH = new CountDownLatch(1);

	void super_launchE4JavaFxApplication() throws Exception {
		super.launchE4JavaFxApplication();
	}

	@Override
	protected void launchE4JavaFxApplication() throws Exception {
		if (Util.isMacOS()) {
			PlatformImpl.addListener(new PlatformImpl.FinishListener() {

				@Override
				public void idle(boolean implicitExit) {
					jfxStop();
					PlatformImpl.removeListener(this);
				}

				@Override
				public void exitCalled() {
					// nothing to do
				}
			});

			PlatformImpl.startup(() -> {
				JFXRealm.createDefault();
				jfxStart(getApplicationContext(), null, null);
				updateStartupState(DefaultProgressState.JAVAFX_INITIALIZED_LAUNCHER_THREAD);
			});
		} else {
			Thread t = new Thread() {
				@Override
				public void run() {
					try {
						super_launchE4JavaFxApplication();
					} catch (Exception e) {
						SHUTDOWN_LATCH.countDown();
						e.printStackTrace();
					}
				}
			};
			t.start();

			STARTUP_LATCH.await();
			updateStartupState(DefaultProgressState.JAVAFX_INITIALIZED_LAUNCHER_THREAD);
			SHUTDOWN_LATCH.await();
		}
	}

	@Override
	protected Class<? extends Application> getJfxApplicationClass() {
		return ExtendedE4Application.class;
	}

	/**
	 * Extended application used on none OS-X system to appropriately handle
	 * lifecycle semantics
	 */
	public static class ExtendedE4Application extends DefaultJFXApp {
		@Override
		public void start(Stage primaryStage) throws Exception {
			STARTUP_LATCH.countDown();
			super.start(primaryStage);
		}

		@Override
		public void stop() throws Exception {
			super.stop();
			SHUTDOWN_LATCH.countDown();
		}
	}
}
