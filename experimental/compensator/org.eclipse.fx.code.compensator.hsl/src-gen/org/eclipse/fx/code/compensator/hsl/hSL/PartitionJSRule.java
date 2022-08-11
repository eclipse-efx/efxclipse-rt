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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partition JS Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule#getToken <em>Token</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule#getFileURI <em>File URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getPartitionJSRule()
 * @model
 * @generated
 */
public interface PartitionJSRule extends ParitionRule
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
   * @see #setToken(Partition)
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getPartitionJSRule_Token()
   * @model
   * @generated
   */
  Partition getToken();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule#getToken <em>Token</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Token</em>' reference.
   * @see #getToken()
   * @generated
   */
  void setToken(Partition value);

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
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getPartitionJSRule_FileURI()
   * @model
   * @generated
   */
  String getFileURI();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule#getFileURI <em>File URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File URI</em>' attribute.
   * @see #getFileURI()
   * @generated
   */
  void setFileURI(String value);

} // PartitionJSRule
