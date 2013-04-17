/**
 *  Copyright (c) 2013 TESIS DYNAware GmbH and others. 
 *  All rights reserved. This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html 
 *  
 *  Contributors: 
 *      Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation
 */
package org.eclipse.fx.demo.contacts.edit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.fx.demo.contacts.Contact;
import org.eclipse.fx.demo.contacts.ContactsFactory;
import org.eclipse.fx.demo.contacts.provider.ContactItemProvider;
import org.eclipse.fx.demo.contacts.provider.ContactsItemProviderAdapterFactory;
import org.junit.Before;
import org.junit.Test;

public class ContactItemProviderTest {

	static final String FIRST_NAME = "Hans";
	static final String LAST_NAME = "Wurst";
	Contact contact;
	ContactItemProvider contactItemProvider;

	@Before
	public void setUp() {
		ContactsItemProviderAdapterFactory adapterFactory = new ContactsItemProviderAdapterFactory();
		contactItemProvider = new ContactItemProvider(adapterFactory);
		contact = ContactsFactory.eINSTANCE.createContact();
	}

	@Test
	public void getTextWithValidName() {
		contact.setFirstName(FIRST_NAME);
		contact.setLastName(LAST_NAME);
		String text = contactItemProvider.getText(contact);
		assertEquals("Text should be '<first name> <last name>' if set", FIRST_NAME + " " + LAST_NAME, text);
	}

	@Test
	public void getTextWithNullName() {
		String text = contactItemProvider.getText(contact);
		assertEquals(" ", text);
	}
	
	@Test
	public void getImageWithValidName() {
		contact.setFirstName(FIRST_NAME);
		contact.setLastName(LAST_NAME);
		Object image = contactItemProvider.getImage(contact);
		assertTrue("Image should be a URL", image instanceof URL);
		URL imageURL = (URL) image;
		assertTrue("Contacts should have a user icon", imageURL.getFile().endsWith("user.png"));
	}
	
	@Test
	public void getImageWithNullName() {
		Object image = contactItemProvider.getImage(contact);
		assertTrue("Image should be a URL", image instanceof ComposedImage);
		ComposedImage composedImage = (ComposedImage) image;
		List<Object> images = composedImage.getImages();
		assertEquals(2, images.size());
		
		// check the base image
		Object baseImage = images.get(0);
		assertTrue("Image should be a URL", baseImage instanceof URL);
		URL baseImageURL = (URL) baseImage;
		assertTrue("Base image should be a contact icon", baseImageURL.getFile().endsWith("user.png"));

		// check the overlay
		Object overlayImage = images.get(1);
		assertTrue("Overlay image should be a URL", overlayImage instanceof URL);
		URL overlayImageURL = (URL) overlayImage;
		assertTrue("Overlay image should be an error bullet", overlayImageURL.getFile().endsWith("bullet_error.png"));
	}
	
}
