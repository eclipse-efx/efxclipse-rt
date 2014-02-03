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

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.fx.ui.modelviewer.ElementDelegateProvider;

public class DefaultElementDelegateProvider implements ElementDelegateProvider {
	
	@Override
	public Collection<DelegateEntry> getDelegates() {
		return Arrays.<DelegateEntry>asList(
				new DelegateEntry(0, MApplicationDelegate.ECLASS, MApplicationDelegate.class),
				new DelegateEntry(0, MWindowDelegate.ECLASS, MWindowDelegate.class)
		);
	}

}
