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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.scene.Node;

import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.StyledTextLine;
import org.eclipse.fx.ui.services.resources.GraphicsLoader;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;

public class SourceViewer extends TextViewer implements ISourceViewer, ISourceViewerExtension, ISourceViewerExtension2, ISourceViewerExtension3, ISourceViewerExtension4 {

	private IPresentationReconciler fPresentationReconciler;
	private IReconciler fReconciler;
	private IAnnotationModel fVisualAnnotationModel;
	protected final static Object MODEL_ANNOTATION_MODEL= new Object();
	private Map<String, AnnotationPresenter> presenterMap = new HashMap<>();
	private GraphicsLoader graphicsLoader;

	@Override
	public void configure(SourceViewerConfiguration configuration) {
		if (getTextWidget() == null)
			return;
		
		getTextWidget().getStyleClass().add(configuration.getStyleclassName());

//		if( configuration.getDefaultStylesheet().getValue() != null ) {
//			getTextWidget().getStylesheets().add(configuration.getDefaultStylesheet().getValue().toExternalForm());
//		}
//
//		configuration.getDefaultStylesheet().addListener((obs,oldVal,newVal) -> {
//			if( oldVal != null ) {
//				getTextWidget().getStylesheets().remove(oldVal.toExternalForm());
//			}
//			if( newVal != null ) {
//				getTextWidget().getStylesheets().add(newVal.toExternalForm());
//			}
//		});

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

		//TODO This is complete different to JFace-Text
		IAnnotationModel annotationModel = configuration.getAnnotationModel();
		if( annotationModel != null ) {
			getTextWidget().setLineRulerGraphicNodeFactory(this::annotationFactory);
			annotationModel.addAnnotationModelListener(new IAnnotationModelListener() {

				private boolean scheduled = false;

				@Override
				public void modelChanged(IAnnotationModel model) {
					if( ! scheduled ) {
						scheduled = true;
						Platform.runLater(() -> {
							scheduled = false;
							System.err.println("REFRESHING");
							getTextWidget().refreshLineRuler();
						});
					}
				}

			});
		}

		if( configuration.getAnnotationPresenters() != null ) {
			configuration.getAnnotationPresenters().stream().forEach(p -> p.getTypes().forEach( s -> presenterMap.put(s,p)));	
		}
		
//		presenterMap.putAll(configuration.getAnnotationPresenters().stream().collect(Collectors.toMap(p -> p.getType(), p -> p)));
		graphicsLoader = configuration.getGraphicsLoader();

		AnnotationPainter annotationPainter = configuration.getAnnotationPainter(this);
		if( annotationModel != null && annotationPainter != null ) {
			annotationModel.addAnnotationModelListener(annotationPainter);
			addTextPresentationListener(annotationPainter);
		}
	}

	private Node annotationFactory(StyledTextLine l) {
		//TODO Should use IAnnotationExtension2
		@SuppressWarnings("unchecked")
		Iterator<Annotation> annotationIterator = fVisualAnnotationModel.getAnnotationIterator();
		while( annotationIterator.hasNext() ) {
			Annotation a = annotationIterator.next();
			Position position = fVisualAnnotationModel.getPosition(a);

			if( l.getLineIndex() == getTextWidget().getContent().getLineAtOffset(position.offset) ) {
				AnnotationPresenter annotationPresenter = presenterMap.get(a.getType());
				if( annotationPresenter != null ) {
					return annotationPresenter.getPresentation(a, graphicsLoader);
				}
				return null;
			}
		}
		return null;
	}

	/**
	 * Disposes the visual annotation model.
	 *
	 * @since 3.1
	 */
	protected void disposeVisualAnnotationModel() {
		if (fVisualAnnotationModel != null) {
			if (getDocument() != null)
				fVisualAnnotationModel.disconnect(getDocument());

			if ( fVisualAnnotationModel instanceof IAnnotationModelExtension)
				((IAnnotationModelExtension)fVisualAnnotationModel).removeAnnotationModel(MODEL_ANNOTATION_MODEL);

			fVisualAnnotationModel= null;
		}
	}

	/**
	 * Creates the visual annotation model on top of the given annotation model.
	 *
	 * @param annotationModel the wrapped annotation model
	 * @return the visual annotation model on top of the given annotation model
	 * @since 3.0
	 */
	protected IAnnotationModel createVisualAnnotationModel(IAnnotationModel annotationModel) {
		IAnnotationModelExtension model= new AnnotationModel();
		model.addAnnotationModel(MODEL_ANNOTATION_MODEL, annotationModel);
		return (IAnnotationModel) model;
	}

	public void setDocument(IDocument document, IAnnotationModel annotationModel) {
		setDocument(document, annotationModel, -1, -1);
	}

	@Override
	public void setDocument(IDocument document, IAnnotationModel annotationModel, int modelRangeOffset, int modelRangeLength) {
		disposeVisualAnnotationModel();

		if (annotationModel != null && document != null) {
			fVisualAnnotationModel= createVisualAnnotationModel(annotationModel);

			// Make sure the visual model uses the same lock as the underlying model
			if (annotationModel instanceof ISynchronizable && fVisualAnnotationModel instanceof ISynchronizable) {
				ISynchronizable sync= (ISynchronizable)fVisualAnnotationModel;
				sync.setLockObject(((ISynchronizable)annotationModel).getLockObject());
			}

			fVisualAnnotationModel.connect(document);
		}

		if (modelRangeOffset == -1 && modelRangeLength == -1)
			super.setDocument(document);
		else
			super.setDocument(document, modelRangeOffset, modelRangeLength);
	}

	@Override
	public IAnnotationModel getAnnotationModel() {
		return fVisualAnnotationModel;
	}
}
