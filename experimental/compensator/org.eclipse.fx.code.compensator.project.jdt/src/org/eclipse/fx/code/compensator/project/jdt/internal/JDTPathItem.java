package org.eclipse.fx.code.compensator.project.jdt.internal;

import org.eclipse.fx.code.compensator.project.ProjectNavigatorItem;


public interface JDTPathItem extends ProjectNavigatorItem {
	public JDTModuleItem getModuleItem();
	public JDTInstanceProject getJdtProject();
}
