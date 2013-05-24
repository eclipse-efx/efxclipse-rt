package org.eclipse.fx.demo.osgi.di;

import javafx.fxml.FXML;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;

@SuppressWarnings("restriction")
public class FXSubController {
	@Inject
	private PrintService service;
	
	@PostConstruct
	void created(IEclipseContext context) {
		System.err.println("Subcontroller post construction");
	}
	
	@FXML
	void initialize() {
		System.err.println("Subcontroller controller");
	}
	
	@FXML
	void sayHello() {
		service.pring("Subcontroller - Hello World!");
	}
}
