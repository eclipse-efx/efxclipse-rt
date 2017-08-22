/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Integration#getCodeIntegrationList <em>Code Integration List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getIntegration()
 * @model
 * @generated
 */
public interface Integration extends EObject
{
  /**
   * Returns the value of the '<em><b>Code Integration List</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.editor.ldef.lDef.CodeIntegration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Code Integration List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Code Integration List</em>' containment reference list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getIntegration_CodeIntegrationList()
   * @model containment="true"
   * @generated
   */
  EList<CodeIntegration> getCodeIntegrationList();

} // Integration
