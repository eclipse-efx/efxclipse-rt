package org.eclipse.fx.testcases.e4.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.fx.ui.workbench.services.ELifecycleService;

public class RegisterDynamicLifecycle {
	
	@Execute
	public void execute(ELifecycleService service, MPart part){
		System.err.println(part.getLabel());
		service.registerLifecycleURI(part, "bundleclass://org.eclipse.fx.testcases.e4/"+
		"org.eclipse.fx.testcases.e4.lifecycle.SecondLifeCycle");
	}

}