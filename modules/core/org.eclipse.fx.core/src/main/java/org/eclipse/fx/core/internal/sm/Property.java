/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.internal.sm;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.namespace.QName;

/**
 * A property model
 */
public class Property {
	private String name;
	private String type;
	private String value;
	private Map<QName, String> otherAttributes = new HashMap<>();

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

	@XmlAnyAttribute
    public Map<QName, String> getOtherAttributes() {
		return this.otherAttributes;
	}
	
	public void setOtherAttributes(Map<QName, String> otherAttributes) {
		this.otherAttributes = otherAttributes;
	}
}
