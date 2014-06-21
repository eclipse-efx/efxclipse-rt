/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scanner Whitespace Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule#getCharacters <em>Characters</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule#getJsMethod <em>Js Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScannerWhitespaceRule()
 * @model
 * @generated
 */
public interface ScannerWhitespaceRule extends ScannerRule
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
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScannerWhitespaceRule_Characters()
   * @model unique="false"
   * @generated
   */
  EList<String> getCharacters();

  /**
   * Returns the value of the '<em><b>Js Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Js Method</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Js Method</em>' attribute.
   * @see #setJsMethod(String)
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScannerWhitespaceRule_JsMethod()
   * @model
   * @generated
   */
  String getJsMethod();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule#getJsMethod <em>Js Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Js Method</em>' attribute.
   * @see #getJsMethod()
   * @generated
   */
  void setJsMethod(String value);

} // ScannerWhitespaceRule
