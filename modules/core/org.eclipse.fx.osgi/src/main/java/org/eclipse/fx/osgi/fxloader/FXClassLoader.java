/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
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
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.osgi.internal.framework.EquinoxConfiguration;
import org.eclipse.osgi.internal.hookregistry.ClassLoaderHook;
import org.eclipse.osgi.internal.loader.BundleLoader;
import org.eclipse.osgi.internal.loader.ModuleClassLoader;
import org.eclipse.osgi.storage.BundleInfo.Generation;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.wiring.BundleWiring;

/**
 * Hook to overwrite OSGis default classloading
 */
public class FXClassLoader extends ClassLoaderHook {
	private static final String FX_SYMBOLIC_NAME = "org.eclipse.fx.javafx"; //$NON-NLS-1$
	private static final String SWT_SYMBOLIC_NAME = "org.eclipse.swt"; //$NON-NLS-1$

	private URLClassLoader classLoader;
//	private boolean swtAvailable;
	private BundleContext frameworkContext;
	private ClassLoader j9Classloader;

	private static boolean isJDK8() {
		return System.getProperty("java.version","").startsWith("1"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@SuppressWarnings("resource")
	@Override
	public Class<?> postFindClass(String name, ModuleClassLoader moduleClassLoader) throws ClassNotFoundException {
		// this is pre java 9
		if( isJDK8() ) {
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
					|| name.startsWith("com.sun.webkit") //$NON-NLS-1$
					) && ! moduleClassLoader.getBundle().getSymbolicName().equals("org.eclipse.swt")) { //$NON-NLS-1$
				URLClassLoader fxClassloader = getFXClassloader();
				if( fxClassloader != null ) {
					return fxClassloader.loadClass(name);
				} else {
					throw new ClassNotFoundException("Unable to locate JavaFX. Please make sure you have a JDK with JavaFX installed eg on Linux you require an Oracle JDK"); //$NON-NLS-1$
				}
			}
		} else {
			// We only need special things for javafx.embed because osgi-bundles on java9 have the ExtClassloader as its parent
			if( name.startsWith("javafx.embed") ) { //$NON-NLS-1$
				if( this.j9Classloader == null ) {
					try {
						this.j9Classloader = createModuleLoader(getSWTClassloader(this.frameworkContext));
						try {
							this.j9Classloader.loadClass("javafx.application.Platform").getDeclaredMethod("setImplicitExit", boolean.class).invoke(null, Boolean.FALSE);//$NON-NLS-1$ //$NON-NLS-2$
						} catch (Throwable e) {
							e.printStackTrace();
						}
					} catch (Throwable e) {
						throw new ClassNotFoundException("Could not find class '"+name+"'", e);  //$NON-NLS-1$//$NON-NLS-2$
					}
				}
				return this.j9Classloader.loadClass(name);
			}
		}


		return super.postFindClass(name, moduleClassLoader);
	}

	private ClassLoader createModuleLoader(ClassLoader swtClassloader) throws Throwable {
		Path path = Paths.get(System.getProperty("java.home")).resolve("lib").resolve("javafx-swt.jar"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		ClassLoader cl = getClass().getClassLoader();
		Class<?> ModuleFinderClass = cl.loadClass("java.lang.module.ModuleFinder"); //$NON-NLS-1$
		Class<?> LayerClass = cl.loadClass("java.lang.ModuleLayer"); //$NON-NLS-1$
		Class<?> ConfigurationClass = cl.loadClass("java.lang.module.Configuration"); //$NON-NLS-1$

//		ModuleFinder finder = ModuleFinder.of(path);
		Object finder = ModuleFinderClass.getMethod("of", Path[].class).invoke(null, new Object[] { new Path[] { path } }); //$NON-NLS-1$
//		Layer boot = Layer.boot();
		Object boot = LayerClass.getMethod("boot").invoke(null); //$NON-NLS-1$
//		Configuration configuration = boot.configuration();
		Object configuration = LayerClass.getMethod("configuration").invoke(boot); //$NON-NLS-1$
//		ModuleFinder of = ModuleFinder.of();
		Object of = ModuleFinderClass.getMethod("of", Path[].class).invoke(null, new Object[] { new Path[0] }); //$NON-NLS-1$
		Set<String> set = new HashSet<String>();
		set.add("javafx.swt"); //$NON-NLS-1$
//		Configuration cf = configuration.resolveRequires(finder, of, set); // since u158 it is only resolve see https://github.com/eclipse/efxclipse-rt/issues/16
		Object cf;
		try {
			cf = ConfigurationClass.getMethod("resolve", ModuleFinderClass, ModuleFinderClass, Collection.class).invoke(configuration, finder, of, set); //$NON-NLS-1$
		} catch( Throwable t ) {
			cf = ConfigurationClass.getMethod("resolveRequires", ModuleFinderClass, ModuleFinderClass, Collection.class).invoke(configuration, finder, of, set); //$NON-NLS-1$
		}

//		Layer layer = boot.defineModulesWithOneLoader(cf, Display.class.getClassLoader());
		Object layer = LayerClass.getMethod("defineModulesWithOneLoader", ConfigurationClass, ClassLoader.class).invoke(boot, cf, swtClassloader); //$NON-NLS-1$
//		ClassLoader loader = layer.findLoader("javafx.swt");
		ClassLoader loader = (ClassLoader) LayerClass.getMethod("findLoader", String.class).invoke(layer, "javafx.swt"); //$NON-NLS-1$ //$NON-NLS-2$
		return loader;
	}

	private URLClassLoader getFXClassloader() {
		if( this.classLoader == null ) {
			ClassLoader swtClassloader = getSWTClassloader(this.frameworkContext);
//			this.swtAvailable = swtClassloader != null;
			this.classLoader = createJREBundledClassloader(swtClassloader == null ? ClassLoader.getSystemClassLoader() : swtClassloader, swtClassloader != null);
		}
		return this.classLoader;
	}

	@Override
	public ModuleClassLoader createClassLoader(ClassLoader parent,
			EquinoxConfiguration configuration, BundleLoader delegate,
			Generation generation) {
		//FIXME Can we get rid of this?
		if( this.frameworkContext == null ) {
			this.frameworkContext = generation.getBundleInfo().getStorage().getModuleContainer().getFrameworkWiring().getBundle().getBundleContext();
		}
		if (FX_SYMBOLIC_NAME.equals(generation.getRevision().getBundle()
				.getSymbolicName())) {
			System.err.println("ERROR: Binding against 'org.eclipse.fx.javafx' had been deprecated since 2.x and has been removed in 3.x "); //$NON-NLS-1$
//			System.err.println("WARNING: You are binding against the deprecated org.eclipse.fx.javafx - please remove all javafx imports"); //$NON-NLS-1$
//			URLClassLoader cl = getFXClassloader();
//			return new FXModuleClassloader(this.swtAvailable, cl, parent, configuration, delegate,
//					generation);
		}
		return super.createClassLoader(parent, configuration, delegate, generation);
	}

	private static ClassLoader getSWTClassloader(BundleContext context) {
		try {
			// Should we better use findProviders() see PackageAdminImpl?
			for( Bundle b : context.getBundles() ) {
				if( SWT_SYMBOLIC_NAME.equals(b.getSymbolicName()) ) {
					if ((b.getState() & Bundle.INSTALLED) == 0) {
						// Ensure the bundle is started else we are unable to
						// extract the
						// classloader
						if ((b.getState() & Bundle.ACTIVE) != 0) {
							try {
								b.start();
							} catch (BundleException e) {
								e.printStackTrace();
							}
						}
						return b.adapt(BundleWiring.class).getClassLoader();
					}

				}
			}
		} catch(Throwable t) {
			System.err.println("Failed to access swt classloader"); //$NON-NLS-1$
			t.printStackTrace();
		}


		return null;
	}

	private static URLClassLoader createJREBundledClassloader(
			ClassLoader parent, boolean swtAvailable) {
		if (FXClassloaderConfigurator.DEBUG) {
			System.err
					.println("FXClassLoader#createJREBundledClassloader - Started"); //$NON-NLS-1$
		}

		try {
			File javaHome;
			try {
				javaHome = new File(System.getProperty("java.home")).getCanonicalFile(); //$NON-NLS-1$
			} catch (IOException e) {
				throw new IllegalStateException("Unable to locate java home", e); //$NON-NLS-1$
			}
			if (!javaHome.exists()) {
				throw new IllegalStateException("The java home '" //$NON-NLS-1$
						+ javaHome.getAbsolutePath() + "' does not exits"); //$NON-NLS-1$
			}

			// Java 8 and maybe one day Java 7
			File jarFile = new File(new File(new File(
					javaHome.getAbsolutePath(), "lib"), "ext"), "jfxrt.jar"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			if (FXClassloaderConfigurator.DEBUG) {
				System.err
						.println("FXClassLoader#createJREBundledClassloader - Assumed location (Java 8/Java 7): " //$NON-NLS-1$
								+ jarFile.getAbsolutePath());
			}

			if (jarFile.exists()) {
				// if SWT is available we need to construct a new
				// URL-Classloader with SWT
				// bundles classloader as the parent
				if (swtAvailable) {
					if (FXClassloaderConfigurator.DEBUG) {
						System.err
								.println("FXClassLoader#createJREBundledClassloader - SWT is available use different loading strategy"); //$NON-NLS-1$
					}

					// Since JDK8b113 the swt stuff is in its own jar
					File swtFX = new File(new File(javaHome.getAbsolutePath(),
							"lib"), "jfxswt.jar");  //$NON-NLS-1$//$NON-NLS-2$

					if (FXClassloaderConfigurator.DEBUG) {
						System.err
								.println("FXClassLoader#createJREBundledClassloader - Searching for SWT-FX integration at " //$NON-NLS-1$
										+ swtFX.getAbsolutePath());
					}

					if (swtFX.exists()) {
						if (FXClassloaderConfigurator.DEBUG) {
							System.err
									.println("FXClassLoader#createJREBundledClassloader - Found SWT/FX"); //$NON-NLS-1$
						}

						ClassLoader extClassLoader = ClassLoader
								.getSystemClassLoader().getParent();
						if (extClassLoader.getClass().getName()
								.equals("sun.misc.Launcher$ExtClassLoader")) { //$NON-NLS-1$
							if (FXClassloaderConfigurator.DEBUG) {
								System.err
										.println("FXClassLoader#createJREBundledClassloader - Delegate to system classloader"); //$NON-NLS-1$
							}

							return new URLClassLoader(
									new URL[] { swtFX.getCanonicalFile()
											.toURI().toURL() },
									new SWTFXClassloader(parent, extClassLoader));
						}

						if (FXClassloaderConfigurator.DEBUG) {
							System.err
									.println("FXClassLoader#createJREBundledClassloader - Using an URL classloader"); //$NON-NLS-1$
						}

						return new URLClassLoader(new URL[] {
								jarFile.getCanonicalFile().toURI().toURL(),
								swtFX.getCanonicalFile().toURI().toURL() },
								parent);
					} else {
						if (FXClassloaderConfigurator.DEBUG) {
							System.err
									.println("FXClassLoader#createJREBundledClassloader - Assume that SWT-FX part of jfxrt.jar"); //$NON-NLS-1$
						}

						URL url = jarFile.getCanonicalFile().toURI().toURL();
						return new URLClassLoader(new URL[] { url }, parent);
					}
				} else {
					// we should be able to delegate to the
					// URL-Extension-Classloader, which is essential for
					// ScenicView
					// which installs an JMX-Component
					try {
						ClassLoader extClassLoader = ClassLoader
								.getSystemClassLoader().getParent();
						if (extClassLoader.getClass().getName()
								.equals("sun.misc.Launcher$ExtClassLoader")) { //$NON-NLS-1$
							if (FXClassloaderConfigurator.DEBUG) {
								System.err
										.println("FXClassLoader#createJREBundledClassloader - Delegate to system classloader"); //$NON-NLS-1$
							}
							return new URLClassLoader(new URL[] {},
									extClassLoader);
						}
					} catch (Throwable t) {
						t.printStackTrace();
					}

					if (FXClassloaderConfigurator.DEBUG) {
						System.err
								.println("FXClassLoader#createJREBundledClassloader - Using an URL classloader"); //$NON-NLS-1$
					}

					URL url = jarFile.getCanonicalFile().toURI().toURL();
					URLClassLoader cl = new URLClassLoader(new URL[] { url },
							parent);
					return cl;
				}
			}

			// Java 7
			jarFile = new File(new File(javaHome.getAbsolutePath(), "lib"), //$NON-NLS-1$
					"jfxrt.jar"); //$NON-NLS-1$
			if (FXClassloaderConfigurator.DEBUG) {
				System.err
						.println("FXClassLoader#createJREBundledClassloader - Assumed location (Java 7): " //$NON-NLS-1$
								+ jarFile.getAbsolutePath());
			}

			if (jarFile.exists()) {
				URL url = jarFile.getCanonicalFile().toURI().toURL();
				return new URLClassLoader(new URL[] { url }, parent);
			} else {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err
							.println("FXClassLoader#createJREBundledClassloader - File does not exist."); //$NON-NLS-1$
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (FXClassloaderConfigurator.DEBUG) {
				System.err
						.println("FXClassLoader#createJREBundledClassloader - Ended"); //$NON-NLS-1$
			}
		}

		return null;
	}

	static class EmptyEnumeration implements Enumeration<URL> {
		static Enumeration<URL> INSTANCE = new EmptyEnumeration();

		@Override
		public boolean hasMoreElements() {
			return false;
		}

		@Override
		public URL nextElement() {
			return null;
		}

	}

	static class SWTFXClassloader extends ClassLoader {
		private final ClassLoader lastResortLoader;
		private final ClassLoader primaryLoader;
		private Boolean checkFlag = null;

		public SWTFXClassloader(ClassLoader lastResortLoader,
				ClassLoader primaryLoader) {
			this.lastResortLoader = lastResortLoader;
			this.primaryLoader = primaryLoader;
			if (FXClassloaderConfigurator.DEBUG) {
				System.err.println("FXClassLoader.SWTFXClassloader#init - Primary Loader " + primaryLoader); //$NON-NLS-1$
				System.err.println("FXClassLoader.SWTFXClassloader#init - Lastresort Loader " + lastResortLoader); //$NON-NLS-1$
			}
		}

		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {
			// We can never load stuff from there and this would lead to a loop
			if( name.startsWith("javafx.embed.swt") ) { //$NON-NLS-1$
				if( this.checkFlag == null ) {
					this.checkFlag = Boolean.TRUE;

					Boolean b = Boolean.FALSE;
					try {
						if( FXClassloaderConfigurator.DEBUG ) {
							System.err.println("FXModuleClassloader#findLocalClass - Someone is trying to load FXCanvas. Need to check for GTK3"); //$NON-NLS-1$
						}

						// Check for GTK3
						String value = (String) loadClass("org.eclipse.swt.SWT").getDeclaredMethod("getPlatform").invoke(null); //$NON-NLS-1$ //$NON-NLS-2$
						if( "gtk".equals(value) ) { //$NON-NLS-1$
							if( FXClassloaderConfigurator.DEBUG ) {
								System.err.println("FXModuleClassloader#findLocalClass - We are on GTK need to take a closer look"); //$NON-NLS-1$
							}
							b = (Boolean) loadClass("org.eclipse.swt.internal.gtk.OS").getDeclaredField("GTK3").get(null);  //$NON-NLS-1$//$NON-NLS-2$
						} else {
							if( FXClassloaderConfigurator.DEBUG ) {
								System.err.println("FXModuleClassloader#findLocalClass - OS is '"+value+"' no need to get upset all is fine"); //$NON-NLS-1$ //$NON-NLS-2$
							}
						}
					} catch (Throwable e) {
						System.err.println("FXModuleClassloader#findLocalClass - Failed to check for Gtk3"); //$NON-NLS-1$
						e.printStackTrace();
					}

					if( b.booleanValue() ) {
						if( FXClassloaderConfigurator.DEBUG ) {
							System.err.println("FXModuleClassloader#findLocalClass - We are on GTK3 - too bad need to disable JavaFX for now else we'll crash the JVM"); //$NON-NLS-1$
						}
						throw new ClassNotFoundException("SWT is running with GTK3 but JavaFX is linked against GTK2"); //$NON-NLS-1$
					}

					try {
						loadClass("javafx.application.Platform").getDeclaredMethod("setImplicitExit", boolean.class).invoke(null, Boolean.FALSE);//$NON-NLS-1$ //$NON-NLS-2$
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
				return super.findClass(name);
			}
			try {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err.println("FXClassLoader.SWTFXClassloader#findClass - Loading " + name + " with primary"); //$NON-NLS-1$ //$NON-NLS-2$
				}
				Class<?> loadClass = this.primaryLoader.loadClass(name);
				if (FXClassloaderConfigurator.DEBUG) {
					System.err.println("FXClassLoader.SWTFXClassloader#findClass - Result " + name + " " + loadClass); //$NON-NLS-1$ //$NON-NLS-2$
				}
				return loadClass;
			} catch (ClassNotFoundException c) {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err.println("FXClassLoader.SWTFXClassloader#findClass - ClassNotFoundException thrown"); //$NON-NLS-1$
					System.err.println("FXClassLoader.SWTFXClassloader#findClass - Loading " + name + " with last resort"); //$NON-NLS-1$ //$NON-NLS-2$
				}

				try {
					Class<?> loadClass = this.lastResortLoader.loadClass(name);
					if (FXClassloaderConfigurator.DEBUG) {
						System.err.println("FXClassLoader.SWTFXClassloader#findClass - Result " + name + " " + loadClass); //$NON-NLS-1$ //$NON-NLS-2$
					}
					return loadClass;
				} catch (ClassNotFoundException tmp) {
					if( FXClassloaderConfigurator.DEBUG ) {
						System.err.println("FXClassLoader.SWTFXClassloader#findClass - Even last resort was unable to load " + name); //$NON-NLS-1$
					}
					throw c;
				}
			}
		}

		@Override
		protected URL findResource(String name) {
			URL url = this.primaryLoader.getResource(name);
			if (url == null) {
				url = this.lastResortLoader.getResource(name);
			}
			return url;
		}

		@Override
		protected Enumeration<URL> findResources(String name)
				throws IOException {
			final Enumeration<URL> en1 = this.primaryLoader.getResources(name);
			final Enumeration<URL> en2 = this.lastResortLoader.getResources(name);

			return new Enumeration<URL>() {
				@Override
				public boolean hasMoreElements() {
					if (en1.hasMoreElements()) {
						return true;
					}
					return en2.hasMoreElements();
				}

				@Override
				public URL nextElement() {
					if (!en1.hasMoreElements()) {
						return en2.nextElement();
					}
					return en1.nextElement();
				}
			};
		}

		@Override
		public URL getResource(String name) {
			URL url = this.primaryLoader.getResource(name);
			if (url == null) {
				url = this.lastResortLoader.getResource(name);
			}
			return url;
		}

		@SuppressWarnings("resource")
		@Override
		public InputStream getResourceAsStream(String name) {
			InputStream in = this.primaryLoader.getResourceAsStream(name);
			if (in == null) {
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
					if (en1.hasMoreElements()) {
						return true;
					}
					return en2.hasMoreElements();
				}

				@Override
				public URL nextElement() {
					if (!en1.hasMoreElements()) {
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
			} catch (ClassNotFoundException c) {
				try {
					return this.lastResortLoader.loadClass(name);
				} catch (ClassNotFoundException tmp) {
					throw c;
				}
			}
		}
	}
}
