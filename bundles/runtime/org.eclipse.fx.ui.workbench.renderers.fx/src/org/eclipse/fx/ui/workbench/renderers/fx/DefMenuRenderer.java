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
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.fx.ui.workbench.renderers.base.BaseMenuRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenu;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WWidgetImpl;

/**
 * default renderer for {@link MMenu}
 */
public class DefMenuRenderer extends BaseMenuRenderer<Menu> {

	@Override
	protected Class<? extends WMenu<Menu>> getWidgetClass(MMenu menu) {
		return MenuImpl.class;
	}

	static class MenuImpl extends WWidgetImpl<Menu, MMenu> implements WMenu<Menu> {
		private ToggleGroup group;
		Runnable showingCallback;
		Runnable hidingCallback;
		MenuItem item;

		@Override
		protected Menu createWidget() {
			final Menu m = new Menu();
			this.item = new MenuItem("<empty>"); //$NON-NLS-1$
			this.item.setDisable(true);
			m.getItems().add(this.item);
			m.setMnemonicParsing(true);
			m.setOnShowing(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					// TODO Work around for JIRA 24505
					if (!m.isShowing()) {
						if (MenuImpl.this.showingCallback != null) {
							MenuImpl.this.showingCallback.run();
						}
					}
					if (getWidget().getItems().size() > 1) {
						getWidget().getItems().remove(MenuImpl.this.item);
					}
				}
			});
			m.setOnHiding(new EventHandler<Event>() {

				@Override
				public void handle(Event arg0) {
					if (MenuImpl.this.hidingCallback != null)
						MenuImpl.this.hidingCallback.run();

					if (getWidget().getItems().isEmpty()) {
						getWidget().getItems().add(MenuImpl.this.item);
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

		@Inject
		public void setLabel(@Named(UIEvents.UILabel.LOCALIZED_LABEL) String label) {
			getWidget().setText(label);
		}

		@Override
		public void addElement(WMenuElement<MMenuElement> widget) {
			if (getWidget().getItems().size() == 1) {
				getWidget().getItems().remove(this.item);
			}

			if (widget.getWidget() instanceof Toggle) {
				if (this.group == null) {
					this.group = new ToggleGroup();
				}
				// see http://javafx-jira.kenai.com/browse/RT-24256
				// group.getToggles().add((Toggle) widget.getWidget());
				((Toggle) widget.getWidget()).setToggleGroup(this.group);
			}
			getWidget().getItems().add((MenuItem) widget.getWidget());
		}

		@Override
		public void addElement(int idx, WMenuElement<MMenuElement> widget) {
			if (getWidget().getItems().size() == 1) {
				getWidget().getItems().remove(this.item);
			}

			if (widget.getWidget() instanceof Toggle) {
				if (this.group == null) {
					this.group = new ToggleGroup();
				}
				// see http://javafx-jira.kenai.com/browse/RT-24256
				// group.getToggles().add((Toggle) widget.getWidget());
				((Toggle) widget.getWidget()).setToggleGroup(this.group);
			}
			getWidget().getItems().add(idx, (MenuItem) widget.getWidget());
		}

		@Override
		public void removeElement(WMenuElement<MMenuElement> widget) {
			if (widget.getWidget() instanceof Toggle) {
				((Toggle) widget.getWidget()).setToggleGroup(null);
			}
			getWidget().getItems().remove(widget.getWidget());
			if (getWidget().getItems().isEmpty()) {
				getWidget().getItems().add(this.item);
			}
		}

		@Override
		protected void setUserData(WWidgetImpl<Menu, MMenu> widget) {
			getWidget().setUserData(widget);
		}

		@Override
		public void setHidingCallback(Runnable hidingCallback) {
			this.hidingCallback = hidingCallback;
		}
	}
}
