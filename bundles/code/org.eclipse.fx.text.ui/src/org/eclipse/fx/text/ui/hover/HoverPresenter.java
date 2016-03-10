package org.eclipse.fx.text.ui.hover;

import org.eclipse.fx.text.hover.HoverInfo;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;

public interface HoverPresenter {

	int getOrder();

	boolean isApplicable(Class<? extends HoverInfo> hover);

	Node createHoverContent(HoverInfo hover);
}
