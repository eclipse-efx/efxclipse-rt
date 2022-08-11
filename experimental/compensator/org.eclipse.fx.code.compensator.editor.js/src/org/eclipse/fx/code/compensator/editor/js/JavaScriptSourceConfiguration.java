/*******************************************************************************
* Copyright (c) 2014 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.code.compensator.editor.js;

import java.net.URL;

import javax.inject.Inject;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyProperty;

import org.eclipse.fx.code.compensator.editor.js.scanner.IJavaScriptColorConstants;
import org.eclipse.fx.code.compensator.editor.js.scanner.IJavaScriptPartitions;
import org.eclipse.fx.code.compensator.editor.js.scanner.JavaScriptCodeScanner;
import org.eclipse.fx.code.compensator.editor.js.scanner.JavaScriptCommentScanner;
import org.eclipse.fx.code.compensator.editor.js.scanner.JavaScriptDocScanner;
import org.eclipse.fx.code.compensator.editor.js.scanner.SingleTokenJavaScriptScanner;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class JavaScriptSourceConfiguration extends SourceViewerConfiguration {

	private JavaScriptCodeScanner fCodeScanner;
	private JavaScriptDocScanner fJavaDocScanner;
	private JavaScriptCommentScanner fMultilineCommentScanner;
	private JavaScriptCommentScanner fSinglelineCommentScanner;
	private SingleTokenJavaScriptScanner fStringScanner;

	@Inject
	public JavaScriptSourceConfiguration() {
		initializeScanners();
	}

	private void initializeScanners() {
		fCodeScanner= new JavaScriptCodeScanner();
		fMultilineCommentScanner= new JavaScriptCommentScanner(IJavaScriptColorConstants.JAVA_MULTI_LINE_COMMENT);
		fSinglelineCommentScanner= new JavaScriptCommentScanner(IJavaScriptColorConstants.JAVA_SINGLE_LINE_COMMENT);
		fStringScanner= new SingleTokenJavaScriptScanner(IJavaScriptColorConstants.JAVA_STRING);
		fJavaDocScanner= new JavaScriptDocScanner();
	}
	
	@Override
	public String getStyleclassName() {
		return "javascript";
	}

	@Override
	public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
		return IJavaScriptPartitions.JAVA_PARTITIONING;
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
		reconciler.setDamager(dr, IJavaScriptPartitions.JAVA_DOC);
		reconciler.setRepairer(dr, IJavaScriptPartitions.JAVA_DOC);

		dr= new DefaultDamagerRepairer(getMultilineCommentScanner());
		reconciler.setDamager(dr, IJavaScriptPartitions.JAVA_MULTI_LINE_COMMENT);
		reconciler.setRepairer(dr, IJavaScriptPartitions.JAVA_MULTI_LINE_COMMENT);

		dr= new DefaultDamagerRepairer(getSinglelineCommentScanner());
		reconciler.setDamager(dr, IJavaScriptPartitions.JAVA_SINGLE_LINE_COMMENT);
		reconciler.setRepairer(dr, IJavaScriptPartitions.JAVA_SINGLE_LINE_COMMENT);

		dr= new DefaultDamagerRepairer(getStringScanner());
		reconciler.setDamager(dr, IJavaScriptPartitions.JAVA_STRING);
		reconciler.setRepairer(dr, IJavaScriptPartitions.JAVA_STRING);

		dr= new DefaultDamagerRepairer(getStringScanner());
		reconciler.setDamager(dr, IJavaScriptPartitions.JAVA_CHARACTER);
		reconciler.setRepairer(dr, IJavaScriptPartitions.JAVA_CHARACTER);

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

}
