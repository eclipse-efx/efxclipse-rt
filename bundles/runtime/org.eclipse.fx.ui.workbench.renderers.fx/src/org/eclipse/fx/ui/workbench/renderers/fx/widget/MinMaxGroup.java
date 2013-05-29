/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.widget;

import java.io.IOException;
import java.io.InputStream;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.osgi.util.LoggerCreator;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMinMaxableWidget.WMinMaxState;

public class MinMaxGroup extends HBox {
	
	protected ObjectProperty<Node> maximizeGraphic = new SimpleObjectProperty<>(this,"maximizeGraphic");
	protected ObjectProperty<Node> minimizeGraphic = new SimpleObjectProperty<>(this,"minimizeGraphic");
	protected ObjectProperty<Node> restoreGraphic = new SimpleObjectProperty<>(this,"restoreGraphic");
	
	private static Logger LOGGER = LoggerCreator.createLogger(MinMaxGroup.class); 
	
	/**
	 * 
	 */
	public MinMaxGroup() {
		maximizeGraphic.set(createMaxIcon());
		minimizeGraphic.set(createMinIcon());
		restoreGraphic.set(createRestoreIcon());
		
		getChildren().setAll(minimizeGraphic.get(), maximizeGraphic.get());
		
	}
	
	private Node createMaxIcon() {
		Group g = new Group();
		
		Rectangle r = new Rectangle(10,10,Color.WHITE);
		r.setStrokeWidth(1.0);
		r.setStroke(Color.BLACK);
		g.getChildren().add(r);
		
		r = new Rectangle(10,2,Color.WHITE);
		r.setStrokeWidth(1.0);
		r.setStroke(Color.BLACK);
		g.getChildren().add(r);
		
		return g;
	}
	
	private Node createMinIcon() {
		Rectangle r = new Rectangle(10,3,Color.WHITE);
		r.setStrokeWidth(1.0);
		r.setStroke(Color.BLACK);
		return r;
	}
	
	private Node createRestoreIcon() {
		Group g = new Group();
		
		Rectangle r = new Rectangle(5,0,5,5);
		r.setFill(Color.WHITE);
		r.setStrokeWidth(1.0);
		r.setStroke(Color.BLACK);
		g.getChildren().add(r);
		
		r = new Rectangle(5,0,5,1);
		r.setFill(Color.BLACK);
		r.setStroke(Color.BLACK);
		g.getChildren().add(r);
		
		r = new Rectangle(3,3,5,5);
		r.setFill(Color.WHITE);
		r.setStrokeWidth(1.0);
		r.setStroke(Color.BLACK);
		g.getChildren().add(r);
		
		r = new Rectangle(3,3,5,1);
		r.setFill(Color.BLACK);
		r.setStroke(Color.BLACK);
		g.getChildren().add(r);
		
		return g;
	}
	
	private static final Node getImageView(String iconName) {
		String path = "/icons/"+iconName+".png";
		try(InputStream in = MinMaxGroup.class.getResourceAsStream(path)) {
			return new ImageView(new Image(in));	
		} catch (IOException e) {
			LOGGER.error("Unable to load '"+path+"'", e);
		}
		return null;
	}
	
	public ObjectProperty<Node> maximizeGraphicProperty() {
		return maximizeGraphic;
	}
	
	public ObjectProperty<Node> minimizeGraphicProperty() {
		return minimizeGraphic;
	}
	
	public ObjectProperty<Node> restoreGraphicProperty() {
		return restoreGraphic;
	}
	
	public void setState(WMinMaxState state) {
		switch (state) {
		case NONE:
			getChildren().clear();
			break;
		case MAXIMIZED:
			getChildren().setAll(minimizeGraphic.get(), restoreGraphic.get());
			break;
		case MINIMIZED:
			getChildren().setAll(restoreGraphic.get());
			break;
		case RESTORED:
			getChildren().setAll(minimizeGraphic.get(), maximizeGraphic.get());
			break;
		default:
			break;
		}
	}
}
