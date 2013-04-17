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
 * A representation of the literals of the enumeration '<em><b>Pointer events</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getPointer_events()
 * @model
 * @generated
 */
public enum Pointer_events implements Enumerator {
	/**
	 * The '<em><b>Visible Painted</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VISIBLE_PAINTED_VALUE
	 * @generated
	 * @ordered
	 */
	VISIBLE_PAINTED(0, "visiblePainted", "visiblePainted"),

	/**
	 * The '<em><b>Visible Fill</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VISIBLE_FILL_VALUE
	 * @generated
	 * @ordered
	 */
	VISIBLE_FILL(1, "visibleFill", "visibleFill"),

	/**
	 * The '<em><b>Visible Stroke</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VISIBLE_STROKE_VALUE
	 * @generated
	 * @ordered
	 */
	VISIBLE_STROKE(2, "visibleStroke", "visibleStroke"),

	/**
	 * The '<em><b>Visible</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VISIBLE_VALUE
	 * @generated
	 * @ordered
	 */
	VISIBLE(3, "visible", "visible"),

	/**
	 * The '<em><b>Painted</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PAINTED_VALUE
	 * @generated
	 * @ordered
	 */
	PAINTED(4, "painted", "painted"),

	/**
	 * The '<em><b>Fill</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILL_VALUE
	 * @generated
	 * @ordered
	 */
	FILL(5, "fill", "fill"),

	/**
	 * The '<em><b>Stroke</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STROKE_VALUE
	 * @generated
	 * @ordered
	 */
	STROKE(6, "stroke", "stroke"),

	/**
	 * The '<em><b>All</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_VALUE
	 * @generated
	 * @ordered
	 */
	ALL(7, "all", "all"),

	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(8, "none", "none"),

	/**
	 * The '<em><b>Inherit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INHERIT_VALUE
	 * @generated
	 * @ordered
	 */
	INHERIT(9, "inherit", "inherit");

	/**
	 * The '<em><b>Visible Painted</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Visible Painted</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VISIBLE_PAINTED
	 * @model name="visiblePainted"
	 * @generated
	 * @ordered
	 */
	public static final int VISIBLE_PAINTED_VALUE = 0;

	/**
	 * The '<em><b>Visible Fill</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Visible Fill</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VISIBLE_FILL
	 * @model name="visibleFill"
	 * @generated
	 * @ordered
	 */
	public static final int VISIBLE_FILL_VALUE = 1;

	/**
	 * The '<em><b>Visible Stroke</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Visible Stroke</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VISIBLE_STROKE
	 * @model name="visibleStroke"
	 * @generated
	 * @ordered
	 */
	public static final int VISIBLE_STROKE_VALUE = 2;

	/**
	 * The '<em><b>Visible</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Visible</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VISIBLE
	 * @model name="visible"
	 * @generated
	 * @ordered
	 */
	public static final int VISIBLE_VALUE = 3;

	/**
	 * The '<em><b>Painted</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Painted</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PAINTED
	 * @model name="painted"
	 * @generated
	 * @ordered
	 */
	public static final int PAINTED_VALUE = 4;

	/**
	 * The '<em><b>Fill</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fill</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILL
	 * @model name="fill"
	 * @generated
	 * @ordered
	 */
	public static final int FILL_VALUE = 5;

	/**
	 * The '<em><b>Stroke</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Stroke</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STROKE
	 * @model name="stroke"
	 * @generated
	 * @ordered
	 */
	public static final int STROKE_VALUE = 6;

	/**
	 * The '<em><b>All</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>All</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALL
	 * @model name="all"
	 * @generated
	 * @ordered
	 */
	public static final int ALL_VALUE = 7;

	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>None</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model name="none"
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 8;

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
	public static final int INHERIT_VALUE = 9;

	/**
	 * An array of all the '<em><b>Pointer events</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Pointer_events[] VALUES_ARRAY =
		new Pointer_events[] {
			VISIBLE_PAINTED,
			VISIBLE_FILL,
			VISIBLE_STROKE,
			VISIBLE,
			PAINTED,
			FILL,
			STROKE,
			ALL,
			NONE,
			INHERIT,
		};

	/**
	 * A public read-only list of all the '<em><b>Pointer events</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Pointer_events> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Pointer events</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Pointer_events get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Pointer_events result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Pointer events</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Pointer_events getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Pointer_events result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Pointer events</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Pointer_events get(int value) {
		switch (value) {
			case VISIBLE_PAINTED_VALUE: return VISIBLE_PAINTED;
			case VISIBLE_FILL_VALUE: return VISIBLE_FILL;
			case VISIBLE_STROKE_VALUE: return VISIBLE_STROKE;
			case VISIBLE_VALUE: return VISIBLE;
			case PAINTED_VALUE: return PAINTED;
			case FILL_VALUE: return FILL;
			case STROKE_VALUE: return STROKE;
			case ALL_VALUE: return ALL;
			case NONE_VALUE: return NONE;
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
	private Pointer_events(int value, String name, String literal) {
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
	
} //Pointer_events
