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
package org.eclipse.fx.ui.workbench.fx;

import java.util.Collection;
import java.util.Hashtable;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.InjectionException;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.PersistState;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.MContribution;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.keybindings.e4.EBindingService;
import org.eclipse.fx.ui.services.theme.MultiURLStylesheet;
import org.eclipse.fx.ui.services.theme.MultiURLStylesheetTypeProvider;
import org.eclipse.fx.ui.services.theme.Stylesheet;
import org.eclipse.fx.ui.services.theme.StylesheetTypeProvider;
import org.eclipse.fx.ui.services.theme.ThemeManager;
import org.eclipse.fx.ui.workbench.base.AbstractE4Application;
import org.eclipse.fx.ui.workbench.base.Util;
import org.eclipse.fx.ui.workbench.base.rendering.ElementRenderer;
import org.eclipse.fx.ui.workbench.base.rendering.RendererFactory;
import org.eclipse.fx.ui.workbench.fx.key.KeyBindingDispatcher;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * Rendering engine for javafx
 */
@SuppressWarnings("restriction")
public class PartRenderingEngine implements IPresentationEngine {
	/**
	 * URL of the engine
	 */
	@NonNull
	public static final String engineURI = "bundleclass://org.eclipse.fx.ui.workbench.fx/org.eclipse.fx.ui.workbench.fx.PartRenderingEngine"; //$NON-NLS-1$

	@NonNull
	private static final String defaultFactoryUrl = "bundleclass://org.eclipse.fx.ui.workbench.renderers.fx/org.eclipse.fx.ui.workbench.renderers.fx.DefWorkbenchRendererFactory"; //$NON-NLS-1$

	@NonNull
	private final RendererFactory factory;

	@NonNull
	private final EModelService modelService;

	private MApplication app;

	@NonNull
	private final Logger logger;

	@NonNull
	private final IEventBroker eventBroker;

	@Inject
	PartRenderingEngine(@Nullable @Named(E4Workbench.RENDERER_FACTORY_URI) @Optional String _factoryUrl,
			@NonNull IEclipseContext context, @NonNull EModelService modelService, @NonNull IEventBroker eventBroker,
			@NonNull ThemeManager themeManager,
			@Preference(nodePath = "org.eclipse.fx.ui.workbench.fx", value = AbstractE4Application.THEME_ID) String themeId,
			@NonNull @Log Logger logger) {
		registerDIStylesheets(context);
		final String factoryUrl;
		this.logger = logger;
		if (_factoryUrl == null) {
			factoryUrl = defaultFactoryUrl;
		} else {
			factoryUrl = _factoryUrl;
		}
		IContributionFactory contribFactory = context.get(IContributionFactory.class);
		RendererFactory factory = (RendererFactory) contribFactory.create(factoryUrl, context);
		if (factory == null) {
			throw new IllegalStateException("No renderer factory was created"); //$NON-NLS-1$
		}
		this.factory = factory;
		this.modelService = modelService;
		this.eventBroker = eventBroker;

		if (context.get(EBindingService.class.getName()) != null) {
			KeyBindingDispatcher dispatcher = ContextInjectionFactory.make(KeyBindingDispatcher.class, context);
			context.set(KeyBindingDispatcher.class, dispatcher);
		}

		setupEventListener(eventBroker);

		if (themeId != null && !themeId.isEmpty()) {
			try {
				themeManager.setCurrentThemeId(themeId);
			} catch (Throwable t) {
				this.logger.error("Unknown theme '" + themeId + "'", t); //$NON-NLS-1$//$NON-NLS-2$
			}
		}

		if (themeManager.getCurrentTheme() == null) {
			Object object = context.get(AbstractE4Application.THEME_ID);
			if (object != null && object instanceof String) {
				themeManager.setCurrentThemeId((String) object);
			} else {
				this.logger.info("No current theme is set"); //$NON-NLS-1$
			}
		}
	}

	private static void registerDIStylesheets(IEclipseContext context) {
		try {
			BundleContext bundleContext = FrameworkUtil.getBundle(PartRenderingEngine.class).getBundleContext();
			{
				Collection<ServiceReference<StylesheetTypeProvider>> list = bundleContext.getServiceReferences(StylesheetTypeProvider.class, null);
				for( ServiceReference<StylesheetTypeProvider> r : list ) {
					bundleContext.registerService(Stylesheet.class,ContextInjectionFactory.make(bundleContext.getService(r).getType(), context),new Hashtable<>());
				}
			}

			{
				Collection<ServiceReference<MultiURLStylesheetTypeProvider>> list = bundleContext.getServiceReferences(MultiURLStylesheetTypeProvider.class, null);
				for( ServiceReference<MultiURLStylesheetTypeProvider> r : list ) {
					bundleContext.registerService(MultiURLStylesheet.class,ContextInjectionFactory.make(bundleContext.getService(r).getType(), context),new Hashtable<>());
				}
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void setupEventListener(IEventBroker eventBroker) {
		EventHandler tbrEventHandler = new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				MUIElement changedObj = (MUIElement) event.getProperty(UIEvents.EventTags.ELEMENT);

				if (changedObj.isToBeRendered()) {
					createGui(changedObj);
				} else {
					removeGui(changedObj);
				}
			}
		};
		eventBroker.subscribe(UIEvents.UIElement.TOPIC_TOBERENDERED, tbrEventHandler);

		EventHandler childrenHandler = new EventHandler() {
			@SuppressWarnings("unchecked")
			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MApplication) {
					if (UIEvents.isADD(event)) {
						// Using UIEvents because we don't have access to Utils
						// from here
						Iterable<MWindow> iterable = (Iterable<MWindow>) UIEvents.asIterable(event,
								UIEvents.EventTags.NEW_VALUE);
						for (MWindow win : iterable) {
							createGui(win);
						}
					} else if (UIEvents.isREMOVE(event)) {
						Iterable<MWindow> iterable = (Iterable<MWindow>) UIEvents.asIterable(event,
								UIEvents.EventTags.OLD_VALUE);
						for (MWindow win : iterable) {
							removeGui(win);
						}
					}
				}
			}
		};
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, childrenHandler);

		//FIXME THIS IS BAD BECAUSE WE GET A DEP ON THE RENDERER IMPL!!!
		EventHandler selectedElementHandler = new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MApplication) {
					Object activeWindow = event.getProperty(UIEvents.EventTags.NEW_VALUE);
					if (activeWindow != null && activeWindow instanceof MWindow) {
						MWindow m = (MWindow) activeWindow;
						if (m.getWidget() instanceof WWidget<?>) {
							WWidget<?> w = (WWidget<?>) m.getWidget();
							w.activate();
						}
					}
				}
			}
		};

		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT, selectedElementHandler);

	}

	@Override
	public Object createGui(MUIElement element, Object parentWidget, IEclipseContext parentContext) {
		if (!element.isToBeRendered()) {
			return null;
		}

		if (element.getWidget() != null) {
			return element.getWidget();
		}

		if (element instanceof MContext && ((MContext) element).getContext() == null) {
			createContext((MContext) element, parentContext);
		}

		Object widget = createWidget(element);
		if (widget != null) {
			ElementRenderer<MUIElement, Object> r = getRendererFor(element);
			r.processContent(element);
			r.postProcess(element);

			Object parent = (element.getCurSharedRef() == null) ? ((EObject) element).eContainer()
					: element.getCurSharedRef();

			if (parent instanceof MUIElement) {
				MUIElement parentElement = (MUIElement) parent;
				ElementRenderer<MUIElement, Object> parentRenderer = getRendererFor(parentElement);
				if (parentRenderer != null) {
					parentRenderer.childRendered(parentElement, element);
				}
			}
		} else {
			// failed to create the widget, dispose its context if necessary
			if (element instanceof MContext) {
				MContext ctxt = (MContext) element;
				IEclipseContext lclContext = ctxt.getContext();
				if (lclContext != null) {
					lclContext.dispose();
					ctxt.setContext(null);
				}
			}
		}

		return widget;
	}

	private Object createWidget(@NonNull MUIElement element) {
		ElementRenderer<MUIElement, Object> renderer = getRenderer(element);
		if (renderer != null) {
			// Remember which renderer is responsible for this widget
			element.setRenderer(renderer);
			Object newWidget = renderer.createWidget(element);
			renderer.bindWidget(element, newWidget);
			return newWidget;
		}

		return null;
	}

	private ElementRenderer<@NonNull MUIElement, Object> getRenderer(@NonNull MUIElement uiElement) {
		return this.factory.getRenderer(uiElement);
	}

	@SuppressWarnings({ "unchecked", "static-method" })
	protected <R extends ElementRenderer<? extends M, Object>, M extends MUIElement> R getRendererFor(@NonNull M element) {
		return (R) element.getRenderer();
	}

	private static IEclipseContext createContext(MContext model, IEclipseContext parentContext) {
		IEclipseContext lclContext = parentContext.createChild(getContextName((MApplicationElement) model));
		Util.setup(model, lclContext);
		return lclContext;
	}

	private static String getContextName(MApplicationElement element) {
		StringBuilder builder = new StringBuilder(element.getClass().getSimpleName());
		String elementId = element.getElementId();
		if (elementId != null && elementId.length() != 0) {
			builder.append(" (").append(elementId).append(") "); //$NON-NLS-1$ //$NON-NLS-2$
		}
		builder.append("Context"); //$NON-NLS-1$
		return builder.toString();
	}

	@Override
	public Object createGui(MUIElement element) {
		// Obtain the necessary parent context
		IEclipseContext parentContext = null;
		if (element.getCurSharedRef() != null) {
			MPlaceholder ph = element.getCurSharedRef();
			parentContext = getContext(ph.getParent());
		} else if (element.getParent() != null) {
			parentContext = getContext(element.getParent());
		} else if (element.getParent() == null) {
			parentContext = getContext((MUIElement) ((EObject) element).eContainer());
		}

		return createGui(element, null, parentContext);
	}

	private IEclipseContext getContext(MUIElement parent) {
		if (parent instanceof MContext) {
			return ((MContext) parent).getContext();
		}
		return this.modelService.getContainingContext(parent);
	}

	@Override
	@SuppressWarnings({ "unchecked", "null" })
	public void removeGui(MUIElement element) {
		MUIElement container = (element.getCurSharedRef() != null) ? element.getCurSharedRef()
				: (MUIElement) ((EObject) element).eContainer();

		if (container != null || element instanceof MWindow) {
			ElementRenderer<MUIElement, Object> parentRenderer = (ElementRenderer<MUIElement, Object>) (container == null
					? null : getRendererFor(container));
			ElementRenderer<MUIElement, Object> renderer = getRendererFor(element);

			if (renderer != null) {
				renderer.preDestroy(element);
			}

			// Check if the control is already rendered
			if (renderer != null) {
				if (!(element instanceof MWindow) && parentRenderer != null && container != null) {
					try {
						parentRenderer.hideChild(container, element);
					} catch (Throwable t) {
						this.logger.error(t.getMessage(), t);
					}
				}

				// Need clean up everything below
				EObject eo = (EObject) element;
				// Make a defensive copy
				EObject[] l = eo.eContents().toArray(new EObject[0]);

				// Unrender ALL children

				MUIElement selectedElement = null;
				if (element instanceof MElementContainer) {
					selectedElement = ((MElementContainer<MUIElement>) element).getSelectedElement();
				}

				for (EObject c : l) {
					if (c instanceof MUIElement) {
						if (selectedElement != c) {
							removeGui((MUIElement) c);
						}
					}
				}

				if (selectedElement != null && eo.eContents().contains(selectedElement)) {
					// now remove the selected element
					removeGui(selectedElement);
				}
				if ((element instanceof MWindow) && parentRenderer != null && container != null) {
					try {
						parentRenderer.hideChild(container, element);
					} catch (Throwable t) {
						this.logger.error(t.getMessage(), t);
					}
				}

				if (element instanceof MContribution) {
					MContribution contribution = (MContribution) element;
					Object client = contribution.getObject();
					IEclipseContext parentContext = renderer.getModelContext(element);
					if (parentContext != null && client != null) {
						try {
							ContextInjectionFactory.invoke(client, PersistState.class, parentContext, null);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

				renderer.destroyWidget(element);

				if (element instanceof MContribution) {
					MContribution contribution = (MContribution) element;
					Object client = contribution.getObject();
					IEclipseContext parentContext = renderer.getModelContext(element);
					if (parentContext != null && client != null) {
						try {
							ContextInjectionFactory.uninject(client, parentContext);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					contribution.setObject(null);
				}

				// dispose the context
				if (element instanceof MContext) {
					clearContext((MContext) element);
				}

				element.setRenderer(null);
			} else {
				ElementRenderer<@NonNull MUIElement, Object> r = getRenderer(element);
				r.destroyRenderingContext(element);
			}
		}
	}

	private static void clearContext(MContext contextME) {
		MContext ctxt = (MContext) contextME;
		IEclipseContext lclContext = ctxt.getContext();
		if (lclContext != null) {
			IEclipseContext parentContext = lclContext.getParent();
			if (parentContext != null) {
				IEclipseContext child = parentContext.getActiveChild();
				if (child == lclContext) {
					child.deactivate();
				}
			} else {
				System.err.println("Strange: " + lclContext + " has no parent!"); //$NON-NLS-1$//$NON-NLS-2$
			}

			ctxt.setContext(null);
			lclContext.dispose();
		}
	}

	@Override
	public Object run(MApplicationElement uiRoot, IEclipseContext appContext) {
		this.app = (MApplication) uiRoot;
		MWindow selected = this.app.getSelectedElement();
		if (selected == null) {
			for (MWindow window : this.app.getChildren()) {
				createGui(window);
			}
			this.eventBroker.post(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE, this.app);
		} else {
			// render the selected one first
			createGui(selected);

			for (MWindow window : this.app.getChildren()) {
				if (selected != window) {
					createGui(window);
				}
			}
			focusGui(selected);
			this.eventBroker.post(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE, this.app);

			int deadlockCount = 0;
			// focus the selected part
			MUIElement element = selected;
			while (element != null) {
				if (element instanceof MElementContainer<?>) {
					if( ((MElementContainer<?>) element).getSelectedElement() == null
							&& element instanceof MPart) {
						break;
					}
					element = ((MElementContainer<?>) element).getSelectedElement();
				}

				if (element instanceof MPlaceholder) {
					element = ((MPlaceholder) element).getRef();
				}

				if (deadlockCount++ > 100) {
					this.logger.error("Possible deadlock - Unable to restore focus to appropriate element"); //$NON-NLS-1$
					return null;
				}

				if (element instanceof MPart && ! (element instanceof MElementContainer<?>)) {
					break;
				}

			}

			if (element != null) {
				focusGui(element);
			}


		}
		return null;
	}

	@Override
	public void stop() {
		if (this.app != null) {
			this.app.getContext().set("__efx_engine_shutdown", Boolean.TRUE); //$NON-NLS-1$
			for (MWindow w : this.app.getChildren()) {
				ElementRenderer<MUIElement, Object> r = getRenderer(w);
				if (r != null) {
					removeGui(w);
				}
			}
		}
	}

	@Override
	public void focusGui(MUIElement element) {
		@SuppressWarnings("unchecked")
		ElementRenderer<MUIElement, Object> renderer = (ElementRenderer<MUIElement, Object>) element.getRenderer();
		if (renderer == null || element.getWidget() == null)
			return;

		Object implementation = element instanceof MContribution ? ((MContribution) element).getObject() : null;

		// If there is no class to call @Focus on then revert to the default
		if (implementation == null) {
			renderer.focus(element);
			return;
		}

		try {
			IEclipseContext context = getContext(element);
			Object defaultValue = new Object();
			Object returnValue = ContextInjectionFactory.invoke(implementation, Focus.class, context, defaultValue);
			if (returnValue == defaultValue) {
				// No @Focus method, force the focus
				renderer.focus(element);
			}
		} catch (InjectionException e) {
			this.logger.errorf("Failed to grant focus to element (%s)", e, element.getElementId()); //$NON-NLS-1$
		} catch (RuntimeException e) {
			this.logger.errorf("Failed to grant focus via DI to element (%s)", e, element.getElementId()); //$NON-NLS-1$
		}
	}
}