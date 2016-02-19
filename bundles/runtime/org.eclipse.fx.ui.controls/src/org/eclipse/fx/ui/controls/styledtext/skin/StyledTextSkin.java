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
import java.util.List;
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
import org.eclipse.fx.ui.controls.styledtext.FXBindUtil;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.StyledTextContent.TextChangeListener;
import org.eclipse.fx.ui.controls.styledtext.TextChangedEvent;
import org.eclipse.fx.ui.controls.styledtext.TextChangingEvent;
import org.eclipse.fx.ui.controls.styledtext.VerticalLineFlow;
import org.eclipse.fx.ui.controls.styledtext.behavior.StyledTextBehavior;
import org.eclipse.fx.ui.controls.styledtext.internal.ContentView;
import org.eclipse.fx.ui.controls.styledtext.internal.LineHelper;
import org.eclipse.fx.ui.controls.styledtext.internal.LineRuler;
import org.eclipse.fx.ui.controls.styledtext.internal.ScrollbarPane;
import org.eclipse.fx.ui.controls.styledtext.internal.Scroller;
import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.fx.ui.controls.styledtext.model.AnnotationPresenter;
import org.eclipse.fx.ui.controls.styledtext.model.AnnotationProvider;
import org.eclipse.fx.ui.controls.styledtext.model.LineRulerAnnotationPresenter;
import org.eclipse.fx.ui.controls.styledtext.model.TextAnnotationPresenter;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.RangeSet;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * Styled text skin
 */
@SuppressWarnings("restriction")
public class StyledTextSkin extends SkinBase<StyledTextArea> {

	private ScrollbarPane<ContentView> contentArea;
	private ContentView content;

	private Scroller scroller;

	private HBox lineRulerArea;

//	private ObservableList<VerticalLineFlow<Integer, Annotation>> sortedLineRulerFlows;

	private ObservableList<LineRuler> sortedLineRulerFlows;


	private HBox rootContainer;

	private final StyledTextBehavior behavior;

	private LineHelper lineHelper;

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

		this.rootContainer.setSpacing(0);

		this.lineRulerArea = new HBox();
		this.rootContainer.getChildren().add(this.lineRulerArea);


		Region spacer = new Region();
		spacer.getStyleClass().addAll("line-ruler", "spacer");
		spacer.setMinWidth(2);
		spacer.setMaxWidth(2);
		this.rootContainer.getChildren().add(spacer);


		lineHelper = new LineHelper(getSkinnable());
		this.content = new ContentView(lineHelper);

		this.contentArea = new ScrollbarPane<>();

		this.contentArea.setCenter(this.content);


		Map<AnnotationProvider, Subscription> subscriptions = new HashMap<>();
		Consumer<RangeSet<Integer>> onAnnotationChange = r-> {
			System.err.println("onAnnotationChange " + r);
			content.updateAnnotations(r);
			sortedLineRulerFlows.forEach(f->f.update(r));
		};

		getSkinnable().getAnnotationProvider().addListener((SetChangeListener<? super AnnotationProvider>)(c) -> {
			if (c.wasAdded()) {
				System.err.println("register for2 " + c.getElementAdded());
				Subscription s = c.getElementAdded().registerChangeListener(onAnnotationChange);
				subscriptions.put(c.getElementAdded(), s);
			}
			if (c.wasRemoved()) {
				Subscription s = subscriptions.remove(c.getElementRemoved());
				if (s != null) s.dispose();
			}
		});
		for (AnnotationProvider p : getSkinnable().getAnnotationProvider()) {
			System.err.println("register for " + p);
			if (!subscriptions.containsKey(p)) {
				Subscription s = p.registerChangeListener(onAnnotationChange);
				subscriptions.put(p, s);
			}
		}

		this.content.getStyleClass().addAll("list-view");

		// focus delegation
		this.content.focusedProperty().addListener((x, o, n)->{
			if (n) {
				getSkinnable().requestFocus();
			}
		});

		getBehavior().installContentListeners(this.content);

		this.content.contentProperty().bind(getSkinnable().contentProperty());

		// scroll support
		this.content.setOnScroll((e)-> {
			this.scroller.scrollBy(Math.round(-e.getDeltaY()));
		});

//		HBox.setHgrow(this.contentView, Priority.ALWAYS);

		HBox.setHgrow(this.contentArea, Priority.ALWAYS);
		this.rootContainer.getChildren().addAll(this.contentArea);
		getChildren().addAll(this.rootContainer);


		// scroll stuff
		this.scroller = new Scroller();
		this.scroller.contentAreaHeightProperty().bind(content.heightProperty());

		this.scroller.lineHeightProperty().bind(content.lineHeightProperty());

		this.content.lineHeightProperty().set(16);

		this.content.bindHorizontalScrollbar(this.contentArea.horizontal);

//		getSkinnable().lineCountProperty().addListener((x, o, n)-> {/* for the quantum! */});
		((IntegerProperty)getSkinnable().lineCountProperty()).bind(content.numberOfLinesProperty());


//		content.numberOfLinesProperty().addListener((x, o, n)-> System.err.println("FUCKING LINE COUNT CHANGE: " + n));
//		getSkinnable().lineCountProperty().addListener((x, o, n)-> System.err.println("FUCKING LINE COUNT CHANGE2: " + n));



		scroller.lineCountProperty().bind(content.numberOfLinesProperty());

		this.scroller.bind(this.contentArea.vertical);


		this.content.textSelectionProperty().bind(getSkinnable().selectionProperty());
		this.content.caretOffsetProperty().bind(getSkinnable().caretOffsetProperty());

		this.content.visibleLinesProperty().bind(this.scroller.visibleLinesProperty());

		Consumer<Double> updateOffset = (offset) -> {
			com.google.common.collect.Range<Integer> visibleLines = scroller.visibleLinesProperty().get();
			ContiguousSet<Integer> set = ContiguousSet.create(visibleLines, DiscreteDomain.integers());
			double lineHeight = scroller.lineHeightProperty().get();
			for (int index : set) {

				double y = index * lineHeight - offset.doubleValue();

				for (VerticalLineFlow<Integer, Annotation> flow : sortedLineRulerFlows) {
					flow.setLineOffset(index, y);
				}
			}
		};

		content.offsetYProperty().bind(scroller.offsetProperty());

		scroller.offsetProperty().addListener((x, o, offset)-> {
			updateOffset.accept(offset.doubleValue());
		});

		scroller.visibleLinesProperty().addListener(x->{
			updateOffset.accept(scroller.offsetProperty().get());
		});

		getSkinnable().getContent().addTextChangeListener(new TextChangeListener() {

			@Override
			public void textSet(TextChangedEvent event) {
				scroller.refresh();
			}

			@Override
			public void textChanging(TextChangingEvent event) {

			}

			@Override
			public void textChanged(TextChangedEvent event) {

			}
		});

		ObservableList<LineRulerAnnotationPresenter> lineRulerPresenters = FXCollections.observableArrayList();
		SortedList<LineRulerAnnotationPresenter> sortedLineRulerPresenters = new SortedList<>(lineRulerPresenters, (a, b)->a.getOrder() - b.getOrder());

		Function<LineRulerAnnotationPresenter, LineRuler> map = (ap) -> {
			Function<Integer, Set<Annotation>> converter = (index)->
			lineHelper.getAnnotations(index).stream().filter(ap::isApplicable).collect(Collectors.toSet());

			Predicate<Set<Annotation>> needsPresentation = ap::isVisible;
			Supplier<Node> nodeFactory = ap::createNode;
			BiConsumer<Node, Set<Annotation>> populator = ap::updateNode;

			LineRuler flow = new LineRuler(ap.getLayoutHint(), converter, needsPresentation, nodeFactory, populator);
//			VerticalLineFlow<Integer, Annotation> flow = new VerticalLineFlow<Integer, Annotation>(converter, needsPresentation, nodeFactory, populator);

			flow.visibleLinesProperty().bind(this.scroller.visibleLinesProperty());
			flow.numberOfLinesProperty().bind(this.content.numberOfLinesProperty());
//			flow.getModel().bindContent(this.getModel());

			flow.minWidthProperty().bind(ap.getWidth());
			flow.prefWidthProperty().bind(ap.getWidth());

			flow.prefWidthProperty().addListener((x, o, n)->{
				System.err.println("width change! " + o + " -> " + n);
				this.rootContainer.requestLayout();
			});
			return flow;
		};

		sortedLineRulerFlows = FXCollections.observableArrayList();
		sortedLineRulerFlows.addListener((InvalidationListener)x-> {
			for (VerticalLineFlow<Integer, Annotation> flow : sortedLineRulerFlows) {
				flow.getStyleClass().setAll("line-ruler");
			}
		});
		FXBindUtil.uniMapBindList(sortedLineRulerPresenters, sortedLineRulerFlows, map);
		FXBindUtil.uniMapBindList(sortedLineRulerFlows, lineRulerArea.getChildren(), (flow)->(Node)flow);
		sortedLineRulerFlows.addListener((ListChangeListener<? super VerticalLineFlow<Integer, Annotation>>)(c)-> {
			while (c.next()) {
				if (c.wasRemoved()) {
					c.getRemoved().forEach((f)-> {
						f.visibleLinesProperty().unbind();
						f.numberOfLinesProperty().unbind();
//						f.getModel().unbind();
						f.prefWidthProperty().unbind();
					});
				}
			}
		});



		Consumer<AnnotationPresenter> installPresenter = (p) -> {
			if (p instanceof LineRulerAnnotationPresenter) {
				LineRulerAnnotationPresenter lrp = (LineRulerAnnotationPresenter) p;
				lineRulerPresenters.add(lrp);
//				installLineRulerAnnotationPresenter.accept(lrp);
			}
			else if (p instanceof TextAnnotationPresenter) {
				TextAnnotationPresenter tp = (TextAnnotationPresenter) p;
				this.content.textAnnotationPresenterProperty().add(tp);
			}
		};
		Consumer<AnnotationPresenter> uninstallPresenter = (p) -> {
			if (p instanceof LineRulerAnnotationPresenter) {
				LineRulerAnnotationPresenter lrp = (LineRulerAnnotationPresenter) p;
				lineRulerPresenters.remove(lrp);
			}
			else if (p instanceof TextAnnotationPresenter) {
				TextAnnotationPresenter tp = (TextAnnotationPresenter) p;
				this.content.textAnnotationPresenterProperty().remove(tp);
			}
		};

		getSkinnable().getAnnotationPresenter().addListener((SetChangeListener<? super AnnotationPresenter>)(c)-> {
			if (c.wasAdded()) {
				installPresenter.accept(c.getElementAdded());
			}
			if (c.wasRemoved()) {
				uninstallPresenter.accept(c.getElementRemoved());
			}
		});
		getSkinnable().getAnnotationPresenter().forEach(installPresenter);

	}

	private <O> void pluginBinding(ObservableValue<O> property, Consumer<O> consumer, List<Subscription> subscriptions) {
		// init
		consumer.accept(property.getValue());
		ChangeListener<? super O> l = (x, o, n)->consumer.accept(n);
		// bind
		property.addListener(l);
		subscriptions.add(()->property.removeListener(l));
	}


	private void scrollColumnIntoView(int colIndex) {

		double w = 8;

		double curOffset = contentArea.horizontal.getValue();
		double colOffset = w * colIndex;

		if (curOffset > colOffset) {
			contentArea.horizontal.setValue(colOffset);
		}

		double lastColDiff = content.getWidth() - w;
		if (curOffset + lastColDiff < colOffset) {
			contentArea.horizontal.setValue(colOffset - lastColDiff);
		}

	}

	private void scrollLineIntoView(int lineIndex) {
		this.scroller.scrollIntoView(lineIndex);
	}

	StyledTextBehavior getBehavior() {
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
		return 16;

//		int lineIndex = getSkinnable().getContent().getLineAtOffset(caretPosition);
//		Line lineObject = (Line) this.lineList.get(lineIndex);
//
//		for (LineCell c : getCurrentVisibleCells()) {
//			if (c.getDomainElement() == lineObject) {
//				return c.getHeight();
//			}
//		}
//		return 0;
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

		Optional<Point2D> location = this.content.getLocationInScene(caretPosition);

		return location.map(l -> this.rootContainer.sceneToLocal(l))
				.map(l -> new Point2D(l.getX(), l.getY() + this.content.getLineHeight()))
				.orElse(null);


//		int lineIndex = getSkinnable().getContent().getLineAtOffset(caretPosition);
//
////		Line lineObject = (Line) this.getModel().get(lineIndex);
//
//		// TODO =?
////		for (LineCell c : getCurrentVisibleCells()) {
////			if (c.getDomainElement() == lineObject) {
////				StyledTextLayoutContainer b = (StyledTextLayoutContainer) c.getGraphic();
////				Point2D careLocation = b.getCareLocation(caretPosition - b.getStartOffset());
////				Point2D tmp = getSkinnable().sceneToLocal(b.localToScene(careLocation));
////				return new Point2D(tmp.getX(), getSkinnable().sceneToLocal(b.localToScene(0, b.getHeight())).getY());
////			}
////		}
//
//		return null;
	}

	/**
	 * Compute the min height
	 *
	 * @param width
	 *            the width that should be used if minimum height depends on it
	 * @return the min height
	 */
	protected double computeMinHeight(double width) {
		return 100; //this.contentView.minHeight(width);
	}

	/**
	 * Compute the min width
	 *
	 * @param height
	 *            the height that should be used if minimum width depends on it
	 * @return the min width
	 */
	protected double computeMinWidth(double height) {
		return 100; //this.contentView.minWidth(height);
	}

	public void scrollLineUp() {
		this.scroller.scrollBy(-1);
	}

	public void scrollLineDown() {
		this.scroller.scrollBy(1);
	}


	static String removeLineending(String s) {
		return s.replace("\n", "").replace("\r", ""); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}


	public int getOffsetAtPosition(double x, double y) {
		return content.getLineIndex(new Point2D(x, y)).orElse(-1);
	}
}