/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.eclipse.fx.core.Range;
import org.eclipse.fx.core.array.ArrayUtils;

/**
 * {@link CharSequence} who is built from annotated segments
 *
 * @param <T>
 *            the annotation type
 *
 * @since 3.0
 */
public final class AnnotatedString<T> implements CharSequence {
	final char[] content;
	final int[][] ranges;
	final T[][] annotations;

	/**
	 * Consumes a segment
	 *
	 * @param <T>
	 *            the annotation type
	 */
	public interface SegmentConsumer<T> {
		/**
		 * Consumes a segment
		 *
		 * @param segmentIndex
		 *            the index of the processed segment
		 *
		 * @param start
		 *            the start index (inclusive)
		 * @param end
		 *            the end index (exclusive)
		 * @param annotation
		 *            the annotations
		 */
		public void accept(int segmentIndex, int start, int end, T[] annotation);
	}

	/**
	 * A segment of the {@link AnnotatedString}
	 */
	public class Segment {
		private final int idx;

		Segment(int idx) {
			this.idx = idx;
		}

		/**
		 * @return the text in the segment
		 */
		public char[] text() {
			return Arrays.copyOfRange(AnnotatedString.this.content, start(), end());
		}

		/**
		 * @return stream of characters
		 */
		public IntStream chars() {
			return ArrayUtils.stream(AnnotatedString.this.content, start(), end());
		}

		/**
		 * @return the start index of the segment (inclusive)
		 */
		public int start() {
			return AnnotatedString.this.ranges[this.idx][0];
		}

		/**
		 * @return the end index of the segment (exclusive)
		 */
		public int end() {
			return AnnotatedString.this.ranges[this.idx][1];
		}

		/**
		 * @return annotations
		 */
		public T[] annotations() {
			return Arrays.copyOf(AnnotatedString.this.annotations[this.idx],
					AnnotatedString.this.annotations[this.idx].length);
		}
	}

	AnnotatedString(char[] content, int[][] ranges, T[][] annotations) {
		this.content = content;
		this.ranges = ranges;
		this.annotations = annotations;
	}

	/**
	 * Apply the consumer on each segment
	 *
	 * @param consumer
	 *            the consumer
	 */
	public void forEachSegment(SegmentConsumer<T> consumer) {
		for (int r = 0; r < this.ranges.length; r++) {
			consumer.accept(r, this.ranges[r][0], this.ranges[r][1], this.annotations[r]);
		}
	}

	/**
	 * @return stream of segments
	 */
	public Stream<Segment> stream() {
		return IntStream.range(0, this.ranges.length).mapToObj(Segment::new);

	}

	/**
	 * Get the content for the provided index
	 *
	 * @param segmentIndex
	 *            the index
	 * @return the content
	 */
	public char[] getContent(int segmentIndex) {
		return Arrays.copyOfRange(this.content, this.ranges[segmentIndex][0], this.ranges[segmentIndex][1]);
	}

	/**
	 * Copy the content to the provided character array
	 *
	 * @param segmentIndex
	 *            the segment index
	 * @param target
	 *            the target array
	 * @return the number of chars copied to the target
	 */
	public int copyContent(int segmentIndex, char[] target) {
		int l = this.ranges[segmentIndex][1] - this.ranges[segmentIndex][0];
		System.arraycopy(this.content, 0, target, 0, l);
		return l;
	}

	@Override
	public int length() {
		return this.content.length;
	}

	@Override
	public char charAt(int index) {
		return this.content[index];
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		int idx = -1;
		for (int i = 0; i < this.ranges.length; i++) {
			if (Range.intersects(start, end, this.ranges[i][0], this.ranges[i][1])) {
				idx = i;
				break;
			}
		}

		int[][] targetRange = Arrays.copyOfRange(this.ranges, 0, 0);
		@SuppressWarnings("unchecked")
		Class<T> type = (Class<T>) this.annotations.getClass().getComponentType();
		T[][] targetAnnotation = ArrayUtils.createArray2Dim(type, 0);
		if (idx != -1) {
			targetRange = Arrays.copyOf(this.ranges, this.ranges.length - idx);
			targetAnnotation = Arrays.copyOf(this.annotations, this.annotations.length - idx);
		}

		return new AnnotatedString<T>(Arrays.copyOfRange(this.content, start, end), targetRange, targetAnnotation);
	}

	@Override
	public String toString() {
		return String.valueOf(this.content);
	}

	/**
	 * Create a builder to create an {@link AnnotatedString}
	 * 
	 * @param <T>
	 *            the value type
	 * @param type
	 *            the annotation type
	 *
	 * @param capacity
	 *            the initial capacity
	 * @return the builder
	 */
	public static <T> Builder<T> create(Class<T> type, int capacity) {
		return new BuilderImpl<T>(type, capacity);
	}

	private static class Struct<T> {
		int[] range;
		T[] annotations;

		public Struct(int start, int end, T[] annotations) {
			this.range = new int[] { start, end };
			this.annotations = annotations;
		}
	}

	/**
	 * Builder used to create an {@link AnnotatedString}
	 *
	 * @param <T>
	 *            the annotation type
	 */
	public interface Builder<T> {
		/**
		 * Add the provided the character array
		 *
		 * @param c
		 *            the character array
		 * @param annotations
		 *            the annotations
		 * @return the builder
		 */
		@SuppressWarnings("unchecked")
		public Builder<T> add(char[] c, T... annotations);

		/**
		 * Add the provided {@link CharSequence}
		 *
		 * @param s
		 *            the sequence
		 * @param annotations
		 *            the annotations
		 * @return the builder
		 */
		@SuppressWarnings("unchecked")
		public Builder<T> add(CharSequence s, T... annotations);

		/**
		 * @return an {@link AnnotatedString} instance
		 */
		public AnnotatedString<T> build();
	}

	private final static class BuilderImpl<T> implements Builder<T> {
		private StringBuilder builder;
		private final List<Struct<T>> ranges = new ArrayList<>();
		private final Class<T> clazz;

		BuilderImpl(Class<T> clazz, int capacity) {
			this.clazz = clazz;
			this.builder = new StringBuilder(capacity);
		}

		@Override
		@SafeVarargs
		public final Builder<T> add(char[] c, T... annotations) {
			this.ranges.add(new Struct<T>(this.builder.length(), this.builder.length() + c.length, annotations));
			this.builder.append(c);
			return this;
		}

		@Override
		@SafeVarargs
		public final Builder<T> add(CharSequence s, T... annotations) {
			this.ranges.add(new Struct<T>(this.builder.length(), this.builder.length() + s.length(), annotations));
			this.builder.append(s);
			return this;
		}

		@Override
		public AnnotatedString<T> build() {
			char[] content = new char[this.builder.length()];
			this.builder.getChars(0, this.builder.length(), content, 0);

			int[][] ranges = new int[this.ranges.size()][2];
			T[][] annotations = ArrayUtils.createArray2Dim(this.clazz, this.ranges.size());
			ArrayUtils.fill(ranges, i -> this.ranges.get(i).range);
			ArrayUtils.fill(annotations, i -> this.ranges.get(i).annotations);

			return new AnnotatedString<T>(content, ranges, annotations);
		}
	}
}
