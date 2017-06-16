/*******************************************************************************
 * Copyright (c) 2015 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.di.context.internal;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.core.TypeTypeProviderService;
import org.osgi.service.component.annotations.Component;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Callback;

/**
 * Type provider for @Inject @LocalInstance FXMLLoader loader
 */
@Component
public class FXMLLoaderTypeProvider implements TypeTypeProviderService<FXMLLoader> {

	@Override
	public Class<? extends FXMLLoader> getType(Type s) {
		return DIFXMLLoader.class;
	}

	@Override
	public boolean test(Type t) {
		return FXMLLoader.class == t;
	}

	static class DIFXMLLoader extends FXMLLoader {
		@Inject
		public DIFXMLLoader(@Named(TypeTypeProviderService.DI_KEY) Class<?> owner, IEclipseContext context) {
			setClassLoader(owner.getClassLoader());
			setBuilderFactory(new JavaFXBuilderFactory(owner.getClassLoader()));
			setControllerFactory(new ControllerFactory(context));
		}
	}

	static class ControllerFactory implements Callback<Class<?>, Object> {

		private final IEclipseContext context;

		public ControllerFactory(IEclipseContext context) {
			this.context = context;
		}

		@Override
		public Object call(Class<?> param) {
			Object o;
			if (param.isInterface() || (param.getModifiers() & Modifier.ABSTRACT) == Modifier.ABSTRACT) {
				o = this.context.get(param.getName());
			} else {
				o = ContextInjectionFactory.make(param, this.context);
				if( o != null ) {
					this.context.set(o.getClass().getName(), o);
				}
			}

			return o;
		}

	}
}