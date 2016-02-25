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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.fx.ui.controls.styledtext.StyleRange;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.StyledTextContent;
import org.eclipse.fx.ui.controls.styledtext.TextSelection;
import org.eclipse.fx.ui.controls.styledtext.model.Annotation;
import org.eclipse.fx.ui.controls.styledtext.model.AnnotationProvider;
import org.eclipse.fx.ui.controls.styledtext.model.TextAnnotation;
import org.eclipse.jdt.annotation.NonNull;

import com.google.common.collect.Range;

public class LineHelper {

	private StyledTextArea control;

	public LineHelper(StyledTextArea control) {
		this.control = control;
	}

	private StyledTextContent getContent() {
		return this.control.getContent();
	}

	private Range<Integer> getSelection() {
		@NonNull
		TextSelection selection = this.control.getSelection();
		return Range.closedOpen(selection.offset, selection.offset + selection.length);
	}

	public boolean isValidLineIndex(int index) {
		return getContent().getLineCount() > index;
	}

	private int getCaretOffset() {
		return this.control.getCaretOffset();
	}

	private StyleRange[] getStyleRanges(int start, int length, boolean includeRanges) {
		return this.control.getStyleRanges(start, length, includeRanges);
	}

	private Set<AnnotationProvider> getAnnotationProvider() {
		return this.control.getAnnotationProvider();
	}



	public int getOffset(int index) {
		return getContent().getOffsetAtLine(index);
	}

	public int getLength(int index) {
		return getText(index).length();
	}

	public int getLengthCountTabsAsChars(int index) {
		String t = getText(index);
		return t.length() + countTabs(t) * 3;
	}

	public String getText(int index) {
		return getContent().getLine(index);
	}

	public Range<Integer> getRange(int index) {
		int lower = getOffset(index);
		int upper = lower + getLength(index);
		return Range.closed(lower, upper);
	}

	private int mapToLocal(int index, int globalOffset) {
		return globalOffset - getOffset(index);
	}

	private com.google.common.collect.Range<Integer> mapToLocal(int index, com.google.common.collect.Range<Integer> global) {
		return com.google.common.collect.Range.range(global.lowerEndpoint() - getOffset(index), global.lowerBoundType(), global.upperEndpoint() - getOffset(index), global.upperBoundType());
	}

	public Range<Integer> getSelection(int index) {
		Range<Integer> selection = getSelection();
		if (selection.isEmpty()) {
			return null;
		}

		Range<Integer> range = getRange(index);

		Range<Integer> localSelection = null;

		if (range.isConnected(selection)) {
			Range<Integer> intersection = selection.intersection(range);
			localSelection = mapToLocal(index, intersection);
		}

		if (localSelection != null) {
			if(ContentView.debugOut) System.err.println(index + " linerange - " + range);
			if(ContentView.debugOut) System.err.println(index + " globalSelection - " + selection);
			if(ContentView.debugOut) System.err.println(index + " localSelection - " + localSelection);
		}

		return localSelection;
	}

	public int getCaret(int index) {
		int globalCaret = getCaretOffset();
		Range<Integer> range = getRange(index);
		if (range.contains(globalCaret)) {
			return mapToLocal(index, globalCaret);
		}
		else {
			return -1;
		}
	}

	private Segment createSegement(String text, StyleRange style) {
		List<String> styleClasses = new ArrayList<>();
		if (style.stylename != null) {
			if (style.stylename.contains(".")) { //$NON-NLS-1$
				List<String> styles = new ArrayList<String>(Arrays.asList(style.stylename.split("\\."))); //$NON-NLS-1$
				styles.add(0, "source-segment"); //$NON-NLS-1$
				styleClasses.addAll(styles);
			} else {
				styleClasses.add("source-segment"); //$NON-NLS-1$
				styleClasses.add(style.stylename);
			}

		} else {
			if (style.foreground != null) {
				styleClasses.add("plain-source-segment"); //$NON-NLS-1$
			} else {
				styleClasses.add("source-segment"); //$NON-NLS-1$
			}
		}
		return new Segment(text, styleClasses);
	}

	static String removeLineending(String s) {
		return s.replace("\n", "").replace("\r", ""); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	public List<Segment> getSegments(int index) {
		List<Segment> segments = new ArrayList<>();

		String line = getContent().getLine(index);
		if (line != null) {
			int start = getContent().getOffsetAtLine(index);
			int length = line.length();

			StyleRange[] ranges = getStyleRanges(start, length, true);
			if (ranges == null) {
				return Collections.emptyList();
			}

			if (ranges.length == 0 && line.length() > 0) {
				StyleRange styleRange = new StyleRange((String) null);
				styleRange.start = start;
				styleRange.length = line.length();

				String text = removeLineending(line.substring(0, line.length()));

				segments.add(createSegement(text, styleRange));
			} else {
				int lastIndex = -1;

				if (ranges.length > 0) {
					if (ranges[0].start - start > 0) {
						StyleRange styleRange = new StyleRange((String) null);
						styleRange.start = start;
						styleRange.length = ranges[0].start - start;

						String text = removeLineending(line.substring(0, ranges[0].start - start));

						segments.add(createSegement(text, styleRange));
					}
				}

				for (StyleRange r : ranges) {
					int begin = r.start - start;
					int end = r.start - start + r.length;

					if (lastIndex != -1 && lastIndex != begin) {
						StyleRange styleRange = new StyleRange((String) null);
						styleRange.start = start + lastIndex;
						styleRange.length = begin - lastIndex;

						String text = removeLineending(line.substring(lastIndex, begin));

						segments.add(createSegement(text, styleRange));
					}

					String text = removeLineending(line.substring(begin, end));

					segments.add(createSegement(text, r));
					lastIndex = end;
				}

				if (lastIndex > 0 && lastIndex < line.length()) {
					StyleRange styleRange = new StyleRange((String) null);
					styleRange.start = start + lastIndex;
					styleRange.length = line.length() - lastIndex;

					String text = removeLineending(line.substring(lastIndex, line.length()));

					segments.add(createSegement(text, styleRange));
				}
			}
		}

		return segments;
	}

	public Set<TextAnnotation> getTextAnnotations(int index) {
		return getAnnotations(index).stream().filter(m->m instanceof TextAnnotation).map(m->(TextAnnotation)m).collect(Collectors.toSet());
	}

	public Set<Annotation> getAnnotations(int index) {
		// collect all the annotations for this line
		Set<Annotation> result = getAnnotationProvider()
			.stream().map(p->p.computeAnnotations(index))
			.flatMap(Collection::stream)
			.collect(Collectors.toSet());
		return result;
	}

	private int countTabs(String s) {
		Matcher matcher = Pattern.compile("\t").matcher(s);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
		return count;
	}


}
