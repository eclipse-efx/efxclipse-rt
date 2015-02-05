/**
 */
package org.eclipse.fx.code.compensator.model.workbench.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.fx.code.compensator.model.workbench.RemoteProject;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Remote Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.RemoteProjectImpl#getRemoteServiceType <em>Remote Service Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RemoteProjectImpl extends ProjectImpl implements RemoteProject {
	/**
	 * The default value of the '{@link #getRemoteServiceType() <em>Remote Service Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteServiceType()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_SERVICE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRemoteServiceType() <em>Remote Service Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoteServiceType()
	 * @generated
	 * @ordered
	 */
	protected String remoteServiceType = REMOTE_SERVICE_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoteProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkbenchPackage.Literals.REMOTE_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemoteServiceType() {
		return remoteServiceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteServiceType(String newRemoteServiceType) {
		String oldRemoteServiceType = remoteServiceType;
		remoteServiceType = newRemoteServiceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.REMOTE_PROJECT__REMOTE_SERVICE_TYPE, oldRemoteServiceType, remoteServiceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkbenchPackage.REMOTE_PROJECT__REMOTE_SERVICE_TYPE:
				return getRemoteServiceType();
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
			case WorkbenchPackage.REMOTE_PROJECT__REMOTE_SERVICE_TYPE:
				setRemoteServiceType((String)newValue);
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
			case WorkbenchPackage.REMOTE_PROJECT__REMOTE_SERVICE_TYPE:
				setRemoteServiceType(REMOTE_SERVICE_TYPE_EDEFAULT);
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
			case WorkbenchPackage.REMOTE_PROJECT__REMOTE_SERVICE_TYPE:
				return REMOTE_SERVICE_TYPE_EDEFAULT == null ? remoteServiceType != null : !REMOTE_SERVICE_TYPE_EDEFAULT.equals(remoteServiceType);
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
		result.append(" (remoteServiceType: ");
		result.append(remoteServiceType);
		result.append(')');
		return result.toString();
	}

} //RemoteProjectImpl
