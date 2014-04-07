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

import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;

public interface WMenu<N> extends WMenuElement<MMenu> {

	void addElement(WMenuElement<MMenuElement> widget);

	void addElement(int idx, WMenuElement<MMenuElement> widget);

	void setShowingCallback(Runnable showingCallback);

	void removeElement(WMenuElement<MMenuElement> widget);

	void setHidingCallback(Runnable hidingCallback);

}
