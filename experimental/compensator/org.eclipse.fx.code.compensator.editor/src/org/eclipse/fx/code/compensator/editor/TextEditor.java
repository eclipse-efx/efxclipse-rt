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

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.services.Constants;
import org.eclipse.fx.ui.services.theme.ThemeManager;
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
	
	StyledTextArea textArea;
	
	String currentStyle;
	
	String currentId;
	
	@PostConstruct
	public void initUI(BorderPane pane, ThemeManager manager, IEventBroker broker) {
		SourceViewer viewer = new SourceViewer() {
			@Override
			protected StyledTextArea createTextWidget() {
				textArea = super.createTextWidget();
				currentId = manager.getCurrentTheme().getId();
				currentStyle = getClass().getClassLoader().getResource("css/"+currentId+"-editor.css").toExternalForm();
				textArea.getStylesheets().add(currentStyle);
				configuration.setThemeId(currentId);
				return textArea;
			}
		};
		broker.subscribe(Constants.THEME_CHANGED, (e) -> { 
			textArea.getStylesheets().remove(currentStyle);
			currentId = manager.getCurrentTheme().getId();
			currentStyle = getClass().getClassLoader().getResource("css/"+currentId+"-editor.css").toExternalForm();
			textArea.getStylesheets().add(currentStyle);
			configuration.setThemeId(currentId);
		});
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
