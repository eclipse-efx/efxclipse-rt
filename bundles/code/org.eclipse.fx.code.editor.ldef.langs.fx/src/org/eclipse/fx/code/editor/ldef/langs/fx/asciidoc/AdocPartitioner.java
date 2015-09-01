package org.eclipse.fx.code.editor.ldef.langs.fx.asciidoc;

public class AdocPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public AdocPartitioner() {
		super(new AdocPartitionScanner(), new String[] {
			"__adoc_multiline_code","__adoc_multiline_comment","__adoc_singleline_comment"
		});
	}
}
