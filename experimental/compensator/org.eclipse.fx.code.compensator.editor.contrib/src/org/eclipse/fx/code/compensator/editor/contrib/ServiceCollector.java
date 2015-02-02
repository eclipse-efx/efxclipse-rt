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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.beans.property.ReadOnlyObjectWrapper;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.Outline;
import org.eclipse.fx.code.compensator.editor.services.DocumentFactory;
import org.eclipse.fx.code.compensator.editor.services.DocumentPersitenceService;
import org.eclipse.fx.code.compensator.editor.services.FileIconLookup;
import org.eclipse.fx.code.compensator.editor.services.FileIconProvider;
import org.eclipse.fx.code.compensator.editor.services.InputFactory;
import org.eclipse.fx.code.compensator.editor.services.OutlineFactory;
import org.eclipse.fx.code.compensator.editor.services.PartitionerFactory;
import org.eclipse.fx.code.compensator.editor.services.ProposalComputerFactory;
import org.eclipse.fx.code.compensator.editor.services.SourceViewerConfigurationFactory;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class ServiceCollector implements DocumentPersitenceService, FileIconLookup {
	private List<InputFactory> inputProviderList = new ArrayList<>();
	private List<DocumentFactory> documentProvider = new ArrayList<>();
	private List<PartitionerFactory> partitionerProvider = new ArrayList<>();
	private List<OutlineFactory> outlineFactoryList = new ArrayList<>();
	private List<SourceViewerConfigurationFactory> configurationProvider = new ArrayList<>();
	private List<FileIconProvider> fileIconProvider = new ArrayList<>();
	private List<ProposalComputerFactory> contentAssistFactory = new ArrayList<>();

	public void addContentAssistFactory(ProposalComputerFactory factory) {
		this.contentAssistFactory.add(factory);
	}

	public void removeContentAssistFactory(ProposalComputerFactory factory) {
		this.contentAssistFactory.remove(factory);
	}

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

	public void addOutlineFactory(OutlineFactory factory) {
		outlineFactoryList.add(factory);
	}

	public void removeOutlineFactory(OutlineFactory factory) {
		outlineFactoryList.remove(factory);
	}

	public void addFileIconProvider(FileIconProvider provider) {
		fileIconProvider.add(provider);
	}

	public void removeFileIconProvider(FileIconProvider provider) {
		fileIconProvider.add(provider);
	}

	public <O> Input<O> createInput(String url) {
		Optional<Input<O>> map = inputProviderList.stream().filter((p) -> p.applies(url)).findFirst().map((p) -> p.createInput(url));
		if( map.isPresent() ) {
			return map.get();
		}
		return null;
	}

	public Optional<Class<? extends Outline>> createOutline(Input<?> input) {
		return outlineFactoryList.stream().filter((p) -> p.applies(input)).findFirst().map((p) -> p.createOutline(input));
	}

	public IDocument createDocument(Input<?> input) {
		Optional<IDocument> map = documentProvider.stream().filter((p) -> p.applies(input)).findFirst().map((p) -> p.createDocument(input));
		if( map.isPresent() ) {
			return map.get();
		}
		return null;
	}

	public IDocumentPartitioner createPartitioner(Input<?> input) {
		Optional<IDocumentPartitioner> map = partitionerProvider.stream().filter((p) -> p.applies(input)).findFirst().map((p) -> p.createPartitioner(input));
		if( map.isPresent() ) {
			return map.get();
		}
		return  new FastPartitioner(new RuleBasedPartitionScanner(), new String[0]);
	}

	public Class<? extends SourceViewerConfiguration> createConfiguration(Input<?> input, GraphicsLoader graphicsLoader) {
		Optional<Class<? extends SourceViewerConfiguration>> map = configurationProvider.stream().filter((p) -> p.applies(input)).findFirst().map((p) -> p.createConfiguration(input));
		if( map.isPresent() ) {
			return map.get();
		}
		return DefaultTextConfiguration.class;
	}

//	public ProposalComputer createProposalComputer(Input<?> input, GraphicsLoader graphicsLoader) {
//		Optional<ProposalComputer> map = contentAssistFactory.stream().filter((c) -> c.applies(input)).findFirst().map((c) -> c.createProposalComputer(graphicsLoader));
//		if( map.isPresent() ) {
//			return map.get();
//		}
//		return null;
//	}

	public URI getFileIcon(String uri) {
		Optional<URI> map = fileIconProvider.stream().filter((p) -> p.applies(uri)).findFirst().map((p) -> p.getIcon(uri));
		if( map.isPresent() ) {
			return map.get();
		}
		return null;
	}

	@Override
	public boolean persist(IDocument d) {
		for( DocumentFactory f : documentProvider ) {
			if( f.persistDocument(d) ) {
				return true;
			}
		}
		return false;
	}


	public static class DefaultTextConfiguration extends SourceViewerConfiguration {
		public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
			PresentationReconciler reconciler = new PresentationReconciler();
			reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

			DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new NoopScanner());
			reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
			reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

			return reconciler;
		}

		private ReadOnlyObjectWrapper<URL> defaultStylesheet = new ReadOnlyObjectWrapper<>(this, "defaultStylesheet", getClass().getClassLoader().getResource("css/highlight.css"));

		@Override
		public String getStyleclassName() {
			return "default-text";
		}
	}

	private static class NoopScanner extends RuleBasedScanner {
		private IToken defaultToken = new Token(new TextAttribute("text_default"));

		public NoopScanner() {
			setDefaultReturnToken(defaultToken);
		}

		@Override
		public IToken nextToken() {
			IToken t = super.nextToken();
			return t;
		}
	}
}
