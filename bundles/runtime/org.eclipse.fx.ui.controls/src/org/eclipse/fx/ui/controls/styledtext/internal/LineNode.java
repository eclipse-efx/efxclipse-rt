package org.eclipse.fx.ui.controls.styledtext.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.fx.ui.controls.styledtext.NodeCachePane;
import org.eclipse.fx.ui.controls.styledtext.ReuseCache;
import org.eclipse.fx.ui.controls.styledtext.model.TextAnnotation;
import org.eclipse.fx.ui.controls.styledtext.model.TextAnnotationPresenter;

import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class LineNode extends StackPane {

	int leftPadding = 0;

	private static boolean debugAnimation = Boolean.getBoolean("styledtext.debuganimation");
	private static boolean debugOut = Boolean.getBoolean("styledtext.debugout");

	private DebugMarker debugUpdateText;
	private DebugMarker debugUpdateAnnotations;
	private DebugMarker debugUpdateSelection;
	private DebugMarker debugUpdateCaret;
	private HBox debugBox;

	private int index;
	private LineHelper lineHelper;


	private int getLineIndex() {
		return index;
	}

	private static TextNode createNode() {
		TextNode textNode = new TextNode("");
		return textNode;
	}

	public class TextLayer extends HBox {

		protected final ReuseCache<TextNode> cache;

		public TextLayer() {
			getStyleClass().add("source-segment-container");
//			setCache(true);
//			setCacheHint(CacheHint.QUALITY);
			setMinWidth(HBox.USE_COMPUTED_SIZE);

			cache = new ReuseCache<>(LineNode::createNode);
			cache.addOnActivate(node->{
				getChildren().add(node);
//				if (!getChildren().contains(node)) {
//					getChildren().add(node);
//				}
//				node.setVisible(true);
//				node.setManaged(true);
			});
			cache.addOnRelease(node->{
				getChildren().remove(node);
//				node.setVisible(false);
//				node.setManaged(false);
			});
//			cache.addOnClear(node->getChildren().remove(node));
		}

		private List<Segment> currentContent = new ArrayList<>();
		private List<TextNode> currentTextNodes = new ArrayList<>();

		public boolean updateContent(List<Segment> content) {
			if (currentContent.equals(content)) {
				return false;
			}
			if (debugOut) System.err.println("update " + getLineIndex() + ": TextLayer");

			for (TextNode c : currentTextNodes) {
				cache.releaseElement(c);
			}
			currentTextNodes.clear();

			for (Segment segment : content) {
				TextNode node = cache.getElement();
				node.updateText(segment.text);
				node.getStyleClass().setAll(segment.styleClasses);
				currentTextNodes.add(node);
			}

			if (content.isEmpty()) {
				TextNode node = cache.getElement();
				node.updateText("");
				currentTextNodes.add(node);
			}

			currentContent = content;

//			applyCss();
//			layout();
			return true;
		}

		public int getCaretIndexAtPoint(Point2D point) {
			Point2D scenePoint = localToScene(point);
			int offset = 0;
			for (TextNode t : this.currentTextNodes) {
				if (t.localToScene(t.getBoundsInLocal()).contains(scenePoint)) {
					int idx = t.getCaretIndexAtPoint(t.sceneToLocal(scenePoint));
					if( idx != -1 ) {
//						System.err.println("returning " + idx + " + " + offset);
						int result = idx + offset;
//						System.err.println("==> (LineNode)" + result);
						return result;
					}
				}
				offset += t.getText().length();
			}

			return -1;
		}

		public double getCharLocation(int charOffset) {
			double result = 0;

			int startOffset = 0;
			for (TextNode t : this.currentTextNodes) {
				int len = t.getText().length();

				if (charOffset >= startOffset && charOffset <= startOffset + len) {
					// hit
					int textNodeOffset = charOffset - startOffset;
					result = t.getCharLocation(textNodeOffset);
					break;
				}
				else if (charOffset > startOffset + len) {
					result = t.getLayoutX() + t.getWidth();
				}
				startOffset += len;
			}
			return result;


//			double location = 0;
//			int offset = 0;
//			for (TextNode t : this.currentTextNodes) {
//				int length = t.getText().length();
//				int endOffset = offset + length;
//
//				if (offset <= charOffset && charOffset <= endOffset ) {
//					int localCharOffset = charOffset - offset;
//					location = t.getLayoutX() + t.getCharLocation(localCharOffset);
//					break;
//				}
//				else if (charOffset > endOffset) {
//					location = t.getLayoutX() + t.getWidth();
//				}
//				offset += length;
//			}
//			System.err.println("getCharLocation(" + charOffset + ") -> " + location);
//			return location;
		}

		@Override
		protected void layoutChildren() {
			super.layoutChildren();
			if (debugOut) System.err.println("layout Line "+getLineIndex()+": TextLayer");
		}

		protected String getText() {
			StringBuilder b = new StringBuilder();
			for (TextNode t : this.currentTextNodes) {
				b.append(t.getText());
			}
			return b.toString();
		}

	}

	public class SelectionLayer extends Region {
		private Region selectionMarker = new Region();

		private com.google.common.collect.Range<Integer> selection;
		private boolean continues;

		public SelectionLayer() {
			this.selectionMarker.getStyleClass().add("selection-marker");
			this.selectionMarker.setManaged(false);

			this.getChildren().setAll(this.selectionMarker);
		}

		private boolean isSelectionChange(com.google.common.collect.Range<Integer> localSelection) {
//			System.err.println("change? " + localSelection + " vs " + selection);
			if (localSelection == null && this.selection == null) {
				return false;
			}
			return this.selection == null || !this.selection.equals(localSelection);
		}

		public void updateSelection(com.google.common.collect.Range<Integer> localSelection, boolean continues) {
			this.continues = continues;
			if (isSelectionChange(localSelection)) {
				System.err.println("updating selection for " + index);
				if (localSelection == null) {
					this.selectionMarker.setVisible(false);
				}
				else {
					this.selectionMarker.setVisible(true);
				}

				this.selection = localSelection;
				requestLayout();
				if (debugAnimation) {
					debugUpdateSelection.play();
				}
			}
		}

		@Override
		protected void layoutChildren() {
			//if (model == null) return;

			if (selection != null) {
				textLayer.layout();

				double begin = textLayer.getCharLocation(selection.lowerEndpoint());
				double end = textLayer.getCharLocation(selection.upperEndpoint());
				System.err.println(selection);
				if (selection.upperEndpoint() == lineHelper.getLength(index) && continues) {
					end = getWidth();
				}


				if (debugOut) System.err.println("layout Line "+getLineIndex()+": SelectionLayer");
	//			System.err.println("SelectionLayer: layoutChildren()");
	//			System.err.println(" setting selection to " + begin + " - " + end);
				this.selectionMarker.resizeRelocate(begin, 0, end - begin, getHeight());
			}
		}
	}

	private static Animation createCaretAnimation(Node caret) {
//		Timeline t = new Timeline(
//				new KeyFrame(Duration.millis(200), new KeyValue(caret.opacityProperty(), 1, Interpolator.DISCRETE)),
//				new KeyFrame(Duration.millis(200), new KeyValue(caret.opacityProperty(), 0))
//		);
//		t.setCycleCount(Animation.INDEFINITE);
//		return t;

		FadeTransition t = new FadeTransition(Duration.millis(200), caret);
		t.setInterpolator(new Interpolator() {
			@Override
			protected double curve(double t) {
				if (t < 0.5) {
					return 0;
				}
				else {
					return 1;
				}
			}
		});
		t.setAutoReverse(true);
		t.setFromValue(1);
		t.setToValue(0);
		t.setCycleCount(Animation.INDEFINITE);

		return t;
	}

	public class CaretLayer extends Region {
		private int caretIndex = -1;

		private Line caret = new Line();

		private Animation caretAnimation;

		public CaretLayer() {
			this.caret.setVisible(false);
			this.caret.setStrokeWidth(2);
			this.caret.getStyleClass().add("text-caret"); //$NON-NLS-1$
			this.caret.setVisible(false);
			this.getChildren().add(this.caret);

			this.caretAnimation = createCaretAnimation(this.caret);

			this.caret.visibleProperty().addListener((x, o, n)->{
				if (n) {
					if (this.caretAnimation.getStatus() != Status.RUNNING) {
						this.caretAnimation.playFromStart();
					}
				}
				else {
					this.caretAnimation.stop();
				}
			});
		}

		private void hideCaret() {
			this.caret.setVisible(false);
		}

		private void showCaret() {
			this.caret.setVisible(true);
		}

		public void updateCaret(int index) {
			if (index != this.caretIndex) {
				if (index == -1) {
					hideCaret();
				}
				else {
					showCaret();
				}

				this.caretIndex = index;
				requestLayout();
				if (debugAnimation) {
					debugUpdateCaret.play();
				}
			}
		}

		public void layoutChildren() {
			double caretOffset = getCharLocation(caretIndex);
			if (debugOut) System.err.println("layout Line "+getLineIndex()+": CaretLayer caretIndex=" + caretIndex + " = " + caretOffset);
			this.caret.setStartX(caretOffset);
			this.caret.setEndX(caretOffset);
			this.caret.setStartY(0);
			this.caret.setEndY(getHeight());
			this.caret.toFront();
		}
	}

	public class AnnotationLayer extends StackPane {

		private Set<TextAnnotation> currentAnnotations;
		private Set<TextAnnotationPresenter> currentPresenters;

		public AnnotationLayer() {
			//setStyle("-fx-border-color: red; -fx-border-style: dashed; -fx-border-width: 1;");


//			setCache(true);
//			setCacheHint(CacheHint.SPEED);

		}

		private class AnnotationOverlay extends NodeCachePane {
			private TextAnnotationPresenter presenter;

			public AnnotationOverlay(TextAnnotationPresenter presenter) {
				super(presenter::createNode);
				this.presenter = presenter;

//				setStyle("-fx-border-color: red; -fx-border-style: dashed; -fx-border-width: 1;");
//				setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
//				setBorder(new Border(new BorderStroke(Color.CADETBLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
				setOpacity(0.5);

//				setPrefHeight(10);
//				cache.addOnActivate(node->node.setManaged(false));


			}

			private Map<TextAnnotation, Node> usedNodes = new HashMap<>();

			private Node getNode(TextAnnotation a) {
				Node node = this.usedNodes.get(a);
				if (node == null) {
					node = getNode();
					this.usedNodes.put(a, node);
				}
				return node;
			}

			private Set<TextAnnotation> current = new HashSet<>();

			public void prepareNodes(Set<TextAnnotation> annotations) {
				boolean same = current.equals(annotations);
				if(ContentView.debugOut) System.err.println("annotation check: " + current +"\n"
								+  "          versus: " + annotations + "\n"
								+  "               -> " + same);

				if (same) {
					return;
				}

				current = annotations;

				// release invisible nodes
				int released = 0;
				Iterator<Entry<TextAnnotation, Node>> iterator = this.usedNodes.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<TextAnnotation, Node> entry = iterator.next();
					if (!annotations.contains(entry.getKey())) {
						releaseNode(entry.getValue());
						iterator.remove();
						released ++;
					}
					else if (!presenter.isVisible(entry.getKey())) {
						releaseNode(entry.getValue());
						iterator.remove();
						released++;
					}
				}

				// release non used nodes
//				HashSet<Node> all = new HashSet<>(getChildren());
//				all.removeAll(usedNodes.values());
//				System.err.println("FORCE RELEASE OF " + all);
//				all.forEach(this::releaseNode);

				int presented = 0;
				// prepare  nodes
				for (TextAnnotation a : annotations) {
					Node n = getNode(a);
					this.presenter.updateNode(n, a);
					presented ++;
				}
//				iterator = this.usedNodes.entrySet().iterator();
//				while (iterator.hasNext()) {
//					Entry<TextAnnotation, Node> entry = iterator.next();
//					presenter.updateNode(entry.getValue(), entry.getKey());
//					presented ++;
//				}

				if (debugOut) System.err.println("update "+getLineIndex()+": AnnotationOverlay: released " + released + " and presented " + presented + " annotation nodes");
				if (debugOut) System.err.println("update "+getLineIndex()+": AnnotationOverlay: active " + annotations);
			}

			@Override
			protected void layoutChildren() {
				if (debugOut) System.err.println("layout Line "+getLineIndex()+": AnnotationLayer -> AnnotationOverlay");
				Iterator<Entry<TextAnnotation, Node>> iterator = this.usedNodes.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<TextAnnotation, Node> entry = iterator.next();
					com.google.common.collect.Range<Integer> range = entry.getKey().getRange();
					double x = getCharLocation(range.lowerEndpoint());
					double width = getCharLocation(range.upperEndpoint()) -x;
					if (debugOut) System.err.println("layout " + entry.getKey() + "-> " + x + " " + width);
					entry.getValue().resizeRelocate(x, 0, width, getHeight());
				}
			}

		}

		Map<TextAnnotationPresenter, AnnotationOverlay> overlays = new HashMap<>();

		public void updateAnnoations(Set<TextAnnotation> annotations, Set<TextAnnotationPresenter> presenters) {
			if (currentAnnotations != null && currentAnnotations.equals(annotations) &&
					currentPresenters != null && currentPresenters.equals(presenters)) {
				// nothing to updated

				return;
			}

			if (debugOut) System.err.println("ANNOTATIONS: " + annotations);
			if (debugOut) System.err.println("update " + getLineIndex() + ": AnnotationLayer " + annotations.size() + " / " + presenters.size());
			Iterator<Entry<TextAnnotationPresenter, AnnotationOverlay>> iterator = overlays.entrySet().iterator();
			// cleanup presenters
			while (iterator.hasNext()) {
				Entry<TextAnnotationPresenter, AnnotationOverlay> entry = iterator.next();
				if (!presenters.contains(entry.getKey())) {
					getChildren().remove(entry.getValue());
					iterator.remove();
				}
			}
			// update presenters
			for (TextAnnotationPresenter presenter : presenters) {
				Set<TextAnnotation> applicableAnnotations = annotations.stream().filter(presenter::isApplicable).collect(Collectors.toSet());
				AnnotationOverlay overlay = this.overlays.get(presenter);
				if (overlay == null) {
					overlay = new AnnotationOverlay(presenter);
					getChildren().add(overlay);
					this.overlays.put(presenter, overlay);
				}
				overlay.prepareNodes(applicableAnnotations);
				overlay.requestLayout();
			}

			if (debugOut) System.err.println("update Line " + getLineIndex() + getChildren());
			requestLayout();

			if (debugAnimation) {
				debugUpdateAnnotations.play();
			}

			currentAnnotations = annotations;
			currentPresenters = presenters;
		}


		@Override
		protected void layoutChildren() {
			super.layoutChildren();
			if (debugOut) System.err.println("layout Line " + getLineIndex() + ": AnnotationLayer ");
		}

	}

	private TextLayer textLayer = new TextLayer();
	private SelectionLayer selectionLayer = new SelectionLayer();
	private CaretLayer caretLayer = new CaretLayer();
	private AnnotationLayer annotationLayer = new AnnotationLayer();


	public LineNode() {
//		this.model = model;
		getStyleClass().add("styled-text-line");

		setPadding(new Insets(0, 0, 0, leftPadding));


//		setStyle("-fx-border-width: 0.1px; -fx-border-color: red");

		getChildren().setAll(this.selectionLayer, this.textLayer, this.caretLayer, this.annotationLayer);

		if (debugAnimation) {
			this.debugUpdateAnnotations = new DebugMarker(Color.RED, 400);
			this.debugUpdateText = new DebugMarker(Color.AQUAMARINE, 300);
			this.debugUpdateSelection = new DebugMarker(Color.BLUE, 150);
			this.debugUpdateCaret = new DebugMarker(Color.GRAY, 150);

			this.debugUpdateAnnotations.setWidth(10);
			this.debugUpdateText.setWidth(10);
			this.debugUpdateSelection.setWidth(10);
			this.debugUpdateCaret.setWidth(10);

			this.debugBox = new HBox();
			this.debugBox.setManaged(false);
			this.debugBox.getChildren().addAll(this.debugUpdateAnnotations, this.debugUpdateSelection, this.debugUpdateCaret, this.debugUpdateText);

			this.getChildren().add(debugBox);
		}

	}

	@Override
	protected void layoutChildren() {
		if (debugOut) System.err.println("layout Line " + index);
		super.layoutChildren();
		if (debugAnimation) {
			debugBox.resizeRelocate(0, 0, 40, getHeight());
			debugUpdateAnnotations.resize(getHeight(), getHeight());
			debugUpdateText.resize(getHeight(), getHeight());
			debugUpdateSelection.resize(getHeight(), getHeight());
			debugUpdateCaret.resize(getHeight(), getHeight());
//			debugUpdateAnnotations.resizeRelocate(0, 0, getWidth(), getHeight());
//			debugUpdateText.resizeRelocate(0, 0, getWidth(), getHeight());
//			debugUpdateSelection.resizeRelocate(0, 0, getWidth(), getHeight());
//			debugUpdateCaret.resizeRelocate(0, 0, getWidth(), getHeight());
		}

	}

	public void setLineHelper(LineHelper helper) {
		this.lineHelper = helper;
	}

	public void update(Set<TextAnnotationPresenter> presenters) {
		requestLayout();
		updateContent(lineHelper.getSegments(index));
		updateSelection(lineHelper.getSelection(index), lineHelper.isValidLineIndex(index+1) ? lineHelper.getSelection(index+1) : null  );
		updateCaret(lineHelper.getCaret(index));
		updateAnnotations(lineHelper.getTextAnnotations(index), presenters);
	}


//	public void update(StyledTextLine model, Set<TextAnnotationPresenter> annotationPresenter) {
////		System.err.println("update " + model.getLineIndex());
//
//		this.model = model;
//
//		updateContent(model.getSegments());
//		updateSelection(model.getSelectionRange());
//		updateCaret(model.getCaretIndex());
//
//		Set<TextAnnotation> textAnnotations = model.getAnnotations().stream().filter(m->m instanceof TextAnnotation).map(m->(TextAnnotation)m).collect(Collectors.toSet());
//		this.annotationLayer.updateAnnoations(textAnnotations, annotationPresenter);
//	}

	public void updateSelection(com.google.common.collect.Range<Integer> lineSelection, com.google.common.collect.Range<Integer> nextLine) {
//		System.err.println("LineNode: updateSelection " + lineSelection);

		if (lineSelection != null && lineSelection.isEmpty()) {
			this.selectionLayer.updateSelection(null, false);
		}
		else {
			this.selectionLayer.updateSelection(lineSelection, nextLine != null);
		}
	}

	boolean currentLine = false;

	public void updateCaret(int caret) {
		this.caretLayer.updateCaret(caret);

		updateCurrentLine(caret != -1);
	}

	public void updateCurrentLine(boolean current) {
		if (this.currentLine != current) {

			if (current) {
				getStyleClass().add("current-line");
			}
			else {
				getStyleClass().remove("current-line");
			}

			this.currentLine = current;
			requestLayout();
		}
	}

	public void updateContent(List<Segment> content) {
		boolean updated = this.textLayer.updateContent(content);
		if (updated) {
			if (debugAnimation) {
				debugUpdateText.play();
			}
		}
	}

	public void updateAnnotations(Set<TextAnnotation> annotations, Set<TextAnnotationPresenter> presenters) {
		this.annotationLayer.updateAnnoations(annotations, presenters);
	}


	public int getCaretIndexAtPoint(Point2D p) {
		return textLayer.getCaretIndexAtPoint(p);
	}

	public int getStartOffset() {
		return lineHelper.getOffset(index);
	}

	public int getEndOffset() {
		return lineHelper.getOffset(index) + lineHelper.getLength(index);
	}

	public double getCharLocation(int charOffset) {
		return this.textLayer.getCharLocation(charOffset);
	}

	/**
	 * Check if the offset is between the start and end
	 *
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @return <code>true</code> if intersects the offset
	 */
//	public boolean intersectOffset(int start, int end) {
//		if (getStartOffset() > end) {
//			return false;
//		} else if (getEndOffset() < start) {
//			return false;
//		}
//		return true;
//	}
//
//	public boolean intersects(Range globalRange) {
//		return intersectOffset(globalRange.getOffset(), globalRange.getEndOffset());
//	}
//
//	public Range computeLineLocalIntersection(Range globalRange) {
//		Range result;
//		if (intersects(globalRange)) {
//			int begin = Math.max(0, globalRange.getOffset() - getStartOffset());
//			int end = Math.min(getEndOffset(), globalRange.getEndOffset() - getStartOffset());
//			result = new Range(begin, end - begin);
//		}
//		else {
//			result = new Range(0, 0);
//		}
//		System.err.println("Line local intersection " + this + ": " + globalRange + " -> " + result);
//		return result;
//	}

	@Override
	public String toString() {
		return "LineNode(idx: "+getLineIndex() + ")@" + hashCode();
	}


	public int getLineLength() {
		return lineHelper.getLength(index);
	}

	public void release() {
		this.index = -1;
		this.caretLayer.hideCaret();
		this.selectionLayer.selection = null;
		this.selectionLayer.selectionMarker.resize(0, 0);
	}

	public void setIndex(int idx) {
//		System.err.println("LineNode#setIndex " + index + " -> " + idx);
		this.index = idx;
	}

}
