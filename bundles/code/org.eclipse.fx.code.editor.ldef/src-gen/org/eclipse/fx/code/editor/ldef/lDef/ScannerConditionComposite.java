/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scanner Condition Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionComposite#getPrim <em>Prim</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionComposite#getSecondary <em>Secondary</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScannerConditionComposite()
 * @model
 * @generated
 */
public interface ScannerConditionComposite extends ScannerCondition
{
  /**
   * Returns the value of the '<em><b>Prim</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prim</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prim</em>' containment reference.
   * @see #setPrim(ScannerConditionExits)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScannerConditionComposite_Prim()
   * @model containment="true"
   * @generated
   */
  ScannerConditionExits getPrim();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionComposite#getPrim <em>Prim</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prim</em>' containment reference.
   * @see #getPrim()
   * @generated
   */
  void setPrim(ScannerConditionExits value);

  /**
   * Returns the value of the '<em><b>Secondary</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.editor.ldef.lDef.ScannerConditionCompositeElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Secondary</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Secondary</em>' containment reference list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScannerConditionComposite_Secondary()
   * @model containment="true"
   * @generated
   */
  EList<ScannerConditionCompositeElement> getSecondary();

} // ScannerConditionComposite
