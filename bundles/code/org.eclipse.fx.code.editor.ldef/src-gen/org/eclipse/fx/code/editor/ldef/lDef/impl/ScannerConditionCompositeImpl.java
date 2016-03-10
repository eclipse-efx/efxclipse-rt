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

import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionComposite;
import org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionCompositeElement;
import org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionExits;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scanner Condition Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.ScannerConditionCompositeImpl#getPrim <em>Prim</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.ScannerConditionCompositeImpl#getSecondary <em>Secondary</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScannerConditionCompositeImpl extends ScannerConditionImpl implements ScannerConditionComposite
{
  /**
   * The cached value of the '{@link #getPrim() <em>Prim</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrim()
   * @generated
   * @ordered
   */
  protected ScannerConditionExits prim;

  /**
   * The cached value of the '{@link #getSecondary() <em>Secondary</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondary()
   * @generated
   * @ordered
   */
  protected EList<ScannerConditionCompositeElement> secondary;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ScannerConditionCompositeImpl()
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
    return LDefPackage.Literals.SCANNER_CONDITION_COMPOSITE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScannerConditionExits getPrim()
  {
    return prim;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrim(ScannerConditionExits newPrim, NotificationChain msgs)
  {
    ScannerConditionExits oldPrim = prim;
    prim = newPrim;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_CONDITION_COMPOSITE__PRIM, oldPrim, newPrim);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrim(ScannerConditionExits newPrim)
  {
    if (newPrim != prim)
    {
      NotificationChain msgs = null;
      if (prim != null)
        msgs = ((InternalEObject)prim).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.SCANNER_CONDITION_COMPOSITE__PRIM, null, msgs);
      if (newPrim != null)
        msgs = ((InternalEObject)newPrim).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.SCANNER_CONDITION_COMPOSITE__PRIM, null, msgs);
      msgs = basicSetPrim(newPrim, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_CONDITION_COMPOSITE__PRIM, newPrim, newPrim));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ScannerConditionCompositeElement> getSecondary()
  {
    if (secondary == null)
    {
      secondary = new EObjectContainmentEList<ScannerConditionCompositeElement>(ScannerConditionCompositeElement.class, this, LDefPackage.SCANNER_CONDITION_COMPOSITE__SECONDARY);
    }
    return secondary;
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
      case LDefPackage.SCANNER_CONDITION_COMPOSITE__PRIM:
        return basicSetPrim(null, msgs);
      case LDefPackage.SCANNER_CONDITION_COMPOSITE__SECONDARY:
        return ((InternalEList<?>)getSecondary()).basicRemove(otherEnd, msgs);
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
      case LDefPackage.SCANNER_CONDITION_COMPOSITE__PRIM:
        return getPrim();
      case LDefPackage.SCANNER_CONDITION_COMPOSITE__SECONDARY:
        return getSecondary();
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
      case LDefPackage.SCANNER_CONDITION_COMPOSITE__PRIM:
        setPrim((ScannerConditionExits)newValue);
        return;
      case LDefPackage.SCANNER_CONDITION_COMPOSITE__SECONDARY:
        getSecondary().clear();
        getSecondary().addAll((Collection<? extends ScannerConditionCompositeElement>)newValue);
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
      case LDefPackage.SCANNER_CONDITION_COMPOSITE__PRIM:
        setPrim((ScannerConditionExits)null);
        return;
      case LDefPackage.SCANNER_CONDITION_COMPOSITE__SECONDARY:
        getSecondary().clear();
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
      case LDefPackage.SCANNER_CONDITION_COMPOSITE__PRIM:
        return prim != null;
      case LDefPackage.SCANNER_CONDITION_COMPOSITE__SECONDARY:
        return secondary != null && !secondary.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ScannerConditionCompositeImpl
