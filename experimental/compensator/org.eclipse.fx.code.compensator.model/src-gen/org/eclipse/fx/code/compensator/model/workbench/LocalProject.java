/**
 */
package org.eclipse.fx.code.compensator.model.workbench;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.LocalProject#getVcsRepository <em>Vcs Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getLocalProject()
 * @model
 * @generated
 */
public interface LocalProject extends Project {
	/**
	 * Returns the value of the '<em><b>Vcs Repository</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vcs Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vcs Repository</em>' containment reference list.
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getLocalProject_VcsRepository()
	 * @model containment="true"
	 * @generated
	 */
	EList<VCSRepository> getVcsRepository();

} // LocalProject
