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
import java.nio.file.Paths;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.fx.code.compensator.editor.ContentTypeProvider;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.TextEditor;
import org.eclipse.fx.code.compensator.editor.URIProvider;
import org.eclipse.fx.code.compensator.editor.services.ContentTypeDetector;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.core.di.Service;

public class FileInput implements Input<String>, ContentTypeProvider, URIProvider {
	private Path path;
	private String data;
	private final List<ContentTypeDetector> detectorList;

	@Inject
	public FileInput(@Named(TextEditor.DOCUMENT_URL) String url, @Service List<ContentTypeDetector> detectorList) {
		this.path = Paths.get(java.net.URI.create(url));
		this.detectorList = detectorList;
	}

	@Override
	public URI getURI() {
		return URI.create(path.toUri().toString());
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
	public void reset() {
		this.data = null;
		getData();
	}

	@Override
	public void dispose() {
		this.data = null;
		this.path = null;
	}

	@Override
	public String getContentType() {
		if( path.toString().endsWith(".java") ) {
			return ContentTypeProvider.JAVA;
		} else if( path.toString().endsWith(".js") ) {
			return ContentTypeProvider.JAVASCRIPT;
		}
		for( ContentTypeDetector d : detectorList ) {
			String ct = d.getContentType(this);
			if( ct != null ) {
				return ct;
			}
		}
		return null;
	}
}