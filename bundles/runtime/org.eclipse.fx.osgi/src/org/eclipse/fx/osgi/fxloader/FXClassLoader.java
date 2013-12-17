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
import java.io.InputStream;
import java.lang.reflect.Method;
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

/**
 * Hook to overwrite OSGis default classloading
 */
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
		if (data.getBundle().getSymbolicName().equals("org.eclipse.fx.javafx")) { //$NON-NLS-1$
			try {
				MyBundleClassLoader cl = new MyBundleClassLoader(getPackageAdmin(), parent, delegate, domain, data, bundleclasspath, this.context);
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
		//NOTHING to be done
	}

	static class MyBundleClassLoader extends DefaultClassLoader {
		private URLClassLoader fxClassLoader;
		private boolean swtAvailable;
		private boolean implicitExitSet;

		public MyBundleClassLoader(PackageAdmin admin, ClassLoader parent, ClassLoaderDelegate delegate, ProtectionDomain domain, BaseData bundledata, String[] classpath, BundleContext context) throws Exception {
			super(parent, delegate, domain, bundledata, classpath);

			ClassLoader parentLoader = parent;
			// Trying to locate swt bundle so that if the swt integration is
			// used
			// we can load those
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
			
			this.fxClassLoader = createClassloader(parentLoader, admin, bundledata, context, this.swtAvailable);
		}

		private static URLClassLoader createJREBundledClassloader(ClassLoader parent, boolean swtAvailable) {
			if( FXClassLoadingConfigurator.DEBUG ) {
				System.err.println("MyBundleClassLoader#createJREBundledClassloader - Started"); //$NON-NLS-1$
			}
			
			try {
				File javaHome; 
				try {
					javaHome= new File (System.getProperty("java.home")).getCanonicalFile(); //$NON-NLS-1$
				} catch (IOException e) {
					throw new IllegalStateException("Unable to locate java home", e); //$NON-NLS-1$
				}
				if (!javaHome.exists()) {
					throw new IllegalStateException("The java home '"+javaHome.getAbsolutePath()+"' does not exits"); //$NON-NLS-1$ //$NON-NLS-2$
				}
				
				// Java 8 and maybe one day Java 7
				File jarFile = new File(new File(new File(javaHome.getAbsolutePath(),"lib"),"ext"),"jfxrt.jar"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				if( FXClassLoadingConfigurator.DEBUG ) {
					System.err.println("MyBundleClassLoader#createJREBundledClassloader - Assumed location (Java 8/Java 7): " + jarFile.getAbsolutePath()); //$NON-NLS-1$
				}
				
				if( jarFile.exists() ) {
					// if SWT is available we need to construct a new URL-Classloader with SWT
					// bundles classloader as the parent
					if( swtAvailable ) {
						if( FXClassLoadingConfigurator.DEBUG ) {
							System.err.println("MyBundleClassLoader#createJREBundledClassloader - SWT is available use different loading strategy"); //$NON-NLS-1$
						}
						
						// Since JDK8b113 the swt stuff is in its own jar
						File swtFX = new File(new File(javaHome.getAbsolutePath(),"lib"),"jfxswt.jar"); //$NON-NLS-1$ //$NON-NLS-2$
						
						if( FXClassLoadingConfigurator.DEBUG ) {
							System.err.println("MyBundleClassLoader#createJREBundledClassloader - Searching for SWT-FX integration at " + swtFX.getAbsolutePath()); //$NON-NLS-1$
						}
						
						if( swtFX.exists() ) {
							if( FXClassLoadingConfigurator.DEBUG ) {
								System.err.println("MyBundleClassLoader#createJREBundledClassloader - Found SWT/FX"); //$NON-NLS-1$
							}
							
							ClassLoader extClassLoader = ClassLoader.getSystemClassLoader().getParent();
							if( extClassLoader.getClass().getName().equals("sun.misc.Launcher$ExtClassLoader") ) { //$NON-NLS-1$
								return new URLClassLoader(new URL[] { swtFX.getCanonicalFile().toURI().toURL() }, new SWTFXClassloader(parent,extClassLoader));
							}
							return new URLClassLoader(new URL[] { jarFile.getCanonicalFile().toURI().toURL(), swtFX.getCanonicalFile().toURI().toURL() }, parent);							
						} else {
							if( FXClassLoadingConfigurator.DEBUG ) {
								System.err.println("MyBundleClassLoader#createJREBundledClassloader - Assume that SWT-FX part of jfxrt.jar"); //$NON-NLS-1$
							}

							URL url = jarFile.getCanonicalFile().toURI().toURL();
							return new URLClassLoader(new URL[] { url }, parent);	
						}
					} else {
						// we should be able to delegate to the URL-Extension-Classloader, which is essential for ScenicView
						// which installs an JMX-Component
						try {
							ClassLoader extClassLoader = ClassLoader.getSystemClassLoader().getParent();
							if( extClassLoader.getClass().getName().equals("sun.misc.Launcher$ExtClassLoader") ) { //$NON-NLS-1$
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
				jarFile = new File(new File(javaHome.getAbsolutePath(),"lib"),"jfxrt.jar"); //$NON-NLS-1$ //$NON-NLS-2$
				if( FXClassLoadingConfigurator.DEBUG ) {
					System.err.println("MyBundleClassLoader#createJREBundledClassloader - Assumed location (Java 7): " + jarFile.getAbsolutePath()); //$NON-NLS-1$
				}
				
				if( jarFile.exists() ) {
					URL url = jarFile.getCanonicalFile().toURI().toURL();
					return new URLClassLoader(new URL[] { url }, parent);
				} else {
					if( FXClassLoadingConfigurator.DEBUG ) {
						System.err.println("MyBundleClassLoader#createJREBundledClassloader - File does not exist."); //$NON-NLS-1$
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if( FXClassLoadingConfigurator.DEBUG ) {
					System.err.println("MyBundleClassLoader#createJREBundledClassloader - Ended"); //$NON-NLS-1$
				}
			}
			
			return null;
		}

		private static URLClassLoader createClassloader(ClassLoader parent, PackageAdmin admin, BaseData bundledata, BundleContext context, boolean swtAvailable) throws Exception {
			URLClassLoader loader;
			
			{
				if( FXClassLoadingConfigurator.DEBUG ) {
					System.err.println("MyBundleClassLoader#createClassloader - checking for JRE bundled javafx"); //$NON-NLS-1$
				}
				
				loader = createJREBundledClassloader(parent, swtAvailable);
			}
			
			if (loader != null) {
				return loader;
			}
			
			throw new IllegalStateException("You need to run at least Java7u6"); //$NON-NLS-1$
		}

		@Override
		public Class<?> findLocalClass(String classname) throws ClassNotFoundException {
			try {
				Class<?> cl = this.fxClassLoader.loadClass(classname);
				if( this.swtAvailable && ! this.implicitExitSet && "javafx.embed.swt.FXCanvas".equals(classname) ) { //$NON-NLS-1$
					try {
						Class<?> platformClass = this.fxClassLoader.loadClass("javafx.application.Platform"); //$NON-NLS-1$
						Method method = platformClass.getDeclaredMethod("setImplicitExit", boolean.class); //$NON-NLS-1$
						method.invoke(null, Boolean.FALSE);
						this.implicitExitSet = true;
					} catch (Throwable e) {
						System.err.println("Unable to setImplicitExit to false"); //$NON-NLS-1$
						e.printStackTrace();
					}
				}
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
				URL url = this.fxClassLoader.findResource(resource);
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

				Enumeration<URL> rv = this.fxClassLoader.findResources(name);
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
		// Nothing to be done

	}

	@Override
	public void frameworkStart(BundleContext context) throws BundleException {
		this.context = context;

		this.paTracker = new ServiceTracker<PackageAdmin, PackageAdmin>(context, PackageAdmin.class.getName(), null);
		this.paTracker.open();

		try {
			Filter filter = context.createFilter(Location.INSTANCE_FILTER);
			this.instanceLocationTracker = new ServiceTracker<Location,Location>(context, filter, null);
			this.instanceLocationTracker.open();
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}

		try {
			Filter filter = context.createFilter(Location.INSTALL_FILTER);
			this.installLocation = new ServiceTracker<Location,Location>(context, filter, null);
			this.installLocation.open();
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}

		this.preferenceServiceTracker = new ServiceTracker<Object,Object>(context, "org.eclipse.core.runtime.preferences.IPreferencesService", null); //$NON-NLS-1$
		this.preferenceServiceTracker.open();
	}

	@Override
	public void frameworkStop(BundleContext context) throws BundleException {
		this.paTracker.close();
		this.paTracker = null;

		this.instanceLocationTracker.close();
		this.instanceLocationTracker = null;

		this.installLocation.close();
		this.installLocation = null;

		this.preferenceServiceTracker.close();
		this.preferenceServiceTracker = null;
	}

	private PackageAdmin getPackageAdmin() {
		ServiceTracker<PackageAdmin, PackageAdmin> tracker = this.paTracker;
		if (tracker == null)
			return null;
		return tracker.getService();
	}

	@Override
	public void frameworkStopping(BundleContext context) {
		// Nothing todo
	}

	@Override
	public void addProperties(Properties properties) {
		// Nothing todo
	}

	@Override
	public URLConnection mapLocationToURLConnection(String location) throws IOException {
		return null;
	}

	@Override
	public void handleRuntimeError(Throwable error) {
		// Nothing todo
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
