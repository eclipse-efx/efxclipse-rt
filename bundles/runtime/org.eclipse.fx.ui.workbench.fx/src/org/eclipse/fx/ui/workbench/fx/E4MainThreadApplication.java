package org.eclipse.fx.ui.workbench.fx;

import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.databinding.JFXRealm;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService.DefaultProgressState;

import com.sun.javafx.application.PlatformImpl;

/**
 * An E4Application who assumes to be launched at the same thread as the OSGi-Launcher
 */
@SuppressWarnings("restriction")
public class E4MainThreadApplication extends E4Application {
	@Override
	protected void launchE4JavaFxApplication() throws Exception {
		PlatformImpl.startup(() -> {
			JFXRealm.createDefault();
			if (Util.isMacOS()) {
				updateStartupState(DefaultProgressState.JAVAFX_INITIALIZED_LAUNCHER_THREAD);
			}

			jfxStart(getApplicationContext(), null, null);
		});
	}
}
