/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token Visual</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.TokenVisual#getToken <em>Token</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.TokenVisual#getColorSpec <em>Color Spec</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.TokenVisual#isBold <em>Bold</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.TokenVisual#isItalic <em>Italic</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getTokenVisual()
 * @model
 * @generated
 */
public interface TokenVisual extends EObject
{
  /**
   * Returns the value of the '<em><b>Token</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Token</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Token</em>' reference.
   * @see #setToken(Token)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getTokenVisual_Token()
   * @model
   * @generated
   */
  Token getToken();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.TokenVisual#getToken <em>Token</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Token</em>' reference.
   * @see #getToken()
   * @generated
   */
  void setToken(Token value);

  /**
   * Returns the value of the '<em><b>Color Spec</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Color Spec</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Color Spec</em>' attribute.
   * @see #setColorSpec(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getTokenVisual_ColorSpec()
   * @model
   * @generated
   */
  String getColorSpec();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.TokenVisual#getColorSpec <em>Color Spec</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Color Spec</em>' attribute.
   * @see #getColorSpec()
   * @generated
   */
  void setColorSpec(String value);

  /**
   * Returns the value of the '<em><b>Bold</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bold</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bold</em>' attribute.
   * @see #setBold(boolean)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getTokenVisual_Bold()
   * @model
   * @generated
   */
  boolean isBold();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.TokenVisual#isBold <em>Bold</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bold</em>' attribute.
   * @see #isBold()
   * @generated
   */
  void setBold(boolean value);

  /**
   * Returns the value of the '<em><b>Italic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Italic</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Italic</em>' attribute.
   * @see #setItalic(boolean)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getTokenVisual_Italic()
   * @model
   * @generated
   */
  boolean isItalic();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.TokenVisual#isItalic <em>Italic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Italic</em>' attribute.
   * @see #isItalic()
   * @generated
   */
  void setItalic(boolean value);

} // TokenVisual
