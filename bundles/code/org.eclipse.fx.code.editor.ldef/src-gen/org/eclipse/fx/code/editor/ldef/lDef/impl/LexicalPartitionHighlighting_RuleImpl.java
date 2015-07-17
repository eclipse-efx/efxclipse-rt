/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule;
import org.eclipse.fx.code.editor.ldef.lDef.Token;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lexical Partition Highlighting Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlighting_RuleImpl#getTokenList <em>Token List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LexicalPartitionHighlighting_RuleImpl extends LexicalPartitionHighlightingImpl implements LexicalPartitionHighlighting_Rule
{
  /**
   * The cached value of the '{@link #getTokenList() <em>Token List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTokenList()
   * @generated
   * @ordered
   */
  protected EList<Token> tokenList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LexicalPartitionHighlighting_RuleImpl()
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
    return LDefPackage.Literals.LEXICAL_PARTITION_HIGHLIGHTING_RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Token> getTokenList()
  {
    if (tokenList == null)
    {
      tokenList = new EObjectContainmentEList<Token>(Token.class, this, LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_RULE__TOKEN_LIST);
    }
    return tokenList;
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
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_RULE__TOKEN_LIST:
        return ((InternalEList<?>)getTokenList()).basicRemove(otherEnd, msgs);
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
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_RULE__TOKEN_LIST:
        return getTokenList();
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
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_RULE__TOKEN_LIST:
        getTokenList().clear();
        getTokenList().addAll((Collection<? extends Token>)newValue);
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
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_RULE__TOKEN_LIST:
        getTokenList().clear();
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
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_RULE__TOKEN_LIST:
        return tokenList != null && !tokenList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //LexicalPartitionHighlighting_RuleImpl
