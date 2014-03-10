package org.eclipse.fx.runtime.examples.swt;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.osgi.util.AbstractJFXApplication;

import javafx.application.Application;
import javafx.stage.Stage;

public abstract class SWTApplication extends AbstractJFXApplication {

	@Override
	protected void jfxStart(IApplicationContext applicationContext, Application jfxApplication, Stage primaryStage) {
		run();
	}
	
	public abstract void run();

	public void spinEventLoop() {

	}
}
