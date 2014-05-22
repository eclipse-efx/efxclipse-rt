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
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.di.InjectionException;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindowElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.ISaveHandler;
import org.eclipse.e4.ui.workbench.modeling.ISaveHandler.Save;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWindow;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * @author tomschindl
 *
 * @param <N>
 */
/**
 * Base renderer for {@link MWindow}
 * 
 * @param <N>
 *            the native widget type
 */
@SuppressWarnings("restriction")
public abstract class BaseWindowRenderer<N> extends BaseRenderer<MWindow, WWindow<N>> {
	// derived from SWT implementation
	private class DefaultSaveHandler implements ISaveHandler {
		private MWindow element;
		private WWindow<N> widget;

		DefaultSaveHandler(MWindow element, WWindow<N> widget) {
			this.element = element;
			this.widget = widget;
		}

		@Override
		public boolean saveParts(Collection<MPart> dirtyParts, boolean confirm) {
			if (confirm) {
				List<MPart> dirtyPartsList = Collections.unmodifiableList(new ArrayList<MPart>(dirtyParts));
				Save[] decisions = promptToSave(dirtyPartsList);
				for (Save decision : decisions) {
					if (decision == Save.CANCEL) {
						return false;
					}
				}

				for (int i = 0; i < decisions.length; i++) {
					if (decisions[i] == Save.YES) {
						if (!save(dirtyPartsList.get(i), false)) {
							return false;
						}
					}
				}
				return true;
			}

			for (MPart dirtyPart : dirtyParts) {
				if (!save(dirtyPart, false)) {
					return false;
				}
			}
			return true;
		}

		@Override
		public boolean save(MPart dirtyPart, boolean confirm) {
			if (confirm) {
				switch (promptToSave(dirtyPart)) {
				case NO:
					return true;
				case CANCEL:
					return false;
				case YES:
					break;
				}
			}

			Object client = dirtyPart.getObject();
			try {
				ContextInjectionFactory.invoke(client, Persist.class, dirtyPart.getContext());
			} catch (InjectionException e) {
				getLogger().error("Failed to persist contents of part", e); //$NON-NLS-1$
				return false;
			} catch (RuntimeException e) {
				getLogger().error("Failed to persist contents of part via DI", e); //$NON-NLS-1$
				return false;
			}
			return true;
		}

		@Override
		public Save[] promptToSave(Collection<MPart> dirtyParts) {
			return BaseWindowRenderer.this.promptToSave(this.element, dirtyParts, this.widget).toArray(new Save[0]);
		}

		@Override
		public Save promptToSave(MPart dirtyPart) {
			return BaseWindowRenderer.this.promptToSave(this.element, dirtyPart, this.widget);
		}
	}

	/**
	 * persisted map key to put window to full screen
	 */
	public static final String KEY_FULL_SCREEN = "efx.window.fullscreen"; //$NON-NLS-1$

	/**
	 * Maximize the shell - provided for SWT-Compat
	 */
	public static final String TAG_SHELLMAXIMIZED = "shellMaximized"; //$NON-NLS-1$

	@Inject
	@Log
	Logger logger;

	@PostConstruct
	void init(IEventBroker eventBroker) {
		registerEventListener(eventBroker, UIEvents.Window.TOPIC_X);
		registerEventListener(eventBroker, UIEvents.Window.TOPIC_Y);
		registerEventListener(eventBroker, UIEvents.Window.TOPIC_WIDTH);
		registerEventListener(eventBroker, UIEvents.Window.TOPIC_HEIGHT);
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_LABEL);
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_TOOLTIP);
		registerEventListener(eventBroker, UIEvents.UIElement.TOPIC_VISIBLE);
		eventBroker.subscribe(UIEvents.Window.TOPIC_WINDOWS, new EventHandler() {

			@Override
			public void handleEvent(Event event) {
				Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
				if (changedObj instanceof MPerspective) {
					MPerspective perspective = (MPerspective) changedObj;
					if (BaseWindowRenderer.this == perspective.getRenderer()) {
						String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
						if (UIEvents.EventTypes.ADD.equals(eventType)) {
							MUIElement element = (MUIElement) event.getProperty(UIEvents.EventTags.NEW_VALUE);
							if (element instanceof MWindow) {
								handleWindowAdd((MWindow) element);
							} else if (element instanceof MWindowElement) {
								handleChildAdd((MWindowElement) element);
							}
						} else if (UIEvents.EventTypes.REMOVE.equals(eventType)) {
							MUIElement element = (MUIElement) event.getProperty(UIEvents.EventTags.OLD_VALUE);
							if (element instanceof MWindow) {
								handleWindowRemove((MWindow) element);
							} else if (element instanceof MWindowElement) {
								handleChildRemove((MWindowElement) element);
							}
						}
					}
				}
			}
		});
	}

	void handleWindowAdd(MWindow element) {
		engineCreateWidget(element);
	}

	void handleWindowRemove(MWindow element) {
		// Nothing to do here
	}

	void handleChildAdd(MWindowElement element) {
		engineCreateWidget(element);
	}

	void handleChildRemove(MWindowElement element) {
		if (element.isToBeRendered() && element.isVisible() && element.getWidget() != null) {
			hideChild((MWindow) (MUIElement) element.getParent(), element);
		}
	}

	@Override
	protected void initWidget(final MWindow element, final WWindow<N> widget) {
		widget.registerActivationCallback(new WCallback<Boolean, Void>() {

			@Override
			public Void call(Boolean param) {
				if (param.booleanValue()) {
					MUIElement parentME = element.getParent();
					if (parentME instanceof MApplication) {
						MApplication app = (MApplication) parentME;
						app.setSelectedElement(element);
						element.getContext().activate();
					} else if (parentME == null) {
						parentME = (MUIElement) ((EObject) element).eContainer();
						if (parentME instanceof MContext) {
							element.getContext().activate();
						}
					}
				}
				return null;
			}
		});
		widget.setOnCloseCallback(new WCallback<WWindow<N>, Boolean>() {

			@Override
			public Boolean call(WWindow<N> param) {
				// TODO Call out to lifecycle

				// Set the render flag for other windows
				// TODO What do we do with: other top-level windows, ...
				MWindow element = param.getDomElement();
				if (element != null && !((MApplicationElement) element.getParent() instanceof MApplication)) {
					element.setToBeRendered(false);
				}
				return Boolean.TRUE;
			}
		});
		getModelContext(element).set(ISaveHandler.class, new DefaultSaveHandler(element, widget));
	}

	/**
	 * Show a prompt to inform the user about dirty parts
	 * 
	 * @param element
	 *            the parent
	 * @param dirtyParts
	 *            the dirty parts
	 * @param widget
	 *            the window widget to use for parenting
	 * @return the result
	 */
	@NonNull
	protected abstract List<@NonNull Save> promptToSave(@NonNull MWindow element, @NonNull Collection<MPart> dirtyParts, @NonNull WWindow<N> widget);

	/**
	 * Show a prompt to inform the user that <b>one</b> part is dirty
	 * 
	 * @param element
	 *            the parent
	 * @param dirtyPart
	 *            the dirty part
	 * @param widget
	 *            the window widget to use for parenting
	 * @return the result
	 */
	protected abstract Save promptToSave(MWindow element, MPart dirtyPart, WWindow<N> widget);

	@Override
	public void doProcessContent(MWindow element) {
		WWindow<N> windowWidget = getWidget(element);

		Object nativeWidget = windowWidget.getWidget();

		if (nativeWidget != null) {
			element.getContext().set(nativeWidget.getClass().getName(), nativeWidget);
		}

		if (element.getMainMenu() != null) {
			WLayoutedWidget<MMenu> menuWidget = engineCreateWidget(element.getMainMenu());
			if (menuWidget != null) {
				windowWidget.setMainMenu(menuWidget);
			}
		}

		if (element instanceof MTrimmedWindow) {
			for (MTrimBar tm : ((MTrimmedWindow) element).getTrimBars()) {
				if (tm.isToBeRendered() && tm.isVisible()) {
					WLayoutedWidget<MTrimBar> trimWidget = engineCreateWidget(tm);
					if (trimWidget != null) {
						trimWidget.addStyleClasses(tm.getSide().name());
						switch (tm.getSide()) {
						case TOP:
							windowWidget.setTopTrim(trimWidget);
							break;
						case RIGHT:
							windowWidget.setRightTrim(trimWidget);
							break;
						case BOTTOM:
							windowWidget.setBottomTrim(trimWidget);
							break;
						case LEFT:
							windowWidget.setLeftTrim(trimWidget);
							break;
						default:
							break;
						}
					}
				}
			}
		}

		for (MWindowElement e : element.getChildren()) {
			if (e.isToBeRendered() && e.isVisible()) {
				WLayoutedWidget<MWindowElement> widget = engineCreateWidget(e);
				if (widget != null) {
					windowWidget.addChild(widget);
				}
			}
		}

		for (MWindow w : element.getWindows()) {
			if (w.isVisible() && w.isToBeRendered()) {
				WWidget<MWindow> widget = engineCreateWidget(w);
				if (widget != null) {
					@SuppressWarnings("unchecked")
					WWindow<N> ww = (WWindow<N>) w.getWidget();
					windowWidget.addChild(ww);
				}
			}
		}
	}

	@Override
	public void postProcess(MWindow element) {
		super.postProcess(element);
		// Only top level windows are shown explicitly
		if (((EObject) element).eContainer() instanceof MApplication) {
			if (element.isVisible()) {
				WWindow<N> window = getWidget(element);
				if (window != null) {
					window.show();
				}
			}
		}
	}

	@Override
	public void childRendered(MWindow parentElement, MUIElement element) {
		if (inContentProcessing(parentElement)) {
			return;
		}

		if (element instanceof MWindowElement) {
			WWindow<N> window = getWidget(parentElement);
			if (window != null) {
				int idx = getRenderedIndex(parentElement, element);
				@SuppressWarnings("unchecked")
				WLayoutedWidget<MWindowElement> widget = (WLayoutedWidget<MWindowElement>) element.getWidget();
				window.addChild(idx, widget);
			}
		} else if (element instanceof MWindow) {
			WWindow<N> window = getWidget(parentElement);
			if (window != null) {
				@SuppressWarnings("unchecked")
				WWindow<N> ww = (WWindow<N>) element.getWidget();
				window.addChild(ww);
			}
		}
	}

	@Override
	public void hideChild(MWindow container, MUIElement changedObj) {
		if (changedObj instanceof MWindowElement) {
			WWindow<N> window = getWidget(container);
			if (window != null) {
				@SuppressWarnings("unchecked")
				WLayoutedWidget<MWindowElement> widget = (WLayoutedWidget<MWindowElement>) changedObj.getWidget();
				window.removeChild(widget);
			}
		} else if (changedObj instanceof MWindow) {
			WWindow<N> window = getWidget(container);
			if (window != null) {
				@SuppressWarnings("unchecked")
				WWindow<N> ww = (WWindow<N>) changedObj.getWidget();
				window.removeChild(ww);
			}
		}
	}

	@Override
	public void destroyWidget(MWindow element) {
		if (element.getWidget() instanceof WWindow<?>) {
			@SuppressWarnings("unchecked")
			WWindow<MWindow> w = (WWindow<MWindow>) element.getWidget();
			w.close();
		}
		super.destroyWidget(element);
	}
}
