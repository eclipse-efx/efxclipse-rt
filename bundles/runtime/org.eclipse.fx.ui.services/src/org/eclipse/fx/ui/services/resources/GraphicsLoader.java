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

import javafx.scene.Node;
import javafx.scene.image.Image;

public interface GraphicsLoader {
	public Image getImage(URI uri);
	public Node getGraphicsNode(URI uri);
	
	public static class Util {
		public static Map<String, String> parseQuery(URI uri) {
			Map<String, String> params = new HashMap<>();
			StringTokenizer tk = new StringTokenizer(uri.query(),"&");
			while( tk.hasMoreTokens() ) {
				String element = tk.nextToken();
				int idx = element.indexOf('=');
				params.put(element.substring(0,idx), element.substring(idx+1));
			}
			
			return params;
		}
		
		public static String getQueryValue(URI uri, String name) {
			StringTokenizer tk = new StringTokenizer(uri.query(),"&");
			String searchValue = name+"=";
			while( tk.hasMoreTokens() ) {
				String element = tk.nextToken();
				if( element.startsWith(searchValue) ) {
					return element.substring(element.indexOf('=')+1);
				}
			}
			return null;
		}

		public static String suffix(URI uri) {
			String last = uri.lastSegment();
			int idx = last.lastIndexOf('.'); 
			if( idx != -1 ) {
				return last.substring(idx+1).toLowerCase();
			}
			return null;
		}
	}

}
