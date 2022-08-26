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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getPartitions <em>Partitions</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getDamagers <em>Damagers</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getPartitioner <em>Partitioner</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getContentTypes <em>Content Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Partitions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.compensator.hsl.hSL.Partition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Partitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Partitions</em>' containment reference list.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getModel_Partitions()
   * @model containment="true"
   * @generated
   */
  EList<Partition> getPartitions();

  /**
   * Returns the value of the '<em><b>Damagers</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.compensator.hsl.hSL.Damager}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Damagers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Damagers</em>' containment reference list.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getModel_Damagers()
   * @model containment="true"
   * @generated
   */
  EList<Damager> getDamagers();

  /**
   * Returns the value of the '<em><b>Partitioner</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Partitioner</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Partitioner</em>' containment reference.
   * @see #setPartitioner(Partitioner)
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getModel_Partitioner()
   * @model containment="true"
   * @generated
   */
  Partitioner getPartitioner();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.Model#getPartitioner <em>Partitioner</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Partitioner</em>' containment reference.
   * @see #getPartitioner()
   * @generated
   */
  void setPartitioner(Partitioner value);

  /**
   * Returns the value of the '<em><b>Content Types</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content Types</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content Types</em>' attribute list.
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getModel_ContentTypes()
   * @model unique="false"
   * @generated
   */
  EList<String> getContentTypes();

} // Model
