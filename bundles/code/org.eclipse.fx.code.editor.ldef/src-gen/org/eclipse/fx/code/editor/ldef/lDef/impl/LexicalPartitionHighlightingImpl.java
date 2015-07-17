/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.Partition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lexical Partition Highlighting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlightingImpl#getPartition <em>Partition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LexicalPartitionHighlightingImpl extends MinimalEObjectImpl.Container implements LexicalPartitionHighlighting
{
  /**
   * The cached value of the '{@link #getPartition() <em>Partition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartition()
   * @generated
   * @ordered
   */
  protected Partition partition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LexicalPartitionHighlightingImpl()
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
    return LDefPackage.Literals.LEXICAL_PARTITION_HIGHLIGHTING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition getPartition()
  {
    if (partition != null && partition.eIsProxy())
    {
      InternalEObject oldPartition = (InternalEObject)partition;
      partition = (Partition)eResolveProxy(oldPartition);
      if (partition != oldPartition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING__PARTITION, oldPartition, partition));
      }
    }
    return partition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition basicGetPartition()
  {
    return partition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPartition(Partition newPartition)
  {
    Partition oldPartition = partition;
    partition = newPartition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING__PARTITION, oldPartition, partition));
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
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING__PARTITION:
        if (resolve) return getPartition();
        return basicGetPartition();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING__PARTITION:
        setPartition((Partition)newValue);
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
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING__PARTITION:
        setPartition((Partition)null);
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
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING__PARTITION:
        return partition != null;
    }
    return super.eIsSet(featureID);
  }

} //LexicalPartitionHighlightingImpl
