package org.eclipse.fx.code.compensator.project.internal.adapter;

import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage;
import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;

public class ModuleContainerItem implements ProjectNavigatorItem {
	private final InstanceProject instanceProject;
	private final ObservableList<ProjectNavigatorItem> modules = FXCollections.observableArrayList();

	public ModuleContainerItem(InstanceProject instanceProject) {
		this.instanceProject = instanceProject;
		modules.addAll(instanceProject.getProject().getModuleList().stream().map( m -> instanceProject.mapModule(m)).collect(Collectors.toList()));
		instanceProject.getProject().eAdapters().add(new AdapterImpl() {
			public void notifyChanged(org.eclipse.emf.common.notify.Notification msg) {
				if( msg.getFeature() == WorkbenchPackage.Literals.MODULE_CONTAINER__MODULE_LIST ) {
					if( msg.getEventType() == Notification.ADD ) {
						modules.add(instanceProject.mapModule((Module) msg.getNewValue()));
					}
				}
			}
		});
	}

	@Override
	public CharSequence getLabel() {
		return "Modules";
	}

	@Override
	public String getIcon() {
		return "platform:/plugin/org.eclipse.fx.code.compensator.project/css/icons/16/workingsets.png";
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
