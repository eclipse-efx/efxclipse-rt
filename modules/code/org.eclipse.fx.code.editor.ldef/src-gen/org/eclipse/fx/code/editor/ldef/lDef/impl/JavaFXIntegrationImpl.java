/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fx.code.editor.ldef.lDef.Codegeneration;
import org.eclipse.fx.code.editor.ldef.lDef.JavaFXIntegration;
import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java FX Integration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.JavaFXIntegrationImpl#getCodegenerationList <em>Codegeneration List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaFXIntegrationImpl extends CodeIntegrationImpl implements JavaFXIntegration
{
  /**
   * The cached value of the '{@link #getCodegenerationList() <em>Codegeneration List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodegenerationList()
   * @generated
   * @ordered
   */
  protected EList<Codegeneration> codegenerationList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavaFXIntegrationImpl()
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
    return LDefPackage.Literals.JAVA_FX_INTEGRATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Codegeneration> getCodegenerationList()
  {
    if (codegenerationList == null)
    {
      codegenerationList = new EObjectContainmentEList<Codegeneration>(Codegeneration.class, this, LDefPackage.JAVA_FX_INTEGRATION__CODEGENERATION_LIST);
    }
    return codegenerationList;
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
      case LDefPackage.JAVA_FX_INTEGRATION__CODEGENERATION_LIST:
        return ((InternalEList<?>)getCodegenerationList()).basicRemove(otherEnd, msgs);
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
      case LDefPackage.JAVA_FX_INTEGRATION__CODEGENERATION_LIST:
        return getCodegenerationList();
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
      case LDefPackage.JAVA_FX_INTEGRATION__CODEGENERATION_LIST:
        getCodegenerationList().clear();
        getCodegenerationList().addAll((Collection<? extends Codegeneration>)newValue);
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
      case LDefPackage.JAVA_FX_INTEGRATION__CODEGENERATION_LIST:
        getCodegenerationList().clear();
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
      case LDefPackage.JAVA_FX_INTEGRATION__CODEGENERATION_LIST:
        return codegenerationList != null && !codegenerationList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //JavaFXIntegrationImpl
