package org.eclipse.fx.ui.workbench.fx.services;

import java.util.concurrent.CountDownLatch;

import org.eclipse.fx.core.SystemUtils;
import org.eclipse.fx.core.app.ApplicationContext;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService;

public class NativeSplashStartupService implements StartupProgressTrackerService {
	private ApplicationContext applicationContext;
	private CountDownLatch hideLatch = new CountDownLatch(1);

	@Override
	public OSGiRV applicationLaunched(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		return OSGiRV.CONTINUE;
	}

	@Override
	public void stateReached(ProgressState state) {
		if( state == DefaultProgressState.JAVAFX_INITIALIZED_LAUNCHER_THREAD ) {
			if( ! SystemUtils.isMacOS() ) {
				try {
					this.hideLatch.await();
				} catch (InterruptedException e) {
					// nothing to do
				}
				this.applicationContext.applicationRunning();
			}
		} else if( state == DefaultProgressState.WORKBENCH_GUI_SHOWN ) {
			if( ! SystemUtils.isMacOS() ) {
				this.hideLatch.countDown();
			} else {
				this.applicationContext.applicationRunning();
			}
		}
	}

}
