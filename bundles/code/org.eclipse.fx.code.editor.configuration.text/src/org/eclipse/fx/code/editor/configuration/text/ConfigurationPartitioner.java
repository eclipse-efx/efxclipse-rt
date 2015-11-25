package org.eclipse.fx.code.editor.configuration.text;

import javax.inject.Inject;

import org.eclipse.fx.code.editor.configuration.LanguageDef;
import org.eclipse.fx.code.editor.configuration.text.internal.ConfigurationRuleBasedPartitionScanner;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;

@SuppressWarnings("restriction")
public class ConfigurationPartitioner extends FastPartitioner {

	@Inject
	public ConfigurationPartitioner(LanguageDef m) {
		super(getScanner(m), getParitions(m));
	}

	private static IPartitionTokenScanner getScanner(LanguageDef m) {
		return new ConfigurationRuleBasedPartitionScanner(m.getPartitionList());
	}

	private static String[] getParitions(LanguageDef m) {
		return m.getPartitionList()
				.stream().filter( p  -> ! p.getName().equals(IDocument.DEFAULT_CONTENT_TYPE))
				.map((p) -> p.getName())
				.toArray((size) -> new String[size]);
	}
}
