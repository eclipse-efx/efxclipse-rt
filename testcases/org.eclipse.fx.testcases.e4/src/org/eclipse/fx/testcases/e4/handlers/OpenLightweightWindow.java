package org.eclipse.fx.testcases.e4.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.fx.testcases.e4.lightweight.SimpleWindow;
import org.eclipse.fx.ui.services.dialog.LightWeightDialogService;
import org.eclipse.fx.ui.services.dialog.LightWeightDialogService.ModalityScope;

public class OpenLightweightWindow {
	@Execute
	public void run(IEclipseContext context, MPart p, LightWeightDialogService service, @Named("scope") String scope) {
		System.err.println("CONTEXT: " + context);
		System.err.println(p);
		service.openDialog(SimpleWindow.class, ModalityScope.valueOf(scope));
	}
}
