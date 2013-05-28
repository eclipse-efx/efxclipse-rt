package org.eclipse.fx.testcases.e4.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

public class CloseOthersHandler {
	
	@Execute
	public void ex(EModelService service, MWindow win){
		MPartStack stack = (MPartStack) service.find("content.stack", win);
		List<MStackElement> toClose = new ArrayList<MStackElement>(stack.getChildren());
		toClose.remove(stack.getSelectedElement());
		stack.getChildren().removeAll(toClose);
	}

}
