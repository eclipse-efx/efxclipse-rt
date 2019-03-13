/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.osgi.fxloader.jpms;

import java.util.Optional;

@SuppressWarnings("javadoc")
public class AddReads {
	final String source;
	final String target;

	public AddReads(String source, String target) {
		this.source = source;
		this.target = target;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.source == null) ? 0 : this.source.hashCode());
		result = prime * result + ((this.target == null) ? 0 : this.target.hashCode());
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
		AddReads other = (AddReads) obj;
		if (this.source == null) {
			if (other.source != null)
				return false;
		} else if (!this.source.equals(other.source))
			return false;
		if (this.target == null) {
			if (other.target != null)
				return false;
		} else if (!this.target.equals(other.target))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.source + "=" + this.target; //$NON-NLS-1$
	}

	/**
	 * Read definition
	 * 
	 * @param value $source-module=$target-module
	 * @return the read definition
	 */
	public static Optional<AddReads> valueOf(String value) {
		int idx = value.indexOf('=');
		if (idx > 0) {
			return Optional.of(new AddReads(value.substring(0, idx), value.substring(idx + 1)));
		}
		return Optional.empty();
	}
}