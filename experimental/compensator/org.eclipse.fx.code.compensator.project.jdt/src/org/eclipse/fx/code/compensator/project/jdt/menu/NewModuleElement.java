package org.eclipse.fx.code.compensator.project.jdt.menu;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.ProjectService.MenuElement;
import org.eclipse.fx.core.di.Invoke;

public class NewModuleElement extends MenuElement {

	public NewModuleElement() {
		super("new-java-module", "New Module");
	}

	@Override
	public boolean applies(ProjectNavigatorItem item) {
		return true;
	}

	@Invoke
	public void run() {
		System.err.println("NEW MODULE");
	}
}
