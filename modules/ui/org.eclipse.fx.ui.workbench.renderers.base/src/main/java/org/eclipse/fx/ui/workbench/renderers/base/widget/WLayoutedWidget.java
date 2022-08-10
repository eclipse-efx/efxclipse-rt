/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.base.widget;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

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

	/**
	 * @return <code>true</code> if the widget should be hidden
	 * @since 3.5.0
	 */
	@SuppressWarnings("boxing")
	public default boolean isHidden() {
		@Nullable
		M domElement = getDomElement();
		return domElement == null ? Boolean.FALSE : (Boolean) domElement.getTransientData().getOrDefault("efx_widgetHidden", Boolean.FALSE); //$NON-NLS-1$
	}

	/**
	 * Show/Hide a the widget
	 * 
	 * @param hidden
	 *            the new value
	 * @since 3.5.0
	 */
	@SuppressWarnings("boxing")
	public default void setHidden(boolean hidden) {
		@Nullable
		M domElement = getDomElement();
		if( domElement != null ) {
			domElement.getTransientData().put("efx_widgetHidden", hidden); //$NON-NLS-1$
		}
	}
}
