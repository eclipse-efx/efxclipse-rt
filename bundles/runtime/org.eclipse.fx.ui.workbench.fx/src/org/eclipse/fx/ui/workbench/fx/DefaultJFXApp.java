/*******************************************************************************
 * Copyright (c) 2014  Pawel Zalejko, BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pawel Zalejko<pzalejko@gmail.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.fx;

import javafx.application.Application;
import javafx.stage.Stage;

import org.eclipse.fx.core.databinding.JFXRealm;

/**
 * The {@link DefaultJFXApp} is a default JavaFX {@link Application} class used for bootstrap.
 * <p>
 * The {@link DefaultJFXApp} is intended to be subclassed by components that would like to provide a custom
 * implementation of the JavaFX {@link Application}.
 */
public class DefaultJFXApp extends Application {

	protected final E4Application e4Application;

	/**
	 * Creates an instance of the {@link DefaultJFXApp} and initializes it using the {@link E4Application} given by 
	 * the {@link E4Application#getE4Application()}.
	 */
	public DefaultJFXApp() {
		this(E4Application.getE4Application());
	}

	/**
	 * Creates an instance of the {@link DefaultJFXApp} and initializer is using the given
	 * {@link E4Application}.
	 * 
	 * @param application the {@link E4Application}.
	 * 
	 * @throws NullPointerException if the given {@link E4Application} is null.
	 */
	public DefaultJFXApp(final E4Application e4Application) {
		if (e4Application == null) {
			throw new NullPointerException("The E4Application cannot be null.");
		}
		this.e4Application = e4Application;
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		initialize();
		e4Application.jfxStart(e4Application.getApplicationContext(), this, primaryStage);
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		e4Application.jfxStop();
	}

	/**
	 * Initializes started application (for instance creates a default realm).
	 */
	protected void initialize() {
		JFXRealm.createDefault();
	}
}