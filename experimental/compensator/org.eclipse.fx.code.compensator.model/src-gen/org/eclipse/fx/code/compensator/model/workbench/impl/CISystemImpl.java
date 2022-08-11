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

import org.eclipse.fx.code.compensator.model.workbench.CISystem;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CI System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.CISystemImpl#getTypeId <em>Type Id</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.CISystemImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.CISystemImpl#getServiceUrl <em>Service Url</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CISystemImpl extends MinimalEObjectImpl.Container implements CISystem {
	/**
	 * The default value of the '{@link #getTypeId() <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeId()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeId() <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeId()
	 * @generated
	 * @ordered
	 */
	protected String typeId = TYPE_ID_EDEFAULT;

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
	 * The default value of the '{@link #getServiceUrl() <em>Service Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceUrl() <em>Service Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceUrl()
	 * @generated
	 * @ordered
	 */
	protected String serviceUrl = SERVICE_URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CISystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkbenchPackage.Literals.CI_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeId(String newTypeId) {
		String oldTypeId = typeId;
		typeId = newTypeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.CI_SYSTEM__TYPE_ID, oldTypeId, typeId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.CI_SYSTEM__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceUrl() {
		return serviceUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceUrl(String newServiceUrl) {
		String oldServiceUrl = serviceUrl;
		serviceUrl = newServiceUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.CI_SYSTEM__SERVICE_URL, oldServiceUrl, serviceUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkbenchPackage.CI_SYSTEM__TYPE_ID:
				return getTypeId();
			case WorkbenchPackage.CI_SYSTEM__LABEL:
				return getLabel();
			case WorkbenchPackage.CI_SYSTEM__SERVICE_URL:
				return getServiceUrl();
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
			case WorkbenchPackage.CI_SYSTEM__TYPE_ID:
				setTypeId((String)newValue);
				return;
			case WorkbenchPackage.CI_SYSTEM__LABEL:
				setLabel((String)newValue);
				return;
			case WorkbenchPackage.CI_SYSTEM__SERVICE_URL:
				setServiceUrl((String)newValue);
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
			case WorkbenchPackage.CI_SYSTEM__TYPE_ID:
				setTypeId(TYPE_ID_EDEFAULT);
				return;
			case WorkbenchPackage.CI_SYSTEM__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case WorkbenchPackage.CI_SYSTEM__SERVICE_URL:
				setServiceUrl(SERVICE_URL_EDEFAULT);
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
			case WorkbenchPackage.CI_SYSTEM__TYPE_ID:
				return TYPE_ID_EDEFAULT == null ? typeId != null : !TYPE_ID_EDEFAULT.equals(typeId);
			case WorkbenchPackage.CI_SYSTEM__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case WorkbenchPackage.CI_SYSTEM__SERVICE_URL:
				return SERVICE_URL_EDEFAULT == null ? serviceUrl != null : !SERVICE_URL_EDEFAULT.equals(serviceUrl);
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
		result.append(" (typeId: ");
		result.append(typeId);
		result.append(", label: ");
		result.append(label);
		result.append(", serviceUrl: ");
		result.append(serviceUrl);
		result.append(')');
		return result.toString();
	}

} //CISystemImpl
