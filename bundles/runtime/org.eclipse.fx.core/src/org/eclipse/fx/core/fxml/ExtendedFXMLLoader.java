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
import javafx.fxml.JavaFXBuilderFactory;


public class ExtendedFXMLLoader {
	private FXMLDocument<?> lastDocument;
	private FXMLLoader lastLoader;
	
	public <T> T load(ClassLoader cl, String path) throws IOException {
		lastDocument = null;
		lastLoader = null;
		try {
			String classname = path.substring(0,path.lastIndexOf('.')).replace('/', '.');
			Class<?> clazz = cl.loadClass(classname);
			FXMLDocument<T> d = (FXMLDocument<T>) clazz.newInstance();
			this.lastDocument = d; 
			return d.load(cl.getResource(path),null);
		} catch (ClassNotFoundException e) {
			FXMLLoader loader = new FXMLLoader();
			loader.setBuilderFactory(new JavaFXBuilderFactory());
			loader.setLocation(cl.getResource(path));
			lastLoader = loader;
			return (T) loader.load(cl.getResourceAsStream(path));
		} catch (InstantiationException e) {
			throw new IOException(e);
		} catch (IllegalAccessException e) {
			throw new IOException(e);
		}
	}
	
	public <C> C getController() {
		return (C) (lastDocument != null ? lastDocument.getController() : lastLoader.getController());
	}
}
