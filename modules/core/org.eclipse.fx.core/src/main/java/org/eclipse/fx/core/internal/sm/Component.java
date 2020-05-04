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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.namespace.QName;

/**
 * DS Component Model
 */
public abstract class Component {
	private String name;
	private Implementation implementation;
	private Service service;
	private List<Reference> reference = new ArrayList<>();
	private List<Property> property = new ArrayList<>();
	private List<Properties> properties = new ArrayList<>();
	private Map<QName, String> otherAttributes = new HashMap<>();

	/**
	 * @return the implementation model
	 */
	public Implementation getImplementation() {
		return this.implementation;
	}

	/**
	 * Set the implementation model
	 *
	 * @param implementation
	 *            the implementation model
	 */
	public void setImplementation(Implementation implementation) {
		this.implementation = implementation;
	}

	/**
	 * @return the service model
	 */
	public Service getService() {
		return this.service;
	}

	/**
	 * Set the service model
	 *
	 * @param service
	 *            the service model
	 */
	public void setService(Service service) {
		this.service = service;
	}

	/**
	 * @return the reference model list
	 */
	public List<Reference> getReference() {
		return this.reference;
	}

	/**
	 * Set the reference model list
	 *
	 * @param reference
	 *            the model list
	 */
	public void setReference(List<Reference> reference) {
		this.reference = reference;
	}

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
	 * @return the property list
	 */
	public List<Property> getProperty() {
		return this.property;
	}

	/**
	 * Set the property list
	 *
	 * @param property
	 *            the list of properties
	 */
	public void setProperty(List<Property> property) {
		this.property = property;
	}

	/**
	 * @return the properties list
	 */
	public List<Properties> getProperties() {
		return this.properties;
	}

	/**
	 * Set the properties list
	 *
	 * @param properties
	 *            the properties
	 */
	public void setProperties(List<Properties> properties) {
		this.properties = properties;
	}
	
	@XmlAnyAttribute
    public Map<QName, String> getOtherAttributes() {
		return this.otherAttributes;
	}
	
	public void setOtherAttributes(Map<QName, String> otherAttributes) {
		this.otherAttributes = otherAttributes;
	}
}
