package org.eclipse.fx.xtext.sample.editor.statemachine;

import java.io.File;

import org.eclipse.fx.xtext.sample.editor.Util;
import org.eclipse.fx.xtext.statemachine.fx.text.IStatemachinePartitions;
import org.eclipse.fx.xtext.statemachine.fx.text.StatemachinePartitionScanner;
import org.eclipse.fx.xtext.statemachine.fx.text.StatemachineSourceConfiguration;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.SourceViewer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SampleStatemachineCode extends Application {
	private final static String[] LEGAL_CONTENT_TYPES = new String[] {
		IStatemachinePartitions.MULTI_LINE_COMMENT
	};
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane container = new BorderPane();
		
		HBox b = new HBox(10);
		
		{
			Button bright = new Button("Bright");
			b.getChildren().add(bright);
			bright.setOnAction(e -> bright.getScene().getStylesheets()
					.setAll(getClass().getResource("bright.css").toExternalForm()));
		}

		{
			Button dark = new Button("Dark");
			b.getChildren().add(dark);
			dark.setOnAction(
					e -> dark.getScene().getStylesheets().setAll(getClass().getResource("dark.css").toExternalForm()));
		}

		container.setTop(b);
		
		Document document = new Document();
		document.set(Util.getFileContent(getClass().getClassLoader().getResource("StateSample.state").toURI()));

		StatemachineSourceConfiguration configuration = new StatemachineSourceConfiguration(document, new File("/Users/tomschindl/Documents/e-workspaces/efxclipse_xtext/org.eclipse.fx.xtext.sample.editor/src/StateSample.state"));

		SourceViewer viewer = new SourceViewer();
		
		FastPartitioner partitioner = new FastPartitioner(new StatemachinePartitionScanner(), LEGAL_CONTENT_TYPES);
		document.setDocumentPartitioner(configuration.getConfiguredDocumentPartitioning(viewer), partitioner);
//		document.setDocumentPartitioner(partitioner);
		partitioner.connect(document);
		
		viewer.configure(configuration);
		viewer.setDocument(document);
		container.setCenter(viewer.getTextWidget());
		Scene s = new Scene(container);
		s.getStylesheets().add(getClass().getResource("bright.css").toExternalForm());
		primaryStage.setScene(s);
		primaryStage.show();
		System.err.println(viewer.getTextWidget().getStyleRanges(0, document.getLength(), true).length);
	}

	public static void main(String[] args) {
		launch(args);
		System.exit(0);
	}
}