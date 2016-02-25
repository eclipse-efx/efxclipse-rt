package org.eclipse.fx.ui.controls.styledtext.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.StyledTextContent;
import org.eclipse.fx.ui.controls.styledtext.StyledTextContent.TextChangeListener;
import org.eclipse.fx.ui.controls.styledtext.TextChangedEvent;
import org.eclipse.fx.ui.controls.styledtext.TextChangingEvent;
import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.fx.ui.controls.styledtext.model.TextAnnotationPresenter;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

import javafx.beans.Observable;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Point2D;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ContentView  extends Pane {

	public static boolean debugOut = Boolean.getBoolean("styledtext.debugout");

	private SetProperty<TextAnnotationPresenter> textAnnotationPresenter = new SimpleSetProperty<>(FXCollections.observableSet());
	public SetProperty<TextAnnotationPresenter> textAnnotationPresenterProperty() {
		return textAnnotationPresenter;
	}

	private class LineLayer extends VFlow<LineNode> {

		public LineLayer(Supplier<LineNode> nodeFactory, BiConsumer<LineNode, Integer> nodePopulator) {
			super(nodeFactory, nodePopulator);

			setOnRelease(n->n.release());
			setOnActivate((idx, n)->n.setIndex(idx));
		}



//		protected void releaseNode(int lineIndex) {
//
//			get(model.get(lineIndex)).ifPresent(n->{
//				n.setVisible(false);
//				n.release();
//			});
//		}

//		protected void releaseNode(StyledTextLine line) {
//			if (debugOut) System.err.println("RELEASE " + line);
//			release(line);
////			get(line).ifPresent(n->{
////				n.setVisible(false);
////				n.release();
////			});
//		}

//		private void updateNode(StyledTextLine line) {
//			if (debugOut) System.err.println("UPDATE " + line);
//			LineNode node = get(line);
//			node.update(line, textAnnotationPresenter);
////			LineNode node = getCreate(m);
////			node.setVisible(true);
//////			node.setModel(m);
////			node.update(m, textAnnotationPresenter);
//		}

//		private void updateNode(int lineIndex, StyledTextLine m) {
//			LineNode node = getCreate(m);
//			node.setVisible(true);
////			node.setModel(m);
//			node.update(m, textAnnotationPresenter);
//		}

//		@Override
//		public void requestLayout() {
//			super.requestLayout();
//		}

//		@Override
//		protected void layoutChildren() {
//			if (debugOut) System.err.println("layout LineLayer");
//			ContiguousSet.create(visibleLines.get(), DiscreteDomain.integers()).forEach(e -> {
//				if (!yOffsetData.containsKey(e)) {
//					if (debugOut) System.err.println("NO yOffset FOR " + e);
//					return;
//				}
//				double x = 0;
//				double y = yOffsetData.get(e);
//				double width = getWidth();
//				double height = getLineHeight();
//
//				if (model.size() > e) {
//					StyledTextLine m = model.get(e);
//					LineNode lineNode = get(m);
//					lineNode.resizeRelocate(x, y, width, height);
//
//					if (debugOut) System.err.println("layout " + e + ": y=" + y + " line= " + lineNode);
//					if (debugOut) System.err.println("      visible = " + lineNode.isVisible());
//					if (debugOut) System.err.println("      bounds = " + lineNode.getBoundsInParent());
////					get(m).ifPresent(n->n.resizeRelocate(x, y, width, height));
//
//					lineNode.layout();
//				}
//			});
//		}

		@Override
		protected void releaseNode(int lineIndex) {
			super.releaseNode(lineIndex);

		}

		private Stream<LineNode> createVisibleLineNodesStream() {
			ContiguousSet<Integer> visibleIndexes = ContiguousSet.create(visibleLines.get(), DiscreteDomain.integers());
//			return visibleIndexes.stream().filter(i->i<model.size()).map(idx->get(model.get(idx))).filter(n->n.isPresent()).map(n->n.get()).filter(n->n.isVisible());
			return visibleIndexes.stream().filter(i->i<getNumberOfLines()).map(idx->getVisibleNode(idx)).filter(n->n.isPresent()).map(n->n.get());
		}

		private Optional<Integer> getLineIndex(javafx.geometry.Point2D point) {
			final Optional<LineNode> hitLine = createVisibleLineNodesStream().filter(n->n.getBoundsInParent().contains(point)).findFirst();
			final Optional<Integer> index = hitLine.map(n->{
				int i = n.getCaretIndexAtPoint(new javafx.geometry.Point2D(point.getX(), n.getHeight()/2));
				if (i >= 0 ) {
					return n.getStartOffset() + i;
				}
				else {
					return n.getEndOffset();
				}
			});
			return index;
		}


//		protected void permutate(int a, int b) {
//			LineNode nodeA = existingNodes.get(a);
//			LineNode nodeB = existingNodes.get(b);
//
//			existingNodes.put(a, nodeB);
//			existingNodes.put(b, nodeA);
//
//			System.err.println("  . permutate " + a + " -> " + b);
//		}
	}

	private StackPane contentBody = new StackPane();

	private LineLayer lineLayer = new LineLayer(()->new LineNode(), (n, m)->{
		n.setLineHelper(getLineHelper());
		n.update(textAnnotationPresenter.get());
	});

	private Predicate<Set<LineNode>> needsPresentation;

	private Map<Integer, Double> yOffsetData = new HashMap<>();

	private boolean forceLayout = true;

	private DoubleProperty lineHeigth = new SimpleDoubleProperty(this, "lineHeight", 16.0);
	public DoubleProperty lineHeightProperty() {
		return this.lineHeigth;
	}
	public double getLineHeight() {
		return this.lineHeigth.get();
	}
	public void setLineHeight(double lineHeight) {
		this.lineHeigth.set(lineHeight);
	}

	private IntegerProperty numberOfLines = new SimpleIntegerProperty(this, "numberOfLines", 0);
	public ReadOnlyIntegerProperty numberOfLinesProperty() {
		return this.numberOfLines;
	}
	public int getNumberOfLines() {
		return this.numberOfLines.get();
	}

	private IntegerProperty caretOffset = new SimpleIntegerProperty(this, "caretOffset", 0);
	public IntegerProperty caretOffsetProperty() {
		return this.caretOffset;
	}

	private ObjectProperty<TextSelection> textSelection = new SimpleObjectProperty<>(this, "textSelection", new TextSelection(0, 0));
	public ObjectProperty<TextSelection> textSelectionProperty() {
		return this.textSelection;
	}

	private ObjectProperty<StyledTextContent> content = new SimpleObjectProperty<>(this, "content");
	public ObjectProperty<StyledTextContent> contentProperty() {
		return this.content;
	}
	public StyledTextContent getContent() {
		return this.content.get();
	}

	private LineHelper lineHelper;

	protected LineLayer getLineLayer() {
		return this.lineLayer;
	}

	protected LineHelper getLineHelper() {
		return this.lineHelper;
	}

//	private ObservableList<StyledTextLine> model;
//	private IntegerBinding modelSize;

//	public void setModel(ObservableList<StyledTextLine> model) {
//		this.model = model;
//
//
////		model.addListener((InvalidationListener)(x)->prepareNodes(getVisibleLines()));
//
////		model.addListener((ListChangeListener<StyledTextLine>)(c)->{
////			RangeSet<Integer> updateNodes = TreeRangeSet.create();
////
////			while (c.next()) {
////				if (debugOut) System.err.println("CHANGE [");
////				if (c.wasPermutated()) {
////					if (debugOut) System.err.println("-> permutation " + c);
//////					for (int i = c.getFrom(); i < c.getTo(); i++) {
//////						lineLayer.permutate(i, c.getPermutation(i));
//////					}
//////					lineLayer.requestLayout();
////				}
////				if (c.wasUpdated() || c.wasReplaced()) {
////					if (debugOut) System.err.println("-> updated or replaced: " + c.getFrom() + " - " + c.getTo());
////					updateNodes.add(Range.closedOpen(c.getFrom(), c.getTo()));
////
////
////				}
////				if (c.wasAdded()) {
////					if (debugOut) System.err.println("-> added: " + c.getFrom() + " - " + c.getTo());
////					updateNodes.add(Range.closedOpen(c.getFrom(), model.size()));
////				}
////				if (c.wasRemoved()) {
////					if (debugOut) System.err.println("-> removed: " + c.getFrom() + " - " + c.getTo());
////
////					c.getRemoved().forEach(line->lineLayer.releaseNode(line));
////
////					updateNodes.add(Range.closedOpen(c.getFrom(), model.size()));
////				}
////				if (debugOut) System.err.println("]");
////			}
////
////			updateNodesNow(updateNodes);
////		});
////
////		modelSize = Bindings.size(model);
////
////		modelSize.addListener((x, o, n)-> {
////			int newSize = n.intValue();
////			int oldSize = o.intValue();
////			if (newSize < oldSize) {
//////				for (int lineIdx = newSize; lineIdx < oldSize; lineIdx++) {
//////					lineLayer.releaseNode(lineIdx);
//////				}
////			}
////		});
//	}

//	private ListProperty<StyledTextLine> model = new SimpleListProperty<>(this, "model", FXCollections.observableArrayList());
//	public ListProperty<StyledTextLine> getModel() {
//		return this.model;
//	}

	private ObjectProperty<Range<Integer>> visibleLines = new SimpleObjectProperty<>(this, "visibleLines", Range.closed(0, 0));
	public ObjectProperty<Range<Integer>> visibleLinesProperty() {
		return this.visibleLines;
	}
	public com.google.common.collect.Range<Integer> getVisibleLines() {
		return this.visibleLines.get();
	}
	public void setVisibleLines(Range<Integer> visibleLines) {
		this.visibleLines.set(visibleLines);
	}

	private Range<Integer> curVisibleLines;
	private StyledTextArea area;

	public ContentView(LineHelper lineHelper, StyledTextArea area) {
		this.area = area;
		this.lineHelper = lineHelper;
//		setStyle("-fx-border-color: green; -fx-border-width:2px; -fx-border-style: dashed;");

		this.contentBody.getChildren().setAll(this.lineLayer);

//		this.lineLayer.setStyle("-fx-border-color: orange; -fx-border-width:2px; -fx-border-style: solid;");


//		this.contentBody.setStyle("-fx-border-color: blue; -fx-border-width:2px; -fx-border-style: dotted;");


		this.getChildren().setAll(this.contentBody);



//		AnimationTimer t = new AnimationTimer() {
//			@Override
//			public void handle(long now) {
//				updatePulse(now);
//			}
//		};
//
//		visibleProperty().addListener((x, o, n)->{
//			if (n) {
//				t.start();
//			}
//			else {
//				t.stop();
//			}
//		});
//
//		t.start();
//		sceneProperty().addListener((x, o, n) -> {
//			if (n == null) {
//				t.stop();
//			}
//			else {
//				t.start();
//			}
//		});


		setMinWidth(200);
		setMinHeight(200);

		visibleLines.addListener(this::onLineChange);
		offsetX.addListener(this::onLineChange);



		this.lineLayer.lineHeightProperty().bind(this.lineHeigth);
		this.lineLayer.yOffsetProperty().bind(this.offsetY);
		this.lineLayer.visibleLinesProperty().bind(this.visibleLines);
		this.lineLayer.numberOfLinesProperty().bind(this.numberOfLines);

		bindContentListener();
		bindCaretListener();
		bindSelectionListener();
	}

	private void bindCaretListener() {
		caretOffset.addListener((x, o, n)-> {
			int oldCaretLine = getContent().getLineAtOffset(o.intValue());
			int newCaretLine = getContent().getLineAtOffset(n.intValue());

			RangeSet<Integer> toUpdate = TreeRangeSet.create();
			toUpdate.add(Range.closed(oldCaretLine, oldCaretLine));
			toUpdate.add(Range.closed(newCaretLine, newCaretLine));

			updateNodesNow(toUpdate);
		});
	}

	private Range<Integer> getAffectedLines(TextSelection selection) {
		int firstLine = getContent().getLineAtOffset(selection.offset);
		int lastLine = getContent().getLineAtOffset(selection.offset + selection.length);
		if(debugOut) System.err.println("getAffectedLines " + selection + " -> " + firstLine + " - " + lastLine);
		if (lastLine == -1) {
			lastLine = numberOfLines.get();
		}
		return Range.closed(firstLine, Math.min(lastLine, numberOfLines.get()));
	}

	private Range<Integer> toRange(TextSelection s) {
		return Range.closedOpen(s.offset, s.offset + s.length);
	}

	private Range<Integer> toLineRange(Range<Integer> globalOffsetRange) {
		int lower = getContent().getLineAtOffset(globalOffsetRange.lowerEndpoint());
		int upper = getContent().getLineAtOffset(globalOffsetRange.upperEndpoint());
		return Range.closed(lower, upper);
	}

	private void bindSelectionListener() {
		textSelection.addListener((x, o, n) -> {
			RangeSet<Integer> toUpdate = TreeRangeSet.create();
			if (o != null) toUpdate.add(getAffectedLines(o));
			if (n != null) toUpdate.add(getAffectedLines(n));
			if(debugOut) System.err.println("ContentView: onSelectionChange " + o + " -> " + n + " triggered " + toUpdate);
			updateNodesNow(toUpdate);
		});
	}

	private void bindContentListener() {
		this.content.addListener((x, o, n)->{
			if (o != null) {
				o.removeTextChangeListener(this.textChangeListener);
			}
			if (n != null) {
				n.addTextChangeListener(this.textChangeListener);
				if(debugOut) System.err.println("init #ofLines with " + n.getLineCount());
				this.numberOfLines.set(n.getLineCount());
			}
		});
		StyledTextContent current = this.content.get();
		if (current != null) {
			current.addTextChangeListener(this.textChangeListener);

			// set inital values
			if(debugOut) System.err.println("init #ofLines with " + current.getLineCount());
			numberOfLines.set(current.getLineCount());

		}
	}

	private TextChangeListener textChangeListener = new TextChangeListener() {

		private Function<Integer, Integer> mapping;
		private RangeSet<Integer> toUpdate = TreeRangeSet.create();
		private RangeSet<Integer> toRelease = TreeRangeSet.create();

		@Override
		public void textSet(TextChangedEvent event) {
			if(debugOut) System.err.println("ContentView textSet");

			// update number of lines
			ContentView.this.numberOfLines.set(getContent().getLineCount());

			getLineLayer().requestLayout();
		}

		private int computeFirstUnchangedLine(TextChangingEvent event) {

			int endOffset = event.offset + event.replaceCharCount;
			int endLineIndex = getContent().getLineAtOffset(endOffset);
			int endLineBegin = getContent().getOffsetAtLine(endLineIndex);
			int endLineLength = lineHelper.getLength(endLineIndex);

			int firstSafeLine;

			if (endLineBegin == event.offset) {
				// offset at beginning of line
				firstSafeLine = endLineIndex;
			}
			else {
				// offset in middle or at end of line
				firstSafeLine = endLineIndex + 1;
			}

			return firstSafeLine;
		}

		@Override
		public void textChanging(TextChangingEvent event) {
			if(debugOut) System.err.println("ContentView textChanging");
			if(debugOut) System.err.println(" current doc len = " + getContent().getLineCount());
			if(debugOut) System.err.println("Event: "+ event);

			final int changeBeginLine = getContent().getLineAtOffset(event.offset);

			// determine first unchanged line
			int firstUnchangedLine = computeFirstUnchangedLine(event);

			if(debugOut) System.err.println("FIRST UNCHANGEDLINE: " + firstUnchangedLine);

			int deltaLines = event.newLineCount - event.replaceLineCount;

			if (deltaLines < 0) {
				this.toRelease.add(Range.closedOpen(firstUnchangedLine + deltaLines, firstUnchangedLine));
			}

			// prepare permutation
			this.mapping = (idx) -> {
				if (idx >= firstUnchangedLine) {
					return idx + deltaLines;
				}
				return idx;
			};

			this.toUpdate.add(Range.closedOpen(changeBeginLine, firstUnchangedLine + deltaLines));


//
//			// simple insert
//			if (event.replaceCharCount == 0) {
//				System.err.println("# Simple Insert");
//				if (event.newLineCount > 0) {
//					System.err.println("# We have new lines");
//
//					int lineIndex = getContent().getLineAtOffset(event.offset);
//					int lineBegin = getContent().getOffsetAtLine(lineIndex);
//					int lineLength = lineHelper.getLength(lineIndex);
//
//					int firstSafeLine;
//					Range<Integer> updateRange;
//
//					if (lineBegin == event.offset) {
//						// at beginning of line
//						firstSafeLine = lineIndex;
//						updateRange = Range.closedOpen(lineIndex, lineIndex + event.newLineCount);
//					}
//					else if (lineBegin == event.offset + lineLength) {
//						// insert was at end of line
//						firstSafeLine= lineIndex + 1;
//						updateRange = Range.closedOpen(lineIndex, lineIndex + event.newLineCount);
//					}
//					else {
//						// insert was in middle of line
//						firstSafeLine = lineIndex + 2;
//						updateRange = Range.closedOpen(lineIndex, lineIndex + 1 + event.newLineCount);
//					}
//					System.err.println("# firstSafeLine = " + firstSafeLine + " / updateRange " + updateRange);
//
//					// prepare update
//					toUpdate.add(updateRange);
//
//					// prepare permutation
//					this.mapping = (idx) -> {
//						if (idx >= firstSafeLine) {
//							return idx + event.newLineCount;
//						}
//						return idx;
//					};
//
//				}
//			}



//			int firstUnchangedLine = changeBeginLine + replaceLines;
//
//			int newFirstUnchnagedLine = changeBeginLine + newLines;
//
//			System.err.println(" changeBeginLine = " + changeBeginLine);
//			System.err.println(" firstUnchangedLine = " + firstUnchangedLine);
//			System.err.println(" newFirstUnchangedLine = " + newFirstUnchnagedLine);
//
//			// prepare updates
//			toUpdate.add(Range.closedOpen(changeBeginLine, changeBeginLine + newLines));
//			// prepare permutation
//			this.mapping = (idx) -> {
//				if (idx >= firstUnchangedLine) {
//					return idx + firstUnchangedLine - newFirstUnchnagedLine;
//				}
//				return idx;
//			};

		}

		@Override
		public void textChanged(TextChangedEvent event) {
			if(debugOut) System.err.println("ContentView textChanged");


			if (!toRelease.isEmpty()) {
				releaseNodesNow(toRelease);
				toRelease.clear();
			}

			// execute permutation
			if (this.mapping != null) {
				getLineLayer().permutateNodes(mapping);
				this.mapping = null;
			}


			// execute updates
			if (!toUpdate.isEmpty()) {

				updateNodesNow(toUpdate);
				toUpdate.clear();
			}

			// update number of lines
			ContentView.this.numberOfLines.set(getContent().getLineCount());


			getLineLayer().requestLayout();
		}
	};

//	Timer t = new Timer();
//	volatile boolean scheduled = false;
//	private void scheduleUpdate() {
//		if (true) return;
//
//		try {
//			if (!scheduled) {
//				scheduled = true;
//				t.schedule(new TimerTask() {
//					@Override
//					public void run() {
//						Platform.runLater(()->doUpdate());
//						scheduled = false;
//					}
//				}, 16);
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	private void onLineChange(Observable o) {
		RangeSet<Integer> toUpdate = TreeRangeSet.create();
		RangeSet<Integer> toRelease = TreeRangeSet.create();

		double offsetY = offsetYProperty().get();
		com.google.common.collect.Range<Integer> visibleLines = visibleLinesProperty().get();
		ContiguousSet<Integer> set = ContiguousSet.create(visibleLines, DiscreteDomain.integers());
		double lineHeight = lineHeightProperty().get();

//		System.err.println("onLineChange " + offsetY + " " + visibleLines);


		// schedule visible line updates
		if (curVisibleLines == null) {
			toUpdate.add(visibleLines);
		}
		else {
			RangeSet<Integer> hiddenLines = TreeRangeSet.create();
			hiddenLines.add(curVisibleLines);
			hiddenLines.remove(visibleLines);

			RangeSet<Integer> shownLines = TreeRangeSet.create();
			shownLines.add(visibleLines);
			shownLines.remove(curVisibleLines);

			toUpdate.addAll(shownLines);
			toRelease.addAll(hiddenLines);
		}
		this.curVisibleLines = visibleLines;

		// store precomputed y data
		for (int index : set) {
			double y = index * lineHeight - offsetY;
			yOffsetData.put(index, y);
			forceLayout = true;
		}

		releaseNodesNow(toRelease);
		updateNodesNow(toUpdate);

		lineLayer.requestLayout();
//		scheduleUpdate();
	}

	private double computeLongestLine() {
		if(debugOut) System.err.println("compute longest line til " + getNumberOfLines());
		if(debugOut) System.err.println(" while content has " + content.get().getLineCount());
		Optional<Integer> longestLine = IntStream.range(0, getNumberOfLines()).mapToObj(index->lineHelper.getLengthCountTabsAsChars(index)).collect(Collectors.maxBy(Integer::compare));
//		Optional<Integer> longestLine = model.stream().map(m->m.getLineLength() + countTabs(m.getText()) * 3).collect(Collectors.maxBy(Integer::compare));
		longestLine = longestLine.map(s->s+2); // extra space
		Optional<Double> longestLineWidth = longestLine.map(i->i*getCharWidth());
		longestLineWidth = longestLineWidth.map(l->Math.max(l, getWidth()));
		return longestLineWidth.orElse(getWidth());
	}

	private Font lastFont;
	private double lastWidth = 8d;

	private double getCharWidth() {
		if( lastFont != area.getFont() ) {
			lastFont = area.getFont();
			lastWidth = Math.ceil(Util.getTextWidth("M", lastFont));
		}
		return lastWidth;
	}

	@Override
	protected void layoutChildren() {
		double scrollX = -offsetX.get();
		this.contentBody.resizeRelocate(scrollX, 0, computeLongestLine(), getHeight());
	}


	private DoubleProperty offsetY = new SimpleDoubleProperty();
	private DoubleProperty offsetX = new SimpleDoubleProperty();

	public void bindHorizontalScrollbar(ScrollBar bar) {
		bar.setMin(0);
		DoubleBinding max = this.contentBody.widthProperty().subtract(widthProperty());
		DoubleBinding factor = this.contentBody.widthProperty().divide(max);
		bar.maxProperty().bind(contentBody.widthProperty().divide(factor));
		bar.visibleAmountProperty().bind(widthProperty().divide(factor));
		this.offsetX.bind(bar.valueProperty());
	}

	public DoubleProperty offsetYProperty() {
		return this.offsetY;
	}


//	private RangeSet<Integer> toRelease = TreeRangeSet.create();
//	private RangeSet<Integer> toUpdate = TreeRangeSet.create();


	private void updateNodesNow(com.google.common.collect.RangeSet<Integer> rs) {
		if(debugOut) System.err.println("updateNodesNow nr of lines = " + getNumberOfLines());
		RangeSet<Integer> subRangeSet = rs.subRangeSet(getVisibleLines()).subRangeSet(Range.closedOpen(0, getNumberOfLines()));
		if(debugOut) System.err.println("updateNodesNow: " + subRangeSet);
		subRangeSet.asRanges().forEach(r-> {
			ContiguousSet.create(r, DiscreteDomain.integers()).forEach(index-> {
				getLineLayer().updateNode(index);
//				StyledTextLine m = this.model.get(index);
//				lineLayer.updateNode(m);
			});
		});
	}

	private void releaseNodesNow(com.google.common.collect.RangeSet<Integer> rs) {
		RangeSet<Integer> subRangeSet = rs.subRangeSet(Range.closedOpen(0, getNumberOfLines()));
//		System.err.println("releaseNodesNow " + subRangeSet);
		if (debugOut) System.err.println("releasing " + rs);
		subRangeSet.asRanges().forEach(r-> {
			ContiguousSet.create(r, DiscreteDomain.integers()).forEach(index-> {
				getLineLayer().releaseNode(index);
//				StyledTextLine m = this.model.get(index);
//				System.err.println("RELEASE " + m);
//				lineLayer.releaseNode(m);
			});
		});
	}

//	private void updateNodes(com.google.common.collect.Range<Integer> range) {
//		if (debugOut) System.err.println("updateNodes(" + range + ")");
//		toUpdate.add(range);
//		scheduleUpdate();
////
////		if (range.intersects(getVisibleLines())) {
////			Range intersection = range.intersect(getVisibleLines());
////			for (int index = intersection.getOffset(); index <intersection.getEndOffset(); index++) {
////				toUpdate.add(index);
//////				StyledTextLine m = this.model.get(index);
//////				prepareNode(index, m);
////			}
////		}
//	}

//	private boolean doUpdate() {
//		try {
//			long now = -System.nanoTime();
//			if (!toRelease.isEmpty()) {
//				toRelease.asRanges().forEach(r-> {
//					ContiguousSet.create(r, DiscreteDomain.integers()).forEach(this.lineLayer::releaseNode);
//				});
//				toRelease.clear();
//			}
//
//			if (!toUpdate.isEmpty()) {
//				toUpdate.subRangeSet(getVisibleLines()).subRangeSet(Range.closedOpen(0, this.model.size())).asRanges().forEach(r-> {
//					ContiguousSet.create(r, DiscreteDomain.integers()).forEach(index-> {
//						StyledTextLine m = this.model.get(index);
//						lineLayer.updateNode(index, m);
//					});
//				});
//				toUpdate.clear();
//			}
//
//
//			now += System.nanoTime();
//
//			if (now > 1000_000 * 5) {
//				System.err.println("update needed " + (now/1000000) + "ms");
//			}
//
//			if (!toRelease.isEmpty() || !toUpdate.isEmpty() || forceLayout) {
////				System.err.println("releasing " + toRelease + " and updating " + toUpdate + " lines");
//
//			    lineLayer.requestLayout();
//
//				forceLayout = false;
//
//				return true;
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//
//	}
//
//	private void updatePulse(long now) {
//		doUpdate();
//	}


	public Optional<Point2D> getLocationInScene(int globalOffset) {
		int lineIndex = getContent().getLineAtOffset(globalOffset);
		Optional<LineNode> node = lineLayer.getVisibleNode(lineIndex);

		return node.map(n->{
			double x = n.getCharLocation(globalOffset - n.getStartOffset());
			Point2D p = new Point2D(x, 0);
			return n.localToScene(p);
		});
	}

	public Optional<Integer> getLineIndex(Point2D point) {
		// transform point to respect horizontal scrolling
		point = this.lineLayer.sceneToLocal(this.localToScene(point));
		Optional<Integer> result =  this.lineLayer.getLineIndex(point);
		return result;

	}
	public void updateAnnotations(RangeSet<Integer> r) {
		updateNodesNow(r);
	}

}
