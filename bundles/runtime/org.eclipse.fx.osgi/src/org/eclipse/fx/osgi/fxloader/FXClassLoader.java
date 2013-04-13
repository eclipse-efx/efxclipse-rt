/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.osgi.fxloader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.eclipse.osgi.baseadaptor.BaseAdaptor;
import org.eclipse.osgi.baseadaptor.BaseData;
import org.eclipse.osgi.baseadaptor.bundlefile.BundleEntry;
import org.eclipse.osgi.baseadaptor.hooks.AdaptorHook;
import org.eclipse.osgi.baseadaptor.hooks.ClassLoadingHook;
import org.eclipse.osgi.baseadaptor.loader.BaseClassLoader;
import org.eclipse.osgi.baseadaptor.loader.ClasspathEntry;
import org.eclipse.osgi.baseadaptor.loader.ClasspathManager;
import org.eclipse.osgi.framework.adaptor.BundleProtectionDomain;
import org.eclipse.osgi.framework.adaptor.ClassLoaderDelegate;
import org.eclipse.osgi.framework.log.FrameworkLog;
import org.eclipse.osgi.internal.baseadaptor.DefaultClassLoader;
import org.eclipse.osgi.service.datalocation.Location;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.service.packageadmin.PackageAdmin;
import org.osgi.util.tracker.ServiceTracker;

@SuppressWarnings("deprecation")
public class FXClassLoader implements ClassLoadingHook, AdaptorHook {

	private ServiceTracker<PackageAdmin, PackageAdmin> paTracker;

	private ServiceTracker<Location,Location> instanceLocationTracker = null;

	private ServiceTracker<?,?> preferenceServiceTracker = null;

	private ServiceTracker<Location, Location> installLocation = null;

	private BundleContext context = null;
	
	/*
	 * Remember the classloader for use in post look ups because of native classloading by javafx' native code
	 * See http://javafx-jira.kenai.com/browse/RT-20883
	 */
	static MyBundleClassLoader LOADER;
	
	@Override
	public byte[] processClass(String name, byte[] classbytes, ClasspathEntry classpathEntry, BundleEntry entry, ClasspathManager manager) {
		return null;
	}

	@Override
	public boolean addClassPathEntry(ArrayList<ClasspathEntry> cpEntries, String cp, ClasspathManager hostmanager, BaseData sourcedata, ProtectionDomain sourcedomain) {
		return false;
	}

	@Override
	public String findLibrary(BaseData data, String libName) {
		return null;
	}

	@Override
	public ClassLoader getBundleClassLoaderParent() {
		return null;
	}
	
	@Override
	public BaseClassLoader createClassLoader(ClassLoader parent, final ClassLoaderDelegate delegate, BundleProtectionDomain domain, BaseData data, String[] bundleclasspath) {
		if (data.getBundle().getSymbolicName().equals("org.eclipse.fx.javafx")) {
			try {
				MyBundleClassLoader cl = new MyBundleClassLoader(getPackageAdmin(), parent, delegate, domain, data, bundleclasspath, context);
				LOADER = cl;
				return cl;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void initializedClassLoader(BaseClassLoader baseClassLoader, BaseData data) {
	}

	static class MyBundleClassLoader extends DefaultClassLoader {
		private URLClassLoader fxClassLoader;

		public MyBundleClassLoader(PackageAdmin admin, ClassLoader parent, ClassLoaderDelegate delegate, ProtectionDomain domain, BaseData bundledata, String[] classpath, BundleContext context) throws Exception {
			super(parent, delegate, domain, bundledata, classpath);

			// Trying to locate swt bundle so that if the swt integration is
			// used
			// we can load those
			Bundle[] bundles = admin.getBundles("org.eclipse.swt", null);
			boolean swtAvailable = false;
			
			if (bundles != null) {
				for (int i = 0; i < bundles.length; i++) {
					if ((bundles[i].getState() & Bundle.INSTALLED) == 0) {
						// Ensure the bundle is started else we are unable to
						// extract the
						// classloader
						if ((bundles[i].getState() & Bundle.ACTIVE) != 0) {
							bundles[i].start();
						}
						parent = bundles[i].adapt(BundleWiring.class).getClassLoader();
						swtAvailable = true;
						break;
					}
				}
			}

			fxClassLoader = createClassloader(parent, admin, bundledata, context, swtAvailable);
		}

		private static URLClassLoader createJREBundledClassloader(ClassLoader parent, boolean swtAvailable) {
			if( FXClassLoadingConfigurator.DEBUG ) {
				System.err.println("MyBundleClassLoader#createJREBundledClassloader - Started");
			}
			
			try {
				File javaHome; 
				try {
					javaHome= new File (System.getProperty("java.home")).getCanonicalFile(); //$NON-NLS-1$
				} catch (IOException e) {
					throw new IllegalStateException("Unable to locate java home", e);
				}
				if (!javaHome.exists()) {
					throw new IllegalStateException("The java home '"+javaHome.getAbsolutePath()+"' does not exits");
				}
				
				// Java 8 and maybe one day Java 7
				File jarFile = new File(new File(new File(javaHome.getAbsolutePath(),"lib"),"ext"),"jfxrt.jar");
				if( FXClassLoadingConfigurator.DEBUG ) {
					System.err.println("MyBundleClassLoader#createJREBundledClassloader - Assumed location (Java 8/Java 7): " + jarFile.getAbsolutePath());
				}
				
				
				
				if( jarFile.exists() ) {
					// if SWT is available we need to construct a new URL-Classloader with SWT
					// bundles classloader as the parent
					if( swtAvailable ) {
						URL url = jarFile.getCanonicalFile().toURI().toURL();
						return new URLClassLoader(new URL[] { url }, parent);	
					} else {
						// we should be able to delegate to the URL-Extension-Classloader, which is essential for ScenicView
						// which installs an JMX-Component
						try {
							ClassLoader extClassLoader = ClassLoader.getSystemClassLoader().getParent();
							if( extClassLoader.getClass().getName().equals("sun.misc.Launcher$ExtClassLoader") ) {
								return new URLClassLoader(new URL[] {}, extClassLoader);	
							}
						} catch(Throwable t) {
							t.printStackTrace();
						}
						URL url = jarFile.getCanonicalFile().toURI().toURL();
						URLClassLoader cl = new URLClassLoader(new URL[] { url }, parent);
						return cl;
					}
				} 
				
				// Java 7
				jarFile = new File(new File(javaHome.getAbsolutePath(),"lib"),"jfxrt.jar");
				if( FXClassLoadingConfigurator.DEBUG ) {
					System.err.println("MyBundleClassLoader#createJREBundledClassloader - Assumed location (Java 7): " + jarFile.getAbsolutePath());
				}
				
				if( jarFile.exists() ) {
					URL url = jarFile.getCanonicalFile().toURI().toURL();
					return new URLClassLoader(new URL[] { url }, parent);
				} else {
					if( FXClassLoadingConfigurator.DEBUG ) {
						System.err.println("MyBundleClassLoader#createJREBundledClassloader - File does not exist.");
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				if( FXClassLoadingConfigurator.DEBUG ) {
					System.err.println("MyBundleClassLoader#createJREBundledClassloader - Ended");
				}
			}
			
			return null;
		}

		private static URLClassLoader createClassloader(ClassLoader parent, PackageAdmin admin, BaseData bundledata, BundleContext context, boolean swtAvailable) throws Exception {
			URLClassLoader loader;
			
			{
				if( FXClassLoadingConfigurator.DEBUG ) {
					System.err.println("MyBundleClassLoader#createClassloader - checking for JRE bundled javafx");
				}
				
				loader = createJREBundledClassloader(parent, swtAvailable);
			}
			
			if (loader != null) {
				return loader;
			}
			
			throw new IllegalStateException("You need to run at least Java7u6");
		}

		@Override
		public Class<?> findLocalClass(String classname) throws ClassNotFoundException {
			try {
				Class<?> cl = fxClassLoader.loadClass(classname);
				return cl;
			} catch (ClassNotFoundException e) {
				return super.findLocalClass(classname);
			} catch (NoClassDefFoundError e) {
				return super.findLocalClass(classname);
			}
		}

		@Override
		public URL findLocalResource(String resource) {
			try {
				URL url = fxClassLoader.findResource(resource);
				if (url == null) {
					url = super.findLocalResource(resource);
				}
				return url;
			} catch (Throwable e) {
				return super.findLocalResource(resource);
			}
		}

		@Override
		protected Enumeration<URL> findResources(String name) throws IOException {
			try {
				List<URL> tmp = new ArrayList<URL>();

				Enumeration<URL> rv = fxClassLoader.findResources(name);
				while (rv.hasMoreElements()) {
					tmp.add(rv.nextElement());
				}

				rv = super.findResources(name);
				while (rv.hasMoreElements()) {
					tmp.add(rv.nextElement());
				}

				return Collections.enumeration(tmp);
			} catch (Throwable e) {
				return super.findResources(name);
			}
		}
	}

	@Override
	public void initialize(BaseAdaptor adaptor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void frameworkStart(BundleContext context) throws BundleException {
		this.context = context;

		paTracker = new ServiceTracker<PackageAdmin, PackageAdmin>(context, PackageAdmin.class.getName(), null);
		paTracker.open();

		try {
			Filter filter = context.createFilter(Location.INSTANCE_FILTER);
			instanceLocationTracker = new ServiceTracker<Location,Location>(context, filter, null);
			instanceLocationTracker.open();
		} catch (InvalidSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Filter filter = context.createFilter(Location.INSTALL_FILTER);
			installLocation = new ServiceTracker<Location,Location>(context, filter, null);
			installLocation.open();
		} catch (InvalidSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		preferenceServiceTracker = new ServiceTracker<Object,Object>(context, "org.eclipse.core.runtime.preferences.IPreferencesService", null);
		preferenceServiceTracker.open();
	}

	@Override
	public void frameworkStop(BundleContext context) throws BundleException {
		paTracker.close();
		paTracker = null;

		instanceLocationTracker.close();
		instanceLocationTracker = null;

		installLocation.close();
		installLocation = null;

		preferenceServiceTracker.close();
		preferenceServiceTracker = null;
	}

	public Bundle ensureStarted(String symbolicName) {
		Bundle[] bundles = getPackageAdmin().getBundles(symbolicName, null);

		if (bundles != null) {
			for (int i = 0; i < bundles.length; i++) {
				if ((bundles[i].getState() & Bundle.INSTALLED) == 0) {
					// Ensure the bundle is started else we are unable to
					// extract the
					// classloader
					if ((bundles[i].getState() & Bundle.ACTIVE) != 0) {
						try {
							bundles[i].start();
						} catch (BundleException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							return null;
						}
					}
					return bundles[i];
				}
			}
		}

		return null;
	}

	private PackageAdmin getPackageAdmin() {
		ServiceTracker<PackageAdmin, PackageAdmin> tracker = paTracker;
		if (tracker == null)
			return null;
		return tracker.getService();
	}

	public Location getInstanceLocation() {
		if (instanceLocationTracker != null)
			return (Location) instanceLocationTracker.getService();
		return null;
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
}
