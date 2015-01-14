package org.eclipse.fx.code.compensator.project.internal.commands;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class SwitchPlayground {
	@Execute
	public void openPlayground(EPartService partService, EModelService modelService, MApplication application) {
		MPerspective perspective = (MPerspective) modelService.find("org.eclipse.fx.code.compensator.freeedit.perspective.0", application);
		partService.switchPerspective(perspective);
	}
}
