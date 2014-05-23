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
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MGenericStack;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.workbench.base.rendering.ElementRenderer;
import org.eclipse.fx.ui.workbench.base.rendering.RendererFactory;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPerspectiveStack;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPerspectiveStack.WStackItem;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPlaceholderWidget;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * Base renderer of {@link MPerspectiveStack}
 * 
 * @param <N>
 *            the native widget type
 * @param <I>
 *            the item type
 * @param <IC>
 *            the native item content widget type
 */
public abstract class BasePerspectiveStackRenderer<N, I, IC> extends BaseRenderer<MPerspectiveStack, WPerspectiveStack<N, I, IC>> {
	@Inject
	RendererFactory factory;

	boolean inLazyInit;

	@PostConstruct
	void init(IEventBroker eventBroker) {
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MPerspectiveStack) {
					MPerspectiveStack parent = (MPerspectiveStack) changedObj;
					if (BasePerspectiveStackRenderer.this == parent.getRenderer()) {
						if (UIEvents.isADD(event)) {
							handleChildrenAddition(parent, Util.<MPerspective> asCollection(event, UIEvents.EventTags.NEW_VALUE));
						} else if (UIEvents.isREMOVE(event)) {
							handleChildrenRemove(parent, Util.<MPerspective> asCollection(event, UIEvents.EventTags.OLD_VALUE));
						}
					}
				}
			}
		});
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MPerspectiveStack) {
					MPerspectiveStack parent = (MPerspectiveStack) changedObj;
					if (BasePerspectiveStackRenderer.this == parent.getRenderer()) {
						String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
						if (UIEvents.EventTypes.SET.equals(eventType)) {
							MUIElement newValue = (MUIElement) event.getProperty(UIEvents.EventTags.NEW_VALUE);
							MUIElement oldValue = (MUIElement) event.getProperty(UIEvents.EventTags.OLD_VALUE);
							handleSelectedElement(parent, (MPerspective) oldValue, (MPerspective) newValue);
						}
					}
				}
			}
		});
		eventBroker.subscribe(UIEvents.UIElement.TOPIC_VISIBLE, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				MUIElement changedObj = (MUIElement) event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj.isToBeRendered()) {
					MUIElement parent = changedObj.getParent();
					// Can be null for e.g. detached windows!!!
					if (parent != null) {
						if (BasePerspectiveStackRenderer.this == parent.getRenderer()) {
							MPerspectiveStack stack = (MPerspectiveStack) parent;
							String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
							if (UIEvents.EventTypes.SET.equals(eventType)) {
								Boolean newValue = (Boolean) event.getProperty(UIEvents.EventTags.NEW_VALUE);
								if (newValue.booleanValue()) {
									// TODO Is childRendered not
									// dangerous to call
									// here??
									childRendered(stack, changedObj);
								} else {
									hideChild(stack, changedObj);
								}
							}
						}
					}
				}
			}
		});
	}

	@Override
	protected void initWidget(final MPerspectiveStack element, final WPerspectiveStack<N, I, IC> widget) {
		super.initWidget(element, widget);
		widget.setMouseSelectedItemCallback(new WCallback<WStackItem<I, IC>, Void>() {

			@Override
			public Void call(WStackItem<I, IC> param) {
				if (param.getDomElement() != null) {
					activatationJob((MPerspective) param.getDomElement(), true);
				}

				return null;
			}
		});
		widget.setKeySelectedItemCallback(new WCallback<WStackItem<I, IC>, Void>() {

			@Override
			public Void call(WStackItem<I, IC> param) {
				if (param.getDomElement() != null) {
					activatationJob((MPerspective) param.getDomElement(), false);
				}

				return null;
			}
		});

		widget.registerActivationCallback(new WCallback<Boolean, Void>() {

			@Override
			public Void call(Boolean param) {
				if (param.booleanValue() && element.getSelectedElement() != null) {
					activatationJob((MPerspective) element.getSelectedElement(), true);
				}
				return null;
			}
		});
	}

	void activatationJob(final MPerspective p, final boolean focus) {
		// nothing to do
	}

	@SuppressWarnings("null")
	@Override
	public void doProcessContent(MPerspectiveStack element) {
		WPerspectiveStack<N, I, IC> stack = getWidget(element);
		if( stack == null ) {
			getLogger().error("The perspective widget for element '"+element+"' is null"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
		List<@NonNull WStackItem<I, IC>> items = new ArrayList<>();
		WStackItem<I, IC> initalItem = null;

		for (MPerspective e : element.getChildren()) {
			// Precreate the rendering context for the subitem
			ElementRenderer<MPerspective, ?> renderer = this.factory.getRenderer(e);
			if (renderer != null && e.isToBeRendered() && e.isVisible()) {
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

		if (element.getSelectedElement() != null) {
			handleSelectedElement(element, null, element.getSelectedElement());
		} else if (!element.getChildren().isEmpty()) {
			// TODO Should this be done through the part service????
			element.setSelectedElement(element.getChildren().get(0));
		}
	}

	@NonNull
	private WStackItem<I, IC> createStackItem(@NonNull WPerspectiveStack<N, I, IC> stack, @NonNull final MPerspective e, ElementRenderer<MPerspective, ?> renderer) {
		IEclipseContext context = renderer.setupRenderingContext(e);
		WStackItem<I, IC> item = ContextInjectionFactory.make(stack.getStackItemClass(), context);
		item.setDomElement(e);
		item.setInitCallback(new WCallback<WStackItem<I, IC>, @Nullable IC>() {

			@SuppressWarnings("unchecked")
			@Override
			public IC call(WStackItem<I, IC> param) {
				BasePerspectiveStackRenderer.this.inLazyInit = true;
				try {
					WLayoutedWidget<MPerspective> widget = engineCreateWidget(e);
					if (widget != null) {
						return (IC) widget.getStaticLayoutNode();
					}
					return null;
				} finally {
					BasePerspectiveStackRenderer.this.inLazyInit = false;
				}
			}
		});
		item.setOnCloseCallback(new WCallback<WStackItem<I, IC>, Boolean>() {

			@Override
			public Boolean call(WStackItem<I, IC> param) {
				return Boolean.valueOf(!handleStackItemClose(e, param));
			}
		});

		return item;
	}

	@SuppressWarnings("null")
	void handleChildrenAddition(@NonNull MPerspectiveStack parent, @NonNull Collection<@NonNull MPerspective> elements) {
		WPerspectiveStack<N, I, IC> stack = getWidget(parent);
		if( stack == null ) {
			getLogger().error("The perspective widget of element '"+parent+"' is null");  //$NON-NLS-1$//$NON-NLS-2$
			return;
		}
		Iterator<MPerspective> i = elements.iterator();
		while (i.hasNext()) {
			MPerspective element = i.next();

			if (element.isToBeRendered() && element.isVisible()) {
				int idx = getRenderedIndex(parent, element);

				ElementRenderer<MPerspective, ?> renderer = this.factory.getRenderer(element);
				WStackItem<I, IC> item = createStackItem(stack, element, renderer);
				stack.addItems(idx, Collections.singletonList(item));
			}
		}
	}

	void handleChildrenRemove(@NonNull MPerspectiveStack parent, @NonNull Collection<MPerspective> elements) {
		Iterator<MPerspective> iterator = elements.iterator();
		while (iterator.hasNext()) {
			MPerspective element = iterator.next();
			if (element.isToBeRendered() && element.isVisible()) {
				hideChild(parent, element);
			}

		}
	}

	void handleSelectedElement(@NonNull MPerspectiveStack parent, @Nullable MPerspective oldElement, @Nullable MPerspective newElement) {
		hideElementRecursive(oldElement);
		if (newElement != null) {
			WPerspectiveStack<N, I, IC> stack = getWidget(parent);
			int idx = 0;
			for (WStackItem<I, IC> i : stack.getItems()) {
				if (i.getDomElement() == newElement) {
					stack.selectItem(idx);
					// TODO Should we do the traversal before???
					showElementRecursive(newElement);
					return;
				}
				idx++;
			}

			// Looks like the child is not part of the UI yet (most likely
			// because it got removed using IPR#removeGUI)
			childRendered(parent, newElement);
			stack.selectItem(parent.getChildren().indexOf(newElement));
			// TODO Should we do the traversal before???
			showElementRecursive(newElement);
		}
	}

	boolean handleStackItemClose(MPerspective e, WStackItem<I, IC> item) {
		return true;
	}

	@SuppressWarnings("null")
	@Override
	public void childRendered(MPerspectiveStack parentElement, MUIElement element) {
		if (this.inLazyInit || inContentProcessing(parentElement) || !element.isVisible()) {
			return;
		}

		WPerspectiveStack<N, I, IC> stack = getWidget(parentElement);
		for (WStackItem<I, IC> i : stack.getItems()) {
			if (i.getDomElement() == element) {
				return;
			}
		}

		int idx = getRenderedIndex(parentElement, element);
		ElementRenderer<MPerspective, ?> renderer = this.factory.getRenderer(element);
		WStackItem<I, IC> item = createStackItem(stack, (MPerspective) element, renderer);
		stack.addItems(idx, Collections.singletonList(item));
	}

	@SuppressWarnings("null")
	@Override
	public void hideChild(MPerspectiveStack container, MUIElement changedObj) {
		WPerspectiveStack<N, I, IC> stack = getWidget(container);
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
			stack.removeItems(Collections.singletonList(item));
		}
	}

	private void hideElementRecursive(@Nullable MUIElement pElement) {
		MUIElement element = pElement;
		if (element == null || element.getWidget() == null) {
			return;
		}

		if (element instanceof MPlaceholder) {
			MPlaceholder ph = (MPlaceholder) element;
			element = ph.getRef();
		}

		// Hide any floating windows
		if (element instanceof MWindow && element.getWidget() != null) {
			element.setVisible(false);
		}

		if (element instanceof MGenericStack<?>) {
			// For stacks only the currently selected elements are being hidden
			MGenericStack<?> container = (MGenericStack<?>) element;
			MUIElement curSel = container.getSelectedElement();
			hideElementRecursive(curSel);
		} else if (element instanceof MElementContainer<?>) {
			MElementContainer<?> container = (MElementContainer<?>) element;
			for (MUIElement childElement : container.getChildren()) {
				hideElementRecursive(childElement);
			}

			// OK, now process detached windows
			if (element instanceof MWindow) {
				for (MWindow w : ((MWindow) element).getWindows()) {
					hideElementRecursive(w);
				}
			} else if (element instanceof MPerspective) {
				for (MWindow w : ((MPerspective) element).getWindows()) {
					hideElementRecursive(w);
				}
			}
		}
	}

	private void showElementRecursive(MUIElement pElement) {
		MUIElement element = pElement;
		if (!element.isToBeRendered()) {
			return;
		}

		if (element instanceof MPlaceholder && element.getWidget() != null) {
			MPlaceholder ph = (MPlaceholder) element;
			MUIElement ref = ph.getRef();

			if (ref.getCurSharedRef() != ph) {
				ref.setCurSharedRef(ph);
				WPlaceholderWidget placeholder = (WPlaceholderWidget) ph.getWidget();
				@SuppressWarnings("unchecked")
				WLayoutedWidget<MUIElement> content = (WLayoutedWidget<MUIElement>) ref.getWidget();
				placeholder.setContent(content);
			}

			element = ref;
		}

		if (element instanceof MContext) {
			IEclipseContext context = ((MContext) element).getContext();
			if (context != null) {
				IEclipseContext newParentContext = this.modelService.getContainingContext(element);
				if (context.getParent() != newParentContext) {
					context.setParent(newParentContext);
				}
			}
		}

		if (element instanceof MWindow && element.getWidget() != null) {
			int visCount = 0;
			for (MUIElement kid : ((MWindow) element).getChildren()) {
				if (kid.isToBeRendered() && kid.isVisible())
					visCount++;
			}
			if (visCount > 0)
				element.setVisible(true);
		}

		if (element instanceof MGenericStack) {
			MGenericStack<?> container = (MGenericStack<?>) element;
			MUIElement curSel = container.getSelectedElement();
			if (curSel == null && container.getChildren().size() > 0) {
				curSel = container.getChildren().get(0);
			}
			if (curSel != null) {
				showElementRecursive(curSel);
			}
		} else if (element instanceof MElementContainer<?>) {
			MElementContainer<?> container = (MElementContainer<?>) element;
			for (MUIElement childElement : container.getChildren().toArray(new MUIElement[0])) {
				showElementRecursive(childElement);
			}

			// OK, now process detached windows
			if (element instanceof MWindow) {
				for (MWindow w : ((MWindow) element).getWindows()) {
					showElementRecursive(w);
				}
			} else if (element instanceof MPerspective) {
				for (MWindow w : ((MPerspective) element).getWindows()) {
					showElementRecursive(w);
				}
			}
		}
	}
}
