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

import java.util.List;

@SuppressWarnings("javadoc")
public class Segment {
	String text;
	List<String> styleClasses;

	public String getText() {
		return this.text;
	}

	public List<String> getStyleClasses() {
		return this.styleClasses;
	}

	public Segment(String text, List<String> styleClasses) {
		this.text = text;
		this.styleClasses = styleClasses;
	}

	@Override
	public String toString() {
		return "Segment(" + this.text + ", " + this.styleClasses + ")";   //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.styleClasses == null) ? 0 : this.styleClasses.hashCode());
		result = prime * result + ((this.text == null) ? 0 : this.text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segment other = (Segment) obj;
		if (this.styleClasses == null) {
			if (other.styleClasses != null)
				return false;
		} else if (!this.styleClasses.equals(other.styleClasses))
			return false;
		if (this.text == null) {
			if (other.text != null)
				return false;
		} else if (!this.text.equals(other.text))
			return false;
		return true;
	}



}
