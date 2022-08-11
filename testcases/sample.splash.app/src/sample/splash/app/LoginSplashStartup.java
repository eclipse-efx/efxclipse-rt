/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package sample.splash.app;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.ui.services.startup.StartupProgressTrackerService;
import org.eclipse.fx.ui.workbench.fx.services.InteractiveStartupService;
import org.eclipse.fx.ui.workbench.fx.services.NativeSplashStartupService;
import org.osgi.service.component.annotations.Component;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

@Component(property="service.ranking:Integer=1")
public class LoginSplashStartup extends NativeSplashStartupService implements StartupProgressTrackerService {

//	@Override
//	protected Scene createScene(IApplicationContext applicationContext, Image splashImage) {
//		return new Scene(new StackPane(new ImageView(splashImage)));
//	}
//
//	@Override
//	protected void hide(Stage stage) {
//		Timeline t = new Timeline(new KeyFrame(Duration.millis(10_000), (a) -> {
//			super.hide(stage);
//		}));
//		t.play();
//	}
}
