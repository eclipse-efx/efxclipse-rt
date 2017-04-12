/*******************************************************************************
 * Copyright (c) 2014 EM-SOFTWARE and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Keimel <c.keimel@emsw.de> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.fx.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * Implementation of the UISynchronize service for JavaFX
 */
@Component(service = { org.eclipse.e4.ui.di.UISynchronize.class })
public class UISynchronizeImpl extends org.eclipse.e4.ui.di.UISynchronize {
	private LoggerFactory factory;
	private Logger logger;

	/**
	 * Setting a new factory
	 *
	 * @param factory
	 *            the new factory
	 */
	@Reference(policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY)
	public void setLoggerFactory(LoggerFactory factory) {
		this.factory = factory;
		this.logger = null;
	}

	/**
	 * Unset the logger factory
	 *
	 * @param factory
	 *            the factory
	 */
	public void unsetLoggerFactory(LoggerFactory factory) {
		if (this.factory == factory) {
			this.factory = null;
			this.logger = null;
		}
	}

	@SuppressWarnings("null")
	private Logger getLogger() {
		if (this.logger == null) {
			this.logger = this.factory.createLogger(getClass().getName());
		}
		return this.logger;
	}

	@Override
	public void syncExec(final Runnable runnable) {
		if (javafx.application.Platform.isFxApplicationThread()) {
			runnable.run();
		} else {
			RunnableFuture<?> task = new FutureTask<Void>(runnable, null);
			javafx.application.Platform.runLater(task);
			try {
				task.get(); // wait for task to complete
			} catch (InterruptedException | ExecutionException e) {
				getLogger().error("Unable to wait until the task is completed", e); //$NON-NLS-1$
			} finally {
				task.cancel(true);
			}
		}
	}

	@Override
	public void asyncExec(Runnable runnable) {
		javafx.application.Platform.runLater(runnable);
	}

}
