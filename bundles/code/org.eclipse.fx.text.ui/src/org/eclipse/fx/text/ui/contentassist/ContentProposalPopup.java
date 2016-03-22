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
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.text.ui.ITextViewer;
import org.eclipse.fx.ui.controls.list.SimpleListCell;
import org.eclipse.fx.ui.controls.styledtext.StyledTextContent.TextChangeListener;
import org.eclipse.fx.ui.controls.styledtext.TextChangedEvent;
import org.eclipse.fx.ui.controls.styledtext.TextChangingEvent;
import org.eclipse.fx.ui.controls.styledtext.VerifyEvent;

import com.sun.javafx.tk.Toolkit;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.PopupWindow;

@SuppressWarnings("restriction")
public class ContentProposalPopup implements IContentAssistListener {
	ITextViewer viewer;
	private PopupWindow stage;
	private ListView<ICompletionProposal> proposalList;
	private WebView documentationView;
	private String prefix;
	int offset;
	private Function<ContentAssistContextData, List<ICompletionProposal>> proposalComputer;

	private ContentAssistant fContentAssistant;
	private ChangeListener<Number> selectionChange;


	private ICompletionProposal chosenProposal = null;
	private final ThreadSynchronize threadSync;

	public ContentProposalPopup(ThreadSynchronize threadSync, ContentAssistant assistant, ITextViewer viewer, Function<ContentAssistContextData, List<ICompletionProposal>> proposalComputer) {
		this.threadSync = threadSync;
		this.viewer = viewer;
		this.proposalComputer = proposalComputer;
		this.fContentAssistant = assistant;
		this.selectionChange = this::onSelectionChange;
	}

	public Optional<ICompletionProposal> displayProposals(List<ICompletionProposal> proposalList, int offset, Point2D position) {
		setup();
		this.prefix = ""; //$NON-NLS-1$
		this.offset = offset;
		this.proposalList.setItems(FXCollections.observableArrayList(proposalList));
		this.proposalList.getSelectionModel().select(0);
		this.stage.setX(position.getX());
		this.stage.setY(position.getY());
		this.stage.setWidth(300);
		this.stage.setHeight(200);
		this.stage.requestFocus();

		this.stage.setOnShowing(this::subscribe);
		this.stage.setOnHidden(this::unsubscribe);

		this.stage.show(this.viewer.getTextWidget().getScene().getWindow());


		this.chosenProposal = null;
		//FIXME We need to get rid if this calls!!!! by using UISynchronize#waitUntil()
		// but we can get a dep on UISynchronize
		Toolkit.getToolkit().checkFxUserThread();
		Toolkit.getToolkit().enterNestedEventLoop(this);

		return Optional.ofNullable(this.chosenProposal);
	}

	public void close() {
		this.stage.hide();
	}

	private void subscribe(Event e) {
		this.viewer.getTextWidget().getContent().addTextChangeListener(this.textChangeListener);
		this.viewer.getTextWidget().caretOffsetProperty().addListener(this.selectionChange);
	}
	private void unsubscribe(Event e) {
		this.viewer.getTextWidget().getContent().removeTextChangeListener(this.textChangeListener);
		this.viewer.getTextWidget().caretOffsetProperty().removeListener(this.selectionChange);
	}

	// TODO calling updateProposals is way too slow

	private void onSelectionChange(Observable x, Number oldSelection, Number newSelection) {
		this.offset = this.viewer.getTextWidget().getCaretOffset();
		updateProposals();
	}

	private TextChangeListener textChangeListener = new TextChangeListener() {
		@Override
		public void textSet(TextChangedEvent event) {
			ContentProposalPopup.this.offset = ContentProposalPopup.this.viewer.getTextWidget().getCaretOffset();
			updateProposals();
		}

		@Override
		public void textChanging(TextChangingEvent event) {
			//nothing to do
		}

		@Override
		public void textChanged(TextChangedEvent event) {
			ContentProposalPopup.this.offset = ContentProposalPopup.this.viewer.getTextWidget().getCaretOffset();
			updateProposals();
		}
	};

	private void updateProposals() {
		List<ICompletionProposal> list = this.proposalComputer.apply(new ContentAssistContextData(this.offset,this.viewer.getDocument()/*,prefix*/));
		if( ! list.isEmpty() ) {
			this.proposalList.setItems(FXCollections.observableArrayList(list));
			this.proposalList.scrollTo(0);
			this.proposalList.getSelectionModel().select(0);
			this.proposalList.requestFocus();
		} else {
			this.stage.hide();
		}
	}

	private void cancelProposal() {
		this.chosenProposal = null;
		close();
	}

	private void applySelectedProposal() {
		ICompletionProposal selectedItem = this.proposalList.getSelectionModel().getSelectedItem();

		this.chosenProposal = selectedItem;
		close();
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
			break;
		case LEFT:
			event.consume();
			updateProposals();
			break;
		case RIGHT:
			event.consume();
			updateProposals();
			break;
		default:
			break;
		}
	}

	private static String getDocumentation(ICompletionProposal proposal) {
		if (proposal != null) {
			return "<html><body><pre>"+proposal.getHoverInfo()+"</pre></body></html>"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return "<html></html>"; //$NON-NLS-1$
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
					System.err.println("HIDE THAT GUY");
					Platform.runLater(this.stage::hide);
				}
			});
			// Fix CSS warnings
			this.stage.setOnHidden((o) -> {
				this.stage = null;
			});

			this.stage.showingProperty().addListener((x, o, n) -> {
				if (!n) {
					Toolkit.getToolkit().exitNestedEventLoop(this, null);
				}
			});
		}
	}

	@Override
	public boolean verifyKey(VerifyEvent event) {

		System.err.println("CONTENT PROPOSAL POPUP: VerifyEvent " + event);

		return true;
	}

}
