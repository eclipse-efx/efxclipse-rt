/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.di;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.stage.Stage;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.osgi.util.AbstractJFXApplication;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;

/**
 * OSGi-Application which launches the DI-Framework and creates the main class
 * using it
 */
public class DIApplication extends AbstractJFXApplication implements
		IExecutableExtension {
	@Nullable
	private String bundleName;
	@Nullable
	private String applicationClass;

	@SuppressWarnings("null")
	@Override
	protected void jfxStart(IApplicationContext applicationContext,
			Application jfxApplication, Stage primaryStage) {
		String bundleName = this.bundleName;
		String applicationClass = this.applicationClass;
		if( bundleName == null || bundleName.isEmpty() ) {
			throw new IllegalStateException("The bundle '"+bundleName+"' to load from is not known"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		if( applicationClass == null || applicationClass.isEmpty() ) {
			throw new IllegalStateException("The application class '"+applicationClass+"' to load from is not known"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		BundleContext context = FrameworkUtil.getBundle(DIApplication.class)
				.getBundleContext();

		List<Bundle> sorted = new ArrayList<>(Arrays.asList(context
				.getBundles()));
		Collections.sort(sorted, new Comparator<Bundle>() {
			@Override
			public int compare(Bundle b1, Bundle b2) {
				return b2.getVersion().compareTo(b1.getVersion());
			}
		});

		for(Bundle b : sorted ) {
			if( bundleName.equals(b.getSymbolicName()) ) {
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

					try {
						Class<?> cl = b.loadClass(this.applicationClass);
						IEclipseContext eContext = EclipseContextFactory
								.getServiceContext(context);
						ContextInjectionFactory.setDefault(eContext);
						eContext.set(IApplicationContext.class, applicationContext);
						eContext.set(Application.class, jfxApplication);
						eContext.set(Stage.class, primaryStage);
						ContextInjectionFactory.make(cl, eContext);
					} catch (Throwable e) {
						LoggerCreator
								.createLogger(getClass())
								.error("Unabled to create instance of '" + this.applicationClass + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
					}
				} else {
					LoggerCreator.createLogger(getClass()).error(
							"Unable to locate bundle: " + this.bundleName); //$NON-NLS-1$
				}
			}
			
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		this.bundleName = config.getContributor().getName();
		this.applicationClass = ((Map<String, String>) data).get("mainClass"); //$NON-NLS-1$
	}

}
