package org.eclipse.fx.text.ui.hover;

import java.util.List;
import java.util.Set;

import org.eclipse.fx.text.hover.HoverInfo;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public interface HoverWindowPresenter {
	void show(Point2D anchor, Bounds bounds, List<HoverInfo> hover);
	void hide();
}
