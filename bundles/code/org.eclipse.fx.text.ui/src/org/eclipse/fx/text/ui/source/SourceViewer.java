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
package org.eclipse.fx.text.ui.source;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.commands.operations.TriggeredOperations;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.text.SourceTextEditActions;
import org.eclipse.fx.core.text.TextEditAction;
import org.eclipse.fx.text.hover.HoverInfo;
import org.eclipse.fx.text.navigation.NavigationRegion;
import org.eclipse.fx.text.navigation.NavigationTarget;
import org.eclipse.fx.text.ui.ITextViewerExtension2;
import org.eclipse.fx.text.ui.TextViewer;
import org.eclipse.fx.text.ui.contentassist.ContentAssistant;
import org.eclipse.fx.text.ui.contentassist.IContentAssistant;
import org.eclipse.fx.text.ui.internal.AnnotationModelSupport;
import org.eclipse.fx.text.ui.internal.SimpleSmartIndent;
import org.eclipse.fx.text.ui.internal.WrappedLineRulerAnnotationPresenter;
import org.eclipse.fx.text.ui.internal.WrappedTextAnnotationPresenter;
import org.eclipse.fx.text.ui.presentation.IPresentationReconciler;
import org.eclipse.fx.text.ui.reconciler.IReconciler;
import org.eclipse.fx.ui.controls.styledtext.TriggerActionMapping;
import org.eclipse.fx.ui.controls.styledtext.TriggerActionMapping.Context;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.QuickLink;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.QuickLinkable;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.SimpleQuickLink;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;

import com.google.common.collect.Range;

public class SourceViewer extends TextViewer implements ISourceViewer, ISourceViewerExtension, ISourceViewerExtension2, ISourceViewerExtension3, ISourceViewerExtension4 {

	private IPresentationReconciler fPresentationReconciler;
	private IReconciler fReconciler;
	private IAnnotationModel fVisualAnnotationModel;
	protected final static Object MODEL_ANNOTATION_MODEL= new Object();

	private Annotation fRangeIndicator;

	private final TriggerActionMapping actionMapping = new TriggerActionMapping();

	private BiFunction<IDocument, Integer, Set<HoverInfo>> documentHoverInfoLookup = null;
	private Function<Annotation, Set<HoverInfo>> annotationHoverInfoLookup = null;

	private void initSourceViewerActionMapping() {
		this.actionMapping.map("Ctrl+Space", SourceTextEditActions.PROPOSAL_REQUEST); //$NON-NLS-1$
		super.getActionMapping().setOverride(actionMapping);
	}

	@Override
	public Subscription subscribeAction(BiFunction<TextEditAction, Context, Boolean> handler) {
		return actionMapping.subscribe(handler);
	}

	@Override
	public void configure(SourceViewerConfiguration configuration) {
		if (getTextWidget() == null)
			return;

		initSourceViewerActionMapping();

		this.actionMapping.setOverride(configuration.getOverrideMapping());

		if (configuration.getFeatures() != null) {
			getFeatures().bind(configuration.getFeatures());
		}

		setUndoManager(configuration.getUndoManager(this));

		getTextWidget().getStyleClass().add(configuration.getStyleclassName());

		this.documentHoverInfoLookup = configuration::getDocumentHoverInfo;
		this.annotationHoverInfoLookup = configuration::getAnnotationHoverInfo;

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


		if( configuration.getAnnotationPresenter() != null ) {
			// install presenters
			configuration.getAnnotationPresenter().getLineRulerAnnotationPresenter().forEach(p -> {
				System.err.println("adding line ruler presenter " + p);
				getTextWidget().getAnnotationPresenter().add(new WrappedLineRulerAnnotationPresenter(p));
			});
			configuration.getAnnotationPresenter().getTextAnnotationPresenter().forEach(p -> {
				getTextWidget().getAnnotationPresenter().add(new WrappedTextAnnotationPresenter(p));
			});
		}


//		AnnotationPainter annotationPainter = configuration.getAnnotationPainter(this);
//		if( annotationModel != null && annotationPainter != null ) {
//			annotationModel.addAnnotationModelListener(annotationPainter);
//			addTextPresentationListener(annotationPainter);
//		}

		String[] types= configuration.getConfiguredContentTypes(this);
		for (int i= 0; i < types.length; i++) {
			String t = types[i];
			setTextHover(configuration.getTextHover(this, t), t, ITextViewerExtension2.DEFAULT_HOVER_STATE_MASK);
		}

		IAnnotationModel annotationModel = configuration.getAnnotationModel();
		// register annotation model with text widget
		if (annotationModel != null) {
			AnnotationModelSupport support = new AnnotationModelSupport(annotationModel, getTextWidget());
			support.install();
		}

		getTextWidget().setQuickLinkCallback(configuration.getQuicklinkCallback());


		new SimpleSmartIndent(this);

	}

	@Override
	public Set<HoverInfo> getHoverInfo(int offset) {
		if (this.documentHoverInfoLookup != null) {
			return this.documentHoverInfoLookup.apply(getDocument(), offset);
		}
		return super.getHoverInfo(offset);
	}

	@Override
	public Set<HoverInfo> getHoverInfo(Annotation annotation) {
		if (this.annotationHoverInfoLookup != null) {
			return this.annotationHoverInfoLookup.apply(annotation);
		}
		return super.getHoverInfo(annotation);
	}

	/**
	 * Disposes the visual annotation model.
	 *
	 * @since 3.1
	 */
	protected void disposeVisualAnnotationModel() {
		if (this.fVisualAnnotationModel != null) {
			if (getDocument() != null)
				this.fVisualAnnotationModel.disconnect(getDocument());

			if ( this.fVisualAnnotationModel instanceof IAnnotationModelExtension)
				((IAnnotationModelExtension)this.fVisualAnnotationModel).removeAnnotationModel(MODEL_ANNOTATION_MODEL);

			this.fVisualAnnotationModel= null;
		}
	}

	/**
	 * Creates the visual annotation model on top of the given annotation model.
	 *
	 * @param annotationModel the wrapped annotation model
	 * @return the visual annotation model on top of the given annotation model
	 * @since 3.0
	 */
	@SuppressWarnings("static-method")
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
			this.fVisualAnnotationModel= createVisualAnnotationModel(annotationModel);

			// Make sure the visual model uses the same lock as the underlying model
			if (annotationModel instanceof ISynchronizable && this.fVisualAnnotationModel instanceof ISynchronizable) {
				ISynchronizable sync= (ISynchronizable)this.fVisualAnnotationModel;
				sync.setLockObject(((ISynchronizable)annotationModel).getLockObject());
			}

			this.fVisualAnnotationModel.connect(document);
		}

		if (modelRangeOffset == -1 && modelRangeLength == -1)
			super.setDocument(document);
		else
			super.setDocument(document, modelRangeOffset, modelRangeLength);
	}

	@Override
	public IAnnotationModel getAnnotationModel() {
		if (this.fVisualAnnotationModel instanceof IAnnotationModelExtension) {
			IAnnotationModelExtension extension= (IAnnotationModelExtension) this.fVisualAnnotationModel;
			return extension.getAnnotationModel(MODEL_ANNOTATION_MODEL);
		}
		return null;
	}

	public IAnnotationModel getVisualAnnotationModel() {
		return this.fVisualAnnotationModel;
	}

	public void setRangeIndicator(Annotation rangeIndicator) {
		this.fRangeIndicator= rangeIndicator;
	}

	public IRegion getRangeIndication() {
		if (this.fRangeIndicator != null && this.fVisualAnnotationModel != null) {
			Position position= this.fVisualAnnotationModel.getPosition(this.fRangeIndicator);
			if (position != null)
				return new Region(position.getOffset(), position.getLength());
		}

		return null;
	}

}
