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

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.ContentTypeDetector;
import org.eclipse.fx.code.compensator.editor.services.InputFactory;

public class FileInputFactory implements InputFactory<FileInput> {
	//FIXME We need to sort and synchronize
	private List<ContentTypeDetector> detectors = new ArrayList<>();

	public void registerContentTypeDetector(ContentTypeDetector dector) {
		detectors.add(dector);
	}

	public void unregisterContentTypeDetector(ContentTypeDetector dector) {
		detectors.remove(dector);
	}

	@Override
	public boolean applies(String url) {
		return url.startsWith("file:");
	}

	@Override
	public Class<FileInput> createInput(String url) {
//		try {
//			return (Input<O>) new FileInput(Paths.get(new URI(url)),detectors);
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return FileInput.class;
	}

}
