/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.demo.e4.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
	private String firstname;
	private String lastname;
	private String street;
	private String zip;
	private String city;
	
	private PropertyChangeSupport changesupport = new PropertyChangeSupport(this);

	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changesupport.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changesupport.removePropertyChangeListener(listener);
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		changesupport.firePropertyChange("firstname", this.firstname, this.firstname = firstname);
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		changesupport.firePropertyChange("lastname", this.lastname, this.lastname = lastname);
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		changesupport.firePropertyChange("street", this.street, this.street = street);
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		changesupport.firePropertyChange("zip", this.zip, this.zip = zip);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		changesupport.firePropertyChange("city", this.city, this.city = city);
	}

}
