/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.jdt.annotation.NonNull;

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
	public static void converter(@NonNull InputStream inputStream, @NonNull OutputStream outputStream)
			throws Exception {
		SvgSvgElement rootElement = XMLLoader.loadDocument(null, inputStream);
		FXMLConverter converter = new FXMLConverter(rootElement);
		outputStream.write(converter.generate().toString().getBytes());
	}
}
