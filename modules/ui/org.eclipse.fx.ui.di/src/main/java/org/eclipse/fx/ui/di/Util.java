/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 */
public abstract class Util<T> {
	/**
	 * Wrap a give callback to always run on the javafx threa
	 * @param <T> the value type
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

	abstract static class SyncCallback<T> implements Callback<T> {
		// nothing to to do
	}
}
