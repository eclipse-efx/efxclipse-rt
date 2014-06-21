/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scanner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getPartition <em>Partition</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getKeywordGroups <em>Keyword Groups</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScanner()
 * @model
 * @generated
 */
public interface Scanner extends EObject
{
  /**
   * Returns the value of the '<em><b>Partition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Partition</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Partition</em>' reference.
   * @see #setPartition(Partition)
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScanner_Partition()
   * @model
   * @generated
   */
  Partition getPartition();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.Scanner#getPartition <em>Partition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Partition</em>' reference.
   * @see #getPartition()
   * @generated
   */
  void setPartition(Partition value);

  /**
   * Returns the value of the '<em><b>Tokens</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tokens</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tokens</em>' containment reference list.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScanner_Tokens()
   * @model containment="true"
   * @generated
   */
  EList<ScannerToken> getTokens();

  /**
   * Returns the value of the '<em><b>Keyword Groups</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Keyword Groups</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Keyword Groups</em>' containment reference list.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScanner_KeywordGroups()
   * @model containment="true"
   * @generated
   */
  EList<KeywordGroup> getKeywordGroups();

  /**
   * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rules</em>' containment reference list.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScanner_Rules()
   * @model containment="true"
   * @generated
   */
  EList<ScannerRule> getRules();

} // Scanner
