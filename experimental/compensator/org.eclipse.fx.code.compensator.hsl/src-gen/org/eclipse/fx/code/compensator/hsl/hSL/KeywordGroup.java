/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Keyword Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup#getToken <em>Token</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup#getKeywords <em>Keywords</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getKeywordGroup()
 * @model
 * @generated
 */
public interface KeywordGroup extends EObject
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
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getKeywordGroup_Token()
   * @model
   * @generated
   */
  ScannerToken getToken();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup#getToken <em>Token</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Token</em>' reference.
   * @see #getToken()
   * @generated
   */
  void setToken(ScannerToken value);

  /**
   * Returns the value of the '<em><b>Keywords</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.compensator.hsl.hSL.Keyword}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Keywords</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Keywords</em>' containment reference list.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getKeywordGroup_Keywords()
   * @model containment="true"
   * @generated
   */
  EList<Keyword> getKeywords();

} // KeywordGroup
