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

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.BiFunction;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.navigator.FolderItem;
import org.eclipse.fx.code.compensator.project.navigator.PathItem;
import org.eclipse.fx.core.URI;

public class JDTPackageFragmentRootItem extends FolderItem implements ProjectNavigatorItem, JDTPathItem {
	private JDTModuleItem moduleItem;

	static final BiFunction<Path, FolderItem, PathItem> FACTORY = (p,i) -> {
		if( Files.isDirectory(p) ) {
			return new JDTPackageItem(i,p);
		} else {
			return new JDTFileItem(i,p);
		}
	};

	public JDTPackageFragmentRootItem(JDTModuleItem moduleItem, Path path) {
		super(moduleItem,path,FACTORY);
		this.moduleItem = moduleItem;
	}

	@Override
	public JDTModuleItem getModuleItem() {
		return moduleItem;
	}

	@Override
	public JDTInstanceProject getJdtProject() {
		return getModuleItem().getJdtProject();
	}

	@Override
	public CharSequence getLabel() {
		return moduleItem.getPath().relativize(path).toString();
	}

	@Override
	public URI getIcon() {
		return URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project.jdt","css/icons/16/packagefolder_obj.png");
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

}
