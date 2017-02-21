package org.eclipse.fx.ui.controls.styledtext_ng.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.fx.core.text.TextUtil;
import org.eclipse.fx.ui.controls.Util;

import com.google.common.collect.RangeSet;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SingleTextGradientStyledLineRenderer extends BaseStyledLineRenderer {
	private final LayoutPane node;

	public SingleTextGradientStyledLineRenderer() {
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

		List<PaintRange> pr = getPaintRanges();
		pr = pr.stream().sorted( (r1,r2) -> r1.range.lowerEndpoint().compareTo(r2.range.lowerEndpoint()) ).collect(Collectors.toList());

		double charWidth = Util.getSize(SingleTextGradientStyledLineRenderer.this.normal, ' ').width;
		double w = charWidth * SingleTextGradientStyledLineRenderer.this.displayedText.length;

		List<Stop> stops = new ArrayList<>(pr.size()*2);
		for( PaintRange r : pr ) {
//			System.err.println(r.range + " => "+ r.range.lowerEndpoint().intValue()*charWidth + " .. " + r.range.upperEndpoint() * charWidth + " = " + r.paint);
			Stop start = new Stop((r.range.lowerEndpoint().intValue() * charWidth) / w, (Color)r.paint);
			Stop end = new Stop(((r.range.upperEndpoint().intValue()+1) * charWidth) / w, (Color)r.paint);
			stops.add(start);
			stops.add(end);
		}
//		stops = new ArrayList<Stop>();
//		stops.add(new Stop(0,Color.RED));
////		stops.add(new Stop(60.009765625,Color.RED));
//		stops.add(new Stop(100,Color.BLUE));
//		System.err.println("width: " + w);
		LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
		System.err.println(lg);

		List<Text> nodes = new ArrayList<>(4);
		if( ! normalFont.isEmpty() ) {
			Text tNode = createTextNode(normalFont, this.originalText, this.tabReplace, this.normal);
			tNode.setFill(lg);
			nodes.add(tNode);
		}

		if( ! boldRange.isEmpty() ) {
			Text tNode = createTextNode(boldRange, this.originalText, this.tabReplace, this.bold);
			tNode.setFill(lg);
			nodes.add(tNode);
		}

		if( ! italicRange.isEmpty() ) {
			Text tNode = createTextNode(italicRange, this.originalText, this.tabReplace, this.italic);
			tNode.setFill(lg);
			nodes.add(tNode);
		}

		if( ! boldItalicRange.isEmpty() ) {
			Text tNode = createTextNode(boldItalicRange, this.originalText, this.tabReplace, this.boldItalic);
			tNode.setFill(lg);
			nodes.add(tNode);
		}

		this.node.getChildren().setAll(nodes);
	}

	private static Text createTextNode(RangeSet<Integer> rangeSet, char[] text, char[] tabReplace, Font font) {
		char[] txt = TextUtil.replace(text, ' ', ( idx, ch ) -> {
			return ch != '\t' && ! rangeSet.contains(Integer.valueOf(idx));
		});

		Text tNode = new Text(String.valueOf(TextUtil.replaceAll(txt, '\r', tabReplace)));
		tNode.setFont(font);
		return tNode;
	}

	class LayoutPane extends Region {
		@Override
		protected void layoutChildren() {
			refreshLayout();
			getChildren().forEach( c -> c.resizeRelocate(0, 0, c.prefWidth(-1), c.prefHeight(-1)));
		}

		@Override
		public ObservableList<Node> getChildren() {
			return super.getChildren();
		}

		@Override
		protected double computeMinHeight(double width) {
			return Util.getSize(SingleTextGradientStyledLineRenderer.this.normal, ' ').height;
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
			return Util.getSize(SingleTextGradientStyledLineRenderer.this.normal, ' ').width * SingleTextGradientStyledLineRenderer.this.displayedText.length;
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
