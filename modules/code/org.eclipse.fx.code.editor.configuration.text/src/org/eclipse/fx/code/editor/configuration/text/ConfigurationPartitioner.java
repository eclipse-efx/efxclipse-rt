package org.eclipse.fx.code.editor.configuration.text;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.fx.code.editor.Input;
import org.eclipse.fx.code.editor.InputContext;
import org.eclipse.fx.code.editor.configuration.LanguageDef;
import org.eclipse.fx.code.editor.configuration.text.internal.ConfigurationRuleBasedPartitionScanner;
import org.eclipse.fx.core.NamedValue;
import org.eclipse.fx.core.di.Service;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;

@SuppressWarnings("restriction")
public class ConfigurationPartitioner extends FastPartitioner {

	@Inject
	public ConfigurationPartitioner(LanguageDef m, InputContext context, Input<?> input, @Service List<ConfigurationConditionDataProvider> providers ) {
		super(getScanner(m, Util.createNamedValueList(context,input, providers)), getParitions(m));
	}

	private static IPartitionTokenScanner getScanner(LanguageDef m, Map<String,NamedValue<Object>> values) {
		return new ConfigurationRuleBasedPartitionScanner(m.getPartitionList(), values);
	}

	private static String[] getParitions(LanguageDef m) {
		return m.getPartitionList()
				.stream().filter( p  -> ! p.getName().equals(IDocument.DEFAULT_CONTENT_TYPE))
				.map((p) -> p.getName())
				.toArray((size) -> new String[size]);
	}
}
