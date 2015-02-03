package org.eclipse.fx.code.server.jdt.server;

import org.eclipse.core.resources.ResourcesPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.err.println("START UP");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.err.println("SHUTDOWN");
		ResourcesPlugin.getWorkspace().save(true, null);
	}

}
