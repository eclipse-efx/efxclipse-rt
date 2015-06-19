package org.eclipse.fx.code.editor.hsl;

import java.util.List;

import org.eclipse.fx.code.compensator.editor.Input;
import org.eclipse.fx.code.compensator.editor.services.PartitionerFactory;
import org.eclipse.fx.code.compensator.editor.services.SourceViewerConfigurationFactory;
import org.eclipse.fx.code.compensator.hsl.hSL.JavaLikeParitioner;
import org.eclipse.fx.code.compensator.hsl.hSL.Model;
import org.eclipse.fx.code.compensator.hsl.hSL.Partitioner;
import org.eclipse.fx.code.compensator.hsl.hSL.RulePartitioner;
import org.eclipse.fx.code.editor.hsl.internal.HSLRuleBasedPartitionScanner;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.source.FastJavaLikePartitionScanner;

public abstract class HSLEditorComponent implements PartitionerFactory, SourceViewerConfigurationFactory {

	protected abstract Model getModel(Input<?> input);
	
	@Override
	public final IDocumentPartitioner createPartitioner(Input<?> input) {
		Model m = getModel(input);
		if( m == null ) {
			throw new IllegalArgumentException("Unsupported input '"+input+"'");
		}

		Partitioner partitioner = m.getPartitioner();
		IPartitionTokenScanner scanner = null;
		if( partitioner instanceof RulePartitioner ) {
			scanner = new HSLRuleBasedPartitionScanner(getClass().getClassLoader(), (RulePartitioner) m.getPartitioner());
		} else if( partitioner instanceof JavaLikeParitioner ) {
			JavaLikeParitioner jp = (JavaLikeParitioner) partitioner;
			scanner = new FastJavaLikePartitionScanner(
					jp.getSingleLineDocParition().getName(),
					jp.getMultiLineDocParition().getName(),
					jp.getJavaDocParition().getName(),
					jp.getCharacterParition().getName(),
					jp.getStringParition().getName());
		}

		if( scanner != null ) {
			return new FastPartitioner(scanner, getParitions(m));
		}

		throw new IllegalStateException("Unsupported partitioner '"+partitioner+"'");
	}

	private static String[] getParitions(Model m) {
		return m.getPartitions().stream().filter((p) -> { return ! p.getName().equals(IDocument.DEFAULT_CONTENT_TYPE); })
				.map((p) -> p.getName())
				.toArray((size) -> new String[size]);
	}
	
	@Override
	public List<ConfigurationType> getConfigurationData() {
		return null;
	}

}
