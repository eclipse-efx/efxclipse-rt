package sample.splash.app;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService;
import org.osgi.service.component.annotations.Component;

import javafx.application.Platform;

@Component(property="service.ranking:Integer=1")
public class InteractiveSplashStartup implements StartupProgressTrackerService {
	private IApplicationContext applicationContext;

	@Override
	public OSGiRV osgiApplicationLaunched(IApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		System.err.println("launched: " + Thread.currentThread());
		return OSGiRV.CONTINUE;
	}

	@Override
	public void stateReached(ProgressState state) {
		if( state == DefaultProgressState.JAVAFX_INITIALIZED ) {
//			Platform.setImplicitExit(false);
			System.err.println("JavaFX initialized on FX-Thread");
		} else if( state == DefaultProgressState.JAVAFX_INITIALIZED_LAUNCHER_THREAD ) {
			System.err.println("JavaFX initialized on Launcher Thread");
			applicationContext.applicationRunning();
		}
	}

}
