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
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.services.resources.GraphicNodeProvider;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.service.component.annotations.Component;

/**
 * FXML node provider
 */
@Component
public class FXMLGraphicsNodeProvider implements GraphicNodeProvider {
	@Override
	public String getName() {
		return "fx.fxml-graphic-provider"; //$NON-NLS-1$
	}

	@SuppressWarnings("null")
	@Override
	public List<String> getFileSuffix() {
		return Arrays.asList("fxml"); //$NON-NLS-1$
	}

	@SuppressWarnings("null")
	@Override
	public Node getGraphicNode(URI uri) throws IOException {
		if( uri.isPlatformPlugin() ) {
			BundleContext context = FrameworkUtil.getBundle(FXMLGraphicsNodeProvider.class).getBundleContext();
			Optional<Bundle> bundleOp = Stream.of(context.getBundles())
				.filter( b -> b.getSymbolicName().equals(uri.segment(1)))
				.findFirst();
			
			if( bundleOp.isPresent() ) {
				Bundle b = bundleOp.get();
				StringBuilder sb = new StringBuilder();
				for (int i = 2; i < uri.segmentCount(); i++) {
					if (sb.length() != 0) {
						sb.append("/"); //$NON-NLS-1$
					}
					sb.append(uri.segment(i));
				}
				FXMLLoader loader = new FXMLLoader();
				loader.setClassLoader(b.adapt(BundleWiring.class).getClassLoader());
				URL url = b.getResource(sb.toString());
				loader.setLocation(url);
				return loader.load();
			} else {
				throw new IOException("Unknown bundle '"+uri.segment(1)+"'"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} else {
			return FXMLLoader.load(new URL(uri.toString()));
		}
	}
}