/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partition Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getParition <em>Parition</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getCheck <em>Check</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getPartition_Rule()
 * @model
 * @generated
 */
public interface Partition_Rule extends EObject
{
  /**
   * Returns the value of the '<em><b>Parition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parition</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parition</em>' reference.
   * @see #setParition(Partition)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getPartition_Rule_Parition()
   * @model
   * @generated
   */
  Partition getParition();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getParition <em>Parition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parition</em>' reference.
   * @see #getParition()
   * @generated
   */
  void setParition(Partition value);

  /**
   * Returns the value of the '<em><b>Check</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Check</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Check</em>' containment reference.
   * @see #setCheck(Check)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getPartition_Rule_Check()
   * @model containment="true"
   * @generated
   */
  Check getCheck();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getCheck <em>Check</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Check</em>' containment reference.
   * @see #getCheck()
   * @generated
   */
  void setCheck(Check value);

} // Partition_Rule
