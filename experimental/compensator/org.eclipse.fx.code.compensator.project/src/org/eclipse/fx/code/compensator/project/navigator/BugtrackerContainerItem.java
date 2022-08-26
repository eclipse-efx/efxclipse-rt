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

import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.core.URI;

public class BugtrackerContainerItem implements ProjectNavigatorItem {
	private final ProjectItem parent;
	private final ObservableList<ProjectNavigatorItem> bugtrackerItems = FXCollections.observableArrayList();
	
	public BugtrackerContainerItem(ProjectItem parent, InstanceProject project) {
		this.parent = parent;
		bugtrackerItems.addAll(project.getBugtrackerInstanceList().stream().map( i -> i.getService().mapRepository(this, i)).collect(Collectors.toList()));
	}
	
	public ProjectNavigatorItem getParent() {
		return parent;
	}
	
	@Override
	public CharSequence getLabel() {
		return "Bugtracker";
	}

	@Override
	public URI getIcon() {
		return URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project","css/icons/16/problems_view.png");
	}

	@Override
	public Object getDomainObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOpenCommandId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDeletable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObservableList<ProjectNavigatorItem> getChildren() {
		return bugtrackerItems;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

}
