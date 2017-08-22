/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fx.code.editor.ldef.lDef.Keyword;
import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.ScannerCondition;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scanner Keyword</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_KeywordImpl#getKeywords <em>Keywords</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_KeywordImpl#getEnabledIf <em>Enabled If</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Scanner_KeywordImpl extends ScannerImpl implements Scanner_Keyword
{
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
   * The cached value of the '{@link #getEnabledIf() <em>Enabled If</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnabledIf()
   * @generated
   * @ordered
   */
  protected ScannerCondition enabledIf;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Scanner_KeywordImpl()
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
    return LDefPackage.Literals.SCANNER_KEYWORD;
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
      keywords = new EObjectContainmentEList<Keyword>(Keyword.class, this, LDefPackage.SCANNER_KEYWORD__KEYWORDS);
    }
    return keywords;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScannerCondition getEnabledIf()
  {
    return enabledIf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnabledIf(ScannerCondition newEnabledIf, NotificationChain msgs)
  {
    ScannerCondition oldEnabledIf = enabledIf;
    enabledIf = newEnabledIf;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_KEYWORD__ENABLED_IF, oldEnabledIf, newEnabledIf);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnabledIf(ScannerCondition newEnabledIf)
  {
    if (newEnabledIf != enabledIf)
    {
      NotificationChain msgs = null;
      if (enabledIf != null)
        msgs = ((InternalEObject)enabledIf).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.SCANNER_KEYWORD__ENABLED_IF, null, msgs);
      if (newEnabledIf != null)
        msgs = ((InternalEObject)newEnabledIf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.SCANNER_KEYWORD__ENABLED_IF, null, msgs);
      msgs = basicSetEnabledIf(newEnabledIf, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_KEYWORD__ENABLED_IF, newEnabledIf, newEnabledIf));
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
      case LDefPackage.SCANNER_KEYWORD__KEYWORDS:
        return ((InternalEList<?>)getKeywords()).basicRemove(otherEnd, msgs);
      case LDefPackage.SCANNER_KEYWORD__ENABLED_IF:
        return basicSetEnabledIf(null, msgs);
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
      case LDefPackage.SCANNER_KEYWORD__KEYWORDS:
        return getKeywords();
      case LDefPackage.SCANNER_KEYWORD__ENABLED_IF:
        return getEnabledIf();
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
      case LDefPackage.SCANNER_KEYWORD__KEYWORDS:
        getKeywords().clear();
        getKeywords().addAll((Collection<? extends Keyword>)newValue);
        return;
      case LDefPackage.SCANNER_KEYWORD__ENABLED_IF:
        setEnabledIf((ScannerCondition)newValue);
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
      case LDefPackage.SCANNER_KEYWORD__KEYWORDS:
        getKeywords().clear();
        return;
      case LDefPackage.SCANNER_KEYWORD__ENABLED_IF:
        setEnabledIf((ScannerCondition)null);
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
      case LDefPackage.SCANNER_KEYWORD__KEYWORDS:
        return keywords != null && !keywords.isEmpty();
      case LDefPackage.SCANNER_KEYWORD__ENABLED_IF:
        return enabledIf != null;
    }
    return super.eIsSet(featureID);
  }

} //Scanner_KeywordImpl
