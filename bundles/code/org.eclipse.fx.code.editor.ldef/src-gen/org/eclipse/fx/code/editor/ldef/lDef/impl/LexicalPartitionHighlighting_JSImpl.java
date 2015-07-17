/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_JS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lexical Partition Highlighting JS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.LexicalPartitionHighlighting_JSImpl#getScriptURI <em>Script URI</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LexicalPartitionHighlighting_JSImpl extends LexicalPartitionHighlightingImpl implements LexicalPartitionHighlighting_JS
{
  /**
   * The default value of the '{@link #getScriptURI() <em>Script URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScriptURI()
   * @generated
   * @ordered
   */
  protected static final String SCRIPT_URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getScriptURI() <em>Script URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScriptURI()
   * @generated
   * @ordered
   */
  protected String scriptURI = SCRIPT_URI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LexicalPartitionHighlighting_JSImpl()
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
    return LDefPackage.Literals.LEXICAL_PARTITION_HIGHLIGHTING_JS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getScriptURI()
  {
    return scriptURI;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScriptURI(String newScriptURI)
  {
    String oldScriptURI = scriptURI;
    scriptURI = newScriptURI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_JS__SCRIPT_URI, oldScriptURI, scriptURI));
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
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_JS__SCRIPT_URI:
        return getScriptURI();
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
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_JS__SCRIPT_URI:
        setScriptURI((String)newValue);
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
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_JS__SCRIPT_URI:
        setScriptURI(SCRIPT_URI_EDEFAULT);
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
      case LDefPackage.LEXICAL_PARTITION_HIGHLIGHTING_JS__SCRIPT_URI:
        return SCRIPT_URI_EDEFAULT == null ? scriptURI != null : !SCRIPT_URI_EDEFAULT.equals(scriptURI);
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
    result.append(" (scriptURI: ");
    result.append(scriptURI);
    result.append(')');
    return result.toString();
  }

} //LexicalPartitionHighlighting_JSImpl
