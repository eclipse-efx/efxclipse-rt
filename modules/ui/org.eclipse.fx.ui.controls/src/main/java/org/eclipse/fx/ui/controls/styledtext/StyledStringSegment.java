/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.styledtext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Segment of a {@link StyledString}
 * <p>
 * <b>This is an experimental component provided as a preview we'll improve and
 * fix problems in up coming releases</b>
 * </p>
 * @noreference
 */
public class StyledStringSegment {
	private final String text;
	private final List<String> styleClass;

	/**
	 * Create a segment
	 *
	 * @param text
	 *            the text
	 * @param styleClass
	 *            the style class
	 */
	public StyledStringSegment(String text, String... styleClass) {
		this.text = text;
		this.styleClass = Arrays.asList(styleClass);
	}

	/**
	 * Create a segment
	 *
	 * @param text
	 *            the text
	 * @param styleClass
	 *            the style class
	 */
	public StyledStringSegment(String text, List<String> styleClass) {
		this.text = text;
		this.styleClass = Collections.unmodifiableList(new ArrayList<>(styleClass));
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * @return the style class
	 */
	public List<String> getStyleClass() {
		return this.styleClass;
	}
}
