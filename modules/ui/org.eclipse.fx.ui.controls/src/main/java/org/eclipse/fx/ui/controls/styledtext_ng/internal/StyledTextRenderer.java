/*******************************************************************************
 * Copyright (c) 2000, 2011 IBM Corporation and others. All rights reserved.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext_ng.internal;

import org.eclipse.fx.core.text.TextChangingEvent;
import org.eclipse.fx.ui.controls.styledtext_ng.StyleRange;

public class StyledTextRenderer {

	StyleRange[] stylesSet;
	int stylesSetCount = 0;
	int[] ranges;
	int styleCount;
	StyleRange[] styles;
	boolean hasLinks;
	LineInfo[] lines;
	int lineCount;
	int[] lineWidth;
	int[] lineHeight;

	final static boolean COMPACT_STYLES = true;
	final static boolean MERGE_STYLES = true;

	final static int GROW = 32;

	public void setStyleRanges(int[] newRanges, StyleRange[] newStyles) {
		int[] _newRanges = newRanges;
		StyleRange[] _newStyles = newStyles;
		if (_newStyles == null) {
			this.stylesSetCount = this.styleCount = 0;
			this.ranges = null;
			this.styles = null;
			this.stylesSet = null;
			this.hasLinks = false;
			return;
		}
		if (_newRanges == null && COMPACT_STYLES) {
			_newRanges = new int[_newStyles.length << 1];
			StyleRange[] tmpStyles = new StyleRange[_newStyles.length];
			if (this.stylesSet == null)
				this.stylesSet = new StyleRange[4];
			for (int i = 0, j = 0; i < _newStyles.length; i++) {
				StyleRange newStyle = _newStyles[i];
				_newRanges[j++] = newStyle.start;
				_newRanges[j++] = newStyle.length;
				int index = 0;
				while (index < this.stylesSetCount) {
					if (this.stylesSet[index].similarTo(newStyle))
						break;
					index++;
				}
				if (index == this.stylesSetCount) {
					if (this.stylesSetCount == this.stylesSet.length) {
						StyleRange[] tmpStylesSet = new StyleRange[this.stylesSetCount + 4];
						System.arraycopy(this.stylesSet, 0, tmpStylesSet, 0, this.stylesSetCount);
						this.stylesSet = tmpStylesSet;
					}
					this.stylesSet[this.stylesSetCount++] = newStyle;
				}
				tmpStyles[i] = this.stylesSet[index];
			}
			_newStyles = tmpStyles;
		}

		if (this.styleCount == 0) {
			if (_newRanges != null) {
				this.ranges = new int[_newRanges.length];
				System.arraycopy(_newRanges, 0, this.ranges, 0, this.ranges.length);
			}
			this.styles = new StyleRange[_newStyles.length];
			System.arraycopy(_newStyles, 0, this.styles, 0, this.styles.length);
			this.styleCount = _newStyles.length;
			return;
		}
		if (_newRanges != null && this.ranges == null) {
			this.ranges = new int[this.styles.length << 1];
			for (int i = 0, j = 0; i < this.styleCount; i++) {
				this.ranges[j++] = this.styles[i].start;
				this.ranges[j++] = this.styles[i].length;
			}
		}
		if (_newRanges == null && this.ranges != null) {
			_newRanges = new int[_newStyles.length << 1];
			for (int i = 0, j = 0; i < _newStyles.length; i++) {
				_newRanges[j++] = _newStyles[i].start;
				_newRanges[j++] = _newStyles[i].length;
			}
		}
		if (this.ranges != null && _newRanges != null) {
			int rangeCount = this.styleCount << 1;
			int start = _newRanges[0];
			int modifyStart = getRangeIndex(start, -1, rangeCount), modifyEnd;
			boolean insert = modifyStart == rangeCount;
			if (!insert) {
				int end = _newRanges[_newRanges.length - 2] + _newRanges[_newRanges.length - 1];
				modifyEnd = getRangeIndex(end, modifyStart - 1, rangeCount);
				insert = modifyStart == modifyEnd && this.ranges[modifyStart] >= end;
			}
			if (insert) {
				addMerge(_newRanges, _newStyles, _newRanges.length, modifyStart, modifyStart);
				return;
			}
			modifyEnd = modifyStart;
			int[] mergeRanges = new int[6];
			StyleRange[] mergeStyles = new StyleRange[3];
			for (int i = 0; i < _newRanges.length; i += 2) {
				int newStart = _newRanges[i];
				int newEnd = newStart + _newRanges[i + 1];
				if (newStart == newEnd)
					continue;
				int modifyLast = 0, mergeCount = 0;
				while (modifyEnd < rangeCount) {
					if (newStart >= this.ranges[modifyStart] + this.ranges[modifyStart + 1])
						modifyStart += 2;
					if (this.ranges[modifyEnd] + this.ranges[modifyEnd + 1] > newEnd)
						break;
					modifyEnd += 2;
				}
				if (this.ranges[modifyStart] < newStart && newStart < this.ranges[modifyStart] + this.ranges[modifyStart + 1]) {
					mergeStyles[mergeCount >> 1] = this.styles[modifyStart >> 1];
					mergeRanges[mergeCount] = this.ranges[modifyStart];
					mergeRanges[mergeCount + 1] = newStart - this.ranges[modifyStart];
					mergeCount += 2;
				}
				mergeStyles[mergeCount >> 1] = _newStyles[i >> 1];
				mergeRanges[mergeCount] = newStart;
				mergeRanges[mergeCount + 1] = _newRanges[i + 1];
				mergeCount += 2;
				if (modifyEnd < rangeCount && this.ranges[modifyEnd] < newEnd && newEnd < this.ranges[modifyEnd] + this.ranges[modifyEnd + 1]) {
					mergeStyles[mergeCount >> 1] = this.styles[modifyEnd >> 1];
					mergeRanges[mergeCount] = newEnd;
					mergeRanges[mergeCount + 1] = this.ranges[modifyEnd] + this.ranges[modifyEnd + 1] - newEnd;
					mergeCount += 2;
					modifyLast = 2;
				}
				int grow = addMerge(mergeRanges, mergeStyles, mergeCount, modifyStart, modifyEnd + modifyLast);
				rangeCount += grow;
				modifyStart = modifyEnd += grow;
			}
		} else {
			int start = _newStyles[0].start;
			int modifyStart = getRangeIndex(start, -1, this.styleCount), modifyEnd;
			boolean insert = modifyStart == this.styleCount;
			if (!insert) {
				int end = _newStyles[_newStyles.length - 1].start + _newStyles[_newStyles.length - 1].length;
				modifyEnd = getRangeIndex(end, modifyStart - 1, this.styleCount);
				insert = modifyStart == modifyEnd && this.styles[modifyStart].start >= end;
			}
			if (insert) {
				addMerge(_newStyles, _newStyles.length, modifyStart, modifyStart);
				return;
			}
			modifyEnd = modifyStart;
			StyleRange[] mergeStyles = new StyleRange[3];
			for (int i = 0; i < _newStyles.length; i++) {
				StyleRange newStyle = _newStyles[i], style;
				int newStart = newStyle.start;
				int newEnd = newStart + newStyle.length;
				if (newStart == newEnd)
					continue;
				int modifyLast = 0, mergeCount = 0;
				while (modifyEnd < this.styleCount) {
					if (newStart >= this.styles[modifyStart].start + this.styles[modifyStart].length)
						modifyStart++;
					if (this.styles[modifyEnd].start + this.styles[modifyEnd].length > newEnd)
						break;
					modifyEnd++;
				}
				style = this.styles[modifyStart];
				if (style.start < newStart && newStart < style.start + style.length) {
					style = mergeStyles[mergeCount++] = (StyleRange) style.clone();
					style.length = newStart - style.start;
				}
				mergeStyles[mergeCount++] = newStyle;
				if (modifyEnd < this.styleCount) {
					style = this.styles[modifyEnd];
					if (style.start < newEnd && newEnd < style.start + style.length) {
						style = mergeStyles[mergeCount++] = (StyleRange) style.clone();
						style.length += style.start - newEnd;
						style.start = newEnd;
						modifyLast = 1;
					}
				}
				int grow = addMerge(mergeStyles, mergeCount, modifyStart, modifyEnd + modifyLast);
				modifyStart = modifyEnd += grow;
			}
		}

	}

	int[] getRanges(int start, int length) {
		if (length == 0)
			return null;
		int[] newRanges;
		int end = start + length - 1;
		if (this.ranges != null) {
			int rangeCount = this.styleCount << 1;
			int rangeStart = getRangeIndex(start, -1, rangeCount);
			if (rangeStart >= rangeCount)
				return null;
			if (this.ranges[rangeStart] > end)
				return null;
			int rangeEnd = Math.min(rangeCount - 2, getRangeIndex(end, rangeStart - 1, rangeCount));
			if (this.ranges[rangeEnd] > end)
				rangeEnd = Math.max(rangeStart, rangeEnd - 2);
			newRanges = new int[rangeEnd - rangeStart + 2];
			System.arraycopy(this.ranges, rangeStart, newRanges, 0, newRanges.length);
		} else {
			int rangeStart = getRangeIndex(start, -1, this.styleCount);
			if (rangeStart >= this.styleCount)
				return null;
			if (this.styles[rangeStart].start > end)
				return null;
			int rangeEnd = Math.min(this.styleCount - 1, getRangeIndex(end, rangeStart - 1, this.styleCount));
			if (this.styles[rangeEnd].start > end)
				rangeEnd = Math.max(rangeStart, rangeEnd - 1);
			newRanges = new int[(rangeEnd - rangeStart + 1) << 1];
			for (int i = rangeStart, j = 0; i <= rangeEnd; i++, j += 2) {
				StyleRange style = this.styles[i];
				newRanges[j] = style.start;
				newRanges[j + 1] = style.length;
			}
		}
		if (start > newRanges[0]) {
			newRanges[1] = newRanges[0] + newRanges[1] - start;
			newRanges[0] = start;
		}
		if (end < newRanges[newRanges.length - 2] + newRanges[newRanges.length - 1] - 1) {
			newRanges[newRanges.length - 1] = end - newRanges[newRanges.length - 2] + 1;
		}
		return newRanges;
	}

	int getRangeIndex(int offset, int low, int high) {
		int _low = low;
		int _high = high;
		if (this.styleCount == 0)
			return 0;
		if (this.ranges != null) {
			while (_high - _low > 2) {
				int index = ((_high + _low) / 2) / 2 * 2;
				int end = this.ranges[index] + this.ranges[index + 1];
				if (end > offset) {
					_high = index;
				} else {
					_low = index;
				}
			}
		} else {
			while (_high - _low > 1) {
				int index = ((_high + _low) / 2);
				int end = this.styles[index].start + this.styles[index].length;
				if (end > offset) {
					_high = index;
				} else {
					_low = index;
				}
			}
		}
		return _high;
	}

	void textChanging(TextChangingEvent event) {
		int start = event.offset;
		int newCharCount = event.newCharCount, replaceCharCount = event.replaceCharCount;
		@SuppressWarnings("unused")
		int newLineCount = event.newLineCount, replaceLineCount = event.replaceLineCount;

		updateRanges(start, replaceCharCount, newCharCount);
		//
		// int startLine = getContent().getLineAtOffset(start);
		// if (replaceCharCount == getContent().getCharCount()) lines =
		// null;
		// if (replaceLineCount == lineCount) {
		// lineCount = newLineCount;
		// lineWidth = new int[lineCount];
		// lineHeight = new int[lineCount];
		// reset(0, lineCount);
		// } else {
		// int delta = newLineCount - replaceLineCount;
		// if (lineCount + delta > lineWidth.length) {
		// int[] newWidths = new int[lineCount + delta + GROW];
		// System.arraycopy(lineWidth, 0, newWidths, 0, lineCount);
		// lineWidth = newWidths;
		// int[] newHeights = new int[lineCount + delta + GROW];
		// System.arraycopy(lineHeight, 0, newHeights, 0, lineCount);
		// lineHeight = newHeights;
		// }
		// if (lines != null) {
		// if (lineCount + delta > lines.length) {
		// LineInfo[] newLines = new LineInfo[lineCount + delta + GROW];
		// System.arraycopy(lines, 0, newLines, 0, lineCount);
		// lines = newLines;
		// }
		// }
		// int startIndex = startLine + replaceLineCount + 1;
		// int endIndex = startLine + newLineCount + 1;
		// System.arraycopy(lineWidth, startIndex, lineWidth, endIndex,
		// lineCount - startIndex);
		// System.arraycopy(lineHeight, startIndex, lineHeight, endIndex,
		// lineCount - startIndex);
		// for (int i = startLine; i < endIndex; i++) {
		// lineWidth[i] = lineHeight[i] = -1;
		// }
		// for (int i = lineCount + delta; i < lineCount; i++) {
		// lineWidth[i] = lineHeight[i] = -1;
		// }
		// if (layouts != null) {
		// int layoutStartLine = startLine - topIndex;
		// int layoutEndLine = layoutStartLine + replaceLineCount + 1;
		// for (int i = layoutStartLine; i < layoutEndLine; i++) {
		// if (0 <= i && i < layouts.length) {
		// if (layouts[i] != null) layouts[i].dispose();
		// layouts[i] = null;
		// if (bullets != null && bulletsIndices != null) bullets[i] = null;
		// }
		// }
		// if (delta > 0) {
		// for (int i = layouts.length - 1; i >= layoutEndLine; i--) {
		// if (0 <= i && i < layouts.length) {
		// endIndex = i + delta;
		// if (0 <= endIndex && endIndex < layouts.length) {
		// layouts[endIndex] = layouts[i];
		// layouts[i] = null;
		// if (bullets != null && bulletsIndices != null) {
		// bullets[endIndex] = bullets[i];
		// bulletsIndices[endIndex] = bulletsIndices[i];
		// bullets[i] = null;
		// }
		// } else {
		// if (layouts[i] != null) layouts[i].dispose();
		// layouts[i] = null;
		// if (bullets != null && bulletsIndices != null) bullets[i] = null;
		// }
		// }
		// }
		// } else if (delta < 0) {
		// for (int i = layoutEndLine; i < layouts.length; i++) {
		// if (0 <= i && i < layouts.length) {
		// endIndex = i + delta;
		// if (0 <= endIndex && endIndex < layouts.length) {
		// layouts[endIndex] = layouts[i];
		// layouts[i] = null;
		// if (bullets != null && bulletsIndices != null) {
		// bullets[endIndex] = bullets[i];
		// bulletsIndices[endIndex] = bulletsIndices[i];
		// bullets[i] = null;
		// }
		// } else {
		// if (layouts[i] != null) layouts[i].dispose();
		// layouts[i] = null;
		// if (bullets != null && bulletsIndices != null) bullets[i] = null;
		// }
		// }
		// }
		// }
		// }
		// if (replaceLineCount != 0 || newLineCount != 0) {
		// int startLineOffset = getContent().getOffsetAtLine(startLine);
		// if (startLineOffset != start) startLine++;
		// updateBullets(startLine, replaceLineCount, newLineCount, true);
		// if (lines != null) {
		// startIndex = startLine + replaceLineCount;
		// endIndex = startLine + newLineCount;
		// System.arraycopy(lines, startIndex, lines, endIndex, lineCount -
		// startIndex);
		// for (int i = startLine; i < endIndex; i++) {
		// lines[i] = null;
		// }
		// for (int i = lineCount + delta; i < lineCount; i++) {
		// lines[i] = null;
		// }
		// }
		// }
		// lineCount += delta;
		// if (maxWidthLineIndex != -1 && startLine <= maxWidthLineIndex &&
		// maxWidthLineIndex <= startLine + replaceLineCount) {
		// maxWidth = 0;
		// maxWidthLineIndex = -1;
		// for (int i = 0; i < lineCount; i++) {
		// if (lineWidth[i] > maxWidth) {
		// maxWidth = lineWidth[i];
		// maxWidthLineIndex = i;
		// }
		// }
		// }
		// }
	}

	int addMerge(int[] mergeRanges, StyleRange[] mergeStyles, int mergeCount, int modifyStart, int modifyEnd) {
		int _mergeCount = mergeCount;
		int _modifyEnd = modifyEnd;
		int rangeCount = this.styleCount << 1;
		StyleRange endStyle = null;
		int endStart = 0, endLength = 0;
		if (_modifyEnd < rangeCount) {
			endStyle = this.styles[_modifyEnd >> 1];
			endStart = this.ranges[_modifyEnd];
			endLength = this.ranges[_modifyEnd + 1];
		}
		int grow = _mergeCount - (_modifyEnd - modifyStart);
		if (rangeCount + grow >= this.ranges.length) {
			int[] tmpRanges = new int[this.ranges.length + grow + (GROW << 1)];
			System.arraycopy(this.ranges, 0, tmpRanges, 0, modifyStart);
			StyleRange[] tmpStyles = new StyleRange[this.styles.length + (grow >> 1) + GROW];
			System.arraycopy(this.styles, 0, tmpStyles, 0, modifyStart >> 1);
			if (rangeCount > _modifyEnd) {
				System.arraycopy(this.ranges, _modifyEnd, tmpRanges, modifyStart + _mergeCount, rangeCount - _modifyEnd);
				System.arraycopy(this.styles, _modifyEnd >> 1, tmpStyles, (modifyStart + _mergeCount) >> 1, this.styleCount - (_modifyEnd >> 1));
			}
			this.ranges = tmpRanges;
			this.styles = tmpStyles;
		} else {
			if (rangeCount > _modifyEnd) {
				System.arraycopy(this.ranges, _modifyEnd, this.ranges, modifyStart + _mergeCount, rangeCount - _modifyEnd);
				System.arraycopy(this.styles, _modifyEnd >> 1, this.styles, (modifyStart + _mergeCount) >> 1, this.styleCount - (_modifyEnd >> 1));
			}
		}
		if (MERGE_STYLES) {
			int j = modifyStart;
			for (int i = 0; i < _mergeCount; i += 2) {
				if (j > 0 && this.ranges[j - 2] + this.ranges[j - 1] == mergeRanges[i] && mergeStyles[i >> 1].similarTo(this.styles[(j - 2) >> 1])) {
					this.ranges[j - 1] += mergeRanges[i + 1];
				} else {
					this.styles[j >> 1] = mergeStyles[i >> 1];
					this.ranges[j++] = mergeRanges[i];
					this.ranges[j++] = mergeRanges[i + 1];
				}
			}
			if (endStyle != null && this.ranges[j - 2] + this.ranges[j - 1] == endStart && endStyle.similarTo(this.styles[(j - 2) >> 1])) {
				this.ranges[j - 1] += endLength;
				_modifyEnd += 2;
				_mergeCount += 2;
			}
			if (rangeCount > _modifyEnd) {
				System.arraycopy(this.ranges, modifyStart + _mergeCount, this.ranges, j, rangeCount - _modifyEnd);
				System.arraycopy(this.styles, (modifyStart + _mergeCount) >> 1, this.styles, j >> 1, this.styleCount - (_modifyEnd >> 1));
			}
			grow = (j - modifyStart) - (_modifyEnd - modifyStart);
		} else {
			System.arraycopy(mergeRanges, 0, this.ranges, modifyStart, _mergeCount);
			System.arraycopy(mergeStyles, 0, this.styles, modifyStart >> 1, _mergeCount >> 1);
		}
		this.styleCount += grow >> 1;
		return grow;
	}

	int addMerge(StyleRange[] mergeStyles, int mergeCount, int modifyStart, int modifyEnd) {
		int _mergeCount = mergeCount;
		int _modifyEnd = modifyEnd;
		int grow = _mergeCount - (_modifyEnd - modifyStart);
		StyleRange endStyle = null;
		if (_modifyEnd < this.styleCount)
			endStyle = this.styles[_modifyEnd];
		if (this.styleCount + grow >= this.styles.length) {
			StyleRange[] tmpStyles = new StyleRange[this.styles.length + grow + GROW];
			System.arraycopy(this.styles, 0, tmpStyles, 0, modifyStart);
			if (this.styleCount > _modifyEnd) {
				System.arraycopy(this.styles, _modifyEnd, tmpStyles, modifyStart + _mergeCount, this.styleCount - _modifyEnd);
			}
			this.styles = tmpStyles;
		} else {
			if (this.styleCount > _modifyEnd) {
				System.arraycopy(this.styles, _modifyEnd, this.styles, modifyStart + _mergeCount, this.styleCount - _modifyEnd);
			}
		}
		if (MERGE_STYLES) {
			int j = modifyStart;
			for (int i = 0; i < _mergeCount; i++) {
				StyleRange newStyle = mergeStyles[i], style;
				if (j > 0 && (style = this.styles[j - 1]).start + style.length == newStyle.start && newStyle.similarTo(style)) {
					style.length += newStyle.length;
				} else {
					this.styles[j++] = newStyle;
				}
			}
			StyleRange style = this.styles[j - 1];
			if (endStyle != null && style.start + style.length == endStyle.start && endStyle.similarTo(style)) {
				style.length += endStyle.length;
				_modifyEnd++;
				_mergeCount++;
			}
			if (this.styleCount > _modifyEnd) {
				System.arraycopy(this.styles, modifyStart + _mergeCount, this.styles, j, this.styleCount - _modifyEnd);
			}
			grow = (j - modifyStart) - (_modifyEnd - modifyStart);
		} else {
			System.arraycopy(mergeStyles, 0, this.styles, modifyStart, _mergeCount);
		}
		this.styleCount += grow;
		return grow;
	}

	public void updateRanges(int start, int replaceCharCount, int newCharCount) {
		if (this.styleCount == 0 || (replaceCharCount == 0 && newCharCount == 0))
			return;
		if (this.ranges != null) {
			int rangeCount = this.styleCount << 1;
			int modifyStart = getRangeIndex(start, -1, rangeCount);
			if (modifyStart == rangeCount)
				return;
			int end = start + replaceCharCount;
			int modifyEnd = getRangeIndex(end, modifyStart - 1, rangeCount);
			int offset = newCharCount - replaceCharCount;
			if (modifyStart == modifyEnd && this.ranges[modifyStart] < start && end < this.ranges[modifyEnd] + this.ranges[modifyEnd + 1]) {
				if (newCharCount == 0) {
					this.ranges[modifyStart + 1] -= replaceCharCount;
					modifyEnd += 2;
				} else {
					if (rangeCount + 2 > this.ranges.length) {
						int[] newRanges = new int[this.ranges.length + (GROW << 1)];
						System.arraycopy(this.ranges, 0, newRanges, 0, rangeCount);
						this.ranges = newRanges;
						StyleRange[] newStyles = new StyleRange[this.styles.length + GROW];
						System.arraycopy(this.styles, 0, newStyles, 0, this.styleCount);
						this.styles = newStyles;
					}
					System.arraycopy(this.ranges, modifyStart + 2, this.ranges, modifyStart + 4, rangeCount - (modifyStart + 2));
					System.arraycopy(this.styles, (modifyStart + 2) >> 1, this.styles, (modifyStart + 4) >> 1, this.styleCount - ((modifyStart + 2) >> 1));
					this.ranges[modifyStart + 3] = this.ranges[modifyStart] + this.ranges[modifyStart + 1] - end;
					this.ranges[modifyStart + 2] = start + newCharCount;
					this.ranges[modifyStart + 1] = start - this.ranges[modifyStart];
					this.styles[(modifyStart >> 1) + 1] = this.styles[modifyStart >> 1];
					rangeCount += 2;
					this.styleCount++;
					modifyEnd += 4;
				}
				if (offset != 0) {
					for (int i = modifyEnd; i < rangeCount; i += 2) {
						this.ranges[i] += offset;
					}
				}
			} else {
				if (this.ranges[modifyStart] < start && start < this.ranges[modifyStart] + this.ranges[modifyStart + 1]) {
					this.ranges[modifyStart + 1] = start - this.ranges[modifyStart];
					modifyStart += 2;
				}
				if (modifyEnd < rangeCount && this.ranges[modifyEnd] < end && end < this.ranges[modifyEnd] + this.ranges[modifyEnd + 1]) {
					this.ranges[modifyEnd + 1] = this.ranges[modifyEnd] + this.ranges[modifyEnd + 1] - end;
					this.ranges[modifyEnd] = end;
				}
				if (offset != 0) {
					for (int i = modifyEnd; i < rangeCount; i += 2) {
						this.ranges[i] += offset;
					}
				}
				System.arraycopy(this.ranges, modifyEnd, this.ranges, modifyStart, rangeCount - modifyEnd);
				System.arraycopy(this.styles, modifyEnd >> 1, this.styles, modifyStart >> 1, this.styleCount - (modifyEnd >> 1));
				this.styleCount -= (modifyEnd - modifyStart) >> 1;
			}
		} else {
			int modifyStart = getRangeIndex(start, -1, this.styleCount);
			if (modifyStart == this.styleCount)
				return;
			int end = start + replaceCharCount;
			int modifyEnd = getRangeIndex(end, modifyStart - 1, this.styleCount);
			int offset = newCharCount - replaceCharCount;
			if (modifyStart == modifyEnd && this.styles[modifyStart].start < start && end < this.styles[modifyEnd].start + this.styles[modifyEnd].length) {
				if (newCharCount == 0) {
					this.styles[modifyStart].length -= replaceCharCount;
					modifyEnd++;
				} else {
					if (this.styleCount + 1 > this.styles.length) {
						StyleRange[] newStyles = new StyleRange[this.styles.length + GROW];
						System.arraycopy(this.styles, 0, newStyles, 0, this.styleCount);
						this.styles = newStyles;
					}
					System.arraycopy(this.styles, modifyStart + 1, this.styles, modifyStart + 2, this.styleCount - (modifyStart + 1));
					this.styles[modifyStart + 1] = (StyleRange) this.styles[modifyStart].clone();
					this.styles[modifyStart + 1].length = this.styles[modifyStart].start + this.styles[modifyStart].length - end;
					this.styles[modifyStart + 1].start = start + newCharCount;
					this.styles[modifyStart].length = start - this.styles[modifyStart].start;
					this.styleCount++;
					modifyEnd += 2;
				}
				if (offset != 0) {
					for (int i = modifyEnd; i < this.styleCount; i++) {
						this.styles[i].start += offset;
					}
				}
			} else {
				if (this.styles[modifyStart].start < start && start < this.styles[modifyStart].start + this.styles[modifyStart].length) {
					this.styles[modifyStart].length = start - this.styles[modifyStart].start;
					modifyStart++;
				}
				if (modifyEnd < this.styleCount && this.styles[modifyEnd].start < end && end < this.styles[modifyEnd].start + this.styles[modifyEnd].length) {
					this.styles[modifyEnd].length = this.styles[modifyEnd].start + this.styles[modifyEnd].length - end;
					this.styles[modifyEnd].start = end;
				}
				if (offset != 0) {
					for (int i = modifyEnd; i < this.styleCount; i++) {
						this.styles[i].start += offset;
					}
				}
				System.arraycopy(this.styles, modifyEnd, this.styles, modifyStart, this.styleCount - modifyEnd);
				this.styleCount -= modifyEnd - modifyStart;
			}
		}
	}

	StyleRange[] getStyleRanges(int start, int length, boolean includeRanges) {
		if (length == 0)
			return null;
		StyleRange[] newStyles;
		int end = start + length - 1;
		if (this.ranges != null) {
			int rangeCount = this.styleCount << 1;
			int rangeStart = getRangeIndex(start, -1, rangeCount);
			if (rangeStart >= rangeCount)
				return null;
			if (this.ranges[rangeStart] > end)
				return null;
			int rangeEnd = Math.min(rangeCount - 2, getRangeIndex(end, rangeStart - 1, rangeCount));
			if (this.ranges[rangeEnd] > end)
				rangeEnd = Math.max(rangeStart, rangeEnd - 2);
			newStyles = new StyleRange[((rangeEnd - rangeStart) >> 1) + 1];
			if (includeRanges) {
				for (int i = rangeStart, j = 0; i <= rangeEnd; i += 2, j++) {
					newStyles[j] = (StyleRange) this.styles[i >> 1].clone();
					newStyles[j].start = this.ranges[i];
					newStyles[j].length = this.ranges[i + 1];
				}
			} else {
				System.arraycopy(this.styles, rangeStart >> 1, newStyles, 0, newStyles.length);
			}
		} else {
			int rangeStart = getRangeIndex(start, -1, this.styleCount);
			if (rangeStart >= this.styleCount)
				return null;
			if (this.styles[rangeStart].start > end)
				return null;
			int rangeEnd = Math.min(this.styleCount - 1, getRangeIndex(end, rangeStart - 1, this.styleCount));
			if (this.styles[rangeEnd].start > end)
				rangeEnd = Math.max(rangeStart, rangeEnd - 1);
			newStyles = new StyleRange[rangeEnd - rangeStart + 1];
			System.arraycopy(this.styles, rangeStart, newStyles, 0, newStyles.length);
		}
		if (includeRanges || this.ranges == null) {
			StyleRange style = newStyles[0];
			if (start > style.start) {
				newStyles[0] = style = (StyleRange) style.clone();
				style.length = style.start + style.length - start;
				style.start = start;
			}
			style = newStyles[newStyles.length - 1];
			if (end < style.start + style.length - 1) {
				newStyles[newStyles.length - 1] = style = (StyleRange) style.clone();
				style.length = end - style.start + 1;
			}
		}
		return newStyles;
	}
}