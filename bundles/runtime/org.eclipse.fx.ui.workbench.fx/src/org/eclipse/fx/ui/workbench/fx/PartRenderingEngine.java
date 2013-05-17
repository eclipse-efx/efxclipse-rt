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

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.InjectionException;
import org.eclipse.e4.core.di.annotations.Optional;
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
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.keybindings.e4.EBindingService;
import org.eclipse.fx.ui.services.theme.ThemeManager;
import org.eclipse.fx.ui.workbench.base.rendering.AbstractRenderer;
import org.eclipse.fx.ui.workbench.base.rendering.RendererFactory;
import org.eclipse.fx.ui.workbench.fx.key.KeyBindingDispatcher;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;


@SuppressWarnings("restriction")
public class PartRenderingEngine implements IPresentationEngine {
	public static final String engineURI = "bundleclass://org.eclipse.fx.ui.workbench.fx/"
			+ "org.eclipse.fx.ui.workbench.fx.PartRenderingEngine";

	private static final String defaultFactoryUrl = "bundleclass://org.eclipse.fx.ui.workbench.renderers.fx/"
			+ "org.eclipse.fx.ui.workbench.renderers.fx.DefWorkbenchRendererFactory";

	private final RendererFactory factory;
	
	private final EModelService modelService;
	
	private MApplication app;
	
	@Inject
	private Logger log;
	
	@Inject
	public PartRenderingEngine(
			@Named(E4Workbench.RENDERER_FACTORY_URI) @Optional String factoryUrl,
			IEclipseContext context,
			EModelService modelService,
			IEventBroker eventBroker,
			ThemeManager themeManager) {
		if( factoryUrl == null ) {
			factoryUrl = defaultFactoryUrl;
		}
		IContributionFactory contribFactory = context.get(IContributionFactory.class);
		this.factory = (RendererFactory) contribFactory.create(factoryUrl, context);
		this.modelService = modelService;
		
		if(  context.get(EBindingService.class.getName()) != null ) {
			KeyBindingDispatcher dispatcher = ContextInjectionFactory.make(KeyBindingDispatcher.class, context);
			context.set(KeyBindingDispatcher.class, dispatcher);
		}
		
		setupEventListener(eventBroker);
		
		if( context.get(E4Application.THEME_ID) != null ) {
			themeManager.setCurrentThemeId((String)context.get(E4Application.THEME_ID));
		}
	}
	
	void setupEventListener(IEventBroker eventBroker) {
		eventBroker.subscribe(UIEvents.UIElement.TOPIC_TOBERENDERED, new EventHandler() {
			
			public void handleEvent(Event event) {
				MUIElement changedObj = (MUIElement) event.getProperty(UIEvents.EventTags.ELEMENT);
				
				if (changedObj.isToBeRendered()) {
					createGui(changedObj);
				} else {
					removeGui(changedObj);
				}
			}
		});
	}
	
	public Object createGui(MUIElement element, Object parentWidget, IEclipseContext parentContext) {
		if( !element.isToBeRendered() ) {
			return null;
		}
		
		if( element.getWidget() != null ) {
			return element.getWidget();
		}
		
		if (element instanceof MContext && ((MContext) element).getContext() == null) {
			createContext((MContext) element, parentContext);
		}
		
		Object widget = createWidget(element);
		if( widget != null ) {
			AbstractRenderer<MUIElement, Object> r = getRendererFor(element);
			r.processContent(element);
			r.postProcess(element);
			
			Object parent = (element.getCurSharedRef() == null)
					? ((EObject)element).eContainer()
					: element.getCurSharedRef();

			if (parent instanceof MUIElement) {
				MUIElement parentElement = (MUIElement) parent;
				AbstractRenderer<MUIElement, Object> parentRenderer = getRendererFor(parentElement);
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
	
	private Object createWidget(MUIElement element) {
		AbstractRenderer<MUIElement,Object> renderer = getRenderer(element);
		if (renderer != null) {
			// Remember which renderer is responsible for this widget
			element.setRenderer(renderer);
			Object newWidget = renderer.createWidget(element);
			if (newWidget != null) {
				renderer.bindWidget(element, newWidget);
				return newWidget;
			}
		}

		return null;
	}
	
	private AbstractRenderer<MUIElement,Object> getRenderer(MUIElement uiElement) {
		return factory.getRenderer(uiElement);
	}
	
	@SuppressWarnings("unchecked")
	protected <R extends AbstractRenderer<? extends M,Object>, M extends MUIElement> R getRendererFor(M element) {
		return (R) element.getRenderer();
	}
	
	private IEclipseContext createContext(MContext model, IEclipseContext parentContext) {
		IEclipseContext lclContext = parentContext.createChild(getContextName((MApplicationElement) model));
		populateModelInterfaces(model, lclContext, model.getClass().getInterfaces());
		model.setContext(lclContext);
		
		for (String variable : model.getVariables()) {
			lclContext.declareModifiable(variable);
		}

		Map<String, String> props = model.getProperties();
		for (String key : props.keySet()) {
			lclContext.set(key, props.get(key));
		}
		
		return lclContext;
	}

	private static void populateModelInterfaces(MContext contextModel, IEclipseContext context, Class<?>[] interfaces) {
		for (Class<?> intf : interfaces) {
			context.set(intf.getName(), contextModel);

			populateModelInterfaces(contextModel, context, intf.getInterfaces());
		}
	}

	private String getContextName(MApplicationElement element) {
		StringBuilder builder = new StringBuilder(element.getClass().getSimpleName());
		String elementId = element.getElementId();
		if (elementId != null && elementId.length() != 0) {
			builder.append(" (").append(elementId).append(") ");
		}
		builder.append("Context");
		return builder.toString();
	}
	
	public Object createGui(MUIElement element) {
		
		// Obtain the necessary parent context
		IEclipseContext parentContext = null;
		if (element.getCurSharedRef() != null) {
			MPlaceholder ph = element.getCurSharedRef();
			parentContext = getContext(ph.getParent());
		} else if (parentContext == null && element.getParent() != null) {
			parentContext = getContext(element.getParent());
		} else if (parentContext == null && element.getParent() == null) {
			parentContext = getContext((MUIElement) ((EObject) element).eContainer());
		}
				
		return createGui(element, null, parentContext);
	}
	
	private IEclipseContext getContext(MUIElement parent) {
		if (parent instanceof MContext) {
			return ((MContext) parent).getContext();
		}
		return modelService.getContainingContext(parent);
	}


	@SuppressWarnings("unchecked")
	public void removeGui(MUIElement element) {
		MUIElement container = (element.getCurSharedRef() != null)
				? element.getCurSharedRef()
				: (MUIElement) ((EObject)element).eContainer();
		
		if( container != null ) {
			AbstractRenderer<MUIElement, Object> parentRenderer = getRendererFor(container);
			AbstractRenderer<MUIElement, Object> renderer = getRendererFor(element);
			
			if( renderer != null ) {
				renderer.preDestroy(element);
			}
			
			// Check if the control is already rendered
			if( renderer != null ) {
				if (parentRenderer != null) {
					parentRenderer.hideChild(container, element);
				}
				
				// Need clean up everything below
				EObject eo = (EObject) element;
				// Make a defensive copy 
				EObject[] l = eo.eContents().toArray(new EObject[0]);
				
				// Unrender ALL children
				
				MUIElement selectedElement = null;
				if( element instanceof MElementContainer ) {
					selectedElement = ((MElementContainer<MUIElement>) element).getSelectedElement();
				}
				
				for( EObject c : l ) {
					if( c instanceof MUIElement ) {
						if( selectedElement != c ) {
							removeGui((MUIElement) c);
						}
					}
				}
				
				if (selectedElement != null
						&& eo.eContents().contains(selectedElement)) {
					// now remove the selected element
					removeGui(selectedElement);
				}
				
				if (element instanceof MContribution) {
					MContribution contribution = (MContribution) element;
					Object client = contribution.getObject();
					IEclipseContext parentContext = renderer.getModelContext(element);
					if (parentContext != null && client != null) {
						try {
							ContextInjectionFactory.invoke(client,
									PersistState.class, parentContext, null);
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
			}
		}
	}
	
	private void clearContext(MContext contextME) {
		MContext ctxt = (MContext) contextME;
		IEclipseContext lclContext = ctxt.getContext();
		if (lclContext != null) {
			IEclipseContext parentContext = lclContext.getParent();
			IEclipseContext child = parentContext.getActiveChild();
			if (child == lclContext) {
				child.deactivate();
			}

			ctxt.setContext(null);
			lclContext.dispose();
		}
	}

	public Object run(MApplicationElement uiRoot, IEclipseContext appContext) {
		app = (MApplication) uiRoot;
		MWindow selected = app.getSelectedElement();
		if (selected == null) {
			for (MWindow window : app.getChildren()) {
				createGui(window);
			}
		} else {
			// render the selected one first
			createGui(selected);
			for (MWindow window : app.getChildren()) {
				if (selected != window) {
					createGui(window);
				}
			}
		}
		return null;
	}

	public void stop() {
		if( app != null ) {
			for( MWindow w : app.getChildren() ) {
				AbstractRenderer<MUIElement, Object> r = getRenderer(w);
				if( r != null ) {
					removeGui(w);
				}
			}			
		}
	}

	@Override
	public void focusGui(MUIElement element) {
		@SuppressWarnings("unchecked")
		AbstractRenderer<MUIElement, Object> renderer =  (AbstractRenderer<MUIElement, Object>) element
				.getRenderer();
		if (renderer == null || element.getWidget() == null)
			return;

		Object implementation = element instanceof MContribution ? ((MContribution) element)
				.getObject() : null;

		// If there is no class to call @Focus on then revert to the default
		if (implementation == null) {
			renderer.focus(element);
			return;
		}

		try {
			IEclipseContext context = getContext(element);
			Object defaultValue = new Object();
			Object returnValue = ContextInjectionFactory.invoke(implementation,
					Focus.class, context, defaultValue);
			if (returnValue == defaultValue) {
				// No @Focus method, force the focus
				renderer.focus(element);
			}
		} catch (InjectionException e) {
			log.errorf("Failed to grant focus to element (%s)", element.getElementId(), e); //$NON-NLS-1$
		} catch (RuntimeException e) {
			log.errorf("Failed to grant focus via DI to element (%s)", element.getElementId(), e); //$NON-NLS-1$
		}
	}
}