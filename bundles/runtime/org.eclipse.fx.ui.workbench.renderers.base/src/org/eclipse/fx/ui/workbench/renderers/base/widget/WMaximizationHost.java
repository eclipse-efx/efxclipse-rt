/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sun Volland<sun.volland@free.fr>
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.base.widget;

import org.eclipse.e4.ui.model.application.ui.MUIElement;

/**
 * Basic interface for widgets supporting a maximized content
 * 
 */
public interface WMaximizationHost {

	/**
	 * Maximizes a widget
	 * 
	 * @param widget widget to maximize
	 */
	void setMaximizedContent(WLayoutedWidget<? extends MUIElement> widget);
	
	/**
	 * Remove maximized content
	 */
	void removeMaximizedContent();
}
