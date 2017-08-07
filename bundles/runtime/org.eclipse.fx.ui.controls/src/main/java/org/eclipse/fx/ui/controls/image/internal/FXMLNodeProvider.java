/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.image.internal;

import java.io.IOException;

import org.eclipse.fx.core.URLUtils;
import org.eclipse.fx.ui.controls.image.GraphicNodeProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 * FXML Graphic node provider
 *
 * @since 3.0
 */
@Component
public class FXMLNodeProvider implements GraphicNodeProvider {

	@Override
	public @NonNull String getName() {
		return "FXML Node Provider"; //$NON-NLS-1$
	}

	@Override
	public boolean handles(String url) {
		return url.endsWith(".fxml"); //$NON-NLS-1$
	}

	@Override
	public @NonNull Node getGraphicNode(String uri) {
		FXMLLoader l = new FXMLLoader();
		l.setLocation(URLUtils.createUrl(uri));
		try {
			return l.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}