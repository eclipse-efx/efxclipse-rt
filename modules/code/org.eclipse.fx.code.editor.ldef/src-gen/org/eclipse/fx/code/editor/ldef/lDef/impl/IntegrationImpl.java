/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fx.code.editor.ldef.lDef.CodeIntegration;
import org.eclipse.fx.code.editor.ldef.lDef.Integration;
import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.IntegrationImpl#getCodeIntegrationList <em>Code Integration List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegrationImpl extends MinimalEObjectImpl.Container implements Integration
{
  /**
   * The cached value of the '{@link #getCodeIntegrationList() <em>Code Integration List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodeIntegrationList()
   * @generated
   * @ordered
   */
  protected EList<CodeIntegration> codeIntegrationList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntegrationImpl()
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
    return LDefPackage.Literals.INTEGRATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CodeIntegration> getCodeIntegrationList()
  {
    if (codeIntegrationList == null)
    {
      codeIntegrationList = new EObjectContainmentEList<CodeIntegration>(CodeIntegration.class, this, LDefPackage.INTEGRATION__CODE_INTEGRATION_LIST);
    }
    return codeIntegrationList;
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
      case LDefPackage.INTEGRATION__CODE_INTEGRATION_LIST:
        return ((InternalEList<?>)getCodeIntegrationList()).basicRemove(otherEnd, msgs);
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
      case LDefPackage.INTEGRATION__CODE_INTEGRATION_LIST:
        return getCodeIntegrationList();
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
      case LDefPackage.INTEGRATION__CODE_INTEGRATION_LIST:
        getCodeIntegrationList().clear();
        getCodeIntegrationList().addAll((Collection<? extends CodeIntegration>)newValue);
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
      case LDefPackage.INTEGRATION__CODE_INTEGRATION_LIST:
        getCodeIntegrationList().clear();
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
      case LDefPackage.INTEGRATION__CODE_INTEGRATION_LIST:
        return codeIntegrationList != null && !codeIntegrationList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //IntegrationImpl
