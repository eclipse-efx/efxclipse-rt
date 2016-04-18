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

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;

import org.eclipse.fx.core.databinding.IJFXBeanValueProperty;
import org.eclipse.fx.core.databinding.JFXBeanProperties;
import org.eclipse.fx.ui.databinding.internal.DatePickerValueProperty;
import org.eclipse.fx.ui.databinding.internal.SingleSelectionProperty;
import org.eclipse.fx.ui.databinding.internal.TextValueProperty;
import org.eclipse.jdt.annotation.NonNull;

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
	public static IJFXControlValueProperty singleViewSelection() {
		return new SingleSelectionProperty();
	}

	/**
	 * Create a property for the text-property of a javafx bean
	 *
	 * @return the text property
	 * @deprecated use {@link #text2()}
	 */
	@NonNull
	@Deprecated
	public static IJFXBeanValueProperty text() {
		return JFXBeanProperties.value("text"); //$NON-NLS-1$
	}

	/**
	 * Create a property for the text-property of a javafx bean
	 *
	 * @return the text property
	 * @since 2.4.0
	 */
	@NonNull
	public static IJFXControlValueProperty text2() {
		return new TextValueProperty();
	}

	/**
	 * Create a date property of the {@link DatePicker}
	 *
	 * @return the property
	 */
	@NonNull
	public static IJFXControlValueProperty date() {
		return new DatePickerValueProperty();
	}
}
