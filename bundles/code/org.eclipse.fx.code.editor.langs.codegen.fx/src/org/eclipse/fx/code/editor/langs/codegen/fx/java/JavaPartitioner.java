package org.eclipse.fx.code.editor.langs.codegen.fx.java;

public class JavaPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public JavaPartitioner() {
		super(new JavaPartitionScanner(), new String[] {
			"__java_multi_line_api_comment","__java_single_line_comment","__java_multi_line_comment","__java_string"
		});
	}
}
