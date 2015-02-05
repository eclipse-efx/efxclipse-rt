package org.eclipse.fx.code.compensator.project.jdt.internal;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.emf.common.util.URI;
import org.eclipse.fx.code.compensator.editor.TextEditor;
import org.eclipse.fx.code.compensator.editor.services.FileIconLookup;
import org.eclipse.fx.code.compensator.model.workbench.LocalProject;
import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.Project;
import org.eclipse.fx.code.compensator.model.workbench.VCSRepository;
import org.eclipse.fx.code.compensator.project.InstanceProject;
import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.vcs.VersionControlService;
import org.eclipse.fx.code.server.jdt.JDTServer;
import org.eclipse.fx.core.di.Service;

public class JDTInstanceProject extends InstanceProject {
	private final JDTServer projectServer;
	private final EPartService partService;
	private final EModelService modelService;
	private final MPerspective perspective;
	private final FileIconLookup fileLookup;

	@Inject
	public JDTInstanceProject(
			IEventBroker eventBroker,
			JDTServer projectServer,
			Project project,
			EPartService partService,
			EModelService modelService,
			MPerspective perspective,
			FileIconLookup fileLookup,
			@Service List<VersionControlService> versionControlService) {
		super(eventBroker, project, versionControlService);
		this.projectServer = projectServer;
		this.partService = partService;
		this.modelService = modelService;
		this.perspective = perspective;
		this.fileLookup = fileLookup;
	}

	public FileIconLookup getFileLookup() {
		return fileLookup;
	}

	public JDTServer getProjectServer() {
		return projectServer;
	}

	@Override
	public ProjectNavigatorItem mapModule(ProjectNavigatorItem parent, Module module) {
		return new JDTModuleItem(parent, module, this);
	}

	@Override
	public boolean openItem(ProjectNavigatorItem item) {
		if( item instanceof JDTFileItem ) {
			JDTFileItem jdtItem = (JDTFileItem) item;
			MPartStack element = (MPartStack) modelService.find("org.eclipse.fx.code.compensator.project.partstack.1", perspective);

			JDTModuleItem moduleItem = jdtItem.getModuleItem();
			Path path = moduleItem.getModuleRelativePath(jdtItem.getDomainObject());
			String url = "jdt:/"+getProject().getName()+"/"+moduleItem.getDomainObject().getName()+"/"+path.toString();

			for( MStackElement p : element.getChildren() ) {
				if( url.equals(p.getPersistedState().get(TextEditor.DOCUMENT_URL)) ) {
					partService.showPart((MPart)p, PartState.ACTIVATE);
					return true;
				}
			}

			MPart p = modelService.createModelElement(MPart.class);
			p.setContributionURI("bundleclass://org.eclipse.fx.code.compensator.editor/org.eclipse.fx.code.compensator.editor.TextEditor");
			p.getPersistedState().put(TextEditor.DOCUMENT_URL, url);
			
			Path repoRelativePath = null;
			Path vcsPathRoot = null;
			
			for( VCSRepository r : ((LocalProject)getProject()).getVcsRepositoryList() ) {
				Path vcsPath = Paths.get(java.net.URI.create(r.getLocalURI()));
				if( jdtItem.getDomainObject().startsWith(vcsPath) ) {
					repoRelativePath = vcsPath.relativize(jdtItem.getDomainObject());
					vcsPathRoot = vcsPath;
					break;
				}
			}
			
			if( vcsPathRoot != null ) {
				p.getPersistedState().put(TextEditor.VCS_URL, "vcs:git:"+vcsPathRoot.toUri()+"?"+repoRelativePath.getFileName().toString());
			}
			
			p.setLabel(URI.createURI(url).lastSegment());
			p.setIconURI(fileLookup.getFileIcon(url).toString());
			p.setCloseable(true);
			p.getTags().add(EPartService.REMOVE_ON_HIDE_TAG);
			element.getChildren().add(p);
			partService.showPart(p, PartState.ACTIVATE);
			return true;
		}
		return false;
	}	
}