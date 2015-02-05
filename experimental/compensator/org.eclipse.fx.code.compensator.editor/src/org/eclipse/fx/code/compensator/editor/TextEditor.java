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

import javafx.beans.property.Property;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.fx.code.compensator.editor.services.DocumentPersitenceService;
import org.eclipse.fx.core.di.ContextValue;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class TextEditor {
	public static final String DOCUMENT_URL = "documentUrl";
	public static final String VCS_URL = "vcsUrl";

	@Inject
	IDocument document;

	@Inject
	SourceViewerConfiguration configuration;

	@Inject
	IDocumentPartitioner partitioner;

	@Inject
	DocumentPersitenceService persistenceService;

	@Inject
	Input<?> input;

	@Inject
	@ContextValue("activeInput")
	Property<Input<?>> activeInput;

	@Inject
	@Optional
	IAnnotationModel annotationModel;

	StyledTextArea textArea;

	String currentStyle;

	String currentId;

	@PostConstruct
	public void initUI(BorderPane pane, IEventBroker broker) {
		SourceViewer viewer = new SourceViewer();
		if( document instanceof IDocumentExtension3 ) {
			((IDocumentExtension3)document).setDocumentPartitioner(configuration.getConfiguredDocumentPartitioning(viewer),partitioner);
		} else {
			document.setDocumentPartitioner(partitioner);
		}
		document.setDocumentPartitioner(partitioner);
		partitioner.connect(document);
		document.addDocumentListener(new IDocumentListener() {

			@Override
			public void documentChanged(DocumentEvent event) {
				broker.send(org.eclipse.fx.code.compensator.editor.Constants.EDITOR_DOCUMENT_MODIFIED, TextEditor.this);
			}

			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {

			}
		});

		viewer.configure(configuration);
		viewer.setDocument(document, annotationModel);
		pane.setCenter(viewer);
		activeInput.setValue(input);
	}

	@Persist
	void save(IEventBroker broker) {
		if( persistenceService.persist(document) ) {
			broker.send(org.eclipse.fx.code.compensator.editor.Constants.OUTLINE_RELOAD, input);
			broker.send(org.eclipse.fx.code.compensator.editor.Constants.EDITOR_DOCUMENT_SAVED, TextEditor.this);
		} else {
			//TODO Handle that
		}
	}

	@Focus
	void focused() {
		activeInput.setValue(input);
		textArea.requestFocus();
		//TODO We should remember the caret offset
		if( textArea.getCaretOffset() == -1 && textArea.getContent().getCharCount() > 0 ) {
			textArea.setCaretOffset(0);
		}
	}

	@PreDestroy
	void destroy() {
		if( activeInput.getValue() == input ) {
			activeInput.setValue(null);
		}
		this.input.dispose();
		this.input = null;
	}
}
