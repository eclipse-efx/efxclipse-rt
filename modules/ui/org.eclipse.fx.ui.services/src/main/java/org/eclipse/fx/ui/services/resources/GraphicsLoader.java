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
package org.eclipse.fx.ui.services.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.services.resources.AdornedImageDescriptor.Location;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

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
	 * Constructs a graphic node from the descriptor provided
	 *
	 * @param descriptor
	 *            the descriptor
	 * @return the graphic node
	 * @since 1.2
	 */
	public default Node getGraphicsNode(@NonNull AdornedImageDescriptor descriptor) {
		AnchorPane a = new AnchorPane();
		Point2D s = descriptor.size;
		if( s != null ) {
			a.setPrefSize(s.getX(), s.getY());
		}

		Double zero = Double.valueOf(0.0);
		{
			Node graphicsNode = getGraphicsNode(descriptor.baseImage);
			AnchorPane.setBottomAnchor(graphicsNode, zero);
			AnchorPane.setLeftAnchor(graphicsNode, zero);
			AnchorPane.setRightAnchor(graphicsNode, zero);
			AnchorPane.setTopAnchor(graphicsNode, zero);
			a.getChildren().add(graphicsNode);
		}

		{
			@SuppressWarnings("null")
			List<Node> collect = descriptor.adornments.stream().filter((ad) -> ad.location == Location.LEFT_TOP).map((ad) -> getGraphicsNode(ad.uri)).filter(n -> n!= null).collect(Collectors.toList());

			if( collect != null && ! collect.isEmpty() ) {
				if( collect.size() == 1 ) {
					Node graphicsNode = collect.get(0);
					AnchorPane.setLeftAnchor(graphicsNode, zero);
					AnchorPane.setTopAnchor(graphicsNode, zero);
					a.getChildren().add(graphicsNode);
				} else {
					double start = 0;
					for( Node n : collect ) {
						Node graphicsNode = collect.get(0);
						AnchorPane.setLeftAnchor(graphicsNode, Double.valueOf(start));
						AnchorPane.setTopAnchor(graphicsNode, zero);
						a.getChildren().add(graphicsNode);
						start += n.prefWidth(-1);
					}
				}
			}
		}

		{
			@SuppressWarnings("null")
			List<Node> collect = descriptor.adornments.stream().filter((ad) -> ad.location == Location.RIGHT_TOP).map((ad) -> getGraphicsNode(ad.uri)).filter(n -> n!= null).collect(Collectors.toList());

			if( collect != null && ! collect.isEmpty() ) {
				if( collect.size() == 1 ) {
					Node graphicsNode = collect.get(0);
					AnchorPane.setRightAnchor(graphicsNode, zero);
					AnchorPane.setTopAnchor(graphicsNode, zero);
					a.getChildren().add(graphicsNode);
				} else {
					double start = 0;
					for( Node n : collect ) {
						Node graphicsNode = collect.get(0);
						AnchorPane.setRightAnchor(graphicsNode, Double.valueOf(start));
						AnchorPane.setTopAnchor(graphicsNode, zero);
						a.getChildren().add(graphicsNode);
						start += n.prefWidth(-1);
					}
				}
			}
		}

		{
			@SuppressWarnings("null")
			List<Node> collect = descriptor.adornments.stream().filter((ad) -> ad.location == Location.LEFT_BOTTOM).map((ad) -> getGraphicsNode(ad.uri)).filter(n -> n!= null).collect(Collectors.toList());

			if( collect != null && ! collect.isEmpty() ) {
				if( collect.size() == 1 ) {
					Node graphicsNode = collect.get(0);
					AnchorPane.setLeftAnchor(graphicsNode, zero);
					AnchorPane.setBottomAnchor(graphicsNode, zero);
					a.getChildren().add(graphicsNode);
				} else {
					double start = 0;
					for( Node n : collect ) {
						Node graphicsNode = collect.get(0);
						AnchorPane.setLeftAnchor(graphicsNode, Double.valueOf(start));
						AnchorPane.setBottomAnchor(graphicsNode, zero);
						a.getChildren().add(graphicsNode);
						start += n.prefWidth(-1);
					}
				}
			}
		}

		{
			@SuppressWarnings("null")
			List<Node> collect = descriptor.adornments.stream().filter((ad) -> ad.location == Location.RIGHT_BOTTOM).map((ad) -> getGraphicsNode(ad.uri)).filter(n -> n!= null).collect(Collectors.toList());

			if( collect != null && ! collect.isEmpty() ) {
				if( collect.size() == 1 ) {
					Node graphicsNode = collect.get(0);
					AnchorPane.setRightAnchor(graphicsNode, zero);
					AnchorPane.setBottomAnchor(graphicsNode, zero);
					a.getChildren().add(graphicsNode);
				} else {
					double start = 0;
					for( Node n : collect ) {
						Node graphicsNode = collect.get(0);
						AnchorPane.setRightAnchor(graphicsNode, Double.valueOf(start));
						AnchorPane.setBottomAnchor(graphicsNode, zero);
						a.getChildren().add(graphicsNode);
						start += n.prefWidth(-1);
					}
				}
			}
		}

		return a;
	}

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
				params.put(element.substring(0, idx),
						element.substring(idx + 1));
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
		public static String getQueryValue(@NonNull URI uri,
				@NonNull String name) {
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
			if (last == null) {
				return null;
			}
			int idx = last.lastIndexOf('.');
			if (idx != -1) {
				return last.substring(idx + 1).toLowerCase();
			}
			return null;
		}
	}

}
