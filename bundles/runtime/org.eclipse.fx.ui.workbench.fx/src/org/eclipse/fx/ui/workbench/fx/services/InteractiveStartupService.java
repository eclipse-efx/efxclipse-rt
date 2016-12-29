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
package org.eclipse.fx.ui.workbench.fx.services;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;

import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.app.ApplicationContext;
import org.eclipse.fx.core.app.ApplicationContext.Splash;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService;

import com.sun.javafx.tk.Toolkit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * Base class to implement a service to implement an interactive startup experience
 */
public abstract class InteractiveStartupService implements StartupProgressTrackerService {
	private ApplicationContext applicationContext;
	private Stage stage;

	private CountDownLatch hideLatch = new CountDownLatch(1);

	@Override
	public OSGiRV applicationLaunched(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		return OSGiRV.CONTINUE;
	}

	protected abstract Scene createScene(ApplicationContext applicationContext, Image splashImage);

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
			Optional<Splash> splash = this.applicationContext.getSplashImage();
			if( splash.isPresent() ) {
				Image img = new Image(splash.get().getUrl().toExternalForm());
				this.stage = new Stage(StageStyle.TRANSPARENT);
				this.stage.setScene(createScene(this.applicationContext, img));
				Point2D location = splash.get().getLocation();
				this.stage.setX(location.getX());
				this.stage.setY(location.getY());
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
