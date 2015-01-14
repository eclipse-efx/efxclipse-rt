/*******************************************************************************
* Copyright (c) 2014 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.compensator.editor.internal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.fx.code.compensator.editor.ContentTypeProvider;
import org.eclipse.fx.code.compensator.editor.Input;

public class FileInput implements Input<String>, ContentTypeProvider {
	private Path path;
	private String data;

	public FileInput(Path path) {
		this.path = path;
	}

	@Override
	public String getData() {
		if( data == null ) {
			try(BufferedReader reader = Files.newBufferedReader(path)) {
				StringBuilder b = new StringBuilder();
				String line;
				while( (line = reader.readLine()) != null ) {
					//FIXME We need to replace TABs for now
					b.append(line.replaceAll("\t", "    ")+"\n");
				}
				reader.close();
				data = b.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data;
	}

	@Override
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public void persist() {
		try(BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(data);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getContentType() {
		//FIXME Need suffix => type mapping
		if( path.toString().endsWith(".xml") ) {
			return ContentTypeProvider.XML;
		} else if( path.toString().endsWith(".java") ) {
			return ContentTypeProvider.JAVA;
		} else if( path.toString().endsWith(".js") ) {
			return ContentTypeProvider.JAVASCRIPT;
		} else if( path.toString().endsWith(".groovy") ) {
			return ContentTypeProvider.GROOVY;
		} else if( path.toString().endsWith(".hsl") ) {
			return ContentTypeProvider.HSL;
		} else if( path.toString().endsWith(".lego") ) {
			return ContentTypeProvider.LEGO;
		} else if( path.toString().endsWith(".dart") ) {
			return ContentTypeProvider.DART;
		}
		return null;
	}
}