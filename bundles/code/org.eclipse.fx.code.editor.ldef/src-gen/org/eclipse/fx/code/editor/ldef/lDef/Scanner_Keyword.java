/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scanner Keyword</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Scanner_Keyword#getKeywords <em>Keywords</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_Keyword()
 * @model
 * @generated
 */
public interface Scanner_Keyword extends Scanner
{
  /**
   * Returns the value of the '<em><b>Keywords</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.editor.ldef.lDef.Keyword}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Keywords</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Keywords</em>' containment reference list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getScanner_Keyword_Keywords()
   * @model containment="true"
   * @generated
   */
  EList<Keyword> getKeywords();

} // Scanner_Keyword
