package org.eclipse.fx.ui.preferences.app;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.ui.preferences.PreferencePage;
import org.eclipse.fx.ui.preferences.PreferencePageFactory;
import org.eclipse.fx.ui.preferences.PreferencePageProvider;
import org.eclipse.fx.ui.preferences.PreferenceUI;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApplication {
	@Inject
	private IEclipseContext context;

	@Inject
	public MainApplication() {

	}

	@PostConstruct
	void run(IApplicationContext applicationContext, javafx.application.Application jfxApplication,
			Stage primaryStage) {

		BorderPane pane = new BorderPane();

		IEclipseContext preferenceCtx = context.createChild("Preference");
		preferenceCtx.set(BorderPane.class, pane);

		ContextInjectionFactory.make(PreferenceUI.class, preferenceCtx);

		Scene s = new Scene(pane);
		primaryStage.setScene(s);
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setTitle("Preference Sample");
		primaryStage.show();
	}
}
