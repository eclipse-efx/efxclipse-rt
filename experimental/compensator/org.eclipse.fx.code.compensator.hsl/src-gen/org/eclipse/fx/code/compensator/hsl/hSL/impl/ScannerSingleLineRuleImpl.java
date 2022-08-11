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
package org.eclipse.fx.code.compensator.hsl.hSL.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerSingleLineRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scanner Single Line Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerSingleLineRuleImpl#getStartSeq <em>Start Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerSingleLineRuleImpl#getEndSeq <em>End Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerSingleLineRuleImpl#getEscapeSeq <em>Escape Seq</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScannerSingleLineRuleImpl extends ScannerRuleImpl implements ScannerSingleLineRule
{
  /**
   * The default value of the '{@link #getStartSeq() <em>Start Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartSeq()
   * @generated
   * @ordered
   */
  protected static final String START_SEQ_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStartSeq() <em>Start Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartSeq()
   * @generated
   * @ordered
   */
  protected String startSeq = START_SEQ_EDEFAULT;

  /**
   * The default value of the '{@link #getEndSeq() <em>End Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndSeq()
   * @generated
   * @ordered
   */
  protected static final String END_SEQ_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEndSeq() <em>End Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndSeq()
   * @generated
   * @ordered
   */
  protected String endSeq = END_SEQ_EDEFAULT;

  /**
   * The default value of the '{@link #getEscapeSeq() <em>Escape Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEscapeSeq()
   * @generated
   * @ordered
   */
  protected static final String ESCAPE_SEQ_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEscapeSeq() <em>Escape Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEscapeSeq()
   * @generated
   * @ordered
   */
  protected String escapeSeq = ESCAPE_SEQ_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ScannerSingleLineRuleImpl()
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
    return HSLPackage.Literals.SCANNER_SINGLE_LINE_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStartSeq()
  {
    return startSeq;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartSeq(String newStartSeq)
  {
    String oldStartSeq = startSeq;
    startSeq = newStartSeq;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_SINGLE_LINE_RULE__START_SEQ, oldStartSeq, startSeq));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEndSeq()
  {
    return endSeq;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEndSeq(String newEndSeq)
  {
    String oldEndSeq = endSeq;
    endSeq = newEndSeq;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_SINGLE_LINE_RULE__END_SEQ, oldEndSeq, endSeq));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEscapeSeq()
  {
    return escapeSeq;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEscapeSeq(String newEscapeSeq)
  {
    String oldEscapeSeq = escapeSeq;
    escapeSeq = newEscapeSeq;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ, oldEscapeSeq, escapeSeq));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case HSLPackage.SCANNER_SINGLE_LINE_RULE__START_SEQ:
        return getStartSeq();
      case HSLPackage.SCANNER_SINGLE_LINE_RULE__END_SEQ:
        return getEndSeq();
      case HSLPackage.SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ:
        return getEscapeSeq();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case HSLPackage.SCANNER_SINGLE_LINE_RULE__START_SEQ:
        setStartSeq((String)newValue);
        return;
      case HSLPackage.SCANNER_SINGLE_LINE_RULE__END_SEQ:
        setEndSeq((String)newValue);
        return;
      case HSLPackage.SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ:
        setEscapeSeq((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case HSLPackage.SCANNER_SINGLE_LINE_RULE__START_SEQ:
        setStartSeq(START_SEQ_EDEFAULT);
        return;
      case HSLPackage.SCANNER_SINGLE_LINE_RULE__END_SEQ:
        setEndSeq(END_SEQ_EDEFAULT);
        return;
      case HSLPackage.SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ:
        setEscapeSeq(ESCAPE_SEQ_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case HSLPackage.SCANNER_SINGLE_LINE_RULE__START_SEQ:
        return START_SEQ_EDEFAULT == null ? startSeq != null : !START_SEQ_EDEFAULT.equals(startSeq);
      case HSLPackage.SCANNER_SINGLE_LINE_RULE__END_SEQ:
        return END_SEQ_EDEFAULT == null ? endSeq != null : !END_SEQ_EDEFAULT.equals(endSeq);
      case HSLPackage.SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ:
        return ESCAPE_SEQ_EDEFAULT == null ? escapeSeq != null : !ESCAPE_SEQ_EDEFAULT.equals(escapeSeq);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (startSeq: ");
    result.append(startSeq);
    result.append(", endSeq: ");
    result.append(endSeq);
    result.append(", escapeSeq: ");
    result.append(escapeSeq);
    result.append(')');
    return result.toString();
  }

} //ScannerSingleLineRuleImpl
