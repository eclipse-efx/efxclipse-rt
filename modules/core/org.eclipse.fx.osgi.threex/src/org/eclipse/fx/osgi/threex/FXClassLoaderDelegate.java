/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.osgi.threex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Properties;

import org.eclipse.osgi.baseadaptor.BaseAdaptor;
import org.eclipse.osgi.baseadaptor.hooks.AdaptorHook;
import org.eclipse.osgi.framework.adaptor.BundleClassLoader;
import org.eclipse.osgi.framework.adaptor.BundleData;
import org.eclipse.osgi.framework.adaptor.ClassLoaderDelegateHook;
import org.eclipse.osgi.framework.log.FrameworkLog;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.service.packageadmin.PackageAdmin;
import org.osgi.util.tracker.ServiceTracker;

/*
 * Remember the classloader for use in post look ups because of native classloading by javafx' native code
 * See http://javafx-jira.kenai.com/browse/RT-20883
 */
/**
 * Final resort delegate for FX
 */
public class FXClassLoaderDelegate implements ClassLoaderDelegateHook, AdaptorHook {
	private boolean flag;
	private ClassLoader classloader;
	private ServiceTracker<PackageAdmin, PackageAdmin> paTracker;
	private boolean swtAvailable;

	public FXClassLoaderDelegate() {
		if( FXClassLoadingConfigurator.DEBUG ) {
			System.err.println("FXClassLoaderDelegate - creating delegate");
		}
	}

	@Override
	public Class<?> preFindClass(String name, BundleClassLoader classLoader, BundleData data) throws ClassNotFoundException {
		return null;
	}

	@Override
	public Class<?> postFindClass(String name, BundleClassLoader classLoader, BundleData data) throws ClassNotFoundException {
		if( (name.startsWith("javafx") //$NON-NLS-1$
				|| name.startsWith("netscape.javascript") //$NON-NLS-1$
				|| name.startsWith("com.sun.glass.events") //$NON-NLS-1$
				|| name.startsWith("com.sun.glass.ui") //$NON-NLS-1$
				|| name.startsWith("com.sun.javafx") //$NON-NLS-1$
				|| name.startsWith("com.sun.media.jfxmedia") //$NON-NLS-1$
				|| name.startsWith("com.sun.media.jfxmediaimpl") //$NON-NLS-1$
				|| name.startsWith("com.sun.openpisces") //$NON-NLS-1$
				|| name.startsWith("com.sun.pisces") //$NON-NLS-1$
				|| name.startsWith("com.sun.prism") //$NON-NLS-1$
				|| name.startsWith("com.sun.scenario") //$NON-NLS-1$
				|| name.startsWith("com.sun.webkit")) && ! "org.eclipse.swt".equals(data.getSymbolicName()) ) { //$NON-NLS-1$
			if( FXClassLoadingConfigurator.DEBUG ) {
				System.err.println("FXClassLoaderDelegate - Loading JavaFX class " + name);
			}
				if( name.startsWith("javafx.embed.swt") ) {
					try {
						if( FXClassLoadingConfigurator.DEBUG ) {
							System.err.println("Creating SWTFX Classloader");
						}
						return getSWTFXClassLoader().loadClass(name);
					} catch (Exception e) {
						throw new ClassNotFoundException(e.getMessage());
					}
				} else {
					return ClassLoader.getSystemClassLoader().loadClass(name);
				}
			}
			return null;
		}

	private ClassLoader getSWTFXClassLoader() throws Exception {
		if( classloader == null ) {
			ClassLoader parentLoader = null;
			// Trying to locate swt bundle so that if the swt integration is
			// used
			// we can load those
			PackageAdmin admin = getPackageAdmin();
			Bundle[] bundles = admin.getBundles("org.eclipse.swt", null); //$NON-NLS-1$

			if (bundles != null) {
				for (int i = 0; i < bundles.length; i++) {
					if ((bundles[i].getState() & Bundle.INSTALLED) == 0) {
						// Ensure the bundle is started else we are unable to
						// extract the
						// classloader
						if ((bundles[i].getState() & Bundle.ACTIVE) != 0) {
							bundles[i].start();
						}
						parentLoader = bundles[i].adapt(BundleWiring.class).getClassLoader();
						this.swtAvailable = true;
						break;
					}
				}
			}

			File javaHome;
			try {
				javaHome= new File (System.getProperty("java.home")).getCanonicalFile(); //$NON-NLS-1$
			} catch (IOException e) {
				throw new IllegalStateException("Unable to locate java home", e); //$NON-NLS-1$
			}
			if (!javaHome.exists()) {
				throw new IllegalStateException("The java home '"+javaHome.getAbsolutePath()+"' does not exits"); //$NON-NLS-1$ //$NON-NLS-2$
			}

			File swtFX = new File(new File(javaHome.getAbsolutePath(),"lib"),"jfxswt.jar");

			ClassLoader extClassLoader = ClassLoader.getSystemClassLoader().getParent();
			if( extClassLoader.getClass().getName().equals("sun.misc.Launcher$ExtClassLoader") ) { //$NON-NLS-1$
				return classloader = new URLClassLoader(new URL[] { swtFX.getCanonicalFile().toURI().toURL() }, new SWTFXClassloader(parentLoader,extClassLoader));
			}
			throw new IllegalStateException("Could not create classloader"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return classloader;
	}


	private PackageAdmin getPackageAdmin() {
		ServiceTracker<PackageAdmin, PackageAdmin> tracker = this.paTracker;
		if (tracker == null)
			return null;
		return tracker.getService();
	}

	@Override
	public URL preFindResource(String name, BundleClassLoader classLoader, BundleData data) throws FileNotFoundException {
		return null;
	}

	@Override
	public URL postFindResource(String name, BundleClassLoader classLoader, BundleData data) throws FileNotFoundException {
		return null;
	}

	@Override
	public Enumeration<URL> preFindResources(String name, BundleClassLoader classLoader, BundleData data) throws FileNotFoundException {
		return null;
	}

	@Override
	public Enumeration<URL> postFindResources(String name, BundleClassLoader classLoader, BundleData data) throws FileNotFoundException {
		return null;
	}

	@Override
	public String preFindLibrary(String name, BundleClassLoader classLoader, BundleData data) throws FileNotFoundException {
		return null;
	}

	@Override
	public String postFindLibrary(String name, BundleClassLoader classLoader, BundleData data) {
		return null;
	}

	@Override
	public void initialize(BaseAdaptor adaptor) {

	}

	@Override
	public void frameworkStart(BundleContext context) throws BundleException {
		this.paTracker = new ServiceTracker<PackageAdmin, PackageAdmin>(context, PackageAdmin.class.getName(), null);
		this.paTracker.open();
	}

	@Override
	public void frameworkStop(BundleContext context) throws BundleException {
		this.paTracker.close();
	}

	@Override
	public void frameworkStopping(BundleContext context) {

	}

	@Override
	public void addProperties(Properties properties) {

	}

	@Override
	public URLConnection mapLocationToURLConnection(String location) throws IOException {
		return null;
	}

	@Override
	public void handleRuntimeError(Throwable error) {

	}

	@Override
	public FrameworkLog createFrameworkLog() {
		return null;
	}

	static class SWTFXClassloader extends ClassLoader {
		private final ClassLoader lastResortLoader;
		private final ClassLoader primaryLoader;

		public SWTFXClassloader(ClassLoader lastResortLoader, ClassLoader primaryLoader) {
			this.lastResortLoader = lastResortLoader;
			this.primaryLoader = primaryLoader;
		}

		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {
			try {
				return this.primaryLoader.loadClass(name);
			} catch( ClassNotFoundException c ) {
				try {
					return this.lastResortLoader.loadClass(name);
				} catch( ClassNotFoundException tmp ) {
					throw c;
				}
			}
		}

		@Override
		protected URL findResource(String name) {
			URL url = this.primaryLoader.getResource(name);
			if( url == null ) {
				url = this.lastResortLoader.getResource(name);
			}
			return url;
		}

		@Override
		protected Enumeration<URL> findResources(String name) throws IOException {
			final Enumeration<URL> en1 = this.primaryLoader.getResources(name);
			final Enumeration<URL> en2 = this.lastResortLoader.getResources(name);

			return new Enumeration<URL>() {
				@Override
				public boolean hasMoreElements() {
					if( en1.hasMoreElements() ) {
						return true;
					}
					return en2.hasMoreElements();
				}

				@Override
				public URL nextElement() {
					if( ! en1.hasMoreElements() ) {
						return en2.nextElement();
					}
					return en1.nextElement();
				}
			};
		}

		@Override
		public URL getResource(String name) {
			URL url = this.primaryLoader.getResource(name);
			if( url == null ) {
				url = this.lastResortLoader.getResource(name);
			}
			return url;
		}

		@SuppressWarnings("resource")
		@Override
		public InputStream getResourceAsStream(String name) {
			InputStream in = this.primaryLoader.getResourceAsStream(name);
			if( in == null ) {
				in = this.lastResortLoader.getResourceAsStream(name);
			}
			return in;
		}

		@Override
		public Enumeration<URL> getResources(String name) throws IOException {
			final Enumeration<URL> en1 = this.primaryLoader.getResources(name);
			final Enumeration<URL> en2 = this.lastResortLoader.getResources(name);

			return new Enumeration<URL>() {
				@Override
				public boolean hasMoreElements() {
					if( en1.hasMoreElements() ) {
						return true;
					}
					return en2.hasMoreElements();
				}

				@Override
				public URL nextElement() {
					if( ! en1.hasMoreElements() ) {
						return en2.nextElement();
					}
					return en1.nextElement();
				}
			};
		}

		@Override
		public Class<?> loadClass(String name) throws ClassNotFoundException {
			try {
				return this.primaryLoader.loadClass(name);
			} catch( ClassNotFoundException c ) {
				try {
					return this.lastResortLoader.loadClass(name);
				} catch( ClassNotFoundException tmp ) {
					throw c;
				}
			}
		}
	}
}