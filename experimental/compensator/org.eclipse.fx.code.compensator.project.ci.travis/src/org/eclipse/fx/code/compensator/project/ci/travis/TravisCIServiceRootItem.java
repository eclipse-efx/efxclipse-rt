package org.eclipse.fx.code.compensator.project.ci.travis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.ci.CIServiceInstance;
import org.eclipse.fx.code.compensator.project.ci.CIServiceRootNavigatorItem;
import org.eclipse.fx.core.URI;
import org.eclipse.fx.travisci.client.BuildsEndpoint;
import org.eclipse.fx.travisci.client.BuildsEndpoint.BuildsQuery;
import org.eclipse.fx.travisci.client.entities.Build;
import org.eclipse.fx.travisci.client.impl.TravisCIClientImpl;

public class TravisCIServiceRootItem implements CIServiceRootNavigatorItem {
	private final ProjectNavigatorItem parent;
	private final CIServiceInstance instance;
	private final ObservableList<ProjectNavigatorItem> items = FXCollections.observableArrayList();
	private List<Build> currentList;
	
	public TravisCIServiceRootItem(ProjectNavigatorItem parent, CIServiceInstance instance) {
		this.parent = parent;
		this.instance = instance;
		
		Thread t = new Thread() {
			@Override
			public void run() {
				TravisCIClientImpl c = new TravisCIClientImpl("travis-java-client-test", "api.travis-ci.org");
				BuildsEndpoint endpoint = c.createEndpoint(BuildsEndpoint.class);
//				while( true ) {
					Stream<Build> builds = endpoint.getBuilds(BuildsQuery.bySlug("tomsontom/compensator-samples"));
					List<Build> collect = builds.collect(Collectors.toList());
					
//					if( currentList != null && currentList.size() == collect.size() ) {
//						try {
//							Thread.sleep(10_000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						continue;
//					}
//					
//					currentList = collect;
					
					List<Build> items = new ArrayList<Build>();
					if( collect.size() > 10 ) {
						Optional<Build> lastSuccess = collect.stream().filter( b -> b.state().equals("passed") ).findFirst();
						if( ! lastSuccess.isPresent() ) {
							for( int i = 0; i < 10; i++ ) {
								items.add(collect.get(i));
							}
						} else {
							if( collect.indexOf(lastSuccess.get()) > 9 ) {
								for( int i = 0; i < 9; i++ ) {
									items.add(collect.get(i));
								}
								items.add(lastSuccess.get());
							} else {
								for( int i = 0; i < 10; i++ ) {
									items.add(collect.get(i));
								}
							}
						}
					} else {
						items.addAll(collect);
					}
					
					IEventBroker eventBroker = instance.getProject().getEventBroker();
					eventBroker.post("org/eclipse/fx/code/compensator/cibundleinfo", items.get(0).state().equals("passed") ? "success" : "failed");
						
					Platform.runLater(() -> {
						TravisCIServiceRootItem.this.items.clear();
						TravisCIServiceRootItem.this.items.setAll(items.stream().map((b) -> new TravisBuild(b, TravisCIServiceRootItem.this)).collect(Collectors.toList()));
					});	
					
//					try {
//						Thread.sleep(10_000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
			}
		};
		t.setDaemon(true);
		t.start();
	}
	
	@Override
	public CharSequence getLabel() {
		return "Travis";
	}

	@Override
	public URI getIcon() {
		return null;
	}

	@Override
	public Object getDomainObject() {
		return instance;
	}

	@Override
	public String getOpenCommandId() {
		return "org.eclipse.fx.code.compensator.project.ci.travis.command.openTravisViewer";
	}

	@Override
	public boolean isDeletable() {
		return true;
	}

	@Override
	public ObservableList<ProjectNavigatorItem> getChildren() {
		return items;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public ProjectNavigatorItem getParent() {
		return parent;
	}

	static class TravisBuild implements ProjectNavigatorItem {

		private Build build;
		
		private ProjectNavigatorItem parent;

		public TravisBuild(Build build, ProjectNavigatorItem parent) {
			this.build = build;
			this.parent = parent;
		}
		
		@Override
		public CharSequence getLabel() {
			return build.number();
		}

		@Override
		public URI getIcon() {
			return "passed".equals(build.state()) ? URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project.ci.travis", "icons/security-high.png") : URI.createPlatformPluginURI("org.eclipse.fx.code.compensator.project.ci.travis", "icons/security-low.png");
		}

		@Override
		public Object getDomainObject() {
			return build;
		}

		@Override
		public String getOpenCommandId() {
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
