/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.fx.code.editor.ldef.lDef.Check;
import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.Partition;
import org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partition Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_RuleImpl#getParition <em>Parition</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_RuleImpl#getStartSeq <em>Start Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_RuleImpl#getCheck <em>Check</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_RuleImpl#getEndSeq <em>End Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_RuleImpl#getEscapeSeq <em>Escape Seq</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Partition_RuleImpl extends MinimalEObjectImpl.Container implements Partition_Rule
{
  /**
   * The cached value of the '{@link #getParition() <em>Parition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParition()
   * @generated
   * @ordered
   */
  protected Partition parition;

  /**
   * The default value of the '{@link #getStartSeq() <em>Start Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartSeq()
   * @generated
   * @ordered
   */
  protected static final String START_SEQ_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStartSeq() <em>Start Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartSeq()
   * @generated
   * @ordered
   */
  protected String startSeq = START_SEQ_EDEFAULT;

  /**
   * The cached value of the '{@link #getCheck() <em>Check</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCheck()
   * @generated
   * @ordered
   */
  protected Check check;

  /**
   * The default value of the '{@link #getEndSeq() <em>End Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndSeq()
   * @generated
   * @ordered
   */
  protected static final String END_SEQ_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEndSeq() <em>End Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndSeq()
   * @generated
   * @ordered
   */
  protected String endSeq = END_SEQ_EDEFAULT;

  /**
   * The default value of the '{@link #getEscapeSeq() <em>Escape Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEscapeSeq()
   * @generated
   * @ordered
   */
  protected static final String ESCAPE_SEQ_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEscapeSeq() <em>Escape Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEscapeSeq()
   * @generated
   * @ordered
   */
  protected String escapeSeq = ESCAPE_SEQ_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Partition_RuleImpl()
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
    return LDefPackage.Literals.PARTITION_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition getParition()
  {
    if (parition != null && parition.eIsProxy())
    {
      InternalEObject oldParition = (InternalEObject)parition;
      parition = (Partition)eResolveProxy(oldParition);
      if (parition != oldParition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LDefPackage.PARTITION_RULE__PARITION, oldParition, parition));
      }
    }
    return parition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Partition basicGetParition()
  {
    return parition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParition(Partition newParition)
  {
    Partition oldParition = parition;
    parition = newParition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.PARTITION_RULE__PARITION, oldParition, parition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStartSeq()
  {
    return startSeq;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartSeq(String newStartSeq)
  {
    String oldStartSeq = startSeq;
    startSeq = newStartSeq;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.PARTITION_RULE__START_SEQ, oldStartSeq, startSeq));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Check getCheck()
  {
    return check;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCheck(Check newCheck, NotificationChain msgs)
  {
    Check oldCheck = check;
    check = newCheck;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.PARTITION_RULE__CHECK, oldCheck, newCheck);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCheck(Check newCheck)
  {
    if (newCheck != check)
    {
      NotificationChain msgs = null;
      if (check != null)
        msgs = ((InternalEObject)check).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.PARTITION_RULE__CHECK, null, msgs);
      if (newCheck != null)
        msgs = ((InternalEObject)newCheck).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.PARTITION_RULE__CHECK, null, msgs);
      msgs = basicSetCheck(newCheck, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.PARTITION_RULE__CHECK, newCheck, newCheck));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEndSeq()
  {
    return endSeq;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEndSeq(String newEndSeq)
  {
    String oldEndSeq = endSeq;
    endSeq = newEndSeq;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.PARTITION_RULE__END_SEQ, oldEndSeq, endSeq));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEscapeSeq()
  {
    return escapeSeq;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEscapeSeq(String newEscapeSeq)
  {
    String oldEscapeSeq = escapeSeq;
    escapeSeq = newEscapeSeq;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.PARTITION_RULE__ESCAPE_SEQ, oldEscapeSeq, escapeSeq));
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
      case LDefPackage.PARTITION_RULE__CHECK:
        return basicSetCheck(null, msgs);
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
      case LDefPackage.PARTITION_RULE__PARITION:
        if (resolve) return getParition();
        return basicGetParition();
      case LDefPackage.PARTITION_RULE__START_SEQ:
        return getStartSeq();
      case LDefPackage.PARTITION_RULE__CHECK:
        return getCheck();
      case LDefPackage.PARTITION_RULE__END_SEQ:
        return getEndSeq();
      case LDefPackage.PARTITION_RULE__ESCAPE_SEQ:
        return getEscapeSeq();
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
      case LDefPackage.PARTITION_RULE__PARITION:
        setParition((Partition)newValue);
        return;
      case LDefPackage.PARTITION_RULE__START_SEQ:
        setStartSeq((String)newValue);
        return;
      case LDefPackage.PARTITION_RULE__CHECK:
        setCheck((Check)newValue);
        return;
      case LDefPackage.PARTITION_RULE__END_SEQ:
        setEndSeq((String)newValue);
        return;
      case LDefPackage.PARTITION_RULE__ESCAPE_SEQ:
        setEscapeSeq((String)newValue);
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
      case LDefPackage.PARTITION_RULE__PARITION:
        setParition((Partition)null);
        return;
      case LDefPackage.PARTITION_RULE__START_SEQ:
        setStartSeq(START_SEQ_EDEFAULT);
        return;
      case LDefPackage.PARTITION_RULE__CHECK:
        setCheck((Check)null);
        return;
      case LDefPackage.PARTITION_RULE__END_SEQ:
        setEndSeq(END_SEQ_EDEFAULT);
        return;
      case LDefPackage.PARTITION_RULE__ESCAPE_SEQ:
        setEscapeSeq(ESCAPE_SEQ_EDEFAULT);
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
      case LDefPackage.PARTITION_RULE__PARITION:
        return parition != null;
      case LDefPackage.PARTITION_RULE__START_SEQ:
        return START_SEQ_EDEFAULT == null ? startSeq != null : !START_SEQ_EDEFAULT.equals(startSeq);
      case LDefPackage.PARTITION_RULE__CHECK:
        return check != null;
      case LDefPackage.PARTITION_RULE__END_SEQ:
        return END_SEQ_EDEFAULT == null ? endSeq != null : !END_SEQ_EDEFAULT.equals(endSeq);
      case LDefPackage.PARTITION_RULE__ESCAPE_SEQ:
        return ESCAPE_SEQ_EDEFAULT == null ? escapeSeq != null : !ESCAPE_SEQ_EDEFAULT.equals(escapeSeq);
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
    result.append(" (startSeq: ");
    result.append(startSeq);
    result.append(", endSeq: ");
    result.append(endSeq);
    result.append(", escapeSeq: ");
    result.append(escapeSeq);
    result.append(')');
    return result.toString();
  }

} //Partition_RuleImpl
