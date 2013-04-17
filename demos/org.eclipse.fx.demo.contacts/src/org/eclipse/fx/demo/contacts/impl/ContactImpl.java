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
package org.eclipse.fx.demo.contacts.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.fx.demo.contacts.Contact;
import org.eclipse.fx.demo.contacts.ContactsPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getMiddleName <em>Middle Name</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getLastName <em>Last Name</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getCompany <em>Company</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getJobTitle <em>Job Title</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getStreet <em>Street</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getCity <em>City</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getZip <em>Zip</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getCountry <em>Country</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getWebPage <em>Web Page</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getPhone <em>Phone</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getMobile <em>Mobile</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getNote <em>Note</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getJpegString <em>Jpeg String</em>}</li>
 *   <li>{@link org.eclipse.fx.demo.contacts.impl.ContactImpl#getSourceFile <em>Source File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContactImpl extends EObjectImpl implements Contact {
	/**
	 * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected String firstName = FIRST_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getMiddleName() <em>Middle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiddleName()
	 * @generated
	 * @ordered
	 */
	protected static final String MIDDLE_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMiddleName() <em>Middle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiddleName()
	 * @generated
	 * @ordered
	 */
	protected String middleName = MIDDLE_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastName()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLastName() <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastName()
	 * @generated
	 * @ordered
	 */
	protected String lastName = LAST_NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;
	/**
	 * The default value of the '{@link #getCompany() <em>Company</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompany()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPANY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getCompany() <em>Company</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompany()
	 * @generated
	 * @ordered
	 */
	protected String company = COMPANY_EDEFAULT;
	/**
	 * The default value of the '{@link #getJobTitle() <em>Job Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String JOB_TITLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getJobTitle() <em>Job Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobTitle()
	 * @generated
	 * @ordered
	 */
	protected String jobTitle = JOB_TITLE_EDEFAULT;
	/**
	 * The default value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected static final String STREET_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getStreet() <em>Street</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreet()
	 * @generated
	 * @ordered
	 */
	protected String street = STREET_EDEFAULT;
	/**
	 * The default value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected static final String CITY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected String city = CITY_EDEFAULT;
	/**
	 * The default value of the '{@link #getZip() <em>Zip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZip()
	 * @generated
	 * @ordered
	 */
	protected static final String ZIP_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getZip() <em>Zip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZip()
	 * @generated
	 * @ordered
	 */
	protected String zip = ZIP_EDEFAULT;
	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final String STATE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected String state = STATE_EDEFAULT;
	/**
	 * The default value of the '{@link #getCountry() <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountry()
	 * @generated
	 * @ordered
	 */
	protected static final String COUNTRY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getCountry() <em>Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountry()
	 * @generated
	 * @ordered
	 */
	protected String country = COUNTRY_EDEFAULT;
	/**
	 * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected String email = EMAIL_EDEFAULT;
	/**
	 * The default value of the '{@link #getWebPage() <em>Web Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWebPage()
	 * @generated
	 * @ordered
	 */
	protected static final String WEB_PAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getWebPage() <em>Web Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWebPage()
	 * @generated
	 * @ordered
	 */
	protected String webPage = WEB_PAGE_EDEFAULT;
	/**
	 * The default value of the '{@link #getPhone() <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhone()
	 * @generated
	 * @ordered
	 */
	protected static final String PHONE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPhone() <em>Phone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhone()
	 * @generated
	 * @ordered
	 */
	protected String phone = PHONE_EDEFAULT;
	/**
	 * The default value of the '{@link #getMobile() <em>Mobile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMobile()
	 * @generated
	 * @ordered
	 */
	protected static final String MOBILE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMobile() <em>Mobile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMobile()
	 * @generated
	 * @ordered
	 */
	protected String mobile = MOBILE_EDEFAULT;
	/**
	 * The default value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected String note = NOTE_EDEFAULT;
	/**
	 * The default value of the '{@link #getJpegString() <em>Jpeg String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJpegString()
	 * @generated
	 * @ordered
	 */
	protected static final String JPEG_STRING_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getJpegString() <em>Jpeg String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJpegString()
	 * @generated
	 * @ordered
	 */
	protected String jpegString = JPEG_STRING_EDEFAULT;
	/**
	 * The default value of the '{@link #getSourceFile() <em>Source File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFile()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_FILE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSourceFile() <em>Source File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFile()
	 * @generated
	 * @ordered
	 */
	protected String sourceFile = SOURCE_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ContactsPackage.Literals.CONTACT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstName(String newFirstName) {
		String oldFirstName = firstName;
		firstName = newFirstName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__FIRST_NAME, oldFirstName, firstName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMiddleName(String newMiddleName) {
		String oldMiddleName = middleName;
		middleName = newMiddleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__MIDDLE_NAME, oldMiddleName, middleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastName(String newLastName) {
		String oldLastName = lastName;
		lastName = newLastName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__LAST_NAME, oldLastName, lastName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompany(String newCompany) {
		String oldCompany = company;
		company = newCompany;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__COMPANY, oldCompany, company));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJobTitle(String newJobTitle) {
		String oldJobTitle = jobTitle;
		jobTitle = newJobTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__JOB_TITLE, oldJobTitle, jobTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreet(String newStreet) {
		String oldStreet = street;
		street = newStreet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__STREET, oldStreet, street));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCity() {
		return city;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCity(String newCity) {
		String oldCity = city;
		city = newCity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__CITY, oldCity, city));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZip(String newZip) {
		String oldZip = zip;
		zip = newZip;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__ZIP, oldZip, zip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(String newState) {
		String oldState = state;
		state = newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountry(String newCountry) {
		String oldCountry = country;
		country = newCountry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__COUNTRY, oldCountry, country));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmail(String newEmail) {
		String oldEmail = email;
		email = newEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__EMAIL, oldEmail, email));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWebPage() {
		return webPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebPage(String newWebPage) {
		String oldWebPage = webPage;
		webPage = newWebPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__WEB_PAGE, oldWebPage, webPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhone(String newPhone) {
		String oldPhone = phone;
		phone = newPhone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__PHONE, oldPhone, phone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMobile(String newMobile) {
		String oldMobile = mobile;
		mobile = newMobile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__MOBILE, oldMobile, mobile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNote() {
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNote(String newNote) {
		String oldNote = note;
		note = newNote;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__NOTE, oldNote, note));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJpegString() {
		return jpegString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJpegString(String newJpegString) {
		String oldJpegString = jpegString;
		jpegString = newJpegString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__JPEG_STRING, oldJpegString, jpegString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceFile() {
		return sourceFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceFile(String newSourceFile) {
		String oldSourceFile = sourceFile;
		sourceFile = newSourceFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContactsPackage.CONTACT__SOURCE_FILE, oldSourceFile, sourceFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ContactsPackage.CONTACT__FIRST_NAME:
				return getFirstName();
			case ContactsPackage.CONTACT__MIDDLE_NAME:
				return getMiddleName();
			case ContactsPackage.CONTACT__LAST_NAME:
				return getLastName();
			case ContactsPackage.CONTACT__TITLE:
				return getTitle();
			case ContactsPackage.CONTACT__COMPANY:
				return getCompany();
			case ContactsPackage.CONTACT__JOB_TITLE:
				return getJobTitle();
			case ContactsPackage.CONTACT__STREET:
				return getStreet();
			case ContactsPackage.CONTACT__CITY:
				return getCity();
			case ContactsPackage.CONTACT__ZIP:
				return getZip();
			case ContactsPackage.CONTACT__STATE:
				return getState();
			case ContactsPackage.CONTACT__COUNTRY:
				return getCountry();
			case ContactsPackage.CONTACT__EMAIL:
				return getEmail();
			case ContactsPackage.CONTACT__WEB_PAGE:
				return getWebPage();
			case ContactsPackage.CONTACT__PHONE:
				return getPhone();
			case ContactsPackage.CONTACT__MOBILE:
				return getMobile();
			case ContactsPackage.CONTACT__NOTE:
				return getNote();
			case ContactsPackage.CONTACT__JPEG_STRING:
				return getJpegString();
			case ContactsPackage.CONTACT__SOURCE_FILE:
				return getSourceFile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ContactsPackage.CONTACT__FIRST_NAME:
				setFirstName((String)newValue);
				return;
			case ContactsPackage.CONTACT__MIDDLE_NAME:
				setMiddleName((String)newValue);
				return;
			case ContactsPackage.CONTACT__LAST_NAME:
				setLastName((String)newValue);
				return;
			case ContactsPackage.CONTACT__TITLE:
				setTitle((String)newValue);
				return;
			case ContactsPackage.CONTACT__COMPANY:
				setCompany((String)newValue);
				return;
			case ContactsPackage.CONTACT__JOB_TITLE:
				setJobTitle((String)newValue);
				return;
			case ContactsPackage.CONTACT__STREET:
				setStreet((String)newValue);
				return;
			case ContactsPackage.CONTACT__CITY:
				setCity((String)newValue);
				return;
			case ContactsPackage.CONTACT__ZIP:
				setZip((String)newValue);
				return;
			case ContactsPackage.CONTACT__STATE:
				setState((String)newValue);
				return;
			case ContactsPackage.CONTACT__COUNTRY:
				setCountry((String)newValue);
				return;
			case ContactsPackage.CONTACT__EMAIL:
				setEmail((String)newValue);
				return;
			case ContactsPackage.CONTACT__WEB_PAGE:
				setWebPage((String)newValue);
				return;
			case ContactsPackage.CONTACT__PHONE:
				setPhone((String)newValue);
				return;
			case ContactsPackage.CONTACT__MOBILE:
				setMobile((String)newValue);
				return;
			case ContactsPackage.CONTACT__NOTE:
				setNote((String)newValue);
				return;
			case ContactsPackage.CONTACT__JPEG_STRING:
				setJpegString((String)newValue);
				return;
			case ContactsPackage.CONTACT__SOURCE_FILE:
				setSourceFile((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ContactsPackage.CONTACT__FIRST_NAME:
				setFirstName(FIRST_NAME_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__MIDDLE_NAME:
				setMiddleName(MIDDLE_NAME_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__LAST_NAME:
				setLastName(LAST_NAME_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__COMPANY:
				setCompany(COMPANY_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__JOB_TITLE:
				setJobTitle(JOB_TITLE_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__STREET:
				setStreet(STREET_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__CITY:
				setCity(CITY_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__ZIP:
				setZip(ZIP_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__STATE:
				setState(STATE_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__COUNTRY:
				setCountry(COUNTRY_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__EMAIL:
				setEmail(EMAIL_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__WEB_PAGE:
				setWebPage(WEB_PAGE_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__PHONE:
				setPhone(PHONE_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__MOBILE:
				setMobile(MOBILE_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__NOTE:
				setNote(NOTE_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__JPEG_STRING:
				setJpegString(JPEG_STRING_EDEFAULT);
				return;
			case ContactsPackage.CONTACT__SOURCE_FILE:
				setSourceFile(SOURCE_FILE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ContactsPackage.CONTACT__FIRST_NAME:
				return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
			case ContactsPackage.CONTACT__MIDDLE_NAME:
				return MIDDLE_NAME_EDEFAULT == null ? middleName != null : !MIDDLE_NAME_EDEFAULT.equals(middleName);
			case ContactsPackage.CONTACT__LAST_NAME:
				return LAST_NAME_EDEFAULT == null ? lastName != null : !LAST_NAME_EDEFAULT.equals(lastName);
			case ContactsPackage.CONTACT__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case ContactsPackage.CONTACT__COMPANY:
				return COMPANY_EDEFAULT == null ? company != null : !COMPANY_EDEFAULT.equals(company);
			case ContactsPackage.CONTACT__JOB_TITLE:
				return JOB_TITLE_EDEFAULT == null ? jobTitle != null : !JOB_TITLE_EDEFAULT.equals(jobTitle);
			case ContactsPackage.CONTACT__STREET:
				return STREET_EDEFAULT == null ? street != null : !STREET_EDEFAULT.equals(street);
			case ContactsPackage.CONTACT__CITY:
				return CITY_EDEFAULT == null ? city != null : !CITY_EDEFAULT.equals(city);
			case ContactsPackage.CONTACT__ZIP:
				return ZIP_EDEFAULT == null ? zip != null : !ZIP_EDEFAULT.equals(zip);
			case ContactsPackage.CONTACT__STATE:
				return STATE_EDEFAULT == null ? state != null : !STATE_EDEFAULT.equals(state);
			case ContactsPackage.CONTACT__COUNTRY:
				return COUNTRY_EDEFAULT == null ? country != null : !COUNTRY_EDEFAULT.equals(country);
			case ContactsPackage.CONTACT__EMAIL:
				return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
			case ContactsPackage.CONTACT__WEB_PAGE:
				return WEB_PAGE_EDEFAULT == null ? webPage != null : !WEB_PAGE_EDEFAULT.equals(webPage);
			case ContactsPackage.CONTACT__PHONE:
				return PHONE_EDEFAULT == null ? phone != null : !PHONE_EDEFAULT.equals(phone);
			case ContactsPackage.CONTACT__MOBILE:
				return MOBILE_EDEFAULT == null ? mobile != null : !MOBILE_EDEFAULT.equals(mobile);
			case ContactsPackage.CONTACT__NOTE:
				return NOTE_EDEFAULT == null ? note != null : !NOTE_EDEFAULT.equals(note);
			case ContactsPackage.CONTACT__JPEG_STRING:
				return JPEG_STRING_EDEFAULT == null ? jpegString != null : !JPEG_STRING_EDEFAULT.equals(jpegString);
			case ContactsPackage.CONTACT__SOURCE_FILE:
				return SOURCE_FILE_EDEFAULT == null ? sourceFile != null : !SOURCE_FILE_EDEFAULT.equals(sourceFile);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (firstName: ");
		result.append(firstName);
		result.append(", middleName: ");
		result.append(middleName);
		result.append(", lastName: ");
		result.append(lastName);
		result.append(", title: ");
		result.append(title);
		result.append(", company: ");
		result.append(company);
		result.append(", jobTitle: ");
		result.append(jobTitle);
		result.append(", street: ");
		result.append(street);
		result.append(", city: ");
		result.append(city);
		result.append(", zip: ");
		result.append(zip);
		result.append(", state: ");
		result.append(state);
		result.append(", country: ");
		result.append(country);
		result.append(", email: ");
		result.append(email);
		result.append(", webPage: ");
		result.append(webPage);
		result.append(", phone: ");
		result.append(phone);
		result.append(", mobile: ");
		result.append(mobile);
		result.append(", note: ");
		result.append(note);
		result.append(", jpegString: ");
		result.append(jpegString);
		result.append(", sourceFile: ");
		result.append(sourceFile);
		result.append(')');
		return result.toString();
	}

} //ContactImpl
