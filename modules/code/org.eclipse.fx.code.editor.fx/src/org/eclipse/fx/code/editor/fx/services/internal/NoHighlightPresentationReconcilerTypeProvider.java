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
package org.eclipse.fx.code.editor.fx.services.internal;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.fx.services.PresentationReconcilerTypeProvider;
import org.eclipse.fx.text.ui.presentation.PresentationReconciler;
import org.eclipse.fx.text.ui.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("restriction")
@Component(property="service.ranking:Integer=-1")
public class NoHighlightPresentationReconcilerTypeProvider implements PresentationReconcilerTypeProvider {

	@Override
	public Class<? extends PresentationReconciler> getType(Input<?> s) {
		return NoHighlightPresentationReconciler.class;
	}

	@Override
	public boolean test(Input<?> t) {
		return true;
	}

	static class NoHighlightPresentationReconciler extends PresentationReconciler {
		public NoHighlightPresentationReconciler() {
			DefaultDamagerRepairer r = new DefaultDamagerRepairer(new NoHighlightScanner());
			setDamager(r, "__dftl_partition_content_type");
			setRepairer(r, "__dftl_partition_content_type");
		}
	}

	static class NoHighlightScanner extends RuleBasedScanner {
		public NoHighlightScanner() {
			setDefaultReturnToken(new Token("sourcetext"));
		}
	}
}
