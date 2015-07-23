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
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule#getWhitespace <em>Whitespace</em>}</li>
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
   * Returns the value of the '<em><b>Whitespace</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Whitespace</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Whitespace</em>' containment reference.
   * @see #setWhitespace(WhitespaceRule)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getLexicalPartitionHighlighting_Rule_Whitespace()
   * @model containment="true"
   * @generated
   */
  WhitespaceRule getWhitespace();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.LexicalPartitionHighlighting_Rule#getWhitespace <em>Whitespace</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Whitespace</em>' containment reference.
   * @see #getWhitespace()
   * @generated
   */
  void setWhitespace(WhitespaceRule value);

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
