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

import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;

public abstract class PathItem implements ProjectNavigatorItem {
	protected final Path path;
	protected final ProjectNavigatorItem parent;

	public PathItem(ProjectNavigatorItem parent, Path path) {
		this.path = path;
		this.parent = parent;
	}
	
	public ProjectNavigatorItem getParent() {
		return parent;
	}

	@Override
	public CharSequence getLabel() {
		return path.getName(path.getNameCount()-1).toString();
	}

	@Override
	public final Path getDomainObject() {
		return path;
	}

	@Override
	public boolean isDeletable() {
		return Files.isWritable(path.getParent());
	}
}
