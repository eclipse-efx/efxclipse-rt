/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scanner Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerRule#getToken <em>Token</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScannerRule()
 * @model
 * @generated
 */
public interface ScannerRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Token</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Token</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Token</em>' reference.
   * @see #setToken(ScannerToken)
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScannerRule_Token()
   * @model
   * @generated
   */
  ScannerToken getToken();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerRule#getToken <em>Token</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Token</em>' reference.
   * @see #getToken()
   * @generated
   */
  void setToken(ScannerToken value);

} // ScannerRule
