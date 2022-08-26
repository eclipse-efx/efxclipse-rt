/*******************************************************************************
 * Copyright (c) 2010 Siemens AG and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Kai T??dter - initial implementation
 ******************************************************************************/

package org.eclipse.fx.demo.contacts.processors;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledToolItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("restriction")
public class ToolbarThemeProcessor extends AbstractThemeProcessor {

	private final static String PROCESSOR_ID = "org.eclipse.fx.demo.contacts.processors.theme.toolbar";

	@Inject
	@Named("toolbar:org.eclipse.ui.main.toolbar")
	private MTrimBar topBar;
	private MToolBar toolBar;

	@Override
	protected boolean check() {
		if (isAreadyProcessed(PROCESSOR_ID)) {
			return false;
		}
		return topBar != null;
	}

	@Override
	protected void preprocess() {
		toolBar = MMenuFactory.INSTANCE.createToolBar();
		topBar.getChildren().add(toolBar);
	}

	@Override
	protected void processTheme(String name, MCommand switchCommand, MParameter themeId, String iconURI) {
		MHandledToolItem toolItem = MMenuFactory.INSTANCE.createHandledToolItem();
		toolItem.setTooltip(name);
		toolItem.setCommand(switchCommand);
		toolItem.getParameters().add(themeId);
		if (iconURI != null) {
			toolItem.setIconURI(iconURI);
		}
		toolBar.getChildren().add(toolItem);
	}

	@Override
	protected void postprocess() {
	}

	@Override
	protected MApplication getApplication() {
		return (MApplication) (((EObject) topBar).eContainer()).eContainer();
	}
}
