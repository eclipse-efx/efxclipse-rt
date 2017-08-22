/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.ConfigValue#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.ConfigValue#getSimpleValue <em>Simple Value</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.ConfigValue#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getConfigValue()
 * @model
 * @generated
 */
public interface ConfigValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' attribute.
   * @see #setKey(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getConfigValue_Key()
   * @model
   * @generated
   */
  String getKey();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.ConfigValue#getKey <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key</em>' attribute.
   * @see #getKey()
   * @generated
   */
  void setKey(String value);

  /**
   * Returns the value of the '<em><b>Simple Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simple Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simple Value</em>' attribute.
   * @see #setSimpleValue(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getConfigValue_SimpleValue()
   * @model
   * @generated
   */
  String getSimpleValue();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.ConfigValue#getSimpleValue <em>Simple Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Simple Value</em>' attribute.
   * @see #getSimpleValue()
   * @generated
   */
  void setSimpleValue(String value);

  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.editor.ldef.lDef.ConfigValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Children</em>' containment reference list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getConfigValue_Children()
   * @model containment="true"
   * @generated
   */
  EList<ConfigValue> getChildren();

} // ConfigValue
