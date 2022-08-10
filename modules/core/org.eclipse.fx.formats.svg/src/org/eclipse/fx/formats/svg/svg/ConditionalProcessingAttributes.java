/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.formats.svg.svg;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Processing Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.ConditionalProcessingAttributes#getRequiredFeatures <em>Required Features</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.ConditionalProcessingAttributes#getRequiredExtensions <em>Required Extensions</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.ConditionalProcessingAttributes#getSystemLanguage <em>System Language</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getConditionalProcessingAttributes()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ConditionalProcessingAttributes extends EObject {
	/**
	 * Returns the value of the '<em><b>Required Features</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Features</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Features</em>' attribute.
	 * @see #setRequiredFeatures(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getConditionalProcessingAttributes_RequiredFeatures()
	 * @model
	 * @generated
	 */
	String getRequiredFeatures();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.ConditionalProcessingAttributes#getRequiredFeatures <em>Required Features</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Features</em>' attribute.
	 * @see #getRequiredFeatures()
	 * @generated
	 */
	void setRequiredFeatures(String value);

	/**
	 * Returns the value of the '<em><b>Required Extensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Extensions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Extensions</em>' attribute.
	 * @see #setRequiredExtensions(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getConditionalProcessingAttributes_RequiredExtensions()
	 * @model
	 * @generated
	 */
	String getRequiredExtensions();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.ConditionalProcessingAttributes#getRequiredExtensions <em>Required Extensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Extensions</em>' attribute.
	 * @see #getRequiredExtensions()
	 * @generated
	 */
	void setRequiredExtensions(String value);

	/**
	 * Returns the value of the '<em><b>System Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Language</em>' attribute.
	 * @see #setSystemLanguage(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getConditionalProcessingAttributes_SystemLanguage()
	 * @model
	 * @generated
	 */
	String getSystemLanguage();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.ConditionalProcessingAttributes#getSystemLanguage <em>System Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Language</em>' attribute.
	 * @see #getSystemLanguage()
	 * @generated
	 */
	void setSystemLanguage(String value);

} // ConditionalProcessingAttributes
