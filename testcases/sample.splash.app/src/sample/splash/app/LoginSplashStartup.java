package sample.splash.app;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService;
import org.eclipse.fx.ui.workbench.fx.services.InteractiveStartupService;
import org.osgi.service.component.annotations.Component;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

@Component(property="service.ranking:Integer=1")
public class LoginSplashStartup extends InteractiveStartupService implements StartupProgressTrackerService {

	@Override
	protected Scene createScene(IApplicationContext applicationContext, Image splashImage) {
		return new Scene(new StackPane(new ImageView(splashImage)));
	}

}
