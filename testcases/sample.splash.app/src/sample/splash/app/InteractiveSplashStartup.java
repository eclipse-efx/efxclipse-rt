package sample.splash.app;

import java.net.URL;
import java.util.concurrent.CountDownLatch;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService;
import org.osgi.framework.Bundle;
import org.osgi.service.component.annotations.Component;

import com.sun.javafx.tk.Toolkit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

@Component(property="service.ranking:Integer=1")
public class InteractiveSplashStartup implements StartupProgressTrackerService {
	private IApplicationContext applicationContext;
	private Stage stage;

	private CountDownLatch hideLatch = new CountDownLatch(1);

	@Override
	public OSGiRV osgiApplicationLaunched(IApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		System.err.println("launched: " + Thread.currentThread());
		return OSGiRV.CONTINUE;
	}

	@Override
	public void stateReached(ProgressState state) {
		if( state == DefaultProgressState.JAVAFX_INITIALIZED ) {
			Bundle bundle = applicationContext.getBrandingBundle();
			URL url = bundle.getResource("splash.bmp");
			if( url != null ) {
				Image img = new Image(url.toExternalForm());
				stage = new Stage(StageStyle.TRANSPARENT);
				stage.setScene(new Scene(new StackPane(new ImageView(img))));
				if( Util.isMacOS() ) {
					double x = Screen.getPrimary().getVisualBounds().getWidth() / 2 - img.getWidth() / 2 - 1;
					double y = 227;
					stage.setX(x);
					stage.setY(y);
					stage.show();
				} else {
					double x = Screen.getPrimary().getBounds().getWidth() / 2 - img.getWidth() / 2 - 1;
					double y = Screen.getPrimary().getBounds().getHeight() / 2 - img.getHeight() / 2;
					stage.setX(x);
					stage.setY(y);

					stage.setOnShown( e -> {
						new Timeline(new KeyFrame(Duration.millis(100), (ev) -> {
							Toolkit.getToolkit().exitNestedEventLoop(this, null);
							hideLatch.countDown();
						})).play();
					});
					stage.show();
					Toolkit.getToolkit().enterNestedEventLoop(this);
				}
			}
		} else if( state == DefaultProgressState.JAVAFX_INITIALIZED_LAUNCHER_THREAD ) {
			if( Util.isMacOS() ) {
				applicationContext.applicationRunning();
			} else {
				try {
					hideLatch.await();
				} catch (InterruptedException e) {
					// nothing to do
				}
				applicationContext.applicationRunning();
			}

		} else if( state == DefaultProgressState.WORKBENCH_GUI_SHOWN ) {
			stage.hide();
		}
	}

}
