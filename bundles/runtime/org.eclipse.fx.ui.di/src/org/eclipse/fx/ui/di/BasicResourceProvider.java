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
package org.eclipse.fx.ui.di;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import javafx.scene.image.Image;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.Logger.Level;
import org.eclipse.fx.osgi.util.LoggerCreator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.BundleContext;

/**
 * Basic implementation of a resource provider
 */
public abstract class BasicResourceProvider implements ResourceProviderService {
	/**
	 * Service properties
	 */
	protected Map<String, String> properties;
	/**
	 * The bundle context
	 */
	protected BundleContext context;
	
	/**
	 * A logger instance
	 */
	protected Logger logger = LoggerCreator.createLogger(getClass());

	/**
	 * Called when the service is activated
	 * 
	 * @param context
	 *            the bundle context
	 * @param properties
	 *            the properties
	 */
	public void activate(BundleContext context, Map<String, String> properties) {
		this.properties = properties;
		this.context = context;
	}

	@Override
	@Nullable
	public Image getImage(@NonNull String key) {
		URL url = FileLocator.find(this.context.getBundle(),
				new Path(this.properties.get(key)), null);

		if (url != null) {
			try(InputStream stream = url.openStream()) {
				return new Image(stream);
			} catch (Exception e) {
				this.logger.error("Unabled to load image with key '"+key+"' at URL '"+url+"'", e);  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
			}
		}
		
		if( this.logger.isEnabled(Level.INFO) ) {
			this.logger.info("Unable to find image with key '"+key+"'");	  //$NON-NLS-1$//$NON-NLS-2$
		}
		
		return null;
	}
}