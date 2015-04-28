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
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.InjectionException;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.application.ui.MContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindowElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.ISaveHandler;
import org.eclipse.e4.ui.workbench.modeling.IWindowCloseHandler;
import org.eclipse.e4.ui.workbench.modeling.ISaveHandler.Save;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WCallback;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WLayoutedWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WTrimBar;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWidget;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWindow;
import org.eclipse.fx.ui.workbench.services.ELifecycleService;
import org.eclipse.fx.ui.workbench.services.lifecycle.annotation.PreClose;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.event.Event;

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
		@NonNull
		private MWindow element;
		@NonNull
		private WWindow<N> widget;
		
		DefaultSaveHandler(@NonNull MWindow element, @NonNull WWindow<N> widget) {
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

		@SuppressWarnings("null")
		@Override
		public Save[] promptToSave(Collection<MPart> dirtyParts) {
			return BaseWindowRenderer.this.promptToSave(this.element, dirtyParts, this.widget).toArray(new Save[0]);
		}

		@SuppressWarnings("null")
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
	/**
	 * Tag marking a secondary window
	 */
	public static final String TAG_SECONDARY_WINDOW = "secondaryMainWindow"; //$NON-NLS-1$

	@Inject
	@Log
	Logger logger;
	
	@Inject
	ELifecycleService lifecycleService;

	@SuppressWarnings("null")
	@PostConstruct
	void init(@NonNull IEventBroker eventBroker) {
		registerEventListener(eventBroker, UIEvents.Window.TOPIC_X);
		registerEventListener(eventBroker, UIEvents.Window.TOPIC_Y);
		registerEventListener(eventBroker, UIEvents.Window.TOPIC_WIDTH);
		registerEventListener(eventBroker, UIEvents.Window.TOPIC_HEIGHT);
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_LABEL);
		registerEventListener(eventBroker, UIEvents.UILabel.TOPIC_TOOLTIP);
		registerEventListener(eventBroker, UIEvents.UIElement.TOPIC_VISIBLE); // This is to check our own visible flag
		
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_CHILDREN, this::handleChildrenEvent);
		eventBroker.subscribe(UIEvents.Window.TOPIC_WINDOWS, this::handleChildrenEvent);
		EventProcessor.attachVisibleProcessor(eventBroker, this); // this is for our children that come and go
	}

	void handleChildrenEvent(Event event) {
	    Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
        if (changedObj instanceof MWindow) {
            MWindow window = (MWindow) changedObj;
            if (BaseWindowRenderer.this == window.getRenderer()) {
                String eventType = (String) event.getProperty(UIEvents.EventTags.TYPE);
                if (UIEvents.EventTypes.ADD.equals(eventType)) {
                    MUIElement element = (MUIElement) event.getProperty(UIEvents.EventTags.NEW_VALUE);
                    if (element instanceof MWindow) {
                        handleWindowAdd((MWindow) element);
                    } else if (element instanceof MWindowElement) {
                        handleChildAdd(window, (MWindowElement) element);
                    }
                } else if (UIEvents.EventTypes.REMOVE.equals(eventType)) {
                    MUIElement element = (MUIElement) event.getProperty(UIEvents.EventTags.OLD_VALUE);
                    if (element instanceof MWindow) {
                        handleWindowRemove(window, (MWindow) element);
                    } else if (element instanceof MWindowElement) {
                        handleChildRemove(window, (MWindowElement) element);
                    }
                }
            }
        }
	}
	
	void handleWindowAdd(@NonNull MWindow element) {
		engineCreateWidget(element);
	}

	void handleWindowRemove(@NonNull MWindow parent, @NonNull MWindow element) {
	    if (element.isToBeRendered() && element.getWidget() != null) {
            hideChild(parent, element);
	    }
	}

	void handleChildAdd(@NonNull MWindow window, @NonNull MWindowElement element) {
	    if(element.getWidget() != null) {
	        // e.g. detaching something into a new window
	        childRendered(window, element);    
	    } else {
	        engineCreateWidget(element);
	    }
	}

	void handleChildRemove(@NonNull MWindow window, MWindowElement element) {
		if (element.isToBeRendered() && element.getWidget() != null) {
			hideChild(window, element);
		}
	}

	@Override
	protected void initWidget(@NonNull final MWindow element, @NonNull final WWindow<N> widget) {
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
				@Nullable
				IEclipseContext modelContext = getModelContext(element);
				if( modelContext != null ) {
					IWindowCloseHandler closeHandler = modelContext.get(IWindowCloseHandler.class);
					if( closeHandler != null ) {
						boolean close = closeHandler.close(element);
						if( ! close ) {
							return Boolean.FALSE;
						}
					}
					
					if( ! BaseWindowRenderer.this.lifecycleService.validateAnnotation(PreClose.class, element, modelContext) ) {
						return Boolean.FALSE;
					}
				} else {
					BaseWindowRenderer.this.logger.error("No model context attached to " + element); //$NON-NLS-1$
				}
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
		IEclipseContext modelContext = getModelContext(element);
		if( modelContext != null ) {
			modelContext.set(ISaveHandler.class, new DefaultSaveHandler(element, widget));	
		} else {
			getLogger().error("The model context is null which is not expected at this point"); //$NON-NLS-1$
		}
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
	protected abstract Save promptToSave(@NonNull MWindow element, @NonNull MPart dirtyPart, @NonNull WWindow<N> widget);

	@SuppressWarnings("null")
	@Override
	public void doProcessContent(MWindow element) {
		WWindow<N> windowWidget = getWidget(element);

		if( windowWidget == null ) {
			getLogger().error("Could not find widget for '"+element+"'"); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
		
		Object nativeWidget = windowWidget.getWidget();

		element.getContext().set(nativeWidget.getClass().getName(), nativeWidget);
		
		if (element.getMainMenu() != null) {
			WLayoutedWidget<MMenu> menuWidget = engineCreateWidget(element.getMainMenu());
			if (menuWidget != null) {
				windowWidget.setMainMenu(menuWidget);
			}
		}

		if (element instanceof MTrimmedWindow) {
			for (MTrimBar tm : ((MTrimmedWindow) element).getTrimBars()) {
				if (tm.isToBeRendered() && isChildRenderedAndVisible(tm)) {
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
			if (isChildRenderedAndVisible(e)) {
				WLayoutedWidget<MWindowElement> widget = engineCreateWidget(e);
				if (widget != null) {
					windowWidget.addChild(widget);
				} else {
					this.logger.error("Widget for element '"+e+"' should not be null"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}

		for (MWindow w : element.getWindows()) {
			if (isChildRenderedAndVisible(w)) {
				WWidget<MWindow> widget = engineCreateWidget(w);
				if (widget != null) {
					@SuppressWarnings("unchecked")
					WWindow<N> ww = (WWindow<N>) w.getWidget();
					if( ww != null ) {
						windowWidget.addChildWindow(ww);
					} else {
						this.logger.error("Widget for element '"+w+"' should not be null"); //$NON-NLS-1$ //$NON-NLS-2$
					}
				}
			}
		}
	}

	@Override
	public void postProcess(MWindow element) {
		super.postProcess(element);
		// Only top level windows are shown explicitly
		if (((EObject) element).eContainer() instanceof MApplication) {
			if (isChildRenderedAndVisible(element)) {
				WWindow<N> window = getWidget(element);
				if (window != null) {
					window.show();
				}
			}
		}
	}

	@Override
	public void childRendered(MWindow parentElement, MUIElement element) {
		if (inContentProcessing(parentElement)|| ! isChildRenderedAndVisible(element)) {
			return;
		}
		
		if (element instanceof MWindowElement) {
			WWindow<N> window = getWidget(parentElement);
			if (window != null) {
				int idx = getRenderedIndex(parentElement, element);
				@SuppressWarnings("unchecked")
				WLayoutedWidget<MWindowElement> widget = (WLayoutedWidget<MWindowElement>) element.getWidget();
				if( widget != null ) {
					window.addChild(idx, widget);	
				} else {
					this.logger.error("Widget for element '"+element+"' should not be null"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		} else if (element instanceof MWindow) {
			WWindow<N> window = getWidget(parentElement);
			if (window != null) {
				@SuppressWarnings("unchecked")
				WWindow<N> ww = (WWindow<N>) element.getWidget();
				if( ww != null ) {
					window.addChildWindow(ww);	
				} else {
					this.logger.error("Widget for element '"+element+"' should not be null"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		} else if( element instanceof MTrimBar ) {
			MTrimBar tm = (MTrimBar) element;
			WTrimBar<MTrimBar> trimWidget = (WTrimBar<MTrimBar>) element.getWidget();
			WWindow<MWindow> windowWidget = (WWindow<MWindow>) parentElement.getWidget();
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

	@Override
	public void hideChild(MWindow container, MUIElement changedObj) {
		if (changedObj instanceof MWindowElement) {
			WWindow<N> window = getWidget(container);
			if (window != null) {
				@SuppressWarnings("unchecked")
				WLayoutedWidget<MWindowElement> widget = (WLayoutedWidget<MWindowElement>) changedObj.getWidget();
				if( widget != null ) {
					window.removeChild(widget);
				} else {
					this.logger.error("Widget for element '"+changedObj+"' should not be null"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		} else if (changedObj instanceof MWindow) {
			WWindow<N> window = getWidget(container);
			if (window != null) {
				@SuppressWarnings("unchecked")
				WWindow<N> ww = (WWindow<N>) changedObj.getWidget();
				if( ww != null ) {
					window.removeChildWindow(ww);	
				} else {
					this.logger.error("Widget for element '"+changedObj+"' should not be null"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		} else if( changedObj instanceof MTrimBar ) {
			WWindow<N> windowWidget = getWidget(container);
			if( windowWidget != null ) {
				MTrimBar tm = (MTrimBar) changedObj;
				WTrimBar<MTrimBar> trimWidget = (WTrimBar<MTrimBar>) changedObj.getWidget();
				if( trimWidget != null ) {
					trimWidget.addStyleClasses(tm.getSide().name());
					switch (tm.getSide()) {
					case TOP:
						windowWidget.setTopTrim(null);
						break;
					case RIGHT:
						windowWidget.setRightTrim(null);
						break;
					case BOTTOM:
						windowWidget.setBottomTrim(null);
						break;
					case LEFT:
						windowWidget.setLeftTrim(null);
						break;
					default:
						break;
					}
				}
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
