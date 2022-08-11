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
package org.eclipse.fx.demo.osgi;

import static java.lang.Math.random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.osgi.util.AbstractJFXApplication;

/**
 * This class controls all aspects of the application's execution
 */
public class Application extends AbstractJFXApplication {

	@Override
	protected void jfxStart(IApplicationContext context, javafx.application.Application jfxApplication, Stage primaryStage) {
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600, Color.BLACK);
		primaryStage.setScene(scene);

		Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
				new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE,
						new Stop[] { new Stop(0, Color.web("#f8bd55")),
								new Stop(0.14, Color.web("#c0fe56")),
								new Stop(0.28, Color.web("#5dfbc1")),
								new Stop(0.43, Color.web("#64c2f8")),
								new Stop(0.57, Color.web("#be4af7")),
								new Stop(0.71, Color.web("#ed5fc2")),
								new Stop(0.85, Color.web("#ef504c")),
								new Stop(1, Color.web("#f2660f")), }));

		Group circles = new Group();
		for (int i = 0; i < 30; i++) {
			Circle circle = new Circle(150, Color.web("white", 0.05));
			circle.setStrokeType(StrokeType.OUTSIDE);
			circle.setStroke(Color.web("white", 0.16));
			circle.setStrokeWidth(4);
			circles.getChildren().add(circle);
		}
		circles.setEffect(new BoxBlur(10, 10, 3));

		Group blendModeGroup = new Group(new Group(new Rectangle(
				scene.getWidth(), scene.getHeight(), Color.BLACK), circles),
				colors);
		colors.setBlendMode(BlendMode.OVERLAY);
		root.getChildren().add(blendModeGroup);

		Timeline timeline = new Timeline();
		for (Node circle : circles.getChildren()) {
			timeline.getKeyFrames().addAll(
					new KeyFrame(Duration.ZERO, // set start position at 0
							new KeyValue(circle.translateXProperty(),
									random() * 800),
							new KeyValue(circle.translateYProperty(),
									random() * 600)),
					new KeyFrame(new Duration(40000), // set end position at 40s
							new KeyValue(circle.translateXProperty(),
									random() * 800), new KeyValue(circle
									.translateYProperty(), random() * 600)));
		}
		// play 40s of animation
		timeline.play(); 
		
		primaryStage.setTitle("Hello OSGi World"); 
		primaryStage.show(); 
	}	
}