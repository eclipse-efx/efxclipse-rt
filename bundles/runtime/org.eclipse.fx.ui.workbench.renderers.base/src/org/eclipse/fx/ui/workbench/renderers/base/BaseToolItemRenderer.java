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

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolItem;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget.WidgetState;


@SuppressWarnings("restriction")
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
				executeAction(element,modelContext.getActiveLeaf());
			}
		});
	}
	
	@Override
	public void checkEnablement(final MToolItem toolbarElement) {
		@SuppressWarnings("unchecked")
		final WToolItem<N> widget = (WToolItem<N>) toolbarElement.getWidget();

		// can we call canExecute in the none ui thread????
		sync.asyncExec(new Runnable() {
			
			@Override
			public void run() {
				try {
					IEclipseContext context = getModelContext(toolbarElement);
					if( context != null && (widget.getWidgetState() == WidgetState.CREATED || widget.getWidgetState() == WidgetState.IN_SETUP ) ) {
						widget.setHandled(canExecute(toolbarElement, context));	
					}
				} catch(Throwable t) {
					//TODO Log it
					t.printStackTrace();
				}
				
			}
		});
		
	}
	
	@Override
	public void doProcessContent(MToolItem element) {
		if( element.getMenu() != null ) {
			engineCreateWidget(element.getMenu());
		}
	}

	@Override
	public void childRendered(MToolItem parentElement, MUIElement element) {
		
	}
	
	@Override
	public void hideChild(MToolItem container, MUIElement changedObj) {
		
	}

}
