/*******************************************************************************
 * Copyright (c) Carl Zeiss Meditec AG
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Thomas Fahrmeyer (lauritziu_ii@yahoo.de) - initial API and implementation
*/
package org.eclipse.fx.tool.preference.spy.internal.model;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.fx.core.log.FluentLogger;
import org.eclipse.fx.core.log.LoggerCreator;
import org.osgi.service.prefs.BackingStoreException;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Model for the preference spy view
 */
@Creatable
public class PreferenceSpyViewModel  {

	private final FluentLogger flogger = FluentLogger.of( LoggerCreator.createLogger( getClass() ) );
	
	private PreferenceTracker preferenceTracker;

	private final StringProperty filter = new SimpleStringProperty();
	
	private final ObjectProperty<List<PreferenceEntry>> preferenceEntries = new SimpleObjectProperty<>();
	private final ObjectBinding<List<PreferenceEntry>> preferenceEntriesFiltered = Bindings.createObjectBinding(this::doFilterPreferenceEntries, preferenceEntries, filter);
	private final ObjectBinding<TreeItem<PreferenceEntry>> treeRoot = Bindings.createObjectBinding(this::map, preferenceEntriesFiltered);
	private ObjectBinding<ObservableList<PreferenceChange>> preferenceChangesFiltered;

	@Inject
	public PreferenceSpyViewModel(PreferenceTracker preferenceTracker ) {
		this.preferenceTracker = preferenceTracker;
		preferenceChangesFiltered = Bindings.createObjectBinding(this::doFilterChanges, preferenceTracker.preferenceChangesProperty(), filter);
	}

	@PreDestroy
	public void destroy() {
		// This binding needs to be disposed because there is a connection to the preferenceTracker which is
		// application scoped long living object
		preferenceChangesFiltered.dispose();
	}

	/**
	 * returns the trace property
	 * @return
	 */
	public BooleanProperty traceProperty() {
		return preferenceTracker.traceProperty();
	}
    
	/**
	 * return the filter property
	 * @return
	 */
	public StringProperty filterProperty() {
		return filter;
	}

	public ObjectBinding<TreeItem<PreferenceEntry>> getTreeRoot() {
		return treeRoot;
	}
	
	public ObjectBinding<ObservableList<PreferenceChange>> getPreferenceChanges() {
		return preferenceChangesFiltered;
	}

	/**
	 * loads the preferences and sorts them
	 */
    public void loadPreferences() {
    	List<PreferenceEntry> values = preferenceTracker.getPreferenceService().loadPreferenceEntries();
    	sort( values );
    	preferenceEntries.set(values);
	}

    /**
     * expands all tree nodes
     */
	public void expandAll() {
		expand( treeRoot.get() );
	}
	
	/**
	 * collapses all tree nodes
	 */
	public void collapseAll() {
		treeRoot.get().getChildren().forEach( ( treeItem ) -> { treeItem.setExpanded( false ); } );
	}
	
	/**
	 * sets the new value of preference entry in IEclipsePreferences and flushes it.
	 * @param preferenceEntry
	 * @param newValue
	 * @return true if successful
	 */
	public boolean setPreferenceEntry( PreferenceEntry preferenceEntry, String newValue ) {
		IEclipsePreferences parentPreferences = preferenceEntry.getParentPreferences();
		parentPreferences.put( preferenceEntry.getKey(), newValue );

		try {
			parentPreferences.flush();
			preferenceEntry.setNewValue( newValue );
		} catch (BackingStoreException e) {
			flogger.atError().withException( e ).log( "Flushing preferences NOT successful" );
			return false;
		}

		return true;
	}
	
    // PRIVATE METHODS **********************************************
    
	private void expand( TreeItem<PreferenceEntry> treeItem ) {
		treeItem.setExpanded( true );
		treeItem.getChildren().forEach( this::expand );
	}
	
	private List<PreferenceEntry> doFilterPreferenceEntries() {
		if( filter.get() == null || preferenceEntries.get() == null ) {
			return preferenceEntries.get();
		}
		return doFilterPreferenceEntries(filter.get().toLowerCase(), preferenceEntries.get());
	}
	
	private List<PreferenceEntry> doFilterPreferenceEntries( String filterValue, List<PreferenceEntry> preferences ) {
    	
    	List<PreferenceNodeEntry> preferenceNodeEntries = preferences.stream()
    			.filter( PreferenceNodeEntry.class::isInstance )
    			.map( PreferenceNodeEntry.class::cast )
    			.map( s -> mapToFiltered( filterValue, s ) )
    			.filter( s -> ! s.getPreferenceEntries().isEmpty() )
    			.collect( Collectors.toList() );

    	List<PreferenceEntry> result = FXCollections.observableArrayList( preferenceNodeEntries );

    	return result;
    }

   	private PreferenceNodeEntry mapToFiltered( String filterValue, PreferenceNodeEntry preferenceNodeEntry ) {
   		
   		PreferenceNodeEntry newPreferenceNodeEntry = new PreferenceNodeEntry( preferenceNodeEntry.getNodePath() );
		
   		List<PreferenceEntry> filteredChildren = preferenceNodeEntry.getPreferenceEntries().stream()
   		      .filter( s -> filterPreferenceEntry( filterValue, s ) )
   		      .collect( Collectors.toList() );
		
   		newPreferenceNodeEntry.getPreferenceEntries().addAll( filteredChildren );
   		
   		return newPreferenceNodeEntry;
   	}
   
   	private boolean filterPreferenceEntry( String filterValue, PreferenceEntry preferenceEntry ) {
   		return ( preferenceEntry.getNodePath().toLowerCase().contains( filterValue ) ||
   				preferenceEntry.getKey().toLowerCase().contains( filterValue ) ||
   				preferenceEntry.getOldValue().toLowerCase().contains( filterValue ) ||
   				preferenceEntry.getNewValue().toLowerCase().contains( filterValue ) );
   	}
   	
	private ObservableList<PreferenceChange> doFilterChanges() {
    	
		ObservableList<PreferenceChange> result = FXCollections.observableArrayList();
		
    	if( filter.get() == null || preferenceTracker.preferenceChangesProperty().isEmpty() ) {
			return result;
		}
    	 
    	String filterValue = filter.get().toLowerCase();
    	
    	List<PreferenceChange> filteredChanges = preferenceTracker.preferenceChangesProperty().stream()
    		.filter( change -> filterPreferenceChange( filterValue, change ) )
    		.collect( Collectors.toList() );

    	result.addAll( filteredChanges );

    	return result;
	}
	
	private boolean filterPreferenceChange( String filterValue, PreferenceChange preferenceChange ) {
		return ( preferenceChange.getNodePath().toLowerCase().contains( filterValue ) ||
				preferenceChange.getKey().toLowerCase().contains( filterValue ) ||
	        	( preferenceChange.getOldValue() != null && preferenceChange.getOldValue().toLowerCase().contains( filterValue ) ) ||
	        	preferenceChange.getNewValue().toLowerCase().contains( filterValue ) );
	}
	
	private TreeItem<PreferenceEntry> map() {
		TreeItem<PreferenceEntry> root = new TreeItem<>();
		root.setExpanded(true);
		root.getChildren().clear();
		if ( preferenceEntriesFiltered.get() != null ) {
			root.getChildren().addAll( preferenceEntriesFiltered.get().stream().map(this::createTreeItem).collect( Collectors.toList() ) );
		}

		return root;
	}
	
	private TreeItem<PreferenceEntry> createTreeItem(PreferenceEntry element) {
		TreeItem<PreferenceEntry> treeItem = new TreeItem<PreferenceEntry>(element, null );

		treeItem.setExpanded(true);
		
		if ( element instanceof PreferenceNodeEntry ) {
			
			ObservableList<PreferenceEntry> preferenceEntries = ( ( PreferenceNodeEntry ) element ).getPreferenceEntries();
			Stream<PreferenceEntry> stream = preferenceEntries.stream();
			List<TreeItem<PreferenceEntry>> childrenList = stream.map( this::createTreeItem ).collect( Collectors.toList() );
			treeItem.getChildren().addAll(childrenList);
		}
		
		return treeItem;
	}
	
	private void sort( List<PreferenceEntry> preferences ) {
		preferences.sort( new Comparator<PreferenceEntry>() {
			@Override
			public int compare(PreferenceEntry o1, PreferenceEntry o2) {
				return o1.getNodePath().compareTo( o2.getNodePath());
			}
		});
		
		preferences.forEach( this::sortChildren );
	}

	private void sortChildren( PreferenceEntry preferenceEntry ) {
		if ( preferenceEntry instanceof PreferenceNodeEntry ) {
			PreferenceNodeEntry node = ( PreferenceNodeEntry ) preferenceEntry;
			node.getPreferenceEntries().sort( new Comparator<PreferenceEntry>() {
				@Override
				public int compare(PreferenceEntry o1, PreferenceEntry o2) {
					return o1.getKey().compareTo( o2.getKey());
				}
			});
		}
	}
	
}
