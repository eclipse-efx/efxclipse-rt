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

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.InputFactory;

public class FileInputFactory implements InputFactory {
	@Override
	public boolean applies(String url) {
		System.err.println("CHECKING: " + url);
		return url.startsWith("file:");
	}

	@Override
	public <O> Input<O> createInput(String url) {
		try {
			return (Input<O>) new FileInput(Paths.get(new URI(url)));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
