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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerWhitespaceRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scanner Whitespace Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerWhitespaceRuleImpl#getCharacters <em>Characters</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerWhitespaceRuleImpl#isJavawhitespace <em>Javawhitespace</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerWhitespaceRuleImpl#getFileURI <em>File URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScannerWhitespaceRuleImpl extends ScannerRuleImpl implements ScannerWhitespaceRule
{
  /**
   * The cached value of the '{@link #getCharacters() <em>Characters</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharacters()
   * @generated
   * @ordered
   */
  protected EList<String> characters;

  /**
   * The default value of the '{@link #isJavawhitespace() <em>Javawhitespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isJavawhitespace()
   * @generated
   * @ordered
   */
  protected static final boolean JAVAWHITESPACE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isJavawhitespace() <em>Javawhitespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isJavawhitespace()
   * @generated
   * @ordered
   */
  protected boolean javawhitespace = JAVAWHITESPACE_EDEFAULT;

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
  protected ScannerWhitespaceRuleImpl()
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
    return HSLPackage.Literals.SCANNER_WHITESPACE_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getCharacters()
  {
    if (characters == null)
    {
      characters = new EDataTypeEList<String>(String.class, this, HSLPackage.SCANNER_WHITESPACE_RULE__CHARACTERS);
    }
    return characters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isJavawhitespace()
  {
    return javawhitespace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJavawhitespace(boolean newJavawhitespace)
  {
    boolean oldJavawhitespace = javawhitespace;
    javawhitespace = newJavawhitespace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_WHITESPACE_RULE__JAVAWHITESPACE, oldJavawhitespace, javawhitespace));
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
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_WHITESPACE_RULE__FILE_URI, oldFileURI, fileURI));
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
      case HSLPackage.SCANNER_WHITESPACE_RULE__CHARACTERS:
        return getCharacters();
      case HSLPackage.SCANNER_WHITESPACE_RULE__JAVAWHITESPACE:
        return isJavawhitespace();
      case HSLPackage.SCANNER_WHITESPACE_RULE__FILE_URI:
        return getFileURI();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case HSLPackage.SCANNER_WHITESPACE_RULE__CHARACTERS:
        getCharacters().clear();
        getCharacters().addAll((Collection<? extends String>)newValue);
        return;
      case HSLPackage.SCANNER_WHITESPACE_RULE__JAVAWHITESPACE:
        setJavawhitespace((Boolean)newValue);
        return;
      case HSLPackage.SCANNER_WHITESPACE_RULE__FILE_URI:
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
      case HSLPackage.SCANNER_WHITESPACE_RULE__CHARACTERS:
        getCharacters().clear();
        return;
      case HSLPackage.SCANNER_WHITESPACE_RULE__JAVAWHITESPACE:
        setJavawhitespace(JAVAWHITESPACE_EDEFAULT);
        return;
      case HSLPackage.SCANNER_WHITESPACE_RULE__FILE_URI:
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
      case HSLPackage.SCANNER_WHITESPACE_RULE__CHARACTERS:
        return characters != null && !characters.isEmpty();
      case HSLPackage.SCANNER_WHITESPACE_RULE__JAVAWHITESPACE:
        return javawhitespace != JAVAWHITESPACE_EDEFAULT;
      case HSLPackage.SCANNER_WHITESPACE_RULE__FILE_URI:
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
    result.append(" (characters: ");
    result.append(characters);
    result.append(", javawhitespace: ");
    result.append(javawhitespace);
    result.append(", fileURI: ");
    result.append(fileURI);
    result.append(')');
    return result.toString();
  }

} //ScannerWhitespaceRuleImpl
