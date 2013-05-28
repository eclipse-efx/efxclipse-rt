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

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.fx.ui.workbench.renderers.base.BaseMenuRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WWidgetImpl;


public class DefMenuRenderer extends BaseMenuRenderer<Menu> {

	@Override
	protected Class<? extends WMenu<Menu>> getWidgetClass(MMenu menu) {
		return MenuImpl.class;
	}

	public static class MenuImpl extends WWidgetImpl<Menu, MMenu> implements WMenu<Menu> {
		private ToggleGroup group;
		Runnable showingCallback;
		
		@Override
		protected Menu createWidget() {
			final Menu m = new Menu();
			m.setMnemonicParsing(true);
			m.setOnShowing(new EventHandler<Event>() {
				
				@Override
				public void handle(Event event) {
					//TODO Work around for JIRA 24505
					if( ! m.isShowing() ) {
						if( showingCallback != null ) {
							showingCallback.run();
						}	
					}
				}
			});
			return m;
		}

		@Override
		public void setShowingCallback(Runnable showingCallback) {
			this.showingCallback = showingCallback;
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
		public void setStyleId(String id) {
			getWidget().setId(id);
		}
		
		@Inject
		public void setLabel(@Named(ATTRIBUTE_localizedLabel)String label) {
			getWidget().setText(label);
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
			getWidget().getItems().add((MenuItem) widget.getWidget());
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
			getWidget().getItems().add(idx, (MenuItem) widget.getWidget());
		}
		
		@Override
		public void removeElement(WMenuElement<MMenuElement> widget) {
			if( widget.getWidget() instanceof Toggle ) {
				((Toggle)widget.getWidget()).setToggleGroup(null);
			}
			getWidget().getItems().remove(widget.getWidget());
		}
		
		@Override
		protected void setUserData(WWidgetImpl<Menu, MMenu> widget) {
			getWidget().setUserData(widget);
		}
	}
}
