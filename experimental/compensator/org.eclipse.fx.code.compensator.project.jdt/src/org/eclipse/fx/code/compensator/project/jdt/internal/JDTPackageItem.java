package org.eclipse.fx.code.compensator.project.jdt.internal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.BiFunction;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.navigator.FileItem;
import org.eclipse.fx.code.compensator.project.navigator.FolderItem;
import org.eclipse.fx.code.compensator.project.navigator.PathItem;


public class JDTPackageItem extends FolderItem implements ProjectNavigatorItem, JDTPathItem {
	private static BiFunction<Path, FolderItem, PathItem> FACTORY = (p,i) -> {
		//FIXME We need to as the backend if this is a managed file
		if( ! Files.isDirectory(p) && p.getFileName().toString().endsWith(".java") ) {
			return new JDTFileItem(i,p);
		}
		return new FileItem(i,p);
	};

	public JDTPackageItem(FolderItem parent, Path p) {
		super(parent,p,FACTORY);
	}

	public String getIcon() {
		return "platform:/plugin/org.eclipse.fx.code.compensator.project.jdt/css/icons/16/package_obj.png";
	}

	@Override
	public JDTModuleItem getModuleItem() {
		return ((JDTPathItem)parent).getModuleItem();
	}

	@Override
	public JDTInstanceProject getJdtProject() {
		return ((JDTPathItem)parent).getJdtProject();
	}
}
