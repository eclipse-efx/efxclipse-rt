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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.controls.image.FontIcon;
import org.eclipse.fx.ui.controls.image.FontIconView;
import org.eclipse.fx.ui.services.resources.GraphicNodeProvider;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;

import javafx.scene.Node;

/**
 * Provider for font-icon view
 */
@Component
public class FontIconNodeProvider implements GraphicNodeProvider {

	@Override
	public @NonNull String getName() {
		return "fx.font-icon-provider"; //$NON-NLS-1$
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull List<@NonNull String> getFileSuffix() {
		return Collections.singletonList("icon"); //$NON-NLS-1$
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull Node getGraphicNode(URI uri) throws IOException {
		String file = uri.toString();
		String[] parts = file.split("/"); //$NON-NLS-1$
		FontIconView v = new FontIconView();
		String iconName = parts[parts.length-1];
		iconName = iconName.substring(0,iconName.lastIndexOf('.'));
		Optional<FontIcon> icon = FontIcon.create(iconName);
		if( icon.isPresent() ) {
			v.setIcon(icon.get());
		} else {
			v.getStyleClass().add(iconName);
		}

		return v;
	}

}
