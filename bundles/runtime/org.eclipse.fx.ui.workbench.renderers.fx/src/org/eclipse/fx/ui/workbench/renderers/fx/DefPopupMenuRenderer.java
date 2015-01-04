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

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.WindowEvent;

import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;
import org.eclipse.fx.ui.workbench.renderers.base.BasePopupMenuRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuElement;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WPopupMenu;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WWidgetImpl;

/**
 * default renderer for {@link MPopupMenu}
 */
public class DefPopupMenuRenderer extends BasePopupMenuRenderer<ContextMenu> {
	@Override
	protected Class<? extends WPopupMenu<ContextMenu>> getWidgetClass(MPopupMenu element) {
		return ContextMenuImpl.class;
	}

	static class ContextMenuImpl extends WWidgetImpl<ContextMenu, MPopupMenu> implements WPopupMenu<ContextMenu> {
		private ToggleGroup group;
		Runnable showingCallback;
		Runnable hidingCallback;
		MenuItem item;

		public ContextMenuImpl() {
			this.item = new MenuItem("<empty>"); //$NON-NLS-1$
			this.item.setDisable(true);
		}

		@Override
		protected ContextMenu createWidget() {
			final ContextMenu m = new ContextMenu();
			m.setOnShowing(new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent event) {
					if (ContextMenuImpl.this.showingCallback != null) {
						ContextMenuImpl.this.showingCallback.run();
					}

					if (getWidget().getItems().size() > 1) {
						getWidget().getItems().remove(ContextMenuImpl.this.item);
					}
				}
			});
			m.setOnHiding(new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent event) {
					// Delay the callback so that the action can be execute
					// before the hiding happens see Bug 451127
					Platform.runLater(() -> {
							if (ContextMenuImpl.this.hidingCallback != null) {
								ContextMenuImpl.this.hidingCallback.run();
							}

							if (getWidget().getItems().isEmpty()) {
								getWidget().getItems().add(ContextMenuImpl.this.item);
							}
					});

				}
			});
			m.getItems().add(this.item);
			return m;
		}

		@Override
		public void setShowingCallback(Runnable showingCallback) {
			this.showingCallback = showingCallback;
		}

		@Override
		public void setHidingCallback(Runnable hidingCallback) {
			this.hidingCallback = hidingCallback;
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
		protected void setUserData(WWidgetImpl<ContextMenu, MPopupMenu> widget) {
			// See http://javafx-jira.kenai.com/browse/RT-25980
			// getWidget().setUserData(widget);
		}
	}
}
