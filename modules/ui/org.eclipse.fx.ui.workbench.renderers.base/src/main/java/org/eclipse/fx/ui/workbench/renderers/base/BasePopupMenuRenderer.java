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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.AboutToHide;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MDynamicMenuContribution;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.workbench.renderers.base.EventProcessor.ChildrenHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPopupMenu;
import org.eclipse.fx.ui.workbench.services.ELifecycleService;
import org.eclipse.fx.ui.workbench.services.lifecycle.annotation.PreClose;
import org.eclipse.fx.ui.workbench.services.lifecycle.annotation.PreShow;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Base renderer for {@link MPopupMenu}
 * 
 * @param <N>
 *            the native widget type
 */
@SuppressWarnings("restriction")
public abstract class BasePopupMenuRenderer<N> extends BaseItemContainerRenderer<MPopupMenu, MMenuElement, WPopupMenu<N>> implements ChildrenHandler<MPopupMenu, MMenuElement> {
	// FIXME Can we merge this with the BaseMenuRenderer????
	@Inject
	ELifecycleService lifecycleService;

	@Inject
	private IContributionFactory contributionFactory;

	@Log
	@Inject
	private Logger logger;

	/**
	 * Context key to access the owner of the popup menu from a application
	 * model point of view
	 */
	public static final String POPUPMENU_PARENT_ELEMENT = "popupmenu-parent"; //$NON-NLS-1$

	private static final String DYNAMIC_MENU_CONTRIBUTION = "DYNAMIC_MENU_CONTRIBUTION"; //$NON-NLS-1$

	private Set<MPopupMenu> currentVisibleMenus = new HashSet<>();

	@Override
	protected void do_init(@NonNull IEventBroker broker) {
		// nothing to do
	}

	@Override
	protected void initWidget(final MPopupMenu element, WPopupMenu<N> widget) {
		super.initWidget(element, widget);
		widget.setShowingCallback(() -> handleShowing(element));
		widget.setHidingCallback(() -> handleHiding(element));
		element.getContext().set(POPUPMENU_PARENT_ELEMENT, ((EObject) element).eContainer());
	}

	@SuppressWarnings("null")
	void handleHiding(@NonNull MPopupMenu element) {
		this.currentVisibleMenus.remove(element);
		IEclipseContext modelContext = getModelContext(element);
		if (modelContext == null) {
			getLogger().info("Model context is null, probably already disposed"); //$NON-NLS-1$
			return;
		}
		IEclipseContext context = modelContext.createChild("lifecycle"); //$NON-NLS-1$
		context.set(MPopupMenu.class, element);
		this.lifecycleService.validateAnnotation(PreClose.class, element, context);

		for (MMenuElement e : element.getChildren().toArray(new MMenuElement[0])) {
			if (e instanceof MDynamicMenuContribution) {
				MDynamicMenuContribution dc = (MDynamicMenuContribution) e;

				Object contrib = dc.getObject();
				if (contrib != null) {
					@SuppressWarnings("unchecked")
					List<MMenuElement> previous = (List<MMenuElement>) dc.getTransientData().remove(DYNAMIC_MENU_CONTRIBUTION);
					context.set(List.class, previous);
					try {
						ContextInjectionFactory.invoke(contrib, AboutToHide.class, context, null);

						if (previous != null && !previous.isEmpty()) {
							element.getChildren().removeAll(previous);
						}
					} catch (Throwable t) {
						getLogger().debug("Unable to process the AboutToHide", t); //$NON-NLS-1$
					}

				}
			}
		}

		context.dispose();
	}

	@SuppressWarnings("null")
	void handleShowing(@NonNull MPopupMenu element) {
		this.currentVisibleMenus.add(element);
		IEclipseContext modelContext = getModelContext(element);
		if (modelContext == null) {
			getLogger().error("The model context is null"); //$NON-NLS-1$
			return;
		}
		IEclipseContext context = modelContext.createChild("lifecycle"); //$NON-NLS-1$
		context.set(MPopupMenu.class, element);
		this.lifecycleService.validateAnnotation(PreShow.class, element, context);

		// we iterate of the copy because it is modified in between
		for (MMenuElement e : element.getChildren().toArray(new MMenuElement[0])) {
			if (e instanceof MDynamicMenuContribution) {
				MDynamicMenuContribution dc = (MDynamicMenuContribution) e;
				if (dc.getObject() == null && dc.getContributionURI() != null) {
					try {
						// TODO On which context should we create the instance,
						// would
						dc.setObject(this.contributionFactory.create(dc.getContributionURI(), context));
					} catch (Throwable t) {
						getLogger().debug("Unable to create contribution", t); //$NON-NLS-1$
					}
				}

				Object contrib = dc.getObject();
				if (contrib != null) {
					List<MMenuElement> list = new ArrayList<MMenuElement>();
					context.set(List.class, list);
					try {
						ContextInjectionFactory.invoke(contrib, AboutToShow.class, context, null);

						int idx = element.getChildren().indexOf(e);
						element.getChildren().addAll(idx, list);
						dc.getTransientData().put(DYNAMIC_MENU_CONTRIBUTION, list);
					} catch (Throwable t) {
						getLogger().debug("Unable to process AboutToShow", t); //$NON-NLS-1$
					}

				}
			}
		}

		for (MMenuElement e : element.getChildren()) {
			if (e.getRenderer() instanceof BaseItemRenderer) {
				@SuppressWarnings("unchecked")
				BaseItemRenderer<MMenuElement, ?> r = (BaseItemRenderer<MMenuElement, ?>) e.getRenderer();
				r.checkEnablement(e);
			}
		}

		context.dispose();
	}

	@Override
	protected boolean skipEnablementCheck() {
		return this.currentVisibleMenus.isEmpty();
	}

	@Override
	protected boolean isShowing(MMenuElement item) {
		return this.currentVisibleMenus.contains(item.getParent());
	}

	@Override
	public void doProcessContent(MPopupMenu element) {
		// TODO Should we do this creation lazy????
		WPopupMenu<N> menu = getWidget(element);
		if (menu == null) {
			getLogger().error("No widget found for '" + element + "'"); //$NON-NLS-1$//$NON-NLS-2$
			return;
		}

		for (MMenuElement e : element.getChildren()) {
			if (e.isToBeRendered()) {
				WMenuElement<MMenuElement> widget = engineCreateWidget(e);
				if (widget != null && isChildRenderedAndVisible(e)) {
					menu.addElement(widget);
				}
			}
		}
	}

	@Override
	public void handleChildrenRemove(@NonNull MPopupMenu parent, @NonNull Collection<@NonNull MMenuElement> elements) {
		Iterator<MMenuElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MMenuElement element = iterator.next();
			if (element == null) {
				getLogger().error("Found a null element in " + elements); //$NON-NLS-1$
				continue;
			}
			if (isChildRenderedAndVisible(element) && element.getWidget() != null) {
				hideChild(parent, element);
			}
		}
	}

	@Override
	public void handleChildrenAddition(MPopupMenu parent, Collection<MMenuElement> elements) {
		Iterator<MMenuElement> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MMenuElement element = iterator.next();
			// if (element instanceof MDynamicMenuContribution) {
			// MDynamicMenuContribution c = (MDynamicMenuContribution) element;
			// lifecycleService.registerLifecycleURI(element,
			// c.getContributionURI());
			// continue;
			// }
			if (element == null) {
				getLogger().error("Found a null element in " + elements); //$NON-NLS-1$
				continue;
			}
			if (isChildRenderedAndVisible(element)) {
				if (element.getWidget() == null) {
					engineCreateWidget(element);
				} else {
					childRendered(parent, element);
				}
			}
		}
	}

	@Override
	public void do_childRendered(@NonNull MPopupMenu parentElement, @NonNull MUIElement element) {
		if (inContentProcessing(parentElement) || !isChildRenderedAndVisible(element)) {
			return;
		}

		int idx = getRenderedIndex(parentElement, element);
		WPopupMenu<N> menu = getWidget(parentElement);
		if (menu == null) {
			getLogger().error("No widget found for '" + parentElement + "'"); //$NON-NLS-1$//$NON-NLS-2$
			return;
		}

		@SuppressWarnings("unchecked")
		WMenuElement<MMenuElement> menuElement = (WMenuElement<MMenuElement>) element.getWidget();
		if (menuElement != null) {
			menu.addElement(idx, menuElement);
		} else {
			getLogger().error("The widget of the element '" + element + "' is null"); //$NON-NLS-1$//$NON-NLS-2$
		}

	}

	@Override
	public boolean isChildRenderedAndVisible(MUIElement u) {
		return super.isChildRenderedAndVisible(u) && !(u instanceof MDynamicMenuContribution);
	}

	@Override
	public void do_hideChild(MPopupMenu container, MUIElement changedObj) {
		WPopupMenu<N> menu = getWidget(container);

		if (menu == null) {
			return;
		}

		@SuppressWarnings("unchecked")
		WMenuElement<MMenuElement> widget = (WMenuElement<MMenuElement>) changedObj.getWidget();
		if (widget != null) {
			menu.removeElement(widget);
		}
	}
}