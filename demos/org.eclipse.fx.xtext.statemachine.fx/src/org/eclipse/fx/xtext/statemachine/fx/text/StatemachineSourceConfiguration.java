package org.eclipse.fx.xtext.statemachine.fx.text;

import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;

import org.eclipse.fx.xtext.statemachine.StatemachineRuntimeModule;
import org.eclipse.fx.xtext.statemachine.StatemachineStandaloneSetup;
import org.eclipse.fx.xtext.statemachine.fx.contentassist.ContentAssistProvider;
import org.eclipse.fx.xtext.statemachine.fx.internal.StatemachineFXModule;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class StatemachineSourceConfiguration extends SourceViewerConfiguration {
	static Injector injector;
	private ContentAssistProvider contentAssistProvider;
	
	static {
		injector = new StatemachineStandaloneSetup() {
			public Injector createInjector() {
				StatemachineRuntimeModule runtimeModule = new StatemachineRuntimeModule();
				StatemachineFXModule webModule = new StatemachineFXModule(Executors.newFixedThreadPool(3));
//				webModule.resourceBaseProvider = resourceBaseProvider
				return Guice.createInjector((Module)runtimeModule, webModule);
				
			}
		}.createInjectorAndDoEMFRegistration();
	}
	
	private Document doc;
	private File f;
	
	public StatemachineSourceConfiguration(Document doc, File f) {
		this.doc = doc;
		this.f = f;
		contentAssistProvider = injector.getInstance(ContentAssistProvider.class);
	}
	
	@Override
	public String getStyleclassName() {
		return "state";
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		{
			DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new StatemachineCodeScanner());
			reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
			reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);			
		}
		
		{
			DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new StatemachineDocScanner());
			reconciler.setDamager(dr, IStatemachinePartitions.MULTI_LINE_COMMENT);
			reconciler.setRepairer(dr, IStatemachinePartitions.MULTI_LINE_COMMENT);
		}
				
		return reconciler;
	}
	
	@Override
	public IContentAssistant getContentAssist() {
		return new ContentAssistant(this::computeProposals);
	}

	private List<ICompletionProposal> computeProposals(Integer offset) {
		return contentAssistProvider.doContentAssist(doc.get(),f.toURI().toString(), offset);
	}
}
