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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.fx.formats.svg.converter.FXMLConverter;
import org.eclipse.fx.formats.svg.handler.XMLLoader;
import org.eclipse.fx.formats.svg.svg.SvgSvgElement;

/**
 * Command line utility to convert an SVG to an FXML-File
 */
public class SVGToFXML {
	/**
	 * Main method called when started from command line
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		String fromFile = args[0];
		String toFile = args[1];

		try (InputStream in = fromFile.startsWith("http") ? new URL(fromFile).openStream() : new FileInputStream(new File(fromFile))) { //$NON-NLS-1$
			if( in != null ) {
				File outFile = new File(toFile);

				SvgSvgElement svgRoot = XMLLoader.loadDocument(outFile.getAbsolutePath(),in);
				FXMLConverter converter = new FXMLConverter(svgRoot);
				try (FileOutputStream out = new FileOutputStream(outFile)) {
					out.write(converter.generate().toString().getBytes());
					out.close();
				}	
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
