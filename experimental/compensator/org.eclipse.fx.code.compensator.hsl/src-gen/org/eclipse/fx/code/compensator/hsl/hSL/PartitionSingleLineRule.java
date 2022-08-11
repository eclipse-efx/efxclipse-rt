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
 * A representation of the model object '<em><b>Partition Single Line Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getParition <em>Parition</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getStartSeq <em>Start Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getEndSeq <em>End Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getEscapeSeq <em>Escape Seq</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getPartitionSingleLineRule()
 * @model
 * @generated
 */
public interface PartitionSingleLineRule extends ParitionRule
{
  /**
   * Returns the value of the '<em><b>Parition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parition</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parition</em>' reference.
   * @see #setParition(Partition)
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getPartitionSingleLineRule_Parition()
   * @model
   * @generated
   */
  Partition getParition();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getParition <em>Parition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parition</em>' reference.
   * @see #getParition()
   * @generated
   */
  void setParition(Partition value);

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
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getPartitionSingleLineRule_StartSeq()
   * @model
   * @generated
   */
  String getStartSeq();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getStartSeq <em>Start Seq</em>}' attribute.
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
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getPartitionSingleLineRule_EndSeq()
   * @model
   * @generated
   */
  String getEndSeq();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getEndSeq <em>End Seq</em>}' attribute.
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
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getPartitionSingleLineRule_EscapeSeq()
   * @model
   * @generated
   */
  String getEscapeSeq();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.PartitionSingleLineRule#getEscapeSeq <em>Escape Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Escape Seq</em>' attribute.
   * @see #getEscapeSeq()
   * @generated
   */
  void setEscapeSeq(String value);

} // PartitionSingleLineRule
