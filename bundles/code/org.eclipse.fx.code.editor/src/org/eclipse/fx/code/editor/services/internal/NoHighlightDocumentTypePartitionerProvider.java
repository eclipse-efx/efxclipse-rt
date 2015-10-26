package org.eclipse.fx.code.editor.services.internal;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.services.DocumentPartitionerTypeProvider;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.osgi.service.component.annotations.Component;

@SuppressWarnings("restriction")
@Component(property="service.ranking:Integer=-1")
public class NoHighlightDocumentTypePartitionerProvider implements DocumentPartitionerTypeProvider {

	@Override
	public Class<? extends IDocumentPartitioner> getType(Input<?> s) {
		return NoHighlightPartitioner.class;
	}

	@Override
	public boolean test(Input<?> t) {
		return true;
	}

	static class NoHighlightPartitioner extends FastPartitioner {

		public NoHighlightPartitioner() {
			super(new RuleBasedPartitionScanner(), new String[0]);
		}
	}
}
