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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Button;
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

import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.fx.ui.workbench.renderers.base.BasePartMenuRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WWidgetImpl;


@SuppressWarnings("restriction")
public class DefPartMenuRenderer extends BasePartMenuRenderer<Control> {

	@Override
	protected Class<? extends WMenu<Control>> getWidgetClass(MMenu element) {
		return MenuImpl.class;
	}

	public static class MenuImpl extends WWidgetImpl<Control, MMenu> implements WMenu<Control> {
		private ContextMenu menu;
		private ToggleGroup group;
		Runnable showingCallback;
		
		@Override
		public void addStyleClasses(List<String> classnames) {
			getWidget().getStyleClass().addAll(classnames);
		}

		@Override
		public void addStyleClasses(String... classnames) {
			getWidget().getStyleClass().addAll(classnames);
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
			
			if( widget.getWidget() instanceof Toggle ) {
				if( group == null ) {
					group = new ToggleGroup();
				}
				// see http://javafx-jira.kenai.com/browse/RT-24256
//				group.getToggles().add((Toggle) widget.getWidget());
				((Toggle)widget.getWidget()).setToggleGroup(group);
			}
			getWidget().getContextMenu().getItems().add((MenuItem) widget.getWidget());
		}

		@Override
		public void addElement(int idx, WMenuElement<MMenuElement> widget) {
			if( widget.getWidget() instanceof Toggle ) {
				if( group == null ) {
					group = new ToggleGroup();
				}
				// see http://javafx-jira.kenai.com/browse/RT-24256
//				group.getToggles().add((Toggle) widget.getWidget());
				((Toggle)widget.getWidget()).setToggleGroup(group);
			}
			getWidget().getContextMenu().getItems().add(idx, (MenuItem) widget.getWidget());
		}

		@Override
		public void setShowingCallback(Runnable showingCallback) {
			this.showingCallback = showingCallback;
		}

		@Override
		public void removeElement(WMenuElement<MMenuElement> widget) {
			if( widget.getWidget() instanceof Toggle ) {
				((Toggle)widget.getWidget()).setToggleGroup(null);
			}
			getWidget().getContextMenu().getItems().remove(widget.getWidget());
		}

		@Override
		protected Control createWidget() {
			final Label b = new Label();
			Polygon p = new Polygon(6, 1, 15, 1, 11, 5, 10, 5);
			p.getStyleClass().add("view-menu-button-icon");
			p.setFill(Color.WHITE);
			p.setStroke(Color.BLACK);
			b.setGraphic(p);
			b.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					menu.show(b, Side.BOTTOM, 0, 0);
				}
			});
			menu = new ContextMenu();
			menu.setOnShowing(new EventHandler<WindowEvent>() {
				
				@Override
				public void handle(WindowEvent event) {
					if( showingCallback != null ) {
						showingCallback.run();
					}
				}
			});
			b.setContextMenu(menu);
			return b;
		}		
	}
}