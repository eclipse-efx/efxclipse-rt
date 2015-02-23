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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBarElement;
import org.eclipse.e4.ui.workbench.Selector;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;

/**
 * Base renderer for the {@link MToolBar}
 * 
 * @param <N>
 *            the widget node
 */
public abstract class BaseToolBarRenderer<N> extends BaseItemContainerRenderer<MToolBar, MToolBarElement, WToolBar<N>> {
	@Override
	protected void do_init(IEventBroker eventBroker) {
		Object value = this.context.get(Constants.TOOLITEM_TIMER);
		Selector noop = m -> true;
		if( value != null && value instanceof Number ) {
			Thread syncThread = new Thread("ToolItem Enablement Sync") { //$NON-NLS-1$
				@Override
				public void run() {
					while (true) {
						checkExecute(noop);
						try {
							Thread.sleep(((Number)value).longValue());
						} catch (InterruptedException e) {
							getLogger().error("Failed to sleep", e); //$NON-NLS-1$
						}
					}
				}
			};
			syncThread.setDaemon(true);
			syncThread.start();
		}
	}
	
	@Override
	public void doProcessContent(MToolBar element) {
		WToolBar<N> toolbar = getWidget(element);
		if( toolbar == null ) {
			getLogger().error("Could not find widget for '"+element+"'");  //$NON-NLS-1$//$NON-NLS-2$
			return;
		}
		for (MToolBarElement item : element.getChildren()) {
			if (item.isToBeRendered()) {
				WWidget<MToolBarElement> itemWidget = engineCreateWidget(item);
				if (itemWidget != null && isChildAndRenderedVisible(item)) {
					toolbar.addChild(itemWidget);
				}
			}
		}
	}

	@Override
	public void do_childRendered(MToolBar parentElement, MUIElement element) {
		if (inContentProcessing(parentElement)) {
			return;
		}

		WToolBar<N> toolbar = getWidget(parentElement);
		if( toolbar == null ) {
			getLogger().error("Could not find widget for '"+parentElement+"'"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
		int idx = getRenderedIndex(parentElement, element);
		@SuppressWarnings("unchecked")
		WWidget<MToolBarElement> widget = (WWidget<MToolBarElement>) element.getWidget();
		if( widget != null ) {
			toolbar.addChild(idx, widget);	
		} else {
			this.logger.error("The widget for element '"+element+"' should not be null.");  //$NON-NLS-1$//$NON-NLS-2$
		}
		
	}

	@Override
	public void do_hideChild(MToolBar container, MUIElement changedObj) {
		WToolBar<N> toolbar = getWidget(container);

		if (toolbar == null) {
			return;
		}

		@SuppressWarnings("unchecked")
		WWidget<MToolBarElement> widget = (WWidget<MToolBarElement>) changedObj.getWidget();
		if (widget != null) {
			toolbar.removeChild(widget);
		}
	}

	@Override
	public void handleChildrenAddition(MToolBar parent, Collection<MToolBarElement> elements) {
		Iterator<MToolBarElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MToolBarElement element = iterator.next();
			if (element.isToBeRendered() && element.isVisible()) {
				if (element.getWidget() == null) {
					engineCreateWidget(element);
				} else {
					childRendered(parent, element);
				}
			}
		}
	}

	@Override
	public void handleChildrenRemove(MToolBar parent, Collection<MToolBarElement> elements) {
		Iterator<MToolBarElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MToolBarElement element = iterator.next();
			if (element.isToBeRendered() && element.isVisible() && element.getWidget() != null) {
				hideChild(parent, element);
			}
		}
	}
}
