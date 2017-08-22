/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Range#getLtIncl <em>Lt Incl</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Range#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Range#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Range#getGtIncl <em>Gt Incl</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getRange()
 * @model
 * @generated
 */
public interface Range extends Check
{
  /**
   * Returns the value of the '<em><b>Lt Incl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lt Incl</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lt Incl</em>' attribute.
   * @see #setLtIncl(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getRange_LtIncl()
   * @model
   * @generated
   */
  String getLtIncl();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Range#getLtIncl <em>Lt Incl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lt Incl</em>' attribute.
   * @see #getLtIncl()
   * @generated
   */
  void setLtIncl(String value);

  /**
   * Returns the value of the '<em><b>Min Value</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Min Value</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Min Value</em>' attribute list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getRange_MinValue()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getMinValue();

  /**
   * Returns the value of the '<em><b>Max Value</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Value</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Value</em>' attribute list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getRange_MaxValue()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getMaxValue();

  /**
   * Returns the value of the '<em><b>Gt Incl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Gt Incl</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gt Incl</em>' attribute.
   * @see #setGtIncl(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getRange_GtIncl()
   * @model
   * @generated
   */
  String getGtIncl();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Range#getGtIncl <em>Gt Incl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Gt Incl</em>' attribute.
   * @see #getGtIncl()
   * @generated
   */
  void setGtIncl(String value);

} // Range
