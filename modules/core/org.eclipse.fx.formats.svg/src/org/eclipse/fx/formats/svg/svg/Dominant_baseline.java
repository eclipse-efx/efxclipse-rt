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
 * A representation of the literals of the enumeration '<em><b>Dominant baseline</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getDominant_baseline()
 * @model
 * @generated
 */
public enum Dominant_baseline implements Enumerator {
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
	 * The '<em><b>Use script</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USE_SCRIPT_VALUE
	 * @generated
	 * @ordered
	 */
	USE_SCRIPT(1, "use_script", "use-script"),

	/**
	 * The '<em><b>No change</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_CHANGE_VALUE
	 * @generated
	 * @ordered
	 */
	NO_CHANGE(2, "no_change", "no-change"),

	/**
	 * The '<em><b>Reset size</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESET_SIZE_VALUE
	 * @generated
	 * @ordered
	 */
	RESET_SIZE(3, "reset_size", "reset-size"),

	/**
	 * The '<em><b>Ideographic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IDEOGRAPHIC_VALUE
	 * @generated
	 * @ordered
	 */
	IDEOGRAPHIC(4, "ideographic", "ideographic"),

	/**
	 * The '<em><b>Alphabetic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALPHABETIC_VALUE
	 * @generated
	 * @ordered
	 */
	ALPHABETIC(5, "alphabetic", "alphabetic"),

	/**
	 * The '<em><b>Hanging</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HANGING_VALUE
	 * @generated
	 * @ordered
	 */
	HANGING(6, "hanging", "hanging"),

	/**
	 * The '<em><b>Mathematical</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATHEMATICAL_VALUE
	 * @generated
	 * @ordered
	 */
	MATHEMATICAL(7, "mathematical", "mathematical"),

	/**
	 * The '<em><b>Central</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTRAL_VALUE
	 * @generated
	 * @ordered
	 */
	CENTRAL(8, "central", "central"),

	/**
	 * The '<em><b>Middle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIDDLE_VALUE
	 * @generated
	 * @ordered
	 */
	MIDDLE(9, "middle", "middle"),

	/**
	 * The '<em><b>Text after edge</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT_AFTER_EDGE_VALUE
	 * @generated
	 * @ordered
	 */
	TEXT_AFTER_EDGE(10, "text_after_edge", "text-after-edge"),

	/**
	 * The '<em><b>Text before edge</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT_BEFORE_EDGE_VALUE
	 * @generated
	 * @ordered
	 */
	TEXT_BEFORE_EDGE(11, "text_before_edge", "text-before-edge"),

	/**
	 * The '<em><b>Inherit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INHERIT_VALUE
	 * @generated
	 * @ordered
	 */
	INHERIT(12, "inherit", "inherit");

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
	 * The '<em><b>Use script</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Use script</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USE_SCRIPT
	 * @model name="use_script" literal="use-script"
	 * @generated
	 * @ordered
	 */
	public static final int USE_SCRIPT_VALUE = 1;

	/**
	 * The '<em><b>No change</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>No change</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NO_CHANGE
	 * @model name="no_change" literal="no-change"
	 * @generated
	 * @ordered
	 */
	public static final int NO_CHANGE_VALUE = 2;

	/**
	 * The '<em><b>Reset size</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Reset size</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESET_SIZE
	 * @model name="reset_size" literal="reset-size"
	 * @generated
	 * @ordered
	 */
	public static final int RESET_SIZE_VALUE = 3;

	/**
	 * The '<em><b>Ideographic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ideographic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IDEOGRAPHIC
	 * @model name="ideographic"
	 * @generated
	 * @ordered
	 */
	public static final int IDEOGRAPHIC_VALUE = 4;

	/**
	 * The '<em><b>Alphabetic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Alphabetic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALPHABETIC
	 * @model name="alphabetic"
	 * @generated
	 * @ordered
	 */
	public static final int ALPHABETIC_VALUE = 5;

	/**
	 * The '<em><b>Hanging</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hanging</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HANGING
	 * @model name="hanging"
	 * @generated
	 * @ordered
	 */
	public static final int HANGING_VALUE = 6;

	/**
	 * The '<em><b>Mathematical</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mathematical</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MATHEMATICAL
	 * @model name="mathematical"
	 * @generated
	 * @ordered
	 */
	public static final int MATHEMATICAL_VALUE = 7;

	/**
	 * The '<em><b>Central</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Central</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CENTRAL
	 * @model name="central"
	 * @generated
	 * @ordered
	 */
	public static final int CENTRAL_VALUE = 8;

	/**
	 * The '<em><b>Middle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Middle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MIDDLE
	 * @model name="middle"
	 * @generated
	 * @ordered
	 */
	public static final int MIDDLE_VALUE = 9;

	/**
	 * The '<em><b>Text after edge</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Text after edge</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEXT_AFTER_EDGE
	 * @model name="text_after_edge" literal="text-after-edge"
	 * @generated
	 * @ordered
	 */
	public static final int TEXT_AFTER_EDGE_VALUE = 10;

	/**
	 * The '<em><b>Text before edge</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Text before edge</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEXT_BEFORE_EDGE
	 * @model name="text_before_edge" literal="text-before-edge"
	 * @generated
	 * @ordered
	 */
	public static final int TEXT_BEFORE_EDGE_VALUE = 11;

	/**
	 * The '<em><b>Inherit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inherit</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INHERIT
	 * @model name="inherit"
	 * @generated
	 * @ordered
	 */
	public static final int INHERIT_VALUE = 12;

	/**
	 * An array of all the '<em><b>Dominant baseline</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Dominant_baseline[] VALUES_ARRAY =
		new Dominant_baseline[] {
			AUTO,
			USE_SCRIPT,
			NO_CHANGE,
			RESET_SIZE,
			IDEOGRAPHIC,
			ALPHABETIC,
			HANGING,
			MATHEMATICAL,
			CENTRAL,
			MIDDLE,
			TEXT_AFTER_EDGE,
			TEXT_BEFORE_EDGE,
			INHERIT,
		};

	/**
	 * A public read-only list of all the '<em><b>Dominant baseline</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Dominant_baseline> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Dominant baseline</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Dominant_baseline get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Dominant_baseline result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Dominant baseline</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Dominant_baseline getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Dominant_baseline result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Dominant baseline</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Dominant_baseline get(int value) {
		switch (value) {
			case AUTO_VALUE: return AUTO;
			case USE_SCRIPT_VALUE: return USE_SCRIPT;
			case NO_CHANGE_VALUE: return NO_CHANGE;
			case RESET_SIZE_VALUE: return RESET_SIZE;
			case IDEOGRAPHIC_VALUE: return IDEOGRAPHIC;
			case ALPHABETIC_VALUE: return ALPHABETIC;
			case HANGING_VALUE: return HANGING;
			case MATHEMATICAL_VALUE: return MATHEMATICAL;
			case CENTRAL_VALUE: return CENTRAL;
			case MIDDLE_VALUE: return MIDDLE;
			case TEXT_AFTER_EDGE_VALUE: return TEXT_AFTER_EDGE;
			case TEXT_BEFORE_EDGE_VALUE: return TEXT_BEFORE_EDGE;
			case INHERIT_VALUE: return INHERIT;
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
	private Dominant_baseline(int value, String name, String literal) {
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
	
} //Dominant_baseline
