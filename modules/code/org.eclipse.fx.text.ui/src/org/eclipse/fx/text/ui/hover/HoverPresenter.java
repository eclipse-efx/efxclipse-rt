package org.eclipse.fx.text.ui.hover;

import org.eclipse.fx.text.hover.HoverInfo;

import javafx.scene.Node;

public interface HoverPresenter {

	int getOrder();

	boolean isApplicable(HoverInfo hover);

	Node createHoverContent(HoverInfo hover);
}
