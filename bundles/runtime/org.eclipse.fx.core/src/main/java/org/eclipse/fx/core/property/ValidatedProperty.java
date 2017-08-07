/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.property;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Subscription;

import javafx.beans.property.Property;

/**
 * Wrap up a property to hold its validation information
 *
 * @param <O>
 *            the element type
 */
public interface ValidatedProperty<O> extends ValidationStatusPropertyOwner {
	/**
	 * @return the property to bind to
	 */
	public Property<O> bindProperty();

	/**
	 * Register a validator who is run passing along the value of the observable
	 *
	 * @param validator
	 *            the validator function
	 * @return the subscription to remove the validator
	 */
	public Subscription registerValidator(Function<O, Status> validator);

	/**
	 * Register a validator who is also use the values from dependent
	 * observables
	 *
	 * @param validator
	 *            the validator
	 * @return the subscription to remove the validator
	 */
	public Subscription registerValidator(BiFunction<O, Map<String, Object>, Status> validator);

	/**
	 * Register a dependent validated property
	 *
	 * @param property
	 *            the property
	 * @return the subscription to remove the dependency
	 */
	public Subscription registerDependency(ValidatedPropertyBase<?> property);

	/**
	 * Register a dependent property
	 *
	 * @param property
	 *            the property
	 * @return the subscription to remove the dependency
	 */
	public Subscription registerDependency(Property<?> property);

	/**
	 * Register a dependent validated property
	 *
	 * @param name
	 *            the name used when build the map for
	 *            {@link ValidatedPropertyBase#registerValidator(BiFunction)}
	 * @param property
	 *            the property
	 * @return the subscription to remove the dependency
	 */
	public Subscription dependency(String name, ValidatedPropertyBase<?> property);

	/**
	 * Register a dependent property
	 *
	 * @param name
	 *            the name used when build the map for
	 *            {@link ValidatedPropertyBase#registerValidator(BiFunction)}
	 * @param property
	 *            the property
	 * @return the subscription to remove the dependency
	 */
	public Subscription dependency(String name, Property<?> property);

	/**
	 * Free all resources
	 */
	public void dispose();
}
