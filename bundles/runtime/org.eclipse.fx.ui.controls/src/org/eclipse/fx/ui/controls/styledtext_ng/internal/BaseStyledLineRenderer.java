package org.eclipse.fx.ui.controls.styledtext_ng.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.geom.Size;
import org.eclipse.fx.core.text.TextUtil;
import org.eclipse.fx.ui.controls.Util;
import org.eclipse.fx.ui.controls.styledtext_ng.StyledLineRenderer;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public abstract class BaseStyledLineRenderer implements StyledLineRenderer {
	char[] originalText = new char[0];
	char[] displayedText = new char[0];
	char[] tabReplace = new char[4];

	Font normal;
	Font bold;
	Font italic;
	Font boldItalic;
	double w;
	double h;

	private RangeSet<Integer> boldRange = TreeRangeSet.create();
	private RangeSet<Integer> italicRange = TreeRangeSet.create();
	private List<PaintRange> paintRanges = new ArrayList<>();

	int flag = 0;
	boolean combinedAction;

	static final int FONTS = 1;
	static final int FILL = 1 << 1;
	static final int TEXT = 1 << 2;

	public BaseStyledLineRenderer() {
		Arrays.fill(tabReplace, ' ');
	}

	protected RangeSet<Integer> getNormalRange() {
		TreeRangeSet<Integer> set = TreeRangeSet.create();
		set.add(Range.closed(0, this.originalText.length));
		set.removeAll(this.boldRange);
		set.removeAll(this.italicRange);
		return set;
	}

	protected RangeSet<Integer> getBoldRange() {
		if( this.italicRange.isEmpty() ) {
			return this.boldRange;
		}
		RangeSet<Integer> onlyBold = TreeRangeSet.create(this.boldRange);
		onlyBold.removeAll(this.italicRange);
		return onlyBold;
	}

	protected RangeSet<Integer> getItalicRange() {
		if( this.boldRange.isEmpty() ) {
			return this.italicRange;
		}
		RangeSet<Integer> onlyItalic = TreeRangeSet.create(this.italicRange);
		onlyItalic.removeAll(this.boldRange);
		return onlyItalic;
	}

	protected RangeSet<Integer> getBoldItalicRange() {
		if( this.italicRange.isEmpty() && this.boldRange.isEmpty() ) {
			RangeSet<Integer> italicBoldRange = TreeRangeSet.create(boldRange);
			italicBoldRange.removeAll(italicRange.complement());
			return italicBoldRange;
		}
		return TreeRangeSet.create();
	}

	protected List<PaintRange> getPaintRanges() {
		return paintRanges;
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
		Range<Integer> closed = Range.closed(r.start, r.end-1);
		for( PaintRange pr : paintRanges ) {
			if( pr.range.equals(closed) ) {
				pr.paint = paint;
				rebuildFill();
				return null;
			}
		}

		PaintRange range = new PaintRange(paint, closed);
		this.paintRanges.add(range);
		rebuildFill();
		return () -> {
			this.paintRanges.remove(range);
			rebuildFill();
		};
	}

	@Override
	public void setText(char[] text) {
		this.originalText = text;
		this.displayedText = TextUtil.replaceAll(this.originalText, '\t', this.tabReplace);
		rebuildText();
	}

	static class PaintRange {
		Paint paint;
		final Range<Integer> range;

		public PaintRange(Paint paint, Range<Integer> range) {
			this.paint = paint;
			this.range = range;
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
		if( (this.flag & TEXT) == TEXT ) {
			rebuildText();
		}
	}

	protected abstract void rebuildFill();
	protected abstract void rebuildFonts();
	protected abstract void rebuildText();
}
