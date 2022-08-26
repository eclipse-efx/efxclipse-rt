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
 * The provided interface
 */
public class Provide {

	private String iface;
	
	private Map<QName, String> otherAttributes = new HashMap<>();

	/**
	 * @return the interface
	 */
	@XmlAttribute(name = "interface")
	public String getIface() {
		return this.iface;
	}

	/**
	 * Set the interface
	 *
	 * @param iface
	 *            the interface
	 */
	public void setIface(String iface) {
		this.iface = iface;
	}

	@XmlAnyAttribute
    public Map<QName, String> getOtherAttributes() {
		return this.otherAttributes;
	}
	
	public void setOtherAttributes(Map<QName, String> otherAttributes) {
		this.otherAttributes = otherAttributes;
	}
}
