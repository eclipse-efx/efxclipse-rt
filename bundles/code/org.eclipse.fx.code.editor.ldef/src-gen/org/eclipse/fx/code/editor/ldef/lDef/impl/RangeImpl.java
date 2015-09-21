/**
 */
package org.eclipse.fx.code.editor.ldef.lDef.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.fx.code.editor.ldef.lDef.LDefPackage;
import org.eclipse.fx.code.editor.ldef.lDef.Range;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.RangeImpl#getLtIncl <em>Lt Incl</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.RangeImpl#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.RangeImpl#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link org.eclipse.fx.code.editor.ldef.lDef.impl.RangeImpl#getGtIncl <em>Gt Incl</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RangeImpl extends CheckImpl implements Range
{
  /**
   * The default value of the '{@link #getLtIncl() <em>Lt Incl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLtIncl()
   * @generated
   * @ordered
   */
  protected static final String LT_INCL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLtIncl() <em>Lt Incl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLtIncl()
   * @generated
   * @ordered
   */
  protected String ltIncl = LT_INCL_EDEFAULT;

  /**
   * The cached value of the '{@link #getMinValue() <em>Min Value</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinValue()
   * @generated
   * @ordered
   */
  protected EList<Integer> minValue;

  /**
   * The cached value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxValue()
   * @generated
   * @ordered
   */
  protected EList<Integer> maxValue;

  /**
   * The default value of the '{@link #getGtIncl() <em>Gt Incl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGtIncl()
   * @generated
   * @ordered
   */
  protected static final String GT_INCL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGtIncl() <em>Gt Incl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGtIncl()
   * @generated
   * @ordered
   */
  protected String gtIncl = GT_INCL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RangeImpl()
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
    return LDefPackage.Literals.RANGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLtIncl()
  {
    return ltIncl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLtIncl(String newLtIncl)
  {
    String oldLtIncl = ltIncl;
    ltIncl = newLtIncl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.RANGE__LT_INCL, oldLtIncl, ltIncl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getMinValue()
  {
    if (minValue == null)
    {
      minValue = new EDataTypeEList<Integer>(Integer.class, this, LDefPackage.RANGE__MIN_VALUE);
    }
    return minValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getMaxValue()
  {
    if (maxValue == null)
    {
      maxValue = new EDataTypeEList<Integer>(Integer.class, this, LDefPackage.RANGE__MAX_VALUE);
    }
    return maxValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGtIncl()
  {
    return gtIncl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGtIncl(String newGtIncl)
  {
    String oldGtIncl = gtIncl;
    gtIncl = newGtIncl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LDefPackage.RANGE__GT_INCL, oldGtIncl, gtIncl));
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
      case LDefPackage.RANGE__LT_INCL:
        return getLtIncl();
      case LDefPackage.RANGE__MIN_VALUE:
        return getMinValue();
      case LDefPackage.RANGE__MAX_VALUE:
        return getMaxValue();
      case LDefPackage.RANGE__GT_INCL:
        return getGtIncl();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LDefPackage.RANGE__LT_INCL:
        setLtIncl((String)newValue);
        return;
      case LDefPackage.RANGE__MIN_VALUE:
        getMinValue().clear();
        getMinValue().addAll((Collection<? extends Integer>)newValue);
        return;
      case LDefPackage.RANGE__MAX_VALUE:
        getMaxValue().clear();
        getMaxValue().addAll((Collection<? extends Integer>)newValue);
        return;
      case LDefPackage.RANGE__GT_INCL:
        setGtIncl((String)newValue);
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
      case LDefPackage.RANGE__LT_INCL:
        setLtIncl(LT_INCL_EDEFAULT);
        return;
      case LDefPackage.RANGE__MIN_VALUE:
        getMinValue().clear();
        return;
      case LDefPackage.RANGE__MAX_VALUE:
        getMaxValue().clear();
        return;
      case LDefPackage.RANGE__GT_INCL:
        setGtIncl(GT_INCL_EDEFAULT);
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
      case LDefPackage.RANGE__LT_INCL:
        return LT_INCL_EDEFAULT == null ? ltIncl != null : !LT_INCL_EDEFAULT.equals(ltIncl);
      case LDefPackage.RANGE__MIN_VALUE:
        return minValue != null && !minValue.isEmpty();
      case LDefPackage.RANGE__MAX_VALUE:
        return maxValue != null && !maxValue.isEmpty();
      case LDefPackage.RANGE__GT_INCL:
        return GT_INCL_EDEFAULT == null ? gtIncl != null : !GT_INCL_EDEFAULT.equals(gtIncl);
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
    result.append(" (ltIncl: ");
    result.append(ltIncl);
    result.append(", minValue: ");
    result.append(minValue);
    result.append(", maxValue: ");
    result.append(maxValue);
    result.append(", gtIncl: ");
    result.append(gtIncl);
    result.append(')');
    return result.toString();
  }

} //RangeImpl
