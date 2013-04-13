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
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.fx.formats.svg.converter.FXMLConverter;
import org.eclipse.fx.formats.svg.handler.XMLLoader;
import org.eclipse.fx.formats.svg.svg.SvgSvgElement;

public class SVGToFXML {

	public static void main(String[] args) throws IOException {
		String fromFile = args[0];
		String toFile = args[1];
		
		InputStream in;
		if( fromFile.startsWith("http") ) {
			URL url = new URL(fromFile);
			in = url.openStream();
		} else {
			File f = new File(fromFile);
			in = new FileInputStream(f);
		}
		
		File outFile = new File(toFile);
		
		XMLLoader l = new XMLLoader();
		SvgSvgElement svgRoot = l.loadDocument(outFile.getAbsolutePath(), in);
		FXMLConverter converter = new FXMLConverter(svgRoot);
		FileOutputStream out = new FileOutputStream(outFile);
		out.write(converter.generate().toString().getBytes());
		out.close();
	}

}
