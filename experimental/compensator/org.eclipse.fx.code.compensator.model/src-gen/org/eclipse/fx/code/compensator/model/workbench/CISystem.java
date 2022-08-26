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
 * A representation of the model object '<em><b>CI System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.CISystem#getTypeId <em>Type Id</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.CISystem#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.model.workbench.CISystem#getServiceUrl <em>Service Url</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getCISystem()
 * @model
 * @generated
 */
public interface CISystem extends EObject {
	/**
	 * Returns the value of the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Id</em>' attribute.
	 * @see #setTypeId(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getCISystem_TypeId()
	 * @model unique="false"
	 * @generated
	 */
	String getTypeId();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.CISystem#getTypeId <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Id</em>' attribute.
	 * @see #getTypeId()
	 * @generated
	 */
	void setTypeId(String value);

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
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getCISystem_Label()
	 * @model unique="false"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.CISystem#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Service Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Url</em>' attribute.
	 * @see #setServiceUrl(String)
	 * @see org.eclipse.fx.code.compensator.model.workbench.WorkbenchPackage#getCISystem_ServiceUrl()
	 * @model unique="false"
	 * @generated
	 */
	String getServiceUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.code.compensator.model.workbench.CISystem#getServiceUrl <em>Service Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Url</em>' attribute.
	 * @see #getServiceUrl()
	 * @generated
	 */
	void setServiceUrl(String value);

} // CISystem
