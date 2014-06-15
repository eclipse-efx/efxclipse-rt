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
package org.eclipse.fx.code.compensator.editor.contrib;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.DocumentFactory;
import org.eclipse.fx.code.compensator.editor.services.InputFactory;
import org.eclipse.fx.code.compensator.editor.services.PartitionerFactory;
import org.eclipse.fx.code.compensator.editor.services.SourceViewerConfigurationFactory;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class ServiceCollector {
	private List<InputFactory> inputProviderList = new ArrayList<>();
	private List<DocumentFactory> documentProvider = new ArrayList<>();
	private List<PartitionerFactory> partitionerProvider = new ArrayList<>();
	private List<SourceViewerConfigurationFactory> configurationProvider = new ArrayList<>();
	
	public void addInputFactory(InputFactory provider) {
		inputProviderList.add(provider);
	}
	
	public void removeInputFactory(InputFactory provider) {
		inputProviderList.remove(provider);
	}
	
	public void addDocumentFactory(DocumentFactory provider) {
		documentProvider.add(provider);
	}
	
	public void removeDocumentFactory(DocumentFactory provider) {
		documentProvider.remove(provider);
	}
	
	public void addPartitionerFactory(PartitionerFactory provider) {
		partitionerProvider.add(provider);
	}
	
	public void removePartitionerFactory(PartitionerFactory provider) {
		partitionerProvider.remove(provider);
	}
	
	public void addSourceViewerConfigurationFactory(SourceViewerConfigurationFactory provider) {
		configurationProvider.add(provider);
	}
	
	public void removeSourceViewerConfigurationFactory(SourceViewerConfigurationFactory provider) {
		configurationProvider.remove(provider);
	}
	
	public <O> Input<O> createInput(String url) {
		System.err.println("PROVIDER: " + inputProviderList);
		Optional<Input<O>> map = inputProviderList.stream().filter((p) -> p.applies(url)).findFirst().map((p) -> p.createInput(url));
		return map.get();
	}
	
	public IDocument createDocument(Input<?> input) {
		Optional<IDocument> map = documentProvider.stream().filter((p) -> p.applies(input)).findFirst().map((p) -> p.createDocument(input));
		return map.get();
	}
	
	public IDocumentPartitioner createPartitioner(Input<?> input) {
		System.err.println("PARTITIONER: " + partitionerProvider);
		Optional<IDocumentPartitioner> map = partitionerProvider.stream().filter((p) -> p.applies(input)).findFirst().map((p) -> p.createPartitioner(input));
		return map.get();
	}
	
	public SourceViewerConfiguration createConfiguration(Input<?> input) {
		Optional<SourceViewerConfiguration> map = configurationProvider.stream().filter((p) -> p.applies(input)).findFirst().map((p) -> p.createConfiguration(input));
		return map.get();
	}
}
