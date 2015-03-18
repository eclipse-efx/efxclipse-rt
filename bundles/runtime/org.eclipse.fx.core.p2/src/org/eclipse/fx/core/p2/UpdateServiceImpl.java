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
package org.eclipse.fx.core.p2;

import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.operations.ProvisioningSession;
import org.eclipse.equinox.p2.operations.UpdateOperation;
import org.eclipse.fx.core.ProgressReporter;
import org.eclipse.fx.core.Status;
import org.eclipse.fx.core.StatusException;
import org.eclipse.fx.core.Util;
import org.eclipse.fx.core.function.ExExecutor;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.eclipse.fx.core.operation.CancelableOperation;
import org.eclipse.fx.core.update.UpdateService;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.ServiceReference;

/**
 * Implementation of service based upon p2
 */
public class UpdateServiceImpl implements UpdateService {
	private Logger logger;
	private LoggerFactory factory;

	static class P2UpdateCheckRV implements UpdateCheckData {
		@Nullable
		public final UpdateOperation updateOperation;
		
		public P2UpdateCheckRV(@Nullable UpdateOperation updateOperation) {
			this.updateOperation = updateOperation;
		}
		
		@Override
		public Optional<CancelableOperation<UpdateData>> update(ProgressReporter progressReporter) {
			UpdateOperation updateOperation = this.updateOperation;
			if( updateOperation != null ) {
				ProgressMonitorAdapter a = new ProgressMonitorAdapter(progressReporter);
				SimpleCancelableOperation<UpdateData> op = new SimpleCancelableOperation<>(() -> a.setCanceled(true));

				Job job = updateOperation.getProvisioningJob(a);
				if( job == null ) {
					return Optional.empty();
				}
				job.addJobChangeListener(new JobChangeAdapter() {
					@SuppressWarnings("null")
					@Override
					public void done(IJobChangeEvent event) {
						IStatus s = event.getResult();
						Status state = fromStatus(s);
						Throwable throwable = state.getThrowable();
						if( throwable == null ) {
							op.completed(state,new P2UpdateRV());	
						} else {
							op.completeExceptionally(new StatusException(state));
						}
					}
				});
				job.schedule();
			}
			return Optional.empty();
		}
	}

	static class P2UpdateRV implements UpdateData {
		// empty
	}

	/**
	 * Set the factory to create a logger
	 * 
	 * @param factory
	 *            the factory
	 */
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
	public SimpleCancelableOperation<UpdateCheckData> checkUpdate(ProgressReporter reporter) {
		IProvisioningAgent agent = getProvisioningAgent();
		final ProvisioningSession session = new ProvisioningSession(agent);
		ProgressMonitorAdapter a = new ProgressMonitorAdapter(reporter);

		SimpleCancelableOperation<UpdateCheckData> op = new SimpleCancelableOperation<>(() -> a.setCanceled(true));
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
						op.completed(fromStatus(s),new P2UpdateCheckRV(null));
					} else if( s.isOK() ) {
						op.completed(fromStatus(s),new P2UpdateCheckRV(o));	
					} else {
						throw new StatusException(fromStatus(s));
					}
				} catch(Throwable t) {
					op.completeExceptionally(t);
				}
				return org.eclipse.core.runtime.Status.OK_STATUS;
			}
		};

		o.schedule();
		return op;
	}

	private static IProvisioningAgent getProvisioningAgent() {
		ServiceReference<?> reference = Activator.getContext().getServiceReference(IProvisioningAgent.SERVICE_NAME);
		IProvisioningAgent agent = (IProvisioningAgent) Activator.getContext().getService(reference);
		return agent;
	}

	// TODO enable forced update support in future
	// protected IQueryable<IInstallableUnit> collectUpdateableUnits(
	// IProvisioningAgent agent, final IProgressMonitor monitor)
	// throws ProvisionException {
	// IRepositoryManager<?> manager = (IRepositoryManager<?>) agent
	// .getService(IMetadataRepositoryManager.class.getName());
	//
	// // Get update site uri's from p2.inf.
	//
	// final StringBuffer siteUrlPackage = new StringBuffer();
	//
	// URI[] uris = manager
	// .getKnownRepositories(IRepositoryManager.REPOSITORIES_ALL);
	//
	// if (uris.length == 0) {
	// getLogger().warning("no update repositories found");
	// } else {
	// for (URI uri : uris) {
	// if (siteUrlPackage.length() > 0) {
	// siteUrlPackage.append(",");
	// }
	// // LOGGER.info( "uri found: " + uri.toString() );
	// siteUrlPackage.append(uri.toString());
	// }
	// }
	//
	// if (siteUrlPackage == null || siteUrlPackage.toString().isEmpty()) {
	// throw new IllegalStateException(
	// "No site URL specified. Edit your p2.inf file.");
	// }
	//
	// getLogger().info( "Synch repos: " + siteUrlPackage );
	//
	// String[] siteUrlStrings = siteUrlPackage.toString().split(",");
	// URI[] siteURIs = new URI[siteUrlStrings.length];
	// for (int i = 0; i < siteURIs.length; i++) {
	// try {
	// siteURIs[i] = new URI(siteUrlStrings[i]);
	// } catch (URISyntaxException e) {
	// throw new IllegalStateException(e);
	// }
	// }
	//
	// // Convert URIs into something we can query...
	// IQueryable<IInstallableUnit> allTheIUs = createIUQueryable(siteURIs,
	// agent, monitor);
	// getLogger().debug("query result: " + allTheIUs);
	//
	// return allTheIUs;
	//
	// }
	//
	// public void installUnits(final IProvisioningAgent agent,
	// IQueryable<IInstallableUnit> allTheIUs, IProgressMonitor monitor) {
	// ProvisioningSession session = new ProvisioningSession(agent);
	// /*
	// * Query the metadata repository(ies) for the feature(s) to install.
	// */
	// Collection<IInstallableUnit> toInstall = allTheIUs.query(
	// QueryUtil.createIUGroupQuery(), new NullProgressMonitor())
	// .toUnmodifiableSet();
	// getLogger().info("Everything to synchronize:");
	// logQueryResults(toInstall);
	//
	// SynchronizeOperation operation = new SynchronizeOperation(session,
	// toInstall);
	// IStatus opStatus = operation.resolveModal(monitor);
	// if (opStatus.isOK()) {
	// ProvisioningJob job = operation.getProvisioningJob(null);
	// opStatus = job.runModal(monitor);
	// if (opStatus.getSeverity() == IStatus.CANCEL)
	// throw new OperationCanceledException();
	// }
	// }
	//
	// private void logQueryResults(Collection<IInstallableUnit> toInstall) {
	// if (getLogger().isEnabled(Level.DEBUG)) {
	// StringBuffer iuNames = new StringBuffer("IUs:\n\n ");
	// for (IInstallableUnit iu : toInstall) {
	// iuNames.append(iu.getId() + iu.getVersion() + "\n ");
	// }
	// getLogger().debug(iuNames.toString());
	// }
	// }
	//
	// private IQueryable<IInstallableUnit> createIUQueryable(URI[] p2Sites,
	// IProvisioningAgent agent, IProgressMonitor monitor)
	// throws ProvisionException {
	// IMetadataRepositoryManager metadataManager = (IMetadataRepositoryManager) agent
	// .getService(IMetadataRepositoryManager.SERVICE_NAME);
	// IArtifactRepositoryManager artifactManager = (IArtifactRepositoryManager) agent
	// .getService(IArtifactRepositoryManager.SERVICE_NAME);
	//
	// final Collection<IMetadataRepository> metadataReposList = new LinkedList<IMetadataRepository>();
	// for (URI uri : p2Sites) {
	// getLogger().debug("Adding metadata repo at: " + uri.toString());
	// try {
	// IMetadataRepository metadataRepo = metadataManager
	// .loadRepository(uri, monitor);
	// getLogger().debug(
	// "metadata repository loaded: " + uri.toString());
	// try {
	// artifactManager.loadRepository(uri, monitor); // load the
	// // repo:
	// // this
	// // makes it
	// // available
	// // to us
	// metadataReposList.add(metadataRepo);
	// } catch (NullPointerException e) {
	// getLogger()
	// .warning(
	// "Repository " + uri
	// + " not found, will be ignored", e);
	// }
	// } catch (ProvisionException e) {
	// if (e.getStatus().getCode() == ProvisionException.REPOSITORY_NOT_FOUND) {
	// getLogger()
	// .warning(
	// "Repository " + uri
	// + " not found, will be ignored");
	// } else {
	// getLogger()
	// .warning(
	// "ProvisionException code="
	// + e.getStatus().getCode()
	// + ", return none");
	// throw e;
	// }
	// } catch (OperationCanceledException e) {
	// getLogger().warning("OperationCanceledException, return none");
	// throw e;
	// }
	// }
	// if (metadataReposList.isEmpty()) {
	// getLogger().debug("seems to be correct, return NONE");
	// return null;
	// } else {
	// getLogger().debug("seems to be correct, return SOME");
	// return QueryUtil.compoundQueryable(metadataReposList);
	// }
	// }
	// private Collection<IInstallableUnit> getInstalledIUs() {
	// IProfile profile = session.getProfileRegistry().getProfile(profileId);
	// if (profile == null)
	// return CollectionUtils.emptyList();
	// IQuery<IInstallableUnit> query = new UserVisibleRootQuery();
	// IQueryResult<IInstallableUnit> queryResult = profile.query(query, null);
	// return queryResult.toUnmodifiableSet();
	// }
}
