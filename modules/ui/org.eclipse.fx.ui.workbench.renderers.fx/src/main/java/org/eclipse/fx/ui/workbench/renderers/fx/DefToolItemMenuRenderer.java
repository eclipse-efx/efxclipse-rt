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
package org.eclipse.fx.ui.workbench.renderers.fx;

import java.util.List;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fx.ui.workbench.renderers.base.BaseMenuRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.BaseRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WToolItem;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.ToolItemMenu;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WWidgetImpl;

/**
 * Default renderer for tool item menus
 */
public class DefToolItemMenuRenderer extends BaseMenuRenderer<ToolItemMenu> {

	@Override
	protected Class<? extends WMenu<ToolItemMenu>> getWidgetClass(MMenu item) {
		return WMenuImpl.class;
	}

	public static class WMenuImpl extends WWidgetImpl<ToolItemMenu, MMenu> implements WMenu<ToolItemMenu> {
		private ToggleGroup group;
		private SplitMenuButton button;
		Runnable showingCallback;
		Runnable hidingCallback;

		@Inject
		public WMenuImpl(@Named(BaseRenderer.CONTEXT_DOM_ELEMENT) MMenu domElement) {
			MToolItem item = (MToolItem) ((EObject) domElement).eContainer();
			@SuppressWarnings("unchecked")
			WToolItem<SplitMenuButton> w = (WToolItem<SplitMenuButton>) item.getWidget();
			this.button = (SplitMenuButton) w.getWidget();
			this.button.showingProperty().addListener(this::handleShowingProperty);
		}

		void handleShowingProperty(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
			if (newValue.booleanValue()) {
				if (this.showingCallback != null) {
					this.showingCallback.run();
				}
			} else {
				if (this.hidingCallback != null) {
					this.hidingCallback.run();
				}
			}
		}

		@Override
		public void addStyleClasses(List<String> classnames) {
			getWidget().getStyleClass().addAll(classnames);
		}

		@Override
		public void addStyleClasses(String... classnames) {
			getWidget().getStyleClass().addAll(classnames);
		}

		@Override
		public void removeStyleClasses(List<String> classnames) {
			getWidget().getStyleClass().removeAll(classnames);
		}

		@Override
		public void removeStyleClasses(String... classnames) {
			getWidget().getStyleClass().removeAll(classnames);
		}

		@Override
		public void setStyleId(String id) {
			getWidget().setId(id);
		}

		@Override
		protected ToolItemMenu createWidget() {
			return new ToolItemMenu(this.button);
		}

		@Override
		protected void setUserData(WWidgetImpl<ToolItemMenu, MMenu> widget) {
			getWidget().setUserData(widget);
		}

		@Inject
		public void setLabel(@Named(UIEvents.UILabel.LOCALIZED_LABEL) String label) {
			getWidget().setText(label);
		}

		@Override
		public void addElement(WMenuElement<MMenuElement> widget) {
			if (widget.getWidget() instanceof Toggle) {
				if (this.group == null) {
					this.group = new ToggleGroup();
				}
				((Toggle) widget.getWidget()).setToggleGroup(this.group);
			}
			getWidget().getItems().add((MenuItem) widget.getWidget());
		}

		@Override
		public void addElement(int idx, WMenuElement<MMenuElement> widget) {
			if (widget.getWidget() instanceof Toggle) {
				if (this.group == null) {
					this.group = new ToggleGroup();
				}
				((Toggle) widget.getWidget()).setToggleGroup(this.group);
			}
			getWidget().getItems().add(idx, (MenuItem) widget.getWidget());
		}

		@Override
		public void removeElement(WMenuElement<MMenuElement> widget) {
			getWidget().getItems().remove(widget.getWidget());
		}

		@Override
		public void setShowingCallback(Runnable showingCallback) {
			this.showingCallback = showingCallback;
		}

		@Override
		public void setHidingCallback(Runnable hidingCallback) {
			this.hidingCallback = hidingCallback;
		}
	}

}