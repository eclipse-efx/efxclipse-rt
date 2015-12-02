package org.eclipse.fx.code.editor.langs.codegen.fx.python;

public class PyPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public PyPartitioner() {
		super(new PyPartitionScanner(), new String[] {
			"__python_multiline_comment","__python_singleline_comment","__python_string"
		});
	}
}
