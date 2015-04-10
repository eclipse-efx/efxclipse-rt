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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.eclipse.core.expressions.ExpressionInfo;
import org.eclipse.e4.core.commands.ExpressionContext;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.contexts.RunAndTrack;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.internal.workbench.ContributionsAnalyzer;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MCoreExpression;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.MUILabel;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.ApplicationElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.workbench.base.rendering.ElementRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPropertyChangeHandler.WPropertyChangeEvent;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget.WidgetState;
import org.eclipse.fx.ui.workbench.services.EModelStylingService;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.event.Event;

/**
 * Base class foe all renderers
 *
 * @param <M>
 *            the model type
 * @param <W>
 *            the abstracted widget type
 */
@SuppressWarnings("restriction")
public abstract class BaseRenderer<M extends MUIElement, W extends WWidget<M>> implements ElementRenderer<M, W> {
	private static final String RENDERING_CONTEXT_KEY = "fx.rendering.context"; //$NON-NLS-1$

	/**
	 * Key used to store the dom element in the context
	 */
	public static final String CONTEXT_DOM_ELEMENT = "fx.rendering.domElement"; //$NON-NLS-1$

	private static final String RENDER_KEY = "_renderer"; //$NON-NLS-1$

	// /**
	// * Key used to store the localized label in the context
	// */
	//	public static final String ATTRIBUTE_localizedLabel = "localizedLabel"; //$NON-NLS-1$
	// /**
	// * Key used to store the localized tooltip in the context
	// */
	//	public static final String ATTRIBUTE_localizedTooltip = "localizedTooltip"; //$NON-NLS-1$

	@Inject
	IEclipseContext _context; // The
								// rendering
								// context

	@Inject
	EModelService modelService;

	@Inject
	EModelStylingService modelStylingService;

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

	@NonNull
	final Map<@NonNull MUIElement, @NonNull ActiveLeafRunAndTrack> visibleWhenElements = new HashMap<>();

	/**
	 * Transient data key used to remember the calculated visibility which is
	 * built from
	 * <ul>
	 * <li>{@link MUIElement#getVisibleWhen()}</li>
	 * <li>{@link MUIElement#isVisible()}</li>
	 * </ul>
	 */
	public static final String CALCULATED_VISIBILITY = "efx_calculated_visibility"; //$NON-NLS-1$

	/**
	 * Constant used to remember the current state of the visible when
	 * expression
	 */
	public static final String CURRENT_VISIBLE_WHEN = "efx_current_visible_when"; //$NON-NLS-1$

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
	protected boolean inContextModification(@NonNull MUIElement element) {
		return this.contextModification.get(element) == Boolean.TRUE;
	}

	/**
	 * Check if we are currently modifying the UI of the given element
	 *
	 * @param element
	 *            the element to check
	 * @return <code>true</code> if the elements ui is currently modified
	 */
	protected boolean inUIModification(@NonNull MUIElement element) {
		return this.uiModification.get(element) == Boolean.TRUE;
	}

	@Override
	@NonNull
	public final W createWidget(final @NonNull M element) {
		final IEclipseContext context = setupRenderingContext(element);

		W widget = ContextInjectionFactory.make(getWidgetClass(element), context);
		// Bug 433845
		widget.setPropertyChangeHandler((WPropertyChangeEvent<W> e) -> propertyObjectChanged(element, e));
		initWidget(element, widget);
		IEventBroker broker = this._context.get(IEventBroker.class);
		if (broker != null) {
			initDefaultEventListeners(broker);
		} else {
			this.logger.error("No event broker was found. Most things will not operate appropiately!"); //$NON-NLS-1$
		}

		element.getTransientData().put(CALCULATED_VISIBILITY, Boolean.valueOf(element.isVisible() && checkVisibleWhen(element, getModelContext(element))));

		if (element.getVisibleWhen() != null) {
			ActiveLeafRunAndTrack rat = new ActiveLeafRunAndTrack(element, this._context.get(IEventBroker.class));
			this.visibleWhenElements.put(element, rat);

			IEclipseContext modelContext = getModelContext(element);
			if (modelContext != null) {
				modelContext.runAndTrack(rat);
			}
		}

		return widget;
	}

	/**
	 * Run code without informing the UI about updates
	 *
	 * @param element
	 *            the element the code is executed on
	 * @param codeBlock
	 *            the code to run
	 */
	public void syncUIModifications(@NonNull MUIElement element, @NonNull Runnable codeBlock) {
		if (inUIModification(element)) {
			codeBlock.run();
			return;
		}

		try {
			BaseRenderer.this.uiModification.put(element, Boolean.TRUE);
			codeBlock.run();
		} finally {
			BaseRenderer.this.uiModification.remove(element);
		}
	}

	private void propertyObjectChanged(@NonNull M element, @NonNull WPropertyChangeEvent<W> event) {
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

	@SuppressWarnings("null")
	private void initDefaultEventListeners(@NonNull IEventBroker broker) {
		registerEventListener(broker, UIEvents.ApplicationElement.TOPIC_PERSISTEDSTATE);
		registerEventListener(broker, UIEvents.ApplicationElement.TOPIC_TAGS);
		registerEventListener(broker, UIEvents.UIElement.TOPIC_CONTAINERDATA);

		broker.subscribe(UIEvents.UIElement.TOPIC_VISIBLEWHEN, this::handleVisibleWhen);
	}

	private void handleVisibleWhen(Event event) {
		Object element = event.getProperty(UIEvents.EventTags.ELEMENT);

		if (element instanceof MUIElement) {
			MUIElement e = (MUIElement) element;

			if (e.getRenderer() == this) {
				if (e.getVisibleWhen() == null) {
					this.visibleWhenElements.remove(e);
				} else {
					this.visibleWhenElements.put(e, new ActiveLeafRunAndTrack(e, this._context.get(IEventBroker.class)));
				}
			}

			IEventBroker broker = this._context.get(IEventBroker.class);
			broker.send(Constants.UPDATE_VISIBLE_WHEN_RESULT, e);
		}
	}

	/**
	 * Check if this renderer is the one responsible for this class
	 *
	 * @param element
	 *            the element
	 * @return <code>true</code> if renderer is the one associated with this
	 *         element
	 */
	protected boolean isRenderer(@NonNull MUIElement element) {
		if (element.getRenderer() != null) {
			return element.getRenderer() == this;
		}
		@Nullable
		IEclipseContext renderingContext = getRenderingContext(element);
		if (renderingContext != null) {
			return renderingContext.get(RENDER_KEY) == this;
		}
		return false;
	}

	@Override
	public final IEclipseContext setupRenderingContext(@NonNull M element) {
		IEclipseContext context = (IEclipseContext) element.getTransientData().get(RENDERING_CONTEXT_KEY);
		if (context == null) {
			context = this._context.createChild("Element RenderingContext"); //$NON-NLS-1$
			context.set(RENDER_KEY, this);
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

				if (eo != null) {
					initContext(eo, context);
					if (element instanceof MPlaceholder) {
						initContext((EObject) element, context);
					}
				} else {
					throw new IllegalStateException("The placeholder reference of '" + element + "' is null"); //$NON-NLS-1$ //$NON-NLS-2$
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
	protected void initContext(@NonNull EObject eo, @NonNull IEclipseContext context) {
		for (EAttribute e : eo.eClass().getEAllAttributes()) {
			context.set(e.getName(), eo.eGet(e));
		}

		if (eo instanceof MApplicationElement) {
			for (Entry<String, String> e : ((MApplicationElement) eo).getPersistedState().entrySet()) {
				context.set(UIEvents.ApplicationElement.PERSISTEDSTATE + "_" //$NON-NLS-1$
						+ e.getKey(), e.getValue());
			}
		}

		// // Localized Label/Tooltip treatment
		// if (eo instanceof MUILabel) {
		// MUILabel l = (MUILabel) eo;
		// context.set(ATTRIBUTE_localizedLabel, l.getLocalizedLabel());
		// context.set(ATTRIBUTE_localizedTooltip, l.getLocalizedTooltip());
		// }
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
	protected void registerEventListener(@NonNull IEventBroker broker, @NonNull String topic) {
		broker.subscribe(topic, this::handleEvent);
	}

	@SuppressWarnings("null")
	void handleEvent(Event event) {
//		System.err.println("EVENT: " + this + " ===> " + event);
		Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
		if (!(changedObj instanceof MUIElement)) {
			return;
		}

		Object newValue = event.getProperty(UIEvents.EventTags.NEW_VALUE);
		String attributeName = event.getProperty(UIEvents.EventTags.ATTNAME).toString();

		// for now only process set and tag events
		// TODO Should we skip none attribute changes???
		if (!UIEvents.isSET(event) && !UIEvents.ApplicationElement.TAGS.equals(attributeName)) {
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
				if (isRenderer(e)) {
					if (attributeName.equals(UIEvents.ApplicationElement.TAGS)) {
						MUIElement m = (MUIElement) changedObj;
						if (m.getWidget() != null) {
							if (UIEvents.isADD(event)) {
								Collection<String> addedTags = Util.<String> asCollection(event, UIEvents.EventTags.NEW_VALUE);
								((WWidget<?>) m.getWidget()).addStyleClasses(this.modelStylingService.getStylesFromTags(new ArrayList<String>(addedTags)));
							} else if (UIEvents.isREMOVE(event)) {
								Collection<String> removedTags = Util.<String> asCollection(event, UIEvents.EventTags.OLD_VALUE);
								((WWidget<?>) m.getWidget()).removeStyleClasses(this.modelStylingService.getStylesFromTags(new ArrayList<String>(removedTags)));
							}
						}
					}

					IEclipseContext ctx = (IEclipseContext) e.getTransientData().get(RENDERING_CONTEXT_KEY);
					if (ctx != null) {
						if (attributeName.equals(UIEvents.ApplicationElement.PERSISTEDSTATE) && newValue instanceof Entry) {
							@SuppressWarnings("unchecked")
							Entry<String, String> entry = (Entry<String, String>) newValue;
							ctx.set(attributeName + "_" //$NON-NLS-1$
									+ entry.getKey(), entry.getValue());
						} else if( attributeName.equals(UIEvents.ApplicationElement.TAGS) ) {
							ctx.set(ApplicationElement.TAGS, new ArrayList<>(e.getTags()));
						} else {
							ctx.set(attributeName, newValue);
						}
						handleAttributeChange(e, ctx, attributeName, newValue);
					}
				}
			}
		} finally {
			BaseRenderer.this.contextModification.remove(e);
		}
	}

	/**
	 * Handle the change of an attribute e.g. to publish the localized string as
	 * well when the label value changes
	 *
	 * @param e
	 *            the ui element
	 * @param context
	 *            the context
	 * @param attributeName
	 *            the attribute name
	 * @param newValue
	 *            the new value
	 */
	@SuppressWarnings("static-method")
	protected void handleAttributeChange(MUIElement e, IEclipseContext context, String attributeName, Object newValue) {
		if (e instanceof MUILabel) {
			MUILabel l = (MUILabel) e;
			if (UIEvents.UILabel.LABEL.equals(attributeName)) {
				context.set(UIEvents.UILabel.LOCALIZED_LABEL, l.getLocalizedLabel());
			} else if (UIEvents.UILabel.TOOLTIP.equals(attributeName)) {
				context.set(UIEvents.UILabel.LOCALIZED_TOOLTIP, l.getLocalizedTooltip());
			}
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
	protected void initRenderingContext(@NonNull M element, @NonNull IEclipseContext context) {
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
	protected void initWidget(@NonNull M element, @NonNull W widget) {
		// nothing todo
	}

	@SuppressWarnings({ "unchecked", "all" })
	@Override
	public void destroyWidget(@NonNull M element) {
		if (element.getTransientData().containsKey(RENDERING_CONTEXT_KEY)) {
			if (element.getWidget() instanceof WWidget<?>) {
				((WWidget<?>) element.getWidget()).setWidgetState(WidgetState.DISPOSED);
			}
			unbindWidget(element, (W) element.getWidget());

			IEclipseContext ctx = (IEclipseContext) element.getTransientData().get(RENDERING_CONTEXT_KEY);
			ctx.dispose();
			element.getTransientData().remove(RENDERING_CONTEXT_KEY);
		}

		if (element.getVisibleWhen() != null) {
			this.visibleWhenElements.remove(element);
		}
	}

	private void unbindWidget(@NonNull M me, @NonNull W widget) {
		widget.setDomElement(null);
		me.setWidget(null);
	}

	@SuppressWarnings("null")
	@Override
	public void bindWidget(@NonNull M me, @NonNull W widget) {
		widget.setDomElement(me);
		widget.addStyleClasses(this.modelStylingService.getStyles(me));

		EObject eo = (EObject) me;
		widget.addStyleClasses("M" + eo.eClass().getName()); //$NON-NLS-1$

		for (EClass e : eo.eClass().getEAllSuperTypes()) {
			widget.addStyleClasses("M" + e.getName()); //$NON-NLS-1$
		}

		String elementId = me.getElementId();
		if (elementId != null) {
			widget.setStyleId(Util.toCSSId(elementId));
		}
		me.setWidget(widget);
	}

	@SuppressWarnings("all")
	@Override
	public void postProcess(@NonNull M element) {
		if (element.getWidget() instanceof WWidget<?>) {
			((WWidget<?>) element.getWidget()).setWidgetState(WidgetState.CREATED);
		}
	}

	@SuppressWarnings("all")
	@Override
	public void preDestroy(@NonNull M element) {
		if (element.getWidget() instanceof WWidget<?>) {
			((WWidget<?>) element.getWidget()).setWidgetState(WidgetState.IN_TEAR_DOWN);
		}
	}

	/**
	 * @return get the presentation engine
	 */
	@NonNull
	protected IPresentationEngine getPresentationEngine() {
		IPresentationEngine p = this._context.get(IPresentationEngine.class);
		if (p == null) {
			throw new IllegalStateException("IPresentationEngine not available"); //$NON-NLS-1$
		}
		return p;
	}

	/**
	 * Get the widgets class
	 *
	 * @param element
	 *            the widget class
	 * @return the widget class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends W> getWidgetClass(@NonNull M element);

	/**
	 * Create a widget for the model element through the
	 * {@link IPresentationEngine#createGui(MUIElement)}
	 *
	 * @param pm
	 *            the model element
	 * @param <LW>
	 *            the widget type
	 * @param <PM>
	 *            the model type
	 * @return the widget
	 */
	@SuppressWarnings("unchecked")
	@Nullable
	protected <LW extends WWidget<PM>, PM extends MUIElement> LW engineCreateWidget(@NonNull PM pm) {
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
	 * @param <LW>
	 *            the widget type
	 * @param <PM>
	 *            the model type
	 * @return the widget
	 */
	@SuppressWarnings("unchecked")
	@Nullable
	protected <LW extends WWidget<PM>, PM extends MUIElement> LW engineCreateWidget(@NonNull PM pm, @NonNull IEclipseContext context) {
		return (LW) getPresentationEngine().createGui(pm, null, context);
	}

	/**
	 * Get the rendering context of the element
	 *
	 * @param element
	 *            the element
	 * @return the context
	 */
	@SuppressWarnings("static-method")
	@Nullable
	protected IEclipseContext getRenderingContext(@NonNull MUIElement element) {
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
	@Nullable
	protected IEclipseContext getContextForParent(@NonNull MUIElement element) {
		return this.modelService.getContainingContext(element);
	}

	@Override
	@Nullable
	public IEclipseContext getModelContext(@NonNull MUIElement element) {
		if (element instanceof MContext) {
			return ((MContext) element).getContext();
		}
		return getContextForParent(element);
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
	protected void activate(@NonNull MPart element, boolean requiresFocus) {
		IEclipseContext curContext = getModelContext(element);
		if (curContext != null) {
			EPartService ps = (EPartService) curContext.get(EPartService.class.getName());
			if (ps != null)
				ps.activate(element, requiresFocus);
		}
	}

	@Override
	public final void processContent(@NonNull M element) {
		try {
			this.contentProcessing.put(element, Boolean.TRUE);
			doProcessContent(element);
		} finally {
			this.contentProcessing.remove(element);
		}
	}

	/**
	 * Check the visible when expression
	 *
	 * @param item
	 *            the item
	 * @param context
	 *            the context
	 * @return <code>true</code> if visible
	 */
	public static boolean checkVisibleWhen(MUIElement item, IEclipseContext context) {
		if (item.getVisibleWhen() != null && item.getVisibleWhen() instanceof MCoreExpression) {
			ExpressionContext exprContext = new ExpressionContext(context.getActiveLeaf());
			boolean value = ContributionsAnalyzer.isVisible((MCoreExpression) item.getVisibleWhen(), exprContext);
			item.getTransientData().put(CURRENT_VISIBLE_WHEN, Boolean.valueOf(value));
			return value;
		}

		return true;
	}

	/**
	 * Get the last calculated visible when state or calculates one
	 *
	 * @param item
	 *            the item
	 * @param context
	 *            the context
	 * @return the current visible when status
	 */
	public static boolean getVisibleWhen(MUIElement item, IEclipseContext context) {
		if (item.getVisibleWhen() != null) {
			if (item.getTransientData().get(CURRENT_VISIBLE_WHEN) != null) {
				return ((Boolean) item.getTransientData().get(CURRENT_VISIBLE_WHEN)).booleanValue();
			}
			return checkVisibleWhen(item, context);
		}
		return true;
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
	protected final int getRenderedIndex(@NonNull MUIElement parent, @NonNull MUIElement element) {
		EObject eElement = (EObject) element;

		EObject container = eElement.eContainer();
		@SuppressWarnings("unchecked")
		List<MUIElement> list = (List<MUIElement>) container.eGet(eElement.eContainmentFeature());
		int idx = 0;
		for (MUIElement u : list) {
			if( u == null ) {
				getLogger().error("Found a null element in " + list); //$NON-NLS-1$
				continue;
			}
			if (isChildRenderedAndVisible(u)) {
				if (u == element) {
					return idx;
				}
				idx++;
			}
		}
		return -1;
	}

	/**
	 * Check if the item is visible and to be rendered
	 *
	 * @param u
	 *            the element
	 * @return <code>true</code> if item is to be shown
	 */
	@Override
	public boolean isChildRenderedAndVisible(@NonNull MUIElement u) {
		return u.isToBeRendered() && u.isVisible() && getVisibleWhen(u, getModelContext(u));
	}

	/**
	 * Process the content of an element
	 *
	 * @param element
	 *            the element
	 */
	protected abstract void doProcessContent(@NonNull M element);

	@Override
	public void focus(@NonNull MUIElement element) {
		if (element.getWidget() instanceof WWidget) {
			WWidget<?> widget = (WWidget<?>) element.getWidget();
			widget.activate();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public W getWidget(@NonNull M element) {
		return (W) element.getWidget();
	}

	// /**
	// * Update all visible when elements
	// */
	// protected void updateVisibleWhen() {
	// for( MUIElement e : this.visibleWhenElements.keySet() ) {
	// getModelContext(e);
	// }
	//
	// }

	class ActiveLeafRunAndTrack extends RunAndTrack {
		RunAndTrack currentActiveLeafRAT;

		final MUIElement element;
		final HashSet<String> variables;
		final IEventBroker broker;

		public ActiveLeafRunAndTrack(MUIElement element, IEventBroker broker) {
			this.element = element;
			this.broker = broker;
			ExpressionInfo info = new ExpressionInfo();
			ContributionsAnalyzer.collectInfo(info, element.getVisibleWhen());
			this.variables = new HashSet<String>(Arrays.asList(info.getAccessedVariableNames()));
		}

		@Override
		public boolean changed(IEclipseContext context) {
			if (BaseRenderer.this.visibleWhenElements.get(this.element) == this) {
				this.currentActiveLeafRAT = new RunAndTrack() {

					@Override
					public boolean changed(IEclipseContext context) {
						if (ActiveLeafRunAndTrack.this.currentActiveLeafRAT == this) {
							for (String v : ActiveLeafRunAndTrack.this.variables) {
								context.get(v);
							}
							ActiveLeafRunAndTrack.this.broker.send(Constants.UPDATE_VISIBLE_WHEN_RESULT, ActiveLeafRunAndTrack.this.element);
							return true;
						} else {
							return false;
						}
					}

				};
				context.getActiveLeaf().runAndTrack(this.currentActiveLeafRAT);
				return true;
			} else {
				this.currentActiveLeafRAT = null;
				return false;
			}
		}
	}
}
