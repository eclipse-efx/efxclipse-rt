package org.eclipse.fx.code.editor.ldef.langs.fx.python;

public class PyPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public PyPartitioner() {
		super(new PyPartitionScanner(), new String[] {
			"__python_multiline_comment","__python_singleline_comment","__python_string"
		});
	}
}
