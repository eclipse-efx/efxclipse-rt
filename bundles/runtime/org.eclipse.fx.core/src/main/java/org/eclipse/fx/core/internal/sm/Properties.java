/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.internal.sm;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Properties model
 */
public class Properties {
	private String entry;

	/**
	 * @return the entry path
	 */
	@XmlAttribute
	public String getEntry() {
		return this.entry;
	}

	/**
	 * Set the entry path
	 * @param entry the entry path
	 */
	public void setEntry(String entry) {
		this.entry = entry;
	}

}
