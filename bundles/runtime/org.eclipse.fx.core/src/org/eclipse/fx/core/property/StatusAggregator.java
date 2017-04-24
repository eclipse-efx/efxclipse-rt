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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.Status.State;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;

/**
 * Aggregate the multiple status properties
 */
public class StatusAggregator implements ValidationStatusPropertyOwner {
	private List<ValidationStatusPropertyOwner> list = new ArrayList<>();
	private ReadOnlyObjectWrapper<Status> statusProperty = new ReadOnlyObjectWrapper<>(this, "statusProperty", Status.ok()); //$NON-NLS-1$

	private static Comparator<Status> STATUS_SORTER = (s1, s2) -> s1.getState().compareTo(s2.getState());
	private static Predicate<Status> WARNING_ERROR = s -> s.getState() == State.ERROR || s.getState() == State.WARNING;

	private final AtomicBoolean validationScheduled = new AtomicBoolean();

	/**
	 * Create a status aggregator
	 *
	 * @param properties
	 *            the properties
	 */
	public StatusAggregator(ValidationStatusPropertyOwner... properties) {
		Stream.of(properties).forEach(this::register);
	}

	/**
	 * Register a property
	 *
	 * @param property
	 *            the property
	 * @return a subscription to remove owner
	 */
	public Subscription register(ValidationStatusPropertyOwner property) {
		property.statusProperty().addListener(this::handleBindingStatusChange);
		this.list.add(property);
		_validate();
		return () -> {
			property.statusProperty().removeListener(this::handleBindingStatusChange);
			this.list.remove(property);
			_validate();
		};
	}

	private void handleBindingStatusChange(Observable o, Status ol, Status ne) {
		if (this.validationScheduled.getAndSet(true)) {
			return;
		}
		Platform.runLater(this::_validate);
	}

	@Override
	public ReadOnlyObjectProperty<Status> statusProperty() {
		return this.statusProperty.getReadOnlyProperty();
	}

	@Override
	public void validate() {
		this.list.stream().forEach( ValidationStatusPropertyOwner::validate );
		_validate();
	}

	private void _validate() {
		this.statusProperty.set(this.list.stream().map(b -> b.statusProperty().get()).sorted(STATUS_SORTER).filter(WARNING_ERROR).findFirst().orElse(Status.ok()));
		this.validationScheduled.set(false);
	}
}
