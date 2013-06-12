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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
	
	protected void compile(String string) {
		// load the resource
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createURI(string), true);
		
		Model m = (Model)resource.getContents().get(0);
		FXGraphJavaGenerator c = new FXGraphJavaGenerator();
		System.out.println(c.generate(m));
	}
}
