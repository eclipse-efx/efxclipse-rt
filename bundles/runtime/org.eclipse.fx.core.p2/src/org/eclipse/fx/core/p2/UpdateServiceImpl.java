/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *     Dirk Fauth <dirk.fauth@googlemail.com> - Bug 464376
 *******************************************************************************/
package org.eclipse.fx.core.p2;

import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.operations.ProvisioningSession;
import org.eclipse.equinox.p2.operations.UpdateOperation;
import org.eclipse.fx.core.ProgressReporter;
import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.Status.State;
import org.eclipse.fx.core.StatusException;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.eclipse.fx.core.operation.CancelableOperation;
import org.eclipse.fx.core.update.UpdateService;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

/**
 * Implementation of service based upon p2
 */
@Component
public class UpdateServiceImpl implements UpdateService {
	private Logger logger;
	private LoggerFactory factory;
	
	private IProvisioningAgent provisioningAgent;

	static class P2UpdateCheckRV implements UpdatePlan {
		@NonNull
		public final UpdateOperation updateOperation;
		
		public P2UpdateCheckRV(@NonNull UpdateOperation updateOperation) {
			this.updateOperation = updateOperation;
		}
		
		@Override
		public CancelableOperation<UpdateResult> runUpdate(ProgressReporter progressReporter) {
			ProgressMonitorAdapter a = new ProgressMonitorAdapter(progressReporter);
			SimpleCancelableOperation<UpdateResult> op = new SimpleCancelableOperation<>(() -> a.setCanceled(true));

			Job job = this.updateOperation.getProvisioningJob(a);
			job.addJobChangeListener(new JobChangeAdapter() {
				@Override
				public void done(IJobChangeEvent event) {
					IStatus s = event.getResult();
					if( s.isOK() ) {
						op.completed(new P2UpdateRV());	
					} else {
						op.completeExceptionally(new StatusException(fromStatus(s)));
					}
				}
			});
			job.schedule();
			return op;
		}
	}

	static class P2UpdateRV implements UpdateResult {
		// empty
	}

	/**
	 * Set the factory to create a logger
	 * 
	 * @param factory
	 *            the factory
	 */
	@Reference
	public void setLoggerFactory(LoggerFactory factory) {
		this.factory = factory;
		if (this.logger != null) {
			this.logger = null;
		}
	}

	/**
	 * Unset the factory for the logger
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

	/**
	 * Set the provisioning agent
	 * @param agent the provisioning agent
	 */
	@Reference(cardinality=ReferenceCardinality.OPTIONAL)
	public void setProvisioningAgent(IProvisioningAgent agent) {
		// We need to keep the relation 0..1 because IProvisioningAgent is only loaded
		// if the p2.core bundle is started!
		this.provisioningAgent = agent;
	}
	
	/**
	 * Unset the provisioning agent
	 * @param agent the provisioning agent
	 */
	public void unsetProvisioningAgent(IProvisioningAgent agent) {
		if (this.provisioningAgent == agent) {
			this.provisioningAgent = null;
		}
	}

//Why is that not allowed???	
	@NonNull
	static Status fromStatus(@NonNull IStatus s) {
		switch (s.getSeverity()) {
		case IStatus.CANCEL:
			return Status.status(Status.State.CANCEL,s.getCode(),Util.notNull(s.getMessage(),"<unknown>"),s.getException()); //$NON-NLS-1$
		case IStatus.ERROR:
			return Status.status(Status.State.ERROR,s.getCode(),Util.notNull(s.getMessage(),"<unknown>"),s.getException()); //$NON-NLS-1$
		case IStatus.WARNING:
			return Status.status(Status.State.WARNING,s.getCode(),Util.notNull(s.getMessage(),"<unknown>"),s.getException()); //$NON-NLS-1$
		default:
			return Status.ok();
		}
	}
	
	@Override
	public SimpleCancelableOperation<Optional<UpdatePlan>> checkUpdate(ProgressReporter reporter) {
		final ProvisioningSession session = new ProvisioningSession(this.provisioningAgent);
		ProgressMonitorAdapter a = new ProgressMonitorAdapter(reporter);

		SimpleCancelableOperation<Optional<UpdatePlan>> op = new SimpleCancelableOperation<>(() -> a.setCanceled(true));
		Job o = new Job("Check for Updates") { //$NON-NLS-1$

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				if( a.isCanceled() ) {
					return org.eclipse.core.runtime.Status.CANCEL_STATUS;
				}
				
				try {
					UpdateOperation o = new UpdateOperation(session);
					IStatus s = o.resolveModal(a);
					if( s.getCode() == UpdateOperation.STATUS_NOTHING_TO_UPDATE ) {
						op.completed(Optional.empty());
					} else if( s.isOK() ) {
						if( o.getProvisioningJob(new NullProgressMonitor()) != null ) {
							op.completed(Optional.of(new P2UpdateCheckRV(o)));	
						} else {
							op.completeExceptionally(new StatusException(Status.status(State.ERROR, 0, "No provisioning job available", null))); //$NON-NLS-1$
						}
					} else {
						op.completeExceptionally(new StatusException(fromStatus(s)));
					}
				} catch(Throwable t) {
					op.completeExceptionally(new StatusException(Status.status(State.ERROR, 0, "Check for update failed unexpectedly", t))); //$NON-NLS-1$
				}
				return org.eclipse.core.runtime.Status.OK_STATUS;
			}
		};

		o.schedule();
		return op;
	}
}