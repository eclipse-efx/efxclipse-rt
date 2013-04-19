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
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.advanced.MPlaceholder;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.impl.BasicPackageImpl;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuSeparator;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBarSeparator;
import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
import org.eclipse.e4.ui.model.application.ui.menu.impl.MenuPackageImpl;
import org.eclipse.e4.ui.workbench.UIEvents.UIElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.ui.workbench.base.rendering.AbstractRenderer;
import org.eclipse.fx.ui.workbench.base.rendering.RendererFactory;

@SuppressWarnings("restriction")
public abstract class BaseWorkbenchRendererFactory implements RendererFactory {
	public static final String SHARED_ELEMENTS_MAP = "EFX.RENDERING.SHARED_ELEMENTS_MAP";
	
	private IEclipseContext context;
	
	private BaseWindowRenderer<?> windowRenderer;
	private BaseSashRenderer<?> sashRenderer;
	private BaseMenuBarRenderer<?> menuBarRenderer;
	private BaseTrimBarRenderer<?> trimBarRenderer;
	private BaseToolBarRenderer<?> toolBarRenderer;
	private BaseToolItemRenderer<?> toolItemRenderer;
	private BaseStackRenderer<?, ?, ?> stackRenderer;
	private BasePartRenderer<?,?,?> partRenderer;
	private BaseMenuRenderer<?> menuRenderer;
	private BaseMenuItemRenderer<?> menuItemRenderer;
	private BaseMenuSeparatorRenderer<?> menuSeperatorRenderer;
	private BaseMenuRenderer<?> toolItemMenuRenderer;
	private BasePerspectiveStackRenderer<?, ?, ?> perspectiveStackRenderer;
	private BasePerspectiveRenderer<?> perspectiveRenderer;
	private BasePlaceholderRenderer<?> placeholderRenderer;
	private BaseToolControlRenderer<?> toolcontrolRenderer;
	private BaseToolBarSeparatorRenderer<?> toolbarSeparatorRenderer;
	private BaseAreaRenderer<?> areaRenderer;
	private BasePopupMenuRenderer<?> popupMenuRenderer;
	private BasePartMenuRenderer<?> partMenuRenderer;
	
	@Inject
	public BaseWorkbenchRendererFactory(IEclipseContext context) {
		this.context = context.createChild();
		this.context.set(RendererFactory.class, this);
		this.context.set(SHARED_ELEMENTS_MAP, new HashMap<UIElement, Set<MPlaceholder>>());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <R extends AbstractRenderer<?,?>> R getRenderer(MUIElement modelObject) {
		if( modelObject instanceof MPopupMenu ) {
			if( popupMenuRenderer == null ) {
				popupMenuRenderer = ContextInjectionFactory.make(getPopupMenuRendererClass(), context);
			}
			return (R) popupMenuRenderer;
		} else if( modelObject instanceof MArea ) {
			if( areaRenderer == null ) {
				areaRenderer = ContextInjectionFactory.make(getAreaRendererClass(), context);
			}
			return (R) areaRenderer;
		} else if( modelObject instanceof MWindow ) {
			if( windowRenderer == null ) {
				windowRenderer = make(getWindowRendererClass());
			}
			return (R) windowRenderer;
		} else if( modelObject instanceof MPerspectiveStack ) {
			if( perspectiveStackRenderer == null ) {
				perspectiveStackRenderer = make(getPerspectiveStackRendererClass());
			}
			return (R) perspectiveStackRenderer;
		} else if( modelObject instanceof MPerspective ) {
			if( perspectiveRenderer == null ) {
				perspectiveRenderer = make(getPerspectiveRendererClass());
			}
			return (R) perspectiveRenderer;
		} else if( modelObject instanceof MPartSashContainer ) {
			if( sashRenderer == null ) {
				sashRenderer = make(getSashRendererClass());
			}
			return (R) sashRenderer;
		} else if( modelObject instanceof MMenu ) {
			if( BasicPackageImpl.Literals.WINDOW__MAIN_MENU.equals(((EObject)modelObject).eContainmentFeature()) ) {
				if( menuBarRenderer == null ) {
					menuBarRenderer = make(getMenuBarRendererClass());
				}
				return (R) menuBarRenderer;
			} else if( MenuPackageImpl.Literals.TOOL_ITEM__MENU.equals(((EObject)modelObject).eContainmentFeature()) ) {
				if( toolItemMenuRenderer == null ) {
					toolItemMenuRenderer = make(getToolItemMenuRendererClass());
				}
				return (R) toolItemMenuRenderer;
			} else if( ((EObject)modelObject).eContainer() instanceof MPart && ((MMenu)modelObject).getTags().contains(BasePartRenderer.VIEW_MENU_TAG) ) {
				if( partMenuRenderer == null ) {
					partMenuRenderer = make(getPartMenuRenderer());
				}
				return (R) partMenuRenderer;
			} else {
				if( menuRenderer == null ) {
					menuRenderer = make(getMenuRendererClass());
				}
				return (R) menuRenderer;
			}
		} else if( modelObject instanceof MTrimBar ) {
			if( trimBarRenderer == null ) {
				trimBarRenderer = make(getTrimBarRendererClass());
			}
			return (R) trimBarRenderer;
		} else if( modelObject instanceof MToolBar ) {
			if( toolBarRenderer == null ) {
				toolBarRenderer = make(getToolBarRendererClass());
			}
			return (R) toolBarRenderer;
		} else if( modelObject instanceof MToolItem ) {
			if( toolItemRenderer == null ) {
				toolItemRenderer = make(getToolItemRendererClass());
			}
			return (R) toolItemRenderer;
		} else if( modelObject instanceof MPartStack ) {
			if( stackRenderer == null ) {
				stackRenderer = make(getStackRendererClass());
			}
			return (R) stackRenderer;
		} else if( modelObject instanceof MPart ) {
			if( partRenderer == null ) {
				partRenderer = make(getPartRendererClass());
			}
			return (R) partRenderer;
		} else if( modelObject instanceof MMenuItem ) {
			if( menuItemRenderer == null ) {
				menuItemRenderer = make(getMenuItemRendererClass());
			}
			return (R) menuItemRenderer;
		} else if( modelObject instanceof MMenuSeparator ) {
			if( menuSeperatorRenderer == null ) {
				menuSeperatorRenderer = make(getMenuSeparatorRendererClass());
			}
			return (R) menuSeperatorRenderer;
		} else if( modelObject instanceof MPlaceholder ) {
			if( placeholderRenderer == null ) {
				placeholderRenderer = make(getPlaceholderRendererClass());
			}
			return (R) placeholderRenderer;
		} else if( modelObject instanceof MToolControl ) {
			if(toolcontrolRenderer == null) {
				toolcontrolRenderer = make(getToolcontrolRendererClass());
			}
			return (R) toolcontrolRenderer;
		} else if(modelObject instanceof MToolBarSeparator) {
			if(toolbarSeparatorRenderer == null) {
				toolbarSeparatorRenderer = make(getToolBarSeparatorRendererClass());
			}
			return (R) toolbarSeparatorRenderer;
		}
		
		return null;
	}

	/**
	 * Obtain an instance of the specified renderer and inject it with the context of this factory.
	 * @param rendererClass The renderer class to be instantiated.
	 * @return a new instance of the given renderer class.
	 */
	protected <R extends AbstractRenderer<?,?>> R make(Class<R> rendererClass) {
		return ContextInjectionFactory.make(rendererClass, context);
	}
	
	protected abstract Class<? extends BaseWindowRenderer<?>> getWindowRendererClass();
	protected abstract Class<? extends BaseSashRenderer<?>> getSashRendererClass();
	protected abstract Class<? extends BaseMenuBarRenderer<?>> getMenuBarRendererClass();
	protected abstract Class<? extends BaseTrimBarRenderer<?>> getTrimBarRendererClass();
	protected abstract Class<? extends BaseToolBarRenderer<?>> getToolBarRendererClass();
	protected abstract Class<? extends BaseToolItemRenderer<?>> getToolItemRendererClass();
	protected abstract Class<? extends BaseStackRenderer<?,?,?>> getStackRendererClass();
	protected abstract Class<? extends BasePartRenderer<?,?,?>> getPartRendererClass();
	protected abstract Class<? extends BaseMenuRenderer<?>> getMenuRendererClass();
	protected abstract Class<? extends BaseMenuItemRenderer<?>> getMenuItemRendererClass();
	protected abstract Class<? extends BaseMenuSeparatorRenderer<?>> getMenuSeparatorRendererClass();
	protected abstract Class<? extends BaseMenuRenderer<?>> getToolItemMenuRendererClass();
	protected abstract Class<? extends BasePerspectiveStackRenderer<?, ?, ?>> getPerspectiveStackRendererClass();
	protected abstract Class<? extends BasePerspectiveRenderer<?>> getPerspectiveRendererClass();
	protected abstract Class<? extends BasePlaceholderRenderer<?>> getPlaceholderRendererClass();
	protected abstract Class<? extends BaseToolControlRenderer<?>> getToolcontrolRendererClass();
	protected abstract Class<? extends BaseToolBarSeparatorRenderer<?>> getToolBarSeparatorRendererClass();
	protected abstract Class<? extends BaseAreaRenderer<?>> getAreaRendererClass();
	protected abstract Class<? extends BasePopupMenuRenderer<?>> getPopupMenuRendererClass();
	protected abstract Class<? extends BasePartMenuRenderer<?>> getPartMenuRenderer();
}
