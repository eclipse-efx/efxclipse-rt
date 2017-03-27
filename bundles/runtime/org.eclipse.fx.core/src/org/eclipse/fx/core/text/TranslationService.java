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
package org.eclipse.fx.core.text;

import java.text.MessageFormat;
import java.util.function.Consumer;

import org.eclipse.fx.core.Subscription;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Service to translate messages
 * 
 * @since 3.0
 */
public interface TranslationService {
	/**
	 * Register a consumer and supplier
	 *
	 * <pre>
	 * &#064;Inject
	 * private TextRegistry reg; // Subclass of AbstractMessageRegistry
	 *
	 * TitledPane tb = new TitledPane();
	 * reg.register(tb::setText, () -&gt; "Hello");
	 * </pre>
	 *
	 * @param consumer
	 *            the consumer the value is set on
	 * @param key
	 *            message key
	 * @param arguments
	 *            message arguments used by
	 *            {@link MessageFormat#format(String, Object...)}
	 * @return the subscription
	 */
	@NonNull
	public Subscription register(@NonNull Consumer<@NonNull String> consumer, @NonNull String key, Object... arguments);

	/**
	 * Force an update of all bindings
	 */
	public void updateBindings();

	/**
	 * Translate the message key
	 * 
	 * @param key
	 *            the message key
	 * @return translation
	 */
	@NonNull
	public String translate(@NonNull String key);
}
