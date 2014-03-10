package org.eclipse.fx.runtime.examples.swt;

import java.lang.reflect.Method;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppLauncher extends Application {
	private static String MAIN_CLASS;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.err.println("IN START");
		Method m = Class.forName(MAIN_CLASS).getMethod("main", new String[0].getClass());
		Object o = new String[0];
		m.invoke(null, o);
	}

	public static void main(String[] args) {
		MAIN_CLASS = args[0];
		launch(args);
	}
}
