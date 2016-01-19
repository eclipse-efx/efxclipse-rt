/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *  Christoph Caks <ccaks@bestsolution.at> - improved editor behavior
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.shape.Line;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

/**
 * A text layout container who is able to show selection
 *
 * @since 2.0
 */
public class StyledTextLayoutContainer extends Region {
	@SuppressWarnings("null")
	@NonNull
	private final ObservableList<@NonNull StyledTextNode> textNodes = FXCollections.observableArrayList();

	@NonNull
	private final IntegerProperty caretIndex = new SimpleIntegerProperty(this, "caretIndex"); //$NON-NLS-1$

	@NonNull
	private final IntegerProperty startOffset = new SimpleIntegerProperty(this, "startOffset"); //$NON-NLS-1$


//	@NonNull
//	final SetProperty<@NonNull StyledTextAnnotation> annotationsProperty = new SimpleSetProperty<>(this, "annotations", FXCollections.observableSet()); //$NON-NLS-1$
//	public SetProperty<@NonNull StyledTextAnnotation> getAnnotations() {
//		return this.annotationsProperty;
//	}
//
//	private Map<StyledTextAnnotation, Rectangle> annotationMarkers = new HashMap<>();

	/**
	 * The start offset if used in a bigger context like {@link StyledTextArea}
	 *
	 * @return the offset property to observe
	 */
	public final IntegerProperty startOffsetProperty() {
		return this.startOffset;
	}

	/**
	 * the the caret index property.
	 *
	 * <p>the index or <code>-1</code> if caret is to be hidden</p>
	 *
	 * @return the caret index property
	 */
	public final IntegerProperty caretIndexProperty() {
		return this.caretIndex;
	}

	/**
	 * Set the caret index
	 *
	 * @param index
	 *            the index or <code>-1</code> if caret is to be hidden
	 */
	public void setCaretIndex(int index) {
		this.caretIndex.set(index);
	}

	/**
	 * Returns the caret index
	 *
	 * @return the index or <code>-1</code> if caret is to be hidden
	 */
	public int getCaretIndex() {
		return this.caretIndex.get();
	}


	/**
	 * The start offset if used in a bigger context like {@link StyledTextArea}
	 *
	 * @return the offset
	 */
	public final int getStartOffset() {
		return this.startOffsetProperty().get();
	}

	/**
	 * The start offset if used in a bigger context like {@link StyledTextArea}
	 *
	 * @param startOffset
	 *            the start offset
	 */
	public final void setStartOffset(final int startOffset) {
		this.startOffsetProperty().set(startOffset);
	}

	@NonNull
	private final ObjectProperty<@NonNull TextSelection> selection = new SimpleObjectProperty<>(this, "selection", TextSelection.EMPTY); //$NON-NLS-1$

	/**
	 * The selection currently shown
	 *
	 * @return the selection property to observe
	 */
	public final ObjectProperty<@NonNull TextSelection> selectionProperty() {
		return this.selection;
	}

	/**
	 * @return the text selection
	 */
	public final @NonNull TextSelection getSelection() {
		return this.selectionProperty().get();
	}

	/**
	 * The selection to be shown
	 *
	 * @param selection
	 *            the new selection
	 */
	public final void setSelection(final @NonNull TextSelection selection) {
		this.selectionProperty().set(selection);
	}

	private final Region selectionMarker = new Region();
	final Line caret = new Line();
	private final TextFlow textLayoutNode = new TextFlow();

	private StyledTextNode selectionStartNode;
	private StyledTextNode selectionEndNode;

	private double selectionStartX;
	private double selectionEndX;

	private Animation caretAnimation;

	private final ReadOnlyBooleanProperty ownerFocusedProperty;

	/**
	 * Create a container to layout text and allows to show e.g. a selection
	 * range
	 */
	public StyledTextLayoutContainer() {
		this(new SimpleBooleanProperty(true));
	}

	private static Animation createCaretAnimation(Node caret) {
		FadeTransition t = new FadeTransition(Duration.millis(400), caret);
		t.setAutoReverse(true);
		t.setFromValue(1);
		t.setToValue(0);
		t.setCycleCount(Animation.INDEFINITE);
		return t;
	}

	/**
	 * Create a container to layout text and allows to show e.g. a selection
	 * range
	 *
	 * @param ownerFocusedProperty
	 *            property identifing if the owner of the text container has the
	 *            input focus
	 */
	@SuppressWarnings("null")
	public StyledTextLayoutContainer(ReadOnlyBooleanProperty ownerFocusedProperty) {
		this.ownerFocusedProperty = ownerFocusedProperty;
		getStyleClass().add("styled-text-layout-container"); //$NON-NLS-1$
		this.textNodes.addListener(this::recalculateOffset);
		this.selectionMarker.setVisible(false);
		this.selectionMarker.setManaged(false);
		this.selectionMarker.getStyleClass().add("selection-marker"); //$NON-NLS-1$
		this.caret.setVisible(false);
		this.caret.setStrokeWidth(2);
		this.caret.setManaged(false);
		this.caret.getStyleClass().add("text-caret"); //$NON-NLS-1$

		this.caretAnimation = createCaretAnimation(this.caret);

		Bindings.bindContent(this.textLayoutNode.getChildren(), this.textNodes);
		getChildren().setAll(this.selectionMarker, this.textLayoutNode, this.caret);
		selectionProperty().addListener(this::handleSelectionChange);

		this.ownerFocusedProperty.addListener(this::updateCaretVisibility);
		this.caretIndex.addListener(this::updateCaretVisibility);

//		this.annotationsProperty.addListener(new SetChangeListener<StyledTextAnnotation>() {
//			@Override
//			public void onChanged(javafx.collections.SetChangeListener.Change<? extends StyledTextAnnotation> change) {
//				System.err.println("ON ANNOTATION MARKER CHANGE");
//				if (change.getElementAdded() != null) {
//					StyledTextAnnotation a = change.getElementAdded();
//
//					Rectangle child = new Rectangle();
//
//					if (a.getType().contains("ERROR")) {
//						child.setFill(Color.RED);
//					}
//					else if (a.getType().contains("WARN")) {
//						child.setFill(Color.YELLOW);
//					}
//					child.setOpacity(0.3);
//
//					Tooltip tt = new Tooltip();
//					tt.setText(a.getText());
//					getChildren().add(child);
//					Tooltip.install(child, tt);
//
//					annotationMarkers.put(a, child);
//				}
//				if (change.getElementRemoved() != null) {
//					StyledTextAnnotation a = change.getElementRemoved();
//
//					Rectangle child = annotationMarkers.remove(a);
//					if (child != null) {
//						getChildren().remove(child);
//					}
//				}
//
//				requestLayout();
//			}
//		});
	}

	private void updateCaretVisibility(Observable o) {
		if (this.ownerFocusedProperty.get() && this.caretIndex.get() != -1) {
			showCaret();
		}
		else {
			hideCaret();
		}
	}

	private void showCaret() {
		this.caret.setVisible(true);
		this.caretAnimation.play();
		requestLayout();
	}

	private void hideCaret() {
		this.caret.setVisible(false);
		this.caretAnimation.stop();
		requestLayout();
	}

	private int getEndOffset() {
		return getStartOffset() + getText().length();
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
	public boolean intersectOffset(int start, int end) {
		if (getStartOffset() > end) {
			return false;
		} else if (getEndOffset() < start) {
			return false;
		}
		return true;
	}

	private void recalculateOffset(Observable o) {
		int offset = 0;
		for (StyledTextNode t : this.textNodes) {
			t.setStartOffset(offset);
			offset = t.getEndOffset();
		}
	}

	private void handleSelectionChange(Observable o, TextSelection oldSelection, TextSelection newSelection) {
		if (newSelection.length == 0) {
			this.selectionMarker.setVisible(false);
			this.selectionMarker.resize(0, 0);
		} else {
			this.selectionMarker.setVisible(true);
			int start = newSelection.offset;
			int end = newSelection.offset + newSelection.length;

			this.selectionStartNode = null;
			this.selectionEndNode = null;
			for (StyledTextNode t : this.textNodes) {
				if (t.intersectOffset(start, end)) {
					if (this.selectionStartNode == null) {
						this.selectionStartNode = t;
					}
					this.selectionEndNode = t;
				}
			}

			if (this.selectionStartNode != null && this.selectionEndNode != null) {
				int charIndex = start - this.selectionStartNode.getStartOffset();
				this.selectionStartX = this.selectionStartNode.getCharLocation(charIndex);
				charIndex = end - this.selectionEndNode.getStartOffset();
				this.selectionEndX = this.selectionEndNode.getCharLocation(charIndex);
				requestLayout();
			}
		}
	}

	@Override
	protected double computePrefHeight(double width) {
		double d = super.computePrefHeight(width);
		return d;
	}

	private double findX(int localOffset) {

		double len = 0;
		for (StyledTextNode t : this.textNodes) {
			if (t.getStartOffset() <= localOffset && t.getEndOffset() > localOffset || this.textNodes.get(this.textNodes.size() - 1) == t) {
				return len + t.getCharLocation(localOffset - t.getStartOffset());
			}
			len += t.getWidth();
		}
		return -1;
	}

	@Override
	protected void layoutChildren() {
		super.layoutChildren();

		this.textLayoutNode.relocate(getInsets().getLeft(), getInsets().getTop());

//		for (Entry<StyledTextAnnotation, Rectangle> e : annotationMarkers.entrySet()) {
//			System.err.println("LAYOUTING MARKER: " + e.getKey().getText());
//			final int globalBeginIndex = e.getKey().getStartOffset();
//			final int globalEndIndex = e.getKey().getStartOffset() + e.getKey().getLength();
//
//			System.err.println("global: " + globalBeginIndex + " - " + globalEndIndex);
//
//			final int localBeginIndex = Math.max(0, globalBeginIndex - getStartOffset());
//			final int localEndIndex = Math.min(getText().length(), globalEndIndex - getStartOffset());
//
//			System.err.println("local: " + localBeginIndex + " - " + localEndIndex);
//
//			double xBegin = findX(localBeginIndex);
//			double xEnd = findX(localEndIndex);
//
////			System.err.println(xBegin + ", " + getInsets().getTop() + ", " + (xEnd - xBegin)+ ", " + textLayoutNode.prefHeight(-1));
////			e.getValue().resizeRelocate(xBegin, getInsets().getTop(), xEnd - xBegin, textLayoutNode.prefHeight(-1));
//			e.getValue().setX(xBegin);
//			e.getValue().setY(getInsets().getTop());
//			e.getValue().setWidth(xEnd - xBegin);
//			e.getValue().setHeight(textLayoutNode.prefHeight(-1));
//			e.getValue().toFront();
//			System.err.println(" -> " + e.getValue());
//		}


		if (this.selectionStartNode != null && this.selectionEndNode != null) {
			double x1 = this.textLayoutNode.localToParent(this.selectionStartNode.getBoundsInParent().getMinX(), 0).getX() + this.selectionStartX;
			double x2 = this.textLayoutNode.localToParent(this.selectionEndNode.getBoundsInParent().getMinX(), 0).getX() + this.selectionEndX;
			this.selectionMarker.resizeRelocate(x1, 0, x2 - x1, getHeight());
		}

		if (this.getCaretIndex() >= 0) {
			this.textLayoutNode.layout();
			this.textLayoutNode.applyCss();
			for (StyledTextNode t : this.textNodes) {
				t.applyCss();
				if (t.getStartOffset() <= this.getCaretIndex() && (t.getEndOffset() > this.getCaretIndex() || this.textNodes.get(this.textNodes.size() - 1) == t)) {
					double caretX = t.getCharLocation(this.getCaretIndex() - t.getStartOffset());
					double x = this.textLayoutNode.localToParent(t.getBoundsInParent().getMinX(), 0).getX() + caretX;
					double h = t.prefHeight(-1);

					this.caret.setStartX(x);
					this.caret.setEndX(x);
					this.caret.setStartY(getInsets().getTop() + 1);
					this.caret.setEndY(h + getInsets().getTop() + 1);
					this.caret.toFront();
					return;
				}
			}

			this.caret.setStartX(0);
			this.caret.setEndX(0);
			this.caret.setStartY(0);
			this.caret.setEndY(15);

		} else {
			this.caret.setStartX(0);
			this.caret.setEndX(0);
			this.caret.setStartY(0);
			this.caret.setEndY(getHeight());
		}
	}

	/**
	 * @return list of text nodes rendered
	 */
	public @NonNull ObservableList<@NonNull StyledTextNode> getTextNodes() {
		return this.textNodes;
	}

	/**
	 * Find the caret index at the give point
	 *
	 * @param point
	 *            the point relative to coordinate system of this node
	 * @return the index or <code>-1</code> if not found
	 */
	public int getCaretIndexAtPoint(Point2D point) {
		Point2D scenePoint = localToScene(point);
		for (StyledTextNode t : this.textNodes) {
			if (t.localToScene(t.getBoundsInLocal()).contains(scenePoint)) {
				return t.getCaretIndexAtPoint(t.sceneToLocal(scenePoint)) + t.getStartOffset();
			}
		}

		return -1;
	}

	private String getText() {
		StringBuilder b = new StringBuilder();
		for (StyledTextNode t : this.textNodes) {
			b.append(t.getText());
		}
		return b.toString();
	}

	/**
	 * Find the position of a the caret at a given index
	 *
	 * @param index
	 *            the index
	 * @return the location relative to this node or <code>null</code>
	 */
	public @Nullable Point2D getCareLocation(int index) {
		for (StyledTextNode t : this.textNodes) {
			if (t.getStartOffset() <= index && t.getEndOffset() >= index) {
				double x = t.getCharLocation(index);
				return sceneToLocal(t.localToScene(x, 0));
			}
		}
		return null;
	}

	/**
	 * Releases resources immediately
	 */
	public void dispose() {
		this.caretAnimation.stop();
	}
}
