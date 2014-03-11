package org.eclipse.fx.testcases.e4.parts;

import java.io.IOException;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.fx.ui.di.FXMLBuilder;
import org.eclipse.fx.ui.di.FXMLLoader;
import org.eclipse.fx.ui.di.FXMLLoaderFactory;
import org.osgi.service.event.Event;

public class TestFXMLBuilder {
	@PostConstruct
	public void init(BorderPane p, @FXMLLoader FXMLLoaderFactory factory) {
		FXMLBuilder<Node> b = factory.loadRequestorRelative("TestFXML.fxml");
		try {
			p.setCenter(b.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Inject
	public void setContext(IEclipseContext context) {
		System.err.println("CONTEXT: " + context);
	}
	
	@Inject
	@Optional
	public void receiveEvent(@EventTopic("MyTopic") Event event) {
		System.err.println("Receiving Topic: " + event);
	}
}
