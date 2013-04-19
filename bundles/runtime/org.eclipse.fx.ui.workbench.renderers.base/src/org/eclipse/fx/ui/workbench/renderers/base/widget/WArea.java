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

import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;

@SuppressWarnings("restriction")
public interface WArea<N> extends WLayoutedWidget<MArea> {

	public void addItem(WLayoutedWidget<MPartSashContainerElement> widget);

	public int getItemCount();

	public void addItems(List<WLayoutedWidget<MPartSashContainerElement>> list);

	public void addItems(int index, List<WLayoutedWidget<MPartSashContainerElement>> list);

	public void removeItem(WLayoutedWidget<MPartSashContainerElement> widget);

}
