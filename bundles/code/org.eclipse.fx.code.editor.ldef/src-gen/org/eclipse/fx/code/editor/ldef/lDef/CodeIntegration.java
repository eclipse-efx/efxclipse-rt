/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Integration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.CodeIntegration#isCodegen <em>Codegen</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.CodeIntegration#isE4 <em>E4</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getCodeIntegration()
 * @model
 * @generated
 */
public interface CodeIntegration extends EObject
{
  /**
   * Returns the value of the '<em><b>Codegen</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Codegen</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Codegen</em>' attribute.
   * @see #setCodegen(boolean)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getCodeIntegration_Codegen()
   * @model
   * @generated
   */
  boolean isCodegen();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.CodeIntegration#isCodegen <em>Codegen</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Codegen</em>' attribute.
   * @see #isCodegen()
   * @generated
   */
  void setCodegen(boolean value);

  /**
   * Returns the value of the '<em><b>E4</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>E4</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>E4</em>' attribute.
   * @see #setE4(boolean)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getCodeIntegration_E4()
   * @model
   * @generated
   */
  boolean isE4();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.CodeIntegration#isE4 <em>E4</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>E4</em>' attribute.
   * @see #isE4()
   * @generated
   */
  void setE4(boolean value);

} // CodeIntegration
