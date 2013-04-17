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
 * A representation of the model object '<em><b>Pattern Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getExternalResourcesRequired <em>External Resources Required</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getViewBox <em>View Box</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getPreserveAspectRatio <em>Preserve Aspect Ratio</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getPatternUnits <em>Pattern Units</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getPatternContentUnits <em>Pattern Content Units</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getPatternTransform <em>Pattern Transform</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement()
 * @model
 * @generated
 */
public interface SvgPatternElement extends SvgElement, ContainerElement<SvgElement>, ConditionalProcessingAttributes, CoreAttributes, PresentationAttributes, XLinkAttributes, ContentElement<SvgElement> {
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getClass_ <em>Class</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement_Style()
	 * @model
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(String value);

	/**
	 * Returns the value of the '<em><b>External Resources Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Resources Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Resources Required</em>' attribute.
	 * @see #setExternalResourcesRequired(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement_ExternalResourcesRequired()
	 * @model
	 * @generated
	 */
	String getExternalResourcesRequired();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getExternalResourcesRequired <em>External Resources Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Resources Required</em>' attribute.
	 * @see #getExternalResourcesRequired()
	 * @generated
	 */
	void setExternalResourcesRequired(String value);

	/**
	 * Returns the value of the '<em><b>View Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Box</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View Box</em>' attribute.
	 * @see #setViewBox(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement_ViewBox()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.ViewBox"
	 * @generated
	 */
	String getViewBox();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getViewBox <em>View Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Box</em>' attribute.
	 * @see #getViewBox()
	 * @generated
	 */
	void setViewBox(String value);

	/**
	 * Returns the value of the '<em><b>Preserve Aspect Ratio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preserve Aspect Ratio</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preserve Aspect Ratio</em>' attribute.
	 * @see #setPreserveAspectRatio(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement_PreserveAspectRatio()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.PreserveAspectRatio"
	 * @generated
	 */
	String getPreserveAspectRatio();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getPreserveAspectRatio <em>Preserve Aspect Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preserve Aspect Ratio</em>' attribute.
	 * @see #getPreserveAspectRatio()
	 * @generated
	 */
	void setPreserveAspectRatio(String value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement_X()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Coordinate"
	 * @generated
	 */
	String getX();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(String value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement_Y()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Coordinate"
	 * @generated
	 */
	String getY();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(String value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement_Width()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Length"
	 * @generated
	 */
	String getWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(String value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement_Height()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Length"
	 * @generated
	 */
	String getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(String value);

	/**
	 * Returns the value of the '<em><b>Pattern Units</b></em>' attribute.
	 * The default value is <code>"PatternUnits.objectBoundingBox"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.PatternUnits}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Units</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Units</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.PatternUnits
	 * @see #setPatternUnits(PatternUnits)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement_PatternUnits()
	 * @model default="PatternUnits.objectBoundingBox"
	 * @generated
	 */
	PatternUnits getPatternUnits();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getPatternUnits <em>Pattern Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern Units</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.PatternUnits
	 * @see #getPatternUnits()
	 * @generated
	 */
	void setPatternUnits(PatternUnits value);

	/**
	 * Returns the value of the '<em><b>Pattern Content Units</b></em>' attribute.
	 * The default value is <code>"PatternUnits.userSpaceOnUse"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.PatternUnits}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Content Units</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Content Units</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.PatternUnits
	 * @see #setPatternContentUnits(PatternUnits)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement_PatternContentUnits()
	 * @model default="PatternUnits.userSpaceOnUse"
	 * @generated
	 */
	PatternUnits getPatternContentUnits();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getPatternContentUnits <em>Pattern Content Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern Content Units</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.PatternUnits
	 * @see #getPatternContentUnits()
	 * @generated
	 */
	void setPatternContentUnits(PatternUnits value);

	/**
	 * Returns the value of the '<em><b>Pattern Transform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Transform</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Transform</em>' attribute.
	 * @see #setPatternTransform(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgPatternElement_PatternTransform()
	 * @model
	 * @generated
	 */
	String getPatternTransform();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgPatternElement#getPatternTransform <em>Pattern Transform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern Transform</em>' attribute.
	 * @see #getPatternTransform()
	 * @generated
	 */
	void setPatternTransform(String value);

} // SvgPatternElement
