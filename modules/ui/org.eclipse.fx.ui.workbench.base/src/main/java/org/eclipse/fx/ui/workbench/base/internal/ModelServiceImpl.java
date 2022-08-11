/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.base.internal;

import java.lang.reflect.Type;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.fx.core.TypeTypeProviderService;
import org.eclipse.fx.ui.workbench.services.ModelService;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.component.annotations.Component;

/**
 * Default implementation of the {@link ModelService}
 */
@Component
public class ModelServiceImpl implements ModelService, TypeTypeProviderService<ModelService.ModelElementFactory> {

	@Override
	public @NonNull String getUniqueId(@NonNull MApplicationElement element) {
		EObject eo = (EObject) element;
		String id = ((XMIResource) eo.eResource()).getID(eo);
		if (id == null) {
			throw new IllegalStateException("Unable to locate ID for '" + element + "'"); //$NON-NLS-1$//$NON-NLS-2$
		}
		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <M extends MApplicationElement> @Nullable M getElementInstance(@NonNull MApplication m, @NonNull String uniqueId) {
		return (M) ((XMIResource) ((EObject) m).eResource()).getEObject(uniqueId);
	}

	@Override
	public MApplication getRoot(@NonNull MApplicationElement e) {
		Resource eResource = ((EObject) e).eResource();
		return eResource != null ? (MApplication) eResource.getContents().get(0) : null;
	}

	@Override
	public Class<? extends ModelElementFactory> getType(Type s) {
		return ModelElementFactoryImpl.class;
	}

	@Override
	public boolean test(Type t) {
		return t == ModelElementFactory.class;
	}

	/**
	 * Factory to create model elements
	 */
	public static class ModelElementFactoryImpl implements ModelElementFactory {
		@NonNull
		private final EModelService modelService;
		@NonNull
		private final Supplier<@NonNull String> contributor;



		/**
		 * Create a new instance
		 *
		 * @param modelService
		 *            the model service
		 * @param ownerType
		 *            the owner type
		 */
		@Inject
		public ModelElementFactoryImpl(@NonNull EModelService modelService, @Named(TypeTypeProviderService.DI_KEY) @NonNull Class<?> ownerType) {
			this.modelService = modelService;
			this.contributor = _getBundleNameSupplier(ownerType);
		}

		@Override
		public <T extends MApplicationElement> @NonNull T createModelElement(@NonNull Class<@NonNull T> clazz) {
			return createModelElement(clazz, this.contributor, (e) -> e);
		}

		@Override
		public <T extends MApplicationElement> @NonNull T createModelElement(@NonNull Class<@NonNull T> clazz, @NonNull Function<@NonNull T, @NonNull T> processor) {
			return createModelElement(clazz, this.contributor, processor);
		}

		@Override
		public <T extends MApplicationElement> @NonNull T createModelElement(@NonNull Class<@NonNull T> clazz, @NonNull Supplier<@NonNull String> contributor) {
			return createModelElement(clazz, contributor, (t) -> t);
		}

		@Override
		public <T extends MApplicationElement> @NonNull T createModelElement(@NonNull Class<@NonNull T> clazz, @NonNull Supplier<@NonNull String> contributor, Function<@NonNull T, @NonNull T> processor) {
			T element = this.modelService.createModelElement(clazz);
			element.setContributorURI("platform:/plugin/" + contributor); //$NON-NLS-1$
			element = processor.apply(element);
			return element;
		}

		@Override
		public <T extends MApplicationElement> @NonNull Supplier<T> createModelElementCreator(@NonNull Class<@NonNull T> clazz) {
			return createModelElementCreator(clazz, this.contributor, (t) -> t);
		}

		@Override
		public <T extends MApplicationElement> @NonNull Supplier<T> createModelElementCreator(@NonNull Class<@NonNull T> clazz, @NonNull Function<@NonNull T, @NonNull T> processor) {
			return createModelElementCreator(clazz, this.contributor, processor);
		}

		@Override
		public <T extends MApplicationElement> @NonNull Supplier<T> createModelElementCreator(@NonNull Class<@NonNull T> clazz, @NonNull Supplier<@NonNull String> contributor) {
			return createModelElementCreator(clazz, contributor, (t) -> t);
		}

		@Override
		public <T extends MApplicationElement> @NonNull Supplier<T> createModelElementCreator(@NonNull Class<@NonNull T> clazz, @NonNull Supplier<@NonNull String> contributor, Function<@NonNull T, @NonNull T> processor) {
			return () -> createModelElement(clazz, contributor, processor);
		}
	}

	@Override
	public @NonNull ModelElementFactory createModelElementFactory(@NonNull Class<?> owner, @NonNull EModelService modelService) {
		return new ModelElementFactoryImpl(modelService, owner);
	}

	public static @NonNull String _getBundleName(Class<?> clazz) {
		String bundleId = FrameworkUtil.getBundle(clazz).getSymbolicName();
		if (bundleId == null) {
			throw new IllegalStateException("Could not extract the bundle name from the '" + clazz + "'"); //$NON-NLS-1$//$NON-NLS-2$
		}
		return bundleId;
	}

	public static @NonNull Supplier<@NonNull String> _getBundleNameSupplier(Class<?> clazz) {
		String id = _getBundleName(clazz);
		return () -> id;
	}

	@Override
	public @NonNull String getBundleName(Class<?> clazz) {
		return _getBundleName(clazz);
	}

	@Override
	public @NonNull Supplier<@NonNull String> getBundleNameSupplier(Class<?> clazz) {
		return _getBundleNameSupplier(clazz);
	}
}
