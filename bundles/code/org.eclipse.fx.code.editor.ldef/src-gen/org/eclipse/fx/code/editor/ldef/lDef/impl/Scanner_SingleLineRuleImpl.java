/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.ScannerCondition;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_SingleLineRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scanner Single Line Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_SingleLineRuleImpl#getStartSeq <em>Start Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_SingleLineRuleImpl#getStartPattern <em>Start Pattern</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_SingleLineRuleImpl#getEndSeq <em>End Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_SingleLineRuleImpl#getEscapeSeq <em>Escape Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_SingleLineRuleImpl#getEnabledIf <em>Enabled If</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Scanner_SingleLineRuleImpl extends Scanner_RuleImpl implements Scanner_SingleLineRule
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
  protected Scanner_SingleLineRuleImpl()
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
    return LDefPackage.Literals.SCANNER_SINGLE_LINE_RULE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_SINGLE_LINE_RULE__START_SEQ, oldStartSeq, startSeq));
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
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_SINGLE_LINE_RULE__START_PATTERN, oldStartPattern, startPattern));
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
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_SINGLE_LINE_RULE__END_SEQ, oldEndSeq, endSeq));
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
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ, oldEscapeSeq, escapeSeq));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_SINGLE_LINE_RULE__ENABLED_IF, oldEnabledIf, newEnabledIf);
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
        msgs = ((InternalEObject)enabledIf).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.SCANNER_SINGLE_LINE_RULE__ENABLED_IF, null, msgs);
      if (newEnabledIf != null)
        msgs = ((InternalEObject)newEnabledIf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.SCANNER_SINGLE_LINE_RULE__ENABLED_IF, null, msgs);
      msgs = basicSetEnabledIf(newEnabledIf, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_SINGLE_LINE_RULE__ENABLED_IF, newEnabledIf, newEnabledIf));
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
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__ENABLED_IF:
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
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__START_SEQ:
        return getStartSeq();
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__START_PATTERN:
        return getStartPattern();
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__END_SEQ:
        return getEndSeq();
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ:
        return getEscapeSeq();
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__ENABLED_IF:
        return getEnabledIf();
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
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__START_SEQ:
        setStartSeq((String)newValue);
        return;
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__START_PATTERN:
        setStartPattern((String)newValue);
        return;
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__END_SEQ:
        setEndSeq((String)newValue);
        return;
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ:
        setEscapeSeq((String)newValue);
        return;
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__ENABLED_IF:
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
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__START_SEQ:
        setStartSeq(START_SEQ_EDEFAULT);
        return;
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__START_PATTERN:
        setStartPattern(START_PATTERN_EDEFAULT);
        return;
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__END_SEQ:
        setEndSeq(END_SEQ_EDEFAULT);
        return;
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ:
        setEscapeSeq(ESCAPE_SEQ_EDEFAULT);
        return;
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__ENABLED_IF:
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
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__START_SEQ:
        return START_SEQ_EDEFAULT == null ? startSeq != null : !START_SEQ_EDEFAULT.equals(startSeq);
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__START_PATTERN:
        return START_PATTERN_EDEFAULT == null ? startPattern != null : !START_PATTERN_EDEFAULT.equals(startPattern);
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__END_SEQ:
        return END_SEQ_EDEFAULT == null ? endSeq != null : !END_SEQ_EDEFAULT.equals(endSeq);
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__ESCAPE_SEQ:
        return ESCAPE_SEQ_EDEFAULT == null ? escapeSeq != null : !ESCAPE_SEQ_EDEFAULT.equals(escapeSeq);
      case LDefPackage.SCANNER_SINGLE_LINE_RULE__ENABLED_IF:
        return enabledIf != null;
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
    result.append(", endSeq: ");
    result.append(endSeq);
    result.append(", escapeSeq: ");
    result.append(escapeSeq);
    result.append(')');
    return result.toString();
  }

} //Scanner_SingleLineRuleImpl
