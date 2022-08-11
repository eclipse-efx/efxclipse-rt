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
package org.eclipse.fx.testcases.fxgraph.shape;

import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class Cube extends Group {
	final Rotate rx = new Rotate(45,Rotate.X_AXIS);
    final Rotate ry = new Rotate(45,Rotate.Y_AXIS);
    final Rotate rz = new Rotate(45,Rotate.Z_AXIS);
    
    final SimpleObjectProperty<Color> color = new SimpleObjectProperty<Color>(this, "color");
    final SimpleDoubleProperty size = new SimpleDoubleProperty(this, "size");
    final SimpleDoubleProperty shade = new SimpleDoubleProperty(this,"shade");
    
    public Color getColor() {
    	return color.get();
    }
    
    public double getSize() {
    	return size.get();
    }
    
    public double getShade() {
    	return shade.get();
    }
    
    public Cube(double paramSize, Color paramColor, double paramShade) {
        getTransforms().addAll(rz, ry, rx);
        
        this.size.set(paramSize);
        this.color.set(paramColor);
        this.shade.set(1);
        
        {
            Rectangle r = new Rectangle();
            r.widthProperty().bind(this.size);
            r.heightProperty().bind(this.size);
            r.fillProperty().bind(
            		DeriveColorBinding.create(
            				color, 
            				new ReadOnlyDoubleWrapper(0.0),
            				new ReadOnlyDoubleWrapper(1.0),
            				new ReadOnlyDoubleWrapper(1).subtract(shade.multiply(0.5)),
            				new ReadOnlyDoubleWrapper(1.0)));
            r.translateXProperty().bind(size.multiply(-0.5));
            r.translateYProperty().bind(size.multiply(-0.5));
            r.translateZProperty().bind(size.multiply(0.5));
            
            getChildren().add(r);
        }
        
        {
            Rectangle r = new Rectangle();
            r.widthProperty().bind(this.size);
            r.heightProperty().bind(this.size);
            r.fillProperty().bind(
            		DeriveColorBinding.create(
            				color, 
            				new ReadOnlyDoubleWrapper(0.0),
            				new ReadOnlyDoubleWrapper(1.0),
            				new ReadOnlyDoubleWrapper(1).subtract(shade.multiply(0.4)),
            				new ReadOnlyDoubleWrapper(1.0)));
            r.translateXProperty().bind(size.multiply(-0.5));
            r.setTranslateY(0);
            r.setRotationAxis(Rotate.X_AXIS);
            r.setRotate(90);
            
            getChildren().add(r);
        }
        
        {
            Rectangle r = new Rectangle();
            r.widthProperty().bind(this.size);
            r.heightProperty().bind(this.size);
            r.fillProperty().bind(
            		DeriveColorBinding.create(
            				color, 
            				new ReadOnlyDoubleWrapper(0.0),
            				new ReadOnlyDoubleWrapper(1.0),
            				new ReadOnlyDoubleWrapper(1).subtract(shade.multiply(0.3)),
            				new ReadOnlyDoubleWrapper(1.0)));
            r.translateXProperty().bind(size.multiply(-1));
            r.translateYProperty().bind(size.multiply(-0.5));
            r.setRotationAxis(Rotate.Y_AXIS);
            r.setRotate(90);
            
            getChildren().add(r);
        }
        
        {
            Rectangle r = new Rectangle();
            r.widthProperty().bind(this.size);
            r.heightProperty().bind(this.size);
            r.fillProperty().bind(
            		DeriveColorBinding.create(
            				color, 
            				new ReadOnlyDoubleWrapper(0.0),
            				new ReadOnlyDoubleWrapper(1.0),
            				new ReadOnlyDoubleWrapper(1).subtract(shade.multiply(0.2)),
            				new ReadOnlyDoubleWrapper(1.0)));
            r.setTranslateX(0);
            r.translateYProperty().bind(size.multiply(-0.5));
            r.setRotationAxis(Rotate.Y_AXIS);
            r.setRotate(90);
            
            getChildren().add(r);
        }
        
        {
            Rectangle r = new Rectangle();
            r.widthProperty().bind(this.size);
            r.heightProperty().bind(this.size);
            r.fillProperty().bind(
            		DeriveColorBinding.create(
            				color, 
            				new ReadOnlyDoubleWrapper(0.0),
            				new ReadOnlyDoubleWrapper(1.0),
            				new ReadOnlyDoubleWrapper(1).subtract(shade.multiply(0.1)),
            				new ReadOnlyDoubleWrapper(1.0)));
            r.translateXProperty().bind(size.multiply(-0.5));
            r.translateYProperty().bind(size.multiply(-1));
            r.setRotationAxis(Rotate.X_AXIS);
            r.setRotate(90);
            
            getChildren().add(r);
        }
        
        {
            Rectangle r = new Rectangle();
            r.widthProperty().bind(this.size);
            r.heightProperty().bind(this.size);
            r.fillProperty().bind(color);
            r.translateXProperty().bind(size.multiply(-0.5));
            r.translateYProperty().bind(size.multiply(-0.5));
            r.translateZProperty().bind(size.multiply(-0.5));
            r.setRotate(90);
            
            getChildren().add(r);
        }
    }
}
