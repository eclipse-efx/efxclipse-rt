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
package org.eclipse.fx.xtext.statemachine.statemachine.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.fx.xtext.statemachine.statemachine.OutputSignal;
import org.eclipse.fx.xtext.statemachine.statemachine.StatemachinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Signal</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OutputSignalImpl extends SignalImpl implements OutputSignal
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OutputSignalImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return StatemachinePackage.Literals.OUTPUT_SIGNAL;
  }

} //OutputSignalImpl
