package org.eclipse.fx.code.compensator.project.bt.github;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.fx.code.compensator.project.bt.BugTrackerInstance;
import org.eclipse.fx.code.compensator.project.bt.BugTrackerService;
import org.eclipse.fx.core.function.ExExecutor;


public class GitHubBucktrackerInstance implements BugTrackerInstance {
	
	private static CommitAction CLOSE = new DefaultAction("Close", "Closes #${id}");
	private static CommitAction FIXES = new DefaultAction("Fixes", "Fixes #${id}");
	private static CommitAction COMMIT_FOR = new DefaultAction("Commit For", "commit for #${id}");
	
	private static final IssueState OPEN_STATE = new DefaultIssueState("Open", null);
	private static final IssueState CLOSE_STATE = new DefaultIssueState("Close", null);
	
	private Repository repository;
	private ObservableList<BugTrackerIssue> issueList = FXCollections.observableArrayList();
	private final GitHubClient client;
	private final String repoOwner;
	private final String repoName; 
	private final GithubBugTrackerService service;
	
	public GitHubBucktrackerInstance(GithubBugTrackerService service, String hostname, String username, String password, String repoOwner, String repoName) {
		this.service = service;
		this.repoOwner = repoOwner;
		this.repoName = repoName;
		
		client = new GitHubClient(hostname);
		client.setCredentials(username, password);
		
		getOpenIssues().thenAccept(l -> {
			List<GitHubBugtrackerIssue> list = l.stream().map(GitHubBugtrackerIssue::new).collect(Collectors.toList());
			Platform.runLater(() -> issueList.setAll(list));
		});
	}
	
	@Override
	public BugTrackerService getService() {
		return service;
	}
	
	private CompletableFuture<Repository> getRepository() {
		if( repository == null ) {
			RepositoryService repoService = new RepositoryService(client);
			return CompletableFuture.supplyAsync(() -> {
				Repository repo = ExExecutor.executeSupplier(() -> repoService.getRepository(repoOwner, repoName), "").get();
				this.repository = repo;
				return repo;
			});
		}
		return CompletableFuture.completedFuture(repository);
	}
	
	private CompletableFuture<List<Issue>> getOpenIssues() {
		return getRepository().handleAsync((r,t) -> {
			try {
				IssueService service = new IssueService(client);
				List<Issue> list = service.getIssues(r, Collections.singletonMap(IssueService.FILTER_STATE, IssueService.STATE_OPEN));
				System.err.println(list);
				return list;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
	}
	
	@Override
	public List<CommitAction> getCommitActions() {
		return Arrays.asList(COMMIT_FOR,CLOSE,FIXES);
	}

	@Override
	public ObservableList<BugTrackerIssue> getIssues() {
		return issueList;
	}
	
	public CharSequence getLabel() {
		return repoName + "@" + repoOwner;
	}
	
	static class GitHubBugtrackerIssue implements BugTrackerIssue {
		private final Issue issue;
		private ObservableList<BugFollowUp> followUp = FXCollections.observableArrayList();
		
		public GitHubBugtrackerIssue(Issue issue) {
			this.issue = issue;
		}
		
		@Override
		public String getId() {
			return this.issue.getNumber() + "";
		}

		@Override
		public String getTitle() {
			return issue.getTitle();
		}

		@Override
		public String getDescription() {
			return issue.getBodyText();
		}

		@Override
		public IssueState getState() {
			return IssueService.STATE_CLOSED.equals(issue.getState()) ? CLOSE_STATE : OPEN_STATE;
		}

		@Override
		public ObservableList<BugFollowUp> getFollowUpList() {
			return followUp;
		}
		
	}
}
