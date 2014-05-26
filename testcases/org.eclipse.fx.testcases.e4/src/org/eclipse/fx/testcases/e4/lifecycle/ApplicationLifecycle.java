package org.eclipse.fx.testcases.e4.lifecycle;

import java.net.URL;

import javafx.scene.Node;
import javafx.scene.control.Label;

import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.fx.ui.dialogs.TitleAreaDialog;

public class ApplicationLifecycle {
	@PostContextCreate
	boolean showStartUp() {
		TitleAreaDialog d = new TitleAreaDialog(null,"Application Lifecycle","Application Lifecycle","Sample for @PostContextCreate",(URL)null) {
			
			@Override
			protected Node createDialogContent() {
				return new Label("Proceed?");
			}
		};
		return d.open() == TitleAreaDialog.OK_BUTTON;
	}
}
