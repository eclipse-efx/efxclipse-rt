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
package org.eclipse.fx.code.compensator.editor.java;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.inject.Inject;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyProperty;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.ProposalComputer;
import org.eclipse.fx.code.compensator.editor.ProposalComputer.ProposalContext;
import org.eclipse.fx.code.compensator.editor.java.scanner.IJavaColorConstants;
import org.eclipse.fx.code.compensator.editor.java.scanner.IJavaPartitions;
import org.eclipse.fx.code.compensator.editor.java.scanner.JavaCodeScanner;
import org.eclipse.fx.code.compensator.editor.java.scanner.JavaCommentScanner;
import org.eclipse.fx.code.compensator.editor.java.scanner.JavaDocScanner;
import org.eclipse.fx.code.compensator.editor.java.scanner.SingleTokenJavaScanner;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class JavaSourceConfiguration extends SourceViewerConfiguration {

	private JavaCodeScanner fCodeScanner;
	private JavaDocScanner fJavaDocScanner;
	private JavaCommentScanner fMultilineCommentScanner;
	private JavaCommentScanner fSinglelineCommentScanner;
	private SingleTokenJavaScanner fStringScanner;
	private final Optional<ProposalComputer> computer;
	private Input<?> input;

	@Inject
	public JavaSourceConfiguration(Input<?> input, @org.eclipse.e4.core.di.annotations.Optional ProposalComputer computer) {
		this.computer = Optional.ofNullable(computer);
		this.input = input;
		initializeScanners();
	}

	private void initializeScanners() {
		fCodeScanner= new JavaCodeScanner();
		fMultilineCommentScanner= new JavaCommentScanner(IJavaColorConstants.JAVA_MULTI_LINE_COMMENT);
		fSinglelineCommentScanner= new JavaCommentScanner(IJavaColorConstants.JAVA_SINGLE_LINE_COMMENT);
		fStringScanner= new SingleTokenJavaScanner(IJavaColorConstants.JAVA_STRING);
		fJavaDocScanner= new JavaDocScanner();
	}

	@Override
	public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
		return IJavaPartitions.JAVA_PARTITIONING;
	}

	@Override
	public IContentAssistant getContentAssist() {
		if( computer.isPresent() ) {
			return new ContentAssistant(this::computeProposals);
		}
		return super.getContentAssist();
	}

	private List<ICompletionProposal> computeProposals(Integer offset) {
		System.err.println("Compute at: " + offset);
		Future<List<ICompletionProposal>> computedProposals = computer.get().compute(new ProposalContext(input, offset));
		try {
			return computedProposals.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {
		PresentationReconciler reconciler= new /*JavaPresentationReconciler*/ PresentationReconciler();
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

		DefaultDamagerRepairer dr= new DefaultDamagerRepairer(getCodeScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		dr= new DefaultDamagerRepairer(getJavaDocScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_DOC);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_DOC);

		dr= new DefaultDamagerRepairer(getMultilineCommentScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_MULTI_LINE_COMMENT);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_MULTI_LINE_COMMENT);

		dr= new DefaultDamagerRepairer(getSinglelineCommentScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_SINGLE_LINE_COMMENT);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_SINGLE_LINE_COMMENT);

		dr= new DefaultDamagerRepairer(getStringScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_STRING);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_STRING);

		dr= new DefaultDamagerRepairer(getStringScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_CHARACTER);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_CHARACTER);

		return reconciler;
	}

	private ITokenScanner getStringScanner() {
		return fStringScanner;
	}

	private ITokenScanner getSinglelineCommentScanner() {
		return fSinglelineCommentScanner;
	}

	private ITokenScanner getMultilineCommentScanner() {
		return fMultilineCommentScanner;
	}

	private ITokenScanner getJavaDocScanner() {
		return fJavaDocScanner;
	}

	private ITokenScanner getCodeScanner() {
		return fCodeScanner;
	}

	@Override
	public void setThemeId(String themeId) {
		super.setThemeId(themeId);
		URL url = getClass().getClassLoader().getResource("css/"+themeId+"-highlight.css");
		if( url != null ) {
			defaultStylesheet.set(url);
		} else {
			defaultStylesheet.set(getClass().getClassLoader().getResource("css/highlight.css"));
		}
	}

	private ReadOnlyObjectWrapper<URL> defaultStylesheet = new ReadOnlyObjectWrapper<>(this, "defaultStylesheet", getClass().getClassLoader().getResource("css/highlight.css"));

	@Override
	public ReadOnlyProperty<URL> getDefaultStylesheet() {
		return defaultStylesheet.getReadOnlyProperty();
	}
}
