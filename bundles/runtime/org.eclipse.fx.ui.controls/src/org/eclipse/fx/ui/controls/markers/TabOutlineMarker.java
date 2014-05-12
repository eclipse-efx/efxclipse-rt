package org.eclipse.fx.ui.controls.markers;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.StrokeType;

public class TabOutlineMarker extends Group {
	public TabOutlineMarker(Bounds containerBounds, Bounds referenceBounds, boolean before) {
		Polyline pl = new Polyline();
		
		if( before ) {
			referenceBounds = new BoundingBox(referenceBounds.getMinX()-referenceBounds.getWidth()/2, referenceBounds.getMinY(),referenceBounds.getWidth(), referenceBounds.getHeight());
		} else {
			referenceBounds = new BoundingBox(referenceBounds.getMaxX()-referenceBounds.getWidth()/2, referenceBounds.getMinY(),referenceBounds.getWidth(), referenceBounds.getHeight());
		}
		
		pl.getPoints().addAll(
			// -----------------
			// top
			// -----------------
			// start
			0.0,
			referenceBounds.getMaxY(),
			
			// tab start
			referenceBounds.getMinX(),
			referenceBounds.getMaxY(),
			
//			// tab start top
			referenceBounds.getMinX(),
			referenceBounds.getMinY(),
			
			// tab end right
			referenceBounds.getMaxX(),
			referenceBounds.getMinY(),
			
			// tab end bottom
			referenceBounds.getMaxX(),
			referenceBounds.getMaxY(),
			
			// end
			containerBounds.getMaxX(),
			referenceBounds.getMaxY(),
			
			// -----------------
			// right
			// -----------------
			containerBounds.getMaxX(),
			containerBounds.getMaxY(),
			
			// -----------------
			// bottom
			// -----------------
			containerBounds.getMinX(),
			containerBounds.getMaxY(),
			
			// -----------------
			// left
			// -----------------
			containerBounds.getMinX(),
			referenceBounds.getMaxY()
		);
		pl.setStroke(Color.ORANGE);
		pl.setStrokeWidth(3);
		pl.setStrokeType(StrokeType.INSIDE);
		getChildren().add(pl);
	}
}
