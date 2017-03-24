package org.eclipse.fx.ui.controls.styledtext_ng;

import org.eclipse.fx.core.text.DefaultContent;
import org.eclipse.fx.core.text.TextContent;
import org.eclipse.fx.ui.controls.styledtext_ng.internal.ContentArea;
import org.eclipse.fx.ui.controls.styledtext_ng.internal.StyledTextRenderer;
import org.eclipse.jdt.annotation.Nullable;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.Region;

public class StyledTextAreaNG extends Region {
	private final ObjectProperty<TextContent> content = new SimpleObjectProperty<>(this, "content", new DefaultContent());
	private final StyledTextRenderer renderer = new StyledTextRenderer();
	private final ContentArea contentArea;

	public StyledTextAreaNG() {
		this.contentArea = new ContentArea(this);
	}

	public final ObjectProperty<TextContent> contentProperty() {
		return this.content;
	}

	public final TextContent getContent() {
		return this.contentProperty().get();
	}

	public final void setContent(final TextContent content) {
		this.contentProperty().set(content);
	}

	/**
	 * Set the style range
	 *
	 * @param range
	 *            the range
	 */
	public void setStyleRange(@Nullable StyleRange range) {
		if (range != null) {
			if (range.isUnstyled()) {
				setStyleRanges(range.start, range.length, null, null, false);
			} else {
				setStyleRanges(range.start, 0, null, new StyleRange[] { range }, false);
			}
		} else {
			setStyleRanges(0, 0, null, null, true);
		}
	}

	/**
	 * Set the style range
	 *
	 * @param start
	 *            the start
	 * @param length
	 *            the length
	 * @param ranges
	 *            the ranges
	 * @param styles
	 *            the style ranges
	 */
	public void setStyleRanges(int start, int length, int[] ranges, @Nullable StyleRange[] styles) {
		if (ranges == null || styles == null) {
			setStyleRanges(start, length, null, null, false);
		} else {
			setStyleRanges(start, length, ranges, styles, false);
		}
	}

	/**
	 * Set the style ranges
	 *
	 * @param ranges
	 *            the ranges
	 * @param styles
	 *            the style ranges
	 */
	public void setStyleRanges(int[] ranges, @Nullable StyleRange[] styles) {
		if (ranges == null || styles == null) {
			setStyleRanges(0, 0, null, null, true);
		} else {
			setStyleRanges(0, 0, ranges, styles, true);
		}
	}

	/**
	 * Set the style ranges
	 *
	 * @param ranges
	 *            the ranges
	 */
	public void setStyleRanges(@Nullable StyleRange... ranges) {
		setStyleRanges(0, 0, null, ranges, true);
	}

	/**
	 * Replace style ranges
	 *
	 * @param start
	 *            the start
	 * @param length
	 *            the length
	 * @param ranges
	 *            the new ranges
	 */
	public void replaceStyleRanges(int start, int length, @Nullable StyleRange[] ranges) {
		if (ranges == null)
			throw new IllegalArgumentException();
		setStyleRanges(start, length, null, ranges, false);
	}

	void setStyleRanges(int start, int length, int[] ranges, StyleRange[] styles, boolean reset) {
		int charCount = getContent().getCharCount();
		int end = start + length;
		if (start > end || start < 0) {
			throw new IllegalArgumentException();
		}

		if (styles != null) {
			if (end > charCount) {
				throw new IllegalArgumentException();
			}
			if (ranges != null) {
				if (ranges.length != styles.length << 1)
					throw new IllegalArgumentException();
			}
			int lastOffset = 0;
			// boolean variableHeight = false;
			for (int i = 0; i < styles.length; i++) {
				if (styles[i] == null) {
					throw new IllegalArgumentException();
				}
				int rangeStart, rangeLength;
				if (ranges != null) {
					rangeStart = ranges[i << 1];
					rangeLength = ranges[(i << 1) + 1];
				} else {
					rangeStart = styles[i].start;
					rangeLength = styles[i].length;
				}
				if (rangeLength < 0) {
					throw new IllegalArgumentException();
				}
				if (!(0 <= rangeStart && rangeStart + rangeLength <= charCount)) {
					throw new IllegalArgumentException();
				}
				if (lastOffset > rangeStart) {
					throw new IllegalArgumentException();
				}
				// variableHeight |= styles[i].isVariableHeight();
				lastOffset = rangeStart + rangeLength;
			}
			// if (variableHeight) setVariableLineHeight();
		}

		@SuppressWarnings("unused")
		int rangeStart = start, rangeEnd = end;
		if (styles != null && styles.length > 0) {
			if (ranges != null) {
				rangeStart = ranges[0];
				rangeEnd = ranges[ranges.length - 2] + ranges[ranges.length - 1];
			} else {
				rangeStart = styles[0].start;
				rangeEnd = styles[styles.length - 1].start + styles[styles.length - 1].length;
			}
		}

		if (reset) {
			this.renderer.setStyleRanges(null, null);
		} else {
			this.renderer.updateRanges(start, length, length);
		}

		if (styles != null && styles.length > 0) {
			this.renderer.setStyleRanges(ranges, styles);
		}

		this.contentArea.refreshStyleRanges(start,length);
	}

}
