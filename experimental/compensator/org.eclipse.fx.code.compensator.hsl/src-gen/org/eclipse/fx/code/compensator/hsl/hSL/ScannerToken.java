/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scanner Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getFgColor <em>Fg Color</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getBgColor <em>Bg Color</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getFont <em>Font</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScannerToken()
 * @model
 * @generated
 */
public interface ScannerToken extends EObject
{
  /**
   * Returns the value of the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default</em>' attribute.
   * @see #setDefault(boolean)
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScannerToken_Default()
   * @model
   * @generated
   */
  boolean isDefault();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#isDefault <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' attribute.
   * @see #isDefault()
   * @generated
   */
  void setDefault(boolean value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScannerToken_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Fg Color</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fg Color</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fg Color</em>' containment reference.
   * @see #setFgColor(Color)
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScannerToken_FgColor()
   * @model containment="true"
   * @generated
   */
  Color getFgColor();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getFgColor <em>Fg Color</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fg Color</em>' containment reference.
   * @see #getFgColor()
   * @generated
   */
  void setFgColor(Color value);

  /**
   * Returns the value of the '<em><b>Bg Color</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bg Color</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bg Color</em>' containment reference.
   * @see #setBgColor(Color)
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScannerToken_BgColor()
   * @model containment="true"
   * @generated
   */
  Color getBgColor();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getBgColor <em>Bg Color</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bg Color</em>' containment reference.
   * @see #getBgColor()
   * @generated
   */
  void setBgColor(Color value);

  /**
   * Returns the value of the '<em><b>Font</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Font</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Font</em>' containment reference.
   * @see #setFont(Font)
   * @see org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage#getScannerToken_Font()
   * @model containment="true"
   * @generated
   */
  Font getFont();

  /**
   * Sets the value of the '{@link org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken#getFont <em>Font</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Font</em>' containment reference.
   * @see #getFont()
   * @generated
   */
  void setFont(Font value);

} // ScannerToken
