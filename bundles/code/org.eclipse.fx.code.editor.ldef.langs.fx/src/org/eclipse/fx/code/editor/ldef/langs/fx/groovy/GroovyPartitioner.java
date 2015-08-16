package org.eclipse.fx.code.editor.ldef.langs.fx.groovy;

public class GroovyPartitioner extends org.eclipse.jface.text.rules.FastPartitioner {
	public GroovyPartitioner() {
		super(new GroovyPartitionScanner(), new String[] {
			"__groovy_apidoc","__groovy_multiline_comment","__groovy_singleline_comment","__groovy_string","__groovy_character"
		});
	}
}
