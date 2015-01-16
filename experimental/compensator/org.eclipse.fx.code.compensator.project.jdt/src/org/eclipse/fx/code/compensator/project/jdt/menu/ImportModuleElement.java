package org.eclipse.fx.code.compensator.project.jdt.menu;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Future;

import javax.inject.Named;

import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchFactory;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.ProjectService.MenuElement;
import org.eclipse.fx.code.server.jdt.JDTServer;
import org.eclipse.fx.core.di.Invoke;
import org.eclipse.fx.core.function.ExExecutor;

public class ImportModuleElement extends MenuElement {

	public ImportModuleElement() {
		super("import-java-module", "Import Module");
	}

	@Override
	public boolean applies(ProjectNavigatorItem item) {
//		return item instanceof VCSDirectory && Files.exists(((Path)item.getDomainObject()).resolve(".project"));
		return false;
	}

	@Invoke
	public void run(JDTServer server, @Named("navigatorSelection") ProjectNavigatorItem item, Project project) {
		Path domainObject = (Path)item.getDomainObject();
		Future<String> future = server.registerModule(domainObject.toUri());
		ExExecutor.executeSupplier(future::get, "Failed to retrieve value").ifPresent( name -> {
			Module m = WorkbenchFactory.eINSTANCE.createModule();
			m.setName(name);
			m.setRootFolderUrl(domainObject.toUri().toString());
			project.getModuleList().add(m);
		});
	}
}
