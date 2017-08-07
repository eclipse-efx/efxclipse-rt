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

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Basic interface all layouted widgets implement
 * 
 * @param <M>
 *            the model type
 */
public interface WLayoutedWidget<M extends MUIElement> extends WWidget<M>, WDragTargetWidget {
	/**
	 * @return the static layout node
	 */
	@NonNull
	public Object getStaticLayoutNode();

	/**
	 * @return the weight when layouted
	 */
	public double getWeight();
	
	/**
	 * @return the widget container
	 */
	@NonNull
	public Object getWidgetNode();
}
