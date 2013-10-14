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

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBarElement;
import org.eclipse.fx.ui.workbench.renderers.base.EventProcessor.ChildrenHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;

public abstract class BaseToolBarRenderer<N> extends BaseRenderer<MToolBar, WToolBar<N>> implements ChildrenHandler<MToolBar, MToolBarElement> {
	private List<MToolBarElement> widgets = new ArrayList<MToolBarElement>();
	private Thread syncThread;

	public BaseToolBarRenderer() {
		syncThread = new Thread("ToolItem Enablement Sync") {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				while (true) {
					MToolBarElement[] iterationCopy;

					// not ideal because we'll probably check items are already
					// removed
					// from the ui
					synchronized (widgets) {
						iterationCopy = widgets.toArray(new MToolBarElement[0]);
					}

					for (int i = 0; i < iterationCopy.length; i++) {
						MToolBarElement e = iterationCopy[i];
						if (e.getRenderer() instanceof BaseItemRenderer<?, ?>) {
							final MToolBarElement tmp = e;
							final BaseItemRenderer<MToolBarElement, ?> r = (BaseItemRenderer<MToolBarElement, ?>) tmp.getRenderer();
							if (tmp.getRenderer() != null) {
								r.checkEnablement(tmp);
							}
						}
					}

					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		syncThread.setDaemon(true);
		syncThread.start();
	}

	@PostConstruct
	void init(IEventBroker eventBroker) {
		EventProcessor.attachChildProcessor(eventBroker, this);
		EventProcessor.attachVisibleProcessor(eventBroker, this);
	}

	@Override
	public void doProcessContent(MToolBar element) {
		WToolBar<N> toolbar = getWidget(element);
		for (MToolBarElement item : element.getChildren()) {
			WWidget<MToolBarElement> itemWidget = engineCreateWidget(item);
			if (itemWidget != null) {
				toolbar.addChild(itemWidget);
			}
		}
	}

	@Override
	public void childRendered(MToolBar parentElement, MUIElement element) {
		synchronized (widgets) {
			widgets.add((MToolBarElement) element);
		}

		if (inContentProcessing(parentElement)) {
			return;
		}

		int idx = getRenderedIndex(parentElement, element);
		WToolBar<N> toolbar = getWidget(parentElement);
		@SuppressWarnings("unchecked")
		WWidget<MToolBarElement> widget = (WWidget<MToolBarElement>) element.getWidget();
		toolbar.addChild(idx, widget);
	}

	@Override
	public void hideChild(MToolBar container, MUIElement changedObj) {
		synchronized (widgets) {
			widgets.remove(changedObj);
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
