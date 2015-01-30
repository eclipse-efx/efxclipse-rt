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

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
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
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Callback;
import javafx.util.Duration;

import org.eclipse.fx.ui.controls.styledtext.StyleRange;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.StyledTextLine;
import org.eclipse.fx.ui.controls.styledtext.behavior.StyledTextBehavior;

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

	private static final boolean USE_MONO_RASTER = true;

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
		this.contentView.getStyleClass().add("styled-text-area"); //$NON-NLS-1$
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
//		this.contentView.setFixedCellSize(25);
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

		// b.getChildren().addAll(lineView);
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

						RegionImpl container = (RegionImpl) c.getGraphic();
						Pane flow = (Pane) container.getChildren().get(0);

						flow.requestLayout();

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
				recalculateItems();
			}
		});
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
	@SuppressWarnings("deprecation")
	public Point2D getCaretLocation(int caretPosition) {
		if (caretPosition < 0) {
			return null;
		}

		int lineIndex = getSkinnable().getContent().getLineAtOffset(caretPosition);
		Line lineObject = this.lineList.get(lineIndex);
		for (LineCell c : getCurrentVisibleCells()) {
			if (c.domainElement == lineObject) {
				RegionImpl container = (RegionImpl) c.getGraphic();
				Pane flow = (Pane) container.getChildren().get(0);
				// System.err.println("STARTING SCAN");
				Text textNode = null;
				int relativePos = 0;
				for (int i = flow.getChildren().size() - 1; i >= 0; i--) {
					Node n = flow.getChildren().get(i);
					// System.err.println(((Text)n).getText() + " => " +
					// n.getLayoutX());
					int offset = ((Integer) n.getUserData()).intValue();
					if (offset <= caretPosition) {
						relativePos = caretPosition - offset;
						textNode = (Text) ((TextFlow) n).getChildren().get(0);
						break;
					}
				}

				if (textNode != null) {
					textNode.setImpl_caretPosition(relativePos);
					PathElement[] elements = textNode.getImpl_caretShape();
					Point2D t = getSkinnable().sceneToLocal(textNode.localToScene(new Point2D(0, textNode.getBoundsInParent().getHeight())));
					// System.err.println(textNode.getText() + " ====> " +
					// xShift);
					int xShift = 0;
					for (PathElement e : elements) {
						if (e instanceof MoveTo) {
							xShift += ((MoveTo) e).getX();
						}
					}
					// System.err.println("==> " + xShift);

					return t.add(xShift, 0);
					// final Path p = (Path)container.getChildren().get(1);
					//
					// p.getElements().clear();
					// p.getElements().addAll(textNode.getImpl_caretShape());
					//
					// p.setLayoutX(textNode.getLayoutX());
					// p.setLayoutY(textNode.getBaselineOffset());
				}

				// RegionImpl container = (RegionImpl)c.getGraphic();
				//
				// final Path p = (Path)container.getChildren().get(1);
				// Point2D rv = new
				// Point2D(p.getLayoutX(),container.getLayoutY());
				// System.err.println("CARE-LOC: " + rv);
				// return rv;
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
		private BooleanBinding caretVisible;
		BooleanProperty flashProperty;
		Timeline flashTimeline;

		/**
		 * A line cell instance
		 */
		public LineCell() {
			getStyleClass().add("styled-text-line"); //$NON-NLS-1$
			this.flashProperty = new SimpleBooleanProperty(this, "flash", false); //$NON-NLS-1$
			this.flashTimeline = new Timeline();
			this.flashTimeline.setCycleCount(Animation.INDEFINITE);

			EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					LineCell.this.flashProperty.set(true);
				}
			};

			EventHandler<ActionEvent> endEvent = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					LineCell.this.flashProperty.set(false);
				}
			};

			this.flashTimeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, startEvent), new KeyFrame(Duration.millis(500), endEvent), new KeyFrame(Duration.millis(1000)));
			this.caretVisible = new BooleanBinding() {
				{
					bind(selectedProperty(), LineCell.this.flashProperty);
				}

				@Override
				protected boolean computeValue() {
					return selectedProperty().get() && LineCell.this.flashProperty.get();
				}
			};
			selectedProperty().addListener(new ChangeListener<Boolean>() {

				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
					if (arg2.booleanValue()) {
						LineCell.this.flashTimeline.play();
					} else {
						LineCell.this.flashTimeline.stop();
					}
				}
			});
			// Once this property is observed the error does not occurr
			// need to track that down one day
			boundsInParentProperty().addListener(new ChangeListener<Bounds>() {

				@Override
				public void changed(
						ObservableValue<? extends Bounds> observable,
						Bounds oldValue, Bounds newValue) {
					if( newValue != null && newValue.getHeight() > 100 ) {
						System.err.println("Looks like an invalid cell height: " + newValue); //$NON-NLS-1$
						Thread.dumpStack();
					}
				}
			});
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
		@SuppressWarnings("deprecation")
		public void updateCaret() {
			int caretPosition = getSkinnable().getCaretOffset();

			if (caretPosition < 0) {
				return;
			}

			int lineIndex = getSkinnable().getContent().getLineAtOffset(caretPosition);
			Line lineObject = StyledTextSkin.this.lineList.get(lineIndex);
			for (LineCell c : getCurrentVisibleCells()) {
				if (c.domainElement == lineObject) {
					RegionImpl container = (RegionImpl) c.getGraphic();
					Pane flow = (Pane) container.getChildren().get(0);

					TextFlow textNode = null;
					int relativePos = 0;
					for (int i = flow.getChildren().size() - 1; i >= 0; i--) {
						Node n = flow.getChildren().get(i);
						int offset = ((Integer) n.getUserData()).intValue();
						if (offset <= caretPosition) {
							relativePos = caretPosition - offset;
							textNode = (TextFlow) n;
							break;
						}
					}

					if (textNode != null) {
						Text text = (Text)textNode.getChildren().get(0);
						text.setImpl_caretPosition(relativePos);

						final Path p = (Path) container.getChildren().get(1);

						p.getElements().clear();

						PathElement[] impl_caretShape = text.getImpl_caretShape();
						if( impl_caretShape.length == 2 ) {
							if( impl_caretShape[0] instanceof MoveTo && impl_caretShape[1] instanceof LineTo ) {
								MoveTo m = (MoveTo)impl_caretShape[0];
								LineTo l = (LineTo)impl_caretShape[1];
								if( m.getY() > 0.0 ) {
//									System.err.println("========== INVALID: " + text.getText() + "============");
//									System.err.println("Caret: " + Arrays.toString(impl_caretShape));
//									System.err.println("Text-Bounds: " + text.getBoundsInLocal());
//									System.err.println("Wrapping-Width: " + text.getWrappingWidth());
//									System.err.println("Text-Flow:" + textNode.getBoundsInLocal());
									l.setY(l.getY() - m.getY());
									m.setY(0);
								} else {
//									System.err.println("========== VALID: " + text.getText() + "============");
//									System.err.println("Caret: " + Arrays.toString(impl_caretShape));
//									System.err.println("Text-Bounds: " + text.getBoundsInLocal());
//									System.err.println("Wrapping-Width: " + text.getWrappingWidth());
//									System.err.println("Text-Flow:" + textNode.getBoundsInLocal());
								}
							}
						}

						p.getElements().addAll(impl_caretShape);

						p.setLayoutX(textNode.getChildren().get(0).getLayoutX() + textNode.getLayoutX());
						p.setLayoutY(textNode.getChildren().get(0).getLayoutY() + textNode.getLayoutY());
					}

					break;
				}
			}
		}

		@Override
		protected void updateItem(Line arg0, boolean arg1) {
			if (!arg1) {
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

				RegionImpl stack = (RegionImpl) getGraphic();
				Pane flow;
				TextLayouter layouter;

				if (stack == null) {
					layouter = new TextLayouter(USE_MONO_RASTER, this::updateCaret);
					flow = layouter.getLayoutPane();
					Path caretPath = new Path();
					caretPath.getStyleClass().add("text-caret"); //$NON-NLS-1$
					caretPath.setManaged(false);
					caretPath.setStrokeWidth(2);
					caretPath.visibleProperty().bind(this.caretVisible);
					stack = new RegionImpl(flow, caretPath);
					setGraphic(stack);
				} else {
					flow = (Pane) stack.getChildren().get(0);
					layouter = (TextLayouter) flow.getUserData();
				}

				List<TextFlow> texts = new ArrayList<>();
				if( arg0.getSegments().isEmpty() ) {
					setPrefHeight(20);
				} else {
					setPrefHeight(-1);
				}
				for (final Segment seg : arg0.getSegments()) {
//					System.err.println("SEGMENT: " + seg.text + " => " + seg.style.stylename);
					final Text t = new Text(seg.text);

					if( seg.style.stylename != null ) {
						t.getStyleClass().setAll("source-segment",seg.style.stylename); //$NON-NLS-1$
					} else {
						if (seg.style.foreground != null) {
							t.getStyleClass().setAll("plain-source-segment"); //$NON-NLS-1$
						} else {
							t.getStyleClass().setAll("source-segment"); //$NON-NLS-1$
						}
					}

					if (seg.style.foreground != null) {
						t.setFill(seg.style.foreground);
					}
					if (seg.style.font != null) {
						t.setFont(seg.style.font);
					}

					if (seg.style.underline) {
//						System.err.println("=====================> UNDERLINEING");
					}


					TextFlow f = new TextFlow(t);
					if( seg.style.decorationStyleClasses != null ) {
						t.getStyleClass().addAll(seg.style.decorationStyleClasses);
					}
					f.setUserData(Integer.valueOf(seg.style.start));
					if( seg.style.hoverStylename != null ) {
						f.getStyleClass().setAll("source-segment-container", seg.style.hoverStylename); //$NON-NLS-1$
						texts.add(f);
					} else {
						f.getStyleClass().setAll("source-segment-container"); //$NON-NLS-1$
						texts.add(f);
					}
				}

				if (texts.isEmpty()) {
					Text t = new Text(""); //$NON-NLS-1$
					t.getStyleClass().setAll("source-segment");  //$NON-NLS-1$
					TextFlow f = new TextFlow(t);
					f.setUserData(Integer.valueOf(arg0.getLineOffset()));
					texts.add(f);
				}
				layouter.setText(arg0.getText());
				flow.getChildren().setAll(texts);
			} else {
				setGraphic(null);
				this.domainElement = null;
				LineInfo lineInfo = StyledTextSkin.this.lineInfoMap.remove(this);
				if (lineInfo != null) {
					lineInfo.setDomainElement(null);
//					StyledTextSkin.this.lineRuler.getChildren().remove(lineInfo);
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
			// System.err.println("LINE: " + line);
			if (line != null) {
				int start = getSkinnable().getContent().getOffsetAtLine(idx);
				int length = line.length();

				StyleRange[] ranges = getSkinnable().getStyleRanges(start, length, true);
				// System.err.println("RANGES: " + ranges);
				if (ranges == null) {
//					System.err.println("NO RANGES");
					return Collections.emptyList();
				}

//				System.err.println("LINE: " + line);

				TextSelection selection = getSkinnable().getSelection();

				int selectionStart = selection.offset - start;
				int selectionEnd = selection.offset+selection.length - start;

				if( ranges.length == 0 && line.length() > 0 ) {
					StyleRange styleRange = new StyleRange((String)null);
					styleRange.start = start;
					styleRange.length = line.length();
					segments.addAll(createSegments(line, styleRange, selectionStart, selectionEnd, 0, line.length()));
				} else {
					int lastIndex = -1;

					if( ranges.length > 0 ) {
						if( ranges[0].start - start > 0 ) {
							StyleRange styleRange = new StyleRange((String)null);
							styleRange.start = start;
							styleRange.length = ranges[0].start - start;
							segments.addAll(createSegments(line, styleRange, selectionStart, selectionEnd, 0, ranges[0].start - start));
						}
					}

					for (StyleRange r : ranges) {
						int begin = r.start - start;
						int end = r.start - start + r.length;

						if (lastIndex != -1 && lastIndex != begin) {
							StyleRange styleRange = new StyleRange((String)null);
							styleRange.start = start + lastIndex;
							styleRange.length = begin - lastIndex;
							segments.addAll(createSegments(line, styleRange, selectionStart, selectionEnd, lastIndex, begin));
						}

						segments.addAll(createSegments(line, r, selectionStart, selectionEnd, begin, end));
						lastIndex = end;
					}

					if( lastIndex > 0 && lastIndex < line.length() ) {
						StyleRange styleRange = new StyleRange((String)null);
						styleRange.start = start + lastIndex;
						styleRange.length = line.length() - lastIndex;
						segments.addAll(createSegments(line, styleRange, selectionStart, selectionEnd, lastIndex, line.length()));
					}
				}


				// System.err.println("SEGEMENTS: " + segments);
			}

			return segments;
		}

		private List<Segment> createSegments(String line, StyleRange r, int selectionStart, int selectionEnd, int begin, int end) {
			//FIXME We need to to set the length!!!
			if( selectionStart != selectionEnd ) {
				if( selectionStart <= begin  && selectionEnd >= end  ) {
					// whole entry is selected
					Segment seg = new Segment();
					seg.text = removeLineending(line.substring(begin, end));
					seg.style = new StyleRange(r);
					seg.style.start = r.start;
					seg.style.hoverStylename = "hover"; //$NON-NLS-1$

//					System.err.println(seg.text + " => " + seg.style.start);
					return Collections.singletonList(seg);
				} else if( selectionStart <= begin && selectionEnd >= begin && selectionEnd <= end ) {
					// selection start before and ends inside
					List<Segment> rv = new ArrayList<StyledTextSkin.Segment>();

					Segment seg = new Segment();
					seg.text = removeLineending(line.substring(begin, selectionEnd));
					seg.style = new StyleRange(r);
					seg.style.hoverStylename = "hover"; //$NON-NLS-1$
					seg.style.start = r.start;
//					System.err.println(seg.text + " => " + seg.style.start);
					rv.add(seg);

					seg = new Segment();
					seg.text = removeLineending(line.substring(selectionEnd, end));
					seg.style = new StyleRange(r);
					seg.style.start = r.start + selectionEnd-begin;
//					System.err.println(seg.text + " => " + seg.style.start);
					rv.add(seg);

					return rv;
				} else if( begin < selectionStart && selectionStart <= end && selectionEnd >= end ) {
					// selection starts inside and ends outside
					List<Segment> rv = new ArrayList<StyledTextSkin.Segment>();

					Segment seg = new Segment();
					seg.text = removeLineending(line.substring(begin, selectionStart));
					seg.style = new StyleRange(r);
					seg.style.start = r.start;
//					System.err.println(seg.text + " => " + seg.style.start);
					rv.add(seg);

					seg = new Segment();
					seg.text = removeLineending(line.substring(selectionStart, end));
					seg.style = new StyleRange(r);
					seg.style.start = r.start + selectionStart-begin;
					seg.style.hoverStylename = "hover"; //$NON-NLS-1$
//					System.err.println(seg.text + " => " + seg.style.start);
					rv.add(seg);

					return rv;
				} else if( between(selectionStart, begin, end) && between(selectionEnd, begin, end) ) {
//					System.err.println("A BETWEEN MATCH!!!!");
					// selection starts and ends inside
					List<Segment> rv = new ArrayList<StyledTextSkin.Segment>();

					Segment seg = new Segment();
					seg.text = removeLineending(line.substring(begin, selectionStart));
					seg.style = new StyleRange(r);
					seg.style.start = r.start;
//					System.err.println(seg.text + " => " + seg.style.start);
					rv.add(seg);

					seg = new Segment();
					seg.text = removeLineending(line.substring(selectionStart, selectionEnd));
					seg.style = new StyleRange(r);
					seg.style.start = r.start + selectionStart-begin;
					seg.style.hoverStylename = "hover"; //$NON-NLS-1$
//					System.err.println(seg.text + " => " + seg.style.start);
					rv.add(seg);

					seg = new Segment();
					seg.text = removeLineending(line.substring(selectionEnd, end));
					seg.style = new StyleRange(r);
					seg.style.start = r.start + selectionEnd-begin;
//					System.err.println(seg.text + " => " + seg.style.start);
					rv.add(seg);
					return rv;
				} else {
//					System.err.println("UNMATCHED CASE");
//					System.err.println("Sel: "+ selectionStart + "/" + selectionEnd);
//					System.err.println("Segment:" + begin + "/" + end);
				}
			}

			Segment seg = new Segment();
			seg.text = removeLineending(line.substring(begin, end));
			seg.style = r;
			return Collections.singletonList(seg);
		}

		private boolean between(int x, int min, int max) {
			return x > min && x < max;
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
//			System.err.println("RELAYOUT");
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
//				System.err.println("BOUNDS: " + l.lineText.getText() + " => " + l.getBoundsInParent());

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