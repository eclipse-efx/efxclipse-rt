/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.fx.code.editor.ldef.lDef.Integration;
import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.LanguageDef;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.Paritioning;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LanguageDefImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LanguageDefImpl#getParitioning <em>Paritioning</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LanguageDefImpl#getLexicalHighlighting <em>Lexical Highlighting</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LanguageDefImpl#getIntegration <em>Integration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LanguageDefImpl extends MinimalEObjectImpl.Container implements LanguageDef
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
   * The cached value of the '{@link #getParitioning() <em>Paritioning</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParitioning()
   * @generated
   * @ordered
   */
  protected Paritioning paritioning;

  /**
   * The cached value of the '{@link #getLexicalHighlighting() <em>Lexical Highlighting</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLexicalHighlighting()
   * @generated
   * @ordered
   */
  protected LexicalHighlighting lexicalHighlighting;

  /**
   * The cached value of the '{@link #getIntegration() <em>Integration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntegration()
   * @generated
   * @ordered
   */
  protected Integration integration;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LanguageDefImpl()
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
    return LDefPackage.Literals.LANGUAGE_DEF;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.LANGUAGE_DEF__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Paritioning getParitioning()
  {
    return paritioning;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParitioning(Paritioning newParitioning, NotificationChain msgs)
  {
    Paritioning oldParitioning = paritioning;
    paritioning = newParitioning;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.LANGUAGE_DEF__PARITIONING, oldParitioning, newParitioning);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParitioning(Paritioning newParitioning)
  {
    if (newParitioning != paritioning)
    {
      NotificationChain msgs = null;
      if (paritioning != null)
        msgs = ((InternalEObject)paritioning).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.LANGUAGE_DEF__PARITIONING, null, msgs);
      if (newParitioning != null)
        msgs = ((InternalEObject)newParitioning).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.LANGUAGE_DEF__PARITIONING, null, msgs);
      msgs = basicSetParitioning(newParitioning, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.LANGUAGE_DEF__PARITIONING, newParitioning, newParitioning));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LexicalHighlighting getLexicalHighlighting()
  {
    return lexicalHighlighting;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLexicalHighlighting(LexicalHighlighting newLexicalHighlighting, NotificationChain msgs)
  {
    LexicalHighlighting oldLexicalHighlighting = lexicalHighlighting;
    lexicalHighlighting = newLexicalHighlighting;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.LANGUAGE_DEF__LEXICAL_HIGHLIGHTING, oldLexicalHighlighting, newLexicalHighlighting);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLexicalHighlighting(LexicalHighlighting newLexicalHighlighting)
  {
    if (newLexicalHighlighting != lexicalHighlighting)
    {
      NotificationChain msgs = null;
      if (lexicalHighlighting != null)
        msgs = ((InternalEObject)lexicalHighlighting).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.LANGUAGE_DEF__LEXICAL_HIGHLIGHTING, null, msgs);
      if (newLexicalHighlighting != null)
        msgs = ((InternalEObject)newLexicalHighlighting).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.LANGUAGE_DEF__LEXICAL_HIGHLIGHTING, null, msgs);
      msgs = basicSetLexicalHighlighting(newLexicalHighlighting, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.LANGUAGE_DEF__LEXICAL_HIGHLIGHTING, newLexicalHighlighting, newLexicalHighlighting));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Integration getIntegration()
  {
    return integration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIntegration(Integration newIntegration, NotificationChain msgs)
  {
    Integration oldIntegration = integration;
    integration = newIntegration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.LANGUAGE_DEF__INTEGRATION, oldIntegration, newIntegration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntegration(Integration newIntegration)
  {
    if (newIntegration != integration)
    {
      NotificationChain msgs = null;
      if (integration != null)
        msgs = ((InternalEObject)integration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.LANGUAGE_DEF__INTEGRATION, null, msgs);
      if (newIntegration != null)
        msgs = ((InternalEObject)newIntegration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.LANGUAGE_DEF__INTEGRATION, null, msgs);
      msgs = basicSetIntegration(newIntegration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.LANGUAGE_DEF__INTEGRATION, newIntegration, newIntegration));
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
      case LDefPackage.LANGUAGE_DEF__PARITIONING:
        return basicSetParitioning(null, msgs);
      case LDefPackage.LANGUAGE_DEF__LEXICAL_HIGHLIGHTING:
        return basicSetLexicalHighlighting(null, msgs);
      case LDefPackage.LANGUAGE_DEF__INTEGRATION:
        return basicSetIntegration(null, msgs);
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
      case LDefPackage.LANGUAGE_DEF__NAME:
        return getName();
      case LDefPackage.LANGUAGE_DEF__PARITIONING:
        return getParitioning();
      case LDefPackage.LANGUAGE_DEF__LEXICAL_HIGHLIGHTING:
        return getLexicalHighlighting();
      case LDefPackage.LANGUAGE_DEF__INTEGRATION:
        return getIntegration();
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
      case LDefPackage.LANGUAGE_DEF__NAME:
        setName((String)newValue);
        return;
      case LDefPackage.LANGUAGE_DEF__PARITIONING:
        setParitioning((Paritioning)newValue);
        return;
      case LDefPackage.LANGUAGE_DEF__LEXICAL_HIGHLIGHTING:
        setLexicalHighlighting((LexicalHighlighting)newValue);
        return;
      case LDefPackage.LANGUAGE_DEF__INTEGRATION:
        setIntegration((Integration)newValue);
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
      case LDefPackage.LANGUAGE_DEF__NAME:
        setName(NAME_EDEFAULT);
        return;
      case LDefPackage.LANGUAGE_DEF__PARITIONING:
        setParitioning((Paritioning)null);
        return;
      case LDefPackage.LANGUAGE_DEF__LEXICAL_HIGHLIGHTING:
        setLexicalHighlighting((LexicalHighlighting)null);
        return;
      case LDefPackage.LANGUAGE_DEF__INTEGRATION:
        setIntegration((Integration)null);
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
      case LDefPackage.LANGUAGE_DEF__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case LDefPackage.LANGUAGE_DEF__PARITIONING:
        return paritioning != null;
      case LDefPackage.LANGUAGE_DEF__LEXICAL_HIGHLIGHTING:
        return lexicalHighlighting != null;
      case LDefPackage.LANGUAGE_DEF__INTEGRATION:
        return integration != null;
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

} //LanguageDefImpl
