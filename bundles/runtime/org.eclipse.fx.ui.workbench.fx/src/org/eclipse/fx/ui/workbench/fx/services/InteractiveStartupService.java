package org.eclipse.fx.ui.workbench.fx.services;

import java.net.URL;
import java.util.concurrent.CountDownLatch;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService;
import org.osgi.framework.Bundle;

import com.sun.javafx.tk.Toolkit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public abstract class InteractiveStartupService implements StartupProgressTrackerService {
	private IApplicationContext applicationContext;
	private Stage stage;

	private CountDownLatch hideLatch = new CountDownLatch(1);

	@Override
	public OSGiRV osgiApplicationLaunched(IApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		return OSGiRV.CONTINUE;
	}

	protected abstract Scene createScene(IApplicationContext applicationContext, Image splashImage);

	protected void show() {
		if( Util.isMacOS() ) {
			this.stage.show();
			this.applicationContext.applicationRunning();
		} else {
			this.stage.setOnShown( e -> {
				new Timeline(new KeyFrame(Duration.millis(100), (ev) -> {
					Toolkit.getToolkit().exitNestedEventLoop(this, null);
					this.hideLatch.countDown();
				})).play();
			});
			this.stage.show();
			Toolkit.getToolkit().enterNestedEventLoop(this);
		}
	}

	@Override
	public void stateReached(ProgressState state) {
		if( state == DefaultProgressState.JAVAFX_INITIALIZED ) {
			Bundle bundle = this.applicationContext.getBrandingBundle();
			URL url = bundle.getResource("splash.bmp"); //$NON-NLS-1$
			if( url != null ) {
				Image img = new Image(url.toExternalForm());
				this.stage = new Stage(StageStyle.TRANSPARENT);
				this.stage.setScene(createScene(this.applicationContext, img));
				if( Util.isMacOS() ) {
					double x = Screen.getPrimary().getVisualBounds().getWidth() / 2 - img.getWidth() / 2 - 1;
					double y = 227;
					this.stage.setX(x);
					this.stage.setY(y);
					show();
				} else {
					double x = Screen.getPrimary().getBounds().getWidth() / 2 - img.getWidth() / 2 - 1;
					double y = Screen.getPrimary().getBounds().getHeight() / 2 - img.getHeight() / 2;
					this.stage.setX(x);
					this.stage.setY(y);
					show();
				}
			}
		} else if( state == DefaultProgressState.JAVAFX_INITIALIZED_LAUNCHER_THREAD ) {
			if( ! Util.isMacOS() ) {
				try {
					this.hideLatch.await();
				} catch (InterruptedException e) {
					// nothing to do
				}
				this.applicationContext.applicationRunning();
			}

		} else if( state == DefaultProgressState.WORKBENCH_GUI_SHOWN ) {
			this.stage.hide();
		}
	}

}
