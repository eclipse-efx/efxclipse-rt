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

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPlaceholderWidget;

/**
 * Base renderer for {@link MPlaceholder}
 * 
 * @param <N>
 *            the native widget type
 */
public abstract class BasePlaceholderRenderer<N> extends BaseRenderer<MPlaceholder, WPlaceholderWidget> {

	@Inject
	@Named(BaseWorkbenchRendererFactory.SHARED_ELEMENTS_MAP)
	private Map<MUIElement, Set<MPlaceholder>> renderedMap;

	private Set<MPlaceholder> getRenderedPlaceholders(MUIElement element) {
		Set<MPlaceholder> set = this.renderedMap.get(element);
		if (set == null) {
			set = new HashSet<MPlaceholder>();
			this.renderedMap.put(element, set);
		}

		return set;
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
			getPresentationEngine().removeGui(refElement);
		} else {
			IEclipseContext curContext = this.modelService.getContainingContext(element);
			MPlaceholder currentRef = refElement.getCurSharedRef();
			IEclipseContext newParentContext = this.modelService.getContainingContext(currentRef);
			List<MContext> allContexts = this.modelService.findElements(refElement, null, MContext.class, null);
			for (MContext ctxtElement : allContexts) {
				IEclipseContext theContext = ctxtElement.getContext();
				// this may be null if it hasn't been rendered yet
				if (theContext != null && theContext.getParent() == curContext) {
					// about to reparent the context, if we're the
					// active child of the current parent, deactivate
					// ourselves first
					if (curContext.getActiveChild() == theContext) {
						theContext.deactivate();
					}
					theContext.setParent(newParentContext);
				}
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
