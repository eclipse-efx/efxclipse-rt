/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.formats.svg.svg;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fe Diffuse Lighting Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement#getSurfaceScale <em>Surface Scale</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement#getDiffuseConstant <em>Diffuse Constant</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement#getKernelUnitLength <em>Kernel Unit Length</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDiffuseLightingElement()
 * @model
 * @generated
 */
public interface SvgFeDiffuseLightingElement extends SvgElement, CoreAttributes, PresentationAttributes, FilterPrimitiveAttributes, ContentElement<SvgElement> {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDiffuseLightingElement_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(String value);

	/**
	 * Returns the value of the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' attribute.
	 * @see #setStyle(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDiffuseLightingElement_Style()
	 * @model
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(String value);

	/**
	 * Returns the value of the '<em><b>Surface Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Surface Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Surface Scale</em>' attribute.
	 * @see #setSurfaceScale(Double)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDiffuseLightingElement_SurfaceScale()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Number"
	 * @generated
	 */
	Double getSurfaceScale();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement#getSurfaceScale <em>Surface Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Surface Scale</em>' attribute.
	 * @see #getSurfaceScale()
	 * @generated
	 */
	void setSurfaceScale(Double value);

	/**
	 * Returns the value of the '<em><b>Diffuse Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diffuse Constant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diffuse Constant</em>' attribute.
	 * @see #setDiffuseConstant(Double)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDiffuseLightingElement_DiffuseConstant()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Number"
	 * @generated
	 */
	Double getDiffuseConstant();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement#getDiffuseConstant <em>Diffuse Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diffuse Constant</em>' attribute.
	 * @see #getDiffuseConstant()
	 * @generated
	 */
	void setDiffuseConstant(Double value);

	/**
	 * Returns the value of the '<em><b>Kernel Unit Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kernel Unit Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kernel Unit Length</em>' attribute.
	 * @see #setKernelUnitLength(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDiffuseLightingElement_KernelUnitLength()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.NumberOptionalNumber"
	 * @generated
	 */
	String getKernelUnitLength();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeDiffuseLightingElement#getKernelUnitLength <em>Kernel Unit Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kernel Unit Length</em>' attribute.
	 * @see #getKernelUnitLength()
	 * @generated
	 */
	void setKernelUnitLength(String value);

} // SvgFeDiffuseLightingElement
