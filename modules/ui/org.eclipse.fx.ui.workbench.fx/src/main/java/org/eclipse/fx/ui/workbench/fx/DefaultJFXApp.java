/*******************************************************************************
 * Copyright (c) 2014  Pawel Zalejko, BestSolution.at and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Pawel Zalejko<pzalejko@gmail.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.fx;

import javafx.application.Application;
import javafx.stage.Stage;

import org.eclipse.core.runtime.IProduct;
import org.eclipse.fx.core.databinding.JFXRealm;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.jdt.annotation.NonNull;

/**
 * The {@link DefaultJFXApp} is a default JavaFX {@link Application} class used
 * for bootstrap.
 * <p>
 * The {@link DefaultJFXApp} is intended to be subclassed by components that
 * would like to provide a custom implementation of the JavaFX
 * {@link Application}.
 */
public class DefaultJFXApp extends Application {

	protected final E4Application e4Application;

	/**
	 * Creates an instance of the {@link DefaultJFXApp} and initializes it using
	 * the {@link E4Application} given by the
	 * {@link E4Application#getE4Application()}.
	 */
	public DefaultJFXApp() {
		this(E4Application.getE4Application());
	}

	/**
	 * Creates an instance of the {@link DefaultJFXApp} and initializer is using
	 * the given {@link E4Application}.
	 * 
	 * @param e4Application
	 *            the {@link E4Application}.
	 * 
	 * @throws NullPointerException
	 *             if the given {@link E4Application} is null.
	 */
	public DefaultJFXApp(@NonNull final E4Application e4Application) {
		this.e4Application = e4Application;
		setProductApplicationName();
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		initialize();
		this.e4Application.jfxStart(this.e4Application.getApplicationContext(), this, primaryStage);
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		this.e4Application.jfxStop();
	}

	/**
	 * Initializes started application (for instance creates a default realm).
	 */
	@SuppressWarnings("static-method")
	protected void initialize() {
		JFXRealm.createDefault();
	}
	
	
	static void setProductApplicationName() {
		try {
			IProduct product = org.eclipse.core.runtime.Platform.getProduct();
			if (product != null && product.getName() != null) {
				com.sun.glass.ui.Application.GetApplication().setName(product.getName());
			}
		} catch (Throwable e) {
			LoggerCreator.createLogger(DefaultJFXApp.class).errorf("Failed to set application name", e); //$NON-NLS-1$
		}
		
	}
}