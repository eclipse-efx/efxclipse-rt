/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christoph Caks <ccaks@bestsolution.at> - improved editor behavior
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.skin;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea.LineLocation;
import org.eclipse.fx.ui.controls.styledtext.StyledTextContent.TextChangeListener;
import org.eclipse.fx.ui.controls.styledtext.TextChangedEvent;
import org.eclipse.fx.ui.controls.styledtext.TextChangingEvent;
import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.fx.ui.controls.styledtext.behavior.StyledTextBehavior;
import org.eclipse.fx.ui.controls.styledtext.internal.ContentView;
import org.eclipse.fx.ui.controls.styledtext.internal.FXBindUtil;
import org.eclipse.fx.ui.controls.styledtext.internal.LineHelper;
import org.eclipse.fx.ui.controls.styledtext.internal.LineRuler;
import org.eclipse.fx.ui.controls.styledtext.internal.ScrollbarPane;
import org.eclipse.fx.ui.controls.styledtext.internal.Scroller;
import org.eclipse.fx.ui.controls.styledtext.internal.TextNode;
import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.fx.ui.controls.styledtext.model.AnnotationPresenter;
import org.eclipse.fx.ui.controls.styledtext.model.AnnotationProvider;
import org.eclipse.fx.ui.controls.styledtext.model.LineRulerAnnotationPresenter;
import org.eclipse.fx.ui.controls.styledtext.model.TextAnnotationPresenter;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

/**
 * Styled text skin
 */
public class StyledTextSkin extends SkinBase<StyledTextArea> {

	private ScrollbarPane<ContentView> contentArea;
	private ContentView content;

	Scroller scroller;

	private HBox lineRulerArea;

	// private ObservableList<VerticalLineFlow<Integer, Annotation>>
	// sortedLineRulerFlows;

	private ObservableList<LineRuler> sortedLineRulerFlows;

	private HBox rootContainer;

	private final StyledTextBehavior behavior;

	private LineHelper lineHelper;

	private static final String CSS_CLASS_LINE_RULER_AREA = "line-ruler-area"; //$NON-NLS-1$
	private static final String CSS_CLASS_LINE_RULER = "line-ruler"; //$NON-NLS-1$
	private static final String CSS_CLASS_SPACER = "spacer"; //$NON-NLS-1$
	private static final String CSS_LIST_VIEW = "list-view"; //$NON-NLS-1$
	private SortedList<LineRulerAnnotationPresenter> sortedLineRulerPresenters;

	/**
	 * Create a new skin
	 *
	 * @param styledText
	 *            the control
	 */
	public StyledTextSkin(StyledTextArea styledText) {
		this(styledText, new StyledTextBehavior(styledText));
	}

	/**
	 * Create a new skin
	 *
	 * @param styledText
	 *            the styled text
	 * @param behavior
	 *            the behavior
	 */
	public StyledTextSkin(StyledTextArea styledText, StyledTextBehavior behavior) {
		super(styledText);
		this.behavior = behavior;
		this.rootContainer = new HBox();
		this.rootContainer.addEventHandler(ContextMenuEvent.CONTEXT_MENU_REQUESTED, e -> {
			e.consume();
		});

		this.rootContainer.setSpacing(0);

		this.lineRulerArea = new HBox();
		this.lineRulerArea.getStyleClass().setAll(CSS_CLASS_LINE_RULER_AREA);
		// Align with ContentView insets!
		this.lineRulerArea.setPadding(new Insets(0,0,0,0));
		this.rootContainer.getChildren().add(this.lineRulerArea);
		styledText.caretOffsetProperty().addListener((obs, ol, ne) -> {
			int lineIdx = styledText.getContent().getLineAtOffset(ne.intValue());
			int colIdx = ne.intValue() - styledText.getContent().getOffsetAtLine(lineIdx);

			// fix colIdx with tabs
			String line = styledText.getContent().getLine(lineIdx).substring(0, colIdx);
			int tabCount = (int)line.chars().filter(c -> c == '\t').count();
			scrollColumnIntoView(colIdx + tabCount * (styledText.tabAvanceProperty().get() - 1), 12);
			scrollLineIntoView(lineIdx);
		});

		Region spacer = new Region();
		spacer.getStyleClass().addAll(CSS_CLASS_SPACER);
		spacer.setMinWidth(2);
		spacer.setMaxWidth(2);
		this.rootContainer.getChildren().add(spacer);

		this.lineHelper = new LineHelper(getSkinnable());
		this.content = new ContentView(this.lineHelper, styledText);
		this.content.lineHeightProperty().bind(styledText.fixedLineHeightProperty());

		final DoubleBinding origFontSize = new DoubleBinding() {
			{
				bind(getSkinnable().fontProperty());
			}
			@Override
			protected double computeValue() {
				Font original = getSkinnable().fontProperty().get();
				if (original == null) {
					return 12;
				}
				return original.getSize();
			}
		};
		final DoubleBinding zoomedFontSize = origFontSize.multiply(getSkinnable().fontZoomFactorProperty());
		final StringExpression zoomedFontStyle = Bindings.concat("-fx-font-size: ", zoomedFontSize, ";");  //$NON-NLS-1$//$NON-NLS-2$

		this.content.styleProperty().bind(zoomedFontStyle);
		this.lineRulerArea.styleProperty().bind(zoomedFontStyle);

		getSkinnable().fontZoomFactorProperty().addListener((x, o, n)->{
			this.sortedLineRulerFlows.forEach(LineRuler::requestLayout);
		});

		this.contentArea = new ScrollbarPane<>();

		this.contentArea.setCenter(this.content);

		Map<AnnotationProvider, Subscription> subscriptions = new HashMap<>();
		Consumer<RangeSet<Integer>> onAnnotationChange = r -> {
			this.content.updateAnnotations(r);
			this.sortedLineRulerFlows.forEach(f -> f.update(r));
		};

		getSkinnable().getAnnotationProvider().addListener((SetChangeListener<? super AnnotationProvider>) (c) -> {
			if (c.wasAdded()) {
				Subscription s = c.getElementAdded().registerChangeListener(onAnnotationChange);
				subscriptions.put(c.getElementAdded(), s);
			}
			if (c.wasRemoved()) {
				Subscription s = subscriptions.remove(c.getElementRemoved());
				if (s != null)
					s.dispose();
			}
		});
		for (AnnotationProvider p : getSkinnable().getAnnotationProvider()) {
			if (!subscriptions.containsKey(p)) {
				Subscription s = p.registerChangeListener(onAnnotationChange);
				subscriptions.put(p, s);
			}
		}

		this.content.getStyleClass().addAll(CSS_LIST_VIEW);
		this.content.addEventHandler(ContextMenuEvent.CONTEXT_MENU_REQUESTED, e -> {
			if( getSkinnable().getContextMenu() != null ) {
				getSkinnable().getContextMenu().show(this.content, e.getScreenX(), e.getScreenY());
			}
		});

		// focus delegation
		this.content.focusedProperty().addListener((x, o, n) -> {
			if (n != null && n.booleanValue()) {
				getSkinnable().requestFocus();
			}
		});

		getBehavior().installContentListeners(this.content);

		this.content.contentProperty().bind(getSkinnable().contentProperty());

		// scroll support
		this.content.setOnScroll((e) -> {
			if (e.getDeltaY() < 0) {
				this.scroller.scrollBy(1);
			}
			else {
				this.scroller.scrollBy(-1);
			}
		});

		// HBox.setHgrow(this.contentView, Priority.ALWAYS);

		HBox.setHgrow(this.contentArea, Priority.ALWAYS);
		this.rootContainer.getChildren().addAll(this.contentArea);
		getChildren().addAll(this.rootContainer);

		// scroll stuff
		this.scroller = new Scroller();
		this.scroller.contentAreaHeightProperty().bind(this.content.heightProperty());
		this.scroller.lineHeightProperty().bind(this.content.lineHeightProperty());

//		this.content.lineHeightProperty().set(16);
		this.content.bindHorizontalScrollbar(this.contentArea.horizontal);
		this.content.bindVerticalScrollbar(this.contentArea.vertical);

		// getSkinnable().lineCountProperty().addListener((x, o, n)-> {/* for
		// the quantum! */});
		((IntegerProperty) getSkinnable().lineCountProperty()).bind(this.content.numberOfLinesProperty());

		// content.numberOfLinesProperty().addListener((x, o, n)->
		// getSkinnable().lineCountProperty().addListener((x, o, n)->

		this.scroller.lineCountProperty().bind(this.content.numberOfLinesProperty());
		this.scroller.bind(this.contentArea.vertical);

		this.content.textSelectionProperty().bind(getSkinnable().selectionProperty());
		this.content.caretOffsetProperty().bind(getSkinnable().caretOffsetProperty());

		this.content.visibleLinesProperty().bind(this.scroller.visibleLinesProperty());

//		Consumer<Double> updateOffset = (offset) -> {
//			com.google.common.collect.Range<Integer> visibleLines = this.scroller.visibleLinesProperty().get();
//			ContiguousSet<Integer> set = ContiguousSet.create(visibleLines, DiscreteDomain.integers());
//			double lineHeight = this.scroller.lineHeightProperty().get();
//			for (int index : set) {
//
//				double y = index * lineHeight - offset.doubleValue();
//
//				for (VerticalLineFlow<Integer, Annotation> flow : this.sortedLineRulerFlows) {
//					flow.setLineOffset(index, y);
//				}
//			}
//		};

		this.content.offsetYProperty().bind(this.scroller.offsetProperty());

//		this.scroller.offsetProperty().addListener((x, o, offset) -> {
//			updateOffset.accept(Double.valueOf(offset.doubleValue()));
//		});

//		this.scroller.visibleLinesProperty().addListener(x -> {
//			updateOffset.accept(Double.valueOf(this.scroller.offsetProperty().get()));
//		});

		getSkinnable().getContent().addTextChangeListener(new TextChangeListener() {

			@Override
			public void textSet(TextChangedEvent event) {
				StyledTextSkin.this.scroller.refresh();
			}

			@Override
			public void textChanging(TextChangingEvent event) {
				// nothing todo
			}

			@Override
			public void textChanged(TextChangedEvent event) {
				// nothing todo
			}
		});



		ObservableList<LineRulerAnnotationPresenter> lineRulerPresenters = FXCollections.observableArrayList();

		this.sortedLineRulerPresenters = new SortedList<>(lineRulerPresenters, (a, b) -> a.getOrder() - b.getOrder());

		Function<LineRulerAnnotationPresenter, LineRuler> map = (ap) -> {
			// initialize LineRuler

			Function<Integer, Set<Annotation>> converter = (index) -> this.lineHelper.getAnnotations(index.intValue()).stream().filter(ap::isApplicable).collect(Collectors.toSet());

			Predicate<Set<Annotation>> needsPresentation = ap::isVisible;
			Supplier<Node> nodeFactory = ap::createNode;
			BiConsumer<Node, Set<Annotation>> populator = ap::updateNode;

			LineRuler flow = new LineRuler(ap.getLayoutHint(), converter, needsPresentation, nodeFactory, populator);

			flow.getStyleClass().setAll(CSS_CLASS_LINE_RULER);
			// add the styleclass from the provider
			ap.getStyleClass().ifPresent(flow.getStyleClass()::add);

			// VerticalLineFlow<Integer, Annotation> flow = new
			// VerticalLineFlow<Integer, Annotation>(converter,
			// needsPresentation, nodeFactory, populator);

			flow.visibleLinesProperty().bind(this.scroller.visibleLinesProperty());
			flow.numberOfLinesProperty().bind(this.content.numberOfLinesProperty());
			flow.lineHeightProperty().bind(this.content.lineHeightProperty());
			flow.yOffsetProperty().bind(this.scroller.offsetProperty());

			// flow.getModel().bindContent(this.getModel());

			flow.fixedWidthProperty().bind(ap.getWidth());

			org.eclipse.fx.ui.controls.styledtext.model.LineRulerAnnotationPresenter.LineRuler lr = new LineRulerAnnotationPresenter.LineRuler() {
				@Override
				public Subscription subscribeMouseReleased(BiConsumer<Integer, MouseEvent> callback) {
					EventHandler<MouseEvent> handler = e-> {
						callback.accept(flow.findLineIndex(new Point2D(e.getX(), e.getY())), e);
					};
					flow.addEventHandler(MouseEvent.MOUSE_RELEASED, handler);
					return () -> flow.removeEventHandler(MouseEvent.MOUSE_RELEASED, handler);
				}

				@Override
				public Subscription subscribeMousePressed(BiConsumer<Integer, MouseEvent> callback) {
					EventHandler<MouseEvent> handler = e-> {
						callback.accept(flow.findLineIndex(new Point2D(e.getX(), e.getY())), e);
					};
					flow.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
					return () -> flow.removeEventHandler(MouseEvent.MOUSE_PRESSED, handler);
				}

				@Override
				public Subscription subscribeMouseClicked(BiConsumer<Integer, MouseEvent> callback) {
					EventHandler<MouseEvent> handler = e-> {
						callback.accept(flow.findLineIndex(new Point2D(e.getX(), e.getY())), e);
					};
					flow.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
					return () -> flow.removeEventHandler(MouseEvent.MOUSE_CLICKED, handler);
				}
			};

			ap.initialize(lr);


			return flow;
		};

		this.sortedLineRulerFlows = FXCollections.observableArrayList();
		FXBindUtil.uniMapBindList(this.sortedLineRulerPresenters, this.sortedLineRulerFlows, map);
		FXBindUtil.uniMapBindList(this.sortedLineRulerFlows, this.lineRulerArea.getChildren(), (flow) -> (Node) flow);
		this.sortedLineRulerFlows.addListener((ListChangeListener<? super LineRuler>) (c) -> {
			while (c.next()) {
				if (c.wasRemoved()) {
					c.getRemoved().forEach((f) -> {
						f.visibleLinesProperty().unbind();
						f.numberOfLinesProperty().unbind();
						f.yOffsetProperty().unbind();
						f.fixedWidthProperty().unbind();
					});
				}
			}
		});

		Consumer<AnnotationPresenter> installPresenter = (p) -> {
			if (p instanceof LineRulerAnnotationPresenter) {
				LineRulerAnnotationPresenter lrp = (LineRulerAnnotationPresenter) p;
				lineRulerPresenters.add(lrp);
				// installLineRulerAnnotationPresenter.accept(lrp);
			} else if (p instanceof TextAnnotationPresenter) {
				TextAnnotationPresenter tp = (TextAnnotationPresenter) p;
				this.content.textAnnotationPresenterProperty().add(tp);
			}
		};
		Consumer<AnnotationPresenter> uninstallPresenter = (p) -> {
			if (p instanceof LineRulerAnnotationPresenter) {
				LineRulerAnnotationPresenter lrp = (LineRulerAnnotationPresenter) p;
				lineRulerPresenters.remove(lrp);
			} else if (p instanceof TextAnnotationPresenter) {
				TextAnnotationPresenter tp = (TextAnnotationPresenter) p;
				this.content.textAnnotationPresenterProperty().remove(tp);
			}
		};

		getSkinnable().getAnnotationPresenter().addListener((SetChangeListener<? super AnnotationPresenter>) (c) -> {
			if (c.wasAdded()) {
				installPresenter.accept(c.getElementAdded());
			}
			if (c.wasRemoved()) {
				uninstallPresenter.accept(c.getElementRemoved());
			}

			// update all
			RangeSet<Integer> r = TreeRangeSet.<Integer>create().complement();
			this.content.updateAnnotations(r);
			this.sortedLineRulerFlows.forEach(f -> f.update(r));
			this.rootContainer.requestLayout();
		});
		getSkinnable().getAnnotationPresenter().forEach(installPresenter);


		Platform.runLater( () -> {
			scrollOffsetIntoView(getSkinnable().getCaretOffset(), 10, 12);
		});

		this.content.lineHeightProperty().bind(getSkinnable().fixedLineHeightProperty());

		this.content.setOnDragExited(e -> {
			if( getSkinnable().getEditable() ) {
				updateInsertionMarkerIndex(-1);
				e.consume();
			}
		});

		this.content.setOnDragOver(e -> {
			if( getSkinnable().getEditable() ) {
				Point2D coords = new Point2D(e.getX(), e.getY());
				Optional<Integer> lineIndex = this.content.getLineIndex(coords);

				if (lineIndex.isPresent()) {
					if (lineIndex.get() != -1) {
						Dragboard db = e.getDragboard();
						if (db.hasString()) {
							e.acceptTransferModes(TransferMode.COPY);
							updateInsertionMarkerIndex(lineIndex.get());
						}
					}
				}
				else {
					updateInsertionMarkerIndex(-1);
				}

				e.consume();
			}
		});

		this.content.setOnDragDropped(e -> {
			if( getSkinnable().getEditable() ) {
				if (e.getDragboard().hasContent(DataFormat.PLAIN_TEXT)) {

					String insert = e.getDragboard().getString();

					Point2D coords = new Point2D(e.getX(), e.getY());
					Optional<Integer> lineIndex = this.content.getLineIndex(coords);
					if (lineIndex.isPresent() && lineIndex.get() != -1) {
						getSkinnable().getContent().replaceTextRange(lineIndex.get(), 0, insert);
						getSkinnable().setCaretOffset(lineIndex.get() + insert.length());
						getSkinnable().setSelection(new TextSelection(lineIndex.get(), insert.length()));
						updateInsertionMarkerIndex(-1);
						e.setDropCompleted(true);
					}
				}
				e.consume();
			}
		});
	}

	public Optional<TextNode> findTextNode(Point2D screenLocation) {
		Point2D contentLocalLocation = this.content.screenToLocal(screenLocation);
		return this.content.findTextNode(contentLocalLocation);
	}

	private void scrollColumnIntoView(int colIndex, int jumpAhead) {
		double charWidth = this.content.getCharWidth();

		double colOffset = charWidth * colIndex;

		double contentWidth = this.content.getWidth();
		double curOffset = this.contentArea.horizontal.getValue();

		if (colOffset < curOffset) {
			double jumpOffset = curOffset - jumpAhead * charWidth;
			if (colOffset < jumpOffset) {
				jumpOffset = colOffset;
			}
			double targetOffset = Math.max(this.contentArea.horizontal.getMin(), jumpOffset);
			this.contentArea.horizontal.setValue(targetOffset);

		}
		if (colOffset > curOffset + contentWidth) {
			double jumpOffset = curOffset + jumpAhead * charWidth;
			if (colOffset > jumpOffset + contentWidth) {
				jumpOffset = colOffset + contentWidth;
			}
			double targetOffset = Math.min(this.contentArea.horizontal.getMax(), jumpOffset);
			this.contentArea.horizontal.setValue(targetOffset);
		}

	}

	public <T> Optional<T> fastQuery(String label, String fieldText, Function<String, T> converter) {
		TextInputDialog diag = new TextInputDialog();
		diag.setTitle(label);
		diag.setHeaderText(label);
		diag.setContentText(fieldText);
		return diag.showAndWait().map(converter);
	}

	public void scrollLineIntoView(int lineIndex) {
		this.scroller.scrollIntoView(lineIndex);
	}

	public void scrollOffsetIntoView(int offset, int verticalOffset, int horizontalOffset) {
		if( offset >= 0 ) {
			int lineIdx = getSkinnable().getContent().getLineAtOffset(offset);
			Range<Integer> visibleLines = this.content.getVisibleLines();
			if( ! visibleLines.contains(Integer.valueOf(lineIdx)) ) {
				int linesVisible = visibleLines.upperEndpoint().intValue() - visibleLines.lowerEndpoint().intValue();
				int delta = linesVisible - verticalOffset;
				int scrollLine = Math.min(lineIdx+delta, getSkinnable().getContent().getLineCount()-1);
				scrollLineIntoView(scrollLine);
			}

			int colIdx = offset - getSkinnable().getContent().getOffsetAtLine(lineIdx);
			String line = getSkinnable().getContent().getLine(lineIdx).substring(0, colIdx);
			int tabCount = (int)line.chars().filter(c -> c == '\t').count();
			scrollColumnIntoView(colIdx + tabCount * (getSkinnable().tabAvanceProperty().get() - 1), horizontalOffset);
		} else {
			scrollLineIntoView(0);
			scrollColumnIntoView(0, 0);
		}
	}

	/**
	 * @return The behavior
	 */
	public StyledTextBehavior getBehavior() {
		return this.behavior;
	}

	/**
	 * The line height at the care position
	 *
	 * @param caretPosition
	 *            the position
	 * @return the line height
	 */
	public double getLineHeight(int caretPosition) {
		if( getSkinnable().getFixedLineHeight() >= 0.0 ) {
			return getSkinnable().getFixedLineHeight();
		}
		//FIXME: We need to calculate that size
		return -1;
	}

	/**
	 * Get the point for the caret position
	 *
	 * @param caretPosition
	 *            the position
	 * @return the point
	 */
	public Point2D getCaretLocation(int caretPosition, LineLocation locationHint) {
		if (caretPosition < 0) {
			return null;
		}

		Optional<Point2D> location = this.content.getLocationInScene(caretPosition, locationHint);

		return location.map(l -> this.rootContainer.sceneToLocal(l)).map(l -> new Point2D(l.getX(), l.getY() + this.content.getLineHeight())).orElse(null);
	}


	@Override
	protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
		return 100;
	}

	@Override
	protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
		return 60;
	}

	/**
	 * Scroll up a line
	 */
	public void scrollLineUp() {
		this.scroller.scrollBy(-1);
	}

	/**
	 * Scroll down a line
	 */
	public void scrollLineDown() {
		this.scroller.scrollBy(1);
	}

	static String removeLineending(String s) {
		return s.replace("\n", "").replace("\r", ""); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	/**
	 * Find the offset at a specific position
	 *
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @return the offset
	 */
	public int getOffsetAtPosition(double x, double y) {
		if (this.content.getBoundsInLocal().getMinY() <= y && this.content.getBoundsInLocal().getMaxY() >= y) {
			return this.content.getLineIndex(new Point2D(x, y)).orElse(Integer.valueOf(getSkinnable().getContent().getCharCount())).intValue();
		}
		else {
			return -1;
		}
	}

	public void refreshStyles(int start, int length) {
		int startLine = getSkinnable().getContent().getLineAtOffset(start);
		int endLine = getSkinnable().getContent().getLineAtOffset(start+length);
		TreeRangeSet<Integer> set = TreeRangeSet.create();
		set.add(Range.closed(startLine, endLine));
		this.content.updatelines(set);
	}

	public void updateInsertionMarkerIndex(int offset) {
		this.content.updateInsertionMarkerIndex(offset);
	}

	public int getVisibleLineCount() {
		return this.scroller.visibleLineCountProperty().get();
	}

	public Bounds getContentBounds() {
		return this.content.getLayoutBounds();
	}
}