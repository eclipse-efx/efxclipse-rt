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

import org.eclipse.fx.code.compensator.hsl.hSL.Damager;
import org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage;
import org.eclipse.fx.code.compensator.hsl.hSL.Model;
import org.eclipse.fx.code.compensator.hsl.hSL.Partition;
import org.eclipse.fx.code.compensator.hsl.hSL.Partitioner;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ModelImpl#getPartitions <em>Partitions</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ModelImpl#getDamagers <em>Damagers</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ModelImpl#getPartitioner <em>Partitioner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

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
   * The cached value of the '{@link #getDamagers() <em>Damagers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDamagers()
   * @generated
   * @ordered
   */
  protected EList<Damager> damagers;

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
  protected ModelImpl()
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
    return HSLPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.MODEL__NAME, oldName, name));
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
      partitions = new EObjectContainmentEList<Partition>(Partition.class, this, HSLPackage.MODEL__PARTITIONS);
    }
    return partitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Damager> getDamagers()
  {
    if (damagers == null)
    {
      damagers = new EObjectContainmentEList<Damager>(Damager.class, this, HSLPackage.MODEL__DAMAGERS);
    }
    return damagers;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HSLPackage.MODEL__PARTITIONER, oldPartitioner, newPartitioner);
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
        msgs = ((InternalEObject)partitioner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HSLPackage.MODEL__PARTITIONER, null, msgs);
      if (newPartitioner != null)
        msgs = ((InternalEObject)newPartitioner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HSLPackage.MODEL__PARTITIONER, null, msgs);
      msgs = basicSetPartitioner(newPartitioner, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.MODEL__PARTITIONER, newPartitioner, newPartitioner));
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
      case HSLPackage.MODEL__PARTITIONS:
        return ((InternalEList<?>)getPartitions()).basicRemove(otherEnd, msgs);
      case HSLPackage.MODEL__DAMAGERS:
        return ((InternalEList<?>)getDamagers()).basicRemove(otherEnd, msgs);
      case HSLPackage.MODEL__PARTITIONER:
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
      case HSLPackage.MODEL__NAME:
        return getName();
      case HSLPackage.MODEL__PARTITIONS:
        return getPartitions();
      case HSLPackage.MODEL__DAMAGERS:
        return getDamagers();
      case HSLPackage.MODEL__PARTITIONER:
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
      case HSLPackage.MODEL__NAME:
        setName((String)newValue);
        return;
      case HSLPackage.MODEL__PARTITIONS:
        getPartitions().clear();
        getPartitions().addAll((Collection<? extends Partition>)newValue);
        return;
      case HSLPackage.MODEL__DAMAGERS:
        getDamagers().clear();
        getDamagers().addAll((Collection<? extends Damager>)newValue);
        return;
      case HSLPackage.MODEL__PARTITIONER:
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
      case HSLPackage.MODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case HSLPackage.MODEL__PARTITIONS:
        getPartitions().clear();
        return;
      case HSLPackage.MODEL__DAMAGERS:
        getDamagers().clear();
        return;
      case HSLPackage.MODEL__PARTITIONER:
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
      case HSLPackage.MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case HSLPackage.MODEL__PARTITIONS:
        return partitions != null && !partitions.isEmpty();
      case HSLPackage.MODEL__DAMAGERS:
        return damagers != null && !damagers.isEmpty();
      case HSLPackage.MODEL__PARTITIONER:
        return partitioner != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
