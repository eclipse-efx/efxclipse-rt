/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.fx.formats.svg.svg;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbol Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSymbolElement#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSymbolElement#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSymbolElement#getExternalResourcesRequired <em>External Resources Required</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSymbolElement#getViewBox <em>View Box</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.SvgSymbolElement#getPreserveAspectRatio <em>Preserve Aspect Ratio</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSymbolElement()
 * @model
 * @generated
 */
public interface SvgSymbolElement extends SvgElement, ContainerElement<SvgElement>, StructuralElement, CoreAttributes, GraphicalEventAttributes, PresentationAttributes, ContentElement<SvgElement> {
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSymbolElement_Class()
	 * @model
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSymbolElement#getClass_ <em>Class</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSymbolElement_Style()
	 * @model
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSymbolElement#getStyle <em>Style</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSymbolElement_ExternalResourcesRequired()
	 * @model
	 * @generated
	 */
	String getExternalResourcesRequired();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSymbolElement#getExternalResourcesRequired <em>External Resources Required</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSymbolElement_ViewBox()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.ViewBox"
	 * @generated
	 */
	String getViewBox();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSymbolElement#getViewBox <em>View Box</em>}' attribute.
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
	 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getSvgSymbolElement_PreserveAspectRatio()
	 * @model dataType="org.eclipse.fx.formats.svg.svg.PreserveAspectRatio"
	 * @generated
	 */
	String getPreserveAspectRatio();

	/**
	 * Sets the value of the '{@link org.eclipse.fx.formats.svg.svg.SvgSymbolElement#getPreserveAspectRatio <em>Preserve Aspect Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preserve Aspect Ratio</em>' attribute.
	 * @see #getPreserveAspectRatio()
	 * @generated
	 */
	void setPreserveAspectRatio(String value);

} // SvgSymbolElement
