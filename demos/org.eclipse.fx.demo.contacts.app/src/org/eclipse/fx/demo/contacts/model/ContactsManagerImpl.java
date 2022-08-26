/*******************************************************************************
 *  Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 *  Contributors: 
 *      Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation
 ******************************************************************************/
package org.eclipse.fx.demo.contacts.model;


import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.fx.demo.contacts.Group;
import org.eclipse.fx.demo.contacts.provider.ContactsItemProviderAdapterFactory;

public class ContactsManagerImpl implements ContactsManager {
	
	protected EditingDomain editingDomain;
	protected VCardContactsResource contactsResource;
	protected ComposedAdapterFactory adapterFactory;
	
	public ContactsManagerImpl() {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ContactsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		
		contactsResource = new VCardContactsResource();
		BasicCommandStack commandStack = new BasicCommandStack();
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack);
		editingDomain.getResourceSet().getResources().add(contactsResource);
	}
	
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}
	
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	@Override
	public Group getRootGroup() {
		return (Group) contactsResource.getContents().get(0);
	}
	
}
