package org.eclipse.fx.ui.controls.styledtext_ng.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

import org.eclipse.fx.core.geom.Size;
import org.eclipse.fx.core.text.TextUtil;
import org.eclipse.fx.ui.controls.Util;

import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SingleTextStyledLineRenderer extends BaseStyledLineRenderer {
	private final LayoutPane node;
	private double minX = -1;
	private double maxX = -1;
	
	private int startCharIndex = -1;
	private int endCharIndex = -1;
	private double shiftX = 0;

	public SingleTextStyledLineRenderer() {
		this.node = new LayoutPane();
	}

	@Override
	public void setVisibleRange(double minX, double maxX) {
		this.minX = minX;
		this.maxX = maxX;
		rebuildText();
	}

	@Override
	public void clearStyles() {
		// TODO Auto-generated method stub

	}

	@Override
	public Node getNode() {
		return this.node;
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

	void refreshLayout() {
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
		
		if( this.minX != -1 && this.maxX != -1 ) {
			DivisionResult v = charInfo(this.minX, this.normal);
			this.startCharIndex = v.integer;
			this.shiftX = v.remainder * Util.getSize(this.normal, 'A').width * -1;
			
			v = charInfo(this.maxX, this.normal);
			this.endCharIndex = v.integer;
			
			this.node.setClip(new Rectangle(0,0,this.maxX-this.minX,Util.getSize(this.normal, 'A').height));
		} else {
			this.startCharIndex = -1;
			this.endCharIndex = -1;
			this.shiftX = 0;
			if( this.node.getClip() != null ) {
				this.node.setClip(null);	
			}
		}

		List<Node> l = new ArrayList<>();
		l.addAll(createTextNodes(this.startCharIndex, this.endCharIndex, normalTextColors, this.originalText, this.tabReplace, this.normal));
		l.addAll(createTextNodes(this.startCharIndex, this.endCharIndex, boldTextColors, this.originalText, this.tabReplace, this.bold));
		l.addAll(createTextNodes(this.startCharIndex, this.endCharIndex, italicTextColors, this.originalText, this.tabReplace, this.italic));
		l.addAll(createTextNodes(this.startCharIndex, this.endCharIndex, italicBoldTextColors, this.originalText, this.tabReplace, this.boldItalic));

		this.node.getChildren().setAll(l);
	}

	private static List<Text> createTextNodes(int startCharIndex, int endCharIndex, Map<Paint, RangeSet<Integer>> textColorRanges, char[] text, char[] tabReplace, Font font) {
		List<Text> nodes = new ArrayList<>();
		
		for( Entry<Paint, RangeSet<Integer>> e : textColorRanges.entrySet() ) {
			char[] txt = TextUtil.replace(text, ' ', ( idx, ch ) -> {
				return ch != '\t' && ! e.getValue().contains(Integer.valueOf(idx));
			});
			
			char[] cs = TextUtil.replaceAll(txt, '\t', tabReplace);
			if( startCharIndex != -1 && endCharIndex != -1 ) {
				cs = Arrays.copyOfRange(cs, startCharIndex, Math.min(endCharIndex+1, cs.length));
			}
			
			// Do not append empty nodes
			if( ! isEmpty(cs) ) {
				Text tNode = new Text(String.valueOf(cs));
				tNode.setFont(font);
				tNode.setFill(e.getKey());
				nodes.add(tNode);				
			}
		}

		return nodes;
	}
	
	private static boolean isEmpty(char[] cs) {
		for( int i = 0; i < cs.length; i++ ) {
			if( cs[i] != ' ' ) {
				return false;
			}
		}
		return true;
	}
	
	static DivisionResult charInfo(double x, Font font) {
		Size w = Util.getSize(font, 'A');
		double charIdx = x / w.width;
		return new DivisionResult((int)charIdx, charIdx - (int)charIdx);
	}
	
	static class DivisionResult {
		final int integer;
		final double remainder;
		
		public DivisionResult(int integer, double remainder) {
			this.integer = integer;
			this.remainder = remainder;
		}
	}

	class LayoutPane extends Region {
		@Override
		protected ObservableList<Node> getChildren() {
			return super.getChildren();
		}

		@Override
		protected void layoutChildren() {
			refreshLayout();
			getChildren().forEach( c -> c.resizeRelocate(SingleTextStyledLineRenderer.this.shiftX, 0, c.prefWidth(-1), c.prefHeight(-1)));
		}

		@Override
		protected double computeMinHeight(double width) {
			return Util.getSize(SingleTextStyledLineRenderer.this.normal, ' ').height;
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
