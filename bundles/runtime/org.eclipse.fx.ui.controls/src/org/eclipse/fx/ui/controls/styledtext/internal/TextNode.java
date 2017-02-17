package org.eclipse.fx.ui.controls.styledtext.internal;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.paint.Paint;

public interface TextNode {

	public abstract void updateText(String text);

	public abstract int getCaretIndexAtPoint(Point2D sceneToLocal);

	public abstract ObservableValue<? extends Paint> fillProperty();

	public abstract String getText();

	public abstract double getCharLocation(int textNodeOffset);

	public abstract ObservableList<String> getStyleClass();

	public abstract Bounds getBoundsInLocal();

	public abstract Point2D sceneToLocal(Point2D scenePoint);

	public abstract Bounds localToScene(Bounds boundsInLocal);

	public abstract double getLayoutX();

	public abstract double getWidth();

	public abstract Bounds getBoundsInParent();

	public abstract void setCursor(Cursor object);

	public abstract void requestLayout();

	public abstract Object getUserData();


}
