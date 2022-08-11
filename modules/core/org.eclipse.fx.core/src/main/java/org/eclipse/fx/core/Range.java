/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
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
