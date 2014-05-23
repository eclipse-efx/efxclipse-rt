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
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPerspective;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWindow;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * Base renderer for {@link MPerspective}
 * 
 * @param <N>
 */
public abstract class BasePerspectiveRenderer<N> extends BaseRenderer<MPerspective, WPerspective<N>> {
	@Inject
	@Log
	Logger logger;

	@PostConstruct
	void init(IEventBroker eventBroker) {
		eventBroker.subscribe(UIEvents.Perspective.TOPIC_WINDOWS, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MPerspective) {
					MPerspective perspective = (MPerspective) changedObj;
					if (BasePerspectiveRenderer.this == perspective.getRenderer()) {
						String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
						if (UIEvents.EventTypes.ADD.equals(eventType)) {
							MUIElement element = (MUIElement) event.getProperty(UIEvents.EventTags.NEW_VALUE);
							if (element instanceof MWindow) {
								handleWindowAdd((MWindow) element);
							} else if (element instanceof MPartSashContainerElement) {
								handleChildAdd((MPartSashContainerElement) element);
							} else {
								getLogger().error("ERROR: Unhandled child addition: " + element); //$NON-NLS-1$
							}
						} else if (UIEvents.EventTypes.REMOVE.equals(eventType)) {
							MUIElement element = (MUIElement) event.getProperty(UIEvents.EventTags.OLD_VALUE);
							if (element instanceof MWindow) {
								handleWindowRemove((MWindow) element);
							} else if (element instanceof MPartSashContainerElement) {
								handleChildRemove((MPartSashContainerElement) element);
							} else {
								getLogger().error("ERROR: Unhandled child removal: " + element); //$NON-NLS-1$
							}
						}
					}
				}
			}
		});
	}

	void handleWindowAdd(MWindow window) {
		engineCreateWidget(window);
	}

	void handleWindowRemove(MWindow window) {
		// Nothing to be done
	}

	void handleChildAdd(MPartSashContainerElement element) {
		engineCreateWidget(element);
	}

	void handleChildRemove(MPartSashContainerElement element) {
		// Nothing to be done
	}

	@Override
	protected void doProcessContent(MPerspective element) {
		element.getChildren();
		List<WLayoutedWidget<MPartSashContainerElement>> list = new ArrayList<WLayoutedWidget<MPartSashContainerElement>>();
		for (MPartSashContainerElement e : element.getChildren()) {
			if (e.isToBeRendered()) {
				WLayoutedWidget<MPartSashContainerElement> w = engineCreateWidget(e);
				if (w != null && e.isVisible()) {
					list.add(w);
				}
			}
		}
		getWidget(element).addItems(list);

		if (!element.getWindows().isEmpty()) {
			MWindow window = findParent((EObject) element);
			WWindow<?> topLevel = (WWindow<?>) window.getWidget();
			for (MWindow w : element.getWindows()) {
				topLevel.addChildWindow(engineCreateWidget(w));
			}
		}
	}

	private static MWindow findParent(EObject e) {
		EObject tmp = e;

		if (tmp.eContainer() instanceof MApplication) {
			return null;
		}

		do {
			tmp = tmp.eContainer();
			if (tmp instanceof MWindow) {
				return (MWindow) tmp;
			}
		} while (tmp.eContainer() != null);

		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void childRendered(MPerspective parentElement, MUIElement element) {
		if (inContentProcessing(parentElement)) {
			return;
		}

		if (element instanceof MPartSashContainerElement) {
			getWidget(parentElement).addItem(getRenderedIndex(parentElement, element), (WLayoutedWidget<MPartSashContainerElement>) element.getWidget());
		} else if (element instanceof MWindow) {
			MWindow parent = findParent((EObject) parentElement);
			WWindow<?> w = (WWindow<?>) parent.getWidget();
			if (w != null) {
				WWindow ww = (WWindow) element.getWidget();
				if (ww != null) {
					w.addChildWindow(ww);
				}
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void hideChild(MPerspective container, MUIElement changedObj) {
		WPerspective<N> perspective = getWidget(container);

		if (perspective == null) {
			return;
		}

		if (changedObj instanceof MPartSashContainerElement) {
			WLayoutedWidget<MUIElement> widget = (WLayoutedWidget<MUIElement>) changedObj.getWidget();
			if (widget != null) {
				perspective.removeItem(widget);
			}
		} else if (changedObj instanceof MWindow) {
			MWindow parent = findParent((EObject) container);
			WWindow<?> w = (WWindow<?>) parent.getWidget();
			if (w != null) {
				WWindow ww = (WWindow) changedObj.getWidget();
				if (ww != null) {
					w.removeChildWindow(ww);
				}
			}
		}
	}
}