package org.eclipse.fx.code.editor.langs.codegen.fx.swift;

public class SwiftPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public SwiftPartitioner() {
		super(new SwiftPartitionScanner(), new String[] {
			"__swift_single_line_comment","__swift_multi_line_comment","__swift_string"
		});
	}
}
