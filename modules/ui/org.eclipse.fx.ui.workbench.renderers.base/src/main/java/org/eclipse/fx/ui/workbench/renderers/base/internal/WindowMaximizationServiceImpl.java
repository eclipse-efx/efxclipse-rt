/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Sun Volland<sun.volland@free.fr>
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.base.internal;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.ui.workbench.renderers.base.services.MaximizationService;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMaximizationHost;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Maximization service implementation for maximized content in perspectives.
 *
 * @since 2.2.0
 */
public class WindowMaximizationServiceImpl implements MaximizationService {

	/**
	 * Perspective
	 */
	@Inject
	protected MWindow window;

	/**
	 * Model service
	 */
	@Inject
	protected EModelService modelService;

	/**
	 * Part service
	 */
	@Inject
	protected EPartService partService;

	/**
	 * Current maximized element
	 */
	protected MUIElement maximizedElement;

	@Override
	public void maximize(@NonNull MUIElement element) {
		MUIElement maxElement = element;
		MPlaceholder placeHolder = maxElement.getCurSharedRef();
		if (placeHolder != null) {
			maxElement = placeHolder;
		}

		if (this.maximizedElement != null) {
			if (this.maximizedElement == maxElement) {
				return;
			}
			restore();
		}

		WMaximizationHost widget = (WMaximizationHost) this.window.getWidget();
		WLayoutedWidget<MUIElement> childWidget = (WLayoutedWidget<MUIElement>) maxElement.getWidget();

		if (widget != null && childWidget != null) {
			widget.setMaximizedContent(childWidget);
			this.window.getPersistedState().put("MAXIMIZED", maxElement.getElementId()); //$NON-NLS-1$
			this.maximizedElement = maxElement;
		}
	}

	@Override
	public void restore() {
		WMaximizationHost widget = (WMaximizationHost) this.window.getWidget();

		WLayoutedWidget<? extends MUIElement> childWidget = null;
		if (this.maximizedElement instanceof MPlaceholder) {
			childWidget = (WLayoutedWidget<MUIElement>) ((MPlaceholder) this.maximizedElement).getRef().getWidget();
		} else {
			childWidget = (WLayoutedWidget<MUIElement>) this.maximizedElement.getWidget();
		}
		if (widget != null && childWidget != null) {
			widget.removeMaximizedContent();
			this.window.getPersistedState().remove("MAXIMIZED"); //$NON-NLS-1$
			this.maximizedElement = null;
		}

	}

	@Override
	public boolean isMaximized(@NonNull MUIElement element) {
		MPlaceholder ref = element.getCurSharedRef();
		return this.maximizedElement == (ref != null ? ref : element);
	}

}
