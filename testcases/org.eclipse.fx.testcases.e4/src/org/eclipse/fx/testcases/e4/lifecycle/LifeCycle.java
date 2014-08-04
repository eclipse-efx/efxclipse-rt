package org.eclipse.fx.testcases.e4.lifecycle;

import javafx.stage.Stage;

import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.fx.ui.dialogs.MessageDialog;
import org.eclipse.fx.ui.workbench.renderers.base.widget.WWindow;
import org.eclipse.fx.ui.workbench.services.lifecycle.annotation.PreClose;

public class LifeCycle {
	
	@SuppressWarnings("rawtypes")
	@PreClose
	public boolean ph(MWindow win){
		MessageDialog.openErrorDialog((Stage)((WWindow)win.getWidget()).getWidget(), "Sorry", "Sorry, no close.");
		return false;
	}
	
	}