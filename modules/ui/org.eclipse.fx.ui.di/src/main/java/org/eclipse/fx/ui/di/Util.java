/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
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
package org.eclipse.fx.ui.di;

import javafx.application.Platform;

import org.eclipse.fx.core.Callback;

/**
 * Utilities
 * 
 * @param <T>
 *            the type passed to the callback
 * @deprecated
 */
@Deprecated
public abstract class Util<T> {
	/**
	 * Wrap a give callback to always run on the javafx threa
	 * 
	 * @param callback
	 *            the callback
	 * @return a wrapped callback
	 */
	public static <T> Callback<T> onFX(final Callback<T> callback) {
		if (callback instanceof SyncCallback<?>) {
			return (SyncCallback<T>) callback;
		}
		return new SyncCallback<T>() {

			@Override
			public void call(final T value) {
				if (Platform.isFxApplicationThread()) {
					callback.call(value);
				} else {
					Platform.runLater(new Runnable() {

						@Override
						public void run() {
							callback.call(value);
						}
					});
				}
			}
		};
	}

	static abstract class SyncCallback<T> implements Callback<T> {
		// nothing to to do
	}
}
