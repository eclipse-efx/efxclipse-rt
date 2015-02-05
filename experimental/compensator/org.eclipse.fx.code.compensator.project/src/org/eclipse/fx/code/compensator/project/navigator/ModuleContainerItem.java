package org.eclipse.fx.code.compensator.project.navigator;

import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage;
import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.core.URI;

public class ModuleContainerItem implements ProjectNavigatorItem {
	private final InstanceProject instanceProject;
	private final ObservableList<ProjectNavigatorItem> modules = FXCollections.observableArrayList();
	private final ProjectItem parent;

	public ModuleContainerItem(ProjectItem parent, InstanceProject instanceProject) {
		this.instanceProject = instanceProject;
		this.parent = parent;
		modules.addAll(instanceProject.getProject().getModuleList().stream().map( m -> instanceProject.mapModule(this,m)).collect(Collectors.toList()));
		instanceProject.getProject().eAdapters().add(new AdapterImpl() {
			public void notifyChanged(org.eclipse.emf.common.notify.Notification msg) {
				if( msg.getFeature() == WorkbenchPackage.Literals.MODULE_CONTAINER__MODULE_LIST ) {
					if( msg.getEventType() == Notification.ADD ) {
						modules.add(instanceProject.mapModule(ModuleContainerItem.this, (Module) msg.getNewValue()));
					}
				}
			}
		});
	}

	@Override
	public ProjectNavigatorItem getParent() {
		return this.parent;
	}
	
	@Override
	public CharSequence getLabel() {
		return "Modules";
	}

	@Override
	public URI getIcon() {
		return URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project","css/icons/16/workingsets.png");
	}

	@Override
	public Object getDomainObject() {
		return instanceProject;
	}

	@Override
	public String getOpenCommandId() {
		return null;
	}

	@Override
	public boolean isDeletable() {
		return false;
	}

	@Override
	public ObservableList<ProjectNavigatorItem> getChildren() {
		return modules;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}
}
