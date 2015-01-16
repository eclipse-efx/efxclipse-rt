/**
 */
package org.eclipse.fx.code.compensator.model.workbench.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fx.code.compensator.model.workbench.BugTracker;
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
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.impl.ProjectImpl#getBugTrackerList <em>Bug Tracker List</em>}</li>
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
	 * The cached value of the '{@link #getBugTrackerList() <em>Bug Tracker List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBugTrackerList()
	 * @generated
	 * @ordered
	 */
	protected EList<BugTracker> bugTrackerList;

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
	public EList<BugTracker> getBugTrackerList() {
		if (bugTrackerList == null) {
			bugTrackerList = new EObjectContainmentEList<BugTracker>(BugTracker.class, this, WorkbenchPackage.PROJECT__BUG_TRACKER_LIST);
		}
		return bugTrackerList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkbenchPackage.PROJECT__BUG_TRACKER_LIST:
				return ((InternalEList<?>)getBugTrackerList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case WorkbenchPackage.PROJECT__BUG_TRACKER_LIST:
				return getBugTrackerList();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
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
			case WorkbenchPackage.PROJECT__BUG_TRACKER_LIST:
				getBugTrackerList().clear();
				getBugTrackerList().addAll((Collection<? extends BugTracker>)newValue);
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
			case WorkbenchPackage.PROJECT__BUG_TRACKER_LIST:
				getBugTrackerList().clear();
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
			case WorkbenchPackage.PROJECT__BUG_TRACKER_LIST:
				return bugTrackerList != null && !bugTrackerList.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //ProjectImpl
