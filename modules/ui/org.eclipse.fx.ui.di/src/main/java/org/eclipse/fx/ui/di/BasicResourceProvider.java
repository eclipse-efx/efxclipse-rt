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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import javafx.scene.image.Image;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.Logger.Level;
import org.eclipse.fx.core.log.LoggerCreator;
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
	@SuppressWarnings("null")
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
	public Image getImage(@NonNull String key) throws IOException {
		URL url = FileLocator.find(this.context.getBundle(),
				new Path(this.properties.get(key)), null);

		if (url != null) {
			try(InputStream stream = url.openStream()) {
				return new Image(stream);
			} catch (Exception e) {
				this.logger.error("Unabled to load image with key '"+key+"' at URL '"+url+"'", e);  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
				if( e instanceof IOException ) {
					throw (IOException)e;
				} else {
					throw new IOException(e);
				}
			}
		}
		
		if( this.logger.isEnabled(Level.INFO) ) {
			this.logger.info("Unable to find image with key '"+key+"'");	  //$NON-NLS-1$//$NON-NLS-2$
		}
		
		return null;
	}
}