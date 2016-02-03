/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lexical Highlighting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting#getList <em>List</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting#getVistual <em>Vistual</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getLexicalHighlighting()
 * @model
 * @generated
 */
public interface LexicalHighlighting extends EObject
{
  /**
   * Returns the value of the '<em><b>List</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getLexicalHighlighting_List()
   * @model containment="true"
   * @generated
   */
  EList<LexicalPartitionHighlighting> getList();

  /**
   * Returns the value of the '<em><b>Vistual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vistual</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vistual</em>' containment reference.
   * @see #setVistual(TokenVisuals)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getLexicalHighlighting_Vistual()
   * @model containment="true"
   * @generated
   */
  TokenVisuals getVistual();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalHighlighting#getVistual <em>Vistual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vistual</em>' containment reference.
   * @see #getVistual()
   * @generated
   */
  void setVistual(TokenVisuals value);

} // LexicalHighlighting
