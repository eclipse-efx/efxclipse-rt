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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;

/**
 * The service model
 */
public class Service {
	private List<Provide> provide = new ArrayList<>();
	private Map<QName, String> otherAttributes = new HashMap<>();

	/**
	 * @return list of provide model elements
	 */
	public List<Provide> getProvide() {
		return this.provide;
	}

	/**
	 * Set the list of provide elements
	 *
	 * @param provide
	 *            the elements
	 */
	public void setProvide(List<Provide> provide) {
		this.provide = provide;
	}

	@XmlAnyAttribute
    public Map<QName, String> getOtherAttributes() {
		return this.otherAttributes;
	}
	
	public void setOtherAttributes(Map<QName, String> otherAttributes) {
		this.otherAttributes = otherAttributes;
	}
}
