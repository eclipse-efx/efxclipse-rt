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
package org.eclipse.fx.ui.services.resources;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import javafx.scene.image.Image;

public interface ImageProvider {
	public String getName();
	public List<String> getFileSuffix();
	public Image getImage(URI uri) throws IOException;
}
