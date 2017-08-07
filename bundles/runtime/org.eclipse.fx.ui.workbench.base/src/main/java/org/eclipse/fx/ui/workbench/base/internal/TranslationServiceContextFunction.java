/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Martin Blühweis <martin.bluehweis@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.base.internal;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.text.TranslationService;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("javadoc")
@Component(property = "service.context.key:String=org.eclipse.fx.core.text.TranslationService")
public class TranslationServiceContextFunction extends ContextFunction implements IContextFunction {
	@Override
	public Object compute(IEclipseContext context, String contextKey) {
		return ContextInjectionFactory.make(TranslationServiceImpl.class, context);
	}

	public static class TranslationServiceImpl implements TranslationService {
		final Map<Consumer<String>, Supplier<String>> bindings = new HashMap<>();
		@Inject
		private org.eclipse.e4.core.services.translation.TranslationService translationService;
		@Inject
		private MApplicationElement element;

		@Override
		public Subscription register(Consumer<String> consumer, String key, Object... arguments) {
			Supplier<String> supplier = () -> {
				String rv = translate(key);
				if (arguments.length > 0) {
					rv = MessageFormat.format(rv, arguments);
				}
				return rv;
			};
			this.bindings.put(consumer, supplier);
			return () -> this.bindings.remove(consumer);
		}

		@Override
		public void updateBindings() {
			Iterator<Entry<Consumer<String>, Supplier<String>>> it = this.bindings.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Consumer<String>, Supplier<String>> next = it.next();
				next.getKey().accept(next.getValue().get());
			}
		}

		@SuppressWarnings("null")
		@Override
		public @NonNull String translate(@NonNull String key) {
			return this.translationService.translate("%" + key, this.element.getContributorURI()); //$NON-NLS-1$
		}
	}
}
