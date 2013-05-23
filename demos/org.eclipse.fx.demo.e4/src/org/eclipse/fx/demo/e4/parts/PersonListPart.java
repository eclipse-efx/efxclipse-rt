package org.eclipse.fx.demo.e4.parts;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.fx.demo.e4.model.Person;

@SuppressWarnings("restriction")
public class PersonListPart {
	@Inject
	public PersonListPart(BorderPane parent, final MApplication application) {
		ListView<Person> view = new ListView<Person>();
		view.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {
			
			public ListCell<Person> call(ListView<Person> arg0) {
				return new PersonCell();
			}
		});
		view.setId("detail-list");
		view.getItems().addAll(createList());
		
		view.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {

			public void changed(ObservableValue<? extends Person> arg0, Person arg1, Person arg2) {
				application.getContext().set(Person.class, arg2);
			}
		});
		
		parent.setCenter(view);
	}
	
	static class PersonCell extends ListCell<Person> {
		@Override
		protected void updateItem(Person arg0, boolean arg1) {
			super.updateItem(arg0, arg1);
			if( arg0 == null ) {
				setText("");
			} else {
				setText(arg0.getFirstname() + ", " + arg0.getLastname());	
			}
			
		}
	}
	
	private List<Person> createList() {
		List<Person> rv = new ArrayList<Person>();
		
		{
			Person p = new Person("Tom","Schindl");
			p.setStreet("Bahnhofstrasse 1");
			p.setZip("6020");
			p.setCity("Innsbruck");
			rv.add(p);	
		}
		
		{
			Person p = new Person("John","Doe");
			p.setStreet("Mainstreet 1");
			p.setZip("E10E4");
			p.setCity("San Francisco");
			rv.add(p);
		}
		
		return rv;
	}
}
