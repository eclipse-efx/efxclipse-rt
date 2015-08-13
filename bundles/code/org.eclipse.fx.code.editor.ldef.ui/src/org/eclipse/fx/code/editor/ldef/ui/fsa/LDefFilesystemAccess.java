package org.eclipse.fx.code.editor.ldef.ui.fsa;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;

public class LDefFilesystemAccess extends EclipseResourceFileSystemAccess2 {
	@Override
	protected IFile getFile(String fileName, String outputName, IProgressMonitor progressMonitor) {
		if( fileName.startsWith("/") ) {
			URI uri = URI.createPlatformResourceURI(fileName, true);
			IFile findMember = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
			return findMember;
		} else {
			return super.getFile(fileName, outputName, progressMonitor);
		}
	}
}
