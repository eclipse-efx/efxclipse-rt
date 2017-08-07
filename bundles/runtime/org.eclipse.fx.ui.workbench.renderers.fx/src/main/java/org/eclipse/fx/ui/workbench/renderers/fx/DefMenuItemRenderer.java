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

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.model.application.ui.menu.ItemType;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.core.log.Log;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.ui.controls.JavaFXCompatUtil;
import org.eclipse.fx.ui.keybindings.KeySequence;
import org.eclipse.fx.ui.keybindings.KeyStroke;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.workbench.fx.EMFUri;
import org.eclipse.fx.ui.workbench.renderers.base.BaseMenuItemRenderer;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WMenuItem;
import org.eclipse.fx.ui.workbench.renderers.fx.widget.WWidgetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.osgi.util.NLS;

import com.google.common.base.Strings;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination.ModifierValue;

/**
 * default renderer for {@link MMenuItem}
 */
public class DefMenuItemRenderer extends BaseMenuItemRenderer<MenuItem> {

	@Override
	protected Class<? extends WMenuItem<MenuItem>> getWidgetClass(MMenuItem item) {
		return MenuItemImpl.class;
	}

	static class MenuItemImpl extends WWidgetImpl<MenuItem, MMenuItem> implements WMenuItem<MenuItem> {
		private ItemType type;
		Runnable runnable;
		private boolean handled = true;
		private boolean enabled = true;

		@Inject
		GraphicsLoader graphicsLoader;

		@Inject @Log
		private Logger logger;

		@Inject
		public MenuItemImpl(@Named("type") ItemType type) {
			this.type = type;
		}

		@SuppressWarnings("null")
		@Override
		protected void bindProperties(MenuItem widget) {
			super.bindProperties(widget);
			if (widget instanceof CheckMenuItem) {
				bindProperty(UIEvents.Item.SELECTED, ((CheckMenuItem) widget).selectedProperty());
			} else if (widget instanceof RadioMenuItem) {
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
		protected MenuItem createWidget() {
			final MenuItem item = internalCreateWidget();
			item.setMnemonicParsing(true);
			final AtomicBoolean skip = new AtomicBoolean(false);
			item.setOnMenuValidation(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					if (!item.isDisable()) {
						skip.set(true);
					}
				}
			});
			item.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// Always skip when called through a keyevent
					if (skip.get()) {
						skip.set(false);
						return;
					}

					if (MenuItemImpl.this.runnable != null) {
						MenuItemImpl.this.runnable.run();
					}
				}
			});
			return item;
		}

		@NonNull
		private MenuItem internalCreateWidget() {
			switch (this.type) {
			case CHECK:
				return new CheckMenuItem();
			case RADIO:
				return new RadioMenuItem(null);
			default:
				return new MenuItem();
			}
		}

		@Inject
		public void setLabel(@Named(UIEvents.UILabel.LOCALIZED_LABEL) String label) {
			getWidget().setText(label);
		}

		@Inject
		public void setSelected(@Named(UIEvents.Item.SELECTED) boolean selected) {
			if (getWidget() instanceof CheckMenuItem) {
				CheckMenuItem c = (CheckMenuItem) getWidget();
				if (c.isSelected() != selected) {
					c.setSelected(selected);
				}
			} else if (getWidget() instanceof RadioMenuItem) {
				RadioMenuItem r = (RadioMenuItem) getWidget();
				if (r.isSelected() != selected) {
					r.setSelected(selected);
				}
			}
		}

		@Inject
		public void setEnabled(@Named(UIEvents.Item.ENABLED) boolean enabled) {
			this.enabled = enabled;
			updateEnabledState();
		}

		@SuppressWarnings("null")
		@Inject
		public void setIconURI(@Named(UIEvents.UILabel.ICONURI) String uri) {
			if (Strings.isNullOrEmpty(uri)) {
				getWidget().setGraphic(null);
			} else {
				getWidget().setGraphic(this.graphicsLoader.getGraphicsNode(new EMFUri(URI.createURI(uri))));
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
			if (this.handled != handled) {
				this.handled = handled;
				updateEnabledState();
			}
		}

		@SuppressWarnings("null")
		@Override
		public void setAccelerator(KeySequence sequence) {
			if (sequence != null && sequence.getKeyStrokes().length == 1) {
				KeyStroke k = sequence.getKeyStrokes()[0];

				KeyCode keyCode = null;
				List<KeyCode> collect = Arrays.asList(KeyCode.values()).stream().filter(code -> {
					return JavaFXCompatUtil.getCode(code) == k.getKeyCode();
				}).collect(Collectors.toList());
				if (collect.size() > 0)
					keyCode = collect.get(0);

				if (keyCode != null) {
					getWidget().setAccelerator(
							new KeyCodeCombination(keyCode, k.hasShiftModifier() ? ModifierValue.DOWN : ModifierValue.ANY, k.hasCtrlModifier() ? ModifierValue.DOWN : ModifierValue.ANY, k.hasAltModifier() ? ModifierValue.DOWN : ModifierValue.ANY, k.hasCommandModifier() ? ModifierValue.DOWN
									: ModifierValue.ANY, ModifierValue.ANY));
				} else {
					String message = NLS.bind("No JavaFX KeyBinding found [keyCode={0}, character={1}]", Integer.valueOf(k.getKeyCode()), Character.valueOf((char) k.getKeyCode())); //$NON-NLS-1$
					this.logger.warning(message);
				}
			} else {
				getWidget().setAccelerator(null);
			}

			// new KeyCharacterCombination
		}

		private void updateEnabledState() {
			getWidget().setDisable(!(this.handled && this.enabled));
		}
	}
}
