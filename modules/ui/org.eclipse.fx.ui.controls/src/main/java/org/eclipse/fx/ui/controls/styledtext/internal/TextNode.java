/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.internal;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

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

	public abstract void setUserData(Object l);


}
