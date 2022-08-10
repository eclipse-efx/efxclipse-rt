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
package org.eclipse.fx.ui.workbench.renderers.base;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolItem;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget.WidgetState;

/**
 * Base renderer for {@link MToolItem}
 * 
 * @param <N>
 *            the native widget type
 */
public abstract class BaseToolItemRenderer<N> extends BaseItemRenderer<MToolItem, WToolItem<N>> {
	@Inject
	UISynchronize sync;

	@Override
	protected void initWidget(final MToolItem element, final WToolItem<N> widget) {
		super.initWidget(element, widget);

		final IEclipseContext modelContext = getModelContext(element);
		widget.setOnActionCallback(new Runnable() {

			@Override
			public void run() {
				executeAction(element, modelContext);
			}
		});
	}

	@Override
	public void checkEnablement(final MToolItem toolbarElement) {
		@SuppressWarnings("unchecked")
		final WToolItem<N> widget = (WToolItem<N>) toolbarElement.getWidget();

		// can we call canExecute in the none ui thread????
		this.sync.asyncExec(new Runnable() {

			@Override
			public void run() {
				try {
					IEclipseContext context = getModelContext(toolbarElement);
					if (context != null && (widget.getWidgetState() == WidgetState.CREATED || widget.getWidgetState() == WidgetState.IN_SETUP)) {
						widget.setHandled(canExecute(toolbarElement, context));
						if( toolbarElement.getTags().contains(TAG_HIDE_ON_DISABLE) ) {
							BaseToolItemRenderer.this.eventBroker.send(Constants.UPDATE_VISIBLE_WHEN_RESULT, toolbarElement);
						}
					}
				} catch (Throwable t) {
					// TODO Log it
					t.printStackTrace();
				}

			}
		});

	}

	@Override
	public void doProcessContent(MToolItem element) {
		MMenu menu = element.getMenu();
		if (menu != null) {
			engineCreateWidget(menu);
		}
	}

	@Override
	public void childRendered(MToolItem parentElement, MUIElement element) {
		// nothing todo
	}

	@Override
	public void hideChild(MToolItem container, MUIElement changedObj) {
		// nothing todo
	}

}
