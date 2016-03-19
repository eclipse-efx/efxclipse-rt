/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.Partition_MultiLineRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partition Multi Line Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_MultiLineRuleImpl#getStartSeq <em>Start Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_MultiLineRuleImpl#getStartPattern <em>Start Pattern</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_MultiLineRuleImpl#getStartSuffix <em>Start Suffix</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_MultiLineRuleImpl#getEndSeq <em>End Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Partition_MultiLineRuleImpl#getEscapeSeq <em>Escape Seq</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Partition_MultiLineRuleImpl extends Partition_RuleImpl implements Partition_MultiLineRule
{
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
   * The default value of the '{@link #getStartPattern() <em>Start Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartPattern()
   * @generated
   * @ordered
   */
  protected static final String START_PATTERN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStartPattern() <em>Start Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartPattern()
   * @generated
   * @ordered
   */
  protected String startPattern = START_PATTERN_EDEFAULT;

  /**
   * The default value of the '{@link #getStartSuffix() <em>Start Suffix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartSuffix()
   * @generated
   * @ordered
   */
  protected static final String START_SUFFIX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStartSuffix() <em>Start Suffix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartSuffix()
   * @generated
   * @ordered
   */
  protected String startSuffix = START_SUFFIX_EDEFAULT;

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
  protected Partition_MultiLineRuleImpl()
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
    return LDefPackage.Literals.PARTITION_MULTI_LINE_RULE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.PARTITION_MULTI_LINE_RULE__START_SEQ, oldStartSeq, startSeq));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStartPattern()
  {
    return startPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartPattern(String newStartPattern)
  {
    String oldStartPattern = startPattern;
    startPattern = newStartPattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.PARTITION_MULTI_LINE_RULE__START_PATTERN, oldStartPattern, startPattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStartSuffix()
  {
    return startSuffix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartSuffix(String newStartSuffix)
  {
    String oldStartSuffix = startSuffix;
    startSuffix = newStartSuffix;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.PARTITION_MULTI_LINE_RULE__START_SUFFIX, oldStartSuffix, startSuffix));
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
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.PARTITION_MULTI_LINE_RULE__END_SEQ, oldEndSeq, endSeq));
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
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.PARTITION_MULTI_LINE_RULE__ESCAPE_SEQ, oldEscapeSeq, escapeSeq));
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
      case LDefPackage.PARTITION_MULTI_LINE_RULE__START_SEQ:
        return getStartSeq();
      case LDefPackage.PARTITION_MULTI_LINE_RULE__START_PATTERN:
        return getStartPattern();
      case LDefPackage.PARTITION_MULTI_LINE_RULE__START_SUFFIX:
        return getStartSuffix();
      case LDefPackage.PARTITION_MULTI_LINE_RULE__END_SEQ:
        return getEndSeq();
      case LDefPackage.PARTITION_MULTI_LINE_RULE__ESCAPE_SEQ:
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
      case LDefPackage.PARTITION_MULTI_LINE_RULE__START_SEQ:
        setStartSeq((String)newValue);
        return;
      case LDefPackage.PARTITION_MULTI_LINE_RULE__START_PATTERN:
        setStartPattern((String)newValue);
        return;
      case LDefPackage.PARTITION_MULTI_LINE_RULE__START_SUFFIX:
        setStartSuffix((String)newValue);
        return;
      case LDefPackage.PARTITION_MULTI_LINE_RULE__END_SEQ:
        setEndSeq((String)newValue);
        return;
      case LDefPackage.PARTITION_MULTI_LINE_RULE__ESCAPE_SEQ:
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
      case LDefPackage.PARTITION_MULTI_LINE_RULE__START_SEQ:
        setStartSeq(START_SEQ_EDEFAULT);
        return;
      case LDefPackage.PARTITION_MULTI_LINE_RULE__START_PATTERN:
        setStartPattern(START_PATTERN_EDEFAULT);
        return;
      case LDefPackage.PARTITION_MULTI_LINE_RULE__START_SUFFIX:
        setStartSuffix(START_SUFFIX_EDEFAULT);
        return;
      case LDefPackage.PARTITION_MULTI_LINE_RULE__END_SEQ:
        setEndSeq(END_SEQ_EDEFAULT);
        return;
      case LDefPackage.PARTITION_MULTI_LINE_RULE__ESCAPE_SEQ:
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
      case LDefPackage.PARTITION_MULTI_LINE_RULE__START_SEQ:
        return START_SEQ_EDEFAULT == null ? startSeq != null : !START_SEQ_EDEFAULT.equals(startSeq);
      case LDefPackage.PARTITION_MULTI_LINE_RULE__START_PATTERN:
        return START_PATTERN_EDEFAULT == null ? startPattern != null : !START_PATTERN_EDEFAULT.equals(startPattern);
      case LDefPackage.PARTITION_MULTI_LINE_RULE__START_SUFFIX:
        return START_SUFFIX_EDEFAULT == null ? startSuffix != null : !START_SUFFIX_EDEFAULT.equals(startSuffix);
      case LDefPackage.PARTITION_MULTI_LINE_RULE__END_SEQ:
        return END_SEQ_EDEFAULT == null ? endSeq != null : !END_SEQ_EDEFAULT.equals(endSeq);
      case LDefPackage.PARTITION_MULTI_LINE_RULE__ESCAPE_SEQ:
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
    result.append(", startPattern: ");
    result.append(startPattern);
    result.append(", startSuffix: ");
    result.append(startSuffix);
    result.append(", endSeq: ");
    result.append(endSeq);
    result.append(", escapeSeq: ");
    result.append(escapeSeq);
    result.append(')');
    return result.toString();
  }

} //Partition_MultiLineRuleImpl
