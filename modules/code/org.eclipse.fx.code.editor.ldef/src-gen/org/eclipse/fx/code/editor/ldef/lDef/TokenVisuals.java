/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token Visuals</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.TokenVisuals#getTokenVisuals <em>Token Visuals</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getTokenVisuals()
 * @model
 * @generated
 */
public interface TokenVisuals extends EObject
{
  /**
   * Returns the value of the '<em><b>Token Visuals</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.editor.ldef.lDef.TokenVisual}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Token Visuals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Token Visuals</em>' containment reference list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getTokenVisuals_TokenVisuals()
   * @model containment="true"
   * @generated
   */
  EList<TokenVisual> getTokenVisuals();

} // TokenVisuals
