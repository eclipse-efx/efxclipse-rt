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
 * A representation of the model object '<em><b>Rect Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getExternalResourcesRequired <em>External Resources Required</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getTransform <em>Transform</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getRx <em>Rx</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getRy <em>Ry</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRectElement()
 * @model
 * @generated
 */
public interface SvgRectElement extends SvgElement, BasicShapeElement, GraphicsElement, ShapeElement, ConditionalProcessingAttributes, CoreAttributes, GraphicalEventAttributes, PresentationAttributes, ContentElement<SvgElement> {
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRectElement_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getClass_ <em>Class</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRectElement_Style()
	 * @model
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getStyle <em>Style</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRectElement_ExternalResourcesRequired()
	 * @model
	 * @generated
	 */
	String getExternalResourcesRequired();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getExternalResourcesRequired <em>External Resources Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Resources Required</em>' attribute.
	 * @see #getExternalResourcesRequired()
	 * @generated
	 */
	void setExternalResourcesRequired(String value);

	/**
	 * Returns the value of the '<em><b>Transform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transform</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transform</em>' attribute.
	 * @see #setTransform(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRectElement_Transform()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Transform"
	 * @generated
	 */
	String getTransform();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getTransform <em>Transform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transform</em>' attribute.
	 * @see #getTransform()
	 * @generated
	 */
	void setTransform(String value);

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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRectElement_X()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Coordinate"
	 * @generated
	 */
	String getX();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getX <em>X</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRectElement_Y()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Coordinate"
	 * @generated
	 */
	String getY();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getY <em>Y</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRectElement_Width()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Length"
	 * @generated
	 */
	String getWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getWidth <em>Width</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRectElement_Height()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Length"
	 * @generated
	 */
	String getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(String value);

	/**
	 * Returns the value of the '<em><b>Rx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rx</em>' attribute.
	 * @see #setRx(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRectElement_Rx()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Length"
	 * @generated
	 */
	String getRx();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getRx <em>Rx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rx</em>' attribute.
	 * @see #getRx()
	 * @generated
	 */
	void setRx(String value);

	/**
	 * Returns the value of the '<em><b>Ry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ry</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ry</em>' attribute.
	 * @see #setRy(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRectElement_Ry()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Length"
	 * @generated
	 */
	String getRy();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRectElement#getRy <em>Ry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ry</em>' attribute.
	 * @see #getRy()
	 * @generated
	 */
	void setRy(String value);

} // SvgRectElement
