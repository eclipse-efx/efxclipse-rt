package org.eclipse.fx.code.compensator.app;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

public class QuitApplication {
	@Execute
	public void shutdown(IWorkbench workbench) {
		workbench.close();
	}
}
