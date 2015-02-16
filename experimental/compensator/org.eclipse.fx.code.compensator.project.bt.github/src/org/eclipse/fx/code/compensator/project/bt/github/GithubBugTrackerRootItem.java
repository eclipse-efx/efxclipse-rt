package org.eclipse.fx.code.compensator.project.bt.github;

import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener.Change;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.bt.BugTrackerInstance.BugTrackerIssue;
import org.eclipse.fx.code.compensator.project.bt.BugTrackerRootNavigatorItem;
import org.eclipse.fx.core.URI;

public class GithubBugTrackerRootItem implements BugTrackerRootNavigatorItem {
	private final ProjectNavigatorItem parent;
	private final GitHubBucktrackerInstance instance;
	private final ObservableList<ProjectNavigatorItem> openIssues = FXCollections.observableArrayList();
	
	public GithubBugTrackerRootItem(ProjectNavigatorItem parent, GitHubBucktrackerInstance instance) {
		this.parent = parent;
		this.instance = instance;
		this.instance.getIssues().addListener(this::handleOpenIssuesChange);
	}
	
	private void handleOpenIssuesChange(Change<? extends BugTrackerIssue> change) {
		while( change.next() ) {
			if( change.getAddedSize() > 0 ) {
				openIssues.addAll(change.getFrom(), change.getAddedSubList().stream().map( b -> new BugTrackerItem(this, b)).collect(Collectors.toList()));	
			}
			if( change.getRemovedSize() > 0 ) {
				openIssues.removeIf( e -> change.getRemoved().contains(e.getDomainObject()) );
			}
		}
	}
	
	@Override
	public CharSequence getLabel() {
		return instance.getLabel();
	}

	@Override
	public URI getIcon() {
		return URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project.bt.github", "css/icons/16/fileFolderType_filter.png");
	}

	@Override
	public Object getDomainObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOpenCommandId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDeletable() {
		return false;
	}

	@Override
	public ObservableList<ProjectNavigatorItem> getChildren() {
		return openIssues;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public ProjectNavigatorItem getParent() {
		return this.parent;
	}

	static class BugTrackerItem implements ProjectNavigatorItem {
		private final BugTrackerIssue issue;
		private final ProjectNavigatorItem parent;
		
		public BugTrackerItem(ProjectNavigatorItem parent, BugTrackerIssue issue) {
			this.issue = issue;
			this.parent = parent;
		}
		
		@Override
		public CharSequence getLabel() {
			return this.issue.getId() + " - " + this.issue.getTitle();
		}

		@Override
		public URI getIcon() {
			return URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project.bt.github", "css/icons/16/script-error.png");
		}

		@Override
		public Object getDomainObject() {
			return this.issue;
		}

		@Override
		public String getOpenCommandId() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isDeletable() {
			return false;
		}

		@Override
		public ObservableList<ProjectNavigatorItem> getChildren() {
			return FXCollections.emptyObservableList();
		}

		@Override
		public boolean isLeaf() {
			return true;
		}

		@Override
		public ProjectNavigatorItem getParent() {
			return parent;
		}
		
	}
	
}
