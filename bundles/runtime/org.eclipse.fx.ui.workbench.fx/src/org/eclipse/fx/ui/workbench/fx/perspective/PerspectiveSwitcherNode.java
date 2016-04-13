/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.fx.perspective;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MHandlerContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.EventTags;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.core.command.CommandService;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.workbench.fx.EMFUri;
import org.osgi.service.event.Event;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;

/**
 * Node who displays {@link MPerspective}s
 */
public class PerspectiveSwitcherNode extends HBox {

	private final EPartService partService;
	private final GraphicsLoader loader;
	private final MPerspectiveStack stack;
	private final boolean hasDialogButton;

	private static final String STYLESHEET_URL = PerspectiveSwitcherNode.class.getResource("default.css").toExternalForm(); //$NON-NLS-1$

	@Inject
	PerspectiveSwitcherNode(IEventBroker eventBroker, GraphicsLoader loader, MApplication application, MWindow window, MHandlerContainer handlerContainer, EPartService partService, EModelService modelService, CommandService commandService) {
		getStyleClass().add("perspective-switcher"); //$NON-NLS-1$
		this.loader = loader;
		this.partService = partService;
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT, this::handleSelectedElement);
		eventBroker.subscribe(UIEvents.UIElement.TOPIC_TOBERENDERED, this::handledRendered);

		Button dialogbutton = new Button();
		dialogbutton.getStyleClass().add("dialog-opener"); //$NON-NLS-1$

		String commandId = handlerContainer.getHandlers().stream().filter(h -> h.getContributionURI().endsWith("org.eclipse.fx.ui.workbench.fx.perspective.SwitchPerspectiveDialogHandler")) //$NON-NLS-1$
				.findFirst().map(h -> h.getCommand().getElementId()).orElse(null);

		if (commandId == null) {
			commandId = window.getHandlers().stream().filter(h -> h.getContributionURI().endsWith("org.eclipse.fx.ui.workbench.fx.perspective.SwitchPerspectiveDialogHandler")) //$NON-NLS-1$
					.findFirst().map(h -> h.getCommand().getElementId()).orElse(null);
		}

		if (commandId == null) {
			commandId = application.getHandlers().stream().filter(h -> h.getContributionURI().endsWith("org.eclipse.fx.ui.workbench.fx.perspective.SwitchPerspectiveDialogHandler")) //$NON-NLS-1$
					.findFirst().map(h -> h.getCommand().getElementId()).orElse(null);
		}

		if (commandId != null) {
			String fCommandId = commandId;
			dialogbutton.setOnAction(e -> {
				commandService.execute(fCommandId, Collections.emptyMap());
			});
			getChildren().add(dialogbutton);
			this.hasDialogButton = true;
		} else {
			this.hasDialogButton = false;
		}

		if (window.getChildren().get(0) instanceof MPerspectiveStack) {
			this.stack = (MPerspectiveStack) window.getChildren().get(0);
		} else {
			this.stack = null;
		}

		if (this.stack != null) {
			MPerspective selected = this.stack.getSelectedElement();
			getChildren().addAll(this.stack.getChildren().stream().filter(p -> p.isToBeRendered()).map(p -> new PerspectiveButton(loader, p, partService, p == selected)).collect(Collectors.toList()));
		}
	}

	@Override
	public String getUserAgentStylesheet() {
		return STYLESHEET_URL;
	}

	private void handleSelectedElement(Event event) {
		if (event.getProperty(EventTags.ELEMENT) == this.stack) {
			MPerspective p = (MPerspective) event.getProperty(EventTags.NEW_VALUE);
			getChildren().stream().filter(n -> n instanceof PerspectiveButton).map(n -> (PerspectiveButton) n).forEach(b -> b.setSelected(b.perspective == p));
		}
	}

	private void handledRendered(Event event) {
		if (event.getProperty(EventTags.ELEMENT) instanceof MPerspective) {
			MPerspective p = (MPerspective) event.getProperty(EventTags.ELEMENT);
			if ((MUIElement) p.getParent() == this.stack) {
				if (p.isToBeRendered()) {
					PerspectiveButton b = new PerspectiveButton(this.loader, p, this.partService, this.stack.getSelectedElement() == p);
					List<MPerspective> visibleList = this.stack.getChildren().stream().filter(pp -> pp.isToBeRendered()).collect(Collectors.toList());
					getChildren().add(visibleList.indexOf(p) + (this.hasDialogButton ? 1 : 0), b);
				} else {
					getChildren().removeIf(b -> b instanceof PerspectiveButton && ((PerspectiveButton) b).perspective == p);
				}
			}
		}
	}

	static class PerspectiveButton extends ToggleButton {
		final MPerspective perspective;

		public PerspectiveButton(GraphicsLoader loader, MPerspective perspective, EPartService service, boolean toggled) {
			setSelected(toggled);
			getStyleClass().add("perspective-button"); //$NON-NLS-1$
			// FIXME React on perspective renaming and locale changes!
			setText(perspective.getLocalizedLabel());
			// FIXME React in URL change
			if (perspective.getIconURI() != null) {
				URI uri = URI.createURI(perspective.getIconURI());
				setGraphic(loader.getGraphicsNode(new EMFUri(uri)));
			}
			this.perspective = perspective;
			setOnAction(e -> {
				service.switchPerspective(perspective);
			});
		}
	}
}