package org.eclipse.jface.text.contentassist;

import static com.sun.javafx.PlatformUtil.isMac;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.eclipse.fx.ui.controls.list.SimpleListCell;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;

public class ContentProposalPopup {
	private ITextViewer viewer;
	private Stage stage;
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
		this.stage.show();
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
			try {
				this.prefix = prefix+character;
				viewer.getDocument().replace(offset, 0, character);
				this.offset += event.getCharacter().length();
				viewer.getTextWidget().setCaretOffset(offset);
				updateProposals();
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void updateProposals() {
		List<ICompletionProposal> list = proposalComputer.apply(offset);
		if( ! list.isEmpty() ) {
			proposalList.setItems(FXCollections.observableArrayList(list));
			proposalList.scrollTo(0);
			proposalList.getSelectionModel().select(0);
		} else {
			stage.close();
		}
	}

	private void handleKeyPressed(KeyEvent event) {
		if( event.getCode() == KeyCode.ESCAPE ) {
			event.consume();
			stage.close();
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
			stage.close();
		}
	}

	private void setup() {
		if( stage == null ) {
			stage = new Stage(StageStyle.TRANSPARENT);
			stage.initOwner(viewer.getTextWidget().getScene().getWindow());
			BorderPane p = new BorderPane();
			Scene s = new Scene(p,300,200);
			s.addEventFilter(KeyEvent.KEY_TYPED, this::handleKeyTyped);
			s.addEventFilter(KeyEvent.KEY_PRESSED, this::handleKeyPressed);
			s.getStylesheets().addAll(viewer.getTextWidget().getScene().getStylesheets());
			proposalList = new ListView<>();
			proposalList.setOnMouseClicked((e) -> {
				if(e.getClickCount() == 1) {
					applySelection();
				}
			});

			Function<ICompletionProposal, CharSequence> label = (c) -> c.getLabel();
			Function<ICompletionProposal, List<String>> css = (c) -> c.getStyles();

			proposalList.setCellFactory((v) -> new SimpleListCell<ICompletionProposal>(label,css));
			p.setCenter(proposalList);
			stage.setScene(s);
			stage.focusedProperty().addListener((o) -> {
				if( ! stage.isFocused() ) {
					Platform.runLater(stage::close);
				}
			});
			// Fix CSS warnings
			stage.setOnHidden((o) -> {
				stage = null;
			});
		}
	}
}
