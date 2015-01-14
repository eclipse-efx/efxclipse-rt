/**
 */
package org.eclipse.fx.code.compensator.model.workbench;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.ModuleContainer#getModuleList <em>Module List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getModuleContainer()
 * @model abstract="true"
 * @generated
 */
public interface ModuleContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Module List</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.fx.code.compensator.model.workbench.Module}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module List</em>' containment reference list.
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getModuleContainer_ModuleList()
	 * @model containment="true"
	 * @generated
	 */
	EList<Module> getModuleList();

} // ModuleContainer
