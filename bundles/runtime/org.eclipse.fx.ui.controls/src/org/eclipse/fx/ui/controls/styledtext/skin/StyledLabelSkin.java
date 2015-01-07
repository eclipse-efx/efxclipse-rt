/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.skin;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.styledtext.StyledLabel;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.controls.styledtext.behavior.StyledLabelBehavior;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;

/**
 * Skin for {@link StyledLabel}
 */
@SuppressWarnings("restriction")
public class StyledLabelSkin extends
		BehaviorSkinBase<StyledLabel, StyledLabelBehavior> {
	private final Pane b;
	private final Label l;

	/**
	 * Create a new skin
	 *
	 * @param control
	 *            the control
	 */
	public StyledLabelSkin(StyledLabel control) {
		super(control, new StyledLabelBehavior(control));
		this.b = new HBox(10);
		this.l = new Label();
		this.l.getStyleClass().clear();
		Bindings.bindContent(this.l.getStyleClass(), control.getStyleClass());
		this.b.getChildren().add(this.l);

		control.styledStringProperty().addListener(this::styleStringChanged);
		control.graphicProperty().addListener(this::graphicChanged);
		if( control.getGraphic() != null ) {
			this.l.setGraphic(control.getGraphic());
		}
		getChildren().add(this.b);
		rebuildControl();
	}

	private void styleStringChanged(
			ObservableValue<? extends StyledString> observable,
			StyledString oldValue, StyledString newValue) {
		if (oldValue != null) {
			oldValue.getSegmentList().removeListener(this::segmentsChanged);
		}
		if (newValue != null) {
			newValue.getSegmentList().addListener(this::segmentsChanged);
		}
	}

	private void graphicChanged(ObservableValue<? extends Node> observable,
			Node oldValue,
			Node newValue) {
		this.l.setGraphic(newValue);
	}

	private void segmentsChanged(Observable o) {
		rebuildControl();
	}

	private void rebuildControl() {
		if( this.b.getChildren().size() > 1 ) {
			this.b.getChildren().set(1,
					Util.toNode(getSkinnable().getStyleString()));
		} else {
			this.b.getChildren().add(
					Util.toNode(getSkinnable().getStyleString()));
		}

	}

	@Override
	public void dispose() {
		getSkinnable().getStyleString().getSegmentList()
				.removeListener(this::segmentsChanged);
		getSkinnable().styledStringProperty().removeListener(
				this::styleStringChanged);
		Bindings.unbindContent(this.l.getStyleClass(), getSkinnable().getStyleClass());
		super.dispose();
	}

}