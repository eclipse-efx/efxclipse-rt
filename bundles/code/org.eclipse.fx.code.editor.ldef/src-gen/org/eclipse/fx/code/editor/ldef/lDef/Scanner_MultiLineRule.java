/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scanner Multi Line Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getStartSeq <em>Start Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getEndSeq <em>End Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getEscapeSeq <em>Escape Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getEnabledIf <em>Enabled If</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_MultiLineRule()
 * @model
 * @generated
 */
public interface Scanner_MultiLineRule extends Scanner_Rule
{
  /**
   * Returns the value of the '<em><b>Start Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Seq</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Seq</em>' attribute.
   * @see #setStartSeq(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_MultiLineRule_StartSeq()
   * @model
   * @generated
   */
  String getStartSeq();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getStartSeq <em>Start Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Seq</em>' attribute.
   * @see #getStartSeq()
   * @generated
   */
  void setStartSeq(String value);

  /**
   * Returns the value of the '<em><b>End Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End Seq</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End Seq</em>' attribute.
   * @see #setEndSeq(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_MultiLineRule_EndSeq()
   * @model
   * @generated
   */
  String getEndSeq();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getEndSeq <em>End Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End Seq</em>' attribute.
   * @see #getEndSeq()
   * @generated
   */
  void setEndSeq(String value);

  /**
   * Returns the value of the '<em><b>Escape Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Escape Seq</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Escape Seq</em>' attribute.
   * @see #setEscapeSeq(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_MultiLineRule_EscapeSeq()
   * @model
   * @generated
   */
  String getEscapeSeq();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getEscapeSeq <em>Escape Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Escape Seq</em>' attribute.
   * @see #getEscapeSeq()
   * @generated
   */
  void setEscapeSeq(String value);

  /**
   * Returns the value of the '<em><b>Enabled If</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enabled If</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enabled If</em>' containment reference.
   * @see #setEnabledIf(ScannerCondition)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_MultiLineRule_EnabledIf()
   * @model containment="true"
   * @generated
   */
  ScannerCondition getEnabledIf();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_MultiLineRule#getEnabledIf <em>Enabled If</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enabled If</em>' containment reference.
   * @see #getEnabledIf()
   * @generated
   */
  void setEnabledIf(ScannerCondition value);

} // Scanner_MultiLineRule
