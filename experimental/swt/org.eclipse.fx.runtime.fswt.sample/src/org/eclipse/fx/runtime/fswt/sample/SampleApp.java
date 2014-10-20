package org.eclipse.fx.runtime.fswt.sample;

import org.eclipse.fx.runtime.fswt.FBlockCondition;
import org.eclipse.fx.runtime.fswt.FSWT;
import org.eclipse.fx.runtime.fswt.FSWTProvider;
import org.eclipse.fx.runtime.fswt.graphics.FFadeTransition;
import org.eclipse.fx.runtime.fswt.widgets.FDisplay;
import org.eclipse.fx.runtime.fswt.widgets.FShell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SampleApp {
	public static void main(String[] args) {
		FSWT facade = FSWTProvider.getFacade();
		facade.boostrap(SampleApp::bootstrap);
	}

	static FBlockCondition bootstrap(FDisplay<Display> display) {
		Shell s = new Shell();

		FShell<Shell> as = FSWTProvider.getFacade().adapt(s, FShell.class);
		as.openBlocking(FFadeTransition.basic(0, 1.0, 1000), () -> {});

		return null;
	}
}
