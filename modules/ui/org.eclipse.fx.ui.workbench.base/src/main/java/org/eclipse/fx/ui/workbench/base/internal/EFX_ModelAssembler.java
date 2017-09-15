/*******************************************************************************
 * Copyright (c) 2017 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.base.internal;

import java.util.Set;
import java.util.TreeSet;

import org.eclipse.e4.ui.internal.workbench.ModelAssembler;
import org.eclipse.e4.ui.internal.workbench.ModelFragmentComparator;
import org.eclipse.e4.ui.internal.workbench.ModelFragmentWrapper;
import org.eclipse.e4.ui.model.application.MApplicationElement;
import org.eclipse.e4.ui.model.fragment.MStringModelFragment;
import org.eclipse.e4.ui.model.internal.ModelUtils;

/**
 * Extended model assembler who fixes Bug 522361
 */
@SuppressWarnings("restriction")
public class EFX_ModelAssembler extends ModelAssembler {
	
	@Override
	public void processFragments(Set<ModelFragmentWrapper> fragmentList) {
		TreeSet<ModelFragmentWrapper> c = new TreeSet<>(new EFX_ModelFragmentComparator());
		c.addAll(fragmentList);
		super.processFragments(c);
	}
	
	static class EFX_ModelFragmentComparator extends ModelFragmentComparator {
		@Override
		public int compare(ModelFragmentWrapper o1, ModelFragmentWrapper o2) {
			if (o1 == o2) {
				return 0;
			}

			if( o1.getModelFragment() instanceof MStringModelFragment && o2.getModelFragment() instanceof MStringModelFragment) {
				MStringModelFragment sm1 = (MStringModelFragment) o1.getModelFragment();
				MStringModelFragment sm2 = (MStringModelFragment) o2.getModelFragment();
				
				boolean hasElement = false;
				for (MApplicationElement element : o2.getModelFragment().getElements()) {
					hasElement |= ModelUtils.findElementById(element, sm1.getParentElementId()) != null;
					if (hasElement)
						break;
				}
				if (hasElement)
					return 1;
				hasElement = false;
				for (MApplicationElement element : o1.getModelFragment().getElements()) {
					hasElement |= ModelUtils.findElementById(element, sm2.getParentElementId()) != null;
					if (hasElement)
						break;
				}
				if (hasElement)
					return -1;
			}
			
			return super.compare(o1, o2);
		}
	}
}
