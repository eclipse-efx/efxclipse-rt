package org.eclipse.fx.code.editor.langs.codegen.fx.ts;

public class TsPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public TsPartitioner() {
		super(new TsPartitionScanner(), new String[] {
			"__ts_single_line_comment","__ts_multi_line_comment","__ts_string"
		});
	}
}
