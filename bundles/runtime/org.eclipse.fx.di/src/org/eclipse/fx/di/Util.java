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
package org.eclipse.fx.di;

import org.eclipse.fx.core.Callback;

import javafx.application.Platform;

public abstract class Util<T> implements Callback<T> {
	
	public static <T> Util<T> onFX(final Callback<T> callback) {
		if( callback instanceof Util<?> ) {
			return (Util<T>) callback;
		}
		return new Util<T>() {

			@Override
			public void call(final T value) {
				if( Platform.isFxApplicationThread() ) {
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
}
