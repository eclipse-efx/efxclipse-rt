package org.eclipse.fx.code.editor.langs.codegen.fx.php;

public class PhpPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public PhpPartitioner() {
		super(new PhpPartitionScanner(), new String[] {
			"__php_multiline_comment","__php_string"
		});
	}
}
