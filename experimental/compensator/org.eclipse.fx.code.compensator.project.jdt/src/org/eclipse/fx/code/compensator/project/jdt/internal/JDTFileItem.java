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
package org.eclipse.fx.code.compensator.project.jdt.internal;

import java.nio.file.Path;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.navigator.FileItem;
import org.eclipse.fx.core.URI;

public class JDTFileItem extends FileItem implements JDTPathItem {

	public JDTFileItem(ProjectNavigatorItem parent, Path p) {
		super(parent,p);
	}

	@Override
	public URI getIcon() {
		return getJdtProject().getFileLookup().getFileIcon(getDomainObject().toUri().toString());
	}

	@Override
	public JDTModuleItem getModuleItem() {
		return ((JDTPathItem)parent).getModuleItem();
	}

	@Override
	public JDTInstanceProject getJdtProject() {
		return ((JDTPathItem)parent).getJdtProject();
	}

}
