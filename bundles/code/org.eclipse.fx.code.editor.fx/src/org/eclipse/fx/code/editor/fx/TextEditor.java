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
package org.eclipse.fx.code.editor.fx;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.core.di.ContextValue;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import javafx.beans.property.Property;
import javafx.scene.layout.BorderPane;

/**
 * Component setting up a JavaFX text editor
 */
@SuppressWarnings("restriction")
public class TextEditor {

	private IDocument document;

	private SourceViewerConfiguration configuration;

	private IDocumentPartitioner partitioner;

	private Input<?> input;

	private Property<Input<?>> activeInput;

	private SourceViewer viewer;

	@Inject
	public void setDocument(IDocument document) {
		if( viewer != null ) {
			throw new IllegalArgumentException("The document has to be set before the editor is initialized");
		}
		this.document = document;
	}

	@Inject
	public void setSourceViewerConfiguration(SourceViewerConfiguration configuration) {
		if( viewer != null ) {
			throw new IllegalArgumentException("The configuration has to be set before the editor is initialized");
		}
		this.configuration = configuration;
	}

	@Inject
	public void setPartitioner(IDocumentPartitioner partitioner) {
		if( viewer != null ) {
			throw new IllegalArgumentException("The partitioner has to be set before the editor is initialized");
		}

		this.partitioner = partitioner;
	}

	@Inject
	public void setInput(Input<?> input) {
		if( viewer != null ) {
			throw new IllegalArgumentException("The input has to be set before the editor is initialized");
		}

		this.input = input;
	}

	@Inject
	@Optional
	public void setActiveInputTracker(@ContextValue("activeInput") Property<Input<?>> activeInput) {
		this.activeInput = activeInput;
	}

	@PostConstruct
	public void initUI(BorderPane pane) {
		viewer = createSourceViewer();
		if( document instanceof IDocumentExtension3 ) {
			((IDocumentExtension3)document).setDocumentPartitioner(configuration.getConfiguredDocumentPartitioning(viewer),partitioner);
		} else {
			document.setDocumentPartitioner(partitioner);
		}
		document.setDocumentPartitioner(partitioner);
		partitioner.connect(document);

		viewer.configure(configuration);
		viewer.setDocument(document, configuration.getAnnotationModel());
		pane.setCenter(viewer);
		if( activeInput != null ) {
			activeInput.setValue(input);
		}
	}

	protected SourceViewer createSourceViewer() {
		return new SourceViewer();
	}

	@Persist
	public void save() {
		input.persist();
		documentSaved();
	}

	protected void documentSaved() {

	}

	@Focus
	void focused() {
		if( activeInput != null ) {
			activeInput.setValue(input);
		}

		viewer.getTextWidget().requestFocus();
		//TODO We should remember the caret offset
		if( viewer.getTextWidget().getCaretOffset() == -1 && viewer.getTextWidget().getContent().getCharCount() > 0 ) {
			viewer.getTextWidget().setCaretOffset(0);
		}
	}

	@PreDestroy
	void destroy() {
		if( activeInput != null && activeInput.getValue() == input ) {
			activeInput.setValue(null);
		}
		this.input = null;
	}
}
