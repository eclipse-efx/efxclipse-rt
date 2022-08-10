/**
 *  Copyright (c) 2013 TESIS DYNAware GmbH and others. 
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 *  Contributors: 
 *      Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation
 */
package org.eclipse.fx.demo.contacts;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.fx.demo.contacts.Contact;
import org.eclipse.fx.demo.contacts.ContactsFactory;
import org.eclipse.fx.demo.contacts.util.ContactsValidator;
import org.junit.Before;
import org.junit.Test;

public class ContactsValidatorTest {
	
	private Contact contact;
	private DiagnosticChain diagnostics;
	private HashMap<Object, Object> context;
	private ContactsValidator validator;

	@Before
	public void setUp() {
		validator = new ContactsValidator();
		context = new HashMap<>();
		diagnostics = new BasicDiagnostic();
		contact = ContactsFactory.eINSTANCE.createContact();
	}

	@Test
	public void validateContact_ValidEmailWithNullEmail() {
		assertFalse(validator.validateContact_ValidEmail(contact, diagnostics, context));
	}
	
	@Test
	public void validateContact_ValidEmailWithInalidEmail() {
		contact.setEmail("@tesis.de");
		assertFalse(validator.validateContact_ValidEmail(contact, diagnostics, context));
	}
	
	@Test
	public void validateContact_ValidEmailWithValidEmail() {
		contact.setEmail("tsommer@tesis.de");
		assertTrue(validator.validateContact_ValidEmail(contact, diagnostics, context));
	}
	
	@Test
	public void validateContact_ValidFirstNameWithNullName() {
		assertFalse(validator.validateContact_ValidFirstName(contact, diagnostics, context));
	}
	
	@Test
	public void validateContact_ValidFirstNameWithInvalidName() {
		contact.setFirstName("#");
		assertFalse(validator.validateContact_ValidFirstName(contact, diagnostics, context));
	}
	
	@Test
	public void validateContact_ValidFirstNameWithValidName() {
		contact.setFirstName("John");
		assertTrue(validator.validateContact_ValidFirstName(contact, diagnostics, context));
	}
	
	@Test
	public void validateContact_ValidLastNameWithNullName() {
		assertFalse(validator.validateContact_ValidLastName(contact, diagnostics, context));
	}
	
	@Test
	public void validateContact_ValidlastNameWithInvalidName() {
		contact.setLastName("#");
		assertFalse(validator.validateContact_ValidLastName(contact, diagnostics, context));
	}
	
	@Test
	public void validateContact_ValidLastNameWithValidName() {
		contact.setLastName("Doe");
		assertTrue(validator.validateContact_ValidLastName(contact, diagnostics, context));
	}

}
