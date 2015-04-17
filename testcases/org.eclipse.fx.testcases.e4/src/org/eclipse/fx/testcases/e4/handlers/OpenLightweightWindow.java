package org.eclipse.fx.testcases.e4.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.fx.testcases.e4.lightweight.SimpleWindow;
import org.eclipse.fx.ui.services.dialog.LightWeightDialogService;
import org.eclipse.fx.ui.services.dialog.LightWeightDialogService.ModalityScope;

public class OpenLightweightWindow {
	@Execute
	public void run(LightWeightDialogService service) {
		service.openDialog(SimpleWindow.class, ModalityScope.WINDOW);
	}
}
