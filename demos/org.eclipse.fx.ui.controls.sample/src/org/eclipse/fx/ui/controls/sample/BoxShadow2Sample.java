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
package org.eclipse.fx.ui.controls.sample;

import org.eclipse.fx.ui.controls.effects.BoxShadow2;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class BoxShadow2Sample extends Application {

    GridPane root;
    
    private Node renderHandle(DoubleProperty prop) {
        GridPane g = new GridPane();
        Label l = new Label(prop.getName());
        TextField f = new TextField();
        f.textProperty().bind(prop.asString());
        Slider s = new Slider(-50, 50, prop.get());
        s.setMajorTickUnit(1.0);
        s.setMinorTickCount(2);
        prop.bind(s.valueProperty());
        g.add(l, 0, 0);
        g.add(s, 1, 0);
        g.add(f, 2, 0);
        return g;
    }
    
    
    VBox s;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
    	
    	
        root = new GridPane();
        Scale scale = new Scale(4, 4);  
        scale.setPivotX(0);  
        scale.setPivotY(0);  
        root.getTransforms().add(scale);
        
        
        root.setHgap(20);
        
        root.add(new Label("box-shadow"), 0, 0);;
        BorderPane left = new BorderPane();
        left.setPadding(new Insets(20));
        left.setMinSize(200, 200);
        left.setMaxSize(200, 200);
        left.setPrefSize(200, 200);
        GridPane.setConstraints(left, 0, 1);
        root.getChildren().add(left);
        left.setStyle("-fx-border-color: red; -fx-border-width:0.5px");
        
        root.add(new Label("setEffect(new DropShadow())"), 1, 0);;
        BorderPane right = new BorderPane();
        right.setPadding(new Insets(20));
        right.setMinSize(200, 200);
        right.setMaxSize(200, 200);
        right.setPrefSize(200, 200);
        GridPane.setConstraints(right, 1, 1);
        root.getChildren().add(right);
        right.setStyle("-fx-border-color: red; -fx-border-width:0.5px");
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        
        BoxShadow2 boxShadow = new BoxShadow2();
        
        Region content = new Region();
        content.setStyle("-fx-background-color: lightgray;");
        boxShadow.setContent(content);
        
        left.setCenter(boxShadow);
        s = new VBox();
        s.getChildren().add(renderHandle(boxShadow.offsetXProperty()));
        s.getChildren().add(renderHandle(boxShadow.offsetYProperty()));
        s.getChildren().add(renderHandle(boxShadow.spreadProperty()));
        s.getChildren().add(renderHandle(boxShadow.blurProperty()));
        
        root.add(s, 0, 2, 2, 1);
        
        {
	        Region c = new Region();
	        DropShadow s = new DropShadow();
	        c.setEffect(s);
	        s.setBlurType(BlurType.GAUSSIAN);
	        s.offsetXProperty().bind(boxShadow.offsetXProperty());
	        s.offsetYProperty().bind(boxShadow.offsetYProperty());
	        s.spreadProperty().bind(boxShadow.spreadProperty());
	        s.radiusProperty().bind(boxShadow.blurProperty());
	        
	        c.setStyle("-fx-background-color: lightgray");
	        right.setCenter(c);
        }
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
