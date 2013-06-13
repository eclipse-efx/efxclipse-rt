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
package org.eclipse.fx.ide.fxml.compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.fx.ide.fxgraph.converter.FXGraphConverter;
import org.eclipse.fx.ide.fxgraph.converter.FXMLLoader;
import org.eclipse.fx.ide.fxgraph.converter.IFXMLFile;
import org.eclipse.fx.ide.fxgraph.fXGraph.Model;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class FXGraphCompiler {
	
	@Inject 
	private Provider<ResourceSet> resourceSetProvider;
	
	public static void main(String[] args) {
		Injector injector = new org.eclipse.fx.ide.fxgraph.FXGraphStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		FXGraphCompiler main = injector.getInstance(FXGraphCompiler.class);
		main.compile(args[0]);
	}
	
	protected void compile(final String string) {
		Model m;
		String fxgraph = string;
		if( string.endsWith("fxml") ) {
			FXMLLoader loader = new FXMLLoader();
			m = loader.loadModel(new IFXMLFile() {
				
				@Override
				public String getPackagename() {
					return "a";
				}
				
				@Override
				public String getName() {
					return new File(string).getName();
				}
				
				@Override
				public InputStream getContent() {
					try {
						return new FileInputStream(string);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
			});
			
			File out = new File("/tmp/tmp.fxgraph");
			try {
				FileOutputStream outStream = new FileOutputStream(out);
				outStream.write(new FXGraphConverter().generate(m).toString().getBytes());
				outStream.close();
				fxgraph = "/tmp/tmp.fxgraph";
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createURI(fxgraph), true);
		
		m = (Model)resource.getContents().get(0);	
		
		FXGraphJavaGenerator c = new FXGraphJavaGenerator();
		System.out.println(c.generate(m));
	}
}
