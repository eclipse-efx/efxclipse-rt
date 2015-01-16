/**
 */
package org.eclipse.fx.code.compensator.model.workbench;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.Project#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.Project#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.Project#getProjectType <em>Project Type</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.Project#getIconURI <em>Icon URI</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.Project#getBugTrackerList <em>Bug Tracker List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends ModuleContainer {
	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Id</em>' attribute.
	 * @see #setProjectId(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getProject_ProjectId()
	 * @model unique="false"
	 * @generated
	 */
	String getProjectId();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.Project#getProjectId <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' attribute.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getProject_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.Project#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Project Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Type</em>' attribute.
	 * @see #setProjectType(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getProject_ProjectType()
	 * @model unique="false"
	 * @generated
	 */
	String getProjectType();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.Project#getProjectType <em>Project Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Type</em>' attribute.
	 * @see #getProjectType()
	 * @generated
	 */
	void setProjectType(String value);

	/**
	 * Returns the value of the '<em><b>Icon URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon URI</em>' attribute.
	 * @see #setIconURI(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getProject_IconURI()
	 * @model unique="false"
	 * @generated
	 */
	String getIconURI();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.Project#getIconURI <em>Icon URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon URI</em>' attribute.
	 * @see #getIconURI()
	 * @generated
	 */
	void setIconURI(String value);

	/**
	 * Returns the value of the '<em><b>Bug Tracker List</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.fx.code.compensator.model.workbench.BugTracker}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bug Tracker List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bug Tracker List</em>' containment reference list.
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getProject_BugTrackerList()
	 * @model containment="true"
	 * @generated
	 */
	EList<BugTracker> getBugTrackerList();

} // Project
