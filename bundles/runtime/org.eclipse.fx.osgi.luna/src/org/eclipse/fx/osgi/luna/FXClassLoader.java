package org.eclipse.fx.osgi.luna;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.Enumeration;

import org.eclipse.osgi.internal.debug.Debug;
import org.eclipse.osgi.internal.framework.EquinoxConfiguration;
import org.eclipse.osgi.internal.hookregistry.ClassLoaderHook;
import org.eclipse.osgi.internal.loader.BundleLoader;
import org.eclipse.osgi.internal.loader.ModuleClassLoader;
import org.eclipse.osgi.internal.loader.classpath.ClasspathManager;
import org.eclipse.osgi.storage.BundleInfo.Generation;

public class FXClassLoader extends ClassLoaderHook {
	private static final String SYMBOLIC_NAME = "org.eclipse.fx.javafx";

	public ModuleClassLoader createClassLoader(ClassLoader parent,
			EquinoxConfiguration configuration, BundleLoader delegate,
			Generation generation) {
		if (SYMBOLIC_NAME.equals(generation.getRevision().getBundle()
				.getSymbolicName())) {
			boolean swtAvailable = false; // TODO
			URLClassLoader cl = createJREBundledClassloader(parent,
					swtAvailable);
			return new FXModuleClassloader(cl, parent, configuration, delegate,
					generation);
		}
		return null;
	}

	static class FXModuleClassloader extends ModuleClassLoader {
		private final EquinoxConfiguration configuration;
		private final BundleLoader delegate;
		private final Generation generation;
		
		private final URLClassLoader fxClassloader;
		private ClasspathManager classpathManager;
		
		public FXModuleClassloader(final URLClassLoader fxClassloader,
				ClassLoader parent, EquinoxConfiguration configuration,
				BundleLoader delegate, Generation generation) {
			super(parent);
			this.configuration = configuration;
			this.delegate = delegate;
			this.generation = generation;
			this.fxClassloader = fxClassloader;
			this.classpathManager = new ClasspathManager(generation, this) {
				@Override
				public Class<?> findLocalClass(String classname)
						throws ClassNotFoundException {
					return fxClassloader.loadClass(classname);
				}
				
				@Override
				public URL findLocalResource(String resource) {
					return fxClassloader.findResource(resource);
				}
				
				@Override
				public Enumeration<URL> findLocalResources(String resource) {
					try {
						return fxClassloader.findResources(resource);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return Collections.emptyEnumeration();
				}
			};
		}

		@Override
		protected Generation getGeneration() {
			return generation;
		}

		@Override
		protected Debug getDebug() {
			return configuration.getDebug();
		}

		@Override
		public ClasspathManager getClasspathManager() {
			return classpathManager;
		}
		
		@Override
		protected EquinoxConfiguration getConfiguration() {
			return configuration;
		}

		@Override
		public BundleLoader getBundleLoader() {
			return delegate;
		}

		@Override
		public boolean isRegisteredAsParallel() {
			return false;
		}
		
//		@Override
//		public Class<?> findLocalClass(String classname)
//				throws ClassNotFoundException {
//			return fxClassloader.loadClass(classname);
//		}
//
//		@Override
//		public URL findLocalResource(String resource) {
//			return fxClassloader.findResource(resource);
//		}
//
//		@Override
//		public Enumeration<URL> findLocalResources(String resource) {
//			try {
//				return fxClassloader.findResources(resource);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return Collections.emptyEnumeration();
//		}
//		
//		@Override
//		protected Generation getGeneration() {
//			// TODO Auto-generated method stub
//			return null;
//		}

	}

	private static URLClassLoader createJREBundledClassloader(
			ClassLoader parent, boolean swtAvailable) {
		if (FXClassloaderConfigurator.DEBUG) {
			System.err
					.println("MyBundleClassLoader#createJREBundledClassloader - Started");
		}

		try {
			File javaHome;
			try {
				javaHome = new File(System.getProperty("java.home")).getCanonicalFile(); //$NON-NLS-1$
			} catch (IOException e) {
				throw new IllegalStateException("Unable to locate java home", e);
			}
			if (!javaHome.exists()) {
				throw new IllegalStateException("The java home '"
						+ javaHome.getAbsolutePath() + "' does not exits");
			}

			// Java 8 and maybe one day Java 7
			File jarFile = new File(new File(new File(
					javaHome.getAbsolutePath(), "lib"), "ext"), "jfxrt.jar");
			if (FXClassloaderConfigurator.DEBUG) {
				System.err
						.println("MyBundleClassLoader#createJREBundledClassloader - Assumed location (Java 8/Java 7): "
								+ jarFile.getAbsolutePath());
			}

			if (jarFile.exists()) {
				// if SWT is available we need to construct a new
				// URL-Classloader with SWT
				// bundles classloader as the parent
				if (swtAvailable) {
					if (FXClassloaderConfigurator.DEBUG) {
						System.err
								.println("MyBundleClassLoader#createJREBundledClassloader - SWT is available use different loading strategy");
					}

					// Since JDK8b113 the swt stuff is in its own jar
					File swtFX = new File(new File(javaHome.getAbsolutePath(),
							"lib"), "jfxswt.jar");

					if (FXClassloaderConfigurator.DEBUG) {
						System.err
								.println("MyBundleClassLoader#createJREBundledClassloader - Searching for SWT-FX integration at "
										+ swtFX.getAbsolutePath());
					}

					if (swtFX.exists()) {
						if (FXClassloaderConfigurator.DEBUG) {
							System.err
									.println("MyBundleClassLoader#createJREBundledClassloader - Found SWT/FX");
						}

						ClassLoader extClassLoader = ClassLoader
								.getSystemClassLoader().getParent();
						if (extClassLoader.getClass().getName()
								.equals("sun.misc.Launcher$ExtClassLoader")) {
							return new URLClassLoader(
									new URL[] { swtFX.getCanonicalFile()
											.toURI().toURL() },
									new SWTFXClassloader(parent, extClassLoader));
						}
						return new URLClassLoader(new URL[] {
								jarFile.getCanonicalFile().toURI().toURL(),
								swtFX.getCanonicalFile().toURI().toURL() },
								parent);
					} else {
						if (FXClassloaderConfigurator.DEBUG) {
							System.err
									.println("MyBundleClassLoader#createJREBundledClassloader - Assume that SWT-FX part of jfxrt.jar");
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
								.equals("sun.misc.Launcher$ExtClassLoader")) {
							return new URLClassLoader(new URL[] {},
									extClassLoader);
						}
					} catch (Throwable t) {
						t.printStackTrace();
					}
					URL url = jarFile.getCanonicalFile().toURI().toURL();
					URLClassLoader cl = new URLClassLoader(new URL[] { url },
							parent);
					return cl;
				}
			}

			// Java 7
			jarFile = new File(new File(javaHome.getAbsolutePath(), "lib"),
					"jfxrt.jar");
			if (FXClassloaderConfigurator.DEBUG) {
				System.err
						.println("MyBundleClassLoader#createJREBundledClassloader - Assumed location (Java 7): "
								+ jarFile.getAbsolutePath());
			}

			if (jarFile.exists()) {
				URL url = jarFile.getCanonicalFile().toURI().toURL();
				return new URLClassLoader(new URL[] { url }, parent);
			} else {
				if (FXClassloaderConfigurator.DEBUG) {
					System.err
							.println("MyBundleClassLoader#createJREBundledClassloader - File does not exist.");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (FXClassloaderConfigurator.DEBUG) {
				System.err
						.println("MyBundleClassLoader#createJREBundledClassloader - Ended");
			}
		}

		return null;
	}

	static class SWTFXClassloader extends ClassLoader {
		private final ClassLoader lastResortLoader;
		private final ClassLoader primaryLoader;

		public SWTFXClassloader(ClassLoader lastResortLoader,
				ClassLoader primaryLoader) {
			this.lastResortLoader = lastResortLoader;
			this.primaryLoader = primaryLoader;
		}

		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException {
			try {
				return primaryLoader.loadClass(name);
			} catch (ClassNotFoundException c) {
				try {
					return lastResortLoader.loadClass(name);
				} catch (ClassNotFoundException tmp) {
					throw c;
				}
			}
		}

		@Override
		protected URL findResource(String name) {
			URL url = primaryLoader.getResource(name);
			if (url == null) {
				url = lastResortLoader.getResource(name);
			}
			return url;
		}

		@Override
		protected Enumeration<URL> findResources(String name)
				throws IOException {
			final Enumeration<URL> en1 = primaryLoader.getResources(name);
			final Enumeration<URL> en2 = lastResortLoader.getResources(name);

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
			URL url = primaryLoader.getResource(name);
			if (url == null) {
				url = lastResortLoader.getResource(name);
			}
			return url;
		}

		@Override
		public InputStream getResourceAsStream(String name) {
			InputStream in = primaryLoader.getResourceAsStream(name);
			if (in == null) {
				in = lastResortLoader.getResourceAsStream(name);
			}
			return in;
		}

		@Override
		public Enumeration<URL> getResources(String name) throws IOException {
			final Enumeration<URL> en1 = primaryLoader.getResources(name);
			final Enumeration<URL> en2 = lastResortLoader.getResources(name);

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
				return primaryLoader.loadClass(name);
			} catch (ClassNotFoundException c) {
				try {
					return lastResortLoader.loadClass(name);
				} catch (ClassNotFoundException tmp) {
					throw c;
				}
			}
		}
	}
}
