/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import javafx.geometry.BoundingBox;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.fx.ui.controls.markers.PositionMarker;
import org.eclipse.fx.ui.controls.markers.TabOutlineMarker;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WDragTargetWidget.DropType;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;

/**
 * Feedback for DnD
 */
public class DefaultDnDFeedback implements DnDFeedbackService {

	@Override
	public MarkerFeedback showFeedback(DnDFeedbackData data) {
		Object widget = data.feedbackContainerElement.getWidget();
		if( widget instanceof WLayoutedWidget<?> ) {
			WLayoutedWidget<?> l = (WLayoutedWidget<?>) widget;
			Pane pane = (Pane) l.getStaticLayoutNode();
			
			if( data.reference instanceof MStackElement ) {
				if( data.sourceElement.getParent() == data.feedbackContainerElement ) {
					return handleReorder(pane, data);
				} else {
					return handleMove(pane, data);
				}
			}
		}
		
		return null;
	}
	
	private static MarkerFeedback handleReorder(Pane layoutNode, DnDFeedbackData data) {
		PositionMarker marker = null;
		for( Node n : layoutNode.getChildren() ) {
			if( n instanceof PositionMarker ) {
				marker = (PositionMarker) n;
			}
		}
		
		if( marker == null ) {
			marker = new PositionMarker();
			marker.setManaged(false);
			layoutNode.getChildren().add(marker);
		} else {
			marker.setVisible(true);	
		}
		
		double w = marker.getBoundsInLocal().getWidth();
		double h = marker.getBoundsInLocal().getHeight();
		
		double ratio = data.containerRegion.height / h;
		ratio += 0.1;
		marker.setScaleX(ratio);
		marker.setScaleY(ratio);
		
		double wDiff = w / 2;
		double hDiff = ( h - h * ratio ) / 2;
		
		if( data.dropType == DropType.AFTER ) {
			marker.relocate(data.containerRegion.x + data.containerRegion.width - wDiff, data.containerRegion.y - hDiff);
		} else {
			marker.relocate(data.containerRegion.x  - wDiff, data.containerRegion.y - hDiff);
		}
		
		final PositionMarker fmarker = marker;
		
		return new MarkerFeedback(data) {
			
			@Override
			public void hide() {
				fmarker.setVisible(false);
			}
		};
	}

	@SuppressWarnings("null")
	private static MarkerFeedback handleMove(Pane layoutNode, DnDFeedbackData data) {
		TabOutlineMarker marker = null;
		
		for( Node n : layoutNode.getChildren() ) {
			if( n instanceof TabOutlineMarker ) {
				marker = (TabOutlineMarker) n;
			}
		}
		
		if( marker == null ) {
			marker = new TabOutlineMarker(layoutNode.getBoundsInLocal(), new BoundingBox(data.containerRegion.x, data.containerRegion.y, data.containerRegion.width, data.containerRegion.height), data.dropType == DropType.BEFORE);
			marker.setManaged(false);
			marker.setMouseTransparent(true);
			layoutNode.getChildren().add(marker);
		} else {
			marker.updateBounds(layoutNode.getBoundsInLocal(), new BoundingBox(data.containerRegion.x, data.containerRegion.y, data.containerRegion.width, data.containerRegion.height), data.dropType == DropType.BEFORE);
			marker.setVisible(true);
		}
		
		final TabOutlineMarker fmarker = marker;
		
		return new MarkerFeedback(data) {
			
			@Override
			public void hide() {
				fmarker.setVisible(false);
			}
		};
	}
}
