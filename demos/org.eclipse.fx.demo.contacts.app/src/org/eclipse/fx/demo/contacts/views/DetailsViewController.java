/******************************************************************************* 
 * Copyright (c) 2012 TESIS DYNAware GmbH and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 *     Torsten Sommer <torsten.sommer@tesis.de> - initial API and implementation 
 *******************************************************************************/
package org.eclipse.fx.demo.contacts.views;

import java.io.ByteArrayInputStream;

import javafx.beans.property.Property;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.fx.demo.contacts.Contact;
import org.eclipse.fx.demo.contacts.ContactsPackage;
import org.eclipse.fx.emf.databinding.edit.EMFEditFXProperties;
import org.eclipse.osgi.internal.signedcontent.Base64;

@SuppressWarnings("restriction")
public class DetailsViewController {

	@FXML
	private ImageView imageView;

	@FXML
	private TextField title;
	private Property<String> titleProperty;

	@FXML
	private TextField firstName;
	private Property<String> firstNameProperty;

	@FXML
	private TextField lastName;
	private Property<String> lastNameProperty;

	@FXML
	private TextField jobTitle;
	private Property<String> jobTitleProperty;

	@FXML
	private TextField note;
	private Property<String> noteProperty;

	@FXML
	private TextField street;
	private Property<String> streetProperty;

	@FXML
	private TextField city;
	private Property<String> cityProperty;

	@FXML
	private TextField zip;
	private Property<String> zipProperty;

	@FXML
	private TextField state;
	private Property<String> stateProperty;

	@FXML
	private TextField country;
	private Property<String> countryProperty;

	@FXML
	private TextField phone;
	private Property<String> phoneProperty;

	@FXML
	private TextField mobile;
	private Property<String> mobileProperty;

	@FXML
	private TextField email;
	private Property<String> emailProperty;

	@FXML
	private TextField webPage;
	private Property<String> webPageProperty;

	// @FXML
	// public void initialize() {
	//
	// }

	public void updateBindings(Contact contact, EditingDomain editingDomain) {
		// General
		titleProperty = rebind(title, titleProperty, contact, ContactsPackage.eINSTANCE.getContact_Title(), editingDomain);
		firstNameProperty = rebind(firstName, firstNameProperty, contact, ContactsPackage.eINSTANCE.getContact_FirstName(), editingDomain);
		lastNameProperty = rebind(lastName, lastNameProperty, contact, ContactsPackage.eINSTANCE.getContact_LastName(), editingDomain);
		jobTitleProperty = rebind(jobTitle, jobTitleProperty, contact, ContactsPackage.eINSTANCE.getContact_JobTitle(), editingDomain);
		noteProperty = rebind(note, noteProperty, contact, ContactsPackage.eINSTANCE.getContact_Note(), editingDomain);

		// Business Address
		streetProperty = rebind(street, streetProperty, contact, ContactsPackage.eINSTANCE.getContact_Street(), editingDomain);
		cityProperty = rebind(city, cityProperty, contact, ContactsPackage.eINSTANCE.getContact_City(), editingDomain);
		zipProperty = rebind(zip, zipProperty, contact, ContactsPackage.eINSTANCE.getContact_Zip(), editingDomain);
		stateProperty = rebind(state, stateProperty, contact, ContactsPackage.eINSTANCE.getContact_State(), editingDomain);
		countryProperty = rebind(country, countryProperty, contact, ContactsPackage.eINSTANCE.getContact_Country(), editingDomain);

		// Business Phones
		phoneProperty = rebind(phone, phoneProperty, contact, ContactsPackage.eINSTANCE.getContact_Phone(), editingDomain);
		mobileProperty = rebind(mobile, mobileProperty, contact, ContactsPackage.eINSTANCE.getContact_Mobile(), editingDomain);

		// Business Internet
		emailProperty = rebind(email, emailProperty, contact, ContactsPackage.eINSTANCE.getContact_Email(), editingDomain);
		webPageProperty = rebind(webPage, webPageProperty, contact, ContactsPackage.eINSTANCE.getContact_WebPage(), editingDomain);

		// image
		Image image = null;
		if (contact != null) {
			String jpegString = contact.getJpegString();
			if (jpegString != null) {
				byte[] imageBytes = Base64.decode(jpegString.getBytes());
				ByteArrayInputStream is = new ByteArrayInputStream(imageBytes);
				image = new Image(is);
			}
		}
		imageView.setImage(image);
	}

	Property<String> rebind(TextField textField, Property<String> oldProperty, Contact contact, EStructuralFeature feature,
			EditingDomain editingDomain) {
		if (oldProperty != null)
			textField.textProperty().unbindBidirectional(oldProperty);

		Property<String> property = null;
		if (contact != null) {
			property = EMFEditFXProperties.value(editingDomain, contact, feature);
			textField.textProperty().bindBidirectional(property);
		}

		textField.setDisable(contact == null);

		if(contact == null)
			textField.clear();
		
		return property;
	}

}
