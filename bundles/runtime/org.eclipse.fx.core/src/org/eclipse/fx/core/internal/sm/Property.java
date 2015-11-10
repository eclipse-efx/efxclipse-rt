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
 * A property model
 */
public class Property {
	private String name;
	private String type;
	private String value;

	/**
	 * @return the name
	 */
	@XmlAttribute
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name
	 *
	 * @param name
	 *            the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	@XmlAttribute
	public String getType() {
		return this.type;
	}

	/**
	 * Set the type
	 *
	 * @param type
	 *            the type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the value
	 */
	@XmlAttribute
	public String getValue() {
		return this.value;
	}

	/**
	 * Set the value
	 *
	 * @param value
	 *            the value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
