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
 * A representation of the model object '<em><b>Fe Composite Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getIn2 <em>In2</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getK1 <em>K1</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getK2 <em>K2</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getK3 <em>K3</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getK4 <em>K4</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeCompositeElement()
 * @model
 * @generated
 */
public interface SvgFeCompositeElement extends SvgElement, CoreAttributes, PresentationAttributes, FilterPrimitiveAttributes, ContentElement<SvgElement> {
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeCompositeElement_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getClass_ <em>Class</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeCompositeElement_Style()
	 * @model
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getStyle <em>Style</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeCompositeElement_In2()
	 * @model
	 * @generated
	 */
	String getIn2();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getIn2 <em>In2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In2</em>' attribute.
	 * @see #getIn2()
	 * @generated
	 */
	void setIn2(String value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The default value is <code>"CompositeOperator.over"</code>.
	 * The literals are from the enumeration {@link org.eclipse.fx.formats.svg.svg.CompositeOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.CompositeOperator
	 * @see #setOperator(CompositeOperator)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeCompositeElement_Operator()
	 * @model default="CompositeOperator.over"
	 * @generated
	 */
	CompositeOperator getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.eclipse.fx.formats.svg.svg.CompositeOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(CompositeOperator value);

	/**
	 * Returns the value of the '<em><b>K1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>K1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>K1</em>' attribute.
	 * @see #setK1(Double)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeCompositeElement_K1()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Number"
	 * @generated
	 */
	Double getK1();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getK1 <em>K1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>K1</em>' attribute.
	 * @see #getK1()
	 * @generated
	 */
	void setK1(Double value);

	/**
	 * Returns the value of the '<em><b>K2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>K2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>K2</em>' attribute.
	 * @see #setK2(Double)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeCompositeElement_K2()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Number"
	 * @generated
	 */
	Double getK2();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getK2 <em>K2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>K2</em>' attribute.
	 * @see #getK2()
	 * @generated
	 */
	void setK2(Double value);

	/**
	 * Returns the value of the '<em><b>K3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>K3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>K3</em>' attribute.
	 * @see #setK3(Double)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeCompositeElement_K3()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Number"
	 * @generated
	 */
	Double getK3();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getK3 <em>K3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>K3</em>' attribute.
	 * @see #getK3()
	 * @generated
	 */
	void setK3(Double value);

	/**
	 * Returns the value of the '<em><b>K4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>K4</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>K4</em>' attribute.
	 * @see #setK4(Double)
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgFeCompositeElement_K4()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.Number"
	 * @generated
	 */
	Double getK4();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgFeCompositeElement#getK4 <em>K4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>K4</em>' attribute.
	 * @see #getK4()
	 * @generated
	 */
	void setK4(Double value);

} // SvgFeCompositeElement
