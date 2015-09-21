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
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getStartSeq <em>Start Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getCheck <em>Check</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getEndSeq <em>End Seq</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getEscapeSeq <em>Escape Seq</em>}</li>
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
   * Returns the value of the '<em><b>Start Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Seq</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Seq</em>' attribute.
   * @see #setStartSeq(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getPartition_Rule_StartSeq()
   * @model
   * @generated
   */
  String getStartSeq();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getStartSeq <em>Start Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Seq</em>' attribute.
   * @see #getStartSeq()
   * @generated
   */
  void setStartSeq(String value);

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

  /**
   * Returns the value of the '<em><b>End Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End Seq</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End Seq</em>' attribute.
   * @see #setEndSeq(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getPartition_Rule_EndSeq()
   * @model
   * @generated
   */
  String getEndSeq();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getEndSeq <em>End Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End Seq</em>' attribute.
   * @see #getEndSeq()
   * @generated
   */
  void setEndSeq(String value);

  /**
   * Returns the value of the '<em><b>Escape Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Escape Seq</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Escape Seq</em>' attribute.
   * @see #setEscapeSeq(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getPartition_Rule_EscapeSeq()
   * @model
   * @generated
   */
  String getEscapeSeq();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule#getEscapeSeq <em>Escape Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Escape Seq</em>' attribute.
   * @see #getEscapeSeq()
   * @generated
   */
  void setEscapeSeq(String value);

} // Partition_Rule
