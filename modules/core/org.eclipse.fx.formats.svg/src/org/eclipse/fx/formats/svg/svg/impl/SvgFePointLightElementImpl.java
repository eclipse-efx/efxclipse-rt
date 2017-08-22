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
package org.eclipse.fx.formats.svg.svg.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.fx.formats.svg.svg.ContentElement;
import org.eclipse.fx.formats.svg.svg.CoreAttributes;
import org.eclipse.fx.formats.svg.svg.LightSourceElement;
import org.eclipse.fx.formats.svg.svg.SvgElement;
import org.eclipse.fx.formats.svg.svg.SvgFePointLightElement;
import org.eclipse.fx.formats.svg.svg.SvgPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fe Point Light Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.impl.SvgFePointLightElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.impl.SvgFePointLightElementImpl#getXml__base <em>Xml base</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.impl.SvgFePointLightElementImpl#getXml__lang <em>Xml lang</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.impl.SvgFePointLightElementImpl#getXml__space <em>Xml space</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.impl.SvgFePointLightElementImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.impl.SvgFePointLightElementImpl#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.impl.SvgFePointLightElementImpl#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.fx.formats.svg.svg.impl.SvgFePointLightElementImpl#getZ <em>Z</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SvgFePointLightElementImpl extends EObjectImpl implements SvgFePointLightElement {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getXml__base() <em>Xml base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXml__base()
	 * @generated
	 * @ordered
	 */
	protected static final String XML_BASE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXml__base() <em>Xml base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXml__base()
	 * @generated
	 * @ordered
	 */
	protected String xml__base = XML_BASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getXml__lang() <em>Xml lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXml__lang()
	 * @generated
	 * @ordered
	 */
	protected static final String XML_LANG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXml__lang() <em>Xml lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXml__lang()
	 * @generated
	 * @ordered
	 */
	protected String xml__lang = XML_LANG_EDEFAULT;

	/**
	 * The default value of the '{@link #getXml__space() <em>Xml space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXml__space()
	 * @generated
	 * @ordered
	 */
	protected static final String XML_SPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXml__space() <em>Xml space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXml__space()
	 * @generated
	 * @ordered
	 */
	protected String xml__space = XML_SPACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<SvgElement> children;

	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final Double X_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected Double x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final Double Y_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected Double y = Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getZ() <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZ()
	 * @generated
	 * @ordered
	 */
	protected static final Double Z_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getZ() <em>Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZ()
	 * @generated
	 * @ordered
	 */
	protected Double z = Z_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SvgFePointLightElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SvgPackage.Literals.SVG_FE_POINT_LIGHT_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXml__base() {
		return xml__base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXml__base(String newXml__base) {
		String oldXml__base = xml__base;
		xml__base = newXml__base;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_BASE, oldXml__base, xml__base));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXml__lang() {
		return xml__lang;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXml__lang(String newXml__lang) {
		String oldXml__lang = xml__lang;
		xml__lang = newXml__lang;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_LANG, oldXml__lang, xml__lang));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXml__space() {
		return xml__space;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXml__space(String newXml__space) {
		String oldXml__space = xml__space;
		xml__space = newXml__space;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_SPACE, oldXml__space, xml__space));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SvgElement> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<SvgElement>(SvgElement.class, this, SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(Double newX) {
		Double oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getY() {
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY(Double newY) {
		Double oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getZ() {
		return z;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZ(Double newZ) {
		Double oldZ = z;
		z = newZ;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__Z, oldZ, z));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__ID:
				return getId();
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_BASE:
				return getXml__base();
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_LANG:
				return getXml__lang();
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_SPACE:
				return getXml__space();
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__CHILDREN:
				return getChildren();
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__X:
				return getX();
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__Y:
				return getY();
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__Z:
				return getZ();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__ID:
				setId((String)newValue);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_BASE:
				setXml__base((String)newValue);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_LANG:
				setXml__lang((String)newValue);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_SPACE:
				setXml__space((String)newValue);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends SvgElement>)newValue);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__X:
				setX((Double)newValue);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__Y:
				setY((Double)newValue);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__Z:
				setZ((Double)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_BASE:
				setXml__base(XML_BASE_EDEFAULT);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_LANG:
				setXml__lang(XML_LANG_EDEFAULT);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_SPACE:
				setXml__space(XML_SPACE_EDEFAULT);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__CHILDREN:
				getChildren().clear();
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__X:
				setX(X_EDEFAULT);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__Y:
				setY(Y_EDEFAULT);
				return;
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__Z:
				setZ(Z_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_BASE:
				return XML_BASE_EDEFAULT == null ? xml__base != null : !XML_BASE_EDEFAULT.equals(xml__base);
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_LANG:
				return XML_LANG_EDEFAULT == null ? xml__lang != null : !XML_LANG_EDEFAULT.equals(xml__lang);
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_SPACE:
				return XML_SPACE_EDEFAULT == null ? xml__space != null : !XML_SPACE_EDEFAULT.equals(xml__space);
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__CHILDREN:
				return children != null && !children.isEmpty();
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__X:
				return X_EDEFAULT == null ? x != null : !X_EDEFAULT.equals(x);
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__Y:
				return Y_EDEFAULT == null ? y != null : !Y_EDEFAULT.equals(y);
			case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__Z:
				return Z_EDEFAULT == null ? z != null : !Z_EDEFAULT.equals(z);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CoreAttributes.class) {
			switch (derivedFeatureID) {
				case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__ID: return SvgPackage.CORE_ATTRIBUTES__ID;
				case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_BASE: return SvgPackage.CORE_ATTRIBUTES__XML_BASE;
				case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_LANG: return SvgPackage.CORE_ATTRIBUTES__XML_LANG;
				case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_SPACE: return SvgPackage.CORE_ATTRIBUTES__XML_SPACE;
				default: return -1;
			}
		}
		if (baseClass == LightSourceElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ContentElement.class) {
			switch (derivedFeatureID) {
				case SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__CHILDREN: return SvgPackage.CONTENT_ELEMENT__CHILDREN;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == CoreAttributes.class) {
			switch (baseFeatureID) {
				case SvgPackage.CORE_ATTRIBUTES__ID: return SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__ID;
				case SvgPackage.CORE_ATTRIBUTES__XML_BASE: return SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_BASE;
				case SvgPackage.CORE_ATTRIBUTES__XML_LANG: return SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_LANG;
				case SvgPackage.CORE_ATTRIBUTES__XML_SPACE: return SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__XML_SPACE;
				default: return -1;
			}
		}
		if (baseClass == LightSourceElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ContentElement.class) {
			switch (baseFeatureID) {
				case SvgPackage.CONTENT_ELEMENT__CHILDREN: return SvgPackage.SVG_FE_POINT_LIGHT_ELEMENT__CHILDREN;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", xml__base: ");
		result.append(xml__base);
		result.append(", xml__lang: ");
		result.append(xml__lang);
		result.append(", xml__space: ");
		result.append(xml__space);
		result.append(", x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(", z: ");
		result.append(z);
		result.append(')');
		return result.toString();
	}

} //SvgFePointLightElementImpl
