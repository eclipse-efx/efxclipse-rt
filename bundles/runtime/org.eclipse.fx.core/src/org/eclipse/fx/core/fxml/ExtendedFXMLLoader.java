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
import java.net.URL;

import org.eclipse.jdt.annotation.NonNull;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;

/**
 * The extended fxml loader tries to create an instance of a class with the same FQN as the given FXML-File
 * and falls back to use the {@link FXMLLoader} if not found.
 * 
 * The greatly improves performance because a precompiled .class file can be used whereas {@link FXMLLoader}
 * has to use reflection to create instances at runtime
 */
public class ExtendedFXMLLoader {
	private FXMLDocument<?> lastDocument;
	private FXMLLoader lastLoader;

	/**
	 * Load the FXML file
	 * 
	 * @param cl
	 *            the classloader to use
	 * @param path
	 *            the path to the FXML-File
	 * @return the object graph constructed from the fxml or .class-File
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@NonNull
	public <T> T load(ClassLoader cl, String path) throws IOException {
		this.lastDocument = null;
		this.lastLoader = null;
		try {
			String classname = path.substring(0, path.lastIndexOf('.')).replace('/', '.');
			Class<?> clazz = cl.loadClass(classname);
			FXMLDocument<T> d = (FXMLDocument<T>) clazz.newInstance();
			this.lastDocument = d;
			URL url = cl.getResource(path);
			if( url != null ) {
				return d.load(url, null);
			} else {
				throw new IOException("Unable to get url for path '"+path+"'"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} catch (ClassNotFoundException e) {
			FXMLLoader loader = new FXMLLoader();
			loader.setBuilderFactory(new JavaFXBuilderFactory());
			loader.setLocation(cl.getResource(path));
			this.lastLoader = loader;
			T rv = (T) loader.load(cl.getResourceAsStream(path));
			if( rv != null ) {
				return rv;	
			}
			throw new IOException("Unable to load fxml document from '"+path+"'"); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (InstantiationException e) {
			throw new IOException(e);
		} catch (IllegalAccessException e) {
			throw new IOException(e);
		}
	}

	/**
	 * The controller of the last loaded "FXML-File"
	 * @return the last controller
	 */
	@SuppressWarnings("unchecked")
	public <C> C getController() {
		if( this.lastDocument == null && this.lastLoader == null ) {
			return null;
		} else if( this.lastDocument != null ) {
			return (C) this.lastDocument.getController();
		} else {
			return this.lastLoader.getController();
		}
	}
}
