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

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.scene.Node;
import javafx.scene.image.Image;

/**
 * Service loading graphic nodes consulting {@link ImageProvider} and
 * {@link GraphicNodeProvider}
 */
public interface GraphicsLoader {
	/**
	 * Loading the image
	 * 
	 * @param uri
	 *            the uri
	 * @return the image
	 */
	@Nullable
	public Image getImage(@NonNull URI uri);

	/**
	 * Constructing a graphic node from the url
	 * 
	 * @param uri
	 *            the uri
	 * @return the graphic node
	 */
	@Nullable
	public Node getGraphicsNode(@NonNull URI uri);

	/**
	 * Utility to extract informations from the uri
	 */
	public static class Util {
		/**
		 * Split the query params into a {@link Map}
		 * 
		 * @param uri
		 *            the uri
		 * @return the map
		 */
		@NonNull
		public static Map<String, String> parseQuery(@NonNull URI uri) {
			Map<String, String> params = new HashMap<>();
			StringTokenizer tk = new StringTokenizer(uri.query(), "&"); //$NON-NLS-1$
			while (tk.hasMoreTokens()) {
				String element = tk.nextToken();
				int idx = element.indexOf('=');
				params.put(element.substring(0, idx), element.substring(idx + 1));
			}

			return params;
		}

		/**
		 * Get query param with the given name
		 * 
		 * @param uri
		 *            the uri
		 * @param name
		 *            the name
		 * @return the value
		 */
		@Nullable
		public static String getQueryValue(@NonNull URI uri, @NonNull String name) {
			StringTokenizer tk = new StringTokenizer(uri.query(), "&"); //$NON-NLS-1$
			String searchValue = name + "="; //$NON-NLS-1$
			while (tk.hasMoreTokens()) {
				String element = tk.nextToken();
				if (element.startsWith(searchValue)) {
					return element.substring(element.indexOf('=') + 1);
				}
			}
			return null;
		}

		/**
		 * Extract the file suffix
		 * 
		 * @param uri
		 *            the uri
		 * @return the suffix
		 */
		@Nullable
		public static String suffix(@NonNull URI uri) {
			String last = uri.lastSegment();
			int idx = last.lastIndexOf('.');
			if (idx != -1) {
				return last.substring(idx + 1).toLowerCase();
			}
			return null;
		}
	}

}
