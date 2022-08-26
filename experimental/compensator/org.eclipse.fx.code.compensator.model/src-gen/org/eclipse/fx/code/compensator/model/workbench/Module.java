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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.Module#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.Module#getRootFolderUrl <em>Root Folder Url</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.Module#getUserdata <em>Userdata</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends ModuleContainer {
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
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getModule_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.Module#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Root Folder Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Folder Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Folder Url</em>' attribute.
	 * @see #setRootFolderUrl(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getModule_RootFolderUrl()
	 * @model unique="false"
	 * @generated
	 */
	String getRootFolderUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.Module#getRootFolderUrl <em>Root Folder Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Folder Url</em>' attribute.
	 * @see #getRootFolderUrl()
	 * @generated
	 */
	void setRootFolderUrl(String value);

	/**
	 * Returns the value of the '<em><b>Userdata</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Userdata</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Userdata</em>' attribute.
	 * @see #setUserdata(Object)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getModule_Userdata()
	 * @model unique="false" transient="true"
	 * @generated
	 */
	Object getUserdata();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.Module#getUserdata <em>Userdata</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Userdata</em>' attribute.
	 * @see #getUserdata()
	 * @generated
	 */
	void setUserdata(Object value);

} // Module
