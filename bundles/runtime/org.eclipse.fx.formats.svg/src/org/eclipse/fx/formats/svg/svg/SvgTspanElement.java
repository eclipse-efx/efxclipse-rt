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
 * A representation of the model object '<em><b>Tspan Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getExternalResourcesRequired <em>External Resources Required</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getDx <em>Dx</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getDy <em>Dy</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getRotate <em>Rotate</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getTextLength <em>Text Length</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getLengthAdjust <em>Length Adjust</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgTspanElement()
 * @model
 * @generated
 */
public interface SvgTspanElement extends SvgElement, TextContentElement, TextContentChildElement, ConditionalProcessingAttributes, CoreAttributes, GraphicalEventAttributes, PresentationAttributes, ContentElement<SvgElement> {
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgTspanElement_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getClass_ <em>Class</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgTspanElement_Style()
	 * @model
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getStyle <em>Style</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgTspanElement_ExternalResourcesRequired()
	 * @model
	 * @generated
	 */
	String getExternalResourcesRequired();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getExternalResourcesRequired <em>External Resources Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Resources Required</em>' attribute.
	 * @see #getExternalResourcesRequired()
	 * @generated
	 */
	void setExternalResourcesRequired(String value);

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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgTspanElement_X()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.ListOfCoordinates"
	 * @generated
	 */
	String getX();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getX <em>X</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgTspanElement_Y()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.ListOfCoordinates"
	 * @generated
	 */
	String getY();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(String value);

	/**
	 * Returns the value of the '<em><b>Dx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dx</em>' attribute.
	 * @see #setDx(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgTspanElement_Dx()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.ListOfLengths"
	 * @generated
	 */
	String getDx();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getDx <em>Dx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dx</em>' attribute.
	 * @see #getDx()
	 * @generated
	 */
	void setDx(String value);

	/**
	 * Returns the value of the '<em><b>Dy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dy</em>' attribute.
	 * @see #setDy(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgTspanElement_Dy()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.ListOfLengths"
	 * @generated
	 */
	String getDy();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getDy <em>Dy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dy</em>' attribute.
	 * @see #getDy()
	 * @generated
	 */
	void setDy(String value);

	/**
	 * Returns the value of the '<em><b>Rotate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotate</em>' attribute.
	 * @see #setRotate(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgTspanElement_Rotate()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.ListOfNumbers"
	 * @generated
	 */
	String getRotate();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getRotate <em>Rotate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotate</em>' attribute.
	 * @see #getRotate()
	 * @generated
	 */
	void setRotate(String value);

	/**
	 * Returns the value of the '<em><b>Text Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Length</em>' attribute.
	 * @see #setTextLength(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgTspanElement_TextLength()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Length"
	 * @generated
	 */
	String getTextLength();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getTextLength <em>Text Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Length</em>' attribute.
	 * @see #getTextLength()
	 * @generated
	 */
	void setTextLength(String value);

	/**
	 * Returns the value of the '<em><b>Length Adjust</b></em>' attribute.
	 * The default value is <code>"LengthAdjust.spacing"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.LengthAdjust}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length Adjust</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length Adjust</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.LengthAdjust
	 * @see #setLengthAdjust(LengthAdjust)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgTspanElement_LengthAdjust()
	 * @model default="LengthAdjust.spacing"
	 * @generated
	 */
	LengthAdjust getLengthAdjust();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgTspanElement#getLengthAdjust <em>Length Adjust</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length Adjust</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.LengthAdjust
	 * @see #getLengthAdjust()
	 * @generated
	 */
	void setLengthAdjust(LengthAdjust value);

} // SvgTspanElement
