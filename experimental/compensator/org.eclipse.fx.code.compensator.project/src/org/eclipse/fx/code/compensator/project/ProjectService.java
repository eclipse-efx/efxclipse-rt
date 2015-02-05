package org.eclipse.fx.code.compensator.project;

import java.util.List;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.core.URI;

public interface ProjectService {
	public String getLabel();
	public URI getIconUri();
	public String getProjectType();
	public String getId();
	public boolean applies(Class<?> type);
	public boolean applies(Project p);
	public String getProjectPerspectiveTemplate(Project p);
	public List<ToolbarGroup> getPrimaryToolbarGroups();
	public List<ToolbarGroup> getSecondaryToolbarGroups();
	public List<ContextMenuGroup> getProjectNavigatorContextMenuGroups();
	public ProjectNavigatorItem mapModuleItem(ProjectNavigatorItem parent, Module m, InstanceProject project);
	public InstanceProject createProjectInstance(IEclipseContext context);

	public abstract static class ContextMenuGroup {
		public final String id;
		private final List<MenuElement> elements;

		public ContextMenuGroup(String id, List<MenuElement> elements) {
			this.id = id;
			this.elements = elements;
		}

		public List<MenuElement> getElements() {
			return elements;
		}

		public abstract boolean applies(ProjectNavigatorItem item);
	}

	public abstract static class MenuElement {
		public final String id;
		public final String label;

		public MenuElement(String id, String label) {
			this.id = id;
			this.label = label;
		}

		public abstract boolean applies(ProjectNavigatorItem item);
	}

	public static class ToolbarGroup {
		public final String id;
		private List<ToolbarElement> elementList;

		public ToolbarGroup(String id, List<ToolbarElement> elementList) {
			this.id = id;
			this.elementList = elementList;
		}

		public List<ToolbarElement> getElementList() {
			return elementList;
		}
	}

	public static abstract class ToolbarElement {
		public final String id;
		public final String tooltip;

		public ToolbarElement(String id, String tooltip) {
			this.id = id;
			this.tooltip = tooltip;
		}
	}


}
