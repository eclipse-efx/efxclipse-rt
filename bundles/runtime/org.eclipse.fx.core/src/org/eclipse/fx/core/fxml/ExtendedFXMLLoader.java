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
package org.eclipse.fx.core.fxml;

import java.io.IOException;

import javafx.fxml.FXMLLoader;


public class ExtendedFXMLLoader {
	public <T> T load(ClassLoader cl, String path) throws IOException {
		try {
			String classname = path.substring(0,path.lastIndexOf('.')).replace('/', '.');
			Class<?> clazz = cl.loadClass(classname);
			FXMLDocument<T> d = (FXMLDocument<T>) clazz.newInstance();
			return d.load(cl.getResource(path),null);
		} catch (ClassNotFoundException e) {
			return FXMLLoader.load(cl.getResource(path));
		} catch (InstantiationException e) {
			throw new IOException(e);
		} catch (IllegalAccessException e) {
			throw new IOException(e);
		}
	}
}
