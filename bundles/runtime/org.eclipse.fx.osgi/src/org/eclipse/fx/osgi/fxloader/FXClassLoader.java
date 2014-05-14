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
import java.util.Enumeration;

import org.eclipse.osgi.internal.debug.Debug;
import org.eclipse.osgi.internal.framework.EquinoxConfiguration;
import org.eclipse.osgi.internal.hookregistry.ClassLoaderHook;
import org.eclipse.osgi.internal.loader.BundleLoader;
import org.eclipse.osgi.internal.loader.ModuleClassLoader;
import org.eclipse.osgi.internal.loader.classpath.ClasspathManager;
import org.eclipse.osgi.storage.BundleInfo.Generation;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.wiring.BundleWiring;

/**
 * Hook to overwrite OSGis default classloading
 */
public class FXClassLoader extends ClassLoaderHook {
	private static final String FX_SYMBOLIC_NAME = "org.eclipse.fx.javafx"; //$NON-NLS-1$
	private static final String SWT_SYMBOLIC_NAME = "org.eclipse.swt"; //$NON-NLS-1$

	@Override
	public ModuleClassLoader createClassLoader(ClassLoader parent,
			EquinoxConfiguration configuration, BundleLoader delegate,
			Generation generation) {
		if (FX_SYMBOLIC_NAME.equals(generation.getRevision().getBundle()
				.getSymbolicName())) {
			ClassLoader swtClassloader = getSWTClassloader(generation);
			URLClassLoader cl = createJREBundledClassloader(swtClassloader == null ? parent : swtClassloader,swtClassloader != null);
			return new FXModuleClassloader(swtClassloader != null, cl, parent, configuration, delegate,
					generation);
		}
		return null;
	}
	
	private static ClassLoader getSWTClassloader(Generation generation) {
		for( Bundle b : generation.getRevision().getBundle().getBundleContext().getBundles() ) {
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
		
		return null;
	}
	

	static class FXModuleClassloader extends ModuleClassLoader {
		private final EquinoxConfiguration configuration;
		private final BundleLoader delegate;
		private final Generation generation;
		
		private ClasspathManager classpathManager;
		boolean implicitExitSet;
		
		
		public FXModuleClassloader(final boolean isSWT, final URLClassLoader fxClassloader,
				ClassLoader parent, EquinoxConfiguration configuration,
				BundleLoader delegate, Generation generation) {
			super(parent);
			this.configuration = configuration;
			this.delegate = delegate;
			this.generation = generation;
			this.classpathManager = new ClasspathManager(generation, this) {
				@Override
				public Class<?> findLocalClass(String classname)
						throws ClassNotFoundException {
					if(isSWT && ! FXModuleClassloader.this.implicitExitSet && "javafx.embed.swt.FXCanvas".equals(classname) ) { //$NON-NLS-1$					
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
								Boolean b = (Boolean) loadClass("org.eclipse.swt.internal.gtk.OS").getDeclaredField("GTK3").get(null);  //$NON-NLS-1$//$NON-NLS-2$
								if( b.booleanValue() ) {
									if( FXClassloaderConfigurator.DEBUG ) {
										System.err.println("FXModuleClassloader#findLocalClass - We are on GTK3 - too bad need to disable JavaFX for now else we'll crash the JVM"); //$NON-NLS-1$
									}
									throw new ClassNotFoundException("SWT is running with GTK3 but JavaFX is linked against GTK2"); //$NON-NLS-1$
								}
							}
							
							if( FXClassloaderConfigurator.DEBUG ) {
								System.err.println("FXModuleClassloader#findLocalClass - We need to disable implicit exiting when running in embedded mode"); //$NON-NLS-1$
							}
						} catch (Throwable e) {
							System.err.println("FXModuleClassloader#findLocalClass - Failed to check for Gtk3"); //$NON-NLS-1$
							e.printStackTrace();
						}
						
						try {
							loadClass("javafx.application.Platform").getDeclaredMethod("setImplicitExit", boolean.class).invoke(null, Boolean.FALSE); //$NON-NLS-1$ //$NON-NLS-2$
							FXModuleClassloader.this.implicitExitSet = true;
						} catch (Throwable e) {
							System.err.println("FXModuleClassloader#findLocalClass - Unable to setImplicitExit to false"); //$NON-NLS-1$
							e.printStackTrace();
						}
					}
					
					return fxClassloader.loadClass(classname);
				}
				
				@Override
				public URL findLocalResource(String resource) {
					return fxClassloader.getResource(resource);
				}
				
				@Override
				public Enumeration<URL> findLocalResources(String resource) {
					try {
						return fxClassloader.getResources(resource);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return EmptyEnumeration.INSTANCE;
				}
			};
		}

		@Override
		protected Generation getGeneration() {
			return this.generation;
		}

		@Override
		protected Debug getDebug() {
			return this.configuration.getDebug();
		}

		@Override
		public ClasspathManager getClasspathManager() {
			return this.classpathManager;
		}
		
		@Override
		protected EquinoxConfiguration getConfiguration() {
			return this.configuration;
		}

		@Override
		public BundleLoader getBundleLoader() {
			return this.delegate;
		}

		@Override
		public boolean isRegisteredAsParallel() {
			return false;
		}
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
		private boolean implicitExitSet;
		
		public SWTFXClassloader(ClassLoader lastResortLoader,
				ClassLoader primaryLoader) {
			this.lastResortLoader = lastResortLoader;
			this.primaryLoader = primaryLoader;
		}

		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {
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
