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

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.ScannerCondition;
import org.eclipse.fx.code.editor.ldef.lDef.Scanner_CharacterRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scanner Character Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_CharacterRuleImpl#getCharacters <em>Characters</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.Scanner_CharacterRuleImpl#getEnabledIf <em>Enabled If</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Scanner_CharacterRuleImpl extends Scanner_RuleImpl implements Scanner_CharacterRule
{
  /**
   * The cached value of the '{@link #getCharacters() <em>Characters</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCharacters()
   * @generated
   * @ordered
   */
  protected EList<String> characters;

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
  protected Scanner_CharacterRuleImpl()
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
    return LDefPackage.Literals.SCANNER_CHARACTER_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getCharacters()
  {
    if (characters == null)
    {
      characters = new EDataTypeEList<String>(String.class, this, LDefPackage.SCANNER_CHARACTER_RULE__CHARACTERS);
    }
    return characters;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_CHARACTER_RULE__ENABLED_IF, oldEnabledIf, newEnabledIf);
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
        msgs = ((InternalEObject)enabledIf).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.SCANNER_CHARACTER_RULE__ENABLED_IF, null, msgs);
      if (newEnabledIf != null)
        msgs = ((InternalEObject)newEnabledIf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.SCANNER_CHARACTER_RULE__ENABLED_IF, null, msgs);
      msgs = basicSetEnabledIf(newEnabledIf, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.SCANNER_CHARACTER_RULE__ENABLED_IF, newEnabledIf, newEnabledIf));
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
      case LDefPackage.SCANNER_CHARACTER_RULE__ENABLED_IF:
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
      case LDefPackage.SCANNER_CHARACTER_RULE__CHARACTERS:
        return getCharacters();
      case LDefPackage.SCANNER_CHARACTER_RULE__ENABLED_IF:
        return getEnabledIf();
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
      case LDefPackage.SCANNER_CHARACTER_RULE__CHARACTERS:
        getCharacters().clear();
        getCharacters().addAll((Collection<? extends String>)newValue);
        return;
      case LDefPackage.SCANNER_CHARACTER_RULE__ENABLED_IF:
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
      case LDefPackage.SCANNER_CHARACTER_RULE__CHARACTERS:
        getCharacters().clear();
        return;
      case LDefPackage.SCANNER_CHARACTER_RULE__ENABLED_IF:
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
      case LDefPackage.SCANNER_CHARACTER_RULE__CHARACTERS:
        return characters != null && !characters.isEmpty();
      case LDefPackage.SCANNER_CHARACTER_RULE__ENABLED_IF:
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
    result.append(" (characters: ");
    result.append(characters);
    result.append(')');
    return result.toString();
  }

} //Scanner_CharacterRuleImpl
