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
package org.eclipse.fx.ui.modelviewer;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;

public interface ElementDelegateProvider {
	public static class DelegateEntry implements Comparable<DelegateEntry> {
		public final int ranking;
		public final EClass eClass;
		public final Class<? extends ElementDelegate> clazz;
		
		public DelegateEntry(int ranking, EClass eClass, Class<? extends ElementDelegate> clazz) {
			this.ranking = ranking;
			this.eClass = eClass;
			this.clazz = clazz;
		}
		
		@Override
		public int compareTo(DelegateEntry o) {
			return Integer.compare(ranking, o.ranking);
		}
	}
	
	public Collection<DelegateEntry> getDelegates();
}
