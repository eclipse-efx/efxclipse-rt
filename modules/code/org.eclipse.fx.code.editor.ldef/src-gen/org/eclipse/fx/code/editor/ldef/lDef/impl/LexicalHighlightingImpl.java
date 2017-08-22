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
import org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting;
import org.eclipse.fx.code.editor.ldef.lDef.TokenVisuals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lexical Highlighting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalHighlightingImpl#getList <em>List</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalHighlightingImpl#getVistual <em>Vistual</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LexicalHighlightingImpl extends MinimalEObjectImpl.Container implements LexicalHighlighting
{
  /**
   * The cached value of the '{@link #getList() <em>List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getList()
   * @generated
   * @ordered
   */
  protected EList<LexicalPartitionHighlighting> list;

  /**
   * The cached value of the '{@link #getVistual() <em>Vistual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVistual()
   * @generated
   * @ordered
   */
  protected TokenVisuals vistual;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LexicalHighlightingImpl()
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
    return LDefPackage.Literals.LEXICAL_HIGHLIGHTING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LexicalPartitionHighlighting> getList()
  {
    if (list == null)
    {
      list = new EObjectContainmentEList<LexicalPartitionHighlighting>(LexicalPartitionHighlighting.class, this, LDefPackage.LEXICAL_HIGHLIGHTING__LIST);
    }
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TokenVisuals getVistual()
  {
    return vistual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVistual(TokenVisuals newVistual, NotificationChain msgs)
  {
    TokenVisuals oldVistual = vistual;
    vistual = newVistual;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LDefPackage.LEXICAL_HIGHLIGHTING__VISTUAL, oldVistual, newVistual);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVistual(TokenVisuals newVistual)
  {
    if (newVistual != vistual)
    {
      NotificationChain msgs = null;
      if (vistual != null)
        msgs = ((InternalEObject)vistual).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LDefPackage.LEXICAL_HIGHLIGHTING__VISTUAL, null, msgs);
      if (newVistual != null)
        msgs = ((InternalEObject)newVistual).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LDefPackage.LEXICAL_HIGHLIGHTING__VISTUAL, null, msgs);
      msgs = basicSetVistual(newVistual, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.LEXICAL_HIGHLIGHTING__VISTUAL, newVistual, newVistual));
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
      case LDefPackage.LEXICAL_HIGHLIGHTING__LIST:
        return ((InternalEList<?>)getList()).basicRemove(otherEnd, msgs);
      case LDefPackage.LEXICAL_HIGHLIGHTING__VISTUAL:
        return basicSetVistual(null, msgs);
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
      case LDefPackage.LEXICAL_HIGHLIGHTING__LIST:
        return getList();
      case LDefPackage.LEXICAL_HIGHLIGHTING__VISTUAL:
        return getVistual();
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
      case LDefPackage.LEXICAL_HIGHLIGHTING__LIST:
        getList().clear();
        getList().addAll((Collection<? extends LexicalPartitionHighlighting>)newValue);
        return;
      case LDefPackage.LEXICAL_HIGHLIGHTING__VISTUAL:
        setVistual((TokenVisuals)newValue);
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
      case LDefPackage.LEXICAL_HIGHLIGHTING__LIST:
        getList().clear();
        return;
      case LDefPackage.LEXICAL_HIGHLIGHTING__VISTUAL:
        setVistual((TokenVisuals)null);
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
      case LDefPackage.LEXICAL_HIGHLIGHTING__LIST:
        return list != null && !list.isEmpty();
      case LDefPackage.LEXICAL_HIGHLIGHTING__VISTUAL:
        return vistual != null;
    }
    return super.eIsSet(featureID);
  }

} //LexicalHighlightingImpl
