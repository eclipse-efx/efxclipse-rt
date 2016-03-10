/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scanner Character Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule#getCharacters <em>Characters</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule#getEnabledIf <em>Enabled If</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_CharacterRule()
 * @model
 * @generated
 */
public interface Scanner_CharacterRule extends Scanner_Rule
{
  /**
   * Returns the value of the '<em><b>Characters</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Characters</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Characters</em>' attribute list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_CharacterRule_Characters()
   * @model unique="false"
   * @generated
   */
  EList<String> getCharacters();

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
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_CharacterRule_EnabledIf()
   * @model containment="true"
   * @generated
   */
  ScannerCondition getEnabledIf();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule#getEnabledIf <em>Enabled If</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enabled If</em>' containment reference.
   * @see #getEnabledIf()
   * @generated
   */
  void setEnabledIf(ScannerCondition value);

} // Scanner_CharacterRule
