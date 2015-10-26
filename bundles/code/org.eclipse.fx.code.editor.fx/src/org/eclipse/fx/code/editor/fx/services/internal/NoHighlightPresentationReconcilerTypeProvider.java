package org.eclipse.fx.code.editor.fx.services.internal;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.fx.services.PresentationReconcilerTypeProvider;
import org.eclipse.jface.text.presentation.PresentationReconciler;
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
			org.eclipse.jface.text.rules.DefaultDamagerRepairer r = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new NoHighlightScanner());
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
