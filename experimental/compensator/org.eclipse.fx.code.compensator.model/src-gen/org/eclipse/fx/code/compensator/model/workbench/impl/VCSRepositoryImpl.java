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
/**
 */
package org.eclipse.fx.code.compensator.model.workbench.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.fx.code.compensator.model.workbench.VCSRepository;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VCS Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.VCSRepositoryImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.VCSRepositoryImpl#getRepoType <em>Repo Type</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.VCSRepositoryImpl#getRepoURI <em>Repo URI</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.VCSRepositoryImpl#getLocalURI <em>Local URI</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.VCSRepositoryImpl#getRepoUsername <em>Repo Username</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.VCSRepositoryImpl#getRepoPassword <em>Repo Password</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VCSRepositoryImpl extends MinimalEObjectImpl.Container implements VCSRepository {
	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepoType() <em>Repo Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepoType()
	 * @generated
	 * @ordered
	 */
	protected static final String REPO_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepoType() <em>Repo Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepoType()
	 * @generated
	 * @ordered
	 */
	protected String repoType = REPO_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepoURI() <em>Repo URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepoURI()
	 * @generated
	 * @ordered
	 */
	protected static final String REPO_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepoURI() <em>Repo URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepoURI()
	 * @generated
	 * @ordered
	 */
	protected String repoURI = REPO_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocalURI() <em>Local URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalURI()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCAL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocalURI() <em>Local URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalURI()
	 * @generated
	 * @ordered
	 */
	protected String localURI = LOCAL_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepoUsername() <em>Repo Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepoUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String REPO_USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepoUsername() <em>Repo Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepoUsername()
	 * @generated
	 * @ordered
	 */
	protected String repoUsername = REPO_USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepoPassword() <em>Repo Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepoPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String REPO_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepoPassword() <em>Repo Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepoPassword()
	 * @generated
	 * @ordered
	 */
	protected String repoPassword = REPO_PASSWORD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VCSRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkbenchPackage.Literals.VCS_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.VCS_REPOSITORY__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepoType() {
		return repoType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepoType(String newRepoType) {
		String oldRepoType = repoType;
		repoType = newRepoType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.VCS_REPOSITORY__REPO_TYPE, oldRepoType, repoType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepoURI() {
		return repoURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepoURI(String newRepoURI) {
		String oldRepoURI = repoURI;
		repoURI = newRepoURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.VCS_REPOSITORY__REPO_URI, oldRepoURI, repoURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocalURI() {
		return localURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalURI(String newLocalURI) {
		String oldLocalURI = localURI;
		localURI = newLocalURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.VCS_REPOSITORY__LOCAL_URI, oldLocalURI, localURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepoUsername() {
		return repoUsername;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepoUsername(String newRepoUsername) {
		String oldRepoUsername = repoUsername;
		repoUsername = newRepoUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.VCS_REPOSITORY__REPO_USERNAME, oldRepoUsername, repoUsername));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepoPassword() {
		return repoPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepoPassword(String newRepoPassword) {
		String oldRepoPassword = repoPassword;
		repoPassword = newRepoPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.VCS_REPOSITORY__REPO_PASSWORD, oldRepoPassword, repoPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkbenchPackage.VCS_REPOSITORY__LABEL:
				return getLabel();
			case WorkbenchPackage.VCS_REPOSITORY__REPO_TYPE:
				return getRepoType();
			case WorkbenchPackage.VCS_REPOSITORY__REPO_URI:
				return getRepoURI();
			case WorkbenchPackage.VCS_REPOSITORY__LOCAL_URI:
				return getLocalURI();
			case WorkbenchPackage.VCS_REPOSITORY__REPO_USERNAME:
				return getRepoUsername();
			case WorkbenchPackage.VCS_REPOSITORY__REPO_PASSWORD:
				return getRepoPassword();
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
			case WorkbenchPackage.VCS_REPOSITORY__LABEL:
				setLabel((String)newValue);
				return;
			case WorkbenchPackage.VCS_REPOSITORY__REPO_TYPE:
				setRepoType((String)newValue);
				return;
			case WorkbenchPackage.VCS_REPOSITORY__REPO_URI:
				setRepoURI((String)newValue);
				return;
			case WorkbenchPackage.VCS_REPOSITORY__LOCAL_URI:
				setLocalURI((String)newValue);
				return;
			case WorkbenchPackage.VCS_REPOSITORY__REPO_USERNAME:
				setRepoUsername((String)newValue);
				return;
			case WorkbenchPackage.VCS_REPOSITORY__REPO_PASSWORD:
				setRepoPassword((String)newValue);
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
			case WorkbenchPackage.VCS_REPOSITORY__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case WorkbenchPackage.VCS_REPOSITORY__REPO_TYPE:
				setRepoType(REPO_TYPE_EDEFAULT);
				return;
			case WorkbenchPackage.VCS_REPOSITORY__REPO_URI:
				setRepoURI(REPO_URI_EDEFAULT);
				return;
			case WorkbenchPackage.VCS_REPOSITORY__LOCAL_URI:
				setLocalURI(LOCAL_URI_EDEFAULT);
				return;
			case WorkbenchPackage.VCS_REPOSITORY__REPO_USERNAME:
				setRepoUsername(REPO_USERNAME_EDEFAULT);
				return;
			case WorkbenchPackage.VCS_REPOSITORY__REPO_PASSWORD:
				setRepoPassword(REPO_PASSWORD_EDEFAULT);
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
			case WorkbenchPackage.VCS_REPOSITORY__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case WorkbenchPackage.VCS_REPOSITORY__REPO_TYPE:
				return REPO_TYPE_EDEFAULT == null ? repoType != null : !REPO_TYPE_EDEFAULT.equals(repoType);
			case WorkbenchPackage.VCS_REPOSITORY__REPO_URI:
				return REPO_URI_EDEFAULT == null ? repoURI != null : !REPO_URI_EDEFAULT.equals(repoURI);
			case WorkbenchPackage.VCS_REPOSITORY__LOCAL_URI:
				return LOCAL_URI_EDEFAULT == null ? localURI != null : !LOCAL_URI_EDEFAULT.equals(localURI);
			case WorkbenchPackage.VCS_REPOSITORY__REPO_USERNAME:
				return REPO_USERNAME_EDEFAULT == null ? repoUsername != null : !REPO_USERNAME_EDEFAULT.equals(repoUsername);
			case WorkbenchPackage.VCS_REPOSITORY__REPO_PASSWORD:
				return REPO_PASSWORD_EDEFAULT == null ? repoPassword != null : !REPO_PASSWORD_EDEFAULT.equals(repoPassword);
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
		result.append(" (label: ");
		result.append(label);
		result.append(", repoType: ");
		result.append(repoType);
		result.append(", repoURI: ");
		result.append(repoURI);
		result.append(", localURI: ");
		result.append(localURI);
		result.append(", repoUsername: ");
		result.append(repoUsername);
		result.append(", repoPassword: ");
		result.append(repoPassword);
		result.append(')');
		return result.toString();
	}

} //VCSRepositoryImpl
