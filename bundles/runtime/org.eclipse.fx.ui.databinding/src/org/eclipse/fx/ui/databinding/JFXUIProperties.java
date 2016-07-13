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
package org.eclipse.fx.ui.databinding;

import java.time.LocalDate;

import org.eclipse.fx.ui.databinding.internal.DateValueProperty;
import org.eclipse.fx.ui.databinding.internal.SingleSelectionProperty;
import org.eclipse.fx.ui.databinding.internal.TextValueProperty;
import org.eclipse.jdt.annotation.NonNull;

import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;

/**
 * Factory to create JavaFX properties
 */
public class JFXUIProperties {
	/**
	 * Create a single selection property for javafx views
	 * <ul>
	 * <li>{@link ListView}</li>
	 * <li>{@link ComboBox}</li>
	 * <li>{@link TableView}</li>
	 * <li>{@link TreeView}</li>
	 * <li>{@link TreeTableView}</li>
	 * </ul>
	 *
	 * @return the property
	 */
	@NonNull
	public static <@NonNull S,T> IJFXControlValueProperty<S,T> singleViewSelection() {
		return new SingleSelectionProperty<>();
	}

	/**
	 * @return single selection property for {@link ListView}
	 * @since 3.0.0
	 */
	@NonNull
	public static <T> IJFXControlValueProperty<ListView<T>,T> singleListViewSelection() {
		return new SingleSelectionProperty<>();
	}

	/**
	 * @return single selection property for {@link ComboBox}
	 * @since 3.0.0
	 */
	@NonNull
	public static <T> IJFXControlValueProperty<ComboBox<T>,T> singleComboBoxSelection() {
		return new SingleSelectionProperty<>();
	}

	/**
	 * @return single selection property for {@link TreeView}
	 * @since 3.0.0
	 */
	@NonNull
	public static <T> IJFXControlValueProperty<TreeTableView<T>,T> singleTreeTableViewSelection() {
		return new SingleSelectionProperty<>();
	}

	/**
	 * @return single selection property for {@link TreeView}
	 * @since 3.0.0
	 */
	@NonNull
	public static <T> IJFXControlValueProperty<TreeView<T>,T> singleTreeViewSelection() {
		return new SingleSelectionProperty<>();
	}

	/**
	 * Create a property for the text-property of a javafx bean
	 *
	 * @return the text property
	 * @since 2.4.0
	 */
	@NonNull
	public static <@NonNull S> IJFXControlValueProperty<S,String> text() {
		return new TextValueProperty<>();
	}

	/**
	 * @return text property for a {@link TextInputControl}
	 * @since 3.0.0
	 */
	@NonNull
	public static IJFXControlValueProperty<TextInputControl,String> textInputText() {
		return new TextValueProperty<>();
	}

	/**
	 * @return text property of a {@link ComboBox#editorProperty()}
	 * @since 3.0.0
	 */
	@NonNull
	public static IJFXControlValueProperty<ComboBox<?>,String> comboBoxText() {
		return new TextValueProperty<>();
	}

	/**
	 * @return text property of a {@link Cell}
	 * @since 3.0.0
	 */
	@NonNull
	public static IJFXControlValueProperty<Cell<?>,String> cellText() {
		return new TextValueProperty<>();
	}

	/**
	 * @return text property of a {@link Tab}
	 * @since 3.0.0
	 */
	@NonNull
	public static IJFXControlValueProperty<Tab,String> tabText() {
		return new TextValueProperty<>();
	}

	/**
	 * Create a date property of the {@link DatePicker}
	 *
	 * @return the property
	 */
	@NonNull
	public static <@NonNull S> IJFXControlValueProperty<S,LocalDate> date() {
		return new DateValueProperty<>();
	}

	/**
	 * @return date property of a {@link DatePicker}
	 * @since 3.0.0
	 */
	@NonNull
	public static IJFXControlValueProperty<DatePicker,LocalDate> datePickerDate() {
		return new DateValueProperty<>();
	}
}
