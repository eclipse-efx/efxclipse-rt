package org.eclipse.fx.demo.osgi.di;

import javafx.fxml.FXML;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;

@SuppressWarnings("restriction")
public class FXController {
	@Inject
	private PrintService service;
	
	@PostConstruct
	void created(IEclipseContext context) {
		System.err.println("Parent post construction");
	}
	
	@FXML
	void initialize() {
		System.err.println("Parent controller");
	}
	
	@FXML
	void sayHello() {
		service.pring("Hello World!");
	}
}
