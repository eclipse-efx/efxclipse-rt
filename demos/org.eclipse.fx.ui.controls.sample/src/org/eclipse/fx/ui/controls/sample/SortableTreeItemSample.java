package org.eclipse.fx.ui.controls.sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.eclipse.fx.ui.controls.tree.SortableTreeItem;
import org.eclipse.fx.ui.controls.tree.TreeItemComparator;

public class SortableTreeItemSample extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	private ToggleGroup sortGroup;
	private CheckBox cbReverse;
	private SortableTreeItem<Actor> folder1;

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = createContents();
			Scene scene = new Scene(root, 800, 600);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Parent createContents() {
		VBox vbox = new VBox(6);
		vbox.getChildren().add(createInputPane());
		vbox.getChildren().add(createAddItemPane());
		Node demoPane = createDemoPane();
		VBox.setVgrow(demoPane, Priority.ALWAYS);
		vbox.getChildren().add(demoPane);
		return new BorderPane(vbox);
	}

	private Node createInputPane() {
    	sortGroup = new ToggleGroup();
    	
        ToggleButton noSort = new ToggleButton("not sorting");
        noSort.setUserData("noSort");
        noSort.setToggleGroup(sortGroup);
        noSort.setSelected(true);
        ToggleButton byLastName = new ToggleButton("sort by last name");
        byLastName.setUserData("byLastName");
        byLastName.setToggleGroup(sortGroup);
        ToggleButton byFirstName = new ToggleButton("sort by first name");
        byFirstName.setUserData("byFirstName");
        byFirstName.setToggleGroup(sortGroup);
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(noSort, byLastName, byFirstName);
        
        cbReverse = new CheckBox("reverse");
        cbReverse.setMaxHeight(Double.MAX_VALUE);
        cbReverse.disableProperty().bind(Bindings.createBooleanBinding(() -> {
        	return sortGroup.getSelectedToggle() == null || sortGroup.getSelectedToggle().getUserData().equals("noSort");
        }, sortGroup.selectedToggleProperty()));
        
        HBox pane = new HBox(6);
        pane.getChildren().addAll(hbox, cbReverse);
        
        TitledPane result = new TitledPane("Sort Options", pane);
        result.setCollapsible(false);
        return result;
    }
	
	private Node createAddItemPane() {
		HBox box = new HBox(6);
		TextField firstname = new TextField();
		firstname.setPromptText("Enter first name ...");
		TextField lastname = new TextField();
		lastname.setPromptText("Enter last name ...");
		
		Button addBtn = new Button("Add new actor to \"Folder 1\"");
		addBtn.setOnAction(event -> {
			SortableTreeItem<Actor> treeItem = new SortableTreeItem<>(new Actor(firstname.getText(), lastname.getText()));
			folder1.getInternalChildren().add(treeItem);
		});
		addBtn.disableProperty().bind(Bindings.isEmpty(lastname.textProperty()));
		
		box.getChildren().addAll(firstname, lastname, addBtn);
		TitledPane pane = new TitledPane("Add new element", box);
		pane.setCollapsible(false);
		return pane;
	}

	private Node createDemoPane() {
		HBox hbox = new HBox(6);
		Node sortedTree = createSortedTree();
		HBox.setHgrow(sortedTree, Priority.ALWAYS);
		hbox.getChildren().add(sortedTree);
		return hbox;
	}

	private Node createSortedTree() {
		SortableTreeItem<Actor> root = getTreeModel();
		root.comparatorProperty().bind(Bindings.createObjectBinding(() -> {
			switch ((String)sortGroup.getSelectedToggle().getUserData()) {
			case "noSort":
				return null;
			case "byLastName":
				return TreeItemComparator.create((actor1, actor2) -> {
					int result = actor1.lastname.compareToIgnoreCase(actor2.lastname);
					return cbReverse.isSelected() ? result * -1 : result;
				});
			case "byFirstName":
				return TreeItemComparator.create((actor1, actor2) -> {
					int result = 0;
					if (actor1.firstname == null)
						result = -1;
					else if (actor2.firstname == null)
						result = 1;
					else
						result = actor1.firstname.compareToIgnoreCase(actor2.firstname);
					return cbReverse.isSelected() ? result * -1 : result;
				});
			}
			return null;
		}, sortGroup.selectedToggleProperty(), cbReverse.selectedProperty()));

		TreeView<Actor> treeView = new TreeView<>(root);
		treeView.setShowRoot(false);

		TitledPane pane = new TitledPane("Filtered TreeView", treeView);
		pane.setCollapsible(false);
		pane.setMaxHeight(Double.MAX_VALUE);
		return pane;
	}

	private SortableTreeItem<Actor> getTreeModel() {
		SortableTreeItem<Actor> root = new SortableTreeItem<>(new Actor("Root"));
		folder1 = createFolder("Folder 1");
		folder1.setExpanded(true);
		root.getInternalChildren().add(folder1);
		root.getInternalChildren().add(createFolder("Folder 2"));
		root.getInternalChildren().add(createFolder("Folder 3"));
		return root;
	}

	private SortableTreeItem<Actor> createFolder(String name) {
		SortableTreeItem<Actor> folder = new SortableTreeItem<>(new Actor(name));
		getActorList().forEach(actor -> folder.getInternalChildren().add(new SortableTreeItem<>(actor)));
		return folder;
	}

	private Iterable<Actor> getActorList() {
		ObservableList<Actor> actorList = FXCollections.observableArrayList(
				new Actor("Jack", "Nicholson"), 
				new Actor("Marlon", "Brando"), 
				new Actor("Robert", "De Niro"), 
				new Actor("Al", "Pacino"), 
				new Actor("Daniel","Day-Lewis"), 
				new Actor("Dustin", "Hoffman"), 
				new Actor("Tom", "Hanks"),
				new Actor("Anthony", "Hopkins"), 
				new Actor("Paul", "Newman"), 
				new Actor("Denzel", "Washington"),
				new Actor("Spencer", "Tracy"), 
				new Actor("Laurence", "Olivier"), 
				new Actor("Jack", "Lemmon"));
		return actorList;
	}

	private static class Actor {
		public String firstname;
		public String lastname;

		public Actor(String string) {
			this.lastname = string;
		}

		public Actor(String firstname, String lastname) {
			this.firstname = firstname;
			this.lastname = lastname;
		}

		@Override
		public String toString() {
			return firstname == null ? lastname : firstname + " " + lastname;
		}
	}

}
