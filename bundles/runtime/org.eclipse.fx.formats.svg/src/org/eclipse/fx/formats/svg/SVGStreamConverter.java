/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.formats.svg;

import java.io.OutputStream;

import java.io.InputStream;

import org.eclipse.fx.formats.svg.converter.FXMLConverter;
import org.eclipse.fx.formats.svg.handler.XMLLoader;
import org.eclipse.fx.formats.svg.svg.SvgSvgElement;

/**
 * Utility to convert an SVG file to FXML
 */
public class SVGStreamConverter {
	/**
	 * Convert the svg stream to on FXML-Stream
	 * 
	 * @param inputStream
	 *            the input stream (SVG)
	 * @param outputStream
	 *            the output string (FXML)
	 * @throws Exception
	 *             if an error occurs
	 */
	public static void converter(InputStream inputStream, OutputStream outputStream)
			throws Exception {
		XMLLoader loader = new XMLLoader();
		SvgSvgElement rootElement = loader.loadDocument(null, inputStream);
		FXMLConverter converter = new FXMLConverter(rootElement);
		outputStream.write(converter.generate().toString().getBytes());
	}
}
