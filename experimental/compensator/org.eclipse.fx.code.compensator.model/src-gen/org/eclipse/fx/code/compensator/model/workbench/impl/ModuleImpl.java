/**
 */
package org.eclipse.fx.code.compensator.model.workbench.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.ModuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.ModuleImpl#getRootFolderUrl <em>Root Folder Url</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImpl extends ModuleContainerImpl implements Module {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRootFolderUrl() <em>Root Folder Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootFolderUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_FOLDER_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRootFolderUrl() <em>Root Folder Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootFolderUrl()
	 * @generated
	 * @ordered
	 */
	protected String rootFolderUrl = ROOT_FOLDER_URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkbenchPackage.Literals.MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.MODULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRootFolderUrl() {
		return rootFolderUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootFolderUrl(String newRootFolderUrl) {
		String oldRootFolderUrl = rootFolderUrl;
		rootFolderUrl = newRootFolderUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.MODULE__ROOT_FOLDER_URL, oldRootFolderUrl, rootFolderUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkbenchPackage.MODULE__NAME:
				return getName();
			case WorkbenchPackage.MODULE__ROOT_FOLDER_URL:
				return getRootFolderUrl();
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
			case WorkbenchPackage.MODULE__NAME:
				setName((String)newValue);
				return;
			case WorkbenchPackage.MODULE__ROOT_FOLDER_URL:
				setRootFolderUrl((String)newValue);
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
			case WorkbenchPackage.MODULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WorkbenchPackage.MODULE__ROOT_FOLDER_URL:
				setRootFolderUrl(ROOT_FOLDER_URL_EDEFAULT);
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
			case WorkbenchPackage.MODULE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WorkbenchPackage.MODULE__ROOT_FOLDER_URL:
				return ROOT_FOLDER_URL_EDEFAULT == null ? rootFolderUrl != null : !ROOT_FOLDER_URL_EDEFAULT.equals(rootFolderUrl);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", rootFolderUrl: ");
		result.append(rootFolderUrl);
		result.append(')');
		return result.toString();
	}

} //ModuleImpl
