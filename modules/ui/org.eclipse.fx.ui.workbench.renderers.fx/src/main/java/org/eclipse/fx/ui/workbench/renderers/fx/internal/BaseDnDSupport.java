/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.workbench.renderers.fx.internal;

import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService.DnDFeedbackData;
import org.eclipse.fx.ui.workbench.renderers.base.services.DnDFeedbackService.MarkerFeedback;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Base support for DnD
 */
public class BaseDnDSupport {
	@Nullable
	private static MarkerFeedback CURRENT_FEEDBACK = null;
	@NonNull
	private final DnDFeedbackService feedbackService;

	/**
	 * Create a new base support
	 * 
	 * @param feedbackService
	 *            the feedback service
	 */
	public BaseDnDSupport(@NonNull DnDFeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	/**
	 * Update the feedback with new data
	 * 
	 * @param data
	 *            the data
	 */
	protected void updateFeedback(DnDFeedbackData data) {
		MarkerFeedback f = CURRENT_FEEDBACK;
		if (f == null || !f.data.equals(data)) {
			cleanup();
			CURRENT_FEEDBACK = this.feedbackService.showFeedback(data);
		}
	}

	/**
	 * Clean up the feedback data
	 */
	protected static void cleanup() {
		if (CURRENT_FEEDBACK != null) {
			CURRENT_FEEDBACK.hide();
			CURRENT_FEEDBACK = null;
		}
	}
}
