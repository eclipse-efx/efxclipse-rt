/**
 */
package org.eclipse.fx.code.compensator.hsl.hSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.fx.code.compensator.hsl.hSL.Color;
import org.eclipse.fx.code.compensator.hsl.hSL.Font;
import org.eclipse.fx.code.compensator.hsl.hSL.HSLPackage;
import org.eclipse.fx.code.compensator.hsl.hSL.ScannerToken;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scanner Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerTokenImpl#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerTokenImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerTokenImpl#getFgColor <em>Fg Color</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerTokenImpl#getBgColor <em>Bg Color</em>}</li>
 *   <li>{@link org.eclipse.fx.code.compensator.hsl.hSL.impl.ScannerTokenImpl#getFont <em>Font</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScannerTokenImpl extends MinimalEObjectImpl.Container implements ScannerToken
{
  /**
   * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefault()
   * @generated
   * @ordered
   */
  protected static final boolean DEFAULT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefault()
   * @generated
   * @ordered
   */
  protected boolean default_ = DEFAULT_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getFgColor() <em>Fg Color</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFgColor()
   * @generated
   * @ordered
   */
  protected Color fgColor;

  /**
   * The cached value of the '{@link #getBgColor() <em>Bg Color</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBgColor()
   * @generated
   * @ordered
   */
  protected Color bgColor;

  /**
   * The cached value of the '{@link #getFont() <em>Font</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFont()
   * @generated
   * @ordered
   */
  protected Font font;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ScannerTokenImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return HSLPackage.Literals.SCANNER_TOKEN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDefault()
  {
    return default_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefault(boolean newDefault)
  {
    boolean oldDefault = default_;
    default_ = newDefault;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_TOKEN__DEFAULT, oldDefault, default_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_TOKEN__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Color getFgColor()
  {
    return fgColor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFgColor(Color newFgColor, NotificationChain msgs)
  {
    Color oldFgColor = fgColor;
    fgColor = newFgColor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_TOKEN__FG_COLOR, oldFgColor, newFgColor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFgColor(Color newFgColor)
  {
    if (newFgColor != fgColor)
    {
      NotificationChain msgs = null;
      if (fgColor != null)
        msgs = ((InternalEObject)fgColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HSLPackage.SCANNER_TOKEN__FG_COLOR, null, msgs);
      if (newFgColor != null)
        msgs = ((InternalEObject)newFgColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HSLPackage.SCANNER_TOKEN__FG_COLOR, null, msgs);
      msgs = basicSetFgColor(newFgColor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_TOKEN__FG_COLOR, newFgColor, newFgColor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Color getBgColor()
  {
    return bgColor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBgColor(Color newBgColor, NotificationChain msgs)
  {
    Color oldBgColor = bgColor;
    bgColor = newBgColor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_TOKEN__BG_COLOR, oldBgColor, newBgColor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBgColor(Color newBgColor)
  {
    if (newBgColor != bgColor)
    {
      NotificationChain msgs = null;
      if (bgColor != null)
        msgs = ((InternalEObject)bgColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HSLPackage.SCANNER_TOKEN__BG_COLOR, null, msgs);
      if (newBgColor != null)
        msgs = ((InternalEObject)newBgColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HSLPackage.SCANNER_TOKEN__BG_COLOR, null, msgs);
      msgs = basicSetBgColor(newBgColor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_TOKEN__BG_COLOR, newBgColor, newBgColor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Font getFont()
  {
    return font;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFont(Font newFont, NotificationChain msgs)
  {
    Font oldFont = font;
    font = newFont;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_TOKEN__FONT, oldFont, newFont);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFont(Font newFont)
  {
    if (newFont != font)
    {
      NotificationChain msgs = null;
      if (font != null)
        msgs = ((InternalEObject)font).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HSLPackage.SCANNER_TOKEN__FONT, null, msgs);
      if (newFont != null)
        msgs = ((InternalEObject)newFont).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HSLPackage.SCANNER_TOKEN__FONT, null, msgs);
      msgs = basicSetFont(newFont, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HSLPackage.SCANNER_TOKEN__FONT, newFont, newFont));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case HSLPackage.SCANNER_TOKEN__FG_COLOR:
        return basicSetFgColor(null, msgs);
      case HSLPackage.SCANNER_TOKEN__BG_COLOR:
        return basicSetBgColor(null, msgs);
      case HSLPackage.SCANNER_TOKEN__FONT:
        return basicSetFont(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case HSLPackage.SCANNER_TOKEN__DEFAULT:
        return isDefault();
      case HSLPackage.SCANNER_TOKEN__NAME:
        return getName();
      case HSLPackage.SCANNER_TOKEN__FG_COLOR:
        return getFgColor();
      case HSLPackage.SCANNER_TOKEN__BG_COLOR:
        return getBgColor();
      case HSLPackage.SCANNER_TOKEN__FONT:
        return getFont();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case HSLPackage.SCANNER_TOKEN__DEFAULT:
        setDefault((Boolean)newValue);
        return;
      case HSLPackage.SCANNER_TOKEN__NAME:
        setName((String)newValue);
        return;
      case HSLPackage.SCANNER_TOKEN__FG_COLOR:
        setFgColor((Color)newValue);
        return;
      case HSLPackage.SCANNER_TOKEN__BG_COLOR:
        setBgColor((Color)newValue);
        return;
      case HSLPackage.SCANNER_TOKEN__FONT:
        setFont((Font)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case HSLPackage.SCANNER_TOKEN__DEFAULT:
        setDefault(DEFAULT_EDEFAULT);
        return;
      case HSLPackage.SCANNER_TOKEN__NAME:
        setName(NAME_EDEFAULT);
        return;
      case HSLPackage.SCANNER_TOKEN__FG_COLOR:
        setFgColor((Color)null);
        return;
      case HSLPackage.SCANNER_TOKEN__BG_COLOR:
        setBgColor((Color)null);
        return;
      case HSLPackage.SCANNER_TOKEN__FONT:
        setFont((Font)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case HSLPackage.SCANNER_TOKEN__DEFAULT:
        return default_ != DEFAULT_EDEFAULT;
      case HSLPackage.SCANNER_TOKEN__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case HSLPackage.SCANNER_TOKEN__FG_COLOR:
        return fgColor != null;
      case HSLPackage.SCANNER_TOKEN__BG_COLOR:
        return bgColor != null;
      case HSLPackage.SCANNER_TOKEN__FONT:
        return font != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (default: ");
    result.append(default_);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ScannerTokenImpl
