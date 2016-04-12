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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;

@SuppressWarnings("javadoc")
public class VerticalLineFlow<M, N>  extends NodeCachePane {

	private Predicate<Set<N>> needsPresentation;

	private BiConsumer<Node, Set<N>> nodePopulator;
	private Function<Integer, Set<N>> converter;
	protected Map<Integer, Double> yOffsetData = new HashMap<>();

	private DoubleProperty lineHeigth = new SimpleDoubleProperty(this, "lineHeight", 16.0); //$NON-NLS-1$
	public DoubleProperty lineHeightProperty() {
		return this.lineHeigth;
	}
	public double getLineHeight() {
		return this.lineHeigth.get();
	}
	public void setLineHeight(double lineHeight) {
		this.lineHeigth.set(lineHeight);
	}

//	private ListProperty<M> model = new SimpleListProperty<>(this, "model", FXCollections.observableArrayList());
//	public ListProperty<M> getModel() {
//		return this.model;
//	}

	private IntegerProperty numberOfLines = new SimpleIntegerProperty(this, "numberOfLines", 0); //$NON-NLS-1$
	public IntegerProperty numberOfLinesProperty() {
		return this.numberOfLines;
	}

	private ObjectProperty<Range<Integer>> visibleLines = new SimpleObjectProperty<>(this, "visibleLines", Range.all()); //$NON-NLS-1$
	public ObjectProperty<Range<Integer>> visibleLinesProperty() {
		return this.visibleLines;
	}
	public RangeSet<Integer> getVisibleLines() {
		RangeSet<Integer> visibleLines = TreeRangeSet.create();
		visibleLines.add(this.visibleLines.get());
		return visibleLines.subRangeSet(Range.closedOpen(Integer.valueOf(0), Integer.valueOf(this.numberOfLines.get())));
	}

	public void setVisibleLines(Range<Integer> visibleLines) {
		this.visibleLines.set(visibleLines);
	}

	public VerticalLineFlow(Function<Integer, Set<N>> converter, Predicate<Set<N>> needsPresentation, Supplier<Node> nodeFactory, BiConsumer<Node, Set<N>> nodePopulator) {
		super(nodeFactory);
		this.needsPresentation = needsPresentation;
		this.nodePopulator = nodePopulator;
		this.converter = converter;

		this.visibleLines.addListener((InvalidationListener)(x)->prepareNodes(getVisibleLines()));
		this.numberOfLines.addListener((InvalidationListener)(x)->prepareNodes(getVisibleLines()));
	}

	protected Map<Integer, Node> activeNodes = new HashMap<>();

	protected void releaseNode(int lineIndex) {
		Node node = this.activeNodes.remove(lineIndex);
		if (node != null) {
			releaseNode(node);
		}
	}

	protected Node getNode(int lineIndex) {
		Node node = this.activeNodes.get(Integer.valueOf(lineIndex));

		if (node == null) {
			node = getNode();
		}

		this.activeNodes.put(Integer.valueOf(lineIndex), node);
		return node;
	}

	private void prepareNodes(RangeSet<Integer> range) {
		if (range == null) return;

//		System.err.println("VerticalLineFlow: prepareNodes " + range);

		// release invisible nodes
		Iterator<Entry<Integer, Node>> iterator = this.activeNodes.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Node> entry = iterator.next();
			Integer index = entry.getKey();
			if (!range.contains(index)) {
				releaseNode(entry.getValue());
				iterator.remove();
			}
		}

		// prepare range nodes
		range.asRanges().forEach(r->ContiguousSet.create(r, DiscreteDomain.integers()).forEach(index -> prepareNode(index.intValue())));

	}

	private void prepareNode(int lineIndex) {
		Set<N> blub = this.converter.apply(Integer.valueOf(lineIndex));
		if (blub.isEmpty()) {
			releaseNode(lineIndex);
		}
		else {
			Node node = getNode(lineIndex);
			this.nodePopulator.accept(node, blub);
		}
	}

	public void setLineOffset(int lineIndex, double yOffset) {
		this.yOffsetData.put(Integer.valueOf(lineIndex), Double.valueOf(yOffset));
		requestLayout();
	}

	@Override
	protected void layoutChildren() {
		this.activeNodes.entrySet().forEach(e -> {
			if (!this.yOffsetData.containsKey(e.getKey())) {
				return;
			}
			double x = 0;
			double y = this.yOffsetData.get(e.getKey()).doubleValue();
			double width = getWidth();
			double height = getLineHeight();
			e.getValue().resizeRelocate(x, y, width, height);
		});
	}



	public void update(RangeSet<Integer> r) {
		prepareNodes(r.subRangeSet(this.visibleLines.get()).subRangeSet(Range.closedOpen(Integer.valueOf(0), Integer.valueOf(this.numberOfLines.get()))));
	}

}
