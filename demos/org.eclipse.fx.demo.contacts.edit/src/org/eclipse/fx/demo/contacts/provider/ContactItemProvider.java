/**
 *  Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 *  All rights reserved. This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html 
 *  
 *  Contributors: 
 *      Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation
 */
package org.eclipse.fx.demo.contacts.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.fx.demo.contacts.Contact;
import org.eclipse.fx.demo.contacts.ContactsPackage;

/**
 * This is the item provider adapter for a {@link at.bestsolution.efxclipse.runtime.demo.contacts.Contact} object.
 * <!-- begin-user-doc -->
 * @implements ITableItemLabelProvider
 * <!-- end-user-doc -->
 * @generated
 */
public class ContactItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource,
		ITableItemLabelProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContactItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addFirstNamePropertyDescriptor(object);
			addMiddleNamePropertyDescriptor(object);
			addLastNamePropertyDescriptor(object);
			addTitlePropertyDescriptor(object);
			addCompanyPropertyDescriptor(object);
			addJobTitlePropertyDescriptor(object);
			addStreetPropertyDescriptor(object);
			addCityPropertyDescriptor(object);
			addZipPropertyDescriptor(object);
			addStatePropertyDescriptor(object);
			addCountryPropertyDescriptor(object);
			addEmailPropertyDescriptor(object);
			addWebPagePropertyDescriptor(object);
			addPhonePropertyDescriptor(object);
			addMobilePropertyDescriptor(object);
			addNotePropertyDescriptor(object);
			addJpegStringPropertyDescriptor(object);
			addSourceFilePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the First Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFirstNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_firstName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_firstName_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__FIRST_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Middle Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMiddleNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_middleName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_middleName_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__MIDDLE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Last Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_lastName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_lastName_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__LAST_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Title feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_title_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_title_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__TITLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Company feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCompanyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_company_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_company_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__COMPANY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Job Title feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJobTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_jobTitle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_jobTitle_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__JOB_TITLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Street feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStreetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_street_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_street_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__STREET,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the City feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_city_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_city_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__CITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Zip feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addZipPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_zip_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_zip_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__ZIP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_state_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_state_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__STATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Country feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCountryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_country_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_country_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__COUNTRY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Email feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEmailPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_email_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_email_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__EMAIL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Web Page feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWebPagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_webPage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_webPage_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__WEB_PAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Phone feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPhonePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_phone_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_phone_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__PHONE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mobile feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMobilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_mobile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_mobile_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__MOBILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Note feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNotePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_note_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_note_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__NOTE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Jpeg String feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addJpegStringPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_jpegString_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_jpegString_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__JPEG_STRING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Source File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Contact_sourceFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Contact_sourceFile_feature", "_UI_Contact_type"),
				 ContactsPackage.Literals.CONTACT__SOURCE_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns Contact.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		Contact contact = (Contact) object;
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(contact);
		Object baseImage = getResourceLocator().getImage("silk/user.png");

		if (diagnostic.getSeverity() != Diagnostic.OK) {
			Object overlayImage = getResourceLocator().getImage("silk/bullet_error.png");
			ArrayList<Object> images = new ArrayList<Object>(2);
			images.add(baseImage);
			images.add(overlayImage);
			return new ComposedImage(images);
		}

		return overlayImage(object, baseImage);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Contact contact = (Contact)object;
		String firstName = contact.getFirstName();
		String lastName = contact.getLastName();
		return (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Contact.class)) {
			case ContactsPackage.CONTACT__FIRST_NAME:
			case ContactsPackage.CONTACT__MIDDLE_NAME:
			case ContactsPackage.CONTACT__LAST_NAME:
			case ContactsPackage.CONTACT__TITLE:
			case ContactsPackage.CONTACT__COMPANY:
			case ContactsPackage.CONTACT__JOB_TITLE:
			case ContactsPackage.CONTACT__STREET:
			case ContactsPackage.CONTACT__CITY:
			case ContactsPackage.CONTACT__ZIP:
			case ContactsPackage.CONTACT__STATE:
			case ContactsPackage.CONTACT__COUNTRY:
			case ContactsPackage.CONTACT__EMAIL:
			case ContactsPackage.CONTACT__WEB_PAGE:
			case ContactsPackage.CONTACT__PHONE:
			case ContactsPackage.CONTACT__MOBILE:
			case ContactsPackage.CONTACT__NOTE:
			case ContactsPackage.CONTACT__JPEG_STRING:
			case ContactsPackage.CONTACT__SOURCE_FILE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ContactsEditPlugin.INSTANCE;
	}
	
	@Override
	public String getColumnText(Object object, int columnIndex) {
		Contact contact = (Contact) object;

		String label = null;
		switch (columnIndex) {
		case 0:
			label = contact.getFirstName();
			break;
		case 1:
			label = contact.getLastName();
			break;
		}

		return label == null ? "n/a" : label;
	}

}
