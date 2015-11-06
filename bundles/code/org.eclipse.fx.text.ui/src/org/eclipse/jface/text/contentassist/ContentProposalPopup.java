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
package org.eclipse.jface.text.contentassist;

import static com.sun.javafx.PlatformUtil.isMac;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.PopupControl;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.eclipse.fx.ui.controls.list.SimpleListCell;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;

public class ContentProposalPopup {
	private ITextViewer viewer;
	private PopupWindow stage;
	private ListView<ICompletionProposal> proposalList;
	private String prefix;
	private int offset;
	private Function<Integer, List<ICompletionProposal>> proposalComputer;

	public ContentProposalPopup(ITextViewer viewer, Function<Integer, List<ICompletionProposal>> proposalComputer) {
		this.viewer = viewer;
		this.proposalComputer = proposalComputer;
	}

	public void displayProposals(List<ICompletionProposal> proposalList, int offset, Point2D position) {
		setup();
		this.prefix = "";
		this.offset = offset;
		this.proposalList.setItems(FXCollections.observableArrayList(proposalList));
		this.proposalList.getSelectionModel().select(0);
		this.stage.setX(position.getX());
		this.stage.setY(position.getY());
		this.stage.setWidth(300);
		this.stage.setHeight(200);
		this.stage.show(viewer.getTextWidget().getScene().getWindow());
		this.stage.requestFocus();
	}

	private void handleKeyTyped(KeyEvent event) {
		if( event.getCharacter().length() == 0 ) {
			return;
		}

		String character = event.getCharacter();
		if( character.length() == 0 ) {
			return;
		}

		if (event.isControlDown() || event.isAltDown() || (isMac() && event.isMetaDown())) {
			if (!((event.isControlDown() || isMac()) && event.isAltDown())) {
				return;
			}
		}

		if (character.charAt(0) > 0x1F
	            && character.charAt(0) != 0x7F ) {
//			try {
				this.prefix = this.prefix+character;
//				viewer.getDocument().replace(offset, 0, character);
				this.offset += event.getCharacter().length();
//				viewer.getTextWidget().setCaretOffset(offset);
				updateProposals();
//			} catch (BadLocationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

	private void updateProposals() {
		List<ICompletionProposal> list = proposalComputer.apply(offset);
		if( ! list.isEmpty() ) {
			proposalList.setItems(FXCollections.observableArrayList(list));
			proposalList.scrollTo(0);
			proposalList.getSelectionModel().select(0);
		} else {
			stage.hide();
		}
	}

	private void handleKeyPressed(KeyEvent event) {
		if( event.getCode() == KeyCode.ESCAPE ) {
			event.consume();
			stage.hide();
		} else if( event.getCode() == KeyCode.BACK_SPACE ) {
			event.consume();
			this.offset -= 1;
			try {
				this.viewer.getDocument().replace(offset, 1, "");
				viewer.getTextWidget().setCaretOffset(offset);
				updateProposals();
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if( event.getCode() == KeyCode.ENTER ) {
			event.consume();
			applySelection();
		} else if( event.getCode() == KeyCode.LEFT ) {
			event.consume();
			this.offset -= 1;
			this.offset = Math.max(0, this.offset);
			viewer.getTextWidget().setCaretOffset(offset);
			updateProposals();
		} else if( event.getCode() == KeyCode.RIGHT ) {
			event.consume();
			this.offset += 1;
			this.offset = Math.min(viewer.getDocument().getLength()-1, this.offset);
			viewer.getTextWidget().setCaretOffset(offset);
			updateProposals();
		}
	}

	private void applySelection() {
		ICompletionProposal selectedItem = proposalList.getSelectionModel().getSelectedItem();
		if( selectedItem != null ) {
			IDocument document = viewer.getDocument();
			selectedItem.apply(document);
			viewer.getTextWidget().setSelection(selectedItem.getSelection(document));
			stage.hide();
		}
	}

	private void setup() {
		if( stage == null ) {
			stage = new PopupWindow() {

			};
			stage.setAutoFix(false);
			stage.setWidth(300);
			stage.setHeight(200);
			BorderPane p = new BorderPane();
			p.setPrefHeight(200);
			p.setPrefWidth(400);
			stage.getScene().addEventFilter(KeyEvent.KEY_TYPED, this::handleKeyTyped);
			stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, this::handleKeyPressed);
			stage.getScene().getStylesheets().addAll(viewer.getTextWidget().getScene().getStylesheets());
			proposalList = new ListView<>();
			proposalList.setOnMouseClicked((e) -> {
				if(e.getClickCount() == 1) {
					applySelection();
				}
			});

			Function<ICompletionProposal, CharSequence> label = (c) -> c.getLabel();
			Function<ICompletionProposal, Node> graphic = (c) -> c.getGraphic();
			Function<ICompletionProposal, List<String>> css = (c) -> Collections.emptyList();


			proposalList.setCellFactory((v) -> new SimpleListCell<ICompletionProposal>(label,graphic,css));
			p.setCenter(proposalList);
			stage.getScene().setRoot(p);
			stage.focusedProperty().addListener((o) -> {
				if( stage != null && ! stage.isFocused() ) {
					Platform.runLater(stage::hide);
				}
			});
			// Fix CSS warnings
			stage.setOnHidden((o) -> {
				stage = null;
			});
		}
	}
}
