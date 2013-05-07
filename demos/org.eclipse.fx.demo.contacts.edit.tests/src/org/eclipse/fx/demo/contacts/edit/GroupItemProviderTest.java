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

import org.eclipse.fx.demo.contacts.ContactsFactory;
import org.eclipse.fx.demo.contacts.Group;
import org.eclipse.fx.demo.contacts.provider.ContactsItemProviderAdapterFactory;
import org.eclipse.fx.demo.contacts.provider.GroupItemProvider;
import org.junit.Before;
import org.junit.Test;

public class GroupItemProviderTest {

	static final String GROUP_NAME = "Dummy Group";
	Group group;
	GroupItemProvider groupItemProvider;

	@Before
	public void setUp() {
		ContactsItemProviderAdapterFactory adapterFactory = new ContactsItemProviderAdapterFactory();
		groupItemProvider = new GroupItemProvider(adapterFactory);
		group = ContactsFactory.eINSTANCE.createGroup();
	}

	@Test
	public void getTextWithValidName() {
		group.setName(GROUP_NAME);
		String text = groupItemProvider.getText(group);
		assertEquals("Text should be the name if set", GROUP_NAME, text);
	}

	@Test
	public void getTextWithNullName() {
		group.setName(null);
		String text = groupItemProvider.getText(group);
		assertEquals("Text should be '?' if the name is null", "?", text);
	}
	
	@Test
	public void getImage() {
		Object image = groupItemProvider.getImage(group);
		assertTrue("Image should be a URL", image instanceof URL);
		URL imageURL = (URL) image;
		assertTrue("Groups should have a folder icon", imageURL.getFile().endsWith("folder.png"));
	}

}
