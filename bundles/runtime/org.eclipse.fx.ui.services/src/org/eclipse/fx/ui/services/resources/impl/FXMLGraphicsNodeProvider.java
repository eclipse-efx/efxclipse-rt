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
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.osgi.util.OSGiFXMLLoader;
import org.eclipse.fx.ui.services.resources.GraphicNodeProvider;
import org.osgi.framework.Bundle;

public class FXMLGraphicsNodeProvider implements GraphicNodeProvider {
	@Override
	public String getName() {
		return "fx.fxml-graphic-provider";
	}

	@Override
	public List<String> getFileSuffix() {
		return Arrays.asList("fxml");
	}

	@Override
	public Node getGraphicNode(URI uri) throws IOException {
		if( uri.isPlatformPlugin() ) {
			Bundle b = org.eclipse.core.runtime.Platform.getBundle(uri.segment(1));
			if( b != null ) {
				StringBuilder sb = new StringBuilder();
				for (int i = 2; i < uri.segmentCount(); i++) {
					if (sb.length() != 0) {
						sb.append("/");
					}
					sb.append(uri.segment(i));
				}
				return OSGiFXMLLoader.load(b, sb.toString(), null, null);	
			} else {
				throw new IOException("Unknown bundle '"+uri.segment(1)+"'");
			}
		} else {
			return FXMLLoader.load(new URL(uri.toString()));
		}
	}
}