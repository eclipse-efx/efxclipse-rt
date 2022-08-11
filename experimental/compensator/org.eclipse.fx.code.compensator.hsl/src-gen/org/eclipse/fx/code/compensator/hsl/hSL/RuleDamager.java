/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Damager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager#getKeywordGroups <em>Keyword Groups</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getRuleDamager()
 * @model
 * @generated
 */
public interface RuleDamager extends Damager
{
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
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getRuleDamager_Tokens()
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
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getRuleDamager_KeywordGroups()
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
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getRuleDamager_Rules()
   * @model containment="true"
   * @generated
   */
  EList<ScannerRule> getRules();

} // RuleDamager
