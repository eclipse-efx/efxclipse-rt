package org.eclipse.fx.code.editor.langs.codegen.fx.kotlin;

public class KotlinPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public KotlinPartitioner() {
		super(new KotlinPartitionScanner(), new String[] {
			"__kotlin_multi_line_api_comment","__kotlin_single_line_comment","__kotlin_multi_line_comment","__kotlin_string"
		});
	}
}
