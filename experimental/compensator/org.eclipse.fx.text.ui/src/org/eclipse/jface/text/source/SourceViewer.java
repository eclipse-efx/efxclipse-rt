/*******************************************************************************
 * Copyright (c) 2000, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Tom Eicher (Avaloq Evolution AG) - block selection mode
 *     Tom Hofmann (Perspectix AG) - bug 297572
 *******************************************************************************/
package org.eclipse.jface.text.source;

import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;

public class SourceViewer extends TextViewer implements ISourceViewer, ISourceViewerExtension, ISourceViewerExtension2, ISourceViewerExtension3, ISourceViewerExtension4 {

	private IPresentationReconciler fPresentationReconciler;
	private IReconciler fReconciler;

	@Override
	public void configure(SourceViewerConfiguration configuration) {
		if (getTextWidget() == null)
			return;

		if( configuration.getDefaultStylesheet().getValue() != null ) {
			getTextWidget().getStylesheets().add(configuration.getDefaultStylesheet().getValue().toExternalForm());
		}

		configuration.getDefaultStylesheet().addListener((obs,oldVal,newVal) -> {
			if( oldVal != null ) {
				getTextWidget().getStylesheets().remove(oldVal.toExternalForm());
			}
			if( newVal != null ) {
				getTextWidget().getStylesheets().add(newVal.toExternalForm());
			}
		});

		setDocumentPartitioning(configuration.getConfiguredDocumentPartitioning(this));

		// install content type independent plug-ins
		fPresentationReconciler= configuration.getPresentationReconciler(this);
		if (fPresentationReconciler != null)
			fPresentationReconciler.install(this);

		fReconciler= configuration.getReconciler(this);
		if (fReconciler != null)
			fReconciler.install(this);

		IContentAssistant assist = configuration.getContentAssist();
		if( assist != null ) {
			assist.install(this);
		}
	}

}
