package org.eclipse.fx.osgi.fxloader;

import org.eclipse.osgi.internal.hookregistry.HookConfigurator;
import org.eclipse.osgi.internal.hookregistry.HookRegistry;

public class FXClassloaderConfigurator implements HookConfigurator {
	public static final boolean DEBUG = true;

	@Override
	public void addHooks(HookRegistry hookRegistry) {
		hookRegistry.addClassLoaderHook(new FXClassLoader());
	}

}
