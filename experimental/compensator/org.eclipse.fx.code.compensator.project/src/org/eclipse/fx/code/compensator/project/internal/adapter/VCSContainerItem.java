package org.eclipse.fx.code.compensator.project.internal.adapter;

import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.fx.code.compensator.model.workbench.LocalProject;
import org.eclipse.fx.code.compensator.model.workbench.VCSRepository;
import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.core.URI;

public class VCSContainerItem implements ProjectNavigatorItem {
	private final InstanceProject project;
	private final ObservableList<ProjectNavigatorItem> children = FXCollections.observableArrayList();

	public VCSContainerItem(InstanceProject project) {
		this.project = project;
		List<VCSRepository> repoList = ((LocalProject)project.getProject()).getVcsRepositoryList();
		children.addAll(repoList.stream().map(this::mapToNavigator).collect(Collectors.toList()));
	}

	private ProjectNavigatorItem mapToNavigator(VCSRepository r) {
		return project.getVersionControlServiceList().stream()
				.filter((v) -> v.getId().equals(r.getRepoType()))
				.findFirst()
				.map((v) -> v.mapRepository(r)).get();
	}

	@Override
	public CharSequence getLabel() {
		return "Repositories";
	}

	@Override
	public URI getIcon() {
		return URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project","css/icons/16/vcs.png");
	}

	@Override
	public Object getDomainObject() {
		return project;
	}

	@Override
	public String getOpenCommandId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDeletable() {
		return false;
	}

	@Override
	public ObservableList<ProjectNavigatorItem> getChildren() {
		return children;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

}
