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

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import org.eclipse.fx.ui.workbench.renderers.base.widget.WMinMaxableWidget.WMinMaxState;

/**
 * A min-max group implementation
 */
public class MinMaxGroup extends HBox {

	/**
	 * maximize graphic
	 */
	protected ObjectProperty<Node> maximizeGraphic = new SimpleObjectProperty<>(this, "maximizeGraphic"); //$NON-NLS-1$
	/**
	 * minimize graphic
	 */
	protected ObjectProperty<Node> minimizeGraphic = new SimpleObjectProperty<>(this, "minimizeGraphic"); //$NON-NLS-1$
	/**
	 * restore graphic
	 */
	protected ObjectProperty<Node> restoreGraphic = new SimpleObjectProperty<>(this, "restoreGraphic"); //$NON-NLS-1$

//	private static Logger LOGGER = LoggerCreator.createLogger(MinMaxGroup.class);

	/**
	 * 
	 */
	public MinMaxGroup() {
		this.maximizeGraphic.set(createMaxIcon());
		this.minimizeGraphic.set(createMinIcon());
		this.restoreGraphic.set(createRestoreIcon());

		getChildren().setAll(this.minimizeGraphic.get(), this.maximizeGraphic.get());

	}

	private static Node createMaxIcon() {
		Group g = new Group();

		Rectangle r = new Rectangle(10, 10, Color.WHITE);
		r.setStrokeWidth(1.0);
		r.setStroke(Color.BLACK);
		g.getChildren().add(r);

		r = new Rectangle(10, 2, Color.WHITE);
		r.setStrokeWidth(1.0);
		r.setStroke(Color.BLACK);
		g.getChildren().add(r);

		return g;
	}

	private static Node createMinIcon() {
		Rectangle r = new Rectangle(10, 3, Color.WHITE);
		r.setStrokeWidth(1.0);
		r.setStroke(Color.BLACK);
		return r;
	}

	private static Node createRestoreIcon() {
		Group g = new Group();

		Rectangle r = new Rectangle(5, 0, 5, 5);
		r.setFill(Color.WHITE);
		r.setStrokeWidth(1.0);
		r.setStroke(Color.BLACK);
		g.getChildren().add(r);

		r = new Rectangle(5, 0, 5, 1);
		r.setFill(Color.BLACK);
		r.setStroke(Color.BLACK);
		g.getChildren().add(r);

		r = new Rectangle(3, 3, 5, 5);
		r.setFill(Color.WHITE);
		r.setStrokeWidth(1.0);
		r.setStroke(Color.BLACK);
		g.getChildren().add(r);

		r = new Rectangle(3, 3, 5, 1);
		r.setFill(Color.BLACK);
		r.setStroke(Color.BLACK);
		g.getChildren().add(r);

		return g;
	}

	// private static final Node getImageView(String iconName) {
	// String path = "/icons/"+iconName+".png";
	// try(InputStream in = MinMaxGroup.class.getResourceAsStream(path)) {
	// return new ImageView(new Image(in));
	// } catch (IOException e) {
	// LOGGER.error("Unable to load '"+path+"'", e);
	// }
	// return null;
	// }

	/**
	 * @return maximize property
	 */
	public ObjectProperty<Node> maximizeGraphicProperty() {
		return this.maximizeGraphic;
	}

	/**
	 * @return minimize property
	 */
	public ObjectProperty<Node> minimizeGraphicProperty() {
		return this.minimizeGraphic;
	}

	/**
	 * @return restore properts
	 */
	public ObjectProperty<Node> restoreGraphicProperty() {
		return this.restoreGraphic;
	}

	/**
	 * Update the state
	 * 
	 * @param state
	 *            the new state
	 */
	public void setState(WMinMaxState state) {
		switch (state) {
		case NONE:
			getChildren().clear();
			break;
		case MAXIMIZED:
			getChildren().setAll(this.minimizeGraphic.get(), this.restoreGraphic.get());
			break;
		case MINIMIZED:
			getChildren().setAll(this.restoreGraphic.get());
			break;
		case RESTORED:
			getChildren().setAll(this.minimizeGraphic.get(), this.maximizeGraphic.get());
			break;
		default:
			break;
		}
	}
}
