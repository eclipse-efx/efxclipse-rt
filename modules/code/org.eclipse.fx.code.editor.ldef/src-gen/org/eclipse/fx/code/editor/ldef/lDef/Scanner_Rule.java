/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scanner Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_Rule#getCheck <em>Check</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_Rule()
 * @model
 * @generated
 */
public interface Scanner_Rule extends Scanner
{
  /**
   * Returns the value of the '<em><b>Check</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Check</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Check</em>' containment reference.
   * @see #setCheck(Check)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_Rule_Check()
   * @model containment="true"
   * @generated
   */
  Check getCheck();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_Rule#getCheck <em>Check</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Check</em>' containment reference.
   * @see #getCheck()
   * @generated
   */
  void setCheck(Check value);

} // Scanner_Rule
