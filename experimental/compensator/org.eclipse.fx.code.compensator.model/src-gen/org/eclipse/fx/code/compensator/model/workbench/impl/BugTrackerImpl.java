/**
 */
package org.eclipse.fx.code.compensator.model.workbench.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.fx.code.compensator.model.workbench.BugTracker;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bug Tracker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.BugTrackerImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.BugTrackerImpl#getBugtrackerType <em>Bugtracker Type</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.BugTrackerImpl#getBugtrackerUrl <em>Bugtracker Url</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.BugTrackerImpl#getBugtrackerUsername <em>Bugtracker Username</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.BugTrackerImpl#getBugtrackerPassword <em>Bugtracker Password</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BugTrackerImpl extends MinimalEObjectImpl.Container implements BugTracker {
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
	 * The default value of the '{@link #getBugtrackerType() <em>Bugtracker Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBugtrackerType()
	 * @generated
	 * @ordered
	 */
	protected static final String BUGTRACKER_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBugtrackerType() <em>Bugtracker Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBugtrackerType()
	 * @generated
	 * @ordered
	 */
	protected String bugtrackerType = BUGTRACKER_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBugtrackerUrl() <em>Bugtracker Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBugtrackerUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String BUGTRACKER_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBugtrackerUrl() <em>Bugtracker Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBugtrackerUrl()
	 * @generated
	 * @ordered
	 */
	protected String bugtrackerUrl = BUGTRACKER_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getBugtrackerUsername() <em>Bugtracker Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBugtrackerUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String BUGTRACKER_USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBugtrackerUsername() <em>Bugtracker Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBugtrackerUsername()
	 * @generated
	 * @ordered
	 */
	protected String bugtrackerUsername = BUGTRACKER_USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getBugtrackerPassword() <em>Bugtracker Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBugtrackerPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String BUGTRACKER_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBugtrackerPassword() <em>Bugtracker Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBugtrackerPassword()
	 * @generated
	 * @ordered
	 */
	protected String bugtrackerPassword = BUGTRACKER_PASSWORD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BugTrackerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkbenchPackage.Literals.BUG_TRACKER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.BUG_TRACKER__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBugtrackerType() {
		return bugtrackerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBugtrackerType(String newBugtrackerType) {
		String oldBugtrackerType = bugtrackerType;
		bugtrackerType = newBugtrackerType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.BUG_TRACKER__BUGTRACKER_TYPE, oldBugtrackerType, bugtrackerType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBugtrackerUrl() {
		return bugtrackerUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBugtrackerUrl(String newBugtrackerUrl) {
		String oldBugtrackerUrl = bugtrackerUrl;
		bugtrackerUrl = newBugtrackerUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.BUG_TRACKER__BUGTRACKER_URL, oldBugtrackerUrl, bugtrackerUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBugtrackerUsername() {
		return bugtrackerUsername;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBugtrackerUsername(String newBugtrackerUsername) {
		String oldBugtrackerUsername = bugtrackerUsername;
		bugtrackerUsername = newBugtrackerUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.BUG_TRACKER__BUGTRACKER_USERNAME, oldBugtrackerUsername, bugtrackerUsername));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBugtrackerPassword() {
		return bugtrackerPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBugtrackerPassword(String newBugtrackerPassword) {
		String oldBugtrackerPassword = bugtrackerPassword;
		bugtrackerPassword = newBugtrackerPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.BUG_TRACKER__BUGTRACKER_PASSWORD, oldBugtrackerPassword, bugtrackerPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkbenchPackage.BUG_TRACKER__LABEL:
				return getLabel();
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_TYPE:
				return getBugtrackerType();
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_URL:
				return getBugtrackerUrl();
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_USERNAME:
				return getBugtrackerUsername();
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_PASSWORD:
				return getBugtrackerPassword();
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
			case WorkbenchPackage.BUG_TRACKER__LABEL:
				setLabel((String)newValue);
				return;
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_TYPE:
				setBugtrackerType((String)newValue);
				return;
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_URL:
				setBugtrackerUrl((String)newValue);
				return;
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_USERNAME:
				setBugtrackerUsername((String)newValue);
				return;
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_PASSWORD:
				setBugtrackerPassword((String)newValue);
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
			case WorkbenchPackage.BUG_TRACKER__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_TYPE:
				setBugtrackerType(BUGTRACKER_TYPE_EDEFAULT);
				return;
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_URL:
				setBugtrackerUrl(BUGTRACKER_URL_EDEFAULT);
				return;
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_USERNAME:
				setBugtrackerUsername(BUGTRACKER_USERNAME_EDEFAULT);
				return;
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_PASSWORD:
				setBugtrackerPassword(BUGTRACKER_PASSWORD_EDEFAULT);
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
			case WorkbenchPackage.BUG_TRACKER__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_TYPE:
				return BUGTRACKER_TYPE_EDEFAULT == null ? bugtrackerType != null : !BUGTRACKER_TYPE_EDEFAULT.equals(bugtrackerType);
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_URL:
				return BUGTRACKER_URL_EDEFAULT == null ? bugtrackerUrl != null : !BUGTRACKER_URL_EDEFAULT.equals(bugtrackerUrl);
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_USERNAME:
				return BUGTRACKER_USERNAME_EDEFAULT == null ? bugtrackerUsername != null : !BUGTRACKER_USERNAME_EDEFAULT.equals(bugtrackerUsername);
			case WorkbenchPackage.BUG_TRACKER__BUGTRACKER_PASSWORD:
				return BUGTRACKER_PASSWORD_EDEFAULT == null ? bugtrackerPassword != null : !BUGTRACKER_PASSWORD_EDEFAULT.equals(bugtrackerPassword);
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
		result.append(", bugtrackerType: ");
		result.append(bugtrackerType);
		result.append(", bugtrackerUrl: ");
		result.append(bugtrackerUrl);
		result.append(", bugtrackerUsername: ");
		result.append(bugtrackerUsername);
		result.append(", bugtrackerPassword: ");
		result.append(bugtrackerPassword);
		result.append(')');
		return result.toString();
	}

} //BugTrackerImpl
