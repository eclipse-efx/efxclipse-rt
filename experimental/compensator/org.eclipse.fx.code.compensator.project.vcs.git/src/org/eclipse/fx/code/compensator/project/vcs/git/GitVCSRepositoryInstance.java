package org.eclipse.fx.code.compensator.project.vcs.git;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javafx.scene.control.ButtonType;

import org.eclipse.fx.code.compensator.model.workbench.VCSRepository;
import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.vcs.VCSRepositoryInstance;
import org.eclipse.fx.code.compensator.project.vcs.VersionControlService;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.UnsupportedCredentialItem;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialItem;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.URIish;

public class GitVCSRepositoryInstance implements VCSRepositoryInstance {
	private Path path;
	private Repository repo;
	private Git git;
	
	private final GitVersionControlService service;
	private final InstanceProject project;
	private final VCSRepository repository;
	
	public GitVCSRepositoryInstance(InstanceProject project, VCSRepository repository, GitVersionControlService service, Path path) {
		this.service = service;
		this.project = project;
		this.repository = repository;
		this.path = path;
		try {
			FileRepositoryBuilder builder = new FileRepositoryBuilder();
			repo = builder.setGitDir(new File(path.toFile(),".git")).readEnvironment().findGitDir().build();
			git = new Git(repo);
//			git.branchCreate().setName("master")
//            .setUpstreamMode(SetupUpstreamMode.SET_UPSTREAM)
//            .setStartPoint("origin/master").setForce(true).call();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Override
	public VersionControlService getService() {
		return service;
	}
	
	@Override
	public Path getRootPath() {
		return path;
	}

	@Override
	public void fetch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void push() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit(Collection<Path> pathList) {
		
		GitCommitDialog dialog = new GitCommitDialog(project.getBugtrackerInstanceList(), pathList);
		dialog.showAndWait().ifPresent( this::handleCommit );
		
		
	}

	private void handleCommit(CommitData c) {
		if( c.type != GitCommitDialog.cancel ) {
			CommitCommand cmd = git.commit();
			for( Path p : c.paths ) {
				System.err.println("PATH: " + p);
				cmd.setOnly(path.relativize(p).toString());
			}
			cmd
				.setMessage(c.message)
				.setAmend(c.amend);
			
			try {
				cmd.call();
				
				if(c.type == GitCommitDialog.push) {
					git.push().setCredentialsProvider(new SSHCredentialProvider(repository.getRepoPassword())).add("master").call();
				}
			} catch (GitAPIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static class CommitData {
		public final ButtonType type;
		public final String message;
		public final Collection<Path> paths;
		public final boolean amend;
		public final boolean gerritChange;
		
		public static CommitData CANCEL = new CommitData(ButtonType.CANCEL, "", Collections.emptyList(), false, false);
		
		public CommitData(ButtonType type, String message, Collection<Path> paths, boolean amend, boolean gerritChange) {
			this.type = type;
			this.message = message;
			this.paths = paths;
			this.amend = amend;
			this.gerritChange = gerritChange;
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
}
