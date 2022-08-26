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
