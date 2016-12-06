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
 * A representation of the model object '<em><b>Radial Gradient Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getExternalResourcesRequired <em>External Resources Required</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getCx <em>Cx</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getCy <em>Cy</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getR <em>R</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getFx <em>Fx</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getFy <em>Fy</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getSpreadMethod <em>Spread Method</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getGradientUnits <em>Gradient Units</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getGradientTransform <em>Gradient Transform</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRadialGradientElement()
 * @model
 * @generated
 */
public interface SvgRadialGradientElement extends SvgElement, GradientElement, CoreAttributes, PresentationAttributes, XLinkAttributes, ContentElement<SvgElement> {
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRadialGradientElement_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getClass_ <em>Class</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRadialGradientElement_Style()
	 * @model
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getStyle <em>Style</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRadialGradientElement_ExternalResourcesRequired()
	 * @model
	 * @generated
	 */
	String getExternalResourcesRequired();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getExternalResourcesRequired <em>External Resources Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Resources Required</em>' attribute.
	 * @see #getExternalResourcesRequired()
	 * @generated
	 */
	void setExternalResourcesRequired(String value);

	/**
	 * Returns the value of the '<em><b>Cx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cx</em>' attribute.
	 * @see #setCx(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRadialGradientElement_Cx()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Coordinate"
	 * @generated
	 */
	String getCx();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getCx <em>Cx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cx</em>' attribute.
	 * @see #getCx()
	 * @generated
	 */
	void setCx(String value);

	/**
	 * Returns the value of the '<em><b>Cy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cy</em>' attribute.
	 * @see #setCy(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRadialGradientElement_Cy()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Coordinate"
	 * @generated
	 */
	String getCy();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getCy <em>Cy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cy</em>' attribute.
	 * @see #getCy()
	 * @generated
	 */
	void setCy(String value);

	/**
	 * Returns the value of the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>R</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>R</em>' attribute.
	 * @see #setR(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRadialGradientElement_R()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Length"
	 * @generated
	 */
	String getR();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getR <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R</em>' attribute.
	 * @see #getR()
	 * @generated
	 */
	void setR(String value);

	/**
	 * Returns the value of the '<em><b>Fx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fx</em>' attribute.
	 * @see #setFx(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRadialGradientElement_Fx()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Coordinate"
	 * @generated
	 */
	String getFx();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getFx <em>Fx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fx</em>' attribute.
	 * @see #getFx()
	 * @generated
	 */
	void setFx(String value);

	/**
	 * Returns the value of the '<em><b>Fy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fy</em>' attribute.
	 * @see #setFy(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRadialGradientElement_Fy()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Coordinate"
	 * @generated
	 */
	String getFy();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getFy <em>Fy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fy</em>' attribute.
	 * @see #getFy()
	 * @generated
	 */
	void setFy(String value);

	/**
	 * Returns the value of the '<em><b>Spread Method</b></em>' attribute.
	 * The default value is <code>"SpreadMethod.pad"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.SpreadMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spread Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spread Method</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.SpreadMethod
	 * @see #setSpreadMethod(SpreadMethod)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRadialGradientElement_SpreadMethod()
	 * @model default="SpreadMethod.pad"
	 * @generated
	 */
	SpreadMethod getSpreadMethod();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getSpreadMethod <em>Spread Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spread Method</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.SpreadMethod
	 * @see #getSpreadMethod()
	 * @generated
	 */
	void setSpreadMethod(SpreadMethod value);

	/**
	 * Returns the value of the '<em><b>Gradient Units</b></em>' attribute.
	 * The default value is <code>"GradientUnits.objectBoundingBox"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.GradientUnits}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gradient Units</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gradient Units</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.GradientUnits
	 * @see #setGradientUnits(GradientUnits)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRadialGradientElement_GradientUnits()
	 * @model default="GradientUnits.objectBoundingBox"
	 * @generated
	 */
	GradientUnits getGradientUnits();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getGradientUnits <em>Gradient Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gradient Units</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.GradientUnits
	 * @see #getGradientUnits()
	 * @generated
	 */
	void setGradientUnits(GradientUnits value);

	/**
	 * Returns the value of the '<em><b>Gradient Transform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gradient Transform</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gradient Transform</em>' attribute.
	 * @see #setGradientTransform(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgRadialGradientElement_GradientTransform()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.TransformList"
	 * @generated
	 */
	String getGradientTransform();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgRadialGradientElement#getGradientTransform <em>Gradient Transform</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gradient Transform</em>' attribute.
	 * @see #getGradientTransform()
	 * @generated
	 */
	void setGradientTransform(String value);

} // SvgRadialGradientElement
