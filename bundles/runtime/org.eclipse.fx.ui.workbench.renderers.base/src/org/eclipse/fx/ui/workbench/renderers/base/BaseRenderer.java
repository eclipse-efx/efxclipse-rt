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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.MUILabel;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.fx.ui.workbench.base.rendering.AbstractRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPropertyChangeHandler;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget.WidgetState;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;


public abstract class BaseRenderer<M extends MUIElement, W extends WWidget<M>> extends AbstractRenderer<M, W> {
	private static final String RENDERING_CONTEXT_KEY = "fx.rendering.context";
	
	public static final String CONTEXT_DOM_ELEMENT = "fx.rendering.domElement";
	
	public static final String ATTRIBUTE_localizedLabel = "localizedLabel";
	public static final String ATTRIBUTE_localizedTooltip = "localizedTooltip";
	
	@Inject
	IEclipseContext _context; // The rendering context
	
	@Inject
	EModelService modelService;
	
//	boolean inContentProcessing;
//	
//	boolean inContextModification;
//	
//	boolean inUIModification;
	
	private Map<String,EAttribute> attributeMap = new HashMap<String, EAttribute>();
	
	private Map<MUIElement, Boolean> contentProcessing = new HashMap<MUIElement, Boolean>();
	private Map<MUIElement, Boolean> contextModification = new HashMap<MUIElement, Boolean>();
	private Map<MUIElement, Boolean> uiModification = new HashMap<MUIElement, Boolean>();
	
	protected boolean inContentProcessing(MUIElement element) {
		return contentProcessing.get(element) == Boolean.TRUE;
	}
	
	protected boolean inContextModification(MUIElement element) {
		return contextModification.get(element) == Boolean.TRUE;
	}
	
	protected boolean inUIModification(MUIElement element) {
		return uiModification.get(element) == Boolean.TRUE;
	}
	
	@Override
	public final W createWidget(final M element) {
		final IEclipseContext context = setupRenderingContext(element);
		
		W widget =  ContextInjectionFactory.make(getWidgetClass(element), context);
		widget.setPropertyChangeHandler(new WPropertyChangeHandler<W>() {

			@Override
			public void propertyObjectChanged(WPropertyChangeEvent<W> event) {
				// There is already a modification in process
				if( inUIModification(element) || inContextModification(element) ) {
					return;
				}
				
				try {
					uiModification.put(element,Boolean.TRUE);
					
					EAttribute attribute = attributeMap.get(event.propertyname);
					EObject eo = (EObject)element;
					
					if( attribute == null ) {
						EStructuralFeature f = eo.eClass().getEStructuralFeature(event.propertyname);
						if( f instanceof EAttribute ) {
							attribute = (EAttribute) f;
							attributeMap.put(event.propertyname, attribute);
						}
					}
					
					if( attribute != null ) {
						if( attribute.getEType().getInstanceClass() == int.class ) {
							eo.eSet(attribute, ((Number)event.newValue).intValue());
						} else {
							eo.eSet(attribute, event.newValue);
						}
					}
				} finally {
					uiModification.remove(element);
				}
			}
			
		});
		initWidget(element, widget);
		initDefaultEventListeners(_context.get(IEventBroker.class));
		
		return widget;
	}
	
	private void initDefaultEventListeners(IEventBroker broker) {
		registerEventListener(broker, UIEvents.ApplicationElement.TOPIC_PERSISTEDSTATE);
	}
	
	public final IEclipseContext setupRenderingContext(M element) {
		IEclipseContext context = (IEclipseContext) element.getTransientData().get(RENDERING_CONTEXT_KEY);
		if( context == null ) {
			context = _context.createChild("Element RenderingContext");
			element.getTransientData().put(RENDERING_CONTEXT_KEY, context);
			context.set(CONTEXT_DOM_ELEMENT, element);
			initRenderingContext(element, context);
			
			try {
				contextModification.put(element,Boolean.TRUE);
				EObject eo;
				if( element instanceof MPlaceholder ) {
					eo = (EObject) ((MPlaceholder)element).getRef();
				} else {
					eo = (EObject) element;
				}
				
				initContext(eo, context);
				if( element instanceof MPlaceholder ) {
					initContext((EObject) element, context);
				}
			} finally {
				contextModification.remove(element);
			}
		}
		return context;
	}
	
	protected void initContext(EObject eo, IEclipseContext context) {
		for( EAttribute e : eo.eClass().getEAllAttributes() ) {
			context.set(e.getName(), eo.eGet(e));
		}
		
		if( eo instanceof MApplicationElement ) {
			for( Entry<String,String> e : ((MApplicationElement)eo).getPersistedState().entrySet() ) {
				context.set(UIEvents.ApplicationElement.PERSISTEDSTATE + "_" + e.getKey(), e.getValue());
			}	
		}
		
		// Localized Label/Tooltip treatment
		if( eo instanceof MUILabel ) {
			MUILabel l = (MUILabel) eo;
			context.set(ATTRIBUTE_localizedLabel, l.getLocalizedLabel());
			context.set(ATTRIBUTE_localizedTooltip, l.getLocalizedTooltip());
		}
	}
	
	protected void registerEventListener(IEventBroker broker, String topic) {
		broker.subscribe(topic, new EventHandler() {
			
			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if( ! (changedObj instanceof MUIElement) ) {
					return;
				}
				
				Object newValue = event.getProperty(UIEvents.EventTags.NEW_VALUE);
				String attributeName = event.getProperty(UIEvents.EventTags.ATTNAME).toString();
				
				// for now only process set events
				//TODO Should we skip none attribute changes???
				if( ! UIEvents.isSET(event) ) {
					return;
				}
				
				MUIElement e = (MUIElement) changedObj;
				// There is already a modification in process
				if( inContextModification(e) ) {
					return;
				}
				
				try {
					contextModification.put(e,Boolean.TRUE);
					
					if( changedObj instanceof MUIElement ) {
						if( e.getRenderer() == BaseRenderer.this ) {
							IEclipseContext ctx = (IEclipseContext) e.getTransientData().get(RENDERING_CONTEXT_KEY);
							if( ctx != null ) {
								if( attributeName.equals(UIEvents.ApplicationElement.PERSISTEDSTATE) && newValue instanceof Entry  ) {
									@SuppressWarnings("unchecked")
									Entry<String,String> entry = (Entry<String, String>) newValue;
									ctx.set(attributeName+"_"+entry.getKey(), entry.getValue());
								} else {
									ctx.set(attributeName, newValue);
									if( e instanceof MUILabel ) {
										MUILabel l = (MUILabel) e;
										if( event.getProperty(UIEvents.EventTags.ATTNAME).equals(UIEvents.UILabel.LABEL) ) {
											ctx.set(ATTRIBUTE_localizedLabel, l.getLocalizedLabel());	
										} else if( event.getProperty(UIEvents.EventTags.ATTNAME).equals(UIEvents.UILabel.TOOLTIP) ) {
											ctx.set(ATTRIBUTE_localizedTooltip, l.getLocalizedTooltip());	
										}									
									}	
								}
							}
						}
					}
				} finally {
					contextModification.remove(e);
				}
			}
		});
	}
	
	protected void initRenderingContext(M element, IEclipseContext context) {
		
	}
	
	protected void initWidget(M element, W widget) {
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void destroyWidget(M element) {
		if( element.getTransientData().containsKey(RENDERING_CONTEXT_KEY) ) {
			if( element.getWidget() instanceof WWidget<?> ) {
				((WWidget<?>)element.getWidget()).setWidgetState(WidgetState.DISPOSED);
			}
			unbindWidget(element, (W) element.getWidget());
			
			IEclipseContext ctx = (IEclipseContext) element.getTransientData().get(RENDERING_CONTEXT_KEY);
			ctx.dispose();
			element.getTransientData().remove(RENDERING_CONTEXT_KEY);
			
		}
	}
	
	private void unbindWidget(M me, W widget) {
		widget.setDomElement(null);
		me.setWidget(null);
	}
	
	@Override
	public void bindWidget(M me, W widget) {
		widget.setDomElement(me);
		widget.addStyleClasses(me.getTags());
		
		EObject eo = (EObject) me;
		widget.addStyleClasses("M" + eo.eClass().getName());
		
		for( EClass e : eo.eClass().getEAllSuperTypes() ) {
			widget.addStyleClasses("M" + e.getName());
		}
		
		if( me.getElementId() != null ) {
			widget.setStyleId(Util.toCSSId(me.getElementId()));
		}
		me.setWidget(widget);
	}

	@Override
	public void postProcess(M element) {
		if( element.getWidget() instanceof WWidget<?> ) {
			((WWidget<?>)element.getWidget()).setWidgetState(WidgetState.CREATED);
		}
	}
	
	@Override
	public void preDestroy(M element) {
		if( element.getWidget() instanceof WWidget<?> ) {
			((WWidget<?>)element.getWidget()).setWidgetState(WidgetState.IN_TEAR_DOWN);
		}
	}
	
	protected IPresentationEngine getPresentationEngine() {
		return _context.get(IPresentationEngine.class);
	}
	
	protected abstract Class<? extends W> getWidgetClass(M element);
	
	@SuppressWarnings("unchecked")
	protected <LW extends WWidget<PM>, PM extends MUIElement> LW engineCreateWidget(PM pm) {
		return (LW) getPresentationEngine().createGui(pm);
	}
	
	@SuppressWarnings("unchecked")
	protected <LW extends WWidget<PM>, PM extends MUIElement> LW engineCreateWidget(PM pm, IEclipseContext context) {
		return (LW) getPresentationEngine().createGui(pm,null,context);
	}
	
	protected IEclipseContext getRenderingContext(M element) {
		return (IEclipseContext) element.getTransientData().get(RENDERING_CONTEXT_KEY);
	}
	
	protected IEclipseContext getContextForParent(MUIElement element) {
		return modelService.getContainingContext(element);
	}

	public IEclipseContext getModelContext(MUIElement part) { 
		if (part instanceof MContext) {
			return ((MContext) part).getContext();
		}
		return getContextForParent(part);
	}

	protected void activate(MPart element, boolean requiresFocus) {
		IEclipseContext curContext = getModelContext(element);
		if (curContext != null) {
			EPartService ps = (EPartService) curContext.get(EPartService.class
					.getName());
			if (ps != null)
				ps.activate(element, requiresFocus);
		}
	}
	
	@Override
	public final void processContent(M element) {
		try {
			contentProcessing.put(element, Boolean.TRUE);
			doProcessContent(element);
		} finally {
			contentProcessing.remove(element);
		}
	}
	
	protected int getRenderedIndex(MUIElement parent, MUIElement element) {
		EObject eElement = (EObject) element;
		
		EObject container = eElement.eContainer();
		@SuppressWarnings("unchecked")
		List<MUIElement> list = (List<MUIElement>) container.eGet(eElement.eContainmentFeature());
		int idx = 0;
		for( MUIElement u : list ) {
			if( u.isToBeRendered() && u.isVisible() ) {
				if( u == element ) {
					return idx;
				}
				idx++;
			}
		}
		return -1;
	}
	
	protected abstract void doProcessContent(M element);
	
	@Override
	public void focus(MUIElement element) {
		if (element.getWidget() instanceof WWidget){
			WWidget<?> widget = (WWidget<?>) element.getWidget();
			widget.activate();
		}
		
	}
}
