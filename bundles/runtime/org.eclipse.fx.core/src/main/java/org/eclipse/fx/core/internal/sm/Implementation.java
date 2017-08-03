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
 * The implementation model
 */
public class Implementation {
	private String clazz;

	/**
	 * @return the implementation class
	 */
	@XmlAttribute(name = "class")
	public String getClazz() {
		return this.clazz;
	}

	/**
	 * Set the implementation class
	 *
	 * @param clazz
	 *            the class
	 */
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

}
