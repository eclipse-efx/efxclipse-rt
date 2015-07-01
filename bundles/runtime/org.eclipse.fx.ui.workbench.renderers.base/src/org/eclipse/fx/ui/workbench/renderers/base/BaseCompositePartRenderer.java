/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MCompositePart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.workbench.base.rendering.RendererFactory;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCompositePart;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolBar;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * Base renderer for {@link MCompositePart}
 * 
 * @param <N>
 *            the native widget
 */
@SuppressWarnings("restriction")
public abstract class BaseCompositePartRenderer<N> extends BaseRenderer<MCompositePart, WCompositePart<N>> {
	@Inject
	RendererFactory factory;

	@PostConstruct
	void init(@NonNull IEventBroker eventBroker) {
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_ICONURI);

		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_LABEL);
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_LOCALIZED_LABEL);

		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_TOOLTIP);
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_LOCALIZED_TOOLTIP);

		registerEventListener(eventBroker, UIEvents.Part.TOPIC_DESCRIPTION);
		registerEventListener(eventBroker, UIEvents.Part.TOPIC_LOCALIZED_DESCRIPTION);

		registerEventListener(eventBroker, UIEvents.Dirtyable.TOPIC_DIRTY);
		
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MCompositePart) {
					MCompositePart parent = (MCompositePart) changedObj;
					if (BaseCompositePartRenderer.this == parent.getRenderer()) {
						if (UIEvents.isADD(event)) {
							handleChildrenAddition(parent, Util.<MPartSashContainerElement> asCollection(event, UIEvents.EventTags.NEW_VALUE));
						} else if (UIEvents.isREMOVE(event)) {
							handleChildrenRemove(parent, Util.<MPartSashContainerElement> asCollection(event, UIEvents.EventTags.OLD_VALUE));

						}
					}
				}
			}
		});
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MCompositePart) {
					MCompositePart parent = (MCompositePart) changedObj;
					if (BaseCompositePartRenderer.this == parent.getRenderer()) {
						String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
						if (UIEvents.EventTypes.SET.equals(eventType)) {
							MUIElement newValue = (MUIElement) event.getProperty(UIEvents.EventTags.NEW_VALUE);
							MUIElement oldValue = (MUIElement) event.getProperty(UIEvents.EventTags.OLD_VALUE);
							handleSelectedElement(parent, (MPartSashContainerElement) oldValue, (MPartSashContainerElement) newValue);
						}
					}
				}
			}
		});
		EventProcessor.attachVisibleProcessor(eventBroker, this);
		eventBroker.subscribe(UIEvents.UIElement.TOPIC_CONTAINERDATA, new EventHandler() {
			
			@Override
			public void handleEvent(Event event) {
				MUIElement changedObj = (MUIElement) event.getProperty(UIEvents.EventTags.ELEMENT);
				if( changedObj != null && changedObj.getParent() != null && changedObj.getParent().getRenderer() == BaseCompositePartRenderer.this ) {
					MElementContainer<MUIElement> parent = changedObj.getParent();
					if( parent != null && !inUIModification(parent) ) {
						@Nullable
						WCompositePart<N> widget = getWidget((MCompositePart)(MUIElement)parent);
						if( widget != null ) {
							widget.updateLayout();	
						} else {
							getLogger().error("Could not find widget for '"+parent+"'");  //$NON-NLS-1$//$NON-NLS-2$
						}
					}
				}
			}
		});
	}

	@Override
	public void doProcessContent(MCompositePart element) {
		WCompositePart<N> sash = getWidget(element);
		if( sash == null ) {
			getLogger().error("Could not find widget for '"+element+"'");  //$NON-NLS-1$//$NON-NLS-2$
			return;
		}
		List<WLayoutedWidget<MPartSashContainerElement>> list = new ArrayList<WLayoutedWidget<MPartSashContainerElement>>();

		for (MPartSashContainerElement e : element.getChildren()) {
			if (e.isToBeRendered()) {
				WLayoutedWidget<MPartSashContainerElement> widget = engineCreateWidget(e);
				if (widget != null && isChildRenderedAndVisible(e)) {
					list.add(widget);
				}
			}
		}

		MToolBar mToolBar = element.getToolbar();
		if (mToolBar != null) {
			WToolBar<N> toolbar = engineCreateWidget(mToolBar);
			sash.setToolbar(toolbar);
		}

		for (MMenu m : element.getMenus()) {
			if (m.getTags().contains(BasePartRenderer.VIEW_MENU_TAG)) {
				final WMenu<N> menu = engineCreateWidget(m);
				sash.setMenu(menu);
				break;
			}
		}

		sash.addItems(list);

		Class<?> cl = sash.getWidget().getClass();
		do {
			element.getContext().set(cl.getName(), sash.getWidget());
			cl = cl.getSuperclass();
		} while (cl != Object.class);

		IContributionFactory contributionFactory = element.getContext().get(IContributionFactory.class);
		Object newPart = contributionFactory.create(element.getContributionURI(), element.getContext());
		element.setObject(newPart);
	}

	@SuppressWarnings("null")
	@Override
	public void childRendered(MCompositePart parentElement, MUIElement element) {
		if (inContentProcessing(parentElement) || ! isChildRenderedAndVisible(element)) {
			return;
		}

		int idx = getRenderedIndex(parentElement, element);
		WCompositePart<N> sash = getWidget(parentElement);
		if( sash == null ) {
			getLogger().error("Could not find widget for '"+parentElement+"'");  //$NON-NLS-1$//$NON-NLS-2$
			return;
		}

		@SuppressWarnings("unchecked")
		WLayoutedWidget<MPartSashContainerElement> w = (WLayoutedWidget<MPartSashContainerElement>) element.getWidget();
		if( w != null ) {
			List<@NonNull WLayoutedWidget<MPartSashContainerElement>> l = Collections.singletonList(w);
			sash.addItems(idx, l);	
		} else {
			this.logger.error("The widget for element '"+element+"' should not be null");  //$NON-NLS-1$//$NON-NLS-2$
		}
	}

	@Override
	public void hideChild(MCompositePart container, MUIElement changedObj) {
		WCompositePart<N> sash = getWidget(container);

		if (sash == null) {
			return;
		}

		@SuppressWarnings("unchecked")
		WLayoutedWidget<MPartSashContainerElement> widget = (WLayoutedWidget<MPartSashContainerElement>) changedObj.getWidget();
		if (widget != null) {
			sash.removeItem(widget);
		}
		if( container.getSelectedElement() == changedObj ) {
			container.setSelectedElement(null);
		}
	}

	void handleChildrenAddition(@NonNull MCompositePart parent, Collection<MPartSashContainerElement> elements) {
		Iterator<MPartSashContainerElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MUIElement element = iterator.next();

			if (element.isToBeRendered()) {
				if (element.getWidget() == null) {
					engineCreateWidget(element);
				} else {
					childRendered(parent, element);
					fixContextHierarchy(elements);
				}
			}
		}

	}

	void handleChildrenRemove(@NonNull MCompositePart parent, Collection<MPartSashContainerElement> elements) {
		Iterator<MPartSashContainerElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MPartSashContainerElement element = iterator.next();
			if (element.isToBeRendered() && element.getWidget() != null) {
				hideChild(parent, element);
			}
		}
		checkSelectedElement(parent);
	}

	void handleSelectedElement(MCompositePart parent, MPartSashContainerElement oldElement, MPartSashContainerElement newElement) {
		// TODO Implement (is this needed the SWT renderes don't care about
		// this!)
	}
}
