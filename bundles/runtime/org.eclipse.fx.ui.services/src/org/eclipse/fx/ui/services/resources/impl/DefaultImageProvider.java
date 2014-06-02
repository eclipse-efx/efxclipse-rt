/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.resources.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;

import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.ui.services.resources.ImageProvider;

/**
 * A default image provider
 */
public class DefaultImageProvider implements ImageProvider {

	@Override
	public String getName() {
		return "fx.default-image-provider"; //$NON-NLS-1$
	}

	@SuppressWarnings("null")
	@Override
	public List<String> getFileSuffix() {
		return Arrays.asList("png","gif","jpg","*"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	@Override
	public Image getImage(URI uri) throws IOException {
		try(InputStream in = new URL(uri.toString()).openStream() ) {
			return new Image(in);
		} catch (IOException e) {
			throw e;
		}
	}
}
