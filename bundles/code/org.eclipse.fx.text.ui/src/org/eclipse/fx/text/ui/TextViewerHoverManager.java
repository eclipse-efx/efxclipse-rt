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
package org.eclipse.fx.text.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.fx.text.hover.DocumentHoverProvider;
import org.eclipse.fx.text.hover.HoverInfo;
import org.eclipse.fx.text.ui.hover.HoverPresenter;
import org.eclipse.fx.text.ui.hover.internal.DefaultHoverPresenter;
import org.eclipse.fx.text.ui.hover.internal.DefaultHoverWindowPresenter;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.events.HoverTarget;
import org.eclipse.fx.ui.controls.styledtext.events.TextHoverEvent;
import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.jface.text.IDocument;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.PopupWindow;

public class TextViewerHoverManager {

	List<DocumentHoverProvider> providers = new ArrayList<>();

	DefaultHoverWindowPresenter windowPresenter;
	List<HoverPresenter> hoverPresenters = new ArrayList<>();

	private final TextViewer textViewer;
	private final PopupWindow popup;
	private final BorderPane root;

	public TextViewerHoverManager(TextViewer textViewer) {

		this.windowPresenter = new DefaultHoverWindowPresenter(textViewer.getTextWidget());
		this.hoverPresenters.add(new DefaultHoverPresenter());
		this.windowPresenter.setHoverPresenter(this.hoverPresenters);

		this.textViewer = textViewer;
		this.popup = new PopupWindow() {
		};
		this.popup.setAutoFix(false);
		this.popup.setAutoHide(false);
		this.textViewer.getTextWidget().sceneProperty().addListener( e -> {
			if( textViewer.getTextWidget().getScene() != null ) {
				popup.getScene().getStylesheets().setAll(textViewer.getTextWidget().getScene().getStylesheets());
			}

		});
		root = new BorderPane();
		root.getStyleClass().add("styled-text-hover");
		popup.getScene().setRoot(root);
	}

	public TextViewer getTextViewer() {
		return textViewer;
	}

	public PopupWindow getPopup() {
		return popup;
	}

	public BorderPane getRoot() {
		return root;
	}



	public void install(StyledTextArea styledTextArea) {
		styledTextArea.addEventHandler(TextHoverEvent.HOVER, e -> {
			if( e.getOffset() > 0 ) {
				final IDocument document = getTextViewer().getDocument();
				final int offset = e.getOffset();


				List<HoverInfo> hovers = new ArrayList<>();

				hovers.addAll(getTextViewer().getHoverInfo(e.getOffset()));

				hovers.addAll(this.providers.stream().flatMap(p->p.getHoverInfo(document, offset).stream()).collect(Collectors.toSet()));

				Set<HoverTarget> annotationTargets = e.getHoverTargets().stream()
						.filter(t->t.model instanceof Annotation)
						.collect(Collectors.toSet());

				Set<HoverInfo> annotationHovers = e.getHoverTargets().stream()
					.filter(t->t.model instanceof Annotation)
					.map(t->(Annotation) t.model)
					.filter(a->a.getModel() instanceof org.eclipse.jface.text.source.Annotation)
					.map(a->(org.eclipse.jface.text.source.Annotation)a.getModel())
					.flatMap(a->getTextViewer().getHoverInfo(a).stream())
					.collect(Collectors.toSet());

				hovers.addAll(annotationHovers);



//				if( e.getOffset() > 0 ) {
//				final ITextHover hover= getTextViewer().getTextHover(e.getOffset(), /*getHoverEventStateMask()*/ ITextViewerExtension2.DEFAULT_HOVER_STATE_MASK);
//				if( hover != null ) {
//					String text = hover.getHoverInfo(getTextViewer(), hover.getHoverRegion(getTextViewer(), e.getOffset()));
//					if( text != null && ! text.isEmpty() ) {
//						Label value = new Label(text);
//						value.getStyleClass().add("styled-text-hover-text");
//						getRoot().setCenter(value);
//						Point2D locationAtOffset = getTextViewer().getTextWidget().getLocationAtOffset(e.getOffsetTokenStart());
//						double x = e.getScreenX();
//						if( locationAtOffset != null ) {
//							x = getTextViewer().getTextWidget().localToScreen(locationAtOffset.getX(),0).getX();
//						}
//						getPopup().show(getTextViewer().getTextWidget().getScene().getWindow(), x, e.getScreenY()+5);
//					} else {
//						getPopup().hide();
//					}
//				} else {
//					getPopup().hide();
//				}
//			} else {
//				getPopup().hide();
//			}

				if (!hovers.isEmpty()) {
					// TODO on multiple hovers we need to determine which screenAnchor to use°!!
					Point2D anchor = e.getHoverTargets().get(0).screenAnchor;
					Bounds bounds = e.getHoverTargets().get(0).screenBounds;
					if (!annotationHovers.isEmpty()) {
						HoverTarget next = annotationTargets.iterator().next();
						anchor = next.screenAnchor;
						bounds = next.screenBounds;
					}

					this.windowPresenter.show(anchor, bounds, hovers);
				}
				else {
					this.windowPresenter.hide();
				}
			}
			else {
				this.windowPresenter.hide();
			}

			styledTextArea.addEventHandler(MouseEvent.MOUSE_PRESSED, event-> {
				this.windowPresenter.hide();
			});


//			if( e.getOffset() > 0 ) {
//				final ITextHover hover= getTextViewer().getTextHover(e.getOffset(), /*getHoverEventStateMask()*/ ITextViewerExtension2.DEFAULT_HOVER_STATE_MASK);
//				if( hover != null ) {
//					String text = hover.getHoverInfo(getTextViewer(), hover.getHoverRegion(getTextViewer(), e.getOffset()));
//					if( text != null && ! text.isEmpty() ) {
//						Label value = new Label(text);
//						value.getStyleClass().add("styled-text-hover-text");
//						getRoot().setCenter(value);
//						Point2D locationAtOffset = getTextViewer().getTextWidget().getLocationAtOffset(e.getOffsetTokenStart());
//						double x = e.getScreenX();
//						if( locationAtOffset != null ) {
//							x = getTextViewer().getTextWidget().localToScreen(locationAtOffset.getX(),0).getX();
//						}
//						getPopup().show(getTextViewer().getTextWidget().getScene().getWindow(), x, e.getScreenY()+5);
//					} else {
//						getPopup().hide();
//					}
//				} else {
//					getPopup().hide();
//				}
//			} else {
//				getPopup().hide();
//			}
		});
	}
}
