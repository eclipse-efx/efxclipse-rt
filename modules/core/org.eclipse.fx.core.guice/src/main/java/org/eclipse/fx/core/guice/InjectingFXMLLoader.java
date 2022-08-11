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
package org.eclipse.fx.core.guice;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.jdt.annotation.NonNull;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Callback;

import com.google.inject.Injector;

/**
 * FXML-Loader who use the injector to create an instance of the controller
 */
public class InjectingFXMLLoader {
	/**
	 * Load an FXML-File
	 * 
	 * @param injector
	 *            the injector to use when creating the controller instance
	 * @param url
	 *            the url
	 * @return the loaded object graph
	 * @throws IOException
	 */
	public static <N> N loadFXML(@NonNull final Injector injector, @NonNull URL url) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(url);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setControllerFactory(new Callback<Class<?>, Object>() {

			@Override
			public Object call(Class<?> param) {
				return injector.getInstance(param);
			}
		});

		try(InputStream in = url.openStream() ) {
			@SuppressWarnings("unchecked")
			N value = (N) loader.load(in);
			in.close();
			return value;	
		}
	}
}
