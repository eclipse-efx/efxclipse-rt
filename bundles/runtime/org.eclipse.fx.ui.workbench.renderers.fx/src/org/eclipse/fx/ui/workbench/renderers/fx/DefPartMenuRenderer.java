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

import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.WindowEvent;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.fx.ui.workbench.renderers.base.BasePartMenuRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WWidgetImpl;

/**
 * default renderer for {@link MMenu} on {@link MPart}
 */
public class DefPartMenuRenderer extends BasePartMenuRenderer<Control> {
	private static final String CSS_CLASS_VIEW_MENU_BUTTON_ICON = "view-menu-button-icon"; //$NON-NLS-1$

	@Override
	protected Class<? extends WMenu<Control>> getWidgetClass(MMenu element) {
		return MenuImpl.class;
	}

	static class MenuImpl extends WWidgetImpl<Control, MMenu> implements WMenu<Control> {
		ContextMenu menu;
		private ToggleGroup group;
		Runnable showingCallback;
		Runnable hidingCallback;

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
		protected void setUserData(WWidgetImpl<Control, MMenu> widget) {
			getWidget().setUserData(widget);
		}

		@Override
		public void addElement(WMenuElement<MMenuElement> widget) {

			if (widget.getWidget() instanceof Toggle) {
				if (this.group == null) {
					this.group = new ToggleGroup();
				}
				// see http://javafx-jira.kenai.com/browse/RT-24256
				// group.getToggles().add((Toggle) widget.getWidget());
				((Toggle) widget.getWidget()).setToggleGroup(this.group);
			}
			getWidget().getContextMenu().getItems().add((MenuItem) widget.getWidget());
		}

		@Override
		public void addElement(int idx, WMenuElement<MMenuElement> widget) {
			if (widget.getWidget() instanceof Toggle) {
				if (this.group == null) {
					this.group = new ToggleGroup();
				}
				// see http://javafx-jira.kenai.com/browse/RT-24256
				// group.getToggles().add((Toggle) widget.getWidget());
				((Toggle) widget.getWidget()).setToggleGroup(this.group);
			}
			getWidget().getContextMenu().getItems().add(idx, (MenuItem) widget.getWidget());
		}

		@Override
		public void setShowingCallback(Runnable showingCallback) {
			this.showingCallback = showingCallback;
		}

		@Override
		public void removeElement(WMenuElement<MMenuElement> widget) {
			if (widget.getWidget() instanceof Toggle) {
				((Toggle) widget.getWidget()).setToggleGroup(null);
			}
			getWidget().getContextMenu().getItems().remove(widget.getWidget());
		}

		@Override
		protected Control createWidget() {
			final Label b = new Label();
			Polygon p = new Polygon(6, 1, 15, 1, 11, 5, 10, 5);
			p.getStyleClass().add(CSS_CLASS_VIEW_MENU_BUTTON_ICON);
			p.setFill(Color.WHITE);
			p.setStroke(Color.BLACK);
			b.setGraphic(p);
			b.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					MenuImpl.this.menu.show(b, Side.BOTTOM, 0, 0);
				}
			});
			this.menu = new ContextMenu();
			this.menu.setOnShowing(new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent event) {
					if (MenuImpl.this.showingCallback != null) {
						MenuImpl.this.showingCallback.run();
					}
				}
			});
			this.menu.setOnHiding(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent arg0) {
					if (MenuImpl.this.hidingCallback != null) {
						MenuImpl.this.hidingCallback.run();
					}
				}
			});
			b.setContextMenu(this.menu);
			return b;
		}

		@Override
		public void setHidingCallback(Runnable hidingCallback) {
			this.hidingCallback = hidingCallback;
		}
	}
}