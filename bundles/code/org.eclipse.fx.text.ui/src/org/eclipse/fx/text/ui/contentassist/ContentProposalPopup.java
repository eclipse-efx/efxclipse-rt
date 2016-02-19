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
package org.eclipse.fx.text.ui.contentassist;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.function.Function;

import org.eclipse.fx.core.Util;
import org.eclipse.fx.text.ui.ITextViewer;
import org.eclipse.fx.ui.controls.list.SimpleListCell;
import org.eclipse.fx.ui.controls.styledtext.StyledTextContent.TextChangeListener;
import org.eclipse.fx.ui.controls.styledtext.TextChangedEvent;
import org.eclipse.fx.ui.controls.styledtext.TextChangingEvent;
import org.eclipse.fx.ui.controls.styledtext.VerifyEvent;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;

import com.sun.javafx.collections.ImmutableObservableList;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.PopupWindow;

public class ContentProposalPopup implements IContentAssistListener {
	private ITextViewer viewer;
	private PopupWindow stage;
	private ListView<ICompletionProposal> proposalList;
	private WebView documentationView;
	private String prefix;
	private int offset;
	private Function<ContentAssistContextData, List<ICompletionProposal>> proposalComputer;

	private ContentAssistant fContentAssistant;

	public ContentProposalPopup(ContentAssistant assistant, ITextViewer viewer, Function<ContentAssistContextData, List<ICompletionProposal>> proposalComputer) {
		this.viewer = viewer;
		this.proposalComputer = proposalComputer;
		this.fContentAssistant = assistant;
	}

	public void displayProposals(List<ICompletionProposal> proposalList, int offset, Point2D position) {
		setup();
		this.prefix = ""; //$NON-NLS-1$
		this.offset = offset;
		this.proposalList.setItems(FXCollections.observableArrayList(proposalList));
		this.proposalList.getSelectionModel().select(0);
		this.stage.setX(position.getX());
		this.stage.setY(position.getY());
		this.stage.setWidth(300);
		this.stage.setHeight(200);
		this.stage.show(this.viewer.getTextWidget().getScene().getWindow());
		this.stage.requestFocus();

		this.stage.setOnShowing(this::subscribe);
		this.stage.setOnHidden(this::unsubscribe);
	}

	private void subscribe(Event e) {
		this.viewer.getTextWidget().getContent().addTextChangeListener(this.textChangeListener);
		this.viewer.getTextWidget().selectionProperty().addListener(this::onSelectionChange);
	}
	private void unsubscribe(Event e) {
		this.viewer.getTextWidget().getContent().removeTextChangeListener(this.textChangeListener);
		this.viewer.getTextWidget().selectionProperty().removeListener(this::onSelectionChange);
	}

	// TODO calling updateProposals is way too slow

	private void onSelectionChange(Observable x) {
		System.err.println("update trigger selection change");
		updateProposals();
	}

	private TextChangeListener textChangeListener = new TextChangeListener() {
		@Override
		public void textSet(TextChangedEvent event) {
			System.err.println("update trigger textSet");
			updateProposals();
		}

		@Override
		public void textChanging(TextChangingEvent event) {
		}

		@Override
		public void textChanged(TextChangedEvent event) {
			System.err.println("update trigger textChanged");
			updateProposals();
		}
	};


	private void handleKeyTyped(KeyEvent event) {
//		Event.fireEvent(this.viewer.getTextWidget(), event);
		return;
//
//
//
//		if( event.getCharacter().length() == 0 ) {
//			return;
//		}
//
//		String character = event.getCharacter();
//		if( character.length() == 0 ) {
//			return;
//		}
//
//		if (event.isControlDown() || event.isAltDown() || (Util.isMacOS() && event.isMetaDown())) {
//			if (!((event.isControlDown() || Util.isMacOS()) && event.isAltDown())) {
//				return;
//			}
//		}
//
//		if (character.charAt(0) > 0x1F
//	            && character.charAt(0) != 0x7F ) {
////			try {
//				this.prefix = this.prefix+character;
////				viewer.getDocument().replace(offset, 0, character);
//				this.offset += event.getCharacter().length();
////				viewer.getTextWidget().setCaretOffset(offset);
//				updateProposals();
////			} catch (BadLocationException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//		}
	}

	private void updateProposals() {
		List<ICompletionProposal> list = this.proposalComputer.apply(new ContentAssistContextData(this.offset,this.viewer.getDocument()/*,prefix*/));
		if( ! list.isEmpty() ) {
			this.proposalList.setItems(FXCollections.observableArrayList(list));
			this.proposalList.scrollTo(0);
			this.proposalList.getSelectionModel().select(0);
		} else {
			this.stage.hide();
		}
	}

	private void cancelProposal() {
		this.stage.hide();
	}

	private void applySelectedProposal() {
		ICompletionProposal selectedItem = this.proposalList.getSelectionModel().getSelectedItem();
		if( selectedItem != null ) {
			IDocument document = this.viewer.getDocument();
			selectedItem.apply(document);

			this.viewer.getTextWidget().setSelection(selectedItem.getSelection(document));
			this.stage.hide();

			this.fContentAssistant.showContextInformation(selectedItem.getContextInformation(), offset);
		}
	}

	private void handleMouseClicked(MouseEvent event) {
		if(event.isStillSincePress() && event.getClickCount() == 2) {
			applySelectedProposal();
		}
	}

	private void handleKeyPressed(KeyEvent event) {
		switch (event.getCode()) {
		case ESCAPE:
			event.consume();
			cancelProposal();
			break;
		case ENTER:
			event.consume();
			applySelectedProposal();
		}


//		if( event.getCode() == KeyCode.ESCAPE ) {
//			event.consume();
//			this.stage.hide();
//		} else if( event.getCode() == KeyCode.BACK_SPACE ) {
//			event.consume();
//			this.offset -= 1;
//			try {
//				this.viewer.getDocument().replace(this.offset, 1, ""); //$NON-NLS-1$
//				this.viewer.getTextWidget().setCaretOffset(this.offset);
//				updateProposals();
//			} catch (BadLocationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else if( event.getCode() == KeyCode.ENTER ) {
//			event.consume();
//			applySelection();
//		} else if( event.getCode() == KeyCode.LEFT ) {
//			event.consume();
//			this.offset -= 1;
//			this.offset = Math.max(0, this.offset);
//			this.viewer.getTextWidget().setCaretOffset(this.offset);
//			updateProposals();
//		} else if( event.getCode() == KeyCode.RIGHT ) {
//			event.consume();
//			this.offset += 1;
//			this.offset = Math.min(this.viewer.getDocument().getLength()-1, this.offset);
//			this.viewer.getTextWidget().setCaretOffset(this.offset);
//			updateProposals();
//		}
	}

	private String getDocumentation(ICompletionProposal proposal) {
		if (proposal != null) {
			return "<html><body><pre>"+proposal.getHoverInfo()+"</pre></body></html>";
		}
		return "<html></html>";
	}

	private void setup() {
		if( this.stage == null ) {
			this.stage = new PopupWindow() {
				// empty by design
			};
			this.stage.setAutoFix(false);
			this.stage.setWidth(300);
			this.stage.setHeight(200);
			BorderPane p = new BorderPane();
			p.setPrefHeight(200);
			p.setPrefWidth(600);
			this.stage.getScene().addEventFilter(KeyEvent.KEY_TYPED, this::handleKeyTyped);
			this.stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, this::handleKeyPressed);

			this.stage.getScene().getStylesheets().addAll(this.viewer.getTextWidget().getScene().getStylesheets());
			this.proposalList = new ListView<>();
			this.proposalList.setMinWidth(300);
			this.proposalList.getStyleClass().add("content-proposal-list"); //$NON-NLS-1$
			this.proposalList.setOnMouseClicked(this::handleMouseClicked);

			this.documentationView = new WebView();
			this.documentationView.setPrefWidth(300);
			this.documentationView.getStyleClass().add("content-proposal-doc"); //$NON-NLS-1$

			this.proposalList.getSelectionModel().selectedItemProperty().addListener((ChangeListener<ICompletionProposal>) (observable, oldValue, newValue) -> {
				this.documentationView.getEngine().loadContent(getDocumentation(newValue));
			});

			Function<ICompletionProposal, CharSequence> label = (c) -> c.getLabel();
			Function<ICompletionProposal, Node> graphic = (c) -> c.getGraphic();
			Function<ICompletionProposal, List<String>> css = (c) -> Collections.emptyList();


			this.proposalList.setCellFactory((v) -> new SimpleListCell<ICompletionProposal>(label,graphic,css));
			p.setCenter(this.proposalList);
			p.setRight(this.documentationView);
			this.stage.getScene().setRoot(p);
			this.stage.focusedProperty().addListener((o) -> {
				if( this.stage != null && ! this.stage.isFocused() ) {
					Platform.runLater(this.stage::hide);
				}
			});
			// Fix CSS warnings
			this.stage.setOnHidden((o) -> {
				this.stage = null;
			});
		}
	}

	@Override
	public boolean verifyKey(VerifyEvent event) {

		System.err.println("CONTENT PROPOSAL POPUP: VerifyEvent " + event);

		return true;
	}

}
