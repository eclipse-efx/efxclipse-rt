package application;
	
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.fx.ui.viewer.ContentProvider;
import org.eclipse.fx.ui.viewer.ContentProviderFactory;
import org.eclipse.fx.ui.viewer.ListViewer;
import org.eclipse.fx.ui.viewer.TableViewer;
import org.eclipse.fx.ui.viewer.ViewerFactory;
import org.eclipse.fx.ui.viewer.javafx.JavaFXViewerFactory;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			ViewerFactory factory = new JavaFXViewerFactory();
			TabPane tb = new TabPane();
			
			{
				Tab t = new Tab("ListViewer");
				BorderPane container = new BorderPane();
				factory.createListViewer(container, this::setupListViewer);
				t.setContent(container);
				tb.getTabs().add(t);
			}

			{
				Tab t = new Tab("TableViewer");
				BorderPane container = new BorderPane();
				factory.createTableViewer(container, this::setupTableViewer);
				t.setContent(container);
				tb.getTabs().add(t);
			}
			
			root.setCenter(tb);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setupTableViewer(TableViewer<List<Person>,Person,ContentProvider<List<Person>,Person>> viewer) {
		viewer.createColumn("firstname", this::firstname).graphicProvider(this::genderImage).setLabel("Firstname");
		viewer.createColumn("lastname", this::lastname).setLabel("Lastname");
		viewer.createColumn("birthday", this::bithdate).textProvider(format::format).setLabel("Birthday");
		viewer.setContentProvider(ContentProviderFactory::createListContentProvider);
		viewer.setInput(this::listInput);
	}
	
	private void setupListViewer(ListViewer<Person[],Person,ContentProvider<Person[],Person>> viewer) {
		viewer.textProvider(this::personFullText).graphicProvider(this::genderImage);
		viewer.setContentProvider(ContentProviderFactory::createArrayContentProvider);
		viewer.setInput(this::arrayInput);
	}
	
	private List<Person> listInput() {
		try {
			return Arrays.asList(
					new Person(false, "Tom", "Schindl", format.parse("01.05.1979")),
					new Person(true, "Maria", "Musterfrau", format.parse("01.05.1970"))
			);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	private Person[] arrayInput() {
		try {
			return new Person[] {
					new Person(false, "Tom", "Schindl", format.parse("01.05.1979")),
					new Person(true, "Maria", "Musterfrau", format.parse("01.05.1970"))
			};
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Person[0];
	}
		
	private String firstname(Person p) {
		return p.getFirstname();
	}
	
	private String lastname(Person p) {
		return p.getLastname();
	}
	
	private Date bithdate(Person p) {
		return p.getBirthdate();
	}
	
	private String genderImage(Person p, String name) {
		return p.isFemale() ? "file:/female.png" : "file:/male.png";
	}
	
	private String personFullText(Person p) {
		return p.getFirstname() + ", " + p.getLastname() + " ("+format.format(p.getBirthdate())+")";
	}
	
	private String genderImage(Person p) {
		return p.isFemale() ? "file:/female.png" : "file:/male.png";
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
