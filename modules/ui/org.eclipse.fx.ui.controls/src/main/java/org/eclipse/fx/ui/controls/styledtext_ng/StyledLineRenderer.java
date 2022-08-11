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
package org.eclipse.fx.ui.controls.styledtext_ng;

import org.eclipse.fx.core.Range;
import org.eclipse.fx.core.Subscription;

import javafx.scene.Node;
import javafx.scene.paint.Paint;

public interface StyledLineRenderer {
	public void setVisibleRange(double minX, double maxX);

	public void setFont(String family, double size);
	public Subscription setBold(Range range);
	public Subscription setItalic(Range range);
	public Subscription setForeground(Paint paint, Range range);
	public void combinedAction(Runnable r);
	public void setText(char[] text);

	public void clearStyles();

	public Node getNode();
}
