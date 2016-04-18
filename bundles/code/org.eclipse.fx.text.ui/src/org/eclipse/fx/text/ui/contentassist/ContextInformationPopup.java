/*******************************************************************************
 * Copyright (c) 2000, 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.ui.contentassist;

import java.util.Iterator;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

import org.eclipse.fx.text.ui.ITextViewer;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.LineLocation;
import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.styledtext.StyledString;
import org.eclipse.fx.ui.controls.styledtext.VerifyEvent;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;


/**
 * This class is used to present context information to the user.
 * If multiple contexts are valid at the current cursor location,
 * a list is presented from which the user may choose one context.
 * Once the user makes their choice, or if there was only a single
 * possible context, the context information is shown in a tool tip like popup. <p>
 * If the tool tip is visible and the user wants to see context information of
 * a context embedded into the one for which context information is displayed,
 * context information for the embedded context is shown. As soon as the
 * cursor leaves the embedded context area, the context information for
 * the embedding context is shown again.
 *
 * @see IContextInformation
 * @see IContextInformationValidator
 */
class ContextInformationPopup implements IContentAssistListener {


	/**
	 * Represents the state necessary for embedding contexts.
	 *
	 * @since 2.0
	 */
	static class ContextFrame {

		final int fBeginOffset;
		final int fOffset;
		final int fVisibleOffset;
		final IContextInformation fInformation;
		final IContextInformationValidator fValidator;
		final IContextInformationPresenter fPresenter;

		/*
		 * @since 3.1
		 */
		public ContextFrame(IContextInformation information, int beginOffset, int offset, int visibleOffset, IContextInformationValidator validator, IContextInformationPresenter presenter) {
			this.fInformation = information;
			this.fBeginOffset = beginOffset;
			this.fOffset = offset;
			this.fVisibleOffset = visibleOffset;
			this.fValidator = validator;
			this.fPresenter = presenter;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof ContextFrame) {
				ContextFrame frame= (ContextFrame) obj;
				return this.fInformation.equals(frame.fInformation) && this.fBeginOffset == frame.fBeginOffset;
			}
			return super.equals(obj);
		}

		@Override
		public int hashCode() {
			return (this.fInformation.hashCode() << 16) | this.fBeginOffset;
		}
	}

	private ITextViewer fViewer;
	private ContentAssistant fContentAssistant;

	private PopupWindow fContextSelectorStage;
	private IContextInformation[] fContextSelectorInput;
	private String fLineDelimiter= null;

	private PopupWindow fContextInfoPopup;
	private BorderPane fRoot;
	private Label fContent;


	private Stack<ContextFrame> fContextFrameStack= new Stack<>();

	/**
	 * The last removed context frame is remembered in order to not re-query the
	 * user about which context should be used.
	 *
	 * @since 3.0
	 */
	private ContextFrame fLastContext= null;

	/**
	 * Creates a new context information popup.
	 *
	 * @param contentAssistant the content assist for computing the context information
	 * @param viewer the viewer on top of which the context information is shown
	 */
	public ContextInformationPopup(ContentAssistant contentAssistant, ITextViewer viewer) {
		this.fContentAssistant= contentAssistant;
		this.fViewer= viewer;

		this.fContextInfoPopup = new PopupWindow() {
		};
		this.fContextInfoPopup.setAutoFix(false);
		this.fContextInfoPopup.setAutoHide(true);
		viewer.getTextWidget().sceneProperty().addListener( e -> {
			if( viewer.getTextWidget().getScene() != null ) {
				this.fContextInfoPopup.getScene().getStylesheets().setAll(viewer.getTextWidget().getScene().getStylesheets());
			}
		});
		if( viewer.getTextWidget().getScene() != null ) {
			this.fContextInfoPopup.getScene().getStylesheets().setAll(viewer.getTextWidget().getScene().getStylesheets());
		}
		this.fRoot = new BorderPane();
		this.fRoot.getStyleClass().add("styled-text-hover");
		this.fContent = new Label();
		this.fRoot.setCenter(fContent);
		this.fContent.getStyleClass().add("context-info");
		fContextInfoPopup.getScene().setRoot(fRoot);
	}

	/**
	 * Shows all possible contexts for the given cursor position of the viewer.
	 *
	 * @param autoActivated <code>true</code>  if auto activated
	 * @return  a potential error message or <code>null</code> in case of no error
	 */
	public String showContextProposals(final boolean autoActivated) {
		return "TODO";
	}

	/**
	 * Displays the given context information for the given offset.
	 *
	 * @param info the context information
	 * @param offset the offset
	 * @since 2.0
	 */
	public void showContextInformation(final IContextInformation info, final int offset) {
			CharSequence infoText = info.getInformationDisplayString();
			if (info != null && info != null && infoText.length() > 0) {
				if( infoText instanceof StyledString ) {
					fContent.setText("");
					fContent.setGraphic(Util.toNode((StyledString) infoText));
				} else {
					fContent.setText(infoText.toString());
					fContent.setGraphic(null);
				}
				Point2D locationAtOffset = fViewer.getTextWidget().getLocationAtOffset(offset, LineLocation.ABOVE);
				locationAtOffset = fViewer.getTextWidget().localToScreen(locationAtOffset);
				if (locationAtOffset != null) {
					double y = locationAtOffset.getY() - fContextInfoPopup.getHeight();
					fContextInfoPopup.show(fViewer.getTextWidget().getScene().getWindow(), locationAtOffset.getX(), y);
				}
			}
			else {
				fContextInfoPopup.hide();
			}
	}

	@Override
	public boolean verifyKey(VerifyEvent event) {

		return false;
	}

}
