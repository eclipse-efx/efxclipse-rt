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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.osgi.internal.framework.EquinoxConfiguration;
import org.eclipse.osgi.internal.hookregistry.ClassLoaderHook;
import org.eclipse.osgi.internal.loader.BundleLoader;
import org.eclipse.osgi.internal.loader.ModuleClassLoader;
import org.eclipse.osgi.service.urlconversion.URLConverter;
import org.eclipse.osgi.storage.BundleInfo.Generation;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.util.tracker.ServiceTracker;

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
	private Object moduleLayer;
	private ClassLoader j11Classloader;
	private static Boolean IS_EQUAL_GREATER_11;
	private static Boolean IS_JAVA_8;
	private static Map<String, ServiceTracker<Object, URLConverter>> urlTrackers = new HashMap<>();

	static boolean isJDK8() {
		if (IS_JAVA_8 != null) {
			return IS_JAVA_8.booleanValue();
		}
		boolean rv = System.getProperty("java.version", "").startsWith("1.8"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		IS_JAVA_8 = Boolean.valueOf(rv);
		return rv;
	}

	private static boolean isEqualGreaterJDK11() {
		if (IS_EQUAL_GREATER_11 != null) {
			return IS_EQUAL_GREATER_11.booleanValue();
		}
		String version = System.getProperty("java.version", ""); //$NON-NLS-1$//$NON-NLS-2$
		String[] parts = version.split("\\D"); //$NON-NLS-1$
		boolean rv = false;
		try {
			rv = Integer.parseInt(parts[0]) >= 11;
		} catch (Throwable e) {
			// TODO: handle exception
		}
		IS_EQUAL_GREATER_11 = Boolean.valueOf(rv);
		return rv;
	}

	@SuppressWarnings("resource")
	@Override
	public Class<?> postFindClass(String name, ModuleClassLoader moduleClassLoader) throws ClassNotFoundException {
		// this is pre java 9
		if (isJDK8()) {
			if ((name.startsWith("javafx") //$NON-NLS-1$
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
			) && !moduleClassLoader.getBundle().getSymbolicName().equals("org.eclipse.swt")) { //$NON-NLS-1$
				URLClassLoader fxClassloader = getFXClassloader();
				if (fxClassloader != null) {
					return fxClassloader.loadClass(name);
				} else {
					throw new ClassNotFoundException(
							"Unable to locate JavaFX. Please make sure you have a JDK with JavaFX installed eg on Linux you require an Oracle JDK"); //$NON-NLS-1$
				}
			}
		} else if (isEqualGreaterJDK11()) {
			// JavaFX is not part of JDK anymore need to install modules on the fly
			try {
				return findClassJavaFX11(name, moduleClassLoader);
			} catch (Throwable e) {
				return null;
			}
		} else {
			// We only need special things for javafx.embed because osgi-bundles on java9
			// have the ExtClassloader as its parent
			if (name.startsWith("javafx.embed")) { //$NON-NLS-1$
				synchronized (this) {
					if (this.j9Classloader == null) {
						try {
							this.j9Classloader = createModuleLoader(getModuleLayer(), "javafx.swt"); //$NON-NLS-1$

							try {
								this.j9Classloader.loadClass("javafx.application.Platform") //$NON-NLS-1$
										.getDeclaredMethod("setImplicitExit", boolean.class).invoke(null, Boolean.FALSE);//$NON-NLS-1$
							} catch (Throwable e) {
								e.printStackTrace();
							}
						} catch (Throwable e) {
							throw new ClassNotFoundException("Could not find class '" + name + "'", e); //$NON-NLS-1$//$NON-NLS-2$
						}
					}
					return this.j9Classloader.loadClass(name);
				}
			}
		}

		return super.postFindClass(name, moduleClassLoader);
	}

	private Class<?> findClassJavaFX11(String name, ModuleClassLoader moduleClassLoader) throws Throwable {
		if (FXClassloaderConfigurator.DEBUG) {
			System.err.println("FXClassLoader#findClassJavaFX11 - started on thread " + Thread.currentThread() ); //$NON-NLS-1$
			System.err.println("Loading class '" + name + "'"); //$NON-NLS-1$//$NON-NLS-2$
		}

		synchronized (this) {
			if( this.j11Classloader == null ) {
				// As all modules are loaded by the same classloader using javafx.base is OK
				this.j11Classloader = createModuleLoader(getModuleLayer(), "javafx.base"); //$NON-NLS-1$			
			}
		}

		if (FXClassloaderConfigurator.DEBUG) {
			System.err.println("FXClassLoader#findClassJavaFX11 - Using classloader " + this.j11Classloader); //$NON-NLS-1$
		}

		Class<?> loadClass = this.j11Classloader.loadClass(name);

		if (FXClassloaderConfigurator.DEBUG) {
			System.err.println("FXClassLoader#findClassJavaFX11 - ended"); //$NON-NLS-1$
		}
		return loadClass;
	}

	private static ClassLoader createModuleLoader(Object moduleLayer, String moduleName) throws Throwable {
//		ClassLoader loader = layer.findLoader("javafx.swt");
		ClassLoader loader = (ClassLoader) moduleLayer.getClass().getMethod("findLoader", String.class) //$NON-NLS-1$
				.invoke(moduleLayer, moduleName);
		return loader;
	}

	private synchronized Object getModuleLayer() throws Throwable {
		if (isEqualGreaterJDK11()) {
			if (this.moduleLayer == null) {
				String javafxDir = System.getProperty("efxclipse.java-modules.dir"); //$NON-NLS-1$

				List<FXProviderBundle> providers = new ArrayList<>();

				if (javafxDir == null) {
					providers = getDeployedJavaModuleBundlePaths(this.frameworkContext);
				} else {
					String[] paths = javafxDir.split(";"); //$NON-NLS-1$
					for( String dir : paths ) {
						Path path = Paths.get(dir);
						if( Files.exists(path) ) {
							providers = Files.list(path) //
									.filter(p -> p.toString().endsWith(".jar")) //$NON-NLS-1$
									.map(p -> new FXProviderBundle(
											p.getFileName().toString().replace(".jar", "").replace('-', '.'), p)) //$NON-NLS-1$//$NON-NLS-2$
									.collect(Collectors.toList());
							break;
						}
					}
				}
				ClassLoader parentClassloader = getSWTClassloader(this.frameworkContext);
				if (parentClassloader == null) {
					parentClassloader = getClass().getClassLoader();
				}

				this.moduleLayer = initModuleLayer(parentClassloader, providers);
			}
		} else {
			if (this.moduleLayer == null) {
				Path path = Paths.get(System.getProperty("java.home")).resolve("lib").resolve("javafx-swt.jar"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

				ClassLoader parentClassloader = getSWTClassloader(this.frameworkContext);
				if (parentClassloader == null) {
					parentClassloader = getClass().getClassLoader();
				}

				this.moduleLayer = initModuleLayer(parentClassloader,
						Collections.singletonList(new FXProviderBundle("javafx.swt", path))); //$NON-NLS-1$
			}
		}

		return this.moduleLayer;
	}

	private Object initModuleLayer(ClassLoader parentClassloader, List<FXProviderBundle> bundles) throws Throwable {
		Path[] paths = bundles.stream().map(p -> p.path).toArray(i -> new Path[i]);
		Set<String> modules = bundles.stream().map(p -> p.module).collect(Collectors.toSet());
		
		if( FXClassloaderConfigurator.DEBUG ) {
			for( FXProviderBundle b : bundles ) {
				System.err.println( b.module + " => " + b.path); //$NON-NLS-1$
			}
		}

		ClassLoader cl = getClass().getClassLoader();
		Class<?> ModuleFinderClass = cl.loadClass("java.lang.module.ModuleFinder"); //$NON-NLS-1$
		Class<?> LayerClass = cl.loadClass("java.lang.ModuleLayer"); //$NON-NLS-1$
		Class<?> ConfigurationClass = cl.loadClass("java.lang.module.Configuration"); //$NON-NLS-1$

//		ModuleFinder finder = ModuleFinder.of(path);
		Object finder = ModuleFinderClass.getMethod("of", Path[].class).invoke(null, new Object[] { paths }); //$NON-NLS-1$
//		Layer boot = Layer.boot();
		Object boot = LayerClass.getMethod("boot").invoke(null); //$NON-NLS-1$
//		Configuration configuration = boot.configuration();
		Object configuration = LayerClass.getMethod("configuration").invoke(boot); //$NON-NLS-1$
//		ModuleFinder of = ModuleFinder.of();
		Object of = ModuleFinderClass.getMethod("of", Path[].class).invoke(null, new Object[] { new Path[0] }); //$NON-NLS-1$

//		Configuration cf = configuration.resolveRequires(finder, of, set); // since u158 it is only resolve see https://github.com/eclipse/efxclipse-rt/issues/16
		Object cf = ConfigurationClass.getMethod("resolve", ModuleFinderClass, ModuleFinderClass, Collection.class) //$NON-NLS-1$
				.invoke(configuration, finder, of, modules);

//		Layer layer = boot.defineModulesWithOneLoader(cf, Display.class.getClassLoader());
		Object layer = LayerClass.getMethod("defineModulesWithOneLoader", ConfigurationClass, ClassLoader.class) //$NON-NLS-1$
				.invoke(boot, cf, parentClassloader);
		return layer;
	}

	private URLClassLoader getFXClassloader() {
		if (this.classLoader == null) {
			ClassLoader swtClassloader = getSWTClassloader(this.frameworkContext);
//			this.swtAvailable = swtClassloader != null;
			this.classLoader = createJREBundledClassloader(
					swtClassloader == null ? ClassLoader.getSystemClassLoader() : swtClassloader,
					swtClassloader != null);
		}
		return this.classLoader;
	}

	public static URLConverter getURLConverter(URL url, BundleContext ctx) {
		if (url == null || ctx == null) {
			return null;
		}
		String protocol = url.getProtocol();
		synchronized (urlTrackers) {
			ServiceTracker<Object, URLConverter> tracker = urlTrackers.get(protocol);
			if (tracker == null) {
				// get the right service based on the protocol
				String FILTER_PREFIX = "(&(objectClass=" + URLConverter.class.getName() + ")(protocol="; //$NON-NLS-1$ //$NON-NLS-2$
				String FILTER_POSTFIX = "))"; //$NON-NLS-1$
				Filter filter = null;
				try {
					filter = ctx.createFilter(FILTER_PREFIX + protocol + FILTER_POSTFIX);
				} catch (InvalidSyntaxException e) {
					return null;
				}
				tracker = new ServiceTracker<>(ctx, filter, null);
				tracker.open();
				// cache it in the registry
				urlTrackers.put(protocol, tracker);
			}
			return tracker.getService();
		}
	}

	@Override
	public synchronized ModuleClassLoader createClassLoader(ClassLoader parent, EquinoxConfiguration configuration,
			BundleLoader delegate, Generation generation) {
		// FIXME Can we get rid of this?
		if (this.frameworkContext == null) {
			this.frameworkContext = generation.getBundleInfo().getStorage().getModuleContainer().getFrameworkWiring()
					.getBundle().getBundleContext();
		}
		if (FX_SYMBOLIC_NAME.equals(generation.getRevision().getBundle().getSymbolicName())) {
			System.err.println(
					"ERROR: Binding against 'org.eclipse.fx.javafx' had been deprecated since 2.x and has been removed in 3.x "); //$NON-NLS-1$
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
			for (Bundle b : context.getBundles()) {
				if (SWT_SYMBOLIC_NAME.equals(b.getSymbolicName())) {
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
		} catch (Throwable t) {
			System.err.println("Failed to access swt classloader"); //$NON-NLS-1$
			t.printStackTrace();
		}

		return null;
	}

	private static List<FXProviderBundle> getDeployedJavaModuleBundlePaths(BundleContext context) {
		List<FXProviderBundle> paths = new ArrayList<>();
		
		if( FXClassloaderConfigurator.DEBUG ) {
			System.err.println("Loading libraries from deployed modules"); //$NON-NLS-1$
		}
		for (Bundle b : context.getBundles()) {
			if (((b.getState() & Bundle.RESOLVED) == Bundle.RESOLVED
					|| (b.getState() & Bundle.ACTIVE) == Bundle.ACTIVE) && b.getHeaders().get("Java-Module") != null) { //$NON-NLS-1$
				String name = b.getHeaders().get("Java-Module"); //$NON-NLS-1$
				if( FXClassloaderConfigurator.DEBUG ) {
					System.err.println("Found OSGi-Module with JPMS-Module '" + name + "'");  //$NON-NLS-1$//$NON-NLS-2$
				}
				URL entry = b.getEntry(name + ".jar"); //$NON-NLS-1$
				// if it is an automatic module - is used
				if (entry == null) {
					entry = b.getEntry(name.replace('.', '-') + ".jar"); //$NON-NLS-1$
				}
				
				if( FXClassloaderConfigurator.DEBUG ) {
					System.err.println("Found Jar '"+entry+"'");  //$NON-NLS-1$//$NON-NLS-2$
				}

				if (entry != null) {
					URLConverter converter = getURLConverter(entry, context);
					try {
						URL url = converter.toFileURL(entry);
						paths.add(new FXProviderBundle(name, Paths.get(url.getFile())));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}

		return paths;
	}

	static class FXProviderBundle {
		final String module;
		final Path path;

		public FXProviderBundle(String module, Path path) {
			this.module = module;
			this.path = path;
		}

		@Override
		public String toString() {
			return "FXProviderBundle [module=" + this.module + ", path=" + this.path + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}

	private static URLClassLoader createJREBundledClassloader(ClassLoader parent, boolean swtAvailable) {
		if (FXClassloaderConfigurator.DEBUG) {
			System.err.println("FXClassLoader#createJREBundledClassloader - Started"); //$NON-NLS-1$
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
			File jarFile = new File(new File(new File(javaHome.getAbsolutePath(), "lib"), "ext"), "jfxrt.jar"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			if (FXClassloaderConfigurator.DEBUG) {
				System.err.println("FXClassLoader#createJREBundledClassloader - Assumed location (Java 8/Java 7): " //$NON-NLS-1$
						+ jarFile.getAbsolutePath());
			}

			if (jarFile.exists()) {
				// if SWT is available we need to construct a new
				// URL-Classloader with SWT
				// bundles classloader as the parent
				if (swtAvailable) {
					if (FXClassloaderConfigurator.DEBUG) {
						System.err.println(
								"FXClassLoader#createJREBundledClassloader - SWT is available use different loading strategy"); //$NON-NLS-1$
					}

					// Since JDK8b113 the swt stuff is in its own jar
					File swtFX = new File(new File(javaHome.getAbsolutePath(), "lib"), "jfxswt.jar"); //$NON-NLS-1$//$NON-NLS-2$

					if (FXClassloaderConfigurator.DEBUG) {
						System.err.println(
								"FXClassLoader#createJREBundledClassloader - Searching for SWT-FX integration at " //$NON-NLS-1$
										+ swtFX.getAbsolutePath());
					}

					if (swtFX.exists()) {
						if (FXClassloaderConfigurator.DEBUG) {
							System.err.println("FXClassLoader#createJREBundledClassloader - Found SWT/FX"); //$NON-NLS-1$
						}

						ClassLoader extClassLoader = ClassLoader.getSystemClassLoader().getParent();
						if (extClassLoader.getClass().getName().equals("sun.misc.Launcher$ExtClassLoader")) { //$NON-NLS-1$
							if (FXClassloaderConfigurator.DEBUG) {
								System.err.println(
										"FXClassLoader#createJREBundledClassloader - Delegate to system classloader"); //$NON-NLS-1$
							}

							return new URLClassLoader(new URL[] { swtFX.getCanonicalFile().toURI().toURL() },
									new SWTFXClassloader(parent, extClassLoader));
						}

						if (FXClassloaderConfigurator.DEBUG) {
							System.err.println("FXClassLoader#createJREBundledClassloader - Using an URL classloader"); //$NON-NLS-1$
						}

						return new URLClassLoader(new URL[] { jarFile.getCanonicalFile().toURI().toURL(),
								swtFX.getCanonicalFile().toURI().toURL() }, parent);
					} else {
						if (FXClassloaderConfigurator.DEBUG) {
							System.err.println(
									"FXClassLoader#createJREBundledClassloader - Assume that SWT-FX part of jfxrt.jar"); //$NON-NLS-1$
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
						ClassLoader extClassLoader = ClassLoader.getSystemClassLoader().getParent();
						if (extClassLoader.getClass().getName().equals("sun.misc.Launcher$ExtClassLoader")) { //$NON-NLS-1$
							if (FXClassloaderConfigurator.DEBUG) {
								System.err.println(
										"FXClassLoader#createJREBundledClassloader - Delegate to system classloader"); //$NON-NLS-1$
							}
							return new URLClassLoader(new URL[] {}, extClassLoader);
						}
					} catch (Throwable t) {
						t.printStackTrace();
					}

					if (FXClassloaderConfigurator.DEBUG) {
						System.err.println("FXClassLoader#createJREBundledClassloader - Using an URL classloader"); //$NON-NLS-1$
					}

					URL url = jarFile.getCanonicalFile().toURI().toURL();
					URLClassLoader cl = new URLClassLoader(new URL[] { url }, parent);
					return cl;
				}
			}

			// Java 7
			jarFile = new File(new File(javaHome.getAbsolutePath(), "lib"), //$NON-NLS-1$
					"jfxrt.jar"); //$NON-NLS-1$
			if (FXClassloaderConfigurator.DEBUG) {
				System.err.println("FXClassLoader#createJREBundledClassloader - Assumed location (Java 7): " //$NON-NLS-1$
						+ jarFile.getAbsolutePath());
			}

			if (jarFile.exists()) {
				URL url = jarFile.getCanonicalFile().toURI().toURL();
				return new URLClassLoader(new URL[] { url }, parent);
			} else {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err.println("FXClassLoader#createJREBundledClassloader - File does not exist."); //$NON-NLS-1$
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (FXClassloaderConfigurator.DEBUG) {
				System.err.println("FXClassLoader#createJREBundledClassloader - Ended"); //$NON-NLS-1$
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

		public SWTFXClassloader(ClassLoader lastResortLoader, ClassLoader primaryLoader) {
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
			if (name.startsWith("javafx.embed.swt")) { //$NON-NLS-1$
				if (this.checkFlag == null) {
					this.checkFlag = Boolean.TRUE;
					
					// On JDK-8 we need to check for GTK3
					if( isJDK8() ) {
						Boolean isGTK3 = Boolean.FALSE;
						try {
							
							if (FXClassloaderConfigurator.DEBUG) {
								System.err.println(
										"FXModuleClassloader#findLocalClass - Someone is trying to load FXCanvas. Need to check for GTK3"); //$NON-NLS-1$
							}

							// Check for GTK3
							String value = (String) loadClass("org.eclipse.swt.SWT").getDeclaredMethod("getPlatform") //$NON-NLS-1$ //$NON-NLS-2$
									.invoke(null);
							if ("gtk".equals(value)) { //$NON-NLS-1$
								if (FXClassloaderConfigurator.DEBUG) {
									System.err.println(
											"FXModuleClassloader#findLocalClass - We are on GTK need to take a closer look"); //$NON-NLS-1$
								}
								
								// Constants moved with Photon
								try {
									isGTK3 = (Boolean) loadClass("org.eclipse.swt.internal.gtk.GTK").getDeclaredField("GTK3") //$NON-NLS-1$//$NON-NLS-2$
											.get(null);
								} catch( Throwable t) {
									isGTK3 = (Boolean) loadClass("org.eclipse.swt.internal.gtk.OS").getDeclaredField("GTK3") //$NON-NLS-1$//$NON-NLS-2$
											.get(null);
								}
							} else {
								if (FXClassloaderConfigurator.DEBUG) {
									System.err.println("FXModuleClassloader#findLocalClass - OS is '" + value //$NON-NLS-1$
											+ "' no need to get upset all is fine"); //$NON-NLS-1$
								}
							}
						} catch (Throwable e) {
							System.err.println("FXModuleClassloader#findLocalClass - Failed to check for Gtk3"); //$NON-NLS-1$
							e.printStackTrace();
						}

						if (isGTK3.booleanValue()) {
							if (FXClassloaderConfigurator.DEBUG) {
								System.err.println(
										"FXModuleClassloader#findLocalClass - We are on GTK3 - too bad need to disable JavaFX for now else we'll crash the JVM"); //$NON-NLS-1$
							}
							throw new ClassNotFoundException("SWT is running with GTK3 but JavaFX is linked against GTK2"); //$NON-NLS-1$
						}
					}
					
					try {
						loadClass("javafx.application.Platform").getDeclaredMethod("setImplicitExit", boolean.class) //$NON-NLS-1$ //$NON-NLS-2$
								.invoke(null, Boolean.FALSE);
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
					System.err.println(
							"FXClassLoader.SWTFXClassloader#findClass - Loading " + name + " with last resort"); //$NON-NLS-1$ //$NON-NLS-2$
				}

				try {
					Class<?> loadClass = this.lastResortLoader.loadClass(name);
					if (FXClassloaderConfigurator.DEBUG) {
						System.err
								.println("FXClassLoader.SWTFXClassloader#findClass - Result " + name + " " + loadClass); //$NON-NLS-1$ //$NON-NLS-2$
					}
					return loadClass;
				} catch (ClassNotFoundException tmp) {
					if (FXClassloaderConfigurator.DEBUG) {
						System.err.println(
								"FXClassLoader.SWTFXClassloader#findClass - Even last resort was unable to load " //$NON-NLS-1$
										+ name);
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
		protected Enumeration<URL> findResources(String name) throws IOException {
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
