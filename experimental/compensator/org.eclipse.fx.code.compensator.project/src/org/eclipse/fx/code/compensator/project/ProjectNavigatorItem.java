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
package org.eclipse.fx.code.compensator.project;

import org.eclipse.fx.core.URI;

import javafx.collections.ObservableList;

public interface ProjectNavigatorItem {
	public CharSequence getLabel();
	public URI getIcon();
	public Object getDomainObject();
	public String getOpenCommandId();
	public boolean isDeletable();
	public ObservableList<ProjectNavigatorItem> getChildren();
	public boolean isLeaf();
	public ProjectNavigatorItem getParent();
}
