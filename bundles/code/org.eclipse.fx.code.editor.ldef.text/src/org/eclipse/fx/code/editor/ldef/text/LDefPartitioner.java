package org.eclipse.fx.code.editor.ldef.text;

import javax.inject.Inject;

import org.eclipse.fx.code.editor.ldef.lDef.LDef;
import org.eclipse.fx.code.editor.ldef.lDef.Partitioner;
import org.eclipse.fx.code.editor.ldef.lDef.Partitioner_Rule;
import org.eclipse.fx.code.editor.ldef.text.internal.LDefRuleBasedPartitionScanner;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;

public class LDefPartitioner extends FastPartitioner {

	@Inject
	public LDefPartitioner(LDef m) {
		super(getScanner(m), getParitions(m));
	}

	private static IPartitionTokenScanner getScanner(LDef m) {
		Partitioner partitioner = m.getParitioning().getPartitioner();
		IPartitionTokenScanner scanner = null;
		if( partitioner instanceof Partitioner_Rule ) {
			scanner = new LDefRuleBasedPartitionScanner((Partitioner_Rule) partitioner);
		}
		return scanner;
	}

	private static String[] getParitions(LDef m) {
		return m.getParitioning().getPartitions()
				.stream().filter( p  -> ! p.getName().equals(IDocument.DEFAULT_CONTENT_TYPE))
				.map((p) -> p.getName())
				.toArray((size) -> new String[size]);
	}
}
