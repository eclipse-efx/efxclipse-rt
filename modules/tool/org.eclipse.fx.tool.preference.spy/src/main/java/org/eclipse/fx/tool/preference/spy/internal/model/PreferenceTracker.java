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
package org.eclipse.fx.tool.preference.spy.internal.model;

import org.eclipse.fx.tool.preference.spy.internal.service.PreferenceService;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.fx.core.log.FluentLogger;
import org.eclipse.fx.core.log.LoggerCreator;
import org.osgi.service.prefs.BackingStoreException;

import javax.inject.Inject;

import static org.eclipse.fx.tool.preference.spy.internal.constants.PreferenceConstants.TRACE_PREFERENCE_CHANGES;

/**
 * Tracks the changes of IEclipsePreferences.
 * 
 * can be switched on and off by changing traceProperty()
 */
@Creatable
public class PreferenceTracker implements IPreferenceChangeListener {

	private final FluentLogger flogger = FluentLogger.of( LoggerCreator.createLogger( getClass() ) );
	
	private IEclipsePreferences bundlePreferences;
	
	private PreferenceService preferenceService;

	private final ObservableList<PreferenceChange> preferenceChanges = FXCollections.observableArrayList();

	private final BooleanProperty trace = new SimpleBooleanProperty();

	@Inject
	public PreferenceTracker(PreferenceService preferenceService, @Preference IEclipsePreferences bundlePreferences) {
		this.preferenceService = preferenceService;
		setBundlePreferences(bundlePreferences);
	}

	private void setBundlePreferences( IEclipsePreferences bundlePreferences ) {
		this.bundlePreferences = bundlePreferences;
		boolean tracePreferences = bundlePreferences.getBoolean(TRACE_PREFERENCE_CHANGES, true );
		trace.addListener( this::traceChanged );
		trace.set( tracePreferences );
	}
	
	/**
	 * preference change listener
	 */
	@Override
	public void preferenceChange( PreferenceChangeEvent event ) {
		PreferenceChange preferenceChange = new PreferenceChange( System.currentTimeMillis(), event.getNode().absolutePath(), event.getKey(), ( String ) event.getOldValue(), event.getNewValue().toString() );
		preferenceChanges.add( preferenceChange );
	}

	public BooleanProperty traceProperty() {
		return trace;
	}

	// PACKAGE VISIBLE

	ObservableList<PreferenceChange> preferenceChangesProperty() {
		return preferenceChanges;
	}

	PreferenceService getPreferenceService() {
		return preferenceService;
	}
	
    // PRIVATE METHODS **********************************************
	
 	private void traceChanged(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		
 		// register listener, so changes to trace flag are always tracked
 		preferenceService.registerListener( this );
		
		bundlePreferences.putBoolean(TRACE_PREFERENCE_CHANGES, newValue );
		try {
			bundlePreferences.flush();
		} catch (BackingStoreException e) {
			flogger.atError().withException( e ).log( "Flushing preferences NOT successful" );
		}

		if ( ! newValue ) {
			preferenceService.deregisterListener( this );
		}
	}

}
