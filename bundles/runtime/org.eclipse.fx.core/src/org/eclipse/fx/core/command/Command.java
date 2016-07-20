/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * Interface representing a command
 *
 * @param <T>
 *            the type returned by this command
 *
 * @since 3.0
 */
public interface Command<T> {

	/**
	 * A parameter value
	 */
	public static class ParameterValue {
		/**
		 * The name of the parameter
		 */
		public final String name;
		/**
		 * The value of the parameter
		 */
		public final String value;

		/**
		 * Create a new parameter value
		 *
		 * @param name
		 *            the name
		 * @param value
		 *            the value
		 */
		public ParameterValue(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}

	/**
	 * @return property describing the enabled state
	 */
	public ReadOnlyBooleanProperty enabledProperty();

	/**
	 * @return <code>true</code> if property is enabled
	 */
	public boolean isEnabled();

	/**
	 * Execute the command with the provided parameters
	 *
	 * @return the result
	 */
	public Optional<T> execute();

	/**
	 * @return Parameters used to execute the command
	 */
	public ObservableMap<String, String> parameters();

	/**
	 * Create a simple command executing the provided function
	 *
	 * @param action
	 *            the action
	 * @return the command instance
	 */
	public static <T> Command<T> createCommand(Function<Map<String, String>, T> action) {
		return new Command<T>() {
			private ReadOnlyBooleanWrapper enabled = new ReadOnlyBooleanWrapper(this, "enabled", true); //$NON-NLS-1$
			private ObservableMap<String, String> parameters = FXCollections.observableMap(new HashMap<>());

			@Override
			public ObservableMap<String, String> parameters() {
				return this.parameters;
			}

			@Override
			public ReadOnlyBooleanProperty enabledProperty() {
				return this.enabled.getReadOnlyProperty();
			}

			@Override
			public boolean isEnabled() {
				return this.enabled.get();
			}

			@Override
			public Optional<T> execute() {
				return Optional.of(action.apply(new HashMap<>(this.parameters)));
			}
		};
	}

	/**
	 * Create a simple command executing the provided function
	 *
	 * @param action
	 *            the action
	 * @param enabledCalculator
	 *            predicate to calculate the enabled state
	 * @return the command instance
	 */
	public static <T> Command<T> createCommand(Function<Map<String, String>, T> action, Predicate<Map<String, String>> enabledCalculator) {
		return new Command<T>() {
			private ReadOnlyBooleanWrapper enabled = new ReadOnlyBooleanWrapper(this, "enabled", true); //$NON-NLS-1$
			private ObservableMap<String, String> parameters = FXCollections.observableMap(new HashMap<>());

			{
				this.parameters.addListener( (Observable o) -> {
					this.enabled.set(enabledCalculator.test(this.parameters));
				});
			}

			@Override
			public ObservableMap<String, String> parameters() {
				return this.parameters;
			}

			@Override
			public ReadOnlyBooleanProperty enabledProperty() {
				return this.enabled.getReadOnlyProperty();
			}

			@Override
			public boolean isEnabled() {
				return this.enabled.get();
			}

			@Override
			public Optional<T> execute() {
				return Optional.of(action.apply(new HashMap<>(this.parameters)));
			}
		};
	}
}
