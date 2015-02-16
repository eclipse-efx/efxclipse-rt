package org.eclipse.fx.code.compensator.project.bt.github;

import org.eclipse.fx.code.compensator.model.workbench.BugTracker;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.bt.BugTrackerInstance;
import org.eclipse.fx.code.compensator.project.bt.BugTrackerRootNavigatorItem;
import org.eclipse.fx.code.compensator.project.bt.BugTrackerService;
import org.eclipse.fx.core.URI;

public class GithubBugTrackerService implements BugTrackerService {

	@Override
	public String getLabel() {
		return "Github Issue Tracker";
	}

	@Override
	public String getId() {
		return "github";
	}

	@Override
	public BugTrackerInstance createInstance(BugTracker bugtracker) {
		String url = bugtracker.getBugtrackerUrl();
		String username = bugtracker.getBugtrackerUsername();
		String password = bugtracker.getBugtrackerPassword();
		
		// url has to be
		// https://$host/repos/:owner/:repo/issues
		URI uri = URI.create(url);
		String hostName = uri.host();
		String repoOwner = uri.segment(1);
		String repoName = uri.segment(2);
		
		return new GitHubBucktrackerInstance(this, hostName, username, password, repoOwner, repoName);
	}

	@Override
	public BugTrackerRootNavigatorItem mapRepository(ProjectNavigatorItem parent, BugTrackerInstance instance) {
		return new GithubBugTrackerRootItem(parent, (GitHubBucktrackerInstance) instance);
	}

	public static void main(String[] args) {
		URI uri = URI.create("https://api.github.com/repos/tomsontom/compensator-samples/issues");
		System.err.println(uri.host());
		
		org.eclipse.emf.common.util.URI uri2 = org.eclipse.emf.common.util.URI.createURI("https://api.github.com/repos/tomsontom/compensator-samples/issues");
		System.err.println(uri2.host());
		
		org.eclipse.emf.common.util.URI uri3 = org.eclipse.emf.common.util.URI.createURI("file:/tmp/file.txt");
		System.err.println(uri3.host());
		
	}
}
