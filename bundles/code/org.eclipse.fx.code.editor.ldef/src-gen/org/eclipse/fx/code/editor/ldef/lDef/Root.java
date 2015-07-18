/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Root#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Root#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Root#getLanguageDefinition <em>Language Definition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getRoot_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Root#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.editor.ldef.lDef.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getRoot_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Language Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Language Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Language Definition</em>' containment reference.
   * @see #setLanguageDefinition(LanguageDef)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getRoot_LanguageDefinition()
   * @model containment="true"
   * @generated
   */
  LanguageDef getLanguageDefinition();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Root#getLanguageDefinition <em>Language Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Language Definition</em>' containment reference.
   * @see #getLanguageDefinition()
   * @generated
   */
  void setLanguageDefinition(LanguageDef value);

} // Root
