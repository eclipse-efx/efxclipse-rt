package org.eclipse.fx.code.editor.ldef.langs.fx.go;

public class GoPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public GoPartitioner() {
		super(new GoPartitionScanner(), new String[] {
			"__go_single_line_comment","__go_multi_line_comment","__go_string"
		});
	}
}
