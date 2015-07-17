/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.fx.code.editor.ldef.lDef.LDef;
import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.Paritioning;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>LDef</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LDefImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LDefImpl#getParitioning <em>Paritioning</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LDefImpl#getLexicalHighlighting <em>Lexical Highlighting</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LDefImpl extends MinimalEObjectImpl.Container implements LDef
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LDefImpl()
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
    return LDefPackage.Literals.LDEF;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.LDEF__NAME, oldName, name));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.LDEF__PARITIONING, oldParitioning, newParitioning);
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
        msgs = ((InternalEObject)paritioning).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.LDEF__PARITIONING, null, msgs);
      if (newParitioning != null)
        msgs = ((InternalEObject)newParitioning).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.LDEF__PARITIONING, null, msgs);
      msgs = basicSetParitioning(newParitioning, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.LDEF__PARITIONING, newParitioning, newParitioning));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.LDEF__LEXICAL_HIGHLIGHTING, oldLexicalHighlighting, newLexicalHighlighting);
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
        msgs = ((InternalEObject)lexicalHighlighting).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.LDEF__LEXICAL_HIGHLIGHTING, null, msgs);
      if (newLexicalHighlighting != null)
        msgs = ((InternalEObject)newLexicalHighlighting).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.LDEF__LEXICAL_HIGHLIGHTING, null, msgs);
      msgs = basicSetLexicalHighlighting(newLexicalHighlighting, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.LDEF__LEXICAL_HIGHLIGHTING, newLexicalHighlighting, newLexicalHighlighting));
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
      case LDefPackage.LDEF__PARITIONING:
        return basicSetParitioning(null, msgs);
      case LDefPackage.LDEF__LEXICAL_HIGHLIGHTING:
        return basicSetLexicalHighlighting(null, msgs);
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
      case LDefPackage.LDEF__NAME:
        return getName();
      case LDefPackage.LDEF__PARITIONING:
        return getParitioning();
      case LDefPackage.LDEF__LEXICAL_HIGHLIGHTING:
        return getLexicalHighlighting();
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
      case LDefPackage.LDEF__NAME:
        setName((String)newValue);
        return;
      case LDefPackage.LDEF__PARITIONING:
        setParitioning((Paritioning)newValue);
        return;
      case LDefPackage.LDEF__LEXICAL_HIGHLIGHTING:
        setLexicalHighlighting((LexicalHighlighting)newValue);
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
      case LDefPackage.LDEF__NAME:
        setName(NAME_EDEFAULT);
        return;
      case LDefPackage.LDEF__PARITIONING:
        setParitioning((Paritioning)null);
        return;
      case LDefPackage.LDEF__LEXICAL_HIGHLIGHTING:
        setLexicalHighlighting((LexicalHighlighting)null);
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
      case LDefPackage.LDEF__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case LDefPackage.LDEF__PARITIONING:
        return paritioning != null;
      case LDefPackage.LDEF__LEXICAL_HIGHLIGHTING:
        return lexicalHighlighting != null;
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

} //LDefImpl
