/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.code.compensator.project.vcs.git;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.fx.code.compensator.model.workbench.VCSRepository;
import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.vcs.VCSRepositoryInstance;
import org.eclipse.fx.code.compensator.project.vcs.VCSRootNavigatorItem;
import org.eclipse.fx.code.compensator.project.vcs.VersionControlService;
import org.eclipse.fx.core.ProgressReporter;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.UnsupportedCredentialItem;
import org.eclipse.jgit.transport.CredentialItem;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.URIish;

public class GitVersionControlService implements VersionControlService {

	@Override
	public String getId() {
		return "git";
	}

	@Override
	public String getLabel() {
		return "Git";
	}

	@Override
	public String getIconURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI cloneRepository(Path localDirectory, String url, String username,
			String password, ProgressReporter reporter) {
		if( url.startsWith("ssh:") ) {
			url = "ssh://"+ username + "@" + url.substring("ssh://".length());
		} else if( url.startsWith("https://") ) {
			url = "https://"+ username + "@" + url.substring("https://".length());
		}
		
		Git result = null;
		try {
			result = Git.cloneRepository().setURI(url).setCredentialsProvider(new SSHCredentialProvider(password)).setDirectory(localDirectory.toFile()).call();
			if( result == null ) {
				throw new IllegalStateException();
			}
			return localDirectory.toUri();
		} catch (GitAPIException e) {
//			return ReturnValue.error("Unable to clone repository", e);
			return null;
		} finally {
			if( result != null ) {
				result.close();
			}
		}
	}
	
	static class SSHCredentialProvider extends CredentialsProvider {
		private String password;
		
		public SSHCredentialProvider(String password) {
			this.password = password;
		}
		
		@Override
		public boolean get(URIish arg0, CredentialItem... items) throws UnsupportedCredentialItem {
			for (CredentialItem item : items) {
                if (item instanceof CredentialItem.StringType) {
                    ((CredentialItem.StringType) item).
                        setValue(password);
                    continue;
                }
            }
            return true;			
		}

		@Override
		public boolean isInteractive() {
			return true;
		}

		@Override
		public boolean supports(CredentialItem... arg0) {
			return true;
		}
		
	}

	@Override
	public VCSRootNavigatorItem mapRepository(ProjectNavigatorItem parent, VCSRepositoryInstance repository) {
		return new GitRepositoryItem(parent, repository, repository.getRootPath());
	}
	

	@Override
	public VCSRepositoryInstance createRepository(InstanceProject project, VCSRepository repository, String uri) {
		return new GitVCSRepositoryInstance(project, repository, this,Paths.get(URI.create(uri)));
	}
}
