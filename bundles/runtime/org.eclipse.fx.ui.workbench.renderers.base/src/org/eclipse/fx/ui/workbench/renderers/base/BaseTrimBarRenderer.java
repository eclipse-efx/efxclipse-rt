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
package org.eclipse.fx.ui.workbench.renderers.base;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimElement;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WTrimBar;



@SuppressWarnings("restriction")
public abstract class BaseTrimBarRenderer<N> extends BaseRenderer<MTrimBar, WTrimBar<N>> {

	@Override
	public void doProcessContent(MTrimBar element) {
		WTrimBar<N> trimBar = getWidget(element);
		for( MTrimElement e : element.getChildren() ) {
			WLayoutedWidget<MTrimElement> trimElementWidget = engineCreateWidget(e);
			if( trimElementWidget != null ) {
				trimBar.addChild(trimElementWidget);
			}
		}
	}

	@Override
	public void childRendered(MTrimBar parentElement, MUIElement element) {
	}
	
	@Override
	public void hideChild(MTrimBar container, MUIElement changedObj) {
	}
}
