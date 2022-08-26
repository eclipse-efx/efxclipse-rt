/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.services.resources.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.services.resources.ImageProvider;
import org.osgi.service.component.annotations.Component;

import javafx.scene.image.Image;

/**
 * A default image provider
 */
@Component
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
		return new Image(uri.toString());
	}
}
