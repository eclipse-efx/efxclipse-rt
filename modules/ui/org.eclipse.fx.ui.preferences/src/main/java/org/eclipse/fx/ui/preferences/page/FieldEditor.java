/*******************************************************************************
 * Copyright (c) 2018 BestSolution.at, EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *     Camille Letavernier <cletavernier@eclipsesource.com>
 *******************************************************************************/
package org.eclipse.fx.ui.preferences.page;

import org.eclipse.fx.core.Memento;

import javafx.beans.binding.StringExpression;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Region;

public abstract class FieldEditor extends Region {
	private StringProperty label = new SimpleStringProperty(this, "label");
	private String name;
	private Memento memento;
	/**
	 * Indicates if this field has been reset to default since the last time it was
	 * loaded or persisted (In which case, on the next persist(), it should remove
	 * its value from the memento)
	 */
	private boolean isDefault;
	private boolean isLoaded = false;
	private final ChangeListener<Object> valueListener = (obs, old, newValue) -> this.setDefault(false);

	protected final ReadOnlyStringWrapper errorMessage = new ReadOnlyStringWrapper(this, "errorMessage", null);

	public FieldEditor(String name, String label) {
		this.name = name;
		this.setLabel(label);
	}

	public FieldEditor(String name) {
		this(name, null);
	}

	/**
	 * <p>
	 * By default, give all available width and height to the children. If more than
	 * one child is present in this field editor, subclasses should provide custom
	 * layout.
	 * </p>
	 */
	@Override
	protected void layoutChildren() {
		Insets padding = getPadding();
		double width = getWidth() - padding.getRight() - padding.getLeft();
		double height = getHeight() - padding.getTop() - padding.getBottom();
		for (Node node : getManagedChildren()) {
			node.resize(width, height);
		}
	}

	void setMemento(Memento memento) {
		this.memento = memento;
	}

	protected Memento getMemento() {
		return this.memento;
	}

	protected String getName() {
		return this.name;
	}

	protected void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	final void load() {
		if (getMemento() != null) {
			this.isDefault = false;
			doLoad();
		}

		if (!isLoaded) {
			this.isLoaded = true;
			getValue().addListener(this.valueListener);
		}
	}

	final void persist() {
		if (getMemento() != null) {
			if (this.isDefault) {
				getMemento().remove(getName());
			} else {
				doPersist();
			}
			this.isDefault = false;
		}
	}

	final void restoreDefaults() {
		doRestoreDefaults();
		this.setDefault(true);
	}

	protected abstract void doLoad();

	protected abstract void doPersist();

	protected abstract void doRestoreDefaults();

	public StringExpression errorMessage() {
		return errorMessage.getReadOnlyProperty();
	}

	/**
	 * Sets the error message for this field editor. Null or empty string will clear
	 * the error message
	 * 
	 * @param error
	 *            The error message to set, or null/empty if the message should be
	 *            cleared
	 * 
	 * @see #clearErrorMessage()
	 */
	protected void setErrorMessage(String error) {
		this.errorMessage.set(error);
	}

	/**
	 * Clear the error message for this field editor
	 */
	protected void clearErrorMessage() {
		this.errorMessage.set(null);
	}

	public final StringProperty labelProperty() {
		return this.label;
	}

	public final String getLabel() {
		return this.labelProperty().get();
	}

	public final void setLabel(final String label) {
		this.labelProperty().set(label);
	}

	/**
	 * Return the value of this field editor. This will be used to automatically
	 * manage {@link #setDefault(boolean)}
	 */
	protected abstract ObservableValue<?> getValue();

	/**
	 * <p>
	 * If true, the preference page will be responsible for displaying the label for
	 * this field editor.
	 * </p>
	 * 
	 * <p>
	 * Subclasses that need to control how their label should be displayed should
	 * override this method and return false.
	 * </p>
	 */
	protected boolean displayLabel() {
		return true;
	}

}
