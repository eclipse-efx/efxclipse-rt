package org.eclipse.fx.osgi.threex;

import org.eclipse.osgi.baseadaptor.HookConfigurator;
import org.eclipse.osgi.baseadaptor.HookRegistry;

/**
 * Configurations for FX
 */
public class FXClassLoadingConfigurator implements HookConfigurator {
	/**
	 * Debug enabled
	 */
	public static final boolean DEBUG = Boolean.getBoolean("efxclipse.osgi.hook.debug"); //$NON-NLS-1$

	/**
	 *
	 */
	public FXClassLoadingConfigurator() {
		if( DEBUG ) {
			System.err.println("FXClassLoadingConfigurator - This is the classloading configurator");	 //$NON-NLS-1$
		}

	}

	@Override
	public void addHooks(HookRegistry hookRegistry) {
		if( DEBUG ) {
			System.err.println("FXClassLoadingConfigurator - Adding hooks for classloading");	 //$NON-NLS-1$
		}
		FXClassLoaderDelegate cl = new FXClassLoaderDelegate();
		hookRegistry.addAdaptorHook(cl);
		hookRegistry.addClassLoaderDelegateHook(cl);
	}

}