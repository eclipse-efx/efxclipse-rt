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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VCS Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository#getRepoType <em>Repo Type</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository#getRepoURI <em>Repo URI</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository#getLocalURI <em>Local URI</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository#getRepoUsername <em>Repo Username</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository#getRepoPassword <em>Repo Password</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getVCSRepository()
 * @model
 * @generated
 */
public interface VCSRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getVCSRepository_Label()
	 * @model unique="false"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Repo Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repo Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repo Type</em>' attribute.
	 * @see #setRepoType(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getVCSRepository_RepoType()
	 * @model unique="false"
	 * @generated
	 */
	String getRepoType();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository#getRepoType <em>Repo Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repo Type</em>' attribute.
	 * @see #getRepoType()
	 * @generated
	 */
	void setRepoType(String value);

	/**
	 * Returns the value of the '<em><b>Repo URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repo URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repo URI</em>' attribute.
	 * @see #setRepoURI(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getVCSRepository_RepoURI()
	 * @model unique="false"
	 * @generated
	 */
	String getRepoURI();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository#getRepoURI <em>Repo URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repo URI</em>' attribute.
	 * @see #getRepoURI()
	 * @generated
	 */
	void setRepoURI(String value);

	/**
	 * Returns the value of the '<em><b>Local URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local URI</em>' attribute.
	 * @see #setLocalURI(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getVCSRepository_LocalURI()
	 * @model unique="false"
	 * @generated
	 */
	String getLocalURI();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository#getLocalURI <em>Local URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local URI</em>' attribute.
	 * @see #getLocalURI()
	 * @generated
	 */
	void setLocalURI(String value);

	/**
	 * Returns the value of the '<em><b>Repo Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repo Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repo Username</em>' attribute.
	 * @see #setRepoUsername(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getVCSRepository_RepoUsername()
	 * @model unique="false"
	 * @generated
	 */
	String getRepoUsername();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository#getRepoUsername <em>Repo Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repo Username</em>' attribute.
	 * @see #getRepoUsername()
	 * @generated
	 */
	void setRepoUsername(String value);

	/**
	 * Returns the value of the '<em><b>Repo Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repo Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repo Password</em>' attribute.
	 * @see #setRepoPassword(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getVCSRepository_RepoPassword()
	 * @model unique="false"
	 * @generated
	 */
	String getRepoPassword();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.VCSRepository#getRepoPassword <em>Repo Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repo Password</em>' attribute.
	 * @see #getRepoPassword()
	 * @generated
	 */
	void setRepoPassword(String value);

} // VCSRepository
