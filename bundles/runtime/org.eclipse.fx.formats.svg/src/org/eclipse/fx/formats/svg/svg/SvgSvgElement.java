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
 * A representation of the model object '<em><b>Svg Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getExternalResourcesRequired <em>External Resources Required</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getViewBox <em>View Box</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getPreserveAspectRatio <em>Preserve Aspect Ratio</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getZoomAndPan <em>Zoom And Pan</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getBaseProfile <em>Base Profile</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getContentScriptType <em>Content Script Type</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getContentStyleType <em>Content Style Type</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getStyleSheet <em>Style Sheet</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement()
 * @model
 * @generated
 */
public interface SvgSvgElement extends SvgElement, ContainerElement<SvgElement>, StructuralElement, ConditionalProcessingAttributes, CoreAttributes, DocumentEventAttributes, GraphicalEventAttributes, PresentationAttributes, ContentElement<SvgElement> {
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getClass_ <em>Class</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_Style()
	 * @model
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getStyle <em>Style</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_ExternalResourcesRequired()
	 * @model
	 * @generated
	 */
	String getExternalResourcesRequired();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getExternalResourcesRequired <em>External Resources Required</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_X()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Coordinate"
	 * @generated
	 */
	String getX();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getX <em>X</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_Y()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Coordinate"
	 * @generated
	 */
	String getY();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getY <em>Y</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_Width()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Length"
	 * @generated
	 */
	String getWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getWidth <em>Width</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_Height()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Length"
	 * @generated
	 */
	String getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(String value);

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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_ViewBox()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.ViewBox"
	 * @generated
	 */
	String getViewBox();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getViewBox <em>View Box</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_PreserveAspectRatio()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.PreserveAspectRatio"
	 * @generated
	 */
	String getPreserveAspectRatio();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getPreserveAspectRatio <em>Preserve Aspect Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preserve Aspect Ratio</em>' attribute.
	 * @see #getPreserveAspectRatio()
	 * @generated
	 */
	void setPreserveAspectRatio(String value);

	/**
	 * Returns the value of the '<em><b>Zoom And Pan</b></em>' attribute.
	 * The default value is <code>"zoomandpan.disable"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.ZoomAndPan}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zoom And Pan</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zoom And Pan</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.ZoomAndPan
	 * @see #setZoomAndPan(ZoomAndPan)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_ZoomAndPan()
	 * @model default="zoomandpan.disable"
	 * @generated
	 */
	ZoomAndPan getZoomAndPan();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getZoomAndPan <em>Zoom And Pan</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zoom And Pan</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.ZoomAndPan
	 * @see #getZoomAndPan()
	 * @generated
	 */
	void setZoomAndPan(ZoomAndPan value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(Double)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_Version()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Number"
	 * @generated
	 */
	Double getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(Double value);

	/**
	 * Returns the value of the '<em><b>Base Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Profile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Profile</em>' attribute.
	 * @see #setBaseProfile(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_BaseProfile()
	 * @model
	 * @generated
	 */
	String getBaseProfile();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getBaseProfile <em>Base Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Profile</em>' attribute.
	 * @see #getBaseProfile()
	 * @generated
	 */
	void setBaseProfile(String value);

	/**
	 * Returns the value of the '<em><b>Content Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Script Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Script Type</em>' attribute.
	 * @see #setContentScriptType(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_ContentScriptType()
	 * @model
	 * @generated
	 */
	String getContentScriptType();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getContentScriptType <em>Content Script Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Script Type</em>' attribute.
	 * @see #getContentScriptType()
	 * @generated
	 */
	void setContentScriptType(String value);

	/**
	 * Returns the value of the '<em><b>Content Style Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Style Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Style Type</em>' attribute.
	 * @see #setContentStyleType(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_ContentStyleType()
	 * @model
	 * @generated
	 */
	String getContentStyleType();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getContentStyleType <em>Content Style Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Style Type</em>' attribute.
	 * @see #getContentStyleType()
	 * @generated
	 */
	void setContentStyleType(String value);

	/**
	 * Returns the value of the '<em><b>Style Sheet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style Sheet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style Sheet</em>' attribute.
	 * @see #setStyleSheet(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSvgElement_StyleSheet()
	 * @model
	 * @generated
	 */
	String getStyleSheet();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSvgElement#getStyleSheet <em>Style Sheet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style Sheet</em>' attribute.
	 * @see #getStyleSheet()
	 * @generated
	 */
	void setStyleSheet(String value);

} // SvgSvgElement
