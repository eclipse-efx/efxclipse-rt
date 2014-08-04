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

import java.net.URL;

import javafx.beans.property.ReadOnlyProperty;

import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;

public abstract class SourceViewerConfiguration {
	private String themeId;
	
	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}
	
	public String getThemeId() {
		return this.themeId;
	}
	
	public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
		return IDocumentExtension3.DEFAULT_PARTITIONING;
	}
	
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler= new PresentationReconciler();
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
		return reconciler;
	}
	
	public abstract ReadOnlyProperty<URL> getDefaultStylesheet();
	
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		return null;
	}
}
