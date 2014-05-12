/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.markers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

import com.sun.javafx.css.converters.PaintConverter;

public class PositionMarker extends Group {
	public PositionMarker() {
		setMouseTransparent(true);
		getStyleClass().add("position-marker");
		Circle outer = new Circle(8);
		outer.setFill(Color.WHITE);
		
		getChildren().add(outer);
		
		{
			Line l = new Line();
			l.setStartX(0);
			l.setStartY(6);
			l.setEndX(0);
			l.setEndY(40);
			l.setStrokeWidth(7);
			l.setStrokeLineCap(StrokeLineCap.ROUND);
			l.setStroke(Color.WHITE);
			getChildren().add(l);
		}
		
		Circle c = new Circle(6);
		c.fillProperty().bind(fillProperty());
		getChildren().add(c);
		
		Circle inner = new Circle(3);
		inner.setFill(Color.WHITE);
		getChildren().add(inner);
		
		{
			Line l = new Line();
			l.setStartX(0);
			l.setStartY(6);
			l.setEndX(0);
			l.setEndY(40);
			l.setStrokeWidth(3);
			l.setStrokeLineCap(StrokeLineCap.ROUND);
			l.strokeProperty().bind(fill);
			getChildren().add(l);			
		}
		
		setEffect(new DropShadow(3, Color.BLACK));
	}
	
	private ObjectProperty<Paint> fill;
	
	public ObjectProperty<Paint> fillProperty() {
		if( fill == null ) {
			fill = new StyleableObjectProperty<Paint>(Color.rgb(0, 139, 255)) {

				@Override
				public CssMetaData<? extends Styleable, Paint> getCssMetaData() {
					return FILL;
				}

				@Override
				public Object getBean() {
					return PositionMarker.this;
				}

				@Override
				public String getName() {
					return "fill";
				}
				
			};
		}
		return fill;
	}
	
	public void setFill(Paint fill) {
		fillProperty().set(fill);
	}
	
	public Paint getFill() {
		return fillProperty().get();
	}
	
	private static final CssMetaData<PositionMarker,Paint> FILL =
            new CssMetaData<PositionMarker,Paint>("-fx-fill", 
                PaintConverter.getInstance(), Color.rgb(0, 139, 255)) {

            @Override
            public boolean isSettable(PositionMarker node) {
                return node.fill == null || !node.fill.isBound();
            }

            @Override
            public StyleableProperty<Paint> getStyleableProperty(PositionMarker node) {
                return (StyleableProperty<Paint>)node.fillProperty();
            }

            
        };
        
     private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;
     
     static {

         final List<CssMetaData<? extends Styleable, ?>> styleables =
             new ArrayList<CssMetaData<? extends Styleable, ?>>(Group.getClassCssMetaData());
         styleables.add(FILL);
         STYLEABLES = Collections.unmodifiableList(styleables);
     }
     
     public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
         return STYLEABLES;
     }

     @Override
     public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
         return getClassCssMetaData();
     }
        
}
