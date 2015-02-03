/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.skin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Skin;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.util.Callback;

import org.eclipse.fx.ui.controls.styledtext.StyleRange;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.StyledTextLine;
import org.eclipse.fx.ui.controls.styledtext.StyledTextLayoutContainer;
import org.eclipse.fx.ui.controls.styledtext.StyledTextNode;
import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.fx.ui.controls.styledtext.behavior.StyledTextBehavior;
import org.eclipse.jdt.annotation.NonNull;

import com.sun.javafx.scene.control.skin.BehaviorSkinBase;
import com.sun.javafx.scene.control.skin.ListViewSkin;
import com.sun.javafx.scene.control.skin.VirtualFlow;

/**
 * Styled text skin
 */
@SuppressWarnings("restriction")
public class StyledTextSkin extends BehaviorSkinBase<StyledTextArea, StyledTextBehavior> {
	ListView<Line> contentView;
	LineRuler lineRuler;

	ObservableList<Line> lineList = FXCollections.observableArrayList();

	// private Set<LineCell> visibleCells = new HashSet<>();
	Map<LineCell, LineInfo> lineInfoMap = new HashMap<>();

	HBox rootContainer;

	/**
	 * Create a new skin
	 *
	 * @param styledText
	 *            the control
	 */
	public StyledTextSkin(StyledTextArea styledText) {
		super(styledText, new StyledTextBehavior(styledText));

		this.rootContainer = new HBox();
		this.rootContainer.setSpacing(0);

		this.lineRuler = new LineRuler();
		this.lineRuler.visibleProperty().bind(getSkinnable().lineRulerVisibleProperty());
		this.lineRuler.managedProperty().bind(getSkinnable().lineRulerVisibleProperty());
		this.rootContainer.getChildren().add(this.lineRuler);

		this.contentView = new ListView<Line>() {
			@Override
			protected Skin<?> createDefaultSkin() {
				return new MyListViewSkin(this);
			}
		};
//		this.contentView.getStyleClass().add("styled-text-area"); //$NON-NLS-1$
		// listView.setFocusTraversable(false);
		this.contentView.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue.booleanValue()) {
					getSkinnable().requestFocus();
				}
			}
		});
		// listView.addEventHandler(KeyEvent.KEY_PRESSED, new
		// EventHandler<KeyEvent>() {
		// });
		this.contentView.setCellFactory(new Callback<ListView<Line>, ListCell<Line>>() {

			@Override
			public ListCell<Line> call(ListView<Line> arg0) {
				return new LineCell();
			}
		});
		this.contentView.setMinHeight(0);
		this.contentView.setMinWidth(0);
//		this.contentView.setFixedCellSize(value);
		this.contentView.setFixedCellSize(15);
		this.contentView.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				getBehavior().updateCursor(event, getCurrentVisibleCells(), event.isShiftDown());
				// The consuming does not help because it looks like the
				// selection change happens earlier => should be push a new
				// ListViewBehavior?
				event.consume();
			}
		});
		this.contentView.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				getBehavior().updateCursor(event, getCurrentVisibleCells(), true);
				event.consume();
			}
		});

		recalculateItems();

		this.contentView.setItems(this.lineList);

		HBox.setHgrow(this.contentView, Priority.ALWAYS);

		this.rootContainer.getChildren().addAll(this.contentView);
		getChildren().addAll(this.rootContainer);

		styledText.caretOffsetProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				int lineIndex = getSkinnable().getContent().getLineAtOffset(newValue.intValue());
				Line lineObject = StyledTextSkin.this.lineList.get(lineIndex);
				getFlow().show(lineIndex);

				for (LineCell c : getCurrentVisibleCells()) {
					if (c.domainElement == lineObject) {
						// Adjust the selection
						if (StyledTextSkin.this.contentView.getSelectionModel().getSelectedItem() != c.domainElement) {
							StyledTextSkin.this.contentView.getSelectionModel().select(lineObject);
						}

						StyledTextLayoutContainer p = (StyledTextLayoutContainer) c.getGraphic();
						p.setCaretIndex(newValue.intValue() - p.getStartOffset());
						p.requestLayout();

						updateCurrentCursorNode(p);

						return;
					}
				}

			}
		});
		styledText.selectionProperty().addListener(new ChangeListener<TextSelection>() {

			@Override
			public void changed(
					ObservableValue<? extends TextSelection> observable,
					TextSelection oldValue, TextSelection newValue) {
				if( newValue == null || newValue.length == 0 ) {
					for( LineCell c : getCurrentVisibleCells() ) {
						if( c.getGraphic() != null ) {
							StyledTextLayoutContainer block = (StyledTextLayoutContainer) c.getGraphic();
							block.setSelection(new TextSelection(0, 0));
						}
					}
				} else {
					TextSelection selection = newValue;
					for( LineCell c : getCurrentVisibleCells() ) {
						if( c.getGraphic() != null ) {
							Line arg0 = c.domainElement;
							StyledTextLayoutContainer block = (StyledTextLayoutContainer) c.getGraphic();
							if( selection.length > 0 && block.intersectOffset(selection.offset, selection.offset+selection.length) ) {
								int start = Math.max(0,selection.offset - arg0.getLineOffset());

								if( arg0.getLineOffset() + arg0.getLineLength() > selection.offset+selection.length ) {
									block.setSelection(new TextSelection(start, selection.offset+selection.length - arg0.getLineOffset() - start));
								} else {
									block.setSelection(new TextSelection(start, arg0.getLineLength() - start));
								}
							} else {
								block.setSelection(new TextSelection(0, 0));
							}
						}
					}
				}
			}
		});
	}

	private StyledTextLayoutContainer currentActiveNode;

	void updateCurrentCursorNode(StyledTextLayoutContainer node) {
		if( this.currentActiveNode != node ) {
			if( this.currentActiveNode != null ) {
				this.currentActiveNode.setCaretIndex(-1);
			}

			this.currentActiveNode = node;
		}
	}


	/**
	 * Refresh the line ruler
	 */
	public void refreshLineRuler() {
		this.lineRuler.refresh();
	}

	MyVirtualFlow getFlow() {
		if (this.contentView == null || this.contentView.getSkin() == null) {
			return null;
		}
		return ((MyListViewSkin) this.contentView.getSkin()).getFlow();
	}

	/**
	 * The line height at the care position
	 *
	 * @param caretPosition
	 *            the position
	 * @return the line height
	 */
	public double getLineHeight(int caretPosition) {
		int lineIndex = getSkinnable().getContent().getLineAtOffset(caretPosition);
		Line lineObject = this.lineList.get(lineIndex);

		for (LineCell c : getCurrentVisibleCells()) {
			if (c.domainElement == lineObject) {
				return c.getHeight();
			}
		}
		return 0;
	}

	/**
	 * Get the point for the caret position
	 *
	 * @param caretPosition
	 *            the position
	 * @return the point
	 */
	public Point2D getCaretLocation(int caretPosition) {
		if (caretPosition < 0) {
			return null;
		}

		int lineIndex = getSkinnable().getContent().getLineAtOffset(caretPosition);
		Line lineObject = this.lineList.get(lineIndex);
		for (LineCell c : getCurrentVisibleCells()) {
			if (c.domainElement == lineObject) {
				StyledTextLayoutContainer b = (StyledTextLayoutContainer) c.getGraphic();
				Point2D careLocation = b.getCareLocation(caretPosition - b.getStartOffset());
				Point2D tmp = getSkinnable().sceneToLocal(b.localToScene(careLocation));
				return new Point2D(tmp.getX(), getSkinnable().sceneToLocal(b.localToScene(0, b.getHeight())).getY());
			}
		}

		return null;
	}

	/**
	 * Compute the min height
	 *
	 * @param width
	 *            the width that should be used if minimum height depends on it
	 * @return the min height
	 */
	protected double computeMinHeight(double width) {
		return this.contentView.minHeight(width);
	}

	/**
	 * Compute the min width
	 *
	 * @param height
	 *            the height that should be used if minimum width depends on it
	 * @return the min width
	 */
	protected double computeMinWidth(double height) {
		return this.contentView.minWidth(height);
	}

	/**
	 * recalculate the line items
	 */
	public void recalculateItems() {
		if (this.lineList.size() != getSkinnable().getContent().getLineCount()) {
			if (this.lineList.size() > getSkinnable().getContent().getLineCount()) {
				this.lineList.remove(getSkinnable().getContent().getLineCount(), this.lineList.size());
			} else {
				List<Line> tmp = new ArrayList<>(getSkinnable().getContent().getLineCount() - this.lineList.size());
				for (int i = this.lineList.size(); i < getSkinnable().getContent().getLineCount(); i++) {
					tmp.add(new Line());
				}
				this.lineList.addAll(tmp);
			}
		}

		redraw();
	}

	/**
	 * Redraw the lines
	 */
	public void redraw() {
		for (LineCell l : getCurrentVisibleCells()) {
			if( l != null )
				l.update();
		}
	}

	List<LineCell> getCurrentVisibleCells() {
		if (this.contentView == null || this.contentView.getSkin() == null) {
			return Collections.emptyList();
		}
		return ((MyListViewSkin) this.contentView.getSkin()).getFlow().getCells();
	}

	/**
	 * A line cell
	 */
	public class LineCell extends ListCell<Line> {
		Line domainElement;

		/**
		 * A line cell instance
		 */
		public LineCell() {
			getStyleClass().add("styled-text-line"); //$NON-NLS-1$
		}

		/**
		 * @return the domain element
		 */
		public Line getDomainElement() {
			return this.domainElement;
		}

		/**
		 * Update the item
		 */
		public void update() {
			if (this.domainElement != null) {
				updateItem(this.domainElement, false);
			}
		}

		/**
		 * Update the caret
		 */
		public void updateCaret() {
			int caretPosition = getSkinnable().getCaretOffset();

			if (caretPosition < 0) {
				return;
			}
		}

		@Override
		protected void updateItem(Line arg0, boolean arg1) {
			if( ! arg1 ) {
				this.domainElement = arg0;
				LineInfo lineInfo = StyledTextSkin.this.lineInfoMap.get(this);
				if (lineInfo == null) {
					lineInfo = new LineInfo();
					lineInfo.setDomainElement(this.domainElement);
					StyledTextSkin.this.lineInfoMap.put(this, lineInfo);
					StyledTextSkin.this.lineRuler.getChildren().add(lineInfo);
					StyledTextSkin.this.lineRuler.requestLayout();
				} else {
					lineInfo.setDomainElement(this.domainElement);
					StyledTextSkin.this.lineRuler.requestLayout();
				}
				lineInfo.setLayoutY(getLayoutY());

				StyledTextLayoutContainer block = (StyledTextLayoutContainer) getGraphic();

				if( block == null ) {
					block = new StyledTextLayoutContainer();
					block.getStyleClass().add("source-segment-container"); //$NON-NLS-1$
					setGraphic(block);
//					getSkinnable().requestLayout();
				}
				block.setStartOffset(arg0.getLineOffset());

				List<@NonNull StyledTextNode> texts = new ArrayList<>();
				for (final Segment seg : arg0.getSegments()) {
					StyledTextNode t = new StyledTextNode(seg.text);
					if( seg.style.stylename != null ) {
						t.getStyleClass().setAll("source-segment",seg.style.stylename); //$NON-NLS-1$
					} else {
						if (seg.style.foreground != null) {
							t.getStyleClass().setAll("plain-source-segment"); //$NON-NLS-1$
						} else {
							t.getStyleClass().setAll("source-segment"); //$NON-NLS-1$
						}
					}
					texts.add(t);
				}

				if( arg0.getSegments().isEmpty() ) {
					StyledTextNode t = new StyledTextNode(""); //$NON-NLS-1$
					t.getStyleClass().setAll("source-segment"); //$NON-NLS-1$
					block.getTextNodes().setAll(t);
				} else {
					block.getTextNodes().setAll(texts);
				}


				TextSelection selection = getSkinnable().getSelection();

				if( selection.length > 0 && block.intersectOffset(selection.offset, selection.offset+selection.length) ) {
					int start = Math.max(0,selection.offset - arg0.getLineOffset());

					if( arg0.getLineOffset() + arg0.getLineLength() > selection.offset+selection.length ) {
						block.setSelection(new TextSelection(start, selection.offset+selection.length - arg0.getLineOffset() - start));
					} else {
						block.setSelection(new TextSelection(start, arg0.getLineLength() - start));
					}
				} else {
					block.setSelection(new TextSelection(0,0));
				}

				if( arg0.getLineOffset() <= getSkinnable().getCaretOffset() && arg0.getLineOffset() + arg0.getText().length() >= getSkinnable().getCaretOffset() ) {
					block.setCaretIndex(getSkinnable().getCaretOffset() - arg0.getLineOffset());
					updateCurrentCursorNode(block);
				} else {
					block.setCaretIndex(-1);
				}
			} else {
				setGraphic(null);
				this.domainElement = null;
				LineInfo lineInfo = StyledTextSkin.this.lineInfoMap.remove(this);
				if (lineInfo != null) {
					lineInfo.setDomainElement(null);
				}
			}

			super.updateItem(arg0, arg1);
		}
	}

	static class RegionImpl extends Region {
		public RegionImpl(Node... nodes) {
			getChildren().addAll(nodes);
		}

		@Override
		public ObservableList<Node> getChildren() {
			return super.getChildren();
		}
	}

	/**
	 * The line domain object
	 */
	public class Line implements StyledTextLine {
		/**
		 * @return the current text
		 */
		@Override
		public String getText() {
			return removeLineending(getSkinnable().getContent().getLine(StyledTextSkin.this.lineList.indexOf(this)));
		}

		@Override
		public int getLineIndex() {
			return StyledTextSkin.this.lineList.indexOf(this);
		}

		/**
		 * @return the line offset
		 */
		public int getLineOffset() {
			int idx = StyledTextSkin.this.lineList.indexOf(this);
			return getSkinnable().getContent().getOffsetAtLine(idx);
		}

		/**
		 * @return the line length
		 */
		public int getLineLength() {
			int idx = StyledTextSkin.this.lineList.indexOf(this);
			String s = getSkinnable().getContent().getLine(idx);
			return s.length();
		}

		/**
		 * @return the different segments
		 */
		@SuppressWarnings("null")
		public List<Segment> getSegments() {
			int idx = StyledTextSkin.this.lineList.indexOf(this);
			List<Segment> segments = new ArrayList<>();

			String line = getSkinnable().getContent().getLine(idx);
			if (line != null) {
				int start = getSkinnable().getContent().getOffsetAtLine(idx);
				int length = line.length();

				StyleRange[] ranges = getSkinnable().getStyleRanges(start, length, true);
				if (ranges == null) {
					return Collections.emptyList();
				}

				if( ranges.length == 0 && line.length() > 0 ) {
					StyleRange styleRange = new StyleRange((String)null);
					styleRange.start = start;
					styleRange.length = line.length();

					Segment seg = new Segment();
					seg.text = removeLineending(line.substring(0, line.length()));
					seg.style = styleRange;

					segments.add(seg);
				} else {
					int lastIndex = -1;

					if( ranges.length > 0 ) {
						if( ranges[0].start - start > 0 ) {
							StyleRange styleRange = new StyleRange((String)null);
							styleRange.start = start;
							styleRange.length = ranges[0].start - start;

							Segment seg = new Segment();
							seg.text = removeLineending(line.substring(0, ranges[0].start - start));
							seg.style = styleRange;

							segments.add(seg);
						}
					}

					for (StyleRange r : ranges) {
						int begin = r.start - start;
						int end = r.start - start + r.length;

						if (lastIndex != -1 && lastIndex != begin) {
							StyleRange styleRange = new StyleRange((String)null);
							styleRange.start = start + lastIndex;
							styleRange.length = begin - lastIndex;

							Segment seg = new Segment();
							seg.text = removeLineending(line.substring(lastIndex, begin));
							seg.style = styleRange;

							segments.add(seg);
						}

						Segment seg = new Segment();
						seg.text = removeLineending(line.substring(begin, end));
						seg.style = r;

						segments.add(seg);
						lastIndex = end;
					}

					if( lastIndex > 0 && lastIndex < line.length() ) {
						StyleRange styleRange = new StyleRange((String)null);
						styleRange.start = start + lastIndex;
						styleRange.length = line.length() - lastIndex;

						Segment seg = new Segment();
						seg.text = removeLineending(line.substring(lastIndex, line.length()));
						seg.style = styleRange;

						segments.add(seg);
					}
				}
			}

			return segments;
		}
	}

	class Segment {
		public String text;
		public StyleRange style;

		@Override
		public String toString() {
			return this.text + " => " + this.style; //$NON-NLS-1$
		}
	}

	static String removeLineending(String s) {
		return s.replace("\n", "").replace("\r", "");  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	class LineInfo extends HBox {
		private Label markerLabel;
		private Label lineText;
		Line line;

		public LineInfo() {
			this.markerLabel = new Label();
			this.markerLabel.setPrefWidth(20);
			this.lineText = new Label();
			this.lineText.getStyleClass().add("line-ruler-text"); //$NON-NLS-1$
			this.lineText.setMaxWidth(Double.MAX_VALUE);
			this.lineText.setMaxHeight(Double.MAX_VALUE);
			this.lineText.setAlignment(Pos.CENTER_RIGHT);
			HBox.setHgrow(this.lineText, Priority.ALWAYS);
			getChildren().addAll(this.markerLabel, this.lineText);
		}

		public void setDomainElement(Line line) {
			if (line == null) {
				this.line = null;
				setManaged(false);
				StyledTextSkin.this.rootContainer.requestLayout();
			} else {
				if (line != this.line) {
					this.line = line;
					calculateContent();
				}
			}
		}

		public void calculateContent() {
			Line line = this.line;
			if( line != null ) {
				setManaged(true);
				String newText = this.line.getLineIndex() + 1 + ""; //$NON-NLS-1$
				String oldText = this.lineText.getText();
				if( oldText == null ) {
					oldText = ""; //$NON-NLS-1$
				}
				this.lineText.setText(newText);
				this.markerLabel.setGraphic(getSkinnable().getLineRulerGraphicNodeFactory().call(line));
				if( newText.length() != oldText.length() ) {
					StyledTextSkin.this.rootContainer.requestLayout();
				}
				StyledTextSkin.this.lineRuler.layout();
			}
		}
	}

	class LineRuler extends Pane {
		boolean skipRelayout;

		@Override
		protected void layoutChildren() {
			if( this.skipRelayout ) {
				return;
			}
			super.layoutChildren();
			Set<Node> children = new HashSet<Node>(getChildren());
			List<LineInfo> layouted = new ArrayList<>();
			double maxWidth = 0;
			for (LineCell c : ((MyListViewSkin) StyledTextSkin.this.contentView.getSkin()).getFlow().getCells()) {
				if( c.isVisible() ) {
					LineInfo lineInfo = StyledTextSkin.this.lineInfoMap.get(c);
					if (lineInfo != null) {
						layouted.add(lineInfo);
						maxWidth = Math.max(maxWidth, lineInfo.getWidth());
						lineInfo.relocate(0, c.getLayoutY());
						lineInfo.resize(lineInfo.getWidth(), c.getHeight());
						lineInfo.setVisible(true);
						children.remove(lineInfo);
					}
				}
			}

			for (LineInfo l : layouted) {
				l.resize(maxWidth, l.getHeight());

			}

			List<Node> toRemove = new ArrayList<>();
			for (Node n : children) {
				if( n instanceof LineInfo ) {
					LineInfo l = (LineInfo) n;
					if( l.line == null ) {
						toRemove.add(l);
					}
				}
				n.setVisible(false);
			}

			getChildren().removeAll(toRemove);
		}

		public void refresh() {
			getChildren().filtered(n -> n instanceof LineInfo).forEach( n -> ((LineInfo)n).calculateContent());
		}
	}

	class MyListViewSkin extends ListViewSkin<Line> {
		private MyVirtualFlow flow;

		public MyListViewSkin(ListView<Line> listView) {
			super(listView);
		}

		public MyVirtualFlow getFlow() {
			return this.flow;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected VirtualFlow<ListCell<Line>> createVirtualFlow() {
			this.flow = new MyVirtualFlow();
			return (VirtualFlow<ListCell<Line>>) ((VirtualFlow<?>) this.flow);
		}

	}

	class MyVirtualFlow extends VirtualFlow<LineCell> {
		public MyVirtualFlow() {
		}

		@Override
		protected void positionCell(LineCell cell, double position) {
			super.positionCell(cell, position);
			LineInfo lineInfo = StyledTextSkin.this.lineInfoMap.get(cell);
			if (lineInfo != null) {
				lineInfo.setDomainElement(cell.domainElement);
				lineInfo.setLayoutY(cell.getLayoutY());
			}
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					StyledTextSkin.this.lineRuler.requestLayout();
				}
			});

		}

		@Override
		public List<LineCell> getCells() {
			return super.getCells();
		}

		@Override
		public void rebuildCells() {
			StyledTextSkin.this.lineRuler.skipRelayout = true;
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					StyledTextSkin.this.lineRuler.skipRelayout = false;
					StyledTextSkin.this.lineRuler.requestLayout();
				}
			});
			super.rebuildCells();
		}
	}
}