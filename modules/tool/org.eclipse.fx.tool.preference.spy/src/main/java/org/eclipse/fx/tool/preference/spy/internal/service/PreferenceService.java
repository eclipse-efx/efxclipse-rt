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
package org.eclipse.fx.tool.preference.spy.internal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.preferences.BundleDefaultsScope;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IPreferenceNodeVisitor;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.fx.core.log.FluentLogger;
import org.eclipse.fx.core.log.LoggerCreator;
import org.eclipse.fx.tool.preference.spy.internal.model.PreferenceEntry;
import org.eclipse.fx.tool.preference.spy.internal.model.PreferenceNodeEntry;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Service that loads the preference data and puts them to PreferenceNodeEntry and PreferenceEntry objects. 
 * Service can be injected  
 */
@Creatable
public class PreferenceService {

	private final FluentLogger flogger = FluentLogger.of( LoggerCreator.createLogger( getClass() ) );
	
	private IEclipsePreferences bundleDefaultsScopePreferences;
	private IEclipsePreferences configurationScopePreferences;
	private IEclipsePreferences defaultScopePreferences;
	private IEclipsePreferences instanceScopePreferences;
	
	public PreferenceService() {
		loadPreferenceNodes();
	}
	
	/**
	 * loads the eclipse preferences of the different scopes (BundeDefaultScope, ConfigurationScope, DefaultScope and InstanceScope) 
	 * 
	 * @return list of preference entry objects
	 */
	public List<PreferenceEntry> loadPreferenceEntries() {
		Map<String, PreferenceNodeEntry> preferenceEntries = new HashMap<String, PreferenceNodeEntry>();
		loadPreferenceNodes();
		
		try {
			bundleDefaultsScopePreferences.accept(new PreferenceGatherer(preferenceEntries));
			configurationScopePreferences.accept(new PreferenceGatherer(preferenceEntries));
			defaultScopePreferences.accept(new PreferenceGatherer(preferenceEntries));
			instanceScopePreferences.accept(new PreferenceGatherer(preferenceEntries));
		} catch (BackingStoreException e) {
			flogger.atError().withException( e ).log( "Reading preferences NOT successful" );
		}

		return new ArrayList<>( preferenceEntries.values() );
	}

	private void loadPreferenceNodes() {
		bundleDefaultsScopePreferences = BundleDefaultsScope.INSTANCE.getNode("");
		configurationScopePreferences = ConfigurationScope.INSTANCE.getNode("");
		defaultScopePreferences = DefaultScope.INSTANCE.getNode("");
		instanceScopePreferences = InstanceScope.INSTANCE.getNode("");
	}

	public void registerListener( IPreferenceChangeListener preferenceChangeListener ) {
		addPreferenceListener(bundleDefaultsScopePreferences, preferenceChangeListener );
		addPreferenceListener(configurationScopePreferences, preferenceChangeListener );
		addPreferenceListener(defaultScopePreferences, preferenceChangeListener );
		addPreferenceListener(instanceScopePreferences, preferenceChangeListener );
	}

	public void deregisterListener( IPreferenceChangeListener preferenceChangeListener ) {
		removePreferenceListener(bundleDefaultsScopePreferences, preferenceChangeListener );
		removePreferenceListener(configurationScopePreferences, preferenceChangeListener );
		removePreferenceListener(defaultScopePreferences, preferenceChangeListener );
		removePreferenceListener(instanceScopePreferences, preferenceChangeListener );
	}
	
	// * PRIVATE METHODS *********************************************************************************************
	
	
	
	private void addPreferenceListener(IEclipsePreferences rootPreference, IPreferenceChangeListener preferenceChangeListener) {
		try {
			rootPreference.accept(new IPreferenceNodeVisitor() {
				@Override
				public boolean visit(IEclipsePreferences node) throws BackingStoreException {
					node.addPreferenceChangeListener(preferenceChangeListener);
					return true;
				}
			});
		} catch (BackingStoreException e) {
			flogger.atError().withException( e ).log( "Adding preference listener NOT successful" );
		}
	}

	private void removePreferenceListener(IEclipsePreferences rootPreference, IPreferenceChangeListener preferenceChangeListener ) {
		try {
			rootPreference.accept(new IPreferenceNodeVisitor() {
				@Override
				public boolean visit(IEclipsePreferences node) throws BackingStoreException {
					node.removePreferenceChangeListener(preferenceChangeListener);
					return true;
				}
			});
		} catch (BackingStoreException e) {
			flogger.atError().withException( e ).log( "Removing preference listener NOT successful" );
		}
	}


}
