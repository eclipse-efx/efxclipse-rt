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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.operations.ProvisioningSession;
import org.eclipse.equinox.p2.operations.UpdateOperation;
import org.eclipse.fx.core.Callback;
import org.eclipse.fx.core.ReturnValue.State;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerFactory;
import org.eclipse.fx.core.update.UpdateService;
import org.osgi.framework.ServiceReference;
import org.eclipse.fx.core.ReturnValue.ReturnValueImpl;

public class UpdateServiceImpl implements UpdateService {
	private Logger logger;
	private LoggerFactory factory;

	static class P2UpdateCheckRV extends ReturnValueImpl<Boolean> implements
			UpdateCheckData {
		public final UpdateOperation updateOperation;
		
		public P2UpdateCheckRV(UpdateOperation updateOperation, State state,
				String message, Boolean value, Throwable throwable) {
			super(state, message, value, throwable);
			this.updateOperation = updateOperation;
		}
	}

	static class P2UpdateRV extends ReturnValueImpl<Boolean> implements
			UpdateData {

		public P2UpdateRV(State state, String message, Boolean value,
				Throwable throwable) {
			super(state, message, value, throwable);
		}
	}

	public void setLoggerFactory(LoggerFactory factory) {
		this.factory = factory;
		if (logger != null) {
			logger = null;
		}
	}

	public void unsetLoggerFactory(LoggerFactory factory) {
		this.factory = null;
		this.logger = null;
	}

	private Logger getLogger() {
		if (logger == null) {
			logger = factory.createLogger(getClass().getName());
		}
		return logger;
	}

	@Override
	public void update(UpdateCheckData data, final Callback<UpdateData> callback) {
		Job job = ((P2UpdateCheckRV) data).updateOperation.getProvisioningJob(new NullProgressMonitor());
		job.addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				IStatus s = event.getResult();
				State state = fromStatus(s);
				callback.call(new P2UpdateRV(state, s.getMessage(), State.OK == state, s.getException()));
			}
		});
		job.schedule();
	}
	
	private State fromStatus(IStatus s) {
		switch (s.getSeverity()) {
		case IStatus.CANCEL:
			return State.CANCEL;
		case IStatus.ERROR:
			return State.ERROR;
		case IStatus.WARNING:
			return State.WARNING;
		default:
			return State.OK;
		}
	}

	@Override
	public void checkUpdate(final Callback<UpdateCheckData> callback) {
		try {
			IProvisioningAgent agent = getProvisioningAgent();
			final ProvisioningSession session = new ProvisioningSession(agent);
			Job o = new Job("Check for Updates") {
				
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					UpdateOperation o = new UpdateOperation(session);
					IStatus s = o.resolveModal(monitor);
					State state = fromStatus(s);
					callback.call(new P2UpdateCheckRV(o, state, s.getMessage(), state == State.OK,s.getException()));
					return Status.OK_STATUS;
				}
			};
			o.schedule();
		} catch (ProvisionException e) {
			getLogger().error(e.getMessage(), e);
			callback.call(new P2UpdateCheckRV(null, State.ERROR,"Failure while try to collect updateable units", null, e));
		}
	}

	private IProvisioningAgent getProvisioningAgent() throws ProvisionException {
		ServiceReference<?> reference = Activator.getContext()
				.getServiceReference(IProvisioningAgent.SERVICE_NAME);
		IProvisioningAgent agent = (IProvisioningAgent) Activator.getContext()
				.getService(reference);
		return agent;
	}

// TODO enable forced update support in future	
//	protected IQueryable<IInstallableUnit> collectUpdateableUnits(
//			IProvisioningAgent agent, final IProgressMonitor monitor)
//			throws ProvisionException {
//		IRepositoryManager<?> manager = (IRepositoryManager<?>) agent
//				.getService(IMetadataRepositoryManager.class.getName());
//
//		// Get update site uri's from p2.inf.
//
//		final StringBuffer siteUrlPackage = new StringBuffer();
//
//		URI[] uris = manager
//				.getKnownRepositories(IRepositoryManager.REPOSITORIES_ALL);
//
//		if (uris.length == 0) {
//			getLogger().warning("no update repositories found");
//		} else {
//			for (URI uri : uris) {
//				if (siteUrlPackage.length() > 0) {
//					siteUrlPackage.append(",");
//				}
//				// LOGGER.info( "uri found: " + uri.toString() );
//				siteUrlPackage.append(uri.toString());
//			}
//		}
//
//		if (siteUrlPackage == null || siteUrlPackage.toString().isEmpty()) {
//			throw new IllegalStateException(
//					"No site URL specified. Edit your p2.inf file.");
//		}
//
//		getLogger().info( "Synch repos: " + siteUrlPackage );
//
//		String[] siteUrlStrings = siteUrlPackage.toString().split(",");
//		URI[] siteURIs = new URI[siteUrlStrings.length];
//		for (int i = 0; i < siteURIs.length; i++) {
//			try {
//				siteURIs[i] = new URI(siteUrlStrings[i]);
//			} catch (URISyntaxException e) {
//				throw new IllegalStateException(e);
//			}
//		}
//
//		// Convert URIs into something we can query...
//		IQueryable<IInstallableUnit> allTheIUs = createIUQueryable(siteURIs,
//				agent, monitor);
//		getLogger().debug("query result: " + allTheIUs);
//
//		return allTheIUs;
//
//	}
//
//	public void installUnits(final IProvisioningAgent agent,
//			IQueryable<IInstallableUnit> allTheIUs, IProgressMonitor monitor) {
//		ProvisioningSession session = new ProvisioningSession(agent);
//		/*
//		 * Query the metadata repository(ies) for the feature(s) to install.
//		 */
//		Collection<IInstallableUnit> toInstall = allTheIUs.query(
//				QueryUtil.createIUGroupQuery(), new NullProgressMonitor())
//				.toUnmodifiableSet();
//		getLogger().info("Everything to synchronize:");
//		logQueryResults(toInstall);
//
//		SynchronizeOperation operation = new SynchronizeOperation(session,
//				toInstall);
//		IStatus opStatus = operation.resolveModal(monitor);
//		if (opStatus.isOK()) {
//			ProvisioningJob job = operation.getProvisioningJob(null);
//			opStatus = job.runModal(monitor);
//			if (opStatus.getSeverity() == IStatus.CANCEL)
//				throw new OperationCanceledException();
//		}
//	}
//
//	private void logQueryResults(Collection<IInstallableUnit> toInstall) {
//		if (getLogger().isEnabled(Level.DEBUG)) {
//			StringBuffer iuNames = new StringBuffer("IUs:\n\n ");
//			for (IInstallableUnit iu : toInstall) {
//				iuNames.append(iu.getId() + iu.getVersion() + "\n ");
//			}
//			getLogger().debug(iuNames.toString());
//		}
//	}
//
//	private IQueryable<IInstallableUnit> createIUQueryable(URI[] p2Sites,
//			IProvisioningAgent agent, IProgressMonitor monitor)
//			throws ProvisionException {
//		IMetadataRepositoryManager metadataManager = (IMetadataRepositoryManager) agent
//				.getService(IMetadataRepositoryManager.SERVICE_NAME);
//		IArtifactRepositoryManager artifactManager = (IArtifactRepositoryManager) agent
//				.getService(IArtifactRepositoryManager.SERVICE_NAME);
//
//		final Collection<IMetadataRepository> metadataReposList = new LinkedList<IMetadataRepository>();
//		for (URI uri : p2Sites) {
//			getLogger().debug("Adding metadata repo at: " + uri.toString());
//			try {
//				IMetadataRepository metadataRepo = metadataManager
//						.loadRepository(uri, monitor);
//				getLogger().debug(
//						"metadata repository loaded: " + uri.toString());
//				try {
//					artifactManager.loadRepository(uri, monitor); // load the
//																	// repo:
//																	// this
//																	// makes it
//																	// available
//																	// to us
//					metadataReposList.add(metadataRepo);
//				} catch (NullPointerException e) {
//					getLogger()
//							.warning(
//									"Repository " + uri
//											+ " not found, will be ignored", e);
//				}
//			} catch (ProvisionException e) {
//				if (e.getStatus().getCode() == ProvisionException.REPOSITORY_NOT_FOUND) {
//					getLogger()
//							.warning(
//									"Repository " + uri
//											+ " not found, will be ignored");
//				} else {
//					getLogger()
//							.warning(
//									"ProvisionException code="
//											+ e.getStatus().getCode()
//											+ ", return none");
//					throw e;
//				}
//			} catch (OperationCanceledException e) {
//				getLogger().warning("OperationCanceledException, return none");
//				throw e;
//			}
//		}
//		if (metadataReposList.isEmpty()) {
//			getLogger().debug("seems to be correct, return NONE");
//			return null;
//		} else {
//			getLogger().debug("seems to be correct, return SOME");
//			return QueryUtil.compoundQueryable(metadataReposList);
//		}
//	}
//	private Collection<IInstallableUnit> getInstalledIUs() {
//		IProfile profile = session.getProfileRegistry().getProfile(profileId);
//		if (profile == null)
//			return CollectionUtils.emptyList();
//		IQuery<IInstallableUnit> query = new UserVisibleRootQuery();
//		IQueryResult<IInstallableUnit> queryResult = profile.query(query, null);
//		return queryResult.toUnmodifiableSet();
//	}
}
