/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.ui.source;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javafx.application.Platform;
import javafx.scene.paint.Color;

import org.eclipse.fx.text.ui.ITextInputListener;
import org.eclipse.fx.text.ui.ITextPresentationListener;
import org.eclipse.fx.text.ui.ITextViewerExtension2;
import org.eclipse.fx.text.ui.ITextViewerExtension5;
import org.eclipse.fx.text.ui.TextPresentation;
import org.eclipse.fx.ui.controls.styledtext.StyleRange;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModelEvent;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelListener;
import org.eclipse.jface.text.source.IAnnotationModelListenerExtension;

public class AnnotationPainter implements IAnnotationModelListener, IAnnotationModelListenerExtension, ITextPresentationListener {
	/**
	 * Mutex for for decorations map.
	 * @since 3.0
	 */
	private Object fHighlightedDecorationsMapLock= new Object();

	private Map<Annotation,Decoration> fHighlightedDecorationsMap= new HashMap<>(); // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=50767

	/**
	 * The presentation information (decoration) for an annotation.  Each such
	 * object represents one decoration drawn on the text area, such as squiggly lines
	 * and underlines.
	 */
	private static class Decoration {
		/** The position of this decoration */
		private Position fPosition;
		/** The color of this decoration */
		private String fAnnotationClass;
		/**
		 * The annotation's layer
		 * @since 3.0
		 */
		private int fLayer;
		/**
		 * The painting strategy for this decoration.
		 * @since 3.0
		 */
		private Object fPaintingStrategy;
	}

	/**
	 * A text style painting strategy draws the decoration for an annotation
	 * onto the text widget by applying a {@link TextStyle} on a given
	 * {@link StyleRange}.
	 *
	 * @since 3.4
	 */
	public interface ITextStyleStrategy {

		/**
		 * Applies a text style on the given <code>StyleRange</code>.
		 *
		 * @param styleRange the style range on which to apply the text style
		 * @param annotationColor the color of the annotation
		 */
//		void applyTextStyle(StyleRange styleRange, Color annotationColor);
		void applyTextStyle(StyleRange styleRange, String annotationStyleClass);
	}


	private ISourceViewer fSourceViewer;
	/** The cached widget of the source viewer */
	private StyledTextArea fTextWidget;
	/** The annotation model providing the annotations to be drawn */
//	private IAnnotationModel fModel;
	/** The annotation access */
	private IAnnotationAccess fAnnotationAccess;

	private Object fDecorationMapLock= new Object();
//	private Map fDecorationsMap= new HashMap(); // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=50767

	private Position fTotalHighlightAnnotationRange= null;

	/**
	 * The range in which the current highlight annotations can be found.
	 * @since 3.0
	 */
	private Position fCurrentHighlightAnnotationRange= null;
	private Map fCachedAnnotationType2PaintingStrategy= new HashMap();
	private Map fPaintingStrategyId2PaintingStrategy= new HashMap();
	private Map fAnnotationType2PaintingStrategyId= new HashMap();
	private Map fCachedAnnotationType2Color= new HashMap();
	private Map fAnnotationType2Color= new HashMap();

	private volatile boolean  fIsSettingModel= false;
	private boolean fInputDocumentAboutToBeChanged;
	private ITextInputListener fTextInputListener;

	/**
	 * Creates a new annotation painter for the given source viewer and with the
	 * given annotation access. The painter is not initialized, i.e. no
	 * annotation types are configured to be painted.
	 *
	 * @param sourceViewer the source viewer for this painter
	 * @param access the annotation access for this painter
	 */
	public AnnotationPainter(ISourceViewer sourceViewer, IAnnotationAccess access) {
		fSourceViewer= sourceViewer;
		fAnnotationAccess= access;
		fTextWidget= sourceViewer.getTextWidget();
	}

	/**
	 * Updates the set of decorations based on the current state of
	 * the painter's annotation model.
	 *
	 * @param event the annotation model event
	 */
	private void catchupWithModel(AnnotationModelEvent event) {

		synchronized (fDecorationMapLock) {
//			if (fDecorationsMap == null)
//				return;
		}

		if (fSourceViewer.getAnnotationModel() == null) {
			// annotation model is null -> clear all
//			synchronized (fDecorationMapLock) {
//				fDecorationsMap.clear();
//			}
			synchronized (fHighlightedDecorationsMapLock) {
				fHighlightedDecorationsMap.clear();
			}
			return;
		}

//		IRegion clippingRegion= computeClippingRegion(null, true);
		IDocument document= fSourceViewer.getDocument();

		int highlightAnnotationRangeStart= Integer.MAX_VALUE;
		int highlightAnnotationRangeEnd= -1;

		int drawRangeStart= Integer.MAX_VALUE;
		int drawRangeEnd= -1;

//		Map decorationsMap;
		Map highlightedDecorationsMap;

		// Clone decoration maps
//		synchronized (fDecorationMapLock) {
//			decorationsMap= new HashMap(fDecorationsMap);
//		}
		synchronized (fHighlightedDecorationsMapLock) {
			highlightedDecorationsMap= new HashMap<>(fHighlightedDecorationsMap);
		}

		boolean isWorldChange= false;

		Iterator e;
		if (event == null || event.isWorldChange()) {
			isWorldChange= true;

//			if (DEBUG && event == null)
//				System.out.println("AP: INTERNAL CHANGE"); //$NON-NLS-1$

//			Iterator iter= decorationsMap.entrySet().iterator();
//			while (iter.hasNext()) {
//				Map.Entry entry= (Map.Entry)iter.next();
//				Annotation annotation= (Annotation)entry.getKey();
//				Decoration decoration= (Decoration)entry.getValue();
////				drawDecoration(decoration, null, annotation, clippingRegion, document);
//			}

//			decorationsMap.clear();

			highlightedDecorationsMap.clear();

			e= fSourceViewer.getAnnotationModel().getAnnotationIterator();


		} else {

			// Remove annotations
			Annotation[] removedAnnotations= event.getRemovedAnnotations();
			for (int i= 0, length= removedAnnotations.length; i < length; i++) {
				Annotation annotation= removedAnnotations[i];
				Decoration decoration= (Decoration)highlightedDecorationsMap.remove(annotation);
				if (decoration != null) {
					Position position= decoration.fPosition;
					if (position != null) {
						highlightAnnotationRangeStart= Math.min(highlightAnnotationRangeStart, position.offset);
						highlightAnnotationRangeEnd= Math.max(highlightAnnotationRangeEnd, position.offset + position.length);
					}
				}
//				decoration= (Decoration)decorationsMap.remove(annotation);
//				if (decoration != null) {
////					drawDecoration(decoration, null, annotation, clippingRegion, document);
//					Position position= decoration.fPosition;
//					if (position != null) {
//						drawRangeStart= Math.min(drawRangeStart, position.offset);
//						drawRangeEnd= Math.max(drawRangeEnd, position.offset + position.length);
//					}
//				}

			}

			// Update existing annotations
			Annotation[] changedAnnotations= event.getChangedAnnotations();
			for (int i= 0, length= changedAnnotations.length; i < length; i++) {
				Annotation annotation= changedAnnotations[i];

				boolean isHighlighting= false;

				Decoration decoration= (Decoration)highlightedDecorationsMap.get(annotation);

				if (decoration != null) {
					isHighlighting= true;
					// The call below updates the decoration - no need to create new decoration
					decoration= getDecoration(annotation, decoration);
					if (decoration == null) {
						Decoration removedDecoration= (Decoration)highlightedDecorationsMap.remove(annotation);
						if (removedDecoration != null) {
							highlightAnnotationRangeStart= Math.min(highlightAnnotationRangeStart, removedDecoration.fPosition.offset);
							highlightAnnotationRangeEnd= Math.max(highlightAnnotationRangeEnd, removedDecoration.fPosition.offset + removedDecoration.fPosition.length);
						}
					}

				} else {
					decoration= getDecoration(annotation, decoration);
					if (decoration != null && decoration.fPaintingStrategy instanceof ITextStyleStrategy) {
						highlightedDecorationsMap.put(annotation, decoration);
						isHighlighting= true;
					}
				}

				boolean usesDrawingStrategy= !isHighlighting && decoration != null;

				Position position= null;
				if (decoration == null)
					position= fSourceViewer.getAnnotationModel().getPosition(annotation);
				else
					position= decoration.fPosition;

				if (position != null && !position.isDeleted()) {
					if (isHighlighting) {
						highlightAnnotationRangeStart= Math.min(highlightAnnotationRangeStart, position.offset);
						highlightAnnotationRangeEnd= Math.max(highlightAnnotationRangeEnd, position.offset + position.length);
					}
					if (usesDrawingStrategy) {
						drawRangeStart= Math.min(drawRangeStart, position.offset);
						drawRangeEnd= Math.max(drawRangeEnd, position.offset + position.length);
					}
				} else {
					Decoration removedDecoration= (Decoration)highlightedDecorationsMap.remove(annotation);
					if (removedDecoration != null) {
						highlightAnnotationRangeStart= Math.min(highlightAnnotationRangeStart, removedDecoration.fPosition.offset);
						highlightAnnotationRangeEnd= Math.max(highlightAnnotationRangeEnd, removedDecoration.fPosition.offset + removedDecoration.fPosition.length);
					}
				}

//				if (usesDrawingStrategy) {
//					Decoration oldDecoration= (Decoration)decorationsMap.get(annotation);
//					if (oldDecoration != null) {
////						drawDecoration(oldDecoration, null, annotation, clippingRegion, document);
//						if (decoration != null)
//							decorationsMap.put(annotation, decoration);
//						else
//							decorationsMap.remove(annotation);
//					}
//				}
			}

			e= Arrays.asList(event.getAddedAnnotations()).iterator();
		}

		// Add new annotations
		while (e.hasNext()) {
			Annotation annotation= (Annotation)e.next();
			Decoration pp= getDecoration(annotation, null);
			if (pp != null) {
//				if (pp.fPaintingStrategy instanceof IDrawingStrategy) {
//					decorationsMap.put(annotation, pp);
//					drawRangeStart= Math.min(drawRangeStart, pp.fPosition.offset);
//					drawRangeEnd= Math.max(drawRangeEnd, pp.fPosition.offset + pp.fPosition.length);
//				} else
				if (pp.fPaintingStrategy instanceof ITextStyleStrategy) {
					highlightedDecorationsMap.put(annotation, pp);
					highlightAnnotationRangeStart= Math.min(highlightAnnotationRangeStart, pp.fPosition.offset);
					highlightAnnotationRangeEnd= Math.max(highlightAnnotationRangeEnd, pp.fPosition.offset + pp.fPosition.length);
				}

			}
		}

//		synchronized (fDecorationMapLock) {
//			fDecorationsMap= decorationsMap;
//			updateDrawRanges(drawRangeStart, drawRangeEnd, isWorldChange);
//		}

		synchronized (fHighlightedDecorationsMapLock) {
			fHighlightedDecorationsMap= highlightedDecorationsMap;
			updateHighlightRanges(highlightAnnotationRangeStart, highlightAnnotationRangeEnd, isWorldChange);
		}
	}

	@Override
	public void applyTextPresentation(TextPresentation tp) {
		Set<Entry<Annotation,Decoration>> decorations;

		synchronized (fHighlightedDecorationsMapLock) {
			if (fHighlightedDecorationsMap == null || fHighlightedDecorationsMap.isEmpty())
				return;

			decorations= new HashSet<>(fHighlightedDecorationsMap.entrySet());
		}

		IRegion region= tp.getExtent();

//		if (DEBUG)
//			System.out.println("AP: applying text presentation offset: " + region.getOffset() + ", length= " + region.getLength()); //$NON-NLS-1$ //$NON-NLS-2$

		for (int layer= 0, maxLayer= 1;	layer < maxLayer; layer++) {

			for (Iterator<?> iter= decorations.iterator(); iter.hasNext();) {
				Map.@NonNull Entry entry= (Map.@NonNull Entry)iter.next();

				Annotation a= (Annotation)entry.getKey();
				if (a.isMarkedDeleted())
					continue;

				Decoration pp = (Decoration)entry.getValue();

				maxLayer= Math.max(maxLayer, pp.fLayer + 1); // dynamically update layer maximum
				if (pp.fLayer != layer)	// wrong layer: skip annotation
					continue;

				Position p= pp.fPosition;
				if (fSourceViewer instanceof ITextViewerExtension5) {
					ITextViewerExtension5 extension3= (ITextViewerExtension5) fSourceViewer;
					if (null == extension3.modelRange2WidgetRange(new Region(p.getOffset(), p.getLength())))
						continue;
				} else if (!fSourceViewer.overlapsWithVisibleRegion(p.offset, p.length)) {
					continue;
				}

				int regionEnd= region.getOffset() + region.getLength();
				int pEnd= p.getOffset() + p.getLength();
				if (pEnd >= region.getOffset() && regionEnd > p.getOffset()) {
					int start= Math.max(p.getOffset(), region.getOffset());
					int end= Math.min(regionEnd, pEnd);
					int length= Math.max(end - start, 0);
					StyleRange styleRange= new StyleRange(null,start, length, null, null);
					((ITextStyleStrategy)pp.fPaintingStrategy).applyTextStyle(styleRange, pp.fAnnotationClass);
					tp.mergeStyleRange(styleRange);
				}
			}
		}
	}

	private Decoration getDecoration(Annotation annotation, Decoration decoration) {

		if (annotation.isMarkedDeleted())
			return null;

		String type= annotation.getType();

		Object paintingStrategy= getPaintingStrategy(type);
		if (paintingStrategy == null)
			return null;

		String color= getColor(type);
		if (color == null)
			return null;

		Position position= fSourceViewer.getAnnotationModel().getPosition(annotation);
		if (position == null || position.isDeleted())
			return null;

		if (decoration == null)
			decoration= new Decoration();

		decoration.fPosition= position;
		decoration.fAnnotationClass= color;
//		if (fAnnotationAccess instanceof IAnnotationAccessExtension) {
//			IAnnotationAccessExtension extension= (IAnnotationAccessExtension) fAnnotationAccess;
//			decoration.fLayer= extension.getLayer(annotation);
//		} else {
//			decoration.fLayer= IAnnotationAccessExtension.DEFAULT_LAYER;
//		}

		decoration.fPaintingStrategy= paintingStrategy;

		return decoration;
	}

	private void updateHighlightRanges(int highlightAnnotationRangeStart, int highlightAnnotationRangeEnd, boolean isWorldChange) {
		if (highlightAnnotationRangeStart != Integer.MAX_VALUE) {

			int maxRangeStart= highlightAnnotationRangeStart;
			int maxRangeEnd= highlightAnnotationRangeEnd;

			if (fTotalHighlightAnnotationRange != null) {
				maxRangeStart= Math.min(maxRangeStart, fTotalHighlightAnnotationRange.offset);
				maxRangeEnd= Math.max(maxRangeEnd, fTotalHighlightAnnotationRange.offset + fTotalHighlightAnnotationRange.length);
			}

			if (fTotalHighlightAnnotationRange == null)
				fTotalHighlightAnnotationRange= new Position(0);
			if (fCurrentHighlightAnnotationRange == null)
				fCurrentHighlightAnnotationRange= new Position(0);

			if (isWorldChange) {
				fTotalHighlightAnnotationRange.offset= highlightAnnotationRangeStart;
				fTotalHighlightAnnotationRange.length= highlightAnnotationRangeEnd - highlightAnnotationRangeStart;
				fCurrentHighlightAnnotationRange.offset= maxRangeStart;
				fCurrentHighlightAnnotationRange.length= maxRangeEnd - maxRangeStart;
			} else {
				fTotalHighlightAnnotationRange.offset= maxRangeStart;
				fTotalHighlightAnnotationRange.length= maxRangeEnd - maxRangeStart;
				fCurrentHighlightAnnotationRange.offset=highlightAnnotationRangeStart;
				fCurrentHighlightAnnotationRange.length= highlightAnnotationRangeEnd - highlightAnnotationRangeStart;
			}
		} else {
			if (isWorldChange) {
				fCurrentHighlightAnnotationRange= fTotalHighlightAnnotationRange;
				fTotalHighlightAnnotationRange= null;
			} else {
				fCurrentHighlightAnnotationRange= null;
			}
		}

		adaptToDocumentLength(fCurrentHighlightAnnotationRange);
		adaptToDocumentLength(fTotalHighlightAnnotationRange);
	}

	private void adaptToDocumentLength(Position position) {
		if (position == null)
			return;

		int length= fSourceViewer.getDocument().getLength();
		position.offset= Math.min(position.offset, length);
		position.length= Math.min(position.length, length - position.offset);
	}

	/**
	 * Returns the painting strategy for the given annotation.
	 *
	 * @param type the annotation type
	 * @return the annotation painter
	 * @since 3.0
	 */
	private Object getPaintingStrategy(final String type) {
		Object strategy= fCachedAnnotationType2PaintingStrategy.get(type);
		if (strategy != null)
			return strategy;

		strategy= fPaintingStrategyId2PaintingStrategy.get(fAnnotationType2PaintingStrategyId.get(type));
		if (strategy != null) {
			fCachedAnnotationType2PaintingStrategy.put(type, strategy);
			return strategy;
		}

		if (fAnnotationAccess instanceof IAnnotationAccessExtension) {
			IAnnotationAccessExtension ext = (IAnnotationAccessExtension) fAnnotationAccess;
			Object[] sts = ext.getSupertypes(type);
			for (int i= 0; i < sts.length; i++) {
				strategy= fPaintingStrategyId2PaintingStrategy.get(fAnnotationType2PaintingStrategyId.get(sts[i]));
				if (strategy != null) {
					fCachedAnnotationType2PaintingStrategy.put(type, strategy);
					return strategy;
				}
			}
		}

		fCachedAnnotationType2PaintingStrategy.put(type, null);
		return null;

	}

	private String getColor(final Object annotationType) {
		String color= (String)fCachedAnnotationType2Color.get(annotationType);
		if (color != null)
			return color;

		color= (String)fAnnotationType2Color.get(annotationType);
		if (color != null) {
			fCachedAnnotationType2Color.put(annotationType, color);
			return color;
		}

		if (fAnnotationAccess instanceof IAnnotationAccessExtension) {
			IAnnotationAccessExtension extension= (IAnnotationAccessExtension) fAnnotationAccess;
			Object[] superTypes= extension.getSupertypes(annotationType);
			if (superTypes != null) {
				for (int i= 0; i < superTypes.length; i++) {
					color= (String)fAnnotationType2Color.get(superTypes[i]);
					if (color != null) {
						fCachedAnnotationType2Color.put(annotationType, color);
						return color;
					}
				}
			}
		}

		return null;
	}

	private void updatePainting(AnnotationModelEvent event) {
//		disablePainting(event == null);

		catchupWithModel(event);

		if (!fInputDocumentAboutToBeChanged)
			invalidateTextPresentation();

//		enablePainting();
	}

	private void invalidateTextPresentation() {
		IRegion r= null;
		synchronized (fHighlightedDecorationsMapLock) {
		    if (fCurrentHighlightAnnotationRange != null)
		    	r= new Region(fCurrentHighlightAnnotationRange.getOffset(), fCurrentHighlightAnnotationRange.getLength());
		}
		if (r == null)
			return;

		if (fSourceViewer instanceof ITextViewerExtension2) {
//			if (DEBUG)
//				System.out.println("AP: invalidating offset: " + r.getOffset() + ", length= " + r.getLength()); //$NON-NLS-1$ //$NON-NLS-2$

			((ITextViewerExtension2)fSourceViewer).invalidateTextPresentation(r.getOffset(), r.getLength());

		} else {
			fSourceViewer.invalidateTextPresentation();
		}
	}



	@Override
	public void modelChanged(AnnotationModelEvent event) {
//		Display textWidgetDisplay;
//		try {
//			StyledText textWidget= fTextWidget;
//			if (textWidget == null || textWidget.isDisposed())
//				return;
//			textWidgetDisplay= textWidget.getDisplay();
//		} catch (SWTException ex) {
//			if (ex.code == SWT.ERROR_WIDGET_DISPOSED)
//				return;
//			throw ex;
//		}

		if (fIsSettingModel) {
			// inside the UI thread -> no need for posting
			if( Platform.isFxApplicationThread() ) {
				updatePainting(event);
			}
			else {
				/*
				 * we can throw away the changes since
				 * further update painting will happen
				 */
				return;
			}
		} else {
//			if (DEBUG && event != null && event.isWorldChange()) {
//				System.out.println("AP: WORLD CHANGED, stack trace follows:"); //$NON-NLS-1$
//				new Throwable().printStackTrace(System.out);
//			}

			// XXX: posting here is a problem for annotations that are being
			// removed and the positions of which are not updated to document
			// changes any more. If the document gets modified between
			// now and running the posted runnable, the position information
			// is not accurate any longer.
			Platform.runLater(() -> updatePainting(event));

		}
	}

	@Override
	public void modelChanged(IAnnotationModel model) {
		modelChanged(new AnnotationModelEvent(model));
	}


	public void addAnnotationType(Object annotationType, Object strategyID) {
		fAnnotationType2PaintingStrategyId.put(annotationType, strategyID);
		fCachedAnnotationType2PaintingStrategy.clear();

		if (fTextInputListener == null) {
			fTextInputListener= new ITextInputListener() {

				/*
				 * @see org.eclipse.jface.text.ITextInputListener#inputDocumentAboutToBeChanged(org.eclipse.jface.text.IDocument, org.eclipse.jface.text.IDocument)
				 */
				public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
					fInputDocumentAboutToBeChanged= true;
				}

				/*
				 * @see org.eclipse.jface.text.ITextInputListener#inputDocumentChanged(org.eclipse.jface.text.IDocument, org.eclipse.jface.text.IDocument)
				 */
				public void inputDocumentChanged(IDocument oldInput, IDocument newInput) {
					fInputDocumentAboutToBeChanged= false;
				}
			};
			fSourceViewer.addTextInputListener(fTextInputListener);
		}

	}

	public void setAnnotationTypeColor(Object annotationType, String color) {
		if (color != null)
			fAnnotationType2Color.put(annotationType, color);
		else
			fAnnotationType2Color.remove(annotationType);
		fCachedAnnotationType2Color.clear();
	}

	public void addTextStyleStrategy(Object id, ITextStyleStrategy strategy) {
		// don't permit null as null is used to signal that an annotation type is not
		// registered with a specific strategy, and that its annotation hierarchy should be searched
		if (id == null)
			throw new IllegalArgumentException();
		fPaintingStrategyId2PaintingStrategy.put(id, strategy);
		fCachedAnnotationType2PaintingStrategy.clear();
	}

}
