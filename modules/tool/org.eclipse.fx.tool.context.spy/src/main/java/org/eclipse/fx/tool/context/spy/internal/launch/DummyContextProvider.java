package org.eclipse.fx.tool.context.spy.internal.launch;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.internal.contexts.EclipseContext;

public class DummyContextProvider {

	private final IEclipseContext applicationContext = new EclipseContext(null);

	public DummyContextProvider() {

		applicationContext.set(EclipseContext.DEBUG_STRING, "Application Context");

		IEclipseContext workplaceContext = applicationContext.createChild("Workplace Context");
		
		workplaceContext.set("some_prop", "123456");

		IEclipseContext window1Context = workplaceContext.createChild("Main Window Context");

		IEclipseContext window2Context = workplaceContext.createChild("Settings Window Context");
		
		window2Context.set("myKey", "myValue");
		window2Context.set(String.class, "halloooo");
		
		window2Context.get("some_prop");

		IEclipseContext settingsPerspectiveContext = window2Context.createChild("Settings Perspective Context");

		
		IEclipseContext rendererContext = applicationContext.createChild("Renderer Context");

	}

	public IEclipseContext getApplicationContext() {
		return applicationContext;
	}

}
