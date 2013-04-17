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
 * A representation of the literals of the enumeration '<em><b>Display</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.fx.formats.svg.svg.SvgPackage#getDisplay()
 * @model
 * @generated
 */
public enum Display implements Enumerator {
	/**
	 * The '<em><b>Inline</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INLINE_VALUE
	 * @generated
	 * @ordered
	 */
	INLINE(0, "inline", "inline"),

	/**
	 * The '<em><b>Block</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOCK_VALUE
	 * @generated
	 * @ordered
	 */
	BLOCK(1, "block", "block"),

	/**
	 * The '<em><b>List item</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIST_ITEM_VALUE
	 * @generated
	 * @ordered
	 */
	LIST_ITEM(2, "list_item", "list-item"),

	/**
	 * The '<em><b>Run in</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUN_IN_VALUE
	 * @generated
	 * @ordered
	 */
	RUN_IN(3, "run_in", "run-in"),

	/**
	 * The '<em><b>Compact</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPACT_VALUE
	 * @generated
	 * @ordered
	 */
	COMPACT(4, "compact", "compact"),

	/**
	 * The '<em><b>Marker</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MARKER_VALUE
	 * @generated
	 * @ordered
	 */
	MARKER(5, "marker", "marker"),

	/**
	 * The '<em><b>Table</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TABLE_VALUE
	 * @generated
	 * @ordered
	 */
	TABLE(6, "table", "table"),

	/**
	 * The '<em><b>Inline table</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INLINE_TABLE_VALUE
	 * @generated
	 * @ordered
	 */
	INLINE_TABLE(7, "inline_table", "inline-table"),

	/**
	 * The '<em><b>Table row group</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TABLE_ROW_GROUP_VALUE
	 * @generated
	 * @ordered
	 */
	TABLE_ROW_GROUP(8, "table_row_group", "table-row-group"),

	/**
	 * The '<em><b>Table header group</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TABLE_HEADER_GROUP_VALUE
	 * @generated
	 * @ordered
	 */
	TABLE_HEADER_GROUP(9, "table_header_group", "table-header-group"),

	/**
	 * The '<em><b>Table footer group</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TABLE_FOOTER_GROUP_VALUE
	 * @generated
	 * @ordered
	 */
	TABLE_FOOTER_GROUP(10, "table_footer_group", "table-footer-group"),

	/**
	 * The '<em><b>Table row</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TABLE_ROW_VALUE
	 * @generated
	 * @ordered
	 */
	TABLE_ROW(11, "table_row", "table-row"),

	/**
	 * The '<em><b>Table column group</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TABLE_COLUMN_GROUP_VALUE
	 * @generated
	 * @ordered
	 */
	TABLE_COLUMN_GROUP(12, "table_column_group", "table-column-group"),

	/**
	 * The '<em><b>Table column</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TABLE_COLUMN_VALUE
	 * @generated
	 * @ordered
	 */
	TABLE_COLUMN(13, "table_column", "table-column"),

	/**
	 * The '<em><b>Table cell</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TABLE_CELL_VALUE
	 * @generated
	 * @ordered
	 */
	TABLE_CELL(14, "table_cell", "table-cell"),

	/**
	 * The '<em><b>Table caption</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TABLE_CAPTION_VALUE
	 * @generated
	 * @ordered
	 */
	TABLE_CAPTION(15, "table_caption", "table-caption"),

	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(16, "none", "none"),

	/**
	 * The '<em><b>Inherit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INHERIT_VALUE
	 * @generated
	 * @ordered
	 */
	INHERIT(17, "inherit", "inherit");

	/**
	 * The '<em><b>Inline</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inline</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INLINE
	 * @model name="inline"
	 * @generated
	 * @ordered
	 */
	public static final int INLINE_VALUE = 0;

	/**
	 * The '<em><b>Block</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Block</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLOCK
	 * @model name="block"
	 * @generated
	 * @ordered
	 */
	public static final int BLOCK_VALUE = 1;

	/**
	 * The '<em><b>List item</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>List item</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIST_ITEM
	 * @model name="list_item" literal="list-item"
	 * @generated
	 * @ordered
	 */
	public static final int LIST_ITEM_VALUE = 2;

	/**
	 * The '<em><b>Run in</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Run in</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUN_IN
	 * @model name="run_in" literal="run-in"
	 * @generated
	 * @ordered
	 */
	public static final int RUN_IN_VALUE = 3;

	/**
	 * The '<em><b>Compact</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Compact</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPACT
	 * @model name="compact"
	 * @generated
	 * @ordered
	 */
	public static final int COMPACT_VALUE = 4;

	/**
	 * The '<em><b>Marker</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Marker</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MARKER
	 * @model name="marker"
	 * @generated
	 * @ordered
	 */
	public static final int MARKER_VALUE = 5;

	/**
	 * The '<em><b>Table</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Table</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TABLE
	 * @model name="table"
	 * @generated
	 * @ordered
	 */
	public static final int TABLE_VALUE = 6;

	/**
	 * The '<em><b>Inline table</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inline table</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INLINE_TABLE
	 * @model name="inline_table" literal="inline-table"
	 * @generated
	 * @ordered
	 */
	public static final int INLINE_TABLE_VALUE = 7;

	/**
	 * The '<em><b>Table row group</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Table row group</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TABLE_ROW_GROUP
	 * @model name="table_row_group" literal="table-row-group"
	 * @generated
	 * @ordered
	 */
	public static final int TABLE_ROW_GROUP_VALUE = 8;

	/**
	 * The '<em><b>Table header group</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Table header group</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TABLE_HEADER_GROUP
	 * @model name="table_header_group" literal="table-header-group"
	 * @generated
	 * @ordered
	 */
	public static final int TABLE_HEADER_GROUP_VALUE = 9;

	/**
	 * The '<em><b>Table footer group</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Table footer group</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TABLE_FOOTER_GROUP
	 * @model name="table_footer_group" literal="table-footer-group"
	 * @generated
	 * @ordered
	 */
	public static final int TABLE_FOOTER_GROUP_VALUE = 10;

	/**
	 * The '<em><b>Table row</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Table row</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TABLE_ROW
	 * @model name="table_row" literal="table-row"
	 * @generated
	 * @ordered
	 */
	public static final int TABLE_ROW_VALUE = 11;

	/**
	 * The '<em><b>Table column group</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Table column group</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TABLE_COLUMN_GROUP
	 * @model name="table_column_group" literal="table-column-group"
	 * @generated
	 * @ordered
	 */
	public static final int TABLE_COLUMN_GROUP_VALUE = 12;

	/**
	 * The '<em><b>Table column</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Table column</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TABLE_COLUMN
	 * @model name="table_column" literal="table-column"
	 * @generated
	 * @ordered
	 */
	public static final int TABLE_COLUMN_VALUE = 13;

	/**
	 * The '<em><b>Table cell</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Table cell</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TABLE_CELL
	 * @model name="table_cell" literal="table-cell"
	 * @generated
	 * @ordered
	 */
	public static final int TABLE_CELL_VALUE = 14;

	/**
	 * The '<em><b>Table caption</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Table caption</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TABLE_CAPTION
	 * @model name="table_caption" literal="table-caption"
	 * @generated
	 * @ordered
	 */
	public static final int TABLE_CAPTION_VALUE = 15;

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
	public static final int NONE_VALUE = 16;

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
	public static final int INHERIT_VALUE = 17;

	/**
	 * An array of all the '<em><b>Display</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Display[] VALUES_ARRAY =
		new Display[] {
			INLINE,
			BLOCK,
			LIST_ITEM,
			RUN_IN,
			COMPACT,
			MARKER,
			TABLE,
			INLINE_TABLE,
			TABLE_ROW_GROUP,
			TABLE_HEADER_GROUP,
			TABLE_FOOTER_GROUP,
			TABLE_ROW,
			TABLE_COLUMN_GROUP,
			TABLE_COLUMN,
			TABLE_CELL,
			TABLE_CAPTION,
			NONE,
			INHERIT,
		};

	/**
	 * A public read-only list of all the '<em><b>Display</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Display> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Display</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Display get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Display result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Display</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Display getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Display result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Display</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Display get(int value) {
		switch (value) {
			case INLINE_VALUE: return INLINE;
			case BLOCK_VALUE: return BLOCK;
			case LIST_ITEM_VALUE: return LIST_ITEM;
			case RUN_IN_VALUE: return RUN_IN;
			case COMPACT_VALUE: return COMPACT;
			case MARKER_VALUE: return MARKER;
			case TABLE_VALUE: return TABLE;
			case INLINE_TABLE_VALUE: return INLINE_TABLE;
			case TABLE_ROW_GROUP_VALUE: return TABLE_ROW_GROUP;
			case TABLE_HEADER_GROUP_VALUE: return TABLE_HEADER_GROUP;
			case TABLE_FOOTER_GROUP_VALUE: return TABLE_FOOTER_GROUP;
			case TABLE_ROW_VALUE: return TABLE_ROW;
			case TABLE_COLUMN_GROUP_VALUE: return TABLE_COLUMN_GROUP;
			case TABLE_COLUMN_VALUE: return TABLE_COLUMN;
			case TABLE_CELL_VALUE: return TABLE_CELL;
			case TABLE_CAPTION_VALUE: return TABLE_CAPTION;
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
	private Display(int value, String name, String literal) {
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
	
} //Display
