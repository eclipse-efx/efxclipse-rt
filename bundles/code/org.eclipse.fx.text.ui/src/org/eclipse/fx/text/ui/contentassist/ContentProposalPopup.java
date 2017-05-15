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

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.fx.core.ThreadSynchronize;
import org.eclipse.fx.text.hover.HtmlString;
import org.eclipse.fx.text.ui.ITextViewer;
import org.eclipse.fx.text.ui.hover.internal.ResizeablePopupWindow;
import org.eclipse.fx.text.ui.internal.SimpleHtmlViewer;
import org.eclipse.fx.ui.controls.styledtext.VerifyEvent;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

@SuppressWarnings("restriction")
public class ContentProposalPopup implements IContentAssistListener {
	ITextViewer viewer;
	private LazyInitReference<ResizeablePopupWindow> stage = new LazyInitReference<>();
	private ListView<ICompletionProposal> proposalList;
	private SimpleHtmlViewer htmlViewer;

	private String prefix;
	int offset;
	private Function<ContentAssistContextData, List<ICompletionProposal>> proposalComputer;

	private ContentAssistant fContentAssistant;
	private ChangeListener<Number> selectionChange;


	private ICompletionProposal chosenProposal = null;
	private final ThreadSynchronize threadSync;
	private final EventHandler<MouseEvent> mouseEvent;
	private CompletableFuture<Optional<ICompletionProposal>> future;

	public void configureWindowSize(Supplier<Point2D> windowSizeRetriever, Consumer<Point2D> windowSizePersister) {
		this.stage.init(stage -> stage.configureWindowSize(windowSizeRetriever, windowSizePersister));
	}
	public ContentProposalPopup(ThreadSynchronize threadSync, ContentAssistant assistant, ITextViewer viewer, Function<ContentAssistContextData, List<ICompletionProposal>> proposalComputer) {
		this.threadSync = threadSync;
		this.viewer = viewer;
		this.proposalComputer = proposalComputer;
		this.fContentAssistant = assistant;
		this.selectionChange = this::onSelectionChange;
		this.mouseEvent = this::onMouseEvent;
	}

	public CompletableFuture<Optional<ICompletionProposal>> displayProposals(List<ICompletionProposal> proposalList, int offset, Point2D position) {
		setup();

		if( this.stage.get().isShowing() ) {
			return CompletableFuture.completedFuture(Optional.empty());
		}

		this.future = new CompletableFuture<>();
		this.prefix = ""; //$NON-NLS-1$
		this.offset = offset;
		this.proposalList.setItems(FXCollections.observableArrayList(proposalList));
		this.proposalList.getSelectionModel().select(0);
		this.stage.get().setX(position.getX());
		this.stage.get().setY(position.getY());
		this.stage.get().requestFocus();

		this.stage.get().show(this.viewer.getTextWidget().getScene().getWindow(), position.getX(), position.getY(), this.viewer.getTextWidget().getFixedLineHeight());
		this.proposalList.requestFocus();

		this.chosenProposal = null;

		return this.future;
	}

	public void close() {
		this.stage.get().hide();
	}

	private void subscribe(Event e) {
		this.viewer.getTextWidget().caretOffsetProperty().addListener(this.selectionChange);
		this.viewer.getTextWidget().getScene().addEventFilter(MouseEvent.MOUSE_PRESSED, this.mouseEvent);
	}
	private void unsubscribe(Event e) {
		this.viewer.getTextWidget().caretOffsetProperty().removeListener(this.selectionChange);
		this.viewer.getTextWidget().getScene().removeEventFilter(MouseEvent.MOUSE_PRESSED, this.mouseEvent);
	}

	private void onMouseEvent(MouseEvent e) {
		close();
	}

	// TODO calling updateProposals is way too slow

	private void onSelectionChange(Observable x, Number oldSelection, Number newSelection) {
		this.offset = this.viewer.getTextWidget().getCaretOffset();
		updateProposals();
	}

	private void updateProposals() {
		List<ICompletionProposal> list = this.proposalComputer.apply(new ContentAssistContextData(this.offset,this.viewer.getDocument()/*,prefix*/));
		if( ! list.isEmpty() ) {
			this.proposalList.setItems(FXCollections.observableArrayList(list));
			this.proposalList.scrollTo(0);
			this.proposalList.getSelectionModel().select(0);
			this.proposalList.requestFocus();
		} else {
			this.stage.get().hide();
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
			this.viewer.getTextWidget().setCaretOffset(Math.max(0,this.viewer.getTextWidget().getCaretOffset()-1));
			break;
		case RIGHT:
			event.consume();
			this.viewer.getTextWidget().setCaretOffset(Math.min(this.viewer.getDocument().getLength()-1,this.viewer.getTextWidget().getCaretOffset()+1));
			break;
		default:
			break;
		}
	}

	private static HtmlString getHtml(ICompletionProposal proposal) {
		if (proposal != null && proposal.getHoverInfo() != null) {
			if (proposal.getHoverInfo() instanceof HtmlString) {
				return (HtmlString) proposal.getHoverInfo();
			}
			else {
				if( proposal.getHoverInfo().toString().startsWith("<html>") ) { //$NON-NLS-1$
					return new HtmlString(proposal.getHoverInfo().toString());
				} else {
					return new HtmlString("<html><body><pre>"+proposal.getHoverInfo()+"</pre></body></html>"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
		return new HtmlString("<html></html>"); //$NON-NLS-1$
	}

	private void setup() {
		if( !this.stage.isInitialized() ) {

			this.htmlViewer = new SimpleHtmlViewer();
			this.htmlViewer.setPrefWidth(300);

			final StackPane docArea = new StackPane();
			docArea.getStyleClass().add("content-proposal-doc"); //$NON-NLS-1$
			docArea.getChildren().add(this.htmlViewer);

			this.stage.setFactory(() -> {
				BorderPane p = new BorderPane();
				p.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
				ResizeablePopupWindow s = new ResizeablePopupWindow(p);
				s.setAutoFix(false);
				s.getScene().addEventFilter(KeyEvent.KEY_PRESSED, this::handleKeyPressed);
//				s.getScene().getStylesheets().addAll(this.viewer.getTextWidget().getScene().getStylesheets());

				p.getStyleClass().add("content-proposal-container"); //$NON-NLS-1$


				s.focusedProperty().addListener((o) -> {
					if( this.stage != null && ! s.isFocused() ) {
						Platform.runLater(s::hide);
					}
				});
				s.setOnShowing(this::subscribe);
				s.addEventHandler(WindowEvent.WINDOW_HIDDEN,this::unsubscribe);

//				// Fix CSS warnings
//				s.setOnHidden((o) -> {
//					this.stage = null;
//				});

				s.showingProperty().addListener((x, o, n) -> {
					if (!n) {
						this.future.complete(Optional.ofNullable(this.chosenProposal));
					}
				});

				SplitPane splitty = new SplitPane(this.proposalList, docArea);
				splitty.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
				SplitPane.setResizableWithParent(this.proposalList, Boolean.FALSE);
				p.setCenter(splitty);

				splitty.prefWidthProperty().bind(p.widthProperty());
				return s;
			});


			this.proposalList = new ListView<>();
			this.proposalList.setMinWidth(300);
			this.proposalList.getStyleClass().add("content-proposal-list"); //$NON-NLS-1$
			this.proposalList.setOnMouseClicked(this::handleMouseClicked);
			this.proposalList.getSelectionModel().selectedItemProperty().addListener((ChangeListener<ICompletionProposal>) (observable, oldValue, newValue) -> {
				this.htmlViewer.setContent(getHtml(newValue));
			});

			this.proposalList.setCellFactory(CompletionCell::new);
		}
	}

	@Override
	public boolean verifyKey(VerifyEvent event) {

		return true;
	}

	static class CompletionCell extends ListCell<ICompletionProposal> {
		public CompletionCell(ListView<ICompletionProposal> v) {
			// nothing to do
		}

		@Override
		protected void updateItem(ICompletionProposal item, boolean empty) {
			super.updateItem(item, empty);
			if( item != null && ! empty ) {
				HBox box = new HBox();
				box.setAlignment(Pos.CENTER_LEFT);
				Node graphic = item.getGraphic();
				Node content = item.getContentNode();
				if( graphic != null ) {
					box.getChildren().add(graphic);
				}
				box.getChildren().add(content);
				HBox.setHgrow(content, Priority.ALWAYS);
				setGraphic(box);
			} else {
				setGraphic(null);
			}
		}
	}
}
