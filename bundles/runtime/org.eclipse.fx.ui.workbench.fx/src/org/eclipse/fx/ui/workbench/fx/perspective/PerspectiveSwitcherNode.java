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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MHandlerContainer;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.UIEvents.EventTags;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.core.command.CommandService;
import org.eclipse.fx.core.preferences.Preference;
import org.eclipse.fx.core.preferences.Value;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.fx.ui.workbench.fx.EMFUri;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.service.event.Event;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;

/**
 * Node who displays {@link MPerspective}s
 */
public class PerspectiveSwitcherNode extends HBox {

	private final EPartService partService;
	private final GraphicsLoader loader;
	private final MPerspectiveStack stack;

	private static final String STYLESHEET_URL = PerspectiveSwitcherNode.class.getResource("default.css").toExternalForm(); //$NON-NLS-1$


	private final Value<List<String>> lastPerspectives;

	@Inject
	PerspectiveSwitcherNode(IEventBroker eventBroker,
			GraphicsLoader loader,
			MApplication application,
			MWindow window,
			MHandlerContainer handlerContainer,
			EPartService partService,
			EModelService modelService,
			CommandService commandService,
			@Preference(key="perspectiveOrder") Value<List<String>> lastPerspectives) {
		getStyleClass().add("perspective-switcher"); //$NON-NLS-1$
		this.lastPerspectives = lastPerspectives;
		this.loader = loader;
		this.partService = partService;
		eventBroker.subscribe(UIEvents.ElementContainer.TOPIC_SELECTEDELEMENT, this::handleSelectedElement);

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
			Separator separator = new Separator();
			separator.setOrientation(Orientation.VERTICAL);
			getChildren().addAll(dialogbutton, separator);
		}

		if (window.getChildren().get(0) instanceof MPerspectiveStack) {
			this.stack = (MPerspectiveStack) window.getChildren().get(0);
		} else {
			this.stack = null;
		}

		if (this.stack != null) {
			MPerspective tmp = this.stack.getSelectedElement();
			if( tmp == null && ! this.stack.getChildren().isEmpty() ) {
				tmp = this.stack.getChildren().get(0);
			}
			MPerspective selected = tmp;
			@Nullable
			List<String> value = lastPerspectives.getValue();
			if( value != null && ! value.isEmpty() ) {
				List<PerspectiveButton> buttonList = this.stack.getChildren().stream()
					.filter( p -> p.isToBeRendered())
					.filter( p -> value.contains(p.getElementId()))
					.map( p -> new PerspectiveButton(loader,p,partService, p == selected))
					.collect(Collectors.toList());
				if( selected != null && ! value.contains(selected.getElementId()) ) {
					buttonList.add(new PerspectiveButton(loader,selected,partService, true));
					publishNewPerspectiveList(selected.getElementId());
				}
				getChildren().addAll(buttonList);
			} else {
				if( selected != null ) {
					getChildren().add(new PerspectiveButton(loader,selected,partService,true));
					publishNewPerspectiveList(selected.getElementId());
				}
			}
		}
	}

	private void publishNewPerspectiveList(String newPerspective) {
		List<String> value = this.lastPerspectives.getValue();
		if( value == null ) {
			value = new ArrayList<>();
		} else {
			value = new ArrayList<>(value);
		}

		if( ! value.contains(newPerspective) ) {
			value.add(newPerspective);
		}
		this.lastPerspectives.publish(value);
	}

	@Override
	public String getUserAgentStylesheet() {
		return STYLESHEET_URL;
	}

	private void handleSelectedElement(Event event) {
		if (event.getProperty(EventTags.ELEMENT) == this.stack) {
			MPerspective p = (MPerspective) event.getProperty(EventTags.NEW_VALUE);

			if( p != null ) {
				getChildren().stream().filter(n -> n instanceof PerspectiveButton).map(n -> (PerspectiveButton) n).forEach(b -> b.setSelected(b.perspective == p));

				if( ! getChildren().stream()
						.filter(n -> n instanceof PerspectiveButton)
						.map(n -> (PerspectiveButton) n)
						.filter( pe -> pe.perspective == p)
						.findFirst()
						.isPresent() ) {
					getChildren().add(new PerspectiveButton(this.loader, p, this.partService, true));
					publishNewPerspectiveList(p.getElementId());
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