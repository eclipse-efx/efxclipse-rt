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
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage;
import org.eclipse.fx.code.compensator.hsl.hSL.Partition;
import org.eclipse.fx.code.compensator.hsl.hSL.PartitionJSRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partition JS Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionJSRuleImpl#getToken <em>Token</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.PartitionJSRuleImpl#getFileURI <em>File URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartitionJSRuleImpl extends ParitionRuleImpl implements PartitionJSRule
{
  /**
   * The cached value of the '{@link #getToken() <em>Token</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToken()
   * @generated
   * @ordered
   */
  protected Partition token;

  /**
   * The default value of the '{@link #getFileURI() <em>File URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFileURI()
   * @generated
   * @ordered
   */
  protected static final String FILE_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFileURI() <em>File URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFileURI()
   * @generated
   * @ordered
   */
  protected String fileURI = FILE_URI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PartitionJSRuleImpl()
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
    return HSLPackage.Literals.PARTITION_JS_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition getToken()
  {
    if (token != null && token.eIsProxy())
    {
      InternalEObject oldToken = (InternalEObject)token;
      token = (Partition)eResolveProxy(oldToken);
      if (token != oldToken)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HSLPackage.PARTITION_JS_RULE__TOKEN, oldToken, token));
      }
    }
    return token;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition basicGetToken()
  {
    return token;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToken(Partition newToken)
  {
    Partition oldToken = token;
    token = newToken;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.PARTITION_JS_RULE__TOKEN, oldToken, token));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFileURI()
  {
    return fileURI;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFileURI(String newFileURI)
  {
    String oldFileURI = fileURI;
    fileURI = newFileURI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.PARTITION_JS_RULE__FILE_URI, oldFileURI, fileURI));
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
      case HSLPackage.PARTITION_JS_RULE__TOKEN:
        if (resolve) return getToken();
        return basicGetToken();
      case HSLPackage.PARTITION_JS_RULE__FILE_URI:
        return getFileURI();
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
      case HSLPackage.PARTITION_JS_RULE__TOKEN:
        setToken((Partition)newValue);
        return;
      case HSLPackage.PARTITION_JS_RULE__FILE_URI:
        setFileURI((String)newValue);
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
      case HSLPackage.PARTITION_JS_RULE__TOKEN:
        setToken((Partition)null);
        return;
      case HSLPackage.PARTITION_JS_RULE__FILE_URI:
        setFileURI(FILE_URI_EDEFAULT);
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
      case HSLPackage.PARTITION_JS_RULE__TOKEN:
        return token != null;
      case HSLPackage.PARTITION_JS_RULE__FILE_URI:
        return FILE_URI_EDEFAULT == null ? fileURI != null : !FILE_URI_EDEFAULT.equals(fileURI);
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
    result.append(" (fileURI: ");
    result.append(fileURI);
    result.append(')');
    return result.toString();
  }

} //PartitionJSRuleImpl
