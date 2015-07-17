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

import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule;
import org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partitioner Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partitioner_RuleImpl#getRuleList <em>Rule List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Partitioner_RuleImpl extends PartitionerImpl implements Partitioner_Rule
{
  /**
   * The cached value of the '{@link #getRuleList() <em>Rule List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRuleList()
   * @generated
   * @ordered
   */
  protected EList<Partition_Rule> ruleList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Partitioner_RuleImpl()
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
    return LDefPackage.Literals.PARTITIONER_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Partition_Rule> getRuleList()
  {
    if (ruleList == null)
    {
      ruleList = new EObjectContainmentEList<Partition_Rule>(Partition_Rule.class, this, LDefPackage.PARTITIONER_RULE__RULE_LIST);
    }
    return ruleList;
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
      case LDefPackage.PARTITIONER_RULE__RULE_LIST:
        return ((InternalEList<?>)getRuleList()).basicRemove(otherEnd, msgs);
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
      case LDefPackage.PARTITIONER_RULE__RULE_LIST:
        return getRuleList();
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
      case LDefPackage.PARTITIONER_RULE__RULE_LIST:
        getRuleList().clear();
        getRuleList().addAll((Collection<? extends Partition_Rule>)newValue);
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
      case LDefPackage.PARTITIONER_RULE__RULE_LIST:
        getRuleList().clear();
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
      case LDefPackage.PARTITIONER_RULE__RULE_LIST:
        return ruleList != null && !ruleList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Partitioner_RuleImpl
