/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.test.junit.e4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.core.ServiceUtils;
import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.core.ThreadSynchronize.BlockCondition;
import org.eclipse.fx.core.app.ApplicationContext;
import org.eclipse.fx.core.app.ApplicationInstance;
import org.eclipse.fx.core.app.ApplicationLocation;
import org.eclipse.fx.core.app.ExitStatus;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.test.junit.FXTest;
import org.eclipse.fx.test.junit.FXTestRule;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.workbench.fx.E4Application;
import org.eclipse.osgi.service.datalocation.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

import javafx.application.Platform;

/**
 * Base class for JUnit-Testing an e4 JavaFX application
 */
public abstract class E4JunitTestCase {
	/**
	 * Rule instance to use if methods are marked with {@link FXTest}
	 */
	@Rule
	public FXTestRule r = new FXTestRule();

	private String productId;

	private ApplicationInstance runningApplication;

	private ServiceRegistration<EventHandler> registerService;

	private BlockCondition<Void> condition = new BlockCondition<>();

	private MWindow window;

	/**
	 * Create a new test instance
	 * 
	 * @param productId
	 *            the product id to test
	 */
	public E4JunitTestCase(String productId) {
		this.productId = productId;
	}

	private BundleContext getBundleContext() {
		return FrameworkUtil.getBundle(E4TestFXApplication.class).getBundleContext();
	}

	/**
	 * Launch the Eclipse 4 Application
	 */
	@Before
	public void launchApplication() {
		EventHandler handler = new EventHandler() {
			public void handleEvent(final Event event) {
				Platform.runLater(() -> {
					condition.release(null);
				});
			}
		};
		Dictionary<String, String> properties = new Hashtable<String, String>();
		properties.put(EventConstants.EVENT_TOPIC, Constants.APPLICATION_LAUNCHED);
		registerService = getBundleContext().registerService(EventHandler.class, handler, properties);

		final List<String> brandingArgs = new ArrayList<>();
		if (productId != null) {
			IConfigurationElement[] elements = RegistryFactory.getRegistry()
					.getConfigurationElementsFor("org.eclipse.core.runtime", "products", productId);
			if (elements != null && elements.length > 0) {
				for (IConfigurationElement prop : elements[0].getChildren("property")) {
					brandingArgs.add("-" + prop.getAttribute("name"));
					brandingArgs.add(prop.getAttribute("value"));
				}
			}
		}

		runningApplication = new E4TestFXApplication();
		runningApplication.launch(new ApplicationContext() {

			@Override
			public Optional<Splash> getSplashImage() {
				return Optional.empty();
			}

			@Override
			public Optional<ApplicationLocation> getInstanceLocation() {
				BundleContext context = FrameworkUtil.getBundle(getClass()).getBundleContext();
				try {
					Collection<ServiceReference<Location>> references = context.getServiceReferences(Location.class,
							Location.INSTANCE_FILTER);
					if (!references.isEmpty()) {
						return Optional
								.of(new ApplicationLocationImpl(context.getService(references.iterator().next())));
					} else {
						LoggerCreator.createLogger(getClass()).error("Could not find an instance location service"); //$NON-NLS-1$
					}
				} catch (InvalidSyntaxException e) {
					LoggerCreator.createLogger(getClass())
							.error("Failed to create a filter '" + Location.INSTANCE_FILTER + "'", e); //$NON-NLS-1$//$NON-NLS-2$
				}
				return Optional.empty();
			}

			@Override
			public Object getApplicationProperty(String key) {
				return null;
			}

			@Override
			public String[] getApplicationArguments() {
				return brandingArgs.toArray(new String[0]);
			}

			@Override
			public void applicationRunning() {

			}
		}).whenComplete((s, t) -> {
			if (t != null) {
				t.printStackTrace();
			}
		});

		ThreadSynchronize service = ServiceUtils.getService(ThreadSynchronize.class).get();
		service.block(condition);
	}

	protected MWindow getMainWindow() {
		return window;
	}

	/**
	 * Shut down the application
	 */
	@After
	public void closeApplication() {
		registerService.unregister();
		runningApplication.stop(ExitStatus.OK);
	}

	private class E4TestFXApplication extends E4Application {
		private E4Workbench workbench;

		@Override
		public Object start(IApplicationContext context) throws Exception {
			return super.start(context);
		}

		@Override
		public E4Workbench createE4Workbench(ApplicationContext applicationContext, IEclipseContext appContext) {
			workbench = super.createE4Workbench(applicationContext, appContext);
			window = workbench.getApplication().getChildren().get(0);
			return workbench;
		}

		@Override
		public void stop() {
			super.stop();
			workbench.close();
		}

		@Override
		public void stop(ExitStatus status) {
			super.stop(status);
			workbench.close();
		}

		@Override
		protected void launchE4JavaFxApplication() throws Exception {
			jfxStart(getApplicationContext(), null, null);
		}

		@Override
		public boolean checkInstanceLocation(ApplicationLocation instanceLocation, IEclipseContext context) {
			return true;
		}
	}

	private static class ApplicationLocationImpl implements ApplicationLocation, Location {
		private final Location location;

		public ApplicationLocationImpl(Location location) {
			this.location = location;
		}

		@Override
		public boolean lock() throws IOException {
			return this.location.lock();
		}

		@Override
		public void release() {
			this.location.release();
		}

		@Override
		public Path getPath() {
			URL url = this.location.getURL();
			try {
				return Paths.get(url.toURI());
			} catch (URISyntaxException e) {
				LoggerCreator.createLogger(getClass()).error("Failed to get the path for '" + url + "'", e); //$NON-NLS-1$//$NON-NLS-2$
			}
			return null;
		}

		@Override
		public URL getURL() {
			return this.location.getURL();
		}

		@Override
		public boolean isReadOnly() {
			return this.location.isReadOnly();
		}

		@Override
		public boolean allowsDefault() {
			return this.location.allowsDefault();
		}

		@Override
		public URL getDefault() {
			return this.location.getDefault();
		}

		@Override
		public Location getParentLocation() {
			return this.location.getParentLocation();
		}

		@Override
		public boolean isSet() {
			return this.location.isSet();
		}

		@Override
		public boolean setURL(URL value, boolean lock) throws IllegalStateException {
			return this.location.setURL(value, lock);
		}

		@Override
		public boolean set(URL value, boolean lock) throws IllegalStateException, IOException {
			return this.location.set(value, lock);
		}

		@Override
		public boolean set(URL value, boolean lock, String lockFilePath) throws IllegalStateException, IOException {
			return this.location.set(value, lock, lockFilePath);
		}

		@Override
		public boolean isLocked() throws IOException {
			return this.location.isLocked();
		}

		@Override
		public Location createLocation(Location parent, URL defaultValue, boolean readonly) {
			return this.location.createLocation(parent, defaultValue, readonly);
		}

		@Override
		public URL getDataArea(String path) throws IOException {
			return this.location.getDataArea(path);
		}
	}
}