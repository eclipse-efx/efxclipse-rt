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

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.fx.core.Memento;
import org.eclipse.fx.core.MultiStatus;
import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.eclipse.fx.core.Subscription;
import org.eclipse.jdt.annotation.NonNull;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectExpression;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Region;

public abstract class FieldEditor<T> extends Region {
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

	private final ReadOnlyStringWrapper errorMessage = new ReadOnlyStringWrapper(this, "errorMessage", null);
	private final ReadOnlyObjectWrapper<Status> status = new ReadOnlyObjectWrapper<>(Status.ok());
	protected final ObservableList<Function<? super T, Status>> validationFunctions = FXCollections
			.observableArrayList();

	public FieldEditor(String name, String label) {
		this.name = name;
		this.setLabel(label);

		errorMessage.bind(
				Bindings.createStringBinding(() -> status.get().isOk() ? null : status.get().getMessage(), status));
	}

	private void configureStatus() {
		ObjectExpression<Status> createStatusBinding = createStatusBinding();
		status.bind(createStatusBinding);
	}

	/**
	 * <p>
	 * Create the status binding for this field editor. The default is computed by
	 * applying the validation functions to the current value upon value change.
	 * </p>
	 * <p>
	 * Subclasses should override this method if they need to update the status
	 * independently from a value change (Typically, if the new user input doesn't
	 * result in a valid new value, thus can't trigger a value change).
	 * </p>
	 */
	protected ObjectExpression<Status> createStatusBinding() {
		return Bindings.createObjectBinding(this::validate, validationFunctions, getValue());
	}

	private Status validate() {
		T value = getValue().getValue();
			
		List<Status> errorStatuses = validationFunctions.stream()
				.map(vf -> vf.apply(value))
				.filter(s -> s != null && !s.isOk())
				.collect(Collectors.toList());
		
		String errorMessages = errorStatuses.stream()
				.map(Status::getMessage)
				.filter(m -> m != null && !m.isEmpty())
				.reduce((s1, s2) -> new StringBuilder(s1).append("\n").append(s2).toString())
				.orElse(null); //When everything's OK, or when Warning/Errors are reported without a message
		
		MultiStatus status = errorStatuses.stream()
				.collect(MultiStatus.toMultiStatus(errorMessages, Status.UNKNOWN_RETURN_CODE));
		
		return status;
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
			configureStatus();
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
	 * <p>
	 * Return the value of this field editor. This will be used to automatically
	 * manage {@link #setDefault(boolean)}.
	 * </p>
	 */
	protected abstract ObservableValue<T> getValue();

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

	/**
	 * <p>
	 * Return the observable {@link Status} property for this editor's value.
	 * </p>
	 * 
	 * @return
	 */
	public ObjectExpression<Status> statusProperty() {
		return status.getReadOnlyProperty();
	}

	/**
	 * <p>
	 * Add a validation function to this field editor. The validation function
	 * accepts a value and produces a Status.
	 * </p>
	 * 
	 * @param validationFunction
	 *            A Function taking a value as a parameter, and returning a
	 *            {@link Status}
	 * @return A {@link Subscription} to unregister the validation function
	 */
	public Subscription registerStatusValidator(@NonNull Function<? super T, Status> validationFunction) {
		validationFunctions.add(validationFunction);
		return () -> validationFunctions.remove(validationFunction);
	}
	
	/**
	 * <p>
	 * Add a validation function to this field editor. The validation function
	 * accepts a value and produces an error message as a {@link String}, or
	 * <code>null</code> if the value is valid.
	 * </p>
	 * <p>
	 * This is a simplified version of {@link #registerStatusValidator(Function)}:
	 * a null or empty message corresponds to {@link Status#ok()}, whereas
	 * a non-empty message corresponds to an {@link Status.State#Error Error} status,
	 * with a default error code an no exception.
	 * </p>
	 * 
	 * @param validationFunction
	 *            A Function taking a value as a parameter, and returning a
	 *            {@link String} error message, or <code>null</code> if the value is
	 *            valid.
	 * @return A {@link Subscription} to unregister the validation function
	 * 
	 * @see #registerStatusValidator(Function)
	 */
	public Subscription registerValidator(@NonNull Function<? super T, String> validationFunction) {
		return registerStatusValidator(validationFunction.andThen(m -> 
			m == null || m.isEmpty() 
					? Status.ok()
					:Status.status(State.ERROR, Status.UNKNOWN_RETURN_CODE, m, null)));
	}

}
