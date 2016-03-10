package org.eclipse.fx.text.ui.hover.internal;

import org.eclipse.fx.text.hover.DefaultHoverInfoType;
import org.eclipse.fx.text.hover.HoverInfo;
import org.eclipse.fx.text.ui.hover.HoverPresenter;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class DefaultHoverPresenter implements HoverPresenter {

	@Override
	public int getOrder() {
		return -1000;
	}

	@Override
	public boolean isApplicable(Class<? extends HoverInfo> hover) {
		return true;
	}

	@Override
	public Node createHoverContent(HoverInfo hover) {
		HBox b = new HBox();
		b.setSpacing(10);

		Label icon = new Label();
		icon.setText("*");

		Label content = new Label();
		content.setText(hover.getHoverText());

		b.getChildren().setAll(icon, content);

		return b;
	}

}
