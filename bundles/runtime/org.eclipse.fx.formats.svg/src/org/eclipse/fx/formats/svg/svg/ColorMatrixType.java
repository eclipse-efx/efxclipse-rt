/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.fx.formats.svg.svg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Color Matrix Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getColorMatrixType()
 * @model
 * @generated
 */
public enum ColorMatrixType implements Enumerator {
	/**
	 * The '<em><b>Matrix</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATRIX_VALUE
	 * @generated
	 * @ordered
	 */
	MATRIX(0, "matrix", "matrix"),

	/**
	 * The '<em><b>Saturate</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SATURATE_VALUE
	 * @generated
	 * @ordered
	 */
	SATURATE(1, "saturate", "saturate"),

	/**
	 * The '<em><b>Hue Rotate</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HUE_ROTATE_VALUE
	 * @generated
	 * @ordered
	 */
	HUE_ROTATE(2, "hueRotate", "hueRotate"),

	/**
	 * The '<em><b>Luminance To Alpha</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUMINANCE_TO_ALPHA_VALUE
	 * @generated
	 * @ordered
	 */
	LUMINANCE_TO_ALPHA(3, "luminanceToAlpha", "luminanceToAlpha");

	/**
	 * The '<em><b>Matrix</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Matrix</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MATRIX
	 * @model name="matrix"
	 * @generated
	 * @ordered
	 */
	public static final int MATRIX_VALUE = 0;

	/**
	 * The '<em><b>Saturate</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Saturate</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SATURATE
	 * @model name="saturate"
	 * @generated
	 * @ordered
	 */
	public static final int SATURATE_VALUE = 1;

	/**
	 * The '<em><b>Hue Rotate</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hue Rotate</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HUE_ROTATE
	 * @model name="hueRotate"
	 * @generated
	 * @ordered
	 */
	public static final int HUE_ROTATE_VALUE = 2;

	/**
	 * The '<em><b>Luminance To Alpha</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Luminance To Alpha</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUMINANCE_TO_ALPHA
	 * @model name="luminanceToAlpha"
	 * @generated
	 * @ordered
	 */
	public static final int LUMINANCE_TO_ALPHA_VALUE = 3;

	/**
	 * An array of all the '<em><b>Color Matrix Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ColorMatrixType[] VALUES_ARRAY =
		new ColorMatrixType[] {
			MATRIX,
			SATURATE,
			HUE_ROTATE,
			LUMINANCE_TO_ALPHA,
		};

	/**
	 * A public read-only list of all the '<em><b>Color Matrix Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ColorMatrixType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Color Matrix Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ColorMatrixType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ColorMatrixType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Color Matrix Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ColorMatrixType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ColorMatrixType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Color Matrix Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ColorMatrixType get(int value) {
		switch (value) {
			case MATRIX_VALUE: return MATRIX;
			case SATURATE_VALUE: return SATURATE;
			case HUE_ROTATE_VALUE: return HUE_ROTATE;
			case LUMINANCE_TO_ALPHA_VALUE: return LUMINANCE_TO_ALPHA;
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
	private ColorMatrixType(int value, String name, String literal) {
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
	
} //ColorMatrixType
