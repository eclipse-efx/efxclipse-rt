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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Rendering intent</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getRendering_intent()
 * @model
 * @generated
 */
public enum Rendering_intent implements Enumerator {
	/**
	 * The '<em><b>Auto</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTO_VALUE
	 * @generated
	 * @ordered
	 */
	AUTO(0, "auto", "auto"),

	/**
	 * The '<em><b>Perceptual</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PERCEPTUAL_VALUE
	 * @generated
	 * @ordered
	 */
	PERCEPTUAL(1, "perceptual", "perceptual"),

	/**
	 * The '<em><b>Relative colorimetric</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELATIVE_COLORIMETRIC_VALUE
	 * @generated
	 * @ordered
	 */
	RELATIVE_COLORIMETRIC(2, "relative_colorimetric", "relative-colorimetric"),

	/**
	 * The '<em><b>Saturation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SATURATION_VALUE
	 * @generated
	 * @ordered
	 */
	SATURATION(3, "saturation", "saturation"),

	/**
	 * The '<em><b>Absolute colorimetric</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABSOLUTE_COLORIMETRIC_VALUE
	 * @generated
	 * @ordered
	 */
	ABSOLUTE_COLORIMETRIC(4, "absolute_colorimetric", "absolute-colorimetric");

	/**
	 * The '<em><b>Auto</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Auto</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUTO
	 * @model name="auto"
	 * @generated
	 * @ordered
	 */
	public static final int AUTO_VALUE = 0;

	/**
	 * The '<em><b>Perceptual</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Perceptual</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PERCEPTUAL
	 * @model name="perceptual"
	 * @generated
	 * @ordered
	 */
	public static final int PERCEPTUAL_VALUE = 1;

	/**
	 * The '<em><b>Relative colorimetric</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Relative colorimetric</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RELATIVE_COLORIMETRIC
	 * @model name="relative_colorimetric" literal="relative-colorimetric"
	 * @generated
	 * @ordered
	 */
	public static final int RELATIVE_COLORIMETRIC_VALUE = 2;

	/**
	 * The '<em><b>Saturation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Saturation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SATURATION
	 * @model name="saturation"
	 * @generated
	 * @ordered
	 */
	public static final int SATURATION_VALUE = 3;

	/**
	 * The '<em><b>Absolute colorimetric</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Absolute colorimetric</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ABSOLUTE_COLORIMETRIC
	 * @model name="absolute_colorimetric" literal="absolute-colorimetric"
	 * @generated
	 * @ordered
	 */
	public static final int ABSOLUTE_COLORIMETRIC_VALUE = 4;

	/**
	 * An array of all the '<em><b>Rendering intent</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Rendering_intent[] VALUES_ARRAY =
		new Rendering_intent[] {
			AUTO,
			PERCEPTUAL,
			RELATIVE_COLORIMETRIC,
			SATURATION,
			ABSOLUTE_COLORIMETRIC,
		};

	/**
	 * A public read-only list of all the '<em><b>Rendering intent</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Rendering_intent> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Rendering intent</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Rendering_intent get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Rendering_intent result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Rendering intent</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Rendering_intent getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Rendering_intent result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Rendering intent</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Rendering_intent get(int value) {
		switch (value) {
			case AUTO_VALUE: return AUTO;
			case PERCEPTUAL_VALUE: return PERCEPTUAL;
			case RELATIVE_COLORIMETRIC_VALUE: return RELATIVE_COLORIMETRIC;
			case SATURATION_VALUE: return SATURATION;
			case ABSOLUTE_COLORIMETRIC_VALUE: return ABSOLUTE_COLORIMETRIC;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Rendering_intent(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Rendering_intent
