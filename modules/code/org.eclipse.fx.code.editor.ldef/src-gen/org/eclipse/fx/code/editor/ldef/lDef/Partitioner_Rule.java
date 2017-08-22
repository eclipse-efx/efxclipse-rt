/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partitioner Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule#getRuleList <em>Rule List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getPartitioner_Rule()
 * @model
 * @generated
 */
public interface Partitioner_Rule extends Partitioner
{
  /**
   * Returns the value of the '<em><b>Rule List</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.editor.ldef.lDef.Partition_Rule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rule List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule List</em>' containment reference list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getPartitioner_Rule_RuleList()
   * @model containment="true"
   * @generated
   */
  EList<Partition_Rule> getRuleList();

} // Partitioner_Rule
