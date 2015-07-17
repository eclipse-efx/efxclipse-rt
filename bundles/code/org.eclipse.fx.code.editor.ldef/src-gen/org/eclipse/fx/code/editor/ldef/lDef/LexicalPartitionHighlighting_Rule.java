/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lexical Partition Highlighting Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule#getTokenList <em>Token List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getLexicalPartitionHighlighting_Rule()
 * @model
 * @generated
 */
public interface LexicalPartitionHighlighting_Rule extends LexicalPartitionHighlighting
{
  /**
   * Returns the value of the '<em><b>Token List</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.editor.ldef.lDef.Token}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Token List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Token List</em>' containment reference list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getLexicalPartitionHighlighting_Rule_TokenList()
   * @model containment="true"
   * @generated
   */
  EList<Token> getTokenList();

} // LexicalPartitionHighlighting_Rule
