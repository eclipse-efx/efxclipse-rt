/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.TokenVisual;
import org.eclipse.fx.code.editor.ldef.lDef.TokenVisuals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token Visuals</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.TokenVisualsImpl#getTokenVisuals <em>Token Visuals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TokenVisualsImpl extends MinimalEObjectImpl.Container implements TokenVisuals
{
  /**
   * The cached value of the '{@link #getTokenVisuals() <em>Token Visuals</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTokenVisuals()
   * @generated
   * @ordered
   */
  protected EList<TokenVisual> tokenVisuals;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TokenVisualsImpl()
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
    return LDefPackage.Literals.TOKEN_VISUALS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TokenVisual> getTokenVisuals()
  {
    if (tokenVisuals == null)
    {
      tokenVisuals = new EObjectContainmentEList<TokenVisual>(TokenVisual.class, this, LDefPackage.TOKEN_VISUALS__TOKEN_VISUALS);
    }
    return tokenVisuals;
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
      case LDefPackage.TOKEN_VISUALS__TOKEN_VISUALS:
        return ((InternalEList<?>)getTokenVisuals()).basicRemove(otherEnd, msgs);
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
      case LDefPackage.TOKEN_VISUALS__TOKEN_VISUALS:
        return getTokenVisuals();
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
      case LDefPackage.TOKEN_VISUALS__TOKEN_VISUALS:
        getTokenVisuals().clear();
        getTokenVisuals().addAll((Collection<? extends TokenVisual>)newValue);
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
      case LDefPackage.TOKEN_VISUALS__TOKEN_VISUALS:
        getTokenVisuals().clear();
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
      case LDefPackage.TOKEN_VISUALS__TOKEN_VISUALS:
        return tokenVisuals != null && !tokenVisuals.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TokenVisualsImpl
