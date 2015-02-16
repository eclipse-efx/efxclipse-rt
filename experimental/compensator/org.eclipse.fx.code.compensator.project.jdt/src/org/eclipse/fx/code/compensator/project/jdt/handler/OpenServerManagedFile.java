package org.eclipse.fx.code.compensator.project.jdt.handler;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
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
import org.eclipse.fx.code.compensator.model.workbench.Module;
import org.eclipse.fx.code.compensator.model.workbench.Project;

public class OpenServerManagedFile {
	@Execute
	public void open(
			Project project,
			EModelService modelService, 
			EPartService partService, 
			MPerspective perspective, 
			FileIconLookup fileLookup,
			@Named("projectid") String projectId, 
			@Named("moduleName") String modulename, 
			@Named("modulePath") String modulePath) {
		System.err.println("RUNNING");
		MPartStack element = (MPartStack) modelService.find("org.eclipse.fx.code.compensator.project.partstack.1", perspective);
		
		String url = "jdt:/"+projectId+"/"+modulename+"/"+modulePath;

		for( MStackElement p : element.getChildren() ) {
			if( url.equals(p.getPersistedState().get(TextEditor.DOCUMENT_URL)) ) {
				partService.showPart((MPart)p, PartState.ACTIVATE);
			}
		}
		
		String moduleRoot = null;
		for( Module m : project.getModuleList() ) {
			if( m.getName().equals(modulename) ) {
				moduleRoot = m.getRootFolderUrl();
			}
		}

		MPart p = modelService.createModelElement(MPart.class);
		p.setContributionURI("bundleclass://org.eclipse.fx.code.compensator.editor/org.eclipse.fx.code.compensator.editor.TextEditor");
		p.getPersistedState().put(TextEditor.DOCUMENT_URL, url);
		p.getPersistedState().put(TextEditor.VCS_URL, moduleRoot + "/" + modulePath);
		
		p.setLabel(URI.createURI(url).lastSegment());
		p.setIconURI(fileLookup.getFileIcon(url).toString());
		p.setCloseable(true);
		p.getTags().add(EPartService.REMOVE_ON_HIDE_TAG);
		element.getChildren().add(p);
		partService.showPart(p, PartState.ACTIVATE);
	}
}
