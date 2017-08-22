/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scanner JS Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_JSRule#getFileURI <em>File URI</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_JSRule#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_JSRule()
 * @model
 * @generated
 */
public interface Scanner_JSRule extends Scanner_Rule
{
  /**
   * Returns the value of the '<em><b>File URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File URI</em>' attribute.
   * @see #setFileURI(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_JSRule_FileURI()
   * @model
   * @generated
   */
  String getFileURI();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_JSRule#getFileURI <em>File URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File URI</em>' attribute.
   * @see #getFileURI()
   * @generated
   */
  void setFileURI(String value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(ScannerCondition)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_JSRule_Condition()
   * @model containment="true"
   * @generated
   */
  ScannerCondition getCondition();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_JSRule#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(ScannerCondition value);

} // Scanner_JSRule
