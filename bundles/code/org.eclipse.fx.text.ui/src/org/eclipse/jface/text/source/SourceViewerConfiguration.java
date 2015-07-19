/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jface.text.source;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;

public abstract class SourceViewerConfiguration {
	public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
		return IDocumentExtension3.DEFAULT_PARTITIONING;
	}

	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler= new PresentationReconciler();
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
		return reconciler;
	}

	public abstract String getStyleclassName();

	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		return null;
	}

	public IContentAssistant getContentAssist() {
		return null;
	}

	public IAnnotationModel getAnnotationModel() {
		return null;
	}

	public List<AnnotationPresenter> getAnnotationPresenters() {
		return Collections.emptyList();
	}

	public AnnotationPainter getAnnotationPainter(ISourceViewer sourceViewer) {
		return null;
	}

}
