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

import org.eclipse.fx.core.ThreadSynchronize;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * Implementation of the UISynchronize service for JavaFX
 */
@Component(service = { org.eclipse.e4.ui.di.UISynchronize.class })
public class UISynchronizeImpl extends org.eclipse.e4.ui.di.UISynchronize {
	private ThreadSynchronize threadSynchronize;

	/**
	 * Setting the thread synchronize
	 *
	 * @param threadSynchronize
	 *            the basic thread sync
	 */
	@Reference(policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY)
	public void setThreadSynchronize(ThreadSynchronize threadSynchronize) {
		this.threadSynchronize = threadSynchronize;
	}

	/**
	 * Unset the threadSynchronize
	 *
	 * @param threadSynchronize
	 *            the threadSynchronize going down
	 */
	public void unsetThreadSynchronize(ThreadSynchronize threadSynchronize) {
		if (this.threadSynchronize == threadSynchronize) {
			this.threadSynchronize = null;
		}
	}

	@Override
	public void syncExec(final Runnable runnable) {
		this.threadSynchronize.syncExec(runnable);
	}

	@Override
	public void asyncExec(Runnable runnable) {
		this.threadSynchronize.asyncExec(runnable);
	}
}
