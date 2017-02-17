package org.eclipse.fx.core;

public class Range {
	public final int start;
	public final int end;

	public Range(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public static boolean intersects(int start1, int end1, int start2, int end2) {
		return between(start1, end1, start2) || between(start1, end1, end2);
	}

	public static boolean between(int start, int end, int value) {
		return start <= value && end >= value;
	}
}
