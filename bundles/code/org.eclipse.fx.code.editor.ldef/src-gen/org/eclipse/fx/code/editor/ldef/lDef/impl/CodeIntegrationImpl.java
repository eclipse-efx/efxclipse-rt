/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.fx.code.editor.ldef.lDef.CodeIntegration;
import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Integration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.CodeIntegrationImpl#isCodegen <em>Codegen</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.CodeIntegrationImpl#isE4 <em>E4</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CodeIntegrationImpl extends MinimalEObjectImpl.Container implements CodeIntegration
{
  /**
   * The default value of the '{@link #isCodegen() <em>Codegen</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCodegen()
   * @generated
   * @ordered
   */
  protected static final boolean CODEGEN_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCodegen() <em>Codegen</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCodegen()
   * @generated
   * @ordered
   */
  protected boolean codegen = CODEGEN_EDEFAULT;

  /**
   * The default value of the '{@link #isE4() <em>E4</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isE4()
   * @generated
   * @ordered
   */
  protected static final boolean E4_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isE4() <em>E4</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isE4()
   * @generated
   * @ordered
   */
  protected boolean e4 = E4_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CodeIntegrationImpl()
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
    return LDefPackage.Literals.CODE_INTEGRATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCodegen()
  {
    return codegen;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCodegen(boolean newCodegen)
  {
    boolean oldCodegen = codegen;
    codegen = newCodegen;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.CODE_INTEGRATION__CODEGEN, oldCodegen, codegen));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isE4()
  {
    return e4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setE4(boolean newE4)
  {
    boolean oldE4 = e4;
    e4 = newE4;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.CODE_INTEGRATION__E4, oldE4, e4));
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
      case LDefPackage.CODE_INTEGRATION__CODEGEN:
        return isCodegen();
      case LDefPackage.CODE_INTEGRATION__E4:
        return isE4();
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
      case LDefPackage.CODE_INTEGRATION__CODEGEN:
        setCodegen((Boolean)newValue);
        return;
      case LDefPackage.CODE_INTEGRATION__E4:
        setE4((Boolean)newValue);
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
      case LDefPackage.CODE_INTEGRATION__CODEGEN:
        setCodegen(CODEGEN_EDEFAULT);
        return;
      case LDefPackage.CODE_INTEGRATION__E4:
        setE4(E4_EDEFAULT);
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
      case LDefPackage.CODE_INTEGRATION__CODEGEN:
        return codegen != CODEGEN_EDEFAULT;
      case LDefPackage.CODE_INTEGRATION__E4:
        return e4 != E4_EDEFAULT;
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
    result.append(" (codegen: ");
    result.append(codegen);
    result.append(", e4: ");
    result.append(e4);
    result.append(')');
    return result.toString();
  }

} //CodeIntegrationImpl
