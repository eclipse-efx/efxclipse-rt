/**
 */
package org.eclipse.fx.code.compensator.model.workbench;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.RemoteProject#getRemoteServiceType <em>Remote Service Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getRemoteProject()
 * @model
 * @generated
 */
public interface RemoteProject extends Project {
	/**
	 * Returns the value of the '<em><b>Remote Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Service Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remote Service Type</em>' attribute.
	 * @see #setRemoteServiceType(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getRemoteProject_RemoteServiceType()
	 * @model unique="false"
	 * @generated
	 */
	String getRemoteServiceType();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.RemoteProject#getRemoteServiceType <em>Remote Service Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Service Type</em>' attribute.
	 * @see #getRemoteServiceType()
	 * @generated
	 */
	void setRemoteServiceType(String value);

} // RemoteProject
