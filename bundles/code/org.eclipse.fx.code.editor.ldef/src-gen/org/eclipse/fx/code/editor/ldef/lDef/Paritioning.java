/**
 */
package org.eclipse.fx.code.editor.ldef.lDef;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paritioning</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Paritioning#getPartitions <em>Partitions</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.Paritioning#getPartitioner <em>Partitioner</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getParitioning()
 * @model
 * @generated
 */
public interface Paritioning extends EObject
{
  /**
   * Returns the value of the '<em><b>Partitions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fx.code.editor.ldef.lDef.Partition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Partitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Partitions</em>' containment reference list.
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getParitioning_Partitions()
   * @model containment="true"
   * @generated
   */
  EList<Partition> getPartitions();

  /**
   * Returns the value of the '<em><b>Partitioner</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Partitioner</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Partitioner</em>' containment reference.
   * @see #setPartitioner(Partitioner)
   * @see org.eclipse.fx.code.editor.ldef.lDef.LDefPackage#getParitioning_Partitioner()
   * @model containment="true"
   * @generated
   */
  Partitioner getPartitioner();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.editor.ldef.lDef.Paritioning#getPartitioner <em>Partitioner</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Partitioner</em>' containment reference.
   * @see #getPartitioner()
   * @generated
   */
  void setPartitioner(Partitioner value);

} // Paritioning
