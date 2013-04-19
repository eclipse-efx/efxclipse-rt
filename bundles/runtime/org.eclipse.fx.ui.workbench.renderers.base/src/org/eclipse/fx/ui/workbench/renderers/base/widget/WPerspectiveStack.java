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

import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;

@SuppressWarnings("restriction")
public interface WPerspectiveStack<N,I,IC> extends WLayoutedWidget<MPerspectiveStack> {
	public interface WStackItem<I,IC> {
		public I getNativeItem();
		public void setDomElement(MPerspective domElement);
		public MPerspective getDomElement();
		public void setInitCallback(WCallback<WStackItem<I, IC>, IC> callback);
		public void setOnCloseCallback(WCallback<WStackItem<I, IC>, Boolean> callback);
	}
	
	public Class<? extends WStackItem<I, IC>> getStackItemClass();
	public void addItem(WStackItem<I, IC> item);
	public void addItems(List<WStackItem<I, IC>> items);
	public void addItems(int index, List<WStackItem<I, IC>> items);
	public void selectItem(int idx);
	public int indexOf(WStackItem<I, IC> item);
	public List<WStackItem<I, IC>> getItems();
	public void removeItems(List<WStackItem<I, IC>> items);
	
	public void setMouseSelectedItemCallback(WCallback<WStackItem<I, IC>, Void> selectedItemCallback);
	public void setKeySelectedItemCallback(WCallback<WStackItem<I, IC>, Void> selectedItemCallback);
	
	public int getItemCount();
}
