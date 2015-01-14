/**
 */
package org.eclipse.fx.code.compensator.model.workbench.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.ProjectImpl#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.ProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.ProjectImpl#getProjectType <em>Project Type</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.ProjectImpl#getIconURI <em>Icon URI</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.ProjectImpl#getBugtrackerType <em>Bugtracker Type</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.ProjectImpl#getBugtrackerUrl <em>Bugtracker Url</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.ProjectImpl#getBugtrackerUsername <em>Bugtracker Username</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.ProjectImpl#getBugtrackerPassword <em>Bugtracker Password</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectImpl extends ModuleContainerImpl implements Project {
	/**
	 * The default value of the '{@link #getProjectId() <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected String projectId = PROJECT_ID_EDEFAULT;

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
	 * The default value of the '{@link #getProjectType() <em>Project Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectType()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectType() <em>Project Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectType()
	 * @generated
	 * @ordered
	 */
	protected String projectType = PROJECT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconURI() <em>Icon URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconURI()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconURI() <em>Icon URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconURI()
	 * @generated
	 * @ordered
	 */
	protected String iconURI = ICON_URI_EDEFAULT;

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
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkbenchPackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectId(String newProjectId) {
		String oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.PROJECT__PROJECT_ID, oldProjectId, projectId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.PROJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectType() {
		return projectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectType(String newProjectType) {
		String oldProjectType = projectType;
		projectType = newProjectType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.PROJECT__PROJECT_TYPE, oldProjectType, projectType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconURI() {
		return iconURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconURI(String newIconURI) {
		String oldIconURI = iconURI;
		iconURI = newIconURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.PROJECT__ICON_URI, oldIconURI, iconURI));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.PROJECT__BUGTRACKER_TYPE, oldBugtrackerType, bugtrackerType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.PROJECT__BUGTRACKER_URL, oldBugtrackerUrl, bugtrackerUrl));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.PROJECT__BUGTRACKER_USERNAME, oldBugtrackerUsername, bugtrackerUsername));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WorkbenchPackage.PROJECT__BUGTRACKER_PASSWORD, oldBugtrackerPassword, bugtrackerPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkbenchPackage.PROJECT__PROJECT_ID:
				return getProjectId();
			case WorkbenchPackage.PROJECT__NAME:
				return getName();
			case WorkbenchPackage.PROJECT__PROJECT_TYPE:
				return getProjectType();
			case WorkbenchPackage.PROJECT__ICON_URI:
				return getIconURI();
			case WorkbenchPackage.PROJECT__BUGTRACKER_TYPE:
				return getBugtrackerType();
			case WorkbenchPackage.PROJECT__BUGTRACKER_URL:
				return getBugtrackerUrl();
			case WorkbenchPackage.PROJECT__BUGTRACKER_USERNAME:
				return getBugtrackerUsername();
			case WorkbenchPackage.PROJECT__BUGTRACKER_PASSWORD:
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
			case WorkbenchPackage.PROJECT__PROJECT_ID:
				setProjectId((String)newValue);
				return;
			case WorkbenchPackage.PROJECT__NAME:
				setName((String)newValue);
				return;
			case WorkbenchPackage.PROJECT__PROJECT_TYPE:
				setProjectType((String)newValue);
				return;
			case WorkbenchPackage.PROJECT__ICON_URI:
				setIconURI((String)newValue);
				return;
			case WorkbenchPackage.PROJECT__BUGTRACKER_TYPE:
				setBugtrackerType((String)newValue);
				return;
			case WorkbenchPackage.PROJECT__BUGTRACKER_URL:
				setBugtrackerUrl((String)newValue);
				return;
			case WorkbenchPackage.PROJECT__BUGTRACKER_USERNAME:
				setBugtrackerUsername((String)newValue);
				return;
			case WorkbenchPackage.PROJECT__BUGTRACKER_PASSWORD:
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
			case WorkbenchPackage.PROJECT__PROJECT_ID:
				setProjectId(PROJECT_ID_EDEFAULT);
				return;
			case WorkbenchPackage.PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WorkbenchPackage.PROJECT__PROJECT_TYPE:
				setProjectType(PROJECT_TYPE_EDEFAULT);
				return;
			case WorkbenchPackage.PROJECT__ICON_URI:
				setIconURI(ICON_URI_EDEFAULT);
				return;
			case WorkbenchPackage.PROJECT__BUGTRACKER_TYPE:
				setBugtrackerType(BUGTRACKER_TYPE_EDEFAULT);
				return;
			case WorkbenchPackage.PROJECT__BUGTRACKER_URL:
				setBugtrackerUrl(BUGTRACKER_URL_EDEFAULT);
				return;
			case WorkbenchPackage.PROJECT__BUGTRACKER_USERNAME:
				setBugtrackerUsername(BUGTRACKER_USERNAME_EDEFAULT);
				return;
			case WorkbenchPackage.PROJECT__BUGTRACKER_PASSWORD:
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
			case WorkbenchPackage.PROJECT__PROJECT_ID:
				return PROJECT_ID_EDEFAULT == null ? projectId != null : !PROJECT_ID_EDEFAULT.equals(projectId);
			case WorkbenchPackage.PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WorkbenchPackage.PROJECT__PROJECT_TYPE:
				return PROJECT_TYPE_EDEFAULT == null ? projectType != null : !PROJECT_TYPE_EDEFAULT.equals(projectType);
			case WorkbenchPackage.PROJECT__ICON_URI:
				return ICON_URI_EDEFAULT == null ? iconURI != null : !ICON_URI_EDEFAULT.equals(iconURI);
			case WorkbenchPackage.PROJECT__BUGTRACKER_TYPE:
				return BUGTRACKER_TYPE_EDEFAULT == null ? bugtrackerType != null : !BUGTRACKER_TYPE_EDEFAULT.equals(bugtrackerType);
			case WorkbenchPackage.PROJECT__BUGTRACKER_URL:
				return BUGTRACKER_URL_EDEFAULT == null ? bugtrackerUrl != null : !BUGTRACKER_URL_EDEFAULT.equals(bugtrackerUrl);
			case WorkbenchPackage.PROJECT__BUGTRACKER_USERNAME:
				return BUGTRACKER_USERNAME_EDEFAULT == null ? bugtrackerUsername != null : !BUGTRACKER_USERNAME_EDEFAULT.equals(bugtrackerUsername);
			case WorkbenchPackage.PROJECT__BUGTRACKER_PASSWORD:
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
		result.append(" (projectId: ");
		result.append(projectId);
		result.append(", name: ");
		result.append(name);
		result.append(", projectType: ");
		result.append(projectType);
		result.append(", iconURI: ");
		result.append(iconURI);
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

} //ProjectImpl
