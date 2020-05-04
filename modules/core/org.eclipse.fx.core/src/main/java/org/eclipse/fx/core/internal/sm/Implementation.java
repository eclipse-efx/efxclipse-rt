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

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.namespace.QName;

/**
 * The implementation model
 */
public class Implementation {
	private String clazz;
	private Map<QName, String> otherAttributes = new HashMap<>();

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

	@XmlAnyAttribute
    public Map<QName, String> getOtherAttributes() {
		return this.otherAttributes;
	}
	
	public void setOtherAttributes(Map<QName, String> otherAttributes) {
		this.otherAttributes = otherAttributes;
	}
}
