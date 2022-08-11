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
package org.eclipse.fx.code.compensator.project.navigator;

import java.nio.file.Path;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.core.URI;

public class FileItem extends PathItem {

	public FileItem(ProjectNavigatorItem parent, Path path) {
		super(parent, path);
	}

	@Override
	public CharSequence getLabel() {
		return path.getName(path.getNameCount()-1).toString();
	}

	@Override
	public URI getIcon() {
		return URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project","css/icons/16/file_obj.png");
	}

	@Override
	public String getOpenCommandId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<ProjectNavigatorItem> getChildren() {
		return FXCollections.emptyObservableList();
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

}
