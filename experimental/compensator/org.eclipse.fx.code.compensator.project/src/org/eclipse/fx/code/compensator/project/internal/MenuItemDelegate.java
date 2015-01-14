package org.eclipse.fx.code.compensator.project.internal;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.fx.core.di.ScopedObjectFactory;

public class MenuItemDelegate {
	@Execute
	public void run(ScopedObjectFactory f, MDirectMenuItem item) {
		f.invoke(item.getTransientData().get("delegate"));
	}
}
