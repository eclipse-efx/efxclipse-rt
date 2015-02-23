/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *      Sun Volland <sun.volland@free.fr> - Bug 429507
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.base;

import java.util.Collection;
import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimElement;
import org.eclipse.fx.ui.workbench.renderers.base.EventProcessor.ChildrenHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolControl;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WTrimBar;

/**
 * Base renderer for {@link MTrimBar}
 * 
 * @param <N>
 *            the native widget type
 */
public abstract class BaseTrimBarRenderer<N> extends BaseRenderer<MTrimBar, WTrimBar<N>> implements ChildrenHandler<MTrimBar, MTrimElement> {
	/**
	 * Tag to use when space should be filled
	 */
	public static final String TAG_FILLSPACE = "fillspace"; //$NON-NLS-1$

	@PostConstruct
	void init(IEventBroker eventBroker) {
		EventProcessor.attachChildProcessor(eventBroker, this);
		EventProcessor.attachVisibleProcessor(eventBroker, this);
	}

	@Override
	public void doProcessContent(MTrimBar element) {
		WTrimBar<N> trimBar = getWidget(element);
		if( trimBar == null ) {
			getLogger().error("Could not find widget for '"+element+"'"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
		for (MTrimElement e : element.getChildren()) {
			if (e.isToBeRendered()) {
				WLayoutedWidget<MTrimElement> trimElementWidget = engineCreateWidget(e);
				if (trimElementWidget != null && isChildRenderedAndVisible(e)) {
					trimBar.addChild(trimElementWidget);
				}
			}
		}
	}

	@Override
	public void childRendered(MTrimBar parentElement, MUIElement element) {
		if (inContentProcessing(parentElement)|| ! isChildRenderedAndVisible(element)) {
			return;
		}

		if (!isChildRenderedAndVisible(element)) {
			return;
		}

		WTrimBar<N> trimBar = getWidget(parentElement);
		if( trimBar == null ) {
			getLogger().error("Could not find widget for '"+parentElement+"'"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
		int idx = getRenderedIndex(parentElement, element);
		@SuppressWarnings("unchecked")
		WLayoutedWidget<MTrimElement> widget = (WLayoutedWidget<MTrimElement>) element.getWidget();
		if( widget != null ) {
			if (widget instanceof WToolBar || widget instanceof WToolControl) {
				trimBar.addChild(idx, widget);
			} else {
				this.logger.warning("Widget '"+widget+"' is not of type 'WToolBar' or 'WToolControl'"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} else {
			this.logger.error("Widget for element '"+element+"' should not be null");  //$NON-NLS-1$//$NON-NLS-2$
		}
	}

	@Override
	public void hideChild(MTrimBar container, MUIElement changedObj) {
		WTrimBar<N> toolbar = getWidget(container);

		if (toolbar == null) {
			return;
		}

		@SuppressWarnings("unchecked")
		WLayoutedWidget<MTrimElement> widget = (WLayoutedWidget<MTrimElement>) changedObj.getWidget();
		if (widget != null) {
			toolbar.removeChild(widget);
		}
	}

	@Override
	public void handleChildrenAddition(MTrimBar parent, Collection<MTrimElement> elements) {
		Iterator<MTrimElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MTrimElement element = iterator.next();
			if (element.isToBeRendered()) {
				if (element.getWidget() == null) {
					engineCreateWidget(element);
				} else {
					childRendered(parent, element);
				}
			}
		}
	}

	@Override
	public void handleChildrenRemove(MTrimBar parent, Collection<MTrimElement> elements) {
		Iterator<MTrimElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MTrimElement element = iterator.next();
			if (element.isToBeRendered() && element.getWidget() != null) {
				hideChild(parent, element);
			}
		}
	}
}
