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
 * A representation of the model object '<em><b>Fe Displacement Map Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement#getIn2 <em>In2</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement#getScale <em>Scale</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement#getXChannelSelector <em>XChannel Selector</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement#getYChannelSelector <em>YChannel Selector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDisplacementMapElement()
 * @model
 * @generated
 */
public interface SvgFeDisplacementMapElement extends SvgElement, CoreAttributes, PresentationAttributes, FilterPrimitiveAttributes, ContentElement<SvgElement> {
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDisplacementMapElement_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement#getClass_ <em>Class</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDisplacementMapElement_Style()
	 * @model
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(String value);

	/**
	 * Returns the value of the '<em><b>In2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In2</em>' attribute.
	 * @see #setIn2(String)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDisplacementMapElement_In2()
	 * @model
	 * @generated
	 */
	String getIn2();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement#getIn2 <em>In2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In2</em>' attribute.
	 * @see #getIn2()
	 * @generated
	 */
	void setIn2(String value);

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see #setScale(Double)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDisplacementMapElement_Scale()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Number"
	 * @generated
	 */
	Double getScale();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(Double value);

	/**
	 * Returns the value of the '<em><b>XChannel Selector</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.ChannelSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XChannel Selector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XChannel Selector</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.ChannelSelector
	 * @see #setXChannelSelector(ChannelSelector)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDisplacementMapElement_XChannelSelector()
	 * @model
	 * @generated
	 */
	ChannelSelector getXChannelSelector();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement#getXChannelSelector <em>XChannel Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XChannel Selector</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.ChannelSelector
	 * @see #getXChannelSelector()
	 * @generated
	 */
	void setXChannelSelector(ChannelSelector value);

	/**
	 * Returns the value of the '<em><b>YChannel Selector</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.ChannelSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YChannel Selector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YChannel Selector</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.ChannelSelector
	 * @see #setYChannelSelector(ChannelSelector)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeDisplacementMapElement_YChannelSelector()
	 * @model
	 * @generated
	 */
	ChannelSelector getYChannelSelector();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeDisplacementMapElement#getYChannelSelector <em>YChannel Selector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YChannel Selector</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.ChannelSelector
	 * @see #getYChannelSelector()
	 * @generated
	 */
	void setYChannelSelector(ChannelSelector value);

} // SvgFeDisplacementMapElement
