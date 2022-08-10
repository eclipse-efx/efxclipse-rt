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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fe Turbulence Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getBaseFrequency <em>Base Frequency</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getNumOctaves <em>Num Octaves</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getSeed <em>Seed</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getStitchTiles <em>Stitch Tiles</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeTurbulenceElement()
 * @model
 * @generated
 */
public interface SvgFeTurbulenceElement extends SvgElement, CoreAttributes, PresentationAttributes, FilterPrimitiveAttributes, ContentElement<SvgElement> {
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeTurbulenceElement_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getClass_ <em>Class</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeTurbulenceElement_Style()
	 * @model
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(String value);

	/**
	 * Returns the value of the '<em><b>Base Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Frequency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Frequency</em>' attribute.
	 * @see #setBaseFrequency(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeTurbulenceElement_BaseFrequency()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.NumberOptionalNumber"
	 * @generated
	 */
	String getBaseFrequency();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getBaseFrequency <em>Base Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Frequency</em>' attribute.
	 * @see #getBaseFrequency()
	 * @generated
	 */
	void setBaseFrequency(String value);

	/**
	 * Returns the value of the '<em><b>Num Octaves</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Octaves</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Octaves</em>' attribute.
	 * @see #setNumOctaves(int)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeTurbulenceElement_NumOctaves()
	 * @model default="1"
	 * @generated
	 */
	int getNumOctaves();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getNumOctaves <em>Num Octaves</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Octaves</em>' attribute.
	 * @see #getNumOctaves()
	 * @generated
	 */
	void setNumOctaves(int value);

	/**
	 * Returns the value of the '<em><b>Seed</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seed</em>' attribute.
	 * @see #setSeed(Double)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeTurbulenceElement_Seed()
	 * @model default="0" dataType="org.eclipse.fx.formats.svg.svg.Number"
	 * @generated
	 */
	Double getSeed();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getSeed <em>Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seed</em>' attribute.
	 * @see #getSeed()
	 * @generated
	 */
	void setSeed(Double value);

	/**
	 * Returns the value of the '<em><b>Stitch Tiles</b></em>' attribute.
	 * The default value is <code>"StitchTiles.noStitch"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.StitchTiles}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stitch Tiles</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stitch Tiles</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.StitchTiles
	 * @see #setStitchTiles(StitchTiles)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeTurbulenceElement_StitchTiles()
	 * @model default="StitchTiles.noStitch"
	 * @generated
	 */
	StitchTiles getStitchTiles();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getStitchTiles <em>Stitch Tiles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stitch Tiles</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.StitchTiles
	 * @see #getStitchTiles()
	 * @generated
	 */
	void setStitchTiles(StitchTiles value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"TurbulenceType.turbulence"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.TurbulenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.TurbulenceType
	 * @see #setType(TurbulenceType)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeTurbulenceElement_Type()
	 * @model default="TurbulenceType.turbulence"
	 * @generated
	 */
	TurbulenceType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeTurbulenceElement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.TurbulenceType
	 * @see #getType()
	 * @generated
	 */
	void setType(TurbulenceType value);

} // SvgFeTurbulenceElement
