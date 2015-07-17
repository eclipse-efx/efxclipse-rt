/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lexical Partition Highlighting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting#getPartition <em>Partition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getLexicalPartitionHighlighting()
 * @model
 * @generated
 */
public interface LexicalPartitionHighlighting extends EObject
{
  /**
   * Returns the value of the '<em><b>Partition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Partition</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Partition</em>' reference.
   * @see #setPartition(Partition)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getLexicalPartitionHighlighting_Partition()
   * @model
   * @generated
   */
  Partition getPartition();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting#getPartition <em>Partition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Partition</em>' reference.
   * @see #getPartition()
   * @generated
   */
  void setPartition(Partition value);

} // LexicalPartitionHighlighting
