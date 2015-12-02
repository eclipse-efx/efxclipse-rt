package org.eclipse.fx.code.editor.langs.codegen.fx.rust;

public class RustPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public RustPartitioner() {
		super(new RustPartitionScanner(), new String[] {
			"__rust_single_line_comment","__rust_multi_line_comment","__rust_string"
		});
	}
}
