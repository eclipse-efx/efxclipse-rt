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
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.model.application.ui.menu.ItemType;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;
import org.eclipse.e4.ui.workbench.IResourceUtilities;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.ui.workbench.renderers.base.BaseMenuItemRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuItem;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WWidgetImpl;


@SuppressWarnings("restriction")
public class DefMenuItemRenderer extends BaseMenuItemRenderer<MenuItem> {

	@Override
	protected Class<? extends WMenuItem<MenuItem>> getWidgetClass(MMenuItem item) {
		return MenuItemImpl.class;
	}

	public static class MenuItemImpl extends WWidgetImpl<MenuItem, MMenuItem> implements WMenuItem<MenuItem> {
		private ItemType type;
		private Runnable runnable;
		private boolean handled = true;
		private boolean enabled = true;
		
		@Inject
		IResourceUtilities<Image> resourceUtilities;
		
		@Inject
		public MenuItemImpl(@Named("type") ItemType type) {
			this.type = type;
		}
		
		@Override
		protected void bindProperties(MenuItem widget) {
			super.bindProperties(widget);
			if( widget instanceof CheckMenuItem ) {
				bindProperty(UIEvents.Item.SELECTED, ((CheckMenuItem) widget).selectedProperty());
			} else if( widget instanceof RadioMenuItem ) {
				bindProperty(UIEvents.Item.SELECTED, ((RadioMenuItem) widget).selectedProperty());
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
		public void setStyleId(String id) {
			getWidget().setId(id);
		}

		@Override
		protected MenuItem createWidget() {
			MenuItem item = internalCreateWidget();
			item.setMnemonicParsing(true);
			if( item != null ) {
				item.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						if( runnable != null ) {
							runnable.run();
						}
					}
				});
			}
			return item;
		}
		
		private MenuItem internalCreateWidget() {
			switch (type) {
			case CHECK:
				return new CheckMenuItem();
			case RADIO:
				return new RadioMenuItem(null);
			default:
				return new MenuItem();
			}
		}
		
		@Inject
		public void setLabel(@Named(ATTRIBUTE_localizedLabel) String label) {
			getWidget().setText(label);
		}
		
		@Inject
		public void setSelected(@Named(UIEvents.Item.SELECTED) boolean selected) {
			if( getWidget() instanceof CheckMenuItem ) {
				CheckMenuItem c = (CheckMenuItem) getWidget();
				if( c.isSelected() != selected ) {
					c.setSelected(selected);
				}
			} else if( getWidget() instanceof RadioMenuItem ) {
				RadioMenuItem r = (RadioMenuItem) getWidget();
				if( r.isSelected() != selected ) {
					r.setSelected(selected);
				}
			}
		}
		
		@Inject
		public void setEnabled(@Named(UIEvents.Item.ENABLED) boolean enabled) {
			this.enabled = enabled;
			updateEnabledState();
		}
		
		@Inject
		public void setIconURI(@Named(UIEvents.UILabel.ICONURI) String uri) {
			if( uri == null ) {
				getWidget().setGraphic(null);
			} else {
				Image img = resourceUtilities.imageDescriptorFromURI(URI.createURI(uri));
				if( img != null ) {
					getWidget().setGraphic(new ImageView(img));
				} else {
					getWidget().setGraphic(null);
				}
			}
		}

		@Override
		protected void setUserData(WWidgetImpl<MenuItem, MMenuItem> widget) {
			getWidget().setUserData(widget);
		}

		@Override
		public void setOnActionCallback(Runnable runnable) {
			this.runnable = runnable;
		}
		
		@Override
		public void setHandled(boolean handled) {
			if( this.handled != handled ) {
				this.handled = handled;
				updateEnabledState();	
			}
		}
		
		private void updateEnabledState() {
			getWidget().setDisable(!(handled && enabled));
		}
	}
}
