package sample.splash.app;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.ui.services.restart.RestartService;

public class RestartHandler {
	@Execute
	public void restart(RestartService service) {
		service.restart(false);
	}
}
