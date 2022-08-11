/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.controls.list;

import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.text.TextRegistry;
import org.eclipse.jdt.annotation.Nullable;

import javafx.scene.control.ListCell;

/**
 * A {@link ListCell} who uses the translation system
 * 
 * @param <T>
 *            the element type
 */
public class L10NListCell<T> extends ListCell<T> {
	private final TextRegistry textRegistry;
	private final Function<@Nullable T, @Nullable String> registryComputer;
	private Subscription subscription;

	/**
	 * Create a new list cell
	 * 
	 * @param textRegistry
	 *            the text registry
	 * @param registryComputer
	 *            function to compute the registry key to use
	 */
	public L10NListCell(TextRegistry textRegistry, Function<@Nullable T, @Nullable String> registryComputer) {
		this.textRegistry = textRegistry;
		this.registryComputer = registryComputer;
	}

	@Override
	protected void updateItem(T item, boolean empty) {
		super.updateItem(item, empty);
		if (this.subscription != null) {
			this.subscription.dispose();
		}

		if (!empty) {
			String key = this.registryComputer.apply(item);
			if (key != null) {
				Supplier<String> supplier = null;
				try {
					supplier = this.textRegistry.getSupplierByKey(key);
				} catch (Throwable t) {
					// it looks like not all TextRegistry impls return null if
					// the supplier is not found but an IAE
				}
				if (supplier != null) {
					this.subscription = this.textRegistry.register(textProperty()::set, supplier);
				} else {
					setText("Unknown l10n key '" + key + "'"); //$NON-NLS-1$//$NON-NLS-2$
				}

			} else {
				setText(""); //$NON-NLS-1$
			}

		} else {
			setText(""); //$NON-NLS-1$
		}
	}
}
