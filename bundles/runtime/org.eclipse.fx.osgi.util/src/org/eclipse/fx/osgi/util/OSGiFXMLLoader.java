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
package org.eclipse.fx.osgi.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;
import javafx.util.Callback;

import org.osgi.framework.Bundle;
import org.osgi.framework.wiring.BundleWiring;

public class OSGiFXMLLoader {
	public static <O> O load(Class<?> requester, String relativeFxmlPath, ResourceBundle resourceBundle, BuilderFactory builderFactory) throws IOException {
		URL url = requester.getResource(relativeFxmlPath);
		ClassLoader loader = requester.getClassLoader();
		return load(loader, url, resourceBundle, builderFactory);
	}
	
	public static <O> O load(Bundle bundle, String bundleRelativeFxmlPath, ResourceBundle resourceBundle, BuilderFactory builderFactory) throws IOException {
		URL url = bundle.getResource(bundleRelativeFxmlPath);
		ClassLoader loader = bundle.adapt(BundleWiring.class).getClassLoader();
		return load(loader, url, resourceBundle, builderFactory);
	}
	
	public static <O> O load(ClassLoader classloader, URL url, ResourceBundle resourceBundle, BuilderFactory builderFactory) throws IOException {
		return load(classloader, url, resourceBundle, builderFactory, null);
	}
	
	public static <O> O load(Class<?> requester, String relativeFxmlPath, ResourceBundle resourceBundle, BuilderFactory builderFactory, Callback<Class<?>, Object> controllerFactory) throws IOException {
		URL url = requester.getResource(relativeFxmlPath);
		ClassLoader loader = requester.getClassLoader();
		return load(loader, url, resourceBundle, builderFactory, controllerFactory);
	}
	
	public static <O> O load(Bundle bundle, String bundleRelativeFxmlPath, ResourceBundle resourceBundle, BuilderFactory builderFactory, Callback<Class<?>, Object> controllerFactory) throws IOException {
		URL url = bundle.getResource(bundleRelativeFxmlPath);
		ClassLoader loader = bundle.adapt(BundleWiring.class).getClassLoader();
		return load(loader, url, resourceBundle, builderFactory, controllerFactory);
	}
	
	public static <O> O load(final ClassLoader classloader, URL url, ResourceBundle resourceBundle, final BuilderFactory builderFactory, Callback<Class<?>, Object> controllerFactory) throws IOException {
		InputStream in = null;
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(url);
			loader.setClassLoader(classloader);
			loader.setResources(resourceBundle);
			if( builderFactory == null ) {
				loader.setBuilderFactory(new JavaFXBuilderFactory(classloader));	
			} else {
				loader.setBuilderFactory(new BuilderFactory() {
					JavaFXBuilderFactory orgBuilder = new JavaFXBuilderFactory(classloader);
					@Override
					public Builder<?> getBuilder(Class<?> type) {
						Builder<?> b = builderFactory.getBuilder(type);
						if( b == null ) {
							b = orgBuilder.getBuilder(type);
						}
						return b;
					}
				});
			}
			
			if( controllerFactory != null ) {
				loader.setControllerFactory(controllerFactory);	
			}
			
			in = url.openStream();
			@SuppressWarnings("unchecked")
			O value = (O) loader.load(in);
			in.close();
			
			return value;
		} finally {
			if( in != null ) {
				in.close();
			}
		}
	}
	
	public interface FXMLLoaderProcessor {
		public void postProcess(FXMLLoader loader);
	}
}
