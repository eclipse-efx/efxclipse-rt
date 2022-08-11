/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.simplycode.app.parts;

import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.fx.code.editor.services.EditorOpener;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.controls.filesystem.FileItem;
import org.eclipse.fx.ui.controls.filesystem.ResourceEvent;
import org.eclipse.fx.ui.controls.filesystem.ResourceItem;
import org.eclipse.fx.ui.controls.filesystem.ResourceTreeView;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;

import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ProjectExplorer {
	@Inject
	EModelService modelService;

	@Inject
	EPartService partService;

	@Inject
	EditorOpener textEditorOpener;

	@PostConstruct
	public void init(BorderPane p, MApplication application, GraphicsLoader nodeProvider) {
		HBox b = new HBox();
		b.getStyleClass().add("tool-bar");
		b.getChildren().add(new Label("Filesystem Explorer", nodeProvider.getGraphicsNode(URI.createPlatformPluginURI("org.eclipse.fx.simplycode.app","css/icons/16/filenav_nav.png"))));
		p.setTop(b);

		ResourceTreeView viewer = new ResourceTreeView();
		viewer.setRootDirectories(FXCollections.observableArrayList(ResourceItem.createObservedPath(Paths.get("/Users/tomschindl/simply-code/"))));
		viewer.addEventHandler(ResourceEvent.openResourceEvent(), this::handleEvent);
		p.setCenter(viewer);
	}

	private void handleEvent(ResourceEvent<ResourceItem> e) {
		e.getResourceItems()
			.stream()
			.filter( r -> r instanceof FileItem)
			.map( r -> (FileItem)r)
			.forEach(this::handle);
	}

	private void handle(FileItem item) {
		textEditorOpener.openEditor(item.getUri());
	}
}
