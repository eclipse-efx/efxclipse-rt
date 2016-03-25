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
package org.eclipse.fx.text.ui.source;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.fx.text.hover.HoverInfo;
import org.eclipse.fx.text.navigation.NavigationRegion;
import org.eclipse.fx.text.ui.DefaultUndoManager;
import org.eclipse.fx.text.ui.Feature;
import org.eclipse.fx.text.ui.ITextHover;
import org.eclipse.fx.text.ui.IUndoManager;
import org.eclipse.fx.text.ui.contentassist.IContentAssistant;
import org.eclipse.fx.text.ui.presentation.IPresentationReconciler;
import org.eclipse.fx.text.ui.presentation.PresentationReconciler;
import org.eclipse.fx.text.ui.reconciler.IReconciler;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.QuickLinkable;
import org.eclipse.fx.ui.controls.styledtext.TriggerActionMapping;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;

import javafx.beans.property.SetProperty;

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

	public SetProperty<Feature> getFeatures() {
		return null;
	}

	public AnnotationPresenter getAnnotationPresenter() {
		return null;
	}

	public AnnotationPainter getAnnotationPainter(ISourceViewer sourceViewer) {
		return null;
	}

	public IUndoManager getUndoManager(ISourceViewer sourceViewer) {
		return new DefaultUndoManager(25);
	}

	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
		return null;
	}

	public Set<HoverInfo> getDocumentHoverInfo(IDocument document, int offset) {
		return Collections.emptySet();
	}

	public Set<HoverInfo> getAnnotationHoverInfo(Annotation annotation) {
		return Collections.emptySet();
	}

	public String[] getConfiguredContentTypes(SourceViewer sourceViewer) {
		return new String[] { IDocument.DEFAULT_CONTENT_TYPE };
	}

	public Function<Integer, Optional<QuickLinkable>> getQuicklinkCallback() {
		return (offset) -> Optional.empty();
	}

	public TriggerActionMapping getOverrideMapping() {
		return null;
	}
}
