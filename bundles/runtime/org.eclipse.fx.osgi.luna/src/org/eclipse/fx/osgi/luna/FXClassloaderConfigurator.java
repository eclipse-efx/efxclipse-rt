package org.eclipse.fx.osgi.luna;

import org.eclipse.osgi.internal.hookregistry.HookConfigurator;
import org.eclipse.osgi.internal.hookregistry.HookRegistry;

public class FXClassloaderConfigurator implements HookConfigurator {
	public static final boolean DEBUG = true;

	public FXClassloaderConfigurator() {
		System.err.println("CLASSLOADING HOOK CONFIG CREATED");
	}
	
	@Override
	public void addHooks(HookRegistry hookRegistry) {
		System.err.println("ADDING HOOK");
		hookRegistry.addClassLoaderHook(new FXClassLoader());
	}

}
