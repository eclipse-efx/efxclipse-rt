/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.fx.code.compensator.model.workbench;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.ModuleContainer#getModuleList <em>Module List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getModuleContainer()
 * @model abstract="true"
 * @generated
 */
public interface ModuleContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Module List</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.fx.code.compensator.model.workbench.Module}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module List</em>' containment reference list.
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getModuleContainer_ModuleList()
	 * @model containment="true"
	 * @generated
	 */
	EList<Module> getModuleList();

} // ModuleContainer
