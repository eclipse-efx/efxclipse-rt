package org.eclipse.fx.ui.controls.styledtext_ng.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.fx.core.text.TextUtil;
import org.eclipse.fx.ui.controls.Util;

import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SingleTextStyledLineRenderer extends BaseStyledLineRenderer {
	private final LayoutPane node;

	public SingleTextStyledLineRenderer() {
		this.node = new LayoutPane();
	}

	@Override
	public void setVisibleRange(double minX, double width) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearStyles() {
		// TODO Auto-generated method stub

	}

	@Override
	public Node getNode() {
		return node;
	}


	@Override
	protected void rebuildFill() {
		rebuildText();
	}

	@Override
	protected void rebuildFonts() {
		rebuildText();
	}

	@Override
	protected void rebuildText() {
		if( this.combinedAction ) {
			this.flag |= TEXT;
			return;
		}

		this.node.requestLayout();
	}

	private void refreshLayout() {
		if( this.flag == 0 ) {
			return;
		}
		this.flag = 0;
		RangeSet<Integer> normalFont = getNormalRange();

		RangeSet<Integer> boldRange = getBoldRange();
		RangeSet<Integer> italicRange = getItalicRange();
		RangeSet<Integer> boldItalicRange = getBoldItalicRange();

		Map<Paint, RangeSet<Integer>> normalTextColors = new HashMap<>();
		Map<Paint, RangeSet<Integer>> boldTextColors = new HashMap<>();
		Map<Paint, RangeSet<Integer>> italicTextColors = new HashMap<>();
		Map<Paint, RangeSet<Integer>> italicBoldTextColors = new HashMap<>();

		for( PaintRange r : getPaintRanges() ) {
			if( ! normalFont.subRangeSet(r.range).isEmpty() ) {
				RangeSet<Integer> set = normalTextColors.computeIfAbsent(r.paint, p -> TreeRangeSet.create());
				set.addAll(normalFont.subRangeSet(r.range));
			} else {
				if( ! boldItalicRange.isEmpty() && ! boldItalicRange.subRangeSet(r.range).isEmpty() ) {
					RangeSet<Integer> set = italicBoldTextColors.computeIfAbsent(r.paint, p -> TreeRangeSet.create());
					set.addAll(boldItalicRange.subRangeSet(r.range));
				} else if( ! italicRange.subRangeSet(r.range).isEmpty() ) {
					RangeSet<Integer> set = italicTextColors.computeIfAbsent(r.paint, p -> TreeRangeSet.create());
					set.addAll(italicRange.subRangeSet(r.range));
				} else if( ! boldRange.subRangeSet(r.range).isEmpty() ) {
					RangeSet<Integer> set = boldTextColors.computeIfAbsent(r.paint, p -> TreeRangeSet.create());
					set.addAll(boldRange.subRangeSet(r.range));
				}
			}
		}

		Arrays.fill(this.tabReplace, ' ');

		List<Node> l = new ArrayList<>();
		l.addAll(createTextNodes(normalTextColors, this.originalText, this.tabReplace, this.normal));
		l.addAll(createTextNodes(boldTextColors, this.originalText, this.tabReplace, this.bold));
		l.addAll(createTextNodes(italicTextColors, this.originalText, this.tabReplace, this.italic));
		l.addAll(createTextNodes(italicBoldTextColors, this.originalText, this.tabReplace, this.boldItalic));

		l.stream().forEach( n -> System.err.println(n));

		this.node.getChildren().setAll(l);
	}

	private static List<Text> createTextNodes(Map<Paint, RangeSet<Integer>> textColorRanges, char[] text, char[] tabReplace, Font font) {
		List<Text> nodes = new ArrayList<>();

		for( Entry<Paint, RangeSet<Integer>> e : textColorRanges.entrySet() ) {
			char[] txt = TextUtil.replace(text, ' ', ( idx, ch ) -> {
				return ch != '\t' && ! e.getValue().contains(idx);
			});
			Text tNode = new Text(String.valueOf(TextUtil.replaceAll(txt, '\r', tabReplace)));
			tNode.setFont(font);
			tNode.setFill(e.getKey());
			nodes.add(tNode);
		}

		return nodes;
	}

	class LayoutPane extends Region {
		@Override
		protected ObservableList<Node> getChildren() {
			return super.getChildren();
		}

		@Override
		protected void layoutChildren() {
			refreshLayout();
			getChildren().forEach( c -> c.resizeRelocate(0, 0, c.prefWidth(-1), c.prefHeight(-1)));
		}

		@Override
		protected double computeMinHeight(double width) {
			return Util.getSize(normal, ' ').height;
		}

		@Override
		protected double computePrefHeight(double width) {
			return super.computeMinHeight(width);
		}

		@Override
		protected double computeMaxHeight(double width) {
			return super.computeMinHeight(width);
		}

		@Override
		protected double computeMinWidth(double height) {
			return Util.getSize(SingleTextStyledLineRenderer.this.normal, ' ').width * SingleTextStyledLineRenderer.this.displayedText.length;
		}

		@Override
		protected double computePrefWidth(double height) {
			return super.computeMinWidth(height);
		}

		@Override
		protected double computeMaxWidth(double height) {
			return super.computeMinWidth(height);
		}
	}
}
