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
import org.eclipse.e4.ui.model.application.ui.basic.MCompositePart;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.basic.impl.BasicPackageImpl;
import org.eclipse.e4.ui.model.application.ui.menu.MDynamicMenuContribution;
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
import org.eclipse.fx.ui.workbench.base.rendering.ElementRenderer;
import org.eclipse.fx.ui.workbench.base.rendering.RendererFactory;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Base factory for renderers
 */
@SuppressWarnings("restriction")
public abstract class BaseWorkbenchRendererFactory implements RendererFactory {
	/**
	 * Context key used to store rendererd elements
	 */
	public static final String SHARED_ELEMENTS_MAP = "EFX.RENDERING.SHARED_ELEMENTS_MAP"; //$NON-NLS-1$

	@NonNull
	private final IEclipseContext context;

	@Nullable
	private BaseWindowRenderer<?> windowRenderer;
	@Nullable
	private BaseSashRenderer<?> sashRenderer;
	@Nullable
	private BaseMenuBarRenderer<?> menuBarRenderer;
	@Nullable
	private BaseTrimBarRenderer<?> trimBarRenderer;
	@Nullable
	private BaseToolBarRenderer<?> toolBarRenderer;
	@Nullable
	private BaseToolItemRenderer<?> toolItemRenderer;
	@Nullable
	private BaseStackRenderer<?, ?, ?> stackRenderer;
	@Nullable
	private BasePartRenderer<?, ?, ?> partRenderer;
	@Nullable
	private BaseMenuRenderer<?> menuRenderer;
	@Nullable
	private BaseMenuItemRenderer<?> menuItemRenderer;
	@Nullable
	private BaseMenuSeparatorRenderer<?> menuSeperatorRenderer;
	@Nullable
	private BaseMenuRenderer<?> toolItemMenuRenderer;
	@Nullable
	private BasePerspectiveStackRenderer<?, ?, ?> perspectiveStackRenderer;
	@Nullable
	private BasePerspectiveRenderer<?> perspectiveRenderer;
	@Nullable
	private BasePlaceholderRenderer<?> placeholderRenderer;
	@Nullable
	private BaseToolControlRenderer<?> toolcontrolRenderer;
	@Nullable
	private BaseToolBarSeparatorRenderer<?> toolbarSeparatorRenderer;
	@Nullable
	private BaseAreaRenderer<?> areaRenderer;
	@Nullable
	private BasePopupMenuRenderer<?> popupMenuRenderer;
	@Nullable
	private BasePartMenuRenderer<?> partMenuRenderer;
	@Nullable
	private BaseCompositePartRenderer<?> compositePartRenderer;

	/**
	 * Create a new instance of the renderer factory
	 * 
	 * @param context
	 *            the context
	 */
	@SuppressWarnings("null")
	@Inject
	public BaseWorkbenchRendererFactory(@NonNull IEclipseContext context) {
		this.context = context.createChild();
		this.context.set(RendererFactory.class, this);
		this.context.set(SHARED_ELEMENTS_MAP, new HashMap<UIElement, Set<MPlaceholder>>());
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R extends ElementRenderer<?, ?>> R getRenderer(MUIElement modelObject) {
		if(modelObject instanceof MCompositePart) {
			if (this.compositePartRenderer == null) {
				this.compositePartRenderer = make(getCompositePartRendererClass());
			}
			return (R) this.compositePartRenderer;
		} else if (modelObject instanceof MPopupMenu) {
			if (this.popupMenuRenderer == null) {
				this.popupMenuRenderer = make(getPopupMenuRendererClass());
			}
			return (R) this.popupMenuRenderer;
		} else if (modelObject instanceof MArea) {
			if (this.areaRenderer == null) {
				this.areaRenderer = make(getAreaRendererClass());
			}
			return (R) this.areaRenderer;
		} else if (modelObject instanceof MWindow) {
			if (this.windowRenderer == null) {
				this.windowRenderer = make(getWindowRendererClass());
			}
			return (R) this.windowRenderer;
		} else if (modelObject instanceof MPerspectiveStack) {
			if (this.perspectiveStackRenderer == null) {
				this.perspectiveStackRenderer = make(getPerspectiveStackRendererClass());
			}
			return (R) this.perspectiveStackRenderer;
		} else if (modelObject instanceof MPerspective) {
			if (this.perspectiveRenderer == null) {
				this.perspectiveRenderer = make(getPerspectiveRendererClass());
			}
			return (R) this.perspectiveRenderer;
		} else if (modelObject instanceof MPartSashContainer) {
			if (this.sashRenderer == null) {
				this.sashRenderer = make(getSashRendererClass());
			}
			return (R) this.sashRenderer;
		} else if (modelObject instanceof MMenu) {
			if (BasicPackageImpl.Literals.WINDOW__MAIN_MENU.equals(((EObject) modelObject).eContainmentFeature())) {
				if (this.menuBarRenderer == null) {
					this.menuBarRenderer = make(getMenuBarRendererClass());
				}
				return (R) this.menuBarRenderer;
			} else if (MenuPackageImpl.Literals.TOOL_ITEM__MENU.equals(((EObject) modelObject).eContainmentFeature())) {
				if (this.toolItemMenuRenderer == null) {
					this.toolItemMenuRenderer = make(getToolItemMenuRendererClass());
				}
				return (R) this.toolItemMenuRenderer;
			} else if (((EObject) modelObject).eContainer() instanceof MPart && ((MMenu) modelObject).getTags().contains(BasePartRenderer.VIEW_MENU_TAG)) {
				if (this.partMenuRenderer == null) {
					this.partMenuRenderer = make(getPartMenuRendererClass());
				}
				return (R) this.partMenuRenderer;
			} else {
				if (this.menuRenderer == null) {
					this.menuRenderer = make(getMenuRendererClass());
				}
				return (R) this.menuRenderer;
			}
		} else if (modelObject instanceof MTrimBar) {
			if (this.trimBarRenderer == null) {
				this.trimBarRenderer = make(getTrimBarRendererClass());
			}
			return (R) this.trimBarRenderer;
		} else if (modelObject instanceof MToolBar) {
			if (this.toolBarRenderer == null) {
				this.toolBarRenderer = make(getToolBarRendererClass());
			}
			return (R) this.toolBarRenderer;
		} else if (modelObject instanceof MToolItem) {
			if (this.toolItemRenderer == null) {
				this.toolItemRenderer = make(getToolItemRendererClass());
			}
			return (R) this.toolItemRenderer;
		} else if (modelObject instanceof MPartStack) {
			if (this.stackRenderer == null) {
				this.stackRenderer = make(getStackRendererClass());
			}
			return (R) this.stackRenderer;
		} else if (modelObject instanceof MPart) {
			if (this.partRenderer == null) {
				this.partRenderer = make(getPartRendererClass());
			}
			return (R) this.partRenderer;
		} else if (modelObject instanceof MMenuItem && !(modelObject instanceof MDynamicMenuContribution)) {
			if (this.menuItemRenderer == null) {
				this.menuItemRenderer = make(getMenuItemRendererClass());
			}
			return (R) this.menuItemRenderer;
		} else if (modelObject instanceof MMenuSeparator) {
			if (this.menuSeperatorRenderer == null) {
				this.menuSeperatorRenderer = make(getMenuSeparatorRendererClass());
			}
			return (R) this.menuSeperatorRenderer;
		} else if (modelObject instanceof MPlaceholder) {
			if (this.placeholderRenderer == null) {
				this.placeholderRenderer = make(getPlaceholderRendererClass());
			}
			return (R) this.placeholderRenderer;
		} else if (modelObject instanceof MToolControl) {
			if (this.toolcontrolRenderer == null) {
				this.toolcontrolRenderer = make(getToolcontrolRendererClass());
			}
			return (R) this.toolcontrolRenderer;
		} else if (modelObject instanceof MToolBarSeparator) {
			if (this.toolbarSeparatorRenderer == null) {
				this.toolbarSeparatorRenderer = make(getToolBarSeparatorRendererClass());
			}
			return (R) this.toolbarSeparatorRenderer;
		}

		return null;
	}

	/**
	 * Obtain an instance of the specified renderer and inject it with the
	 * context of this factory.
	 * 
	 * @param rendererClass
	 *            The renderer class to be instantiated.
	 * @param <R> the renderer type
	 * @return a new instance of the given renderer class.
	 */
	@NonNull
	protected <@NonNull R extends ElementRenderer<?, ?>> R make(Class<R> rendererClass) {
		return ContextInjectionFactory.make(rendererClass, this.context);
	}

	/**
	 * @return the window renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseWindowRenderer<?>> getWindowRendererClass();

	/**
	 * @return the sash renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseSashRenderer<?>> getSashRendererClass();

	/**
	 * @return the menubar renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseMenuBarRenderer<?>> getMenuBarRendererClass();

	/**
	 * @return the trimbar renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseTrimBarRenderer<?>> getTrimBarRendererClass();

	/**
	 * @return the toolbar renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseToolBarRenderer<?>> getToolBarRendererClass();

	/**
	 * @return the tool item renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseToolItemRenderer<?>> getToolItemRendererClass();

	/**
	 * @return the stack renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseStackRenderer<?, ?, ?>> getStackRendererClass();

	/**
	 * @return the part renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BasePartRenderer<?, ?, ?>> getPartRendererClass();

	/**
	 * @return the menu renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseMenuRenderer<?>> getMenuRendererClass();

	/**
	 * @return the menu item renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseMenuItemRenderer<?>> getMenuItemRendererClass();

	/**
	 * @return the menu separator renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseMenuSeparatorRenderer<?>> getMenuSeparatorRendererClass();

	/**
	 * @return the tool item menu renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseMenuRenderer<?>> getToolItemMenuRendererClass();

	/**
	 * @return the perspective stack renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BasePerspectiveStackRenderer<?, ?, ?>> getPerspectiveStackRendererClass();

	/**
	 * @return the perspective renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BasePerspectiveRenderer<?>> getPerspectiveRendererClass();

	/**
	 * @return the placeholder renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BasePlaceholderRenderer<?>> getPlaceholderRendererClass();

	/**
	 * @return the toolcontrol renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseToolControlRenderer<?>> getToolcontrolRendererClass();

	/**
	 * @return the toolbar separator renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseToolBarSeparatorRenderer<?>> getToolBarSeparatorRendererClass();

	/**
	 * @return the area renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseAreaRenderer<?>> getAreaRendererClass();

	/**
	 * @return the popup menu renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BasePopupMenuRenderer<?>> getPopupMenuRendererClass();

	/**
	 * @return the part menu renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BasePartMenuRenderer<?>> getPartMenuRendererClass();
	/**
	 * @return the composite part renderer class
	 */
	@NonNull
	protected abstract Class<@NonNull ? extends BaseCompositePartRenderer<?>> getCompositePartRendererClass();
}
