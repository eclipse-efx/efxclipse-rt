/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scanner Keyword</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword#getKeywords <em>Keywords</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword#getEnabledIf <em>Enabled If</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_Keyword()
 * @model
 * @generated
 */
public interface Scanner_Keyword extends Scanner
{
  /**
   * Returns the value of the '<em><b>Keywords</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.editor.ldef.lDef.Keyword}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Keywords</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Keywords</em>' containment reference list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_Keyword_Keywords()
   * @model containment="true"
   * @generated
   */
  EList<Keyword> getKeywords();

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
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_Keyword_EnabledIf()
   * @model containment="true"
   * @generated
   */
  ScannerCondition getEnabledIf();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword#getEnabledIf <em>Enabled If</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enabled If</em>' containment reference.
   * @see #getEnabledIf()
   * @generated
   */
  void setEnabledIf(ScannerCondition value);

} // Scanner_Keyword
