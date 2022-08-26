/*******************************************************************************
 * Copyright (c) 2022 BestSolution.at and others.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v.2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *  
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *     BestSolution.at - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.testcases.e4.parts;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.model.application.ui.basic.MCompositePart;

/**
 * The {@link MCompositePartContribution} is a contribution class which is attached to the
 * {@link MCompositePart} via <code>contributionURI</code>.
 */
public class MCompositePartContribution {

	@PostConstruct
	public void init(final MCompositePart part) {
		System.err.println("Created MCompositePartContribution for: " + part.getElementId());
	}
}
