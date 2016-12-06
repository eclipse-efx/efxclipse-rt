/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext.internal;


import com.google.common.collect.Range;

import javafx.beans.Observable;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.ScrollBar;

@SuppressWarnings("javadoc")
public class Scroller {

	private DoubleProperty lineHeight = new SimpleDoubleProperty(this, "lineHeight", 16); //$NON-NLS-1$
	public DoubleProperty lineHeightProperty() {
		return this.lineHeight;
	}
	
	private DoubleProperty lineCount = new SimpleDoubleProperty(this, "lineCount", 0); //$NON-NLS-1$
	public DoubleProperty lineCountProperty() {
		return this.lineCount;
	}

	private IntegerProperty visibleLineCount = new SimpleIntegerProperty(this, "visibleLineCount", 0); //$NON-NLS-1$

	private DoubleBinding pageHeight = this.lineHeight.multiply(this.visibleLineCount.add(-1));
	
	private DoubleProperty contentHeight = new SimpleDoubleProperty(this, "contentHeight", 0); //$NON-NLS-1$
	public ReadOnlyDoubleProperty contentHeightProperty() {
		return this.contentHeight;
	}

	private DoubleProperty contentAreaHeight = new SimpleDoubleProperty(this, "contentAreaHeight", 0); //$NON-NLS-1$
	public DoubleProperty contentAreaHeightProperty() {
		return this.contentAreaHeight;
	}

	private ObjectProperty<Range<Integer>> visibleLines = new SimpleObjectProperty<>(this, "visibleLines", Range.all()); //$NON-NLS-1$
	public ReadOnlyObjectProperty<Range<Integer>> visibleLinesProperty() {
		return this.visibleLines;
	}

	public ReadOnlyIntegerProperty visibleLineCountProperty() {
		return this.visibleLineCount;
	}

	private DoubleProperty offset = new SimpleDoubleProperty(this, "offset", 0.01); //$NON-NLS-1$
	public DoubleProperty offsetProperty() {
		return this.offset;
	}

	private DoubleProperty min = new SimpleDoubleProperty(this, "min", 0); //$NON-NLS-1$
	private DoubleProperty max = new SimpleDoubleProperty(this, "max", 0); //$NON-NLS-1$

	public Scroller() {

		install();
	}

	private void recomputeContentHeight(Observable x) {
		double contentHeight = this.lineCount.get() * this.lineHeight.get();
		this.contentHeight.set(contentHeight);
	}

	private void recomputeMax(Observable x) {
		double max = Math.max(0, this.contentHeight.get() - this.contentAreaHeight.get());
		this.max.set(max);
	}

	private void recomputeVisibleLineCount(Observable x) {
		int visibleLineCount = (int) Math.ceil(this.contentAreaHeight.get() / this.lineHeight.get());
		this.visibleLineCount.set(visibleLineCount);
	}

	private void recomputeVisibleLines(Observable x) {
		int lower = (int) Math.floor(this.offset.get() / this.lineHeight.get());
		int upper = lower + this.visibleLineCount.get();
		Range<Integer> visibleLines = Range.closed(Integer.valueOf(lower), Integer.valueOf(upper));
		this.visibleLines.set(visibleLines);
	}

	private void recomputeAll() {
		recomputeContentHeight(null);
		recomputeMax(null);
		recomputeVisibleLineCount(null);
		recomputeVisibleLines(null);
	}

	private void install() {
		this.lineCount.addListener(this::recomputeContentHeight);
		this.lineHeight.addListener(this::recomputeContentHeight);


		this.contentHeight.addListener(this::recomputeMax);
		this.contentAreaHeight.addListener(this::recomputeMax);

		this.lineHeight.addListener(this::recomputeVisibleLineCount);
		this.contentAreaHeight.addListener(this::recomputeVisibleLineCount);

		this.offset.addListener(this::recomputeVisibleLines);
		this.lineHeight.addListener(this::recomputeVisibleLines);
		this.visibleLineCount.addListener(this::recomputeVisibleLines);
	}

	public void bind(ScrollBar bar) {
		bar.minProperty().bind(this.min);

		bar.maxProperty().bind(this.max);

		bar.visibleAmountProperty().bind(this.contentAreaHeight.divide(this.contentHeight.divide(this.max)));

		bar.valueProperty().bindBidirectional(this.offset);

		bar.unitIncrementProperty().bind(this.lineHeight);
		bar.blockIncrementProperty().bind(this.pageHeight);
		
		recomputeAll();
	}


	public void scrollBy(int lines) {
		scrollBy(lineHeightProperty().get() * lines);
	}

	public void scrollBy(double units) {

		double newVal = this.offset.get() + units;
		newVal = Math.min(this.max.get(), newVal);
		newVal = Math.max(this.min.get(), newVal);

		this.offset.set(newVal);
	}

	public void scrollIntoView(int line) {
		double lineOffset = line * this.lineHeight.get();

		if (lineOffset < this.offset.get()) {
			// we need to scroll up
			this.offset.set(lineOffset);
		}

		double lastLineDelta = this.contentAreaHeight.get() - this.lineHeight.get();
		if (lineOffset > this.offset.get() + lastLineDelta) {
			// we need to scroll down
			this.offset.set(lineOffset - lastLineDelta);
		}
	}

	public void scrollTo(int line) {
		this.offset.set(line * this.lineHeight.get());
	}

	public void refresh() {
		recomputeAll();
	}



}
