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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPlaceholderWidget;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.event.Event;

/**
 * Base renderer for {@link MPlaceholder}
 *
 * @param <N>
 *            the native widget type
 */
public abstract class BasePlaceholderRenderer<N> extends BaseRenderer<MPlaceholder, WPlaceholderWidget> {

	@Inject
	@Named(BaseWorkbenchRendererFactory.SHARED_ELEMENTS_MAP)
	private Map<MUIElement, Set<@NonNull MPlaceholder>> renderedMap;

	private Set<@NonNull MPlaceholder> getRenderedPlaceholders(MUIElement element) {
		Set<@NonNull MPlaceholder> set = this.renderedMap.get(element);
		if (set == null) {
			set = new HashSet<@NonNull MPlaceholder>();
			this.renderedMap.put(element, set);
		}

		return set;
	}

	@PostConstruct
	void init(@NonNull IEventBroker eventBroker) {
		eventBroker.subscribe(UIEvents.UILabel.TOPIC_ICONURI,this::handleRefEvent);

		eventBroker.subscribe(UIEvents.UILabel.TOPIC_LABEL,this::handleRefEvent);
		eventBroker.subscribe(UIEvents.UILabel.TOPIC_LOCALIZED_LABEL,this::handleRefEvent);

		eventBroker.subscribe(UIEvents.UILabel.TOPIC_TOOLTIP,this::handleRefEvent);
		eventBroker.subscribe(UIEvents.UILabel.TOPIC_LOCALIZED_TOOLTIP,this::handleRefEvent);

		eventBroker.subscribe(UIEvents.Dirtyable.TOPIC_DIRTY,this::handleRefEvent);
	}

	@Override
	protected void initContext(@NonNull EObject eo, @NonNull IEclipseContext context) {
		super.initContext(eo, context);
		if( eo instanceof MPlaceholder ) {
			MPlaceholder element = (MPlaceholder) eo;
			Set<MPlaceholder> set = getRenderedPlaceholders(element.getRef());
			if (!set.contains(element)) {
				set.add(element);
			}
		}
	}

	private void handleRefEvent(Event event) {
		Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);

		MUIElement e = (MUIElement) changedObj;

		if( e == null ) {
			return;
		}

		if (inContextModification(e)) {
			return;
		}

		String attributeName = event.getProperty(UIEvents.EventTags.ATTNAME).toString();
		Object newValue = event.getProperty(UIEvents.EventTags.NEW_VALUE);

		for( MPlaceholder p : getRenderedPlaceholders(e) ) {
			try {
				BasePlaceholderRenderer.this.contextModification.put(p, Boolean.TRUE);
				if( isRenderer(p) ) {
					IEclipseContext ctx = getRenderingContext(p);
					if (ctx != null) {
						ctx.set(attributeName, newValue);
					}
				}
			} finally {
				BasePlaceholderRenderer.this.contextModification.put(p, Boolean.FALSE);
			}
		}
	}

	@Override
	protected void initWidget(MPlaceholder element, WPlaceholderWidget widget) {
		super.initWidget(element, widget);

		MUIElement ref = element.getRef();
		ref.setCurSharedRef(element);

		Set<MPlaceholder> set = getRenderedPlaceholders(ref);
		if (!set.contains(element)) {
			set.add(element);
		}

		@SuppressWarnings("unchecked")
		WLayoutedWidget<MUIElement> refWidget = (WLayoutedWidget<MUIElement>) ref.getWidget();
		if (refWidget == null) {
			ref.setToBeRendered(true);
			IEclipseContext contextForParent = getContextForParent(ref);
			if( contextForParent != null ) {
				refWidget = engineCreateWidget(ref, contextForParent);
			} else {
				getLogger().error("Could not find context for reference '"+ref+"'"); //$NON-NLS-1$ //$NON-NLS-2$
			}

		}

		widget.setContent(refWidget);

		if (ref instanceof MContext) {
			IEclipseContext context = ((MContext) ref).getContext();
			IEclipseContext newParentContext = getModelContext(element);
			if (context.getParent() != newParentContext) {
				context.setParent(newParentContext);
			}
		}
	}

	@Override
	public void destroyWidget(MPlaceholder element) {
		MUIElement refElement = element.getRef();

		Set<MPlaceholder> set = this.renderedMap.get(refElement);
		if (set == null || !set.remove(element)) {
			// super.destroyWidget(element);
			// return;
		}

		// Last reference removed so we can destroy it
		if (set == null || set.isEmpty()) {
			if (refElement instanceof MPart) {
				MPart thePart = (MPart) refElement;
				String imageURI = thePart.getIconURI();
				thePart.setIconURI(null);
				thePart.setIconURI(imageURI);
			}
			refElement.setCurSharedRef(null);
			getPresentationEngine().removeGui(refElement);
		} else {
			MPlaceholder currentRef = refElement.getCurSharedRef();
			if( currentRef == element ) {
				refElement.setCurSharedRef(null);
			}
		}

		super.destroyWidget(element);
	}

	@Override
	protected void doProcessContent(MPlaceholder element) {
		// nothing to do
	}

	@Override
	public void childRendered(MPlaceholder parentElement, MUIElement element) {
		// nothing to do
	}

	@Override
	public void hideChild(MPlaceholder container, MUIElement changedObj) {
		// nothing to do
	}
}
