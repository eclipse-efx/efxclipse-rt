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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBarElement;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.Selector;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.core.di.ScopedObjectFactory;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.workbench.renderers.base.EventProcessor.ChildrenHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;

/**
 * Base renderer for the {@link MToolBar}
 * 
 * @param <N>
 *            the widget node
 */
public abstract class BaseToolBarRenderer<N> extends BaseRenderer<MToolBar, WToolBar<N>> implements ChildrenHandler<MToolBar, MToolBarElement> {
	List<MToolBarElement> widgets = new ArrayList<MToolBarElement>();
	
	@Inject
	IEclipseContext context;
	
	@PostConstruct
	void init(IEventBroker eventBroker) {
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
		
		EventProcessor.attachChildProcessor(eventBroker, this);
		EventProcessor.attachVisibleProcessor(eventBroker, this);
		eventBroker.subscribe(ScopedObjectFactory.KEYMODIFED_TOPIC, e -> checkExecute(m -> true));
		eventBroker.subscribe(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, e -> {
			Object d = e.getProperty(IEventBroker.DATA);
			if( d instanceof Selector ) {
				checkExecute((Selector) d);
			} else if( UIEvents.ALL_ELEMENT_ID.equals(d)) {
				checkExecute(m -> true);
			} else if( d != null ) {
				checkExecute(m -> d.equals(m.getElementId()));
			}
		});	
		this.context.runAndTrack(new RunAndTrack() {
			
			@Override
			public boolean changed(IEclipseContext context) {
				context.get(IServiceConstants.ACTIVE_CONTEXTS);
				context.get(IServiceConstants.ACTIVE_SELECTION);
				context.get(IServiceConstants.ACTIVE_PART);
				checkExecute(noop);
				return true;
			}
		});
		
	}
	
	void checkExecute(Selector selector) {
		MToolBarElement[] iterationCopy;

		// not ideal because we'll probably check items are already
		// removed
		// from the ui
		synchronized (BaseToolBarRenderer.this.widgets) {
			iterationCopy = BaseToolBarRenderer.this.widgets.toArray(new MToolBarElement[0]);
		}
		
		for (int i = 0; i < iterationCopy.length; i++) {
			MToolBarElement e = iterationCopy[i];
			if (e.getRenderer() instanceof BaseItemRenderer<?, ?> && selector.select(e)) {
				final MToolBarElement tmp = e;
				@SuppressWarnings("unchecked")
				final BaseItemRenderer<MToolBarElement, ?> r = (BaseItemRenderer<MToolBarElement, ?>) tmp.getRenderer();
				if (tmp.getRenderer() != null) {
					r.checkEnablement(tmp);
				}
			}
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
				if (itemWidget != null && item.isVisible()) {
					toolbar.addChild(itemWidget);
				}
			}
		}
	}

	@Override
	public void childRendered(MToolBar parentElement, MUIElement element) {
		synchronized (this.widgets) {
			this.widgets.add((MToolBarElement) element);
		}

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
	public void hideChild(MToolBar container, MUIElement changedObj) {
		synchronized (this.widgets) {
			this.widgets.remove(changedObj);
		}

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
