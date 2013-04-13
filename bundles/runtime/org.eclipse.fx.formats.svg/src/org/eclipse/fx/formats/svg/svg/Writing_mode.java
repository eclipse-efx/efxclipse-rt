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
 * A representation of the literals of the enumeration '<em><b>Writing mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getWriting_mode()
 * @model
 * @generated
 */
public enum Writing_mode implements Enumerator {
	/**
	 * The '<em><b>Lr tb</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LR_TB_VALUE
	 * @generated
	 * @ordered
	 */
	LR_TB(0, "lr_tb", "lr-tb"),

	/**
	 * The '<em><b>Rl tb</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RL_TB_VALUE
	 * @generated
	 * @ordered
	 */
	RL_TB(1, "rl_tb", "rl-tb"),

	/**
	 * The '<em><b>Tb rl</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TB_RL_VALUE
	 * @generated
	 * @ordered
	 */
	TB_RL(2, "tb_rl", "tb-rl"),

	/**
	 * The '<em><b>Lr</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LR_VALUE
	 * @generated
	 * @ordered
	 */
	LR(3, "lr", "lr"),

	/**
	 * The '<em><b>Rl</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RL_VALUE
	 * @generated
	 * @ordered
	 */
	RL(4, "rl", "rl"),

	/**
	 * The '<em><b>Tb</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TB_VALUE
	 * @generated
	 * @ordered
	 */
	TB(5, "tb", "tb"),

	/**
	 * The '<em><b>Inherit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INHERIT_VALUE
	 * @generated
	 * @ordered
	 */
	INHERIT(6, "inherit", "inherit");

	/**
	 * The '<em><b>Lr tb</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lr tb</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LR_TB
	 * @model name="lr_tb" literal="lr-tb"
	 * @generated
	 * @ordered
	 */
	public static final int LR_TB_VALUE = 0;

	/**
	 * The '<em><b>Rl tb</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Rl tb</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RL_TB
	 * @model name="rl_tb" literal="rl-tb"
	 * @generated
	 * @ordered
	 */
	public static final int RL_TB_VALUE = 1;

	/**
	 * The '<em><b>Tb rl</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Tb rl</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TB_RL
	 * @model name="tb_rl" literal="tb-rl"
	 * @generated
	 * @ordered
	 */
	public static final int TB_RL_VALUE = 2;

	/**
	 * The '<em><b>Lr</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lr</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LR
	 * @model name="lr"
	 * @generated
	 * @ordered
	 */
	public static final int LR_VALUE = 3;

	/**
	 * The '<em><b>Rl</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Rl</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RL
	 * @model name="rl"
	 * @generated
	 * @ordered
	 */
	public static final int RL_VALUE = 4;

	/**
	 * The '<em><b>Tb</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Tb</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TB
	 * @model name="tb"
	 * @generated
	 * @ordered
	 */
	public static final int TB_VALUE = 5;

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
	public static final int INHERIT_VALUE = 6;

	/**
	 * An array of all the '<em><b>Writing mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Writing_mode[] VALUES_ARRAY =
		new Writing_mode[] {
			LR_TB,
			RL_TB,
			TB_RL,
			LR,
			RL,
			TB,
			INHERIT,
		};

	/**
	 * A public read-only list of all the '<em><b>Writing mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Writing_mode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Writing mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Writing_mode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Writing_mode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Writing mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Writing_mode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Writing_mode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Writing mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Writing_mode get(int value) {
		switch (value) {
			case LR_TB_VALUE: return LR_TB;
			case RL_TB_VALUE: return RL_TB;
			case TB_RL_VALUE: return TB_RL;
			case LR_VALUE: return LR;
			case RL_VALUE: return RL;
			case TB_VALUE: return TB;
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
	private Writing_mode(int value, String name, String literal) {
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
	
} //Writing_mode
