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
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.workbench.base.rendering.AbstractRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPropertyChangeHandler.WPropertyChangeEvent;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget.WidgetState;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.event.Event;

/**
 * Base class foe all renderers
 * 
 * @param <M>
 *            the model type
 * @param <W>
 *            the abstracted widget type
 */
public abstract class BaseRenderer<M extends MUIElement, W extends WWidget<M>> extends AbstractRenderer<M, W> {
	private static final String RENDERING_CONTEXT_KEY = "fx.rendering.context"; //$NON-NLS-1$

	/**
	 * Key used to store the dom element in the context
	 */
	public static final String CONTEXT_DOM_ELEMENT = "fx.rendering.domElement"; //$NON-NLS-1$

	/**
	 * Key used to store the localized label in the context
	 */
	public static final String ATTRIBUTE_localizedLabel = "localizedLabel"; //$NON-NLS-1$
	/**
	 * Key used to store the localized tooltip in the context
	 */
	public static final String ATTRIBUTE_localizedTooltip = "localizedTooltip"; //$NON-NLS-1$

	@Inject
	IEclipseContext _context; // The
								// rendering
								// context

	@Inject
	EModelService modelService;

	// boolean inContentProcessing;
	//
	// boolean inContextModification;
	//
	// boolean inUIModification;

	Map<String, EAttribute> attributeMap = new HashMap<String, EAttribute>();

	private Map<MUIElement, Boolean> contentProcessing = new HashMap<MUIElement, Boolean>();
	Map<MUIElement, Boolean> contextModification = new HashMap<MUIElement, Boolean>();
	Map<MUIElement, Boolean> uiModification = new HashMap<MUIElement, Boolean>();

	@Inject
	@Log
	Logger logger;

	/**
	 * @return the logger
	 */
	protected Logger getLogger() {
		return this.logger;
	}

	/**
	 * Check if we are currently processing this element
	 * 
	 * @param element
	 *            the element to check
	 * @return <code>true</code> if element is currently processed
	 */
	protected boolean inContentProcessing(MUIElement element) {
		return this.contentProcessing.get(element) == Boolean.TRUE;
	}

	/**
	 * Check if we are currently modifying the context of this element
	 * 
	 * @param element
	 *            the element to check
	 * @return <code>true</code> if the elements context is currently modified
	 */
	protected boolean inContextModification(MUIElement element) {
		return this.contextModification.get(element) == Boolean.TRUE;
	}

	/**
	 * Check if we are currently modifying the UI of the given element
	 * 
	 * @param element
	 *            the element to check
	 * @return <code>true</code> if the elements ui is currently modified
	 */
	protected boolean inUIModification(MUIElement element) {
		return this.uiModification.get(element) == Boolean.TRUE;
	}

	@Override
	public final W createWidget(final M element) {
		final IEclipseContext context = setupRenderingContext(element);

		W widget = ContextInjectionFactory.make(getWidgetClass(element), context);
		// Bug 433845
		widget.setPropertyChangeHandler((WPropertyChangeEvent<W> e) -> propertyObjectChanged(element, e));
		initWidget(element, widget);
		initDefaultEventListeners(this._context.get(IEventBroker.class));

		return widget;
	}

	private void propertyObjectChanged(M element, @NonNull WPropertyChangeEvent<W> event) {
		// There is already a modification in process
		if (inUIModification(element) || inContextModification(element)) {
			return;
		}

		try {
			BaseRenderer.this.uiModification.put(element, Boolean.TRUE);

			EAttribute attribute = BaseRenderer.this.attributeMap.get(event.propertyname);
			EObject eo = (EObject) element;

			if (attribute == null) {
				EStructuralFeature f = eo.eClass().getEStructuralFeature(event.propertyname);
				if (f instanceof EAttribute) {
					attribute = (EAttribute) f;
					BaseRenderer.this.attributeMap.put(event.propertyname, attribute);
				}
			}

			if (attribute != null) {
				if (attribute.getEType().getInstanceClass() == int.class) {
					Object v = event.newValue;
					if (v == null) {
						eo.eSet(attribute, Integer.valueOf(0));
					} else {
						eo.eSet(attribute, Integer.valueOf(((Number) v).intValue()));
					}
				} else {
					eo.eSet(attribute, event.newValue);
				}
			}
		} finally {
			BaseRenderer.this.uiModification.remove(element);
		}
	}

	private void initDefaultEventListeners(IEventBroker broker) {
		registerEventListener(broker, UIEvents.ApplicationElement.TOPIC_PERSISTEDSTATE);
		registerEventListener(broker, UIEvents.ApplicationElement.TOPIC_TAGS);
	}

	@Override
	public final IEclipseContext setupRenderingContext(M element) {
		IEclipseContext context = (IEclipseContext) element.getTransientData().get(RENDERING_CONTEXT_KEY);
		if (context == null) {
			context = this._context.createChild("Element RenderingContext"); //$NON-NLS-1$
			element.getTransientData().put(RENDERING_CONTEXT_KEY, context);
			context.set(CONTEXT_DOM_ELEMENT, element);
			initRenderingContext(element, context);

			try {
				this.contextModification.put(element, Boolean.TRUE);
				EObject eo;
				if (element instanceof MPlaceholder) {
					eo = (EObject) ((MPlaceholder) element).getRef();
				} else {
					eo = (EObject) element;
				}

				initContext(eo, context);
				if (element instanceof MPlaceholder) {
					initContext((EObject) element, context);
				}
			} finally {
				this.contextModification.remove(element);
			}
		}
		return context;
	}

	/**
	 * Initialize the context
	 * 
	 * @param eo
	 *            the object the context should be populated with
	 * @param context
	 *            the context
	 */
	@SuppressWarnings("static-method")
	protected void initContext(EObject eo, IEclipseContext context) {
		for (EAttribute e : eo.eClass().getEAllAttributes()) {
			context.set(e.getName(), eo.eGet(e));
		}

		if (eo instanceof MApplicationElement) {
			for (Entry<String, String> e : ((MApplicationElement) eo).getPersistedState().entrySet()) {
				context.set(UIEvents.ApplicationElement.PERSISTEDSTATE + "_" //$NON-NLS-1$
						+ e.getKey(), e.getValue());
			}
		}

		// Localized Label/Tooltip treatment
		if (eo instanceof MUILabel) {
			MUILabel l = (MUILabel) eo;
			context.set(ATTRIBUTE_localizedLabel, l.getLocalizedLabel());
			context.set(ATTRIBUTE_localizedTooltip, l.getLocalizedTooltip());
		}
	}

	/**
	 * Register an event listener for the give topic and translate it into
	 * context informations
	 * 
	 * @param broker
	 *            the event broker
	 * @param topic
	 *            the topic
	 */
	protected void registerEventListener(IEventBroker broker, String topic) {
		broker.subscribe(topic, this::handleEvent);
	}

	void handleEvent(Event event) {
		Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
		if (!(changedObj instanceof MUIElement)) {
			return;
		}
		
		Object newValue = event.getProperty(UIEvents.EventTags.NEW_VALUE);
		String attributeName = event.getProperty(UIEvents.EventTags.ATTNAME).toString();

		// for now only process set events
		// TODO Should we skip none attribute changes???
		if (!UIEvents.isSET(event)) {
			return;
		}

		MUIElement e = (MUIElement) changedObj;
		// There is already a modification in process
		if (inContextModification(e)) {
			return;
		}
		
		try {
			BaseRenderer.this.contextModification.put(e, Boolean.TRUE);

			if (changedObj instanceof MUIElement) {
				if( event.getProperty(UIEvents.EventTags.ATTNAME).equals(UIEvents.ApplicationElement.TAGS) ) {
					MUIElement m = (MUIElement) changedObj;
					if( m.getWidget() != null ) {
						((WWidget<?>)m.getWidget()).removeStyleClasses(m.getTags());
						((WWidget<?>)m.getWidget()).addStyleClasses(m.getTags());
					}
				}
				
				if (e.getRenderer() == BaseRenderer.this) {
					IEclipseContext ctx = (IEclipseContext) e.getTransientData().get(RENDERING_CONTEXT_KEY);
					if (ctx != null) {
						if (attributeName.equals(UIEvents.ApplicationElement.PERSISTEDSTATE) && newValue instanceof Entry) {
							@SuppressWarnings("unchecked")
							Entry<String, String> entry = (Entry<String, String>) newValue;
							ctx.set(attributeName + "_" //$NON-NLS-1$
									+ entry.getKey(), entry.getValue());
						} else {
							ctx.set(attributeName, newValue);
							if (e instanceof MUILabel) {
								MUILabel l = (MUILabel) e;
								if (event.getProperty(UIEvents.EventTags.ATTNAME).equals(UIEvents.UILabel.LABEL)) {
									ctx.set(ATTRIBUTE_localizedLabel, l.getLocalizedLabel());
								} else if (event.getProperty(UIEvents.EventTags.ATTNAME).equals(UIEvents.UILabel.TOOLTIP)) {
									ctx.set(ATTRIBUTE_localizedTooltip, l.getLocalizedTooltip());
								}
							}
						}
					}
				}
			}
		} finally {
			BaseRenderer.this.contextModification.remove(e);
		}
	}

	/**
	 * Initialize the rendering context
	 * 
	 * @param element
	 *            the element
	 * @param context
	 *            the context
	 */
	protected void initRenderingContext(M element, IEclipseContext context) {
		// nothing todo
	}

	/**
	 * Initialize the widget
	 * 
	 * @param element
	 *            the model element
	 * @param widget
	 *            the widget
	 */
	protected void initWidget(M element, W widget) {
		// nothing todo
	}

	@SuppressWarnings("unchecked")
	@Override
	public void destroyWidget(M element) {
		if (element.getTransientData().containsKey(RENDERING_CONTEXT_KEY)) {
			if (element.getWidget() instanceof WWidget<?>) {
				((WWidget<?>) element.getWidget()).setWidgetState(WidgetState.DISPOSED);
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
		widget.addStyleClasses("M" + eo.eClass().getName()); //$NON-NLS-1$

		for (EClass e : eo.eClass().getEAllSuperTypes()) {
			widget.addStyleClasses("M" + e.getName()); //$NON-NLS-1$
		}

		if (me.getElementId() != null) {
			widget.setStyleId(Util.toCSSId(me.getElementId()));
		}
		me.setWidget(widget);
	}

	@Override
	public void postProcess(M element) {
		if (element.getWidget() instanceof WWidget<?>) {
			((WWidget<?>) element.getWidget()).setWidgetState(WidgetState.CREATED);
		}
	}

	@Override
	public void preDestroy(M element) {
		if (element.getWidget() instanceof WWidget<?>) {
			((WWidget<?>) element.getWidget()).setWidgetState(WidgetState.IN_TEAR_DOWN);
		}
	}

	/**
	 * @return get the presentation engine
	 */
	protected IPresentationEngine getPresentationEngine() {
		return this._context.get(IPresentationEngine.class);
	}

	/**
	 * Get the widgets class
	 * 
	 * @param element
	 *            the widget class
	 * @return the widget class
	 */
	protected abstract Class<? extends W> getWidgetClass(M element);

	/**
	 * Create a widget for the model element through the
	 * {@link IPresentationEngine#createGui(MUIElement)}
	 * 
	 * @param pm
	 *            the model element
	 * @return the widget
	 */
	@SuppressWarnings("unchecked")
	protected <LW extends WWidget<PM>, PM extends MUIElement> LW engineCreateWidget(PM pm) {
		return (LW) getPresentationEngine().createGui(pm);
	}

	/**
	 * Create a widget for the model element through
	 * {@link IPresentationEngine#createGui(MUIElement, Object, IEclipseContext)}
	 * 
	 * @param pm
	 *            the model element
	 * @param context
	 *            the context
	 * @return the widget
	 */
	@SuppressWarnings("unchecked")
	protected <LW extends WWidget<PM>, PM extends MUIElement> LW engineCreateWidget(PM pm, IEclipseContext context) {
		return (LW) getPresentationEngine().createGui(pm, null, context);
	}

	/**
	 * Get the rendering context of the element
	 * 
	 * @param element
	 *            the element
	 * @return the context
	 */
	protected IEclipseContext getRenderingContext(M element) {
		return (IEclipseContext) element.getTransientData().get(RENDERING_CONTEXT_KEY);
	}

	/**
	 * Get the context for the parent using
	 * {@link EModelService#getContainingContext(MUIElement)}
	 * 
	 * @param element
	 *            the element
	 * @return the context
	 */
	protected IEclipseContext getContextForParent(MUIElement element) {
		return this.modelService.getContainingContext(element);
	}

	@Override
	public IEclipseContext getModelContext(MUIElement part) {
		if (part instanceof MContext) {
			return ((MContext) part).getContext();
		}
		return getContextForParent(part);
	}

	/**
	 * Activate the given part using
	 * {@link EPartService#activate(MPart, boolean)}
	 * 
	 * @param element
	 *            the element
	 * @param requiresFocus
	 *            true of focus is required
	 */
	protected void activate(MPart element, boolean requiresFocus) {
		IEclipseContext curContext = getModelContext(element);
		if (curContext != null) {
			EPartService ps = (EPartService) curContext.get(EPartService.class.getName());
			if (ps != null)
				ps.activate(element, requiresFocus);
		}
	}

	@Override
	public final void processContent(M element) {
		try {
			this.contentProcessing.put(element, Boolean.TRUE);
			doProcessContent(element);
		} finally {
			this.contentProcessing.remove(element);
		}
	}

	/**
	 * Get the rendering index of the element
	 * 
	 * @param parent
	 *            the parent
	 * @param element
	 *            the element
	 * @return the index or <code>-1</code>
	 */
	@SuppressWarnings("static-method")
	protected int getRenderedIndex(MUIElement parent, MUIElement element) {
		EObject eElement = (EObject) element;

		EObject container = eElement.eContainer();
		@SuppressWarnings("unchecked")
		List<MUIElement> list = (List<MUIElement>) container.eGet(eElement.eContainmentFeature());
		int idx = 0;
		for (MUIElement u : list) {
			if (u.isToBeRendered() && u.isVisible()) {
				if (u == element) {
					return idx;
				}
				idx++;
			}
		}
		return -1;
	}

	/**
	 * Process the content of an element
	 * 
	 * @param element
	 *            the element
	 */
	protected abstract void doProcessContent(M element);

	@Override
	public void focus(MUIElement element) {
		if (element.getWidget() instanceof WWidget) {
			WWidget<?> widget = (WWidget<?>) element.getWidget();
			widget.activate();
		}

	}
}
