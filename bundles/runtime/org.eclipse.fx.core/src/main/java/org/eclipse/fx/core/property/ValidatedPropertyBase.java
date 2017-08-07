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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.eclipse.fx.core.Subscription;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Base class to wrap up a property to hold its validation information
 *
 * @param <O>
 *            the primitive type
 * @since 2.4.0
 */
public abstract class ValidatedPropertyBase<O> implements ValidatedProperty<O> {
	static Comparator<Status> STATUS_SORTER = (s1, s2) -> s1.getState().compareTo(s2.getState());
	static Predicate<Status> WARNING_ERROR = s -> s.getState() == State.ERROR || s.getState() == State.WARNING;

	private final ReadOnlyObjectWrapper<Status> status = new ReadOnlyObjectWrapper<>(this, "status", Status.ok()); //$NON-NLS-1$
	private Map<String, Supplier<?>> dependencyMap = new HashMap<>();
	private final List<BiFunction<O, Map<String, Object>, Status>> validationList = new ArrayList<>();
	private List<Subscription> listeners = new ArrayList<>();

	private ObservableList<Status> validationStatusList = FXCollections.observableArrayList();

	/**
	 * The wrapped domain property
	 */
	protected final Property<O> domainProperty;

	private final AtomicBoolean validationScheduled = new AtomicBoolean();

	/**
	 * Create an instance wrapping an existing property
	 *
	 * @param domainProperty
	 *            the domain property
	 */
	public ValidatedPropertyBase(Property<O> domainProperty) {
		this.domainProperty = domainProperty;
		this.domainProperty.addListener(this::handlePropertyChange);
	}

	@Override
	public ReadOnlyObjectProperty<Status> statusProperty() {
		return this.status.getReadOnlyProperty();
	}

	@Override
	public Subscription registerValidator(Function<O, Status> validator) {
		return registerValidator((t, dep) -> validator.apply(t));
	}

	@Override
	public Subscription registerValidator(BiFunction<O, Map<String, Object>, Status> validator) {
		this.validationList.add(validator);
		return () -> {
			this.validationList.remove(validator);
			_runValidation();
		};
	}

	@Override
	public Subscription registerDependency(ValidatedPropertyBase<?> property) {
		return dependency(property.domainProperty.getName(), property);
	}

	@Override
	public Subscription registerDependency(Property<?> property) {
		return dependency(property.getName(), property);
	}

	@Override
	public Subscription dependency(String name, ValidatedPropertyBase<?> property) {
		if (name == null) {
			throw new IllegalArgumentException("A name is required"); //$NON-NLS-1$
		}
		this.dependencyMap.put(name, () -> {
			return property.bindProperty().getValue();
		});

		property.domainProperty.addListener(this::handlePropertyChange);
		Subscription domainSub = () -> property.domainProperty.removeListener(this::handlePropertyChange);
		Subscription bindSub;
		this.listeners.add(domainSub);

		if (property.domainProperty != property.bindProperty()) {
			property.bindProperty().addListener(this::handlePropertyChange);
			bindSub = () -> property.bindProperty().removeListener(this::handlePropertyChange);
			this.listeners.add(bindSub);
		} else {
			bindSub = null;
		}

		return () -> {
			domainSub.dispose();
			this.listeners.remove(domainSub);
			if (bindSub != null) {
				bindSub.dispose();
				this.listeners.remove(bindSub);
			}
		};
	}

	@Override
	public Subscription dependency(String name, Property<?> property) {
		this.dependencyMap.put(name, property::getValue);
		property.addListener(this::handlePropertyChange);
		Subscription s = () -> {
			property.removeListener(this::handlePropertyChange);
		};
		this.listeners.add(s);
		return () -> {
			s.dispose();
			this.listeners.remove(s);
		};
	}

	private void handlePropertyChange(Observable o, Object ol, Object ne) {
		runValidation();
	}

	@Override
	public void validate() {
		_runValidation();
	}

	private void runValidation() {
		if (this.validationScheduled.getAndSet(true)) {
			return;
		}
		Platform.runLater(this::_runValidation);
	}

	private void _runValidation() {
		Map<String, Object> map = Optional.ofNullable(this.dependencyMap)
				.<Map<String,Object>>map(m -> m.entrySet().stream().collect(Collectors.toMap(Entry::getKey, e -> (Object) e.getValue().get())))
				.orElse(new HashMap<>());
		this.validationStatusList.setAll(this.validationList.stream().map(f -> f.apply(this.bindProperty().getValue(), map)).collect(Collectors.toList()));
		this.status.setValue(this.validationStatusList.stream().sorted(STATUS_SORTER).filter(WARNING_ERROR).findFirst().orElse(Status.ok()));
		this.validationScheduled.set(false);
	}

	@Override
	public void dispose() {
		this.listeners.forEach(e -> e.dispose());
		this.dependencyMap.clear();
		this.validationList.clear();
	}
}
