/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.preference.spy.internal.view;

import org.eclipse.fx.tool.preference.spy.internal.model.PreferenceChange;
import org.eclipse.fx.tool.preference.spy.internal.model.PreferenceEntry;
import org.eclipse.fx.tool.preference.spy.internal.model.PreferenceEntry.Fields;
import org.eclipse.fx.tool.preference.spy.internal.model.PreferenceNodeEntry;
import org.eclipse.fx.tool.preference.spy.internal.model.PreferenceSpyViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.eclipse.e4.core.di.annotations.Creatable;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Main view for preference spy
 */
@Creatable
public class PreferenceSpyView {

	private static final String CSS_PREFERENCE_SPY_CSS = "/css/preference-spy.css";
	
	private static final String FILTER_TEXT_FIELD_PROMPT_TEXT = "type filter text";

	private static final String TRACE_LABEL = "Trace preference changes"; 
	
	private static final String COLUMN_LABEL_NODEPATH = "Nodepath";
	private static final String COLUMN_LABEL_KEY = "Key";
	private static final String COLUMN_LABEL_VALUE = "Value";
	private static final String COLUMN_LABEL_OLDVALUE = "Old value";
	private static final String COLUMN_LABEL_NEWVALUE = "New value";
	private static final String COLUMN_LABEL_TIME = "Time";
	
	private static final String CONTEXT_MENU_LABEL_EDIT = "Edit";
	private static final String CONTEXT_MENU_LABEL_FILTER_NODEPATH = "Filter for nodepath";
	
	private BorderPane borderPane;

	private TextField filterField; 
	
	private TreeTableView<PreferenceEntry> treeTableView;
	
	private TableView<PreferenceChange> tableViewChanges;
	
	private PreferenceSpyViewModel model;

	@Inject
	public PreferenceSpyView(PreferenceSpyViewModel model ) {
		this.model = model;
	}

	public PreferenceSpyViewModel getModel() {
		return model;
	}

	/**
	 * Returns the gui element.
	 * 
	 * @return
	 */
	public Parent getGui() {
		if (borderPane == null) {
			createGui();
		}
		return borderPane;
	}

	// PRIVATE METHODS *********************************************************************************
	
	private void createGui() {
		borderPane = new BorderPane();
		applyCss();

		VBox topPanel = createTopPanel();
		borderPane.setTop( topPanel );
		
		treeTableView = createTreeTableView();
		
		tableViewChanges = createChangeTableView();
		
		SplitPane splitPane = new SplitPane( treeTableView, tableViewChanges );
		splitPane.setOrientation(Orientation.VERTICAL);
		splitPane.setDividerPositions(0.66d);
		borderPane.setCenter(splitPane);		
	}

	private void applyCss() {
		borderPane.getStylesheets().add(this.getClass().getResource(CSS_PREFERENCE_SPY_CSS).toExternalForm());
	}

	private VBox createTopPanel() {
		VBox topPanel = new VBox(10.0);
		topPanel.setPadding(new Insets(10));

		CheckBox traceCb = new CheckBox( TRACE_LABEL );
		traceCb.selectedProperty().bindBidirectional( model.traceProperty() );
		topPanel.getChildren().add( traceCb );
	
		filterField = new TextField();
		filterField.setMinWidth( 400 );
		filterField.setPromptText(FILTER_TEXT_FIELD_PROMPT_TEXT);
		model.filterProperty().bind( filterField.textProperty() );
		topPanel.getChildren().add(filterField);

		return topPanel;
	}
	
	private TreeTableView<PreferenceEntry> createTreeTableView() {
		TreeTableView<PreferenceEntry> treeTableView = new TreeTableView<>();
		treeTableView.getColumns().add( createPreferenceTreeTableColumn(COLUMN_LABEL_NODEPATH , Fields.nodePath.toString(), 300 ) );
		treeTableView.getColumns().add( createPreferenceTreeTableColumn(COLUMN_LABEL_KEY, Fields.key.toString(), 300 ) );
		treeTableView.getColumns().add( createPreferenceTreeTableColumn(COLUMN_LABEL_VALUE, Fields.newValue.toString(), 300 ) );
		
		treeTableView.setShowRoot( false );
		treeTableView.setColumnResizePolicy( TreeTableView.CONSTRAINED_RESIZE_POLICY );
		treeTableView.rootProperty().bind( model.getTreeRoot() );
		
		treeTableView.setContextMenu( new Menu() );
		
		return treeTableView;
	}
	
	private TreeTableColumn<PreferenceEntry, PreferenceEntry> createPreferenceTreeTableColumn( String label, String propertyValueName, int width ) {
		TreeTableColumn<PreferenceEntry, PreferenceEntry> treeTableColumn = new TreeTableColumn<>( label );
		treeTableColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>( propertyValueName ) );
		treeTableColumn.setMinWidth( width );
		return treeTableColumn;
	}
	
	private TableView<PreferenceChange> createChangeTableView() {
		TableView<PreferenceChange> tableView = new TableView<>();
		
		tableView.getColumns().add( createPreferenceChangeTableColumn( COLUMN_LABEL_TIME, "timeString", 160 ) );
		tableView.getColumns().add( createPreferenceChangeTableColumn(COLUMN_LABEL_NODEPATH, Fields.nodePath.toString(), 280 ) );
		tableView.getColumns().add( createPreferenceChangeTableColumn(COLUMN_LABEL_KEY, Fields.key.toString(), 200 ) );
		tableView.getColumns().add( createPreferenceChangeTableColumn(COLUMN_LABEL_OLDVALUE, Fields.oldValue.toString(), 130 ) );
		tableView.getColumns().add( createPreferenceChangeTableColumn(COLUMN_LABEL_NEWVALUE, Fields.newValue.toString(), 130 ) );
		
		tableView.itemsProperty().bind( model.getPreferenceChanges() );
		
		return tableView;
	}

	private TableColumn<PreferenceChange, PreferenceChange> createPreferenceChangeTableColumn( String label, String propertyValueName, int width ) {
		TableColumn<PreferenceChange, PreferenceChange> tableColumn = new TableColumn<>( label );
		tableColumn.setCellValueFactory( new PropertyValueFactory<>( propertyValueName ) );
		tableColumn.setMinWidth( width );
		return tableColumn;
	}
	
	private class Menu extends ContextMenu {
		
        Menu() {
    		MenuItem editMenuItem = new MenuItem(CONTEXT_MENU_LABEL_EDIT);
    		editMenuItem.setOnAction( new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					TreeItem<PreferenceEntry> selectedItem = treeTableView.getSelectionModel().getSelectedItem();
					if ( selectedItem != null ) {
						PreferenceEntry selectedPreferenceEntry = selectedItem.getValue();
						if ( ! ( selectedPreferenceEntry instanceof PreferenceNodeEntry) ) {
							editPreferenceEntry( selectedPreferenceEntry );
							selectedItem.setValue( selectedPreferenceEntry );
						}
					}
				}
    		} );
            getItems().add( editMenuItem );

            MenuItem filterNodePathMenuItem = new MenuItem(CONTEXT_MENU_LABEL_FILTER_NODEPATH);
            filterNodePathMenuItem.setOnAction( new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					TreeItem<PreferenceEntry> selectedItem = treeTableView.getSelectionModel().getSelectedItem();
					if ( selectedItem != null ) {
						PreferenceEntry selectedPreferenceEntry = selectedItem.getValue();
						String nodePath = selectedPreferenceEntry.getNodePath();
						filterField.setText( nodePath );
					}
				}
    		} );
    		
            getItems().add( filterNodePathMenuItem );
        }
        
    }

	private void editPreferenceEntry( PreferenceEntry preferenceEntry ) {
		
		String newValue = editValue( "Enter new value",
				"NodePath : " + preferenceEntry.getNodePath() + "\nKey : " + preferenceEntry.getKey(),
				preferenceEntry.getNewValue() );
		
		if ( newValue == null ) {
			return;
		}
		
		model.setPreferenceEntry(preferenceEntry, newValue);
		
	}

	private String editValue( String titleText, String headerText, String oldValue) {
	    TextInputDialog dialog = new TextInputDialog( oldValue );
	    dialog.setTitle(titleText);
	    dialog.setHeaderText( headerText );
	    dialog.setResizable( true );
	    Optional<String> result = dialog.showAndWait();
	    if ( result.isPresent() ) {
	    	return result.get();
	    } else {
	    	return null;
	    }
	}
	
}
