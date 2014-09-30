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
