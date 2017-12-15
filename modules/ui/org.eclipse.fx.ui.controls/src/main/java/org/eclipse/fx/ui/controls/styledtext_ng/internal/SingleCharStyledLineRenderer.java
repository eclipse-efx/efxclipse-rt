package org.eclipse.fx.ui.controls.styledtext_ng.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.Triple;
import org.eclipse.fx.core.geom.Size;
import org.eclipse.fx.core.text.TextUtil;
import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.styledtext_ng.StyledLineRenderer;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

import javafx.beans.value.WritableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SingleCharStyledLineRenderer implements StyledLineRenderer {
	private final LayoutPane node;
	private final int tabAdvance = 4;
	private int[] tabPositions;
	private char[] renderedText = new char[0];
	private char[] originalText = new char[0];
	double h;
	double w;
	List<TextNode> currentNodes = new ArrayList<TextNode>();

	private Font normal;
	private Font bold;
	private Font italic;
	private Font boldItalic;

	private RangeSet<Integer> boldRange = TreeRangeSet.create();
	private RangeSet<Integer> italicRange = TreeRangeSet.create();
	private List<PaintRange> paintRanges = new ArrayList<>();

	private boolean combinedAction;
	private int flag = 0;

	private static final int FONTS = 1;
	private static final int FILL = 1 << 1;

	public SingleCharStyledLineRenderer() {
		this.node = new LayoutPane(this);
	}

	@Override
	public void setVisibleRange(double minX, double maxX) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFont(String family, double size) {
		this.normal = Font.font(family, size);
		this.bold = Font.font(family, FontWeight.BOLD, size);
		this.italic = Font.font(family, FontPosture.ITALIC, size);
		this.boldItalic = Font.font(family, FontWeight.BOLD, FontPosture.ITALIC, size);

		Size dim = Util.getSize(this.normal, 'A');
		this.w = dim.width;
		this.h = dim.height;
		rebuildFonts();
		this.node.requestLayout();
	}

	@Override
	public Subscription setBold(org.eclipse.fx.core.Range r) {
		Range<Integer> range = Range.closed(r.start, r.end-1);
		this.boldRange.add(range);
		rebuildFonts();
		return () -> {
			this.boldRange.remove(range);
			rebuildFonts();
		};
	}

	@Override
	public Subscription setItalic(org.eclipse.fx.core.Range r) {
		Range<Integer> range = Range.closed(r.start, r.end-1);
		this.italicRange.add(range);
		rebuildFonts();
		return () -> {
			this.italicRange.remove(range);
			rebuildFonts();
		};
	}

	@Override
	public Subscription setForeground(Paint paint, org.eclipse.fx.core.Range r) {
		PaintRange range = new PaintRange(paint, Range.closed(r.start, r.end-1));
		this.paintRanges.add(range);
		rebuildFill();
		return () -> {
			this.paintRanges.remove(range);
			rebuildFill();
		};
	}

	static class PaintRange {
		final Paint paint;
		final Range<Integer> range;

		public PaintRange(Paint paint, Range<Integer> range) {
			this.paint = paint;
			this.range = range;
		}
	}

	@Override
	public void setText(char[] text) {
		Triple<char[], int[], int[]> rv = TextUtil.replaceTabBySpace(text, this.tabAdvance);
		this.tabPositions = rv.value3;
		this.originalText = text;
		if( rv.value3.length == 0 ) {
			this.renderedText = text;
		} else {
			this.renderedText = rv.value1;
		}
		rebuild();
	}

	private Paint getPaint(int index) {
		for( PaintRange r : this.paintRanges ) {
			if( r.range.contains(index) ) {
				return r.paint;
			}
		}

		return Color.BLACK;
	}

	private void rebuild() {
		List<TextNode> l = new ArrayList<>(this.originalText.length);
		for( int i = 0; i < this.renderedText.length; i++ ) {
			if( this.renderedText[i] != ' ' ) {
				TextNode node = new TextNode(i,this.renderedText[i]);
				node.setFontData(this.boldRange.contains(i), this.italicRange.contains(i));
				node.setFill(getPaint(i));
				updateFont(node);
				l.add( node );

			}
		}
		this.currentNodes = l;
		this.node.getChildren().setAll(this.currentNodes);

		this.node.requestLayout();
	}

	private void rebuildFonts() {
		if( this.combinedAction ) {
			this.flag |= FONTS;
		} else {
			for( TextNode t : this.currentNodes ) {
				t.setFontData(this.boldRange.contains(t.index), this.italicRange.contains(t.index));
			}
			this.currentNodes.forEach(this::updateFont);
		}
	}

	private void rebuildFill() {
		if( this.combinedAction ) {
			this.flag |= FILL;
		} else {
			this.currentNodes.forEach( n -> n.setFill(getPaint(n.index)));
		}
	}

	public void combinedAction(Runnable r) {
		this.combinedAction = true;
		try {
			r.run();
		} finally {
			this.combinedAction = false;
		}

		if( (this.flag & FONTS) == FONTS ) {
			rebuildFonts();
		}

		if( (this.flag & FILL) == FILL ) {
			rebuildFill();
		}
	}

	private void updateFont(TextNode node) {
		if( node.bold && node.italic ) {
			node.setFont(this.boldItalic);
		} else if( node.bold ) {
			node.setFont(this.bold);
		} else if( node.italic ) {
			node.setFont(this.italic);
		} else {
			node.setFont(this.normal);
		}
	}

	@Override
	public void clearStyles() {
		// TODO Auto-generated method stub

	}

	@Override
	public Node getNode() {
		return this.node;
	}

	public double getCharWidth() {
		return this.w;
	}

	public double getCharHeight() {
		return this.h;
	}

	public double getWidth() {
		return this.w * this.renderedText.length;
	}

	public double getHeight() {
		return this.h;
	}

	static class TextNode extends Text {
		final int index;
		boolean bold;
		boolean italic;

		public TextNode(int index, char c) {
			super(TextUtil.toString(c));
			setManaged(false);
			this.index = index;
		}

		public void setFontData(boolean bold, boolean italic) {
			this.bold = bold;
			this.italic = italic;
		}
	}

	static class LayoutPane extends Region {
		private SingleCharStyledLineRenderer r;
		public LayoutPane(SingleCharStyledLineRenderer r) {
			this.r = r;
		}

		@Override
		public ObservableList<Node> getChildren() {
			return super.getChildren();
		}

//		@Override
//		protected void impl_processCSS(WritableValue<Boolean> unused) {
//			// no css in this area
//		}

		@Override
		protected void layoutChildren() {
			double w = this.r.getCharWidth();
			double h = this.r.getCharHeight();
			this.r.currentNodes.forEach( n -> n.resizeRelocate(n.index * w, 0, w, h));
		}

		@Override
		protected double computeMinWidth(double height) {
			return r.getWidth();
		}

		@Override
		protected double computeMinHeight(double width) {
			System.err.println("MIn: " + getHeight());
			return r.getCharHeight();
		}

		@Override
		protected double computePrefHeight(double width) {
			System.err.println("PREF: " + getHeight());
			return r.getCharHeight();
		}

		@Override
		protected double computePrefWidth(double height) {
			return r.getWidth();
		}

		@Override
		protected double computeMaxHeight(double width) {
			return r.getCharHeight();
		}

		@Override
		protected double computeMaxWidth(double height) {
			return r.getWidth();
		}
	}
}
