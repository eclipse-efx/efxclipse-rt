package org.eclipse.fx.code.compensator.project.jdt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.code.compensator.model.workbench.LocalProject;
import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorContribution;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.ProjectService;
import org.eclipse.fx.code.compensator.project.internal.adapter.ModuleContainerItem;
import org.eclipse.fx.code.compensator.project.internal.adapter.VCSContainerItem.VCSDirectory;
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
import org.eclipse.fx.core.SimpleURI;
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
	public ProjectNavigatorItem mapModuleItem(Module m, InstanceProject instanceProject) {
		return new JDTModuleItem(m, (JDTInstanceProject) instanceProject);
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
		return new SimpleURI(getClass().getClassLoader().getResource("css/icons/16/jperspective.png").toExternalForm());
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
			return item instanceof VCSDirectory;
		}
	}
}
