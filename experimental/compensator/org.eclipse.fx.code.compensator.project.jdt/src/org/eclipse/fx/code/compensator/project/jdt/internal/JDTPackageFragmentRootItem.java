package org.eclipse.fx.code.compensator.project.jdt.internal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.BiFunction;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;
import org.eclipse.fx.code.compensator.project.navigator.FolderItem;
import org.eclipse.fx.code.compensator.project.navigator.PathItem;

public class JDTPackageFragmentRootItem extends FolderItem implements ProjectNavigatorItem, JDTPathItem {
	private JDTModuleItem moduleItem;

	static final BiFunction<Path, FolderItem, PathItem> FACTORY = (p,i) -> {
		if( Files.isDirectory(p) ) {
			return new JDTPackageItem(i,p);
		} else {
			return new JDTFileItem(i,p);
		}
	};

	public JDTPackageFragmentRootItem(JDTModuleItem moduleItem, Path path) {
		super(moduleItem,path,FACTORY);
		this.moduleItem = moduleItem;
	}

	@Override
	public JDTModuleItem getModuleItem() {
		return moduleItem;
	}

	@Override
	public CharSequence getLabel() {
		return moduleItem.getPath().relativize(path).toString();
	}

	@Override
	public String getIcon() {
		return "platform:/plugin/org.eclipse.fx.code.compensator.project.jdt/css/icons/16/packagefolder_obj.png";
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

}
