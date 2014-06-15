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
package org.eclipse.fx.code.compensator.editor;

import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class TextEditor {
	public static final String DOCUMENT_URL = "documentUrl";
	
	@Inject
	IDocument document;
	
	@Inject
	SourceViewerConfiguration configuration;
	
	@Inject
	IDocumentPartitioner partitioner;
	
	@PostConstruct
	public void initUI(BorderPane pane) {
		SourceViewer viewer = new SourceViewer();
		if( document instanceof IDocumentExtension3 ) {
			((IDocumentExtension3)document).setDocumentPartitioner(configuration.getConfiguredDocumentPartitioning(viewer),partitioner);
		} else {
			document.setDocumentPartitioner(partitioner);
		}
		document.setDocumentPartitioner(partitioner);
		partitioner.connect(document);
		
		viewer.configure(configuration);
		viewer.setDocument(document);
		pane.setCenter(viewer);
	}
}
