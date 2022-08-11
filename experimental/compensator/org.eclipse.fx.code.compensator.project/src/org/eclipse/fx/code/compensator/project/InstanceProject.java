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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.code.compensator.model.workbench.BugTracker;
import org.eclipse.fx.code.compensator.model.workbench.LocalProject;
import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.compensator.model.workbench.VCSRepository;
import org.eclipse.fx.code.compensator.project.bt.BugTrackerInstance;
import org.eclipse.fx.code.compensator.project.bt.BugTrackerService;
import org.eclipse.fx.code.compensator.project.vcs.VCSRepositoryInstance;
import org.eclipse.fx.code.compensator.project.vcs.VersionControlService;

public abstract class InstanceProject {
	private final Project project;
	private final List<VersionControlService> versionControlServiceList;
	private final IEventBroker eventBroker;
	private final List<VCSRepositoryInstance> repositoryInstanceList = new ArrayList<>();
	private final List<BugTrackerService> bugtrackerServiceList;
	private final List<BugTrackerInstance> bugtrackerInstanceList = new ArrayList<>();
	
	public InstanceProject(
			IEventBroker eventBroker,
			Project project,
			List<VersionControlService> versionControlServiceList,
			List<BugTrackerService> bugtrackerServiceList) {
		this.eventBroker = eventBroker;
		this.project = project;
		this.project.setUserdata(this);
		this.bugtrackerServiceList = bugtrackerServiceList;
		this.versionControlServiceList = versionControlServiceList;
		if( this.project instanceof LocalProject ) {
			((LocalProject)this.project).getVcsRepositoryList().forEach(this::handleRepository);
		}
		project.getBugTrackerList().forEach(this::handleBugtracker);
	}
	
	private void handleBugtracker(BugTracker bugtracker) {
		bugtrackerInstanceList.add(getBugtrackerServiceList()
			.stream()
			.filter( s -> s.getId().equals(bugtracker.getBugtrackerType()) )
			.findFirst().
			map(s -> s.createInstance(bugtracker)).get());
	}
	
	
	private void handleRepository(VCSRepository repository) {
		Path path = Paths.get(java.net.URI.create(repository.getLocalURI()));
		if( ! Files.exists(path) ) {
			getVersionControlServiceList()
				.stream()
				.filter(v -> v.getId().equals(repository.getRepoType()))
				.findFirst().ifPresent(v -> v.cloneRepository(path, repository.getRepoURI(), repository.getRepoUsername(), repository.getRepoPassword(), null));
		}
		
		repositoryInstanceList.add(getVersionControlServiceList()
				.stream()
				.filter(v -> v.getId().equals(repository.getRepoType()))
				.findFirst()
				.map(v -> v.createRepository(this,repository,repository.getLocalURI())).get());
	}

	public final Project getProject() {
		return project;
	}
	
	public List<VCSRepositoryInstance> getRepositoryInstanceList() {
		return repositoryInstanceList;
	}

	public final List<VersionControlService> getVersionControlServiceList() {
		return versionControlServiceList;
	}
	
	public final List<BugTrackerInstance> getBugtrackerInstanceList() {
		return bugtrackerInstanceList;
	}
	
	public List<BugTrackerService> getBugtrackerServiceList() {
		return bugtrackerServiceList;
	}
	
	public IEventBroker getEventBroker() {
		return eventBroker;
	}

	public abstract boolean openItem(ProjectNavigatorItem item);
	public abstract ProjectNavigatorItem mapModule(ProjectNavigatorItem parent, Module module);
}
