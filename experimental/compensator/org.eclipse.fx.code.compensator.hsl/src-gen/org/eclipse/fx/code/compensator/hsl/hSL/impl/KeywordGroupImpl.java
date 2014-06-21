/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage;
import org.eclipse.fx.code.compensator.hsl.hSL.Keyword;
import org.eclipse.fx.code.compensator.hsl.hSL.KeywordGroup;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Keyword Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.KeywordGroupImpl#getToken <em>Token</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.KeywordGroupImpl#getKeywords <em>Keywords</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeywordGroupImpl extends MinimalEObjectImpl.Container implements KeywordGroup
{
  /**
   * The cached value of the '{@link #getToken() <em>Token</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToken()
   * @generated
   * @ordered
   */
  protected ScannerToken token;

  /**
   * The cached value of the '{@link #getKeywords() <em>Keywords</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeywords()
   * @generated
   * @ordered
   */
  protected EList<Keyword> keywords;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected KeywordGroupImpl()
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
    return HSLPackage.Literals.KEYWORD_GROUP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScannerToken getToken()
  {
    if (token != null && token.eIsProxy())
    {
      InternalEObject oldToken = (InternalEObject)token;
      token = (ScannerToken)eResolveProxy(oldToken);
      if (token != oldToken)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HSLPackage.KEYWORD_GROUP__TOKEN, oldToken, token));
      }
    }
    return token;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScannerToken basicGetToken()
  {
    return token;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToken(ScannerToken newToken)
  {
    ScannerToken oldToken = token;
    token = newToken;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.KEYWORD_GROUP__TOKEN, oldToken, token));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Keyword> getKeywords()
  {
    if (keywords == null)
    {
      keywords = new EObjectContainmentEList<Keyword>(Keyword.class, this, HSLPackage.KEYWORD_GROUP__KEYWORDS);
    }
    return keywords;
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
      case HSLPackage.KEYWORD_GROUP__KEYWORDS:
        return ((InternalEList<?>)getKeywords()).basicRemove(otherEnd, msgs);
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
      case HSLPackage.KEYWORD_GROUP__TOKEN:
        if (resolve) return getToken();
        return basicGetToken();
      case HSLPackage.KEYWORD_GROUP__KEYWORDS:
        return getKeywords();
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
      case HSLPackage.KEYWORD_GROUP__TOKEN:
        setToken((ScannerToken)newValue);
        return;
      case HSLPackage.KEYWORD_GROUP__KEYWORDS:
        getKeywords().clear();
        getKeywords().addAll((Collection<? extends Keyword>)newValue);
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
      case HSLPackage.KEYWORD_GROUP__TOKEN:
        setToken((ScannerToken)null);
        return;
      case HSLPackage.KEYWORD_GROUP__KEYWORDS:
        getKeywords().clear();
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
      case HSLPackage.KEYWORD_GROUP__TOKEN:
        return token != null;
      case HSLPackage.KEYWORD_GROUP__KEYWORDS:
        return keywords != null && !keywords.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //KeywordGroupImpl
