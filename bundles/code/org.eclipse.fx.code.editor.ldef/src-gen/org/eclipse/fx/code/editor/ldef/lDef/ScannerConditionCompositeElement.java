/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scanner Condition Composite Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionCompositeElement#getOp <em>Op</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionCompositeElement#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScannerConditionCompositeElement()
 * @model
 * @generated
 */
public interface ScannerConditionCompositeElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScannerConditionCompositeElement_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionCompositeElement#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(ScannerCondition)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScannerConditionCompositeElement_Condition()
   * @model containment="true"
   * @generated
   */
  ScannerCondition getCondition();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionCompositeElement#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(ScannerCondition value);

} // ScannerConditionCompositeElement
