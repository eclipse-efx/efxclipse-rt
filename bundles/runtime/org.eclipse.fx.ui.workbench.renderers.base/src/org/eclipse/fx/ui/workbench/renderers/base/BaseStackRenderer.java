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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MCompositePart;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.ui.workbench.base.rendering.ElementRenderer;
import org.eclipse.fx.ui.workbench.base.rendering.RendererFactory;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WStack.WStackItem;
import org.eclipse.fx.ui.workbench.services.ELifecycleService;
import org.eclipse.fx.ui.workbench.services.lifecycle.annotation.PreClose;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * Base renderer for {@link MPartStack}
 *
 * @param <N>
 *            the native widget
 * @param <I>
 *            the item type
 * @param <IC>
 *            the native item content widget type
 */
public abstract class BaseStackRenderer<N, I, IC> extends BaseRenderer<MPartStack, WStack<N, I, IC>> {
	private static final String MAP_ITEM_KEY = "fx.rendering.stackitem"; //$NON-NLS-1$
	/**
	 * Transient tag to inform about a move operation
	 */
	public final static String MAP_MOVE = "fx.rendering.stackitem.move"; //$NON-NLS-1$

	/**
	 * Tag key used to mark a menu as a tab-menu
	 */
	public final static String TAG_TAB_CONTEXT_MENU = "tabmenu"; //$NON-NLS-1$

	@Inject
	RendererFactory factory;

	@Inject
	MApplication application;

	@Inject
	ELifecycleService lifecycleService;

	boolean inLazyInit;

	@PostConstruct
	void init(IEventBroker eventBroker) {
		//TODO Switch to EventProcessor.attachChildProcessor
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MPartStack) {
					MPartStack parent = (MPartStack) changedObj;
					if (BaseStackRenderer.this == parent.getRenderer()) {
						if (UIEvents.isADD(event)) {
							handleChildrenAddition(parent, Util.<MStackElement> asCollection(event, UIEvents.EventTags.NEW_VALUE));
						} else if (UIEvents.isREMOVE(event)) {
							handleChildrenRemove(parent, Util.<MStackElement> asCollection(event, UIEvents.EventTags.OLD_VALUE));
						}
					}
				}
			}
		});
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MPartStack) {
					MPartStack parent = (MPartStack) changedObj;
					if (BaseStackRenderer.this == parent.getRenderer()) {
						String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
						if (UIEvents.EventTypes.SET.equals(eventType)) {
							MUIElement newValue = (MUIElement) event.getProperty(UIEvents.EventTags.NEW_VALUE);
							MUIElement oldValue = (MUIElement) event.getProperty(UIEvents.EventTags.OLD_VALUE);
							handleSelectedElement(parent, (MStackElement) oldValue, (MStackElement) newValue);
						}
					}
				}
			}
		});
		EventProcessor.attachVisibleProcessor(eventBroker, this);
	}

	@Nullable
	MPart getPart(@NonNull MUIElement tmp) {
		MUIElement element = tmp;
		if( element instanceof MPart ) {
			return (MPart) element;
		} else if (element instanceof MPlaceholder) {
			return (MPart) ((MPlaceholder) element).getRef();
		} else if (element instanceof MElementContainer<?>) {
			@SuppressWarnings("unchecked")
			MElementContainer<MUIElement> container = (MElementContainer<MUIElement>) element;
			element = container.getSelectedElement();
			if ((element == null) && !container.getChildren().isEmpty()) {
				element = container.getChildren().get(0);
			}
			if( element != null ) {
				return getPart(element);
			}
			return null;
		} else {
			return (MPart) element;
		}
	}

	@Override
	protected void initWidget(final MPartStack element, final WStack<N, I, IC> widget) {
		super.initWidget(element, widget);
		// widget.setMinMaxState(WMinMaxState.MAXIMIZED);
		widget.setMouseSelectedItemCallback(new WCallback<@NonNull WStackItem<I, IC>, Void>() {

			@Override
			public Void call(WStackItem<I, IC> param) {
				MStackElement domElement = param.getDomElement();
				if (domElement != null) {
					MPart part = getPart(domElement);
					if( part != null ) {
						activatationJob(element, part, true);
					} else {
						getLogger().error("Unable to find part to activate for '"+domElement+"'"); //$NON-NLS-1$ //$NON-NLS-2$
					}
				}

				return null;
			}
		});
		widget.setKeySelectedItemCallback(new WCallback<@NonNull WStackItem<I, IC>, Void>() {

			@Override
			public Void call(WStackItem<I, IC> param) {
				MStackElement domElement = param.getDomElement();
				if (domElement != null) {
					MPart part = getPart(domElement);
					if( part != null ) {
						activatationJob(element, part, false);
					} else {
						getLogger().error("Unable to find part to activate for '"+domElement+"'"); //$NON-NLS-1$ //$NON-NLS-2$
					}
				}

				return null;
			}
		});

		widget.registerActivationCallback(new WCallback<Boolean, Void>() {

			@Override
			public Void call(Boolean param) {
				MStackElement selectedElement = element.getSelectedElement();
				if (param.booleanValue() && selectedElement != null) {
					MPart part = getPart(selectedElement);
					if( part != null ) {
						activatationJob(element, part, true);
					} else {
						getLogger().error("Unable to find part to activate for '"+selectedElement+"'"); //$NON-NLS-1$ //$NON-NLS-2$
					}
				}
				return null;
			}
		});
	}

	void activatationJob(@NonNull MPartStack stackToActivate, final @NonNull MPart p, final boolean focus) {
		if (shouldActivate(stackToActivate)) {
			activate(p, focus);
		}
	}

	private boolean shouldActivate(@NonNull MPartStack stackToActivate) {
		if (inContentProcessing(stackToActivate)) {
			return false;
		}

		if (this.application != null) {
			IEclipseContext applicationContext = this.application.getContext();
			IEclipseContext activeChild = applicationContext.getActiveChild();
			if (activeChild == null || activeChild.get(MWindow.class) != this.application.getSelectedElement() || this.application.getSelectedElement() != this.modelService.getTopLevelWindowFor(stackToActivate)) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("null")
	@Override
	public void doProcessContent(MPartStack element) {
		WStack<N, I, IC> stack = getWidget(element);
		if( stack == null ) {
			getLogger().error("Could not find widget for '"+element+"'");  //$NON-NLS-1$//$NON-NLS-2$
			return;
		}
		List<@NonNull WStackItem<I, IC>> items = new ArrayList<>();
		WStackItem<I, IC> initalItem = null;

		for (MStackElement e : element.getChildren()) {
			// Precreate the rendering context for the subitem
			ElementRenderer<MStackElement, ?> renderer = this.factory.getRenderer(e);
			if (renderer != null && isChildRenderedAndVisible(e)) {
				WStackItem<I, IC> item = createStackItem(stack, e, renderer);
				items.add(item);

				if (e == element.getSelectedElement()) {
					initalItem = item;
				}
			}
		}

		if (!items.isEmpty()) {
			if (initalItem == null || items.size() == 1 || items.get(0) == initalItem) {
				stack.addItems(items);
			} else {
				stack.addItem(initalItem);
				if (items.get(items.size() - 1) == initalItem) {
					stack.addItems(0, items.subList(0, items.size() - 1));
				} else {
					int idx = items.indexOf(initalItem);
					stack.addItems(0, items.subList(0, idx));
					stack.addItems(items.subList(idx + 1, items.size()));
				}

			}
		}

		stack.selectItem(stack.getItems().indexOf(initalItem));

		// Ensure an element is selected see 436659
		if( element.getSelectedElement() == null ) {
			if( ! stack.getItems().isEmpty() ) {
				element.setSelectedElement(stack.getItems().get(0).getDomElement());
			}
		}
	}

	@NonNull
	private WStackItem<I, IC> createStackItem(@NonNull WStack<N, I, IC> stack, final @NonNull MStackElement e, @NonNull ElementRenderer<MStackElement, ?> renderer) {
		IEclipseContext context = renderer.setupRenderingContext(e);
		WStackItem<I, IC> item = ContextInjectionFactory.make(stack.getStackItemClass(), context);
		e.getTransientData().put(MAP_ITEM_KEY, item);
		item.setDomElement(e);
		item.setInitCallback(new WCallback<@NonNull WStackItem<I, IC>, @Nullable IC>() {

			@SuppressWarnings("unchecked")
			@Override
			public IC call(WStackItem<I, IC> param) {
				BaseStackRenderer.this.inLazyInit = true;
				try {
					WLayoutedWidget<MStackElement> widget = engineCreateWidget(e);

					if (widget != null) {
						return (IC) widget.getStaticLayoutNode();
					}
					return null;
				} finally {
					BaseStackRenderer.this.inLazyInit = false;
				}
			}
		});
		item.setOnCloseCallback(new WCallback<@NonNull WStackItem<I, IC>, Boolean>() {

			@Override
			public Boolean call(WStackItem<I, IC> param) {
				return Boolean.valueOf(!handleStackItemClose(e, param));
			}
		});

		return item;
	}


	@SuppressWarnings("null")
	void handleChildrenAddition(MPartStack parent, Collection<MStackElement> elements) {
		WStack<N, I, IC> widget = getWidget(parent);

		if( widget == null ) {
			getLogger().error("Could not find widget for '"+parent+"'");  //$NON-NLS-1$//$NON-NLS-2$
			return;
		}

		Iterator<MStackElement> i = elements.iterator();
		while (i.hasNext()) {
			MStackElement element = (MStackElement) i.next();
			if (isChildRenderedAndVisible(element)) {
				int idx = getRenderedIndex(parent, element);

				ElementRenderer<MStackElement, ?> renderer = this.factory.getRenderer(element);
				if( renderer != null ) {


					WStack<N, I, IC> stack = widget;
					@SuppressWarnings("unchecked")
					WStackItem<I, IC> item = (WStackItem<I, IC>) element.getTransientData().get(MAP_ITEM_KEY);
					if( item == null || ! widget.getStackItemClass().isAssignableFrom(item.getClass()) ) {
						item = createStackItem(widget, element, renderer);
					}

					stack.addItems(idx, Collections.singletonList(item));
				} else {
					getLogger().error("Could not find renderer for '"+element+"'");  //$NON-NLS-1$//$NON-NLS-2$
				}
			}
		}

		//TODO THIS NEEDS TO BE MOVED TO THE CHILD ADDITION HANDLER!!!!
		fixContextHierarchy(elements);

		// Ensure an element is selected see 436659
		if( parent.getSelectedElement() == null ) {
			if( ! widget.getItems().isEmpty() ) {
				parent.setSelectedElement(widget.getItems().get(0).getDomElement());
			}
		}
	}

	void handleChildrenRemove(@NonNull MPartStack parent, Collection<MStackElement> elements) {
		WStack<N, I, IC> parentWidget = getWidget(parent);
		if( parentWidget == null ) {
			getLogger().error("Could not find widget for '"+parent+"'"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}

		// more performant group removal
		ArrayList<MStackElement> list = new ArrayList<MStackElement>(elements);
		MStackElement selectedElement = parent.getSelectedElement();
		if ((selectedElement != null) && (list.contains(selectedElement))) {
			list.remove(selectedElement);
			list.add(selectedElement);// remove and add the selected element to
										// the end
		}

		// build the stack item list out of the model
		List<@NonNull WStackItem<I, IC>> items = transmuteList(parentWidget, list);
		parentWidget.removeItems(items);
		ArrayList<MStackElement> removeOnHideList = new ArrayList<MStackElement>();
		Boolean b = (Boolean) this.application.getContext().get("__efx_engine_shutdown"); //$NON-NLS-1$
		if( b == null || ! b.booleanValue() ) {
			for (MStackElement element : list) {
				if (element.getTags().contains(EPartService.REMOVE_ON_HIDE_TAG)) {
					removeOnHideList.add(element);
				}
				if( ! element.getTransientData().containsKey(MAP_MOVE) ) {
					element.getTransientData().remove(MAP_ITEM_KEY);
				}
			}
			parent.getChildren().removeAll(removeOnHideList);
		}

		checkSelectedElement(parent);
	}

	@NonNull
	private List<@NonNull WStackItem<I, IC>> transmuteList(WStack<N, I, IC> parentWidget, ArrayList<MStackElement> list) {
		ArrayList<@NonNull WStackItem<I, IC>> resultList = new ArrayList<>();
		for (WStackItem<I, IC> item : parentWidget.getItems()) {
			MStackElement domElement = item.getDomElement();
			if (domElement != null && list.contains(domElement) && (domElement.isToBeRendered()) && (isChildRenderedAndVisible(domElement))) {
				resultList.add(item);
			}
		}

		return resultList;
	}

	void handleSelectedElement(final @NonNull MPartStack parent, @Nullable final MStackElement oldElement, @Nullable final MStackElement _newElement) {
		MStackElement newElement = _newElement;

		if( newElement == null ) {
			return;
		}

		WStack<N, I, IC> stack = getWidget(parent);
		if( stack == null ) {
			getLogger().error("Could not find widget for '"+parent+"'"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
		int idx = 0;
		for (WStackItem<I, IC> i : stack.getItems()) {
			if (i.getDomElement() == newElement) {
				stack.selectItem(idx);
				fixContextHierarchy(newElement);
				return;
			}
			idx++;
		}

		// Looks like the child is not part of the UI yet (most likely because
		// it got removed using IPR#removeGUI)
		childRendered(parent, newElement);
		stack.selectItem(parent.getChildren().indexOf(newElement));
		// TODO Should we do the traversal before???
		fixContextHierarchy(newElement);
		activateLeafPart(newElement);
	}

	boolean handleStackItemClose(@NonNull MStackElement e, @NonNull WStackItem<I, IC> item) {
		MPart part = e instanceof MCompositePart ? (MPart) e : getPart(e);
		if( part == null ) {
			getLogger().error("Unable to extract part from '"+e+"'");  //$NON-NLS-1$//$NON-NLS-2$
			return true;
		}

		if (!part.isCloseable()) {
			return false;
		}

		IEclipseContext partContext = part.getContext();
		IEclipseContext parentContext = getContextForParent(part);
		if( parentContext == null ) {
			getLogger().error("The parent context is unknown. This is impossible."); //$NON-NLS-1$
			return false;
		}
		// a part may not have a context if it hasn't been rendered
		IEclipseContext context = (partContext == null ? parentContext : partContext).createChild();
		if (partContext == null) {
			context.set(MPart.class, part);
		}

		// Allow closes to be 'canceled'
		EPartService partService = (EPartService) context.get(EPartService.class.getName());

		try {
			if (partService.savePart(part, true) && this.lifecycleService.validateAnnotation(PreClose.class, part, context)) {
				partService.hidePart(part);
				return true;
			}
			// the user has canceled out of the save operation, so don't close
			// the part
			return false;
		} finally {
			context.dispose();
		}

	}

	@SuppressWarnings("null")
	@Override
	public void childRendered(MPartStack parentElement, MUIElement element) {
		if (element == null || this.inLazyInit || inContentProcessing(parentElement) || !isChildRenderedAndVisible(element)) {
			return;
		}

		WStack<N, I, IC> stack = getWidget(parentElement);
		if( stack ==  null ) {
			getLogger().error("Could not find widget for '"+parentElement+"'"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
		for (WStackItem<I, IC> i : stack.getItems()) {
			if (i.getDomElement() == element) {
				return;
			}
		}

		ElementRenderer<MStackElement, ?> renderer = this.factory.getRenderer(element);
		if( renderer != null ) {
			int idx = getRenderedIndex(parentElement, element);
			stack.addItems(idx, Collections.singletonList(createStackItem(stack, (MStackElement) element, renderer)));
		} else {
			getLogger().error("Could not find renderer for '"+element+"'");  //$NON-NLS-1$//$NON-NLS-2$
		}

	}

	@SuppressWarnings("null")
	@Override
	public void hideChild(MPartStack container, MUIElement changedObj) {
		WStack<N, I, IC> stack = getWidget(container);
		if (stack == null) {
			return;
		}

		WStackItem<I, IC> item = null;

		for (WStackItem<I, IC> i : stack.getItems()) {
			if (i.getDomElement() == changedObj) {
				item = i;
				break;
			}
		}

		if (item != null) {
			List<WStackItem<I, IC>> l = Collections.singletonList(item);
			stack.removeItems(l);
		}

		Boolean b = (Boolean) this.application.getContext().get("__efx_engine_shutdown"); //$NON-NLS-1$
		if ((b == null || ! b.booleanValue()) && changedObj.getTags().contains(EPartService.REMOVE_ON_HIDE_TAG)) {
			container.getChildren().remove(changedObj);
		}
	}
}