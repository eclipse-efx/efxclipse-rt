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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

@SuppressWarnings("javadoc")
public class VFlow<N extends Node>  extends Pane {

	private Object sync = new Object();

//	private int overload = 100;

	private Supplier<N> nodeFactory;
	private BiConsumer<N, Integer> nodePopulator;

	private Map<Integer, N> activeNodes = new HashMap<>();
	private Queue<N> freeNodes = new LinkedList<>();

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

	private IntegerProperty numberOfLines = new SimpleIntegerProperty(this, "numberOfLines", 0); //$NON-NLS-1$
	public IntegerProperty numberOfLinesProperty() {
		return this.numberOfLines;
	}
	public int getNumberOfLines() {
		return this.numberOfLines.get();
	}
	public void setNumberOfLines(int lines) {
		this.numberOfLines.set(lines);
	}

	private DoubleProperty yOffset = new SimpleDoubleProperty(this, "yOffset", 0); //$NON-NLS-1$
	public DoubleProperty yOffsetProperty() {
		return this.yOffset;
	}
	public double getYOffset() {
		return this.yOffset.get();
	}
	public void setYOffset(double yOffset) {
		this.yOffset.set(yOffset);
	}

	private ObjectProperty<Range<Integer>> visibleLines = new SimpleObjectProperty<>(this, "visibleLines", Range.all()); //$NON-NLS-1$
	public ObjectProperty<Range<Integer>> visibleLinesProperty() {
		return this.visibleLines;
	}
	public Range<Integer> getVisibleLines() {
		return this.visibleLines.get();
	}
	public void setVisibleLines(Range<Integer> visibleLines) {
		this.visibleLines.set(visibleLines);
	}

	private Consumer<N> onRelease;
	private BiConsumer<Integer, N> onActivate;

	protected void setOnRelease(Consumer<N> onRelease) {
		this.onRelease = onRelease;
	}

	protected void setOnActivate(BiConsumer<Integer, N> onActivate) {
		this.onActivate = onActivate;
	}

	public VFlow(Supplier<N> nodeFactory, BiConsumer<N, Integer> nodePopulator) {
		this.nodeFactory = nodeFactory;
		this.nodePopulator = nodePopulator;
		this.visibleLines.addListener(this::onVisibleLinesChange);
		this.yOffset.addListener((x)->requestLayout());
		this.numberOfLines.addListener(this::onNumberOfLinesChange);
	}


//	private void onModelChange(ListChangeListener.Change<? extends M> change) {
//		RangeSet<Integer> toUpdate = TreeRangeSet.create();
//		RangeSet<Integer> toRelease = TreeRangeSet.create();
////
//		while (change.next()) {
//			if (change.wasUpdated()) {
//				toUpdate.add(Range.closedOpen(change.getFrom(), change.getTo()));
//			}
//			if (change.wasAdded()) {
//				toUpdate.add(Range.closedOpen(change.getFrom(), model.size()));
//			}
//			if (change.wasRemoved()) {
//				toUpdate.add(Range.closedOpen(change.getFrom(), model.size()));
//			}
//		}
////
////
////
////		triggerUpdate(toUpdate);
////		triggerRelease(toRelease);
////		toUpdate.add(visibleLines.get());
//
//
//		Range<Integer> all = Range.all();
//		RangeSet<Integer> notAll = TreeRangeSet.create();
//		notAll.add(all);
//		// always release not existing nodes
//		toRelease.addAll(notAll.complement());
//
//		triggerRelease(toRelease);
//		triggerUpdate(toUpdate);
//
//		requestLayout();
//	}

	public void permutateNodes(Function<Integer, Integer> mapping) {
//		String permutate = "permutateNodes(): ";
		synchronized (this.sync) {
			Map<Integer, N> newActiveNodes = new HashMap<>();
			Set<Integer> changedIndexes = new HashSet<>();
			for (Entry<Integer, N> entry : this.activeNodes.entrySet()) {
				final Integer curIndex = entry.getKey();
				final Integer newIndex = mapping.apply(entry.getKey());
//				permutate += "\n * " + curIndex + " -> " + newIndex;
				if (curIndex.intValue() != newIndex.intValue()) changedIndexes.add(newIndex);
				newActiveNodes.put(newIndex, entry.getValue());
			}
			this.activeNodes = newActiveNodes;

			for (Integer index : changedIndexes) {
				// apply indices
				if (this.onActivate != null) this.onActivate.accept(index, this.activeNodes.get(index));
			}

		}
	}

	private void onNumberOfLinesChange(Observable x, Number o, Number n) {
		if (n.intValue() > o.intValue()) {
			RangeSet<Integer> toUpdate = TreeRangeSet.create();
			toUpdate.add(Range.closedOpen(Integer.valueOf(o.intValue()), Integer.valueOf(n.intValue())));
			triggerUpdate(toUpdate);
		}
		else if (n.intValue() < o.intValue()) {
			RangeSet<Integer> toRelease = TreeRangeSet.create();
			toRelease.add(Range.closed(Integer.valueOf(n.intValue()), Integer.valueOf(o.intValue())));
			triggerRelease(toRelease);
		}
	}

	private void onVisibleLinesChange(Observable x, Range<Integer> o, Range<Integer> n) {
		RangeSet<Integer> toUpdate = TreeRangeSet.create();
		RangeSet<Integer> toRelease = TreeRangeSet.create();

		if (o != null && n != null) {
			RangeSet<Integer> hidden = TreeRangeSet.create();
			hidden.add(o);
			hidden.remove(n);

			toRelease.addAll(hidden);
		}

		if (n != null) {
			toUpdate.add(getVisible());
		}

		triggerUpdate(toUpdate);
		triggerRelease(toRelease);
		requestLayout();
	}

	private Range<Integer> getVisible() {
		return this.visibleLines.get();
//		Range<Integer> r = visibleLines.get();
//		return Range.closedOpen(r.lowerEndpoint() - overload, r.upperEndpoint() + overload);
	}

	private void triggerUpdate(RangeSet<Integer> range) {
		Range<Integer> all = Range.closedOpen(Integer.valueOf(0), Integer.valueOf(getNumberOfLines()));
		RangeSet<Integer> onlyExisting = range.subRangeSet(all);
		RangeSet<Integer> onlyVisible = onlyExisting.subRangeSet(getVisible());

		onlyVisible.asRanges().stream()
		.flatMapToInt(VFlow::toIntStream)
		.forEach(index -> updateNode(index));
	}

	private void triggerRelease(RangeSet<Integer> range) {
		if (range.contains(Integer.valueOf(Integer.MAX_VALUE)) || range.contains(Integer.valueOf(Integer.MIN_VALUE))) {
			return;
		}
		range.asRanges().stream()
		.flatMapToInt(VFlow::toIntStream)
		.forEach(index -> releaseNode(index));
	}

	@Override
	protected void layoutChildren() {
		synchronized (this.sync) {
			this.activeNodes.entrySet().forEach(e -> {
				double x = 0;
				double y = e.getKey().intValue() * getLineHeight() - getYOffset();
				double width = getWidth();
				double height = getLineHeight();
				e.getValue().resizeRelocate(x, y, width, height);
			});
		}
	}



	protected void releaseNode(int lineIndex) {
		synchronized (this.sync) {
			N node = this.activeNodes.remove(Integer.valueOf(lineIndex));
			if (node != null) {
				node.setVisible(false);
				this.freeNodes.offer(node);
				if (this.onRelease != null) {
					this.onRelease.accept(node);
				}
			}
		}
	}

	protected void updateNode(int lineIndex) {
		N node = getNode(lineIndex);
		node.setVisible(true);
		this.nodePopulator.accept(node, Integer.valueOf(lineIndex));
	}

	public Optional<N> getVisibleNode(int lineIndex) {
		synchronized (this.sync) {
			N node = this.activeNodes.get(Integer.valueOf(lineIndex));
			return Optional.ofNullable(node);
		}
	}

	protected N getNode(int lineIndex) {
		synchronized (this.sync) {
			N node = this.activeNodes.remove(Integer.valueOf(lineIndex));

			if (node == null) {
				if (!this.freeNodes.isEmpty()) {
					node = this.freeNodes.poll();
				}
			}

			if (node == null) {
				node = this.nodeFactory.get();
				getChildren().add(node);
			}

			if (node != null) if (this.onActivate != null) this.onActivate.accept(Integer.valueOf(lineIndex), node);
			this.activeNodes.put(Integer.valueOf(lineIndex), node);

			return node;
		}
	}

	static IntStream toIntStream(Range<Integer> range) {
		return ContiguousSet.create(range, DiscreteDomain.integers()).stream().mapToInt(i->i.intValue());
	}

}
