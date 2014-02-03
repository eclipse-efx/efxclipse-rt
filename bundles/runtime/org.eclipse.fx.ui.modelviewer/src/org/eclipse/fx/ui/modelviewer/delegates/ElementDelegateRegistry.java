/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.modelviewer.delegates;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.fx.ui.modelviewer.ElementDelegate;
import org.eclipse.fx.ui.modelviewer.ElementDelegateProvider;
import org.eclipse.fx.ui.modelviewer.ElementDelegateProvider.DelegateEntry;

public class ElementDelegateRegistry {

	private Map<EClass, DelegateEntry> delegates = new HashMap<>(); 
	
	public void registerDelegateProvider(ElementDelegateProvider delegateProvider) {
		synchronized (delegates) {
			for( DelegateEntry e : delegateProvider.getDelegates() ) {
				DelegateEntry ce = delegates.get(e.eClass);
				if( ce != null ) {
					if( ce.ranking < e.ranking ) {
						delegates.put(e.eClass, e);
					}
				} else {
					delegates.put(e.eClass, e);
				}
			}
		}
	}
	
	public Class<? extends ElementDelegate> getDelegate(EClass eClass) {
		DelegateEntry d = delegates.get(eClass);
		if( d == null ) {
			for( EClass e : eClass.getEAllSuperTypes() ) {
				d = delegates.get(e);
				if( d != null ) {
					return d.clazz;
				}
			}
		}
		if( d == null ) {
			return null;
		}
		return d.clazz;
	}
}
