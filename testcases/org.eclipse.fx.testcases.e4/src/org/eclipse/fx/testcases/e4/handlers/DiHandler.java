package org.eclipse.fx.testcases.e4.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;

@SuppressWarnings("restriction")
public class DiHandler {
	@CanExecute
	boolean canRun(@Named("test") @Optional Integer i) {
		return i != null && i.intValue() % 2 == 0;
	}
	
	@Execute
	void run(MToolItem item) {
		System.err.println("Running: " + item);
	}

}
