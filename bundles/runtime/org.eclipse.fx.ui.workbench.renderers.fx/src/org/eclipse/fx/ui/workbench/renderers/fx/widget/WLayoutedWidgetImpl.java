/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.widget;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.Logger.Level;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;



public abstract class WLayoutedWidgetImpl<N,NN extends Node,M extends MUIElement> extends WWidgetImpl<N,M> implements WLayoutedWidget<M> {
	private Node staticLayoutGroup;
	private double weight = 10;
	
	protected abstract NN getWidgetNode();
	
	@Inject
	@Log
	protected Logger logger;
	
	@Override
	public Node getStaticLayoutNode() {
		if( staticLayoutGroup == null ) {
			staticLayoutGroup = createStaticLayoutNode();
		}
		return staticLayoutGroup;
	}
	
	protected Node createStaticLayoutNode() {
		Pane staticLayoutGroup = createStaticPane();
		Node n = getWidgetNode();
		if( n != null ) {
			staticLayoutGroup.getChildren().add(n);
		} else {
			logger.log(Level.ERROR, "No widget node to attach");
		}
		return staticLayoutGroup;
	}
	
	protected Pane createStaticPane() {
		return new StackPane();
	}
	
	@Override
	public void addStyleClasses(List<String> classnames) {
		getWidgetNode().getStyleClass().addAll(classnames);
	}
	
	@Override
	public void addStyleClasses(String... classnames) {
		getWidgetNode().getStyleClass().addAll(classnames);
	}
	
	@Override
	public void setStyleId(String id) {
		getWidgetNode().setId(id);
	}
	
	@Override
	protected void setUserData(WWidgetImpl<N, M> widget) {
		getWidgetNode().setUserData(widget);
	}
	
	@Override
	public double getWeight() {
		return weight;
	}
	
	@Inject
	void setContainerData(@Named(UIEvents.UIElement.CONTAINERDATA) @Optional String data) {
		if( data != null ) {
			try {
				weight = Double.parseDouble(data);
				return;
			} catch(Throwable t) {
				
			}
		}
		
		weight = 10;
	}
}