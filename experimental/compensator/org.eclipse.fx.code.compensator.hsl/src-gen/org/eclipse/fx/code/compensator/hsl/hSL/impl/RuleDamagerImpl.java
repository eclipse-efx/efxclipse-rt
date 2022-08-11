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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage;
import org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup;
import org.eclipse.fx.code.compensator.hsl.hSL.RuleDamager;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerRule;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Damager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.RuleDamagerImpl#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.RuleDamagerImpl#getKeywordGroups <em>Keyword Groups</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.RuleDamagerImpl#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleDamagerImpl extends DamagerImpl implements RuleDamager
{
  /**
   * The cached value of the '{@link #getTokens() <em>Tokens</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTokens()
   * @generated
   * @ordered
   */
  protected EList<ScannerToken> tokens;

  /**
   * The cached value of the '{@link #getKeywordGroups() <em>Keyword Groups</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeywordGroups()
   * @generated
   * @ordered
   */
  protected EList<KeywordGroup> keywordGroups;

  /**
   * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRules()
   * @generated
   * @ordered
   */
  protected EList<ScannerRule> rules;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleDamagerImpl()
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
    return HSLPackage.Literals.RULE_DAMAGER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ScannerToken> getTokens()
  {
    if (tokens == null)
    {
      tokens = new EObjectContainmentEList<ScannerToken>(ScannerToken.class, this, HSLPackage.RULE_DAMAGER__TOKENS);
    }
    return tokens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<KeywordGroup> getKeywordGroups()
  {
    if (keywordGroups == null)
    {
      keywordGroups = new EObjectContainmentEList<KeywordGroup>(KeywordGroup.class, this, HSLPackage.RULE_DAMAGER__KEYWORD_GROUPS);
    }
    return keywordGroups;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ScannerRule> getRules()
  {
    if (rules == null)
    {
      rules = new EObjectContainmentEList<ScannerRule>(ScannerRule.class, this, HSLPackage.RULE_DAMAGER__RULES);
    }
    return rules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case HSLPackage.RULE_DAMAGER__TOKENS:
        return ((InternalEList<?>)getTokens()).basicRemove(otherEnd, msgs);
      case HSLPackage.RULE_DAMAGER__KEYWORD_GROUPS:
        return ((InternalEList<?>)getKeywordGroups()).basicRemove(otherEnd, msgs);
      case HSLPackage.RULE_DAMAGER__RULES:
        return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case HSLPackage.RULE_DAMAGER__TOKENS:
        return getTokens();
      case HSLPackage.RULE_DAMAGER__KEYWORD_GROUPS:
        return getKeywordGroups();
      case HSLPackage.RULE_DAMAGER__RULES:
        return getRules();
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
      case HSLPackage.RULE_DAMAGER__TOKENS:
        getTokens().clear();
        getTokens().addAll((Collection<? extends ScannerToken>)newValue);
        return;
      case HSLPackage.RULE_DAMAGER__KEYWORD_GROUPS:
        getKeywordGroups().clear();
        getKeywordGroups().addAll((Collection<? extends KeywordGroup>)newValue);
        return;
      case HSLPackage.RULE_DAMAGER__RULES:
        getRules().clear();
        getRules().addAll((Collection<? extends ScannerRule>)newValue);
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
      case HSLPackage.RULE_DAMAGER__TOKENS:
        getTokens().clear();
        return;
      case HSLPackage.RULE_DAMAGER__KEYWORD_GROUPS:
        getKeywordGroups().clear();
        return;
      case HSLPackage.RULE_DAMAGER__RULES:
        getRules().clear();
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
      case HSLPackage.RULE_DAMAGER__TOKENS:
        return tokens != null && !tokens.isEmpty();
      case HSLPackage.RULE_DAMAGER__KEYWORD_GROUPS:
        return keywordGroups != null && !keywordGroups.isEmpty();
      case HSLPackage.RULE_DAMAGER__RULES:
        return rules != null && !rules.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RuleDamagerImpl
