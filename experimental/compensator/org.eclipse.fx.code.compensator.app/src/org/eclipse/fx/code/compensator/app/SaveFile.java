package org.eclipse.fx.code.compensator.app;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;

public class SaveFile {
	@CanExecute
	public boolean canSave(MPart part) {
		return part.isDirty();
	}

	@Execute
	public void save(MPart part, IEclipseContext context) {
		if( part.isDirty() ) {
			ContextInjectionFactory.invoke(part.getObject(), Persist.class,context);
		}
	}
}
