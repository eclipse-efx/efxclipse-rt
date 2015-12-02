package org.eclipse.fx.code.editor.langs.codegen.fx.js;

public class JsPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public JsPartitioner() {
		super(new JsPartitionScanner(), new String[] {
			"__js_single_line_comment","__js_multi_line_comment","__js_string"
		});
	}
}
