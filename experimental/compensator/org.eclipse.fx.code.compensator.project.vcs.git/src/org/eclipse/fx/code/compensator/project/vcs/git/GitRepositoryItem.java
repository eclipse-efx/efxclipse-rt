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
package org.eclipse.fx.code.compensator.project.vcs.git;

import java.nio.file.Path;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.navigator.FolderItem;
import org.eclipse.fx.code.compensator.project.vcs.VCSRepositoryInstance;
import org.eclipse.fx.code.compensator.project.vcs.VCSRootNavigatorItem;
import org.eclipse.jgit.lib.Repository;

public class GitRepositoryItem extends FolderItem implements VCSRootNavigatorItem {
	private VCSRepositoryInstance repository;
	private Repository repo;

	public GitRepositoryItem(ProjectNavigatorItem parent, VCSRepositoryInstance repository, Path path) {
		super(parent, path);
		this.repository = repository;
	}

	public String getLabel() {
		return "Working Directory";
	}

//	@Override
//	public void fetch() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void push() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void merge() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void commit() {
//		
//	}
//	
//	@Override
//	public void commit(Collection<Path> pathList) {
//		Git git = new Git(repo);
//		for( Path p : pathList ) {
//			System.err.println(p.relativize(path));
//		}
//		
//	}
}