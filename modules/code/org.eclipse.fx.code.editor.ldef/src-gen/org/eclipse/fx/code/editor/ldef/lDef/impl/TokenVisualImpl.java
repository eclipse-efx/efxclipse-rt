/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.Token;
import org.eclipse.fx.code.editor.ldef.lDef.TokenVisual;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token Visual</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.TokenVisualImpl#getToken <em>Token</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.TokenVisualImpl#getColorSpec <em>Color Spec</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.TokenVisualImpl#isBold <em>Bold</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.TokenVisualImpl#isItalic <em>Italic</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TokenVisualImpl extends MinimalEObjectImpl.Container implements TokenVisual
{
  /**
   * The cached value of the '{@link #getToken() <em>Token</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getToken()
   * @generated
   * @ordered
   */
  protected Token token;

  /**
   * The default value of the '{@link #getColorSpec() <em>Color Spec</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColorSpec()
   * @generated
   * @ordered
   */
  protected static final String COLOR_SPEC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getColorSpec() <em>Color Spec</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getColorSpec()
   * @generated
   * @ordered
   */
  protected String colorSpec = COLOR_SPEC_EDEFAULT;

  /**
   * The default value of the '{@link #isBold() <em>Bold</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBold()
   * @generated
   * @ordered
   */
  protected static final boolean BOLD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isBold() <em>Bold</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isBold()
   * @generated
   * @ordered
   */
  protected boolean bold = BOLD_EDEFAULT;

  /**
   * The default value of the '{@link #isItalic() <em>Italic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isItalic()
   * @generated
   * @ordered
   */
  protected static final boolean ITALIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isItalic() <em>Italic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isItalic()
   * @generated
   * @ordered
   */
  protected boolean italic = ITALIC_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TokenVisualImpl()
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
    return LDefPackage.Literals.TOKEN_VISUAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Token getToken()
  {
    if (token != null && token.eIsProxy())
    {
      InternalEObject oldToken = (InternalEObject)token;
      token = (Token)eResolveProxy(oldToken);
      if (token != oldToken)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LDefPackage.TOKEN_VISUAL__TOKEN, oldToken, token));
      }
    }
    return token;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Token basicGetToken()
  {
    return token;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setToken(Token newToken)
  {
    Token oldToken = token;
    token = newToken;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.TOKEN_VISUAL__TOKEN, oldToken, token));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getColorSpec()
  {
    return colorSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setColorSpec(String newColorSpec)
  {
    String oldColorSpec = colorSpec;
    colorSpec = newColorSpec;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.TOKEN_VISUAL__COLOR_SPEC, oldColorSpec, colorSpec));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isBold()
  {
    return bold;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBold(boolean newBold)
  {
    boolean oldBold = bold;
    bold = newBold;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.TOKEN_VISUAL__BOLD, oldBold, bold));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isItalic()
  {
    return italic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setItalic(boolean newItalic)
  {
    boolean oldItalic = italic;
    italic = newItalic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.TOKEN_VISUAL__ITALIC, oldItalic, italic));
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
      case LDefPackage.TOKEN_VISUAL__TOKEN:
        if (resolve) return getToken();
        return basicGetToken();
      case LDefPackage.TOKEN_VISUAL__COLOR_SPEC:
        return getColorSpec();
      case LDefPackage.TOKEN_VISUAL__BOLD:
        return isBold();
      case LDefPackage.TOKEN_VISUAL__ITALIC:
        return isItalic();
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
      case LDefPackage.TOKEN_VISUAL__TOKEN:
        setToken((Token)newValue);
        return;
      case LDefPackage.TOKEN_VISUAL__COLOR_SPEC:
        setColorSpec((String)newValue);
        return;
      case LDefPackage.TOKEN_VISUAL__BOLD:
        setBold((Boolean)newValue);
        return;
      case LDefPackage.TOKEN_VISUAL__ITALIC:
        setItalic((Boolean)newValue);
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
      case LDefPackage.TOKEN_VISUAL__TOKEN:
        setToken((Token)null);
        return;
      case LDefPackage.TOKEN_VISUAL__COLOR_SPEC:
        setColorSpec(COLOR_SPEC_EDEFAULT);
        return;
      case LDefPackage.TOKEN_VISUAL__BOLD:
        setBold(BOLD_EDEFAULT);
        return;
      case LDefPackage.TOKEN_VISUAL__ITALIC:
        setItalic(ITALIC_EDEFAULT);
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
      case LDefPackage.TOKEN_VISUAL__TOKEN:
        return token != null;
      case LDefPackage.TOKEN_VISUAL__COLOR_SPEC:
        return COLOR_SPEC_EDEFAULT == null ? colorSpec != null : !COLOR_SPEC_EDEFAULT.equals(colorSpec);
      case LDefPackage.TOKEN_VISUAL__BOLD:
        return bold != BOLD_EDEFAULT;
      case LDefPackage.TOKEN_VISUAL__ITALIC:
        return italic != ITALIC_EDEFAULT;
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
    result.append(" (colorSpec: ");
    result.append(colorSpec);
    result.append(", bold: ");
    result.append(bold);
    result.append(", italic: ");
    result.append(italic);
    result.append(')');
    return result.toString();
  }

} //TokenVisualImpl
