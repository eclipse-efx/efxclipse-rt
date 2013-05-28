/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.base.widget;

import java.util.List;

import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;

public interface WSash<N> extends WLayoutedWidget<MPartSashContainer> {
	public static final String TAG_FIXED_LAYOUT = "fx_fixedLayout";
	
	public static final String FIXED_LAYOUT_WIDTH = "fx_layout_width";
	public static final String FIXED_LAYOUT_HEIGHT = "fx_layout_height";
	public static final String FIXED_LAYOUT_GRAB_HORIZONTAL = "fx_layout_grab_horizontal";
	public static final String FIXED_LAYOUT_GRAB_VERTICAL = "fx_layout_grab_vertical";
	
	public void addItem(WLayoutedWidget<MPartSashContainerElement> widget);

	public int getItemCount();

	public void addItems(List<WLayoutedWidget<MPartSashContainerElement>> list);

	public void addItems(int index, List<WLayoutedWidget<MPartSashContainerElement>> list);

	public void removeItem(WLayoutedWidget<MPartSashContainerElement> widget);

}
