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
 * A representation of the model object '<em><b>Fe Offset Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeOffsetElement#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeOffsetElement#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeOffsetElement#getDx <em>Dx</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeOffsetElement#getDy <em>Dy</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeOffsetElement()
 * @model
 * @generated
 */
public interface SvgFeOffsetElement extends SvgElement, CoreAttributes, PresentationAttributes, FilterPrimitiveAttributes, ContentElement<SvgElement> {
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeOffsetElement_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeOffsetElement#getClass_ <em>Class</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeOffsetElement_Style()
	 * @model
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeOffsetElement#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(String value);

	/**
	 * Returns the value of the '<em><b>Dx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dx</em>' attribute.
	 * @see #setDx(Double)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeOffsetElement_Dx()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Number"
	 * @generated
	 */
	Double getDx();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeOffsetElement#getDx <em>Dx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dx</em>' attribute.
	 * @see #getDx()
	 * @generated
	 */
	void setDx(Double value);

	/**
	 * Returns the value of the '<em><b>Dy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dy</em>' attribute.
	 * @see #setDy(Double)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeOffsetElement_Dy()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Number"
	 * @generated
	 */
	Double getDy();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeOffsetElement#getDy <em>Dy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dy</em>' attribute.
	 * @see #getDy()
	 * @generated
	 */
	void setDy(Double value);

} // SvgFeOffsetElement
