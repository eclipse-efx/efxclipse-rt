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
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_PatternRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scanner Pattern Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_PatternRuleImpl#getStartPattern <em>Start Pattern</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_PatternRuleImpl#getLength <em>Length</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_PatternRuleImpl#getContentPattern <em>Content Pattern</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_PatternRuleImpl#getEnabledIf <em>Enabled If</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Scanner_PatternRuleImpl extends Scanner_RuleImpl implements Scanner_PatternRule
{
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
   * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  protected static final int LENGTH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLength()
   * @generated
   * @ordered
   */
  protected int length = LENGTH_EDEFAULT;

  /**
   * The default value of the '{@link #getContentPattern() <em>Content Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContentPattern()
   * @generated
   * @ordered
   */
  protected static final String CONTENT_PATTERN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getContentPattern() <em>Content Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContentPattern()
   * @generated
   * @ordered
   */
  protected String contentPattern = CONTENT_PATTERN_EDEFAULT;

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
  protected Scanner_PatternRuleImpl()
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
    return LDefPackage.Literals.SCANNER_PATTERN_RULE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_PATTERN_RULE__START_PATTERN, oldStartPattern, startPattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLength()
  {
    return length;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLength(int newLength)
  {
    int oldLength = length;
    length = newLength;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_PATTERN_RULE__LENGTH, oldLength, length));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getContentPattern()
  {
    return contentPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContentPattern(String newContentPattern)
  {
    String oldContentPattern = contentPattern;
    contentPattern = newContentPattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_PATTERN_RULE__CONTENT_PATTERN, oldContentPattern, contentPattern));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_PATTERN_RULE__ENABLED_IF, oldEnabledIf, newEnabledIf);
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
        msgs = ((InternalEObject)enabledIf).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.SCANNER_PATTERN_RULE__ENABLED_IF, null, msgs);
      if (newEnabledIf != null)
        msgs = ((InternalEObject)newEnabledIf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.SCANNER_PATTERN_RULE__ENABLED_IF, null, msgs);
      msgs = basicSetEnabledIf(newEnabledIf, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_PATTERN_RULE__ENABLED_IF, newEnabledIf, newEnabledIf));
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
      case LDefPackage.SCANNER_PATTERN_RULE__ENABLED_IF:
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
      case LDefPackage.SCANNER_PATTERN_RULE__START_PATTERN:
        return getStartPattern();
      case LDefPackage.SCANNER_PATTERN_RULE__LENGTH:
        return getLength();
      case LDefPackage.SCANNER_PATTERN_RULE__CONTENT_PATTERN:
        return getContentPattern();
      case LDefPackage.SCANNER_PATTERN_RULE__ENABLED_IF:
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
      case LDefPackage.SCANNER_PATTERN_RULE__START_PATTERN:
        setStartPattern((String)newValue);
        return;
      case LDefPackage.SCANNER_PATTERN_RULE__LENGTH:
        setLength((Integer)newValue);
        return;
      case LDefPackage.SCANNER_PATTERN_RULE__CONTENT_PATTERN:
        setContentPattern((String)newValue);
        return;
      case LDefPackage.SCANNER_PATTERN_RULE__ENABLED_IF:
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
      case LDefPackage.SCANNER_PATTERN_RULE__START_PATTERN:
        setStartPattern(START_PATTERN_EDEFAULT);
        return;
      case LDefPackage.SCANNER_PATTERN_RULE__LENGTH:
        setLength(LENGTH_EDEFAULT);
        return;
      case LDefPackage.SCANNER_PATTERN_RULE__CONTENT_PATTERN:
        setContentPattern(CONTENT_PATTERN_EDEFAULT);
        return;
      case LDefPackage.SCANNER_PATTERN_RULE__ENABLED_IF:
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
      case LDefPackage.SCANNER_PATTERN_RULE__START_PATTERN:
        return START_PATTERN_EDEFAULT == null ? startPattern != null : !START_PATTERN_EDEFAULT.equals(startPattern);
      case LDefPackage.SCANNER_PATTERN_RULE__LENGTH:
        return length != LENGTH_EDEFAULT;
      case LDefPackage.SCANNER_PATTERN_RULE__CONTENT_PATTERN:
        return CONTENT_PATTERN_EDEFAULT == null ? contentPattern != null : !CONTENT_PATTERN_EDEFAULT.equals(contentPattern);
      case LDefPackage.SCANNER_PATTERN_RULE__ENABLED_IF:
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
    result.append(" (startPattern: ");
    result.append(startPattern);
    result.append(", length: ");
    result.append(length);
    result.append(", contentPattern: ");
    result.append(contentPattern);
    result.append(')');
    return result.toString();
  }

} //Scanner_PatternRuleImpl
