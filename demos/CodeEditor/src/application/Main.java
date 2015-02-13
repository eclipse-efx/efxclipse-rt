package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import application.text.FastJavaPartitionScanner;
import application.text.IJavaPartitions;
import application.text.JavaSourceConfiguration;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		MenuBar b = new MenuBar();
		Menu m = new Menu("File");
		MenuItem item = new MenuItem("Open ...");
		m.getItems().add(item);
		b.getMenus().add(m);
		
		{
			Menu themes = new Menu("Themes");
			
			ToggleGroup g = new ToggleGroup();
			
			RadioMenuItem defaultTheme = new RadioMenuItem("Default");
			defaultTheme.setSelected(true);
			defaultTheme.setOnAction(e -> {
				Scene scene = primaryStage.getScene();
				scene.getStylesheets().clear();
				scene.getStylesheets().add(getClass().getResource("default.css").toExternalForm());
				scene.getStylesheets().add(Main.class.getResource("highlight.css").toExternalForm());

			});
			
			RadioMenuItem dark = new RadioMenuItem("Dark");
			dark.setOnAction(e -> {
				Scene scene = primaryStage.getScene();
				scene.getStylesheets().clear();
				scene.getStylesheets().add(getClass().getResource("dark-default.css").toExternalForm());
				scene.getStylesheets().add(Main.class.getResource("dark-highlight.css").toExternalForm());

			});
			themes.getItems().addAll(defaultTheme,dark);
			
			m.getItems().add(themes);
			g.getToggles().addAll(defaultTheme,dark);
		}
		
		root.setTop(b);
		
		TabPane tabPane = new TabPane();
		root.setCenter(tabPane);
		
		m.setOnAction(e -> {
			FileChooser c = new FileChooser();
			c.getExtensionFilters().add(new ExtensionFilter("Java Source Files", Collections.singletonList("*.java")));
			c.setSelectedExtensionFilter(c.getExtensionFilters().get(0));
			List<File> showOpenMultipleDialog = c.showOpenMultipleDialog(primaryStage);
			if( showOpenMultipleDialog != null ) {
				for( File f : showOpenMultipleDialog ) {
					Path path = Paths.get(f.toURI());
					Tab t = new Tab(path.getFileName().toString());
					t.setContent(createViewer(path).getTextWidget());
					tabPane.getTabs().add(t);
				}				
			}
		});

		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("default.css").toExternalForm());
		scene.getStylesheets().add(Main.class.getResource("highlight.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public SourceViewer createViewer(Path p) {
		SourceViewer viewer = new SourceViewer();
		SourceViewerConfiguration configuration = createConfig();
		Document document = createDocument(p);
		IDocumentPartitioner partitioner = createPartitioner();

		if (document instanceof IDocumentExtension3) {
			((IDocumentExtension3) document).setDocumentPartitioner(
					configuration.getConfiguredDocumentPartitioning(viewer), partitioner);
		} else {
			document.setDocumentPartitioner(partitioner);
		}
		document.setDocumentPartitioner(partitioner);
		partitioner.connect(document);

		viewer.configure(configuration);
		viewer.setDocument(document);
		return viewer;

	}

	private SourceViewerConfiguration createConfig() {
		return new JavaSourceConfiguration();
	}

	private IDocumentPartitioner createPartitioner() {
		return new FastPartitioner(new FastJavaPartitionScanner(), new String[] { IJavaPartitions.JAVA_DOC,
				IJavaPartitions.JAVA_MULTI_LINE_COMMENT, IJavaPartitions.JAVA_SINGLE_LINE_COMMENT,
				IJavaPartitions.JAVA_STRING, IJavaPartitions.JAVA_CHARACTER });
	}

	private Document createDocument(Path p) {
		return new Document(getFile(p));
	}

	private String getFile(Path p) {
		try (BufferedReader reader = Files.newBufferedReader(p)) {
			StringBuilder b = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				// FIXME We need to replace TABs for now
				b.append(line.replaceAll("\t", "    ") + "\n");
			}
			reader.close();
			return b.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) {
		launch(args);
	}
}
