/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.xtext.sample.editor.java;

import org.eclipse.fx.xtext.sample.editor.Util;
import org.eclipse.fx.xtext.sample.editor.java.text.FastJavaPartitionScanner;
import org.eclipse.fx.xtext.sample.editor.java.text.IJavaPartitions;
import org.eclipse.fx.xtext.sample.editor.java.text.JavaSourceConfiguration;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.SourceViewer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SampleJavaCode extends Application {
	private final static String[] LEGAL_CONTENT_TYPES = new String[] { IJavaPartitions.JAVA_DOC,
			IJavaPartitions.JAVA_MULTI_LINE_COMMENT, IJavaPartitions.JAVA_SINGLE_LINE_COMMENT,
			IJavaPartitions.JAVA_STRING, IJavaPartitions.JAVA_CHARACTER };

	private int count = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane container = new BorderPane();

		HBox b = new HBox(10);

		Document document = new Document();

		{
			Button load = new Button("Load");
			load.setOnAction(e -> {
				try {
					if (count++ % 2 == 1) {
						document.set(
								Util.getFileContent(getClass().getClassLoader().getResource("Sample_big.txt").toURI()));
					} else {
						document.set(
								Util.getFileContent(getClass().getClassLoader().getResource("Sample.txt").toURI()));
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} );
			b.getChildren().add(load);
		}

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

		JavaSourceConfiguration configuration = new JavaSourceConfiguration();

		SourceViewer viewer = new SourceViewer();

		FastPartitioner partitioner = new FastPartitioner(new FastJavaPartitionScanner(), LEGAL_CONTENT_TYPES);
		document.setDocumentPartitioner(configuration.getConfiguredDocumentPartitioning(viewer), partitioner);
		partitioner.connect(document);

		viewer.configure(configuration);
		viewer.setDocument(document);
		container.setCenter(viewer.getTextWidget());
		Scene s = new Scene(container);
		s.getStylesheets().add(getClass().getResource("bright.css").toExternalForm());
		primaryStage.setScene(s);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}