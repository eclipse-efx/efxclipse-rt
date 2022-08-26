/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.skin;

import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.styledtext.StyledLabel;
import org.eclipse.fx.ui.controls.styledtext.StyledString;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Skin for {@link StyledLabel}
 */
public class StyledLabelSkin extends
		SkinBase<StyledLabel> {
	private final Pane b;
	private final Label l;

	/**
	 * Create a new skin
	 *
	 * @param control
	 *            the control
	 */
	public StyledLabelSkin(StyledLabel control) {
		super(control);
		this.b = new HBox();
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