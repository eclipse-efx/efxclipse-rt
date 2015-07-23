/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Whitespace Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule#getCharacters <em>Characters</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule#isJavawhitespace <em>Javawhitespace</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule#getFileURI <em>File URI</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getWhitespaceRule()
 * @model
 * @generated
 */
public interface WhitespaceRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Characters</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Characters</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Characters</em>' attribute list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getWhitespaceRule_Characters()
   * @model unique="false"
   * @generated
   */
  EList<String> getCharacters();

  /**
   * Returns the value of the '<em><b>Javawhitespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Javawhitespace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Javawhitespace</em>' attribute.
   * @see #setJavawhitespace(boolean)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getWhitespaceRule_Javawhitespace()
   * @model
   * @generated
   */
  boolean isJavawhitespace();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule#isJavawhitespace <em>Javawhitespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Javawhitespace</em>' attribute.
   * @see #isJavawhitespace()
   * @generated
   */
  void setJavawhitespace(boolean value);

  /**
   * Returns the value of the '<em><b>File URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File URI</em>' attribute.
   * @see #setFileURI(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getWhitespaceRule_FileURI()
   * @model
   * @generated
   */
  String getFileURI();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.WhitespaceRule#getFileURI <em>File URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File URI</em>' attribute.
   * @see #getFileURI()
   * @generated
   */
  void setFileURI(String value);

} // WhitespaceRule
