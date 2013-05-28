package org.eclipse.fx.testcases.e4.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

public class BatchRemoveHandler {
	
	@Execute
	public void ex(EModelService service, MWindow win){
		MPartStack stack = (MPartStack) service.find("content.stack", win);
		stack.getChildren().removeAll(stack.getChildren());
		
	}

}
