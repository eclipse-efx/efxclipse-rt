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
 * The provided interface
 */
public class Provide {

	private String iface;

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

}
