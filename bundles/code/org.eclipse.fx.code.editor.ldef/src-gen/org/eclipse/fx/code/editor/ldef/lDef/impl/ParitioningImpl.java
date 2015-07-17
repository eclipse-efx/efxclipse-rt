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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.Paritioning;
import org.eclipse.fx.code.editor.ldef.lDef.Partition;
import org.eclipse.fx.code.editor.ldef.lDef.Partitioner;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Paritioning</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.ParitioningImpl#getPartitions <em>Partitions</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.ParitioningImpl#getPartitioner <em>Partitioner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParitioningImpl extends MinimalEObjectImpl.Container implements Paritioning
{
  /**
   * The cached value of the '{@link #getPartitions() <em>Partitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartitions()
   * @generated
   * @ordered
   */
  protected EList<Partition> partitions;

  /**
   * The cached value of the '{@link #getPartitioner() <em>Partitioner</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartitioner()
   * @generated
   * @ordered
   */
  protected Partitioner partitioner;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParitioningImpl()
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
    return LDefPackage.Literals.PARITIONING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Partition> getPartitions()
  {
    if (partitions == null)
    {
      partitions = new EObjectContainmentEList<Partition>(Partition.class, this, LDefPackage.PARITIONING__PARTITIONS);
    }
    return partitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partitioner getPartitioner()
  {
    return partitioner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPartitioner(Partitioner newPartitioner, NotificationChain msgs)
  {
    Partitioner oldPartitioner = partitioner;
    partitioner = newPartitioner;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.PARITIONING__PARTITIONER, oldPartitioner, newPartitioner);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPartitioner(Partitioner newPartitioner)
  {
    if (newPartitioner != partitioner)
    {
      NotificationChain msgs = null;
      if (partitioner != null)
        msgs = ((InternalEObject)partitioner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.PARITIONING__PARTITIONER, null, msgs);
      if (newPartitioner != null)
        msgs = ((InternalEObject)newPartitioner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.PARITIONING__PARTITIONER, null, msgs);
      msgs = basicSetPartitioner(newPartitioner, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.PARITIONING__PARTITIONER, newPartitioner, newPartitioner));
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
      case LDefPackage.PARITIONING__PARTITIONS:
        return ((InternalEList<?>)getPartitions()).basicRemove(otherEnd, msgs);
      case LDefPackage.PARITIONING__PARTITIONER:
        return basicSetPartitioner(null, msgs);
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
      case LDefPackage.PARITIONING__PARTITIONS:
        return getPartitions();
      case LDefPackage.PARITIONING__PARTITIONER:
        return getPartitioner();
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
      case LDefPackage.PARITIONING__PARTITIONS:
        getPartitions().clear();
        getPartitions().addAll((Collection<? extends Partition>)newValue);
        return;
      case LDefPackage.PARITIONING__PARTITIONER:
        setPartitioner((Partitioner)newValue);
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
      case LDefPackage.PARITIONING__PARTITIONS:
        getPartitions().clear();
        return;
      case LDefPackage.PARITIONING__PARTITIONER:
        setPartitioner((Partitioner)null);
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
      case LDefPackage.PARITIONING__PARTITIONS:
        return partitions != null && !partitions.isEmpty();
      case LDefPackage.PARITIONING__PARTITIONER:
        return partitioner != null;
    }
    return super.eIsSet(featureID);
  }

} //ParitioningImpl
