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

import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindowElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;

public interface WWindow<N> extends WWidget<MWindow> {

	public void setMainMenu(WLayoutedWidget<MMenu> menuWidget);

	public void setTopTrim(WLayoutedWidget<MTrimBar> trimBar);

	public void setLeftTrim(WLayoutedWidget<MTrimBar> trimBar);

	public void setRightTrim(WLayoutedWidget<MTrimBar> trimBar);

	public void setBottomTrim(WLayoutedWidget<MTrimBar> trimBar);

	public void addChild(WLayoutedWidget<MWindowElement> widget);

	public void addChild(int idx, WLayoutedWidget<MWindowElement> widget);

	public void removeChild(WLayoutedWidget<MWindowElement> widget);

	public void addChild(WWindow<N> widget);

	public void removeChild(WWindow<N> widget);

	public void setOnCloseCallback(WCallback<WWindow<N>, Boolean> closeCallback);

	public void show();

	public void close();
}
