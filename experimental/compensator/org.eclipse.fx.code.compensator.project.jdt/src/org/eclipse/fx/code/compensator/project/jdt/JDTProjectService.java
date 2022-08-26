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
package org.eclipse.fx.code.compensator.project.jdt;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.code.compensator.model.workbench.LocalProject;
import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.compensator.model.workbench.VCSRepository;
import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorContribution;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.ProjectService;
import org.eclipse.fx.code.compensator.project.jdt.internal.JDTInstanceProject;
import org.eclipse.fx.code.compensator.project.jdt.internal.JDTModuleItem;
import org.eclipse.fx.code.compensator.project.jdt.menu.ImportModuleElement;
import org.eclipse.fx.code.compensator.project.jdt.tb.DebugElement;
import org.eclipse.fx.code.compensator.project.jdt.tb.NewClassElement;
import org.eclipse.fx.code.compensator.project.jdt.tb.NewEnumElement;
import org.eclipse.fx.code.compensator.project.jdt.tb.NewInterfaceElement;
import org.eclipse.fx.code.compensator.project.jdt.tb.NewModuleElement;
import org.eclipse.fx.code.compensator.project.jdt.tb.NewPackageElement;
import org.eclipse.fx.code.compensator.project.jdt.tb.RunElement;
import org.eclipse.fx.code.compensator.project.navigator.FolderItem;
import org.eclipse.fx.code.compensator.project.navigator.ModuleContainerItem;
import org.eclipse.fx.core.URI;

public class JDTProjectService implements ProjectService {
	private List<ToolbarGroup> primaryGroups;
	private List<ToolbarGroup> secondaryGroup;
	private List<ContextMenuGroup> menuGroups;
	private List<ProjectNavigatorContribution> contextMenuContributions = new ArrayList<>();

	public void registerContextMenuContributions(ProjectNavigatorContribution contribution) {
		if( contribution.applies(this) ) {
			contextMenuContributions.add(contribution);
		}
	}

	public void unregisterContextMenuContributions(ProjectNavigatorContribution contribution) {
		if( contribution.applies(this) ) {
			contextMenuContributions.remove(contribution);
		}
	}

	@Override
	public ProjectNavigatorItem mapModuleItem(ProjectNavigatorItem parent, Module m, InstanceProject instanceProject) {
		return new JDTModuleItem(parent, m, (JDTInstanceProject) instanceProject);
	}

	@Override
	public InstanceProject createProjectInstance(IEclipseContext context) {
		return ContextInjectionFactory.make(JDTInstanceProject.class, context);
	}

	@Override
	public boolean applies(Project p) {
		if( p instanceof LocalProject ) {
			return getId().equals(p.getProjectType());
		}
		return false;
	}

	@Override
	public URI getIconUri() {
		return URI.create(getClass().getClassLoader().getResource("css/icons/16/jperspective.png").toExternalForm());
	}

	@Override
	public String getProjectType() {
		return "java-project";
	}

	@Override
	public String getProjectPerspectiveTemplate(Project p) {
		return "org.eclipse.fx.code.compensator.project.perspective.default";
	}

	@Override
	public String getLabel() {
		return "Java Project";
	}

	@Override
	public boolean applies(Class<?> type) {
		return type == LocalProject.class;
	}

	@Override
	public String getId() {
		return "org.eclipse.fx.code.compensator.project.jdt";
	}

	@Override
	public List<ToolbarGroup> getPrimaryToolbarGroups() {
		if(  primaryGroups == null ) {
			primaryGroups = new ArrayList<>();
			primaryGroups.add(new ToolbarGroup("launcher", Arrays.asList(new RunElement(), new DebugElement())));
			primaryGroups.add(new ToolbarGroup("new-files", Arrays.asList(new NewModuleElement(), new NewPackageElement(), new NewClassElement(), new NewInterfaceElement(), new NewEnumElement())));

		}
		return primaryGroups;
	}

	@Override
	public List<ToolbarGroup> getSecondaryToolbarGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContextMenuGroup> getProjectNavigatorContextMenuGroups() {
		if( menuGroups == null ) {
			menuGroups = new ArrayList<>();
			menuGroups.add(new ModuleContainerContextGroup());
			menuGroups.add(new VCSDirectoryContextGroup());
		}
		return menuGroups;
	}


	static class ModuleContainerContextGroup extends ContextMenuGroup {

		public ModuleContainerContextGroup() {
			super("module-container", createElements());
		}

		private static List<MenuElement> createElements() {
			return Arrays.asList(new org.eclipse.fx.code.compensator.project.jdt.menu.NewModuleElement());
		}

		@Override
		public boolean applies(ProjectNavigatorItem item) {
			return item instanceof ModuleContainerItem || item instanceof JDTModuleItem;
		}
	}

	static class VCSDirectoryContextGroup extends ContextMenuGroup {

		public VCSDirectoryContextGroup() {
			super("vcs-dir", createElements());
		}

		private static List<MenuElement> createElements() {
			return Arrays.asList(new ImportModuleElement());
		}

		@Override
		public boolean applies(ProjectNavigatorItem item) {
//			if( item instanceof FolderItem ) {
//				return item.getChildren()
//					.stream()
//					.filter(i -> i.getDomainObject() instanceof Path && ((Path)i.getDomainObject()).getFileName().toString().equals(".project"))
//					.findFirst().isPresent();
//			}
			//TODO need to fix 
//			if( item instanceof FolderItem ) {
//				FolderItem fItem = (FolderItem) item;
//				Object domainObject = fItem.getParent().getDomainObject();
//				if( domainObject instanceof Path ) {
//					
//				}
//			}
			
			return item instanceof FolderItem && ((FolderItem)item).getParent().getDomainObject() instanceof Path;
		}
	}
}
