/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.services;

import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Service used to handle model stuff
 *
 * @noimplement
 * @since 2.0
 */
public interface ModelService {
	/**
	 * Get global unique identifier for the given model element
	 *
	 * @param element
	 *            the element
	 * @return the unique identifier
	 */
	public @NonNull String getUniqueId(@NonNull MApplicationElement element);

	/**
	 * Get the real element for the given id
	 *
	 * @param m
	 *            the application element
	 * @param uniqueId
	 *            the unique id
	 * @param <M>
	 *            the element type
	 * @return the instance or <code>null</code> if not found
	 */
	public @Nullable <M extends MApplicationElement> M getElementInstance(@NonNull MApplication m, @NonNull String uniqueId);

	/**
	 * Get the root element of the model
	 *
	 * @param e
	 *            the current element
	 * @return the root element
	 */
	public @Nullable MApplication getRoot(@NonNull MApplicationElement e);

	/**
	 * Factory to create model elements
	 */
	public interface ModelElementFactory {
		/**
		 * Create a model element instance and initialize the
		 * {@link MApplicationElement#setContributorURI(String)}
		 *
		 * @param clazz
		 *            the model instance type
		 * @return the instance
		 */
		public <T extends MApplicationElement> @NonNull T createModelElement(@NonNull Class<@NonNull T> clazz);

		/**
		 * Create a model element instance, initialize the
		 * {@link MApplicationElement#setContributorURI(String)} and run the
		 * element through the provided processor
		 *
		 * @param clazz
		 *            the model instance type
		 * @param processor
		 *            the processor to eg initialize the element
		 * @return the model instance
		 */
		public <T extends MApplicationElement> @NonNull T createModelElement(@NonNull Class<@NonNull T> clazz, @NonNull Function<@NonNull T, @NonNull T> processor);

		/**
		 * Create a model element instance and initialize the
		 * {@link MApplicationElement#setContributorURI(String)} with the value
		 * provided by the contributor supplier
		 *
		 * @param clazz
		 *            the model instance type
		 * @param contributor
		 *            the contributor supplier
		 * @return the instance
		 */
		public <T extends MApplicationElement> @NonNull T createModelElement(@NonNull Class<@NonNull T> clazz, @NonNull Supplier<@NonNull String> contributor);

		/**
		 * Create a model element instance, initialize the
		 * {@link MApplicationElement#setContributorURI(String)} with the value
		 * provided by the contributor supplier and run the element through the
		 * provided processor
		 *
		 * @param clazz
		 *            the model instance type
		 * @param contributor
		 *            the contributor supplier
		 * @param processor
		 *            the processor to eg initialize the element
		 * @return the instance
		 */
		public <T extends MApplicationElement> @NonNull T createModelElement(@NonNull Class<@NonNull T> clazz, @NonNull Supplier<@NonNull String> contributor, Function<@NonNull T, @NonNull T> processor);

		/**
		 * Create a supplier who creates a model element instance and
		 * initializes the {@link MApplicationElement#setContributorURI(String)}
		 *
		 * @param clazz
		 *            the model instance type
		 * @return the instance
		 */
		public <T extends MApplicationElement> @NonNull Supplier<T> createModelElementCreator(@NonNull Class<@NonNull T> clazz);

		/**
		 * Create a supplier who creates a model element instance, initializes
		 * the {@link MApplicationElement#setContributorURI(String)} and run the
		 * element through the provided processor
		 *
		 * @param clazz
		 *            the model instance type
		 * @param processor
		 *            the processor to eg initialize the element
		 * @return the model instance
		 */
		public <T extends MApplicationElement> @NonNull Supplier<T> createModelElementCreator(@NonNull Class<@NonNull T> clazz, @NonNull Function<@NonNull T, @NonNull T> processor);

		/**
		 * Create a supplier who creates a model element instance and
		 * initializes the {@link MApplicationElement#setContributorURI(String)}
		 * with the value provided by the contributor supplier
		 *
		 * @param clazz
		 *            the model instance type
		 * @param contributor
		 *            the contributor supplier
		 * @return the instance
		 */
		public <T extends MApplicationElement> @NonNull Supplier<T> createModelElementCreator(@NonNull Class<@NonNull T> clazz, @NonNull Supplier<@NonNull String> contributor);

		/**
		 * Create a supplier who creates a model element instance, initializes
		 * the {@link MApplicationElement#setContributorURI(String)} with the
		 * value provided by the contributor supplier and run the element
		 * through the provided processor
		 *
		 * @param clazz
		 *            the model instance type
		 * @param contributor
		 *            the contributor supplier
		 * @param processor
		 *            the processor to eg initialize the element
		 * @return the instance
		 */
		public <T extends MApplicationElement> @NonNull Supplier<T> createModelElementCreator(@NonNull Class<@NonNull T> clazz, @NonNull Supplier<@NonNull String> contributor, Function<@NonNull T, @NonNull T> processor);
	}

	/**
	 * Create a factory to create model elements
	 *
	 * @param owner
	 *            the owner of the model element
	 * @param modelService
	 *            the model service used to create the elements
	 * @return the factory
	 */
	public @NonNull ModelElementFactory createModelElementFactory(@NonNull Class<?> owner, @NonNull EModelService modelService);

	/**
	 * Get the name of the bundle
	 *
	 * @param clazz
	 *            the clazz
	 * @return the bundle name
	 */
	public @NonNull String getBundleName(@NonNull Class<?> clazz);

	/**
	 * Get a supplier for the bundle name
	 *
	 * @param clazz
	 *            the clazz
	 * @return the bundle name
	 */
	public @NonNull Supplier<@NonNull String> getBundleNameSupplier(@NonNull Class<?> clazz);
}
