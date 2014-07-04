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
package org.eclipse.fx.code.compensator.editor.xml;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.fx.code.compensator.editor.ContentTypeProvider;
import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.hsl.HSLConfiguration;
import org.eclipse.fx.code.compensator.editor.hsl.HSLRuleBasedPartitionScanner;
import org.eclipse.fx.code.compensator.editor.services.PartitionerFactory;
import org.eclipse.fx.code.compensator.editor.services.SourceViewerConfigurationFactory;
import org.eclipse.fx.code.compensator.hsl.HSLStandaloneSetup;
import org.eclipse.fx.code.compensator.hsl.hSL.Model;
import org.eclipse.fx.code.compensator.hsl.hSL.RulePartitioner;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class XMLComponent implements PartitionerFactory, SourceViewerConfigurationFactory {
	private Model model;
	
	public XMLComponent() {
		HSLStandaloneSetup.doSetup();
		
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(URI.createPlatformPluginURI("/org.eclipse.fx.code.compensator.editor.xml/xml.hsl", true), true);
		model = (Model) resource.getContents().get(0);
//		System.err.println(resource.getContents().get(0));
	}
	
	@Override
	public SourceViewerConfiguration createConfiguration(Input<?> input) {
		return new HSLConfiguration(getClass().getClassLoader(),model);
	}

	@Override
	public boolean applies(Input<?> input) {
		if( input instanceof ContentTypeProvider ) {
			String contentType = ((ContentTypeProvider) input).getContentType();
			return ContentTypeProvider.XML.equals(contentType);
		}
		return false;
	}
	
	private IPartitionTokenScanner getParitionScanner() {
		if( model.getPartitioner() instanceof RulePartitioner ) {
			return new HSLRuleBasedPartitionScanner(getClass().getClassLoader(), (RulePartitioner) model.getPartitioner());
		} else {
			throw new UnsupportedOperationException();
		}
	}
	
	private String[] getParitions() {
		return model.getPartitions().stream().filter((p) -> { return ! p.getName().equals(IDocument.DEFAULT_CONTENT_TYPE); })
				.map((p) -> p.getName())
				.toArray((size) -> new String[size]);
	}

	@Override
	public IDocumentPartitioner createPartitioner(Input<?> input) {
		return new FastPartitioner(
				getParitionScanner(),
				getParitions());
	}

}
